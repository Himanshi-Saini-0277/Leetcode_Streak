class Solution {

    public long kMirror(int base, int count) {
        long sum = 0;

        for (int length = 1; ; ++length) {
            int start = (int) Math.pow(10, (length - 1) / 2);
            int end = (int) Math.pow(10, (length + 1) / 2);

            for (int i = start; i < end; i++) {
                long palindrome = i;

                for (int j = length % 2 == 0 ? i : i / 10; j > 0; j /= 10) {
                    palindrome = palindrome * 10 + j % 10;
                }
                String baseRepresentation = Long.toString(palindrome, base);
              
                if (isPalindrome(baseRepresentation.toCharArray())) {
                    sum += palindrome;
                    if (--count == 0) {
                        return sum;
                    }
                }
            }
        }
    }
    private boolean isPalindrome(char[] charArray) {
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }
}