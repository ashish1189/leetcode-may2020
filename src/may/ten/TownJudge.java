package may.ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int count[] = new int[N];
		int judge = -1;
		
		for (int i = 0; i < trust.length; i++) {
			count[trust[i][0] - 1] = trust[i][0];

			if(map.containsKey(trust[i][0])) {
				map.get(trust[i][0]).add(trust[i][1]);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(trust[i][1]);
				map.put(trust[i][0], list);
			}
		}

		for (int i = 0; i < count.length; i++) {
			if(count[i] == 0) {
				judge = i + 1;
				for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
					if(!entry.getValue().contains(judge)) {
						judge = -1;
						break;
					}
				}
			}
		}
		
		return judge;
	}

	public static void main(String[] args) {
		int[][] trust1 = {{1,2}};
		int[][] trust2 = {{1,3},{2,3}};
		int[][] trust3 = {{1,3},{2,3},{3,1}};
		int[][] trust4 = {{1,2},{2,3}};
		int[][] trust5 = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		
		TownJudge tj = new TownJudge();
		System.out.println(tj.findJudge(2, trust1));
		System.out.println(tj.findJudge(3, trust2));
		System.out.println(tj.findJudge(3, trust3));
		System.out.println(tj.findJudge(3, trust4));
		System.out.println(tj.findJudge(4, trust5));
	}

}
