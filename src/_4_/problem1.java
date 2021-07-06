package _4_;

/**
 * 一个整数，它加上100后是一个完全平方数，再加上168后又是一个完全平方数，请问该数是多少？
 * @author lca
 */
public class problem1 {
    public static void main(String[] args) {
        for (int i = 1;i<1000000; i++) {
            if(Math.pow((int)Math.sqrt(i+100),2)==i+100&&Math.pow((int)Math.sqrt(i+168),2)==i+168){
                System.out.print(i);
            }
        }
    }
}
