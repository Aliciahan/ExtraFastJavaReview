class Parent
{
    public String tag = "Tag in Public Class";
}

class Derived extends Parent{
    public String tag = "Private Tag in Derived class";
}

public class HideTest{
    public static void main(String [] args){
        Derived d= new Derived();
        System.out.println(d.tag);//Private Tag
        System.out.println(((Parent)d).tag);//Public Tag

    }
}