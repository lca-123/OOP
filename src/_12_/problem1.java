package _12_;

import java.util.*;

/**
 * 逆序数对
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]=sc.nextInt();
        }
        int[] temp = new int[num];
        System.out.println(divide(arr,0,num-1,temp));

    }

    public static int divide(int[] arr, int left, int right, int[] temp){
        if(left == right) {
            return 0;
        }

        int mid = (left + right)/2;
        int leftNum = divide(arr,left,mid,temp),rightNum = divide(arr,mid+1,right,temp);
        if(arr[mid] <= arr[mid+1]){
            return leftNum + rightNum;
        }
        int mergeNum = merge(arr,left,mid,right,temp);
        return leftNum+rightNum+mergeNum;
    }

    public static int merge(int[] arr,int left,int mid,int right,int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i]=arr[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {
            if(i == mid + 1){
                arr[k]=temp[j];
                j++;
            }
            else if(j == right + 1){
                arr[k]=temp[i];
                i++;
            }
            else if(temp[i]<=temp[j]){
                arr[k]=temp[i];
                i++;
            }else{
                arr[k]=temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
