package de.uni_hildesheim.sse.easy.ant.instantiators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;



//import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * A Make-Instantiator, wich runs make-scripts with the help of ANT (operating system independent).
 * 
 * @author Sebastian Bender
 */
@Instantiator("make")
public class Make extends AbstractFileInstantiator {

    private static final CustomAntLogger CONSOLE_LOGGER = new CustomAntLogger();
    private static final String XML_TYPE = ".xml";

    //ANT Messages
    private static final int ERR_PRIO = 0;
    private static final int MSG_PRIO = 2;

    // checkstyle: stop exception type check
    
    /**
     * Runs make-scripts with the help of ANT.
     * 
     * @param root the root-path
     * @param buildFilePath the make-build-file
     * @param buildtarget the build target (must be ant)
     * @param arguments make-arguments
     * @return the created artefacts
     * @throws VilException in case of execution/parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> make(Path root, String buildFilePath, String buildtarget, 
        Map<String, Object> arguments) throws VilException {
        
        File buildFile = new File(root.getAbsolutePath(), buildFilePath);
        String fullBuildFilePath = buildFile.getAbsolutePath();
        
        long timestamp = PathUtils.normalizedTime();
        File targetPath = determineTargetPath(root);

        if (buildFile.exists() && buildFile.isDirectory()) {
            buildFile = createTempBuildFile(fullBuildFilePath, argumentsToString(arguments));     
        } else {
            throw new VilException("invalid build path", VilException.ID_INSUFFICIENT_ARGUMENT);
        }
        Project p = new Project();
        antDebugging(p);
        p.setUserProperty("ant.file", buildFile.getAbsolutePath());        
        try {
            p.fireBuildStarted();
            p.init();
            ProjectHelper helper = ProjectHelper.getProjectHelper();
            p.addReference("ant.projectHelper", helper);
            helper.parse(p, buildFile);
            //TODO: Aktuell nur "ant" als target unterstuetzt
            p.executeTarget(buildtarget);
            p.fireBuildFinished(null);
        } catch (Exception e) {
            p.fireBuildFinished(e);
            throw new VilException(e.getMessage(), VilException.ID_RUNTIME_EXECUTION);

        }
        //Display (Make)-Errors in EASy
        if (CONSOLE_LOGGER.getMessages().containsKey(ERR_PRIO))  {
            throw new VilException("MAKE: " + CONSOLE_LOGGER.getMessages().get(MSG_PRIO) 
                + " " + CONSOLE_LOGGER.getMessages().get(ERR_PRIO), VilException.ID_INSUFFICIENT_ARGUMENT);

        }
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), root.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }
    
    // checkstyle: resume exception type check

    
    /**
     * Creates a temporary ANT build file to execute make.
     * 
     * @param path the path to execute the make file within
     * @param arguments the arguments for make
     * @return the created (temporary) file
     */
    private static File createTempBuildFile(String path, String arguments) {
        File temp = null;
        String content = "<?xml version=\"1.0\" ?> <project name=\"TestANTMAKE\" default=\"make\"> "
                + "\n <target name=\"make\">"
                + "\n <exec executable=\"make\">"
                + "\n <arg line=\"" + arguments + " -C " + path + "\"/>"
                + "\n</exec>"
                + "\n</target>"
                + "\n</project>";
        //System.out.println(content);
        try {
            temp = File.createTempFile(String.valueOf(new Random().nextInt()), XML_TYPE);
            FileWriter fw = new FileWriter(temp.getPath(), true);
            fw.write(content);
            fw.flush();
            fw.close();
            temp.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Turns VIL parameters into string parameters for Make.
     * 
     * @param arguments the arguments to be turned into a String
     * @return the resulting string
     */
    private static String argumentsToString(Map<String, Object> arguments) {
        String argument = "";
        for (Map.Entry<String, Object> param : arguments.entrySet()) {
            argument += toString(param.getValue() + " ");    
        }
        return argument;
    }
    
    /**
     * Applies debugging settings to the executing ANT project.
     * 
     * @param project the project to be modified
     */
    private static void antDebugging(Project project) {
        //DefaultLogger consoleLogger = new DefaultLogger();
        CONSOLE_LOGGER.setErrorPrintStream(System.err);
        CONSOLE_LOGGER.setOutputPrintStream(System.out);
        CONSOLE_LOGGER.setMessageOutputLevel(Project.MSG_INFO);
        project.addBuildListener(CONSOLE_LOGGER);
    }
    
}