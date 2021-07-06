import java.util.*;

public class shan {
    public static void main(String[] args) {
        int a,b,time=0;
        Scanner scanner = new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        Queue<Integer> queue= new LinkedList<>();
        queue.add(a);
        while(true){
            queue.add(-1);
            int temp;
            while((temp=queue.poll())!=-1){
                if(temp==b){
                    break;
                }
                if(temp-1>=0){
                    queue.add(temp-1);
                }
                if(temp+1<=20){
                    queue.add(temp+1);
                }
                if(temp*2<=20){
                    queue.add(temp*2);
                }
            }
            if(temp==b){
                break;
            }
            time+=1;
        }
        System.out.println(time);
    }
}
