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
package net.ssehub.easy.varModel.model.datatypes;

/**
 * Defines constants for the OCL keywords for operations. Some IVML specific names are included.
 * For operations, reuse and also for testing.
 * 
 * @author Holger Eichelberger
 * @author Tebbje
 */
public class OclKeyWords {
    
    // e.g. because of shifting operation declaration between different datatypes.
    // no explicit relations between declaration name and related datatype.
    // => String got SIZE just like a Container/Set/Sequence also got SIZE.
    
    // e.g. AnyType
    public static final String EQUALS = "==";
    public static final String UNEQUALS = "<>";
    public static final String ASSIGNMENT = "=";
    public static final String IS_TYPE_OF = "isTypeOf";
    public static final String IS_KIND_OF = "isKindOf";
    public static final String LOCALE = "locale";
    
    // e.g. Boolean
    @IVMLKeyWord
    public static final String NOT = "not";
    @IVMLKeyWord
    public static final String OR = "or";
    @IVMLKeyWord
    public static final String XOR = "xor";
    @IVMLKeyWord
    public static final String AND = "and";
    @IVMLKeyWord
    public static final String IMPLIES = "implies";
    
    // e.g. Integer, Real
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULT = "*";
    public static final String DIV = "/";
    public static final String DIV_INT = "div";
    public static final String GREATER = ">";
    public static final String LESS = "<";
    public static final String GREATER_EQUALS = ">=";
    public static final String LESS_EQUALS = "<=";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String ABS = "abs";
    public static final String INVERSE = "-";
    public static final String FLOOR = "floor";
    public static final String ROUND = "round";
    public static final String MOD = "mod";
    public static final String WARNING = "warning";
    public static final String TO_STRING = "toString";
    
    // e.g. String
    public static final String EQUALS_IGNORE_CASE = "equalsIgnoreCase";
    public static final String TO_INTEGER = "toInteger";
    public static final String TO_REAL = "toReal";
    public static final String TO_BOOLEAN = "toBoolean";
    public static final String CHARACTERS = "characters";
    public static final String TO_UPPER_CASE = "toUpperCase";
    public static final String TO_LOWER_CASE = "toLowerCase";
    public static final String CONCAT = "concat";    
    public static final String SUBSTRING = "substring";
    public static final String MATCHES = "matches";
    public static final String SUBSTITUTES = "substitutes";

    // reused among String and Container
    public static final String SIZE = "size";
    
    // e.g. Container, Set, Sequence
    public static final String INCLUDES = "includes";
    public static final String EXCLUDES = "excludes";
    public static final String INCLUDES_ALL = "includesAll";
    public static final String EXCLUDES_ALL = "excludesAll";
    public static final String COUNT = "count";
    public static final String IS_EMPTY = "isEmpty";
    public static final String NOT_EMPTY = "notEmpty";
    public static final String SUM = "sum";
    public static final String PRODUCT = "product";
    public static final String AVG = "avg";
    public static final String EXISTS = "exists";
    public static final String IS_UNIQUE = "isUnique";
    public static final String ANY = "any";
    public static final String ONE = "one";
    public static final String INDEX_ACCESS = "[]";
    public static final String AT = "at";
    public static final String COLLECT = "collect";
    public static final String COLLECT_NESTED = "collectNested";
    public static final String SORTED_BY = "sortedBy";
    public static final String SELECT = "select";
    public static final String REJECT = "reject";
    public static final String AS_SET = "asSet";
    public static final String AS_SEQUENCE = "asSequence";
    public static final String UNION = "union";
    public static final String FOR_ALL = "forAll";
    public static final String ADD = "add";
    public static final String FLATTEN = "flatten";
    public static final String INCLUDING = "including";
    public static final String EXCLUDING = "excluding";
    
    // e.g. Set
    public static final String INTERSECTION = "intersection";
    public static final String REVERSE = "reverse";
    public static final String SYMMETRIC_DIFFERENCE = "symmetricDifference";
    
    // e.g. Sequence
    public static final String APPEND = "append";
    public static final String PREPEND = "prepend";
    public static final String INSERT_AT = "insertAt";
    public static final String SUB_SEQUENCE = "subSequence";
    public static final String INDEX_OF = "indexOf";
    public static final String FIRST = "first";
    public static final String LAST = "last";
    public static final String HAS_DUPLICATES = "hasDuplicates";
    public static final String SUBSEQUENCE = "subSequence";
    public static final String ISSUBSEQUENCE = "isSubsequenceOf";
    public static final String OVERLAPS = "overlaps";

    // Enum
    public static final String ORDINAL = "ordinal";
    
    // self
    @IVMLKeyWord
    public static final String SELF = "self";
    
    // e.g. IVML
    public static final String TYPE_OF = "typeOf";
    public static final String APPLY = "apply";
    @IVMLKeyWord
    public static final String IFF = "iff";
    public static final String IS_DEFINED = "isDefined";    
    public static final String TYPE_SELECT = "typeSelect";
    public static final String SELECT_BY_TYPE = "selectByType";
    public static final String SELECT_BY_KIND = "selectByKind";
    public static final String TYPE_REJECT = "typeReject";
    
    // IVML aliases
    public static final String UNEQUALS_ALIAS = "!=";

    /**
     * Prevents this class from being initialized from outside. Prepared for being
     * "reused" to entire set of IVML constants.
     */
    protected OclKeyWords() {
    }

}
