package may.twentyone;

public class SubMatrices {

	public int countSquares(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) 
        	return 0;
        
        int col = matrix[0].length;
        if (col <= 0) 
        	return 0;

        int[][] dp = new int[row+1][col+1];
        int count = 0;
        for (int i = 1; i <= row; i ++)
        {
            for (int j = 1; j <= col; j ++)
            {
                if (matrix[i-1][j-1]==1)
                {
                    int edgeSize = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;                    
                    count = count + (edgeSize-1+1);
                    dp[i][j] = edgeSize;
                }
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int[][] A = {
				  {0,1,1,1},
				  {1,1,1,1},
				  {0,1,1,1}
				};
		
		SubMatrices sm = new SubMatrices();
		
		System.out.println(sm.countSquares(A));
		
		int[][] B = {
				  {1,0,1},
				  {1,1,0},
				  {1,1,0}
				};
		
		System.out.println(sm.countSquares(B));

	}

}
