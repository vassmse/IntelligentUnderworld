// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

position(gate).
~arrived(destination).

/* Initial goals */
!move(cerberus).

/* Plans */

+!move(cerberus) : position(gate)
	<- .print("Hi Cerberus, please let me in.");
	   -position(gate);
	   +position(cerberus);
	   .send(cerberus,tell,visitor);.
   
 +!move(classifier)[source(cerberus)] : position(cerberus)
	<- .print("Hi Classifier Creature, where should I go?");
	   +position(classifier);
	   -position(cerberus);
	   .send(classifierCreature,tell,visitor(bad));. //TODO: Átrendezni logikusan a cselekvéseket
	   
+!move(mourning)[source(classifierCreature)] : position(classifier)
	<-  -position(classifier);
	    +position(mourning);
	    .print("Morning, Mourning Gate Checker. Let me in.");
	    .send(mourning,tell,visitor(bad)).
+arrived(X):true
	<- .print("I arrived to ",X).
