package AbstractClasses;

abstract class ParentAbstract {
  public static int parentInt = 1090;
  // static final int x;
  static {
    // x = 5;
    System.out.println("Inside the static block of parent");
  }

  ParentAbstract() {
    System.out.println("Parent constructor");
  }

  public void parentMethod() {
    System.out.println("Method in parent called");
  }

}

class Child extends ParentAbstract {
  // static final int x;
  public int childInt = 1000;
  static {
    // x = 10;
    System.out.println("Inside the static block of child");
  }

  Child() {
    System.out.println("Child constructor");
  }

  public void childMethod() {
    System.out.println("Method in child called");
    // System.out.println("The value of x is: " + x);

  }
}

public class StaticBlocksAndAbstractClasses {
  public static void main(String[] args) {
    System.out.println("Inside main function");
    Child c = new Child();
    c.parentMethod();
    // ParentAbstract p = new Child();//This linking of parent and child classes id
    // done during run time and the next line is also decided during run time only.
    // p.parentMethod();//Dynamic method dispatch
    // Dynamic method dispatch is achieved by using the concept of Runtime
    // polymorphism
    // c.childMethod();
    // While executing the above line uncomment the declaration of x in parent,
    // child classes and the println statement in childMethod(). Then
    // c.childMethod() also prints the value of static final int x in Child class
    // and not the value in parent class. This is called shadowing in Java
  }
}
// Q1. Consider the above question and answer which statements get printed,
// their sequence and the reason why it gets printed.
/*
 * My solution is: when Child c = new Child() is executed- 1. It is calling the
 * static block of Child needs to be executed but as it is extending from a
 * parent class, I believe static of the parent is executed first and then the
 * static of the child class 2. Next the constructor of the Child class should
 * technically be called, but as extending is happening from parent class Parent
 * constructor gets executed first and then the Child constructor. 3. Lastly
 * since there are no more static and constructor elements, the execution is
 * moved to the next line which is calling the parentMethod(). Since the method
 * is not of static nature it gets inherited and executed. Final result:
 * ->>>>>>>Inside main finction ->>>>>>>Inside the static block of Parent
 * ->>>>>>>Inside the static block of Child ->>>>>>>Parent constructor
 * ->>>>>>>Child constructor ->>>>>>>Method in parent called. A more robust and
 * beautiful reasoning for Why not "Inside main function. Inside the static
 * block of Parent. Parent constructor. Inside the static block of Child. Child
 * constructor. Method in parent called." is printed is that, the compiler takes
 * care of class members first and then constructors i.e., due to inheritance,
 * the parent class is loaded first and then the child class is loaded. The
 * question arises why not the above the sequence and not the sequence that we
 * got, the reason is that the members in the static block of Parent are created
 * first but before going to the constructor the compiler looks for other static
 * members even in the child class then it goes to constructor. This is due to
 * the fact that if there is a static final int x in parent and child classes,
 * then if Parent constructor is initialized right after parent static block, if
 * shadowing occurs in child static block then it wouldn't make difference to
 * parent static block. If static block of child class is executed right after
 * the execution of parent static block then if there is any shoadowing occuring
 * in child static block that can be taken care of immediately.
 */
// Since I am awesome, I got results exactly right!!
// Q2. In the above case if the line c.parentMethod() is commented, what would
// the result be?
/*
 * My solution for this is: Everything up until calling constructor is executed
 * in the line when Child c = new Child() is executed.
 */
// I am on fire, I scored this right as well.
// Q3. In the above code what would happen if the object reference used is
// Parent p = new Child() instead of using Child object's reference.
/*
 * My guess would be that nothing changes, everything still follows the same as
 * in Q1. Even if the object reference changes the calling of constructor in
 * Child class has to be preceeded by class extension and constructor calling.
 * So this change doesn't make a difference
 */
// Woohoo! I am right again.
// Q4. What if