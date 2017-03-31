import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 */
public class BlackString {
    public static BigInteger Num(int n){
        BigInteger[] dp1 = new BigInteger[1000];
        BigInteger[] dp2 = new BigInteger[1000];
        Arrays.fill(dp1,BigInteger.valueOf(0));
        Arrays.fill(dp2,BigInteger.valueOf(0));
        dp1[2]=BigInteger.valueOf(3);
        dp2[2]=BigInteger.valueOf(6);
        int i=2;
        while(i<n+1){
            dp1[i+1] = dp1[i].add(dp2[i]);
            dp2[i+1] = dp1[i].multiply(BigInteger.valueOf(2)).add(dp2[i]);
            i++;
        }
        return dp1[n].add(dp2[n]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(Num(n));
        }
    }
}
