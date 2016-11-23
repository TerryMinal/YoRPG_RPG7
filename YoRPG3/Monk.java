public class Monk  extends Character {
    //monk description
    //  super.description = "He may be meditating. He may be calm. But don't mess with him or else he'll whip open a can of monk fu on you";

    public Monk () {
	this("noName"); 
    }
    
    public Monk (String name) {
	this.name = name;
	health = 500;
	strength = 85; 
	defense = origDefense = 60; 
	attackRating = origAttack = .1; 
    }
    
    public void specialize() {
	defense = (int)(origDefense/.9);
        attackRating =  origAttack * 2.3; 
    }
    
    public void normalize() {
	defense = origDefense; 
	attackRating = origAttack;
    }

    public String about() {
	return "He may be meditating. He may be calm. But don't mess with him or else he'll whip open a can of monk fu on you";
    }

}


    
