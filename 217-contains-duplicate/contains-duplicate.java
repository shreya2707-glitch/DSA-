import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // set.add(num) returns false if the element already exists in the set
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}