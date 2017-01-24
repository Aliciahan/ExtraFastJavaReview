class Creature{
    {
        System.out.println("Creature non static block");
    }
    public Creature(){
        System.out.println("Creature non parms constructor");
    }
    public Creature(String name){
        this();
        System.out.println("Creature with name parms constructor");
    }
}
class Animal extends Creature{
    {
        System.out.println("Animal non static block");
    }
    public Animal(String name){
        super(name);
        System.out.println("Anaimal with one param constructor"+name);
    }
    public Animal(String name, int age){
        this(name);
        System.out.println("Animal with twos params constructor"+age);
    }
}
class Wolf extends Animal{
    {
        System.out.println("Wolf non static block");
    }
    public Wolf(){
        super("灰太狼",3);
        System.out.println("Wolf non param");

    }
    public Wolf(double weight){
        this();
        System.out.println("wolf with weight"+weight);
    }

}
public class InitTest2{
    public static void main(String[] args){
        new Wolf(5.6);
    }
}