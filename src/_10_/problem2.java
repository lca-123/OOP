package _10_;

import java.util.*;

/**
 * 一个同学这个学期必须选修 n 门课程，记为0到n-1 。在选修某些课程之前需要一些先修课程。
 * 例如，想要学习课程 0 ，需要先完成课程 1 .给定课程总量以及它们的先决条件，
 * 请判断这位同学是否可能完成所有课程的学习？
 * @author lca
 */
public class problem2 {
    static List<List<Integer>> edges;
    static int[] visited;
    static boolean canFinish = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCourse = sc.nextInt();
        edges = new ArrayList<>();
        for (int i = 0; i < numOfCourse; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numOfCourse];
        int numOfConditions = sc.nextInt();
        for (int i = 0; i < numOfConditions; i++) {
            int index = sc.nextInt();
            edges.get(index).add(sc.nextInt());
        }
        for (int i = 0; i < numOfCourse && canFinish; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }
        System.out.println(canFinish);
    }

    public static void dfs(int pre){
        visited[pre]=1;
        for(int next:edges.get(pre)){
            if(visited[next] == 1){
                canFinish = false;
                return ;
            }else if(visited[next]==0){
                dfs(next);
                if(!canFinish){
                    return ;
                }
            }
        }
        visited[pre]=2;
    }
}
