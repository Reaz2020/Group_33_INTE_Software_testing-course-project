import java.util.Random;

public class Combat {

	private Creature player; 
	private Creature monster;
	private boolean playerTurn;
	private boolean activeCombat;
	private int playerTurns;
	private int totalTurns;

	public Combat(Creature player, Creature monster) { 
        if (player == monster) {
            throw new IllegalArgumentException("Creatures can not combat themselves!");
        }
		this.monster = monster;
		this.player = player;
		playerTurn = true;
		activeCombat = true;
	}
	
	protected Creature getMonster() {
		return monster;
	}
	
	protected Creature getPlayer() {
		return player;
	}

	public void turn() {

		while (activeCombat) {

			if (player.getHitPoints() <= 0 || monster.getHitPoints() <= 0) {
				activeCombat = false;
			}
			
			else if (!playerTurn) {
				monsterTurn(random(), monster, player);
				playerTurn = true;
			}
			
			else {
				//player need a seperate user interface class to choose attacks
				//is not yet implemented because its outside the scope of project
				//so for now makes use of random class to simulate choices
				int playerChoice = random();
				playerTurn(playerChoice, player, monster);
				playerTurn = false;
			}
		}
	}
	
	protected void turnTester(int attackType, int totalTurns) {

		do {

			if (player.getHitPoints() <= 0 || monster.getHitPoints() <= 0) {
				activeCombat = false;
			} 
			
			else if (!playerTurn) {
				monsterTurn(attackType, monster, player);
				playerTurn = true;
			}
			
			else {
				//Note that turnTester uses monsterTurn method for simplicity
				monsterTurn(attackType, player, monster);
				playerTurn = false;
			}
			totalTurns--;
		} while (activeCombat = totalTurns > 0);
	}

	protected int basicAttack(Creature attacker) {
		return attacker.getAttackPower();
	}
	
	protected int criticalAttack(Creature attacker) {
		return 2*attacker.getAttackPower();
	}
	
	/* Commented out because method is now obsolete, was merged with inflictDamage
	 * 
	protected int finalDamageValue(int damageBeforeDefense, Creature defender) {
		int finalDmg = damageBeforeDefense - defender.getDefensePower();
		if (finalDmg < 0) {
			finalDmg = 0;
		}
		return finalDmg;
	} 
	*/ 
	
	protected void inflictDamage(int finalDamageValue, Creature defender) {
		int currentHealth = defender.getHitPoints();
		int finalDmg = finalDamageValue - defender.getDefensePower();
		if (finalDmg < 0) {
			finalDmg = 0;
		}

		int finalHealth = currentHealth-finalDmg;
		if (finalHealth<0) {
			finalHealth = 0;
		}
		defender.setHitPoints(finalHealth);
	}

	private boolean checkIfDragonSuperAttackAvailable(Creature attacker, int totalTurns) {
		return attacker instanceof Dragon && totalTurns == 4 && attacker.getAttackPower() > 0;
	}

	public void monsterTurn(int number, Creature attacker, Creature defender) {

		totalTurns++;

		// Check if super attack is available
		boolean bonusDamage = checkIfDragonSuperAttackAvailable(attacker, totalTurns);

		int damage = 0;

		if (bonusDamage) {
			damage += Dragon.SUPER_ATTACK_DMG; // damage = 400
		}
		if (number <9) {
			damage += basicAttack(attacker);
			inflictDamage(damage,defender);
		} else if (number == 9) {
			damage += criticalAttack(attacker);
			inflictDamage(damage,defender);
		} else {
			inflictDamage(damage,defender);
		}
		//more can be added, even non combat effects
	}

	public void playerTurn(int number, Creature attacker, Creature defender) {
		
		playerTurns++;
		
		//if statement sets all non critical attacks to be basic attacks, hence near identical 
		
		if (number>1) {
			number = 0;
			}
		
		//functionality with monsterTurn (criticalDamage on 1 instead of 9), but opens up the ability
		//to add cases and give players unique abilities separate from monsters. 
		switch(number) {
		case 0:
			int damage = basicAttack(attacker);
			inflictDamage(damage,defender);
			break;
		case 1:
			int criticalDamage = criticalAttack(attacker);
			inflictDamage(criticalDamage,defender);
			break;
		case 2:
			//intended opening for player abilities/attacks
			//cases can be added and represent choices
			break;
		default:
			break;
		}

		
	}	
	
	protected int random() {
		Random turn = new Random();
		return turn.nextInt(10);
	}
	
	public int getPlayerTurns() {
		return playerTurns;
	}
	
	public boolean getActiveCombat() {
		return activeCombat;
	}

}