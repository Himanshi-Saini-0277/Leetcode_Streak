class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (list.size() != 1) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                int val = (list.get(i) + list.get(i + 1)) % 10;
                temp.add(val);
            }
            list = temp;
        }
        return list.get(0);
    }
}