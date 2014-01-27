package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;

/**
 * Implements a simple stream-based execution tracer. Produces normalized sequences of collections
 * in order to facilitate easy comparison.
 * 
 * @author Holger Eichelberger
 */
public abstract class StreamTracer 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StreamTracer implements ITracer {
        
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
    public void valueDefined(VariableDeclaration var, Object value) {
        printIndentation();
        printValueDefined(var, value);
        println();
    }

    /**
     * Is prints a value definition.
     * 
     * @param var the modified variable
     * @param value the actual value
     */
    protected void printValueDefined(VariableDeclaration var, Object value) {
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
        print(var.getName() + " <- " + valueString);
    }
    
    @Override
    public void traceExecutionException(VilLanguageException exception) {
        // not needed in testing, covered from outside
    }

}
