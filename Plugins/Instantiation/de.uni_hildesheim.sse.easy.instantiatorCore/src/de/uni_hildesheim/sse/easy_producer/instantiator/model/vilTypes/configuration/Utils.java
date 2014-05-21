package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Some utility methods. Currently it is unsure how much access to pure variable
 * declarations VIL actually needs. Here are some accessor methods for VIL compliant
 * types but, however, the results are actually not cached!
 * 
 * @author Holger Eichelberger
 */
public class Utils {
    
    /**
     * Prevents external creation.
     */
    private Utils() {
    }
    
    /**
     * Returns a matching attribute declaration.
     * 
     * @param configuration the configuration to return the declaration for
     * @param name the name of the attribute to be returned
     * @return the attribute declaration or <b>null</b> if not found
     */
    public static IvmlDeclaration getAttributeDeclaration(Configuration configuration, String name) {
        IvmlDeclaration result = null;
        Project project = configuration.getConfiguration().getProject();
        for (int a = 0; null == result && a < project.getAttributesCount(); a++) {
            AbstractVariable var = project.getAttribute(a);
            if (var.getName().equals(name) || var.getQualifiedName().equals(name)) {
                result = new IvmlDeclaration(var);
            }
        }
        return result;
    }

}
