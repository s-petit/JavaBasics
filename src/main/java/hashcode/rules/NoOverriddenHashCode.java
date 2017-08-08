package hashcode.rules;

import hashcode.EqualsObject;

public class NoOverriddenHashCode extends EqualsObject {

    public NoOverriddenHashCode(String code, String label) {
        super(code, label);
    }

    // no hashcode overriden, the hashcode is Object hashcode, ie. unique for each object
    // rule is broken, equal object won't have same hashcode
    // will have hazardous behaviors inside HashSets and HashMaps
}
