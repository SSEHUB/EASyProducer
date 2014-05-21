package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider.StringComparator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;

/**
 * Implements a simple stream-based execution tracer. Produces normalized sequences of collections
 * in order to facilitate easy comparison.
 * 
 * @author Holger Eichelberger
 */
public abstract class StreamTracer extends AbstractWriter implements ITracer {

    /**
     * The normalizer for this tracer.
     */
    protected static final StringComparator NORMALIZER = new StringComparator() {

        @Override
        public int compare(String o1, String o2) {
            int result;
            if (null == o1) {
                if (o2 == null) {
                    result = 0;
                } else {
                    result = 1;
                }
            } else {
                result = o1.compareTo(o2);
            }
            return result;
        }

        @Override
        public boolean inTracer() {
            return true;
        }
        
    };

    private String[] baseFolder;
    
    /**
     * Creates a new stream tracer.
     * 
     * @param out the output writer
     * @param baseFolder optional base folders used to make matching 
     *   (string) values relative
     */
    public StreamTracer(Writer out, String... baseFolder) {
        super(out);
        this.baseFolder = baseFolder;
    }
    
    /**
     * Makes a string value obtained from the {@link StringValueHelper} relative.
     * 
     * @param object the object to be made relative
     * @return the relative string (where applicable)
     */
    protected String makeRelative(Object object) {
        return makeRelative(StringValueHelper.getStringValue(object, NORMALIZER));        
    }
    
    /**
     * Aims at making the given string relative to the base folders
     * stored in this instance.
     * 
     * @param string the string to be made relative (may be <b>null</b>)
     * @return the relative string
     */
    protected String makeRelative(String string) {
        String result = string;
        if (null != baseFolder && null != result) {
            for (int s = 0; s < baseFolder.length; s++) {
                result = result.replace(baseFolder[s] + "/", "").replace(baseFolder[s], "");
            }
        }
        return result;
    }
    
    @Override
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
    }

    @Override
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result) {
        if (CallType.TRANSPARENT != callType) {
            printIndentation();
            print("-> ");
            print(descriptor.getName());
            print("(");
            if (null != args) {
                for (int p = 0; p < descriptor.getParameterCount(); p++) {
                    if (p > 0) {
                        print(", ");
                    }
                    print(descriptor.getParameterType(p).getName());
                }
            }
            print(") with (");
            if (null != args) {
                for (int a = 0; a < args.length; a++) {
                    if (a > 0) {
                        print(", ");
                    }
                    Object tmp = args[a];
                    if (descriptor.acceptsImplicitParameters() && a == args.length - 1 
                        && tmp instanceof Map<?, ?>) {
                        tmp = skipImplicitArguments((Map<?, ?>) tmp);
                    }
                    print(makeRelative(tmp));
                }
            }
            print(") = ");
            println(makeRelative(result));
        }
    }

    /**
     * Skips the implicit named arguments from <code>inMap</code>.
     * 
     * @param inMap the map to be processed
     * @return a copy of <code>inMap</code> without implicit arguments
     */
    private Map<?, ?> skipImplicitArguments(Map<?, ?> inMap) {
        Map<Object, Object> outMap = new HashMap<Object, Object>();
        for (Map.Entry<?, ?> ent : inMap.entrySet()) {
            boolean skip = false;
            if (ent.getKey() instanceof String) {
                if (Constants.IMPLICIT_PARENT_PARAMETER_NAME.equals(ent.getKey()) 
                    || Constants.IMPLICIT_PATHS_PARAMETER_NAME.equals(ent.getKey())) {
                    skip = true;
                }
            } 
            if (!skip) {
                outMap.put(ent.getKey(), ent.getValue());
            }
        }
        return outMap;
    }

    @Override
    public void failedAt(Expression expression) {
        print("failed expression: ");
        ExpressionWriter writer = getWriter(getOut());
        try {
            expression.accept(writer);
        } catch (ExpressionException e) {
        }
    }
    
    /**
     * Returns the writer for emitting expressions.
     * 
     * @param out the output target
     * @return the writer
     */
    protected abstract ExpressionWriter getWriter(Writer out);

}
