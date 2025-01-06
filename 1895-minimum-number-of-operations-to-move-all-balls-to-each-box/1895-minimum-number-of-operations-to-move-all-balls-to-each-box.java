class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        
        int[] arrBox=new int[n];
        for(int i=0; i<n; i++){
            arrBox[i]=boxes.charAt(i)-'0';
        }

        int[] left=new int[n]; 
        int[] right=new int[n]; 

        int oneCnt=0;
        oneCnt=arrBox[0];
        for(int i=1; i<n; i++){
            left[i]=left[i-1]+oneCnt;
            oneCnt+=arrBox[i];
        }
 
        oneCnt=arrBox[n-1];
        for(int i=n-2; i>=0; i--){
            right[i]=right[i+1]+oneCnt;
            oneCnt+=arrBox[i];
        }

        for(int i=0; i<n; i++){
            arrBox[i]=left[i]+right[i];
        }        

        return arrBox;
    }
}