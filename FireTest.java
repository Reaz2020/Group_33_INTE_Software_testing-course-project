import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireTest {

    @Test
    void getMethodTestTheNameOfTheMagic() {
        Fire m = new Fire(10, 5);
        assertEquals("Fire", m.getName());
    }

    @Test
    void getMethodTestostOfTheMagic() {
        Fire m = new Fire( 10, 5);
        assertEquals(10, m.getManaCost());
    }

    @Test
    void isMagicFireBooleanReturnTrue(){
        Fire m = new Fire( 10, 5);
        assertTrue(m.isFire());
    }

    @Test
    void isMagicFrostBooleanReturnFalse(){
        Fire m = new Fire( 10, 5);
        assertFalse(m.isFrost());
    }

    @Test
    void manaCostThrowIAENegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fire( -1, 0);
        });
    }

    @Test
    void damageThrowIAENegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fire( 0, -1);
        });
    }

    @Test
    void toStringFormatForTheMagic() {
        Fire m = new Fire( 10, 5);
        assertEquals("Name = Fire, ManaCost = 10, Damage = 5", m.toString());
    }

    @Test
    void zeroBeingAcceptedAsManaCostAndDamage() {
        Fire m = new Fire( 0, 0);
        assertEquals("Name = Fire, ManaCost = 0, Damage = 0", m.toString());

    }

    @Test
    void setManaCostToANewCost(){
        Fire m = new Fire( 10, 5);
        m.setManaCost(2);
        assertEquals(2, m.getManaCost());
    }

    @Test
    void setManaCostToBelowZeroAndCheckIfItAutoAdjustToZero(){
        Fire m = new Fire( 10, 5);
        m.setManaCost(-2);
        assertEquals(0, m.getManaCost());
    }

    @Test
    void setDamageToANewDamageOutput(){
        Fire m = new Fire( 10, 5);
        m.setDamage(12);
        assertEquals(12, m.getDamage());
    }

    @Test
    void setDamageBelowZeroAutoAdjustFixItToZero(){
        Fire m = new Fire( 10, 5);
        m.setDamage(-5);
        assertEquals(0, m.getDamage());
    }

}