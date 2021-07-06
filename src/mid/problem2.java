package mid;

import java.util.Scanner;

/**
 * 输出两个字符串num1和num2，分别表示两个正整数，输出这两个正整数num1和num2之和。
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1=sc.next(),str2=sc.next();
        int len = Math.max(str1.length(),str2.length())+1;
        int[] num1 =new int[len];
        int[] num2 =new int[len];
        int[] ans = new int[len];
        for (int i = 0; i < str1.length(); i++) {
            num1[str1.length()-i-1]=str1.charAt(i)-'0';
        }
        for (int i = 0; i < str2.length(); i++) {
            num2[str2.length()-i-1]=str2.charAt(i)-'0';
        }
        int p=0;
        for (int i = 0; i < len; i++) {
            ans[i] += num1[i]+num2[i];
            p=ans[i]/10;
            ans[i] %= 10;
            if(p>0){
                ans[i+1]+=p;
            }
        }

        String res = "";
        int loop = len-1;
        while(loop >=1 && ans[loop]==0){
            loop--;
        }
        while (loop >= 0) {
            res += ans[loop--];
        }
        System.out.println(res);
    }
}
