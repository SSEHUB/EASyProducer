package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FTwitterStreamFilter implements IFTwitterStreamFilter {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFTwitterStreamFilterInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamFilterInput implements IFTwitterStreamFilter.IIFTwitterStreamFilterInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFTwitterStreamFilterOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamFilterOutput implements IFTwitterStreamFilter.IIFTwitterStreamFilterOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFTwitterStreamFilterInput input, IIFTwitterStreamFilterOutput result) {
    }

}
