// Agent cerberus in project intelligentHell
// Cerberus guards the gate of the Underworld


/* Plans */

+visitor(in)[source(dead)]
	<- .print("You can enter the Underworld.");
	   .send(dead,achieve,move(classifier)).
	   
+visitor(out)[source(dead)]
	<- .print("You can NOT leave the Underworld.").
