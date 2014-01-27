package de.uni_hildesheim.sse.reasoning.drools;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult.ConstraintEvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult.EvaluationPair;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Class for evaluation of a set of constraints.
 * 
 * @author Phani
 * 
 */
public class DroolsEvaluation implements IConstraintTreeVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");

    private DroolsVisitor droolsVisitor;
    private int key = 1;
    private Map<Integer, ModelElement> ruleMapper = new HashMap<Integer, ModelElement>();
    private boolean acceptConstraint = false;
    private List<Integer> cList = new ArrayList<Integer>();
    // private List<Message> messageList = new ArrayList<Message>();
    private int evaluationStartIndex = 0;

    /**
     * This method evaluates a project, configuration with a set of constraints.
     * 
     * @param project
     *            Project.
     * @param cfg
     *            Configuration.
     * @param constraints
     *            list of constraints to be evaluated.
     * @param reasonerConfig
     *            reasoner configuration.
     * @param observer
     *            Progress Observer.
     * @return Result of the reasoning process.
     */

    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints,
            ReasonerConfiguration reasonerConfig, ProgressObserver observer) {
        DroolsVisitor.setOptimize(false);
        DroolsOperations.loadOperators();
        DroolsOperations.createDroolsOperators();
        EvaluationResult result = new EvaluationResult();
        logger.info("Checking ... ");
        droolsVisitor = new DroolsVisitor();
        droolsVisitor.setEvaluationChecking(true);
        project.accept(droolsVisitor);

        for (int i = 0; i < project.getImportsCount(); i++) {
            ProjectImport tempProjectImport = project.getImport(i);
            tempProjectImport.accept((IModelVisitor) droolsVisitor);
            this.key = droolsVisitor.getRuleCount();
        }

        java.util.Set<Map.Entry<Integer, ModelElement>> set = droolsVisitor.getRuleMapper().entrySet();
        for (Map.Entry<Integer, ModelElement> itr : set) {
            this.ruleMapper.put(itr.getKey(), itr.getValue());
        }

        for (int i = 0; i < project.getElementCount(); i++) {
            droolsVisitor.setRuleCount(key);
            this.ruleMapper.put(new Integer(key), project.getElement(i));
            key++;
            if (project.getElement(i) instanceof Constraint) {
                Constraint cons = (Constraint) project.getElement(i);
                cons.getConsSyntax().accept(this);
                if (acceptConstraint) {
                    project.getElement(i).accept((IModelVisitor) droolsVisitor);
                    acceptConstraint = false;
                }
            } else {
                project.getElement(i).accept((IModelVisitor) droolsVisitor);
            }
        }

        for (int j = 0; j < project.getInternalConstraintCount(); j++) {
            droolsVisitor.setRuleCount(key);
            this.ruleMapper.put(new Integer(key), project.getElement(j));
            key++;
            project.getInternalConstraint(j).accept((IModelVisitor) droolsVisitor);
        }
        evaluationStartIndex = key;
        droolsVisitor.setEvaluationCalls(true);
        if (null != constraints) {
            logger.info("evaluation constraints are " + constraints.size());
            for (int j = 0; j < constraints.size(); j++) {
                droolsVisitor.setRuleCount(key);
                this.ruleMapper.put(new Integer(key), constraints.get(j));
                key++;
                constraints.get(j).accept((IModelVisitor) droolsVisitor);
            }
        }

        cfg.accept(droolsVisitor);
        instantiateKnowledgeBase(project, result);

        return result;
    }

    // checkstyle: stop exception type check
    /**
     * Method to instantiate drools knowledge base.
     * 
     * @param project
     *            Project.
     * @param result
     *            Reasoning result.
     */
    @SuppressWarnings("unchecked")
    private void instantiateKnowledgeBase(Project project, EvaluationResult result) {
        try {
            KnowledgeBase kbase = readKnowledgeBase(droolsVisitor.getFilePath());
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            String packageName = this.getClass().getPackage().getName();
            addGlobals(ksession);
            FactType fact = kbase.getFactType(packageName, "Project");
            Object projIns = fact.newInstance();

            ksession.insert(projIns);

            int nu = DroolsVisitor.getTotalDecls();
            if ((nu / DroolsVisitor.THRESHOLD) == 0) {
                FactType fact1 = kbase.getFactType(packageName, "Project0");
                Object projIns1 = fact1.newInstance();
                ksession.insert(projIns1);
            } else {
                for (int i = 0; i <= (nu / DroolsVisitor.THRESHOLD); i++) {
                    FactType fact1 = kbase.getFactType(packageName, "Project" + i);
                    if (fact1 != null) {
                        Object projIns1 = fact1.newInstance();
                        ksession.insert(projIns1);
                    }
                }
            }

            ksession.getAgenda().getAgendaGroup("Group Config").setFocus();
            ksession.fireAllRules();
            ksession.getAgenda().getAgendaGroup("Fact Config").setFocus();
            ksession.fireAllRules();
            ksession.getAgenda().getAgendaGroup("Group 0").setFocus();
            ksession.fireAllRules();
            ksession.getAgenda().getAgendaGroup("Group 1").setFocus();
            ksession.fireAllRules();
            ksession.getAgenda().getAgendaGroup("Group 2").setFocus();
            ksession.fireAllRules();
            logger.info("fact count " + ksession.getFactCount() + " " + ksession.getFactHandle(projIns));

            cList = (ArrayList<Integer>) ksession.getGlobal("cList");

            int totalKeys = ruleMapper.keySet().size();
            for (int in = evaluationStartIndex; in <= totalKeys; in++) {
                Constraint cons = (Constraint) this.ruleMapper.get(in);
                // logger.info("index  " + in + ".. " +
                // cList.contains(in));
                if (cList.contains(in)) {
                    EvaluationPair ePair = new EvaluationPair(cons, ConstraintEvaluationResult.FALSE);
                    result.addEvaluationPair(ePair);
                } else {
                    EvaluationPair ePair = new EvaluationPair(cons, ConstraintEvaluationResult.TRUE);
                    result.addEvaluationPair(ePair);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to add globals.
     * 
     * @param ksession Drools Knowledge session.
     */
    private void addGlobals(StatefulKnowledgeSession ksession) {
        ksession.setGlobal("cList", new ArrayList<Integer>());
        ksession.setGlobal("dList", new ArrayList<String>());
        ksession.setGlobal("vList", new ArrayList<String>());
        ksession.setGlobal("fList", new ArrayList<String>());
        ArrayList<String> definedList = (ArrayList<String>) droolsVisitor.getdList();
        java.util.Set<String> tempSet = new HashSet<String>();
        tempSet.addAll(definedList);
        definedList.removeAll(definedList);
        definedList.addAll(tempSet);
        @SuppressWarnings("unchecked")
        List<String> defL = (ArrayList<String>) ksession.getGlobal("dList");
        for (int i = 0; i < definedList.size(); i++) {
            defL.add(definedList.get(i));
        }
        Map<String, Integer> enumMap = new HashMap<String, Integer>();
        enumMap = droolsVisitor.getEnumMap();
        Iterator<String> itr = enumMap.keySet().iterator();
        while (itr.hasNext()) {
            String k = itr.next();
            ksession.setGlobal(k, enumMap.get(k));
        }
    }

    /**
     * A private method for rule parsing.
     * 
     * @param path
     *            of the .drl file.
     * @return KnowledgeBase.
     * @throws Exception
     *             Exception.
     */
    private static KnowledgeBase readKnowledgeBase(String path) throws Exception {

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

        FileInputStream fis = new FileInputStream(path);
        kbuilder.add(ResourceFactory.newInputStreamResource(fis), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error + " @line " + error.getLines());
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    // checkstyle: resume exception type check

    @Override
    public void visitConstantValue(ConstantValue value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitVariable(Variable variable) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
    }

    @Override
    public void visitComment(Comment comment) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        boolean operationIsEquals = (call.getOperation().equals(OclKeyWords.EQUALS));
        boolean operationIsImplies = call.getOperation().equals(OclKeyWords.IMPLIES);

        if (operationIsEquals) {
            if ((call.getOperand() instanceof Variable) || (call.getOperand() instanceof CompoundAccess)) {
                // logger.info("This constraint needs to be there.");
                acceptConstraint = true;
            }
        } else if (operationIsImplies) {
            if (call.getParameter(0).getClass().equals(call.getClass())) {
                OCLFeatureCall temp = (OCLFeatureCall) call.getParameter(0);
                if (temp.getOperation().equals(OclKeyWords.EQUALS)) {
                    // logger.info("this should also be included.");
                    acceptConstraint = true;
                }
            } else if (call.getParameter(0) instanceof Parenthesis) {
                OCLFeatureCall temp2 = new OCLFeatureCall(call.getOperand(), OclKeyWords.IMPLIES,
                        ((Parenthesis) call.getParameter(0)).getExpr());
                temp2.accept(this);
            }
        }

    }

    @Override
    public void visitLet(Let let) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitDslFragment(DslFragment fragment) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub

    }

}
