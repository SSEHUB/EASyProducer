package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python decorator in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeDecorator implements IPythonCodeElement {
    
    private String name;
    private IPythonCodeElement decorated;
    private List<PythonCodeDecoratorArg> args = new ArrayList<>();

    PythonCodeDecorator(String name, IPythonCodeElement decorated, PythonCodeImportScope scope) {
        this.decorated = decorated;
        this.name = decorated.getArtifact().validateFuncCall(name, scope);
    }

    @Invisible(inherit = true)
    @Override
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName();
    }

    public PythonCodeDecorator addArgument(String value) {
        IPythonCodeElement.add(args, new PythonCodeDecoratorArg(value, this));
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        storeNoLn(out);
        out.println();
    }

    public void storeNoLn(CodeWriter out) {
        out.printwi("@" + name);

        if (args != null && !args.isEmpty()) {
            out.print("(");
            IPythonCodeElement.storeList(args, ", ", out);
            out.print(")");
        }
    }

    @Override
    public IPythonCodeArtifact getArtifact() {
        return decorated.getArtifact();
    }

    @Override
    public IPythonCodeElement getParent() {
        return decorated;
    }

    @Override
    public void setParent(IPythonCodeElement decorated) {
        this.decorated = decorated;
    }

    @Override
    public int getElementCount() {
        return (decorated instanceof PythonCodeParamSpec) ? 0 : 1;
    }
}