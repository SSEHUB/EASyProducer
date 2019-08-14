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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * This class contains keywords and constants related to ivml files.
 * 
 * @author El-Sharkawy
 */
public class IvmlKeyWords extends OclKeyWords {
    
    // Having constants for this purpose is indeed a good idea. Interface was ok
    // but turned into a class in order to unify it with OclKeywords. Made public
    // so that also the grammar mechanism may use the constants.
    
    //Keywords
    /**
     * <b>IVML Keyword:</b> Keyword for the project.
     */
    public static final String PROJECT = "project";
    
    /**
     * <b>IVML Keyword:</b> Keyword for the version.
     */
    public static final String VERSION = "version";
    
    /**
     * <b>IVML Keyword:</b> Keyword for import.
     */
    public static final String IMPORT = "import";

    /**
     * <b>IVML Keyword:</b> Keyword for conflicts.
     */
    public static final String CONFLICTS = "conflicts";

    /**
     * <b>IVML Keyword:</b> Keyword for abstract (compounds).
     */
    public static final String ABSTRACT = "abstract";
    
    /**
     * <b>IVML Keyword:</b> Keyword for the compound.
     */
    public static final String COMPOUND = "compound";
    
    /**
     * <b>IVML Keyword:</b> Keyword for the enum.
     */
    public static final String ENUM = "enum";

    /**
     * <b>IVML Keyword:</b> Keyword for eval.
     */
    public static final String EVAL = "eval";

    /**
     * <b>IVML Keyword:</b> Keyword for freeze.
     */
    public static final String FREEZE = "freeze";

    /**
     * <b>IVML Keyword:</b> Keyword for but.
     */
    public static final String BUT = "but";
    
    /**
     * <b>IVML Keyword:</b> Keyword for the typedef.
     */
    public static final String TYPEDEF = "typedef";

    /**
     * <b>IVML Keyword:</b> Keyword for the with.
     */
    public static final String WITH = "with";
    
    /**
     * <b>IVML Keyword:</b> Keyword for sequence.
     */
    public static final String SEQUENCEOF = "sequenceOf";
    
    /**
     * <b>IVML Keyword:</b> Keyword for a set.
     */
    public static final String SETOF = "setOf";

    /**
     * <b>IVML Keyword:</b> Keyword for a reference declaration.
     */
    public static final String REFTO = "refTo";

    /**
     * <b>IVML Keyword:</b> Keyword for a reference use (dereferencing).
     */
    public static final String REFBY = "refBy";

    /**
     * <b>IVML Keyword:</b> Keyword for refines.
     */
    public static final String REFINES = "refines";

    /**
     * <b>IVML Keyword:</b> Keyword for interface.
     */
    public static final String INTERFACE = "interface";

    /**
     * <b>IVML Keyword:</b> Keyword for export.
     */
    public static final String EXPORT = "export";

    /**
     * <b>IVML Keyword:</b> Keyword for if.
     */
    public static final String IF = "if";

    /**
     * <b>IVML Keyword:</b> Keyword for then.
     */
    public static final String THEN = "then";

    /**
     * <b>IVML Keyword:</b> Keyword for else.
     */
    public static final String ELSE = "else";

    /**
     * <b>IVML Keyword:</b> Keyword for endif.
     */
    public static final String ENDIF = "endif";

    /**
     * <b>IVML Keyword:</b> Keyword for let.
     */
    public static final String LET = "let";
    
    /**
     * <b>IVML Keyword:</b> Keyword for "in".
     */
    public static final String IN = "in";

    /**
     * <b>IVML Keyword:</b> Keyword for "def".
     */
    public static final String DEF = "def";

    /**
     * <b>IVML Keyword:</b> Keyword for "static".
     */
    public static final String STATIC = "static";
    
    /**
     * <b>IVML Keyword:</b> Keyword for "annotate".
     */
    public static final String ATTRIBUTE = "annotate";

    /**
     * <b>IVML Keyword:</b> Keyword for "assign".
     */
    public static final String ASSIGN = "assign";
    
    /**
     * <b>IVML Keyword:</b> Keyword for "to".
     */
    public static final String TO = "to";

