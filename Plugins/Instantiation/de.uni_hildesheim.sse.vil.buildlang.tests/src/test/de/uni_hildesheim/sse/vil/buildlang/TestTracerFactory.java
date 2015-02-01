package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.Writer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.IInstantiatorTracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * Defines a factory for tracing VIL and VTL outputs.
 * 
 * @author Holger Eichelberger
 */
class TestTracerFactory extends TracerFactory {

    private static final boolean DEBUG = false;
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer buildTracer;
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer templateTracer;

    /**
     * A specific tracer to record also the template location.
     * 
     * @author Holger Eichelberger
     */
    private static class TemplateTracer extends 
        de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.StreamTracer {

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
        buildTracer = new de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StreamTracer(
            trace, baseFolders);
        if (DEBUG) {
            templateTracer = new TemplateTracer(trace, baseFolders);
        } else {
            templateTracer = new de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.StreamTracer(
                trace, baseFolders);
        }
    }
    
    @Override
    protected de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer 
    createTemplateLanguageTracerImpl() {
        return templateTracer;
    }

    @Override
    protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer 
    createBuildLanguageTracerImpl() {
        return buildTracer;
    }

    @Override
    protected IInstantiatorTracer createInstantiatorTracerImpl() {
        return EMPTY_INSTANTIATOR_TRACER;
    }

}
