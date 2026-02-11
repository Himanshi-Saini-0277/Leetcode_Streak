class SegmentTree {
    public int n, size;
    public int[] sum, mn, mx;

    SegmentTree(int n) {
        this.n = n;
        this.size = 4 * n;
        this.sum = new int[size];
        this.mn  = new int[size];
        this.mx  = new int[size];
    }

    void pull(int node) {
        int l = node * 2, r = node * 2 + 1;

        sum[node] = sum[l] + sum[r];
        mn[node] = Math.min(mn[l], sum[l] + mn[r]);
        mx[node] = Math.max(mx[l], sum[l] + mx[r]);
    }

    void update(int idx, int val) {
        int node = 1, l = 0, r = n - 1, index = 0;
        int[] path = new int[32]; 

        while (l != r) {
            path[index++] = node;
            int m = l + (r - l) / 2;
            if (idx <= m) {
                node = node * 2;
                r = m;
            } else {
                node = node * 2 + 1;
                l = m + 1;
            }
        }

        sum[node] = val;
        mn[node] = val;
        mx[node] = val;

        while (index > 0) {
            pull(path[--index]);
        }
    }

    int find_rightmost_prefix(int target) {
        int node = 1, l = 0, r = n - 1, sum_before = 0;

        if (target < mn[node] || target > mx[node]) return -1;

        while (l != r) {
            int m = l + (r - l) / 2;
            int lchild = node * 2, rchild = node * 2 + 1;

            int sum_before_right = sum[lchild] + sum_before;
            int need_right = target - sum_before_right;

            if (mn[rchild] <= need_right && need_right <= mx[rchild]) {
                node = rchild;
                l = m + 1;
                sum_before = sum_before_right;
            } else {
                node = lchild;
                r = m;
            }
        }

        return l;
    }
}

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        SegmentTree s_tree = new SegmentTree(n);
    
        int[] first = new int[100001]; 
        Arrays.fill(first, -1);
        
        int result = 0;
        for (int l = n - 1; l >= 0; --l) {
            int num = nums[l];
            
            if (first[num] != -1) {
                s_tree.update(first[num], 0);
            }
            first[num] = l;
            
            s_tree.update(l, (num & 1) == 0 ? 1 : -1); 
            
            int r = s_tree.find_rightmost_prefix(0);
            if (r >= l) {
                result = Math.max(result, r - l + 1);
            }
        }
        
        return result;
    }
}