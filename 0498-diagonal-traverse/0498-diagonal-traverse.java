class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length; int m=mat[0].length;
        int ans[]=new int[n*m];
        int idx=0;
        int flag=0;
        for(int row=0; row<n; row++) {
            ArrayList<Integer> list=new ArrayList<>();
            int i=row;
            int j=0;
            if(flag%2==0) {
                while(i>=0 && i<n && j>=0 && j<m) {
                    ans[idx++]=mat[i--][j++];
                }
            } else {
                while(i>=0 && i<n && j>=0 && j<m) {
                    list.add(mat[i--][j++]);
                }
                for(int x=list.size()-1; x>=0; x--) {
                    ans[idx++]=list.get(x);
                }
            }
            flag++;
        }
        for(int col=1; col<m; col++) {
            ArrayList<Integer> list=new ArrayList<>();
            int i=n-1;
            int j=col;
            if(flag%2==0) {
                while(i>=0 && i<n && j>=0 && j<m) {
                    ans[idx++]=mat[i--][j++];
                }
            } else {
                while(i>=0 && i<n && j>=0 && j<m) {
                    list.add(mat[i--][j++]);
                }
                for(int x=list.size()-1; x>=0; x--) {
                    ans[idx++]=list.get(x);
                }
            }
            flag++;
        }
        return ans;
    }
}