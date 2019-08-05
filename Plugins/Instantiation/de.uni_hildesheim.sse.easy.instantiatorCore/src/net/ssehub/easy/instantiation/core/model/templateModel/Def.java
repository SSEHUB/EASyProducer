package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.Map;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.IResolvableOperation;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ContainerInitializerExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a template language subtemplate ('def').
 * 
 * @author Holger Eichelberger
 */
public class Def extends TemplateBlock implements ITemplateLangElement, IResolvableOperation<VariableDeclaration>, 
    IStringValueProvider {

    private Template parent;
    private String name;
    private VariableDeclaration[] param; // all params in declaration sequence, required ones first
    private Map<String, VariableDeclaration> namedParam;
    private TypeDescriptor<?> specifiedType;
    private boolean isProtected = false;
    
    /**
     * Constructor for serialization.
     */
    Def() {
        super(null);
    }
    
    /**
     * Creates a new sub-template ('def').
     * 
     * @param name the name of the template
     * @param param the parameter of the template (may be <b>null</b>)
     * @param body the body elements (may be <b>null</b>)
     * @param parent the declaring template
     * @param specifiedType the specified type (may be <b>null</b> if none is given)
     */
    public Def(String name, VariableDeclaration[] param, ITemplateElement[] body, 
        TypeDescriptor<?> specifiedType, Template parent) {
        super(body);
        this.parent = parent;
        this.name = name;
        this.param = param;
        this.namedParam = VariableDeclaration.mapDefaultedParameters(this.namedParam, this.param);
        this.specifiedType = specifiedType;
        setParent(this); // propagate parent
    }
    
    /**
     * Returns whether this Def is protected in visibility.
     * 
     * @return <code>true</code> if it is protected, <code>false</code> else
     */
    public boolean isProtected() { // no IModifier for now
        return isProtected;
    }

    /**
     * Changes whether this Def is protected in visibility.
     * 
     * @param isProtected <code>true</code> if it is protected, <code>false</code> else
     */
    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }
        
    /**
     * Returns the name of this template.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * The specified type. For the actual type see {@link #inferType()}.
     * 
     * @return the specified type, may be <b>null</b> if none is given
     */
    public TypeDescriptor<?> getSpecifiedType() {
        return specifiedType;
    }
    
    @Override
    public int getParameterCount() {
        return null == param ? 0 : param.length;
    }
    
    @Override
    public VariableDeclaration getParameter(int index) {
        if (null == param) {
            throw new IndexOutOfBoundsException();
        }
        return param[index];
    }
    
    @Override
    public int getRequiredParameterCount() {
        return VariableDeclaration.getRequiredParameterCount(namedParam, param);
    }

    @Override
    public VariableDeclaration getParameter(String name) {
        return VariableDeclaration.getParameter(namedParam, name, param);
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitDef(this);
    }

    @Override
    public IMetaType getParameterType(int index) {
        return param[index].getType();
    }

    @Override
    public String getJavaSignature() {
        return getSignature(); // shall print out full signature!
    }

    @Override
    public String getSignature() {
        StringBuilder signature = new StringBuilder();
        if (null != getName()) {
            signature.append(getName());
        }
        signature.append("(");
        if (null != param) {
            for (int p = 0; p < param.length; p++) {
                signature.append(param[p].getType().getVilName());
                if (p < param.length - 1) {
                    signature.append(",");
                }
            }
        }
        signature.append(")");
        return signature.toString();
    }

    @Override
    public TypeDescriptor<?> getReturnType() {
        return null != specifiedType ? specifiedType : TypeRegistry.anyType(); // let's see at runtime
    }

    @Override
    public boolean acceptsNamedParameters() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result = super.inferType();
        if (null != specifiedType && !specifiedType.isAssignableFrom(result)) {
            boolean ok = checkEmptyContainerIntializerCompliance(result, specifiedType);
            if (!ok && specifiedType.getBaseType() instanceof TypeDescriptor) {
                ok = checkEmptyContainerIntializerCompliance(result, (TypeDescriptor<?>) specifiedType.getBaseType());
            }
            if (!ok) {
                throw new VilException("resulting type of block " + result.getVilName() 
                    + " does not fit to specified type " + specifiedType.getVilName(), 
                    VilException.ID_SEMANTIC);
            }
        }
        return result;
    }
    
    /**
     * Checks the given inferred <code>result</code> type and the specified result type <code>specifiedType</code> for
     * type compliance against direct return of an empty container initializer.
     *  
     * @param result the inferred result type
     * @param specifiedType the specified result type
     * @return <code>true</code> for compliance, <code>false</code> else
     */
    private boolean checkEmptyContainerIntializerCompliance(TypeDescriptor<?> result, TypeDescriptor<?> specifiedType) {
        boolean ok = false;
        // allow compatibility for empty container initializer expressions
        if (result.isCollection() && specifiedType.isCollection()) {
            ITemplateElement elt = getTypeDefiningElement();
            if (elt instanceof ExpressionStatement) {
                Expression eltEx = ((ExpressionStatement) elt).getExpression();
                if (eltEx instanceof ContainerInitializerExpression) {
                    ok = 0 == ((ContainerInitializerExpression) eltEx).getInitExpressionsCount();
                }
            }
        }
        return ok;
    }
    
    @Override
    public boolean isFirstParameterOperand() {
        return false;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public IMetaType getDeclaringType() {
        return parent;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return getSignature();
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer(name);
        result.append("(");
        if (null != param && param.length > 0) {
            result.append(param[0].toString());
            for (int i = 1; i < param.length; i++) {
                result.append(", ");                
                result.append(param[i].toString());                
            }
        }
        result.append(")");
        
        return result.toString();
    }

    @Override
    protected void setParent(ILanguageElement parent) {
        super.setParent(parent);
        for (int p = 0; p < getParameterCount(); p++) {
            getParameter(p).setParent(this);
        }
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return null; // not implemented, done by visitor
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return null; // not implemented, done by visitor
    }
    
}
