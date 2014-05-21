package jess;

import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Rete implements JessListener, Serializable {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!

    public static final int INSTALL = 0;
    public static final int ACTIVATE = 1;
    public static final int EVERY_TIME = 2;
    public static final String LIBRARY_PATH_ID = "jess.library.path.id";
    public static final String LIBRARY_NAME = "scriptlib.clp";
    @SuppressWarnings("rawtypes")
    public static java.util.Map s_lineNumberTable = null;
    
    public Rete createPeer() {
        return null;
    }
    
    public Rete(Object o) {
    }
    
    public Rete() {
    }
    
    public Rete(Applet a) {
    }
    
    public void addInputRouter(String s, Reader r, boolean b) {
    }
    
    public void removeInputRouter(String s) {
    }
    
    public Reader getInputRouter(String s) {
        return null;
    }
    
    public void addOutputRouter(String s, Writer w) {
    }

    public void removeOutputRouter(String s) {
    }
    
    public boolean getInputMode(String s) {
        return false;
    }
    
    public Writer getOutputRouter(String s) {
        return null;
    }
    
    public PrintWriter getErrStream() {
        return null;
    }
    
    public PrintWriter getOutStream() {
        return null;
    }
    
    public synchronized void clear() throws jess.JessException {
    }

    public void reset() throws jess.JessException {
    }

    public void setDynamicChecking(boolean b) {
    }
    
    public Fact assertString(String s, Context c) throws JessException {
        return null;
    }
    
    public Fact assertString(String s) throws JessException {
        return null;
    }
    
    public Fact assertFact(Fact f) throws JessException {
        return null;
    }
    
    public Fact assertFact(Fact f, Context c) throws JessException {
        return null;
    }
    
    public Fact retractString(String s) throws JessException {
        return null;
    }
    
    public Fact retract(Fact f) throws JessException {
        return null;
    }
    
    public void removeFacts(String s) throws JessException {
    }
    
    public Fact modify(Fact f, String s, Value v) throws JessException {
        return null;
    }
    
    public Fact modify(Fact f, String s, Value v, Context c) throws JessException {
        return null;
    }
    
    public Fact modify(Fact f, String[] s, Value[] v) throws JessException {
        return null;
    }
    
    public Fact modify(Fact f, String[] s, Value[] v, Context c) throws jess.JessException {
        return null;
    }

    public Fact findFactByID(int i) throws JessException {
        return null;
    }
    
    public Fact findFactByFact(Fact f) throws JessException {
        return null;
    }
    
    //public WorkingMemoryMarker mark();
    //public void resetToMark(WorkingMemoryMarker) throws JessException;
    //public Iterator getObjects(Filter f);
    
    public void ppFacts(String s, Writer w) throws IOException {
    }
    
    public void ppFacts(String s, Writer w, boolean b) throws IOException {
    }
    
    public void ppFacts(Writer w) throws IOException {
    }

    public void ppFacts(Writer w, boolean b) throws IOException {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDeffacts() {
        return null;        
    }
    
    //public jess.Deffacts findDeffacts(java.lang.String);
    
    @SuppressWarnings("rawtypes")
    public Iterator listDeftemplates() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDefrules() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listFacts() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDefinstances() {
        return null;        
    }
    
    public boolean containsObject(Object o) {
        return false;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDefclasses() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDefglobals() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listFunctions() {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDeffunctions() {
        return null;        
    }
    
    //public final jess.HasLHS findDefrule(java.lang.String);
    @SuppressWarnings("rawtypes")
    public Class javaClassForDefclass(String s) {
        return null;        
    }
    
    public Deftemplate findDeftemplate(String s) throws JessException {
        return null;        
    }

    public Deftemplate createDeftemplate(String s) throws JessException {
        return null;        
    }
    
    public Deftemplate addDeftemplate(Deftemplate d) throws JessException {
        return null;        
    }
    
    public void removeDeftemplate(String s) throws JessException {
    }

    //public Deffacts addDeffacts(Deffacts d) throws JessException;
    
    public void removeDeffacts(String s) throws JessException {
    }
    
    //public jess.Defglobal addDefglobal(jess.Defglobal)       throws jess.JessException;
    
    @SuppressWarnings("rawtypes")
    public List addDefglobals(List l) throws JessException {
        return null;        
    }
    
    //public jess.Defglobal findDefglobal(java.lang.String);
    
    public void removeDefglobal(String s) throws JessException {
    }
    
    public void removeUserDefinedFunctions() {
    }
    
    public Userfunction addUserfunction(Userfunction u) {
        return null;        
    }

    public void removeUserfunction(String s) {
    }

    //public jess.Userpackage addUserpackage(jess.Userpackage);
    public final Userfunction findUserfunction(String s) {
        return null;        
    }
    
    //public final jess.HasLHS addDefrule(jess.HasLHS)       throws jess.JessException;
    public final Value unDeffacts(String s) {
        return null;        
    }
    
    public final Value unDefrule(String s) throws JessException {
        return null;        
    }
    
    public void removeDefrule(String s) throws JessException {
    }
    
    //public void addDefmodule(Defmodule m) throws JessException;
    public void addDefmodule(String s) throws JessException {
    }
    
    public void addDefmodule(String s1, String s2) throws JessException {
    }
    
    public void removeDefmodule(String s) throws JessException {
    }
    
    public String getCurrentModule() {
        return null;        
    }
    
    public String setCurrentModule(String s) throws JessException {
        return null;        
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listModules() {
        return null;        
    }
    
    public String getFocus() {
        return null;        
    }
    
    public void setFocus(String s) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listFocusStack() throws JessException {
        return null;        
    }
    
    public void clearFocusStack() {
    }
    
    public String popFocus(String s) throws JessException {
        return null;        
    }
    
    public void verifyModule(String s) throws JessException {
    }

    public String resolveName(String s) {
        return null;        
    }
    
    //public jess.Defmodule findModule(java.lang.String)       throws jess.JessException;
    public boolean hasActivations() throws JessException {
        return false;
    }
    
    public boolean hasActivations(String s) throws JessException {
        return false;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listActivations() throws JessException {
        return null;        
    }

    @SuppressWarnings("rawtypes")
    public Iterator listActivations(String s) throws JessException {
        return null;        
    }

//    public Activation peekNextActivation() throws JessException {
//        return null;        
//    }
    
    public Object getActivationSemaphore() {
        return null;        
    }
    
    public void waitForActivations() {
    }
    
    //public String setStrategy(Strategy s) throws jess.JessException;
    
    //public jess.Strategy getStrategy();
    public final void setEvalSalience(int i) throws JessException {
    }
    
    public final int getEvalSalience() {
        return 0;
    }
    
    public int run() throws JessException {
        return 0;
    }
    
    public int run(int i) throws JessException {
        return 0;
    }
    
    public int runUntilHalt() throws JessException {
        return 0;
    }
    
    public void halt() throws JessException {
    }
    
    public boolean isHalted() {
        return false;
    }
    
    public String getThisRuleName() {
        return null;
    }
    
//    public Activation getThisActivation() {
//        return null;
//    }

    public Thread getRunThread() {
        return null;
    }

    public void addJessListener(JessListener l) {
    }

    public void removeJessListener(JessListener l) {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listJessListeners() {
        return null;
    }
    
    public int getEventMask() {
        return 0;
    }
    
    public void setEventMask(int i) {
    }

    public void setPassiveMode(boolean b) {
    }
    
    public boolean isDebug() {
        return false;
    }
    public void setDebug(boolean b) {
    }

    public static void recordFunction(Funcall f, String s, int i) {
    }

    //public static void recordFunction(Funcall f, jess.server.LineNumberRecord) {
    //}
    
    //public static jess.server.LineNumberRecord lookupFunction(jess.Funcall);
    public void removeDebugListener(JessListener l) {
    }
    
    public void addDebugListener(JessListener l) {
    }

    @SuppressWarnings("rawtypes")
    public Iterator listDebugListeners() {
        return null;
    }
    
    public void bload(InputStream i) throws IOException, ClassNotFoundException {
    }
    
    public void bsave(OutputStream o) throws IOException {
    }

    public Value definstance(String s, Object o, boolean b) throws jess.JessException {
        return null;
    }
    
    public Value definstance(String s, Object o, boolean b, Context c) throws JessException {
        return null;
    }

    public Fact getShadowFactForObject(Object o) throws JessException {
        return null;
    }
    
    public Fact remove(Object o) throws JessException {
        return null;
    }
    
    public Fact undefinstance(Object o) throws JessException {
        return null;
    }
    
    public Value updateObject(Object o) throws JessException {
        return null;
    }
    
    public Value updateObject(Object o, Context c) throws JessException {
        return null;
    }
    
    public Value updateObject(Object o, String s) throws JessException {
        return null;
    }
    
    public Value add(Object o) throws JessException {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public void addAll(Collection c) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public void removeAll(Collection c) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public void addAll(Iterator i) throws JessException {
    }
    
    public Value defclass(String s, String s1, String s2, boolean b) throws JessException {
        return null;
    }
    
    public Value defclass(String s, String s1, String s2) throws JessException {
        return null;
    }
    
    public final Context getGlobalContext() {
        return null;
    }
    
    public Value eval(String s) throws JessException {
        return null;
    }
    
    public Value executeCommand(String s) throws JessException {
        return null;
    }
    
    public Value eval(String s, Context c) throws JessException {
        return null;
    }
    
    public Value executeCommand(String s, Context c) throws JessException {
        return null;
    }
    
    public final void setResetGlobals(boolean b) {
    }
    
    public final boolean getResetGlobals() {
        return false;
    }
    
    public Value store(String s, Value v) {
        return null;
    }
    
    public Value store(String s, Object o) {
        return null;
    }
    
    public Value fetch(String s) {
        return null;
    }
    
    public void clearStorage() {
    }
    
    //public static jess.factory.Factory getFactory();
    //public static void setFactory(jess.factory.Factory);
    
    public Value batch(String s) throws jess.JessException {
        return null;
    }
    
    //public jess.QueryResult runQueryStar(java.lang.String, jess.ValueVector) throws jess.JessException
    //public jess.QueryResult runQueryStar(java.lang.String, jess.ValueVector, jess.Context)       throws jess.JessException;
    
    @SuppressWarnings("rawtypes")
    public Iterator runQuery(String s, ValueVector v) throws JessException {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator runQuery(String s, ValueVector v, Context c) throws JessException {
        return null;
    }
    
    public int countQueryResults(String s, ValueVector v) throws JessException {
        return 0;
    }
    
    public int countQueryResults(String s, ValueVector v, Context c) throws JessException {
        return 0;
    }
    
    public void watch(int i) throws JessException {
    }
    
    public void unwatch(int i) throws JessException {
    }
    
    public void watchAll() {
    }
    
    public void unwatchAll() {
    }
    
    public void eventHappened(JessEvent e) {
    }
    
    public String setWatchRouter(String s) throws JessException {
        return null;
    }
    
    public void defineFeature(String s) {
    }
    
    public boolean isFeatureDefined(String s) {
        return false;
    }
    
    @SuppressWarnings("rawtypes")
    public List getSupportingTokens(Fact f) {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public List getSupportedFacts(Fact f) {
        return null;
    }
    
    public Applet getApplet() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Class getAppObjectClass() {
        return null;
    }
    
    public void setApplet(Applet a) {
    }
    
    public void setAppObject(Object o) {
    }
    
    public void setClassLoader(ClassLoader c) {
    }
    
    public ClassLoader getClassLoader() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Class findClass(String s) throws ClassNotFoundException {
        return null;
    }
    
    public URL getResource(String s) {
        return null;
    }

    public void importPackage(String s) {
    }
    
    public void importClass(String s) throws JessException {
    }
    //public jess.ClassResearcher getClassResearcher()
    //public void setClassResearcher(jess.ClassResearcher);
    //public jess.ValueFactory getValueFactory();
    //public void setValueFactory(jess.ValueFactory);

    public char getMemberChar() {
        return 0;
    }

    public void setMemberChar(char c) {
    }
    
}
