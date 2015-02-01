package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FCorrelation implements IFCorrelation {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFCorrelationInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationInput implements IFCorrelation.IIFCorrelationInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFCorrelationOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFCorrelationOutput implements IFCorrelation.IIFCorrelationOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFCorrelationInput input, IIFCorrelationOutput result) {
    }

}
