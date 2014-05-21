package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.NoTracer 
    implements ITracer {

    public static final ITracer INSTANCE = new NoTracer();

    /**
     * Prevents external instantiation.
     */
    private NoTracer() {
    }

    @Override
    public void visitDef(Def def, RuntimeEnvironment environment) {
    }

    @Override
    public void visitedDef(Def def, RuntimeEnvironment environment, Object result) {
    }
    
    @Override
    public void visitedSwitch(Object select, int alternative, Object value) {
    }

    @Override
    public void visitLoop(VariableDeclaration var) {
    }

    @Override
    public void visitedLoop(VariableDeclaration var) {
    }

    @Override
    public void visitAlternative(boolean takeIf) {
    }

    @Override
    public void failedAt(ITemplateLangElement element) {
    }

    @Override
    public void visitTemplate(Template template) {
    }

    @Override
    public void visitedTemplate(Template template) {
    }

}
