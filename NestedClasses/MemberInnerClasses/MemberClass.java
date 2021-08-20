package Interfaces.NestedClasses.MemberInnerClasses;

class OuterClass {
  static int x = 10;
  int y = 20;

  class MemberInnerClass {
    /*
     * static int innerX = 100;//I am using Java 14.0.1. Not making MemberInnerClass
     * static is showing an error that a static variable cannot be created inside a
     * non static inner type. But in Java 16 it is showing that it is possible.
     * Making MemberInnerClass as static makes it possible to declare a static int
     * inside the static inner type
     */
    int innerX = 100;
    int innerY = 1000;

    void innerFoo() {
      System.out.println(
          "This is the function 'foo' inside the class MemberInnerClassDemo.MemberInnerClass and the value of x and y is: "
              + x + y);
      System.out.println(
          "This is the function 'foo' inside the class MemberInnerClassDemo.MemberInnerClass and the value of innerX and innerY is: "
              + innerX + innerY);
    }
  }

  void foo() {
    System.out.println("This is the function foo inside the class MemberInnerClassDemo and x and y is: " + x + y);
  }

}

public class MemberClass {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    // System.out.println(OuterClass.MemberInnerClass.innerX);//This line works fine
    // when the variable innerX of MemberInnerClass is declared static. But
    // declaring an object of MemberInnerClass which is not static and also
    // containing a static member causes an error.
    OuterClass.MemberInnerClass inner = outer.new MemberInnerClass();
    /*
     * Syntax for creating an object of inner class is outerclass.innerclass =
     * outerclassobject.new innerclass();
     */
    outer.foo();
    // inner.innerFoo();
    System.out.println(outer);
  }
}
