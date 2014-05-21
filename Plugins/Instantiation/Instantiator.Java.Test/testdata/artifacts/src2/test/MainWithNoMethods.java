@VariationPoint("")
public class Main {
	@VariationPoint("A")
	private int number = 3;
	private int number2 = 3;
	@VariationPoint("A")
	private int number3 = 3;
	private int delete = 1;

	public class Test {
		@VariationPoint("B")
		private int test = 10;
	}
}