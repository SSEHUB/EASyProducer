package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.List;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestrictable;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

/**
 * Establishes a link to a variability model for resolving names in tools.
 * However, variability model identifiers are actually resolved at runtime
 * from the actual configuration instance passed in.
 * 
 * @author Holger Eichelberger
 */
public class Advice implements IVersionRestrictable {

    private String name;
    private VersionRestriction[] restrictions;
    private Project resolved;

    /**
     * Creates an advice annotation.
     * 
     * @param name The name of the project to be imported.
     * @param restrictions the optional version restrictions that apply
     * @param resolved the resolved project, may be <b>null</b> if no resolution is possible
     */
    public Advice(String name, VersionRestriction[] restrictions, Project resolved) {
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
     * Returns the restriction specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the restriction to be returned
     * @return the restriction
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getRestrictionsCount}</code>
     */
    public VersionRestriction getRestriction(int index) {
        if (null == restrictions) {
            throw new IndexOutOfBoundsException();
        }
        return restrictions[index];
    }

    /**
     * Returns the number of restrictions.
     * 
     * @return the number of restrictions
     */
    public int getRestrictionsCount() {
        return null == restrictions ? 0 : restrictions.length;
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
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitAdvice(this);
    }
    
    /**
     * Returns whether <code>name</code> can be resolved to an IVML element.
     * 
     * @param name the name to be resolved
     * @return <code>true</code> if <code>name</code> denotes an IVML element, <code>false</code> else
     */
    public boolean isIvmlElement(String name) {
        boolean found = false;
        if (null != resolved && null != name) {
            try {
                found = null != ModelQuery.findElementByName(resolved, name, null);
            } catch (IvmlException e) {
                // means... not found
            }
            if (!found) {
                try {
                    found = null != ModelQuery.enumLiteralAsValue(resolved, name);
                } catch (IvmlException e) {
                    // means... not found
                }
            }
        }
        return found;
    }

    /**
     * Creates an advice by resolving <code>name</code> to a variability model.
     * 
     * @param name the name to be resolved
     * @param restrictions the version restrictions
     * @param warning a string builder to append warnnings to
     * @return the created advice instance
     */
    public static Advice create(String name, VersionRestriction[] restrictions, StringBuilder warning) {
        // TODO consider versions
        Project resolved = null;
        ModelInfo<Project> resolvingInfo = null;
        List<ModelInfo<Project>> varModels = VarModel.INSTANCE.availableModels().getModelInfo(name);
        if (null == varModels || 0 == varModels.size()) {
            warning.append("cannot resolve '" + name + "' - IVML identifier may also not be (fully) resolved");
        }  else if (varModels.size() > 1) {
            // TODO consider uri to reduce model set
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
