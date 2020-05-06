package may.six;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
        int mark = nums.length / 2;
        int element = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > mark) {
                element = entry.getKey();
                break;
            }
        }
        return element;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MajorityElement obj = new MajorityElement();
		int[] arr1 = {3, 2, 3};
		int[] arr2 = {2, 2, 1, 1, 1, 2, 2};
		int[] arr3 = {4, 5, 6, 1, 3, 4, 4, 3, 4, 5, 4, 4, 4};
		int[] arr4 = {1, 2, 1, 4, 1, 5, 1, 2, 1, 6, 1, 7, 1, 1};
		int[] arr5 = {3, 2, 3, 2, 2};

		System.out.println(obj.majorityElement(arr1));
		System.out.println(obj.majorityElement(arr2));
		System.out.println(obj.majorityElement(arr3));
		System.out.println(obj.majorityElement(arr4));
		System.out.println(obj.majorityElement(arr5));
	}

}
