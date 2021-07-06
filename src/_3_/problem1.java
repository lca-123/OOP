package _3_;

import java.util.Scanner;

/**
 * 取一个任意小于1美元的金额，然后换成尽可能少的硬币。硬币有1美分，5美分，10美分，25美分4种，1美元等于100美分。
 * 尽量用大面额硬币去做匹配。
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money=sc.nextDouble();
        int[] num = new int[4];
        double money2=100*money;
        while(money2>=25){
            num[0]++;
            money2-=25;
        }
        while(money2>=10){
            num[1]++;
            money2-=10;
        }
        while(money2>=5){
            num[2]++;
            money2-=5;
        }
        while(money2>=1){
            num[3]++;
            money2-=1;
        }
        System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3]);
    }
}
