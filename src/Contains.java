import java.util.Locale;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/5/15.
 */
public class Contains {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        SortedSet<Long> set = new TreeSet<Long>();
        SortedSet<Long> subset = new TreeSet<Long>();

        if (nums.length<=1 || k < 0 || t < 0)
            return false;

        //start point
        int start = 1;

        //初始set的内容
        for (int i = 1; i <=(k<nums.length-1?k:nums.length-1); i++) {
            if(set.contains((long) nums[i]))
                return true;
            set.add((long) nums[i]);
        }
        //start 是初始位置
        while(start<nums.length-1) {
            subset = set.subSet((long) nums[start] - t, (long) nums[start] + t+1);
            if (!subset.isEmpty())
                return true;
            set.remove((long) nums[start]);
            if (nums.length > start + k+1)
            {
                if(set.contains((long) nums[start + k+1]))
                    return true;
                set.add((long) nums[start + k+1]);
            }
            start++;
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,3,1};
        int k = 1;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
    }
}
