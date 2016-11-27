public class Boss extends Monster {

    public Boss() {
	name = "Sedarg von Egelloc";
	health = origHealth = 400;
	defense = origDefense = 60;
	speed = origSpeed = 70;
	evasion = origEvasion = .42; 
	state = 0;
	attackRating = origAttack = 1.2;
	speedPercent[0] = .55;
	speedPercent[1] = .67; 
	speedPercent[2] = .74;
	speedPercent[3] = .82;
	identity=6;
    }

    public int attack2 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((85 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;

    } 

    public int attack3 (Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((100 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;

    }	

    public int attack4 (Character opp) {
	evasion = origEvasion;
	defense = origDefense; 
	int damage = (int) ((125 * attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;
   }

    public String about() {
	return "Ruff"; 
    }
}
