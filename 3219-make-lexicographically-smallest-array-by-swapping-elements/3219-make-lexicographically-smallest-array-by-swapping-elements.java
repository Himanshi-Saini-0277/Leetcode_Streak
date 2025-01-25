class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] res=new int[n];

        int[][] numsSort= new int[n][];
        for(int i=0; i<n; i++){
            numsSort[i]=new int[]{nums[i], i};
        }
        
        Arrays.sort(numsSort, (a,b)->a[0]-b[0]);

        Map<Integer, Deque<Integer>> map=new HashMap<>();

        int[] grpArr=new int[n];
        int grpNo=0;

        grpArr[numsSort[0][1]]=grpNo;
        map.put(grpNo, new ArrayDeque<>());
        map.get(grpNo).addLast(numsSort[0][0]);

        for(int i=1; i<n; i++){
            if(numsSort[i][0]-map.get(grpNo).getLast()<=limit){
                map.get(grpNo).addLast(numsSort[i][0]);
                grpArr[numsSort[i][1]]=grpNo;
            }
            else{
                grpNo++;
                map.put(grpNo, new ArrayDeque<>());
                map.get(grpNo).addLast(numsSort[i][0]);
                grpArr[numsSort[i][1]]=grpNo;
            }
        }
        for(int i=0; i<n; i++){
            res[i]=map.get(grpArr[i]).pollFirst();
        }

        return res;
    }
}