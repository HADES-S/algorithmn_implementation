import java.util.Scanner;

public class myClass {
    public static final int MOD = 100003;

    public static void main(String[] args){

        int m,n;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(getResult(m,n));
    }

    public static int getResult(int m,int n){
        int allIns = pow(m, n);
        int noBreak = m*pow(m-1, n-1)%MOD;
        return allIns>noBreak?allIns-noBreak:allIns-noBreak+MOD;
    }


    public static int pow(int n,int exp){
        if(exp==1){
            return n;
        }
        int num = pow(n, exp/2);
        int ans = num*num%MOD;
        if(exp%2==0){
            return ans;
        }else{
            return ans*n%MOD;
        }
    }

}