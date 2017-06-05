import java.net.NetworkInterface;

/**
 * Created by Administrator on 2017/6/1.
 * 1.split不太靠谱，碰上 :2::这种也只分成两 不能保证分成多少份,..
 * 2数字为01的情况
 * 3、警惕切分后length为0的情况
 * 4、切分后为00的情况
 */
public class Validate_IP_Address {
    public static String validIPAddress(String IP) {
        if(IP.contains(".")){
            int size =0;
            for(int i=0;i<IP.length();i++){
                if(IP.charAt(i)=='.')
                    size++;
            }
            if(size!=3)
                return "Neither";
            if(IP.length()>15)
                return "Neither";
            String[] strList = IP.split("\\.");
            if(strList.length!=4)
                return "Neither";
            for(String str:strList){
                if(str.length()<1)
                    return "Neither";
                for(int i=0;i<str.length();i++)
                    if(!(str.charAt(i)>='0'&&str.charAt(i)<='9'))
                        return "Neither";
                Integer i =Integer.valueOf(str);
                if(i>255)
                    return "Neither";
            }
            return "IPv4";
        }else if(IP.contains(":")){
            int size =0;
            for(int i=0;i<IP.length();i++){
                if(IP.charAt(i)==':')
                    size++;
            }
            if(size!=7)
                return "Neither";
            if(IP.length()>39)
                return "Neither";
            String[] strList = IP.split(":");
            if(strList.length!=8)
                return "Neither";
            for(String str:strList){
                if(str.length()>4||str.length()==0)
                    return "Neither";
                for(int i=0;i<str.length();i++){
                    if((!(str.charAt(i)>='0'&&str.charAt(i)<='9'))&&(!(str.charAt(i)>='a'&&str.charAt(i)<='e'))&&(!(str.charAt(i)>='A'&&str.charAt(i)<='E'))){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }else {
            return "Neither";
        }
    }
    public boolean isNumber(String str){
        if(str.length()==0)
            return false;
        else if(str.length()==1)
        {
            if(!(str.charAt(0)>'0'&&str.charAt(0)<='9'))
                return false;
            else
                return true;
        }
        else if(str.length()>1)
        {
            if(str.charAt(0)=='0'&&str.charAt(1)!='0')
                return false;
            return true;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
