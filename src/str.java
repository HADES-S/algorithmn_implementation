import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/15.
 */
public class str {
    public static String changeStr(String mystring){
        StringBuilder result = new StringBuilder();
        if(mystring.equals(""))
            return "";
        if(mystring.length()==1){
            result = result.append(1);
            result = result.append(mystring);
            return  result.toString();
        }
        char a = '*';
        int Count = 0;
        for (int i=0;i<mystring.length();i++)
        {
            if(a=='*'){
                a = mystring.charAt(i);
                Count=1;
                continue;
            }
            if(a==mystring.charAt(i)){
                Count++;
                continue;
            }
            if(a!=mystring.charAt(i)){
                result.append(Count);
                result.append(a);
                Count=1;
                a=mystring.charAt(i);
            }
        }
        result.append(Count);
        result.append(a);
        return result.toString();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(changeStr(s));
    }
    }
