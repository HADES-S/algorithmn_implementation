import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/22.
 */
public class Moslems {
    public static void main(String[] args) {
        int Num = 0;
        ArrayList<Integer> A1 = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            A1.add(sc.nextInt());
        }
        if (N == 0 || N == 1) {
            System.out.println(A1.get(0));
            return;
        } else {
            int first = 0, second = A1.size() - 1;
            while (first < second) {
                if (A1.get(first) > A1.get(second)) {
                    Num++;
                    second--;
                    A1.set(second, A1.get(second) + A1.get(second + 1));
                    continue;
                }
                if (A1.get(first) < A1.get(second)) {
                    Num++;
                    first++;
                    A1.set(first, A1.get(first) + A1.get(first - 1));
                    continue;
                }
                if (A1.get(first) == A1.get(second)) {
                    first++;
                    second--;
                }
                break;
            }
            System.out.println(Num);
        }
    }

}
