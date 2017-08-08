package hashcode.rules;

import hashcode.EqualsObject;

import java.util.Objects;

public class ValidHashCode extends EqualsObject {


    public ValidHashCode(String code, String label) {
        super(code, label);
    }

    // hashcode depends on same fields than equals
    // so only equals objects will be in the same bucket
    // performance on hashsets and hashmaps will be optimal
    @Override
    public int hashCode() {
        return Objects.hash(code, label);
    }
}
