package net.ssehub.easy.instantiation.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * This class loads a yaml configuration file.
 * 
 * @author Aike Sass
 *
 */
public class YamlDeserializer {

    private String originalFile;

    /**
     *  Thread-safe singleton.
     *  
     * @author Aike Sass
     *
     */
    private static final class InstanceHolder {
        static final YamlDeserializer INSTANCE = new YamlDeserializer();
    }

    /**
     * Private constructor.
     */
    private YamlDeserializer() {
    }

    /**
     * Returns an instance of this class.
     * @return An instance of {@link InstanceHolder}.
     */
    public static YamlDeserializer getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * Loads the file from the file system using snakeyaml.
     * 
     * @param file Path to configuration file.
     * @return Map with all key value pairs.
     * 
     * @throws IOException exception
     */
    public Map<Object, Object> loadFile(File file) throws IOException {
        if (null == originalFile) {
            originalFile = readOriginalFile(file);
        }
        InputStream input = new FileInputStream(file);
        Yaml yaml = new Yaml();
        Map<Object, Object> ret = (Map<Object, Object>) yaml.load(new InputStreamReader(input));
        if (null != ret) {
            ret = new HashMap<Object, Object>(ret);
        } else {
            ret = null;
        }
        try {
            input.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Creates a backup file by coping the file and renaming it.
     * 
     * @param file The file which should be backed up.
     * @throws IOException exception
     */
    public void createBackup(File file) throws IOException {
        File dest = new File(file.getParentFile().getAbsolutePath(), file.getName() + "_backup");
        FileUtils.copyFile(file, dest);
    }

    /**
     * Reads the original configuration file.
     * 
     * @param file Path the configuration file.
     * 
     * @return File as String
     * @throws IOException exception
     */
    private String readOriginalFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        String fileAsString = "";
        try {
            fileAsString = IOUtils.toString(inputStream);
        } finally {
            inputStream.close();
        }
        return fileAsString;
    }

    /**
     * Returns the original file as string.
     * @return File as string
     */
    public String getOriginalFile() {
        return originalFile;
    }

    /**
     * Gets a file from a remote host.
     * Taken from http://www.jcraft.com/jsch/examples/ScpFrom.java.html
     * 
     * @param user the username credential
     * @param password the password credential
     * @param host the remote host
     * @param rfile The remote file
     * @param lfile The local file
     */
//    public void getFromSCP(String user, String password, String host, String rfile, String lfile) {
//        String prefix = null;
//        if (new File(lfile).isDirectory()) {
//            prefix = lfile + File.separator;
//        }
//        try {
//            Session session = createSession(user, password, host);
//            // exec 'scp -f rfile' remotely
//            String command = "scp -f " + rfile;
//            Channel channel = session.openChannel("exec");
//            ((ChannelExec) channel).setCommand(command);
//            // get I/O streams for remote scp
//            OutputStream out = channel.getOutputStream();
//            InputStream in = channel.getInputStream();
//            channel.connect();
//            byte[] buf = new byte[1024];
//            // send '\0'
//            buf[0] = 0;
//            out.write(buf, 0, 1);
//            out.flush();
//            while (true) {
//                int c = checkAck(in);
//                if (c != 'C') {
//                    break;
//                }
//                // read '0644 '
//                in.read(buf, 0, 5);
//                long filesize = 0L;
//                while (true) {
//                    if (in.read(buf, 0, 1) < 0) {
//                        // error
//                        break;
//                    }
//                    if (buf[0] == ' ') {
//                        break;
//                    }
//                    filesize = filesize * 10L + (long) (buf[0] - '0');
//                }
//                String file = null;
//                for (int i = 0;; i++) {
//                    in.read(buf, i, 1);
//                    if (buf[i] == (byte) 0x0a) {
//                        file = new String(buf, 0, i);
//                        break;
//                    }
//                }
//                // send '\0'
//                buf[0] = 0;
//                out.write(buf, 0, 1);
//                out.flush();
//                // read a content of lfile
//                FileOutputStream fos = new FileOutputStream(prefix == null ? lfile : prefix + file);
//                int foo;
//                while (true) {
//                    if (buf.length < filesize) {
//                        foo = buf.length;
//                    } else {
//                        foo = (int) filesize;
//                    }
//                    foo = in.read(buf, 0, foo);
//                    if (foo < 0) {
//                        // error
//                        break;
//                    }
//                    fos.write(buf, 0, foo);
//                    filesize -= foo;
//                    if (filesize == 0L) {
//                        break;
//                    }
//                }
//                fos.close();
//                fos = null;
//                if (checkAck(in) != 0) {
//                    System.exit(0);
//                }
//                // send '\0'
//                buf[0] = 0;
//                out.write(buf, 0, 1);
//                out.flush();
//            }
//            session.disconnect();
//        } catch (JSchException | IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Creates a session for downloading a file from a remote host.
     * @param user The user credential
     * @param password The password credential
     * @param host The remote host
     * @return Created session
     * @throws JSchException exception
     */
    private Session createSession(String user, String password, String host) throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, 22);
        // username and password will be given via UserInfo interface.
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        return session;
    }

    /**
     * Check the acknowledgement.
     * @param in Inputstream
     * @return errorcode
     * @throws IOException exception
     */
    static int checkAck(InputStream in) throws IOException {
        int b = in.read();
        // b may be 0 for success,
        // 1 for error,
        // 2 for fatal error,
        // -1
        if (b == 0) {
            return b;
        }
        if (b == -1) {
            return b;
        }
        if (b == 1 || b == 2) {
            StringBuffer sb = new StringBuffer();
            int c;
            do {
                c = in.read();
                sb.append((char) c);
            } while (c != '\n');
            if (b == 1) { // error
                System.out.print(sb.toString());
            }
            if (b == 2) { // fatal error
                System.out.print(sb.toString());
            }
        }
        return b;
    }

    /**
     * Parse the env.sh file on nimbus to get all the worker URIs.
     * 
     * @param user The user credentials.
     * @param password The password credentials.
     * @param host The remote host.
     * @param rfile The remote file
     * @param lfile The local file
     * @return List with all workers
     * @throws IOException exception
     */
//    public List<String> getStormWorker(String user, String password, String host, String rfile, String lfile)
//            throws IOException {
//        List<String> list = new ArrayList<String>();
//        getFromSCP(user, password, host, rfile, lfile);
//        FileInputStream inputStream = new FileInputStream(new File(lfile));
//        try {
//            String fileAsString = IOUtils.toString(inputStream);
//            Properties p = new Properties();
//            p.load(new StringReader(fileAsString));
//            String workerProp = p.getProperty("WORKER");
//            workerProp = workerProp.replace("\"", "");
//            String[] tmp = workerProp.split(" ");
//            for (String string : tmp) {
//                list.add(string);
//            }
//        } finally {
//            inputStream.close();
//        }
//        return list;
//    }

}
