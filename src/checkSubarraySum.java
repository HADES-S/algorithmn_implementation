/**
 * Created by Administrator on 2017/6/4.
 */
public class checkSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        for (int init =0,end=1;end<nums.length;end++){
            int start = init,sum=0;
            for(int i=start;i<=end;i++)
                sum = sum+nums[i];
            for (;;)
            {
                if(k==0&&sum==0)
                    return true;
                if(k!=0&&sum%k==0)
                    return true;
                sum = sum - nums[start];
                start++;
                end++;
                if(end==nums.length)
                    break;
                sum = sum + nums[end];
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums ={23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum(nums,-6));
    }
}
