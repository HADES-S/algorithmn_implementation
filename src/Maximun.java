import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/15.
 */
public class Maximun {
    static int N,M;
    public static int maximun(int N,int M,int square[][]){
        if(N<M||N==0||M==0){//特殊情况判断  数组从一开始
            return 0;
        }
        int result=0;
        for(int i=1;i<=N;i++){
            for (int j=0;j<=N-M+1;j++){
                if(result<getLine(i,j,square,M))
                    result = getLine(i,j,square,M);
            }
        }
        for(int i=1;i<=N-M+1;i++){
            for (int j=0;j<=N;j++){
                if(result<getoff(i,j,square,M))
                    result = getoff(i,j,square,M);
            }
        }

        for(int i=1;i<=N-M+1;i++){
            for (int j=0;j<=N-M+1;j++){
                if(result<getsecond(i,j,square,M))
                    result = getsecond(i,j,square,M);
            }
        }
        for (int i=1;i<=N-M+1;i++){
            for(int j=N;j>=M;j--){
                if(result<getthird(i,j,square,M))
                    result = getthird(i,j,square,M);
            }
        }
        return result;
    }
    static int getLine(int i,int j,int square[][],int M){
        int point = j;
        int score = 0;
        while((point-j+1)<=M){
            score=score+square[i][point];
            point++;
        }
        return score;
    }
    static int getoff(int i,int j,int square[][],int M){
        int point = i;
        int score = 0;
        while ((point-i+1)<=M){
            score = score + square[point][j];
            point++;
        }
        return score;
    }
    static int getsecond(int i,int j,int square[][],int M){
        int point1 = i,point2 = j;
        int score = 0;
        while ((point1-i+1)<=M&&(point2-j+1)<=M){
            score = score +square[point1][point2];
            point1++;
            point2++;
        }
        return score;
    }
    static int getthird(int i,int j,int square[][],int M){
        int point1 = i,point2 = j;
        int score = 0;
        while((point1-i+1)<=M&&(j-point2+1)<=M){
            score = score + square[point1][point2];
            point1++;
            point2--;
        }
        return score;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int square[][] = new int[101][101];
        int N = sc.nextInt();
        int M = sc.nextInt();
        for(int i=1;i<=N;i++) {
            for (int j = 1; j <= N; j++) {
                square[i][j] = sc.nextInt();
            }
        }
        int result = maximun(N,M,square);
        System.out.println(result);
        }
}
