import java.util.Random;

public class Die {
   private int faceValue;
   public final int MAX = 6;

   public Die() {
      roll();
   }

   public void roll() {
      Random random = new Random();
      int RandomFaceValue = random.nextInt(MAX) + 1;
      this.setFaceValue(RandomFaceValue);
   }

   public void setFaceValue(int value) {
      this.faceValue = value;
   }

   public int getFaceValue() {
      return this.faceValue;
   }

   public String toString() {
      return Integer.toString(this.faceValue);
   }

   public boolean equals(Die otherDie) {
      return this.faceValue == otherDie.getFaceValue();
   }
}