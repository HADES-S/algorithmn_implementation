import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/12.
 */
public class linked_list_cycle2 {
    static ListNode fastPoint;
    static ListNode lowPoint;
    static ListNode nextPoint;
    static boolean  hasCycle(ListNode head){
        fastPoint = head;
        lowPoint = head;
        nextPoint = head;
        if(head==null)
            return false;
        do {
            if(fastPoint.next!=null&&fastPoint.next.next!=null)
                fastPoint = fastPoint.next.next;
            else
                return false;
            lowPoint = lowPoint.next;
        }while (fastPoint!=lowPoint);
        if(fastPoint ==lowPoint){
            while (lowPoint!=nextPoint){
                if(lowPoint.next!=null)
                    lowPoint = lowPoint.next;
                if(nextPoint.next!=null)
                    nextPoint = nextPoint.next;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Integer[] moreints = {1,2,3,4,5,6,7,8,4};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(moreints));
        ListNode listnode = ListNode.createByArray(arr);
        Boolean list = linked_list_cycle2.hasCycle(listnode);
        if(list==false)
            System.out.println("false");
        else
            System.out.println(true);
    }
}
