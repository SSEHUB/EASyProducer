package de.uni_hildesheim.sse.reasoner.jess;

import jess.JessException;
import jess.Rete;
import de.uni_hildesheim.sse.reasoner.jess.functions.Equals;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLBooleanImplication;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLUnion;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLXNOR;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLXOR;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLany;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLappend;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLasSequence;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLasSet;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLavg;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLdiv;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLeq;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLexcludes;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLexists;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLfirst;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLfloor;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLforAll;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLincludes;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLindexAccess;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLindexOf;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLisDefined;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLisEmpty;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLlast;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLmatches;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLmax;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLmin;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLminus;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLmod;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLneq;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLnotEmpty;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLone;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLprepend;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLproduct;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLrej;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLround;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLsel;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLselect;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLsize;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLsubstitutes;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLsubstring;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLsum;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLtoInteger;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLtoReal;
import de.uni_hildesheim.sse.reasoner.jess.functions.IVMLtypeOf;
import de.uni_hildesheim.sse.reasoner.jess.functions.ListAdd;
import de.uni_hildesheim.sse.reasoner.jess.functions.ListContains;
import de.uni_hildesheim.sse.reasoner.jess.functions.NotEquals;

public class ReasoningThread extends Thread{

	private JessController jessController;
	private Rete jessEngine;
	private String jessFileName;
	private boolean terminationActivated = false;
	
	private Thread thread = null;
	
	public ReasoningThread (JessController jc, Rete engine, String fileName) {
		jessController = jc;
		this.jessEngine = engine;
		
		loadEngine(jessEngine);
		jessFileName = fileName;
		
	}
	
