import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/4.
 */
public class WordDictionary {
    /** Initialize your data structure here. */
    Node root;
    class Node{
        Node[] array = new Node[26];
        boolean isEnd=false;
        boolean isRoot = false;
        Node(boolean End){
            isEnd = End;
        }
    }
    public WordDictionary() {
        this.root =new Node(false);
        root.isRoot = true;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node temp = root;
        int i=0;
        for (Character c:word.toCharArray()){
            if(temp.array[c-'a']!=null){
                temp=temp.array[c-'a'];
            }else {
                temp.array[c-'a'] = new Node(false);
                temp = temp.array[c-'a'];
            }
            if(i==word.length()-1)
                temp.isEnd = true;
            i++;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int step1=1;
        int step2=0;
        int flag = 0;
        for (char c:word.toCharArray()){
            if(flag==word.length()-1)
            {
                while (!queue.isEmpty())
                {
                    Node temp = queue.peek();
                    queue.poll();
                    if(c=='.')
                    {
                        for (int i=0;i<26;i++){
                            if(temp.array[i]!=null&&temp.array[i].isEnd==true)
                                return true;
                        }
                    }
                    else if(temp.array[c-'a']!=null&&temp.array[c-'a'].isEnd==true)
                    {
                        return true;
                    }
                }
            }
            for(int i=0;i<step1;i++){
                Node temp = queue.peek();
                queue.poll();
                if(temp==null)
                    continue;
                if(c=='.'){
                    for(int j=0;j<26;j++)
                    {
                        queue.add(temp.array[j]);
                        step2++;
                    }
                }else if(c>='a'&&c<='z'){
                    queue.add(temp.array[c-'a']);
                    step2++;
                }else {
                    return false;
                }
            }
            step1 =step2;
            step2 = 0;
            flag++;
        }
        return false;
    }
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
