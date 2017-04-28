import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Administrator on 2017/4/8.
 */
public class EL_SUENO {
    static int[] info;
    static int[] need;
    static int[] cost;
    static int[] AllCost;
    static boolean[] used;
    static HashMap<Integer,List<Integer>> father = new HashMap<Integer,List<Integer>>();
    static HashMap<Integer,List<Integer>> son = new HashMap<Integer,List<Integer>>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cost = new int[N+1];
        info = new int[N+1];
        need = new int[N+1];
        AllCost = new int[N+1];
        used = new boolean[N+1];

        int start =0;
        for(int i=1;i<=N;i++)
        {
            int f =sc.nextInt();
            if(f==0)
                start=i;
            if(!father.containsKey(i))
            {
                LinkedList<Integer> link = new LinkedList<Integer>();
                link.add(f);
                father.put(i,link);
            }else {
                father.get(i).add(f); //会不会没有存进去
            }
            if(!son.containsKey(f))
            {
                LinkedList<Integer> link = new LinkedList<Integer>();
                link.add(i);
                son.put(f,link);
            }else {
                father.get(f).add(i); // 会不会没有存进去
            }
            need[i] = sc.nextInt();
            info[i] = sc.nextInt();
            cost[i] = sc.nextInt();
            if(need[i]==0) {
                AllCost[i] = cost[i];
            }
        }
        Arrays.fill(AllCost,Integer.MAX_VALUE);
        Arrays.fill(used,false);
        sort(son.get(start),start);
        System.out.println(AllCost[start]);
    }
    public static void sort(List<Integer>list,int Num){
        int[] op = new int[need[Num]];
        Arrays.fill(op,Integer.MAX_VALUE);
        for(int i=0;i<list.size();i++) {
            if (used[list.get(i)] == false) {
                sort(son.get(used[list.get(i)]), i);
            }
        }
        op[0]=0;
        for(int j1=0;j1<list.size();j1++){
            for(int j2=need[Num];j2>=0;j2--)
            {
                if(j2>=info[list.get(j1)]&&op[list.get(j1)]!=Integer.MAX_VALUE)
                {
                    op[j2] = Math.min(op[j2],op[j2-info[list.get(j1)]]+AllCost[j2-info[list.get(j1)]]);
                }
            }
        }
        AllCost[Num] = op[need[Num]]+cost[Num];
    }
}
