package intelligentUnderworld;

// Environment code for project intelligentUnderworld

import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.Location;

import java.util.logging.*;

public class Tartarus extends Environment {

	//TODO Common literals
	public static final Literal positionCerberus = Literal.parseLiteral("position(cerberus)");
	public static final Literal positionClassifier = Literal.parseLiteral("position(classifier)");
	public static final Literal positionElyisum = Literal.parseLiteral("position(elysium)");
	public static final Literal positionAshodelus = Literal.parseLiteral("position(ashodelus)");
	public static final Literal positionMourning = Literal.parseLiteral("position(mourning)");
	
	
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
    	
//    	model= new TartarusModel();
//        if (args.length == 0 || args.length == 1 && !args[0].equals("gui(off)")) { 
//    	    if (view != null) { // in case init is called twice
//        		view.setVisible(false);
//        		view.dispose();
//    	    }
//            view  = new TartarusView(model);
//            model.setView(view);
//        }
        
        //updatePercepts();
    	
//        super.init(args);
//        try {
//			addPercept(ASSyntax.parseLiteral("percept(demo)"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    private void updatePercepts() {
    	clearPercepts();
    	
//    	Location lDead = model.getAgPos(0);
    	
//    	if(lDead.equals(model.lCerberus)) {
//    		addPercept(positionCerberus);
//    	}
//    	if(lDead.equals(model.lClassifierCreature)) {
//    		addPercept(positionClassifier);
//    	}
	}

	@Override
    public boolean executeAction(String agName, Structure action) {
		logger.info(agName+" doing: "+ action);
//        try {
//            if (action.equals(ns)) {
//                model.nextSlot();
//            } else if (action.getFunctor().equals("move_towards")) {
//                int x = (int)((NumberTerm)action.getTerm(0)).solve();
//                int y = (int)((NumberTerm)action.getTerm(1)).solve();
//                model.moveTowards(x,y);
//            } else if (action.equals(pg)) {
//                model.pickGarb();
//            } else if (action.equals(dg)) {
//                model.dropGarb();
//            } else if (action.equals(bg)) {
//                model.burnGarb();
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        updatePercepts();

       // try {
        //    Thread.sleep(200);
       // } catch (Exception e) {}
        //informAgsEnvironmentChanged();
        return true;
    }

    /** Called before the end of MAS execution */
//    @Override
//    public void stop() {
//    	if (view != null) {
//    	    view.setVisible(false);
//    	    view.dispose();
//    	}
//    }
}
