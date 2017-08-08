package hashcode.rules;

public class NoEqualsAndHashcode {

    public final String code;
    public final String label;

    public NoEqualsAndHashcode(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // without equals, each instance is unique
    // equals will be similar to ==
    // no need to override hashcode, because every object is unique, and the hashcode is unique by default,
    // depending on the memory address.
}
