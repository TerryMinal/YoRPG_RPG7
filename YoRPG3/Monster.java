//Team RPG-7: Xin Yi Chen, Terry Guan, Alitquan Mallick
//APCS1 pd4
//HW30 -- Ye Olde Role Playing Game 
//2016-11-16

public class Monster extends Character {

    public Monster() {
        health = 150; 
        strength = (int) (Math.random() * 50 + 30);
        defense = 20; 
        attackRating = 3;
	name = "Brownies";
    }

   
}
