package properties;





/**
 * Diese Klasse stellt wichtige Konstanten bereit, die die Programmeinstellungen
 * darstellen.
 */
public class ProgramSettings {
	
	public static final int FLOORS = Integer.valueOf("$floors");
	
	public static final int ELEVATORS = Integer.valueOf("$elevators");
	
	
	/**
	 * Geschwindigkeit der Fahrstühle.
	 */
	public static final Speed ELEVATORS_SPEED = Speed.MEDIUM;

	
	/*
	 * #if($synchronized == true)
	 */
	/**
	 * Anzahl Rufknöpfe pro Stockwerk. 
	 */
	public static final int FLOORS_BUTTONS = 1;
	/*
	 * #end	
	 */
	
	/**
	 * Ob Fahrstühle beschleunigt sein sollen
	 */
	public static final boolean ACCELERATED = Boolean.parseBoolean("$controlling_accelerated");
	
	/**
	 * Ob man Fahrtwunsch von aussen abbrechen kann
	 */
	public static final boolean OUTERVIEW_CANCEL = Boolean.parseBoolean("$outerview_cancellation");
	
	public static final boolean INNERVIEW_DOORBUTTON = Boolean.parseBoolean("$innerview_doorbutton");
	
	public static final boolean INNERVIEW_AUTH = Boolean.parseBoolean("$innerview_authorization");
	
	public static final boolean DISPLAY_DIRECTION = Boolean.parseBoolean("$display_direction");
	public static final boolean DISPLAY_FLOOR_NUMBER = Boolean.parseBoolean("$display_currfloor_number");
	public static final boolean DISPLAY_FLOOR_CHAIN = Boolean.parseBoolean("$display_currfloor_chain");
	public static final boolean DISPLAY_TARGET = Boolean.parseBoolean("$display_target");
	public static final boolean DISPLAY_DOORSIDE = Boolean.parseBoolean("$display_openingside");
	public static final boolean AUTOSCROLL = Boolean.parseBoolean("$outerview_autoscroll");
	public static final boolean OUTERVIEW_EMERGENCY = Boolean.parseBoolean("$outerview_emergencybuttons");
	public static final boolean INNERVIEW_EMERGENCY = Boolean.parseBoolean("$innerview_emergencybutton");
	
	/**
	 * Höhe aller Stockwerke.
	 */
	public static final int FLOORS_HEIGHT = 50;

	
	public static int getTotalHeight(int iFloor) {
		int result = 0;
		
		
		result = iFloor * FLOORS_HEIGHT;
		
		
		return result;
	}

}
