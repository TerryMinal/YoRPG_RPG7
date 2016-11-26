public class Boss extends Monster {

    public Boss() {
	name = "Sedarg";
	health = origHealth = 400;
	defense = origDefense = 60;
	speed = origSpeed = 70;
	state = 0;
	attackRating = origAttack = 1.2;
    }

    public void attack1 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
    } 

    public void attack2 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
    }	

    public void attack3 (Character enemy) {
	evasion = origEvasion;
	defense = origDefense;
    }

    public String about() {
	return ""; 
    }
}
