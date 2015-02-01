package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FResultCombination implements IFResultCombination {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFResultCombinationInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFResultCombinationInput implements IFResultCombination.IIFResultCombinationInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFResultCombinationOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFResultCombinationOutput implements IFResultCombination.IIFResultCombinationOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFResultCombinationInput input, IIFResultCombinationOutput result) {
    }

}
