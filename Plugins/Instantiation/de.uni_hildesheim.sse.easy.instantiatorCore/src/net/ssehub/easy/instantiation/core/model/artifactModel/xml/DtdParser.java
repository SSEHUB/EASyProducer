package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * This class is used to read embedded DTDs from XML files and write them back later.
 * This is neccessary due to the fact, that the transformer of w3c.dom loses any information of embedded DTDs.
 * @author pastuschek
 *
 */
public class DtdParser {
    
    private static final String DOCTYPE = "<!DOCTYPE";
    
    /**
     * Will extract a embedded DTD from an XML file.
     * @param file The XML file.
     * @return A List of Strings with the embedded DTD.
     * @throws FileNotFoundException Thrown if the XML file could not be found.
     */
    public static Dtd extractDTD(File file) throws FileNotFoundException {
        return checkForDTD(readFile(file));
    }

    /**
     * Will extract a embedded DTD from an XML file.
     * 
     * @param in the input stream
     * @return A List of Strings with the embedded DTD.
     */
    public static Dtd extractDTD(InputStream in) {
        return checkForDTD(readFile(in));
    }

    /**
     * Checks a List of Strings for an embedded DTD.
     * If a DTD exists it is returned as a new List of Strings.
     * @param stringList List of Strings that are to be checked for DTD.
     * @return A List of Strings with the DTD only (formatting will be maintained).
     */
    private static Dtd checkForDTD(List<String> stringList) {
        List<String> dtdContent = new ArrayList<String>();
        Dtd dtd = new Dtd();
        int openBrackets = 0;
        int current = 0;
        int start = -1;
        String string = "";
        String subString = "";
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
    public static void writeDtd(File file, Dtd dtd) throws FileNotFoundException {
        List<String> oldContent = readFile(file);
        BufferedWriter writer = null;
        if (null != dtd && null != file) {
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "UTF-8"));
                for (int i = 0; i < oldContent.size(); i++) {
                    if (i == dtd.getLine()) {
                        List<String> dtdContent = dtd.getContent();
                        for (int j = 0; j < dtdContent.size(); j++) {
                            writer.write(dtdContent.get(j));
                            writer.write("\r\n");
                        }
                    }
                    writer.write(oldContent.get(i));
                    writer.write("\r\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (null != writer) {
                        writer.close();
                    }
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
    private static List<String> readFile(File file) throws FileNotFoundException {
        List<String> result = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            result = readFile(fis);
            fis.close();
        } catch (IOException e) {
            IOUtils.closeQuietly(fis);
        }
        if (null == result) {
            result = new ArrayList<String>();
        }
        return result;
    }
    
    /**
     * Reads a from an input stream and returns a List of Strings with the content.
     * 
     * @param in the input stream to read
     * @return A List of Strings with the content.
     */
    private static List<String> readFile(InputStream in) {
        String line;
        List<String> stringList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        try {
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    if (stringList.size() > 0) {
                        String addString = stringList.get(stringList.size() - 1);
                        addString += "\r\n";
                        stringList.remove(stringList.size() - 1);
                        stringList.add(addString);
                    }
                } else {
                    stringList.add(line);
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return stringList;
    }

}
