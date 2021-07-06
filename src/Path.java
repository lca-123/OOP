import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Path {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        int n=input.nextInt();
        int[][] matrix=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=input.nextInt();
            }
        }

        int x1=input.nextInt();
        int y1=input.nextInt();
        int x2=input.nextInt();
        int y2=input.nextInt();

        Queue<int[]> path= new LinkedList<>();
        int[] cur=new int[2];
        cur[0]=x1;
        cur[1]=y1;
        path.add(cur);

        while(!path.isEmpty()){

            int[] curr=path.poll();
            if(curr[0]==x2&&curr[1]==y2){
                System.out.println("Yes");
                break;
            }
            if(matrix[curr[0]][curr[1]+1]==0 && !visited[curr[0]][curr[1]+1]){
                int[] curr1=new int[2];
                curr1[0]=curr[0];
                curr1[1]=curr[1]+1;

                path.add(curr1);
                visited[curr1[0]][curr1[1]]=true;
            }
            if(matrix[curr[0]+1][curr[1]]==0 && !visited[curr[0]+1][curr[1]]){
                int[] curr1=new int[2];
                curr1[0]=curr[0]+1;
                curr1[1]=curr[1];

                path.add(curr1);
                visited[curr1[0]][curr1[1]]=true;
            }
            if(matrix[curr[0]][curr[1]-1]==0 && !visited[curr[0]][curr[1]-1]){
                int[] curr1=new int[2];
                curr1[0]=curr[0];
                curr1[1]=curr[1]-1;
                path.add(curr1);
                visited[curr1[0]][curr1[1]]=true;

            }
            if(matrix[curr[0]-1][curr[1]]==0 && !visited[curr[0]-1][curr[1]]){
                int[] curr1=new int[2];
                curr1[0]=curr[0]-1;
                curr1[1]=curr[1];
                path.add(curr1);
                visited[curr1[0]][curr1[1]]=true;

            }
        }

        if(path.isEmpty()){
            System.out.println("No");
        }


    }
}
