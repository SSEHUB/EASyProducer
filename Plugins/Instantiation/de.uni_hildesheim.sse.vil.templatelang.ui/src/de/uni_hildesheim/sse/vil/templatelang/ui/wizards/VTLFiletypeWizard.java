package de.uni_hildesheim.sse.vil.templatelang.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.ssehub.easy.dslCore.ui.wizards.AbstractFiletypeWizard;

/**
 * This is a sample new wizard. Its role is to create a new file resource in the
 * provided container. If the container resource (a folder or a project) is
 * selected in the workspace when the wizard is opened, it will accept it as the
 * target container. The wizard creates one file with the extension "vtl". If a
 * sample multi-page editor (also available as a template) is registered for the
 * same extension, it will be able to open it.
 * 
 * @author El-Sharkawy
 */

public class VTLFiletypeWizard extends AbstractFiletypeWizard {
    /**
     * Default parameters for the complete template as well as for the main method.
     * Also includes opening parenthesis and line feed. 
     */
    private static final String DEFAULT_PARAMETERS = "(Configuration config, FileArtifact target) {" + LINEFEED;

    /**
     * Sole Constructor for VTLFiletypeWizard.
     */
    public VTLFiletypeWizard() {
        super(new VTLPageCreator(), "de.uni_hildesheim.sse.vil.templatelang.ui");
    }

    @Override
    protected InputStream openContentStream(String fileName) {
        String contents = "template " + fileName + DEFAULT_PARAMETERS
            + LINEFEED
            + INDENTION + "def main" + DEFAULT_PARAMETERS
            + INDENTION + LINEFEED
            + INDENTION + "}" + LINEFEED
            + LINEFEED
            + "}";
        return new ByteArrayInputStream(contents.getBytes());
    }
}