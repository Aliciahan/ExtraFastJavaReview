class Cat{
    double weight;
    int age;
    public Cat(double weight, int age){
        this.weight=weight;
        this.age = age;
    }
    public void infoCat(){
        System.out.println("This cat is "+weight+"kg, and "+age+" years old");
    }
}

public class ArrayTest3 {
    public static void main(String [] args){
        int [] pos = new int[5];
        for (int i=0; i<pos.length;i++){
            pos[i] = (i+1)*2;
        }
        int a  =pos[1];
        int b = 20 ;
        pos[2] = b;
        Cat[] cats = new Cat[2];
        cats[0]= new Cat(3.34,2);
        cat[1] = new Cat(3.2,2);
        Cat c1= cats[0];
        Cat c2 = new Cat(4.3,3);
        cats[1]= c2;

    }
}