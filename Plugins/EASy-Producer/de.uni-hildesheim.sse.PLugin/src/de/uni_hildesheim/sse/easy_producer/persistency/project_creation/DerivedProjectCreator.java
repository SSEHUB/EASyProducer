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
package de.uni_hildesheim.sse.easy_producer.persistency.project_creation;

import de.uni_hildesheim.sse.easy_producer.Activator;
import de.uni_hildesheim.sse.easy_producer.EASyUtils;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ExpressionStatement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.IRuleElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.InstantiateExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.MapExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlTypes;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;

/**
 * Creates a derived EASy project, which will have one predecessor.
 * @author El-Sharkawy
 *
 */
class DerivedProjectCreator extends AbstractProjectCreator {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(AbstractProjectCreator.class,
        Activator.PLUGIN_ID);
    
    private String predecessorID;
    
    
    /**
     * Creates a new derived {@link ProductLineProject}.
     * @param projectName The name of the new project (should already be checked, whether the name is valid).
     * @param predecessorID The projectID of a predecessor for the new project, must not be <tt>null</tt>.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before.
     * @param configurators Optional list of configurators to configure the newly created project, maybe <tt>null</tt>.
     *     The configurators whill be applied in the ordering of the array.
     */
    DerivedProjectCreator(String projectName, String predecessorID, boolean lazy,
        IEASyProjectConfigurator[] configurators) {
        
        super(projectName, lazy, configurators);
        this.predecessorID = predecessorID;
    }

    /**
     * Creates the derived {@link ProductLineProject}.
     * @return The newly created {@link ProductLineProject}.
     */
    @Override
    ProductLineProject createEASyProject() {
        super.createProject();
        ProductLineProject parentPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(predecessorID);

        // Set Predecessors
        getCreatedProject().getMemberController().addPredecessor(predecessorID);
        
        // Support old EASy project, which do not contain any build scripts
        boolean hasBuildScript = null != parentPLP.getBuildScript();
        EASyUtils.addImport(getCreatedProject(), parentPLP, hasBuildScript);

        // Save parent plp
        parentPLP.save();

        // Set Successor
        parentPLP.getMemberController().addSuccessor(getCreatedProject().getProjectID());

        // Configure the newly created PTN
        getCreatedProject().pullConfigFromPredecessors();
        createScriptImports();
        getCreatedProject().save();

        // Sets persistence properties for the newly created project and refreshes the workspace/models
        super.setPersistenceProperties();
   
        return getCreatedProject();
    }

    /**
     * Adds call to build script of predecessor to own build script.
     */
    protected void createScriptImports() {
        Script mainScript = getCreatedProject().getBuildScript();
        Rule mainRule = mainScript.getMainRule(true);
        
        PLPInfo parentPLP = SPLsManager.INSTANCE.getPLP(predecessorID);
        Script parentScript = parentPLP.getBuildScript();
        
        Script resolved = null;
        for (int i = 0; i < mainScript.getImportsCount() && resolved == null; i++) {
            ModelImport<?> scriptImport = mainScript.getImport(i);
            if (scriptImport.getName().equals(parentScript.getName())) {
                resolved = (Script) scriptImport.getResolved();
            }
            
        }
        
        if (null != resolved) {
            
            // If empty, call "instantiate p : source.predecessors()"
            if (mainRule.getBodyElementCount() == 0) {
                createDefaultRuleContent(mainRule);
            }
            
        }
    }
    
    /**
     * Adds a default call to main rule in build script. <br/>
     * In this case, this method tries to add a "instantiate all predecessors" call to the main rule.
     * @param mainRule The main rule of the current (derived) project, where the changes should be added to.
     */
    protected void createDefaultRuleContent(Rule mainRule) {
        try {
            // Create variable for iteration
            VariableDeclaration p = new VariableDeclaration("p", IvmlTypes.projectType());
            
            // Create: source.predecessors()
            Expression sourceVar = new VariableExpression(mainRule.getParameter(0));
            Expression predecessorAccess = new CallExpression(mainRule, "predecessors", sourceVar);
            // Resolve expression
            predecessorAccess.inferType();
            
            // Create body: instantiate call
            CallArgument sourceProject = new CallArgument(new VariableExpression(p));
            CallArgument config = new CallArgument(new VariableExpression(mainRule.getParameter(1)));
            CallArgument targetProject = new CallArgument(new VariableExpression(mainRule.getParameter(2)));
            Expression mapBody = new InstantiateExpression(p, null, null, sourceProject, config, targetProject);
            // Resolve expression
            mapBody.inferType();
            
            // Create map
            ExpressionStatement bodyStatement = new ExpressionStatement(mapBody);
            VariableDeclaration[] mapVariables = {p};
            MapExpression map = new MapExpression(mapVariables, predecessorAccess, new IRuleElement[]{bodyStatement},
                null, true);
            ExpressionStatement mapStatement = new ExpressionStatement(map);
            
            // Set body of main rule
            mainRule.setBody(new IRuleElement[] {mapStatement});
            
            // If changes where successful (no exception occurred, notify model that script was edited.
            getCreatedProject().buildScriptWasEdited();
        } catch (ExpressionException e) {
            LOGGER.warn("Rule could not be modified. Reason: " + e.getMessage());
        } catch (VilLanguageException e) {
            LOGGER.warn("Rule could not be modified. Reason: " + e.getMessage());
        }    
    }
}
