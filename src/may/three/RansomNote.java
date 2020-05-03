package may.three;

public class RansomNote {
	public boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }
    
    public static void main (String[] args) {
    	RansomNote note = new RansomNote();
    	System.out.println(note.canConstruct("aa", "aab"));
    	System.out.println(note.canConstruct("", ""));
    	System.out.println(note.canConstruct("bcb", "cjjajdfaaeegig"));
    	System.out.println(note.canConstruct("a", "b"));
    	System.out.println(note.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }
}