package ExceptionHandling;

class myException {
  void foo() throws Exception {
    int[] a = { 0, 0 };

    int b = a[2] & 1 / 0;// Whichever is declared first is thrown
  }
}

public class AndingExceptions {
  public static void main(String[] args) throws Exception {
    myException me = new myException();
    try {
      me.foo();
    } catch (Exception e) {
      System.out.println(e.getClass());
    }

  }
}
