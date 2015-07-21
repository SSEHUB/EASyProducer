/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactTypes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CompositeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * A factory to create the match expressions implemented in this package.
 * 
 * @author Holger Eichelberger
 */
public class MatchFactory {

    public static final MatchFactory INSTANCE = new MatchFactory();
    
    private static final TypeDescriptor <?> STRING = TypeRegistry.stringType();
    private static final TypeDescriptor <?> PATH = ArtifactTypes.pathType();
    private static final TypeDescriptor <?> ARTIFACT = ArtifactTypes.artifactType();
    private static final TypeDescriptor <?> BOOLEAN = TypeRegistry.booleanType();
    
    /**
     * Prevents external creation.
     */
    private MatchFactory() {
    }

    /**
     * Creates a rule match expression from <code>expr</code>.
     * 
     * @param expr the expression to be turned into a rule match expression
     * @return the resulting rule match expression (<b>null</b> if no creation is possible)
     * @throws VilException in case of type problems
     */
    public AbstractRuleMatchExpression create(Expression expr) throws VilException {
        // TODO use match expressions as prototypes for the decision here - deferred
        AbstractRuleMatchExpression result = null;
        TypeDescriptor<?> type = expr.inferType();
        if (STRING == type && expr instanceof ConstantExpression) {
            ConstantExpression cExpr = (ConstantExpression) expr;
            result = new StringMatchExpression(cExpr.getValue().toString());
        } else if (PATH.isAssignableFrom(type)) {
            result = new PathMatchExpression(expr);
        } else if (type.isCollection()) {
            result = new CollectionMatchExpression(expr);
        } else if (ARTIFACT.isAssignableFrom(type)) {
            result = new ArtifactMatchExpression(expr);
        } else if (expr instanceof AbstractRuleMatchExpression) {
            result = (AbstractRuleMatchExpression) expr;
        } else if (STRING == type && expr instanceof CompositeExpression) {
            result = new CompoundMatchExpression((CompositeExpression) expr);
        } else if (BOOLEAN == type) {
            // last alternative - just a boolean pre/postcondition
            result = new BooleanMatchExpression(expr);
        }
        return result;
    }

}
