package Interfaces.NestedClasses.LocalInnerClasses;

class OuterClass {
  static int x = 10;
  int y = 20;

  void foo() {
    class InnerClass {
      // static int innerX = 100;//This cannot be declared. Because the class is not a
      // static one and the function in which this is present is also not a static
      // function
      int innerX = 100;
      int innerY = 200;

      void innerFoo() {
        System.out.println("Inside the Inner foo function which is inside the local inner class");
        System.out.println("The value of innerX and innerY are :" + innerX + " " + innerY);
        System.out
            .println("The value of x and y from the outer class accessed from the innerFoo method are: " + x + " " + y);
      }
    }// This class is present inside the scope of the method innerFoo. It is not
     // possible to create an object of type innerClass outside the method foo.
    InnerClass i = new InnerClass();
    i.innerFoo();
    System.out.println("End of the method containing the inner class");
  }
}

public class LocalClass {
  public static void main(String[] args) {
    System.out.println("Inside main function");
    OuterClass outer = new OuterClass();
    outer.foo();
  }
}
