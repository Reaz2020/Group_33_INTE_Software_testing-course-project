import java.util.HashMap;
import java.util.Map;

public class Magician extends Creature {

    // Should never be able to change dmg but still check dmg value even if object is not instansiated.
    private final static int DRAGON_EXTRA_DMG = 30;
    private final static int MAGICIAN_PENALTY_DMG = 50;
    private int mana;
    private Map<String, Magic> magicBook = new HashMap<>(); //Sparar spells här

    public Magician(int hitPoints, int attackPower, int defensePower, int mana) {
        super(hitPoints, attackPower, defensePower);
        checkManaNotBelowZero(mana);
        this.mana = mana;
    }

    @Override
    // Resistant to all magic
    public boolean checkIfResistant(Magic magic) {
        return true;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        checkManaNotBelowZero(mana);
        this.mana = mana;
    }

    // Adding magic if it does not already exist
    public void addMagicToMagicBook(Magic magic) {
        String magicName = magic.getName();
        if (magicBook.get(magicName) == null) {
            magicBook.put(magic.getName(), magic);
        } else {
            throw new IllegalStateException("Spell already exists");
        }
    }

    private void dealDamage(Creature creature, boolean isResistant, int damage, int manaCost) {
        // Checking that Magician is having enough mana
        if (getMana() >= manaCost) {
            if (isResistant) {
                creature.setHitPoints(creature.getHitPoints() - damage / 2);
            } else {
                creature.setHitPoints(creature.getHitPoints() - damage);
            }
            setMana(getMana() - manaCost);
        }
    }

    // Using magic on creature
    public void castMagic(String name, Creature creature) {
        Magic magic = getMagicBook().get(name);
        if (magic != null && creature != null) {
            if (creature instanceof Man) {

                boolean isResistant = creature.checkIfResistant(magic);
                dealDamage(creature, isResistant, magic.getDamage(), magic.getManaCost());

            } else if (creature instanceof Dragon) {

                boolean isResistant = creature.checkIfResistant(magic);
                dealDamage(creature, isResistant, magic.getDamage() + DRAGON_EXTRA_DMG, magic.getManaCost());

            } else if (creature instanceof Magician) {

                boolean isResistant = creature.checkIfResistant(magic);
                dealDamage(creature, isResistant, magic.getDamage() - MAGICIAN_PENALTY_DMG, magic.getManaCost());
            }
        }
    }

    public Map<String, Magic> getMagicBook() {
        return magicBook;
    }

    private void checkManaNotBelowZero(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana less than 0");
        }
    }

    @Override
    public String toString() {
        return "HP: " + getHitPoints() + ", Attack: " + getAttackPower() + ", Defense: " + getDefensePower() + ", Mana: " + getMana();
    }
}
