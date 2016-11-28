//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW35 -- Ye Olde Role Playing Game, Realized
//2016-11-27

public class Monster extends Character {

    int chosenAttack; 

    public Monster() {
	health = origHealth = 160;
	defense = origDefense = 55;
	speed = origSpeed = 80;
	state = 0;
	charge = 0;
	attackRating = origAttack = 1;
	evasion = origEvasion = .38; 
	speedPercent[0] = .46; 
	speedPercent[1] = .55; 
	speedPercent[2] = .68;
	speedPercent[3] = .73;
	chosenAttack = (int) (Math.random() * 3 + 1);
	identity=5;
    }

    public int attack2 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((70 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;

    } 

    public int attack3 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((90 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;

    }	

    public int attack4 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((110 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;

    }

    public void randomizeAttack() {
	chosenAttack = (int) (Math.random() * 3 + 1); 
    }

    public int determineAttack(Character opp) {
	//if (Math.random() >= .7) {
	int damage = chooseAttack(opp, chosenAttack);
	System.out.println ("\n" + "Monster has dealt " + damage + " damage to " +  opp.getName());
	return damage;
    }
   
    

    public String about() {
	return "I'm a monster. I was designed by game developers to be slain for points."; 
    }
}
