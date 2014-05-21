package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Normalizes a path into an XML document.
 * 
 * @author Holger Eichelberger
 */
public class PathUtils {

    /**
     * The separator between element names.
     */
    public static final String SEPARATOR = "/";
    
    /**
     * Normalizes the given path (removes superfluous {@link #SEPARATOR separators}).
     * 
     * @param path the path to be normalized
     * @return the normalized path
     */
    public static String normalize(String path) {
        path = path.replace(SEPARATOR + SEPARATOR, SEPARATOR);
        if (path.startsWith(SEPARATOR)) {
            path = path.substring(1);
        }
        if (path.endsWith(SEPARATOR)) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }
    
    /**
     * Selects XML elements from <code>container</code> according to a given path. 
     * We may go for XPath expressions in future.
     * 
     * @param container the container to select from
     * @param path the normalized (!) path to the elements (use {@link #normalize(String)} before calling)
     * @return the matching elements (may be empty)
     * @throws ArtifactException in case invalid XmlElements are used.
     */
    static Set<XmlElement> selectByPath(IXmlContainer container, String path) throws ArtifactException {
        Set<XmlElement> result;
        int pos = path.indexOf('/');
        if (pos > 0) {
            String name = path.substring(0, pos);
            String remainder = path.substring(pos + 1);
            Iterator<XmlElement> elts = container.selectByName(name).iterator();
            List<XmlElement> tmp = new ArrayList<XmlElement>();
            while (elts.hasNext()) {
                XmlElement elt = elts.next();
                Iterator<XmlElement> iter = elt.selectByPath(remainder).iterator();
                while (iter.hasNext()) {
                    tmp.add(iter.next());
                }
            }
            result = new ListSet<XmlElement>(tmp, XmlElement.class);
        } else {
            result = container.selectByName(path);
        }
        return result;
    }

}
