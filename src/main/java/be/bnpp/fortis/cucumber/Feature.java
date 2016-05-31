package be.bnpp.fortis.cucumber;

import java.util.Arrays;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class Feature {
    public String uri;
    public String id;
    public String keyword;
    public String name;
    public String description;
    public int line;
    public Tag[] tags;
    public Element[] elements;

    @Override
    public String toString() {
        return "Feature{" +
                "uri='" + uri + '\'' +
                ", id='" + id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", line=" + line +
                ", tags=" + Arrays.toString(tags) +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}

