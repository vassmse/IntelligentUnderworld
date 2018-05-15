// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

//position(gate).
position(nowhere).
~arrived(destination).
status(natural).
degOfCert(0.7).

/* Initial goals */
!move(cerberus).

/* Plans */

+!move(cerberus) : position(nowhere)	
<- .print("Waiting... Am I good?");.
	
+move(cerberus) : position(gate)	 
	<-	move_towards(cerberus);
	   -position(gate);
	   +position(cerberus);
	   .print("Hi Cerberus, please let me in.");
	   .send(cerberus,tell,visitor(in));.
	   
   
 +!move(classifier)[source(cerberus)] : position(cerberus) & status(S) & degOfCert(D)
	<-  move_towards(classifierCreature);
	   -position(cerberus);
	   +position(classifier);
<<<<<<< HEAD
	   .print("Hi Classifier Creature, where should I go?");  
       .send(classifierCreature,tell,visitor(status(A),degOfCert(B)));. //todo:ezt honnan szedi?? GUIN kéne beállítani pl, más és más kül. halottaknál 	
=======
	   .print("Hi Classifier Creature, where should I go?");
	  .send(classifierCreature,tell,visitor(status(S),degOfCert(D)));. 	
>>>>>>> 9bf915d8ba7ad7093150591130cd0ccaf0aa1100
	   
   
+!move(X)[source(classifierCreature)] : position(classifier)
	<-  move_towards(X); 
	    -position(classifier);
	    +position(X);
	    .print("Hello ",X," Gate Checker. Let me in.");
	    .send(X,achieve,letmein);.
	   
	    
	    
+arrived(X):true
	<- .print("I arrived to ",X,". I will be there forever.");.
