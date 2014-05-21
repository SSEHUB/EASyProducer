package de.uni_hildesheim.sse.persistency;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;

/**
 * An IVML writer which may or not emit comments.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurableIVMLWriter extends IVMLWriter {

    private List<Project> imports;
    private int projectNestingLevel = 0;
    
    /**
     * Creates a writer instance. Due to the pooling mechanism, disabling comments
     * can only be done by a non-pooled subclass.
     *  
     * @param writer the writer which should be used for writing the output
     * @param emitComments whether comments shall be emitted or ignored
     * @param emitImports whether imports shall be emitted or ignored
     */
    public ConfigurableIVMLWriter(Writer writer, boolean emitComments, boolean emitImports) {
        super(writer, emitComments);
        if (emitImports) {
            imports = new ArrayList<Project>();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitProjectImport(ProjectImport pImport) {
        super.visitProjectImport(pImport);
        Project resolved = pImport.getResolved();
        if (null != imports && null != resolved) {
            if (!imports.contains(resolved)) {
                imports.add(resolved);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitProject(Project project) {
        projectNestingLevel++;
        super.visitProject(project);
        projectNestingLevel--;
        if (0 == projectNestingLevel && null != imports) {
            projectNestingLevel++;
            for (int i = 0; i < imports.size(); i++) {
                imports.get(i).accept(this);
            }
            projectNestingLevel--;
        }
    }
    
}
