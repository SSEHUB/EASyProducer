package properties;

public enum Speed {
	SLOW(70), MEDIUM(40), FAST(10);

	private int value;

	private Speed(int speed) {
		this.value = speed;
	}

	public int getValue() {
		return value;
	}

}
