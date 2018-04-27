// Agent gateChecker in project intelligentHell

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */

+visitor(good)[source(dead)]		
	<- .print("You can enter the ELYSIUM section."); 
	   .send(dead, tell, arrived(elysium)).

+visitor(natural)[source(dead)]		
	<- .print("You can enter the ASPHODELUS section."); 
	   .send(dead, tell, arrived(asphodelus)).
	   
+visitor(bad)[source(dead)]		
	<- .print("You can enter the MOURNING section."); 
	   .send(dead, tell, arrived(mourning)).
   