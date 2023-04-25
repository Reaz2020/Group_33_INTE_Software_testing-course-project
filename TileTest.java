import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void TestExistenceOfFire() {
        Tile tile1=new Tile(new Position(0,0),true,false,false,false,false,false,false);
        assertTrue(tile1.isFire(), "Fire should be on this place");
        assertFalse(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void HillsExistence(){
        Tile tile1=new Tile(new Position(0,0),false,true,false,false,false,false,false);
        assertFalse(tile1.isFire());
        assertTrue(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void JangleExistence(){
        Tile tile1=new Tile(new Position(0,0),false,false,true,false,false,false,false);
        assertFalse(tile1.isFire());
        assertFalse(tile1.isHills());
        assertTrue(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void EnemyExistence(){
        Tile tile1=new Tile(new Position(0,0),false,false,false,true,false,false,false);
        assertFalse(tile1.isFire());
        assertFalse(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertTrue(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void EmptyPlaceCheck(){
        Tile tile1=new Tile(new Position(0,0),false,false,false,false,true,false,false);
        assertFalse(tile1.isFire());
        assertFalse(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertTrue(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void LevelComplitionPlaceCheck(){
        Tile tile1=new Tile(new Position(0,0),false,false,false,false,false,true,false);
        assertFalse(tile1.isFire());
        assertFalse(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertTrue(tile1.isLevel());
        assertFalse(tile1.isLife());
    }

    @Test
    void EnergyExistance(){
        Tile tile1=new Tile(new Position(0,0),false,false,false,false,false,false,true);
        assertFalse(tile1.isFire());
        assertFalse(tile1.isHills());
        assertFalse(tile1.isJangle());
        assertFalse(tile1.isEnemy());
        assertFalse(tile1.isEmpty());
        assertFalse(tile1.isLevel());
        assertTrue(tile1.isLife());
    }

    // TEST TYPE TDD(test driven dev)
    @Test
    void IftwoElementIsTrue(){
        assertThrows(IllegalArgumentException.class, () -> {
            Tile tile = new Tile(new Position(0, 0), true, true, false, false, false, false, false);
        });
    }

    @Test
    void IftwoElementIsTrue2(){
        assertThrows(IllegalArgumentException.class, () -> {
            Tile tile = new Tile(new Position(0, 0), true, false, true, false, false, false, false);
        });
    }

    @Test
    void IftwoElementIsTrue3(){
        assertThrows(IllegalArgumentException.class, () -> {
            Tile tile = new Tile(new Position(0, 0), true, false, false, true, false, false, false);
        });
    }

    @Test
    void IftwoElementIsTrue4(){
        assertThrows(IllegalArgumentException.class, () -> {
            Tile tile = new Tile(new Position(0, 0), true, false, false, false, false, true, false);
        });
    }

    @Test
    void checkIfOneElementIsTrueOnOneTile() {
        Tile tile=new Tile(new Position(0,0),true,false,false,false,false,false,false);
        assertTrue(tile.checkIfOneElementIsTrueOnOneTile());
    }

}