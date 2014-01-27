package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ClassWrapper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaType;

/**
 * Defines a java extension of the template language.
 * 
 * @author Holger Eichelberger
 */
public class JavaExtension {
    
    private String name;
    private ClassWrapper resolved;
    
    /**
     * Creates a java extension instance.
     * 
     * @param name the name of the Java class extending the functionality
     * @throws VilLanguageException in case that the related class denoted by 
     *     <code>name</code> cannot be resolved
     */
    public JavaExtension(String name) throws VilLanguageException {
        this.name = name;
        // try more specific first
        for (int l = ExtensionClassLoaders.getLoaderCount() - 1; null == resolved && l >= 0; l--) {
            try {
                resolved = new ClassWrapper(ExtensionClassLoaders.getLoader(l).loadClass(name));
            } catch (ClassNotFoundException e) {
                // handled later
            }
        }
        if (null == resolved) {
            throw new VilLanguageException("extension class " + name + " not found (class loader registered?)", 
                VilLanguageException.ID_CANNOT_RESOLVE_JAVA_EXTENSION);
        }
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
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitJavaExtension(this);
    }
    
}
