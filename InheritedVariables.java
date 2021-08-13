
// class A {
//   int a = 10;
//   // private int a = 10;//Even declaring the variable a doesn't solve the problem
//   // of b.display() accessing the value of a in class B. It still produces the
//   // output as A::a only, not B::a

//   void display() {
//     System.out.println("The value of a in parent class is: " + a);// Here writing a is similar to writing A::a (:: is
//                                                                   // called scope resolution operator in c)
//   }
// }

// class B extends A {
//   int a = 100;

//   void show() {
//     System.out.println("The value of a in child class (via show) is: " + a);// Here writing a is similar to writing B::a
//   }

//   // If display function is not overriden b.display() is going to be executed as
//   // System.out.println("The value of a in parent class is: " + A::a")
//   // void display() {
//   // System.out.println("The value of a in child class (via display) is: " + a);
//   // }// By adding these 3 lines b.display() is being called in child class
// }

// public class InheritedVariables{
//   public static void main(String[] args) {
//     A a = new A();
//     B b = new B();
//     a.display();
//     b.display();
//     b.show();
//     C c = new C();
//     c.display();
//     D d = new D();
//     d.display();
//   }
// }

// In by overriding the display method you can display the value in the child
// class. Without overriding the b.display() is still accessing the value
// present in the parent class as seen with the scope resolution operator.
// There is another way to do it without overriding
// class C {
//   static int a = 10;

//   void display() {
//     System.out.println("The value of a is: " + a);
//   }
// }

// class D extends C {
//   D() {
//     C.a = 100;
//   }

// }

// public class InheritedVariables {
//   public static void main(String[] args) {
//     C c = new C();
// System.out.print("c.display");
//     c.display();
//     D d = new D();
//     d.display();
// System.out.print("d.display");
//     c.display();
// System.out.print("c.display");
//   }
// }
//This is another way to display the value without overriding. But the drawback of this method is, since the variable a in C is static int, it gets replaced in the constructor, which means losing of data

//There is one more implementation by using super keyword
class E {
  int a = 10;

  E() {

  }

  E(int a) {
    this.a = a;
  }

  void display() {
    System.out.println("The value of a is: " + a);
  }
}

class F extends E {
  F() {
    super(100);
  }
}

public class InheritedVariables {
  public static void main(String[] args) {
    E e = new E();
    System.out.print("e.display: ");
    e.display();
    F f = new F();
    System.out.print("f.display: ");
    f.display();
    System.out.print("e.display: ");
    e.display();
  }
}
// This is the smartes implementation, without overriding using Super Keyword
