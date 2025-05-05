class Solution {
    static final int MOD = 1000000007;
    public int numTilings(int n) {
        int arr[] = new int[n > 3? n : 3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        for(int i=3;i<n;i++){
            arr[i] = (arr[i-1]*2%MOD + arr[i-3])%MOD;
        }
        return arr[n-1];
    }
}