
public abstract class Magic {


    private int manaCost; //How much mana the magic should cost
    private final String name; //Name of the Magic
    private int damage; //Damage output of the magic
    private boolean fire = false; //Pre-set to false, if the attribute of the magic is this, it will be set to true
    private boolean frost = false; //Pre-set to false, if the attribute of the magic is this, it will be set to true

    public Magic(String name, int manaCost, int damage) {
        //Checks if the manaCost or Damage output is not below zero, if it is, IEA
        if (manaCost < 0 || damage < 0) {
            throw new IllegalArgumentException("Must have a name, manacost/damage must be either 0 or above");
        }// if manaCost < 0 || damage < 0
        this.name = name;
        this.manaCost = manaCost;
        this.damage = damage;
    }//Magic constructor

    public boolean isFire() {
        return fire;
    }// isFire

    public boolean isFrost() {
        return frost;
    }//isFrost

    public void setFire(boolean fire) {
        this.fire = fire;
    }//setFire

    public void setFrost(boolean frost) {
        this.frost = frost;
    }//setFrost

    //Find out what this spell can do kind of damage
    public int getDamage() {
        return damage;
    }//getDamage

    //To find out how much mana it will cost to use this spell
    public int getManaCost() {
        return manaCost;
    }//getManaCost

    //Race, profession and special item can affect manacost
    public void setManaCost(int manaCost) {
        //Auto adjust manaCost to zero if it drops below zero because of skills/ability/items
        if (manaCost < 0) {
            manaCost = 0;
        }//Auto adjust manaCost to zero if it drops below zero because of skills/ability/items
        this.manaCost = manaCost;
    }//setManaCost

    //Race, profession and special item can affect damage output
    public void setDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }//Auto adjust damage to zero if it drops below zero because of skills/ability/items/debuffer
        this.damage = damage;
    }//setDamage


    public String getName() {
        return name;
    }//getName

    //toString method to show/know how it should me presented/saved
    @Override
    public String toString() {
        return "Name = " + getName() + ", ManaCost = " + getManaCost() + ", Damage = " + getDamage();
    }//toString
}//Class Magic
