package de.uni_hildesheim.sse.model.varModel;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.confModel.IConfiguration;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.CopyVisitor;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.VersionType;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.utils.modelManagement.IRestrictionEvaluationContext;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * A version expression based on IVML constraints.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionVersionRestriction implements IVersionRestriction {

    private ConstraintSyntaxTree expr;
    private DecisionVariableDeclaration versionVariable;
    private DecisionVariableDeclaration compoundVersionVariable;
    
    /**
     * Creates a new expression version restriction.
     * 
     * @param expr the version restriction expression
     * @param versionVariable the variable representing the actual version of the project to be imported
     * @param compoundVersionVariable the version variable in terms of the (legacy) compound version
     * @throws RestrictionEvaluationException in case of type compliance problems
     */
    public ExpressionVersionRestriction(ConstraintSyntaxTree expr, DecisionVariableDeclaration versionVariable, 
        DecisionVariableDeclaration compoundVersionVariable) 
        throws RestrictionEvaluationException {
        this.expr = expr;
        this.versionVariable = versionVariable;
        this.compoundVersionVariable = compoundVersionVariable;
        try {
            IDatatype type = expr.inferDatatype();
            if (!BooleanType.TYPE.isAssignableFrom(type)) {
                throw new RestrictionEvaluationException("restriction expression must be a constraint, i.e., of "
                    + "type Boolean", CSTSemanticException.TYPE_MISMATCH);
            }
        } catch (CSTSemanticException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId(), e);
        }
    }
    
    /**
     * Creates the restriction variables for IVML models.
     * 
     * @param modelName the name of the model
     * @return the restriction variables (1: the pseudo-compound variable, 0: the plain variable)
     */
    public static DecisionVariableDeclaration[] createRestrictionVars(String modelName) {
        DecisionVariableDeclaration[] result = new DecisionVariableDeclaration[2];
        Compound cmp = new Compound("$" + modelName, null);
        result[0] = new DecisionVariableDeclaration(IvmlKeyWords.VERSION, VersionType.TYPE, cmp);
        cmp.add(result[0]);
        result[1] = new DecisionVariableDeclaration(modelName, cmp, null);
        return result;
    }
    
    /**
     * Creates a typical single restriction from the given variable (see {@link #createRestrictionVars(String)}, the
     * operator and the version.
     * 
     * @param var the variable to use
     * @param operator the operator
     * @param version the version
     * @return the expression
     * @throws ValueDoesNotMatchTypeException in case that <code>version</code> is invalid
     * @throws CSTSemanticException in case of constraint composition problems
     */
    public static ConstraintSyntaxTree createSingleRestriction(DecisionVariableDeclaration var, String operator, 
        Version version) throws ValueDoesNotMatchTypeException, CSTSemanticException {
        ConstraintSyntaxTree result = new Variable(var);
        if (Compound.TYPE.isAssignableFrom(var.getType())) {
            result = new CompoundAccess(result, IvmlKeyWords.VERSION);
        }
        ConstraintSyntaxTree expr = new OCLFeatureCall(result, operator, 
            new ConstantValue(ValueFactory.createValue(VersionType.TYPE, version)));
        expr.inferDatatype();
        return expr;
    }

    @Override
    public void emit(Object context) {
        if (context instanceof IConstraintTreeVisitor) {
            expr.accept((IConstraintTreeVisitor) context);
        }
    }

    @Override
    public String toSpecification() {
        return StringProvider.toIvmlString(expr);
    }
    
    @Override
    public boolean evaluate(IRestrictionEvaluationContext context, Version version) 
        throws RestrictionEvaluationException {
        Boolean result;
        if (context instanceof IConfiguration) {
            Object processor = context.startEvaluation();
            context.setValue(versionVariable, version);
            context.setValue(compoundVersionVariable, version);
            EvaluationVisitor visitor = new EvaluationVisitor((IConfiguration) context, null, false, null);
            expr.accept(visitor);
            Value value = visitor.getResult();
            visitor.clear();
            context.unsetValue(versionVariable);
            context.unsetValue(compoundVersionVariable);
            context.endEvaluation(processor);
            if (null == value) {
                StringBuilder tmp = new StringBuilder();
                for (int m = 0; m < visitor.getMessageCount(); m++) {
                    if (m > 0) {
                        tmp.append(", ");
                    }
                    tmp.append(visitor.getMessage(m).getDescription());
                }
                throw new RestrictionEvaluationException(tmp.toString(), CSTSemanticException.UNRESOLVED);
            } else if (value instanceof BooleanValue) {
                result = ((BooleanValue) value).getValue();
            } else {
                throw new RestrictionEvaluationException("restriction cannot be evaluated to Boolean", 
                    CSTSemanticException.TYPE_MISMATCH);
            }
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public IVersionRestriction copy(IModel model) throws RestrictionEvaluationException {
        DecisionVariableDeclaration[] vars = createRestrictionVars(model.getName());
        Map<AbstractVariable, AbstractVariable> mapping = new HashMap<AbstractVariable, AbstractVariable>();
        mapping.put(versionVariable, vars[0]);
        mapping.put(compoundVersionVariable, vars[1]);
        CopyVisitor visitor = new CopyVisitor(mapping);
        expr.accept(visitor);
        return new ExpressionVersionRestriction(visitor.getResult(), vars[0], vars[1]);
    }

    @Override
    public IVersionRestriction copy(IVariableMapper mapper) throws RestrictionEvaluationException {
        CopyVisitor visitor = new CopyVisitor(mapper);
        expr.accept(visitor);
        return new ExpressionVersionRestriction(visitor.getResult(), 
            map(mapper, versionVariable), 
            map(mapper, compoundVersionVariable));
    }
    
    /**
     * Maps <code>var</code> via <code>mapper</code>.
     * 
     * @param mapper the mapper
     * @param var the variable to be mapped
     * @return the mapped variable, possibly <code>var</code>
     */
    private DecisionVariableDeclaration map(IVariableMapper mapper, DecisionVariableDeclaration var) {
        DecisionVariableDeclaration result = var;
        IVariable tmp = mapper.map(var);
        if (tmp instanceof DecisionVariableDeclaration) {
            result = (DecisionVariableDeclaration) tmp;
        }
        return result;
    }

}
