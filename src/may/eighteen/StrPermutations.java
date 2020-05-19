package may.eighteen;

public class StrPermutations {

	/*
	private boolean areEqual(int[] arr1, int[] arr2) {
		for (int i = 0; i < 26; i++) {
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;
	}*/
	
	public boolean checkInclusion(String s1, String s2) {
        /*if(s1.length() == 1 && s2.contains(s1)) {
        	return true;
        }
 
        if(s1.length() > s2.length())
        	return false;
  
		int[] bench = new int[26];
        int[] chars = new int[26];
        int[] basic = new int[26];
 
        for(char c : s1.toCharArray()) {
        	chars[c - 'a']++;
        	bench[c - 'a']++;
        }
 
        for(int i = 0; i + s1.length() <= s2.length(); i++) {        	
        	for(char c : s2.substring(i, i+s1.length()).toCharArray())
        		chars[c - 'a']--;
        	
        	if(areEqual(basic, chars))
        		return true;
        	else 
        		chars = bench.clone();
        }
        return false;*/
		
		int[] counts = new int[26];
        for(int i=0;i<s1.length();i++){
            counts[s1.charAt(i) - 'a']++;
        }
        int n = s1.length();

        int left=0;
        int right=0;
        char[] arr = s2.toCharArray();
        while(right<arr.length){
            while(right<arr.length && counts[arr[right] - 'a']>0){
                counts[arr[right] - 'a']--;
                right++;
            }
            
            if(right-left==n)return true;
         
            while(right<arr.length && counts[arr[right] - 'a']<=0) {
                counts[arr[left++] - 'a']++;
            }            
        }

        return false; 
    }

	public static void main(String[] args) {
		StrPermutations sp = new StrPermutations();
		
		System.out.println(sp.checkInclusion("ab", "eidbaooo"));
		System.out.println(sp.checkInclusion("adc", "dcda"));
		System.out.println(sp.checkInclusion("ab", "eidboaoo"));
	}

}
