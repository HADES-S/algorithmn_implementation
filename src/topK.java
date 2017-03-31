
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/14.
 */
/*
public class topK {
    //int random;本来想用随机函数的，现在取第一个
    //类似快排的partition函数
    static int partition(ArrayList<Integer> arr,int start,int end,int k){
        int a=arr.get(start);
        int i = start+1,j=end;
        while(true){
            while(arr.get(i)-a<0){
                if(i==end)break;
                i++;
            }
            while(arr.get(j)-a>0){
                if(j==start)break;
                j--;
            }
            if(i>=j)break;
            int temp=arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
        }
        int temp=arr.get(j);
        arr.set(start,temp);
        arr.set(j,a);
        if(j==k)
            return arr.get(k-1);
        else{
            if(j>k)
            {
                return partition(arr,start,j-1,k);
            }else
            {
                return partition(arr,j+1,end,k+start-j);
            }
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        while (sc.hasNext()){
            String str = sc.next();
            arr.add(Integer.parseInt(str));
            if()
        }
        int result = partition(arr,0,arr.size()-1,k);
        System.out.println(result);
    }
}
*/