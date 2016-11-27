public class Warrior extends Character {

    public Warrior() {
	this("noName"); 
    }
    
    public Warrior(String name) {
	this.name = name;
	health = origHealth = 200;
	defense = origDefense = 55;
	speed = origSpeed = 55;
        evasion = origEvasion = 30;
	charge = 0;
	state = 0;
	attackRating = origAttack = .95;
	speedPercent[0] = .5;
	speedPercent[1] = .3; 
	speedPercent[2] = .7; 
	speedPercent[3] = .5;
	attackName[0]="Normal Attack";
	attackName[1]="The Swing of Strength";
	attackName[2]="The Swing of Speed";
	attackName[3]="Muscle Flexed Lunge";
	identity=1;
    }

    public int attack2 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((137 * attackRating) - (opp.getDefense()));
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
	int damage = (int) ((120 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;
}

    public String about() {
	return "A character with emphasis on power. It's brolicness takes away from it's brains and speed; Indeed this character is the embodiment of brawns over brain";    
    }
}
