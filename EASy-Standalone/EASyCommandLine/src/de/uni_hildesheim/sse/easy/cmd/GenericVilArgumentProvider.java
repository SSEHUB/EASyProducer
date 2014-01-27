package de.uni_hildesheim.sse.easy.cmd;

import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.VilArgumentProvider;

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
     *   {@link Executor#addCustomArgument(String, Object))}
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

}
