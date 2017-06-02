/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.DefaultImportResolver;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;

/**
 * A specific resolver for VIL enabling calls to VTL.
 * 
 * @author Holger Eichelberger
 */
public class BuildLangImportResolver extends DefaultImportResolver<Script> {

    @Override
    protected void cannotResolveImport(ModelImport<Script> imp, List<IMessage> messages, 
        URI modelURI, IRestrictionEvaluationContext context) {
        try {
            Template template = TemplateModel.INSTANCE.resolve(imp.getName(), 
                imp.getVersionRestriction(), modelURI, context);
            if (null != template && 2 == template.getParameterCount()) {
                Script tmpScript = new Script(template.getName());
                for (int d = 0; d < template.getDefCount(); d++) {
                    Def def = template.getDef(d);
                    if (!def.isProtected()) {
                        tmpScript.addRule(new VtlRule(def, tmpScript));
                    }
                }
                imp.setResolved(tmpScript);
            } else {
                super.cannotResolveImport(imp, messages, modelURI, context);
            }
        } catch (ModelManagementException e) {
            messages.add(new Message(e.getMessage(), Status.ERROR));
        }
    }

}
