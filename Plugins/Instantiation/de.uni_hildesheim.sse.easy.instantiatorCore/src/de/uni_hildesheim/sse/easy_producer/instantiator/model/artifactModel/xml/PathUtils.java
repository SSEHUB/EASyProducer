package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
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
     * @throws VilException in case invalid XmlElements are used.
     */
    static Set<XmlElement> selectByPath(IXmlContainer container, String path) throws VilException {
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

    /**
     * Selects XML elements based on a given XPath expression.
     * 
     * @param path the XPath expression
     * @param root the XML element to start evaluating the XPath expression at
     * @param container the XML container
     * @return the resulting elements
     * @throws VilException in case invalid XmlElements are used or <code>path</code> is invalid.
     */
    public static Set<XmlElement> selectByXPath(String path, Object root, IXmlContainer container) throws VilException {
        Set<XmlElement> result = null;
        try {
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            XPathExpression expr = xpath.compile(path);
            NodeList nodes = (NodeList) expr.evaluate(root, XPathConstants.NODESET);
            List<XmlElement> tmp = new ArrayList<XmlElement>(nodes.getLength());
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String nodePath = "";
                Node par = node;
                while (null != par.getParentNode()) {
                    if (nodePath.length() > 0) {
                        nodePath += "/";
                    }
                    nodePath += node.getNodeName();
                    par = par.getParentNode();
                }
                Set<XmlElement> nodeRes = PathUtils.selectByPath(container, nodePath);
                for (XmlElement elt : nodeRes) {
                    tmp.add(elt);
                }
            }
            result = new ListSet<XmlElement>(tmp, XmlElement.class);
        } catch (XPathExpressionException e) {
            throw new VilException(e.getMessage(), VilException.ID_RUNTIME);
        }
        return result;
    }
    
}
