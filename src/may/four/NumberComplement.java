package may.four;

public class NumberComplement {

	public int findComplement(int num) {
        char[] binary = Integer.toBinaryString(num).toCharArray();
        
        for (int i = 0; i < binary.length; i++) {
            if(binary[i] == '0')
                binary[i] = '1';
            else
                binary[i] = '0';
        }
        return Integer.parseInt(String.valueOf(binary), 2);
    }
	
	public static void main(String[] args) {
		NumberComplement obj = new NumberComplement();
		
		System.out.println(obj.findComplement(5));
	}

}
