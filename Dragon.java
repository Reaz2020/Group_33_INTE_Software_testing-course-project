public class Dragon extends Creature {

    // Should never be able to change dmg but still check dmg value even if object is not instansiated.
    public static final int SUPER_ATTACK_DMG = 400;

    @Override
    public boolean checkIfResistant(Magic magic) {
        return magic instanceof Fire;
    }

    public Dragon(int hitPoints, int attackPower, int defensePower) { super(hitPoints, attackPower, defensePower);
    }

    @Override
    public String toString() {
        return "HP: " + getHitPoints() + ", Attack: " + getAttackPower() + ", Defense: " + getDefensePower();
    }
}
