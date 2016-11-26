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
    }

    public void attack1 (Character enemy) {}
    public void attack2 (Character enemy) {}
    public void attack3 (Character enemy) {}

    public void special1 (Character enemy) {}
    public void special2 (Character enemy) {}
    public void special3 (Character enemy) {}

    public void defend() {}

    public String about() {
	return "A character with emphasis on power. It's brolicness takes away from it's brains and speed; Indeed this character is the embodiment of brawns over brain";    
    }
}
