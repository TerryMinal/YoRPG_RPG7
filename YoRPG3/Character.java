//Team RPG7
//Terry Guan, Xin Yi Chen, Alitquan Mallick
public abstract class Character{
    protected String name; 
    protected int health, strength, origStrength,defense, origDefense, speed, origSpeed;
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

    public void normalAttack() {
	lowerHP(30); 
    } 
    
    public abstract void chooseAttack(); 

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
    public void normalize(){
	defense = origDefense; 
	attackRating = origAttack;
	speed = origSpeed; 
    }    
    
    protected abstract String about(); 
}
