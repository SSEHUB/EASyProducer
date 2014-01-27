package simulator.model;
/**
 * Hier wird ein Target modulliert, das ein gew&auml;hltes
 * Fahrtziel mit verschiedenen Attributen darstellt.
 */
public class Target {
	private int iFloor;
	private int iPriority;
	private int iDirection;
	
	public Target (){
		iFloor = -1;
		iPriority = 1;
		iDirection = 0;
	}
	public Target(int floor, int direction){
		iFloor = floor;
		iDirection = direction;
		iPriority = 1;

	}

	/**
	 * @return the iFloor
	 */
	public int getFloor() {
		return iFloor;
	}

	/**
	 * @param iFloor the iFloor to set
	 */
	public void setFloor(int iFloor) {
		this.iFloor = iFloor;
	}

	/**
	 * @return the fPriority
	 */
	public int getPriority() {
		return iPriority;
	}
	
	/**
	 * Z&auml;hlt die Priorit&auml;t des jeweiligen Targets um die
	 * &uuml;bergebene Distanz hoch.
	 * @param distance
	 */
	public void calculatePriority(int distance){
		this.iPriority += distance;
	}
	/**
	 * @return the iDirection
	 */
	public int getiDirection() {
		return iDirection;
	}
	/**
	 * @param iDirection the iDirection to set
	 */
	public void setiDirection(int iDirection) {
		this.iDirection = iDirection;
	}
	
}
