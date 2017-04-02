import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/2.
 */
public class Matrix_diverse {
    static int[] intX1 ={0,1,-1,0};
    static int[] intY1 ={-1,0,0,1};
    static int M;
    static int N;
    static boolean[][] dp;
    public static void dfs(int i,int j){
        dp[i][j]=true;
        for(int d=0;d<4;d++){
            if(i+intX1[d]<3*N&&j+intY1[d]<3*M&&i+intX1[d]>=0&&j+intY1[d]>=0&&dp[i+intX1[d]][j+intY1[d]]==false){
                dfs(i+intX1[d],j+intY1[d]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         N = sc.nextInt();
         M = sc.nextInt();
        sc.nextLine();
        dp = new boolean[3*(N + 1)][3*(M + 1)];
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                //System.out.println(temp.charAt(j));
                if (temp.charAt(j) == '\\' )
                    dp[3*i][3*j] = dp[3*i+1][3*j+1]=dp[3*i+2][3*j+2]=true;
                else if (temp.charAt(j) == '/' )
                    dp[3*i+2][3*j] = dp[3*i+1][3*j+1]=dp[3*i][3*j+2]=true;

            }
        }
        int sum=0;
        for(int i=0;i<3*N;i++)
            for(int j=0;j<3*M;j++){
                if(dp[i][j]==false)
                {
                    sum++;
                    dfs(i,j);
                }
            }
        System.out.println(sum);

    }
}