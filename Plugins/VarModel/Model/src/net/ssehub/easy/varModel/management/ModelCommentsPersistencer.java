/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.management;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

import net.ssehub.easy.basics.modelManagement.IModelManagementRepository;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Utils;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.persistency.StringProvider;

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
            CommentResource props = getComments(info);
            if (null != props) {
                assignCommentsToProject(project, props);
            }
        }
    }
    
    public static CommentResource getComments(Project project) throws IOException {
        CommentResource props = null;
        if (null != project) {
            ModelInfo<Project> info = VarModel.INSTANCE.availableModels().getModelInfo(project);
            if (null != info) {
                props = getComments(info);
            }
        }
        return props;
    }
    
    private static CommentResource getComments(ModelInfo<Project> info) throws IOException {
        CommentResource props = null;
        File resourceFile = Utils.toExistingFile(info.getCommentsResource());
        if (null == resourceFile) {
            resourceFile = Utils.toExistingFile(info.getDefaultCommentsResource());
        }
        if (null != resourceFile) {
            props = new CommentResource();
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
        }
        return props;
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
        if (elt instanceof Constraint) {
            qName = getKey((Constraint) elt);
        }
        if (null != qName) {
            String tmp = props.get(qName);
            if (null != tmp) {
                comment = tmp;
            }
        }
        elt.setComment(comment);
    }
    
    public static String getKey(Constraint cons) {
        String key = null;
        if (null != cons) {
            ConstraintSyntaxTree cst = cons.getConsSyntax();
            if (null != cst) {
                key = StringProvider.toIvmlString(cst).replace(" ", "").replace("=", "~");
            }
        }
        return key;
    }

}
