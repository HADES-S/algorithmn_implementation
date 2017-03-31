/**
 * Created by Administrator on 2017/2/24.
 There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 Note:
 The solution is guaranteed to be unique.
 */
public class gas_station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==1&&gas[0]>=cost[0])
            return 0;
        if(gas.length==1&&gas[0]<cost[0])
            return -1;
        int cost1[] =new int[cost.length];
        for(int i=0;i<cost.length-1;i++)
            cost1[i+1] = cost[i];
        cost1[0] = cost[cost.length-1];
        int loc = 0;
        int max = 0;
        int add[] =new int[gas.length];
        int sub[] =new int[gas.length];
        for(int i=0;i<gas.length-1;i++){
            add[i] = gas[i] - cost1[i+1];
        }
        add[gas.length-1]=gas[gas.length-1]-cost1[0];
        for(int i=0;i<add.length;i++){
            if(i==0){
                if(add[0]<=0)
                    sub[0]=0;
                else
                {
                    sub[0]=add[0];
                    max =add[0];
                    loc=0;
                }
                continue;
            }
            if(sub[i-1]+add[i]<0)
            {
                sub[i]=0;
            }else {
                sub[i]=sub[i-1]+add[i];
                if(max<=sub[i]){
                    loc=i;
                    max = sub[i];
                }
            }
        }
        int i=0;
        while(sub[loc]>0){
            loc--;
            i++;
            if(loc==-1)
                loc=sub.length-1;
            if(i>sub.length)
                break;
        }
        loc++;
        int sum = 0;
        for(i=0;i<gas.length;i++){
            sum = sum+gas[(loc+i)%gas.length]-cost1[(loc+i+1)%gas.length];
            if(sum<0){
                return -1;
            }
        }
        return loc;
    }
    public static void main(String args[]){
        int gas[]={67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
        int cost[] = {27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
