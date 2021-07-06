package _9_;

import java.util.*;

public class problem1x {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int numOfItems = sc.nextInt();

        double[] values = new double[numOfItems];
        int[] weights = new int[numOfItems];
        double[] pv = new double[numOfItems];

        for (int i = 0; i < numOfItems; i++) {
            values[i] = sc.nextDouble();
            weights[i] = sc.nextInt();
            pv[i] = values[i] / weights[i];
        }
        quickSort(pv,weights,0,numOfItems-1);
        System.out.printf( "%.2f", bestMethod(pv, weights ,w) );
    }

    public static void quickSort(double[] arr,int[] weight,int low,int high){
        int i,j;
        double temp,t;
        int temp2,t2;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = arr[low];
        temp2 = weight[low];

        while (i<j) {
            while (temp >=arr[j] &&i<j) {
                j--;
            }
            while (temp <=arr[i] &&i<j) {
                i++;
            }
            if (i<j) {
                t = arr[j] ;arr[j] = arr[i];arr[i] = t ;
                t2 = weight[j]; weight[j] = weight[i]; weight[i] = t2;
            }

        }
        arr[low] = arr[i]; arr[i] = temp;
        weight[low] = weight[i]; weight[i] = temp2;

        quickSort(arr, weight, low, j-1);
        quickSort(arr, weight,j+1, high);
    }

    public static double bestMethod(double[] wi, int[] weight, int w)
    {
        int i=0;
        double totalValue = 0;
        while( w>0 ){
            if( w>= weight[i] ){
                totalValue += wi[i]*weight[i] ;
                w -= weight[i];
                i ++;
            }
            else{
                double per = 1.0 * w / weight[i];
                totalValue += wi[i]*weight[i] * per;
                break;
            }
        }
        return totalValue;
    }
}
