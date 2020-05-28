package may.twentyeight;

public class CountBits {
	public int[] countBits(int num) {
		/*
		List<Integer> list = new ArrayList<>();
		
        if(num == 0)
        	return new int[1];
        
        if(num == 1) {
        	int[] ans = {0, 1};
        	return ans;
        }
        
        list.add(0);
        list.add(1);

        for(int i = 2; i <= num; i++) {
        	int count = 0;
        	int n = i;
        	while(n > 0) {
        		int temp = n % 2;
        		
        		if(temp == 1)
        			count++;
        		
        		n = n / 2;
        	}
        	list.add(count);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
        */
		
		if (num < 0)
            return new int[1];

        int[] countBitArray = new int[num + 1];
        
        countBitArray[0] = 0;
        
        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }

        return countBitArray;
    }

	public static void main(String[] args) {
		CountBits bits = new CountBits();
		
		int arr[] = bits.countBits(5);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");

		System.out.println();
		
		int arr1[] = bits.countBits(10);
		
		for(int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i]+" ");
	}

}
