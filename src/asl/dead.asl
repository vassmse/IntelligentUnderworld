// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

//position(gate).
position(nowhere).
~arrived(destination).


/* Initial goals */
!move(cerberus).

/* Plans */

+!move(cerberus) : position(nowhere)	
<- .print("Waiting... Am I good?");.
//	+position(gate);
//	-position(nowhere);
//	+move(cerberus);.
//	
	
+move(cerberus) : position(gate)	 
	<-	move_towards(cerberus);
	   -position(gate);
	   +position(cerberus);
	   .print("Hi Cerberus, please let me in.");
	   .send(cerberus,tell,visitor(in));.
	   
   
 +!move(classifier)[source(cerberus)] : position(cerberus)
	<-  move_towards(classifierCreature);
	   -position(cerberus);
	   +position(classifier);
	   .print("Hi Classifier Creature, where should I go?");  
       .send(classifierCreature,tell,visitor(status(A),degOfCert(B)));. //todo:ezt honnan szedi?? GUIN k�ne be�ll�tani pl, m�s �s m�s k�l. halottakn�l 	
	   
   
+!move(X)[source(classifierCreature)] : position(classifier)
	<-  move_towards(X); 
	    -position(classifier);
	    +position(X);
	    .print("Hello ",X," Gate Checker. Let me in.");
	    .send(X,achieve,letmein);.
	   
	    
	    
+arrived(X):true
	<- .print("I arrived to ",X,". I will be there forever.");.
