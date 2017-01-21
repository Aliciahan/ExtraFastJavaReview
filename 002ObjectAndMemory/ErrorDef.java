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