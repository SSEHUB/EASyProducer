/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.common.AbstractResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.IResolvableModel;
import net.ssehub.easy.instantiation.core.model.common.IVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaField;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

/**
 * Creates a project which is the top-level element of a build script VIL-model.
 * Scripts represent an implicit type, i.e., they are not registered with the 
 * {@link net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry} and, thus, not
 * assignable.
 * 
 * @author kroeher
 */
public class Script extends AbstractResolvableModel<VariableDeclaration, Script> 
    implements IBuildlangElement, IResolvableModel<VariableDeclaration, Script>,
    IVariableDeclarationReceiver<VariableDeclaration> {

    /**
     * Defines the default start rule name.
     */
    public static final String DEFAULT_START_RULE_NAME = "main";
    
    public static final String NAME_OTHERPROJECTS = "OTHERPROJECTS";
    public static final String NAME_SCRIPTDIR = "SCRIPTDIR";
    
    private static final Set<String> IMPLICIT_VARS;
    
    static {
        IMPLICIT_VARS = new HashSet<String>();
        IMPLICIT_VARS.add(NAME_OTHERPROJECTS);
        IMPLICIT_VARS.add(NAME_SCRIPTDIR);
    }

    private String name;
    private Version version;
    private ModelImport<Script> parent;
    private VariableDeclaration[] parameters;
    private java.util.Map<String, VariableDeclaration> namedParams;
    private List<VariableDeclaration> declarations;
    private List<AbstractRule> rules;
    private List<LoadProperties> loadProperties;

    /**
     * A descriptor class used for creating scripts (maximum parameter constraint).
     * 
     * @param <S> the script type
     * @author Holger Eichelberger
     */
    public static class ScriptDescriptor<S extends Script> {

        private VariableDeclaration[] parameters;
        private Advice[] advices;
        private Imports<S> imports;

        /**
         * Creates a script descriptor.
         * 
         * @param parameters the formal parameters of this script
         * @param advices the advices (may be <b>null</b>)
         * @param imports the imports (may be <b>null</b>)
         */
        public ScriptDescriptor(VariableDeclaration[] parameters, Advice[] advices, Imports<S> imports) {
            this.parameters = parameters;
            this.advices = advices;
            this.imports = imports;
        }

        /**
         * Returns the parameters.
         * 
         * @return the parameters
         */
        public VariableDeclaration[] getParameters() {
            return parameters;
        }
        
        /**
         * Returns the advices.
         * 
         * @return the avices
         */
        public Advice[] getAdvices() {
            return advices;
        }
        
        /**
         * Returns the imports.
         * 
         * @return the imports
         */
        public Imports<S> getImports() {
            return imports;
        }
        
    }

    /**
     * Constructor for serializer.
     */
    Script() {
        this(null, null, null, null);
    }

    /**
     * Constructor for a script without parent, parameters or advices and with the default
     * type registry.
     * 
     * @param name Name of the project.
     */
    public Script(String name) {
        this(name, TypeRegistry.DEFAULT);
    }

    /**
     * Constructor for a script without parent, parameters or advices.
     * 
     * @param name Name of the project.
     * @param registry the responsible registry
     */
    public Script(String name, TypeRegistry registry) {
        this(name, null, null, registry);
    }
    
    /**
     * Constructor for a script with parameters and default type registry.
     * 
     * @param name Name of the project.
     * @param parameters the formal parameters of this script
     */
    public Script(String name, VariableDeclaration[] parameters) {
        this(name, parameters, TypeRegistry.DEFAULT);
    }
    
    /**
     * Constructor for a script with parameters.
     * 
     * @param name Name of the project.
     * @param parameters the formal parameters of this script
     * @param registry the responsible registry
     */
    public Script(String name, VariableDeclaration[] parameters, TypeRegistry registry) {
        this(name, null, new ScriptDescriptor<Script>(parameters, null, null), registry);
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
    public Script(String name, ModelImport<Script> parent, ScriptDescriptor<Script> descriptor, TypeRegistry registry) {
        super(null == descriptor ? null : descriptor.imports, registry, null == descriptor ? null : descriptor.advices);
        this.name = name;
        this.parent = parent;
        this.version = null;
        this.loadProperties = new ArrayList<LoadProperties>();
        this.declarations = new ArrayList<VariableDeclaration>();
        this.rules = new ArrayList<AbstractRule>();        
        this.parameters = null == descriptor ? null : descriptor.parameters;
        this.namedParams = VariableDeclaration.mapDefaultedParameters(this.namedParams, this.parameters);
        createImplicitVariables();
        adjustParents();
    }
    
    /**
     * Adjusts the parents of contained elements.
     */
    private void adjustParents() {
        for (int r = 0; r < rules.size(); r++) {
            rules.get(r).setParent(this);
        }
        for (int p = 0; p < getParameterCount(); p++) {
            getParameter(p).setParent(this);
        }
        for (int d = 0; d < getVariableDeclarationCount(); d++) {
            getVariableDeclaration(d).setParent(this);
        }
    }
    
    @Override
    protected net.ssehub.easy.instantiation.core.model.common.Imports<Script> createImports() {
        return new Imports<Script>((Imports<Script>) null, null);
    }

    /**
     * Creates the default parameter for a VIL script.
     * 
     * @return the default parameter
     */
    public static VariableDeclaration[] createDefaultParameter() {
        VariableDeclaration[] param = new VariableDeclaration[3];
        param[0] = new VariableDeclaration("source", IvmlTypes.projectType());
        param[1] = new VariableDeclaration("config", IvmlTypes.configurationType());
        param[2] = new VariableDeclaration("target", IvmlTypes.projectType());
        return param;
    }
        
    /**
     * Creates implicit variables.
     * 
     * @see #isImplicit(VariableDeclaration)
     */
    protected void createImplicitVariables() {
        try {
            TypeDescriptor<?>[] tmp = TypeDescriptor.createArray(1);
            tmp[0] = IvmlTypes.projectType();
            declarations.add(new VariableDeclaration(NAME_OTHERPROJECTS, TypeRegistry.getSetType(tmp)));
            declarations.add(new VariableDeclaration(NAME_SCRIPTDIR, TypeRegistry.stringType()));
        } catch (VilException e) {
            EASyLoggerFactory.INSTANCE.getLogger(Script.class, Bundle.ID).exception(e);
        }
    }
    
    @Override
    public boolean isImplicit(VariableDeclaration decl) {
        return null != decl && IMPLICIT_VARS.contains(decl.getName());
    }

    @Override
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }
    
    @Override
    public VariableDeclaration getParameter(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    
    @Override
    public int getRequiredParameterCount() {
        return VariableDeclaration.getRequiredParameterCount(namedParams, parameters);
    }

    @Override
    public VariableDeclaration getParameter(String name) {
        return VariableDeclaration.getParameter(namedParams, name, parameters);
    }
    
    /**
     * Add a properties file to this project.
     * 
     * @param propFile The properties to be added.
     */
    public void addLoadProperties(LoadProperties propFile) {
        this.loadProperties.add(propFile);
    }
    
    /**
     * Adds a rule instance.
     * 
     * @param rule the rule instance
     */
    public void addRule(AbstractRule rule) {
        rules.add(rule);
        rule.setParent(this);
    }
    
    /**
     * Removes a rule instance.
     * 
     * @param rule the rule instance
     */
    public void removeRule(Rule rule) {
        rules.remove(rule);
    }
    
    /**
     * Adds a variable declaration.
     * 
     * @param varDecl the variable declaration
     */
    public void addVariableDeclaration(VariableDeclaration varDecl) {
        declarations.add(varDecl);
        varDecl.setParent(this);
    }
    
    /**
     * Get the name of this project.
     * 
     * @return The name of this project.
     */
    public String getName() {
        return this.name;
    }
    
    @Override
    public String getQualifiedName() {
        return this.name;
    }
    
    /**
     * Get the parent project which this project extends.
     * 
     * @return The parent project of this project or <code>null</code> if no parent is defined for this project.
     */
    public Script getParent() {
        Script result;
        if (null == parent) {
            result = null;
        } else {
            result = parent.getResolved();
        }
        return result;
    }
    
    /**
     * Get the version of this project.
     * 
     * @return The version of this project or <code>null</code> if no version is defined for this project.
     */
    public Version getVersion() {
        return this.version;
    }
    
    @Override
    public void setVersion(Version version) {
        this.version = version;
    }
    
    /**
     * Get the number of rules in this project.
     * 
     * @return The number of rules in this project.
     */
    public int getRuleCount() {
        return this.rules.size();
    }
    
    /**
     * Get the rule in this project at the specified index.
     * 
     * @param index The 0-based index of the rule to be returned.
     * @return The rule at the given index.
     */
    public AbstractRule getRule(int index) {
        return this.rules.get(index);
    }
    
    /**
     * Returns the index of the specified <code>rule</code>.
     * 
     * @param rule the rule to search for
     * @return <code>-1</code> if <code>rule</code> was not found, , the index of <code>rule</code> else
     */
    public int indexOf(Rule rule) {
        return rules.indexOf(rule);
    }
    
    /**
     * Returns the variable declaration with the specified <code>name</code>.
     * 
     * @param name the name of the variable declaration
     * @return the matching variable declaration, <b>null</b> else
     */
    public VariableDeclaration getVariableDeclaration(String name) {
        VariableDeclaration result = null;
        for (int d = 0; null == result && d < declarations.size(); d++) {
            VariableDeclaration decl = declarations.get(d);
            if (decl.getName().equals(name)) {
                result = decl; 
            }
        }
        return result;
    }
    
    /**
     * Get the number of variable declarations of this project.
     * 
     * @return The number of variable declarations of this project.
     */
    public int getVariableDeclarationCount() {
        return declarations.size();
    }
    
    /**
     * Get the declaration of this project at the specified index.
     * 
     * @param index The 0-based index of the declaration to be returned.
     * @return The declaration at the given index.
     */
    public VariableDeclaration getVariableDeclaration(int index) {
        return declarations.get(index);
    }
    
    /**
     * Get the number of properties to be loaded for this project.
     * 
     * @return The number of properties to be loaded for this project.
     */
    public int getPropertiesCount() {
        return loadProperties.size();
    }
    
    /**
     * Get the properties file of this project at the specified index.
     * 
     * @param index The 0-based index of the properties file to be returned.
     * @return The properties file at the given index.
     */
    public LoadProperties getProperties(int index) {
        return loadProperties.get(index);
    }    
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitScript(this);
    }

    @Override
    public int getOperationsCount() {
        return rules.size();
    }

    @Override
    public IMetaOperation getOperation(int index) {
        return rules.get(index);
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return false; // not a visible type, i.e., not assignable at all
    }

    @Override
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        return null; // no conversions defined on a script
    }

    @Override
    public ModelImport<Script> getSuper() {
        return parent;
    }

    @Override
    public int getExtensionTypesCount() {
        return 0; // no extension types in buildscript language
    }

    @Override
    public IMetaType getExtensionType(int index) {
        throw new IndexOutOfBoundsException(); // no extension types in buildscript language
    }

    @Override
    public IndentationConfiguration getIndentationConfiguration() {
        return null;
    }
    
    /**
     * Determines the start rule for script involving imported scripts.
     * 
     * @param startRuleName the start rule name (typically "main")
     * @return the start rule
     * @throws VilException in case that the start rule cannot be determined (uniquely)
     */
    public AbstractRule determineStartRule(String startRuleName) throws VilException {
        AbstractRule startRule = null;
        List<AbstractRule> roots = new ArrayList<AbstractRule>();
        collectRoots(new HashSet<Script>(), new HashSet<String>(), roots);
        if (roots.isEmpty()) {
            throw new VilException("no rule (without dependencies) to be executed", 
                VilException.ID_RUNTIME_STARTRULE); 
        }
        if (1 == roots.size() && null == startRuleName) {
            startRule = roots.get(0);
        } else {
            if (null == startRuleName) {
                StringBuilder tmp = new StringBuilder();
                for (int r = 0; r < roots.size(); r++) {
                    if (r > 0) {
                        tmp.append(", ");
                    }
                    tmp.append(roots.get(r).getJavaSignature());
                }
                throw new VilException("multiple possible start rules (" + tmp 
                     + ") but no start rule name specified", VilException.ID_RUNTIME_STARTRULE); 
            }
            int count = 0;
            for (int r = 0; r < roots.size(); r++) {
                AbstractRule rule = roots.get(r);
                if (rule.getName().equals(startRuleName)) {
                    startRule = rule;
                    count++;
                }
            }
            if (0 == count) {
                throw new VilException("no matching start rule found (check parameter, protected)", 
                    VilException.ID_RUNTIME_STARTRULE); 
            }
            if (count > 1) { // shall not happen
                throw new VilException("ambiguous matching start rules", 
                    VilException.ID_RUNTIME_STARTRULE); 
            }
        }
        return startRule;
    }

    /**
     * Finds the root rules.
     * 
     * @param processed already processed scripts (to be modified as a side effect)
     * @param knownSignatures the known signatures of already included rules (to be modified as a side effect)
     * @param roots the actual root rules (to be modified as a side effect)
     */
    private void collectRoots(java.util.Set<Script> processed, java.util.Set<String> knownSignatures, 
        List<AbstractRule> roots) {
        if (!processed.contains(this)) {
            processed.add(this);
            Set<AbstractRule> candidates = new HashSet<AbstractRule>();
            Set<AbstractRule> resolved = new HashSet<AbstractRule>();
            // store all rules for fast access; first all rules are candidates for roots
            for (int r = 0; r < getRuleCount(); r++) {
                AbstractRule rule = getRule(r);
                if (!rule.isProtected()) {
                    candidates.add(rule);
                }
            }
            
            // iterate over rules - remove those rules for which all preconditions are resolved
            int lastResolvedSize = resolved.size();
            do {
                Iterator<AbstractRule> iter = candidates.iterator();
                while (iter.hasNext()) {
                    AbstractRule rule = iter.next();
                    boolean allResolved = true;
                    for (int p = 0; allResolved && p < rule.getRuleCallCount(Side.RHS); p++) {
                        RuleCallExpression call = rule.getRuleCall(Side.RHS, p);
                        allResolved &= resolved.contains(call.getResolved()) || call.isSuper();
                    }
                    if (allResolved) {
                        resolved.add(rule);
                        iter.remove();
                    }
                }
            } while (!candidates.isEmpty() && resolved.size() != lastResolvedSize);

            // the case that we only have top-level rules
            if (candidates.isEmpty()) {
                candidates = resolved;
            }
            roots.addAll(candidates);

            // remaining candidates may be roots... but only if the parameters match the script
            /*for (Rule rule : candidates) {
                boolean paramOk = rule.getParameterCount() == script.getParameterCount();
                for (int p = 0; paramOk && p < rule.getParameterCount(); p++) {
                    VariableDeclaration rV = rule.getParameter(0);
                    VariableDeclaration sV = script.getParameter(0);
                    paramOk &= rV.getName().equals(sV.getName()) && sV.getType().isAssignableFrom(rV.getType());
                }
                if (paramOk) {
                    String sig = rule.getJavaSignature();
                    if (!knownSignatures.contains(sig)) {
                        roots.add(rule);
                    }
                }
            }*/
        }
    }
    
    /**
     * Returns the folder containing the physical model file.
     * 
     * @return the folder or <b>null</b> if this cannot be accessed
     */
    File getContainingFolder() {
        File result; 
        ModelInfo<Script> info = BuildModel.INSTANCE.availableModels().getModelInfo(this);
        if (null != info && null != info.getLocation()) {
            URI location = info.getLocation();
            result = new File(location);
            if (result.isFile()) {
                result = result.getParentFile();
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the default main rule of this script, i.e., a rule with name {@link #DEFAULT_START_RULE_NAME}
     * complying to the parameters of this script.
     * 
     * @param createIfAbsent if <code>true</code> create the rule if it does not exist, <code>false</code> just 
     *   return <b>null</b> if the rule does not exist
     * 
     * @return the main rule or <b>null</b>
     */
    public AbstractRule getMainRule(boolean createIfAbsent) {
        return getMainRule(DEFAULT_START_RULE_NAME, createIfAbsent);
    }
    
    /**
     * Returns the main rule of this script, i.e., a rule with <code>name</code>
     * complying to the parameters of this script.
     * 
     * @param createIfAbsent if <code>true</code> create the rule if it does not exist, <code>false</code> just 
     *   return <b>null</b> if the rule does not exist
     * @param name the name of the rule
     * @return the main rule or <b>null</b>
     */
    public AbstractRule getMainRule(String name, boolean createIfAbsent) {
        AbstractRule main = null;
        for (int r = 0; null == main && r < getRuleCount(); r++) {
            AbstractRule rule = getRule(r);
            if (rule.getName().equals(name)) {
                boolean ok = (rule.getParameterCount() == getParameterCount());
                for (int p = 0; ok && p < getParameterCount(); p++) {
                    ok = getParameter(p).getType().isAssignableFrom(rule.getParameter(p).getType());
                }
                if (ok) {
                    main = rule;
                }
            }
        }
        if (null == main && createIfAbsent) {
            VariableDeclaration[] param = new VariableDeclaration[getParameterCount()];
            for (int p = 0; p < param.length; p++) {
                VariableDeclaration sParam = getParameter(p);
                param[p] = new VariableDeclaration(sParam.getName(), sParam.getType());
            }
            main = new Rule(name, false, param, new RuleDescriptor(), this);
            rules.add(main);
        }
        return main;
    }

    @Override
    public boolean isBasicType() {
        return false;
    }
    
    @Override
    public boolean enableDynamicDispatch() {
        return true;
    }
    
    /**
     * Returns the imports instance.
     * 
     * @return the imports instance
     */
    @Override
    protected Imports<Script> getImports() {
        return (Imports<Script>) super.getImports();
    }
    
    /**
     * Returns the number of VTL restrictions.
     * 
     * @return the number of VTL restrictions
     */
    public int getVtlRestrictionsCount() {
        Imports<Script> imp = getImports();
        return null == imp ? 0 : imp.getVtlRestrictionsCount();
    }

    /**
     * Returns the specified VTL restriction.
     * 
     * @param index the 0-based index of the VTL restriction
     * @return the specified model import
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getVtlRestrictionsCount()}</code>
     */
    public ModelImport<Template> getVtlRestriction(int index) {
        Imports<Script> imp = getImports();
        if (null == imp) {
            throw new IndexOutOfBoundsException();
        }
        return imp.getVtlRestriction(index);
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }
    
    @Override
    public IMetaOperation addPlaceholderOperation(String name, int parameterCount, boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false; // shall not be handled by IActualTypeProvider
    }

    @Override
    protected void reload() {
        BuildModel.INSTANCE.reload(this);
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return new RuntimeEnvironment();
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public IMetaField getField(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isInternal() {
        return false;
    }

    @Override
    public IMetaType getSuperType() {
        return null;
    }
    
    @Override
    public int getGenericParameterCount() {
        return 0;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

    @Override
    public List<IMetaOperation> getCandidates(String name, int unnamedArgsCount) {
        return TypeDescriptor.getCandidates(this, name, unnamedArgsCount);
    }

}
