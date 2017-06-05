import java.util.HashMap;

/**
 * Created by Administrator on 2017/5/26.
 */
public class jailbreak2 {

    public static long fastMode(long m,long n,long mod){
        long res = 1;
        while (n>0){
            if((n&1)==1)
                res = (res*m)%mod;
            m = (m*m)%mod;
            n = n>>1;

        }
        return res;
    }
    public static long getResult(long m,long n){
        if(m==0||n==0)
            return 0;
        if(m==1||n==1)
            return 0;
        long start = fastMode(m,n,100003);
        long end = fastMode(m-1,n-1,100003);
        return (start*100003-m*end);
    }
    public static void main(String[] args){

        int m =5,n=12;
        System.out.println(getResult(m,n));
    }
}
