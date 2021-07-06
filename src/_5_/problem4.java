package _5_;

import java.util.Scanner;

/**
 * 约瑟夫(Joseph)问题的一种描述是：编号为1，2，…，n的n个人按顺时针方向围坐一圈，每人持有一个密码(正整数)。
 * 一开始任选一个正整数作为报数上限值m，从第一个人开始按顺时针方向自1开始顺序报数，报到m时停止报数。
 * 报m的人出列，将他的密码作为新的m值，从他在顺时针方向上的下一个人开始重新从1报数，
 * 如此下去，直至所有人全部出列为止。试设计一个程序求出出列顺序。
 * @author lca
 */
public class problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=sc.nextInt(),num=sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]=sc.nextInt();
        }

        int cur=0,out=0;
        boolean[] visited = new boolean[num];
        int[] output = new int[num];
        for (int i = 0; i < num-1; i++) {
            while(count>1){
                cur = (cur +1)%num;
                while(visited[cur]){
                    cur = (cur +1)%num;
                }
                count--;
            }
            output[out++]=cur;
            visited[cur]=true;
            count=arr[cur];
            cur = (cur +1)%num;
            while(visited[cur]){
                cur = (cur +1)%num;
            }
        }
        int loop=0;
        while(visited[loop]){
            loop++;
        }
        output[out]=loop;
        for (int value : output) {
            System.out.println(value + 1);
        }
    }
}
