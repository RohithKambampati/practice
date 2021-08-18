package NestedInterfaces;
/*Interface inside interface
Class inside interface
Interface inside class
Class inside class
All of these are allowed combinations in Java
*/

//Case 1: Interface inside an interface
interface A {
  void methodA();

  interface B {// Interface inside any interface is by default public and cannot be changed.
               // The methods can have modified acess which still need to be used by the
               // default method inside the interface only, like discussed in the interfaces
               // concept java program
    // int methodA();
    void methodA(int x);// Declared this to remove the ambiguity the above statement causes

    void methodB();
  }
}

// Case 2: Interface inside a class
class Outer {
  static int x = 10;
  int y = 100;

  interface Inner {// Interface inside any class can be given access modifier and it still works
    void methodC();

    static void displayX() {
      System.out.println("The value of static int x declared in the class Outer is: " + x);
      /*
       * x cannot be referred to as this.x as it is static and it is declared and
       * initiated before the constructor.
       */
    }

    default void displayY() {
      // System.out.println("The value of instance variable y declared in the Outer
      // class is: " + y);//Since the y here is not associated with any object and is
      // not a static variable there comes a need to create an object of the class
      // Outer and then use the variable y.
      Outer obj = new Outer();
      System.out.println("The value of instance variable y declared in the Outer class is: " + obj.y);
    }
  }

}

// Implementation of case 1: Interface inside another interface
class Case1 implements A, A.B {
  @Override
  public void methodA() {
    System.out.println("Overriding methodA in interface A");
    /*
     * When implementing both A and A.B interfaces methodA() function is present in
     * interface A and A.B. So when trying to override it causes ambiguity for the
     * // compiler since the parameters they both take are also the same. Inorder to
     * prevent this ambiguity, name the functions of methodA() different in both
     * interfaces.
     */
  }

  @Override
  public void methodA(int x) {
    System.out.println("Overriding the methodA in interface A.B and the value of x is: " + x);
  }

  @Override
  public void methodB() {
    System.out.println("Overriding methodB in interface A.B");
  }

  void temp() {
    System.out.println("This is an undesired function");
  }
}

// Implementation of case 2: Interface inside a class
class Case2 implements Outer.Inner {
  @Override
  public void methodC() {
    System.out.println("Overriding the method show of the interface Outer.Inner in class Case2");
  }
}

public class NestedInterfacesOverriding {
  public static void main(String[] args) {// Here String... args is also allowed
    // case 1:
    System.out.println("Case1: Interface inside an interface");
    Case1 ab = new Case1();
    ab.methodA();
    ab.methodA(435);
    ab.methodB();
    ab.temp();
    // Here in the above statement we are able to access the method temp which is
    // not wanted by the interface, but still it could be accessed. To avoid
    // providing access to the undesired function use dynamic method dispatch.
    A a = new Case1();
    a.methodA();
    // a.temp()//causes compilation error
    A.B b = new Case1();
    b.methodA(10);
    b.methodB();
    // b.temp();// causes compilation error
    // case 2:
    System.out.println("Case2: Interface inside a class");
    Case2 c = new Case2();
    c.methodC();
    // c.display();//When class case2 extends the Interface from Outer.Inner, it
    // doesn't inherit the static methods just like when a static method/variable
    // cannot be inherited by the class extending it.
    Outer.Inner.displayX();// Can call the method display directly by using name of the interface
    c.displayY();// this function kinda gets copied to all the classes implementing this
                 // interface since it is default. And this default has nothing to do with the
                 // default access specifier
    // Outer.Inner.displayY();/*the displayY() method is not a static method so it
    // cannot be invoked without implementing the Inner interface*/
    c.displayY();
  }
}
