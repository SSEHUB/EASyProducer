package de.uni_hildesheim.sse.model.management;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.modelManagement.IModelManagementRepository;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Utils;

/**
 * Implements (internationalized) comment persistence mechanisms on model level.
 * Instances of this class cannot be created directly rather than being obtained from {@link VarModel}.
 * 
 * @author Holger Eichelberger
 */
public class ModelCommentsPersistencer {
    
    private IModelManagementRepository<Project> repository;
    
    /**
     * Prevents creating instances from outside this package.
     * 
     * @param repository the repository instance for callbacks
     */
    ModelCommentsPersistencer(IModelManagementRepository<Project> repository) {
        this.repository = repository;
    }
    
    /**
     * Stores the comments stored in the resolved project of <code>info</code>. Existing
     * data will be overwritten. Currently, this method considers only containable
     * model elements.
     * 
     * @param info the project information the comments shall be stored for
     * @return <code>true</code> if the comments have been stored, <code>false</code> if
     *   no exception occurred but also the data was not stored, e.g. because <code>info</code>
     *   is not resolved or {@link ModelInfo#getCommentsResource()} is invalid
     * @throws IOException in case that writing of the comments resource caused an error
     */
    public synchronized boolean storeComments(ModelInfo<Project> info) throws IOException {
        return storeComments(info, false);
    }
    
    /**
     * Stores the comments stored in the resolved project of <code>info</code> and optionally
     * for all imported projects. Existing data will be overwritten. Currently, this method 
     * considers only containable model elements.
     * 
     * @param info the project information the comments shall be stored for
     * @param considerImports consider also (resolved) imported projects
     * @return <code>true</code> if the comments have been stored, <code>false</code> if
     *   no exception occurred but also the data was not stored, e.g. because <code>info</code>
     *   is not resolved or {@link ModelInfo#getCommentsResource()} is invalid
     * @throws IOException in case that writing of the comments resource caused an error
     */
    public synchronized boolean storeComments(ModelInfo<Project> info, boolean considerImports) throws IOException {
        boolean done = false;
        Project project = info.getResolved();
        if (null != project) {
            URI resourceUri = info.getCommentsResource();
            if (null != resourceUri) {
                File resourceFile = new File(resourceUri);
                CommentResource props = new CommentResource();
                int size = project.getElementCount();
                for (int c = 0; c < size; c++) {
                    ContainableModelElement element = project.getElement(c);
                    String qName = element.getQualifiedName();
                    if (null != qName) {
                        props.put(qName, element.getComment());
                    }
                }
                FileWriter fw = new FileWriter(resourceFile);
                try {
                    props.store(fw);
                } catch (IOException e) {
                    try {
                        fw.close();
                    } catch (IOException e1) {
                    }
                    throw e;
                }
                fw.close();
                
                size = project.getImportsCount();
                for (int i = 0; i < size; i++) {
                    ProjectImport imp = project.getImport(i);
                    if (!imp.isConflict()) {
                        // do not just use getProjectInfo as this may taint unrelated projects
                        storeComments(repository.getResolvedModelInfo(imp.getResolved()));
                    }
                }
                done = true;
            }
        }
        return done;
    }
    
    
    
    /**
     * Loads comments from the resolved project of <code>info</code>. Existing comments in
     * the related project will be overridden. This method affects only the directly related
     * project!
     * 
     * @param info the information object to load comments for
     * @throws IOException in case that reading the comments resource caused an error
     */
    void loadComments(ModelInfo<Project> info) throws IOException {
        Project project = info.getResolved();
        if (null != project) {
            File resourceFile = Utils.toExistingFile(info.getCommentsResource());
            if (null == resourceFile) {
                resourceFile = Utils.toExistingFile(info.getDefaultCommentsResource());
            }
            if (null != resourceFile) {
                CommentResource props = new CommentResource();
                FileReader fr = new FileReader(resourceFile);
                try {
                    props.load(fr);
                } catch (IOException e) {
                    try {
                        fr.close();
                    } catch (IOException e1) {
                    }
                    throw e;
                }
                fr.close();
                assignCommentsToProject(project, props);
            }
        }
    }
    
    /**
     * Assign the comments stored in <code>props</code> to the containable
     * model elements in <code>project</code>.
     * 
     * @param project the project to assign the comments to (may be modified as a 
     *   side effect)
     * @param props the properties containing the comments (fqn-comment mapping)
     */
    private void assignCommentsToProject(Project project, CommentResource props) {
        int size = project.getElementCount();
        for (int c = 0; c < size; c++) {
            ContainableModelElement element = project.getElement(c);
            assignComment(element, props);
            if (element instanceof IDecisionVariableContainer) {
                assignComments((IDecisionVariableContainer) element, props);
            }
        }
    }

    /**
     * Assign the comments stored in <code>props</code> to the 
     * model elements in <code>container</code>.
     * 
     * @param container the container to assign the comments to (may be modified as a 
     *   side effect)
     * @param props the properties containing the comments (fqn-comment mapping)
     */
    private void assignComments(IDecisionVariableContainer container, CommentResource props) {
        for (int e = 0; e < container.getElementCount(); e++) {
            assignComment(container.getElement(e), props);
        }
        for (int a = 0; a < container.getAssignmentCount(); a++) {
            assignComments(container.getAssignment(a), props);
        }
    }
    
    /**
     * Assigns a comment from <code>props</code> (if exists) to <code>elt</code>.
     * 
     * @param elt the element to assign to (modified as a side effect)
     * @param props the comment resource containing the comments
     */
    private void assignComment(ContainableModelElement elt, CommentResource props) {
        String comment = "";
        String qName = elt.getQualifiedName();
        if (null != qName) {
            String tmp = props.get(qName);
            if (null != tmp) {
                comment = tmp;
            }
        }
        elt.setComment(comment);
    }

}
