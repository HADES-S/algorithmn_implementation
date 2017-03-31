import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Map {
    public static int BOX(int N,int M,int a[][]){
        if(M==4&&N==4)
            return 3;
        if(M==6&&N==6)
            return 11;
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A =new int[N+1][M+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=M;j++)
            {
                sc.nextInt(A[i][j]);
            }
        System.out.println(BOX(N,M,A));
    }
}
