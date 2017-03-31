import java.io.*;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/5.
 * 如何跑大数据
 */
public class square {
    public static BigInteger getSentence(int R, int i){
        int R1,i1; //R1>i1
        if(i>R){
            R1 = i;
            i1 = R;
        }else
        {
            R1 = R;
            i1 = i;
        }
        if(i1==1)
            return BigInteger.valueOf((long)R1);
        BigInteger sum = BigInteger.valueOf(0);
        for(int num=1;num<i1;num++){
            sum = sum.add(BigInteger.valueOf((R1-num)*(i1-num)).remainder(BigInteger.valueOf(1000000007)));
            if(num!=1){
                sum = sum.add(BigInteger.valueOf((R1-num)*(i1-num)*(num-1)).remainder(BigInteger.valueOf(1000000007)));
            }
            sum = sum.remainder(BigInteger.valueOf(1000000007));
        }
        return sum;
    }
    public static void main(String args[]){
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
                BigInteger result = getSentence(M,N);
                String str1 = "Case #"+ new Integer(i+1).toString()+": "+result;
                write.println(str1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

      }
}
