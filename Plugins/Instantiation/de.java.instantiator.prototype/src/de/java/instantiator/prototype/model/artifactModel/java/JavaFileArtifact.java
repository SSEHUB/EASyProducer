package de.java.instantiator.prototype.model.artifactModel.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;

import de.java.instantiator.prototype.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents a Java source code file artifact.
 * 
 * @author Holger Eichelberger
 */
// TODO @ArtifactCreator
public class JavaFileArtifact extends FileArtifact {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaFileArtifact.class, Bundle.ID);

    private File file;

    /**
     * Creates a new class file artifact.
     * 
     * @param file
     *            the file to read the artifact contents from
     * @param model
     *            the artifact model to create this folder artifact within
     */
    JavaFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        this.file = file;
        // parse lazy on request
    }

    /**
     * Returns the annotation value.
     * 
     * @param annotation
     *            the name of the annotation type
     * @param field
     *            the field to be returned
     * @return the field or <b>null</b> if not found
     */
    public String annotationValue(String annotation, String field) {
        return "";
    }

    @Override
    public void artifactChanged() throws ArtifactException {
        // TODO
    }

    @Override
    public void store() throws ArtifactException {
        // TODO consider super
    }

    /**
     * Returns the classes of this java file.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = Class.class)
    public Set<Class> classes() {
        //TODO seperate inner classes
        List<Class> classList = new ArrayList<Class>();
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = Path.fromOSString(workspace.getRoot().getLocation() + file.toString());
        IFile ifile = workspace.getRoot().getFileForLocation(location);
        ICompilationUnit unit = JavaCore.createCompilationUnitFrom(ifile);
        Class clazz = new Class(unit);
        classList.add(clazz);
        return new ArraySet<Class>(classList.toArray(new Class[classList.size()]), Class.class);
    }
}
