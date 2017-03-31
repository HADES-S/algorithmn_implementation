import java.util.*;

/**
 * Created by Administrator on 2017/2/12.
 */
public class word_break_ii {
    static Set<String> resultset = new HashSet<String>();

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        String ns = new String();
        getNewWord(s,dict,ns);
        ArrayList<String> result = new ArrayList<String>(resultset);
        return result;
    }
    public static void getNewWord(String Ls,Set<String> dict,String Ns){
        if(Ls == null||Ls.equals("")) {
            resultset.add(Ns);
            return;
        }
        for (String word : dict){
            if(Ls.endsWith(word)){
                String offerNs;
                if(Ns.equals(""))
                {
                    offerNs = word+Ns;//加入word 的尾串
                }
                else
                {
                    offerNs = word+" "+Ns;
                }
               // System.out.println(offerNs);
                getNewWord(Ls.substring(0,Ls.length()-word.length()),dict,offerNs);
            }
        }
    }
    public static void main(String args[]){

        String a = "catsanddog";
        List<String> arr = new ArrayList<String>(Arrays.asList("cat","sand","and","dog","cats"));
        Set<String> myStr = new HashSet<String>(arr);
        ArrayList<String> str = wordBreak(a,myStr);
        System.out.println(str);

      }
}
