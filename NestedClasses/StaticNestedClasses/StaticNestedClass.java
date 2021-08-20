package Interfaces.NestedClasses.StaticNestedClasses;

class OuterClass {
  static int x = 10;
  static int y = 20;
  int z = 1000000;

  // Static nested classes are not inner classes. They are like member inner
  // classes i.e., they are inside a class but outside the methods
  static class StaticNested {
    // Only static variables of OuterClass are accessible here. Not it's instance
    // variables.
    // A Static Nested class can have both static and non static members
    static int staticNestedX = 1000;

    void StaticNestedClassFun() {
      System.out.println("Start of StaticNestedClassFun");
      System.out.println("The value of staticNestedX is: " + staticNestedX);
      System.out.println("Inside the non static method of a static nested class");
      System.out.println("Static member of Outer class: " + x);
      // System.out.println("Non static member of Outer class: " + z);
      // Non static members of outer class cannot be accessed by static nested class.
      System.out.println("End of StaticNestedClassFun");
    }
  }

  public void outerFun() {
    System.out.println("Instance method of Outer Class and x, y are: " + x + " " + y);
  }

}

public class StaticNestedClass {
  public static void main(String[] args) {
    OuterClass obj1 = new OuterClass();
    obj1.outerFun();
    // Static members of Static Nested class can be accessed directly. But to access
    // the non static methods/variables, one has to create an object of the static
    // nested class
    System.out.println(OuterClass.StaticNested.staticNestedX);
    /*
     * If the nested class wasn't a static class and we try to access static members
     * of the inner class, the result would be 0 "the default value of int in java"
     * If the nested class was a static class and we try to access the static
     * members then we get the desired results.
     */
    // OuterClass.StaticNested temp = obj1.new StaticNested();//Syntax if the nested
    // class is not static
    /*
     * When we try to create an object of the StaticNested class when it is not
     * static, it causes error, because this non static nested class consists of
     * static members.
     */
    OuterClass.StaticNested obj2 = new OuterClass.StaticNested();
    System.out.println(obj2.staticNestedX);
    obj2.StaticNestedClassFun();
    // Static methods of nested static method can be accessed by
    // OuterClass.StaticNestedClass.nameOfTheMethod or by creating an object like
    // above.
  }

}
/*
 * Member Inner classes can be inherited. They can't be overridden because one
 * cannot override a class but a function. Local Inner classes can be inherited
 * outside the method based on the access modifier of the method in which they
 * are present. But they can be inherited by classes inside the method in which
 * they are present
 */
