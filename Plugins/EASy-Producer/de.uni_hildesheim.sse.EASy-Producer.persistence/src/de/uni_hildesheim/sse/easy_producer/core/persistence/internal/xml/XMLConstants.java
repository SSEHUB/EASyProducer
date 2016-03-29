
package de.uni_hildesheim.sse.easy_producer.core.persistence.internal.xml;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.util.FileUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.PersistenceConstants;
import net.ssehub.easy.basics.modelManagement.Version;

/**
 * XML Constants for the XML Connector.
 * 
 * @author El-Sharkawy
 * @since 04.10.11
 */
public class XMLConstants {
    /*
     * XML Characters
     */

    /**
     * <b>XML Character:</b>Linefeed.
     */
    static final String LINEFEED = "\r\n";
    /**
     * <b>XML Character:</b>Tabstop.
     */
    static final String TABSTOP = "\t";
    /**
     * <b>XML Character:</b>Escaped Quotes.
     */
    static final String QUOTES = "&quot;";

    /**
     * <b>XML Character:</b>Escaped opening brackets.
     */
    static final String LESSTHAN = "&lt;";

    /**
     * <b>XML Character:</b>Escaped closing brackets.
     */
    static final String GREATERTHAN = "&gt;";

    /**
     * <b>XML Character:</b>Escaped ampersand.
     */
    static final String AMP = "&amp;";

    /*
     * XML node paths
     */

    /**
     * <b>XML Node Path:</b> For the root node.
     */
    static final String PATH_4_ROOT_NODE = "/" + XMLConstants.ROOT_NODE_NAME;

    /**
     * <b>XML Node Path:</b> For the Transformator Section.
     */
    static final String PATH_4_TRANSFORMATORS = "/" + XMLConstants.ROOT_NODE_NAME + "/"
            + XMLConstants.TRANSFORMATORS_NODE_NAME;

    /*
     * Name for Nodes
     */
    /**
     * <b>XML Node Name:</b> For the root node.
     */
    private static final String ROOT_NODE_NAME = "ProductLineProject";
    
    /**
     * <b>XML Node Name:</b> For the Transformators Section.
     */
    private static final String TRANSFORMATORS_NODE_NAME = "transformators";

    // checkstyle: stop declaration order check
    /**
     * <b>Closing Tag:</b> For the root node.
     */
    static final String CLOSING_ROOT = "</" + ROOT_NODE_NAME + ">";

    /**
     * <b>Starting Tag:</b> For the Transformators Section.
     */
    static final String STARTING_TRANSFORMATORS = "<" + TRANSFORMATORS_NODE_NAME + ">";
    // checkstyle: resume declaration order check

    
    /*
     * XML-Tags
     */
    /**
     * Returns the Begin of the the xml file (preamble + ROOT tag).
     * 
     * @param project The project which should be saved.
     * @param pathEnv a path environment for making files and paths relative
     * @return begin for a valid configuration xml file.
     */
    static StringBuffer startTag(PersistentProject project, PathEnvironment pathEnv) {
        StringBuffer tag = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        tag.append(LINEFEED);
        tag.append("<");
        tag.append(ROOT_NODE_NAME);
        tag.append(' ');
        tag.append(PersistenceConstants.PTN_UUID);
        tag.append("=\"");
        tag.append(project.getID());
        tag.append("\" ");
        tag.append(PersistenceConstants.PTN_PROJECTNAME);
        tag.append("=\"");
        tag.append(project.getProject().getName());
        Version version = project.getVersion();
        if (null != version) {
            tag.append("\" ");
            tag.append(PersistenceConstants.PLP_VERSION);
            tag.append("=\"");
            tag.append(version.getVersion());
        }
        File location = project.getLocation();
        if (null != location) {
            tag.append("\" ");
            tag.append(PersistenceConstants.PLP_LOCATION);
            tag.append("=\"");
            tag.append(FileUtils.toIndependent(pathEnv.makeRelative(location)));
        }
        tag.append("\">");
        tag.append(LINEFEED);

        return tag;
    }

    /**
     * Creates an appropriate XML opening tag for a given model type.
     * 
     * @param type the model type which should be stored in a XML file.
     * @return A XML starting tag
     */
    static StringBuffer startingTag(ModelType type) {
        StringBuffer tag = new StringBuffer();
        tag.append(TABSTOP);
        tag.append("<");
        tag.append(type.getDenotation());
        tag.append(">");
        tag.append(LINEFEED);

        return tag;
    }

    /**
     * Creates an appropriate XML opening tag for a given model type.
     * 
     * @param type the model type which should be stored in a XML file.
     * @return A XML starting tag
     */
    static StringBuffer closingTag(ModelType type) {
        StringBuffer tag = new StringBuffer();
        tag.append(TABSTOP);
        tag.append("</");
        tag.append(type.getDenotation());
        tag.append(">");
        tag.append(LINEFEED);

        return tag;
    }

    /**
     * Creates a path for the XML parser to locate the desired model.
     * 
     * @param type The type of the desired model, which should be parsed.
     * @return A XML path to locate the nodes of the desired model
     */
    static StringBuffer path4Models(ModelType type) {
        StringBuffer path = new StringBuffer();
        path.append(PATH_4_ROOT_NODE);
        path.append("/");
        String node = type.getDenotation();
        path.append(node);

        return path;
    }
}