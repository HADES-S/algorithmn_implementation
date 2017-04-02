import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/2.
 */
public class FindMax {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger[] Num = new BigInteger[100002];
        for(int i=0;i<N;i++){
            int M = sc.nextInt();
            for(int j=0;j<M;j++){
                Num[j]= sc.nextBigInteger();
            }
            BigInteger Max = BigInteger.valueOf((long)0);
            for(int i2=0;i2<M;i2++)
                for (int j2=i2+1;j2<M;j2++){
                    BigInteger a = Num[i2].and(Num[j2]);
                    if(Max.compareTo(Num[i2].multiply(Num[j2]).multiply(a))<0)
                        Max=Num[i2].multiply(Num[j2]).multiply(a);
                }
            System.out.println(Max);
        }
    }
}
