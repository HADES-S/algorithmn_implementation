import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/3/29.
 */
public class PracticeJava extends Java{
    static {
        System.out.println("hello");
    }
    PracticeJava(){
        System.out.println("construct practicejava");
    }
    public static void main(String[] args){
        new PracticeJava();
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
