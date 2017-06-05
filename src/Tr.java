import java.util.Arrays;
import java.util.Scanner;


public class Tr {

    public static void main(String[] args){
        int n,m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        long[] numbers = new long[n+1];
        for(int i=0;i<n;i++){
            numbers[i] = scanner.nextInt();
        }

        boolean[] hit = new boolean[1000001];
        boolean[] hitCopy = new boolean[1000001];
        hit[0] = true;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hit[j]){
                    long newHit = (numbers[i]+j)%m;
                    if(newHit==0L){
                        System.out.println("Yes");
                        return;
                    }else{
                        hitCopy[(int)newHit] = true;
                        hitCopy[j] = true;
                    }
                }
            }
            boolean[] temp = hit;
            hit = hitCopy;
            hitCopy = temp;
            Arrays.fill(hitCopy,false);
        }
        System.out.println("No");
    }

}
