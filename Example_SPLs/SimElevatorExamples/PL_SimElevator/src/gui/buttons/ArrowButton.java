package gui.buttons;

import gui.windows.MainWindow;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import main.ElevatorSimulator;
import properties.ProgramSettings;
import simulator.model.Target;

/**
 * Klasse die die Up&Down Buttons eines JSpinners liefern für Rufknöpfe hoch
 * runter
 * 
 */
public class ArrowButton extends JSpinner {
/*
 * #if($outerview_buttontype == "ArrowButton")
 */
	/**
	 * id
	 */
	private static final long serialVersionUID = 1L; 

	private boolean isIgnored;
	private boolean hightlighted[] = new boolean[2];
	private int id;
	private int iElevatorIndex;
	private static SpinnerNumberModel snm = new SpinnerNumberModel(1, -1, 1, 2);

	/**
	 * Konstruktor mit übergebener ID für stockwerke
	 */
	public ArrowButton(int id, int iElevatorIndex) {
		super(snm);
		this.setId(id);
		this.iElevatorIndex = iElevatorIndex;
		this.isIgnored = false;
		this.remove(this.getEditor());
		this.setBorder(null);
		this.setMaximumSize(new Dimension(20, 25));
		this.setBounds(200, 45, 20, 25);
	
		this.getComponent(0).addMouseListener(new ArrowButtonListener(0));
		this.getComponent(1).addMouseListener(new ArrowButtonListener(1));
	}

	/**
	 * getter der id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter der id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	// TODO jedem elevator mitgeben achtet auf buttonklicks am spinner

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

	public boolean isHighlighted(int iComponent) {
		return hightlighted[iComponent];
	}

	public void setHighlight(int iComponent, boolean bHighlight) {
		if (bHighlight) {
			if (iComponent == 0) {
				this.getComponent(iComponent).setBackground(Color.GREEN);
			} else {
				this.getComponent(iComponent).setBackground(Color.YELLOW);
			}
		} else {
			this.getComponent(iComponent).setBackground(null);
		}
		hightlighted[iComponent] = bHighlight;
	}

	
	public void updatePosition(int panelHeight) {
			this.setBounds(125, panelHeight
					- (id * ProgramSettings.FLOORS_HEIGHT)
					- 60, 20, 30);
	}
	
	
	private class ArrowButtonListener extends MouseAdapter implements MouseListener {
		private int iComp;
		
		public ArrowButtonListener(int iComp) {
			this.iComp = iComp;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ArrowButton self = ArrowButton.this;
			
			if (e.getButton() == MouseEvent.BUTTON1 && self.isEnabled()) {

				// Fahrtwunsch hinzufügen/stornieren und Highlights entsprechend aktualisieren
				if (self.isHighlighted(iComp)) {
					if(ProgramSettings.OUTERVIEW_CANCEL){
					/*
					 * #if($controlling_synchronized == true)
					 */
					ElevatorSimulator.getInstance().getSuperController().deleteTarget(iElevatorIndex, id);
					MainWindow.getInstance().highlightFloorButtons(id, false, iComp);
					MainWindow.getInstance().highlightFloorButtons(id, false, Math.abs(iComp - 1));
					/*
					 * #else
					 */
					ElevatorSimulator.getInstance().getController(iElevatorIndex).addDeletion(id);
					setHighlight(iComp, false);
					setHighlight(Math.abs(iComp - 1), false);
					/*
					 * #end
					 */
					}
				} else {
					Target target = new Target(self.getId(), (Integer) self.getValue());
					/*
					 * #if($controlling_synchronized == true)
					 */
					ElevatorSimulator.getInstance().getSuperController().addTarget(target, iElevatorIndex, false);
					MainWindow.getInstance().highlightFloorButtons(id, true, iComp);
					MainWindow.getInstance().highlightFloorButtons(id, false, Math.abs(iComp - 1));
					/*
					 * #else
					 */
					ElevatorSimulator.getInstance().getController(iElevatorIndex).addFloor(target);
					setHighlight(iComp, true);
					setHighlight(Math.abs(iComp - 1), false);
					/*
					 * #end
					 */
				}

			}
			
			// rechte Maustaste zum Deaktivieren bzw. Ignorieren von Etagen
			if (e.getButton() == MouseEvent.BUTTON3 && self.isEnabled()) {
				DefaultButton untenbutton = MainWindow.getInstance().getControlPanel(iElevatorIndex).getButtons().get(
						self.getId());

				if (!self.isIgnored() || !untenbutton.isIgnored()) {
					self.setIgnored(true);
					self.setEnabled(false);
					ElevatorSimulator.getInstance().getController(iElevatorIndex).getlIgnoreList()
							.set(self.getId(), true);
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
/*
 * #end	
 */
}


