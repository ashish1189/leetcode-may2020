package may.eleven;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int[][] newImage = image;
        int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        newImage[sr][sc] = newColor;
        for (int i = 0; i < dir.length; i ++) {
            int nextX = sr + dir[i][0];
            int nextY = sc + dir[i][1];
            if (nextX < 0 || nextX >= newImage.length || nextY < 0 || nextY >= newImage[0].length) {
                continue;
            }
            if (newImage[nextX][nextY] != oldColor) {
                continue;
            }
            floodFill(newImage, nextX, nextY, newColor);
        }
        return image;
    }
	
	public static void main(String[] args) {
		FloodFill ff = new FloodFill();

		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		//int[][] image = {{1,1,1,1,1}, {1,1,1,1,0}, {1,1,1,0,0}, {1,1,0,0,0}, {1,0,0,0,1}};
		int sr = 1, sc = 1, newColor = 2;

		for(int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j]+"\t");
			}
			System.out.println("");
		}

		int[][] filled = ff.floodFill(image, sr, sc, newColor);

		System.out.println("");

		for(int i = 0; i < filled.length; i++) {
			for (int j = 0; j < filled[i].length; j++) {
				System.out.print(filled[i][j]+"\t");
			}
			System.out.println("");
		}
	}
}
