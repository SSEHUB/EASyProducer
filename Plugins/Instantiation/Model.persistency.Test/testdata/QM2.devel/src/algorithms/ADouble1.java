package algorithms;

import eu.qualiMaster.families.inf.IFDouble;

public class ADouble1 implements IFDouble{

	@Override
	public void calculate(IIFDoubleInput input, IIFDoubleOutput result) {
		result.setBatchDoubleValue(input.getValuePlus10());
	}

}
