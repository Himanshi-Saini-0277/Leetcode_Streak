class Solution {
public:
    static vector<int> constructTransformedArray(vector<int>& nums) {
        const int n=nums.size();
        vector<int> ans(n);
        for (int i=0; i<n; i++){
            int j=(i+nums[i])%n;  
            ans[i]=nums[j+(-(j<0)&n)];
        }
        return ans;
    
    
    }
};