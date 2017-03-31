import java.util.Objects;

/**
 * Created by Administrator on 2017/2/12.
 */
public class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x;}
    public String printString(){
        String str="";
        if(random!=null) {
            str = label+" "+random.label+"\n";
        }else {
            str = label +" null"+"\n";
        }
        if(next!=null)
        {
            str = str +next.printString();
        }
        return str;
    }
}
