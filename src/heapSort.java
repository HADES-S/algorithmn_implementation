/**
 * Created by Administrator on 2017/4/4.
 * 简洁的两种堆排序操作
 */
public class heapSort {
    static int sz=0;
    static int[] heap;
    static void  push(int x){
        int i =sz++;
        while(i>0){
            int p = (i-1)/2;
            if(heap[p]<i)
                break;
            heap[i]=heap[p];
            i=p;
        }
        heap[i] = x;
    }

    int pop(){
        int ret = heap[0];
        int x = heap[--sz];
        int i=0;
        while(i*2+1<sz){
            int a =i*2+1,b=i*2+2;
            if(b<sz&&heap[b]<heap[a])a=b;
            if(heap[a] >= x)break;

            heap[i] = heap[a];
            i=a;
        }
        heap[i] = x;
        return ret;
    }
}
