import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Jump {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        while(in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            int[] a = solveDP(n,m);
            for (int i:a){
                System.out.println(i);
            }
        }

    }
    private static int[] solveDP(int n,int m){
        int[] dp = new int[m+1]; // 到达 i位置需要的最小步数
        if(m==n)
            return null;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for(int i=n;i<=m;i++){
            if(dp[i] == Integer.MAX_VALUE){ // 该位置不能像前走
                dp[i] = 0;
                continue;
            }
            ArrayList<Integer> gcd = getList(i);
            for(int j=0;j<gcd.size();j++){
                int x = gcd.get(j);
                if(i+x<=m) // 记录向前走的长度，保留最小的步数
                    dp[i+x] = Math.min(dp[i+x], dp[i] + 1);
            }
        }
        return dp;
    }
    // 求因数 时间复杂度 sqrt（n） 很强大
    public static ArrayList<Integer> getList(int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i*i<=k;i++){
            if(k%i ==0){
                if(i!=1&&i!=k)
                    list.add(i);
                if((i*i)!=k&&(k/i)!=1&&(k/i)!=k)
                    list.add(k/i);
            }
        }
        return list;
    }
}