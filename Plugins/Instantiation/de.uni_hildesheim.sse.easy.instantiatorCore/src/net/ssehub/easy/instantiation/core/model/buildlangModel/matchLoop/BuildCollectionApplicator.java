package net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.buildlangModel.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * An applicator which collects the RHS values which need a build and pushes the related
 * match variable values into the given runtime environment.
 * 
 * @author Holger Eichelberger
 */
public class BuildCollectionApplicator extends Applicator {

    private List<List<Object>> rhsObjects = new ArrayList<List<Object>>();
    private RuntimeEnvironment environment;
    
    /**
     * Creates a build collection applicator for a given runtime <code>environment</code>.
     * 
     * @param environment the environment to 
     */
    public BuildCollectionApplicator(RuntimeEnvironment environment) {
        this.environment = environment;
    }
    
    @Override
    public void apply(Object expectedLhsValue, Object rhsValue, int index) throws VilException {
        if (index < 0 || index >= getElementCount()) {
            throw new IndexOutOfBoundsException();
        }
        while (rhsObjects.size() <= index) {
            rhsObjects.add(null);
        }
        List<Object> coll = rhsObjects.get(index);
        if (null == coll) {
            coll = new ArrayList<Object>();
            rhsObjects.set(index, coll);
        }
        coll.add(rhsValue);
    }

    /**
     * Sets the results of the MATCH-variables in <code>environment</code>.
     * 
     * @throws VilException in case that setting the a value fails (e.g., redefining a constant)
     */
    public void conditionLoopFinished() throws VilException {
        if (null != rhsValues) {
            for (int c = 0; c < rhsValues.length; c++) {
                Collection<?> build = null;
                Object rhsValue = rhsValues[c];
                TypeDescriptor<?> rhsEntryType = rule.getRuleCondition(Side.RHS, c).getEntryType();
                if (rhsValue instanceof Set<?>) {
                    build = new ListSet<Object>(rhsObjects.get(c), rhsEntryType);
                } else if (rhsValue instanceof Sequence<?>) {
                    build = new ListSequence<Object>(rhsObjects.get(c), rhsEntryType);
                }
                environment.addValue(rule.getMatchVariable(Side.RHS, c), build); 
            }
        }
    }
    
}
