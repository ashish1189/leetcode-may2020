package may.thirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class KClosestToOrigin {

	public int[][] kClosest(int[][] points, int K) {
        if(points.length == 1 && K == 1)
        	return points;
        
        Set<Double> set = new TreeSet<>();
        Map<Double, ArrayList<int[]>> map = new HashMap<>();
        
        for(int i = 0; i < points.length; i++) {
        	Double dist = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
        	set.add(dist);

        	int[] arr = {points[i][0], points[i][1]};
        	
        	if(map.containsKey(dist)) {
        		map.get(dist).add(arr);
        	} else {
        		ArrayList<int[]> al = new ArrayList<>();
        		al.add(arr);
        		map.put(dist, al);
        	}
        }

        List<int[]> list = new ArrayList<>();
        
        for(Double dist : set) {
        	if(K == 0)
        		break;
        	
        	for(int[] arr : map.get(dist)) {
        		list.add(arr);
        		K--;
        	}
        }
        
        return list.toArray(new int[list.size()][]);
    }

	public static void main(String[] args) {
		KClosestToOrigin k = new KClosestToOrigin();
		
		int[][] A = {{1,3},{-2,2}};
		int[][] aa = k.kClosest(A, 1);
		
	}

}
