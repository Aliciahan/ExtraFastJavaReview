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


	


