package gui.windows;


import gui.views.ScrollPanel;
import gui.views.inside.ControlPanel;
import gui.views.inside.DisplayPanel;
import gui.views.outside.ElevatorPanel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import main.ElevatorSimulator;
import properties.ProgramSettings;
import simulator.model.Elevator;

/**
 * Die Klasse MainWindow hier wird Das Hauptfenster erstellt mit dem dann
 * sp&auml;ter im Programm die Oberfl&auml;che f&uuml;r den Benutzer ersichtlich
 * wird
 * 
 * 
 */
public class MainWindow {

	private static MainWindow instance = null;

	private JFrame frame;
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	
	/*
	 * #if($elevators > 1)
	 */
	private ArrayList<ElevatorPanel> lElevatorPanels = new ArrayList<ElevatorPanel>(ProgramSettings.ELEVATORS);
	private ArrayList<DisplayPanel> lDisplayPanels = new ArrayList<DisplayPanel>(ProgramSettings.ELEVATORS);
	private ArrayList<ControlPanel> lControlPanels = new ArrayList<ControlPanel>(ProgramSettings.ELEVATORS);
	private ArrayList<JScrollPane> lScrollPanes = new ArrayList<JScrollPane>(ProgramSettings.ELEVATORS);
	/*
	 * #else
	 */
	private ElevatorPanel elevatorPanel;
	private DisplayPanel displayPanel;
	private ControlPanel controlPanel;
	private JScrollPane scrollPane;
	/*
	 * #end
	 */

	
	/**
	 * Standardkonstruktor des Hauptfensters
	 */
	public MainWindow() {
		instance = this;
		createWindow();
	}

	
	// getter & setter
	
	/**
	 * 
	 * Statische Methode, liefert die einzige Instanz dieser
	 * 
	 * Klasse zurück
	 */

	public static MainWindow getInstance() {

		if (instance == null) {

			instance = new MainWindow();

		}

		return instance;
	}
	
	public static void setInstance(MainWindow mw) {
		instance = mw;
	}

	
	/**
	 * Getter f&uuml;r das Hauptframe
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	
	/**
	 * @return the lElevatorPanels
	 */
	/*
	 * #if($elevators > 1)
	 */
	public ElevatorPanel getElevatorPanel(int i) {
		return lElevatorPanels.get(i);
	}
	
	/*
	 * #else
	 */
	public ElevatorPanel getElevatorPanel() {
		return elevatorPanel;
	}
	/*
	 * #end
	 */
	
	/**
	 * @return the lStatusPanels
	 */
	/*
	 * #if($elevators > 1)
	 */
	public DisplayPanel getDisplayPanel(int i) {
		return lDisplayPanels.get(i);
	}
	/*
	 * #else
	 */
		
	public DisplayPanel getDisplayPanel() {
		return displayPanel;
	}
	/*
	 * #end
	 */
	
	/*
	 * #if($elevators > 1)
	 */
	public ControlPanel getControlPanel(int i) {
		return lControlPanels.get(i);
	}
	/*
	 * #else
	 */
			
	public ControlPanel getControlPanel() {
		return controlPanel;
	}
	/*
	 * #end
	 */

	/**
	 * @return the lScrollPanes
	 */
	/*
	 * #if($elevators > 1)
	 */
	public JScrollPane getScrollPane(int i) {
		return lScrollPanes.get(i);
	}
	/*
	 * #else
	 */
			
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	/*
	 * #end
	 */
	
			

	/**
	 * Fuer die Gestaltung des GridBagLayouts.
	 */
	private void addComponent(Container cont, GridBagLayout gbl, Component c,
			int x, int y, int width, int height, double weightx, double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		cont.add(c);
	}

