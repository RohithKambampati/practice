package ThisKeyWord;

class TestThisWithMethods {
  void foo(TestThisWithMethods obj) {
    System.out.println("foo method invoked : " + obj);
  }

  void bar() {
    TestThisWithMethods obj = new TestThisWithMethods();
    foo(obj);
    // Shortcut for the above is:
    foo(this);
  }
}

public class ThisAndMethods {
  public static void main(String[] args) {
    TestThisWithMethods obj = new TestThisWithMethods();
    obj.bar();
  }
}
