package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FShow implements IFShow {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFShowInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFShowInput implements IFShow.IIFShowInput {

        private double batchDoubleValue;

        @Override
        public double getBatchDoubleValue() {
            return batchDoubleValue;
        }

        @Override
        public void setBatchDoubleValue(double batchDoubleValue) {
            this.batchDoubleValue = batchDoubleValue;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFShowOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFShowOutput implements IFShow.IIFShowOutput {

        private double result;

        @Override
        public double getResult() {
            return result;
        }

        @Override
        public void setResult(double result) {
            this.result = result;
        }
    }

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFShowInput input, IIFShowOutput result) {
    }

}
