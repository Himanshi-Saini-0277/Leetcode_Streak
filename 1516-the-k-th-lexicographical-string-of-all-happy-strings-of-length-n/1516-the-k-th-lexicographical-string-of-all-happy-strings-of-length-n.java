class Solution {
    private String ans = "";

    private void solve(int len, int[] cnt, int n, char[] chars, StringBuilder s) {
        if (len == n) {
            if (--cnt[0] == 0) {
                ans = s.toString();
            }
            return;
        }
        for (char c : chars) {
            if (len == 0 || s.charAt(len - 1) != c) {
                s.append(c);
                solve(len + 1, cnt, n, chars, s);
                s.deleteCharAt(s.length() - 1);
                if (cnt[0] == 0) return;
            }
        }
    }

    public String getHappyString(int n, int k) {
        ans = "";
        solve(0, new int[]{k}, n, new char[]{'a', 'b', 'c'}, new StringBuilder());
        return ans;
    }
}