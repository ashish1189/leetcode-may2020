package may.twentysix;

import java.util.HashMap;

public class LongestBinArray {

	public int findMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
        	return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0, n = nums.length;

        for(int i = 0; i < n; i++)
        	nums[i] = (nums[i] == 0) ? -1 : 1;
 
        for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			
			if(sum == 0) {
				max = i + 1;
			}
			
			if (map.containsKey(sum + n)) { 
                if (max < i - map.get(sum + n))
                	max = i - map.get(sum + n);
            } 
            else {
            	map.put(sum + n, i);
            }
		}
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestBinArray obj = new LongestBinArray();
		
		int[] A = {0,1};
		System.out.println(obj.findMaxLength(A));
		
		int[] B = {0,1,0};
		System.out.println(obj.findMaxLength(B));
		
		int[] C = {};
		System.out.println(obj.findMaxLength(C));
		
		int[] D = {1, 0, 0, 1, 0, 1, 1};
		System.out.println(obj.findMaxLength(D));
		
		int[] E = {1, 0, 1, 1, 1, 0, 0};
		System.out.println(obj.findMaxLength(E));
		
		int[] F = {1, 1, 1, 1};
		System.out.println(obj.findMaxLength(F));
		
		int[] G = {0, 0, 1, 1, 0};
		System.out.println(obj.findMaxLength(G));
	}

}
