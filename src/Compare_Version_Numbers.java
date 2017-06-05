/**
 * Created by Administrator on 2017/5/25.
 */
public class Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        //length=0
        if(version1.length()==0&&version2.length()==0)
            return 0;
        if(version1.length()==0&&version2.length()!=0)
            return -1;
        if(version1.length()!=0&&version2.length()==0)
            return 1;

        int length1 = version1.length();
        int length2 = version2.length();

        int result = 0;
        boolean mark1=false;
        boolean mark2=false;
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        if(str1.length==0)
        {
            str1 = new String[1];
            str1[0] = version1;
        }
        if(str2.length==0){
            str2 = new String[1];
            str2[0] = version1;
        }
        for(int i=0;i<Math.min(str1.length,str2.length);i++){
            int a = Integer.valueOf(str1[i]);
            int b = Integer.valueOf(str2[i]);
            if(a>b)
            {
                result = 1;
                break;
            }else if(a<b){
                result = -1;
                break;
            }
        }
        if(result==0)
        {
            if(str1.length>str2.length){
                for(int i=str2.length;i<str1.length;i++){
                    int a = Integer.valueOf(str2[i]);
                    if(a!=0)
                    {
                        result = 1;
                        break;
                    }
                }
            }
            if(str1.length<str2.length){
                for(int i=str1.length;i<str2.length;i++){
                    int a = Integer.valueOf(str2[i]);
                    if(a!=0)
                    {
                        result = -1;
                        break;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(compareVersion("1","1.1"));
    }

}
