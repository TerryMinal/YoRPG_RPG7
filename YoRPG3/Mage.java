public class Mage extends Character {
    //warrior description
    //  super.description = "A character with emphasis on power. It's brolicness takes away from it's brains and speed; Indeed this character is the embodiment of brawns over brain";  

    public Mage() {
	this("noName"); 
    }
    
    public Mage (String name) {
	this.name = name;
	health = 300;
	strength = 90; 
	defense = origDefense = 40; 
	attackRating = origAttack = .2; 
    }
}


   
   
