public class Frost extends Magic {


    private static final String NAME_FROST = "Frost";// Name of the set is final and cannot be changed.

    //Basic constrcutor, the name is already pre-set, only manaCost and damage need to be fed into the constructor
    public Frost(int manaCost, int damage) {
        super(NAME_FROST, manaCost, damage);
        setFrost(true);
    }//Frost Constructor
}//Class Frost
