package may.thirteen;

public class MinNumber {

	public String removeKdigits(String num, int k) {
		if(num.length() == k)
			return "0";

		StringBuilder sb = new StringBuilder(num);
		
		for (int j = 0; j < k; j++) {
			int i = 0;
			while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i ++;
            }
            sb.delete(i, i + 1);
		}
		
		int i = 0;
		while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i ++;
        }
        return sb.toString().substring(i);
	}

	public static void main(String[] args) {
		MinNumber o1 = new MinNumber();
		System.out.println(o1.removeKdigits("1432219", 3));
		System.out.println(o1.removeKdigits("10200", 1));
		System.out.println(o1.removeKdigits("10", 2));
	}

}
