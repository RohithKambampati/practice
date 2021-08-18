package NestedInterfaces;

interface Doable {
  void doSomethingDoable();

  interface Nested {
    void doSomethingNested();
  }
}

class Implementor implements Doable.Nested {
  // public void doSomethingDoable() {
  // System.out.println("Printing from Doable Interface -> Doable.Nested is
  // inherited");
  // }// Writing these methods is basically writing new functions and hence
  // overriding is also not possible.

  public void doSomethingNested() {
    System.out.println("Printing from Nested Interface -> Doable.Nested is inherited");
  }
}

class Implementor2 implements Doable {
  public void doSomethingDoable() {
    System.out.println("Printing from Doable Interface -> Doable is inherited");
  }

  // public void doSomethingNested() {
  // System.out.println("Printing from Nested Interface -> Doable is inherited");
  // } // Writing these methods is basically writing new functions and hence
  // overriding is also not possible.
  // interface Nested {
  // static void blablabla();// This is creating new interface named Nested. It
  // diesn't mean overriding the Doable interface's nested interface because
  // nested interface behaves as if it is a static thing.
  // }
}

public class NestedInterface {
  public static void main(String[] args) {
    Implementor i = new Implementor();
    // i.doSomethingDoable();// There is no such method present
    i.doSomethingNested();
    Implementor2 i2 = new Implementor2();
    i2.doSomethingDoable();
    // i2.doSomethingNested();// There is no such method present
  }
}
