import java.util.Arrays;

public class LGS {

    public static void main(String[] args) {
        String str1="GDBFHFJDFNDN",str2="ASJDHHDU";
        int[][] arr= new int[str1.length()+1][str2.length()+1];
        String[][] str = new String[str1.length()+1][str2.length()+1];
        for (int i = 0; i <=str1.length(); i++) {
            for (int j = 0; j <=str2.length(); j++) {
                str[i][j]="";
            }
        }

        for (int i = 1; i <=str1.length(); i++) {
            for (int j = 1; j <=str2.length(); j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                    str[i][j]=str[i-1][j-1]+str1.charAt(i-1);
                }else{
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                    str[i][j]=arr[i-1][j]>arr[i][j-1]?str[i-1][j]:str[i][j-1];
                }
            }
        }

        //回溯出最大公共串
        int p=str1.length(),q=str2.length();
        String res="";
        while(p>0&&q>0){
            if(str1.charAt(p-1)==str2.charAt(q-1)){
                res = str1.charAt(p-1)+res;
                p--;
                q--;
            }else if (arr[p-1][q]>arr[p][q-1]){
                p--;
            }else{
                q--;
            }
        }
        System.out.println(res);
        System.out.println(str[str1.length()][str2.length()] + " size = " + arr[str1.length()][str2.length()]);
    }

}
