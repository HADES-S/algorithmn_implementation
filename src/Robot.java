/**
 * Created by Administrator on 2017/4/8.
 */
import java.util.Scanner;
public class Robot {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long Count=1;
        long min=0;
        long num=sc.nextLong();
        int q=sc.nextInt();
        long workTime=num/Count;
        if(num%Count!=0){
            workTime++;
        }
        long build=0;
        min+=workTime;
        boolean isTrue=true;
        while(isTrue){
            Count*=2;
            build+=q;
            long temp=build+(num/Count);
            if(num%Count!=0){
                temp++;
            }
            if(temp>=min)
                isTrue=false;
            else{
                min=temp;
            }
        }
        System.out.println(min);
    }
}

