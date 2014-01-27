package de.uni_hildesheim.sse.reasoner.jess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jess.Accumulate;
import jess.Context;
import jess.Deffacts;
import jess.Deffunction;
import jess.Defglobal;
import jess.Defmodule;
import jess.Defquery;
import jess.Defrule;
import jess.Deftemplate;
import jess.Fact;
import jess.FactIDValue;
import jess.Funcall;
import jess.Group;
import jess.JessException;
import jess.Pattern;
import jess.RU;
import jess.Test1;
import jess.Visitor;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A Visitor implementation for visiting the facts loaded from the project.
 * @author Phani
 *
 */
public class JessFactsVisitor implements Visitor, IValueVisitor {

    private Context context = null;
    private Map<String, IDatatype> varMap = null;
    private int tabCount = 0;
    private boolean isAFact = false;
    private Configuration config;
    private ReasoningResult result;
    private List<ModelElement> frozenElements = new ArrayList<ModelElement>();
    private Map<String, IDecisionVariable> decisionsMap = new HashMap<String, IDecisionVariable>();
    private String compName = "";
    private String confValue = "";
    private boolean outerComp = true;
    private CompoundValue cv = null;

    /**
     * Constructor for the class.
     * @param context Jess context.
     * @param config Configuration.
     * @param result ReasoningResult. 
     */
    public JessFactsVisitor(Context context, Configuration config, ReasoningResult result) {
        this.context = context;
        this.config = config;
        this.result = result;
        
    }
    
    /**
     * Getter for the configuration.
     * @return Configuration, updated.
     */
    public Configuration getConfig() {
        return config;
    }

    /**
     * Setting up the map.
     * @param map Variable map.
     */
    
    public void setVarMap(Map<String, IDatatype> map) {
        this.varMap = map;
        createDecisionsMap();
        
    }
    
    /**
     * Method to process the messages (mainly related to frozen values).
     */
    public void processMessages() {
        if (frozenElements.size() != 0) {
            result.addMessage(new Message("Illegal Operation (s) : CHANGING FROZEN ELEMENTS ",
                    frozenElements, Status.ERROR));
        }
    }
    
