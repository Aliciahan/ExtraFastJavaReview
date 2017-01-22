class Cat{
    String name;
    int age;

    public Cat(String name, int age){
        System.out.println("执行Constructor"); //Then Constructor
        this.name= name;
        this.age = age;
    }
    {
        System.out.println("non-static initialized"); //First Executed
        weight =2.0;
    }

    double weight = 2.3; // Third executed

    public String toString(){
        return "Cat name:"+name+" ,cat age :"+age+", cat weight:"+weight;
    }
}
public class InitTest{
    public static void main(String [] args){
        Cat cat = new Cat ("ketty",2);
        System.out.println(cat);
        System.out.println(cat);
        Cat c2 = new Cat ("Jerfield",3);
        System.out.println(c2);
    }
}