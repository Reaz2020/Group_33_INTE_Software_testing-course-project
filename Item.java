public class Item {

    public enum PotionType {
        HEALTH
    }

    private final PotionType potionType; //What kind of potion it is, ex: Health or Mana
    private int potionAmmount; //The amount it carries

    public Item(PotionType potionType, int potionAmmount) {
        //If the ammount is below zero, it should not be created at throw an IAE
        if (potionAmmount < 0) {
            throw new IllegalArgumentException("Potion ammount must be 0 or higher" + potionAmmount);

        }//If potionammount < 0
        this.potionType = potionType;
        this.potionAmmount = potionAmmount;
    }//Item constructor


    public PotionType getPotionType() {
        return potionType;
    }//getPotionType

    public int getPotionAmmount() {
        return potionAmmount;
    }//getPotionAmmount

    public void setPotionAmmount(int potionAmmount) {
        //This scenario shouldn't happen in theory, it only decreases the ammount it has but this is implemented as a "if scenario"-
        if (potionAmmount < 0) {
            throw new IllegalStateException("Something went wrongg, potion used up more than is should had");
        }// if potionAmmount < 0
        this.potionAmmount = potionAmmount;
    }//setPotionAmmount

    public void usePotion(Creature p, Item i) {
        //This if-equals is a temprorary thing, change it later stage of the project but for now it works if you limit to only Health potion
        if (i.potionType.equals(PotionType.HEALTH)) {
            int tempHP = p.getHitPoints(); //HP is brought to a tempHP holder
            int tempAmmount = i.getPotionAmmount();//Pottion ammount is brought to a temp holder
            tempHP += tempAmmount; //Add these two temp holders together
            p.setHitPoints(tempHP); //Set now the new value from the temp to the player
            tempAmmount -= i.potionAmmount; //Decrease the ammount of the potion
            i.setPotionAmmount(tempAmmount); //Set the new ammount

        }//if potionType is Health
    }

    @Override
    public String toString() {
        return "This is a " + getPotionType() + " Potion, with the amount " + getPotionAmmount();
    }//To String method
}//Class Item
