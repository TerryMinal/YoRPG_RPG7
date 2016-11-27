//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW35 -- Ye Olde Role Playing Game, Realized
//2016-11-27

public class Rogue extends Character {

    public Rogue () {
	this("noName"); 
    }
    
    public Rogue (String name) {
	this.name = name;
	health = origHealth = 120;
	defense = origDefense = 40;
	speed = origSpeed = 100;
        evasion = origEvasion = 50;
	charge = 0;
	state = 0;
	attackRating = origAttack = 1.0;
	speedPercent[0] = .5; 
	speedPercent[1] = .9;
	speedPercent[2] = 1; 
	speedPercent[3] = .86;
	attackName[0]="Normal Attack";
	attackName[1]="Juu Nin Too Iro";
	attackName[2]="Go To Ra Shuriken";
	attackName[3]="Kami no Ninjato";
	identity=4;
    }

    //Juu Nin Too Iro (115 strength, .9 speed percent)
    public int attack2 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((115 * attackRating) - (enemy.getDefense()));
	enemy.lowerHP(damage);
	return damage;
    } 

    //Go To Ra Shuriken (105 strength, 1 speed percent)
    public int attack3 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((105 * attackRating) - (enemy.getDefense()));
	enemy.lowerHP(damage);
	return damage;
    }

    //Kami No Ninjato (128 strength, .86 speed percent)
    public int attack4 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((128 * attackRating) - (enemy.getDefense()));
	enemy.lowerHP(damage);
	return damage;
    }
    
    public String about() {
	return "\"...\" said the rogue. Fast and descrete, he strikes when you least expect it. He wears a lot of black too.";
    }
}


   
   
