package may.eight;

public class CollinearPoints {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2)
            return true;

        boolean flag = false;

        for(int i = 1; i < coordinates.length - 1; i++) {
            int a =   coordinates[i-1][0] * (coordinates[i][1] - coordinates[i+1][1])
                    + coordinates[i][0] * (coordinates[i+1][1] - coordinates[i-1][1])
                    + coordinates[i+1][0] * (coordinates[i-1][1] - coordinates[i][1]);
            
            if (a == 0) {
                flag = true;
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
 
    public static void main(String[] args) {
		CollinearPoints cp = new CollinearPoints();
		int[][] arr1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(cp.checkStraightLine(arr1));
		
		int[][] arr2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		System.out.println(cp.checkStraightLine(arr2));
	}
}