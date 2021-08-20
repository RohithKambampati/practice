package Interfaces.NestedClasses.AnonymousInnerClasses;

interface MyInterface {
  void interfaceFun();// Nature of this function is public abstract
}

abstract class MyAbstractClass {
  abstract void abstractFun();

  void print() {
    int x = 10;
    System.out.println("Inherited from abstract class " + x);
  }
}

class ImplementingInterface implements MyInterface {
  public void interfaceFun() {
    System.out.println("Concrete implementation for Interface method");
  }
}

public class AnonymousClass {
  public static void main(String[] args) {
    // Case1: Anonymous classes in case of interfaces
    // Interface is implemented and then we created an object to access the methods
    // in the class.
    MyInterface obj = new ImplementingInterface();
    System.out.println("Using the object of the class that implements the interface");
    obj.interfaceFun();
    // There is another way to do the above without implementing the interface
    MyInterface obj2 = new MyInterface() {
      public void interfaceFun() {
        System.out.println("Concrete implementation for Interface method");
        anonOwnMethod();
      }

      public void anonOwnMethod() {// this can be static and non static
        System.out.println("This is the Own method of anon class");// This own method for an inner class is valid, but
                                                                   // the scope of this method is inside the anonymous
                                                                   // class only. Even if it is public this cannot be
                                                                   // accessed outside the anonymous class
      }
    };// This essentially does the same as implementing an interface. It might seem
      // like the above line is creating an object of MyInterface. But that is not
      // what is happening. It is just a short form syntax of a class implementing an
      // interface. The name of this is decided by the JVM, we do not have to provide
      // the name of the class hence the name anonymous class. The JRE interpreter
      // converts this name less class into a separate class.
    // The above syntax works only if we are trying to implement single interface.
    // If there are multiple interfaces we want to implement in a class, we have to
    // go back to the classic way of doing it by creating a separate class.
    System.out.println("Using anonymous class");
    obj2.interfaceFun();
    // obj2.anonOwnMethod();//Is not accessible as the obj2 is of reference type My
    // Interface and MyInterface doesn't have the anonOwnMethod. This is just like
    // how it happens in case of implementing interfaces normally
    // Case2: Anonymous inner classes in case of Abstract class
    MyAbstractClass obj3 = new MyAbstractClass() {
      int x = 1000;

      public void abstractFun() {
        System.out.println("Concrete implementation for abstractFun method");
      }

      @Override
      public void print() {
        System.out.println("Inherited from abstract class " + x);// Usually no need to Override. But if there was a
                                                                 // class variable in it. Then one way to print the
                                                                 // current class's instance variable is to Override
                                                                 // previous method.
      }
    };
    // This is basically a syntactic sugar for extending the abstract class and
    // creating a new anonymous class. The same syntax can be used to extend a non
    // abstract class and the results would be the same. In that case too, you
    // wouldn't be able to create the own method of this new anonymous class,
    // because it is using the object reference of the parent.
    obj3.abstractFun();
    obj3.print();
  }

}
