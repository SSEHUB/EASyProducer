package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider.StringComparator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * Helps turning an object into a string. Note that this mechanism is different than
 * <code>toString</code> as usual for POJOs.
 * 
 * @author Holger Eichelberger
 */
public class StringValueHelper {

    public static final String NULL_VALUE = "null"; // we do not really have a value for null in VIL
    private static final HashMap<Class<?>, IRegisteredStringValueProvider> REGISTERED_PROVIDERS 
        = new HashMap<Class<?>, IRegisteredStringValueProvider>();
    
    /**
     * Turns the first character into an upper case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String firstToUpperCase(String string) {
        String result = string;
        if (1 == string.length()) {
            result = string.toUpperCase();
        } else if (string.length() > 1) {
            result = Character.toUpperCase(string.charAt(0)) + string.substring(1);
        }
        return result;
    }

    /**
     * Turns the first character into a lower case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String firstToLowerCase(String string) {
        String result = string;
        if (1 == string.length()) {
            result = string.toLowerCase();
        } else if (string.length() > 1) {
            result = Character.toLowerCase(string.charAt(0)) + string.substring(1);
        }
        return result;
    }
    
    /**
     * Returns the string value in case of value or expression replacements. In this situation,
     * further conversions may apply, such as that {@link IvmlElement IvmlElements} are converted
     * into their actual value rather than returning their name.
     * 
     * @param object the object to be turned into a string
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @return the string value
     */
    public static String getStringValueInReplacement(Object object, StringComparator comparator) {
        if (object instanceof IvmlElement) {
            object = ((IvmlElement) object).getValue();
        }
        return getStringValue(object, comparator);
    }

    /**
     * Registers a string value provider.
     * @param objectClass the class to register the provider for
     * @param provider the provider
     */
    public static void registerStringValueProvider(Class<?> objectClass, IRegisteredStringValueProvider provider) {
        if (null != objectClass) {
            REGISTERED_PROVIDERS.put(objectClass, provider);
        }
    }
    
    /**
     * Returns the registered string value provider.
     * @param objectClass the class the provider was registered for
     * @return the registered provider (or <b>null</b> if none was found)
     */
    public static IRegisteredStringValueProvider getStringValueProvider(Class<?> objectClass) {
        return null == objectClass ? null : REGISTERED_PROVIDERS.get(objectClass);
    }
    
    /**
     * Turns the given object into a string using {@link IStringValueProvider}.
     * 
     * @param object the object to be turned into a string
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @return the string value
     */
    public static String getStringValue(Object object, StringComparator comparator) {
        String result;
        // no special case for collection needed as they are instances of IStringValueProvider
        if (object instanceof IStringValueProvider) {
            result = ((IStringValueProvider) object).getStringValue(comparator);
        } else if (object instanceof java.util.Map) {
            result = Map.getStringValue((java.util.Map<?, ?>) object, comparator);
        } else if (object instanceof Iterator) {
            result = PseudoIterator.STRING_VALUE;
        } else if (null == object || TypeRegistry.NULL == object) {
            result = NULL_VALUE; // we no 
        } else {
            IRegisteredStringValueProvider provider = getStringValueProvider(object.getClass());
            if (null != provider) {
                result = provider.getStringValue(object, comparator);
            } else {
                // don't care for Pseudo* as they are just types and no instances
                result = object.toString();
            }
        }
        return result;
    }
    
    /**
     * Turns the given collection into a string.
     * 
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @param collection the collection to be turned into a string
     * @return the string value
     */
    public static String getStringValue(Collection<?> collection, StringComparator comparator) {
        String result;
        if (null == collection) {
            result = NULL_VALUE;
        } else {
            StringBuilder tmp = new StringBuilder("{");
            if (null != comparator) {
                List<String> tmpList = new ArrayList<String>();
                Iterator<?> iter = collection.iterator();
                while (iter.hasNext()) {
                    tmpList.add(getStringValue(iter.next(), comparator));
                }
                Collections.sort(tmpList, comparator);
                for (int i = 0; i < tmpList.size(); i++) {
                    if (i > 0) {
                        tmp.append(", ");
                    } 
                    tmp.append(tmpList.get(i));
                }
            } else {
                Iterator<?> iter = collection.iterator();
                while (iter.hasNext()) {
                    Object o = iter.next();
                    tmp.append(getStringValue(o, comparator));
                    if (iter.hasNext()) {
                        tmp.append(", ");
                    }
                }
            }
            tmp.append("}");
            result = tmp.toString();
        }
        return result;
    }
    
    /**
     * Sorts a given collection according to the string values of the contained elements.
     * 
     * @param <T> the entry type of the collection
     * 
     * @param collection the collection to be sorted
     * @param comparator the comparator to be used for sorting
     * @return a sorted collection of the same type or <code>collection</code> if no <code>comparator</code> 
     *   is given, or <code>collection</code> is <b>null</b>
     */
    public static <T> Collection<T> sortCollection(Collection<T> collection, StringComparator comparator) {
        if (null != collection && null != comparator) {
            SortedMap<String, T> sortedCollectionEntries = new TreeMap<String, T>(comparator);
            for (T t : collection) {
                sortedCollectionEntries.put(getStringValue(t, null), t);
            }
            List<T> sorted = new ArrayList<T>();
            sorted.addAll(sortedCollectionEntries.values());
            TypeDescriptor<?>[] param = TypeDescriptor.createArray(collection.getGenericParameterCount());
            for (int d = 0; d < param.length; d++) {
                param[d] = collection.getGenericParameterType(d);
            }
            if (collection instanceof Set<?>) {
                collection = new ListSet<T>(sorted, param);
            } else if (collection instanceof Sequence<?>) {
                collection = new ListSequence<T>(sorted, param);
            } else {
                EASyLoggerFactory.INSTANCE.getLogger(StringValueHelper.class, Bundle.ID).warn(
                    "unknown collection type " + collection.getClass().getName());
            }
        }
        return collection;
    }

    
}
