package hashcode.rules;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidHashCodeTest {

    ValidHashCode o1 = new ValidHashCode("code", "label");
    ValidHashCode o2 = new ValidHashCode("code", "label");

    @Test
    public void objects_with_same_values_should_be_equals() {
        assertThat(o1).isEqualTo(o2);
    }

    @Test
    public void equals_objects_with_valid_overridden_hashcode_should_have_same_hashcodes() {
        assertThat(o1.hashCode()).isEqualTo(o2.hashCode());
    }

    @Test
    public void duplicates_should_be_removed_from_sets() {
        Set<ValidHashCode> set = Sets.newHashSet(o1, o2);
        // the element to match doesn't matter, there are equals anyway
        assertThat(set).containsExactlyInAnyOrder(o1);
        assertThat(set).containsExactlyInAnyOrder(o2);
    }

}