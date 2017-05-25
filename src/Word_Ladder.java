import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Administrator on 2017/5/25.
 */
public class Word_Ladder {
    public static int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList) {
        Boolean[] used = new Boolean[wordList.size()];
        Arrays.fill(used,false);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int length = 1;
        int firstLevel= 1;
        int secondLevel = 0;
        boolean flag =false;
        while (!queue.isEmpty()){
            //
            String result = queue.poll();
            firstLevel--;
            for(int i=0;i<wordList.size();i++){
                if(compare(result,wordList.get(i))&&used[i]==false)
                {
                    used[i]=true;
                    queue.add(wordList.get(i));
                    secondLevel++;
                    if(wordList.get(i).equals(endWord))
                    {
                        flag =true;
                        return length+1;
                    }
                }
            }
            if(firstLevel==0)
            {
                for(int i =0;i<used.length;i++)
                System.out.print(used[i]+" ");
                System.out.println();
                length++;
                firstLevel = secondLevel;
                secondLevel=0;
            }
        }
        if (flag==true)
            return length;
        return 0;

    }
    public static boolean compare(String a,String b){
        if(a.length()!=b.length())
            return false;
        int fal = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                fal++;
        }
        if(fal!=1)
            return false;
        return true;
    }
    public static void main(String[] args){
        String beginword = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(beginword,endWord,Arrays.asList(wordList)));
    }
}
