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
    }
}
