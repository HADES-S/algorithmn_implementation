import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Sort {
    public static ArrayList<Integer> first = new ArrayList<Integer>();
    public static ArrayList<Integer> second = new ArrayList<Integer>();
    public static int getkth(ArrayList<Integer> A,int aStart,ArrayList<Integer> B,int bStart,int k){
        if(aStart>A.size() -1)return B.get(bStart+k-1);
        if(bStart>B.size() -1)return A.get(aStart+k-1);
        if(k==1)return Math.min(A.get(aStart),B.get(bStart));
        int aMid = Integer.MAX_VALUE,bMid=Integer.MAX_VALUE;
        if(aStart+k/2-1<A.size())aMid =A.get(aStart+k/2-1);
        if(bStart+k/2-1<B.size())bMid =B.get(bStart+k/2-1);
        if(aMid<bMid)
            return getkth(A,aStart+k/2,B,bStart,k-k/2);
        else
            return getkth(A,aStart,B,bStart+k/2,k-k/2);
    }

    public static void main(String[] args){
        int all[]={222,333,23,21,3543,63,81,82};
        int k = 3 ;
        for(int i=0;i<all.length/2;i++){
            first.add(all[i]);
            second.add(all[(all.length/2)+i]);
        }
        Lock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();
        if(all.length%2==1)
            second.add(all[all.length-1]);
        sortFunction sort1 = new sortFunction(1,lock,empty);
        sortFunction sort2 = new sortFunction(2,lock,full);
        Thread thread1 = new Thread(sort1);
        Thread thread2 = new Thread(sort2);
        try {
            thread1.start();
            thread2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            lock.lock();
            System.out.println("主线程未唤醒");
            full.await();
            empty.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("执行主线程");
        int result = getkth(first,0,second,0,k);
        System.out.println(result);
        lock.unlock();
    }
}
class sortFunction implements Runnable,Comparator<Integer> {
    int num;
    Condition c;
    Lock lock;
    public sortFunction(int i,Lock lock,Condition c){
        this.num =i;
        this.c = c;
        this.lock = lock;
    }
    @Override
    public synchronized void run() {
        try {
            lock.lock();
            if(num==1){
                Sort.first.sort(this);
            }
            if(num==2){
                Sort.second.sort(this);
            }
            System.out.println("线程执行完成");
        }catch (Exception e){
        }finally {
            c.signalAll();
            lock.unlock();
        }
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

