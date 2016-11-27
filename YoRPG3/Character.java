//Team RPG7
//Terry Guan, Xin Yi Chen, Alitquan Mallick
public abstract class Character{
    protected String name; 
    protected int health,origHealth, defense, origDefense; 
    protected int charge, state;   //int state- 0:normal 1:posioned 2: paralyzed
    protected double attackRating, origAttack, speed, origSpeed, evasion, origEvasion;
    //currentSpeed is the character speed * speed percent
    //list of speed percent of each Character: add to subclasses 
    protected double[] speedPercent = new double[4]; 
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
	int tempHP = health;
	health = tempHP - damage; 
    }

    // 70 strength, .5 speed percent
    public void normalAttack(Character opp) {
	int damage = (int) ((70* attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
    } 

    
    public void chooseAttack(Character opp, int i){
	if (state != 2){//if opp is not paralyzed
	    if (opp.evade()  == true){ //if evade successfully
		System.out.println("your opponent evaded your attack!"); 
	    }
	    else if (i == 1){
		attack1(opp);
	    }
	    else if(i == 2){
		attack2(opp);
	    }
	
	    else if (i == 3){
		attack3(opp);
	    }
	}
	else if (i == 1){
	    attack1(opp);
	}
	else if (i == 2){
	    attack2(opp);
	}
	
	else if (i == 3){
	    attack3(opp);
	}
    }

    public abstract void attack1(Character opponent);
    public abstract void attack2(Character opponent);
    public abstract void attack3(Character opponent);
    
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
	    if (opp.evade() == true){ // if evade successfully
		System.out.println("the opponent evaded your attack!");
	    }
	    else if (i == 1){
		special1(opp);
	    }
	    else if (i == 2){
		special2(opp);
	    }
	    else if (i == 3){
		special3();
	    }
	}
	else if (i == 1){
	    special1(opp);
	}
	else if (i == 2){
	    special2(opp);
	}
	else if (i == 3){
	    special3();
	}
    }

    //poison: decreasing opp's health for 3 rounds
    public void special1(Character opponent){
	opponent.state = 1; //changes opponent's state to poison
    }
    
    //paralysis: opp not being able to attack for 3 rounds
    public void special2(Character opponent){
	opponent.state = 2 ; //changes opponent's state to paralyzed
    }

    //healing: increase health
    public void special3(){
	int temp = health;
	health = (int)(temp * 1.2);
    }
    

    public void defend() {
	defense = (int) (origDefense * 1.5);
	evasion = origEvasion + 10;
	charge (20);
	if (charge > 100) {
	    charge = 100;
	}
    }

    public void normalize(){
	health = origHealth;
	defense = origDefense;
	speed  = origSpeed;
	evasion = origEvasion;
	attackRating = origAttack;
        state = 0; 
    }    
    
    protected abstract String about();
}
