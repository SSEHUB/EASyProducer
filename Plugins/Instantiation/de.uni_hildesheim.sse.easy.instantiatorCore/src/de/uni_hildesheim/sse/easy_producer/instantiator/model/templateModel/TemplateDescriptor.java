package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Imports;
import de.uni_hildesheim.sse.utils.modelManagement.IndentationConfiguration;

/**
 * Carries the information for creating a template (just a temporary instance).
 * 
 * @author Holger Eichelberger
 */
public class TemplateDescriptor {

    private List<Def> defs;
    private List<JavaExtension> extensions;
    private Imports<Template> imports;
    private VariableDeclaration[] param;
    private Advice[] advices;
    private IndentationConfiguration indentationConfiguration;

    /**
     * Defines the parameter.
     * 
     * @param param the parameter
     * @param resolver the resolver to add the parameters to
     */
    public void setParameter(VariableDeclaration[] param, Resolver resolver) {
        this.param = param;
        if (null != this.param) {
            for (int p = 0; p < param.length; p++) {
                resolver.add(param[p]);
            }
        }
    }

    /**
     * Returns the parameter of the template.
     * 
     * @return the parameter
     */
    VariableDeclaration[] getParameter() {
        return param;
    }

    /**
     * Defines the advices.
     * 
     * @param advices the advices
     */
    public void setAdvices(Advice[] advices) {
        this.advices = advices;
    }
    
    /**
     * Returns the advices.
     * 
     * @return the advices
     */
    Advice[] getAdvices() {
        return advices;
    }
    
    /**
     * Sets the imports.
     * 
     * @param imports the imports
     */
    public void setImports(Imports<Template> imports) {
        this.imports = imports;
    }

    /**
     * Returns the imports.
     * 
     * @return the imports
     */
    Imports<Template> getImports() {
        return imports;
    }
    
    /**
     * Adds an extension.
     * 
     * @param extension the extension to be added
     */
    public void addJavaExtension(JavaExtension extension) {
        if (null == extensions) {
            extensions = new ArrayList<JavaExtension>();
        }
        extensions.add(extension);
    }

    /**
     * Returns the extensions.
     * 
     * @return the extensions (may be <b>null</b>)
     */
    JavaExtension[] getJavaExtensions() {
        JavaExtension[] result;
        if (null != extensions && extensions.size() > 0) {
            result = new JavaExtension[extensions.size()];
            extensions.toArray(result);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Adds a def template.
     * 
     * @param def the template ti be added
     */
    public void addDef(Def def) {
        if (null == defs) {
            defs = new ArrayList<Def>();
        }
        defs.add(def);        
    }

    /**
     * Returns the def templates.
     * 
     * @return the def templates (may be <b>null</b>)
     */
    Def[] getDefs() {
        Def[] result;
        if (null != defs && defs.size() > 0) {
            result = new Def[defs.size()];
            defs.toArray(result); 
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Defines the indentation configuration.
     * 
     * @param config the indentation configuration
     */
    public void setIndentationConfiguration(IndentationConfiguration config) {
        this.indentationConfiguration = config;
    }
    
    /**
     * Returns the indentation configuration.
     * 
     * @return the indentation configuration
     */
    public IndentationConfiguration getIndentationConfiguration() {
        return indentationConfiguration;
    }

}
