package hashcode;

import java.util.Objects;

// WARNING : hashcode is forgotten on purpose for this abstract class.
// We let the child class the choice of hashcode implementation
public abstract class EqualsObject {

    public final String code;
    public final String label;

    public EqualsObject(String code, String label) {
        this.code = code;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EqualsObject that = (EqualsObject) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(label, that.label);
    }

    // no hashcode overridden for now

}
