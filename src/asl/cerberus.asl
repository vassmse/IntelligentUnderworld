// Agent cerberus in project intelligentHell
// Cerberus guards the gate of the underworld

/* Initial beliefs and rules */
//escape(false).

/* Initial goals */


/* Plans */

+visitor[source(dead)]
	<- .print("You can enter the Underworld.");
	   .send(dead,achieve,move(classifier)).
