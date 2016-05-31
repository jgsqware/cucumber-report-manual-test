package be.bnpp.fortis.cucumber;

/**
 * Created by juliengarcia on 5/31/16.
 */
public class Tag {
    public String name;
    public int line;

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", line=" + line +
                '}';
    }
}
