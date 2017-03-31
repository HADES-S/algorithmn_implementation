import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/29.
 */
public class Father {
    public static ArrayList<Integer> in = new ArrayList<Integer>();
    static int[] d = new int[10000];
    static boolean[] vis = new boolean[10000];
    public static int getResult(int S){
        if(S==0)
            return 0;
        if(vis[S])return d[S];
        vis[S] = true;
        int ans  = d[S];
        for(int i=1;i<=in.size();i++){
            if(S>=in.get(i-1)){
                int temp = getResult(S-in.get(i-1));
                if(temp!=Integer.MAX_VALUE&&temp>=0)
                    ans = Math.min(ans,temp+1);
            }
        }
        d[S] = ans;
        return ans;
    }
    public static void main(String[] args) {
        Arrays.fill(d,Integer.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        String[] arr  =sc.next().split(",");
        for(String arr1:arr) {
            in.add(Integer.valueOf(arr1));
        }
        int need = sc.nextInt();
        int result = getResult(need);
        if(result == Integer.MAX_VALUE||in.size()==0||need<0||result==0)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}
