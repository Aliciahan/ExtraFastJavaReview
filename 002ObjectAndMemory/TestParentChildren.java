class Base{
    private int i =2;
    public Base(){
        System.out.println("The i of This is: "+this.i);
        this.display();
        System.out.println(this.getClass());
    }
    public void display(){
        System.out.println("the value of i is: "+i);
    }
}

class Derived extends Base{
    private int i =22;
    public Derived(){
        i=222; // Step 1:
    }
    public void display(){

        System.out.println("the value of i is: "+i);
    }
}

public class TestParentChildren {
    public static void main(String[] args){
        new Derived();
    }
}