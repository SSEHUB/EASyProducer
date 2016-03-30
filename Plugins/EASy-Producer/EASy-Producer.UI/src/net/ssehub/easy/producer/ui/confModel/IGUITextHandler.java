package net.ssehub.easy.producer.ui.confModel;

import java.util.List;

/**
 * Interface for a GUITextHandler. 
 * Handles Texts and creates formats for the Editor.
 * 
 * @author Dennis Konoppa
 *
 */
public interface IGUITextHandler {

    /**
     * Method to create the format for a text.
     * 
     * @param text the text
     * @return formats which is fitting for the text
     */
    public String format(String text);

    /**
     * Method to generate List of Objects from a given format.
     * 
     * @param format the format which contains values of the Machine
     * @return List of Objects which contains valid values for the Machine
     */
    public List<Object> split(String format);
}
