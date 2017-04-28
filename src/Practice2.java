/**
 * Created by Administrator on 2017/4/16.
 */
public class Practice2 {
    public static void main(String[] args){
        int a = -10;
        int s=1;
        while(s>a)
        {
            int i = s&a;
            System.out.println(s+" "+i);
            System.out.println(Integer.toBinaryString(s));
            System.out.println(Integer.toBinaryString(a));
            s = s<<1;
        }
        int i = s&a;
        System.out.println(s+" "+i);
        System.out.println(Integer.toBinaryString(s));
        System.out.println(Integer.toBinaryString(a));
    }
}
