package algorithms;

import eu.qualiMaster.families.inf.IFAdd10;

public class AAdd101 implements IFAdd10{

	@Override
	public void calculate(IIFAdd10Input input, IIFAdd10Output result) {
		double valuePlus10 = input.getQuote() + 10;
		result.setValuePlus10(valuePlus10);
	}

}
