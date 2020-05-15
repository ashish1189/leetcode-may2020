package may.fifteen;

public class CircularArrayMaxSum {

	private int kadaneOriginal(int A[]) {
		/**
		 * Kadane's original algorithm works only if there is
		 * at least 1 positive element in the array. For the arrays
		 * with all negative integers we have to modify the Kadane's 
		 * algorithm.
		 */
		
		int max_end = 0;
		int max_so_far = Integer.MIN_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			max_end += A[i];

			if(max_end < 0)
				max_end = 0;

			if(max_so_far < max_end)
				max_so_far = max_end;
		}
		
		return max_so_far;
	}

	private int kadaneMax(int A[]) {
		int max_end = A[0];
        int max_so_far = A[0];
        
        for (int i = 1; i < A.length; i++) {
			max_end = Math.max(A[i], max_end + A[i]);
			max_so_far = Math.max(max_so_far, max_end);
		}
        return max_so_far;
	}

	public int maxSubarraySumCircular(int[] A) {
        int std_sum = kadaneMax(A);
        
        int wrap = 0;
        
        for (int i = 0; i < A.length; i++) {
			wrap += A[i];
			A[i] = -A[i];
		}

        int all_neg = kadaneMax(A);
 
        if(all_neg == -wrap)
        	return std_sum;
        
        wrap = wrap + all_neg;

        return (wrap > std_sum)? wrap : std_sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularArrayMaxSum ca = new CircularArrayMaxSum();
		
		int[] A = {1,-2,3,-2};
		int[] B = {5,-3,5};	
		int[] C = {3,-1,2,-1};	
		int[] D = {3,-2,2,-3};
		int[] E = {-2,-3,-1};
		System.out.println(ca.kadaneOriginal(A));
		System.out.println(ca.kadaneOriginal(B));
		System.out.println(ca.kadaneOriginal(C));
		System.out.println(ca.kadaneOriginal(D));
		System.out.println(ca.kadaneOriginal(E));
		System.out.println();
		System.out.println("Circular Array answers below");
		System.out.println();
		System.out.println(ca.maxSubarraySumCircular(A));
		System.out.println(ca.maxSubarraySumCircular(B));
		System.out.println(ca.maxSubarraySumCircular(C));
		System.out.println(ca.maxSubarraySumCircular(D));
		System.out.println(ca.maxSubarraySumCircular(E));
	}

}
