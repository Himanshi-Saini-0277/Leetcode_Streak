class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        
        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) r1.add(x);
            else if (x % 3 == 2) r2.add(x);
        }
        
        if (sum % 3 == 0) return sum;
        
        Collections.sort(r1);
        Collections.sort(r2);
        
        int rem = sum % 3;
        int ans = 0;
        
        if (rem == 1) {
            int op1 = (r1.size() >= 1) ? sum - r1.get(0) : 0;
            int op2 = (r2.size() >= 2) ? sum - r2.get(0) - r2.get(1) : 0;
            ans = Math.max(op1, op2);
        } else { // rem == 2
            int op1 = (r2.size() >= 1) ? sum - r2.get(0) : 0;
            int op2 = (r1.size() >= 2) ? sum - r1.get(0) - r1.get(1) : 0;
            ans = Math.max(op1, op2);
        }
        
        return ans;
    }
}