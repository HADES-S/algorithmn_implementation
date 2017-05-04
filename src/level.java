import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/5/3.
 */
public class level {
    public static class Node{
        Node left;
        Node right;
        int value;
        Node(int v){
            value = v;
        }
    }
    public static void levelTraverse(Node node){
        if(node==null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        int firstLevel = 1,nextLevel=0;
        queue.add(node);
        while (!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p.value+" ");
            if(p.left!=null) {
                nextLevel++;
                queue.add(p.left);
            }
            if(p.right!=null) {
                nextLevel++;
                queue.add(p.right);
            }
            firstLevel--;
            if(firstLevel==0)
            {
                System.out.println();
                firstLevel=nextLevel;
                nextLevel=0;
            }
        }
    }
    public static void main(String[] args){
        Node a= new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.right.right = new Node(5);

        levelTraverse(a);
    }
}
