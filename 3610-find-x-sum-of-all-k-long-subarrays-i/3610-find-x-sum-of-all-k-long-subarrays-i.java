class Solution {
    class Pair implements Comparable<Pair>{

        int ele;
        int freq;

        public Pair(int ele,int freq){
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p){
            if(this.freq == p.freq) return this.ele - p.ele;
            return this.freq - p.freq;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        for(int i=0;i<=n-k;i++){

            HashMap<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for(int j=i;j<=i+k-1;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }

            for(Map.Entry<Integer,Integer> pair : map.entrySet()){
                pq.add(new Pair(pair.getKey(),pair.getValue()));
                if(pq.size()>x) pq.poll();
            }

            int s = 0;
            while(pq.size()>0){
                Pair t = pq.poll();
                s += t.ele*t.freq;
            }
            ans[i] = s;
        }
        return ans;
    }
}