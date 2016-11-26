
public class Mage extends Character {
    private int MP;
    public Mage() {
	this("noName"); 
    }
    
    public Mage (String name) {
	this.name = name;
	health = origHealth = 120;
	defense = origDefense = 45;
	speed = origSpeed = 80;
        evasion = origEvasion = 35;
	charge = 0;
	state = 0;
	attackRating = origAttack = .9;
	MP = 100;
    }

    public void getMP(int num){
	int tempMP = MP;
	MP = tempMP + num;
    }

    public void useMP(int num){
	int tempMP = MP;
	MP = tempMP - num;
    }

    //attack 1: frost strick (30MP, 100 strength, .5 speed percent)
    public void attack1(Character opp){
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((100* attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	useMP(30);
    }

    //attack 2: lightning spear(20MP, 95 strength, .75 speed percent)
    public void attack2(Character opp){
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((95* attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	useMP(20);
    }

    //attack 3: Jinx of Demon Fire(50MP, 140 strength, .4 speed percent)
    public void attack3(Character opp){
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((140* attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	useMP(50);
    }

    public void special1 (Character opp) {}
    public void special2 (Character opp) {}
    public void special3 (Character opp) {}

    public String about() {
	return "And with his great staff and white beard he screas \"You shall not pass!\" This character can cast magic and all sorts of magic stuff";
    }


}


   
   
