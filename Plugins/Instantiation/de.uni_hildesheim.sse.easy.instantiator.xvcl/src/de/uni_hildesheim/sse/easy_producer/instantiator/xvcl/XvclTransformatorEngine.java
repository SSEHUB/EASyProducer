package de.uni_hildesheim.sse.easy_producer.instantiator.xvcl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorEngine;
import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import edu.xvcl.core.api.XVCLException;
import edu.xvcl.core.util.XVCLProcessor;

/**
 * The XVCL transformator engine implementation.
 * 
 * @author bullerts
 * @author gawenda
 * @author kapeluch
 */
public class XvclTransformatorEngine extends InstantiatorEngine {

    private static final String SPCNAME = "0spc";
    private static final String FILETYPE = ".xvcl";
    private XVCLProcessor xvcl;
    private String repositoryPath;
    private String targetProjectName;
    private String space = System.getProperty("file.separator");
    private StringBuffer context = new StringBuffer();

    public XvclTransformatorEngine() {
        // required by DS
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.addEngine(this);
        TypeRegistry.DEFAULT.register(XVCLInstantiator.class);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        Transformator.removeEngine(this);
    }
    
    @Override
    protected void initEngine() {
        targetProjectName = getPLP().getProjectName();
        repositoryPath = getPredecessorPath();
        xvcl = new XVCLProcessor();
    }
    
    @Override
    public void instantiate() throws InstantiatorException {
        String specFile = repositoryPath + space + SPCNAME + FILETYPE;
        String[] args = {specFile};
        createSpecFile();
        
        try {
            xvcl.process(args, true, true, false);
            xvcl.clearCache();
            
            // remove all .xvcl files after instantiation
            for (File f : getFilesToInstantiate()) {
                if (f.getName().endsWith(FILETYPE)) {
                    f.delete();
                }
            }
            // remove spec
            File f = new File(repositoryPath + space + SPCNAME + FILETYPE);
            f.delete();
            f = new File(repositoryPath + space + SPCNAME);
            f.delete();
            

        } catch (XVCLException e) {
            throw new InstantiatorException(e.getLocalizedMessage());
        }
    }
    
    /**
     * Instantiates the given XVCL specification file via VIL.
     * @param specification The stating point for instantiation with XVCL.
     * @throws InstantiatorException If XVCL detects any errors.
     */
    void instantiate(FileArtifact specification) throws InstantiatorException {
        xvcl = new XVCLProcessor();
        String[] args = null;
        if (null != specification && null != specification.getPath()) {
            File specFile = specification.getPath().getAbsolutePath();
            if (null != specFile && null != specFile.getAbsolutePath()) {
                args = new String[]{specFile.getAbsolutePath()};
            }
        }
        
        // Critical: If xvcl detects any errors, it will call System.exit(1) and close the whole jVM.
        if (null != args && args.length > 0) {
            try {
                xvcl.process(args, true, true, false);
                xvcl.clearCache();
                System.out.println(xvcl.getVersion());
    
            } catch (XVCLException e) {
                throw new InstantiatorException(e.getLocalizedMessage());
            }
        }
        
        clearContext();
        xvcl = null;
    }
    
    @Override
    protected void addValue2Context(IDecisionVariable variable) {
        AbstractVariable declaration = variable.getDeclaration();
        Value value = variable.getValue();
        context.append(buildVar(declaration.getName(), value.getValue().toString()));
    }

    @Override
    protected void clearContext() {
        context = new StringBuffer();
    }
    
    /**
     * This method creates the xvcl specification file for the instantiation.
     */
    private void createSpecFile() {
        
        Writer fw = null;
        try {
            fw = new FileWriter(repositoryPath + space + SPCNAME + FILETYPE);
            fw.write(getSpec());
        } catch (IOException e) {
            System.err.println("File creation error.");
        } finally {
            if (fw != null) {
                try {
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    /**
     * Returns the contents of the xvcl specification.
     * @return  xvcl specification as string
     */
    private String getSpec() {
        StringBuffer spec = new StringBuffer();
        spec.append("<?xml version=\"1.0\"?>\n");
        spec.append("<!DOCTYPE x-frame SYSTEM>\n");
        spec.append("<x-frame name=\"" + SPCNAME + FILETYPE + "\">\n");
        
        spec.append(buildVar("dir", repositoryPath + space + "src" + space));
        spec.append(buildVar("out", "bin" + space + targetProjectName + space));
        
        // create <adapt>-tag for each file to instantiate 
        for (File file : getFilesToInstantiate()) {
            if (file.getName().endsWith(FILETYPE)) {
                String infile = file.getPath();
                String outfile = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.'));
                context.append("<adapt x-frame=\"" + infile + "\" outfile=\"" + outfile + ".java\" />\n");
            }
        }
        
        spec.append(context.toString());
        spec.append(" </x-frame>");
        
        return spec.toString();
    }
    
    /**
     * Constructs and returns a XVCL tag, which defines a variable.
     * @param name  The name of the variable
     * @param value     The value of the variable
     * @return      XVCL tag as string
     */
    private String buildVar(String name, String value) {
        return "<set var=\"" + name + "\" value=\"" + value + "\" />\n";
    }


}