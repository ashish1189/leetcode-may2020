package may.twentythree;

import java.util.ArrayList;
import java.util.List;

public class ListIntersection {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		int m = A.length, n = B.length;
        
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        while (i < m && j < n) {
            int[] a = A[i];
            int[] b = B[j];
            
            if (a[0] >= b[0] && a[0] <= b[1]) {
                result.add(new int[]{a[0], Math.min(a[1], b[1])});
                if (a[1] < b[1]) 
                	i++;
                else 
                	j++;
            } else if (b[0] >= a[0] && b[0] <= a[1]) {
                result.add(new int[]{b[0], Math.min(a[1], b[1])});
                if (a[1] < b[1]) 
                	i++;
                else 
                	j++;
            } else if (a[0] < b[0]) 
                i++;
            else if (a[0] > b[0])
            	j++;
        }
        
        return result.toArray(new int[result.size()][]);  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListIntersection li = new ListIntersection();
		
		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		
		int[][] arr = li.intervalIntersection(A, B);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
