package _15_;

import java.util.*;

public class problem1 {

    public static int n;
    public static int Q;
    public static int m;
    public static int s;
    public static int[] weights;
    public static int[] profits;
    public static int[] punish;
    public static boolean[][] conflict;
    public static int[][] punishSet;
    public static int[][] f;

    public static int best_profit;
    public static int[] marks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Q=sc.nextInt();
        m=sc.nextInt();
        s=sc.nextInt();
        weights = new int[n];
        profits = new int[n];
        conflict = new boolean[n][n];
        punishSet = new int[s][3];
        punish = new int[s];
        marks = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i]=sc.nextInt();
            profits[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(),b = sc.nextInt();
            conflict[a][b] = conflict[b][a] = true;
        }
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 2; j++) {
                punishSet[i][j]=sc.nextInt();
            }
            punish[i]=sc.nextInt();
        }
        best_profit = 0;
        ArrayList<Integer> ss = new ArrayList<>();
        dp();
        dfs(ss,0,0,-1);
        System.out.println(best_profit);
    }

    public static void dp(){
        f=new int[n+1][Q+1];
        for (int i = n - 1; i >=0 ; i--) {
            for (int j = 0; j <= Q; j++) {
                if(j<weights[i]){
                    f[i][j] = f[i+1][j];
                }else{
                    f[i][j] = Math.max(f[i+1][j],f[i+1][j-weights[i]]+profits[i]);
                }
            }
        }
    }

    public static void dfs(ArrayList<Integer> ss,int w, int p, int index){


        if(p + f[index+1][Q-w] <= best_profit){
            return ;
        }
        if(p >= best_profit){
            best_profit = p;
        }
        for (int i = index+1; i < n; i++) {
            if(w + weights[i] > Q){
                continue;
            }
            boolean feasible = true;
            for (int j = 0; j < ss.size(); j++) {
                if(conflict[ss.get(j)][i]){
                    feasible = false;
                    break;
                }
            }
            if(!feasible){
                continue;
            }
            ss.add(i);
            int[] mark = new int[s];
            int pp = p;
            for (Integer integer : ss) {
                for (int j = 0; j < s; j++) {
                    if (integer == punishSet[j][0]) {
                        mark[j]++;
                    }
                    if (integer == punishSet[j][1]) {
                        mark[j]++;
                    }
                    if (integer == punishSet[j][2]) {
                        mark[j]++;
                    }
                }
            }
            for (int k = 0; k < s; k++) {
                if(mark[k]>=2 && marks[k]==0){
                    marks[k]=1;
                    pp -= punish[k];
                }
                if(mark[k]<2 && marks[k]==1){
                    marks[k]=0;
                }
            }
            dfs(ss,w+weights[i],pp+profits[i],i);
            ss.remove(ss.size()-1);
        }
    }
}
