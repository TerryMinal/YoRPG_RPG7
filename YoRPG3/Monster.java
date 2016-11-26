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

    public void attack1 (Character enemy) {} 
    public void attack2 (Character enemy) {}	
    public void attack3 (Character enemy) {}

    public void special1 (Character enemy) {}
    public void special2 (Character enemy) {}
    public void special3 (Character enemy) {}

    public void defend () {}

    public String about() {
	return "I'm a monster. I was designed by game developers to be slain for points."; 
    }
}
