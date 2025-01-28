class Solution {
    private static int max = 0;
    private static int sum = 0;
    public int findMaxFish(int[][] arr) {
        max = 0;
      for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[0].length;j++)
			{
				if(arr[i][j] > 0)
				{
					sum = 0;
					check(arr, i, j);
				}
			}
		}
		return max;
	}
	private static void check(int[][] arr, int row, int col) {
		if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 0 || arr[row][col] == -1)
		{
			return;
		}
		sum += arr[row][col];
		arr[row][col] = -1;
		max = Math.max(sum, max);
		check(arr, row + 1, col);
		check(arr, row - 1, col);
		check(arr, row, col + 1);
		check(arr, row, col - 1);
		
	}
}