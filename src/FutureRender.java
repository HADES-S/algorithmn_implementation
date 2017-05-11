import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/5/4.
 */
public class FutureRender {
    public static ExecutorService es = Executors.newFixedThreadPool(10);
    static void renderPage(){
        String[] list = new String[]{"我","很","急躁"};
        List<String> imageInfos = Arrays.asList("我","很","难受");
        List<String> imageInfos2 = Arrays.asList("我","很","急躁");

        Callable<List<String>> task2 = new Callable<List<String>>(){
            @Override
            public List<String> call() throws Exception {
                List<String> result = new ArrayList<String>();
                for(String s:imageInfos2){
                    result.add(s);
                }
                return result;
            }
        };

        Callable<List<String>> task = new Callable<List<String>>(){

            @Override
            public List<String> call() throws Exception {
                List<String> result = new ArrayList<String>();
                for(String s:imageInfos){
                    result.add(s);
                }
                return result;
            }
        };
        Future<List<String>> future = es.submit(task2);
        Future<List<String>> future2 = es.submit(task);
        try {
            List<String> str = future.get();
            for (String str1:str){
                System.out.println(str1);
            }
            List<String> str2 = future2.get();
            for (String strs:str2){
                System.out.println(strs);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            future.cancel(true);
        }catch (ExecutionException e){
            System.out.println(e.getCause());
        }
    }
    public static void main(String[] args){
        renderPage();
        es.shutdown();
    }


}
