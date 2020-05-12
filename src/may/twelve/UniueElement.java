package may.twelve;

public class UniueElement {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
    	while(low < high) {
    		int mid = (low+high)/2;
    		if (mid % 2 == 1) mid--;
    		
    		if(nums[mid] != nums[mid+1]) {
    			high = mid;
    		} else {
    			low = mid + 2;
    		}
    	}
    	return nums[low];
    }
    
	public static void main(String[] args) {
		UniueElement ue = new UniueElement();
		int[] nums = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8};
		
		System.out.println(ue.singleNonDuplicate(nums));
		
		int[] nums1 = {1,1,2,3,3,4,4,8,8};
		System.out.println(ue.singleNonDuplicate(nums1));
		
		int[] nums2 = {3,3,7,7,10,11,11};
		System.out.println(ue.singleNonDuplicate(nums2));
	}

}
