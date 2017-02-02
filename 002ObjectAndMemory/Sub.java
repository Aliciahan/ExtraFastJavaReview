class Base{
    int count=2;
}
class Mid extends Base{
    int count =20;
}
public class Sub extends Mid{
    int count=200;
    public void accessMid(){
        System.out.println(super.count);
    }
    public static void main(String[] args){
        Sub s= new Sub();
        Mid s2m= s;
        Base s2b = s;

        System.out.println(s.count);//200
        System.out.println(s2m.count);//20
        System.out.println(s2b.count);//2
        s.accessMid();//donc 20
    }

}