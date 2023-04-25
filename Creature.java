public abstract class Creature {

    private int hitPoints;
    private int attackPower;
    private int defensePower;
    private Position creaturesPosition;
    private int maxHealth;

    public Creature(int hitPoints, int attackPower, int defensePower) {
        checkHitPointsNotBelowZero(hitPoints);
        checkAttackPowerNotBelowZero(attackPower);
        this.hitPoints = hitPoints;
        this.defensePower = defensePower;
        this.maxHealth = hitPoints + 500;
        //Every character starts with 500 extra HP. Can be adjusted or fixed in another way
    }

    public abstract boolean checkIfResistant(Magic magic);

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        checkHitPointsNotBelowZero(hitPoints);
        if (maxHealth <= hitPoints) {
            this.hitPoints = maxHealth;
        }// If HP happens to go above the limited maxHealth boundry, it should adjust it to maxHealth
        //ex: 2500hp max, but you have at the moment 2300Hp left, drink a 500 potion, so when it reaches above it just adjust it back to max health
        if (maxHealth >= hitPoints) {
            this.hitPoints = hitPoints;
        }//This simply just check if the new HP is same or less than max HP
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setNewMaxHealth(int newMaxHealth) {
        this.maxHealth += newMaxHealth;
    }//raise the max health threshold because of item,skilll or etc

    private void checkHitPointsNotBelowZero(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("HP less than 0");
        }
    }

    public Position getCreaturePosition() {
        return creaturesPosition;
    }

    public void setCreaturePosition(Position position) {
        this.creaturesPosition = position;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attack) {
        checkAttackPowerNotBelowZero(attack);
    }

    private void checkAttackPowerNotBelowZero(int attack) {
        attackPower = Math.max(attack, 0);
    }

    public int getDefensePower() {
        return defensePower;
    }
}