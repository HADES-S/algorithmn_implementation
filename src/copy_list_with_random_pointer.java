import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
public class copy_list_with_random_pointer {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
        {
            RandomListNode newList =  new RandomListNode(head.label);
            newList.next = head.next;
            newList.random=head.random;
            return newList;
        }
        RandomListNode fasthead=head;
        RandomListNode lowhead=head;
        //讲原列表和新列表按照间隔的方式排列
        while(fasthead!=null){
            fasthead = fasthead.next;
            RandomListNode tempNode = new RandomListNode(lowhead.label);
            lowhead.next=tempNode;
            lowhead.next.next =fasthead;
            lowhead=fasthead;
        }
        fasthead=head;
        //将新列表加入random选项
        while (fasthead!=null){
            if(fasthead.random!=null)
                fasthead.next.random = fasthead.random.next;
            else
                fasthead.next.random =null;
            fasthead = fasthead.next;
            fasthead = fasthead.next;
        }
        RandomListNode newHead = head.next;
        RandomListNode newHeadPoint = newHead;
        RandomListNode oldHeadPoint = head;
        fasthead =newHead;
        //拆分原List和新List
        while (fasthead.next!=null){
            fasthead = fasthead.next;
            oldHeadPoint.next = fasthead;
            oldHeadPoint = oldHeadPoint.next;
            fasthead = fasthead.next;
            newHeadPoint.next = fasthead;
            newHeadPoint = newHeadPoint.next;
        }
        newHeadPoint.next = null;
        oldHeadPoint.next = null;
        return newHead;
    }
    public static void main(String args[]){
        //测试用例1:1、2、3、4、5、6
        RandomListNode OldList = new RandomListNode(1);
        RandomListNode headPoint = OldList;
        RandomListNode point_1 = headPoint;
        RandomListNode rNode =new RandomListNode(2);
        headPoint.next=rNode;
        headPoint = headPoint.next;
        RandomListNode point_2 = headPoint;
        headPoint.next = new RandomListNode(3);
        headPoint = headPoint.next;
        RandomListNode point_3 = headPoint;
        headPoint.next = new RandomListNode(4);
        headPoint = headPoint.next;
        RandomListNode point_4 = headPoint;
        headPoint.next = new RandomListNode(5);
        headPoint = headPoint.next;
        RandomListNode point_5 = headPoint;
        headPoint.next = new RandomListNode(6);
        headPoint = headPoint.next;
        RandomListNode point_6 = headPoint;
        point_1.random = point_3;
        point_2.random = point_6;
        point_3.random = point_1;
        point_4.random = point_1;
        point_6.random = point_2;
        RandomListNode newList = copyRandomList(OldList);
        System.out.println(newList.printString());
        //测试用例2: 1，1
        RandomListNode oldList2 = new RandomListNode(1);
        oldList2.next = null;
        oldList2.random = oldList2;
        newList = copyRandomList(oldList2);
        System.out.println(newList.printString());
        //测试用例3 1 null
        oldList2.random=null;
        copyRandomList(oldList2);
        newList = copyRandomList(oldList2);
        System.out.println(newList.printString());
        //测试用例4
        oldList2 = null;
        newList = copyRandomList(oldList2);
        //System.out.println(newList.printString());
        //测试用例5
        oldList2 = new RandomListNode(1);
        oldList2.next = new RandomListNode(2);
        oldList2.random = oldList2.next;
        oldList2.next.next = null;
        oldList2.next.random = oldList2;
        newList = copyRandomList(oldList2);
        System.out.println(newList.printString());
    }
}
