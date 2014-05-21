package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all information of a DTD.
 * That is the actual DTD and the line within the XML that it was located in before.
 * @author pastuschek
 *
 */
public class Dtd {

    private List<String> dtdContent = new ArrayList<String>();
    private int line = 0;
    
    /**
     * Sets the content of the DTD.
     * @param content A List of Strings with the DTD content.
     */
    public void setContent(List<String> content) {
        this.dtdContent = content;
    }
    
    /**
     * Sets the line of the DTD. This is the number of the line where the DTD shall start in
     * the XML file.
     * @param line An Integer with the line where the DTD began in its original document.
     */
    public void setLine(int line) {
        this.line = line;
    }
    
    /**
     * Returns the content of the DTD.
     * @return List of Strings with the DTD content.
     */
    public List<String> getContent() {
        return this.dtdContent;
    }
    
    /**
     * Returns the line of the DTD.
     * This is the line in which the DTD began in its original file.
     * @return Integer with the line number.
     */
    public int getLine() {
        return this.line;
    }
    
}
