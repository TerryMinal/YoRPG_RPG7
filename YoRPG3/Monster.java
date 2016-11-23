//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW30 -- Ye Olde Role Playing Game 
//2016-11-16

public class Monster extends Character {

    public Monster() {
        health = 150; 
        strength = (int) (Math.random() * 50 + 30);
        defense = origDefense = 20; 
        attackRating = origAttack = 3;
	name = "Brownies";
    }
    public void specialize() {
	defense = (int)(origDefense/1.1);
        attackRating =  origAttack * 1.2; 
    }

    public void normalize() {
	defense = origDefense; 
	attackRating = origAttack;
    }

    public String about() {
	return "I'm a monster. I was designed by game developers to be slain for points."; 
    }
}
