package hashcode.rules;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NoOverriddenHashCodeTest {

    private NoOverriddenHashCode o = new NoOverriddenHashCode("code", "label");
    private NoOverriddenHashCode o2 = new NoOverriddenHashCode("code", "label");

    @Test
    public void objects_with_same_values_should_be_equals() {
        assertThat(o).isEqualTo(o2);
    }

    @Test
    public void equals_objects_without_overridden_hashcode_should_have_different_hashcodes() {
        assertThat(o).isEqualTo(o2);
        assertThat(o.hashCode()).isNotEqualTo(o2.hashCode());
    }

    @Test
    public void sets_are_messed_up_when_equals_is_overridden_but_not_hashcode() {
        Set<NoOverriddenHashCode> set = Sets.newHashSet(o, o2);
        // WTF, o and o2 are equals but the set contains both elements
        // because contains expect that equals elements are in same bucket and do its checks inside the bucket
        assertThat(set).containsExactlyInAnyOrder(o, o2);
    }
}
