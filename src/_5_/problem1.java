package _5_;

import java.util.Scanner;

/**
 * 输入任意一个字符串，统计输入的字符串中单词的个数，单词之间用空格分隔。
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int count=0;
        for (String s : arr) {
            if (!"".equals(s) && !(s.length() == 1 && !Character.isLetter(s.charAt(0)))) {
                count++;
            }
        }
        System.out.println(count);

        //System.out.println(countLetter("\t\ta    aad   !"));
    }

    public static int countLetter(String str){
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isLetter(aChar) || (aChar == ' ')) {
                res.append(aChar);
            } else {
                res.append(' ');
            }
        }
        //System.out.println(Arrays.toString(res.toString().split(" ")));
        int count=0;
        for(String item: res.toString().split(" ")){
            if(!"".equals(item)){
                count++;
            }
        }
        return count;
    }
}
