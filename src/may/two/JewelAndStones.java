package may.two;

import java.util.HashSet;
import java.util.Set;

public class JewelAndStones {
    public static int numJewelsInStones(String J, String S) {
    	int count = 0;
        Set<Character> jewels = new HashSet<>();
        
        for (int i = 0; i < J.length(); i++) {
        	jewels.add(J.charAt(i));
        }
        
        System.out.println(jewels.toString());
        
        for(int i = 0; i < S.length(); i++) {
        	if(jewels.contains(S.charAt(i)))
        		count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    	System.out.println(numJewelsInStones("z", "ZZZ"));
    }
}