	public void runNormal() {
	    try {
            jessEngine.batch(jessFileName);
            jessEngine.run();
        } catch (JessException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void run() {
		thread = Thread.currentThread();
		try {		
            jessEngine.batch(jessFileName);
            jessEngine.run();
            System.out.println("");
			System.err.println("termination is: " + terminationActivated);
			if (!terminationActivated) {
				System.out.println("reasoningTask: termination is not activated!");
				jessController.setResultFound(true);
				jessController.notifySuccessfulReasoning();
			}
		} catch (JessException e) {
			e.printStackTrace();
		    /*
		     * In the current implementation Jess is stopped from the outside
		     * by resetting the engine while running. Of course, this is not
		     * a good way but there is no other solution so far.
		     * We do not print the exception but this little hint below ;-) 
		     */
		    /**
		     * A workaround hs been done. This involves writing each assignment/value modification rule
		     * in individual defmodule. Just for mitigating the risk of running into infinite problem,
		     * the threads may be sued.
		     * @author Saripalli
		     * 
		     */
		    System.out.println("Jess stopped NORMALLY from outside :");
		}
	}
	
	public void setTerminationActivated (boolean active) {
		System.err.println("in reasoning task termination set to:" + active);
		terminationActivated = active;
	}

	public Thread getThread() {
		return thread;
	}
	
	/**
     * A private method which loads the Jess's Rete engine with all the custom IVML operations.
     * @param jessEngine Rete engine.
     */
    private void loadEngine(Rete jessEngine) {
//        jessEngine.addUserpackage(new JessUserFunctions());
        
        jessEngine.addUserfunction(new IVMLBooleanImplication());
        jessEngine.addUserfunction(new IVMLXOR());
        jessEngine.addUserfunction(new IVMLisEmpty());
        jessEngine.addUserfunction(new IVMLnotEmpty());
        jessEngine.addUserfunction(new IVMLlast());
        jessEngine.addUserfunction(new IVMLmin());
        jessEngine.addUserfunction(new IVMLmax());
        jessEngine.addUserfunction(new IVMLsum());
        jessEngine.addUserfunction(new IVMLproduct());
        jessEngine.addUserfunction(new IVMLavg());
        jessEngine.addUserfunction(new IVMLXNOR());
        jessEngine.addUserfunction(new IVMLasSet());
        jessEngine.addUserfunction(new IVMLasSequence());
        jessEngine.addUserfunction(new IVMLtypeOf());
        jessEngine.addUserfunction(new IVMLappend());
        jessEngine.addUserfunction(new IVMLprepend());
        jessEngine.addUserfunction(new IVMLUnion());
        jessEngine.addUserfunction(new IVMLexists());
        jessEngine.addUserfunction(new IVMLselect());
        jessEngine.addUserfunction(new IVMLsel());
        jessEngine.addUserfunction(new IVMLrej());
        jessEngine.addUserfunction(new IVMLmatches());
        jessEngine.addUserfunction(new IVMLsubstitutes());
        jessEngine.addUserfunction(new IVMLsubstring());
        jessEngine.addUserfunction(new IVMLindexOf());
        jessEngine.addUserfunction(new IVMLtoInteger());
        jessEngine.addUserfunction(new IVMLtoReal());
        jessEngine.addUserfunction(new IVMLfloor());
        jessEngine.addUserfunction(new IVMLmod());
        jessEngine.addUserfunction(new IVMLminus());
        jessEngine.addUserfunction(new IVMLdiv());
        jessEngine.addUserfunction(new IVMLany());
        jessEngine.addUserfunction(new IVMLfirst());
        jessEngine.addUserfunction(new IVMLone());
        jessEngine.addUserfunction(new IVMLindexAccess());
        jessEngine.addUserfunction(new IVMLforAll());
        jessEngine.addUserfunction(new IVMLincludes());
        jessEngine.addUserfunction(new IVMLexcludes());
        jessEngine.addUserfunction(new IVMLisDefined());
        jessEngine.addUserfunction(new IVMLsize());
        jessEngine.addUserfunction(new IVMLround());
        jessEngine.addUserfunction(new IVMLeq());
        jessEngine.addUserfunction(new IVMLneq());
        jessEngine.addUserfunction(new Equals());
        jessEngine.addUserfunction(new NotEquals());
        jessEngine.addUserfunction(new ListContains());
        jessEngine.addUserfunction(new ListAdd());
        
    }
    
//    /**
//     * Class implementing Userpackage to add the custom Jess functions in a batch.
//     * @author Saripalli
//     *
//     */
//    private class JessUserFunctions implements Userpackage {
//
//        @Override
//        public void add(Rete jessEngine) {
//            jessEngine.addUserfunction(new IVMLBooleanImplication());
//            jessEngine.addUserfunction(new IVMLXOR());
//            jessEngine.addUserfunction(new IVMLisEmpty());
//            jessEngine.addUserfunction(new IVMLnotEmpty());
//            jessEngine.addUserfunction(new IVMLlast());
//            jessEngine.addUserfunction(new IVMLmin());
//            jessEngine.addUserfunction(new IVMLmax());
//            jessEngine.addUserfunction(new IVMLsum());
//            jessEngine.addUserfunction(new IVMLproduct());
//            jessEngine.addUserfunction(new IVMLavg());
//            jessEngine.addUserfunction(new IVMLXNOR());
//            jessEngine.addUserfunction(new IVMLasSet());
//            jessEngine.addUserfunction(new IVMLasSequence());
//            jessEngine.addUserfunction(new IVMLtypeOf());
//            jessEngine.addUserfunction(new IVMLappend());
//            jessEngine.addUserfunction(new IVMLprepend());
//            jessEngine.addUserfunction(new IVMLUnion());
//            jessEngine.addUserfunction(new IVMLexists());
//            jessEngine.addUserfunction(new IVMLselect());
//            jessEngine.addUserfunction(new IVMLsel());
//            jessEngine.addUserfunction(new IVMLrej());
//            jessEngine.addUserfunction(new IVMLmatches());
//            jessEngine.addUserfunction(new IVMLsubstitutes());
//            jessEngine.addUserfunction(new IVMLsubstring());
//            jessEngine.addUserfunction(new IVMLindexOf());
//            jessEngine.addUserfunction(new IVMLtoInteger());
//            jessEngine.addUserfunction(new IVMLtoReal());
//            jessEngine.addUserfunction(new IVMLfloor());
//            jessEngine.addUserfunction(new IVMLmod());
//            jessEngine.addUserfunction(new IVMLminus());
//            jessEngine.addUserfunction(new IVMLdiv());
//            jessEngine.addUserfunction(new IVMLany());
//            jessEngine.addUserfunction(new IVMLfirst());
//            jessEngine.addUserfunction(new IVMLone());
//            jessEngine.addUserfunction(new IVMLindexAccess());
//            jessEngine.addUserfunction(new IVMLforAll());
//            jessEngine.addUserfunction(new IVMLincludes());
//            jessEngine.addUserfunction(new IVMLexcludes());
//            jessEngine.addUserfunction(new IVMLisDefined());
//            jessEngine.addUserfunction(new IVMLsize());
//            jessEngine.addUserfunction(new IVMLround());
//            jessEngine.addUserfunction(new IVMLeq());
//            jessEngine.addUserfunction(new IVMLneq());
//            jessEngine.addUserfunction(new Equals());
//            jessEngine.addUserfunction(new NotEquals());
//            jessEngine.addUserfunction(new ListContains());
//        }
//        
//    }

}
