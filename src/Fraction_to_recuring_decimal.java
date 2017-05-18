import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/9.
 * 字符串的题要考虑的几个方面
 * 小数，小数首位是不是0
 * 正负情况
 * 是否会有字符串溢出
 * 考虑使用long类型
 * 会不会有无线循环
 * double的精度有几位
 * 如何确保double和int之间的关系
 */
public class Fraction_to_recuring_decimal {
    public static String fractionToDecimal(int numerator, int denominator2) {

        long numerator2 = numerator;
        long denominator = denominator2;
        boolean repeat = false;
        boolean isfu = false;

        //define
        if (denominator == 0)
            return null;
        if (numerator2 == 0)
            return "0";
        if((numerator2<0&&denominator>0)||(numerator2>0&&denominator<0))
        {
            numerator2 = Math.abs(numerator2);
            denominator = Math.abs(denominator);
            isfu =true;
        }


        //正数部分结果
        StringBuilder result = new StringBuilder(String.valueOf(numerator2/denominator)+'.');
        HashMap<Double, Integer> map = new HashMap<>();

        double start = (numerator2 * 1.0 % denominator)*10;
        int stripLoc = 1;
        for (; ; ) {
            if (start % denominator == 0) {
                repeat = false;
                long used = Math.abs((long) (start) / denominator);
                String str = String.valueOf(used);
                result.append(str);
                break;
            } else {
                //已经存在过了
                if (map.containsKey(start)) {
                    int tempStripLoc = map.get(start);
                    repeat = true;
                    result = result.insert(result.indexOf(".") + tempStripLoc, '(');
                    result.append(")");
                    break;
                }
                long used = (long) (start) / denominator;
                String str = String.valueOf(used);
                result.append(str);
                map.put(start, stripLoc);
                stripLoc++;
                start = start % denominator;
                start = start * 10;
            }
        }


        StringBuilder resultAnswer = new StringBuilder("");

        double base = (double)numerator2/denominator;
        if(isfu==true)
            resultAnswer.append("-");
        if (repeat == true)
            return resultAnswer.append(result).toString();
        else if((base - (long)base)<=0.00000000000001&&(base - (long)base)>=-0.000000000000001)
            return resultAnswer.append(String.valueOf((long)base)).toString();
        else
            return resultAnswer.append(result).toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        String str = fractionToDecimal(first,second);
        System.out.println(str);
    }
}
