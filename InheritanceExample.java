/*This is an Example of implicit typecasting
This can even be seen as a case of inheritance
Say there are 4 classes, A, B, C, Object(The cosmic superclass)
Object->A->B->C
Say we are passing an object of type C to function fun (overloaded function) which takes inputs
of types A and B. It doesn't take an input of type C. Then object of type is C is passed to the
next higher up class in the multilevel inheritance system i.e., it the function that takes
parameter of type B is invoked*/
class Test {
  public static float display(float a) {
    System.out.println("Display inside float method");// this is printed. int is implicitly converted into nearest one
                                                      // which is float.
    return a;
  }

  public static double display(double a) {
    System.out.println("Display inside double method");
    return a;

  }
}

public class InheritanceExample {
  public static void main(String[] args) {
    int a = 20;
    System.out.println(Test.display(a));
  }
}