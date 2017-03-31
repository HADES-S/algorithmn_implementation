import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2017/2/16.
 */
public class LH {
    public static ArrayList<Integer> app(ArrayList<Integer> use){
        int start = 0;
        boolean has =false;
        while(has==false){
            has = true;
            for (int i=0;i<use.size()-1;i++){
                int count = used(i,use);
                if(count>=3) {
                    has=false;
                    for(int j=0;j<count;j++){
                        use.remove(i);
                    }
                    break;
                }
            }
        }
        return use;
    }
    public static int used(int i,ArrayList<Integer> use){
        int start = i;
        int count =0;
        while(use.get(start)==use.get(i)){
            count++;
            start++;
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<15;i++)
            arr.add(sc.nextInt());
        ArrayList<Integer> arr2 = app(arr);
        for (int in =0 ;in<arr.size()-1;in++){
            System.out.print(arr.get(in)+" ");
        }
        System.out.println(arr.get(arr.size()-1));
    }
}
