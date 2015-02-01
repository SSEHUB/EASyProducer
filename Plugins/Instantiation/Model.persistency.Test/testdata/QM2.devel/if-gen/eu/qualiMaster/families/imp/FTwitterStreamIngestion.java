package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FTwitterStreamIngestion implements IFTwitterStreamIngestion {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFTwitterStreamIngestionInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamIngestionInput implements IFTwitterStreamIngestion.IIFTwitterStreamIngestionInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFTwitterStreamIngestionOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTwitterStreamIngestionOutput implements IFTwitterStreamIngestion.IIFTwitterStreamIngestionOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFTwitterStreamIngestionInput input, IIFTwitterStreamIngestionOutput result) {
    }

}
