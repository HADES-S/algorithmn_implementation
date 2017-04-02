import java.security.KeyStore;
import java.util.*;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/4/2.
 *
 描述
 小Hi的学校的教学楼前有一面砖墙。这面墙由N层砖砌成，其中从上到下第i层包含Ci块高度相同但宽度不同的砖。

 例如下图所示的这面墙，由3层砖砌成。其中第1层包含3块砖，从左到右宽度依次是6、4和3；第2层包含4块砖，从左到右依次宽度依次是4、4、2和3；第3层包含3块砖，从左到右宽度依次是5、6和2。

 +------------+
 |  6  | 4 |3 |
 +------------+
 | 4 | 4 |2|3 |
 +------------+
 | 5  | 6   |2|
 +------------+
 ^
 现在小Hi想在墙上画一道竖线，并且希望竖线穿过的砖块数目越少越好（如果竖线刚好在左右两块砖的交界处，则不会穿过砖块）。例如上例在墙^标示的位置画线，只会穿过一块砖。

 注意小Hi不能在墙的左右边沿画线。

 输入
 第一行一个整数N，表示层数。 (1 <= N <= 100000)

 以下N行每行包含若干个证书。其中第一个整数Ci代表该层砖块的数目，之后Ci个整数表示从左到右每块砖的宽度。

 整面墙总砖块数目不超过100000，总宽度不超过100000000。

 输出
 最少穿过的砖块数目。

 样例输入
 3
 3 6 4 3
 4 4 4 2 3
 3 5 6 2
 样例输出
 1
 */
public class brick_wall {

    public static void main(String[] args){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        TreeMap<Integer,Integer> size = new TreeMap<Integer,Integer>(comparator);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int M = sc.nextInt();
            int sum=0;
            for(int j=0;j<M;j++){
                if(j!=M-1) {
                    sum = sum + sc.nextInt();
                    if (size.containsKey(sum)) {
                        size.put(sum, size.get(sum) + 1);
                    } else {
                        size.put(sum, 1);
                    }
                }else{
                    sc.nextInt();
                }
            }
        }
        int Value = 0;
        for(Map.Entry entry: size.entrySet()){
            int Num = (Integer)entry.getValue();
            Value = Num>Value?Num:Value;
        }
        System.out.println(N-Value);
    }
}
