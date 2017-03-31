import java.util.*;

/**
 * Created by Administrator on 2017/2/12.
 */
public class word_break {
    public static boolean wordBreak(String s, Set<String> dict) {
        List<Integer> dp =new ArrayList<Integer>();
        if(s.equals("")||s==null)
            return true;
        if(dict.size()<1)
            return false;
        for (int i=0;i<s.length();i++){
          dp.add(i,0);
        }
        for(int i=0;i<s.length();i++){
            if(i==0||dp.get(i-1)==1){
                String tempString = s.substring(i);
                //System.out.println(tempString);
                Iterator<String> iterator = dict.iterator();
                while(iterator.hasNext()){
                   String str = iterator.next();
                   if(tempString.startsWith(str)){
                       dp.set(i+str.length()-1,1);
                       System.out.println(i+str.length()-1);
                   }
                }
            }
        }
        if(dp.get(s.length()-1)==1)
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        String a = "cars";
        List<String> arr = new ArrayList<String>(Arrays.asList("car","ca","rs"));
        Set<String> myStr = new HashSet<String>(arr);
        boolean str = wordBreak(a,myStr);
        System.out.println(str);
    }
}
