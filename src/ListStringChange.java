import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 */
public class ListStringChange {
    public static void main(String args[]){
        List<String>  list = new ArrayList<String>();
        list.add("aa");
        List<Object> r = (List<Object>)(List)list;
        System.out.println(r);
    }
}

