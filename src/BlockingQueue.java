import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/4/22.
 */
public class BlockingQueue {
    public static void main(String[] args){
        ConcurrentHashMap<String,Integer> hashMap = new ConcurrentHashMap<String,Integer>();
        hashMap.put("Simon",1);
        hashMap.put("Semior",2);
    }
}
