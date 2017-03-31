/*
        现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。
        输入描述:
        输入数据有n+1行：
        第一行为工程师人数n(1 ≤ n ≤ 6)
        接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)


        输出描述:
        输出一个整数，表示有多少种不同的工作安排方案
        */
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/25.
 */
public class twoClass {
    static int count=0;
    public static int task(int n,boolean[][] skill)
    {
        boolean[] tee = new boolean[n+1];
        Arrays.fill(tee,false);
        nameTask(0,tee,n,skill);
        return count;
    }//tee 从1开始
    public static int nameTask(int a,boolean[] tee,int n,boolean[][] skill){
        if(isTrue(tee))
        {
            count++;
            return 0;
        }
        if(a==6&&trueSize(tee)==n)
        {
            count++;
            return 0;
        }
        if(a==6&&trueSize(tee)!=n)
        {
            return 0;
        }
        for(int i=1;i<=n;i++){
            if(skill[i][a]==true&&tee[i]==false){
                tee[i]=true;
                nameTask(a+1,tee,n,skill);
                tee[i]=false;
            }
        }
        nameTask(a+1,tee,n,skill);
        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean skill[][] = new boolean[10][10];
        for(int i2=0;i2<8;i2++)
            Arrays.fill(skill[i2],false);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            String num = sc.next();
            for(int j=0;j<num.length();j++){
                skill[i][Integer.parseInt(String.valueOf(num.charAt(j)))] = true;
            }
        }
        System.out.println(task(n,skill));
    }
    static
    boolean isTrue(boolean[] tee){
        for(int i=0;i<tee.length;i++)
        {
            if(tee[i]==false)
                return false;
        }
        return true;
    }
   static int trueSize(boolean[] tee){
        int count=0;
        for(int i=0;i<tee.length;i++){
            if(tee[i]==true)
                count++;
        }
        return count;
    }
}
