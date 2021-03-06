package Interfaces;

interface Vehicle {
  void start();// By default these two methods are associated with public and abstract
               // modifiers

  void stop();

  int getNoOfWheels();

  default void displaySpeed() {
    // declaring this function that has a body without a modifier in an interface
    // causes a compilation error because, these by default are public abstract and
    // abstract methods cannot have a body. To resolve this the modifier - default
    // is included
    System.out.println("The speed is 40kmph");
    putGas();
  }

  static void putGas() {
    // this static method can be invoked by using Vehicle.putGas(), just like any
    // other static method and also this can be called in the default method of the
    // same interface
    System.out.println("Message from static function" + ": " + "Please put gas");
  }

  private String displayMessage() {
    // private methods can be declared in an interface but they cannot be overriden.
    // They must only be used by other methods present in the interface
    // Then the default method that is calling methods like this is known as an
    // anchor method
    return "New Notification";

  }
}

class Car implements Vehicle {// The difference between class extension and implementing interface is A calss
  // can only extend one class, whereas an interface can implement more than one
  // interface at a time.
  public void start() {
    // If you don't want to override this function, define it as abstract. And if
    // public keyword is not associated with it is going to throw an error because
    // in the interface the method is by default a public abstract method, when no
    // modifier is mentioned. That is not the case with classes. Here if no access
    // modifier is metioned, it is considered to be of type default. When overriding
    // a function, the thumb rule is to not reduce the visibility of the method in
    // the parent, in this case the inteface Vehicle.
    System.out.println("Car started");
  }

  public void stop() {
    System.out.println("Car stopped");
  }

  public int getNoOfWheels() {
    return 4;
  }

  void applyBrake() {
    System.out.println("Brake applied");
  }
}

class Bike implements Vehicle {

  public int getNoOfWheels() {

    return 2;
  }

  public void start() {
    System.out.println("Bike started");
  }

  public void stop() {
    System.out.println("Bike stopped");

  }

}

public class Interfaces {
  public static void main(String[] args) {
    // Car c = new Car();
    Vehicle car = new Car();
    car.start();
    car.stop();
    System.out.println("The number of wheels in the car are " + car.getNoOfWheels());
    car.displaySpeed();
    // car.applyBrake();//This will be undefined for the type Vehicle
    Vehicle bike = new Bike();
    bike.start();
    bike.stop();
    System.out.println("The number of wheels in the bike are " + bike.getNoOfWheels());
    bike.displaySpeed();
    // It is best practice to define an object of reference type of the Interface
    // and not the class that is implementing class. Say the blueprint of the class
    // i.e., the interface (Vehicle in this case) is given to somebody to develop a
    // class. And if they have created new methods apart from the ones present in
    // the interface (applyBrake in this case), which are not required by you, then
    // creating an object of
    // reference type of implementing class(Car in this case) makes the user to
    // access the unwanted function in Car class. To avoid this, declaration of
    // object reference type Interface(Vehicle in this case) is necessary.
    // By using dynamic binding here we are restricting the number of features.
  }
}
