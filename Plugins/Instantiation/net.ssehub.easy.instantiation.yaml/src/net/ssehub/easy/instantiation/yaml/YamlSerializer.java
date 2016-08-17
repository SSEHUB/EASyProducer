package net.ssehub.easy.instantiation.yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * This class is used to safe the configuration to the file system.
 * 
 * @author Aike Sass
 *
 */
public class YamlSerializer {

    /**
     * Thread-safe singleton.
     * 
     * @author Aike Sass
     */
    private static final class InstanceHolder {
        static final YamlSerializer INSTANCE = new YamlSerializer();
    }

    /**
     * Private constructor.
     */
    private YamlSerializer() {
    }

    /**
     * Returns the an instance of {@link InstanceHolder}.
     * 
     * @return Instance of {@link InstanceHolder}
     */
    public static YamlSerializer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // public void dump(Object data, File file) throws IOException {
    //// DumperOptions options = new DumperOptions();
    //// options.setDefaultScalarStyle(DumperOptions.ScalarStyle.DOUBLE_QUOTED);
    // Yaml yaml = new Yaml();
    // FileWriter writer = new FileWriter(file);
    // yaml.dump(data, writer);
    // writer.close();
    // }

    /**
     * Saves a configuration to the file system.
     * 
     * @param fileAsString
     *            The file as string
     * @param source
     *            The path in the file system where the configuration should be
     *            saved.
     * @throws IOException
     *             exception
     */
    public void save(String fileAsString, File source) throws IOException {
        FileUtils.writeStringToFile(source, fileAsString);
    }

    /**
     * Merges the new yaml properties with the original file. This needs to be
     * done to keep the comments in the file.
     * 
     * @param data
     *            new properties
     * @param string
     *            The original file as string.
     * @return file as string with merge results
     */
    public String merge(Map<Object, Object> data, String string) {
        string = string.replace("\r", "");
        for (Object object : data.keySet()) {
            String key = String.valueOf(object);
            if (string.contains(key)) {
                if (data.get(object) instanceof String) {
                    String newValue = String.valueOf(data.get(object));
                    int position = string.indexOf(key);
                    char escaped = string.charAt(position + key.length() + 2);
                    if (escaped == '"') {
                        int start = string.indexOf("\"", position);
                        int end = string.indexOf("\"", start + 1);
                        String value = string.substring(start + 1, end);
                        if (!value.equals(newValue)) {
                            System.out.println("UPDATING STRING: " + value);
                            String before = string.substring(0, start + 1);
                            String after = string.substring(end);
                            string = before + newValue + after;
                        }
                    } else {
                        int start = string.indexOf(" ", position);
                        int end = string.indexOf("\n", start);
                        String value = string.substring(start + 1, end);
                        if (!value.equals(newValue)) {
                            System.out.println("UPDATING: " + value);
                            string = string.substring(0, start + 1) + newValue
                                    + string.substring(start + 1 + newValue.length());
                        }
                    }
                }
                if (data.get(object) instanceof Integer) {
                    String newValue = String.valueOf(data.get(object));
                    int position = string.indexOf(key);
                    int start = string.indexOf(":", position) + 2;
                    int end = string.indexOf("\n", start);
                    String value = string.substring(start, end);
                    if (!value.equals(newValue)) {
                        System.out.println("UPDATING INT: " + value);
                        string = string.substring(0, start) + newValue + string.substring(start + newValue.length());
                    }
                }
                if (data.get(object) instanceof ArrayList) {
                    ArrayList<String> newList = (ArrayList<String>) data.get(object);
                    String newValue = "";
                    for (String str : newList) {
                        newValue = newValue + "     - \"" + str + "\"";
                        if (newList.indexOf(str) != newList.size() - 1) {
                            newValue = newValue + "\n";
                        }
                    }
                    int position = string.indexOf(key);
                    int start = string.indexOf(":", position);
                    int end = string.indexOf("\n", start);
                    for (int i = 0; i < newList.size(); i++) {
                        int tmpEnd = string.indexOf("\n", end + 1);
                        String substring = string.substring(end, tmpEnd);
                        if (substring.trim().startsWith("-")) {
                            end = tmpEnd;
                        }
                    }
                    String value = string.substring(start + 2, end);
                    if (!value.trim().equals(newValue.trim())) {
                        System.out.println("UPDATING ARRAY: " + value);
                        string = string.substring(0, start + 2) + newValue + string.substring(end);
                    }
                }
            }
        }
        return string;
    }

}
