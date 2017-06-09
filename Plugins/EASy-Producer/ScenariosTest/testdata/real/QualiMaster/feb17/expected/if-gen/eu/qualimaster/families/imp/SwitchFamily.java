package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "ISwitchFamily" (GEN).
 */
public class SwitchFamily implements ISwitchFamily {

    /**
     * Provides a default implementation of the data input for the {@link ISwitchFamilyRandomDataInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class ISwitchFamilyRandomDataInput implements IISwitchFamilyRandomDataInput {

        private int randomInteger;
        private long timestamp;

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        static {
            SerializerRegistry.register("ISwitchFamilyRandomDataInput", SwitchFamilySerializers.ISwitchFamilyRandomDataInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link ISwitchFamilyRandomDataOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class ISwitchFamilyRandomDataOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IISwitchFamilyRandomDataOutput> implements IISwitchFamilyRandomDataOutput {

        /**
         * Creates the item.
         */
        public ISwitchFamilyRandomDataOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private ISwitchFamilyRandomDataOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        public ISwitchFamilyRandomDataOutput createItem() {
            return new ISwitchFamilyRandomDataOutput(false);
        }
        @Override
        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
        @Override
        public int getTaskId() {
            return taskId;
        }
        private transient int taskId;
        private int randomInteger;
        private long timestamp;

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        @Override
        public long getTimestamp(){
            return timestamp;
        }

        @Override
        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }
        static {
            SerializerRegistry.register("ISwitchFamilyRandomDataOutput", SwitchFamilySerializers.ISwitchFamilyRandomDataOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    public void calculate(IISwitchFamilyRandomDataInput input, IISwitchFamilyRandomDataOutput randomDataResult) {
    }

    /**
     * Sets the algorithm parameter "aggregationFactor".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterAggregationFactor(int value) {
    }

    /**
     * Sets the algorithm parameter "delay".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDelay(int value) {
    }

    /**
     * Sets the algorithm parameter "flag".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFlag(boolean value) {
    }

    /**
     * Sets the algorithm parameter "windowSize".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterWindowSize(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
