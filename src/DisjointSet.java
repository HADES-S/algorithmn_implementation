/**
 * Created by Administrator on 2017/4/4.
 */
public class DisjointSet {
    int[] pair;
    int[] rank;
    int find(int x){
        if(pair[x]==x)
            return x;
        else
        {
            return pair[x] = find(pair[x]);
        }
    }

    void unite(int x,int y){
        int x1 = find(x);
        int y1 = find(y);
        if(x==y)
            return;
        if(rank[x]<rank[y]){
            pair[x] = y;
        }else {
            pair[y] = x;
            if(rank[x]==rank[y])rank[x]++;
        }
    }
    boolean same(int x,int y){
        return find(x)==find(y);
    }
}
