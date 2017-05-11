import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/5/5.
 */
public class FontSize {
    static int[] NL =new int[1001];
    static int sum=0;
    static double getPage(int N,int W,int H,int fontSize,int P){
        int Wnum = W/fontSize;
        if(Wnum==0)
            return P+1;
        int LSum = 0;
        for(int i=0;i<N;i++){
            LSum = LSum + (int)Math.ceil(NL[i]*(1.0)/Wnum);
        }
        double Pages = LSum/Math.floor(H*(1.0)/fontSize);
        return Pages;
    }
    public static int getSize(int N,int W,int H,int P){
        int Num = (int)Math.ceil(sum/P);
        Num = W*H/Num;
        for(int i=Num;;){
            if(P>=getPage(N,W,H,i,P))
                return i;
            else
                i--;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();
        for(int i =0 ;i<Num;i++){
            int N = sc.nextInt();
            int P = sc.nextInt();
            int W = sc.nextInt();
            int H = sc.nextInt();
            sum = 0;
            for(int j=0;j<N;j++){
                NL[j] = sc.nextInt();
                sum += NL[j];
            }
            System.out.println(getSize(N,W,H,P));
        }
    }
}
