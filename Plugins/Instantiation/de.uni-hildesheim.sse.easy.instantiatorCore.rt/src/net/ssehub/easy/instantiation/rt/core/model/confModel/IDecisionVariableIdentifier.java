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
package net.ssehub.easy.instantiation.rt.core.model.confModel;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.IvmlKeyWords;

/**
 * Uses {@link IDecisionVariable}s to identify temporary value mappings inside the {@link AdaptiveConfiguration}.
 * @author El-Sharkawy
 */
public class IDecisionVariableIdentifier extends AbstractVariableIdentifier<IDecisionVariable> {
    
    private static final String SEPARATOR = IvmlKeyWords.NAMESPACE_SEPARATOR;

    @Override
    protected String variableToID(IDecisionVariable variable) {
        return variable.getQualifiedName();
    }

    @Override
    protected boolean isNestedVariable(String id) {
        return null != id && StringUtils.countMatches(id, SEPARATOR) > 1;
    }

    @Override
    protected String iDecisionVariableToID(IDecisionVariable variable) {
        return variableToID(variable);
    }

    @Override
    protected Iterator<String> getIDIterator(final String id) {
        return new Iterator<String>() {
            private String[] segments = id.split(SEPARATOR);
            private int index = 1;

            @Override
            public boolean hasNext() {
                return segments.length > index; 
            }

            @Override
            public String next() {
                String id;
                if (1 == index) {
                    id = segments[0] + SEPARATOR + segments[1];
                    index++;
                } else {
                    id = segments[index++];
                }
                
                return id;
            }
        };
    }

}
