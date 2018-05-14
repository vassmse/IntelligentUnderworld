// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

//position(gate).
~arrived(destination).

/* Initial goals */
!move(cerberus).

/* Plans */

+!move(cerberus) : position(gate)	 
	<- -position(gate);
	   +position(cerberus);
	   .print("Hi Cerberus, please let me in.");
	   .send(cerberus,tell,visitor(in));
	   move_towards(cerberus).
   
 +!move(classifier)[source(cerberus)] : position(cerberus)
	<- -position(cerberus);
	   +position(classifier);
	   .print("Hi Classifier Creature, where should I go?");
	   .send(classifierCreature,tell,visitor(status(bad),degOfCert(0.4))); //todo:ezt honnan szedi?? GUIN kéne beállítani pl, más és más kül. halottaknál 	
	   move_towards(classifierCreature).
   
+!move(X)[source(classifierCreature)] : position(classifier)
	<-  -position(classifier);
	    +position(X);
	    .print("Hello ",X," Gate Checker. Let me in.");
	    .send(X,achieve,letmein);
	    move_towards(X);.	    
	    
	    
+arrived(X):true
	<- .print("I arrived to ",X,". I will be there forever.");.
