
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void xyPositionValidTest(){ // validation check
        Position p1 = new Position(5,7);
        assertEquals(5,p1.getX());
        assertEquals(7,p1.getY());
    }

    @Test
    void invalidTestForXPosition(){
        Position p2 = new Position(6,7);
        assertNotEquals(8,p2.getX());
        assertEquals(7,p2.getY());
    }
    @Test
    void invalidTestForYPosition(){
        Position p3 = new Position(10,12);
        assertEquals(10,p3.getX());
        assertNotEquals(14,p3.getY());
    }




}