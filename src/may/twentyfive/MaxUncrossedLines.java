
package may.twentyfive;

public class MaxUncrossedLines {

	public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length, dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxUncrossedLines ul = new MaxUncrossedLines();
		
		int[] A = {1,4,2};
		int[] B = {1,2,4};
		
		System.out.println(ul.maxUncrossedLines(A, B));
		
	}

}
