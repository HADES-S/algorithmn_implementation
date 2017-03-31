/**
 * Created by Administrator on 2017/2/22.
 */
public class single_number {
    public static int singlenumber(int[] A){
        int one=0;
        for(int i=0;i<A.length;i++){
            one ^=(~A[i]);
        }
        return ~one;
    }
    public static void main(String args[]){
        int a[]={2,2,3,4,5,4,6,3,6};
        int num = singlenumber(a);
        System.out.println(num);
    }
}
