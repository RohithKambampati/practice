package ThisKeyWord;

class SuperAndThis {
  SuperAndThis() {
    System.out.println("Non parameterized super constructor");
  }

  SuperAndThis(String msg) {
    this();
    System.out.println("Parameterized Super constructor: " + msg);
  }
}

public class ThisConstructorCall extends SuperAndThis {
  ThisConstructorCall() {
    // The first line of this constructor anyhow calls the non parameterized
    // constructor of the super. But it can be overridden
    super("I am awesome");// This can be used to invoke the parameterized constructor. This is allowed.
    // this();//Java doesn't allow calling the same constructor from the constructor
    System.out.println("Non parameterized constructor");
  }

  ThisConstructorCall(String msg) {
    // this();
    // super(msg);// But here, the constructor call this() already created super("I
    // am awesome") constructor. Each object can be associated with only one
    // constructor call. Had there been no this() call in the constructor, this
    // would have worked fine.
    // Making super the first statement in this constructor call still doesn't solve
    // the problem because the constructor call this() should be the first statement
    System.out.println("Parameterized constructor 1: " + msg);
  }

  ThisConstructorCall(String msg1, String msg2) {
    this(msg1);
    System.out.println("Parameterized constructor 2: " + msg2);
  }

  public static void main(String[] args) {
    // ThisConstructorCall obj1 = new ThisConstructorCall();
    // ThisConstructorCall obj2 = new ThisConstructorCall("Rohith");
    ThisConstructorCall obj3 = new ThisConstructorCall("Rohith", "Kambampati");
    System.out.println(System.getProperty("java.class.path"));
  }

}
