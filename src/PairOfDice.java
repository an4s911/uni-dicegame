/**
 * PairOfDice --- represents two Die objects
 * 
 * @author Anas Bashir
 */
public class PairOfDice {
   private Die die1 = new Die(); // First die
   private Die die2 = new Die(); // Second die

   /**
    * Get faceValue for first die
    * 
    * @return integer faceValue for the first die
    */
   public int getDie1() {
      return die1.getFaceValue();
   }

   /**
    * Set faceValue for first die
    * 
    * @param newFaceValue Integer value between 1 and 6
    */
   public void setDie1(int newFaceValue) {
      die1.setFaceValue(newFaceValue);
   }

   /**
    * Get faceValue for second die
    * 
    * @return integer faceValue for the second die
    */
   public int getDie2() {
      return die2.getFaceValue();
   }

   /**
    * Set faceValue for second die
    * 
    * @param newFaceValue Integer value between 1 and 6
    */
   public void setDie2(int newFaceValue) {
      die2.setFaceValue(newFaceValue);
   }

   /**
    * String representation of PairOfDice object
    *
    * @return both die face values concatenated as a string
    */
   public String toString() {
      return die1 + " " + die2;
   }

   /**
    * Compares two PairOfDice objects for equality
    * 
    * @param anotherPairOfDice PairOfDice object to be compared for equality
    * @return boolean true if both objects are equal, false otherwise
    */
   public boolean equals(PairOfDice anotherPairOfDice) {
      return this.die1.equals(anotherPairOfDice.die1) && this.die2.equals(anotherPairOfDice.die2);
   }

   /**
    * Roll both dice
    */
   public void roll() {
      die1.roll();
      die2.roll();
   }

   /**
    * Get the sum of both dice
    * 
    * @return integer sum of both dice
    */
   public int getDiceSum() {
      return die1.getFaceValue() + die2.getFaceValue();
   }
}
