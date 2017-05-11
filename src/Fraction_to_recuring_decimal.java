import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Fraction_to_recuring_decimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        //define
        if (denominator == 0)
            return null;
        if (numerator == 0)
            return "0";
        boolean repeat = false;
        //base为初始化结果
        double base = numerator * 1.0 / denominator;
        //正数部分结果
        StringBuilder result = new StringBuilder(String.valueOf(base).split("\\.")[0] + ".");
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        double start = numerator * 1.0 % denominator;
        start *= 10;
        int stripLoc = 1;
        double second;
        int time = 0;
        for (second = start; ; ) {
            if (start % denominator == 0) {
                repeat = false;
                break;
            } else if (map.containsKey(start)) {
                repeat = true;
                int tempStripLoc = map.get(start);
                result = result.insert(result.indexOf(".") + tempStripLoc, '(');
                result.append(")");
                break;
            } else {
                int used = (int) (start) / denominator;
                String str = String.valueOf(used);
                start = start % denominator;
                map.put(start, stripLoc);
                start = start * 10;
                stripLoc++;
                result.append(str);
            }
        }
        if (repeat == true)
            return result.toString();
        else
            return String.valueOf(base);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        String str = fractionToDecimal(first,second);
        System.out.println(str);
    }
}
