import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/12.
 * 使用快指针和慢指针
 */
public class linked_list_cycle {
    static ListNode fastPoint;
    static ListNode lowPoint;
    static ListNode nextPoint;
    public static ListNode detectCycle(ListNode head){
        fastPoint = head;
        lowPoint = head;
        nextPoint = head;
        if(head==null)
            return null;
        do {
            if(fastPoint.next!=null&&fastPoint.next.next!=null)
                fastPoint = fastPoint.next.next;
            else
                return null;
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
        return nextPoint;
    }
    public static void main(String args[]){
        Integer[] moreints = {1,2,3,4,5,6,7,8,4};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(moreints));
        ListNode listnode = ListNode.createCycleListByArr(arr);
        ListNode list = linked_list_cycle.detectCycle(listnode);
        if(list==null)
            System.out.println("null");
        else
            System.out.println(list.val);
    }
}
