import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */
public class single_number_2 {
    public static int singleNumber(int[] A){
        //int one=0,two=0;
        //List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,6,8,2,3,6,8,3,6,8,2));
        int one1=0,two1=0,three1=0;
        for(Integer i=0;i<A.length;i++){
            two1 |=one1& A[i]; //two1 | = one 有一次1 list[i]有一次1  出现两次一的分布
            one1^=A[i];
            three1 = one1&two1;
            one1 &= ~three1;
            two1 &=~three1;
        }
        System.out.println(one1);
        return 0;
    }
    public static void main(String args[]){
        int[] a ={2,2,3,2};
        singleNumber(a);
    }
}
