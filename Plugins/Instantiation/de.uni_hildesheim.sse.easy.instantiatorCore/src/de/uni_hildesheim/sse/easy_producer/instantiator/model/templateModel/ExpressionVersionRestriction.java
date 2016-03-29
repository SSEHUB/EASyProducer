package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;

/**
 * A version restriction based on VTL expressions.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestriction 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionVersionRestriction {

    /**
     * Creates a new expression version restriction.
     * 
     * @param expr the version restriction expression
     * @param versionVariable the variable representing the actual version of the project to be imported
     * @throws RestrictionEvaluationException in case of type compliance problems
     */
    public ExpressionVersionRestriction(Expression expr, VariableDeclaration versionVariable)
        throws RestrictionEvaluationException {
        super(expr, versionVariable);
    }

    @Override
    public IVersionRestriction copy(IModel model) throws RestrictionEvaluationException {
        try {
            Map<VariableDeclaration, VariableDeclaration> mapping 
                = new HashMap<VariableDeclaration, VariableDeclaration>();
            de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.VariableDeclaration decl 
                = new de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.VariableDeclaration(
                     "version", TypeRegistry.versionType());
            mapping.put(getVersionVariable(), decl);
            ExpressionCopyVisitor visitor = new ExpressionCopyVisitor(mapping, true);
            Expression expr = (Expression) getExpression().accept(visitor);
            return new ExpressionVersionRestriction(expr, decl);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }

    @Override
    public IVersionRestriction copy(IVariableMapper mapper) throws RestrictionEvaluationException {
        try {
            ExpressionCopyVisitor visitor = new ExpressionCopyVisitor(null, true, mapper);
            Expression expr = (Expression) getExpression().accept(visitor);
            VariableDeclaration decl = getVersionVariable();
            IVariable var = mapper.map(decl);
            if (var instanceof VariableDeclaration) {
                decl = (VariableDeclaration) decl;
            }
            return new ExpressionVersionRestriction(expr, decl);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }
    
}
