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
package net.ssehub.easy.varModel.persistency;

import java.io.StringWriter;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IPartialEvaluable;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Turns model (parts) into strings.
 * 
 * @author Holger Eichelberger
 * @author Christian Kröher
 */
public class StringProvider {

    /**
     * Turns a model element into a string containing IVML.
     * 
     * @param element the element to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(ModelElement element) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        element.accept(visitor);
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;
    }

    /**
     * Turns a syntax tree into a string containing IVML (without context).
     * 
     * @param cst the constraint syntax tree to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(ConstraintSyntaxTree cst) {
        return toIvmlString(cst, null);
    }
    
    /**
     * Turns a syntax tree into a string containing IVML.
     * 
     * @param cst the constraint syntax tree to be turned into a string
     * @param context the context within the <code>cst</code> shall be printed, e.g., to exploit implicitly qualified 
     *     variable names
     * @return The resulting string
     */
    public static final String toIvmlString(ConstraintSyntaxTree cst, IModelElement context) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        int parAdded = 0;
        if (null != context) {
            visitor.addParent(IVMLWriter.DUMMY_PARENT);
            parAdded++;
            IModelElement iter = context;
            while (null != iter && !(iter instanceof Project)) {
                iter = iter.getParent();
            }
            if (null != iter && iter != context) {
                visitor.addParent(iter);
                parAdded++;
            }
            visitor.addParent(context);
            parAdded++;
        }
        cst.accept(visitor);
        if (null != context) {
            while (parAdded > 0) {
                visitor.removeLastParent();
                parAdded--;
            }
        }
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;        
    }
    
    /**
     * Turns a value into a string containing IVML.
     * 
     * @param value the value to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(Value value) {
        String result;
        if (null != value) {
            StringWriter writer = new StringWriter();
            IVMLWriter visitor = IVMLWriter.getInstance(writer);
            value.accept(visitor);
            result = writer.toString();
            IVMLWriter.releaseInstance(visitor);
        } else {
            result = "";
        }
        return result;        
    }
    
    /**
     * Turns a type into a string containing IVML.
     * 
     * @param type the type to be turned into a string
     * @return The resulting string as unique string using {@link IvmlDatatypeVisitor}
     */
    public static final String toIvmlString(IDatatype type) {
        return IvmlDatatypeVisitor.getUniqueType(type);
    }
    
    /**
     * Turns an evaluable element into a string containing IVML.
     * 
     * @param element the evaluable element to be turned into a string
     * @return The resulting string
     */
    public static final String toIvmlString(IPartialEvaluable element) {
        StringWriter writer = new StringWriter();
        IVMLWriter visitor = IVMLWriter.getInstance(writer);
        element.accept(visitor);
        String result = writer.toString();
        IVMLWriter.releaseInstance(visitor);
        return result;
    }
    
}
