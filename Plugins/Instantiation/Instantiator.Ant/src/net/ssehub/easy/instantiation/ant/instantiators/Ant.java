package net.ssehub.easy.instantiation.ant.instantiators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> ant(Path root, String buildFilePath, String buildtarget) 
        throws VilException {

        File buildFile = new File(root.getAbsolutePath(), buildFilePath);
        String fullBuildFilePath = buildFile.getAbsolutePath();
         
        long timestamp = PathUtils.normalizedTime();
        File targetPath = determineTargetPath(root);

        if (buildFile.exists() && fullBuildFilePath.endsWith(XML_TYPE)) {
            buildFile = new File(fullBuildFilePath);
        } else {
            throw new VilException("buildfile '" + fullBuildFilePath + "' does not exists or is not valid", 
                            VilException.ID_INSUFFICIENT_ARGUMENT);
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
            throw new VilException(e.getMessage(), VilException.ID_RUNTIME_EXECUTION);
        }
        //Display ANT-Error-Messages in EASy
        if (CONSOLE_LOGGER.getMessages().containsKey(ERR_PRIO))  {
            throw new VilException("ANT: " + CONSOLE_LOGGER.getMessages().get(MSG_PRIO) 
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