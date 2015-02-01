package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.io.File;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry.ILanguage;

/**
 * Executes an rtVil adaptation script.
 * 
 * @author Holger Eichelberger
 */
public class RtVilExecution extends BuildlangExecution {

    public static final ILanguage LANGUAGE = new ILanguage() {

        @Override
        public String getName() {
            return "rt-VIL";
        }
        
    };
    
    /**
     * Creates a new execution environment.
     * 
     * @param tracer the tracer
     * @param base the base directory for making files absolute
     * @param parameter the top-level parameter for the script to be executed
     */
    public RtVilExecution(ITracer tracer, File base, Map<String, Object> parameter) {
        super(tracer, base, parameter);
    }

}
