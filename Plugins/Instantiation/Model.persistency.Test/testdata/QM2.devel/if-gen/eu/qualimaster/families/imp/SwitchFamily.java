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

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
        }
        static {
            SerializerRegistry.register("ISwitchFamilyRandomDataInput", SwitchFamilySerializers.ISwitchFamilyRandomDataInputSerializer.class);
        }
    }

    /**
     * Provides a default implementation of the data output for the {@link ISwitchFamilyProccessedDataOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class ISwitchFamilyProccessedDataOutput implements IISwitchFamilyProccessedDataOutput {

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
            SerializerRegistry.register("ISwitchFamilyProccessedDataOutput", SwitchFamilySerializers.ISwitchFamilyProccessedDataOutputSerializer.class);
        }
    }

    /**
     * Calculates the actual <code>result</code> for <code>input</code>.
     *
     * @param input the algorithm input taken from the input stream
     * @param result the result calculated by the algorithm
     */
    @Override
    public void calculate(IISwitchFamilyRandomDataInput input, IISwitchFamilyProccessedDataOutput result){
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
