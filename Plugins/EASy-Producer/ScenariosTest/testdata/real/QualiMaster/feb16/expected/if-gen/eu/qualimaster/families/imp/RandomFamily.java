package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IRandomFamily" (GEN).
 */
public class RandomFamily implements IRandomFamily {

    /**
     * Provides a default implementation of the data input for the {@link IRandomFamilyRandomDataInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IRandomFamilyRandomDataInput implements IIRandomFamilyRandomDataInput {

        private int randomInteger;

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        static {
            SerializerRegistry.register("IRandomFamilyRandomDataInput", RandomFamilySerializers.IRandomFamilyRandomDataInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IRandomFamilyProccessedDataOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IRandomFamilyProccessedDataOutput extends eu.qualimaster.base.algorithm.AbstractOutputItem<IIRandomFamilyProccessedDataOutput> implements IIRandomFamilyProccessedDataOutput {

        /**
         * Creates the item.
         */
        public IRandomFamilyProccessedDataOutput() {
            this(true);
        }

        /**
         * Creates a sub-item.
         *
         * @param topLevel whether it is a top-level item
         */
        private IRandomFamilyProccessedDataOutput(boolean topLevel) {
            super(topLevel);
            setParent(this);
        }

        @Override
        protected IRandomFamilyProccessedDataOutput createItem() {
            return new IRandomFamilyProccessedDataOutput(false);
        }
        private int randomInteger;

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        static {
            SerializerRegistry.register("IRandomFamilyProccessedDataOutput", RandomFamilySerializers.IRandomFamilyProccessedDataOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIRandomFamilyRandomDataInput input, IIRandomFamilyProccessedDataOutput result){
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

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
