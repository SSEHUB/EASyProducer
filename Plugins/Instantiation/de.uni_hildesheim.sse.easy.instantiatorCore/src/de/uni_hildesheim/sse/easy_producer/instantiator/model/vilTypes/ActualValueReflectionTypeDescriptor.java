package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Allows the use the {@link IActualValueProvider} mechanism for reflective types. However, we need to 
 * create an instance of the reflective type in order to make the interface available. Thus, classes
 * using this descriptor must implement a (not necessarily accessible) no-argument constructor.
 * @author Holger Eichelberger
 *
 * @param <T> the type
 */
public class ActualValueReflectionTypeDescriptor <T> extends ReflectionTypeDescriptor <T> 
    implements IActualValueProvider  {

    private IActualValueProvider template;
    
    /**
     * Creates a new type descriptor.
     * 
     * @param templateCons the template constructor
     * @throws VilException if analyzing the class fails for some reason
     */
    ActualValueReflectionTypeDescriptor(Constructor<T> templateCons) throws VilException {
        super(templateCons.getDeclaringClass());
        try {
            templateCons.setAccessible(true);
            template = (IActualValueProvider) templateCons.newInstance();
        } catch (SecurityException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        } catch (ClassCastException e) {
            // just to be sure, does not lead to the actual value as template remains null
        }
    }

    @Override
    public Object determineActualValue(Object object) {
        Object result = object;
        if (null != template) {
            result = template.determineActualValue(object);
        }
        return result;
    }
}
