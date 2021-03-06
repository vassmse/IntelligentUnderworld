package intelligentUnderworld;

import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;

public class TartarusModel extends GridWorldModel {

	public static final int GSize = 7;
	public static final int CERBERUS = 128;
	public static final int CLASSIFIER_CREATURE = 64;
	public static final int GATECHECKER_ELYSIUM = 8;
	public static final int GATECHECKER_ASPHODELUS = 32;
	public static final int GATECHECKER_MOURNING = 16;

	Location lCerberus = new Location(1, 3);
	Location lClassifierCreature = new Location(3, 3);
	Location lGateCheckerElysium = new Location(5, 1);
	Location lGateCheckerAsphodelus = new Location(5, 3);
	Location lGateCheckerMourning = new Location(5, 5);
	Location lGate = new Location(0, 3);

	protected TartarusModel() {
		// create a 7x7 grid with one mobile agent
		super(GSize, GSize, 1);

		// initial location of dead
		// TODO 0 should mean the ag code of dead
		setAgPos(0, 0, 3);

		// initial location of the non-moving agents
		add(CERBERUS, lCerberus);
		add(CLASSIFIER_CREATURE, lClassifierCreature);
		add(GATECHECKER_ELYSIUM, lGateCheckerElysium);
		add(GATECHECKER_ASPHODELUS, lGateCheckerAsphodelus);
		add(GATECHECKER_MOURNING, lGateCheckerMourning);

		// TODO methods

	}

	boolean moveTowards(Location dest) {
		Location r1 = getAgPos(0);
		if (r1.x < dest.x)
			r1.x++;
		else if (r1.x > dest.x)
			r1.x--;
		if (r1.y < dest.y)
			r1.y++;
		else if (r1.y > dest.y)
			r1.y--;

		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}

		setAgPos(0, r1);

		try {
			Thread.sleep(200);
		} catch (Exception e) {
		}

		setAgPos(0, dest);

		try {
			Thread.sleep(500);
		} catch (Exception e) {
		}

		if (dest.x == 5) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}

			r1.x = 6;
			r1.y = dest.y;
			setAgPos(0, r1);
		}

		return true;
	}

}
