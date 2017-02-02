class Fruit{
    String color = "not defined color";
    public Fruit getThis(){
        return this;
    }
    public void info(){
        System.out.println("The function in Fruit");
    }
}

public class Apple extends Fruit{
    @Override
    public void info() {
        System.out.println("The function in Apple");
    }

    public void AccessSuperInfo(){
        super.info();
    }
    public Fruit getSuper(){
        return super.getThis();
    }
    String color = "Red";

    public static void main(String [] args){
        Apple a= new Apple();
        Fruit f=a.getSuper();
        System.out.println("a and f are the same?:"+(a==f));//Yes
        System.out.println("accessing the color in a"+a.color);//Red
        System.out.println("Accessing the color in f"+f.color);//not defined
        a.info();//function in Apple
        f.info();//function in Apple
        a.AccessSuperInfo();//function in Fruit.
    }
}