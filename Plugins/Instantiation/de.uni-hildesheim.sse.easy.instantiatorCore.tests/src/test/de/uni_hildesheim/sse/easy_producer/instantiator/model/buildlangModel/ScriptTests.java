package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;

/**
 * Some tests for build language scripts using the model API.
 * 
 * @author Holger Eichelberger
 */
public class ScriptTests extends AbstractTest {
    
    /**
     * Tests versioned scripts.
     */
    @Test
    public void testVersion() {
        String scriptName = "script";
        String impName = "script";

        Version version = null;
        try {
            version = new Version("1.0");
        } catch (VersionFormatException e) {
            Assert.fail("version shall be correct: " + e.getMessage());
        }
        VersionRestriction[] vr = {new VersionRestriction(impName, Operator.EQUALS, version)};
        List<ModelImport<Script>> imps = new ArrayList<ModelImport<Script>>();
        imps.add(new ModelImport<Script>(impName, false, vr));
        Imports imports = new Imports(imps, null);
        ScriptDescriptor desc = new ScriptDescriptor(null, null, imports);
        Script script = new Script(scriptName, null, desc, TypeRegistry.DEFAULT);
        Assert.assertNotNull("script shall be there", script);
        StringWriter sWriter = new StringWriter();
        BuildlangWriter writer = new BuildlangWriter(sWriter);
        writer.setIndentation(""); // simplifies comparison later
        try {
            script.accept(writer);
        } catch (VilLanguageException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        // IVML test style
        String model = sWriter.toString();
        model = model.replace("\n", ""); // skip newlines
        model = model.replace("\r", ""); // skip returns
        String expected = "import script with (version == v1.0);vilScript script () {}";
        Assert.assertEquals("model comparison fails:", model, expected);
    }

}
