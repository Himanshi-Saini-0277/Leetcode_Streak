class Solution 
{
    public int findKthNumber(int n, int k) 
    {
        int curr = 1; 
        k -= 1; 
        while (k > 0) 
        {
            long steps = countSteps(n, curr, curr + 1); 

            if (steps <= k) 
            {
                curr += 1;   
                k -= steps;
            } 
            else 
            {
                curr *= 10;  
                k -= 1;
            }
        }

        return curr; 
    }

    private long countSteps(int n, long curr, long next) 
    {
        long steps = 0;
        while (curr <= n) 
        {
            steps += Math.min(n + 1L, next) - curr;
            curr *= 10;
            next *= 10;
        }
        
        return steps;
    }
}