package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "nonlocal" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeNonLocal extends PythonCodeElement {
    
    private List<String> varNames = new ArrayList<>();

    public PythonCodeNonLocal(IPythonCodeElement parent, String name) {
        super(parent);
        varNames.add(name);
    }

    public PythonCodeNonLocal addVar(String name) {
        varNames.add(name);
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        out.printlnwi("nonlocal " + IPythonCodeElement.toList(varNames, ","));
    }
    
}
