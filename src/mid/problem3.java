package mid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给你一个字符串num和一个整数k 。其中，num 表示一个很大的整数，字符串中的每个字符依次对应整数上的各个数位 。
 * 你可以交换这个整数相邻数位的数字 最多k次。请你返回你能得到的最小整数，并以字符串形式返回。
 * @author lca
 */
public class problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        int k=sc.nextInt();
      System.out.println(method(numStr,k));

//        int h=0;
//        while(k>0){
//            char minNum='9' + 1;
//            int minL=h;
//            for (int i = h; i <= k+h && i<numStr.length(); i++) {
//                if(numStr.charAt(i)<minNum){
//                    minNum=numStr.charAt(i);
//                    minL=i;
//                }
//            }
//            if(minL!=h){
//                numStr = numStr.substring(0, h) + minNum + numStr.substring(h, minL) + numStr.substring(minL+1);
//                int step = minL - h;
//                k-= step;
//                h++;
//            }else{
//                break;
//            }
//        }
//        System.out.println(numStr);
    }



    public static String method(String num, int k) {
        int n = num.length();
        if (k == 0 || num.length() == 1) {
            return num;
        }
        if (k >= n*(n - 1) / 2) {
            char[] numToChar = num.toCharArray();
            Arrays.sort(numToChar);
            StringBuilder ans = new StringBuilder();
            for (char s : numToChar) {
                ans.append(s);
            }
            return ans.toString();
        }
        int i = 1;
        int index = 0;
        char a = num.charAt(0);
        while (i < n && i <= k) {
            if (num.charAt(i) < a) {
                a = num.charAt(i);
                index = i;
            }
            i++;
        }
        return a + method(num.substring(0, index) + num.substring(index + 1), k - index);
    }



}
