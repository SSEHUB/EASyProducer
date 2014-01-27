package gui.views.inside;

import gui.buttons.AuthorizeButton;
import gui.buttons.DefaultButton;
import gui.views.ScrollPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import main.ElevatorSimulator;
import properties.ProgramSettings;
import gui.buttons.EmergencyButton;

public class ControlPanel extends ScrollPanel {
	

	private static final long serialVersionUID = 1048074068165896521L;
	
	private ArrayList<DefaultButton> lButtons;
	
	private int iElevatorIndex;
		
	private EmergencyButton emergencyButton;
	
	public EmergencyButton getEmergencyButton() {
		return emergencyButton;
	}
	
		
	private JButton openButton;
	
	private JButton closeButton;
	
	/**
	 * @return the openButton
	 */
	public JButton getOpenButton() {
		return openButton;
	}

	/**
	 * @return the closeButton
	 */
	public JButton getCloseButton() {
		return closeButton;
	}
	
	/**
	 * @return the lButtons
	 */
	public ArrayList<DefaultButton> getButtons() {
		return lButtons;
	}
	
	
	public ControlPanel(int iElevatorIndex) {
		super();
		this.iElevatorIndex = iElevatorIndex;
		lButtons = new ArrayList<DefaultButton>(ProgramSettings.FLOORS);
		
		init();
	}

	public void init() {
		int iwButton = 30;
		int ihButton = 15;
		// neue Scrollclasse, damit in durch die Tabs gescrollt werden kann.

		this.setLayout(new GridLayout(2 + (ProgramSettings.FLOORS / 6),
				6));
		this.setPreferredSize(new Dimension(350, (ihButton + 5)
				* (ProgramSettings.FLOORS / 4) + 40));
		
		//Button zum offen halten und schließen der Tür
		if(ProgramSettings.INNERVIEW_DOORBUTTON){
			addOpenCloseButtons();
		}else{
			this.add(new JLabel());
		}
		
		//Notrufbutton
		if(ProgramSettings.INNERVIEW_EMERGENCY){
			addEmergencyButton();
		}else{
			this.add(new JLabel());
		}
		
		//Button für Schutzbereiche 
		if(ProgramSettings.INNERVIEW_AUTH){
			this.add(new AuthorizeButton());
		}else{
			this.add(new JLabel());
		}

		
		// leere Labels adden, damit der erste Etagenbutton nicht direkt
		// neben dem Notrufbutton erscheint
		this.add(new JLabel());
		this.add(new JLabel());
		
		// Buttons erzeugen
		for (int i = 0; i < ProgramSettings.FLOORS; i++) {
			DefaultButton mjbButton = new DefaultButton(i, iElevatorIndex, true);
			mjbButton.setPreferredSize(new Dimension(iwButton, ihButton));

			lButtons.add(mjbButton);
			this.add(mjbButton);
		}
	}

	/**
	 * f&uuml;gt die Buttons f&uuml;r T&uuml;r auf/zu in die GUI ein
	 */
	public void addOpenCloseButtons() {
		Icon close = new ImageIcon(getClass().getResource("../../../close.gif"));
		Icon open = new ImageIcon(getClass().getResource("../../../open.gif"));

		openButton = new JButton();
		openButton.setIcon(open);

		closeButton = new JButton();
		closeButton.setIcon(close);

		openButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Die Variable wird mit jedem Klick auf den Button invertiert.
				ElevatorSimulator.getInstance().getController(
						/*
						 * #if($elevators > 1)
						 */
							iElevatorIndex
							/*
							 * #end
							 */
							).getElevator().setbKeepDoorsOpen(
								!ElevatorSimulator.getInstance().getController(
										/*
										 * #if($elevators > 1)
										 */
											iElevatorIndex
											/*
											 * #end
											 */
											).getElevator().isbKeepDoorsOpen());
			}
		});
		closeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Die Variable wird mit jedem Klick auf den Button invertiert.
				ElevatorSimulator.getInstance().getController(
						/*
						 * #if($elevators > 1)
						 */
							iElevatorIndex
							/*
							 * #end
							 */
							).getElevator().setbCloseDoorsNow(
								!ElevatorSimulator.getInstance().getController(
										/*
										 * #if($elevators > 1)
										 */
											iElevatorIndex
											/*
											 * #end
											 */
											).getElevator().isbCloseDoorsNow());
			}

		});

		this.add(openButton);
		this.add(closeButton);
	}

	
	/**
	 * Erzeugt Notruf-Button.
	 */
	private void addEmergencyButton() {
		emergencyButton = new EmergencyButton(-1, iElevatorIndex, true);
		emergencyButton.setPreferredSize(new Dimension(20, 20));
		this.add(emergencyButton);
	}
}
