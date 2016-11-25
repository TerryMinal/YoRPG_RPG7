
public class Mage extends Character {
    private int MP;
    public Mage() {
	this("noName"); 
    }
    
    public Mage (String name) {
	this.name = name;
	health = origHealth = 300;
	defense = origDefense = 40;
	speed = origSpeed = 80;
        evasion = origEvasion = 9;
	charge = 0;
	state = 0;
	attackRating = origAttack = .2;
	MP = 100;
    }

    //attack 1: frost strick (30MP, 50 strength, .5 speed percent)
    public void attack1(Character opp){
	damage = strength* attackRating - (opp.getDefense());
	if (evade()){
	    opp.lowerHP(0);
	}
	else{
	    opp.lowerHP(damage);
	}
    }

    public void attack2(Character opp){
    }
    public void attack3(Character opp){
    }

    public void defend(){
    }

    public String about() {
	return "And with his great staff and white beard he screas \"You shall not pass!\" This character can cast magic and all sorts of magic stuff";
    }


}


   
   
