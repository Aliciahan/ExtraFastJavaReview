public class ArrayTest2{
    public static void main(String[] args){
        int [] nums= new int[]{3,5,20,12};
        int [] prices;
        prices =nums;

        for (int i=0; i<prices.length;i++){
            System.out.println(prices[i]);
        }

        prices[2]=34;
        System.out.println("the 3rd element of nums is :" + nums[2]);
    }
}
