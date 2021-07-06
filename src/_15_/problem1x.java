package _15_;
import java.util.*;

/**
 * 带冲突约束的0-1背包问题是在经典的0-1背包问题基础上考虑物品之间的冲突关系，
 * 即物品i和物品j存在冲突，就不能同时将物品i和物品j装入背包。
 * 今天我们要做的题目是一个考虑特殊的成本结构的带冲突约束的0-1背包问题。
 * 在该问题中，问题输入包含一组大小为3的集合，并且每一个集合有一个惩罚值。
 * 给定一个集合S，如果一个背包方案中包含了这个集合S中两个或两个以上的商品，
 * 那么该背包的方案的总利润就要减去该集合S对应的惩罚。例如，有两个集合{1,2,3}和{3,4,5}构成，
 * 其中集合{1，2，3}对应的惩罚是10，{3，4，5}对应的惩罚是20,如果一个背包方案是{1,2,6,7,8}，
 * 由于该方案包含了集合{1，2，3}中的2个物品，那么该背包方案的利润应该减去集合{1,2,3}的惩罚，即10。
 */
public class problem1x {

    public static int[][] f;
    public static ArrayList<Integer> best_solution;
    public static int best_profit;
    public static int[] mark;

    public static class Punish {
        int punish1;
        int punish2;
        int punish3;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int Q = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];
        for(int i = 0; i < n; i ++) {
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        boolean[][] conflicts = new boolean[n][n];
        for(int i = 0; i < m; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            conflicts[a][b] = conflicts[b][a] = true;
        }

        Punish[] punishs = new Punish[s];
        int[] pm = new int[s];
        for(int i = 0; i < s; i ++) {
            punishs[i] = new Punish();
            punishs[i].punish1 = sc.nextInt();
            punishs[i].punish2 = sc.nextInt();
            punishs[i].punish3 = sc.nextInt();
            pm[i] = sc.nextInt();
        }

        best_profit = 0;
        best_solution = new ArrayList<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        mark = new int[n];
        dp(n, Q, w, p);
        dfs(n, Q, w, p, 0, 0, -1, conflicts, punishs, pm, path);

        System.out.println(best_profit);
    }

    public static void dfs(int n, int Q, int[] w, int[] p, int weight, int profit, int index, boolean[][] conflicts, Punish[] punishes, int[] pm, ArrayList<Integer> path) {
        if(profit + f[index + 1][Q - weight] <= best_profit) {
            return;
        }
        if(profit > best_profit){
            best_profit = profit;
            best_solution = new ArrayList<Integer>(path);
        }
        for(int i = index + 1; i < n; i ++) {
            if(weight + w[i] > Q){
                continue;
            }
            boolean feasible = true;
            for (Integer value : path) {
                if (conflicts[value][i]) {
                    feasible = false;
                    break;
                }
            }
            if(!feasible){
                continue;
            }
            path.add(i);
            int nextProfit = profit + p[i];
            int[] count = new int[punishes.length];
            if(path.size()>=2){
                for (Integer integer : path) {
                    for (int k = 0; k < punishes.length; k ++) {
                        if(integer == punishes[k].punish1) {
                            count[k] ++;
                        }
                        if(integer == punishes[k].punish2) {
                            count[k] ++;
                        }
                        if(integer == punishes[k].punish3) {
                            count[k] ++;
                        }
                    }
                }
            }
            for(int t = 0; t < punishes.length; t ++){
                if(count[t] >= 2 && mark[t] == 0){
                    mark[t] = 1;
                    nextProfit = nextProfit - pm[t];
                }
                if(count[t] < 2 && mark[t] == 1){
                    mark[t] = 0;
                }
            }
            dfs(n, Q, w, p, weight + w[i], nextProfit, i, conflicts, punishes, pm, path);
            path.remove(path.size() - 1);
        }
    }

    public static void dp(int n, int Q, int[] w, int[] p) {
        f = new int[n + 1][Q + 1];
        for(int i = n - 1; i >= 0; i --) {
            for(int j = 0; j <= Q; j ++) {
                if(w[i] > j) {
                    f[i][j] = f[i + 1][j];
                }else {
                    f[i][j] = Math.max(f[i + 1][j], f[i + 1][j - w[i]] + p[i]);
                }
            }
        }
    }
}
