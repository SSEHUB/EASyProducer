package net.ssehub.easy.instantiation.core.model.common;

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IResolutionScope;

/**
 * Establishes a link to a variability model for resolving names in tools.
 * However, variability model identifiers are actually resolved at runtime
 * from the actual configuration instance passed in.
 * 
 * @author Holger Eichelberger
 */
public class Advice {

    private String name;
    private IVersionRestriction restrictions;
    private Project resolved;

    /**
     * Creates an advice annotation.
     * 
     * @param name The name of the project to be imported.
     * @param restrictions the optional version restrictions that apply
     * @param resolved the resolved project, may be <b>null</b> if no resolution is possible
     */
    public Advice(String name, IVersionRestriction restrictions, Project resolved) {
        this.name = name;
        this.restrictions = restrictions;
        this.resolved = resolved;
    }
    
    /**
     * Returns the name of the variability model.
     * 
     * @return the name of the variability model
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the version restrictions.
     * 
     * @return the version restrictions (may be <b>null</b> if absent)
     */
    public IVersionRestriction getVersionRestriction() {
        return restrictions;
    }

    
    /**
     * Returns the resolved project.
     * 
     * @return the resolved project, may be <b>null</b> if no resolution is possible
     */
    public Project getResolved() {
        return resolved;
    }

    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitAdvice(this);
    }
    
    /**
     * Returns whether <code>name</code> can be resolved to an IVML element.
     * 
     * @param name the name to be resolved
     * @return the IVML element (value, containable model element), <b>null</b> else
     */
    public Object getIvmlElement(String name) {
        Object found = null;
        if (null != resolved && null != name) {
            found = getIvmlElement(resolved, name);
        }
        return found;
    }

    /**
     * Returns whether <code>name</code> can be resolved to an IVML element in <code>scope</code>.
     * 
     * @param scope the resolution scope
     * @param name the name to be resolved
     * @return the IVML element (value, containable model element), <b>null</b> else
     */
    public static Object getIvmlElement(IResolutionScope scope, String name) {
        Object found = null;
        try {
            found = ModelQuery.findElementByName(scope, name, null);
        } catch (IvmlException e) {
            // means... not found
        }
        if (null == found) {
            try {
                found = ModelQuery.enumLiteralAsValue(scope, name);
            } catch (IvmlException e) {
                // means... not found
            }
        }
        return found;
    }

    /**
     * Creates an advice by resolving <code>name</code> to a variability model.
     * 
     * @param name the name to be resolved
     * @param modelURI the URI of the model
     * @param restrictions the version restrictions
     * @param warning a string builder to append warnings to
     * @return the created advice instance
     */
    public static Advice create(String name, URI modelURI, IVersionRestriction restrictions, StringBuilder warning) {
        // TODO consider versions
        Project resolved = null;
        ModelInfo<Project> resolvingInfo = null;
        List<ModelInfo<Project>> varModels = VarModel.INSTANCE.availableModels().getModelInfo(name);
        if (null != varModels && varModels.size() > 1) { // disambiguate, leave the first call - legacy
            varModels = VarModel.INSTANCE.availableModels().getVisibleModelInfo(name, modelURI);
        }
        if (null == varModels || 0 == varModels.size()) {
            warning.append("cannot resolve '" + name + "' - IVML identifier may also not be (fully) resolved");
        }  else if (varModels.size() > 1) {
            warning.append("model '" + name + "' cannot be resolved unambigously - IVML identifier may " 
                + "not be (fully) resolved");
        } else {
            resolvingInfo = varModels.get(0);
        }
        if (null != resolvingInfo) {
            resolved = resolvingInfo.getResolved();
            if (null == resolved) {
                try {
                    resolved = VarModel.INSTANCE.load(resolvingInfo);
                } catch (ModelManagementException e) {
                    warning.append(e.getMessage());
                }
            }
        }
        return new Advice(name, restrictions, resolved);
    }

}
