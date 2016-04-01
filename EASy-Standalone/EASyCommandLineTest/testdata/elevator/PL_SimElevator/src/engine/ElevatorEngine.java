package engine;

import gui.views.inside.ControlPanel;
import gui.views.inside.DisplayPanel;
import gui.windows.MainWindow;

import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import main.ElevatorSimulator;
import properties.ProgramSettings;
import simulator.controllers.AbstractController;
import simulator.model.Elevator;

/**
 * Klasse mit eigener RunnableInstanz
 * 
 */
public class ElevatorEngine implements Runnable {

	private MainWindow mw;

	private AbstractController myController;
	private Elevator myElevator;
	private JLabel myElevatorImage;
	private ControlPanel myControls;
	private DisplayPanel myDisplays;

	private SpeedController speedController;
	
	/**
	 * Konstruktor der Klasse ElevatorThread
	 * 
	 * @param iControllerIndex
	 */
	public ElevatorEngine(AbstractController controller) {
		mw = MainWindow.getInstance();
		
		/*
		 * #if($elevators > 1)
		 */
		myController = ElevatorSimulator.getInstance().getController(controller.getIndex());
		myElevatorImage = mw.getElevatorPanel(controller.getIndex()).getElevatorImage();
		myControls = mw.getControlPanel(controller.getIndex());
		myDisplays = mw.getDisplayPanel(controller.getIndex());
		/*
		 * #else
		 */
		myController = ElevatorSimulator.getInstance().getController();
		myElevatorImage = mw.getElevatorPanel().getElevatorImage();
		myControls = mw.getControlPanel();
		myDisplays = mw.getDisplayPanel();
		/*
		 * #end
		 */
		
		myElevator = controller.getElevator();
		
		if(ProgramSettings.ACCELERATED){
			speedController = new SpeedController();
		}
	}

	@Override
	/**
	 * Ueberladene run-Methode, welche mittels Schleife die Position des Grafikelements verändert
	 */
	public void run() {
		// synchronized (mw.getlElevatorPanels().get(iControllerIndex)) {
		if(ProgramSettings.INNERVIEW_DOORBUTTON){
		myControls.getCloseButton().setEnabled(false);
		myControls.getOpenButton().setEnabled(false);
		}

		while (myController.getCurrentTarget() != null) {

			if (myController.isUpdateNecessary()) {
				myController.updateTarget();
			}

			if (!myController.getDeletionQueue().contains(
					myController.getCurrentTarget().getFloor())) {
				
				int floorHeight;
				floorHeight = ProgramSettings.FLOORS_HEIGHT;

				
				// Bewegungsanimation des Fahrstuhls
				for (int i = 0; i < floorHeight; i++) {

					// /////////////////////////////////////
					myElevatorImage.setLocation((int) myElevatorImage.getLocation().getX(),
							(int) myElevatorImage.getLocation().getY() - myElevator.getDirection());

					if(ProgramSettings.AUTOSCROLL){
						scrollWithElevator(myElevator);
					}

						
						
						try {
							if(ProgramSettings.ACCELERATED){
								speedController.adaptSpeed(i, myElevator, myControls.getButtons());
							}else{
								Thread.sleep(ProgramSettings.ELEVATORS_SPEED.getValue());
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						

				}
			}

			myElevator.setbCloseDoorsNow(false);
			myElevator.setbKeepDoorsOpen(false);

			myDisplays.updateValues(myElevator, myController.getCurrentTarget());

			boolean targetFound = myController.simulate();
			
			if(ProgramSettings.DISPLAY_DIRECTION){
				myDisplays.changeImageDirection(myElevator.getDirection());
			}

			if (targetFound) {
				if(ProgramSettings.INNERVIEW_DOORBUTTON){
				/*
				 * Tueren oeffnen und schliessen Buttons koennen nur betaetigt
				 * werden, wenn der Fahrstuhl sein Ziel erreicht hat bzw. steht.
				 */
				myControls.getCloseButton().setEnabled(true);
				myControls.getOpenButton().setEnabled(true);
				}

				mw.animateDoors(myController.getIndex(), myElevator.getCurrentFloor());
				myController.doAfterAnimate();

				if(ProgramSettings.INNERVIEW_DOORBUTTON){
				myControls.getCloseButton().setEnabled(false);
				myControls.getOpenButton().setEnabled(false);
				}

			}

		}
		if(ProgramSettings.INNERVIEW_DOORBUTTON){
			myControls.getCloseButton().setEnabled(true);
			myControls.getOpenButton().setEnabled(true);
		}
	}

	
	
	/**
	 * Diese Methode laesst die Scrollbar mit dem Elevator scrollen, wenn er aus
	 * dem Bild laeuft. wenn der Elevator aus dem Viewpoint rausfaehrt, dannsoll
	 * die scrollbar mitscrollen, also der viewpoint sollsich verschieben.
	 * 
	 * wenn die y-koordinate von dem Elevator kleiner ist alsDifferenz aus
	 * Gesamthoehe des Panels und der hoehe des Viewport, dann soll der
	 * viewpoint verschoben werden.
	 * 
	 * @param elevator
	 *            - der Elevator fuer die Location
	 * 
	 */
	public void scrollWithElevator(Elevator elevator) {

		/*
		 * wenn der Elevator aus dem Viewpoint rausfaehrt, dannsoll die
		 * scrollbar mitscrollen, also der viewpoint soll sich verschieben.
		 */
		
		Point pImage = new Point(myElevatorImage.getLocation());
		JScrollPane jscroll = mw.getScrollPane(
				/*
				 * #if($elevators > 1)
				 */
				myController.getIndex()
				/*
				 * #end
				 */
				);
		if (elevator.getDirection() == 1) {
			if (pImage.getY() < (jscroll.getViewport().getViewPosition().getY())) {
				jscroll.getViewport().setViewPosition(
						new Point((int) 1, (int) jscroll.getViewport().getViewPosition().getY()
								- (elevator.getDirection() * jscroll.getHeight())));
			}
		} else if (elevator.getDirection() == -1) {
			if (pImage.getY() > (jscroll.getViewport().getViewPosition().getY() + 500)) {
				jscroll.getViewport().setViewPosition(
						new Point((int) 1, (int) jscroll.getViewport().getViewPosition().getY()
								- (elevator.getDirection() * jscroll.getHeight())));

			}
		}

	}
}