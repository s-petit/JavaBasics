package hashcode.rules;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NoEqualsAndHashcodeTest {

    private NoEqualsAndHashcode noEqualsAndHashcode = new NoEqualsAndHashcode("code", "label");
    private NoEqualsAndHashcode noEqualsAndHashcode2 = new NoEqualsAndHashcode("code", "label");

    @Test
    public void objects_with_same_values_are_not_equal_to_each_other_when_equals_not_overridden() {
        assertThat(noEqualsAndHashcode).isNotEqualTo(noEqualsAndHashcode2);
    }

    @Test
    public void objects_with_same_values_have_not_the_same_hashcode_when_equals_not_overridden() {
        assertThat(noEqualsAndHashcode.hashCode()).isNotEqualTo(noEqualsAndHashcode2.hashCode());
    }

    @Test
    public void objects_with_same_values_are_both_inside_a_set() {
        // the instances of NoEqualsAndHashcode are never equal to each other, not considered as duplicates in a set.
        Set<NoEqualsAndHashcode> set = Sets.newHashSet(noEqualsAndHashcode, noEqualsAndHashcode2);
        assertThat(set).containsExactlyInAnyOrder(noEqualsAndHashcode, noEqualsAndHashcode2);
    }

}