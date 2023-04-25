import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManTest {

    @Test
    void testGetHitPoints() {
        Man m = new Man(2000,200,92);
        assertEquals(2000, m.getHitPoints());
    }

    @Test
    void testSetHitPoints() {
        Man m = new Man(2000,200,92);
        m.setHitPoints(1999);
        assertEquals(1999, m.getHitPoints());
    }

    @Test
    void negativeHitPointsThrowsIAE() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Man(-2,200,92);
        });
        assertEquals( "HP less than 0", e.getMessage());
    }

    @Test
    void setNegativeHitPointsThrowsIAE() {
         assertThrows(IllegalArgumentException.class, () -> {
         Man m = new Man(-500,200,92);
         m.setHitPoints(-2555);
      });
    }

    @Test
    void testGetAttackPower() {
        Man m = new Man(1999, 200, 91);
        assertEquals(200, m.getAttackPower());
    }

    @Test
    void testSetAttackPower() {
        Man m = new Man(1999, 200, 91);
        m.setAttackPower(199);
        assertEquals(199, m.getAttackPower());
    }

    @Test
    void testNegativeAttackPowerInConstructor() {
        Man m = new Man(1999, -200, 91);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testSetNegativeAttackPower() {
        Man m = new Man(1999, 200, 91);
        m.setAttackPower(-199);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testGetDefensePower() {
        Man m = new Man(1999, 200, 91);
        assertEquals(91, m.getDefensePower());
    }

    @Test
    void testGetDefensePowerWhenNegative() {
        Man m = new Man(1999, 200, -91);
        assertEquals(-91, m.getDefensePower());
    }

    @Test
    void testManaIsZero() {
        Man m = new Man(1999, 200, 91);
        assertEquals(0,m.getMana());
    }

    @Test
    void testGetMaxHealth() {
        Man m = new Man(2000,200,92);
        assertEquals(2500, m.getMaxHealth());
    }

    @Test
    void testSetNewMaxHealth(){
        Man m = new Man(2000,200,92);
        m.setNewMaxHealth(500);
        assertEquals(3000, m.getMaxHealth());
    }
    
    @Test
    void testGetSwordTypeIron() {
        Man m = new Man(2000,200,92, Man.SwordType.Iron);
        assertEquals(Man.SwordType.Iron, m.getSwordType());
    }

    @Test
    void testGetSwordTypeSteel() {
        Man m = new Man(2000,200,92, Man.SwordType.Steel);
        assertEquals(Man.SwordType.Steel, m.getSwordType());
    }

    @Test
    void testGetSwordTypeMitrhil() {
        Man m = new Man(2000,200,92, Man.SwordType.Mithril);
        assertEquals(Man.SwordType.Mithril, m.getSwordType());
    }

    @Test
    void testGetAttackPowerWithIronSwordType() {
        Man m = new Man(2000,200,92, Man.SwordType.Iron);
        assertEquals(215, m.getAttackPower());
    }

    @Test
    void testGetAttackPowerWithSteelSwordType() {
        Man m = new Man(2000,200,92, Man.SwordType.Steel);
        assertEquals(225, m.getAttackPower());
    }

    @Test
    void testGetAttackPowerWithMithrilSwordType() {
        Man m = new Man(2000,200,92, Man.SwordType.Mithril);
        assertEquals(250, m.getAttackPower());
    }

    @Test
    void testSetSwordTypeToIronWithoutObjectHavingAnyCurrentSword() {
        Man m = new Man(2000,200,92);
        m.setSwordType(Man.SwordType.Iron);
        assertEquals(Man.SwordType.Iron, m.getSwordType());
    }

    @Test
    void testSetSwordTypeToSteelWithoutObjectHavingAnyCurrentSword() {
        Man m = new Man(2000,200,92);
        m.setSwordType(Man.SwordType.Steel);
        assertEquals(Man.SwordType.Steel, m.getSwordType());
    }

    @Test
    void testSetSwordTypeToMithrilWithoutObjectHavingAnyCurrentSword() {
        Man m = new Man(2000,200,92);
        m.setSwordType(Man.SwordType.Mithril);
        assertEquals(Man.SwordType.Mithril, m.getSwordType());
    }

    @Test
    void testSetSwordTypeToIronWithObjectHavingSword() {
        Man m = new Man(2000,200,92, Man.SwordType.Steel);
        m.setSwordType(Man.SwordType.Iron);
        assertEquals(Man.SwordType.Iron, m.getSwordType());
    }

    @Test
    void testSetSwordTypeToSteelWithObjectHavingSword() {
        Man m = new Man(2000,200,92, Man.SwordType.Iron);
        m.setSwordType(Man.SwordType.Steel);
        assertEquals(Man.SwordType.Steel, m.getSwordType());
    }

    @Test
    void testSetSwordTypeToMithrilWithObjectHavingSword() {
        Man m = new Man(2000,200,92, Man.SwordType.Steel);
        m.setSwordType(Man.SwordType.Mithril);
        assertEquals(Man.SwordType.Mithril, m.getSwordType());
    }

    @Test
    void testIsNotResistantToFire() {
        Man man = new Man(2000,200,92, Man.SwordType.Iron);
        assertFalse(man.checkIfResistant(new Fire(10, 50)));
    }

    @Test
    void testIsNotResistantToFrost() {
        Man man = new Man(2000,200,92, Man.SwordType.Steel);
        assertFalse(man.checkIfResistant(new Frost(10, 50)));
    }

    @Test
    void testToString() {
        Man m = new Man(2000, 200, 90, Man.SwordType.Iron);
        assertEquals("HP: 2000, Attack: 215, Defense: 90, Sword: Iron", m.toString());
    }
}