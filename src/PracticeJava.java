import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/3/29.
 */
public class PracticeJava extends Java{
    PracticeJava(){
        System.out.println("construct practicejava");
    }
    public static void main(String[] args){
        Java a = null ;
        synchronized (a){
            System.out.println("hello");
        }
    }
}
class Java{
    static {
        System.out.println("hello java");
    }
    Java(){
        System.out.println("construct java");
    }
}
