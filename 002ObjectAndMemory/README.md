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


### When we define it? 
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
