package intelligentUnderworld;

// Environment code for project intelligentUnderworld

import jason.asSyntax.*;
import jason.environment.*;
import jason.environment.grid.Location;

import java.util.logging.*;

public class Tartarus extends Environment {

	public static final Literal positionGate = Literal.parseLiteral("position(gate)");
	public static final Literal positionNowhere = Literal.parseLiteral("position(nowhere)");
	public static final Literal goalMove = Literal.parseLiteral("move(cerberus)");
	public Literal statusAgent = null;
	public Literal certanity = null;

	public double degOfCert = 8;
	public String agentState = "good";

	private Logger logger = Logger.getLogger("intelligentUnderworld." + Tartarus.class.getName());

	TartarusModel model = null; // the model of the grid
	TartarusView view = null;

	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init(String[] args) {
		model = new TartarusModel();
		view = new TartarusView(model);
		model.setView(view);
		view.setEnv(this);
	}

	private void updatePercepts() {
		clearPercepts();

		Location lDead = model.getAgPos(0);

		if (lDead.equals(model.lGate)) {
			removePercept("dead", positionNowhere);
			addPercept("dead", positionGate);
			addPercept("dead", goalMove);
		}

		if (lDead.equals(model.lCerberus)) {
			statusAgent = Literal.parseLiteral("status(" + agentState + ")");
			certanity = Literal.parseLiteral("degOfCert(" + degOfCert + ")");
			addPercept(statusAgent);
			addPercept(certanity);
		}
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

		}

		else {
			logger.info("Failed to execute action " + action);
		}

		if (result) {
			updatePercepts();

		}

		return result;
	}

	public void startAgent(double degOfCert, String agentState) {
		this.agentState = agentState;
		this.degOfCert = degOfCert / 10;
		updatePercepts();

	}
}
