import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrostTest {

    @Test
    void getMethodTestTheNameOfTheMagic() {
        Frost m = new Frost(10, 5);
        assertEquals("Frost", m.getName());
    }

    @Test
    void getMethodTestostOfTheMagic() {
        Frost m = new Frost(10, 5);
        assertEquals(10, m.getManaCost());
    }

    @Test
    void isMagicFrostBooleanReturnTrue(){
        Frost m = new Frost(10, 5);
        assertTrue(m.isFrost());
    }

    @Test
    void isMagicFireBooleanReturnFalse(){
        Frost m = new Frost(10, 5);
        assertFalse(m.isFire());
    }

    @Test
    void manaCostThrowIAENegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Frost( -1, 0);
        });
    }

    @Test
    void damageThrowIAENegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Frost( 0, -1);
        });
    }

    @Test
    void toStringFormatForTheMagic() {
        Frost m = new Frost( 10, 5);
        assertEquals("Name = Frost, ManaCost = 10, Damage = 5", m.toString());
    }

    @Test
    void zeroBeingAcceptedAsManaCostAndDamage() {
        Frost m = new Frost( 0, 0);
        assertEquals("Name = Frost, ManaCost = 0, Damage = 0", m.toString());

    }

    @Test
    void setManaCostToANewCost(){
        Frost m = new Frost( 10, 5);
        m.setManaCost(2);
        assertEquals(2, m.getManaCost());
    }

    @Test
    void setManaCostToBelowZeroAndCheckIfItAutoAdjustToZero(){
        Frost m = new Frost( 10, 5);
        m.setManaCost(-2);
        assertEquals(0, m.getManaCost());
    }

    @Test
    void setDamageToANewDamageOutput(){
        Frost m = new Frost( 10, 5);
        m.setDamage(12);
        assertEquals(12, m.getDamage());
    }

    @Test
    void setDamageBelowZeroAutoAdjustFixItToZero(){
        Frost m = new Frost( 10, 5);
        m.setDamage(-5);
        assertEquals(0, m.getDamage());
    }

}