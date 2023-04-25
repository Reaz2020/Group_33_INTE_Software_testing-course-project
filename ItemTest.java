import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void creatingAHealthPotionType() {
        Item potion = new Item(Item.PotionType.HEALTH, 200);
        assertEquals(Item.PotionType.HEALTH, potion.getPotionType());
    }

    @Test
    void creatingAPotionToCheckAmmount() {
        Item p = new Item(Item.PotionType.HEALTH, 200);
        assertEquals(200, p.getPotionAmmount());
    }

    @Test
    void creatingPotionWithIAEWithNegativeOneAmmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Item(Item.PotionType.HEALTH, -1);
        });
    }

    @Test
    void addingHealthToAPlayerWithPotion() {
        Man m = new Man(2000, 200, 92);
        Item p = new Item(Item.PotionType.HEALTH, 500);
        p.usePotion(m, p);
        assertEquals(2500, m.getHitPoints());
    }

    @Test
    void addingHealthToAplaterWithPotionButEmptyingTheAmmountToZero() {
        Man m = new Man(2000, 200, 92);
        Item p = new Item(Item.PotionType.HEALTH, 500);
        p.usePotion(m, p);
        assertEquals(0, p.getPotionAmmount());
    }

    @Test
    void toStringFormatForHealthPotion() {
        Item p = new Item(Item.PotionType.HEALTH, 550);
        assertEquals("This is a HEALTH Potion, with the amount 550", p.toString());
    }

    @Test
    void setPotionAmmountToANewAmmount() {
        Item p = new Item(Item.PotionType.HEALTH, 550);
        p.setPotionAmmount(800);
        assertEquals(800, p.getPotionAmmount());
    }

    @Test
    void setPotionAmmountToBelowISEKickIn() {
        assertThrows(IllegalStateException.class, () -> {
            Item p = new Item(Item.PotionType.HEALTH, 500);
            p.setPotionAmmount(-50);

        });
    }

    @Test
    void testNewHPAutoAdjustToMaxHealthWhenReachingAboveThresholdOfMaxHealth() {
        Man m = new Man(2000, 200, 92);
        Item p = new Item(Item.PotionType.HEALTH, 2000);
        p.usePotion(m, p);
        assertEquals(2500, m.getHitPoints());
    }


}