    /**
     * <b>IVML Keyword:</b> Keyword for "null".
     */
    public static final String NULL = "null";

    /**
     * <b>IVML Keyword:</b> Keyword for "const".
     */
    public static final String CONST = "const";

    //Characters

    /**
     * <b>IVML Character:</b> Whitespace.
     */
    public static final String WHITESPACE = " ";

    /**
     * <b>IVML Character:</b> Operation definition separator.
     */
    public static final String OPDEF_SEPARATOR = "=";
    
    /**
     * <b>IVML Character:</b> namespace separator.
     */
    public static final String NAMESPACE_SEPARATOR = "::";
    
    /**
     * <b>IVML Character:</b> Version start symbol.
     */
    public static final String VERSION_START = "v";
    
    /**
     * <b>IVML Character:</b> Left brackets for the beginning of an block.
     */
    public static final String BEGINNING_BLOCK = "{";
    
    /**
     * <b>IVML Character:</b> Right brackets for the ending of an block.
     */
    public static final String ENDING_BLOCK = "}";

    /**
     * <b>IVML Character:</b> Left brackets for the beginning of a parenthesis.
     */
    public static final String BEGINNING_PARENTHESIS = "(";
    
    /**
     * <b>IVML Character:</b> Right brackets for the ending of a parenthesis.
     */
    public static final String ENDING_PARENTHESIS = ")";

    // chars may speed up string search operations...
    
    /**
     * <b>IVML Character:</b> "." for compound access. Same as {@link #ATTRIBUTE_ACCESS} and
     * {@link #ENUM_ACCESS} but may change due to known grammar problems accessing compounds
     * from an expression.
     */
    public static final char COMPOUND_ACCESS = '.';

    /**
     * <b>IVML Character:</b> "." for enum access. Same as {@link #COMPOUND_ACCESS} and
     * {@link #ATTRIBUTE_ACCESS} but may change due to known grammar problems accessing compounds
     * from an expression.
     */
    public static final char ENUM_ACCESS = '.';

    /**
     * <b>IVML Character:</b> "{@value}" for attribute access. Same as {@link #COMPOUND_ACCESS} and
     * {@link #ENUM_ACCESS} but may change due to known grammar problems accessing compounds
     * from an expression.
     */
    public static final char ATTRIBUTE_ACCESS = '.';

    /**
     * <b>IVML Character:</b> "{@value}" for separating decimal numbers.
     */
    public static final char DECIMAL_SEPARATOR = '.';

    /**
     * <b>IVML Character:</b> "->" for container operation access.
     */
    public static final String CONTAINER_OP_ACCESS = "->";
    
    /**
     * <b>IVML Character:</b> Linefeed.
     */
    public static final String LINEFEED = "\r\n";
    
    /**
     * <b>IVML Character:</b> Semicolon.
     */
    public static final String SEMICOLON = ";";

    /**
     * <b>IVML Character:</b> Colon.
     */
    public static final String COLON = ":";
    
    /**
     * <b>IVML Character:</b> Comma.
     */
    public static final String COMMA = ",";

    /**
     * <b>IVML Character:</b> Pipe.
     */
    public static final String PIPE = "|";
    
    /**
     * <b>IVML Character:</b> "{@value}".
     */
    public static final String EQUALS = "==";

    /**
     * <b>IVML Character:</b> "{@value}".
     */
    public static final String ASSIGNMENT = "=";
    
    /**
     * <b>IVML Character:</b> Quotes.
     */
    public static final String QUOTES = "\"";

    /**
     * IVML DSL context start.
     */
    public static final String DSL_CONTEXT_START = "DSL(";
    
    /**
     * IVML DSL context end.
     */
    public static final String DSL_CONTEXT_END = ")";

    /**
     * IVML DSL program start.
     */
    public static final String DSL_START = "%";
    
    /**
     * IVML DSL program end.
     */
    public static final String DSL_END = "DSL%";
    
    /**
     * Shortcut for this project.
     */
    public static final String THIS_PROJECT = ".";

    /**
     * Prevents this class from being initialized from outside.
     */
    private IvmlKeyWords() {
    }

}
