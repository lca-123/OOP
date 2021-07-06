package _5_;

import java.util.Scanner;

/**
 * 输入任意一个字符串，统计输入的字符串中英文字母、数字、空格和其他字符出现的次数。
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        int numLetter=0,numNum=0,numKong=0,other=0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if(Character.isLetter(c)){
                numLetter++;
            }else if(Character.isDigit(c)){
                numNum++;
            }else if(c==' '){
                numKong++;
            }else{
                other++;
            }
        }
        System.out.println(numLetter + " " + numNum + " " + numKong + " " + other);
    }
}
