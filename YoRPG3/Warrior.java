public class Warrior extends Character {

    public Warrior() {
	this("noName"); 
    }
    
    public Warrior(String name) {
	this.name = name;
	health = origHealth = 200;
	defense = origDefense = 55;
	speed = origSpeed = 55;
        evasion = origEvasion = 30;
	charge = 0;
	state = 0;
	attackRating = origAttack = .95;
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
