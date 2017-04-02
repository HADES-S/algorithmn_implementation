import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/2.
 */
public class GoldBach {
    public static boolean isPrimer(int Num){
        if(Num==2)
            return true;
        if(Num%2==0)
            return false;
        for(int i=2;i<=(int)Math.sqrt(Num)+1;i++)
        {
            if(Num%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i=0;
        for (i =2;i <= N/2;i++){
            if (isPrimer(i)&&isPrimer(N-i))
                break;
        }
        System.out.println(i+" "+(N-i));
    }
}
