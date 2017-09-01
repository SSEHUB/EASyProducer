/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.common.Advice;
import net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.VarModelIdentifierExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypeResolver;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;

/**
 * A specific template language execution for replacting VTL expressions/variables.
 * 
 * @author Holger Eichelberger
 */
public class TemplateSubstitutionExecution extends TemplateLangExecution {

    /**
     * Creates a new substitution evaluation visitor and initializes the runtime environment.
     * 
     * @param tracer the tracer instance for testing
     * @param modelName the name of the temporary template model for this execution
     * @param addAdvice add an advice to the project underlying <code>config</code>
     * @param config the configuration to take values from
     * @throws VilException if initializing the runtime environment fails
     */
    public TemplateSubstitutionExecution(ITracer tracer, String modelName, boolean addAdvice, Configuration config) 
        throws VilException {
        super(tracer, new StringWriter(), createParams(config));
        RuntimeEnvironment<VariableDeclaration> environment = getRuntimeEnvironment();
        // environment uses default registry - create a new one, add the type resolver if needed and inject it via 
        // switch context into the environment
        TypeRegistry registry = new TypeRegistry(TypeRegistry.DEFAULT);
        TemplateDescriptor desc = new TemplateDescriptor();
        if (addAdvice) {
            Advice[] advices = new Advice[1];
            net.ssehub.easy.varModel.model.Project prj = config.getConfiguration().getProject();
            advices[0] = new Advice(prj.getName(), null, prj);
            desc.setAdvices(advices);
            registry.addTypeResolver(new IvmlTypeResolver(prj, registry));
        }
        Template model = new Template(modelName, null, desc, registry);
        environment.switchContext(model);
        environment.addValue(new VariableDeclaration("config", IvmlTypes.configurationType()), config);
    }

    /**
     * Creates the parameter set for initializing the super class.
     * 
     * @param config the configuration to take values from
     * @return the parameter set
     */
    private static Map<String, Object> createParams(Configuration config) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(TemplateLangExecution.PARAM_CONFIG, config);
        params.put(TemplateLangExecution.PARAM_TARGET, null);
        return params;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws VilException {
        Object res = super.visitVarModelIdentifierExpression(identifier);
        if (res instanceof IvmlElement) { // resolve here immediately
            res = ((IvmlElement) res).getValue();
        }
        return res;
    }

}
