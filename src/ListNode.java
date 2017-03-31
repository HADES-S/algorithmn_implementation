import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    static ListNode createByArray(List<Integer> arr){
        ListNode listnode = new ListNode(0);
        ListNode startnode = listnode;
        int a=0;
        Iterator<Integer> iterator = arr.iterator();
        while(iterator.hasNext()){
            a = iterator.next();
            ListNode temp = new ListNode(a);
            listnode.next =temp;
            listnode = listnode.next;
        }
        return startnode.next;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        ListNode listNode = this;
        while (listNode.next!=null){
            stringBuilder.append(listNode.val);
            stringBuilder.append(" ");
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
    public static ListNode createCycleListByArr(List<Integer> arr){
        Integer integer = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        ListNode listNode = createByArray(arr);
        ListNode startNode = listNode;
        ListNode endNode = listNode;
        for(int i=1;i<integer;i++){
            startNode =startNode.next;
        }
        while (endNode.next!=null){
            endNode = endNode.next;
        }
        endNode.next = startNode;
        return listNode;
    }
}
