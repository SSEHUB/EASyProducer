package net.ssehub.easy.producer.core.persistence;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;

/**
 * Processes the SAX XML reading.
 * 
 * @author Holger Eichelberger
 */
class ConfigurationContentHandler implements ContentHandler {

    static final String XML_ELT_CONFIGURATION = "configuration";
    static final String XML_ELT_PATH = "path";
    static final String XML_ATTR_KIND = "kind";
    static final String XML_ATTR_VALUE = "value";

    private final Configuration configuration;
    private boolean inConfig = false;

    /**
     * Creates a configuration content handler.
     * 
     * @param configuration the configuration to be modified
     */
    ConfigurationContentHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (!inConfig) {
            if (XML_ELT_CONFIGURATION.equals(qName)) {
                inConfig = true;
            }
        } else {
            if (XML_ELT_PATH.equals(qName)) {
                readPath(atts);
            }
        }
    }
    
    /**
     * Reads a path based on the given attributes.
     * 
     * @param atts the attributes
     */
    private void readPath(Attributes atts) {
        String kind = atts.getValue(XML_ATTR_KIND);
        String value = atts.getValue(XML_ATTR_VALUE);
        if (null != kind & null != value) {
            PathKind k = PathKind.valueOf(kind);
            if (null != k) {
                configuration.setPathDirect(k, value);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (inConfig) {
            if (XML_ELT_CONFIGURATION.equals(qName)) {
                inConfig = false;
            }                
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }
    
}