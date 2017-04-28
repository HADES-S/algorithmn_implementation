import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/8.
 */
public class Diligent_Robot {
    public static int N,Q;
    public static int[][] dp;
    public int dp(int N2,int K2){
        if(dp[N2][K2]!=Integer.MAX_VALUE){
            return dp[N2][K2];
        }
        int Max=Integer.MAX_VALUE;
        for(int i=1;i<=K2/2;i++)
        {
            if(N-Q*(K2-2*i)>=0){
                int temp = dp(N-Q*(K2-2*i),K2-i)+Q;
                Max = Max<temp?Max:temp;
            }
        }
        int temp = dp(N-K2,K2)+1;
        Max = Max<temp?Max:temp;
        dp[N2][K2]=Max;
        return Max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //任务个数
        Q = sc.nextInt(); //生个机器人要多久
        dp = new int[N][N/2];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<N/2;i++)
        {
            dp[0][i]=0;
            dp[1][i]=1;
        }
    }
}
