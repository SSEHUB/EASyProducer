package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;
import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.BuiltIn;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.serializer.xml.Extensions;
import net.ssehub.easy.instantiation.serializer.xml.ISerializerPlugin;
import net.ssehub.easy.instantiation.serializer.xml.ModelSerializer;
import net.ssehub.easy.instantiation.serializer.xml.Registration;
import net.ssehub.easy.instantiation.serializer.xml.XmlIo;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

// TODO: Über alle tests im workspace iterieren und serializieren.

/**
 * Test if the whole QM2 model can be serialized.
 * 
 * @author Sass
 * 
 */
public class SerializeQM2ModelTest extends AbstractUtil {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    private static final File VIL = new File(TEMPDATA, "qm2.xml");
    
    private static final File IVML = new File(TEMPDATA, "qm2ivml.xml");
    
    private static final File APPLY = new File(XMLDATA, "apply");
    
    private static final File APPLY_XML = new File(TEMPDATA, "apply.xml");

    private final String[] vtlFilter = {"vtl" };

    private final String[] vilFilter = {"vil" };

    private final String[] ivmlFilter = {"ivml" };

    private final Collection<File> vtlFiles = FileUtils.listFiles(MODELDATA, vtlFilter, true);

    private final Collection<File> vilFiles = FileUtils.listFiles(MODELDATA, vilFilter, true);

    private final Collection<File> ivmlFiles = FileUtils.listFiles(MODELDATA, ivmlFilter, true);
    
    private static List<ISerializerPlugin<?>> registeredPluginsBackup;

    /**
     * Delete XML file.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        deleteTmpDir();
        TEMPDATA.mkdir();
        if (!Environment.runsInEclipse()) {
            Registration.register();
            BuiltIn.initialize();
            ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
            ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
            net.ssehub.easy.instantiation.maven.Registration.register();
        }
        try {
            Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
            Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
            Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            Assert.assertEquals(1, VarModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(1, BuildModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(1, TemplateModel.INSTANCE.loaders().getLoaderCount());
            Assert.assertEquals(1, VarModel.INSTANCE.locations().getLocationCount());
            Assert.assertEquals(1, BuildModel.INSTANCE.locations().getLocationCount());
            Assert.assertEquals(1, TemplateModel.INSTANCE.locations().getLocationCount());
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        // Unregister all Extensions, registered via descriptive services
        if (Environment.runsInEclipse()) {
            registeredPluginsBackup = new ArrayList<ISerializerPlugin<?>>();
            Iterator<ISerializerPlugin<?>> registeredPluginsIterator = Extensions.getPluginList().iterator();
            while (registeredPluginsIterator.hasNext()) {
                ISerializerPlugin<?> registeredPlugin = registeredPluginsIterator.next();
                if (null != registeredPlugin) {
                    registeredPluginsBackup.add(registeredPlugin);
                    registeredPluginsIterator.remove();
                }
            }
        }
    }

    private static void deleteTmpDir() {
        if (TEMPDATA.exists()) {
            try {
                FileUtils.deleteDirectory(TEMPDATA);
            } catch (IOException e) {
                Assert.fail("Could not cleanup temp data directory: " + TEMPDATA.getAbsolutePath());
            }
        }
    }
    
    /**
     * Clean up: unregister loader and remove locations.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        Assert.assertEquals(1, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.locations().getLocationCount());
        // Remove locations
        try {
            VarModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
            BuildModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
            TemplateModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        // Unregister Loader
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
        BuildModel.INSTANCE.loaders().unregisterLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
        TemplateModel.INSTANCE.loaders().unregisterLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
        // Check if all loaders and locations were removed
        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
        // Re-register all Extensions, registered via descriptive services
        if (Environment.runsInEclipse()) {
            if (null != registeredPluginsBackup) {
                for (int i = 0; i < registeredPluginsBackup.size(); i++) {
                    Extensions.register(registeredPluginsBackup.get(i));
                }
            }
        }
    }
 
    /**
     * Calls the test methods. Write must be called before read to insure that the XMl files are created.
     */
    @Test
    public void testReadWrite() {
        assertWriteQM2();
        assertReadQM2();
    }

    /**
     * Test if the whole QM2 model can be serialized.
     */
    private void assertWriteQM2() {
        // Test precondition: xml files must not exist
        Assert.assertFalse("File does exist: " + VIL.getAbsolutePath(), VIL.exists());
        Assert.assertFalse("File does exist: " + IVML.getAbsolutePath(), IVML.exists());
        ModelSerializer.serializeModel(MODELDATA.toPath(), VIL.toPath());
        // Test postcondition: xml files must exist
        Assert.assertTrue("File does not exist: " + VIL.getAbsolutePath(), VIL.exists());
        Assert.assertTrue("File does not exist: " + IVML.getAbsolutePath(), IVML.exists());
    }

