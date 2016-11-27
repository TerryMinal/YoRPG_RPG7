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
	speedPercent[0] = .5; 
	speedPercent[1] = 1.0;
	speedPercent[2] = .2; 
	speedPercent[3] = .65;
	attackName[0]="Normal Attack";
	attackName[1]="Bald Eagle Barrage";
	attackName[2]="Whale Tsunami";
	attackName[3]="Mudslide";
	    
    }

    // Bald Eagle Barrage
    public int attack2 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	damage = (int) (65  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
	return damage;
    }

    //Whale tsunami
    public int attack3 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	damage = (int) (150  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
	return damage;
    }

    //Mudslide
    public int attack4 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage;
	damage = (int) (100  * this.attackRating) - (enemy.defense);
	enemy.lowerHP (damage);
	return damage;
    }


    public String about() {
	return "He may be meditating. He may be calm. But don't mess with him or else he'll whip open a can of monk fu on you";
    }

}



    
