package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VariableDeclaration;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends net.ssehub.easy.instantiation.core.model.common.NoTracer 
    implements ITracer {

    public static final ITracer INSTANCE = new NoTracer();

    /**
     * Prevents external instantiation.
     */
    private NoTracer() {
    }

    @Override
    public void visitDef(Def def, RuntimeEnvironment<?> environment) {
    }

    @Override
    public void visitedDef(Def def, RuntimeEnvironment<?> environment, Object result) {
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

    @Override
    public void visitWhileBody() {
    }

    @Override
    public void visitedWhileBody() {
    }

}
