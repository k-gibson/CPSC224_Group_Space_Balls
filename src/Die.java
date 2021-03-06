/**
* This class stores the face value of a dice to use playing Race Through Space.
* It contains the methods to roll the dice, and get the face value of the die
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class Die.java
* @author Alana Dillinger
* @version v1.0 5/4/2018
*/

import java.util.*;

public class Die{
  // We don't need any GUI in this class
  public static enum Planet{MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE};
  public Planet planet;
  private Random rand;

  /**
  * Die constructor stores an enumerated type Planet which stored the current face value of the die
  * and and Random object used for rolling the die
  */
  public Die() {
    Planet planet;
    rand = new Random();
  }

  /**
  * "Rolls the die" or assigns a random integer between 1 and 6 to the die's value
  * Converts that integer to the corresponding planet
  */
  public void roll(int numberOfSides) {
    int value = rand.nextInt(numberOfSides);
    if(value ==0) planet = Planet.MERCURY;
    if(value ==1) planet = Planet.VENUS;
    if(value ==2) planet = Planet.MARS;
    if(value ==3) planet = Planet.JUPITER;
    if(value ==4) planet = Planet.SATURN;
    if(value ==5) planet = Planet.URANUS;
    if(value ==6) planet = Planet.NEPTUNE;
  }

  /**
    * Retrieves the value of a certain die
    * @return and integer of the value stored in that die
    */
  public Planet getValue() {
    return (this.planet);
  }
}