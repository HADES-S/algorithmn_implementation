import java.util.*;

/**
 * Created by Administrator on 2017/5/14.
 */
public class Surrounded_Regions {
    static boolean[][] used;
    static int row,column;
    static int[] stepX = {-1,0,1,0};
    static int[] stepY = {0,1,0,-1};
    static class Node extends Object{
        int x,y;
       public  Node(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object node){
            if (node==null)
                return false;
            if(!(node instanceof Node))
                return false;
            Node node2 = (Node)node;
            if(this.x==node2.x&&this.y==node2.y)
                return true;
            return false;
        }
    }
    public static void solve(char[][] board) {
        row = board.length;
        if((row)>=1)
        {
            column = board[0].length;
        }
        else
            return;
        used = new boolean[row][column];
        for(int i =0;i<row;i++)
            Arrays.fill(used[i],false);
        for(int i=0;i<row;i+=1)
            for(int j=0;j<column;j+=1){
                if(board[i][j]=='O') {
                    dpChange(i, j, board);
                  //  if(temp==false
                }
            }
    }

    public static void dpChange(int x,int y,char[][] arr){
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> collect = new HashSet<Node>();
        queue.add(new Node(x,y));
        boolean isSurround = true;
        if(x==0||x==row-1||y==0||y==column-1)
        { isSurround=false;}
        else
        {
            isSurround = true;
        }
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(used[temp.x][temp.y]==true)
                continue;
            used[temp.x][temp.y]=true;
            collect.add(temp);
            for(int i=0;i<4;i++)
            {
                int tempStepX = stepX[i]+temp.x;
                int tempStepY = stepY[i]+temp.y;
                if(tempStepX>=0&&tempStepX<row&&tempStepY>=0&&tempStepY<column&&used[tempStepX][tempStepY]==false&&arr[tempStepX][tempStepY]=='O'){
                    if(tempStepX==0||tempStepX==row-1||tempStepY==0||tempStepY==column-1)
                    { isSurround=false;}
                    queue.add(new Node(tempStepX,tempStepY));
                }
            }
        }
        if(isSurround==true)
        {
            for(Node temp:collect){
                arr[temp.x][temp.y]='X';
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(arr);
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }
}
