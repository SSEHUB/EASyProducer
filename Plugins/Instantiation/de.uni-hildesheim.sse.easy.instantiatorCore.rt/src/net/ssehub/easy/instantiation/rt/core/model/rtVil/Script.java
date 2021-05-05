/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Imports;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a script, i.e., the top-level element of a rtVIL-model.
 * Scripts represent an implicit type, i.e., they are not registered with the 
 * {@link net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry} and, thus, not
 * assignable.
 * 
 * @author Holger Eichelberger
 */
public class Script extends net.ssehub.easy.instantiation.core.model.buildlangModel.Script {

    private List<Strategy> strategies = new ArrayList<Strategy>();
    private List<Tactic> tactics = new ArrayList<Tactic>();
    private boolean wasExecuted = false;
    
    /**
     * Constructor for a script without parent, parameters or advices and with the default
     * type registry.
     * 
     * @param name Name of the project.
     */
    public Script(String name) {
        super(name);
    }

    /**
     * Constructor for a script without parent, parameters or advices.
     * 
     * @param name Name of the project.
     * @param registry the responsible registry
     */
    public Script(String name, TypeRegistry registry) {
        super(name, registry);
    }
    
    /**
     * Constructor for a script.
     * 
     * @param name Name of the project.
     * @param parent the super script to inherit from (as a script import, may be <b>null</b>, shall be member of 
     *     <code>imports</code> or also <b>null</b>)
     * @param descriptor the descriptor carrying parameters, advices and imports (may be <b>null</b>)
     * @param registry the responsible type registry 
     */
    public Script(String name, ModelImport<Script> parent, ScriptDescriptor<Script> descriptor, 
        TypeRegistry registry) {
        super(name, convert(parent), convert(descriptor), registry);
        adjustParents();
    }
    
    /**
     * Adjusts the parents of the contained elements.
     */
    private void adjustParents() {
        for (int s = 0; s < getStrategiesCount(); s++) {
            getStrategy(s).setParent(this);
        }
        for (int t = 0; t < getTacticsCount(); t++) {
            getTactic(t).setParent(this);
        }
    }
    
