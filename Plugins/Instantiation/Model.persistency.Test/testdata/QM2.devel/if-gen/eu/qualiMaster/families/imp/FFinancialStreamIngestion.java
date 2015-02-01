package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FFinancialStreamIngestion implements IFFinancialStreamIngestion {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFFinancialStreamIngestionInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFinancialStreamIngestionInput implements IFFinancialStreamIngestion.IIFFinancialStreamIngestionInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFFinancialStreamIngestionOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFFinancialStreamIngestionOutput implements IFFinancialStreamIngestion.IIFFinancialStreamIngestionOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFFinancialStreamIngestionInput input, IIFFinancialStreamIngestionOutput result) {
    }

}
