import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/6.
 */
public class DirSIze {
    public static void getFileList(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length== 0){
            list = path.list();
        }else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        }
        for(String t:list){
            System.out.println(t);
        }
    }
    public static void
    local(String path,final String regex){
        List<Integer> a=Arrays.asList(5,4,3,2,1);
        Iterator<Integer> b = a.iterator();
        while (b.hasNext()){
            System.out.println(b.next());
        }

    }
    public static void main(final String[] args){
        local(null,null);
    }

}
