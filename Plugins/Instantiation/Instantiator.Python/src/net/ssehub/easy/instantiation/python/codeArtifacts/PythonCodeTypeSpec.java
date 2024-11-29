package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeToStringWriter;
import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python type (usage) specification in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeTypeSpec implements IPythonCodeElement, IPythonCodeTypeSpec {
    private String type;
    private IPythonCodeElement enclosing;

    protected PythonCodeTypeSpec(String type, IPythonCodeElement enclosing) {
        this(type, enclosing, PythonCodeImportScope.MODULE);
    }

    protected PythonCodeTypeSpec(String type, IPythonCodeElement enclosing, PythonCodeImportScope scope) {
        this.enclosing = enclosing;
        this.type = type;
        if (scope != PythonCodeImportScope.NONE) {
            getArtifact().validateType(this);
        }
    }

    protected PythonCodeTypeSpec(PythonCodeTypeSpec type, IPythonCodeElement enclosing, PythonCodeImportScope scope) {
        this.enclosing = enclosing;
        this.type = type.type;
        if (scope != PythonCodeImportScope.NONE) {
            getArtifact().validateType(this);
        }
    }

    public static PythonCodeTypeSpec create(String type, IPythonCodeElement enclosing) {
        return create(type, enclosing, PythonCodeImportScope.MODULE);
    }

    public static PythonCodeTypeSpec create(String type, IPythonCodeElement enclosing, PythonCodeImportScope scope) {
        return new PythonCodeTypeSpec(type, enclosing, scope);
    }

    public String getType() {
        return type;
    }

    @Invisible
    @Override
    public IPythonCodeArtifact getArtifact() {
        return enclosing.getArtifact();
    }

    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " " + type;
    }

    @Override
    public String getOutputTypeName() {
        return type;
    }

    public String getOutputType() {
        CodeToStringWriter out = new CodeToStringWriter();
        store(out);
        return out.getString();
    }

    @Override
    public void setOutputTypeName(String typeName) {
        this.type = typeName;
    }

    @Override
    public IPythonCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IPythonCodeElement parent) {
        PythonCodeClass.setParent(parent, p -> this.enclosing = p);
    }

    @Override
    public void store(CodeWriter out) {
        out.print(this.type);
    }
}
