package de.uni_hildesheim.sse.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizard;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "vil". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 * 
 * @author El-Sharkawy
 */

public class VILFiletypeWizard extends AbstractFiletypeWizard {

    /**
     * Constructor for VILFiletypeWizard.
     */
    public VILFiletypeWizard() {
        super(new VILPageCreator(), "de.uni_hildesheim.sse.vil.buildlang.ui");
        setNeedsProgressMonitor(true);
    }

    @Override
    protected InputStream openContentStream(String fileName) {
        String contents = "vilScript " + fileName + "(Project source, Configuration config, Project target) {"
            + LINEFEED + LINEFEED + "}";
        return new ByteArrayInputStream(contents.getBytes());
    }
}