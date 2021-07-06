package _9_;

import java.util.*;

/**
 * Fractional Knapsack Problem
 * Read an integer W, which is the maximum allowed weight of a knapsack.
 * Read an integer n and then n items; each has a value (double) and a weight (integer).
 * Items can be divided into pieces. Solve the fractional knapsack problem and print total value of
 * packed items. Keep two decimals in final results. "%.2f"
 * Hint: greedy; n <= 60000
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w=sc.nextInt(),n=sc.nextInt();
        ArrayList<item> items = new ArrayList<>();
        double res=0;
        for (int i = 0; i < n; i++) {
            items.add(new item(sc.nextDouble(),sc.nextInt()));
        }
        Collections.sort(items);
        int index=0;
        while(w>0){
            item cur = items.get(index);
            if(cur.weight<=w) {
                res += cur.pv*cur.weight;
                w -= cur.weight;
            }else{
                res += cur.pv*w;
                break;
            }
            index++;
        }
        System.out.printf("%.2f",res);

    }
}
class item implements Comparable<item>{
    public int weight;
    public double pv;

    public item(double value,int weight){
        this.weight=weight;
        this.pv=value/weight;
    }

    @Override
    public int compareTo(item o) {
        return this.pv-o.pv>0?-1:1;
    }

    @Override
    public String toString() {
        return "item{" +
                ", weight=" + weight +
                ", pv=" + pv +
                '}';
    }
}