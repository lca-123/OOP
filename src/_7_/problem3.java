package _7_;

import java.util.Scanner;

/**
 * 编辑距离
 * @author lca
 */
public class problem3 {
    //abcdef
    //aacf
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1=sc.nextLine(),str2=sc.nextLine();
        int len1=str1.length(),len2=str2.length();
        int[][] ans = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            ans[i][0]=i;
        }
        for (int i = 0; i <= len2; i++) {
            ans[0][i]=i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }else{
                    int temp=Math.min(ans[i][j-1],ans[i-1][j-1]);
                    ans[i][j] = 1+ Math.min(ans[i-1][j],temp);
                }
            }
        }
        System.out.println(ans[len1][len2]);
    }
}
