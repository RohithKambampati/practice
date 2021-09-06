package ThisKeyWord;

// interface Bank{
//   int accNo;
//   int userId;
// }
class BankAcc {
  int accNo;

  BankAcc(int accNo) {
    this.accNo = accNo;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Account number is: " + accNo;
  }
}

class OnlineBankAcc extends BankAcc {
  int userId;

  OnlineBankAcc(int accNo, int userId) {
    super(accNo);
    this.userId = userId;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Account number is: " + accNo + ", User Id is: " + userId;
  }
}

public class BankAccTest {
  public static void main(String[] args) {
    BankAcc bankAcc = new BankAcc(123456);
    OnlineBankAcc onlineBankAcc = new OnlineBankAcc(123456, 7654321);
    System.out.println(bankAcc);
    System.out.println(onlineBankAcc);
  }
}
