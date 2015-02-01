package algorithms;

import eu.qualiMaster.families.inf.IFShow;

public class AShow1 implements IFShow{

	@Override
	public void calculate(IIFShowInput input, IIFShowOutput result) {
		result.setResult(input.getBatchDoubleValue());
	}

}
