public class RollingDice {
   public static void main(String[] args) {
      Die myDie = new Die();

      // Testing if Die gets an initial value and it is random
      // and testing getFaceValue method
      System.out.println("Initial face value that is randomly assigned: " + myDie.getFaceValue());

      // Testing setFaceValue method
      myDie.setFaceValue(5);
      System.out.println("After setting face value as 5: " + myDie.getFaceValue());

      // Testing roll method
      myDie.roll();
      System.out.println("After rolling the die once: " + myDie.getFaceValue());

      // Testing toString method
      System.out.println("Die as a String: \n" + myDie.toString());

      // Testing equals method
      Die anotherDie = new Die();
      System.out.println("myDie: " + myDie.getFaceValue());
      System.out.println("anotherDie: " + anotherDie.getFaceValue());

      if (myDie.equals(anotherDie)) {
         System.out.println("Both dice are equal");
      } else {
         System.out.println("Both dice are not equal");
      }

   }
}
