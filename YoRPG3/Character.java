//Team RPG7
//Terry Guan, Xin Yi Chen, Alitquan Mallick
//HW34: Ye Olde Role Playing Game, Unchained
//11-23-16
public abstract class Character{
    protected String name; 
    protected int health, strength, defense, origDefense, speed, origSpeed;
    protected double attackRating,origAttack;

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
	int origHealth = health;
	health = origHealth - damage; 
    }

    public int attack(Character  opp) {
	int attackValue = (int)(strength * attackRating - opp.getDefense());
	if (attackValue < 0){
	    attackValue = 0;
	}
        opp.lowerHP(attackValue);
	return attackValue;

    }

    /*
      1.prepares the Warrior to perform a special attack
      2.decreases defense attribute
      3.increases attack attribute
     */
    public abstract void specialize();

    /*
      1.prepares the Warrior to perform a normal attack
      2.resets defense attribute
      3.resets attack attribute
     */
    public abstract void normalize(); 

    protected abstract String about(); 
}