    /**
     * Test if the QM2 model can be loaded from a XML file and if the result is the same as if the model was loaded from
     * the file system.
     */
    private void assertReadQM2() {
        int countFiles = vilFiles.size() + vtlFiles.size();
        try {
            Assert.assertTrue("File does not exist: " + IVML.getAbsolutePath(), IVML.exists());
            List<IModel> ivmlList = XmlIo.read(IVML, true);
            Assert.assertEquals(ivmlFiles.size(), ivmlList.size());
            for (IModel xmlModel : ivmlList) {
                String filename = xmlModel.getName();
                Project xmlProject = (Project) xmlModel;
                List<ModelInfo<Project>> list1 = VarModel.INSTANCE.availableModels().getModelInfo(filename);
                ModelInfo<Project> model = list1.get(0);
                Project project = model.getResolved();
                String xmlProjectAsString;
                try {
                    xmlProjectAsString = toIVMLString(xmlProject);
                    String projectAsString = toIVMLString(project);
                    Assert.assertEquals(projectAsString, xmlProjectAsString);
                } catch (VilException e) {
                    Assert.fail(e.getMessage());
                }
            }
            // read vtl and vil model from XML
            List<IModel> list = XmlIo.read(VIL, false);
            List<File> tmp = new ArrayList<File>();
            tmp.addAll(vilFiles);
            tmp.addAll(vtlFiles);
            for (IModel iModel : list) {
                String fileName = iModel.getName();
                // Check if Template output is the same after reading from XML
                if (iModel instanceof Template) {
                    Template template1 = (Template) iModel;
                    List<ModelInfo<Template>> list1 = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
                    ModelInfo<Template> model = list1.get(0);
                    Template template = model.getResolved();
                    try {
                        String template1AsString = toVtlString(template1);
                        String templateAsString = toVtlString(template);
                        Assert.assertEquals(templateAsString, template1AsString);
                    } catch (VilException e) {
                        Assert.fail(e.getMessage());
                    }
                }
                // Check if Script output is the same after reading from XML
                if (iModel instanceof Script) {
                    try {
                        checkScriptEquality(iModel, fileName);
                    } catch (VilException e) {
                        Assert.fail(e.getMessage());
                    }
                }
            }
            Assert.assertEquals(countFiles, list.size());
        } catch (FileNotFoundException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Checks a script for equality.
     * 
     * @param iModel    the loaded model from the XML file
     * @param fileName  name of the model
     * @throws VilException in case something goes wrong
     */
    private void checkScriptEquality(IModel iModel, String fileName) throws VilException {
//        if (iModel instanceof de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script) {
//            de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script script1 = 
//                (de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script) iModel;
//            List<ModelInfo<de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script>> list1 =
//                    RtVilModel.INSTANCE.availableModels().getModelInfo(fileName);
//            ModelInfo<de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script> model = list1
//                    .get(0);
//            de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script script = 
//                (de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script) model
//                .getResolved();
//            String scriptAsString = toVilString(script);
//            String script1AsString = toVilString(script1);
//            Assert.assertEquals(scriptAsString, script1AsString);
//        } else {
            Script script1 = (Script) iModel;
            List<ModelInfo<Script>> list1 = BuildModel.INSTANCE.availableModels()
                    .getModelInfo(fileName);
            ModelInfo<Script> model = list1.get(0);
            Script script = (Script) model.getResolved();
            String scriptAsString = toVilString(script);
            String script1AsString = toVilString(script1);
            Assert.assertEquals(scriptAsString, script1AsString);
//        }
    }
    
    @Test
    public void testApplyVilScript() {
        deleteTmpDir();
        TEMPDATA.mkdir();
        // Write
        Assert.assertFalse("File does exist: " + APPLY_XML.getAbsolutePath(), APPLY_XML.exists());
        ModelSerializer.serializeModel(APPLY.toPath(), APPLY_XML.toPath());
        // Test postcondition: xml files must exist
        Assert.assertTrue("File does not exist: " + APPLY_XML.getAbsolutePath(), APPLY_XML.exists());
        // Read
        try {
            List<IModel> list = XmlIo.read(APPLY_XML, false);
            for (IModel iModel : list) {
                String fileName = iModel.getName();
                // Check if Script output is the same after reading from XML
                if (iModel instanceof Script) {
                    try {
                        checkScriptEquality(iModel, fileName);
                    } catch (VilException e) {
                        Assert.fail(e.getMessage());
                    }
                }
            }
        } catch (IOException e1) {
            Assert.fail(e1.getMessage());
        }
        
    }
}
