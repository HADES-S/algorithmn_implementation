import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.ObjectType;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2017/2/22.
 */
public class pushBix {
    public static class loc{
        int x;
        int y;
        loc(int x,int y){
            this.x=x;
            this.y=y;
        }
        public boolean equals(loc s){
            if(this.x ==s.x&&this.y==s.y)
                return true;
            else
                return false;
        }
    }
    public static class state{
        loc people= new loc(0,0);
        loc box = new loc(0,0);
        state(loc people,loc box){
            this.people.x = people.x;
            this.people.y = people.y;
            this.box.x = box.x;
            this.box.y = box.y;
        }
        public boolean equals(Object s2){
            state s = (state)s2;
            if (this.people.equals(s.people)&&this.box.equals(s.box))
                return true;
            else return false;
        }
    }
    public static int pushBox(char a[][],loc start,loc box,int N,int M){
        int step=0;
        java.util.Map<state,Integer> Q = new HashMap<state,Integer>(){
            public boolean containsKey(Object s1){
                state s = (state)s1;
                for(Entry entry:entrySet()){
                    state temp = (state) entry.getKey();
                    if(temp.box.equals(s.box)&&temp.people.equals(s.people))
                        return true;
                }
                return false;
            }
        };
        Queue<state> pos = new LinkedList<state>();
        int xStep[]={0,1,0,-1};
        int yStep[]={1,0,-1,0};
        state startstate = new state(start,box);
        Q.put(startstate,0);
        pos.add(startstate);
        loc New ,Temp;
        while(!pos.isEmpty()){
            state oldState = pos.poll();
            Temp = oldState.people;
            box = oldState.box;
            for(int i=0;i<4;i++){
                New = new loc(Temp.x+xStep[i],Temp.y+yStep[i]);
                if(!useful(New.x,New.y,N,M)){
                    continue;
                }
                if(a[New.x][New.y]=='#') {
                    continue;
                }
                if(New.equals(box)&&useful(box.x+xStep[i],box.y+yStep[i],N,M)){
                    box.x +=xStep[i];
                    box.y +=yStep[i];
                    if(a[box.x][box.y]=='@'){
                        return Q.get(oldState)+1;
                    }
                    if(a[box.x][box.y]=='#')
                        continue;
                    state  NewState = new state(New,box);
                    if(!Q.containsKey(NewState))
                    {
                        Q.put(NewState,Q.get(oldState)+1);
                        pos.add(NewState);
                    }
                    box.x -= xStep[i];
                    box.y -=yStep[i];
                }else
                {
                    state  NewState = new state(New,box);
                    if(!Q.containsKey(NewState))
                    {
                        Q.put(NewState,Q.get(oldState)+1);
                        pos.add(NewState);
                    }
                }
            }
        }
        return 0;
    }
    public static boolean useful(int x,int y,int N,int M){
        if(x>=0&&x<M&&y>=0&&y<N)
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char a[][] = new char[N][M];
        String line ;
        loc start=new loc(0,0),box=new loc(0,0);
        for (int i=0;i<N;i++)
        {
            line = sc.next();
            for (int j=0;j<M;j++){
                a[i][j] = line.charAt(j);
                if(a[i][j]=='X')
                {
                    box.x = i;
                    box.y = j;
                }
                if(a[i][j]=='*'){
                    start.x = i;
                    start.y = j;
                }
            }
        }

        int result = pushBox(a,start,box,N,M);
        System.out.println(result);
    }
}
