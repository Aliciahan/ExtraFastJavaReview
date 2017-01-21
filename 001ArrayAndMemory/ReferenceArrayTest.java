

public class ReferenceArrayTest{
    public static void main(String [] args){
        Person[] studients;
        studients = new Person[2];
        System.out.println("the length of studients:"+studients.length);
        Person zhang = new Person();
        zhang.age=15;
        zhang.height=158;
        Person lee = new Person();
        lee.age=16;
        lee.height= 161;
        studients[0]=zhang;
        studients[1]=lee;
        lee.info();
        studients[1].info();

    }

}