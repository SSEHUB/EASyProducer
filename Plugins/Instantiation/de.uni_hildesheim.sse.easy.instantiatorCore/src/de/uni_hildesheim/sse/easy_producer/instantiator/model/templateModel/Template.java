package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.AbstractResolvableModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IResolvableModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVariableDeclarationReceiver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Represents a VIL template.
 * 
 * @author Holger Eichelberger
 */
public class Template extends AbstractResolvableModel<VariableDeclaration, Template> 
    implements ITemplateLangElement, IResolvableModel<VariableDeclaration>, 
    IVariableDeclarationReceiver<VariableDeclaration> {

    private Version version;
    private String name;
    private ModelImport<Template> extension;
    private JavaExtension[] javaExtensions;
    private List<VariableDeclaration> declarations;
    private VariableDeclaration[] param;
    private Advice[] advices;
    private List<Def> defs;
    private IndentationConfiguration indentationConfiguration;
    
    /**
     * Creates a VIL template instance.
     * 
     * @param name the name
     * @param extension the extended template (may be <b>null</b>)
     * @param descriptor information to create the template from
     * @param registry the registry responsible for this template
     * @throws VilLanguageException in case of erroneous input
     */
    public Template(String name, ModelImport<Template> extension, TemplateDescriptor descriptor, TypeRegistry registry) 
        throws VilLanguageException {
        super(descriptor.getImports(), registry);
        if (null == name || name.length() == 0) {
            throw new VilLanguageException("no name given", VilLanguageException.ID_SEMANTIC);
        }
        this.name = name;
        this.extension = extension;
        this.javaExtensions = descriptor.getJavaExtensions();
        this.advices = descriptor.getAdvices();
        this.param = descriptor.getParameter();
        this.indentationConfiguration = descriptor.getIndentationConfiguration();
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
     * Get the number of advices of this template.
     * 
     * @return The number of advices of this template.
     */
    public int getAdviceCount() {
        return null == advices ? 0 : advices.length;
    }
    
    /**
     * Get the advices of this template at the specified index.
     * 
     * @param index The 0-based index of the advices to be returned.
     * @return The advices at the given index.
     * @throws IndexOutOfBoundsException if 
     *     <code>index &lt; 0 || index &gt;={@link #getAdviceCount()}</code>
     */
    public Advice getAdvice(int index) {
        if (null == advices) {
            throw new IndexOutOfBoundsException();
        }
        return advices[index];
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
    
    /**
     * Get the number of parameter of this template.
     * 
     * @return The number of parameter of this template.
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
    public boolean isIvmlElement(String name) {
        boolean result = false;
        // TODO consider parent?
        for (int a = 0; !result && a < getAdviceCount(); a++) {
            result = getAdvice(a).isIvmlElement(name);
        }
        return result;
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

    @Override
    public boolean isBasicType() {
        return false;
    }

}
