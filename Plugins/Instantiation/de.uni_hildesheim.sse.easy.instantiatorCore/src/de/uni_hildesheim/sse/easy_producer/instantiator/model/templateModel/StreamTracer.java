package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionWriter;
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
     * Creates a new stream tracer.
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
    public void visitDef(Def def, RuntimeEnvironment environment) {
        printIndentation();
        print("-> " + def.getName() + "(");
        for (int i = 0; i < def.getParameterCount(); i++) {
            if (i > 0) {
                print(", ");
            }
            print(def.getParameter(i).getType().getVilName());
        }
        print(")");
        if (def.getParameterCount() > 0) {
            print(" with (");
            for (int i = 0; i < def.getParameterCount(); i++) {
                if (i > 0) {
                    print(", ");
                }
                try {
                    print(StringValueHelper.getStringValue(environment.getValue(def.getParameter(i)), NORMALIZER));
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
    public void visitedDef(Def def, RuntimeEnvironment environment, Object result) {
        decreaseIndentation();
    }

    @Override
    public void visitedSwitch(Object select, int alternative, Object value) {
        printIndentation();
        println("switch(" + StringValueHelper.getStringValue(select, NORMALIZER) + ")");
        increaseIndentation();
        printIndentation();
        println(alternative + " : " + StringValueHelper.getStringValue(value, NORMALIZER));
        decreaseIndentation();
    }

    @Override
    public void visitLoop(VariableDeclaration var) {
        printIndentation();
        println("for " + var.getName() + " {");
        increaseIndentation();
    }

    @Override
    public void visitedLoop(VariableDeclaration var) {
        decreaseIndentation();
        printIndentation();
        println("}");
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
    public void failedAt(ITemplateLangElement element) {
        if (emitFailed) {
            print("failed at: ");
            TemplateLangWriter writer = new TemplateLangWriter(getOut());
            try {
                element.accept(writer);
            } catch (VilException e) {
            }
        }
    }

    @Override
    protected ExpressionWriter getWriter(Writer out) {
        return new TemplateLangWriter(getOut());
    }

    @Override
    public void visitTemplate(Template template) {
        // due to compatibility with existing test traces
    }

    @Override
    public void visitedTemplate(Template template) {
        // due to compatibility with existing test traces
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
