class Base{
    int count =2;
    public void display(){
        System.out.println("the method in Base display called this.count:"+this.count);
    }
}

class Derived extends  Base{
    int count = 20;

    @Override
    public void display() {
        System.out.println(this.count);
    }
}

public class FieldAndMethodTest{
    public static void main(String [] args) {
        Base b = new Base();
        System.out.println(b.count); // b.count =2
        b.display();; // b count = 2
        System.out.println("---------d------------");

        Derived d = new Derived();
        System.out.println(d.count);//d.count = 20
        d.display();//20

        System.out.println("---------bd------------");

        Base bd = new Derived();
        System.out.println(bd.count); //2 <-initialized by Base
        bd.display(); // this point to the counter of Derived

        System.out.println("---------d2b------------");
        Base d2b = d;
        System.out.println(d2b.count);//2
        d2b.display();
    }
}

