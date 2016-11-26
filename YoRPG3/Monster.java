//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW30 -- Ye Olde Role Playing Game 
//2016-11-16

public class Monster extends Character {

    public Monster() {
	health = origHealth = 160;
	defense = origDefense = 55;
	speed = origSpeed = 80;
	state = 0;
	attackRating = origAttack = 1;
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
	return "I'm a monster. I was designed by game developers to be slain for points."; 
    }
}
