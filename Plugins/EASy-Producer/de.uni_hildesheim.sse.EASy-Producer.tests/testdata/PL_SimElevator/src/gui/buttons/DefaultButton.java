package gui.buttons;

import gui.windows.MainWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import main.ElevatorSimulator;
import properties.ProgramSettings;
import simulator.controllers.AbstractController;
import simulator.model.Target;

/**
 * ausgelagerte Klasse für spezielle Instanzen von JButton. hier bekommen die
 * Buttons noch eine ID um sie sp&auml;ter mit den Stockwerken verkn&uuml;pfen
 * zu k&ouml;nnen
 * 
 */
public class DefaultButton extends JButton {

	/**
	 * Serialisierung
	 */
	private static final long serialVersionUID = 1L;

	private boolean isIgnored;
	private boolean bHighlighted = false;
	private int id;
	private int iElevatorIndex;
	private boolean bInside;

	/**
	 * Standardkonstruktor
	 */
	public DefaultButton() {

	}
	
	/**
	 * Konstruktor mit Parameter für Innen/Außen Unterscheidung
	 * 
	 * @param id
	 * @param iElevatorIndex 
	 * @param bInside
	 */
	public DefaultButton(int id, int iElevatorIndex, boolean bInside) {
		this.isIgnored = false;
		this.bInside = bInside;
		this.id = id;
		this.iElevatorIndex = iElevatorIndex;
		this.setText(Integer.toString(id));
		this.setFont(new Font("Arial", Font.PLAIN, 10));
		this.setIconTextGap(0);
		this.addActionListener(new DefaultButtonActionListener());
		this.addMouseListener(new DefaultButtonMouseListener());
	}

	/**
	 * Konstruktor ohne Parameter für Innen/Außen Unterscheidung
	 * 
	 * @param id
	 * @param iElevatorIndex 
	 */
	public DefaultButton(int id, int iElevatorIndex) {
		this.isIgnored = false;
		this.bInside = false;
		this.id = id;
		this.iElevatorIndex = iElevatorIndex;
		this.setText(Integer.toString(id));
		this.setFont(new Font("Arial", Font.PLAIN, 10));
		this.setIconTextGap(0);
		this.addActionListener(new DefaultButtonActionListener());
		this.addMouseListener(new DefaultButtonMouseListener());
	}

	/**
	 * Getter f&uuml;r die Button-ID
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param isIgnored the isIgnored to set
	 */
	public void setIgnored(boolean isIgnored) {
		this.isIgnored = isIgnored;
	}

	/**
	 * @return the isIgnored
	 */
	public boolean isIgnored() {
		return isIgnored;
	}

	/**
	 * @return Button highlighted
	 */
	public boolean isHighlighted() {
		return bHighlighted;
	}

	public void setHighlight(boolean aHighlight) {
		if (aHighlight) {
			this.setBackground(Color.GREEN);
		} else {
			this.setBackground(null);
		}

		this.bHighlighted = aHighlight;
	}

	
	private class DefaultButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			AbstractController controller = ElevatorSimulator.getInstance().getController(
					/*
					 * #if($elevators > 1)
					 */
					iElevatorIndex
					/*
					 * #end
					 */
					);
			// wenn Button gehighlighted ist, dann muss Highlight
			// entfernt werden
			if (isHighlighted()) {
				if(ProgramSettings.OUTERVIEW_CANCEL){
				controller.addDeletion(
						id);
				MainWindow.getInstance().getControlPanel(
				/*
				 * #if($elevators > 1)
				 */
					iElevatorIndex
				/*
				 * #end
				 */
						).getButtons().get(id).setHighlight(false);

				/*
				 * #if($controlling_synchronized == true)
				 */
					MainWindow.getInstance().highlightFloorButtons(id, false, 0);
				/*
				 * #else
				 */
					setHighlight(false);
				/*
				 * #end
				 */
				}
				// ansonsten highlighten
			} else {
				Target target = new Target(id, 0);
				
				// wenn Fahrstühle synchronisiert, dann müssen alle
				// Buttons auf der Etage gehighlighted werden
				/*
				 * #if($controlling_synchronized == true)
				 */
					if(bInside)
						setHighlight(true);
					else
						MainWindow.getInstance().highlightFloorButtons(id, true, 0);
				
					if(ProgramSettings.INNERVIEW_EMERGENCY){
						if(bInside && MainWindow.getInstance().getControlPanel(
						/*
						 * #if($elevators > 1)
						 */
						iElevatorIndex
						/*
						 * #end
						 */
						).getEmergencyButton().isActivated()) {
							ElevatorSimulator.getInstance().getSuperController()
							.addPriorityCall(
									iElevatorIndex,
									id,
									bInside);
						} else {
							ElevatorSimulator.getInstance().getSuperController().addTarget(target, controller.getIndex(), bInside);
						}
					}else{
						ElevatorSimulator.getInstance().getSuperController().addTarget(target, controller.getIndex(), bInside);
					}
					
				/*
				 * #else
				 */
					setHighlight(true);
					if(ProgramSettings.INNERVIEW_EMERGENCY){
						if(bInside && MainWindow.getInstance().getControlPanel(
							/*
							 * #if($elevators > 1)
							 */
							iElevatorIndex
							/*
							 * #end
							 */
							).getEmergencyButton().isActivated()) {
							ElevatorSimulator.getInstance().getController(
							/*
							 * #if($elevators > 1)
							 */
							iElevatorIndex
							/*
							 * #end
							 */
							).addPriorityCall(id);
						} else {
							controller.addFloor(target);
						}
					}else{
						controller.addFloor(target);
					}
					
					MainWindow.getInstance().getControlPanel(
					/*
					 * #if($elevators > 1)
					 */
						iElevatorIndex
						/*
						 * #end
						 */
						).getButtons().get(id).setHighlight(true);
				/*
				 * #end
				 */
			}
			controller.startSimulation();
		}
		
	}
	
	private class DefaultButtonMouseListener extends MouseAdapter implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			DefaultButton self = DefaultButton.this;
			if (e.getButton() == MouseEvent.BUTTON3) {
				
				DefaultButton untenbutton = MainWindow.getInstance().getControlPanel(
				/*
				 * #if($elevators > 1)
				 */
					iElevatorIndex
				/*
				 * #end
				 */
					).getButtons().get(self.getId());

				if (!self.isIgnored() || !untenbutton.isIgnored()) {
					self.setIgnored(true);
					self.setEnabled(false);
					ElevatorSimulator.getInstance().getController(
					/*
					 * #if($elevators > 1)
					 */
						iElevatorIndex
					/*
					 * #end
					 */
						).getlIgnoreList().set(self.getId(), true);

					untenbutton.setIgnored(true);
					untenbutton.setEnabled(false);
				} else {
					self.setIgnored(false);
					self.setEnabled(true);
					untenbutton.setIgnored(false);
					untenbutton.setEnabled(true);
				}
			}
		}
	}
	
}
