
public class ArrayTest{
    public static void main(String[] args){
        String [] books = new String[]{
                "hello World",
                "another one",
                "the third one"
        };

        String [] names = new String[]{
                "name1",
                "name2",
                "name3"
        };

        String [] strArr = new String [5];

        System.out.println("the length of the first array:"+books.length);
        System.out.println("the length of the second array:"+names.length);
        System.out.println("the length of the third array:"+strArr.length);

        int [] iArr = null;
        int [] prices;
        // System.out.println(prices);  //Error here compile error.
        System.out.println(iArr);
        iArr = new int[5];
        System.out.println(iArr.length);

    }

}