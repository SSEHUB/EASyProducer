package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python "import" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeImport implements IPythonCodeImport {

    private String module = "";
    private List<String> names = new ArrayList<>();
    private String alias = "";
    private IPythonCodeArtifact artifact;
    private boolean isWildcard;

    public PythonCodeImport(IPythonCodeArtifact artifact, String module, boolean explicit) {
        this.module = module;
        this.artifact = artifact;
        this.isWildcard = false;
        artifact.registerImport(this, explicit);
    }

    public PythonCodeImport(IPythonCodeArtifact artifact, String module, String name, boolean explicit) {
        this.names.add(name);
        this.module = module;
        this.artifact = artifact;
        this.isWildcard = name.equals("*");
        artifact.registerImport(this, explicit);
    }

    public String getAlias() {
        return this.alias;
    }

    /**
     * Moves this import to the imports at the beginning of the artifact. By default, the import occurs wherever
     * it is added.
     * 
     * @return <b>this</b> for chaining
     */
    public PythonCodeImport toImports() {
        this.artifact.moveToImports(this);
        return this;
    }
    
    /**
     * Moves this import conditionally to the imports at the beginning of the artifact. By default, the import occurs 
     * wherever it is added.
     * 
     * @param apply whether this import shall be moved or not
     * @return <b>this</b> for chaining
     */
    public PythonCodeImport toImports(boolean apply) {
        if (apply) {
            toImports();
        }
        return this;
    }

    public PythonCodeImport setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        if (!names.isEmpty()) {
            out.printlnwi("from " + module + " import " + getName());
        } else if (!alias.isEmpty()) {
            out.printlnwi("import " + module + " as " + alias);
        } else {
            out.printlnwi("import " + module);
        }
    }

    @Override
    public String getName() {
        return IPythonCodeElement.toList(names, ",");
    }

    @Override
    public String getModule() {
        return module;
    }

    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }

    @Override
    public boolean isWildcard() {
        return isWildcard;
    }

    @Override
    public IPythonCodeArtifact getArtifact() {
        return artifact;
    }

    @Override
    public IPythonCodeElement getParent() {
        return null;
    }

    @Override
    public void setParent(IPythonCodeElement parent) {
    }

    @Override
    public boolean match(IPythonCodeImport other) {
        return (module.equals(other.getModule()) || alias.equals(other.getModule()))
            && (hasName(other.getName()) || isWildcard);
    }
    
    private boolean hasName(String name) {
        boolean result;
        if (name.length() == 0) {
            result = names.size() == 0;
        } else {
            result = names.contains(name);
        }
        return result;
    }

    /**
     * Adds a further name to be imported.
     * 
     * @param name the name
     * @return <b>this</b> for chaining
     */
    public PythonCodeImport addName(String name) {
        this.names.add(name);
        return this;
    }
    
}
