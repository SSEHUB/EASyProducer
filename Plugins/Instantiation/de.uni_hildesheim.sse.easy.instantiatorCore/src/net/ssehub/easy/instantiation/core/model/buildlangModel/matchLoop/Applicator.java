package net.ssehub.easy.instantiation.core.model.buildlangModel.matchLoop;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Applies the result of the matches determined by the 
 * {@link LhsRhsMatchLoop#matchLoop(Rule, Object[], Applicator, ITracer)} method.
 * 
 * @author Holger Eichelberger
 */
public abstract class Applicator {

    protected Rule rule;
    protected Object[] rhsValues;

    /**
     * Initializes the applicator for the underlying loop. This method has been
     * defined here in order to ensure consistency between applicator and underlying
     * loop.
     * 
     * @param rule the rule to work on
     * @param rhsValues the RHS value
     */
    protected void initialize(Rule rule, Object[] rhsValues) {
        this.rule = rule;
        this.rhsValues = rhsValues;
    }
    
    /**
     * Apply this applicator for one combination which requires building. This may
     * be due to the fact that <code>rhsValue</code>
     * <ul>
     *   <li>is newer than <code>expectedLhsValue</code></li>
     *   <li>exists but <code>expectedLhsValue</code> does not exist</li>
     *   <li>exists but no LHS is specified (<code>expectedLhsValue</code> is <b>null</b>)
     * </ul>
     * 
     * @param expectedLhsValue the expected result after building <code>rhsValue</code> (may be <b>null</b>)
     * @param rhsValue the value determined for the right side as part of a match
     * @param index the 0-based index of the RHS match condition in the specifying rule ({@link #getElementCount()}
     * @throws IndexOutOfBoundsException if <code>index</code> is invalid
     * @throws VilException in case that executing parts of a rule or setting variable values fails
     */
    public abstract void apply(Object expectedLhsValue, Object rhsValue, int index) throws VilException;

    /**
     * Returns the value of the elements handles by this applicator, i.e., the maximum index + 1.
     * 
     * @return the element count
     */
    public int getElementCount() {
        return null == rhsValues ? 0 : rhsValues.length;
    }

    /**
     * Enables a pre-exit of the match loop.
     * 
     * @return <code>true</code> if the match loop shall exit before the next iteration, 
     *   <code>false</code> if the loop shall continue (default)
     */
    protected boolean stopMatchLoop() {
        return false;
    }

    /**
     * Enables a pre-exit of the condition loop.
     * 
     * @return <code>true</code> if the condition loop shall exit before the next iteration, 
     *   <code>false</code> if the loop shall continue (default)
     */
    protected boolean stopConditionLoop() {
        return false;
    }
    
    /**
     * Notifies when the match loop terminated.
     * 
     * @throws VilException in case that executing parts of a rule fails
     */
    protected void matchLoopFinished() throws VilException {
    }

    /**
     * Notifies when the condition loop terminated.
     * 
     * @throws VilException in case that executing parts of a rule fails
     */
    protected void conditionLoopFinished() throws VilException {
    }

}
