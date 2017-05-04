import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 */
public class BSTCreate {
    static class Node
    {
        Node left;
        Node right;
        int value;
        Node(){

        }
        Node(int value){
            this.value = value;
        }
    }
    public static void getArray(Node node ,ArrayList<Integer> iter){
        if(node==null)
            return;
        getArray(node.left,iter);
        iter.add(node.value);
        getArray(node.right,iter);

    }
    public static Node createBST(int[] a ,int start, int end,Node node){
        if(start>end) {
            return null;
        }
        if(start==end){
            node.value=a[start];
        }else {
            int mid = (start+end)/2;
            node.value= a[mid];
            if(start<=mid-1)
                createBST(a,start,mid-1,node.left = new Node());
            if(mid+1<=end)
                createBST(a,mid+1,end,node.right = new Node());
        }
        return node;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] a = new int[]{1,2,3,4,5};
        Node root = new Node();
        Node node = createBST(a,0,a.length-1,root);
        getArray(node,arr);
        Iterator<Integer> next = arr.iterator();
        while (next.hasNext()){
            System.out.println(next.next()+" ");
        }
    }
}
