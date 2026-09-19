class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128]; // Covers all ASCII uppercase and lowercase letters
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : counts) {
            // Add the largest even part of the character's count
            length += (count / 2) * 2;

            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        // A palindrome can have at most one single character in the very center
        return hasOdd ? length + 1 : length;
    }
}