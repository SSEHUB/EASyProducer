package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassWrapper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Defines a java extension of the template language.
 * 
 * @author Holger Eichelberger
 */
public class JavaExtension {
    
    private String name;
    private ClassWrapper resolved;
    private boolean isDefault;
    
    /**
     * Creates a java extension instance.
     * 
     * @param name the name of the Java class extending the functionality
     * @param registry the type registry being responsible for this extension
     * @throws VilException in case that the related class denoted by 
     *     <code>name</code> cannot be resolved
     */
    public JavaExtension(String name, TypeRegistry registry) throws VilException {
        this.name = name;
        // try more specific first
        for (int l = ExtensionClassLoaders.getLoaderCount() - 1; null == resolved && l >= 0; l--) {
            try {
                resolved = new ClassWrapper(ExtensionClassLoaders.getLoader(l).loadClass(name), registry);
            } catch (ClassNotFoundException e) {
                // handled later
            }
        }
        if (null == resolved) {
            throw new VilException("extension class " + name + " not found (class loader registered?)", 
                VilException.ID_CANNOT_RESOLVE_JAVA_EXTENSION);
        }
    }

    /**
     * Creates a default Java extension instance.
     * 
     * @param extension the extension class
     * @param registry the type registry being responsible for this extension
     * @throws VilException in case that the related class denoted by 
     *     <code>name</code> cannot be resolved
     */
    public JavaExtension(Class<?> extension, TypeRegistry registry) throws VilException {
        this.name = extension.getName();
        resolved = new ClassWrapper(extension, registry);
        isDefault = true;
    }
    
    /**
     * Returns the resolved type.
     * 
     * @return the resolved type
     */
    public IMetaType getResolved() {
        return resolved;
    }
    
    /**
     * The name of the Java class extending the functionality.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Visits a java extension.
     * 
     * @param visitor the visitor
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitJavaExtension(this);
    }
    
    /**
     * Returns whether this Java extension is a default extension. 
     * 
     * @return <code>true</code> if it is a default extension, <code>false</code> else
     */
    public boolean isDefault() {
        return isDefault;
    }
    
}
