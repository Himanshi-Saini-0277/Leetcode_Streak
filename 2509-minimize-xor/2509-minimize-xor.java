class Solution {
    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    public int minimizeXor(int num1, int num2) {
        int bits = countSetBits(num2);
        int result = 0;
        for (int i = 31; i >= 0 && bits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i);
                bits--;
            }
        }
        for (int i = 0; i < 32 && bits > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                bits--;
            }
        }
        return result;
    }
}