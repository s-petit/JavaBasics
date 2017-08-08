package hashcode.performance;

import hashcode.EqualsObject;

import java.util.Objects;

public class SlowHashCode extends EqualsObject {

    public SlowHashCode(String code, String label) {
        super(code, label);
    }

    // hashcode depends on a subset of fields used for equals
    // so equals objects will have same hashcode, so the rule is respected
    // but also, unequal objects may be in a same bucket
    // it will affect performances. The more elements a bucket contains, the more time is necessary to find the element
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
