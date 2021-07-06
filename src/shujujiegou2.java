import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class shujujiegou2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 =scanner.next(),str2 = scanner.next();
        char[] chars1 = str1.toCharArray(),chars2 = str2.toCharArray();
        HashSet<Character> characters1 = new HashSet<>();
        int count=0;
        for (int i = 0; i < chars1.length; i++) {
            characters1.add(chars1[i]);
        }
        HashSet<Character> characters2 = new HashSet<>();
        for (int i = 0; i < chars2.length; i++) {
            characters2.add(chars2[i]);
        }
        for(char c:characters2){
            if(characters1.contains(c)){
                count++;
            }
        }
        System.out.println(count);
    }
}
