//Team RPG7
//Terry Guan, Xin Yi Chen, Alitquan Mallick
public abstract class Character{
    protected String name; 
    protected int health,origHealth, defense, origDefense; 
    protected int speed, origSpeed, evasion, origEvasion;
    protected int charge, state;  
    protected double attackRating,origAttack;
    
    //int state- 0:normal 1:posioned 2: paralyzed
        /*
      returns boolean indicating living or dead
     */
    public boolean isAlive() {
	if(health <= 0)
	    return false; 
	else
	    return true; 
    }

    
    /*
      returns value of defense attribute
     */
    public int getDefense() {
	return defense;
    }

    
    /*
      returns value of name attribute
     */
    public String getName() {
	return name; 
    }
    /*
      takes an int parameter, decreases life attribute by that amount
    */
    public void lowerHP(int damage) {
	health = origHealth - damage; 
    }
    
    public void normalAttack() {
	lowerHP(30); 
    } 
           
    public void chooseAttack(Character opp, int i){
	if (state != 2){
	    if (evade == true){
	    opp.lowerHP(0);
	    }
	}
	if (i == 1){
	    attack1(opp);
	}
	if (i == 2){
	    attack2(opp);
	}
	
	if (i == 3){
	    attack3(opp);
	}
    }

    public abstract attack1();
    public abstract attack2();
    public abstract attack3();
    
    public boolean evade() {
	if ((int) (Math.random() * 100) < evasion)
	    return true; 
	else 
	    return false; 
    }

    public void charge(int amount) {
	charge += amount; 
    }
    
    public void specialize(Character opp, int i){
	if (state != 2){ // if the opp is not paralyzed
	    if (evade == true){
		opp.lowerHP(0);
	    }
	}
	if (i == 1){
	    special1(opp);
	}
	if (i == 2){
	    special2(opp);
	}
	if (i == 3){
	    special3(opp);
	}
    }

    //poison
    public abstract special1();
    //paralysis
    public abstract special2();
    //healing
    public abstract special3();
    

    public abstract void defend(); 

    public void normalize(){
	defense = origDefense; 
	attackRating = origAttack;
	speed = origSpeed;
	evasion = origEvasion; 
    }    
    
    protected abstract String about(); 
}
