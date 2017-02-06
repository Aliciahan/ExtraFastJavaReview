public class FinalClassVariableTest{
    //define final class variable
    final static int var1 = "helloworld".length();
    final static int var2;
    static {
        var2 = "helloworld2".length();
    }
    public static void main(String [] args){
        System.out.println(FinalClassVariableTest.var1);
        System.out.println(FinalClassVariableTest.var2);
    }
}