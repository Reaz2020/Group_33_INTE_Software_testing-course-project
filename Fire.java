public class Fire extends Magic {


    private static final String NANME_FIRE = "Fire";// Name of the set is final and cannot be changed.

    //Basic constrcutor, the name is already pre-set, only manaCost and damage need to be fed into the constructor
    public Fire(int manaCost, int damage) {
        super(NANME_FIRE, manaCost, damage);
        setFire(true);

    }//Fire Constructor
}//Class Fire
