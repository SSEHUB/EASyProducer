package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;

/**
 * Implements a simple stream-based execution tracer. Produces normalized sequences of collections
 * in order to facilitate easy comparison.
 * 
 * @author Holger Eichelberger
 */
public class StreamTracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.StreamTracer 
    implements ITracer {

    private boolean emitFailed;
    
    /**
     * Creates a new file tracer.
     * 
     * @param out the output writer
     * @param baseFolder optional base folders used to make matching 
     *   (string) values relative
     */
    public StreamTracer(Writer out, String... baseFolder) {
        super(out, baseFolder);
    }

    /**
     * Creates a new stream tracer.
     * 
     * @param out the output writer
     * @param emitFailed whether failure causes shall be emitted
     * @param baseFolder optional base folders used to make matching 
     *   (string) values relative
     */
    public StreamTracer(Writer out, boolean emitFailed, String... baseFolder) {
        super(out, baseFolder);
        this.emitFailed = emitFailed;
    }

    @Override
    public void visitRule(Rule rule, RuntimeEnvironment environment) {
        printIndentation();
        print("-> " + rule.getName() + "(");
        for (int i = 0; i < rule.getParameterCount(); i++) {
            if (i > 0) {
                print(", ");
            }
            print(rule.getParameter(i).getType().getVilName());
        }
        print(")");
        if (rule.getParameterCount() > 0) {
            print(" with (");
            for (int i = 0; i < rule.getParameterCount(); i++) {
                if (i > 0) {
                    print(", ");
                }
                try {
                    String arg = StringValueHelper.getStringValue(
                        environment.getValue(rule.getParameter(i)), NORMALIZER);
                    print(makeRelative(arg));
                } catch (VilException e) {
                    print("<null>");
                }
            }
            print(")");
        }
        println();
        increaseIndentation();
    }

    @Override
    public void visitedRule(Rule rule, RuntimeEnvironment environment, Object result) {
        decreaseIndentation();
    }

    @Override
    public void visitLoop(IEnumeratingLoop loop, RuntimeEnvironment environment) {
        printIndentation();
        print(loop.getElementName());
        println(" {");
        increaseIndentation();
    }

    @Override
    public void visitIteratorAssignment(IEnumeratingLoop loop, VariableDeclaration var, Object value) {
        printIndentation();
        print(loop.getElementName());
        print(": ");
        printValueDefined(var, null, value);
        println();
    }
    
    @Override
    public void visitedLoop(IEnumeratingLoop loop, RuntimeEnvironment environment) {
        decreaseIndentation();
        printIndentation();
        println("}");
    }

    @Override
    public Collection<?> adjustSequenceForMap(Collection<?> collection) {
        return StringValueHelper.sortCollection(collection, NORMALIZER);
    }

    @Override
    public Collection<Object> adjustSequenceForJoin(Collection<Object> collection) {
        return StringValueHelper.sortCollection(collection, NORMALIZER);
    }

    @Override
    public void visitSystemCall(String[] args) {
        printIndentation();
        print("system call(");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                print(", ");
            }
            print(args[i]);
        }
        println(")");
    }

    @Override
    public void visitingInstantiator(String name) {
        // this is intended for logging on user level
    }

    @Override
    public void visitedInstantiator(String name, Object result) {
        // this is intended for logging on user level
    }

    @Override
    public void failedAt(IBuildlangElement element) {
        if (emitFailed) {
            print("failed at: ");
            BuildlangWriter writer = new BuildlangWriter(getOut());
            try {
                element.accept(writer);
            } catch (VilException e) {
            }
            println();
        }
    }

    @Override
    protected ExpressionWriter getWriter(Writer out) {
        return new BuildlangWriter(getOut());
    }

    @Override
    public void visitScript(Script script) {
        // for compatibility with existing tests
    }

    @Override
    public void visitedScript(Script script) {
        // for compatibility with existing tests
    }

    @Override
    public void reset() {
    }

    @Override
    public void visitAlternative(boolean takeIf) {
        printIndentation();
        print("visit ");
        if (takeIf) {
            println("if-branch");
        } else {
            println("else-branch");
        }
    }

    @Override
    public void visitWhileBody() {
        printIndentation();
        println("while body {");
        increaseIndentation();
    }

    @Override
    public void visitedWhileBody() {
        decreaseIndentation();
        printIndentation();
        println("}");
    }

}
