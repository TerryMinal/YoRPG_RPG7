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

    }

    public void attack1 (Character enemy) {} 
    public void attack2 (Character enemy) {}	
    public void attack3 (Character enemy) {}

    public void special1 (Character enemy) {}
    public void special2 (Character enemy) {}
    public void special3 (Character enemy) {}

    public void defend () {}
    
    public String about() {
	return "\"...\" said the rogue. Fast and descrete, he strikes when you least expect it. He wears a lot of black too.";
    }
}


   
   
