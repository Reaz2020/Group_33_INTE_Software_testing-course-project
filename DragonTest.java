import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    @Test
    void testGetHitPoints() {
        Dragon m = new Dragon(2000, 200, 92);
        assertEquals(2000, m.getHitPoints());
    }

    @Test
    void negativeHitPointsThrowsIAE() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Dragon m = new Dragon(-2000, 200, 92);
        });
        assertEquals("HP less than 0", e.getMessage());
    }

    @Test
    void setHitPoints() {
        Dragon m = new Dragon(2000, 200, 92);
        m.setHitPoints(1900);
        assertEquals(1900, m.getHitPoints());
    }

    @Test
    void setNegativeHitPointsThrowsIAE() {
         assertThrows(IllegalArgumentException.class, () -> {
            Dragon m = new Dragon(2000, 200, 92);
            m.setHitPoints(-2000);
        });
    }

    @Test
    void testGetAttackPower() {
        Dragon m = new Dragon(2000, 200, 92);
        assertEquals(200, m.getAttackPower());
    }

    @Test
    void testSetAttackPower() {
        Dragon m = new Dragon(2000, 200, 92);
        m.setAttackPower(199);
        assertEquals(199, m.getAttackPower());
    }

    @Test
    void testNegativeAttackPowerInConstructor() {
        Dragon m = new Dragon(2000, -200, 92);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testSetNegativeAttackPower() {
        Dragon m = new Dragon(2000, 200, 92);
        m.setAttackPower(-199);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testGetDefensePower() {
        Dragon m = new Dragon(2000, 200, 92);
        assertEquals(92, m.getDefensePower());
    }

    @Test
    void testIsNotResistantToFire() {
        Dragon dragon = new Dragon(2000, 200, 92);
        assertTrue(dragon.checkIfResistant(new Fire(10, 50)));
    }

    @Test
    void testIsResistantToFrost() {
        Dragon dragon = new Dragon(2000, 200, 92);
        assertFalse(dragon.checkIfResistant(new Frost(10, 50)));
    }

    @Test
    void testToString() {
        Dragon dragon = new Dragon(2000, 200, 92);
        assertEquals("HP: 2000, Attack: 200, Defense: 92", dragon.toString());
    }
}