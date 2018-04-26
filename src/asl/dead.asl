// Agent dead in project intelligentUnderworld
// Dead person

/* Initial beliefs and rules */

position(gate).

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
	   .send(classifierCreature,tell,visitor);.
