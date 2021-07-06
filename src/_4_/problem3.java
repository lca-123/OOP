package _4_;

/**
 * 两个乒乓球队进行比赛，各出三人。甲队为a，b，c三人，乙对为x，y，z三人。已抽签决定比赛名单。
 * 有人向队员打听比赛的名单。a说他不和x比赛，c说他不和x，z比赛，请编程找出三场比赛名单。
 * @author lca
 */
public class problem3 {
    public static void main(String[] args) {
        char[] arr= new char[]{'x','y','z'};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(i==j||j==k||k==i){
                        continue;
                    }else
                    if(i==0){
                        continue;
                    }else if(k==0||k==2){
                        continue;
                    }else{
                        System.out.println("a:"+arr[i]);
                        System.out.println("b:"+arr[j]);
                        System.out.println("c:"+arr[k]);

                    }
                }
            }
        }
    }
}
