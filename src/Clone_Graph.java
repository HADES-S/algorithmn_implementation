import sun.awt.image.ImageWatched;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;

/**
 * Created by Administrator on 2017/3/9.
 */
class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class Clone_Graph {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        if(node.neighbors.size()==0)
            return new UndirectedGraphNode(node.label);
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        return addNode(node,map);
        }
    public static UndirectedGraphNode addNode(UndirectedGraphNode onenode, HashMap<Integer,UndirectedGraphNode> hash){
        if(hash.containsKey(onenode.label)){
            return hash.get(onenode.label);
        }else {
            UndirectedGraphNode graphNode = new UndirectedGraphNode(onenode.label);
            hash.put(onenode.label,graphNode);
            for(UndirectedGraphNode temp:onenode.neighbors){
                if(hash.containsKey(temp.label))
                {
                    graphNode.neighbors.add(hash.get(temp.label));
                }else {
                    UndirectedGraphNode neighborNode = addNode(temp,hash);
                    graphNode.neighbors.add(neighborNode);
                }
            }
            return graphNode;
        }
    }
    public static void main(String[] args){
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        node.neighbors.add(new UndirectedGraphNode(2));
        node.neighbors.add(new UndirectedGraphNode(3));
        node.neighbors.get(0).neighbors.add(new UndirectedGraphNode(4));
        UndirectedGraphNode endNode = cloneGraph(node);
        Queue<UndirectedGraphNode> createnode = new LinkedList<UndirectedGraphNode>();
        createnode.add(endNode);
        while (!createnode.isEmpty()){
            UndirectedGraphNode newnode = createnode.poll();
            System.out.println(newnode.label);
            for(UndirectedGraphNode graphNode:newnode.neighbors){
                createnode.add(graphNode);
                System.out.println(graphNode.label);
            }
        }
    }
}
