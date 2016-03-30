package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;
import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.BuiltIn;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangExecution;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionParserRegistry;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateLangExecution;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.serializer.xml.Registration;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * The refined version of abstract tests for the build language.
 * 
 * @author Sass
 * 
 */
public abstract class AbstractTest extends AbstractUtil {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    /**
     * Creates and initializes an abstract test.
     */
    protected AbstractTest() {

    }

    /**
     * Set up before class. Register loaders and add locations.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        if (!Environment.runsInEclipse()) {
            Registration.register();
            BuiltIn.initialize();
            ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
            ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
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
        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
        // Check loaders
//        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
        try {
            // Register loader
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(MODELDATA, OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        // Check loaders and locations
        Assert.assertEquals(1, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.locations().getLocationCount());
    }

    /**
     * Tear down after class. Unregister loaders and remove locations.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        Assert.assertEquals(1, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(1, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(1, TemplateModel.INSTANCE.locations().getLocationCount());
        VarModel.INSTANCE.loaders().unregisterLoader(ModelUtility.INSTANCE, OBSERVER);
        BuildModel.INSTANCE.loaders().unregisterLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
        TemplateModel.INSTANCE.loaders().unregisterLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
        try {
            VarModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
            BuildModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
            TemplateModel.INSTANCE.locations().removeLocation(MODELDATA, OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
    }

}
