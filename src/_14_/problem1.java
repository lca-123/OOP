package _14_;

import java.util.Scanner;

public class problem1 {
    public static String path = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt(), p = sc.nextInt();
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        solution(maze,0,0,visited,"", p);
        System.out.println(path);
    }
    public static void solution(int[][] maze, int i, int j, boolean[][] visited, String res, int p){
        if(i==0 && j == maze[0].length - 1 && maze[i][j] == 1){
            if(p>=0){
                path = res + "[" + i + ", " + j + "]";
            }else{
                path = "Can not escape!";
            }
            return ;
        }
        if(i>=0 && j>=0 && i< maze.length && j < maze[0].length && maze[i][j]==1 && !visited[i][j]){
            visited[i][j] = true;
            res += "[" + i + ", " + j + "], ";
            solution(maze,i,j+1,visited,res,p-1);
            solution(maze,i+1,j,visited,res,p);
            solution(maze,i,j-1,visited,res,p-1);
            solution(maze,i-1,j,visited,res,p-3);

        }
    }
}
