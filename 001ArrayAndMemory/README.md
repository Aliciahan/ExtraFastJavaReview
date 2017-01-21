# Array

## Initialization

The array of Java is ***static***

- static: developer give the values, sys fix the length.
- dynamic: developer fix the length, sys fixes the values.


~~~java 
ArrayTest.java

public class ArrayTest{
    public static void main(String[] args){
        String [] books = new String[]{
                "hello World",
                "another one",
                "the third one"
        };

        String [] strArr = new String [5];

    }
}
~~~

*The array in Java and Python, js is not the same thing.*

For those whom is not distributed value, the value depends on its type: 

**Default value**: 

~~~java
* byte short int long : 0
* flat double: 0.0
* char :'\u0000'
* boolean : false
* class interface array : null
~~~


**when we initialize an array, what happened?**

Think about pointer in C

.... several revisions ... 


