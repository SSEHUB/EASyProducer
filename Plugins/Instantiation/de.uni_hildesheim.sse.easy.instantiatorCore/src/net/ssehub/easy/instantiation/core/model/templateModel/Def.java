package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.IResolvableOperation;
import net.ssehub.easy.instantiation.core.model.common.VilException;
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
    private VariableDeclaration[] param;
    private TypeDescriptor<?> specifiedType;
    private boolean isProtected = false;
    
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
        this.specifiedType = specifiedType;
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
    
    /**
     * Get the number of parameter of this template.
     * 
     * @return The number of sub-templates of this template.
     */
    public int getParameterCount() {
        return null == param ? 0 : param.length;
    }
    
    /**
     * Get the parameter of this template at the specified index.
     * 
     * @param index The 0-based index of the parameter to be returned.
     * @return The parameter at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getParameterCount()}</code>
     */
    public VariableDeclaration getParameter(int index) {
        if (null == param) {
            throw new IndexOutOfBoundsException();
        }
        return param[index];
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
            throw new VilException("resulting type of def-block " + result.getVilName() 
                + " does not fit to specified type " + specifiedType.getVilName(), 
                VilException.ID_SEMANTIC);
        }
        return result;
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
}
