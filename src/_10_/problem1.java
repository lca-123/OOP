package _10_;

import java.util.*;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组。一个岛屿是由一些相邻的1(代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。假设数组的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i != map.length; ++i) {
            for (int j = 0; j != map[0].length; ++j) {
                ans = Math.max(ans, dfs(map, i, j));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int[][] map, int curI, int curJ) {
        if (curI < 0 || curJ < 0 || curI == map.length || curJ == map[0].length || map[curI][curJ] != 1) {
            return 0;
        }
        map[curI][curJ] = 0;
        int[] ix = {0, 0, 1, -1};
        int[] jx = {1, -1, 0, 0};
        int ans = 1;
        for (int i = 0; i != 4; ++i) {
            int nextI = curI + ix[i], nextJ = curJ + jx[i];
            ans += dfs(map, nextI, nextJ);
        }
        return ans;
    }
}




