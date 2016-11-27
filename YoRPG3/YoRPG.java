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
    private int enemyChosenAttack = (int) (Math.random() * 3); 
    
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
        

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int i = 1;
	int j = 1;
	int s = 1;
	int d1, d2, j1, j2, j3, j4, nA, mnA;
	String choice;
	String specialChoice;
	String specialChoice2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    choice = "\nChoose your attack:\n" ;
		    choice += "\t1: Normal Attack\n" ;
		    choice += "\t2: Special Attack\n" ;
		    choice += "\t3: Defend\n" ;
		    choice += "Selection: ";
		    if (pat.charge == 100) {
			choice += "\t4: Special";
		    }
		    System.out.print (choice);
		    
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		// mage's magic is left out, instanceof is the best way to include it
		
		if (i == 1) {
		    nA = pat.normalAttack (smaug);
		    System.out.println( "\n" + pat.getName() + " dealt " + nA + "points of damage.");
		}
		else if (i == 2) {
		    try {
			specialChoice =  "\nChoose your special attack:\n" ;
			specialChoice += "\t1: Special Attack 1\n" ;
		        specialChoice += "\t2: Special Attack 2\n" ;
		        specialChoice +=  "\t3: Special Attack 3\n" ;
			specialChoice +=  "Selection :" ;
			System.out.print (specialChoice);
			j = Integer.parseInt( in.readLine() );
		    }
		    catch (IOException e ) { }

		    if (j == 1) {
			j1 = pat.attack1 (smaug);
			System.out.println( "\n" + pat.getName() + " dealt " + j1 +" points of damage.");
		    }
		    else if (j == 2) {
			j2 = pat.attack2 (smaug);
			System.out.println( "\n" + pat.getName() + " dealt " + j2 +" points of damage.");
		    }
		    else if (j == 3) {
			j3 = pat.attack3 (smaug);
			System.out.println( "\n" + pat.getName() + " dealt " + j3 +" points of damage.");
		    }
		    else {
			j4 = pat.normalAttack (smaug);
			System.out.println( "\n" + pat.getName() + " dealt " + j4 +" points of damage.");
		    }
		}
		else if (i == 3) {
		    pat.defend();
		    System.out.println ( pat.getName() + " gets into defensive position. His or her evasion and defense increase!" );
		}
		else if (i == 4) {
		    if (pat.charge > 0) {
			try {
			    specialChoice = "\nChoose your special attack:" ;
			    specialChoice +=  "\t1: Special Technique 1" ;
			    specialChoice += "\t2: Special Technique 2" ;
			    specialChoice += "\t3: Special Technique 3" ;
			    System.out.print (specialChoice);
			    s = Integer.parseInt( in.readLine() );
			}
			catch (IOException e ) { }
			// utilization of special
			if  (s == 1) {}
			else if (s == 2) {}
			else if (s == 3) {}
			else {
			    pat.normalAttack(smaug);
			}
		    }
		    else { pat.normalAttack (smaug);
		    }
		}
		else {
		    pat.normalAttack (smaug);
		}
		// this is used for testing; generic monster attack
	        mnA = smaug.normalAttack (pat);
		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + mnA + " points of damage.");
	    }
        

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
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

    private void whoGoesFirst(Monster opp, int i) {
	double playerSpeed  = pat.speed * pat.speedPercent[i];
	double monsterSpeed = opp.speed * opp.speedPercent[enemyChosenAttack]; 
	if (playerSpeed > monsterSpeed) {
	    pat.chooseAttack(opp, i); 
	    opp.chooseAttack(pat, enemyChosenAttack);
	} 
	else {
	    opp.chooseAttack(pat, enemyChosenAttack); 
	    pat.chooseAttack(opp, i); 
	}
    }
}//end class YoRPG


