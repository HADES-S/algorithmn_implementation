import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/26.
 */
public class JailBreak {
    public static long getResult(long M,long N)
    {
        long success = 0;
        long unsuccess = M;
        Long circleTime = N-1;
        while (circleTime>0){
            success = (success*M+unsuccess)%100003;
            unsuccess = (unsuccess*(M-1))%100003;
            circleTime--;
        }
        return success;
    }
    public static void main(String[] args){
        System.out.println(getResult(5,12));
    }
}
