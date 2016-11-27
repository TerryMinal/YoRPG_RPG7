//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW30 -- Ye Olde Role Playing Game 
//2016-11-16

public class Monster extends Character {

    int chosenAttack; 

    public Monster() {
	health = origHealth = 160;
	defense = origDefense = 55;
	speed = origSpeed = 80;
	state = 0;
	attackRating = origAttack = 1;
	evasion = origEvasion = .38; 
	speedPercent[0] = .46; 
	speedPercent[1] = .55; 
	speedPercent[2] = .68;
	speedPercent[3] = .73;
	chosenAttack = (int) (Math.random() * 3 + 1);
	identity="Monster";
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

    public void determineAttack(Character opp) {
	if (Math.random() >= .7) {
	    chooseAttack(opp, chosenAttack); 
	}
	else {
	    if (chosenAttack == 4) {
		if (charge == 100)
		    specialize(opp, chosenAttack);
		else {
		    //shuffles chosenAttack until its not a special super attack
		    while(chosenAttack == 4) {
			randomizeAttack();
		    }
		}
	    }
	    else {
		specialize(opp, chosenAttack); 
	    }
	}
    }

    public String about() {
	return "I'm a monster. I was designed by game developers to be slain for points."; 
    }
}
