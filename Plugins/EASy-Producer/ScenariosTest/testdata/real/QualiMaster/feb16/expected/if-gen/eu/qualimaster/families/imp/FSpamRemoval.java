package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IFSpamRemoval" (GEN).
 */
public class FSpamRemoval implements IFSpamRemoval {

    /**
     * Provides a default implementation of the data input for the {@link IFSpamRemovalTwitterStreamInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSpamRemovalTwitterStreamInput implements IIFSpamRemovalTwitterStreamInput {

        private Object status;
        private double spamPropability;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        @Override
        public double getSpamPropability(){
            return spamPropability;
        }

        @Override
        public void setSpamPropability(double spamPropability){
            this.spamPropability = spamPropability;
        }
        static {
            SerializerRegistry.register("IFSpamRemovalTwitterStreamInput", FSpamRemovalSerializers.IFSpamRemovalTwitterStreamInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IFSpamRemovalTwitterStreamOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IFSpamRemovalTwitterStreamOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIFSpamRemovalTwitterStreamOutput> implements IIFSpamRemovalTwitterStreamOutput {

        /**
         * Creates the item.
         */
        public IFSpamRemovalTwitterStreamOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IFSpamRemovalTwitterStreamOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IFSpamRemovalTwitterStreamOutput createItem() {
            return new IFSpamRemovalTwitterStreamOutput(false);
        }
        private Object status;

        @Override
        public Object getStatus(){
            return status;
        }

        @Override
        public void setStatus(Object status){
            this.status = status;
        }
        static {
            SerializerRegistry.register("IFSpamRemovalTwitterStreamOutput", FSpamRemovalSerializers.IFSpamRemovalTwitterStreamOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIFSpamRemovalTwitterStreamInput input, IIFSpamRemovalTwitterStreamOutput result){
    }


    /**
     * Sets the algorithm parameter "spamThreshold".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterSpamThreshold(double value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
