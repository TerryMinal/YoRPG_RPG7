public class Rogue extends Character {
    //warrior description
    //  super.description = "A character with emphasis on power. It's brolicness takes away from it's brains and speed; Indeed this character is the embodiment of brawns over brain";  

    public Rogue () {
	this("noName"); 
    }
    
    public Rogue (String name) {
	this.name = name;
	health = 200;
	strength = 95; 
	defense = origDefense = 150; 
	attackRating = origAttack = .3; 
    }
}


   
   
