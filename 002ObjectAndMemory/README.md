# Object and Memory

##2.1 实例变量 和 类变量

**Variable:**

- 成员变量field: 
	- static: 将实例成员变成类成员, 所以static只能修饰class里面的成员, 不能修饰外部类, 局部变量局部内部类.
	- 实例变量 
- 局部变量: (in the stack of function)
	- 形参 (birth: when the function is called. die: when the function is over)
	- 方法内部的局部变量: (birth: defined, die: when the function is over)
	- 代码块内的局部变量: (when the block is initialed, die: when then block finished running)

~~~java
public class ErrorDef{
    //first type of error, very simple 
    int num1 = num2+2;
    int num2 =20;
    
    //error 2nd type, won't work
    static int num3 = num4+2;
    static int num4 =20;
    
    //Right thing to do :
    int num5 = num6+2;
    static int num6 = 20;    
}

~~~

####实例变量和类变量

We can simply say that the **static** object occupies only one place in the memory. 


##2.1.2 When we define it? 
* Where we  define an object
* 构造器
* 非静态初始模块

例子: InitTest.java

~~~java
class Cat{
    String name;
    int age;

    public Cat(String name, int age){
        System.out.println("执行Constructor"); //2nd Constructor
        this.name= name;
        this.age = age;
    }
    {
        System.out.println("non-static initialized"); //First Executed
        weight =2.0;
    }

    double weight = 2.3; // Third executed

    public String toString(){
        return "Cat name:"+name+" ,cat age :"+age+", cat weight:"+weight;
    }
}
~~~

javap -c Cat : look at **line 13** and **line 20**
	
~~~java
  public Cat(java.lang.String, int);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       7: ldc           #3                  // String non-static initialized
       9: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      12: aload_0
      13: ldc2_w        #5                  // double 2.0d**
      16: putfield      #7                  // Field weight:D
      19: aload_0
      20: ldc2_w        #8                  // double 2.3d
      23: putfield      #7                  // Field weight:D
      26: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      29: ldc           #10                 // String 执行Constructor
      31: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      34: aload_0
      35: aload_1
      36: putfield      #11                 // Field name:Ljava/lang/String;
      39: aload_0
      40: iload_2
      41: putfield      #12                 // Field age:I
      44: return
~~~

#####An other example : 

~~~java
public class JavapToolTest{
    int count =20;
    {
        count =12;
    }
    public JavapToolTest(){
        System.out.println(count);
    }
    public JavapToolTest(String name){
        System.out.println(name);
    }
}
~~~

javap -c JavapToolTest 

~~~java
MBP-de-XICUN:002ObjectAndMemory xicunhan$ javap -c JavapToolTest
Compiled from "JavapToolTest.java"
public class JavapToolTest {
  int count;

  public JavapToolTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: bipush        20
       7: putfield      #2                  // Field count:I
      10: aload_0
      11: bipush        12
      13: putfield      #2                  // Field count:I
      16: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: aload_0
      20: getfield      #2                  // Field count:I
      23: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
      26: return

  public JavapToolTest(java.lang.String);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: bipush        20
       7: putfield      #2                  // Field count:I
      10: aload_0
      11: bipush        12
      13: putfield      #2                  // Field count:I
      16: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: aload_1
      20: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      23: return
}
~~~

<mark>**得出结论: Constructor最后, non-static和 define过程两个看顺序!**</mark>

##### We find the same thing in the static definition
look at **StaticInitTest.java**

另一个例子: 

~~~java
class Price{
    final static Price INSTANCE = new Price(2.8);
    static double initPrice = 20;
    double currentPrice;
    public Price(double discount){
        currentPrice = initPrice-discount;
    }
}

public class PriceTest{
    public static void main(String [] args){
        System.out.println(Price.INSTANCE.currentPrice);
        Price p = new Price(2);
        System.out.println(p.currentPrice);
    }
}
~~~

