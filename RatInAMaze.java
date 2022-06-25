import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        allPaths(maze, new int[maze.length][maze[0].length], 0, 0, al);
        return al;
    }
    
    private static void allPaths(int[][] maze, int[][] arr, int row, int col, ArrayList<ArrayList<Integer>> al) {
        if(row == arr.length - 1 && col == arr[0].length - 1) {
            arr[row][col] = 1;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    list.add(arr[i][j]);
                }
            }
            al.add(list);
            return;
        }
        if(!isValid(maze, row, col)) return;
        arr[row][col] = 1;
        maze[row][col] = 0;
        allPaths(maze, arr, row - 1, col, al);
        allPaths(maze, arr, row, col + 1, al);
        allPaths(maze, arr, row + 1, col, al);
        allPaths(maze, arr, row, col - 1, al);
        maze[row][col] = 1;
        arr[row][col] = 0;
    }
    
    private static boolean isValid(int[][] maze, int row, int col) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length && maze[row][col] == 1;
    }
}
