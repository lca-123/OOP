package _4_;

import java.util.*;

/**
 * 分解质因数
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        int num1=num;
        int div=1;
        ArrayList<Integer> arr = new ArrayList<>();
        while(num!=1){
            div++;
            while(num%div==0){
                arr.add(div);
                num/=div;
            }
        }
        System.out.print(num1 + "=" + arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            System.out.print("*"+arr.get(i));
        }
    }
}
