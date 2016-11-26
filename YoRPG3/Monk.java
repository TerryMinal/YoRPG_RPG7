public class Monk  extends Character {

    public Monk () {
	this("noName"); 
    }
    
    public Monk (String name) {
	this.name = name;
	health = origHealth =  170;
	defense = origDefense = 50;
	evasion = origEvasion = 40;
	attackRating = origAttack = .9;
	speed = origSpeed =  85;
	charge = 0;
	state = 0;
	    
    }

    // Bald Eagle Barrage
    public void attack1 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	double speedPercent = 0.5;
	this.speed = (int) (origSpeed * speedPercent);
	damage = (int) (65  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
    }

    //Whale tsunami
    public void attack2 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	double speedPercent = 1;
	this.speed = (int) (origSpeed * speedPercent);
	damage = (int) (150  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
    }

    //Mudslide
    public void attack3 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	double speedPercent = .65;	
	this.speed = (int) (origSpeed * speedPercent);
	damage = (int) (100  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
    }


    public String about() {
	return "He may be meditating. He may be calm. But don't mess with him or else he'll whip open a can of monk fu on you";
    }

}



    
