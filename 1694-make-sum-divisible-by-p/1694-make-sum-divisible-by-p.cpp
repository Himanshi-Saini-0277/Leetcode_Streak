#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int rem = totalSum % p;
        if (rem == 0) return 0;

        unordered_map<int, int> prefixMod;
        prefixMod[0] = -1;
        long prefixSum = 0;
        int minLength = nums.size();

        for (int i = 0; i < nums.size(); ++i) {
            prefixSum += nums[i];
            int currentMod = prefixSum % p;
            int targetMod = (currentMod - rem + p) % p;

            if (prefixMod.find(targetMod) != prefixMod.end()) {
                minLength = min(minLength, i - prefixMod[targetMod]);
            }

            prefixMod[currentMod] = i;
        }

        return minLength == nums.size() ? -1 : minLength;
    }
};