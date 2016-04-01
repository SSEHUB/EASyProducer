package gui.views.outside;

import gui.buttons.$outerview_buttontype;
//import gui.buttons.DefaultButton;
import gui.views.ScrollPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import properties.ProgramSettings;

import gui.buttons.EmergencyButton;


/**
 * Eigene Klasse die von JPanel erbt und die einzelnen Etagen aufs Panel
 * zeichnet. Implementiert Scrollable, damit es Scrollbar ist.
 * 
 */
public class ElevatorPanel extends ScrollPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel elevatorImage;
	
	private int iElevatorIndex;
	
	private ArrayList<$outerview_buttontype> callButtons;
	
	private ArrayList<EmergencyButton> emergencyButtons;
	
	/**
	 * @return the emergencyButtons
	 */
	public ArrayList<EmergencyButton> getEmergencyButtons() {
		return emergencyButtons;
	}
	
	
	
	public ArrayList<$outerview_buttontype> getCallButtons() {
		return callButtons;
	}

	public int getElevatorIndex() {
		return iElevatorIndex;
	}

	/**
	 * @return the elevatorImage
	 */
	public JLabel getElevatorImage() {
		return elevatorImage;
	}

	/**
	 * Ueberladener Konstruktor.
	 */
	public ElevatorPanel(int iIndex) {

		this.iElevatorIndex = iIndex;
		this.callButtons = new ArrayList<$outerview_buttontype>(ProgramSettings.FLOORS);
		
		createPanel();
	}

	/**
	 * zeichnet das Panel mit dem Elevator-Image.
	 */
	public void createPanel() {
		this.setLayout(null);
		/*
		 * Ist f&uuml;r das repaint des Graphic-Objektes nun nicht mehr selber
		 * verantwortlich.
		 */
		this.setOpaque(false);
		
		this.setPreferredSize(new Dimension(200, Math.max(470, (ProgramSettings.getTotalHeight(ProgramSettings.FLOORS)) + 81)));

		this.elevatorImage = new JLabel();
		Icon icon = new ImageIcon(getClass().getResource("../../../doorsClosed.gif"));
		this.elevatorImage.setIcon(icon);
		this.elevatorImage.setBounds(55, this.getPreferredSize().height - 64, 40, 40);
		this.add(elevatorImage);

		// anzahl buttons pro etage
		/*
		 * #if($controller_synchronized == true)
		 */
			if (ProgramSettings.FLOORS_BUTTONS == ProgramSettings.ELEVATORS) {
				createComponents();
			} else {
				int iii = Math.round(ProgramSettings.ELEVATORS / ProgramSettings.FLOORS_BUTTONS);

				// wenn iii == 1, falls kommazahl und abgerundet wird, dann nur
				// buttons, wenn kleiner als anzahl knoepfe/etage
				if ((iii == 1)
						&& iElevatorIndex < ProgramSettings.FLOORS_BUTTONS) {

					createComponents();

				}
				// wenn iControllerIndex vielfache von iii
				if ((iii != 1) && ((iElevatorIndex + 1) % iii) == 0) {
					createComponents();
				}

			}
		/*
		 * #else
		 */
			createComponents();
		/*
		 * #end
		 */

	}

	private void createComponents() {
		createButtons();
		createFloorLabels();
		if(ProgramSettings.OUTERVIEW_EMERGENCY){
			createEmergencyButtons();
		}
	}


	/**
	 * Diese Methode added Buttons zum hoch oder runterfahren neben die
	 * Fahrstuehle.
	 */
	public void createButtons() {
		// Rufbuttons erzeugen

		for (int i = 0; i < ProgramSettings.FLOORS; i++) {
			
			$outerview_buttontype tmpButton = new $outerview_buttontype(i, iElevatorIndex);

			
			tmpButton.setBounds(110, this.getPreferredSize().height
					- (i * ProgramSettings.FLOORS_HEIGHT)
					- 45, 50, 20);
			
			callButtons.add(tmpButton);
			
			this.add(tmpButton);
			
		}
			
	}
	
	
	private void createFloorLabels() {
		for(int i = 0; i < ProgramSettings.FLOORS; i++) {
			
			// Label für Etagennummer initialisieren
			JLabel lblFloor = new JLabel(Integer.toString(i));		
			lblFloor.setText(Integer.toString(i));
			
			lblFloor.setPreferredSize(new Dimension(10, 5));
			

			lblFloor.setBounds(35 - (5 * lblFloor.getText().length()), this.getPreferredSize().height
					- (i * ProgramSettings.FLOORS_HEIGHT)
					- 55, lblFloor.getText().length() * 10, 45);

			this.add(lblFloor);
		}
		
	}

	
	/**
	 * Diese Methode erzeugt neben jeder Etage einen Notruf-Button
	 */
	private void createEmergencyButtons() {
		this.emergencyButtons = new ArrayList<EmergencyButton>();
		for (int i = 0; i < ProgramSettings.FLOORS; i++) {
			EmergencyButton emButton = new EmergencyButton(i, iElevatorIndex, false);
			

				emButton.setBounds(170, this.getPreferredSize().height
						- (i * ProgramSettings.FLOORS_HEIGHT) - 45,
						20, 20);
			
			emergencyButtons.add(emButton);
			this.add(emButton);
		}
	}

	/**
	 * Diese Methode zeichnet die Rechtecke fuer die Etagen.
	 * 
	 * @param g
	 *            die gezeichnete Grafik
	 */
	public void paintComponent(Graphics g) {

		for (int i = 0; i < ProgramSettings.FLOORS; i++) {
			

				g.drawRect(ProgramSettings.FLOORS_HEIGHT, this
						.getPreferredSize().height
						- (i * ProgramSettings.FLOORS_HEIGHT) - 70,
						ProgramSettings.FLOORS_HEIGHT,
						ProgramSettings.FLOORS_HEIGHT);
			
		}
	}

}