package may.twentynine;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(prerequisites.length == 0 || numCourses == 0)
			return true;
		
		int[] visited = new int[numCourses];
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int[] pre : prerequisites) {
			if(map.containsKey(pre[0]))
				map.get(pre[0]).add(pre[1]);
			else {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(pre[1]);
				map.put(pre[0], al);
			}
		}
		
		for(int i = 0; i < numCourses; i++) {
			if(!canFinishDFS(map, visited, i))
				return false;
		}
		
		return true;
    }

	private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int i) {
		if(visited[i] == -1)
			return false;
		if(visited[i] == 1)
			return true;
		
		visited[i] = -1;
		
		if(map.containsKey(i)) {
			for(int v : map.get(i)) {
				if(!canFinishDFS(map, visited, v))
					return false;
			}
		}

		visited[i] = 1;

		return true;
	}

	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		
		int crs = 2;
		int[][] crs1 = {{0, 1}};
		System.out.println(cs.canFinish(crs, crs1));
		
		crs = 2;
		int[][] crs2 = {{0, 1}, {1, 0}};
		System.out.println(cs.canFinish(crs, crs2));
	}

}
