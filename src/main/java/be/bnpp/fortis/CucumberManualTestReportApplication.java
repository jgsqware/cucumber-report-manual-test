package be.bnpp.fortis;

import be.bnpp.fortis.cucumber.CucumberJson;
import be.bnpp.fortis.cucumber.Feature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class CucumberManualTestReportApplication implements CommandLineRunner,ExitCodeGenerator {

    private File cucumberReport;
    @Autowired
    private ApplicationContext context;
    private int exitCode = 0;

    @RequestMapping("/resource")
    public @ResponseBody Feature[] home() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Feature[] cucumberJson = mapper.readValue(cucumberReport, Feature[].class);
        return cucumberJson;
    }

    @RequestMapping(value = "/resource",method = RequestMethod.POST)
    public void storeReport(@RequestBody Feature[] features) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Files.write(cucumberReport.toPath(),mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(features));
        close(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(CucumberManualTestReportApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        if(strings.length == 0){
            System.out.println("No Report path provided");
            close(1);
        }else{
            Path p = Paths.get(strings[0]);
            if(!Files.exists(p)){
                System.out.println("Report path not found: " + strings[0]);
                close(1);
            }
            cucumberReport = p.toFile();
        }
    }

    private void close(int exitCode){
        System.out.println("Closing...");
        this.exitCode = exitCode;
        SpringApplication.exit(context, this);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
