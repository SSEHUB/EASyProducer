package de.uni_hildesheim.sse.persistency.xml;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import loader.IVMLModelLoader;
//import loader.VILModelLoader;
//import loader.VTLModelLoader;
//
//import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
//import org.junit.Test;
//
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
//import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
//import de.uni_hildesheim.sse.model.management.VarModel;
//import de.uni_hildesheim.sse.model.varModel.Project;
//import de.uni_hildesheim.sse.utils.modelManagement.IModel;
//import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
//import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
//import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
//
//public class EasyTest extends AbstractTest {
//    
//    private static File src = new File("C:/Users/runtime-EclipseApplication2/PL_Bla/EASy1");
//
//    
//    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
//    private final File file = new File("easy.xml");
//    private final String[] vtlFilter = {"vtl" };
//    private final String[] vilFilter = {"vil" };
//    private final String[] ivmlFilter = {"ivml" };
//    private final Collection<File> vtlFiles = FileUtils.listFiles(src, vtlFilter, true);
//    private final Collection<File> vilFiles = FileUtils.listFiles(src, vilFilter, true);
//    private final Collection<File> ivmlFiles = FileUtils.listFiles(src, ivmlFilter, true);
//    
//    /**
//     * The directory containing all tests.
//     * 
//     * @return the test data directory
//     */
//    protected File getTestDataDir() {
//        return src;
//    }
//    
//    /**
//     * Test if the whole QM2 model can be serialized.
//     */
//    @Test
//    public void testWriteQM2() {
//        List<IModel> modelList = new ArrayList<IModel>();
//        for (File file : ivmlFiles) {
//            String pattern = "(_\\d)*.ivml";
//            String fileName = file.getName().replaceAll(pattern, "");
//            List<ModelInfo<Project>> list = VarModel.INSTANCE.availableModels().getModelInfo(fileName);
//            ModelInfo<Project> model = list.get(0);
//            try {
//                VarModel.INSTANCE.load(model);
//                Project project = model.getResolved();
//                modelList.add(project);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//            }
//        }
//        for (File file : vtlFiles) {
//            String fileName = file.getName().replace(".vtl", "");
//            List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
//            ModelInfo<Template> model = list.get(0);
//            try {
//                TemplateModel.INSTANCE.load(model);
//                Template template = model.getResolved();
//                modelList.add(template);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//            }
//        }
//        for (File file : vilFiles) {
//            String pattern = "(_\\d)*.vil";
//            String fileName = file.getName().replaceAll(pattern, "");
//            List<ModelInfo<Script>> list = BuildModel.INSTANCE.availableModels().getModelInfo(fileName);
//            ModelInfo<Script> model = list.get(0);
//            try {
//                BuildModel.INSTANCE.load(model);
//                Script script = model.getResolved();
//                modelList.add(script);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//            }
//        }
//        FileOutputStream out;
//        try {
//            out = new FileOutputStream(file);
//            XmlIo.write(modelList, out);
//        } catch (FileNotFoundException e) {
//            logger.exception(e);
//        }
//    }
//    
//    @Test
//    public void testEasy() {
//        try {
//            BuiltIn.initialize();
//            VarModel.INSTANCE.loaders().registerLoader(new IVMLModelLoader(), OBSERVER);
//            VarModel.INSTANCE.locations().addLocation(file, OBSERVER);
//            System.out.println("############ END OF IVML ############");
//            for (File file : ivmlFiles) {
//                String pattern = "(_\\d)*.ivml";
//                String fileName = file.getName().replaceAll(pattern, "");
//                List<ModelInfo<Project>> list = VarModel.INSTANCE.availableModels().getModelInfo(fileName);
//                Assert.assertEquals(true, list != null);
//                ModelInfo<Project> model = list.get(0);
//                try {
//                    VarModel.INSTANCE.load(model);
//                } catch (ModelManagementException e) {
//                    logger.exception(e);
//                }
//            }
//            BuildModel.INSTANCE.loaders().registerLoader(new VILModelLoader(), OBSERVER);
//            BuildModel.INSTANCE.locations().addLocation(file, OBSERVER);
//            System.out.println("############ END OF VIL ############");
//            TemplateModel.INSTANCE.loaders().registerLoader(new VTLModelLoader(), OBSERVER);
//            TemplateModel.INSTANCE.locations().addLocation(file, OBSERVER);
//        } catch (ModelManagementException e1) {
//            logger.exception(e1);
//        }
//        for (File file : vilFiles) {
//            String pattern = "(_\\d)*.vil";
//            String fileName = file.getName().replaceAll(pattern, "");
//            List<ModelInfo<Script>> list = BuildModel.INSTANCE.availableModels().getModelInfo(fileName);
//            Assert.assertEquals(true, list != null);
//            ModelInfo<Script> model = list.get(0);
//            try {
//                BuildModel.INSTANCE.load(model);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//            }
////            sysoutScript(model);
//        }
//        for (File file : vtlFiles) {
//            String fileName = file.getName().replace(".vtl", "");
//            List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
//            if (list == null) {
//                System.out.println(fileName);
//            }
//            Assert.assertEquals(true, list != null);
//            ModelInfo<Template> model = list.get(0);
//            try {
//                TemplateModel.INSTANCE.load(model);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//            }
//        }
//        // execute
//        try {
//            ProjectDescriptor source = new ProjectDescriptor("easy.xml", "PL_Bla");
//            ProjectDescriptor target = new ProjectDescriptor(source, file);
//            Executor executor = new Executor(source.getMainVilScript()).addSource(source).addTarget(target)
//                    .addConfiguration(source.getConfiguration("PL_Bla"));
//            executor.execute();
//        } catch (ModelManagementException e) {
//            logger.exception(e);
//            e.printStackTrace();
//        } catch (VilLanguageException e) {
//            logger.exception(e);
//            e.printStackTrace();
//        }
//    }
//}
