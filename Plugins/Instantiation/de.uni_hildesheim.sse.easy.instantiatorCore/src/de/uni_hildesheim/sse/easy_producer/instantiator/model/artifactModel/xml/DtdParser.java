package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to read embedded DTDs from XML files and write them back later.
 * This is neccessary due to the fact, that the transformer of w3c.dom loses any information of embedded DTDs.
 * @author pastuschek
 *
 */
public class DtdParser {
    
    private static final String DOCTYPE = "<!DOCTYPE";
    private InputStream fis = null;
    private BufferedReader br = null;
    
    /**
     * Will extract a embedded DTD from an XML file.
     * @param file The XML file.
     * @return A List of Strings with the embedded DTD.
     * @throws FileNotFoundException Thrown if the XML file could not be found.
     */
    public Dtd extractDTD(File file) throws FileNotFoundException {
        
        Dtd dtd = new Dtd();
        
        dtd = checkForDTD(this.readFile(file));
        
        return dtd;
    }
    
    /**
     * Checks a List of Strings for an embedded DTD.
     * If a DTD exists it is returned as a new List of Strings.
     * @param stringList List of Strings that are to be checked for DTD.
     * @return A List of Strings with the DTD only (formatting will be maintained).
     */
    private Dtd checkForDTD(List<String> stringList) {
    
        List<String> dtdContent = new ArrayList<String>();
        Dtd dtd = new Dtd();
        
        int openBrackets = 0;
        int current = 0;
        int start = -1;
        String string = "";
        String subString = "";
        
        System.out.println(stringList.size());
        
        for (int i = 0; i < stringList.size(); i++) {
            
            string = stringList.get(i);
            
            start = string.toLowerCase().indexOf(DOCTYPE.toLowerCase());
            if (start >= 0) {
                current = start + DOCTYPE.length();
                dtd.setLine(i);
                subString = DOCTYPE;
                openBrackets++;
            }
            
            while (openBrackets > 0 && current < string.length()) {
                if (string.charAt(current) == '<') {
                    openBrackets++;
                } else if (string.charAt(current) == '>') {
                    openBrackets--;
                }
                subString += string.charAt(current);
                current++;
            }
            
            if (openBrackets > 0) {
                start = -1;
            }
            
            if (subString.length() > 0) {
                dtdContent.add(subString);
            }
            
            subString = "";
            current = 0;
            
        }
        
        dtd.setContent(dtdContent);
        return dtd;
        
    }
    
    /**
     * Writes the dtd back into a file.
     * @param file The file to change.
     * @param dtd The dtd to write into the file.
     * @throws FileNotFoundException If file was not found.
     */
    public void writeDtd(File file, Dtd dtd) throws FileNotFoundException {
        
        List<String> oldContent = this.readFile(file);
        
        Writer writer = null;

        if (null != dtd && null != file) {
        
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "utf-8"));
                for (int i = 0; i < oldContent.size(); i++) {
                    if (i == dtd.getLine()) {
                        List<String> dtdContent = dtd.getContent();
                        for (int j = 0; j < dtdContent.size(); j++) {
                            writer.write(dtdContent.get(j));
                            writer.write(System.getProperty("line.separator"));
                        }
                    }
                    writer.write(oldContent.get(i));
                    writer.write(System.getProperty("line.separator"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
        }
        
    }
    
    /**
     * Reads a file and returns a List of Strings with the content.
     * @param file The file to be read.
     * @return A List of Strings with the content.
     * @throws FileNotFoundException If File was not found.
     */
    private List<String> readFile(File file) throws FileNotFoundException {
        
        String line;
        List<String> stringList = new ArrayList<String>();
        fis = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        
        try {
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    String addString = stringList.get(stringList.size() - 1);
                    addString += "\n";
                    stringList.remove(stringList.size() - 1);
                    stringList.add(addString);
                } else {
                    stringList.add(line);
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        
        try {
            fis.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return stringList;
    }

}