~~~bash
MBP-de-XICUN:002ObjectAndMemory xicunhan$ java PriceTest
-2.8
18.0
~~~

我们可以看出, 在初始化的时候, 仅仅分配了空间+默认值, 并没有被赋值, 只有实例化之后, 才有数值出现. 

##2.2 Parents

继承extends的时候, 这个执行顺序:

~~~java
MBP-de-XICUN:002ObjectAndMemory xicunhan$ javac InitTest2.java 
MBP-de-XICUN:002ObjectAndMemory xicunhan$ java InitTest2
Creature non static block
Creature non parms constructor
Creature with name parms constructor
Animal non static block
Anaimal with one param constructor灰太狼
Animal with twos params constructor3
Wolf non static block
Wolf non param
wolf with weight5.6
~~~

---
* Question: can a parent class gain access to its children?

TestParentChildren.java

~~~java
class Base{
    private int i =2;
    public Base(){
        this.display();
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
~~~

we will see that <mark>**the result is : 0**</mark>

~~~java
MBP-de-XICUN:002ObjectAndMemory xicunhan$ java TestParentChildren
the value of i is: 0
~~~

Why? 

- First in the Step 1 Initialize two i one for Base, the other for Derived, the default value are all 0 !
- Then, before running the constructor of Derived it will run the constructor of Base, the i in base =2
- but the "this" in it belongs to which class? this.i = 2, but this.display() uses the fonction of Class Derived!!!!

the value of i depends on who declare it! But when we use the fonction, we consider like the problem does not exist. 

To show this we rewrite Base

~~~java
class Base{
    private int i =2;
    public Base(){
        System.out.println("The i of This is: "+this.i);
        this.display();
        System.out.println(this.getClass());
    }
~~~

we got 

~~~java 
MBP-de-XICUN:002ObjectAndMemory xicunhan$ java TestParentChildren
The i of This is: 2
the value of i is: 0
class Derived
~~~

####In which case we get access to the fonction rewritten by a child?

~~~java
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
~~~
 
the miracle is : 

~~~java
MBP-de-XICUN:002ObjectAndMemory xicunhan$ java Wolf
Wolf[name:null,weight:0.0]
~~~

<mark>一定要注意在主类里面不要引用被子类重写的方法!!!</mark>

## 2.3 Memory Control (Parent and Child)
Look at an example first: 

~~~java

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
    }
}
~~~

Whether this is a d, db, or d2b when they point at an Object Derived, and when we use the fonction display(), they will always show us the result of their **REAL TYPE**, but when we show the elements in them, they show us the result of **Declaration Type**.

<mark>Why</mark>

~~~java
class Animal{
    public String name;
    public void info(){
        System.out.println(name);
    }
}

public class AnimalTest extends Animal{
    private double weight;
}
~~~

look at the compilation : 

~~~bash

MacBook-Pro-de-XICUN:002ObjectAndMemory xicunhan$ javap -c -private AnimalTest
Compiled from "AnimalTest.java"
public class AnimalTest extends Animal {
  private double weight;

  public AnimalTest();
    Code:
       0: aload_0
       1: invokespecial #1// Method Animal."<init>":()V
       4: return

  public void info();
    Code:
       0: aload_0
       1: invokespecial #2// Method Animal.info:()V
       4: return
}
~~~

We find that

- the weight is not initialised.
- get the function info() directly from Anminal

So that:
 
- the name is still existe in the class Animal(will not be copied to the New extended class): Makes it possible to get two class have the variable the same nom. 
- if Override the function in the extended class, it is impossible to copy the function from his parent. 

<mark> What happens to the variables the same nom</mark>

~~~java
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
~~~

#### How to use super()

~~~java
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
~~~

We constate that, the variable defined right. 
but the info() is still the info in a. 

- function in Extended class cannot return super.
- the programme doesn't allow using the super as a variable. 


~~~java

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
~~~






