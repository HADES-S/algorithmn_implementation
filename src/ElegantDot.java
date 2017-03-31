import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/13.
 */
public class ElegantDot {
    public static int Dot(int square){
        int time = 0;
        int N = (int)Math.sqrt(square/2);
        for(int i=1;i<=N;i++){
            double left= Math.sqrt(square-i*i);
            if(left -(int)left==0)
            {
                time++;
            }
        }
        if(Math.sqrt(square)-(int)Math.sqrt(square)!=0)
             time = time*8;
        else
            time = time*8+4;
        if(N*N*2==square)
            time = time-4;
        return time;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int time = Dot(N);
        System.out.println(time);
    }
}
