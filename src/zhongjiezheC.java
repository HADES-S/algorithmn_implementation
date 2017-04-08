import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/7.
 */
public class zhongjiezheC {
    public static void main(String[] args)
    {
        int[][] dp = new int[400][400];
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[] X = new int[N];//车头坐标
        int[] L = new int[N];//车尾坐标
        ArrayList<Integer> arr =new ArrayList<Integer>();//所有可能的情况
        for(int i=0;i<N;i++){
            X[i] = sc.nextInt();
            arr.add(X[i]);
            L[i] = sc.nextInt()+X[i];
            arr.add(L[i]);
        }
        int len = arr.size();
        int Max = 0;//最大值
        for(int i=0;i<len;i++)//第一个的坐标
            for(int j=i+1;j<len;j++)//第二个的坐标
            {
                int temp=0;
                for(int k=0;k<N;k++)//对于每个点是不是能够打到
                {//判断如果能打到就+1
                    if ((arr.get(i)>=X[k]&&(arr.get(i)<=L[k])||(arr.get(j)>=X[k]&&(arr.get(j)<=L[k]))))
                            temp++;
                }
                if(temp>Max)//如果比现有大 就用新的
                    Max=temp;
            }
        System.out.println(Max);
    }
}
