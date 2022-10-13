package net.ssehub.easy.instantiation.core.model.expressions;

import java.io.File;
import java.io.Writer;
import java.net.URI;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import net.ssehub.easy.basics.DefaultLocale;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider.StringComparator;
import net.ssehub.easy.varModel.model.values.NullValue;

/**
 * Implements a simple stream-based execution tracer. Produces normalized sequences of collections
 * in order to facilitate easy comparison. Does not support filtering.
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

    private Locale locale = DefaultLocale.getDefaultLocale();
    private String[] baseFolder;
    private RuntimeEnvironment<?, ?> environment;
    private Stack<String> callStack = new Stack<String>();
    
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

    /**
     * Aims at making the given URI relative to the base folders
     * stored in this instance.
     * 
     * @param uri the URI to be made relative
     * @return the relative string
     */
    protected String makeRelative(URI uri) {
        File file = new File(uri);
        return makeRelative(file.getAbsolutePath());
    }
    
    @Override
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
        if (CallType.TRANSPARENT != callType) {
            String text = "-> ";
            text += descriptor.getName();
            if (descriptor.isConstructor() && null != descriptor.getReturnType()) {
                text += " ";
                text += descriptor.getReturnType().getVilName();
            }
            text += "(";
            if (null != args) {
                for (int p = 0; p < descriptor.getParameterCount(); p++) {
                    if (p > 0) {
                        text += ", ";
                    }
                    text += descriptor.getParameterType(p).getName();
                }
            }
            text += ") with (";
            if (null != args) {
                for (int a = 0; a < args.length; a++) {
                    if (a > 0) {
                        text += ", ";
                    }
                    Object tmp = args[a];
                    if (descriptor.acceptsImplicitParameters() && a == args.length - 1 
                        && tmp instanceof Map<?, ?>) {
                        tmp = skipImplicitArguments((Map<?, ?>) tmp);
                    }
                    text += makeRelative(tmp);
                }
            }
            text += ")";
            callStack.push(text);
        }
    }

    @Override
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result) {
        if (CallType.TRANSPARENT != callType) {
            printIndentation();
            print(callStack.pop());
            
            /*print("-> ");
            print(descriptor.getName());
            if (descriptor.isConstructor() && null != descriptor.getReturnType()) {
                print(" ");
                print(descriptor.getReturnType().getVilName());
            }
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
            print(")");*/
            if (NullValue.VALUE != result) {
                print(" = ");
                print(makeRelative(result));
            }
            println();
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
                if (Constants.IMPLICIT_PARAMETER.contains(ent.getKey())) {
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
        } catch (VilException e) {
        }
    }
    
    /**
     * Returns the writer for emitting expressions.
     * 
     * @param out the output target
     * @return the writer
     */
    protected abstract ExpressionWriter getWriter(Writer out);
    
    @Override
    public Locale getLocale() {
        return locale;
    }
    
    @Override
    public void setLocale(Locale locale) {
        if (null != locale) {
            this.locale = locale;
        }
    }
    
    @Override
    public void setRuntimeEnvironment(RuntimeEnvironment<?, ?> environment) {
        this.environment = environment;
    }

    @Override
    public RuntimeEnvironment<?, ?> getRuntimeEnvironment() {
        return environment;
    }

}
