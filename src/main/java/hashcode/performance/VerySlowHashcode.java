package hashcode.performance;

import hashcode.EqualsObject;

public class VerySlowHashcode extends EqualsObject {

    public VerySlowHashcode(String code, String label) {
        super(code, label);
    }

    // will result on poor performances because there will be one bucket for all instances
    // rules are ok, equals objets will have the same hashcode, but searching in hashset and hashmap may be long
    @Override
    public int hashCode() {
        return 42;
    }
}
