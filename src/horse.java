import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/15.
 */
public class horse {
    public static double getName(int N){
        double[] f = new double[1001];
        double sum=0;
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=N;i++){
            sum=0;
            for(int j=1;j<=i;j++){
                sum = sum+(f[i-j]+1);
            }
            f[i] = sum/i;
        }
        return f[N];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DecimalFormat df = new DecimalFormat("0.0000");
        String result = df.format(getName(N));
        System.out.println(result);
    }
}
