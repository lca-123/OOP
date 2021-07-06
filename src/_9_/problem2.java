package _9_;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCity=sc.nextInt(),w=sc.nextInt(),curW=0;
        int[][] citys = new int[numOfCity][3];
        boolean[] isVistied = new boolean[numOfCity];
        //确定出发城市
        int start=0,maxAmount=Integer.MIN_VALUE;
        for (int i = 0; i < numOfCity; i++) {
            citys[i][0]=sc.nextInt();
            citys[i][1]=sc.nextInt();
            citys[i][2]=sc.nextInt();
            if(maxAmount<=citys[i][2]){
                start=i;
                maxAmount=citys[i][2];
            }
        }
        isVistied[start]=true;
        curW= Math.min(citys[start][2], w);
        int curS=start;
        //各城市间的距离
        double[][] dis = new double[numOfCity][numOfCity];
        for (int i = 0; i < numOfCity; i++) {
            for (int j = 0; j < numOfCity; j++) {
                dis[i][j]=Math.sqrt(Math.pow(citys[i][0]-citys[j][0],2)+Math.pow(citys[i][1]-citys[j][1],2));
            }
        }

//        for (int i = 0; i < numOfCity; i++) {
//            for (int j = 0; j < numOfCity; j++) {
//                System.out.printf("%.2f  ",dis[i][j]);
//            }
//            System.out.println();
//        }
        double res = 0;

        for (int j = 0; j < numOfCity - 1; j++) {
            double curDis=Double.MAX_VALUE;
            int disS=0;
            for (int i = 0; i < numOfCity ; i++) {
                if(!isVistied[i]&&curW+citys[i][2]>=0 && curW+citys[i][2]<= w && (dis[curS][i]<curDis)){
                    disS=i;
                    curDis=dis[curS][i];
                }
            }
            System.out.println(Arrays.toString(isVistied));
            System.out.println(disS);
            isVistied[disS]=true;
            curW=curW+citys[disS][2];
            res += curDis;
            curS=disS;
        }
        res += dis[curS][start];
        System.out.printf("%.2f",res);
    }

}
