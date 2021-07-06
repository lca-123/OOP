package _12_;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class problem2x {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            points[i].x=sc.nextInt();
            points[i].y=sc.nextInt();
        }

        Point[] res = closest(points);
        double ans = Math.sqrt(Math.pow(res[0].x-res[1].x,2)+Math.pow(res[0].y-res[1].y,2));
        System.out.printf("%.2f",ans);
    }

    public static Point[] closest(Point[] points){
        Point[] result = new Point[2];
        int minX = (int)Double.MIN_VALUE,maxX = (int)Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if(points[i].x < minX){
                minX = points[i].x;
            }
            if(points[i].x > maxX){
                maxX = points[i].x;
            }
        }
        int midX = (minX + maxX)/2;

        ArrayList<Point> P1 = new ArrayList<>();
        ArrayList<Point> P2 = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if(points[i].x<=midX){
                P1.add(points[i]);
            }else{
                P2.add(points[i]);
            }
        }

        Point[] p1 = new Point[P1.size()];
        Point[] p2 = new Point[P2.size()];

        P1.toArray(p1);
        P2.toArray(p2);

        mergeSort(p1,"x");
        mergeSort(p2,"x");

        Point[] result1 = new Point[2];
        result1 = closest(p1);

        Point[] result2 = new Point[2];
        result2 = closest(p2);

        double d1 = Math.sqrt(Math.min(Math.pow(result1[0].x - result1[1].x, 2) + Math.pow(result1[0].y - result1[1].y, 2),
                Math.pow(result2[0].x - result2[1].x, 2) + Math.pow(result2[0].y - result2[1].y, 2)));
        if(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2) <
                Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2)) {
            result = result1;
        } else {
            result = result2;
        }

        ArrayList<Point> P3 = new ArrayList<>();
        ArrayList<Point> P4 = new ArrayList<>();

        for (Point value : p1) {
            if (midX - value.x < d1) {
                P3.add(value);
            }
        }
        for (Point point : p2) {
            if (point.x - midX < d1) {
                P4.add(point);
            }
        }

        Point[] p3 = new Point[P3.size()];
        Point[] p4 = new Point[P4.size()];
        P3.toArray(p3);
        P4.toArray(p4);

        mergeSort(p3,"y");
        mergeSort(p4,"y");

        double d = Double.MAX_VALUE;

        for (int i = 0; i < p3.length; i++) {
            for (int j = 0; j < p4.length; j++) {
                if(Math.abs(p3[i].y - p4[j].y)<d1){
                    double tmp = Math.sqrt(Math.pow(p3[i].x-p4[j].x,2)+Math.pow(p3[i].y-p4[j].y,2));
                    if(tmp < d){
                        d = tmp;
                        result[0]=p3[i];
                        result[1]=p4[j];
                    }
                }
            }
        }

        return result;
    }

    public static void mergeSort(Point[] points,String property){
        Point[] temp = new Point[points.length];
        mergeSort(points,temp,0,points.length-1,property);
    }

    public static void mergeSort(Point[] points, Point[] temp, int left ,int right, String property){
        if(left < right){
            int mid = (left + right)/2;

            mergeSort(points,temp,left,mid,property);
            mergeSort(points,temp,mid+1,right,property);

            merge(points,temp,left,mid + 1,right,property);
        }
    }

    public static void merge(Point[] points,Point[] temp, int left, int mid,int right,String property){
        int leftEnd = mid - 1;
        int numOf = right - left + 1;

        int t = left;

        while(left <= leftEnd && mid <= right){
            if(property.equals("x")){
                if(points[left].x <= points[mid].x){
                    temp[t++] = points[left++];
                }else{
                    temp[t++] = points[mid++];
                }
            }else{
                if(points[left].y <= points[mid].y){
                    temp[t++] = points[left++];
                }else{
                    temp[t++] = points[mid++];
                }
            }
        }

        while(left <= leftEnd){
            temp[t++] = points[left++];
        }
        while(mid <= right){
            temp[t++] = points[mid++];
        }

        System.arraycopy(temp,right - numOf + 1,points,right - numOf + 1,numOf);
    }
}
