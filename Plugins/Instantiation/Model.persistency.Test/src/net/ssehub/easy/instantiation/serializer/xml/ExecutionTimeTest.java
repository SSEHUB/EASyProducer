package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;
import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.BuiltIn;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.serializer.xml.loader.IVMLModelLoader;
import net.ssehub.easy.instantiation.serializer.xml.loader.VILModelLoader;
import net.ssehub.easy.instantiation.serializer.xml.loader.VTLModelLoader;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

public class ExecutionTimeTest extends AbstractUtil {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    private static final int NUMBER_OF_RUNS = 20;

    private static final File VIL = new File(XMLDATA, "qm2.xml");
    
    private final static File dumpFile = new File("C:/Users/punkid/Desktop/dump");

    private final String[] vtlFilter = {"vtl" };

    private final String[] vilFilter = {"vil" };

    private final String[] ivmlFilter = {"ivml" };
    
    private final Collection<File> vtlFiles = FileUtils.listFiles(MODELDATA, vtlFilter, true);

    private final Collection<File> vilFiles = FileUtils.listFiles(MODELDATA, vilFilter, true);

    private final Collection<File> ivmlFiles = FileUtils.listFiles(MODELDATA, ivmlFilter, true);
    
    

    /**
     * Load properties and register types.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        if (dumpFile.exists()) {
            try {
                FileUtils.cleanDirectory(dumpFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        clear();
    }

    @Test
    public void testReadFromXMLTime() {
        runNewDeserializer(NUMBER_OF_RUNS);
    }
    
    @Test
    public void testFromModel() {
        runOldDeserializer(NUMBER_OF_RUNS);
    }

    private void loadProject() {
        // Is the model fully loaded?
        List<ModelInfo<Project>> list = VarModel.INSTANCE.availableModels().getModelInfo("QM");
        if (null != list && !list.isEmpty()) {
            ModelInfo<Project> info = list.get(0);
            if (null != info) {
                Project project = info.getResolved();
                if (null == project) {
                    Assert.fail("Project not loaded");
                }
            } else {
                Assert.fail("Model not found");
            }
        } else {
            Assert.fail("List is empty");
        }
    }

    private void runNewDeserializer(int numberOfRuns) {
        int average = 0;
        long averageUsedMemory = 0;
        for (int i = 1; i <= numberOfRuns; i++) {
            long startTime = System.currentTimeMillis();
            ModelDeserializer.deserializeModel(VIL);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(i + "\t" + elapsedTime + "\t" + memoryUsage());
            average += elapsedTime;
            averageUsedMemory += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            if (i == numberOfRuns) {
                loadProject();
            }
            File file = new File(dumpFile, String.valueOf(i) + ".bin");
            HeapDumper.dumpHeap(file.getAbsolutePath(), false);
            clear();
        }
        NumberFormat format = NumberFormat.getInstance();
        System.out.println("Average (new way): " + average / numberOfRuns + "ms and an average memory usage of " 
            + format.format((averageUsedMemory / 1024) / numberOfRuns));
        System.out.println();
    }

    private String memoryUsage() {
        NumberFormat format = NumberFormat.getInstance();
        Runtime runtime = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        sb.append(format.format(usedMemory / 1024) + "\t");
        sb.append(format.format(freeMemory / 1024) + "\t");
        sb.append(format.format(totalMemory / 1024) + "\t");
        sb.append(format.format(maxMemory / 1024) + "\t");
        sb.append(format.format((freeMemory + (maxMemory - totalMemory)) / 1024) + "\t");
        return sb.toString();
    }

    private void runOldDeserializer(int numberOfRuns) {
        if (!Environment.runsInEclipse()) {
            Registration.register();
            BuiltIn.initialize();
            ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
            ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
            net.ssehub.easy.instantiation.maven.Registration.register();
        }
        int average = 0;
        long averageUsedMemory = 0;
        for (int i = 1; i <= numberOfRuns; i++) {
            long startTime = System.currentTimeMillis();
            try {
                VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
                BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
                TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
                VarModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
                BuildModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
                TemplateModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail(e.getMessage());
            }
            // Load IVML
            for (File file : ivmlFiles) {
                ModelInfo<Project> project = VarModel.INSTANCE.availableModels().getInfo(file.toURI());
                try {
                    VarModel.INSTANCE.load(project);
                } catch (ModelManagementException e) {
                    Assert.fail(e.getMessage());
                }
            }
            // Load VTL
            for (File file : vtlFiles) {
                ModelInfo<Template> template = TemplateModel.INSTANCE.availableModels().getInfo(file.toURI());
                try {
                    TemplateModel.INSTANCE.load(template);
                } catch (ModelManagementException e) {
                    Assert.fail(e.getMessage());
                }
            }
            // Load VIL
            for (File file : vilFiles) {
                ModelInfo<Script> script = BuildModel.INSTANCE.availableModels().getInfo(file.toURI());
                try {
                    BuildModel.INSTANCE.load(script);
                } catch (ModelManagementException e) {
                    Assert.fail(e.getMessage());
                }
            }
            
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(i + "\t" + elapsedTime + "\t" + memoryUsage());
            average += elapsedTime;
            averageUsedMemory += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            if (i == numberOfRuns) {
                loadProject();
            }
            clear();
        }
        NumberFormat format = NumberFormat.getInstance();
        System.out.println("Average (old way): " + average / numberOfRuns + "ms and an average memory usage of " 
            + format.format((averageUsedMemory / 1024) / numberOfRuns));
        System.out.println();
    }

    private static void clear() {
        if (!Environment.runsInEclipse()) {
            loadProperties();
            Registration.register();
            BuiltIn.initialize();
            net.ssehub.easy.instantiation.maven.Registration.register();
        }
        // Remove all possible locations
        int locationCount = VarModel.INSTANCE.locations().getLocationCount();
        for (int i = 0; i < locationCount; i++) {
            try {
                File varModelLocation = VarModel.INSTANCE.locations().getLocation(i).getLocation();
                File buildModelLocation = BuildModel.INSTANCE.locations().getLocation(i).getLocation();
                File tempModelLocation = TemplateModel.INSTANCE.locations().getLocation(i).getLocation();
                VarModel.INSTANCE.locations().removeLocation(varModelLocation, OBSERVER);
                BuildModel.INSTANCE.locations().removeLocation(buildModelLocation, OBSERVER);
                TemplateModel.INSTANCE.locations().removeLocation(tempModelLocation, OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail(e.getMessage());
            }
        }
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
        BuildModel.INSTANCE.loaders().unregisterLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
        TemplateModel.INSTANCE.loaders().unregisterLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
        VarModel.INSTANCE.loaders().unregisterLoader(IVMLModelLoader.INSTANCE, OBSERVER);
        BuildModel.INSTANCE.loaders().unregisterLoader(VILModelLoader.INSTANCE, OBSERVER);
        TemplateModel.INSTANCE.loaders().unregisterLoader(VTLModelLoader.INSTANCE, OBSERVER);
        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
    }

}
