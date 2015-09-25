package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;
import eu.qualimaster.dataManagement.serialization.SerializerRegistry;

/**
 * The implementation for the algorithm family "IAggregateFamily" (GEN).
 */
public class AggregateFamily implements IAggregateFamily {

    /**
     * Provides a default implementation of the data input for the {@link IAggregateFamilyRandomDataInput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IAggregateFamilyRandomDataInput implements IIAggregateFamilyRandomDataInput {

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
            SerializerRegistry.register("IAggregateFamilyRandomDataInput", AggregateFamilySerializers.IAggregateFamilyRandomDataInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link IAggregateFamilyRandomDataOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IAggregateFamilyRandomDataOutput implements IIAggregateFamilyRandomDataOutput {

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
            SerializerRegistry.register("IAggregateFamilyRandomDataOutput", AggregateFamilySerializers.IAggregateFamilyRandomDataOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IIAggregateFamilyRandomDataInput input, IIAggregateFamilyRandomDataOutput result){
    }


    /**
     * Sets the algorithm parameter "factor".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterFactor(int value) {
    }

    /**
     * Sets the algorithm parameter "delay".
     *
     * @param value the new value of the algorithm parameter
     */
    public void setParameterDelay(int value) {
    }

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
