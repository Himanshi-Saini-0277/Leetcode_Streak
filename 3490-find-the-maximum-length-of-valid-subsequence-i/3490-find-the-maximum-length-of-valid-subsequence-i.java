class Solution 
{
    public int maximumLength(int[] nums) 
    {
        int evenCount = 0, oddCount = 0;
        int altEven = 0, altOdd = 0;

        for (int num : nums) 
        {
            int p = num % 2;
            if (p == 0) 
            { 
                evenCount++;
                altEven = altOdd + 1;
            } 
            else 
            { 
                oddCount++;
                altOdd = altEven + 1;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), Math.max(altEven, altOdd));
    }
}