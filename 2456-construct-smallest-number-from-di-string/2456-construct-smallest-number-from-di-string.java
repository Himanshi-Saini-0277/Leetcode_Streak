class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder("1");
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                ans.append(temp).append((char)('2' + i));
                temp.setLength(0);
            } else {
                temp.insert(0, ans.charAt(ans.length() - 1));
                ans.setLength(ans.length() - 1);
                ans.append((char)('2' + i));
            }
        }
        
        return ans.append(temp).toString();
    }
}