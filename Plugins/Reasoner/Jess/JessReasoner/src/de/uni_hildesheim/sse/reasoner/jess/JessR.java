package de.uni_hildesheim.sse.reasoner.jess;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jess.Fact;
import jess.JessException;
import jess.Rete;
import jess.Value;

import org.osgi.service.component.ComponentContext;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributesCheckVisitor;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ZipUpgrader;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;


/**
 * Class JessR as a reasoning interface. This class contains one public method, isConsistent, 
 * which takes Project and Configuration as arguments and returns a boolean telling the user 
 * if the configuration is valid for the given project.
 * @author saripalli
 *
 */
public class JessR implements IReasoner {

    /**
     * Optimization Case Nr. : 
     * Case 0 : all the variables are passed for reasoning
     * Case 1 : only variables that have constraints are passed. Note : this allows the type definitions, which are 
     *          treated as internal constraints, are also passed.
     * Case 2 : only the variables that have constraints are passed. Note : type definitions, or the internal
     *          constraints are not passed.          
     */
    private static int optimizationCaseNr = 2;
    
    /**
     * To get the type of optimization.
     * @return optimization Casr Nr.
     */
    public static int getOptimizationCaseNr() {
        return optimizationCaseNr;
    }


    private ReasonerDescriptor descriptor;
    private JessVisitor jessVis;
    private List<Message> messageList = new ArrayList<Message>();
    private Map<String, IDatatype> varMap = null;
    private Map<Integer, ModelElement> ruleMapper = new HashMap<Integer, ModelElement>();
    private int key = 1;
    
    
    

    /**
     * Class Constructor.
     */
    public JessR() {
        JessCommons.loadOperators();
        System.out.println("JESSR created");
    }
    
    
    
    
    
    /**
     * Getter for key count.
     * @return key count.
     */
    public int getKey() {
        return key;
    }
    
    /**
     * Setter for key count.
     * @param key key count.
     */
    public void setKey(int key) {
        this.key = key;
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is unstable
        ReasonerFrontend.getInstance().getRegistry().register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is unstable
        ReasonerFrontend.getInstance().getRegistry().unregister(this);
    }
    
     
    /**
     * jessEngine method. This is a private method called from isConsistent method. The main 
     * activity that goes on here is parsing the Jess file (.clp) and retrieving the 
     * <b>getValidation</b> value in the Jess file. <b>getValidation</b> is an indicator 
     * for the satisfiability. Moreover, it also activates Jess custom functions for reasoning over IVML.
     * @param cfg Configuration.
     * @param updateIndicator indicates if an update on the configuration is required.
     * @param result Reasoning result.
     * @throws JessException JessException.
     * @throws IOException IOException.
     * @return ruleFiredCount The number of rules/constraints not satisfied.
     */
    private int jessEngine(Configuration cfg, Boolean updateIndicator, ReasoningResult result)
        throws JessException, IOException {
        System.out.println("license valid? " + JessLicense.isLicenseValid());
        Rete reteEngine = new Rete();
        //loadEngine(reteEngine);

        
        File clpFile = jessVis.getJessCLPFile();
        FileReader file = new FileReader(clpFile);
        int ruleFiredCount = 0;
        try {
            System.out.println(" . . . . . . . . . . . . . .  Begin Looping class. ");
            
            /*
             * Use the Jess controller to run the reasoning (to mitigate looping problems)!
             * Latency for starting the reasoning process  - 2 seconds.            
             */
            JessController jc = new JessController(reteEngine, 2000);
            jc.startReasoning(clpFile.getCanonicalPath());
            
            Rete currentEng = jc.getReteEngine();
            
            Value listValue = currentEng.eval("(getList)");
            @SuppressWarnings("unchecked")
            List<Integer> l = (List<Integer>) listValue.externalAddressValue(currentEng.getGlobalContext());
            List<ModelElement> conflictingConstraints = new ArrayList<ModelElement>();
            for (int i = 0; i < l.size(); i++) {
                conflictingConstraints.add(this.ruleMapper.get(l.get(i)));
            }
            Message mes = new Message("Constraints not satisfied", conflictingConstraints, Status.ERROR);
            if (conflictingConstraints.size() != 0) {
                this.messageList.add(mes);
            }
            Value v = currentEng.eval("(getValidation)");
            System.out.println(" ...... " + currentEng.eval("?*FixedList*").externalAddressValue(currentEng.getGlobalContext()));
            ruleFiredCount = v.intValue(currentEng.getGlobalContext());

            if (updateIndicator) {
                this.configUpdation(currentEng, cfg, result);
            }
            
        } finally {
            file.close();
        }

        // CK: test
        try {
            reteEngine.clear();
        } catch (JessException e) {
            e.printStackTrace();
        }
        
        System.out.print("total rules fired " + ruleFiredCount);
        System.out.println(" . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n");
        return ruleFiredCount; 
    }

