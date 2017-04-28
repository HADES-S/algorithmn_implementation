import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class QueueAttack {
    static HashMap<Integer,Integer> countRow;
    static HashMap<Integer,Integer> countColumn;
    static HashMap<Integer,Integer> countSum;
    static HashMap<Integer,Integer> countsmall;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //Integer n=Integer.valueOf(sc.nextLine());
        Integer n = sc.nextInt();
        int[] row=new int[n];
        int[] column=new int[n];
        int[] sum=new int[n];
        int[] small=new int[n];
        for(int i=0;i<n;i++){
            row[i]=sc.nextInt();
            column[i]=sc.nextInt();
            sum[i]=row[i]+column[i];
            small[i]=row[i]-column[i];
        }
        countRow=new HashMap<>();
        countColumn=new HashMap<>();
        countSum=new HashMap<>();
        countsmall=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!countRow.containsKey(row[i])){
                countRow.put(row[i],1);
            }else{
                countRow.put(row[i], countRow.get(row[i])+1);
            }
            if(!countColumn.containsKey(column[i])){
                countColumn.put(column[i],1);
            }else{
                countColumn.put(column[i], countColumn.get(column[i])+1);
            }
            if(!countSum.containsKey(sum[i])){
                countSum.put(sum[i],1);
            }else{
                countSum.put(sum[i], countSum.get(sum[i])+1);
            }
            if(!countsmall.containsKey(small[i])){
                countsmall.put(small[i],1);
            }else{
                countsmall.put(small[i], countsmall.get(small[i])+1);
            }
        }
        long Sum=(long)0;
        for(int x:countRow.values()){
            Sum+=getResult(x);
        }
        for(int x:countColumn.values()){
            Sum+=getResult(x);
        }
        for(int x:countSum.values()){
            Sum+=getResult(x);
        }
        for(int x:countsmall.values()){
            Sum+=getResult(x);
        }
        System.out.println(Sum);
    }
    public static long getResult(int x){
        return (long)x*(long)(x-1)/2;
    }
}