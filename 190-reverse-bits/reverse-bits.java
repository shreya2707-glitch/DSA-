class Solution {
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;         // Shift result left to make room
            result |= (n & 1);    // Append the least significant bit of n
            n >>>= 1;             // Unsigned right shift n by 1
        }
        
        return result;
    }
}