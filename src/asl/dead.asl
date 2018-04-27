// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

position(gate).
~arrived(destination).

/* Initial goals */
!move(cerberus).

/* Plans */

+!move(cerberus) : position(gate)	 
	<- -position(gate);
	   +position(cerberus);
	   .print("Hi Cerberus, please let me in.");
	   .send(cerberus,tell,visitor);.
   
 +!move(classifier)[source(cerberus)] : position(cerberus)
	<- -position(cerberus);
	   +position(classifier);
	   .print("Hi Classifier Creature, where should I go?");
	   .send(classifierCreature,tell,visitor(bad));.
	   
+!move(mourning)[source(classifierCreature)] : position(classifier)
	<-  -position(classifier);
	    +position(mourning);
	    .print("Morning, Mourning Gate Checker. Let me in.");
	    .send(mourning,tell,visitor(bad)).
+arrived(X):true
	<- .print("I arrived to ",X,". I will be there forever.").
