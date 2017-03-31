import java.util.Scanner;

public class package1 {

    private static int weight=0,item_num=0;
    private static Item[] item =null;

    public class Item{
        public int weight=0;
        public int value=0;
    }
    public static int Iterative(int n,int C){
        if(n==0 || C==0)
            return 0;
        else{
            for(int i=n-1;i>=0;i--){
                if(item[i].weight>C){
                    return Iterative(n-1,C);
                }else{
                    int temp1=Iterative(n-1,C);
                    int temp2=Iterative(n-1,C-item[i].weight)+item[i].value;
                    return temp1>temp2?temp1:temp2;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            item_num=s.nextInt();
            item=new Item[item_num];
            for(int i=0;i<item_num;i++){
                item[i]=new package1().new Item();
                item[i].value=s.nextInt();
            }
            for(int i=0;i<item_num;i++){
                item[i].weight=s.nextInt();
            }
            weight=s.nextInt();
            System.out.println(Iterative(item_num,weight));
        }
    }
}
