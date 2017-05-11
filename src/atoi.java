import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/5/8.
 */
public class atoi {
    public static int myAtoi(String str) {
        //define program
        boolean isMinus = false;
        boolean isFloat = false;
        int floatSize = 0;
        int num = 0;
        int len = str.length();
        if(str.length()==0)
            return 0;
        //判断所有首位非数字，非正负的都为错
        if(str.charAt(0)!=('+')&&str.charAt(0)!=('-')&&str.charAt(0)!=(' ')&&(str.charAt(0)<'0'||str.charAt(0)>'9'))
            return 0;
        //判断首位为空格
        while(str.charAt(0)==' '){
            str = str.substring(1);
            len--;
        }
        //判断首位为+- 后面只有一个零0
        if((str.charAt(0)==('-'|'+'))&&((str.length()==2&&str.charAt(1)=='0')||(len==1)))
        {
            return 0;
        }
        if(str.charAt(0)=='-'&&str.length()>1)
        {
            isMinus = true;
            str = str.substring(1);
            len = len-1;
        }
        if(str.charAt(0)=='+'&&str.length()>1&&isMinus==false)
        {
            str = str.substring(1);
            len = len-1;
        }
        for(int loc=0;loc<str.length();loc++){
            if((str.charAt(loc)<'0'||str.charAt(loc)>'9')&&str.charAt(loc)!='.')
                return num;
            if(str.charAt(loc)=='.')
            {
                isFloat= true;
                continue;
            }
            if(isFloat==true)
            {
                floatSize++;
            }
            int locInt = str.charAt(loc) - '0';
            if((num>214748364||(num==214748364&&locInt>=7))&&isMinus==false)
            {
                num = 2147483647;
                break;
            }
            else if ((num>214748364||(num==214748364&&locInt>=8))&&isMinus==true)
            {
                num = -2147483648;
                isMinus=false;
                break;
            }
            else
                num = num*10+locInt;

        }
        if(isMinus==true)
        {
            num = num*(-1);
        }
        if(isFloat ==true){
            num = num/(int)(Math.pow(10,floatSize));
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String s = sc.next();
        //System.out.println(myAtoi(s));
        char a ='还';
        short a1 =1;
        float a2 = 1.1f;
        System.out.println(a2);
        ExecutorService executor = Executors.newFixedThreadPool(3);
    }
}

