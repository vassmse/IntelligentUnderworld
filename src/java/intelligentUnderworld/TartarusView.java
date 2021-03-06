package intelligentUnderworld;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;


public class TartarusView extends GridWorldView{

	private static final long serialVersionUID = 1L;
	
	Tartarus tartarusEnv= null;
	
	public void setEnv(Tartarus env) {
		this.tartarusEnv= env;
	}
		
	TartarusModel tartarusModel;
	
	public TartarusView(TartarusModel model) {
		super(model, "Intelligent Underworld", 700);
		tartarusModel = model;
		defaultFont = new Font("Arial", Font.BOLD, 12); // change default font
		setVisible(true);
		repaint();
	}
	
	JLabel    jlMouseLoc;
    JComboBox<String> agentState;
    JSlider   degOfCert;
    JButton startButton;
	
	@Override
	public void initComponents(int width)
	{
		super.initComponents(width);
        agentState = new JComboBox<String>();
        
        agentState.addItem("good");
        agentState.addItem("natural");
        agentState.addItem("bad");
            
        JPanel args = new JPanel();
        args.setLayout(new BoxLayout(args, BoxLayout.Y_AXIS));

        JPanel sp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sp.setBorder(BorderFactory.createEtchedBorder());
        sp.add(new JLabel("State of agent:"));
        sp.add(agentState);

        degOfCert = new JSlider();
        degOfCert.setMinimum(0);
        degOfCert.setMaximum(10);
        degOfCert.setValue(1);
        degOfCert.setPaintTicks(true);
        degOfCert.setPaintLabels(true);
        degOfCert.setMajorTickSpacing(10);
        degOfCert.setMinorTickSpacing(1);
        degOfCert.setInverted(false);
        Hashtable<Integer,Component> labelTable = new Hashtable<Integer,Component>();
        labelTable.put( 10, new JLabel("max") );
        labelTable.put( 5, new JLabel("Certanty") );
        labelTable.put( 0, new JLabel("min") );
        degOfCert.setLabelTable( labelTable );
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(BorderFactory.createEtchedBorder());
        p.add(degOfCert);

        startButton = new JButton();
        startButton.setText("Start");
        
        JPanel b = new JPanel(new FlowLayout());
        b.setBorder(BorderFactory.createEtchedBorder());
        b.add(startButton);
        
        args.add(sp);
        args.add(p);
        args.add(b);        
        

        JPanel s = new JPanel(new BorderLayout());
        s.add(BorderLayout.WEST, args);
        getContentPane().add(BorderLayout.SOUTH, s);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //your actions
            	tartarusEnv.startAgent((int)degOfCert.getValue(), agentState.getSelectedItem().toString());
            }
        });
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
