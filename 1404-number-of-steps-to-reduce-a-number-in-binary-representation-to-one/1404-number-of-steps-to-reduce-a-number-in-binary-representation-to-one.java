class Solution {
    public int numSteps(String s) {
    int st = 0;
    int c = 0;
    for (int i = s.length() - 1; i > 0; i--) {
        int n = s.charAt(i) - '0';
        if (n + c == 1) {
            st+= 2;
            c= 1;
        } else {
            st+= 1;
        }
    }
    return st+c;
    }
}