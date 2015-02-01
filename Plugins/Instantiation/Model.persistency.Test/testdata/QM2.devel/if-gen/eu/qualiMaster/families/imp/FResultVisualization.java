package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FResultVisualization implements IFResultVisualization {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFResultVisualizationInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFResultVisualizationInput implements IFResultVisualization.IIFResultVisualizationInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFResultVisualizationOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFResultVisualizationOutput implements IFResultVisualization.IIFResultVisualizationOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFResultVisualizationInput input, IIFResultVisualizationOutput result) {
    }

}
