package _9_;

import java.util.*;

/**
 * 旅行推销员问题（最短路径问题）（英语：Travelling salesman problem, TSP）是这样一个问题：
 * 给定一系列城市和每对城市之间的距离，求解访问每一座城市一次并回到起始城市的最短回路。
 * 它是组合优化中的一个NP困难问题，在运筹学和理论计算机科学中非常重要。
 * 现在我们考虑一个取货送货推销员问题，即除了第一个节点外，每个节点都有一个货物量，
 * 正数表示该节点能够提供的货物量，复数表示该节点需要的货物量。
 * 同时，车辆有容量限制，即在任何节点，车辆所载的货物量不能超过车辆的容量。
 * 问题要求计算出将货物从取货点送往收货点的最短的路径的长度。
 * @author lca
 */
public class problem2x {

    public static double[][] dis;
    public static double minCost=Double.MAX_VALUE;
    public static int numOfCity;
    public static int w;
    public static int[][] citys;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        numOfCity=sc.nextInt();
        w=sc.nextInt();
        citys = new int[numOfCity][3];


        for (int i = 0; i < numOfCity; i++) {
            citys[i][0]=sc.nextInt();
            citys[i][1]=sc.nextInt();
            citys[i][2]=sc.nextInt();
        }
        dis = new double[numOfCity][numOfCity];
        for (int i = 0; i < numOfCity; i++) {
            for (int j = 0; j < numOfCity; j++) {
                dis[i][j]=Math.sqrt(Math.pow(citys[i][0]-citys[j][0],2)+Math.pow(citys[i][1]-citys[j][1],2));
            }
        }
        for (int i = 0; i < numOfCity && citys[i][2]>=0; i++) {
            boolean[] isVistied = new boolean[numOfCity];
            isVistied[i]=true;
            tsp(isVistied,0,i,0,citys[i][2],i);
        }
        System.out.printf("%.2f",minCost);
    }

    public static void tsp(boolean[] isVisited, int curEdge, int curCity, double curCost, int curW, int start){
        if(numOfCity-1 == curEdge){
            curCost += dis[curCity][start];
            minCost = Math.min(minCost,curCost);
        }
        for(int i=0;i<numOfCity;i++){
            if(!isVisited[i] && curW + citys[i][2]>=0 && curW + citys[i][2]<=w){
                boolean[] newIsVisited = Arrays.copyOf(isVisited,isVisited.length);
                newIsVisited[i]=true;
                tsp(newIsVisited,curEdge+1,i,curCost+dis[curCity][i],curW + citys[i][2],start);
            }
        }
    }
}
