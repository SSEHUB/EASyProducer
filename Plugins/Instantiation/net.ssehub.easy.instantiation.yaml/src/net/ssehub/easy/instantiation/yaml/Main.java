package net.ssehub.easy.instantiation.yaml;

import java.io.File;
import java.io.IOException;

/**
 * This class is used for the standalone jar file which is used to edit
 * configuration files.
 * 
 * @author Aike Sass
 *
 */
public class Main {
    private static final String CONF_FILE = "storm.yaml";

    /**
     * This class edits a configuration files which is located at the HARD CODED
     * path. The configuration file will be backed up before editing.
     * 
     * @param args
     *            The arguements contain the key and values which should be
     *            edited.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            String key = args[0];
            String value = args[1];
            String path = "/usr/local/storm/conf/" + CONF_FILE;
            File file = new File(path);
            try {
                YamlDeserializer.getInstance().createBackup(file);
                YamlEditor.getInstance().refreshData(file);
                String oldValue = (String) YamlEditor.getInstance().getEntry(key, file);
                String newValue = oldValue + " " + value;
                YamlEditor.getInstance().updateEntry(file, key, newValue);
                String oldString = YamlDeserializer.getInstance().getOriginalFile();
                String newString = YamlSerializer.getInstance().merge(YamlEditor.getInstance().getData(), oldString);
                YamlSerializer.getInstance().save(newString, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(
                    "Parameters not valid! Please make sure you call this "
                    + "programm with the following parameters: key value");
        }
    }

}

// SCRIPTDIR=`dirname $0`
// source $SCRIPTDIR/env.sh
// KEY="worker.childopts"
// VALUE="-javaagent:"
// for host in $WORKER
// do
// ssh nisstorm@$host 'java -jar Yaml.jar Main host KEY VALUE
// echo $host ok
// done
