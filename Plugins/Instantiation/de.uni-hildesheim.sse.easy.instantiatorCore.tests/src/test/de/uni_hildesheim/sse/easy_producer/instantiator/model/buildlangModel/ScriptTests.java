package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionVersionRestriction;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.RestrictionEvaluationException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

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
        List<ModelImport<Script>> imps = new ArrayList<ModelImport<Script>>();
        try {
            VariableDeclaration decl = new VariableDeclaration("version", TypeRegistry.versionType());
            Expression expr = ExpressionVersionRestriction.createSingleRestriction(decl, 
                IvmlKeyWords.EQUALS, version);
            imps.add(new ModelImport<Script>(impName, false, new ExpressionVersionRestriction(expr, decl)));
        } catch (RestrictionEvaluationException e) {
            Assert.fail(e.getMessage());
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        
        Imports<Script> imports = new Imports<Script>(imps, null);
        ScriptDescriptor<Script> desc = new ScriptDescriptor<Script>(null, null, imports);
        Script script = new Script(scriptName, null, desc, getRegistry());
        Assert.assertNotNull("script shall be there", script);
        StringWriter sWriter = new StringWriter();
        BuildlangWriter writer = new BuildlangWriter(sWriter);
        writer.setIndentation(""); // simplifies comparison later
        try {
            script.accept(writer);
        } catch (VilException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        // IVML test style
        String model = sWriter.toString();
        model = model.replace("\n", ""); // skip newlines
        model = model.replace("\r", ""); // skip returns
        String expected = "import script with version == v1.0;vilScript script () {}";
        Assert.assertEquals("model comparison fails:", model, expected);
    }

}
