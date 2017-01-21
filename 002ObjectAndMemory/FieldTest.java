class Person{
    public String name;
    public int age;
    public static int eyeNum;
    public void info(){
        System.out.println("The name is:" + name+"age:" + age+ ", the eyeNum:" + eyeNum);
    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
public class FieldTest{
    public static void main (String [] args){
        Person.eyeNum=4;
        System.out.println("the eyeNum = "+Person.eyeNum);

        Person p = new Person("han",30);
        Person p2 = new Person("Lin",35);

        p.info();
        p2.info();

        //change the eyeNum from p2
        System.out.println("we changed the eyeNum from p2");
        p2.eyeNum = 2000;

        p.info();
    }
}