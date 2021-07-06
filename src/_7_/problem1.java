package _7_;

import java.util.*;

/**
 * 所谓回文字符串，就是一个字符串，从左到右读和从右到左读是完全一样的，比如"aba"。
 * 当然，我们给你的问题不会再简单到判断一个字符串是不是回文字符串。
 * 现在要求你，给你一个字符串，可在任意位置添加字符，最少再添加几个字符，可以使这个字符串成为回文字符串。
 * @author lca
 */

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(method2(str));
    }

    //动态规划
    public static int method2(String str1){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(str1.length()-1-i));
        }
        String str2=sb.toString();
        int[][] arr= new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i <=str1.length(); i++) {
            for (int j = 1; j <=str2.length(); j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return str1.length()-arr[str1.length()][str1.length()];
    }

    //递归求解
    public static int method(String str){
        if(str.length()<=2){
            if(str.length()==2){
                return str.charAt(0)==str.charAt(1)?0:1;
            }
            return 0;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){
            return method(str.substring(1,str.length()-1));
        }else {
            return Math.min(method(str.substring(0, str.length() - 1)), method(str.substring(1))) + 1;
        }
    }

}
