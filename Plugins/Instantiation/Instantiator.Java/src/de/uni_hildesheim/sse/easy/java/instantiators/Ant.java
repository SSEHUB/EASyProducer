package de.uni_hildesheim.sse.easy.java.instantiators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils.ScanResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.AbstractFileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Builds Java applications with ANT.
 * 
 * @author Sebastian Bender
 */
@Instantiator("ant")
public class Ant extends AbstractFileInstantiator {

    private static final String XML_TYPE = ".xml";
    private static final CustomAntLogger CONSOLE_LOGGER = new CustomAntLogger();
    //ANT Messages
    private static final int ERR_PRIO = 0;
    private static final int MSG_PRIO = 2;
    
    // checkstyle: stop exception type check
    
    /**
     * Executes a specific ANT-build target.
     * 
     * @param root the root-path
     * @param buildFilePath ANT-buildfile name
     * @param buildtarget the ANT-Build-Target
     * @return the created artefacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> ant(Path root, String buildFilePath, String buildtarget) 
        throws ArtifactException {

        File buildFile = new File(root.getAbsolutePath(), buildFilePath);
        String fullBuildFilePath = buildFile.getAbsolutePath();
         
        long timestamp = PathUtils.normalizedTime();
        File targetPath = determineTargetPath(root);

        if (buildFile.exists() && fullBuildFilePath.endsWith(XML_TYPE)) {
            buildFile = new File(fullBuildFilePath);
        } else {
            throw new ArtifactException("buildfile '" + fullBuildFilePath + "' does not exists or is not valid", 
                ArtifactException.ID_INSUFFICIENT_ARGUMENT);
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
            p.executeTarget(buildtarget);
            p.fireBuildFinished(null);
        } catch (Exception e) {
            p.fireBuildFinished(e);
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_RUNTIME_EXECUTION);
        }
        //Display ANT-Error-Messages in EASy
        if (CONSOLE_LOGGER.getMessages().containsKey(ERR_PRIO))  {
            throw new ArtifactException("ANT: " + CONSOLE_LOGGER.getMessages().get(MSG_PRIO) 
                    + " " + CONSOLE_LOGGER.getMessages().get(ERR_PRIO), ArtifactException.ID_INSUFFICIENT_ARGUMENT);

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
     * Applies debugging settings to the ANT project.
     * 
     * @param project the project to be modified
     */
    private static void antDebugging(Project project) {
        CONSOLE_LOGGER.setErrorPrintStream(System.err);
        CONSOLE_LOGGER.setOutputPrintStream(System.out);
        CONSOLE_LOGGER.setMessageOutputLevel(Project.MSG_INFO);
        project.addBuildListener(CONSOLE_LOGGER);
    }
    
}