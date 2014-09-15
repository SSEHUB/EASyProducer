package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle string collections and their format in editor.
 *  
 * @author Dennis Konoppa
 */
public class StringCollectionHandler implements IGUITextHandler {

    private String separator;

    /**
     * C'tor for StringCollectionEditor.
     * 
     * @param separator - the separator string
     */
    public StringCollectionHandler(String separator) {
        this.separator = separator;
    }
    
    @Override
    public String format(String text) {
        String result = text.replaceAll("\\{", "");
        result = result.replaceAll("\\}", "");
        String[] values = result.split(separator);
        List<String> strings = new ArrayList<String>();
        if (values.length >= 1 && !values[0].equals("")) {
            // Machine has ports
            for (String value: values) {
                strings.add(value);
            }            
        }
        result = createTextAreaNumbers(strings);
        return result;
    }


    @Override
    public List<Object> split(String format) {
        String[] values = format.split(", ");
        List<Object> list = new ArrayList<Object>();
        for (String value : values) {
            list.add(value);
        }
        return list;
    }
    
    /**
     * Method to create format of lists of numbers in the Editor.
     * 
     * @return String with correct format for Editor
     * @param strings - List of strings
     */
    public String createTextAreaNumbers(List<String> strings) {
        StringBuffer st = new StringBuffer();
        st.append(strings.get(0));
        for (int i = 1; i < strings.size(); i++) {
            st.append(separator);
            st.append(strings.get(i));
        }
        return st.toString();
    }

}
