/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name?
    private int moveCount;
    private boolean gameOver;
    private int difficulty;
    private int chosenClass;
    private int enemyChosenAttack = (int) (Math.random()*4.1);//range from 0 to 4 
    
    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String t;
	String name = "";
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose thou difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid character, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	t = "Intrepid character, what class do thy want to be'eth?";
	t += "\nChoose thou  character: \n";
	t += "\t1: Warrior\n";
	t += "\t2: Mage\n";
	t += "\t3: Monk\n";
	t += "\t4: Rogue\n";
	t += "Selection: ";
	System.out.print( t );

	try {
	    chosenClass = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }



	//instantiate the player's character
	if ( chosenClass == 1) {
	    pat = new Warrior(name); 
	}
        else if ( chosenClass == 2) {
	    pat = new Mage (name);
	  }
	else if ( chosenClass == 3) {
	    pat = new Monk (name);
	}
	else if ( chosenClass == 4) {
	    pat = new Rogue (name);
	}
	else {
	    System.out.println ("Your classeth hath been set to Warrior by defaulteth");
	    pat = new Warrior (name);
	}
        smaug = new Monster(); 

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Character pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int damage; 
	String choice;
	String specialChoice;
	String specialChoice2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );
	    
	    while( smaug.isAlive() && pat.isAlive() ) {
		displayStats(); 
		// Give user the option of using a special attack:
		try {
		    choice = "Choose your attack:\n" ;
		    choice += "\t1: Attack\n" ;
		    choice += "\t2: Special Attack\n" ;
		    choice += "\t3: Defend\n" ;
		     if (pat.charge == 100) {
			choice += "\t4: Special\n";
		    }
		    choice += "Selection: ";
		    System.out.print (choice);
		    
		    int i = Integer.parseInt( in.readLine() );
		    if (i == 4 && pat.charge < 100) { 
			System.out.println("close but no cigar. Choose another attack"); 
			System.out.print(choice); 
		    }
		    //normal attack
		    if (i == 1) {
			try{
			    choice = "\nChoose your attack:\n" ;
			    choice += "\t1: " + pat.attackName[0] + "\n";
			    choice += "\t2: " + pat.attackName[1] + "\n";
			    choice += "\t3: " + pat.attackName[2] + "\n";
			    choice += "\t4: " + pat.attackName[3];
			    System.out.println(choice);
			    System.out.print ("Selection: ");
			
			    int n = Integer.parseInt( in.readLine() );			
			    damage = doBattle(n);  
			    System.out.print ( "\n" + pat.getName() + " dealt " + damage +" points of damage.");
			}
			catch (IOException e) {}
	    
		    }
		
		    //choosing special attack
		    else if (i == 2) {
			try {
			    specialChoice =  "\nChoose your special attack:\n" ;
			    specialChoice += "\t1: Poison\n" ;
			    specialChoice += "\t2: Paralyze\n" ;
			    specialChoice += "\t3: Heal thyself\n" ;
			    specialChoice += "Selection: " ;
			    System.out.print (specialChoice);
			    
			    int j = Integer.parseInt( in.readLine() );
			    specializeBattle(j); 
			}

			catch (IOException e ) { }
		    }
		    //defend 
		    else if (i == 3) {
			pat.defend();
			System.out.println ( pat.getName() + " gets into defensive position. His or her evasion and defense increase!" );
		    }
		    else if (i == 4) {
			    pat.specialize(smaug, 4); 
		    }
		    else {
			pat.attack1 (smaug);
		    }
		    // this is used for testing; generic monster attack
		    /*  int mnA = smaug.attack1 (pat);
			System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() + " for " + mnA + " points of damage."); 
		    if (mnA > 10) {
			pat.charge += 10;
			} */
		    
		    pat.checkCharge(); 
		    smaug.checkCharge(); 
		    pat.checkState(); 
		    smaug.checkState(); 
		}
		catch ( IOException e ) { }
	    }
	    //case analysis of battling
	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... You cut ye olde monster down, but + with its dying breath ye olde monster laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
	        pat.charge(30);//winning gains charge
		pat.normalize(); // reset all stat after each battle
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private int doBattle(int i) {
	int damage; 
	double playerSpeed  = pat.speed * pat.speedPercent[i-1]; //speed percent array goes from 0 to 3
	double monsterSpeed = smaug.speed * smaug.speedPercent[smaug.chosenAttack]; 
	if (playerSpeed > monsterSpeed) {
	    damage = pat.chooseAttack(smaug, i); 
	    smaug.determineAttack(pat); 
	} 
	else {
	    smaug.determineAttack(pat); 
	    damage = pat.chooseAttack(smaug, i); 
	}
	return damage;
    }
    
    private void specializeBattle(int i) {
	if (pat.speed > smaug.speed) { 
	    pat.specialize(smaug, i);
	    smaug.determineAttack(pat);
	}
	else {
	    smaug.determineAttack(pat); 
	    pat.specialize(smaug, i); 
	}
    }

    private void displayStats() {
	String stats;
	stats = pat.getName() +"'s stats:\n";
	stats += "\nhealth: " + pat.health + "\n";
	stats += "charge: " + pat.charge;
	if (pat.identity == 2){
	    Mage temp = (Mage) pat; 
	    stats += "MP: "+ temp.MP +"\n";
	}
	System.out.println(stats); 
    }
    
    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...
	// ================================================*/
        
	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	//	  ================================================*/
    }//end main

}//end class YoRPG


