package gui.buttons;

import gui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.ElevatorSimulator;

/**
 * Klasse, die von JButton erbt und den Notrufbutton repr‰sentiert.
 * 
 */
public class EmergencyButton extends JButton {

	private static final long serialVersionUID = 1L;
	private boolean bActivated = false;
	private int id;
	private int iElevatorIndex;
	private boolean inside;
	private Icon iconActive;
	private Icon iconNotActive;

	/**
	 * Konstruktor
	 * 
	 * @param id - Nummer des Stockwerks
	 * @param iControllerIndex - Index des Controllers, der dieser Button zugeordnet ist
	 * @param inside - Button innen (StatusPanel) oder auﬂen (ElevatorPanel)
	 */
	public EmergencyButton(int id, int iElevatorIndex, boolean bInside) {
		super();
		this.id = id;
		this.inside = bInside;
		this.iElevatorIndex = iElevatorIndex;

		// Icons initialisieren
		this.iconActive = new ImageIcon(getClass().getResource(
				"../../flame_activated.gif"));
		this.iconNotActive = new ImageIcon(getClass().getResource(
				"../../flame.gif"));
		this.setIcon(iconNotActive);

		// this.addActionListener(new MyActionListener());
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (isActivated()) {
					
					setActivated(false);
					
				} else {
					setActivated(true);
					if (!isInside()) {
						
						/*
						 * #if($controlling_synchronized == true)
						 */
						ElevatorSimulator.getInstance().getSuperController()
								.addPriorityCall(
										EmergencyButton.this.iElevatorIndex,
										EmergencyButton.this.id,
										EmergencyButton.this.inside);

						MainWindow.getInstance().activateEmergencyButtons(
									EmergencyButton.this.id, true);
						
						/*
						 * #else
						 */
						
						ElevatorSimulator.getInstance().getController(
								/*
								 * #if($elevators > 1)
								 */
								EmergencyButton.this.iElevatorIndex
								/*
								 * #end
								 */
								).addPriorityCall(EmergencyButton.this.id);
						/*
						 * #end
						 */
					}

				}

			}
		});
	}

	/**
	 * @return Button innen oder auﬂen
	 */
	public boolean isInside() {
		return inside;
	}

	/**
	 * @param setzt innen/auﬂen Status
	 */
	public void setInside(boolean inside) {
		this.inside = inside;
	}

	/**
	 * @return Button aktiviert? (nicht zu verwechseln mit enabled)
	 */
	public boolean isActivated() {
		return bActivated;
	}

	/**
	 * @param Button (de-)aktivieren
	 */
	public void setActivated(boolean bActivated) {
		if (bActivated) {
			this.setIcon(iconActive);
		} else {
			this.setIcon(iconNotActive);
		}
		this.bActivated = bActivated;
	}

}