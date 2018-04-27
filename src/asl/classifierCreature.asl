// Agent classifierCreature in project intelligentHell
// The Classifier Creature decide which person goes to which section of hell

/* Initial beliefs and rules */


/* Initial goals */

//!classify.


/* Plans */

+visitor(bad)[source(dead)]		
	<- .print("You should go to the MOURNING section, you are a bad dead."); //TODO: Szóljon a gatechackernek is
	   .send(dead, achieve, move(mourning)).
 
