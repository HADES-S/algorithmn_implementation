import java.util.*;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int start = i+1,end = nums.length-1;
            while (start<end){
                if(nums[start]+nums[end]+nums[i]==0)
                {
                    List temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    while(start+1<end&&nums[start]==nums[start+1])
                        start++;
                    while(start<end-1&&nums[end-1]==nums[end])
                        end--;
                }
                else if(nums[start]+nums[end]+nums[i]>0){
                    end--;
                }else {
                    start++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {-1, 0, 1, 2, -1, -4};
        for(List<Integer> list:threeSum(arr))
        {
            for(Integer integer:list){
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
