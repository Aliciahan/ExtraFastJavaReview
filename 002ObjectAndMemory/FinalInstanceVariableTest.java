public class FinalInstanceVariableTest {
    //instance variable
    final int var1 = "helloworld".length();
    final int var2;
    final int var3;

    {
        //initial block
        var2 = "helloworld2".length();
    }

    //in the constructor
    public FinalInstanceVariableTest(){
        this.var3 = "helloworld23".length();
    }

    public static void main(String [] args){
        FinalInstanceVariableTest fiv = new FinalInstanceVariableTest();
        System.out.println(fiv.var1);
        System.out.println(fiv.var2);
        System.out.println(fiv.var3);
    }

}