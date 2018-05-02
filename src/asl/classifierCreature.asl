// Agent classifierCreature in project intelligentHell
// The Classifier Creature decide which person goes to which section of hell


/* Plans */

//GOOD: Dead thinks that itself is good
+visitor(status(X),degOfCert(D))[source(dead)]: visitor(status(good),degOfCert(D)) & D>0.5
	<- .print("You should go to the ELYSIUM section, you are a GOOD dead.");
	   .send(dead, achieve, move(elysium));
	   .send(dead, tell, status(good));
	   .send(elysium, tell, visitor(elysium)).
	   
//NATURAL: Dead thinks that itself is natural OR Dead is not sure, if it's good
+visitor(status(X),degOfCert(D))[source(dead)]: (visitor(status(good),degOfCert(D)) & D<0.5) | (visitor(status(natural),degOfCert(D)) & D>0.5)
	<- .print("You should go to the ASPHODELUS section, you are a NATURAL dead.");
	   .send(dead, achieve, move(asphodelus));
	   .send(dead, tell, status(natural));
	   .send(asphodelus, tell, visitor(asphodelus)).	   	 
   
//BAD: : Dead thinks that itself is bad OR Dead is not sure, if it's natural   
+visitor(status(X),degOfCert(D))[source(dead)]: (visitor(status(natural),degOfCert(D)) & D<0.5) | (visitor(status(bad),degOfCert(D)))
	<- .print("You should go to the MOURNING section, you are a BAD dead.");
	   .send(dead, achieve, move(mourning));
	   .send(dead, tell, status(bad));
	   .send(mourning, tell, visitor(mourning)).
	   

	   
	   
	   
	   
	   
	   