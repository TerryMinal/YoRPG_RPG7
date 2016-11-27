
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
	speedPercent[0] = .5; 
	speedPercent[1] = 1.0;
	speedPercent[2] = .75; 
	speedPercent[3] = .4;
	attackName[0]="Normal Attack";
	attackName[1]="Frost Strick";
	attackName[2]="Lightning Spear";
	attackName[3]="Jinx of Demon Fire";
	identity="Mage";
    }

    public void getMP(int num){
	int tempMP = MP;
	MP = tempMP + num;
    }

    public void useMP(int num){
	int tempMP = MP;
	MP = tempMP - num;
    }

    //attack 2: frost strike (30MP, 100 strength, .5 speed percent)
    public int attack2(Character opp){
	if (MP < 30){
	    System.out.println("Normal Attack! Oops... it seems like you don't have enough magic points!");
	   return attack1(opp);
	}
	else{
	    evasion = origEvasion;
	    defense = origDefense;
	    int damage = (int) ((100* attackRating) - (opp.getDefense()));
	    opp.lowerHP(damage);
	    useMP(30);
	    return damage;
	}
    }

    //attack 3: lightning spear(20MP, 95 strength, .75 speed percent)
    public int attack3(Character opp){
	if (MP < 20){
	    System.out.println("Normal Attack! Oops... it seems like you don't have enough magic points!");
	    return attack1(opp);
	}
	else{
	    evasion = origEvasion;
	    defense = origDefense;
	    int damage = (int) ((95* attackRating) - (opp.getDefense()));
	    opp.lowerHP(damage);
	    useMP(20);
	    return damage;
	}
    }

    //attack 4: Jinx of Demon Fire(50MP, 140 strength, .4 speed percent)
    public int attack4(Character opp){
	if (MP < 50){
	    System.out.println("Normal Attack! Oops... it seems like you don't have enough magic points!");
	    return attack1(opp);
	}
	else{
	    evasion = origEvasion;
	    defense = origDefense;
	    int damage = (int) ((140* attackRating) - (opp.getDefense()));
	    opp.lowerHP(damage);
	    useMP(50);
	    return damage;
	}
    }

    public String about() {
	return "And with his great staff and white beard he screas \"You shall not pass!\" This character can cast magic and all sorts of magic stuff";
    }


}


   
   
