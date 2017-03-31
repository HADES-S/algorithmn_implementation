import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/24.
 */
public class numTransfer {
    public static int gettime(int k,int tX[],int tY[],int goalX,int goalY,int walk,int run){
        int Min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            int  temp =taxi(0,0,tX[i],tY[i],run)+taxi(tX[i],tY[i],goalX,goalY,walk);
            if(Min>temp)
                Min=temp;
        }
        if(Min>taxi(0,0,goalX,goalY,run))
            Min=taxi(0,0,goalX,goalY,run);
        return Min;
    }
    public static int taxi(int X,int Y,int goalX,int goalY,int walk){
        int getX = Math.abs(goalX -X);
        int getY = Math.abs(goalY -Y);
        return walk*(getX+getY);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int[] typeX = new int[51];
        int[] typeY = new int[51];
        int i;
        for(i=0;i<num;i++){
            typeX[i] = sc.nextInt();
        }
        for(i=0;i<num;i++){
            typeY[i] = sc.nextInt();
        }
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();
        int walktime = sc.nextInt();
        int taxitime = sc.nextInt();
        System.out.println(gettime(num,typeX,typeY,goalX,goalY,taxitime,walktime));
    }
}
