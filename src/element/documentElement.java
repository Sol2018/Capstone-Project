package element;

import java.util.Date;

public class documentElement extends htmlElement {
    public documentElement(String src, String description, String author, String name, String location, Date lastmodified, long size) {
        super(description, author, name, location, lastmodified, size);
    }
}