    @Override
    public Object visitFact(Fact fact) {

        try {
            Value v;
            
            for (int i = 1; i < fact.size(); i++) {
                String slot = fact.getDeftemplate().getSlotName(i);
                if (fact.get(i) instanceof FactIDValue) {
                    FactIDValue f = (FactIDValue) fact.get(i);
                    tabCount++;
                    isAFact = true;
                    for (int j = 0; j < tabCount - 1; j++) {
                        System.out.print("\t");
                    }
                    System.out.print("Fact name* -> " 
                            + fact.getDeftemplate().getSlotName(i));
                    System.out.println(" IDatatype " + this.varMap.get(slot).getName() + " ");
                    this.compName = fact.getDeftemplate().getSlotName(i);
                    IDecisionVariable decVar = null;
                    if (outerComp) {
                        outerComp = false;
                        decVar = this.decisionsMap.get(this.compName);
                        v = (CompoundValue) this.config.getDecision(decVar.getDeclaration()).getValue();
                        cv = (CompoundValue) v;
                        
                        f.factValue(this.context).accept(this);
                    } else {
                        System.out.println(" Inner comp name ");
                    }
                    
                    isAFact = false;
                    this.tabCount = 0;
                    outerComp = true;
                    
                } else {
                    nestedElementConfig(fact, slot);
                }
            }
            
            
        } catch (JessException e) {
            System.out.println("Exception...");
            System.err.println(e.getMessage());
            System.out.println(" jess message " + e.getMessage() + " " + e.getLineNumber());
            System.out.println(" " + e.getProgramText());
            e.printStackTrace();
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
       
        
        return null;
    }

    /**
     * A private method to process nested element configuration.
     * @param fact Jess fact.
     * @param slot Slot of the fact.
     * @throws JessException Should not occur if jess is syntactically right.
     * @throws ValueDoesNotMatchTypeException Should not occur values are assigned to the appropriate datatypes.
     * @throws ConfigurationException Should not occur if there is no flaw in the configuration.
     */
    private void nestedElementConfig(Fact fact, String slot) throws JessException,
    ValueDoesNotMatchTypeException, ConfigurationException {
        if (!slot.contains("instance")) {
            for (int j = 0; j < tabCount; j++) {
                System.out.print("\t");
            }
            System.out.print("Variable name -> " + slot);
            if (!isAFact) {
                nonNestedElemConfig(fact, slot); 
            } else {
                jess.Value vall = fact.getSlotValue(slot);
                int vTyp = vall.resolveValue(context).type();
                String valAsString = vall.toString();
                
                if (!valAsString.equals("nil")) {
                    
                    if (valAsString.equals("TRUE") || valAsString.equals("FALSE")) {
                        valAsString = valAsString.toLowerCase();
                        cv.configureValue(slot, valAsString);
                    } else if (vTyp == RU.FACT) {
                        System.out.println(" Fact value ");
                        System.out.println("\t " + vall.factValue(context));
                    } else if ((vTyp == RU.INTEGER) || (vTyp == RU.FLOAT) || (vTyp == RU.STRING) ) {
                        cv.configureValue(slot, valAsString);
                    }
           
                } 
            }
            System.out.println("\t Value -> " + fact.getSlotValue(slot));
        }
    }


    /**
     * Private method that updates config for non nested element.
     * @param fact Jess fact.
     * @param slot Fact slot.
     * @throws JessException Should not occur if jess is syntactically right.
     * @throws ValueDoesNotMatchTypeException Should not occur values are assigned to the appropriate datatypes.
     * @throws ConfigurationException Should not occur if there is no flaw in the configuration.
     */
    private void nonNestedElemConfig(Fact fact, String slot) throws JessException, ValueDoesNotMatchTypeException,
            ConfigurationException {
        System.out.print("  IDatatype " + this.varMap.get(slot).getName());
        boolean isSequence = this.varMap.get(slot).getTypeClass().isAssignableFrom(Sequence.class);
        boolean isSet = this.varMap.get(slot).getTypeClass().isAssignableFrom(Set.class);
        boolean isCompound = this.varMap.get(slot).getTypeClass().isAssignableFrom(Compound.class);
        boolean isEnum = isTypeEnum(slot);
        boolean isOrderedEnum;
        isOrderedEnum = isTypeOrderedEnum(slot);
        boolean isSetOrSequence = isSequence || isSet;
        boolean isEnumOrOrderedEnum = isEnum || isOrderedEnum;
        
        if (!(isSetOrSequence || isEnumOrOrderedEnum || isCompound)) {
            configureIntRealString(fact, slot); 
        } else if (isEnumOrOrderedEnum) {
            configureEnums(fact, slot);
        } else if (isSetOrSequence) {
            if (fact.getSlotValue(slot).listValue(context).size() != 0) {
                String firstElem = fact.getSlotValue(slot).listValue(context).get(0).toString();
                System.out.println(" sequenceOf ? " + this.varMap.get(slot) + " 1st elem " + firstElem);
                System.out.println(" delaration " + this.decisionsMap.get(slot).getDeclaration().getName());
                
            }
            
        }
    }

    /**
     * Private method to identify if the slot is of type Enum.
     * @param slot Jess slot.
     * @return <b>True</b> if it is an enum. 
     */
    private boolean isTypeEnum(String slot) {
        return this.varMap.get(slot).getTypeClass().isAssignableFrom(Enum.class);
    }

    /**
     * Private method to identify if the slot is of type OrderedEnum.
     * @param slot Jess slot.
     * @return <b>True</b> if it is an enum. 
     */
    private boolean isTypeOrderedEnum(String slot) {
        return this.varMap.get(slot).getTypeClass().isAssignableFrom(OrderedEnum.class);
    }

    /**
     * Private method to configure enums (ordered or unordered).
     * @param fact Jess fact.
     * @param slot Fact slot.
     * @throws JessException Should not occur if jess is syntactically right.
     * @throws ValueDoesNotMatchTypeException Should not occur values are assigned to the appropriate datatypes.
     * @throws ConfigurationException Should not occur if there is no flaw in the configuration.
     */
    private void configureEnums(Fact fact, String slot) throws JessException, ValueDoesNotMatchTypeException,
            ConfigurationException {
        Enum e = (Enum) this.varMap.get(slot);
        IDecisionVariable decVar = this.decisionsMap.get(slot);
        if (!fact.getSlotValue(slot).equals("nil")) {
            Value confV;
            confV = this.config.getDecision(decVar.getDeclaration()).getValue(); 
            if (confV != null) {
                confV.accept(this);
            }
            String litVal = e.getLiteralByOrdinal(fact.getSlotValue(slot).intValue(context)).getName();
            EnumValue eValue = (EnumValue) ValueFactory.createValue(this.varMap.get(slot), litVal); 
            if (this.config.getDecision(decVar.getDeclaration()).getState() != AssignmentState.FROZEN) {
                this.config.getDecision(decVar.getDeclaration()).setValue(eValue, AssignmentState.DERIVED);
            } else {
                ModelElement m = (ModelElement) decVar.getDeclaration();
                if (!fact.getSlotValue(slot).equals(this.confValue)) {
                    this.frozenElements.add(m);
                }
            }
        }
    }

    /**
     * Private method for updating values of type integer, real and strings.
     * @param fact jess fact.
     * @param slot Slot of the fact.
     * @throws JessException Should not occur.
     * @throws ValueDoesNotMatchTypeException Occurs if values are assigned to incorrect datatypes.
     * @throws ConfigurationException Shows there is an error in configuration.
     */
    private void configureIntRealString(Fact fact, String slot) throws JessException, ValueDoesNotMatchTypeException,
            ConfigurationException {
        String val = fact.getSlotValue(slot).toString();
        if (!val.equals("nil")) {
            if (val.equals("TRUE") || val.equals("FALSE")) {
                val = val.toLowerCase();
            }
            Value v;
            IDecisionVariable decVar = this.decisionsMap.get(slot);
            v = ValueFactory.createValue(this.varMap.get(slot), val);
            Value confV;
            confV = this.config.getDecision(decVar.getDeclaration()).getValue(); 
            if (confV != null) {
                confV.accept(this);
            }
            if (this.config.getDecision(decVar.getDeclaration()).getState() != AssignmentState.FROZEN) {
                this.config.getDecision(decVar.getDeclaration()).setValue(v, AssignmentState.DERIVED);
            } else {
                ModelElement m = (ModelElement) decVar.getDeclaration();
                if (!fact.getSlotValue(slot).equals(this.confValue)) {
                    this.frozenElements.add(m);
                }
            }
        }
    }
    
    /**
     * A private method to create a map for all the decisions given the declaration names.
     */
    private void createDecisionsMap() {
        Iterator<IDecisionVariable> iterator = this.config.iterator();    
        while (iterator.hasNext()) {
            IDecisionVariable dc = iterator.next();
            String decName = dc.getDeclaration().getName();
            Iterator<String> itr = this.varMap.keySet().iterator();
            while (itr.hasNext()) {
                String ss = (String) itr.next();
                if (ss.equals(decName)) {
                    //System.out.println("ss is  " + ss);
                    this.decisionsMap.put(ss, dc);
                }
            }
        }
        
    }
    
    
    @Override
    public Object visitAccumulate(Accumulate arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDeffacts(Deffacts arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDeffunction(Deffunction arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDefglobal(Defglobal arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDefmodule(Defmodule arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDefquery(Defquery arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDefrule(Defrule arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitDeftemplate(Deftemplate arg0) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object visitFuncall(Funcall arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitGroup(Group arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitPattern(Pattern arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object visitTest1(Test1 arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        this.confValue = value.getValue().toString();    
        Enum e = (Enum) value.getType();
        for (int i = 0; i < e.getLiteralCount(); i++) {
            if (e.getLiteral(i).getName().equals(this.confValue)) {
                this.confValue = String.valueOf(e.getLiteral(i).getOrdinal());
            }
        }
//        System.out.println("new value is " + this.confValue);
    }

    @Override
    public void visitStringValue(StringValue value) {
        this.confValue = value.getValue().toString();        
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitIntValue(IntValue value) {
        this.confValue = value.getValue().toString();
       
             
    }

    @Override
    public void visitRealValue(RealValue value) {
        this.confValue = value.getValue().toString();        
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // TODO Auto-generated method stub
    }

    @Override
    public void visitNullValue(NullValue value) {
        // TODO Auto-generated method stub
    }

}
