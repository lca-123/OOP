package mid;

import java.util.*;

public class problem3x {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        int k=sc.nextInt();
        System.out.println(method(numStr,k));
    }
    public static String method(String num, int k) {
        int n = num.length();
        Queue<Integer>[] loc = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            loc[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            loc[num.charAt(i) - '0'].offer(i + 1);
        }
        StringBuilder ans = new StringBuilder();
        treeArr arr = new treeArr(n);
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (!loc[j].isEmpty()) {
                    int behind = arr.query(loc[j].peek() + 1, n);
                    int dist = loc[j].peek() + behind - i;
                    if (dist <= k) {
                        arr.update(loc[j].poll());
                        ans.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

}

class treeArr {
    int n;
    int[] tree;

    public treeArr(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public void update(int x) {
        while (x <= n) {
            ++tree[x];
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    public int query(int x, int y) {
        return query(y) - query(x - 1);
    }
}
