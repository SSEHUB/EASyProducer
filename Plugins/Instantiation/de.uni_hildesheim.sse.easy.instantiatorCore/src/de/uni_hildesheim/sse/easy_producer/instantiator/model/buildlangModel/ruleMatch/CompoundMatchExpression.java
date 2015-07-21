package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CompositeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Denotes the special expression regarding a path match.
 * 
 * @author Aike Sass
 */
public class CompoundMatchExpression extends AbstractPathRuleMatchExpression {

    private CompositeExpression ex;
    private Path resolved;

    /**
     * Creates a path match expression.
     * 
     * @param ex the {@link CompositeExpression}
     */
    public CompoundMatchExpression(CompositeExpression ex) {
        this.ex = ex;
    }
    
    /**
     * Returns the text used for creating the expression.
     * 
     * @return the text
     */
    public CompositeExpression getCompositeExpression() {
        return ex;
    }

    @Override
    public TypeDescriptor<?> getEntryType() {
        return TypeRegistry.DEFAULT.getType(IFileSystemArtifact.class);
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws VilException {
        return visitor.visitCompoundMatchExpression(this);
    }

    /**
     * Sets the resolved value of the match expression, in particular in case of mixed expressions.
     * 
     * @param resolved the resolved path
     */
    void resolve(Path resolved) {
        this.resolved = resolved;
    }
    
    /**
     * Returns the resolved expression.
     * 
     * @return the resolved expression
     */
    public Path getResolved() {
        return resolved;
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws VilException {
        // requires resolve() before - must return a collection
        Collection<?> result;
        Path path = getResolved();
        if (null != path) {
            result = path.selectAll();    
        } else {
            result = null;
        }
        return result;
    }

}