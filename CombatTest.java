import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CombatTest {

	@Test
	void creaturesCanNotStartCombatWithItself() {
        Man m = new Man(500,50,50);

        assertThrows(IllegalArgumentException.class, () ->{
        	new Combat(m, m);
        });
        
	}
	
	@Test
	void constructorCreatesCombatObject() {
		//toFix
        Man m = new Man(500,50,50);
        Dragon d = new Dragon(1000, 100, 200);
        Combat c = new Combat(m, d);
        
        assertEquals(m, c.getPlayer());
        assertEquals(d, c.getMonster());
	}
	
	@Test
	void basicAttackEqualsAttackPower() {
        Man m = new Man(500,50,50);
        Dragon d = new Dragon(1000, 0, 0);
        Combat c = new Combat(m, d);
        
        assertEquals(m.getAttackPower(), c.basicAttack(m));
	}
	
	@Test
	void basicAttackEqualsAttackPowerIfNegative() {
        Man m = new Man(500,-50,50);
        Dragon d = new Dragon(1000, 100, 200);
        Combat c = new Combat(m, d);
        
        assertEquals(m.getAttackPower(), c.basicAttack(m));
	}
	
	@Test
	void criticalAttackEqualsDoubleAttackPower() {
        Man m = new Man(500,100,150);
        Dragon d = new Dragon(1000, 200, 50);
        Combat c = new Combat(m, d);
        
        assertEquals(2*100, c.criticalAttack(m));		
	}
	
	@Test
	void activeCombatFalse() {
        Man m = new Man(500,100,150);
        Dragon d = new Dragon(1000, 200, 50);
        Combat c = new Combat(m, d);
        
        c.turn();
        
        assertFalse(c.getActiveCombat());
	}
	@Test
	void activeCombatTrue() {
        Man m = new Man(500,100,150);
        Dragon d = new Dragon(1000, 200, 50);
        Combat c = new Combat(m, d);
        
        assertTrue(c.getActiveCombat());

	}
	
	
	@Test
	void inflictDamageWithBasicAttack() {
        Man m = new Man(500,0,150);
        Dragon d = new Dragon(1000, 200, 0);
        Combat c = new Combat(m, d);
        
        int basicAttack = c.basicAttack(d);
        c.inflictDamage(basicAttack, c.getPlayer());
        
        assertEquals(500-50, m.getHitPoints());
	}
	
	@Test
	void calculateInflictDamageWithCriticalAttack() {
        Man m = new Man(500,0,150);
        Dragon d = new Dragon(1000, 200, 0);
        Combat c = new Combat(m, d);
        
        int criticalAttack = c.criticalAttack(d);
        c.inflictDamage(criticalAttack, c.getPlayer());
        
        assertEquals(500-(200*2-150), m.getHitPoints());
	}
	
	@Test
	void inflictBasicAttackFinalDamage() {
        Man m = new Man(500,0,150);
        Dragon d = new Dragon(1000, 200, 0);
        Combat c = new Combat(m, d);
        
        c.inflictDamage(200, m);
        
        assertEquals(500-(200-150), m.getHitPoints());
	}
	
	@Test
	void negativeAttackPowerCanNotHealDefender() {
        Man m = new Man(500,0,200);
        Dragon d = new Dragon(1000, -100, 0);
        Combat c = new Combat(m, d);
        
        int basicAttack = c.basicAttack(d);
        c.inflictDamage(basicAttack, c.getPlayer());
        
        assertEquals(500, m.getHitPoints());
	}
	
	@Test
	void strongDefensePowerCanNotHealDefender() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 100);
        Combat c = new Combat(m, d);
        
        int basicAttack = c.basicAttack(d);
        c.inflictDamage(basicAttack, d);
        
        assertEquals(1000, d.getHitPoints());
	}


	
	@Test
	void negativegDefensePowerDoesIncreaseDamage() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, -50);
        Combat c = new Combat(m, d);

        int basicAttack = c.basicAttack(m);
        c.inflictDamage(basicAttack, d);
        
        assertEquals(900, d.getHitPoints());
	}
	
	@Test
	void randomReturnsNumber0to9() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 100);
        Combat c = new Combat(m, d);
        
        int random = c.random();
        
        
        assertTrue(-1<random&&random<10);

	}
	
	@Test
	void monsterTurn0RollEquals8BasicAttack() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 50);
        Combat c = new Combat(m, d);
        c.monsterTurn(0, m, d);

        assertEquals(1000,d.getHitPoints());
	}
	
	@Test
	void monsterTurn5RollEquals8BasicAttack() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 50);
        Combat c = new Combat(m, d);
        c.monsterTurn(5, m, d);

        assertEquals(1000,d.getHitPoints());
	}	
	
	@Test
	void monsterTurn9RollEqualsCriticalAttack() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 50);
        Combat c = new Combat(m, d);
        
        c.monsterTurn(9, m, d);
        
        assertEquals(950,d.getHitPoints());
	}
	
	@Test
	void monsterTurn10RollEqualsNothing() {
        Man m = new Man(500, 50, 0);
        Dragon d = new Dragon(1000, 0, 50);
        Combat c = new Combat(m, d);
        
        c.monsterTurn(10, m, d);
        
        assertEquals(1000,d.getHitPoints());
	}
	
	@Test
	void turnTester5TurnsBasicAttacks() {
        Man man = new Man(500, 50, 0);
        Magician magician = new Magician(1000, 50, 0, 40);
        Combat c = new Combat(man, magician);

        c.turnTester(1,5);
        
        assertEquals(850,magician.getHitPoints());
        assertEquals(400,man.getHitPoints());

	}
	
	@Test
	void turnTesterCombatNegativeAttackPower() {
        Man m = new Man(500, -500, 0);
        Dragon d = new Dragon(500, -500, 0);
        Combat c = new Combat(m, d);
        
        c.turnTester(9,10);

        assertEquals(500,d.getHitPoints());
        assertEquals(500,m.getHitPoints());

	}
	
	@Test
	void turnTesterCombatNegativeDefense() {
        Man m = new Man(500, 100, -500);
        Dragon d = new Dragon(500, 100, -100);
        Combat c = new Combat(m, d);
        
        c.turnTester(1,1);

        assertEquals(300,d.getHitPoints());

	}
	
	@Test
	void testCombatBetweenDragonAndMan() {
        Man man = new Man(500, 50, 0);
        Dragon dragon = new Dragon(1000, 500, 50);
        Combat c = new Combat(man, dragon);
        
        c.turn();
        
        //man should die in 4 total minimum
        //which means man can not deal more than 100 damage
        //Man health should equal 0 and Dragon be over 899
        
        assertEquals(0,man.getHitPoints());
        assertTrue(899<dragon.getHitPoints());
	}
	
	@Test
	void combatWillResultInRandomCriticalAttacks() {
        Man m = new Man(500, 500, 2000);
        Dragon d = new Dragon(500, 500, 500);
        Combat c = new Combat(m, d);
        
        c.turn();
        
        //man should get criticalAttack eventually
        //dragon deals 1400 damage at most and will never damage man
        
        assertEquals(0,d.getHitPoints());
        assertEquals(500,m.getHitPoints());

	}
	
	@Test
	void dragonBestsManInCombat() {
        Man m = new Man(500, 50, 25);
        Dragon d = new Dragon(50000, 100, 25);
        Combat c = new Combat(m, d);
        
        c.turn();
        
        assertEquals(0,m.getHitPoints());
        assertTrue(40000<d.getHitPoints());

	}
	
	@Test
	void manBestsDragonInCombat() {
        Man knight = new Man(5000, 500, 150);
        Dragon dragon = new Dragon(5000, 100, 25);
        Combat c = new Combat(knight, dragon);
        
        c.turn();
        
        assertEquals(0,dragon.getHitPoints());
        assertTrue(0<knight.getHitPoints());
	}
	
	@Test
	void testPlayerTurn0RollEqualsBasicAttack() {
        Man m = new Man(500, 500, 150);
        Dragon d = new Dragon(5000, 100, 0);
        Combat c = new Combat(m, d);
        
        c.playerTurn(0, m, d);
        
        assertEquals(4500,d.getHitPoints());

	}
	
	@Test
	void testPlayerTurn1RollEqualsCriticalAttack() {
        Man m = new Man(500, 500, 150);
        Dragon d = new Dragon(5000, 100, 0);
        Combat c = new Combat(m, d);
        
        c.playerTurn(1, m, d);
        
        assertEquals(4000,d.getHitPoints());
	}
	
	@Test
	void playerTurnStartsAtZero() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(5000, 10, 0);
        Combat c = new Combat(m, d);
        
        assertEquals(0,c.getPlayerTurns());
	}
	
	@Test
	void playerTurnCountsToOne() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(5000, 10, 0);
        Combat c = new Combat(m, d);
        
        c.playerTurn(1, m, d);
        assertEquals(1,c.getPlayerTurns());
	}
	
	@Test
	void playerTurnCountsMoreThanOne() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(5000, 10, 0);
        Combat c = new Combat(m, d);
        
        c.playerTurn(1, m, d);
        c.playerTurn(1, m, d);
        c.playerTurn(1, m, d);
        c.playerTurn(1, m, d);
        assertEquals(4,c.getPlayerTurns());
	}

    @Test
    void testNoSpecialAttackWhenCreatureIsNotDragon() {
        Man man = new Man(500, 10, 0);
        Magician magician = new Magician(500, 10, 0, 60);
        Combat c = new Combat(magician, man);

        c.turnTester(3, 4);

        assertEquals(480, magician.getHitPoints());
        assertEquals(480, man.getHitPoints());
    }

    @Test
    void testDragonNoSpecialAttackWhenAttackPowerIsNegative() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(500, -10, 0);
        Combat c = new Combat(d, m);

        c.turnTester(9, 3);

        assertEquals(480, d.getHitPoints());
        assertEquals(500, m.getHitPoints());
    }

    @Test
    void testDragonNoSpecialAttackWhenAttackPowerIsZero() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(500, 0, 0);
        Combat c = new Combat(d, m);

        c.turnTester(9, 3);

        assertEquals(480, d.getHitPoints());
        assertEquals(500, m.getHitPoints());
    }

    @Test
    void testDragonNoSpecialAttackWhenTotalTurnsAreLessThanFour() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(500, 10, 0);
        Combat c = new Combat(d, m);

        c.turnTester(7, 3);

        assertEquals(490, d.getHitPoints());
        assertEquals(480, m.getHitPoints());
    }

    @Test
    void testDragonSpecialAttackWhenTotalTurnsAreMoreThanFour() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(500, 10, 0);
        Combat c = new Combat(m, d);

        c.turnTester(7, 5);

        assertEquals(470, d.getHitPoints());
        assertEquals(80, m.getHitPoints());
    }

    @Test
    void testDragonSpecialAttackWhenTotalTurnsAreFour() {
        Man m = new Man(500, 10, 0);
        Dragon d = new Dragon(500, 10, 0);
        Combat c = new Combat(m, d);

        c.turnTester(7, 4);

        assertEquals(480, d.getHitPoints());
        assertEquals(80, m.getHitPoints());
    }

    @Test
    void testDragonSpecialAttackWithCriticalStrike() {
        Man m = new Man(500, 20, 0);
        Dragon d = new Dragon(500, 10, 0);
        Combat c = new Combat(m, d);

        c.turnTester(9, 10);

        assertEquals(300, d.getHitPoints());
        assertEquals(0, m.getHitPoints());
    }
}