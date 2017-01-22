public class StaticInitTest{
    static int count =2;
    static String name2 = "def in front";
    static{
        System.out.println("Static Init Block");
        name = "Java Programming";
        name2 = "Def later on";
    }
    static String name = "I am crazy about programming";

    public static void main(String [] args){
        System.out.println("the value of Count:" + StaticInitTest.count);
        System.out.println("The value of Name:"+StaticInitTest.name);
        System.out.println("The value of Name:"+StaticInitTest.name2);
    }
}