package net.ssehub.easy.standalone.cmd;

import java.util.Map;

import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;

/**
 * A generic VIL argument provider which just maps all arguments given in terms
 * of name-value pairs to additional VIL arguments.
 * 
 * @author Holger Eichelberger
 */
public class GenericVilArgumentProvider extends VilArgumentProvider {

    private Map<String, Object> arguments;

    /**
     * Creates a generic VIL argument provider.
     * 
     * @param arguments the arguments as name-value mapping (please note that
     *   the values shall comply to VIL conventions, see in particular 
     *   {@link Executor#addCustomArgument(String, Object)}
     */
    public GenericVilArgumentProvider(Map<String, Object> arguments) {
        assert null != arguments;
        this.arguments = arguments;
    }
    
    @Override
    protected void provideArgumentsImpl(PLPInfo plp, Executor executor) {
        if (null != arguments) {
            for (Map.Entry<String, Object> entry : arguments.entrySet()) {
                executor.addCustomArgument(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public boolean acceptsFreeArguments() {
        return false;
    }

    @Override
    public String getFreeArguments() {
        return "";
    }

    @Override
    public String getName() {
        return "Command line argument provider";
    }

    @Override
    public String getParameterName() {
        return "";
    }

    @Override
    public String getParameterType() {
        return "";
    }

    @Override
    public void setFreeArguments(String arg0) {
        // No action needed
    }

}
