import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicianTest {

    @Test
    void testGetHitPoints() {
        Magician m = new Magician(2000, 200, 92, 40);
        assertEquals(2000, m.getHitPoints());
    }

    @Test
    void negativeHitPointsThrowsIAE() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Magician(-2, 200, 92, 40);
        });
        assertEquals("HP less than 0", e.getMessage());
    }

    @Test
    void setHitPoints() {
        Magician m = new Magician(2000, 200, 92, 40);
        m.setHitPoints(1900);
        assertEquals(1900, m.getHitPoints());
    }

    @Test
    void setNegativeHitPointsThrowsIAE() {
         assertThrows(IllegalArgumentException.class, () -> {
            Magician m = new Magician(2000, 200, 92, 40);
            m.setHitPoints(-2000);
        });
    }

    @Test
    void testGetAttackPower() {
        Magician m = new Magician(1999, 200, 91, 40);
        assertEquals(200, m.getAttackPower());
    }

    @Test
    void testSetAttackPower() {
        Magician m = new Magician(1999, 200, 91, 40);
        m.setAttackPower(199);
        assertEquals(199, m.getAttackPower());
    }

    @Test
    void testNegativeAttackPowerInConstructor() {
        Magician m = new Magician(1999, -200, 91, 40);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testSetNegativeAttackPower() {
        Magician m = new Magician(1999, 200, 91, 40);
        m.setAttackPower(-199);
        assertEquals(0, m.getAttackPower());
    }

    @Test
    void testGetDefensePower() {
        Magician m = new Magician(1999, 200, 91, 40);
        assertEquals(91, m.getDefensePower());
    }

    @Test
    void getMana() {
        Magician m = new Magician(2000, 200, 92, 40);
        assertEquals(40, m.getMana());
    }

    @Test
    void getManaIfManaISZero() {
        Magician m = new Magician(2000, 200, 92, 0);
        assertEquals(0, m.getMana());
    }

    @Test
    void negativeManaThrowsIAE() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Magician(2000, 200, 92, -40);
        });
        assertEquals("Mana less than 0", e.getMessage());
    }

    @Test
    void setMana() {
        Magician m = new Magician(2000, 200, 92, 40);
        m.setMana(30);
        assertEquals(30, m.getMana());
    }

    //Need to figure out how to write this one
    //Hope this works ~Tahmid
    @Test
    void setNegativeManaThrowsIAE() {
         assertThrows(IllegalArgumentException.class, () -> {
            Magician m = new Magician(2000, 200, 92, 40);
            m.setMana(-40);
        });
    }

    @Test
    void testMagicSpellExistInTheMagicBook() {
        Magician gandalf = new Magician(2000, 200, 92, 40);
        Fire m = new Fire(10, 5);
        gandalf.addMagicToMagicBook(m);
        assertTrue(gandalf.getMagicBook().containsKey("Fire") && gandalf.getMagicBook().get("Fire") != null);
    }

    @Test
    void testTwoMagicSpellExistInTheMagicBook() {
        Magician gandalf = new Magician(2000, 200, 92, 40);
        Fire m = new Fire(10, 5);
        Frost n = new Frost(6, 8);
        gandalf.addMagicToMagicBook(m);
        gandalf.addMagicToMagicBook(n);
        assertTrue(gandalf.getMagicBook().containsKey("Fire") && gandalf.getMagicBook().get("Fire") != null && gandalf.getMagicBook().containsKey("Frost") && gandalf.getMagicBook().get("Frost") != null);
    }

    @Test
    void testIsResistantToFire() {
        Magician magician = new Magician(2000, 200, 92, 100);
        assertTrue(magician.checkIfResistant(new Fire(10, 50)));
    }

    @Test
    void testIsResistantToFrost() {
        Magician magician = new Magician(2000, 200, 92, 100);
        assertTrue(magician.checkIfResistant(new Frost(10, 50)));
    }

    /**
     * Test Magician vs. Man
     */

    @Test
    void testMagicianAttacksManWithNoMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        magician.castMagic("no magic", man);

        assertEquals(2000, man.getHitPoints());
    }

    @Test
    void testMagicianAttacksManWithFireMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        Magic fire = new Fire(50, 10);
        magician.addMagicToMagicBook(fire);

        magician.castMagic(fire.getName(), man);
        assertEquals(1990, man.getHitPoints());
    }

    @Test
    void testMagicianAttacksManWithFrostMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        Magic frost = new Frost(50, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), man);
        assertEquals(1900, man.getHitPoints());
    }

    /**
     * Test Magician vs. Dragon
     */

    @Test
    void testMagicianAttacksDragonWithNoMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Dragon dragon = new Dragon(2000, 200, 92);

        magician.castMagic("no magic", dragon);

        assertEquals(2000, magician.getHitPoints());
    }

    @Test
    void testMagicianAttacksDragonWithFireMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Dragon dragon = new Dragon(2000, 200, 92);

        Magic fire = new Fire(50, 100);
        magician.addMagicToMagicBook(fire);

        magician.castMagic(fire.getName(), dragon);
        assertEquals(1935, dragon.getHitPoints());
    }

    @Test
    void testMagicianAttacksDragonWithFrostMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Dragon dragon = new Dragon(2000, 200, 92);

        Magic frost = new Frost(50, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), dragon);
        assertEquals(1870, dragon.getHitPoints());
    }

    /**
     * Test Magician vs. Magician
     */

    @Test
    void testMagicianAttacksMagicianWithNoMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Magician magician1 = new Magician(2005, 203, 90, 80);

        magician.castMagic("no magic", magician1);
        assertEquals(2005, magician1.getHitPoints());
    }

    @Test
    void testMagicianAttacksMagicianWithFireMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Magician magician1 = new Magician(2005, 203, 90, 80);

        Magic fire = new Fire(50, 100);
        magician.addMagicToMagicBook(fire);

        magician.castMagic(fire.getName(), magician1);
        assertEquals(1980, magician1.getHitPoints());
    }

    @Test
    void testMagicianAttacksMagicianWithFrostMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Magician magician1 = new Magician(2005, 203, 90, 80);

        Magic frost = new Frost(50, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), magician1);
        assertEquals(1980, magician1.getHitPoints());
    }

    @Test
    void testTotalManaHasDecreasedAfterCastingMagic() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        Magic frost = new Frost(50, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), man);
        assertEquals(50, magician.getMana());
    }

    @Test
    void testMagicDoesNotDealDamageWhenNotEnoughMana() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        Magic frost = new Frost(110, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), man);
        assertEquals(2000, magician.getHitPoints());
    }

    @Test
    void testMagicDoesNotUseManaWhenManaNotEnough() {
        Magician magician = new Magician(2000, 200, 92, 100);
        Man man = new Man(2000, 200, 92, Man.SwordType.Steel);

        Magic frost = new Frost(110, 100);
        magician.addMagicToMagicBook(frost);

        magician.castMagic(frost.getName(), man);
        assertEquals(100, magician.getMana());
    }

    @Test
    void testAddMagicToMagicBook() {
        Fire magic = new Fire(30, 20);
        Magician magician = new Magician(2000, 200, 92, 100);
        magician.addMagicToMagicBook(magic);
        assertEquals("Fire", magician.getMagicBook().get(magic.getName()).getName());
    }

    @Test
    void testMagicAlreadyExistsInBook() {
        Fire magic = new Fire(30, 20);
        Magician magician = new Magician(2000, 200, 92, 100);
        magician.addMagicToMagicBook(magic);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            magician.addMagicToMagicBook(magic);

        });
        assertEquals("Spell already exists", e.getMessage());
    }

    @Test
    void testAddTwoDifferentTypesOfMagicToMagicBook() {
        Fire fire = new Fire(30, 20);
        Frost frost = new Frost(40, 30);

        Magician magician = new Magician(2000, 200, 92, 100);
        magician.addMagicToMagicBook(fire);
        magician.addMagicToMagicBook(frost);
        assertEquals("Fire", magician.getMagicBook().get(fire.getName()).getName());
        assertEquals("Frost", magician.getMagicBook().get(frost.getName()).getName());
    }

    @Test
    void testToString() {
        Magician m = new Magician(2000, 200, 92, 40);
        assertEquals("HP: 2000, Attack: 200, Defense: 92, Mana: 40", m.toString());
    }
}