public class Warrior extends Character {
 
    public Warrior() {
	this("noName"); 
    }
    
    public Warrior(String name) {
	this.name = name;
	health = 125;
	strength = 105; 
	defense = origDefense = 45; 
	attackRating = origAttack = .4; 
	super.description = "A character with emphasis on power. It's brolicness takes away from it's brains and speed; Indeed this character is the embodiment of brawns over brain";  
    }

}
