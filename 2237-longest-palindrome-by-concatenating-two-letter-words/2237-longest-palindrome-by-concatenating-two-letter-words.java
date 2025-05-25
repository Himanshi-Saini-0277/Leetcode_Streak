class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        boolean hasCenter = false;

        for (String word : new HashSet<>(freq.keySet())) {
            String rev = new StringBuilder(word).reverse().toString();
            if (word.equals(rev)) {
                int count = freq.get(word);
                ans += (count / 2) * 4;
                if (count % 2 == 1) hasCenter = true;
            } else if (freq.containsKey(rev)) {
                int pairs = Math.min(freq.get(word), freq.get(rev));
                ans += pairs * 4;
                freq.put(rev, 0);
            }
        }

        if (hasCenter) ans += 2;
        return ans;
    }
}