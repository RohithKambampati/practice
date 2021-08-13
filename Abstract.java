package AbstractClasses;

/*
->Abstraction is done to hide implementation details i.e., hiding code and other details that we donot want the user to know.
->Abstract classes are not made public, because the purpose of abstract classes is to provide us a chance to override and implement the methods present in them. If one inherits and doesn't override few methods, then the child class should also be declared abstract to avoid compilation errors.
->An abstract class can have both abstract and concrete functions in them
->An abstract has only declaration and no body
->An abstract class cannot be instantiated
->An abstract class can have final methods
->An abstract method being final doesn't make any sense
->Abstract class can have constructors, they can be accessed by subclasses using super() keyword. But an object of abstract cannot be created
->Order of Access Specifiers (Least to highest visibility) is:
1. Private 2. Default 3. Protected 4. Public
->An absract class can have static methods
->Any static thing is a compile time entity, overriding is an example of dynamic polymorphism which happens during run time. Dynamic polymorphism cannot be done to things that were decided at the compile time
->Static entities donot come to the subclasses through inheritance, so overriding static inheritance is not possible, we are basically creating 2 separate functions one in parent class and one in subclass
*/
abstract class Bike {
  abstract void ride();// default access specifier is used

  void trafficLight() {
    System.out.println("Red light");
  }

  void displaySpeedLimit() {// Concrete functions like this are used the same for all the child classes
    System.out.println("The maximum speed limit is 140 kmph");
  }

  static void takeRightTurn() {
    System.out.println("Taking Right turn");
  }
  // Since the above methods are not of final type, they can be overriden in the
  // subclasses.
  // But with the inclusion of final keyword in the function signature, this
  // function is inherited to all the class that are extending this class and
  // cannot be overriden
}

class Hero extends Bike {
  /*
   * private void ride()//This function signature is invalid. A child method
   * cannot have more restriction than the parent method. As parent class's method
   * is default, this can be default, protected, public
   */
  void ride() {
    System.out.println("Riding a Hero bike");
  }

  // @Override//Uncommenting this would cause an error because the static void
  // takeRightTurn() method of parent has not been inherited at all.
  static void takeRightTurn() {
    System.out.println("Not taking Right turn");
  }
}

class Honda extends Bike {
  void ride() {
    System.out.println("Riding a Honda bike");
  }

  void trafficLight() {
    System.out.println("Green Light");
  }
}

class Bajaj extends Bike {
  void ride() {
    System.out.println("Riding a Bajaj bike");
  }
}

public class Abstract {
  public static void main(String[] args) {
    Bike hero = new Hero();// Using abstract class's object reference is very common. Using a abstract
                           // class's reference we can store objects of child classes.
    // This is called runtime polymorphism
    // It is said that dynamic binding is happening in line "Bike hero = new
    // Hero();" where one object's reference is being used for another object's
    // method. You can only bind parent
    // class object and child class object
    Honda honda = new Honda();
    // one of the advantage of using the parent class's object reference to
    // instantiate the child class is in the future, if you want to assign honda =
    // new Bajaj() that eould totally be possible with above lines of code. But if
    // the object reference of honda is Honda, then it wouldn't be possible to
    // assign honda = new Bajaj().
    // The current implementation makes it more dynamic
    Bike bajaj = new Bajaj();
    hero.ride();// Dynamic method dispatch allows us to use parent class's object reference to
                // call child class method
    hero.displaySpeedLimit();// A call to concrete method of abstract class is made here. The
                             // displaySpeedLimit() function that is inherited by subclass from the abstract
                             // class is used here. There is no direct call happening from line
                             // "hero.displaySpeedLimit();" to parent class.

    hero.trafficLight();
    honda.ride();
    honda.displaySpeedLimit();
    honda.trafficLight();
    bajaj.ride();
    bajaj.displaySpeedLimit();
    bajaj.trafficLight();
    hero.takeRightTurn();// Implements the function present in Bike(parent) class
    Hero.takeRightTurn();// Implements the funciton present in Hero(child) class
    // Now consider this scenario where
    Hero hero2 = new Hero();
    hero2.takeRightTurn();// Implements the function present in Hero(child) class
    Hero.takeRightTurn();// Implements the function present in Hero(child) class
    System.out.print("honda.takeRightTurn(): ");
    honda.takeRightTurn();// Doubt - Even when the Object Reference type of honda is changed from Bike to
                          // Honda, this line is still executing static method of parent class
    System.out.print("honda.takeRightTurn(): ");
    Honda.takeRightTurn();// Doubt - Even when the Object Reference type of honda is changed from Bike to
                          // Honda, this line is still executing static method of parent class
    // Answer to the above doubt is, It looks like Honda has inherited the Bike
    // class's static method. But that is not the case. If the static method is not
    // present in Honda then it looks for the static method in the parent class.
    // That is the reason why we are able to access Bike class's static method with
    // an object of reference type Honda when there is no such static method in
    // Honda class
    /*
     * What is happening here is, basically a static function is bound to its class
     * and when an object of reference type parent is used the static methods
     * present in the parent class are accessed. When an object of reference type
     * child is used the static methods present in the child class can be accessed
     * by using obj.method(). In simple words the static function of the object
     * reference is called.
     */
    // A conclusion wrt to classes, objects, static and non static can be made here
    // Class names to access static members of the class, object names to access non
    // static members of the class

  }
}
