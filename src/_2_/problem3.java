package _2_;

import java.util.Scanner;


/**
 * 取一个整数a从右端开始的4～7位构成的整数。例如，假如a=100，则有a从右端开始的4~7位构成的整数为12。
 * @author lca
 */
public class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = Integer.toBinaryString(num);
        int len = str.length();
        for (int i = 0; i < 7- len; i++) {
            str = "0" + str;
        }
        str = str.substring(str.length()-7,str.length()-3);
        System.out.println(Integer.valueOf(str,2));
    }
}
