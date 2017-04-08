import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/7.
 */
public class yihuo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuilder str3 = new StringBuilder();
        if(N==1&&str1.charAt(0)==str2.charAt(0))
        {
            System.out.print(0);
            return;
        }
        if(N==1&&str1.charAt(0)!=str2.charAt(0))
        {
            System.out.print(1);
            return;
        }
        for(int i=0;i<N;i++)
        {
            if(str1.charAt(i)==str2.charAt(i))
                str3.append('0');
            else
                str3.append('1');
        }
        long sum=0;
        String str5 =str3.toString();
        int large=0;
        int len = str5.length();
        while(large<len){
            if(str5.charAt(large)=='0')
                large++;
            else{
                break;
            }
        }
        if(large==len)
            System.out.println(0);
        else {
            for(int i=len-1;i>=large;i--){
                if(str5.charAt(i)=='1')
                    sum=sum+(int)Math.pow(2,len-1-i);
            }
            System.out.println(sum);
        }
    }
}
