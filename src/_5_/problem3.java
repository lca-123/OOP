package _5_;

import java.util.Scanner;

/**
 * 输入任意一个字符串，删除字符串中所有非字母字符然后输出。
 * @author lca
 */
public class problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String output="";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                output+=c;
            }
        }
        System.out.println(output);
    }
}
