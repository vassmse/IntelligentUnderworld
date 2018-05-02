// Agent gateChecker in project intelligentHell


/* Plans */

+!letmein: visitor(elysium)
	<- .print("You can enter the ELYSIUM section."); 
	   .send(dead, tell, arrived(elysium)).
	   
+!letmein: visitor(asphodelus)
	<- .print("You can enter the ASPHODELUS section."); 
	   .send(dead, tell, arrived(asphodelus)).
	   	      
+!letmein: visitor(mourning)
	<- .print("You can enter the MOURNING section."); 
	   .send(dead, tell, arrived(mourning)).
	  