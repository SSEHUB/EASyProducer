package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.matchLoop;

import java.util.Iterator;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule.Side;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;

/**
 * A generic loop over LHS/RHS matches determining which combinations need a build. Upon such
 * collections, an {@link Applicator} is called to perform specific actions.
 * 
 * @author Holger Eichelberger
 */
public class LhsRhsMatchLoop {
    
    /**
     * Loops over the LHS/RHS matches and calls the <code>applicator</code> for each match.
     * 
     * @param rule the rule to loop over
     * @param rhsValues the already determined values for the RHS matching conditions (in case that there are 
     *     multiple, may be <b>null</b> or empty)
     * @param applicator the applicator instance to be called on each match requiring a build
     * @param tracer the tracer instance (needed to reorder the match sequence if required)
     * @throws VilLanguageException in case that determining the expected LHS value or applying 
     *     the <code>applicator</code> fails
     */
    public static void matchLoop(Rule rule, Object[] rhsValues, Applicator applicator, ITracer tracer) 
        throws VilLanguageException {
        if (null != rhsValues) {
            applicator.initialize(rule, rhsValues);
            int lhsCondCount = rule.getRuleConditionCount(Side.LHS);
            // loop: just in case that we will have multiple in future
            for (int c = 0; !applicator.stopConditionLoop() && c < rhsValues.length; c++) { 
                Collection<?> coll = (Collection<?>) rhsValues[c];
                coll = tracer.adjustSequenceForMap(coll);
                Iterator<?> iter = coll.iterator();
                AbstractRuleMatchExpression rhs = rule.getRuleCondition(Side.RHS, c);
                AbstractRuleMatchExpression lhs;
                if (c < lhsCondCount) {
                    lhs = rule.getRuleCondition(Side.LHS, c);
                } else {
                    lhs = null;
                }
                while (iter.hasNext() && !applicator.stopMatchLoop()) {
                    Object rhsValue = iter.next();
                    Object expectedLhsValue;
                    if (null != lhs) {
                        try {
                            expectedLhsValue = lhs.determineExpected(rhs, rhsValue);
                        } catch (ArtifactException e) {
                            throw new VilLanguageException(e);
                        }
                    } else {
                        expectedLhsValue = null;
                    }
                    if (buildNeeded(expectedLhsValue, rhsValue)) {
                        applicator.apply(expectedLhsValue, rhsValue, c);
                    }    
                }
                applicator.matchLoopFinished();
            }
            applicator.conditionLoopFinished();
        }
    }      
        
    /**
     * Returns whether a build is needed to turn <code>rhsValue</code> into <code>lhsValue</code>. Actually, both
     * values are determined as values from visiting {@link AbstractRuleMatchExpression AbstractRuleMatchExpressions} 
     * and, therefore, are objects (internally {@link IArtifact artifacts}).
     * 
     * @param lhsValue the (expected) individual value to be produced by a rule
     * @param rhsValue the individual input determined by a matching precondition
     * @return <code>true</code> if a build is needed because <code>lhsValue</code> does not exist or is outdated,
     *   <code>false</code> if a build is not needed
     */
    private static boolean buildNeeded(Object lhsValue, Object rhsValue) {
        boolean needed = true;
        if (rhsValue instanceof IArtifact) {
            IArtifact rArtifact = (IArtifact) rhsValue;
            if (rArtifact.exists()) {
                if (lhsValue instanceof IArtifact) {
                    IArtifact lArtifact = (IArtifact) lhsValue;
                    if (!lArtifact.exists()) {
                        needed = true; // RHS exists, LHS does not exist -> build RHS->LHS
                    } else {
                        long rLast = PathUtils.normalizeTime(rArtifact.lastModification());
                        long lLast = PathUtils.normalizeTime(lArtifact.lastModification());
                        // both exist, RHS more recent than LHS -> build RHS->LHS
                        needed = rLast > 0 && lLast > 0 && rLast >= lLast; 
                    }
                } else {
                    // LHS cannot be compared and dependency cannot be determined, but allow build if lhs is not present
                    needed = lhsValue == null; 
                }
            } else {
                needed = false; // RHS does not exist
            }
        }
        return needed;
    }

}
