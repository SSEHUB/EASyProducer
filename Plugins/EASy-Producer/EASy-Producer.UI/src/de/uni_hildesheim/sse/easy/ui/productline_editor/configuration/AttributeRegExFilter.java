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
package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * Implements a simple attribute filter.
 * 
 * @author Holger Eichelberger
 */
public class AttributeRegExFilter extends AbstractConfigurationFilter {
    
    private Pattern attrPattern;
    private Pattern valuePattern;

    /**
     * Creates an attribute filter.
     * 
     * @param attributeNameRegEx a regular expression for matching attribute names
     * @param valueRegEx a regular expression for matching the textual representation of values
     * @param showAllNestedElements whether nested elements of a shown variable will also be filtered
     * 
     * @throws PatternSyntaxException in case of an erroneous pattern syntax
     */
    public AttributeRegExFilter(String attributeNameRegEx, String valueRegEx, boolean showAllNestedElements) 
        throws PatternSyntaxException {
        super(showAllNestedElements);
        attrPattern = Pattern.compile(attributeNameRegEx);
        valuePattern = Pattern.compile(valueRegEx);
    }

    @Override
    protected boolean checkVariable(GUIVariable variable) {
        IDecisionVariable var = variable.getVariable();
        boolean display = false;
        for (int a = 0; !display && a < var.getAttributesCount(); a++) {
            IDecisionVariable attr = var.getAttribute(a);
            Value value = attr.getValue();
            if (null != value) {
                Matcher matcher = attrPattern.matcher(attr.getDeclaration().getName());
                if (matcher.matches()) {
                    String valueText = StringProvider.toIvmlString(value);
                    matcher = valuePattern.matcher(valueText);
                    display = matcher.matches();
                }
            }
        }
        return display || checkVariableRecursivley(variable);
    }
    
}