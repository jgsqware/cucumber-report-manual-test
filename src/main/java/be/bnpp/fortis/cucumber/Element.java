package be.bnpp.fortis.cucumber;

import java.util.Arrays;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class Element {
    public String id;
    public String keyword;
    public String name;
    public String description;
    public String line;
    public String type;
    public Tag[] tags;
    public Step[] steps;

    @Override
    public String toString() {
        return "Element{" +
                "id='" + id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", line='" + line + '\'' +
                ", type='" + type + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", steps=" + Arrays.toString(steps) +
                '}';
    }
}
