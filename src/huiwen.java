import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/13.
 */
public class huiwen {
    public static int Huiwen(int N, LinkedList<Integer> arr){
        int time =0;
        int point1=0,point2=N-1;
        while (point2-point1>1){
            if(arr.get(point1)>arr.get(point2)){
                arr.set(point2-1,arr.get(point2)+arr.get(point2-1));
                //arr.remove(point2);
                point2--;
                time++;
            }else if (arr.get(point1)<arr.get(point2)){
                arr.set(point1+1,arr.get(point1)+arr.get(point1+1));
                //arr.remove(point1);
                point1++;
                time++;
            }
            else {
                point1++;
                point2--;
            }
        }
        if(point2-point1==1&&!arr.get(point1).equals(arr.get(point2))){
            System.out.println(arr.get(point1)+" "+arr.get(point2));
            time++;
        }
        return time;
    }
    public static void main(String args[]){
        LinkedList<Integer> list = new LinkedList<Integer>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i=0;i<N;i++){
            list.add(scan.nextInt());
        }
        int time = Huiwen(N,list);
        System.out.println(time);
    }
}