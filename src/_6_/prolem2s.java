package _6_;

import java.util.Scanner;

/**
 * 生产线上有两台完全一样的机器需要处理一批零件，每一个零件一旦开始处理就不能停止，求处理完这批零件的最短时间。
 * @author lca
 */
public class prolem2s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int[] time=new int[num];
        for (int i = 0; i < num; i++) {
            time[i]=sc.nextInt();
        }
        System.out.println(getSmallTime(time,num));
    }

    public static int getSmallTime(int[] time, int len){
        int totaltime=0;
        for (int i = 0; i < len; i++) {
            totaltime+=time[i];
        }
        //0-1背包问题
//        int[][] res = new int[len +1][totaltime/2+1];
//        for (int i = 0; i <= len; i++) {
//            for (int j = 0; j <= totaltime/2; j++) {
//                if(i==0){
//                    res[i][j]=0;
//                }else if(j<time[i-1]){
//                    res[i][j]=res[i-1][j];
//                }else{
//                    res[i][j]=Math.max(res[i-1][j],res[i-1][j-time[i-1]]+time[i-1]);
//                }
//            }
//        }
        //优化背包问题
        int[] ans = new int[totaltime/2+1];
        for (int i = 0; i < len; i++) {
            for (int j = totaltime/2; j >= time[i]; j--) {
                ans[j] = Math.max(ans[j],ans[j-time[i]]+time[i]);
            }
        }
        return totaltime-ans[totaltime/2];
    }
}
