import java.util.*;

/**
 * Created by Administrator on 2017/4/1.
 */
public class hiho_password {
    public static void getResult(List<Integer> Num,HashMap<Integer,Integer> map){
        int i= Num.size()-1;
        for(;i>=1;i--)
        {
            if(Num.get(i)<Num.get(i-1)) {
                i--;
                break;
            }
            if(map.get(Num.get(i))>1)
            {
                i--;
                break;
            }

        }
        Set<Integer> set = new HashSet<Integer>();
        for(int j=0;j<=i;j++){
            if(!set.contains(Num.get(j)))
            {
                System.out.print(Num.get(j)+" ");
                set.add(Num.get(j));
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> Num = new ArrayList<Integer>();
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++)
        {
            int temp = sc.nextInt();
            Num.add(temp);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        getResult(Num,map);
    }
}
