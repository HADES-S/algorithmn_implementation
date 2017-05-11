import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2017/5/8.
 */
public class ReverseWordInString {
    public static String reverseWords(String s) {
        String str = "";
        if(s.length()==0)
            return str;
        String[] list = s.split(" ");
        if(list.length==0)
            return str;
        if(list.length==1)
            return list[0];
        for(int i=list.length-1;i>0;i--){
            str = str +list[i]+" ";
        }
        str = str +list[0];
        StringBuilder st = new StringBuilder(str);
        return str;
    }
    public static void main(String[] args){
        System.out.println(0.16666666666666666*6-1==0);
        Scanner sc = new Scanner(System.in);
        //System.out.println(reverseWords(sc.next()));
        String str = "1.666";
        String[] strList = str.split(".+\\.");
        for(String s :strList)
            System.out.println(s.toString());
    }
}
