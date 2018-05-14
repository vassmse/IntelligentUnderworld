package intelligentUnderworld;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

public class TartarusView extends GridWorldView{

	private static final long serialVersionUID = 1L;
		
	TartarusModel tartarusModel;
	
	public TartarusView(TartarusModel model) {
		super(model, "Intelligent Underworld", 700);
		tartarusModel = model;
		defaultFont = new Font("Arial", Font.BOLD, 12); // change default font
		setVisible(true);
		repaint();
	}
	
	//draw application objects
	@Override
	public void draw(Graphics g, int x, int y, int object) {
		Location lDead = tartarusModel.getAgPos(0);
		
		switch(object) {
			case TartarusModel.CERBERUS:
				if(lDead.equals(tartarusModel.lCerberus)) {
					super.drawAgent(g, x, y, Color.yellow, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "CERBERUS");
				}
				else {
					super.drawAgent(g, x, y, Color.gray, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "CERBERUS");
				}				
				break;
			case TartarusModel.CLASSIFIER_CREATURE:
				if(lDead.equals(tartarusModel.lClassifierCreature)) {
					super.drawAgent(g, x, y, Color.yellow, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "CLASSIFIER_CREATURE");
				}
				else {
					super.drawAgent(g, x, y, Color.gray, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "CLASSIFIER_CREATURE");
				}				
				break;
			case TartarusModel.GATECHECKER_ELYSIUM:
				if(lDead.equals(tartarusModel.lGateCheckerElysium)) {
					super.drawAgent(g, x, y, Color.yellow, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_ELYSIUM");
				}
				else {
					super.drawAgent(g, x, y, Color.gray, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_ELYSIUM");
				}				
				break;
			case TartarusModel.GATECHECKER_ASPHODELUS:
				if(lDead.equals(tartarusModel.lGateCheckerAsphodelus)) {
					super.drawAgent(g, x, y, Color.yellow, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_ASPHODELUS");
				}
				else {
					super.drawAgent(g, x, y, Color.gray, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_ASPHODELUS");
				}				
				break;
			case TartarusModel.GATECHECKER_MOURNING:
				if(lDead.equals(tartarusModel.lGateCheckerMourning)) {
					super.drawAgent(g, x, y, Color.yellow, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_MOURNING");
				}
				else {
					super.drawAgent(g, x, y, Color.gray, -1);
					g.setColor(Color.black);
    	            drawString(g, x, y, defaultFont, "GATECHECKER_MOURNING");
				}				
				break;
			}
		
	}
	
    @Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id) {
    	super.drawAgent(g, x, y, Color.PINK, -1);
    	g.setColor(Color.black);
        drawString(g, x, y, defaultFont, "dead_is_here");
        Location lDead = tartarusModel.getAgPos(0);
        if (   !lDead.equals(tartarusModel.lCerberus) 
			&& !lDead.equals(tartarusModel.lClassifierCreature) 
			&& !lDead.equals(tartarusModel.lGateCheckerElysium) 
			&& !lDead.equals(tartarusModel.lGateCheckerAsphodelus) 
			&& !lDead.equals(tartarusModel.lGateCheckerMourning)) {
            super.drawAgent(g, x, y, Color.yellow, -1);
            g.setColor(Color.black);
            super.drawString(g, x, y, defaultFont, "Dead");
        }
    }
	
	

}
