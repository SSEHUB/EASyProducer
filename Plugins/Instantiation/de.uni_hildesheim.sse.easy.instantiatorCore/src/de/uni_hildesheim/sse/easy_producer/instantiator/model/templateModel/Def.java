package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IResolvableOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements a template language subtemplate ('def').
 * 
 * @author Holger Eichelberger
 */
public class Def extends TemplateBlock implements ITemplateLangElement, IResolvableOperation<VariableDeclaration> {

    private Template parent;
    private String name;
    private VariableDeclaration[] param;
    private TypeDescriptor<? extends IVilType> specifiedType;
    
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
        TypeDescriptor<? extends IVilType> specifiedType, Template parent) {
        super(body);
        this.parent = parent;
        this.name = name;
        this.param = param;
        this.specifiedType = specifiedType;
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
    public TypeDescriptor<? extends IVilType> getSpecifiedType() {
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
    public Object accept(IVisitor visitor) throws VilLanguageException {
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
                signature.append(param[p].getType().getName());
                if (p < param.length - 1) {
                    signature.append(",");
                }
            }
        }
        signature.append(")");
        return signature.toString();
    }

    @Override
    public TypeDescriptor<? extends IVilType> getReturnType() {
        return TypeRegistry.anyType(); // let's see at runtime
    }

    @Override
    public boolean acceptsNamedParameters() {
        return false;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        TypeDescriptor<? extends IVilType> result = super.inferType();
        if (null != specifiedType && !specifiedType.isAssignableFrom(result)) {
            throw new VilLanguageException("resulting type of def-block " + result.getVilName() 
                + " does not fit to specified type " + specifiedType.getVilName(), 
                VilLanguageException.ID_SEMANTIC);
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

}
