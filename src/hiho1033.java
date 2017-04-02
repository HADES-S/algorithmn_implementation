import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2017/4/1.
 *
 * 描述
 给定一个数 x，设它十进制展从高位到低位上的数位依次是 a0, a1, ..., an - 1，定义交错和函数：

 f(x) = a0 - a1 + a2 - ... + ( - 1)n - 1an - 1

 例如：

 f(3214567) = 3 - 2 + 1 - 4 + 5 - 6 + 7 = 4

 给定 l, r, k，求在 [l, r] 区间中，所有 f(x) = k 的 x 的和，即：

 1405402477702.png

 输入
 输入数据仅一行包含三个整数，l, r, k(0 ≤ l ≤ r ≤ 1018, |k| ≤ 100)。

 输出
 输出一行一个整数表示结果，考虑到答案可能很大，输出结果模 10^9 + 7。

 1、可能会产生 最高位是0的情况
 */
public class hiho1033 {
    public static long Mode=1000000007;
    public static long[][][] dp;
    public static long[][][] size;
    public static void getResult(long length,int big,int value,Integer[] arr ){
        for(int i=0;i<=9;i++)
        {
            dp[1][i][encode(i)] = i;
            size[1][i][encode(i)] = 1;
        }
        for (int i=2;i<=length;i++)
            for(int j=1;j<=9;j++)
                for(int k=1-9*(int)Math.ceil(length/2.0);k<=9*Math.floor(length/2.0);k++)
                {
                    if(j-1==0)
                    {
                        size[i][j][encode(k)] = dp[i-1][9][encode(k)] + dp[i - 1][9][encode(j - k)];
                        dp[i][j][encode(k)] = dp[i][j - 1][encode(k)] + dp[i - 1][9][encode(j - k)] +
                                j * (int) Math.pow(10, i - 1) * size[i - 1][9][encode(j - k)];
                        dp[i][j][encode(k)] = dp[i][j][encode(k)] % Mode;
                    }else {
                        size[i][j][encode(k)] = dp[i][j - 1][encode(k)] + dp[i - 1][9][encode(j - k)];
                        dp[i][j][encode(k)] = dp[i][j - 1][encode(k)] + dp[i - 1][9][encode(j - k)] +
                                j * (int) Math.pow(10, i - 1) * size[i - 1][9][encode(j - k)];
                        dp[i][j][encode(k)] = dp[i][j][encode(k)] % Mode;
                    }
                }
    }
    static int encode(int k){
        k=k+10*9;
        return k;
    }
    static int decode(int k){
        k=k-10*9;
        return k;
    }
    public static Integer[] getArr(long num){
        int[] result = new int[1];
        String str = String.valueOf(num);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=str.length()-1;i>=0;i--){
            arr.add(Character.getNumericValue(str.charAt(i)));
        }
        List<String> a = new LinkedList<String>();
        return (Integer[])arr.toArray();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long num1 = sc.nextInt();
        long num2 = sc.nextInt();
        int value = sc.nextInt();
        Integer[] arr1 = getArr(num1);
        Integer[] arr2 = getArr(num2);
        Arrays.fill(dp,0);
        for(int i=0;i<=9;i++)
        {
            //控制初始输入
            dp[1][i][encode(i)] = i;
            size[1][i][encode(i)] = 1;
        }
        getResult(arr2.length,arr2[arr2.length-1],value,arr2);
        long result = 0;
        for(int i=0;i<arr2.length;i++)
        {
            result = result + dp[i+1][arr2[i]][encode(value)];
            if(i<arr1.length)
                result=result - dp[i+1][arr1[i]][encode(value)];
            result = result%Mode;
        }
        System.out.println(result);
    }
}
