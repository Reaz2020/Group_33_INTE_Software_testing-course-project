import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {



    @Test
    void TestWidth() {
        Map map = new Map(10, 15);
        assertEquals(map.getWidth(), 10);
    }

    @Test

    void TestBreadth() {
        Map map = new Map(12, 14);
        assertEquals(map.getBreadth(), 14);
    }
    // TEST TYPE TDD


    @Test
// in this test we dont want more then one tile can be placed in the same position,
        // so we have make a hash set to check if one object is already there, we have to creat an IAE.
    void SamePositionTest() {
        Map map = new Map(10, 10);
        map.addTile(new Tile(new Position(5, 5)));
        assertThrows(IllegalArgumentException.class, () -> {
            map.addTile(new Tile(new Position(5, 5)));
        });
    }

    @Test

    void tileOutofMapInX() {
        Map map = new Map(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            map.addTile(new Tile(new Position(15, 5)));
        });
    }

    @Test

    void tileOutofMapInY() {
        Map map = new Map(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            map.addTile(new Tile(new Position(5, 15)));
        });
    }

    @Test
// TDD , i am expecting if the width is less then 0 , will throw IAE.test has failed .testes,written code  in map class,retest.
    void ifTilePositionIsGivenNegativeForX() {
        Map map = new Map(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            map.addTile(new Tile(new Position(-15, 5)));
        });
    }

    @Test
//TDD , i am expecting if the breadth is less then 0 , will throw IAE.
    void ifTilePositionIsGivenNegativeInY() {
        Map map = new Map(10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            map.addTile(new Tile(new Position(5, -15)));
        });
    }
    @Test
    void widthNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map map = new Map(-10, 10);
        });
    }
    @Test
    void IfWidthZeroOrLessThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map map = new Map(0, 10);
        });
    }
    @Test
    void ifBreadthNegativeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map map = new Map(10, -10);
        });
    }
    @Test
    void IfBreadthZeroOrLessThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            Map map = new Map(10, 0);
        });
    }

    @Test
    void mansSetPositionTestInEmptyPlace(){ // changed name from mansPositionTest().
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        assertTrue(map.checkPosition(new Position(1,1)),"empty place can be accesed");
    }
    @Test
    void mansSetPositionTestInFire(){ //written now.
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        assertFalse(map.checkPosition(new Position(1,2)),"fire is true here");
    }
    @Test
    void mansSetPositionTestInHill(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        assertFalse(map.checkPosition(new Position(1,3)),"hill is true here");
        assertFalse(map.checkPosition(new Position(3,2)),"hill is true here");
    }
    @Test
    void mansSetPositionTestInEnemy(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        map.addTile(new Tile(new Position(3,4),false,false,false,true,false,false,false));
        assertFalse(map.checkPosition(new Position(3,4)),"enemy is here");
    }
    @Test
    void mansSetPositionTestInJungle(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        assertFalse(map.checkPosition(new Position(3,3)),"jungle is here");
    }
    @Test
    void mansSetPositionTestInLife(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        assertTrue(map.checkPosition(new Position(2,3)),"life can be accesed ");
    }

    @Test
    void mansMoveUpPositionTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),1));
        assertEquals(1,player.getCreaturePosition().getX());
        assertEquals(1,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveDownPositionTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),3));
        assertEquals(2,player.getCreaturePosition().getX());
        assertEquals(1,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveRightPositionTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,4),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),2));
        assertEquals(1,player.getCreaturePosition().getX());
        assertEquals(2,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveLeftPositionTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,4),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),4));
        assertEquals(1,player.getCreaturePosition().getX());
        assertEquals(1,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveLeftPositionInvalidTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,4),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),4));
        assertEquals(1,player.getCreaturePosition().getX());
        assertNotEquals(0,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveRightPositionInvalidTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,4),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),2));
        assertEquals(1,player.getCreaturePosition().getX());
        assertNotEquals(1,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveDownPositionInvalidTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),3));
        assertNotEquals(1,player.getCreaturePosition().getX());
        assertEquals(1,player.getCreaturePosition().getY());
    }

    @Test
    void mansMoveUpPositionInvalidTest(){
        Map map = new Map(3,5);
        map.addTile(new Tile(new Position(1,2),true,false,false,false,false,false,false));
        map.addTile(new Tile(new Position(1,3),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(2,3),false,false,false,false,false,false,true));
        map.addTile(new Tile(new Position(3,2),false,true,false,false,false,false,false));
        map.addTile(new Tile(new Position(3,3),false,false,true,false,false,false,false));
        map.addTile(new Tile(new Position(3,5),false,false,false,false,false,true,false));
        Man player=new Man(100,100,100);
        if(map.checkPosition(new Position(1,1))){
            player.setCreaturePosition(new Position(1,1));
        }
        player.setCreaturePosition(map.movePosition(player.getCreaturePosition(),1));
        assertNotEquals(0,player.getCreaturePosition().getX());
        assertEquals(1,player.getCreaturePosition().getY());
    }

}

