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
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Implements an artifact match expression.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactMatchExpression extends AbstractRuleMatchExpression {

    private Expression expression;
    private transient Object resolved;
    
    /**
     * Creates a new collection match expression.
     * 
     * @param expression an expression which evaluates to a collection
     * @throws VilException in case that the expression does not evaluate to a collection
     */
    public ArtifactMatchExpression(Expression expression) throws VilException {
        if (!ArtifactTypes.artifactType().isAssignableFrom(expression.inferType())) {
            throw new VilException("expression does not evaluate to an artifact", 
                VilException.ID_SEMANTIC);
        }
        this.expression = expression;
    }
    
    /**
     * Returns the artifact expression.
     * 
     * @return the artifact expression
     */
    public Expression getExpression() {
        return expression;
    }
    
    @Override
    public TypeDescriptor<?> getEntryType() {
        return ArtifactTypes.artifactType();
    }

    @Override
    public Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) {
        return resolved;
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws VilException {
        return visitor.visitArtifactMatchExpression(this);
    }

    @Override
    public boolean contributesTo(AbstractRuleMatchExpression expression) {
        return false; // TODO implement
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws VilException {
        // requires resolution by matchResolver before - must return a collection
        Object value = expression.accept(evaluator);
        Collection<?> result;
        if (value instanceof FileArtifact) {
            FileArtifact[] resultArray = new FileArtifact[1];
            resultArray[0] = (FileArtifact) value;
            TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
            param[0] = getEntryType();
            result = new ArraySet<FileArtifact>(resultArray, param);
        } else if (value instanceof IArtifact) {
            IArtifact[] resultArray = new IArtifact[1];
            resultArray[0] = (IArtifact) value;
            TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
            param[0] = getEntryType();
            result = new ArraySet<IArtifact>(resultArray, param);
        } else {
            throw new VilException("artifact match expression value is not of type Artifact", 
                VilException.ID_INTERNAL);
        }
        return result;
    }
    
    /**
     * Resolves the expression.
     * 
     * @param resolved the resolved object
     */
    void resolve(Object resolved) {
        this.resolved = resolved;
    }

}
