package gui.views.inside;

import gui.views.inside.displays.FloorChainDisplay;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import properties.ProgramSettings;

import simulator.model.Elevator;
import simulator.model.Target;

/**
 * 
 * @author Rob
 * Diese Klasse repräsentiert ein Panel, welches alle Anzeige-Elemente
 * des Fahrstuhls enthält
 */
public class DisplayPanel extends JPanel {
	
	private static final long serialVersionUID = -7053155399480364159L;
	
	//VARIATIONSPUNKT
	//Feature: aktuelle Etage (Zahl)
	private JLabel lblCurrentFloor;
	
	//VARIATIONSPUNKT
	//Feature: aktuelle Etage (Kette)
	private FloorChainDisplay chainDisplay;
	
	
	private JLabel lblTargetFloor;
	
	private JLabel lblDoorOpen;
	
	private JLabel lblDirection;
	
	private JLabel lblController;
	
	private String sControllerName;
	
	private final int PANEL_WIDTH = 500;
	private final int PANEL_HEIGHT = 320;
	

	
	
	/**
	 * @return the lblTargetFloor
	 */
	public JLabel getLblTargetFloor() {
		return lblTargetFloor;
	}
	

	/**
	 * @return the lblDoorOpen
	 */
	public JLabel getLblDoorOpen() {
		return lblDoorOpen;
	}

	/**
	 * @return the lblDirection
	 */
	public JLabel getLblDirection() {
		return lblDirection;
	}

	/**
	 * @return the lblController
	 */
	public JLabel getLblController() {
		return lblController;
	}
	

	
	public DisplayPanel(String sControllerName) {
		super();
		this.sControllerName = sControllerName;
		init();
	}
	
	public void init() {
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(new BorderLayout());
		// das Panel fur space, darein kommt jpStatus

		JPanel jpStatus = new JPanel();
		jpStatus.setLayout(new GridLayout(7, 2));

		// font fuer die Anzeigen
		Font font = new Font("Arial", Font.PLAIN, 13);
		
		// Controller-Typ
		lblController = new JLabel();
		lblController.setFont(font);
		
		
		lblController.setText(sControllerName);
		
		jpStatus.add(new JLabel("Controller:"));
		jpStatus.add(lblController);
		
		if(ProgramSettings.DISPLAY_FLOOR_NUMBER){
			// aktuelle Etage (Zahl)
			lblCurrentFloor = new JLabel("0");
			lblCurrentFloor.setFont(font);
			jpStatus.add(new JLabel("Aktuelle Etage: "));
			jpStatus.add(lblCurrentFloor);
		}
		
		if(ProgramSettings.DISPLAY_FLOOR_CHAIN){
			// aktuelle Etage (Kette)
			chainDisplay = new FloorChainDisplay();
			this.add(chainDisplay, BorderLayout.NORTH);
		}
		
		if(ProgramSettings.DISPLAY_TARGET){
			// Zieletage
			lblTargetFloor = new JLabel("keine");
			lblTargetFloor.setFont(font);
			jpStatus.add(new JLabel("Zieletage:"));
			jpStatus.add(lblTargetFloor);
		}
		
		if(ProgramSettings.DISPLAY_DOORSIDE){
			// Tür-Zustand
			lblDoorOpen = new JLabel();
			lblDoorOpen.setFont(font);
			jpStatus.add(new JLabel("Tür:"));
			jpStatus.add(lblDoorOpen);
		}

		if(ProgramSettings.DISPLAY_DIRECTION){
			// Fahrtrichtung
			lblDirection = new JLabel();
			Icon icArrowZ = new ImageIcon(getClass().getResource("../../../stop.gif"));
			lblDirection.setIcon(icArrowZ);
			jpStatus.add(new JLabel("Richtung:"));
			jpStatus.add(lblDirection);
		}
		
		jpStatus.setPreferredSize(new Dimension(400, 300));
		this.add(jpStatus, BorderLayout.CENTER);

		// Panels fuer abstaende
		this.add(new JPanel(), BorderLayout.EAST);
		
	}
	
	/**
	 * Anzeige der Statuswerte des Fahrstuhls aktualisieren
	 */
	public void updateValues(Elevator elevator, Target currentTarget) {
		
		int iCurrentFloor = elevator.getCurrentFloor();
		int iDirection = elevator.getDirection();
		
		if(ProgramSettings.DISPLAY_FLOOR_NUMBER){
			lblCurrentFloor.setText(Integer.toString(iCurrentFloor + iDirection));
		}
		
		if(ProgramSettings.DISPLAY_FLOOR_CHAIN){
			chainDisplay.setValue(iCurrentFloor + iDirection);
		}
		
		if(ProgramSettings.DISPLAY_TARGET){
			if (currentTarget != null) {
				lblTargetFloor.setText(Integer.toString(currentTarget.getFloor()));
			}
		}
	}
	
	
	/**
	 * Diese Methode wechselt das Bild der Richtungsanzeige, je nachedem, ob der
	 * Fahrstuhl steht, nach oben oder nach unten faehrt.
	 */
	public void changeImageDirection(int iDirection) {

		switch(iDirection) {
			case 1:
				lblDirection.setIcon(new ImageIcon(getClass().getResource(
				"../../../up.gif")));
				break;
			case -1:
				lblDirection.setIcon(new ImageIcon(getClass().getResource(
				"../../../down.gif")));
				break;
			default:
				lblDirection.setIcon(new ImageIcon(getClass().getResource(
				"../../../stop.gif")));
				break;
		}
		
	}
	
}
