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
package de.uni_hildesheim.sse.model.varModel;

import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.BEGINNING_PARENTHESIS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.ENDING_PARENTHESIS;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.REFTO;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.SEQUENCEOF;
import static de.uni_hildesheim.sse.model.varModel.IvmlKeyWords.SETOF;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.DatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.QualifiedNameMode;

/**
 * Implements a default datatype visitor for IVML.
 * 
 * @author Holger Eichelberger
 */
public class IvmlDatatypeVisitor extends DatatypeVisitor {

    private static final List<IvmlDatatypeVisitor> INSTANCES = new ArrayList<IvmlDatatypeVisitor>();

    /**
     * Constructs a default visitor.
     */
    IvmlDatatypeVisitor() {
        super(SETOF, SEQUENCEOF, REFTO, BEGINNING_PARENTHESIS, ENDING_PARENTHESIS);
    }

    /**
     * Obtains an instance. Must be released using {@link #release(IvmlDatatypeVisitor)}.
     * 
     * @param mode the name mode
     * 
     * @return the default visitor
     */
    public static final synchronized IvmlDatatypeVisitor getInstance(QualifiedNameMode mode) {
        IvmlDatatypeVisitor result;
        if (!INSTANCES.isEmpty()) {
            result = INSTANCES.remove(INSTANCES.size() - 1);
        } else {
            result = new IvmlDatatypeVisitor();
        }
        result.setQualifiedNameMode(mode);
        return result;
    }
    
    /**
     * Releases (and clears) a given visitor.
     * 
     * @param visitor the visitor being released
     */
    public static final synchronized void release(IvmlDatatypeVisitor visitor) {
        visitor.clear();
        INSTANCES.add(visitor);
    }
    
    /**
     * Returns the textual representation of the given type using an instance of this class.
     * (convenience)
     * 
     * @param type the type to be represented
     * @param mode the name mode
     * @return the textual representation
     */
    public static final String getType(IDatatype type, QualifiedNameMode mode) {
        IvmlDatatypeVisitor instance = getInstance(mode);
        String result = instance.getType(type);
        release(instance);
        return result;
    }
 
    /**
     * Returns the textual representation of the given type based on the unique name using 
     * an instance of this class. (convenience)
     * 
     * @param type the type to be represented
     * @return the textual representation
     */
    public static final String getUniqueType(IDatatype type) {
        return getType(type, QualifiedNameMode.UNIQUE);
    }

    /**
     * Returns the textual representation of the given type based on the qualified name using 
     * an instance of this class. (convenience)
     * 
     * @param type the type to be represented
     * @return the textual representation
     */
    public static final String getQualifiedType(IDatatype type) {
        return getType(type, QualifiedNameMode.QUALIFIED);
    }

    /**
     * Returns the textual representation of the given type based on the unqualified name using 
     * an instance of this class. (convenience)
     * 
     * @param type the type to be represented
     * @return the textual representation
     */
    public static final String getUnqualifiedType(IDatatype type) {
        return getType(type, QualifiedNameMode.UNQUALIFIED);
    }

}