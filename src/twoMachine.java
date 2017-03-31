import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/28.
 */
public class twoMachine {
    public static int getLimited(ArrayList<Integer> arr){
        if(arr.size()==0)
            return 0;
        if(arr.size()==1)
            return arr.get(0);
        if(arr.size()==2)
            return Math.max(arr.get(0),arr.get(1));
        while (arr.size()>2){
            int first = arr.get(0);
            int fLoc = 0;
            int second =arr.get(1);
            int sLoc = 1;
            if(first>second)
            {
                int temp = first;
                first = second;
                second = temp;
                temp = fLoc;
                fLoc = sLoc;
                sLoc = temp;
            }
            for(int i=3;i<arr.size();i++){
                if(arr.get(i)<first)
                {
                    second=first;
                    first = arr.get(i);
                    sLoc = fLoc;
                    fLoc = i;
                }else if(arr.get(i)<second){

                    second = arr.get(i);
                    sLoc = i;
                }
            }
            arr.add(arr.get(fLoc)+arr.get(sLoc));
            System.out.println(arr.get(fLoc)+arr.get(sLoc));
            arr.remove(fLoc);
            arr.remove(sLoc);
        }
        if(arr.size()==2)
        {
            return Math.max(arr.get(0),arr.get(1));
        }else {
            return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i= 0;i<N;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(getLimited(arr));
    }
}
