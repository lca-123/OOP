package mid;

import java.util.*;

/**
 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到m报数），凡报到m的人退出圈子，
 * 问最后留下的是原来第几号的那位。人的下标从1开始，也就是第一个人的下标是1。
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int count=sc.nextInt();

        int p=0;
        for (int i = 2; i <= num; i++) {
            p=(p+count)%i;
        }
        System.out.println(p+1);
//
//        int cur=0;
//        boolean[] visited = new boolean[num];
//
//        for (int i = 0; i < num-1; i++) {
//            int count1=count;
//            while(count1>1) {
//                cur = (cur + 1) % num;
//                while (visited[cur]) {
//                    cur = (cur + 1) % num;
//                }
//                count1--;
//            }
//            visited[cur]=true;
//            cur = (cur +1)%num;
//            while(visited[cur]){
//                cur = (cur +1)%num;
//            }
//        }
//        for (int i = 0; i < num; i++) {
//            if(!visited[i]) {
//                System.out.println(i+1);
//            }
//        }
    }
}