	/**
	 * Beschreibt die Elemente des das Hauptfenster.
	 */
	private void createWindow() {

		frame = new JFrame("ElevatorSimulator");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setSize(1025, 960);

		//Container pane = frame.getContentPane();

		// Erstellen der Menueleiste inkl. deren Eintraege
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu mainMenu = new JMenu("Datei");
		JMenuItem beenden = new JMenuItem("Beenden");
		mainMenu.add(beenden);
		JMenu helper = new JMenu("?");

		JMenuItem helpMain = new JMenuItem("Hilfe");
		helpMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InfoWindow("Hilfe zum ElevatorSimulator","../../helpMain.htm").setVisible(true);
			}
		});
		JMenuItem info = new JMenuItem("Info");
		info.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new InfoWindow("Info zum ElevatorSimulator","../../info.htm").setVisible(true);
			}
		});
		helper.add(helpMain);
		helper.add(info);
		menubar.add(mainMenu);
		menubar.add(helper);

		ScrollPanel jpAll = new ScrollPanel();
		jpAll.setAlignmentX(Component.LEFT_ALIGNMENT);
		// in jpAll sind alle Steuerelemente
		GridBagLayout gbl = new GridBagLayout();
		jpAll.setLayout(gbl);

		// Added das Elevator-Panel in der scrollpane

		int vsbPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int hsbPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

		
		// x y w h wx wy
		addComponent(jpAll, gbl, createTopArea(), 0, 0, 1, 1, 0, 1.0);
		addComponent(jpAll, gbl, createBottomArea(), 0, 1, 1, 1, 0, 0);

		JScrollPane scpane = new JScrollPane(jpAll, vsbPolicy, hsbPolicy);
		scpane.getHorizontalScrollBar();
		// scpane.setPreferredSize(new Dimension(300, 400));
		frame.getContentPane().add(scpane);

		beenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int iAnswer = JOptionPane.showConfirmDialog(null,
						"Möchten Sie das Programm beenden?",
						"Programm Beenden", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (iAnswer == JOptionPane.YES_OPTION) {
					System.exit(1);
				}

			}
		});
		frame.setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width - frame
						.getSize().width) / 2, (Toolkit.getDefaultToolkit()
						.getScreenSize().height - frame.getSize().height) / 2);

		frame.setVisible(true);

	}

	
	public ScrollPanel createTopArea() {
		ScrollPanel jpElevatorArea = new ScrollPanel();
		jpElevatorArea.setLayout(new BoxLayout(jpElevatorArea, BoxLayout.LINE_AXIS));
		jpElevatorArea.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// ElevatorPanels erzeugen und im Fahrstuhlbereich einfügen
		/*
		 * #if($elevators > 1)
		 */
		for (int i = 0; i < ProgramSettings.ELEVATORS; i++) {
			jpElevatorArea.add(buildElevatorPanel(i));
		}
		/*
		 * #else
		 */
		jpElevatorArea.add(buildElevatorPanel(0));
		/*
		 * #end
		 */
		
		return jpElevatorArea;
		
	}
	
	
	public Component createBottomArea() {
		
		/*
		 * #if($elevators > 1)
		 */
		JTabbedPane bottomArea = new JTabbedPane();
		bottomArea.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		for (int i = 0; i < ProgramSettings.ELEVATORS; i++) {
			JLabel lbl = new JLabel(String.valueOf("Fahrstuhl " + (i + 1)));
			lbl.setPreferredSize(new Dimension(229, 10));
			
			bottomArea.addTab(Integer.toString(i + 1), buildBottomPanel(i));
			bottomArea.setTabComponentAt(i, lbl);
			bottomArea.setMnemonicAt(i, KeyEvent.VK_2);
		}
		
		ScrollPanel scrollpanel = new ScrollPanel();
		scrollpanel.setLayout(new FlowLayout());
		scrollpanel.setPreferredSize(new Dimension(350, 35 * (ProgramSettings.FLOORS) / 4 + 40));
		bottomArea.add(scrollpanel);
		/*
		 * #else
		 */
		
		JPanel bottomArea = buildBottomPanel(0);
		
		/*
		 * #end
		 */
		
		
		return bottomArea;
	}
	
	
	public JPanel buildBottomPanel(int iElevatorIndex) {
		
		JPanel resultPanel = new JPanel();
		
		resultPanel.setPreferredSize(new Dimension(1000, 320));
		resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		ControlPanel pnlControls = new ControlPanel(iElevatorIndex);
		DisplayPanel pnlDisplays = new DisplayPanel(ElevatorSimulator.getInstance().getController(
		/*
		 * #if($elevators > 1)
		 */
			iElevatorIndex
		/*
		 * #end
		 */
		).getClass().getSimpleName());
		
		/*
		 * #if($elevators > 1)
		 */
		lControlPanels.add(pnlControls);
		lDisplayPanels.add(pnlDisplays);
		/*
		 * #else
		 */
		controlPanel = pnlControls;
		displayPanel = pnlDisplays;
		/*
		 * #end
		 */
		
		// Scrollbalken Einstellungen
		int vsbPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int hsbPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
		JScrollPane pane = new JScrollPane(pnlControls, vsbPolicy, hsbPolicy);
		pane.setPreferredSize(new Dimension(370, 300));
		// in das parentpanel setzen
		JPanel jpAll = new JPanel();
		jpAll.setLayout(new BorderLayout());
		JPanel jpInlay = new JPanel(new BorderLayout());

		jpInlay.add(pnlDisplays, BorderLayout.WEST);
		jpInlay.add(pnlControls, BorderLayout.CENTER);
		
		resultPanel.add(jpInlay, BorderLayout.SOUTH);
		return resultPanel;

	}

	/**
	 * Erstellt ein Panel f&uuml;r die Scrollbar links beim Elevator
	 * 
	 * 
	 */
	public JScrollPane buildElevatorPanel(int iElevatorIndex) {
		/*
		 * Gr&ouml;sse des Elevator-Panels berechnet sich &uuml;ber die Anzahl
		 * der Stockwerke.
		 */
		ElevatorPanel pnlElevator = new ElevatorPanel(iElevatorIndex);

		/*
		 * Scrollbalken Einstellungen
		 */
		int vsbPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int hsbPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane elevatorScrollPane = new JScrollPane(pnlElevator, vsbPolicy, hsbPolicy);
		elevatorScrollPane.setPreferredSize(new Dimension(250, 550));

		// Titel border
		TitledBorder titleElevator = BorderFactory.createTitledBorder(
				loweredbevel, "Fahrstuhl" + (iElevatorIndex + 1));
		elevatorScrollPane.setBorder(titleElevator);

		/*
		 * Scrollbar nach unten setzten
		 */
		elevatorScrollPane.getViewport().setViewPosition(
				new Point(1, ProgramSettings.FLOORS * ProgramSettings.getTotalHeight(ProgramSettings.FLOORS)));
		
		/*
		 * #if($elevators > 1)
		 */
		lElevatorPanels.add(pnlElevator);
		lScrollPanes.add(elevatorScrollPane);
		/*
		 * #else
		 */
		elevatorPanel = pnlElevator;
		scrollPane = elevatorScrollPane;
		/*
		 * #end
		 */
		
		return elevatorScrollPane;
	}



	/**
	 * Animiert die T&uuml;ren beim &ouml;ffnen und schließen und simuliert die
	 * Wartezeit.
	 * 
	 * @param iTargetIndex
	 *            Current Floor des Elevators.
	 * 
	 */
	public void animateDoors(int iControllerIndex, int iTargetIndex) {
		
		ElevatorPanel pnlElevator = getElevatorPanel(
		/*
		 * #if($elevators > 1)
		 */
			iControllerIndex
			/*
			 * #end
			 */
			);
		ControlPanel pnlControls = getControlPanel(
		/*
		 * #if($elevators > 1)
		 */
		iControllerIndex
		/*
		 * #end
		 */
		);

		// Buttons disablen, damit während der Animation kein erneuter
		// Fahrwunsch auf der selben Etage getätigt werden kann
		// und highlights entfernen
		if (pnlElevator.getCallButtons().size() != 0) {
			
		/*
		 * #if($controlling_synchronized == true)
		 */
			
			setFloorButtonsEnabled(iTargetIndex, false);
			highlightFloorButtons(iTargetIndex, false, 0);
			/*
			 * #if($outerview_buttontype == "ArrowButton")
			 */
				highlightFloorButtons(iTargetIndex, false, 1);
			/*
			 * #end
			 */
		
		/*
		 * #else
		 */
		
			pnlElevator.getCallButtons().get(iTargetIndex).setEnabled(false);
			// Highlight entfernen
			/*
			 * #if($outerview_buttontype == "ArrowButton")
			 */
			pnlElevator.getCallButtons().get(iTargetIndex).setHighlight(0, false);
			pnlElevator.getCallButtons().get(iTargetIndex).setHighlight(1, false);
			/*
			 * #else
			 */
			pnlElevator.getCallButtons().get(iTargetIndex).setHighlight(false);
			/*
			 * #end
			 */
			
		/*
		 * #end
		 */

		}

		
		// Highlight im Statuspanel entfernen und Button disablen
		pnlControls.getButtons().get(iTargetIndex)
			.setHighlight(false);
		pnlControls.getButtons().get(iTargetIndex)
			.setEnabled(false);
		

		Elevator elevator = ElevatorSimulator.getInstance().getController(
				/*
				 * #if($elevators > 1)
				 */
					iControllerIndex
				/*
				 * #end
				 */
					).getElevator();

		// Türanimation
		try {
			// Animation für das Öffnen der Türen
			changeImage("../../doorsOpening.gif", iControllerIndex);
			Thread.sleep(780);

			// Ein einzelnes Bild, das die offenen Türen darstellt
			changeImage("../../doorsOpened.gif", iControllerIndex);

			/*
			 * Es wird maximal 3000 Millisekunden gewartet, bevor die Türen sich
			 * wieder schließen, wird während dessen auf den Türen schließen
			 * Button gedrückt, wird sofort abgebrochen.
			 */

			for (int i = 1; i <= 2000; i++) {
				Thread.sleep(1);
				if (elevator.isbCloseDoorsNow()) {
					break;
				}
			}

			/*
			 * Sollen die Türen geöffnet bleiben, wird die while Schleife,
			 * solange durchlaufen, bis der Türen öffnen Button erneut gedrückt
			 * wird, oder der Türen schließen Button betätigt wurde
			 */
			while (elevator.isbKeepDoorsOpen() && !elevator.isbCloseDoorsNow()) {
				Thread.sleep(1);
			}

			changeImage("../../doorsClosing.gif", iControllerIndex);
			Thread.sleep(800);

			changeImage("../../doorsClosed.gif", iControllerIndex);

		} catch (InterruptedException e) {

		}

		pnlControls.getButtons().get(iTargetIndex).setEnabled(true);

		// Buttons wieder enablen
		/*
		 * #if($controlling_synchronized == true)
		 */
			
			setFloorButtonsEnabled(iTargetIndex, true);
			
		/*
		 * #else
		 */
			
			if(pnlElevator.getCallButtons().size() != 0) {
				pnlElevator.getCallButtons()
					.get(iTargetIndex).setEnabled(true);
			}
			
		/*
		 * #end
		 */
			
		if(ProgramSettings.OUTERVIEW_EMERGENCY){
			/*
			 * #if($controlling_synchronized == true)
			 */
			activateEmergencyButtons(iTargetIndex, false);
			/*
			 * #else
			 */
			pnlElevator.getEmergencyButtons().get(
					iTargetIndex).setActivated(false);
			/*
			 * #end
			 */
		}

	}

	/**
	 * Diese Methode wechselt das Bild des Fahrstuhls in dem GUI.
	 * 
	 * @param path
	 */
	private void changeImage(String path, int iControllerIndex) {
		Icon icon = new ImageIcon(getClass().getResource(path));
		getElevatorPanel(
				/*
				 * #if($elevators > 1)
				 */
					iControllerIndex
				/*
				 * #end
				 */
					).getElevatorImage().setIcon(icon);
	}

	/*
	 * #if($controlling_synchronized == true && $elevators > 1)
	 */
	/**
	 * Highlighted alle Buttons auf einer Etage (auf allen Fahrstühlen)
	 * 
	 * @param iFloor
	 *            - Etage, die gehighlighted werden soll
	 * @param bHighlight
	 *            - Highlight hinzufügen/entfernen
	 */
	public void highlightFloorButtons(int iFloor, boolean bHighlight, int iComponent) {
		for (int i = 0; i < ProgramSettings.ELEVATORS; i++) {
			if(lElevatorPanels.get(i).getCallButtons().size() != 0) {
				/*
				 * #if($outerview_buttontype == "ArrowButton")
				 */
				getElevatorPanel(i).getCallButtons().get(iFloor)
					.setHighlight(iComponent, bHighlight);
				/*
				 * #else
				 */
				getElevatorPanel(i).getCallButtons().get(iFloor)
					.setHighlight(bHighlight);
				/*
				 * #end
				 */
			}
		}
	}
	
	/**
	 * aktiviert oder deaktiviert die Rufknöpfe aller Fahrstühle auf einer bestimmten Etage
	 * @param iFloor - Stockwerk
	 * @param bEnabled - aktiviert/deaktiviert
	 */
	public void setFloorButtonsEnabled(int iFloor, boolean bEnabled) {
		for (int i = 0; i < ProgramSettings.ELEVATORS; i++) {
				if(lElevatorPanels.get(i).getCallButtons().size() != 0) {
					getElevatorPanel(i).getCallButtons().get(iFloor)
					.setEnabled(bEnabled);
				}

		}
	}

	/**
	 * Aktiviert bzw. Deaktiviert die Notrufbuttons auf einer Etage
	 * @param iFloor - Etage, deren NotrufButtons deaktiviert werden soll
	 * @param bActive - aktivieren/deaktivieren
	 */
	public void activateEmergencyButtons(int iFloor, boolean bActive) {
		for (int i = 0; i < ProgramSettings.ELEVATORS; i++) {

			if(lElevatorPanels.get(i).getEmergencyButtons().size() != 0) {
				lElevatorPanels.get(i).getEmergencyButtons().get(iFloor).setActivated(bActive);
			}
			
		}
	}
	/*
	 * #end
	 */
	
	public void close() {
		frame.dispose();
		instance = null;
	}

}
