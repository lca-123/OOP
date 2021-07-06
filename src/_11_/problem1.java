package _11_;

import java.util.Scanner;

/**
 * 给定一个数组，一个下限和一个上限，求有多少个不同的区间使得每个区间的和在给定的上下限之间。
 * @author lca
 */
public class problem1 {
    public static int numOfSection=0;
    public static int down;
    public static int up;
    public static int num;
    public static int[] arr;
    public static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        down=sc.nextInt();
        up = sc.nextInt();
        arr = new int[num];
        sum = new int[num+1];
        for (int i = 0; i < num; i++) {
            arr[i]=sc.nextInt();
            sum[i+1]=sum[i]+arr[i];
        }
        numOfSection = mergeCount(0,num);
        System.out.println(numOfSection);
    }

    public static int mergeCount(int left,int right){
        if(left == right){
            return 0;
        }else{
            int mid = (left + right)/2;
            int ret1 = mergeCount(left,mid);
            int ret2 = mergeCount(mid+1,right);
            int ret = ret1 + ret2;

            int i=left,l=mid+1,r=mid+1;
            while(i <= mid){
                while(l <= right && sum[l]-sum[i] < down){
                    l++;
                }
                while(r <= right && sum[r] - sum[i] <= up){
                    r++;
                }
                ret += r - l;
                i++;
            }

            int[] sorted = new int[right - left + 1];
            int i1 = left,i2 = mid + 1,j=0;
            while(i1 <= mid && i2 <= right){
                if(sum[i1]<sum[i2]){
                    sorted[j++]=sum[i1++];
                }else{
                    sorted[j++]=sum[i2++];
                }
            }
            while(i1 <= mid){
                sorted[j++]=sum[i1++];
            }
            while(i2 <= right){
                sorted[j++]=sum[i2++];
            }

            if (sorted.length >= 0) {
                System.arraycopy(sorted, 0, sum, left, sorted.length);
            }

            return ret;
        }
    }

}
