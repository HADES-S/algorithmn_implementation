import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2017/3/17.
 */
public class Producer {
    private final int Max_Value = 100;
    private LinkedBlockingQueue<Object> blocks = new LinkedBlockingQueue<Object>(100);

    public void produce(int num) {
        if (blocks.size() == Max_Value) {
            System.out.println("wait");
        }
        for (int i = 0; i < num; i++) {
            try {
                blocks.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Now" + blocks.size());
        }
    }
    public void consume(int num) {
        if (blocks.size() == 0) {
            System.out.println("number");
        }
        for (int i = 0;i<=num;i++){
            try{
                blocks.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("输出仓储");
    }
}
