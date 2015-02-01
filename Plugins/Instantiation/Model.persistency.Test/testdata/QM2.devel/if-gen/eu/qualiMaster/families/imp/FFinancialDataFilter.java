package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FFinancialDataFilter implements IFFinancialDataFilter {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFFinancialDataFilterInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFinancialDataFilterInput implements IFFinancialDataFilter.IIFFinancialDataFilterInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFFinancialDataFilterOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFinancialDataFilterOutput implements IFFinancialDataFilter.IIFFinancialDataFilterOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFFinancialDataFilterInput input, IIFFinancialDataFilterOutput result) {
    }

}