    /**
     * Converts the model import back to the super class types.
     * 
     * @param imp the import (may be <b>null</b>)
     * @return the converted import (<b>null</b> if <code>imp</code> is null)
     */
    private static ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> 
        convert(ModelImport<Script> imp) {
        
        // not nice, to be removed if rt-VIL and VIL are unified in the future
        ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> result;
        if (null != imp) {
            result = new ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>(
                imp.getName(), imp.isConflict(), imp.getVersionRestriction());
            try {
                result.setResolved(imp.getResolved());
            } catch (ModelManagementException e) {
                // shall not happen
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts the script descriptor back to the super class types.
     * 
     * @param desc the descriptor
     * @return the converted descriptor
     */
    private static ScriptDescriptor<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> 
        convert(ScriptDescriptor<Script> desc) {
        
        // not nice, to be removed if rt-VIL and VIL are unified in the future
        Imports<Script> sImps = desc.getImports();
        List<ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>> imp;
        imp = new ArrayList<
            ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>>();
        for (int i = 0; i < sImps.getImportsCount(); i++) {
            imp.add(convert(sImps.getImport(i)));
        }
        List<ModelImport<Template>> vtl = new ArrayList<ModelImport<Template>>();
        for (int i = 0; i < sImps.getVtlRestrictionsCount(); i++) {
            vtl.add(sImps.getVtlRestriction(i));
        }
        Imports<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> imps;
        imps = new Imports<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>(imp, vtl);
        return new ScriptDescriptor<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>(
            desc.getParameters(), desc.getAdvices(), imps);
    }

    /**
     * Creates implicit variables.
     * 
     * @see #isImplicit(VariableDeclaration)
     */
    protected void createImplicitVariables() {
        // no implicit variables for now
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IRtVilVisitor) {
            result = ((IRtVilVisitor) visitor).visitScript(this);
        } else {
            result = visitor.visitScript(this);
        }
        return result;
    }
    
    /**
     * Returns whether this script was already executed (initialization).
     * 
     * @return <code>true</code> if it was already executed, <code>false</code> else
     * @see #markAsExecuted()
     */
    public boolean wasExecuted() {
        return wasExecuted;
    }
    
    /**
     * Marks this script as executed.
     */
    public void markAsExecuted() {
        wasExecuted = true;
    }

    //TODO getOperations
    //TODO getSuper

    @Override
    protected void reload() {
        RtVilModel.INSTANCE.reload(this);
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return new RuntimeEnvironment();
    }

    /**
     * Returns the number of strategies stored in this script.
     * 
     * @return the number of strategies
     */
    public int getStrategiesCount() {
        return strategies.size();
    }

    /**
     * Adds the specified strategy to this script.
     * 
     * @param strategy the strategy to be added (<b>null</b> is ignored)
     */
    public void addStrategy(Strategy strategy) {
        if (null != strategy) {
            strategies.add(strategy);
            strategy.setParent(this);
        }
    }
    
    /**
     * Returns the specified strategy.
     * 
     * @param index the 0-based index of the strategy to return
     * @return the specified strategy
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getStrategiesCount}</code>
     */
    public Strategy getStrategy(int index) {
        return strategies.get(index);
    }
    
    /**
     * Returns the number of tactics stored in this script.
     * 
     * @return the number of tactics
     */
    public int getTacticsCount() {
        return tactics.size();
    }
    
    /**
     * Adds the specified tactic to this script.
     * 
     * @param tactic the tactic to be added (<b>null</b> is ignored)
     */
    public void addTactic(Tactic tactic) {
        if (null != tactic) {
            tactics.add(tactic);
            tactic.setParent(this);
        }
    }

    /**
     * Returns the specified tactic.
     * 
     * @param index the 0-based index of the tactic to return
     * @return the specified tactic
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getTacticsCount}</code>
     */
    public Tactic getTactic(int index) {
        return tactics.get(index);
    }
    
    @Override
    public int getOperationsCount() {
        // partition the access over extended operations
        return strategies.size() + tactics.size() + super.getOperationsCount();
    }

    @Override
    public IMetaOperation getOperation(int index) {
        // partition the access over extended operations
        IMetaOperation result = null;
        int sSize = getStrategiesCount();
        if (index < sSize) {
            result = getStrategy(index);
        } else {
            int tSize = getTacticsCount();
            if (index < sSize + tSize) {
                result = getTactic(index - sSize);
            } else {
                result = super.getOperation(index - sSize - tSize);
            }
        }
        return result;
    }
    
    /**
     * Collects all explicitly called strategies.
     * 
     * @param result the strategies
     * @param done the visited scripts, non-recursive if <b>null</b>
     */
    private void collectStrategies(HashSet<Strategy> result, HashSet<Script> done) {
        if (null == done || !done.contains(this)) {
            if (done != null) {
                done.add(this);
            }
            for (int s = 0; s < getStrategiesCount(); s++) {
                Strategy strategy = getStrategy(s);
                for (int b = 0; b < strategy.getBodyElementCount(); b++) {
                    IRuleElement elt = strategy.getBodyElement(b);
                    if (elt instanceof StrategyCall) {
                        StrategyCall call = (StrategyCall) elt;
                        Strategy resolved = call.getResolved();
                        if (null != resolved) {
                            result.add(resolved);
                        }
                    }
                }
            }
            if (done != null) {
                for (int i = 0; i < getImportsCount(); i++) {
                    Script imp = (Script) getImport(i).getResolved();
                    if (imp != null) {
                        imp.collectStrategies(result, done);
                    }
                }
            }
        }
    }

    /**
     * Returns the top-level strategies, i.e., strategies that are not referenced and
     * comply to the parameters of the script so that they can be called directly. This
     * is the default call and includes referenced strategies.
     * 
     * @param considerImports consider the imports of the scripts
     * @param allStrategies just all strategies or all matching strategies
     * 
     * @return the top-level strategies
     */
    public List<Strategy> getTopLevelStrategies(boolean considerImports, boolean allStrategies) {
        return getTopLevelStrategies(considerImports, allStrategies, false);
    }
    
    /**
     * Returns the top-level strategies, i.e., strategies that are not referenced and
     * comply to the parameters of the script so that they can be called directly.
     * 
     * @param considerImports consider the imports of the scripts
     * @param allStrategies just all strategies or all matching strategies
     * @param excludeReferenced whether referenced strategies shall count as top-level strategies or not
     * 
     * @return the top-level strategies
     */
    public List<Strategy> getTopLevelStrategies(boolean considerImports, boolean allStrategies, 
        boolean excludeReferenced) {
        List<Strategy> result = new ArrayList<Strategy>();
        
        // hash first all those that are referenced
        HashSet<Strategy> strategies = new HashSet<Strategy>();
        HashSet<Script> done = considerImports ? new HashSet<Script>() : null;
        if (excludeReferenced) {
            collectStrategies(strategies, done);
        }
        // return then those that are not hashed / referenced
        for (int s = 0; s < getStrategiesCount(); s++) {
            Strategy strategy = getStrategy(s);
            if (!strategies.contains(strategy)) {
                boolean matchesScript;
                if (allStrategies) {
                    matchesScript = true;
                } else if (getParameterCount() == 0) {
                    matchesScript = 0 == strategy.getParameterCount();
                } else {
                    matchesScript = true;
                    int maxCommonCount = Math.min(getParameterCount(), strategy.getParameterCount());
                    for (int p = 0; matchesScript && p < maxCommonCount; p++) {
                        matchesScript = getParameter(p).getType().isAssignableFrom(strategy.getParameterType(p));
                    }
                }
                if (matchesScript) {
                    result.add(strategy);
                }
            }
        }
        return result;
    }

    @Override
    public String getLanguageName() {
        return "rt-VIL";
    }

}
