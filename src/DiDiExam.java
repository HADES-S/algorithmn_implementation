import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/7.
 */
public class DiDiExam {
    static int row ;
    static int column;
    static char[][] arr ;
    static boolean[][] used ;
    static int[] gox = new int[]{1,0,-1,0};
    static int[] goy = new int[]{0,1,0,-1};
    static void dfs(int x,int y){
        if(arr[x][y]=='0'||used[x][y]==true) {
            return;
        }
        used[x][y]=true;
        int startX = x;
        int startY = y;
        for(int temp = 0;temp<4;temp++)
        {
            startX +=gox[temp];
            startY +=goy[temp];
            if(startX>=0&&startX<row&&startY>=0&&startY<column&&arr[startX][startY]=='1')
            {
                dfs(startX,startY);
            }
            startX -=gox[temp];
            startY -=goy[temp];
        }
    }
    public static void main(String[] args){
        int num = 0;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        column = sc.nextInt();
        if(row==0||column==0)
        {
            System.out.println(0);
            return;
        }
        arr = new char[row+1][column+1];
        used = new boolean[row+1][column+1];
        for (int t=0;t<row+1;t++)
            Arrays.fill(used[t],false);
        for(int i=0;i<row;i++){
            String str = sc.next();
            for(int j=0;j<column;j++)
            {
                 arr[i][j] = str.charAt(j);
            }
        }
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
            {
                if(arr[i][j]=='1')
                {
                    if(used[i][j]==false) {
                        num++;
                        dfs(i,j);
                    }
                }
            }
        System.out.println(num);
    }
}
