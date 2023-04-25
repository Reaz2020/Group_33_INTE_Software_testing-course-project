import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicBookTest {

    @Test
    void testCheckIfMagicBookExistsInArray() {
        MagicBook m = new MagicBook();
        m.addMagicBook("Fire", 10, 15);
        m.addMagicBook("Air", 8, 12);
        assertEquals("Name = Fire, ManaCost = 10, Damage = 15, Name = Air, ManaCost = 8, Damage = 12, ", m.printOutArrayList());
        //NOTE at every entry in the Arraylist is added with ", " with the space at the end of the entry, rememeber that

    }

    @Test
    void testIfIAEKicksInWhenPuttingInNegativeValueOnManaCost(){
        assertThrows(IllegalArgumentException.class, () -> {
            MagicBook m = new MagicBook();
            m.addMagicBook("Fire", -1, 15);

        });

    }

    @Test
    void testIfIAEKicksInWhenPuttingInNegativeValueOnDamage(){
        assertThrows(IllegalArgumentException.class, () -> {
            MagicBook m = new MagicBook();
            m.addMagicBook("Fire", 5, -5);

        });

    }
    @Test
    void testIfIAEKicksInWhenPuttingInNegativeValueOnBothDamageAndManaCost(){
        assertThrows(IllegalArgumentException.class, () -> {
            MagicBook m = new MagicBook();
            m.addMagicBook("Fire", -5, -5);

        });

    }

}