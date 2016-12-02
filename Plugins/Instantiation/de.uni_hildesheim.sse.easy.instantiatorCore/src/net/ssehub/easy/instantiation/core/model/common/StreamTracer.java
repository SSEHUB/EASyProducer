package net.ssehub.easy.instantiation.core.model.common;

import java.io.Writer;

import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;

/**
 * Implements a simple stream-based execution tracer. Produces normalized sequences of collections
 * in order to facilitate easy comparison.
 * 
 * @author Holger Eichelberger
 */
public abstract class StreamTracer 
    extends net.ssehub.easy.instantiation.core.model.expressions.StreamTracer implements ITracer {

    private boolean enabled = true;
    
    /**
     * Creates a new stream tracer.
     * 
     * @param out the output writer
     * @param baseFolder optional base folders used to make matching 
     *   (string) values relative
     */
    public StreamTracer(Writer out, String... baseFolder) {
        super(out, baseFolder);
    }
        
    @Override
    public void trace(String text) {
        printIndentation();
        println(text);
    }

    @Override
    public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
        if (enabled) {
            printIndentation();
            printValueDefined(var, field, value);
            println();
        }
    }

    /**
     * Is prints a value definition.
     * 
     * @param var the modified variable
     * @param field the field in <code>var</code>, may be <b>null</b>
     * @param value the actual value
     */
    protected void printValueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
        if (enabled) {
            boolean tmp = false;
            if (value instanceof Path) {
                tmp = ((Path) value).isTemporary();
            } else if (value instanceof IFileSystemArtifact) {
                tmp = ((IFileSystemArtifact) value).isTemporary();
            }
            String valueString;
            if (tmp) {
                valueString = "<temp>";
            } else {
                valueString = makeRelative(value);
            }
            String name = var.getName();
            if (null != field) {
                name += "." + field.getName();
            }
            print(name + " <- " + valueString);
        }
    }
    
    @Override
    public void traceExecutionException(VilException exception) {
        // not needed in testing, covered from outside
    }

    /**
     * Returns whether this tracer is enabled.
     * 
     * @return <code>true</code> for enabled, <code>false</code> else
     */
    protected boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable(boolean enable) {
        this.enabled = enable;
    }

}
