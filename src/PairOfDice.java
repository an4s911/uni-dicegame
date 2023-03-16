public class PairOfDice {
   private Die die1 = new Die();
   private Die die2 = new Die();

   public int getDie1() {
      return die1.getFaceValue();
   }

   public void setDie1(int newFaceValue) {
      die1.setFaceValue(newFaceValue);
   }

   public int getDie2() {
      return die2.getFaceValue();
   }

   public void setDie2(int newFaceValue) {
      die2.setFaceValue(newFaceValue);
   }

   public String toString() {
      return die1.getFaceValue() + " " + die2.getFaceValue();
   }

   public boolean equals(PairOfDice anotherPairOfDice) {
      return this.die1 == anotherPairOfDice.die1 && this.die2 == anotherPairOfDice.die2;
   }

   public void roll() {
      die1.roll();
      die2.roll();
   }

   public int getDiceSum() {
      return die1.getFaceValue() + die2.getFaceValue();
   }
}
