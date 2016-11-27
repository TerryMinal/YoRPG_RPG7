//Team RPG7
//Terry Guan, Xin Yi Chen, Alitquan Mallick
public abstract class Character{
    protected String name; 
    protected int health,origHealth, defense, origDefense; 
    protected int charge, state, numTurns; //int state- 0:normal 1:posoined 2: paralyzed | int numTurns: number of turns state inflicted
    protected double attackRating, origAttack, speed, origSpeed, evasion, origEvasion;
    //currentSpeed is the character speed * speed percent
    //list of speed percent of each Character: add to subclasses 
    protected double[] speedPercent = new double[4];

    //list of the attackNames for each character
    protected String[] attackName = new String[4];
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
    public int attack1(Character opp) {
	evasion = origEvasion;
	defense = origDefense;
	int damage = (int) ((70* attackRating) - (opp.getDefense()));
	opp.lowerHP(damage);
	return damage;
    } 

    
    public int chooseAttack(Character opp, int i){
	if (state != 2){//if character is not paralyzed
	    if (opp.evade()  == true){ //if opponent's  evade successfully
		System.out.println(" Your opponent evaded your attack! ");
		return 0;
	    }
	    else if (i == 1){
		return attack1(opp);
	    }
	    else if(i == 2){
		return attack2(opp);
	    }
	
	    else if (i == 3){
		return attack3(opp);
	    }
	    else if (i == 4){
		return attack4(opp);
	    }
	    else {
		System.out.println("doth gave us the wrong number. Your attack choice has been nullified");
		return 0;
	    }
	}
	else {
	    System.out.println("doth been paralyzed. Doth muscles need reworking"); 
	    return 0;
	}
    }

    public abstract int attack2(Character opponent);
    public abstract int attack3(Character opponent);
    public abstract int attack4(Character opponent);
    
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
	if (state != 2){ // if player is not paralyzed
	    if (i == 3) { 
		special3(); 
	    }
	    
	    if (opp.evade() == true){ // if evade successfully
		System.out.println("the opponent evaded your attack!");
	    }
	    else if (i == 1){
		special1(opp);
	    }
	    else if (i == 2){
		special2(opp);
	    }  
	    else if (i == 4) {
		if (charge == 100)
		    special4(opp); 
		else {
		    System.out.println("Not enough charge: you wasted an attack"); 
		}
	    }
	    else {
		System.out.println("doth gave us the wrong number. Your attack choice has been nullified"); 
	    }
	}
	else if (i == 1){
	    special1(opp);
	}
	else if (i == 2){
	    special2(opp);
	}
	else if (i == 4) {
	    if (charge == 100)
		special4(opp); 
	    else {
		System.out.println("Not enough charge: you wasted an attack"); 
	    }
	}
	else {
	    System.out.println("doth been paralyzed. Doth muscles need reworking"); 
	}	
    }

    //poison: decreasing opp's health for 3 rounds
    public void special1(Character opponent){
	opponent.state = 1;  //changes opponent's state to poison
	opponent.numTurns = 3;
	System.out.println( "\n" + "enemy has been poisioned");
    }
    
    //paralysis: opp not being able to attack for 3 rounds
    public void special2(Character opponent){
	opponent.state = 2 ; //changes opponent's state to paralyzed
	opponent.numTurns = 3;
	System.out.println( "\n" + "enemy has been paralyzed");
    }

    //healing: increase health
    public void special3(){
	int temp = health;
	health = (int)(temp * 1.2);
	System.out.println( "\n" + "Health  gained"); 
    }
    
    public void special4(Character opp) {
	opp.lowerHP(190);
	evasion = .9 * evasion; 
	speed = .85 * speed;
	defense = (int) (.9 * defense); 
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

    public void checkCharge() {
	if (charge > 100)
	    charge = 100; 
    }
    
    public void checkState() {
	if (state == 0) {
	    numTurns = 3;
	}
	if (numTurns == 0) {
	    state = 0; 
	    numTurns = 3;
	}
	if (state == 1) {
	    health -= 10;
	    numTurns -= 1; 
	} 
	if (state == 2) {
	    numTurns -= 1; 
	    //paralysis is provided in chooseAttack and specialize
	}
    }
    
    protected abstract String about();
}
