import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/14.
 */
public class caiGou {
    static long[][] dp = new long[1000][1000];
    static int[] P ;
    static int[] V ;
    long rec(int i ,int j) {
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        int res;
        if (i == P.length)
            res = 0;
        return dp[i][j];
   }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int B=scanner.nextInt();
        int[] P = new int[100001];
        int[] V = new int[100001];
        int flag = 0;
        int Min = 0;
        int loc = -1;
        while (scanner.hasNextInt()) {
            P[flag] = scanner.nextInt();
            V[flag] = scanner.nextInt();
            flag++;
        }
    }


}
