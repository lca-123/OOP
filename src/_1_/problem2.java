package _1_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(sc.nextInt());
        }
        Collections.sort(integers);
        System.out.println(integers.get(n-1)+integers.get(n-2));
        //这里是王天翼添加的无用信息
        //我又加了一条无用信息
    }
}
