package _6_;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    static int mintime=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] time=new int[num];
        for (int i = 0; i < num; i++) {
            time[i]=sc.nextInt();
        }
        method(time,num,0,0,0);
        System.out.println(mintime);
    }

    public static void method(int[] time,int num,int cur,int one,int two){
        if(cur==num){
            int curtime=Math.max(one,two);
            mintime=Math.min(mintime,curtime);
        }else{
            method(time,num,cur+1,one+time[cur],two);
            method(time,num,cur+1,one,two+time[cur]);
        }
    }
}
