package de.uni_hildesheim.sse.vil.rt.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import de.uni_hildesheim.sse.dslcore.ui.wizards.AbstractFiletypeWizard;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "rtvil". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 * 
 * @author El-Sharkawy
 */
public class VILFiletypeWizard extends AbstractFiletypeWizard {

    /**
     * Constructor for rt-VILFiletypeWizard.
     */
    public VILFiletypeWizard() {
        super(new VILPageCreator(), "de.uni_hildesheim.sse.vil.rt.ui");
        setNeedsProgressMonitor(true);
    }

    @Override
    protected InputStream openContentStream(String fileName) {
        String contents = "rtVilScript " + fileName + "(Project source, Configuration config, Project target) {"
            + LINEFEED + LINEFEED + "}";
        return new ByteArrayInputStream(contents.getBytes());
    }
}