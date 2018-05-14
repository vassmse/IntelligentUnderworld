package intelligentUnderworld;

// Environment code for project intelligentUnderworld

import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.Location;

import java.util.logging.*;

public class Tartarus extends Environment {

	//TODO Common literals
//	public static final Literal positionCerberus = Literal.parseLiteral("position(cerberus)");
//	public static final Literal positionClassifier = Literal.parseLiteral("position(classifier)");
//	public static final Literal positionElyisum = Literal.parseLiteral("position(elysium)");
//	public static final Literal positionAshodelus = Literal.parseLiteral("position(ashodelus)");
//	public static final Literal positionMourning = Literal.parseLiteral("position(mourning)");
	public static final Literal positionGate = Literal.parseLiteral("position(gate)");	
	
    private Logger logger = Logger.getLogger("intelligentUnderworld."+Tartarus.class.getName());
    
    TartarusModel model = null; //the model of the grid
    TartarusView view = null;

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
    	model = new TartarusModel();
        view  = new TartarusView(model);
        model.setView(view);
        updatePercepts();    
    }

    private void updatePercepts() {
    	clearPercepts();
    	
    	
    	Location lDead = model.getAgPos(0);
    	
    	if(lDead.equals(model.lGate)) {
    		addPercept(positionGate);
    	}
//    	
//		if(lDead.equals(model.lCerberus)) {
//			addPercept(positionCerberus);
//		}
//		if(lDead.equals(model.lClassifierCreature)) {
//			addPercept(positionClassifier);
//		}
//		if(lDead.equals(model.lGateCheckerAsphodelus)) {
//			addPercept(positionAshodelus);
//		}
//		if(lDead.equals(model.lGateCheckerElysium)) {
//			addPercept(positionElyisum);
//		}
//		if(lDead.equals(model.lGateCheckerMourning)) {
//			addPercept(positionMourning);
//		}
		
	}

	@Override
    public boolean executeAction(String agName, Structure action) {
		logger.info(agName+" doing: "+ action);
		boolean result = false;		

		if (action.getFunctor().equals("move_towards")) {
            String l = action.getTerm(0).toString();
            Location dest = null;
            if(l.equals("cerberus")){
            	dest= model.lCerberus;
            }else if (l.equals("classifierCreature")) {
                dest = model.lClassifierCreature;
            } else if (l.equals("mourning")) {
                dest = model.lGateCheckerMourning;
            }
	            try {
	                result = model.moveTowards(dest);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            logger.info("Failed to execute action "+action);
	        }
	
	        if (result) {
	            updatePercepts();
	            try {
	                Thread.sleep(200);
	            } catch (Exception e) {}
	        }
	        
	        
	        return result;
	    }
}
