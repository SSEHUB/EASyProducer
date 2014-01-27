@VariationPoint("")
public class Main {
	@VariationPoint("A")
	private static final int number = 3;
	private static final int number2 = 3;
	@VariationPoint("A")
	private static final int number3 = 3;
	private static final int delete = 1;

	private int calc() {
		return number + number2 + number3 - delete;
	}

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.calc());
		Test t = new Main().new Test();
		System.out.println(t.calcNumbers(10, 20));
	}

	public class Test {
		@VariationPoint("B")
		private static final int test = 10;

		public int calcNumbers(int a, int b) {
			return a + b + test;
		}
	}
}