class Solution {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<int[]> minh = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        boolean[] deleted = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                int[] top = minh.poll();
                deleted[-top[1]] = true;
            } else {
                minh.offer(new int[]{c, -i});
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (deleted[i] || s.charAt(i) == '*') continue;
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}