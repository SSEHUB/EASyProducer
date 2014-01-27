package de.uni_hildesheim.sse.reasoner.jess;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
import de.uni_hildesheim.sse.reasoner.jess.functions.ListContains;
import de.uni_hildesheim.sse.reasoner.jess.functions.NotEquals;


/**
 * Class to handle the looping malfunctioning of jess rules.
 * @author Kroher
 * @author Phani
 *
 */


public class JessLoop {
    private int delay = 0;
    private Timer jessTimer;
    private Rete engine;
    private File file = null;
    private long inTime; 
    private long outTime;
    
    /**
     * Constructor for the class.
     * @param sec time in seconds.
     * @param file File to parse..
     */
    public JessLoop(int sec, File file) {
        delay = sec;
        this.file = file;
        System.out.println("Create new rete");
        engine = new Rete();
        loadEngine(engine);
        System.out.println("New rete created");
        jessTimer = new Timer();
    }
    
    /**
     * Getter for rete engine to use for factsVisitor.
     * @return The rete engine.
     */
    public Rete getEngine() {
        return engine;
    }

    /**
     * Class JessRun task extending TimeTask.
     * @author Phani
     *
     */
    class JessRunTask extends TimerTask {
        
        @Override
        public void run() {
            try {
                
                loopingTest();
            } catch (JessException je) {
                System.out.println("Exception...");
                System.err.println(je.getMessage());
                System.out.println(" jess message " + je.getMessage() + " " + je.getLineNumber());
                System.out.println(" .. " + je.getProgramText() + je.getErrorCode());
            }
            //if the loop would stop, the timer would be canceled.
            //in this test, this should never be reached.
            
            jessTimer.cancel();
            System.out.println("JessTimer canceled after successful execution!");
            
        }
        
        /**
         * Private method loopingtest that runs the file and takes care of the looping. 
         * @throws JessException should not occur.
         */
        private void loopingTest() throws JessException {
// begin measuring time
            inTime = System.currentTimeMillis();
            try {
                engine.batch(file.getCanonicalPath());
//                engine.runUntilHalt();
                outTime = System.currentTimeMillis();
                System.out.println("actual running time = " + inTime / 1000.0 + " .. " + outTime / 1000.0);
                System.out.println("is - " + (outTime - inTime) + " --- " + (outTime - inTime) / 1000.0);
                jessTimer.cancel();
            } catch (IOException e) {
                e.printStackTrace();
            } 
            
           
        }
    }
    

    /**
     * Method to start the timer.
     */
    public void start() {
        
        System.out.println("Jess starts in " + delay + " seconds");
        jessTimer.schedule(new JessRunTask(), delay * 1000);
    }
    
    /**
     * Method that stops the Jess engine in case of a loop.
     */
    public void stop() {
        System.out.println("Jess will stop...");
        try {
            engine.halt();
        } catch (JessException e) {
            e.printStackTrace();
        }
        
        
        System.out.println("Jess stopped successfully from outside!");
        
    }
    
    /**
     * A private method which loads the Jess's Rete engine with all the custom IVML operations.
     * @param engine Rete engine.
     */
    private void loadEngine(Rete engine) {
        engine.addUserfunction(new ListContains());
        engine.addUserfunction(new IVMLBooleanImplication());
        engine.addUserfunction(new IVMLXOR());
        engine.addUserfunction(new IVMLisEmpty());
        engine.addUserfunction(new IVMLnotEmpty());
        engine.addUserfunction(new IVMLlast());
        engine.addUserfunction(new IVMLmin());
        engine.addUserfunction(new IVMLmax());
        engine.addUserfunction(new IVMLsum());
        engine.addUserfunction(new IVMLproduct());
        engine.addUserfunction(new IVMLavg());
        engine.addUserfunction(new IVMLXNOR());
        engine.addUserfunction(new IVMLasSet());
        engine.addUserfunction(new IVMLasSequence());
        engine.addUserfunction(new IVMLtypeOf());
        engine.addUserfunction(new IVMLappend());
        engine.addUserfunction(new IVMLprepend());
        engine.addUserfunction(new IVMLUnion());
        engine.addUserfunction(new IVMLexists());
        engine.addUserfunction(new IVMLselect());
        engine.addUserfunction(new IVMLsel());
        engine.addUserfunction(new IVMLrej());
        engine.addUserfunction(new IVMLmatches());
        engine.addUserfunction(new IVMLsubstitutes());
        engine.addUserfunction(new IVMLsubstring());
        engine.addUserfunction(new IVMLindexOf());
        engine.addUserfunction(new IVMLtoInteger());
        engine.addUserfunction(new IVMLtoReal());
        engine.addUserfunction(new IVMLfloor());
        engine.addUserfunction(new IVMLmod());
        engine.addUserfunction(new IVMLminus());
        engine.addUserfunction(new IVMLdiv());
        engine.addUserfunction(new IVMLany());
        engine.addUserfunction(new IVMLfirst());
        engine.addUserfunction(new IVMLone());
        engine.addUserfunction(new IVMLindexAccess());
        engine.addUserfunction(new IVMLforAll());
        engine.addUserfunction(new IVMLincludes());
        engine.addUserfunction(new IVMLexcludes());
        engine.addUserfunction(new IVMLisDefined());
        engine.addUserfunction(new IVMLsize());
        engine.addUserfunction(new IVMLround());
        engine.addUserfunction(new IVMLeq());
        engine.addUserfunction(new IVMLneq());
        engine.addUserfunction(new Equals());
        engine.addUserfunction(new NotEquals());
        
    }

    
    

}
