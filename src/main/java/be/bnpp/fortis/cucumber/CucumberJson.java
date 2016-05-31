package be.bnpp.fortis.cucumber;

import java.util.Arrays;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class CucumberJson {
    public Feature[] features;

    @Override
    public String toString() {
        return "CucumberJson{" +
                "features=" + Arrays.toString(features) +
                '}';
    }
}
