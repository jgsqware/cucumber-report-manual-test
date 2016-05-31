package be.bnpp.fortis.cucumber;

import java.util.Arrays;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class Step {
    public String keyword;
    public String name;
    public String line;
    public Match match;
    public Result result;
    public String[] output;

    @Override
    public String toString() {
        return "Step{" +
                "keyword='" + keyword + '\'' +
                ", name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", match=" + match +
                ", result=" + result +
                ", output=" + Arrays.toString(output) +
                '}';
    }
}
