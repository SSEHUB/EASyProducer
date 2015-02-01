package eu.qualiMaster.families.imp;

import eu.qualiMaster.families.inf.*;

public class FDouble implements IFDouble {

    public static boolean HW = false;
    /**
     * Provides a default implementation of the data input for the {@link IFDoubleInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDoubleInput implements IFDouble.IIFDoubleInput {

        private double valuePlus10;

        @Override
        public double getValuePlus10() {
            return valuePlus10;
        }

        @Override
        public void setValuePlus10(double valuePlus10) {
            this.valuePlus10 = valuePlus10;
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFDoubleOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFDoubleOutput implements IFDouble.IIFDoubleOutput {

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

    public static boolean isHw() {
        return HW;
    }

    @Override
    public void calculate(IIFDoubleInput input, IIFDoubleOutput result) {
    }

}
