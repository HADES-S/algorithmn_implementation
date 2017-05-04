import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ArrayInt {
    public static boolean isMatch(String str, String filter){
        // ab  "" 情况
        if(str.length()!=0&&filter.length()==0)
            return false;

        if(str.length()==0&&filter.length()==0)
            return true;
        boolean flag = false;
        if(str.length()==0)
        {
            for(int i =0;i<filter.length();i++)
                if(filter.charAt(i)!='*')
                    return false;
            return true;
        }
        if(filter.length()==1&& filter.charAt(0)=='*') {
            return true;
        }
        if(filter.charAt(0)=='*') {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == filter.charAt(1)||filter.charAt(1)=='*'||filter.charAt(1)=='?')
                    flag = isMatch(str.substring(i, str.length()), filter.substring(1)) == false ? flag : true;
            }
        }else {
            flag = (str.charAt(0)==filter.charAt(0)||filter.charAt(0)=='?')?isMatch(str.substring(1),filter.substring(1)):flag;
        }
        return flag;
    }
    public static boolean isMatch2(String str1,String filter){
        //"" "" 情况
        if(str1.length()==0&&filter.length()==0)
            return true;
        //"ab" "" 情况
        if(str1.length()!=0&&filter.length()==0)
            return false;
        int count =0;
        for(int i=0,j=0,starLoc=-1;;){
            //都完成情况
            if(str1.length()==i&&filter.length()==j)
                return true;
            //最后一个是※
            if(j==filter.length()-1&&filter.charAt(j)=='*')
                return true;
            //
            if(i<str1.length()&&j==filter.length()&&starLoc==-1)
                return false;
            if(i<str1.length()&&j==filter.length()) {
                i = ++count;
                j = starLoc + 1;
            }
            if(j<filter.length()&&filter.charAt(j)=='*')
            {
                count=i;
                starLoc = j;
                j++;
                continue;
            }
            if(i==str1.length()&&j<filter.length())
                return false;
            if(i<str1.length()&&j<filter.length()&&(str1.charAt(i)==filter.charAt(j)||filter.charAt(j)=='?')){
                i++;
                j++;

            }else if(j<=filter.length()&&starLoc!=-1&&j!=starLoc+1) {
                i = ++count;
                j = starLoc + 1;
            }
            else if(j==starLoc+1)
                i++;
            else
                return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.nextInt()==1) {
            String str = sc.next();
            String filter = sc.next();
            boolean result = isMatch2(str, filter);
            int num = result == true ? 1 : 0;
            System.out.println(num);
            ExecutorService executor = Executors.newFixedThreadPool(8);

        }
    }
}
