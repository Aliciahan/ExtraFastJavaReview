class Animal{
    private String desc;
    public Animal(){
        this.desc= getDesc();// Pay attention here
    }
    public String getDesc(){
        return "Animal";
    }
    public String toString(){
        return desc;
    }
}
public class Wolf extends Animal{
    private String name;
    private double weight;
    public Wolf(String name,double  weight){
        this.name=name; // 3
        this.weight = weight;
    }

    @Override
    public String getDesc() {
        return "Wolf[name:"+name+",weight:"+weight+"]";
    }
    public static void main(String [] args){
        System.out.println(new Wolf("灰太狼",34.3)); //1
    }
}