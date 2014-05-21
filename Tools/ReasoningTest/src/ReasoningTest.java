import java.io.IOException;
import java.io.StringWriter;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.IVMLWriter;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.core.impl.ReasonerRegistry;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.drools.DroolsEngine;
import de.uni_hildesheim.sse.reasoning.drools.DroolsReasoner;


public class ReasoningTest {
    
    public static void main(String[] a) {
        Project p = new Project("test");
        DecisionVariableDeclaration dcl = new DecisionVariableDeclaration("intA", IntegerType.TYPE, p);
        p.add(dcl);
        Variable var = new Variable(dcl);
        Value val;
        try {
            val = ValueFactory.createValue(IntegerType.TYPE, "1");
            ConstantValue cValue = new ConstantValue(val);
            OCLFeatureCall call = new OCLFeatureCall(var, OclKeyWords.GREATER, cValue);
            Constraint constraint = new Constraint(p);
            constraint.setConsSyntax(call);
            p.add(constraint);
        } catch (ValueDoesNotMatchTypeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Configuration config = new Configuration(p);
        IDecisionVariable ivar = config.getDecision(dcl);
        Value val2;
        try {
            val2 = ValueFactory.createValue(IntegerType.TYPE, "-1");
            ivar.setValue(val2, AssignmentState.ASSIGNED);
        } catch (ValueDoesNotMatchTypeException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        ReasonerRegistry.getInstance().register(new DroolsReasoner());
        ReasoningResult result =  ReasonerFrontend.getInstance().check(p, config);
        
        System.out.println(result.hasConflict());
        System.out.println(ReasoningTest.class.getClassLoader());
        System.out.println(DroolsEngine.class.getClassLoader());
        
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        p.accept(iWriter);
        try {
            iWriter.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(sWriter);
    }

}
