package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FTest implements IFTest {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFTestInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTestInput implements IFTest.IIFTestInput {


    }

    /**
     * Provides a default implementation of the data output for the {@link IFTestOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFTestOutput implements IFTest.IIFTestOutput {


    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFTestInput input, IIFTestOutput result) {
    }

}
