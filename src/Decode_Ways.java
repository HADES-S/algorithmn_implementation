/**
 * Created by Administrator on 2017/5/25.
 */
public class Decode_Ways {
    public static int numDecodings(String s){

        if(s.length()==0)
            return 0;

        if(s.length()==1)
        {
            int p;
            if((p=Integer.valueOf(s.substring(0,1)))>0&&p<27)
                return 1;
            else
                return 0;
        }
        //length为2时
        int[] num = new int[s.length()];
        if(s.charAt(0)=='0')
            return 0;
        num[0] = 1;
        int time = Integer.valueOf((s.substring(0,2)));
        if(time>0&&time<27&&s.charAt(1)!='0')
            num[1] = 2;
        else if(s.charAt(1)!='0')
            num[1] = 1;
        else if(time>0&&time<27)
            num[1] = 1;
        else
            return 0;


        if(s.length()==2)
            return num[1];
        for(int i=2;i<num.length;i++){
            if(Integer.valueOf(s.substring(i-1,i))!=0)
            {
                int number = Integer.valueOf((s.substring(i-1,i+1)));
                if(number>0&&number<27&&s.charAt(i)!='0')
                    num[i] = num[i-1]+num[i-2];
                else if(s.charAt(i)=='0')
                {
                    int p;
                    if((p = Integer.valueOf(s.substring(i-1,i)))>2||p==0)
                        return 0;
                    num[i] = num[i-2];
                }
                else
                    num[i] = num[i-1];
            }else{
                if(s.charAt(i)=='0')
                {
                    return 0;
                }else
                {
                    num[i] = num[i-1];
                }
            }
        }
        return num[num.length-1];
    }
    public static void main(String[] args){
        System.out.println(numDecodings("1090"));
    }
}
