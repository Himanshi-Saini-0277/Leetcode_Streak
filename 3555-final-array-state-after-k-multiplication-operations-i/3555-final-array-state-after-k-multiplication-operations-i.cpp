#include <vector>
#include <algorithm>

class Solution {
public:
    vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
        while (k > 0) {
            int minIndex = 0;
            for (int i = 1; i < nums.size(); ++i) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            nums[minIndex] *= multiplier;
            --k;
        }
        return nums;
    }
};