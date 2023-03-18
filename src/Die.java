import java.util.Random;

/**
 * Die --- represents a single die.
 * 
 * @author Anas Bashir
 */
public class Die {
   private int faceValue; // The value of the die.
   public final int MAX = 6; // Max value for the die.

   /**
    * Die class Constructor
    */
   public Die() {
      roll();
   }

   /**
    * Roll the die. Sets a random face value between 1 and 6.
    * 
    * @param no parameters
    */
   public void roll() {
      Random random = new Random();
      int RandomFaceValue = random.nextInt(MAX) + 1;
      this.setFaceValue(RandomFaceValue);
   }

   /**
    * Set the face value of the die
    * 
    * @param value
    */
   public void setFaceValue(int value) {
      this.faceValue = value;
   }

   /**
    * Return the face value of the die
    * 
    * @return int this.faceValue
    */
   public int getFaceValue() {
      return this.faceValue;
   }

   /**
    * Converts faceValue of the die to a string.
    * 
    * @return String of the faceValue
    */
   public String toString() {
      return Integer.toString(this.faceValue);
   }

   /**
    * Compares two current Die object with another Die
    * 
    * @param otherDie
    * @return boolean, true if they are equal, false otherwise
    */
   public boolean equals(Die otherDie) {
      return this.faceValue == otherDie.getFaceValue();
   }
}