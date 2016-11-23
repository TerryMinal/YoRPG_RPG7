public class Rogue extends Character {

    public Rogue () {
	this("noName"); 
    }
    
    public Rogue (String name) {
	this.name = name;
	health = 200;
	strength = 95; 
	defense = origDefense = 150; 
	attackRating = origAttack = .3; 
    }

    public void specialize() {
	defense = origDefense;
        attackRating =  origAttack * 1.5; 
    }
    
    public void normalize() {
	defense = origDefense; 
	attackRating = origAttack;
    }

    public String about() {
	return "\"...\" said the rogue. Fast and descrete, he strikes when you least expect it. He wears a lot of black too.";
    }
}


   
   
