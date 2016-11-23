
public class Mage extends Character {

    public Mage() {
	this("noName"); 
    }
    
    public Mage (String name) {
	this.name = name;
	health = 300;
	strength = 90; 
	defense = origDefense = 40; 
	attackRating = origAttack = .2; 
    }
    
        public void specialize() {
	defense = (int)(origDefense/1.01);
        attackRating =  origAttack * 3.2; 
    }


    public void normalize() {
	defense = origDefense; 
	attackRating = origAttack;
    }

    public String about() {
	return "And with his great staff and white beard he screas \"You shall not pass!\" This character can cast magic and all sorts of magic stuff";
    }
}


   
   
