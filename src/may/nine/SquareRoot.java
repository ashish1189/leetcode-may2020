package may.nine;

public class SquareRoot {

	public static boolean isPerfectSquare(int num) {
        if(num <= 1)
        	return false;

		double temp;
		double sr = num / 2;

		do {
			temp = sr;
			sr = (temp + (num / temp)) / 2;
			System.out.println(sr+" : "+temp);
		} while ((temp - sr) != 0);

        if(sr%1 == 0)
            return true;
        else
            return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPerfectSquare(2));
	}

}
