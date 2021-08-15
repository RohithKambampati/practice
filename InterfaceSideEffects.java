package Interfaces;

interface Foo {
  // abstract class Foo {
  int dummy = Bar.haveSideEffect();// The nature of the variable mentioned in a interface is public static final

  // void bla();// The nature of this function is public abstract
  abstract void bla();
}

class Bar {
  static int haveSideEffect() {
    System.out.println("Interface Foo initialized");
    return 0;
  }
}

// class Impl implements Foo {
class Impl extends Foo {
  public void bla() {

  }
}

public class InterfaceSideEffects {
  // static {
  // System.out.println("inside static block");//This block gets executed the
  // first. Even before the main function
  // }
  public static void main(String[] args) {
    System.out.println("InterfaceSideEffects.main()");
    Impl i = new Impl();
    System.out.println("Impl initialized");
    i.bla();
    System.out.println("Impl instance method invoked");
    Foo f = new Impl();
    System.out.println("Impl initialized and assigned to Foo");
    f.bla();
    System.out.println("Foo interface method invoked");
    // System.out.println(Foo.dummy);//This I have added to check whether the dummy
    // is getting initialised at all.
    // System.out.println(i.dummy);//This proves that initialization of dummy to 0
    // is done

  }
}
// The question is to guess the output of the above mentioned program
//
// 1. After getting into main function, the first statement
// "InterfaceSideEffects.main" gets printed.
// 2. Then in the next line there is an object of type Impl being initiated.
// This means right before this Interface code runs and it calls the Bar method
// which prints the statement
// "Interface Foo initialized"
// 3. After this the statement "Impl initialized" is printed
// 4. After this i.bla() produces no output because it is an empty void function
// 5.Then the print statement containing the statement "Impl instance method
// invoked"
// 6. The line Foo f = new Foo() does the same thing as comment 2
// 7. Then the print statement containing the statement "Impl initialized and
// assigned to Foo" gets executed.
// 8. f.bla() calls the function present in the class Impl and it prints nothing
// 9. The program ends with the last statement by printing "Foo interface method
// invoked"
// My final solution is
// InterfaceSideEffects.main
// Interface Foo initialized
// Impl initialized
// Impl instance method invoked
// Impl initialized and assigned to Foo
// Foo interface method invoked
/*
 * But the solution I thought was different from the output that I got. The
 * comments 2 and 6 didn't print anything. However, the initialisation of dummy
 * to 0 is done. This is considered as an error associated with java interfaces.
 * This is one of the problems with JVM which hasn't been resolved yet.
 * Basically this happens whenever a static method outside the interface is
 * called from an interface and initialised to a final variable.
 */

// -> Inner class has been provided as a solution to this problem.
// -> Had the interface been an abstract class it would have worked fine.
