package may.ten;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {
		boolean count[] = new boolean[1000];
		
		for (int i = 0; i < trust.length; i++) {
			count[trust[i][0]] = true;
		}
 
		for (int i = 0; i < count.length; i++) {
			if(count[i]) {
				System.out.println(count[i]);
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int[][] trust = {{1,3},{2,3}};
		TownJudge tj = new TownJudge();
		System.out.println(tj.findJudge(3, trust));
	}

}
