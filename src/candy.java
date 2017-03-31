/**
 There are N children standing in a line. Each child is assigned a rating value.
 You are giving candies to these children subjected to the following requirements:
 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 逻辑方面的缺陷
 1.考虑边缘是不是真的能覆盖掉
 2.考虑有没有可能一开始不为1
 3.所有的测试样例
 一路大，一路小，大小大，小大小，小小大，大大小
 个数 0,1,2
 */
public class candy {
    public static int candy(int[] ratings) {
        int sum = 0;
        int n =0;
        int val[] = new int[ratings.length];
        val[0]=1;
        if(ratings.length==0)
            return 0;
        if(ratings.length==1)
            return 1;

        for(int i=0;i<ratings.length;i++){
            if(i==0){
                sum=1;
                 n =1;
                continue;
            }
            if(ratings[i]>ratings[i-1])
            {
                n=n+1;
                sum= sum +n;
                val[i]=n;
                continue;
            }
            if(ratings[i]<=ratings[i-1]){
                n=1;
                sum = sum +n;
                val[i]=n;
                continue;
            }
        }
        for(int i=ratings.length-1;i>=1;i--){
            if(ratings[i]<ratings[i-1]){
                sum = sum - val[i-1];
                val[i-1]=val[i-1]>(val[i]+1)?val[i-1]:val[i]+1;
                sum = sum + val[i-1];

            }
        }
        return sum;
    }
    public static void main(String args[]){
        int[] ranting ={5,3,1};
        System.out.println(candy(ranting));
    }
}
