package _3_;

/**
 * 水仙花数
 * @author lca
 */
public class problem2 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            //int a=i%10,b=i/10%10,c=i/100;
            int a = Integer.parseInt(Integer.toString(i).substring(0,1));
            int b = Integer.parseInt(Integer.toString(i).substring(1,2));
            int c = Integer.parseInt(Integer.toString(i).substring(2,3));
            

            if(i==Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)){
                System.out.println(i);
            }
        }
    }
}
