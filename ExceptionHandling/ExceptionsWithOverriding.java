package ExceptionHandling;

import java.io.IOException;

class A {
  void foo() throws RuntimeException {
    throw new RuntimeException();// Parent method throws Runtime exception
  }
}

class B extends A {
  @Override
  void foo() throws ArrayIndexOutOfBoundsException {
    throw new ArrayIndexOutOfBoundsException("Array Index out of bounds exception");
  }
}

class C extends A {
  void foo() throws IOException {
    throw new IOException("IO exception");// Overriding method should only throw Run time exception or child class
                                          // exceptions of runtime exceptions
  }
}

class A1 {
  void foo() throws Exception {
    throw new RuntimeException("Run time Exception in A1");
  }
}

class C1 {
  void foo() throws IOException {
    throw new IOException("IO Exception in C1");
  }
}

public class ExceptionsWithOverriding {
  public static void main(String[] args) {
    B b = new B();
    C c = new C();
    C1 c1 = new C1();
    try {
      b.foo();
    } catch (ArithmeticException e) {
      System.out.println(e);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e + " Caught in b.foo()");
    }
    try {
      c1.foo();
    } catch (Exception e) {
      System.out.println(e);
    }
    // try {
    // c.foo();
    // } catch (ArithmeticException e) {
    // System.out.println(e);
    // } catch (ArrayIndexOutOfBoundsException e) {
    // System.out.println(e + " Caught in c.foo()");
    // }

    // throw new ArithmeticException("Arithmetic exception in main");// this is an
    // unchecked exception. it throws exception
    // but no compilation errors

    // throw new IOException("IO exception in main");// Compilation error, because
    // IO is a checked exception and it has to
    // be declared explicitly in the function signature to not cause a
    // compilation error.
    try {
      throw new IOException("IO excpetion in main");
    } catch (Exception e) {
      System.out.println(e);
    }

  }
}
// For the JVM to handle a checked exception, the exception has to be declared
// in the function signature.
// If you donot declare it in function signature, it is your responsibility to
// handle the exception. JVM doesn't catch it, so causes compilation error.