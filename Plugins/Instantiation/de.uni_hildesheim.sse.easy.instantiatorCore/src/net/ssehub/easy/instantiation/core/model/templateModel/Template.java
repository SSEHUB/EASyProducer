package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.common.AbstractResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.IResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.IVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaField;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL template.
 * 
 * @author Holger Eichelberger
 */
public class Template extends AbstractResolvableModel<VariableDeclaration, Template> 
    implements ITemplateLangElement, IResolvableModel<VariableDeclaration, Template>, 
    IVariableDeclarationReceiver<VariableDeclaration> {

    private Version version;
    private String name;
    private ModelImport<Template> extension;
    private JavaExtension[] javaExtensions;
    private List<VariableDeclaration> declarations;
    private VariableDeclaration[] param;
    private java.util.Map<String, VariableDeclaration> namedParams;
    private List<Def> defs;
    private IndentationConfiguration indentationConfiguration;
    private FormattingConfiguration formattingConfiguration;
    
    /**
     * Constructor for serialization.
     */
    Template() {
        super(null, null, null);
    }
    
    /**
     * Creates a VIL template instance.
     * 
     * @param name the name
     * @param extension the extended template (may be <b>null</b>)
     * @param descriptor information to create the template from
     * @param registry the registry responsible for this template
     * @throws VilException in case of erroneous input
     */
    public Template(String name, ModelImport<Template> extension, TemplateDescriptor descriptor, TypeRegistry registry) 
        throws VilException {
        super(descriptor.getImports(), registry, descriptor.getAdvices());
        if (null == name || name.length() == 0) {
            throw new VilException("no name given", VilException.ID_SEMANTIC);
        }
        this.name = name;
        this.extension = extension;
        this.javaExtensions = descriptor.getJavaExtensions();
        this.param = descriptor.getParameter();
        this.namedParams = VariableDeclaration.mapDefaultedParameters(this.namedParams, this.param);
        this.indentationConfiguration = descriptor.getIndentationConfiguration();
        this.formattingConfiguration = descriptor.getFormattingConfiguration();
        adjustParents();
    }

    /**
     * Adjusts the parents.
     */
    protected void adjustParents() {
        for (int p = 0; p < getParameterCount(); p++) {
            getParameter(p).setParent(this);
        }
        for (int d = 0; d < getVariableDeclarationCount(); d++) {
            getVariableDeclaration(d).setParent(this);
        }
        // typdefs shall be ok 
        // defs shall be ok
    }
    
    /**
     * Get the number of extensions of this template.
     * 
     * @return The number of extensions of this template.
     */
    public int getJavaExtensionCount() {
        return null == javaExtensions ? 0 : javaExtensions.length;
    }
    
    /**
     * Get the extension of this template at the specified index.
     * 
     * @param index The 0-based index of the extension to be returned.
     * @return The extension at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getJavaExtensionCount()}</code>
     */
    public JavaExtension getJavaExtension(int index) {
        if (null == javaExtensions) {
            throw new IndexOutOfBoundsException();
        }
        return javaExtensions[index];
    }

    @Override
    public boolean isImplicit(VariableDeclaration decl) {
        return false; // VTL does not have implicit variables for now
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getQualifiedName() {
        return name;
    }

    @Override
    public void addVariableDeclaration(VariableDeclaration var) {
        if (null == declarations) {
            declarations = new ArrayList<VariableDeclaration>();
        }
        declarations.add(var);
        var.setParent(this);
    }
    
    /**
     * Get the number of variable declaration of this template.
     * 
     * @return The number of variable declaration of this template.
     */
    public int getVariableDeclarationCount() {
        return null == declarations ? 0 : declarations.size();
    }
    
    /**
     * Get the variable declaration of this template at the specified index.
     * 
     * @param index The 0-based index of the variable declaration to be returned.
     * @return The variable declaration at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getVariableDeclarationCount()}</code>
     */
    public VariableDeclaration getVariableDeclaration(int index) {
        if (null == declarations) {
            throw new IndexOutOfBoundsException();
        }
        return declarations.get(index);
    }
    
    /**
     * Get the number of sub-templates of this template.
     * 
     * @return The number of sub-templates of this template.
     */
    public int getDefCount() {
        return null == defs ? 0 : defs.size();
    }
    
    /**
     * Adds a sub-template.
     * 
     * @param def the sub-template to be added
     */
    public void addDef(Def def) {
        if (null == defs) {
            defs = new ArrayList<Def>();
        }
        defs.add(def);
        def.setParent(this);
    }
    
    /**
     * Adds a sub-template. (not nice)
     * 
     * @param def the sub-template to be removed
     */
    public void removeDef(Def def) {
        if (null != defs) {
            defs.remove(def);
        }
    }
    
    /**
     * Get the sub-templates of this template at the specified index.
     * 
     * @param index The 0-based index of the defs to be returned.
     * @return The defs at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getDefCount()}</code>
     */
    public Def getDef(int index) {
        if (null == defs) {
            throw new IndexOutOfBoundsException();
        }
        return defs.get(index);
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
        return VariableDeclaration.getRequiredParameterCount(namedParams, param);
    }

    @Override
    public VariableDeclaration getParameter(String name) {
        return VariableDeclaration.getParameter(namedParams, name, param);
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitTemplate(this);
    }

    @Override
    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public Version getVersion() {
        return version;
    }

    @Override
    public ModelImport<Template> getSuper() {
        return extension;
    }

    @Override
    public int getOperationsCount() {
        return getDefCount();
    }

    @Override
    public IMetaOperation getOperation(int index) {
        return getDef(index);
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return false; // not a visible type, i.e., not assignable at all
    }

    @Override
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        return null; // no conversions defined on a template
    }

    @Override
    public Template getParent() {
        Template result;
        if (null == extension) {
            result = null;
        } else {
            result = extension.getResolved();
        }
        return result;
    }

    @Override
    public int getExtensionTypesCount() {
        return getJavaExtensionCount();
    }

    @Override
    public IMetaType getExtensionType(int index) {
        return getJavaExtension(index).getResolved();
    }

    @Override
    public IndentationConfiguration getIndentationConfiguration() {
        return indentationConfiguration;
    }
    
    /**
     * Returns the formatting configuration of this script.
     * 
     * @return the formatting configuration (may be <b>null</b> of there is none)
     */
    public FormattingConfiguration getFormattingConfiguration() {
        return formattingConfiguration;
    }

    @Override
    public boolean isBasicType() {
        return false;
    }
    
    @Override
    public boolean enableDynamicDispatch() {
        return true;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public IMetaOperation addPlaceholderOperation(String name, int parameterCount, boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false; // shall not be handled by IActualTypeProvider
    }
    
    @Override
    protected void reload() {
        TemplateModel.INSTANCE.reload(this);
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return new RuntimeEnvironment();
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public IMetaField getField(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public IMetaType getSuperType() {
        return null;
    }

    @Override
    public int getGenericParameterCount() {
        return 0;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }
    
    @Override
    public List<IMetaOperation> getCandidates(String name, int unnamedArgsCount) {
        return TypeDescriptor.getCandidates(this, name, unnamedArgsCount);
    }

}