package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.Writer;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;

/**
 * Defines a factory for tracing VIL and VTL outputs.
 * 
 * @author Holger Eichelberger
 */
public class TestTracerFactory extends TracerFactory {

    private static final boolean DEBUG = false;
    private net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer buildTracer;
    private net.ssehub.easy.instantiation.core.model.templateModel.ITracer templateTracer;

    /**
     * A specific tracer to record also the template location.
     * 
     * @author Holger Eichelberger
     */
    private static class TemplateTracer extends 
        net.ssehub.easy.instantiation.core.model.templateModel.StreamTracer {

        /**
         * Creates a new template stream tracer.
         * 
         * @param out the output writer
         * @param baseFolder optional base folders used to make matching 
         *   (string) values relative
         */
        public TemplateTracer(Writer out, String... baseFolder) {
            super(out, baseFolder);
        }
        
        @Override
        public void visitTemplate(Template template) {
            ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getModelInfo(template);
            if (null != info) {
                printIndentation();
                println("enter template " + makeRelative(info.getLocation()));
            }
        }

        @Override
        public void visitedTemplate(Template template) {
            ModelInfo<Template> info = TemplateModel.INSTANCE.availableModels().getModelInfo(template);
            if (null != info) {
                printIndentation();
                println("exit template " + makeRelative(info.getLocation()));
            }
        }
        
    }
    
    /**
     * Creates a test tracer factory.
     * 
     * @param trace the writer receiving the trace
     * @param baseFolders the base folders
     */
    public TestTracerFactory(Writer trace, String[] baseFolders) {
        buildTracer = new net.ssehub.easy.instantiation.core.model.buildlangModel.StreamTracer(
            trace, baseFolders) {

            @Override
            public void traceWarning(String text) { // no warnings here
            }

        };
        if (DEBUG) {
            templateTracer = new TemplateTracer(trace, baseFolders);
        } else {
            templateTracer = new net.ssehub.easy.instantiation.core.model.templateModel.StreamTracer(
                trace, baseFolders) {

                @Override
                public void traceWarning(String text) { // no warnings here
                }
                
            };
        }
    }
    
    @Override
    public net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
        createTemplateLanguageTracerImpl() {
        
        return templateTracer;
    }

    @Override
    public net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
        createBuildLanguageTracerImpl() {
        
        return buildTracer;
    }

    @Override
    public IInstantiatorTracer createInstantiatorTracerImpl() {
        return EMPTY_INSTANTIATOR_TRACER;
    }

}
