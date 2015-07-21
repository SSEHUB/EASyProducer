package eu.qualimaster.families.imp;

import eu.qualimaster.families.inf.*;
import eu.qualimaster.observables.IObservable;

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
    }

    /**
     * Provides a default implementation of the data output for the {@link IRandomFamilyProccessedDataOutput} algorithm.
     * Actual execution system code may also directly wrap the respective tuple concept.
     */
    public static class IRandomFamilyProccessedDataOutput implements IIRandomFamilyProccessedDataOutput {

        private int randomInteger;

        @Override
        public int getRandomInteger(){
            return randomInteger;
        }

        @Override
        public void setRandomInteger(int randomInteger){
            this.randomInteger = randomInteger;
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

    @Override
    public void switchState(State arg0) {
    }

    @Override
    public Double getMeasurement(IObservable arg0) {
	    return null;
    }
}
