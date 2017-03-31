import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//做题的时候 i*i <= j时  可以通过同时使用 i 和 j/i 降低复杂度 ，同时注意判断i=j情况
//前面的值不一定比后面的小，所以还是要判断
/**
 * Created by Administrator on 2017/3/22.
 */
public class Dot {

    public static int[] sortUp(int A,int B){
        // int[] Num= new int[100000];
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        if (A == B)
            System.out.println(0);
        else if (A > B || A - B == -1)
            System.out.println(-1);
        else {
            int[] Num = new int[B - A + 1];
            int i;
            for (i = 0; i < B - A + 1; i++) {
                Num[i] = 0;
            }
            for (i = 0; i <= B - A; i++) {
                if (Num[i] == 0 && i != 0) {
                    continue;
                } else {
                    for (int j = 2; j * j <= (A + i); j++) {
                        if (j > (B - A - i)) { //增加值大于需要的值
                            break;
                        }
                        if (((A + i) % j == 0)) {
                            if(Num[i+j]==0||Num[i + j] >Num[i]+1) {
                                Num[i + j] = Num[i] + 1;
                                if(i+j==84)
                                    System.out.println("soft"+i+"Num"+Num[i]);
                                if (i + j + A == B) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (((A + i) / j )<=(B - A - i)&&(j*j!=(A+i))) {
                                if(Num[i + (A + i)/j]==0||Num[i + (A + i) / j]>Num[i] + 1)
                                    Num[i + (A + i) / j]=Num[i] + 1;
                                if((i+(A+i)/j)==84)
                                    System.out.println("soft"+(i+A)+"Num"+Num[i]);
                                if (A + i + (A + i) / j == B) {
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (flag == true)
                    break;
            }
            return Num;
        }
        return null;
    }
    private static int[] solveDP(int n,int m){
        int[] dp = new int[m+1]; // 到达 i位置需要的最小步数
        if(m==n)
            return null;
        Arrays.fill(dp, Integer.MAX_VALUE);
//        System.out.println(Arrays.toString(dp));
        dp[n] = 0;
        for(int i=n;i<=m;i++){
            if(dp[i] == Integer.MAX_VALUE){ // 该位置不能像前走
                dp[i] = 0;
                continue;
            }
            ArrayList<Integer> gcd = getList(i);
            for(int j=0;j<gcd.size();j++){
                int x = gcd.get(j);
                if(i+x==92)
                    System.out.println("real"+i+"Num"+dp[i]);
                if(i+x<=m) // 记录向前走的长度，保留最小的步数
                    dp[i+x] = Math.min(dp[i+x], dp[i] + 1);
            }
        }
        return dp;
    }
    // 求因数 时间复杂度 sqrt（n） 很强大
    public static ArrayList<Integer> getList(int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i*i<=k;i++){
            if(k%i ==0){
                if(i!=1&&i!=k)
                    list.add(i);
                if((i*i)!=k&&(k/i)!=1&&(k/i)!=k)
                    list.add(k/i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int N =8;
        int M =85678;
        int[] a = sortUp(N,M);
        int[] b = solveDP(N,M);
        for(int i=N+1;i<=M;i++){
            System.out.println(a[i-N]+" "+b[i]);
        }
    }
}
