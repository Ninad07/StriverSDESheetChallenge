public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        if(image[x][y] != newColor) fill(image, x, y, image[x][y], newColor);
        return image;
    }
    
    private static void fill(int[][] arr, int row, int col, int color, int newColor) {
        if(!isValid(arr, row, col, color)) return;
        
        arr[row][col] = newColor;
        fill(arr, row - 1, col, color, newColor);
        fill(arr, row, col + 1, color, newColor);
        fill(arr, row + 1, col, color, newColor);
        fill(arr, row, col - 1, color, newColor);
    }
    
    private static boolean isValid(int[][] arr, int row, int col, int color) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == color;
    }
}

