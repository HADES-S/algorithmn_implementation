import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/5.
 */
public class overLap {
    public boolean getResult(String s1,String s2){
        int stack=0;
        int lens1 = 0;
        int lens2 = 0;
        return true;
    }
    public static void main(String args[]) {

    }
    public void outPut(){
        try {
            File in = new File(System.getProperty("user.dir")+"\\in\\read.in");
            File out = new File(System.getProperty("user.dir")+"\\in\\out.txt");
            InputStreamReader read = new InputStreamReader(new FileInputStream(in),"utf-8");
            PrintStream write = new PrintStream(out);
            BufferedReader bufferedReader = new BufferedReader(read);
            String str = bufferedReader.readLine();
            Scanner sc = new Scanner(str);
            int size = sc.nextInt();
            for(int i = 0;i<size;i++){
                str = bufferedReader.readLine();
                sc = new Scanner(str);
                int M = sc.nextInt();
                int N = sc.nextInt();
                System.out.println(M);
                System.out.println(N);
            //    String str1 = "Case #"+ new Integer(i+1).toString()+": "+result;
            //    write.println(str1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
