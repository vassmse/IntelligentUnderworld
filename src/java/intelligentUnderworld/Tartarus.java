package intelligentUnderworld;

// Environment code for project intelligentUnderworld

import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.Location;

import java.util.logging.*;

public class Tartarus extends Environment {

	// TODO Common literals
	public static final Literal positionCerberus = Literal.parseLiteral("position(cerberus)");
	public static final Literal positionClassifier = Literal.parseLiteral("position(classifier)");
	public static final Literal positionElyisum = Literal.parseLiteral("position(elysium)");
	public static final Literal positionAshodelus = Literal.parseLiteral("position(ashodelus)");
	public static final Literal positionMourning = Literal.parseLiteral("position(mourning)");
	public static final Literal positionGate = Literal.parseLiteral("position(gate)");
	public static final Literal positionNowhere = Literal.parseLiteral("position(nowhere)");
	public static final Literal goalMove = Literal.parseLiteral("move(cerberus)");
	
	public double degOfCert = 8;
	public String agentState = "good";
	
	public Literal statusAgent = null;
	
	
//	public Literal whereTo = Literal.parseLiteral(".send(classifierCreature,tell,visitor(status("+agentState+"),degOfCert("+degOfCert+")));");

	
	private Logger logger = Logger.getLogger("intelligentUnderworld." + Tartarus.class.getName());

	TartarusModel model = null; // the model of the grid
	TartarusView view = null;

	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init(String[] args) {
		model = new TartarusModel();
		view = new TartarusView(model);
		model.setView(view);
		//updatePercepts();
		view.setEnv(this);
	}

	private void updatePercepts() {
		logger.info("updateFV");
		clearPercepts();

		Location lDead = model.getAgPos(0);
		
		
		if (lDead.equals(model.lGate)) {
			removePercept("dead", positionNowhere);	
			addPercept("dead",positionGate);
			addPercept("dead", goalMove);
			logger.info("gate");
			
		}

		if (lDead.equals(model.lCerberus)) {
			statusAgent = Literal.parseLiteral("status("+agentState+")");
			addPercept(statusAgent);
			logger.info(statusAgent.toString());
			logger.info(agentState);
		}
		
//		if (lDead.equals(model.lClassifierCreature)) {
//			addPercept(positionClassifier);
//			removePercept(positionCerberus);
//		}
//		if (lDead.equals(model.lGateCheckerAsphodelus)) {
//			addPercept(positionAshodelus);
//			removePercept(positionClassifier);
//		}
//		if (lDead.equals(model.lGateCheckerElysium)) {
//			addPercept(positionElyisum);
//			removePercept(positionClassifier);
//		}
//		if (lDead.equals(model.lGateCheckerMourning)) {
//			addPercept(positionMourning);
//			removePercept(positionClassifier);
//		}

	}

	@Override
	public boolean executeAction(String agName, Structure action) {
		logger.info(agName + " doing: " + action);
		boolean result = false;

		if (action.getFunctor().equals("move_towards")) {
			String l = action.getTerm(0).toString();
			Location dest = null;
			if (l.equals("cerberus")) {
				dest = model.lCerberus;
			} else if (l.equals("classifierCreature")) {
				dest = model.lClassifierCreature;
			} else if (l.equals("mourning")) {
				dest = model.lGateCheckerMourning;
			} else if (l.equals("asphodelus")) {
				dest = model.lGateCheckerAsphodelus;
			} else if (l.equals("elysium")) {
				dest = model.lGateCheckerElysium;
			} 
			try {
				result = model.moveTowards(dest);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		} else if(action.getFunctor().equals("initAbilities")){
//			String agentStatus = action.getTerm(0).toString();
//			String degOfCert = action.getTerm(1).toString();
//			
//		}
//		
		}
		
		
		else {
			logger.info("Failed to execute action " + action);
		}

		if (result) {
			updatePercepts();

		}
		// try {
		// Thread.sleep(800);
		// logger.info("waiting 500ms");
		// } catch (Exception e) {
		// logger.info("AJJAJ");
		// }
		return result;
	}


	public void startAgent(double degOfCert, String agentState) {
		// TODO Auto-generated method stub
		this.agentState=agentState;
		this.degOfCert=degOfCert/10;
		updatePercepts();
		
	}
}
