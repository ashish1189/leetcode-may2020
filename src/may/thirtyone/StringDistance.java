package may.thirtyone;

public class StringDistance {

	public int minDistance(String word1, String word2) {
		if(word1 == null)
			word1 = "";
		
		if(word2 == null)
			word2 = "";

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for(int i = 0; i < dp.length; i++) {
        	for(int j = 0; j < dp[i].length; j++)
        		System.out.print(dp[i][j]+" ");
        	
        	System.out.println("");
        }
        System.out.println("");
        for(int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            for(int j = 0; j < word2.length(); j++) {
                char c2 = word2.charAt(j);
                
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    
                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        for(int i = 0; i < dp.length; i++) {
        	for(int j = 0; j < dp[i].length; j++)
        		System.out.print(dp[i][j]+" ");
        	
        	System.out.println("");
        }
        return dp[word1.length()][word2.length()];
    }

	public static void main(String[] args) {
		StringDistance sd = new StringDistance();

		sd.minDistance("horse", "ros");
		//System.out.println(sd.minDistance(null, null));
		//System.out.println(sd.minDistance(null, "ros"));
		//System.out.println(sd.minDistance("horse", null));
		//System.out.println(sd.minDistance("", "ros"));
		//System.out.println(sd.minDistance("horse", ""));
		//System.out.println(sd.minDistance("horse", "ros"));
		//System.out.println(sd.minDistance("intention", "execution"));

	}

}
