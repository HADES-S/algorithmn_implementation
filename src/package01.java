import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/1.
 */
public class package01 {
    static int[] need ;
    static int[] value;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        value = new int[N+10];
        need = new int[N+10];
        int[][] dp = new int[N+1][M+1];
        for(int i=0;i<N;i++){
            need[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        for(int i=0;i<=M;i++)
            dp[N][i]=0;
        //这里的递归式是从第i个物品开始挑选，总重小于j
        for(int i=N-1;i>=0;i--)
            for(int j=0;j<=M;j++){
                if(j>=need[i])
                    dp[i][j]=Math.max(dp[i+1][j],dp[i+1][j-need[i]]+value[i]);
                else
                    dp[i][j] = dp[i+1][j];
            }
        System.out.println(dp[0][M]);
    }
}
