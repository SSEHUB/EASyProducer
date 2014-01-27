package de.uni_hildesheim.sse.reasoning.drools2.functions;

import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

import de.uni_hildesheim.sse.reasoning.core.model.IModelChangeListener;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;

/**
 * Class for updating facts in Drools session.
 * @author Sizonenko
 */
public class FactUpdater implements IModelChangeListener {
    
    private StatefulKnowledgeSession session;
    
    /**
     * Constructor for this class.
     * @param session {@link StatefulKnowledgeSession} in Drools.
     */
    public FactUpdater(StatefulKnowledgeSession session) {
        this.session = session;
    }
    
//    /**
//     * Method for updating facts in KB after a new value in the {@link ReasonerVariable} was set.
//     * @param rVariable with changed value.
//     */
//    public static void updateSession(ReasonerVariable rVariable) {
//    }

    @Override
    public void variableChanged(ReasonerVariable rVariable) {
//        Iterator<FactHandle> factIterator = session.getFactHandles().iterator();
//        while (factIterator.hasNext()) {
//            FactHandle fact = factIterator.next();
//            ReasonerVariable var = (ReasonerVariable) session.getObject(fact);
//            System.out.println(var.getName());
//        }
        FactHandle fact = null;
        try {
            if (rVariable.getParent() == null) {
                fact = session.getFactHandle(rVariable);
                session.update(fact, rVariable);
                System.out.println("No parrent: " + session.getFactHandle(rVariable).toString() 
                    + " : " + rVariable.getName());               
            } else {
                fact = session.getFactHandle(rVariable.getParent());
                rVariable = rVariable.getParent();
                session.update(fact, rVariable);
                System.out.println("Parent: " + session.getFactHandle(rVariable));
            }
        } finally {
            System.out.println("Updating: " + rVariable.getName());
        }        
    }
}
