// Agent gateChecker in project intelligentHell

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */

+visitor(bad)[source(dead)]		
	<- .print("You can enter the MOURNING section."); 
	   .send(dead, tell, arrived(mourning)).
