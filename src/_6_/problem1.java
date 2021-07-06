package _6_;

import java.util.*;

/**
 * 给定一个数塔，其存储形式为如下所示的下三角矩阵。
 * 在此数塔中，从顶部出发，在每一节点可以选择向左下走还是向右下走，一直走到底层。
 * 请找出一条路径，使路径上的数值和最大。
 *              9
 *           12    15
 *        10    6      8
 *     21    8      9     5
 * 19     7     10     4     16
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len=sc.nextInt();
        int[][] tower = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                tower[i][j]=sc.nextInt();
            }
        }
        for (int i =len-2; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                tower[i][j] += Math.max(tower[i+1][j],tower[i+1][j+1]);
            }
        }
        System.out.println(tower[0][0]);
    }
}
