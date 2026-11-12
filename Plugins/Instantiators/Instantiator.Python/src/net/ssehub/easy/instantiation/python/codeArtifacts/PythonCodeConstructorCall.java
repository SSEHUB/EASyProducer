package net.ssehub.easy.instantiation.python.codeArtifacts;

/**
 * Represents a Python constructor call in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeConstructorCall extends PythonCodeFnCall {

    public PythonCodeConstructorCall(IPythonCodeElement parent, String cls) {
        super(parent, cls, PythonCodeImportScope.NONE);
    }

    @Override
    protected String validateFuncName(IPythonCodeElement parent, String name, PythonCodeImportScope scope) {
        if (name.contains(".")) { // else methodName may be qualified but not by class
            PythonCodeTypeSpec type = new PythonCodeTypeSpec(name, parent);
            return type.getOutputType();
        }

        return name;
    }

    @Override
    public PythonCodeConstructorCall addArgument(Object arg) {
        return (PythonCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    public PythonCodeConstructorCall addStringArgument(String val) {
        return (PythonCodeConstructorCall) super.addStringArgument(val);
    }

    @Override
    public PythonCodeConstructorCall addArgument(String arg) {
        return (PythonCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    public PythonCodeConstructorCall addArgument(String methodName, PythonCodeImportScope scope) {
        return (PythonCodeConstructorCall) super.addArgument(methodName, scope);
    }

    @Override
    public PythonCodeConstructorCall addConstructorCall(String cls) {
        return (PythonCodeConstructorCall) super.addConstructorCall(cls);
    }
}
