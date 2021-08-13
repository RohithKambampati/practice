package AbstractClasses;

//Create a BankAccount Abstract class with functionalities display accbalance, deposit money, withdraw money as abstract methods, showCurrencyType is the concrete block in the abstract class
//Create 2 child classes say HDFC, SBI. Inside these child classes provide implementations for the abstract methods and then you will also use the currency function to print the currency
//Use BankAccount class's object to instantiate the HDFC and SBI objects nad call these methods.
abstract class BankAccount {
  abstract int getAccBalance();

  final static String currType = "INR";

  abstract void depositMoney(int amount);

  abstract void withdrawMoney(int amount);

  String showCurrencyType() {
    return currType;
  }
}

class HDFC extends BankAccount {
  int balance;

  HDFC(int balance) {
    this.balance = balance;
  }

  int getAccBalance() {
    System.out.println("The balance is: " + this.balance + " " + showCurrencyType());
    return this.balance;
  }

  void depositMoney(int amount) {
    this.balance += amount;
  }

  void withdrawMoney(int amount) {
    if (amount > getAccBalance()) {
      System.out.println("Insufficient funds");

    } else {
      this.balance = this.balance - amount;
    }
  }
}

class SBI extends BankAccount {
  int balance;

  SBI(int balance) {
    this.balance = balance;
  }

  int getAccBalance() {
    System.out.println("The balance is: " + this.balance + " " + showCurrencyType());
    return this.balance;
  }

  void depositMoney(int amount) {
    this.balance += amount;
  }

  void withdrawMoney(int amount) {
    if (amount < getAccBalance()) {
      System.out.println("Insufficient funds");
    } else {
      this.balance = this.balance - amount;
    }
  }
}

public class AbstractClassesTask {
  public static void main(String[] args) {
    BankAccount hdfc = new HDFC(1000);
    BankAccount sbi = new SBI(10000);
    hdfc.showCurrencyType();
    int bal = hdfc.getAccBalance();
    hdfc.depositMoney(1000);
    bal = hdfc.getAccBalance();
    hdfc.withdrawMoney(100000);
    bal = hdfc.getAccBalance();
    sbi.showCurrencyType();

  }
}