    /**
     * Method to update the configuration.
     * @param currentEng Current active rete engine.
     * @param cfg Configuration to update.
     * @param result ReasoningResult
     * @throws JessException Should not occur.
     */
    private void configUpdation(Rete currentEng, Configuration cfg, ReasoningResult result) throws JessException {
        JessFactsVisitor factVisitor = new JessFactsVisitor(currentEng.getGlobalContext(), cfg, result);
        factVisitor.setVarMap(this.varMap);
        if (currentEng.listFacts().hasNext()) {
            ((Fact) currentEng.listFacts().next()).accept(factVisitor);
        }
        factVisitor.processMessages(); 
        
    }

    

    @Override
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        ReasoningResult notSupportedResult = new ReasoningResult("JessReasoner");
        return notSupportedResult;
    }




    @Override
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        EvaluationResult result = new EvaluationResult("JessReasoner");
        
        // TODO implement
        return result;
    }

    @Override
    public ReasoningResult upgrade(URI uri, ProgressObserver observer) {
        Map<String, String> files = new HashMap<String, String>();
        files.put("Jess71p2/lib/jess.jar", "jess.jar");
        files.put("Jess71p2/lib/JessML1_0.xsd", "JessML1_0.xsd");
        files.put("Jess71p2/lib/jsr94.jar", "jsr94.jar");
        ZipUpgrader upgrader = new ZipUpgrader(uri, Activator.getLocation(), files, null, observer);
        return upgrader.upgrade();
    }

    @Override
    public void notify(IReasonerMessage message) {
        // react if reasoners depend on each other
    }

    @Override
    public ReasonerDescriptor getDescriptor() {
        if (null == descriptor) {
            descriptor = new JessReasonerDescriptor();
        }
        return descriptor;
    }
    
    
    @Override
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,  
        ProgressObserver observer) {
        EvaluationResult result = new EvaluationResult("JessReasoner");

        basicModelVisitor(project, cfg, result, true);

        AttributesCheckVisitor.check(cfg, reasonerConfiguration, result);

        return result;
    }


    @Override
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,  
        ProgressObserver observer) {
        ReasoningResult result = new ReasoningResult();
        basicModelVisitor(project, cfg, result, false);
        
        AttributesCheckVisitor.check(cfg, reasonerConfiguration, result);
        
        return result;
    }
    
    
    /**
     * Method to recursively visit the inner project imports.
     * @param project Resolved project.
     */
    private void visitInnerImports(Project project) {
        for (int i = 0; i < project.getImportsCount(); i++) { 
            ProjectImport tempProjectImport = project.getImport(i);
            if (tempProjectImport.getResolved().getImportsCount() != 0) {
                visitInnerImports(tempProjectImport.getResolved());
            }
            tempProjectImport.accept((IModelVisitor) jessVis);
            this.key = jessVis.getKeyCount();
        }
    }

    /**
     * A private method that basically visits the whole model.
     * @param project Project.
     * @param cfg Configuration.
     * @param result result to pass.
     * @param updateIndicator an indicator for updating the configuration.
     */
    private void basicModelVisitor(Project project, Configuration cfg, ReasoningResult result,
            Boolean updateIndicator) {
        long inTime = System.currentTimeMillis();
        jessVis = new JessVisitor();
        
        if (optimizationCaseNr != 0) {
            JessVisitor.setOptimization(true);
            preprocessDeclarations(project);
        } else {
            JessVisitor.setOptimization(false);
        }
        
        project.accept(jessVis);
        
        this.varMap = jessVis.getVariableMap();
        visitInnerImports(project);
        for (int i = 0; i < project.getImportsCount(); i++) { 
            ProjectImport tempProjectImport = project.getImport(i);
            tempProjectImport.accept((IModelVisitor) jessVis);   
            this.key = jessVis.getKeyCount();
        }
        
        java.util.Set<Map.Entry<Integer, ModelElement>> set = jessVis.getRuleMapper().entrySet();
        for (Map.Entry<Integer, ModelElement> itr : set) {
            this.ruleMapper.put(itr.getKey(), itr.getValue());
        }
       
        List<ContainableModelElement> elements = new ArrayList<ContainableModelElement>();
        for (int i = 0; i < project.getElementCount(); i++) {
            jessVis.setKeyCount(key);
            this.ruleMapper.put(new Integer(key), project.getElement(i));
            key++;
            project.getElement(i).accept((IModelVisitor) jessVis);
            elements.add(project.getElement(i));
        }
        for (int j = 0; j < project.getInternalConstraintCount(); j++) {
            jessVis.setKeyCount(key);
            this.ruleMapper.put(new Integer(key), project.getElement(j));
            key++;
            project.getInternalConstraint(j).accept((IModelVisitor) jessVis);
            elements.add(project.getInternalConstraint(j));
        }
        cfg.accept(jessVis);
        long transTime = System.currentTimeMillis();
        System.err.println("Translation time  " + (transTime - inTime) / 1000.0);
        List<ModelElement> conflictingElements = new ArrayList<ModelElement>();
        for (int i = 0; i < jessVis.getNonSupportedRules().size(); i++) {
            conflictingElements.add(this.ruleMapper.get(jessVis.getNonSupportedRules().get(i)));
        }
        if (conflictingElements.size() != 0) {
            result.addMessage(new Message("Constraints not supported", conflictingElements, Status.WARNING));
        }
        int validator = 0; 
        
        try { 
            validator = this.jessEngine(cfg, updateIndicator, result);
            System.out.println("validator " + validator);
            if (validator != 0) {
                System.out.println("Not Satisfiable");
                for (int i = 0; i < this.messageList.size(); i++) {
                    result.addMessage(this.messageList.get(i));
                }
            } else if ((validator == 0) && (result.getMessageCount() == 0)) {
                System.out.println("Satisfiability");
            } 
            
        } catch (JessException e) {
            System.out.println(e.getMessage() + " " + e.getLineNumber() + " " + e.getProgramText());
            result.addMessage(new Message("Jess Error: " + e.getMessage() + "\n CAUSE: " + e.getCause(), 
                    null, Status.ERROR));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.messageList.removeAll(messageList);
        
       
    }
    
    
    /**
     * Method to process declarations.
     * This is where the required optimization takes place. 
     * The aim is to use the declarations that have constraints.
     * The rest are ignored as they speed up the reasoning process.
     * @param project Project.
     */
    @SuppressWarnings("unused")
    private void preprocessDeclarations(Project project) {
        JessVariablesPreProcessor processor = new JessVariablesPreProcessor();
        for (int i = 0; i < project.getImportsCount(); i++) { 
            ProjectImport tempProjectImport = project.getImport(i);
            preprocessDeclarations(tempProjectImport.getResolved());
        }
        
        for (int i = 0; i < project.getElementCount(); i++) {
            if (project.getElement(i) instanceof Constraint) {
                Constraint cons = (Constraint) project.getElement(i);
                cons.getConsSyntax().accept(processor);
            } 
            if (project.getElement(i) instanceof DecisionVariableDeclaration) {
                DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(i);
                if (decl.getDefaultValue() != null) {
                    ConstraintSyntaxTree call = (ConstraintSyntaxTree) decl.getDefaultValue();
                    Variable var = new Variable(decl);
                    OCLFeatureCall valueCall = new OCLFeatureCall(var, OclKeyWords.ASSIGNMENT, call);
                    valueCall.accept(processor);
                }
            }
        }
        if (optimizationCaseNr == 1) {
            for (int i = 0; i < project.getInternalConstraintCount(); i++) {
                project.getInternalConstraint(i).getConsSyntax().accept(processor);
            }
            
        }
        System.out.println("Total used -> " + JessVariablesPreProcessor.getVariablesUsed().size());
        
    }
    



}
