import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Compare implements Comparator<Compare> {
    public String str;
    public Compare(String str){
        this.str =str;
    }
    public int compare(Compare compare1,Compare compare2){
        if(compare1.str.compareTo(compare2.str)>0)
            return 1;
        else if(compare1.str.compareTo(compare2.str)==0)
            return 0;
        else
            return -1;
    }
    public static void main(String[] args){
        ArrayList<Compare> arr = new ArrayList<Compare>();
        Compare com = new Compare("str");
        Compare com2 = new Compare("sstr");
        arr.add(com);
        arr.add(com2);
        arr.sort(new Compare("str"));
        for (Compare cn:arr){
            System.out.println(cn.str);
        }
    }
}
