package de.uni_hildesheim.sse.model.management;

import java.util.List;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * A project imports resolver. Don't store information in attributes!
 * 
 * @author Holger Eichelberger
 */
class DefaultImportResolver extends de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver<Project> {

    /**
     * Creates the resolver instance.
     */
    DefaultImportResolver() {
        super();
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
        logger.info("Model.DefaultImportResolver registered");            
    }

    @Override
    protected ImportResolver<Project> getTopResolver() {
        return VarModel.getResolver();
    }

    @Override
    protected void setTopResolver(ImportResolver<Project> resolver) {
        VarModel.setResolver(resolver);
    }


    /**
     * Checks the imported interfaces for obvious import problems, such as importing projects
     * with interfaces as a whole.
     * 
     * @param imp the import to be resolved
     * @param model the model which may resolve the import
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return <code>true</code> if the import is fine, <code>true</code> if problems were detected
     */
    @Override
    protected boolean checkImported(ModelImport<Project> imp, Project model, List<IMessage> messages) {
        boolean isOk = true;
        if (!imp.isConflict() && imp instanceof ProjectImport) {
            ProjectImport pImp = (ProjectImport) imp;
            boolean projectHasInterfaces = model.hasInterfaces();
            boolean impHasInterfaces = !isEmptyOrNull(pImp.getInterfaceName());
            if (projectHasInterfaces && !impHasInterfaces) {
                messages.add(new Message("import for project '" + imp.getName() 
                    + "' does not refer to an interface but project declares interfaces", 
                    Status.ERROR));
                isOk = false;
            } else if (!projectHasInterfaces && impHasInterfaces) {
                messages.add(new Message("import for project '" + imp.getName() 
                    + "' refers to an interface but project does not declare interfaces", 
                    Status.ERROR));
                isOk = false;
            }
        }
        return isOk;
    }

    /**
     * Returns whether <code>text</code> is empty or <b>null</b>.
     * @param text the string to be tested
     * @return <code>true</code> if <code>text</code> is empty or <b>null</b>, 
     *   <code>false</code> else
     */
    private static boolean isEmptyOrNull(String text) {
        return null == text || 0 == text.length();
    }

}
