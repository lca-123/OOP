import java.awt.*;
import java.util.*;


public class bfs {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=sc.nextInt();
                // a little 
            }
        }

        int sx=sc.nextInt(),sy=sc.nextInt(),dx=sc.nextInt(),dy=sc.nextInt();
        Point sp = new Point(sx,sy);
        Queue<Point> points = new LinkedList<>();
        points.add(sp);
        visited[sx][sy]=true;
        while(!points.isEmpty()){
            Point point = points.poll();
            if(point.x==dx&&point.y==dy&&maze[point.x][point.y]!=1){
                System.out.print("Yes");
                points.add(point);
                break;
            }
            if(point.x+1<row&&maze[point.x+1][point.y]!=1&&!visited[point.x+1][point.y]){
                points.add(new Point(point.x+1,point.y));
                visited[point.x+1][point.y]=true;
            }
            if(point.y+1<col&&maze[point.x][point.y+1]!=1&&!visited[point.x][point.y+1]){
                points.add(new Point(point.x,point.y+1));
                visited[point.x][point.y+1]=true;
            }
            if(point.x-1>=0&&maze[point.x-1][point.y]!=1&&!visited[point.x-1][point.y]){
                points.add(new Point(point.x-1,point.y));
                visited[point.x-1][point.y]=true;
            }
            if(point.y-1>=0&&maze[point.x][point.y-1]!=1&&!visited[point.x][point.y-1]){
                points.add(new Point(point.x,point.y-1));
                visited[point.x][point.y-1]=true;
            }
        }
        if(points.isEmpty()){
            System.out.println("No");
        }

    }


}
