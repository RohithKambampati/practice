package Interfaces.NestedClasses.ClassInInterface;

interface MyInterface {
  int num = 10;// public static and final

  void interfaceFun();

  class NestedClass {
    int x = 100;
    private int y = 1000;
    static int z = 200;
    private static int w = 100000;

    void nestedNonStaticFun() {
      System.out.println("Inside the nested class's non static method");
      System.out.println("x, y, z are: " + x + "  " + y + "  " + z);
      System.out.println("num is: " + num);
    }

    public static void nestedStaticFun() {
      System.out.println("Inside the nested class's static method");
      // System.out.println("x, y, z are: " + x + " " + y + " " + z);//x and y are not
      // accessible as they are non static members and this is a static method
      System.out.println("w and z are: " + w + "  " + z);
      System.out.println("num is: " + num); // num is accessible as it is public static final by default and is present
                                            // in this scope
    }
  }

}

public class ClassInInterface {
  public static void main(String[] args) {
    MyInterface.NestedClass obj = new MyInterface.NestedClass();
    // static members and nested classes of an interface are accessible directly.
    // That is the reason due to which we are able to create an object of the nested
    // class
    obj.nestedNonStaticFun();
    obj.nestedStaticFun();
    MyInterface.NestedClass.nestedStaticFun();
  }
}
