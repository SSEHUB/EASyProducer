package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Deftemplate implements Serializable, Visitable, Modular {
    
    public Deftemplate(String s, String s1, Rete r) throws JessException {
    }

    public Deftemplate(String s, String s1, Deftemplate d, Rete r) throws JessException {
    }
    
    public static Deftemplate getRootTemplate() {
        return null;
    }
    
    public static Deftemplate getInitialTemplate() {
        return null;
    }
    
    public static Deftemplate getClearTemplate() {
        return null;
    }
    
    public static Deftemplate getNullTemplate() {
        return null;
    }
    
    public static Deftemplate getTestTemplate() {
        return null;
    }
    
    public static Deftemplate getAccumTemplate() {
        return null;
    }
    
    public Deftemplate getParent() {
        return null;
    }

    public final String getName() {
        return null;
    }

    public final String getBaseName() {
        return null;
    }

    public final String getDocstring() {
        return null;
    }

    public final void doBackwardChaining(Rete r) throws jess.JessException  {
    }

    public final boolean getBackwardChaining() {
        return false;
    }

    public void addSlot(String s, Value v, String s1) throws JessException {
    }

    public void addMultiSlot(String s, Value v, String s1) throws JessException {
    }

    public void addMultiSlot(String s, Value v) throws JessException {
    }
    
    public int getSlotDataType(int i) throws JessException {
        return 0;
    }
    
    public int getSlotDataType(String s) throws JessException {
        return 0;
    }
    
    public Value getSlotDefault(int i) throws JessException {
        return null;
    }
    
    public Value getSlotDefault(String s) throws JessException {
        return null;
    }
    
    public ValueVector getSlotAllowedValues(String b) throws JessException {
        return null;
    }
    
    public int getSlotType(int i) throws JessException {
        return 0;
    }

    public int getSlotType(String s) throws JessException {
        return 0;
    }

    public boolean isMultislot(int i) throws JessException {
        return false;
    }
    
    public int getSlotIndex(String s) {
        return 0;
    }

    public String getSlotName(int i) throws JessException {
        return null;
    }

    public String[] getSlotNames() {
        return null;
    }
    
    public int getNSlots() {
        return 0;
    }

    public Object accept(Visitor v) {
        return null;
    }

    public String getModule() {
        return null;
    }

    public boolean isBackwardChainingTrigger() {
        return false;
    }

    public String getBackchainingTemplateName() {
        return null;
    }

    public String getNameWithoutBackchainingPrefix() {
        return null;
    }

    public Deftemplate getBackchainingTemplate(Rete r) throws JessException {
        return null;
    }

    public boolean isOrdered() {
        return false;
    }

    public void setSlotSpecific(boolean b) {
    }

    public boolean isSlotSpecific() {
        return false;
    }

    public final String getConstructType() {
        return null;
    }

    public String getShadowClassName() {
        return null;
    }

    public boolean isShadowTemplate() {
        return false;
    }
    
    public boolean includesVariables() throws JessException {
        return false;
    }

    public static boolean isSpecialName(String s) {
        return false;
    }

    public static Deftemplate getSpecialTemplate(String s) {
        return null;
    }

    public void setSlotAllowedValues(String s, ValueVector v) throws JessException {
    }

    public boolean isAllowedValue(String s, Value v) throws JessException {
        return false;
    }

    public void freeze(Rete r) throws JessException {
    }
}
