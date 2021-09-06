package ExceptionHandling;

class Test {
  static int demo() {
    try {
      return 1;

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Finally");
      return 100;
    }
    // return -1;
  }
}

public class TryFinallyWithReturn {
  public static void main(String[] args) {
    System.out.println(Test.demo());
  }
}