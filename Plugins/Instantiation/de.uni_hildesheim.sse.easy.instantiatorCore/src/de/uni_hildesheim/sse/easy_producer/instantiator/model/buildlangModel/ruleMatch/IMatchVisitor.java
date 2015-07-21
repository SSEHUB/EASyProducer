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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Visitor methods for the match expressions.
 * 
 * @author Holger Eichelberger
 */
public interface IMatchVisitor {

    /**
     * Visits a path match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitPathMatchExpression(PathMatchExpression expression) throws VilException;

    /**
     * Visits a string match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitStringMatchExpression(StringMatchExpression expression) throws VilException;

    /**
     * Visits an artifact match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws VilException;

    /**
     * Visits a collection match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws VilException;

    /**
     * Visits a boolean match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitBooleanMatchExpression(BooleanMatchExpression expression) throws VilException;

    /**
     * Visits a compound match expression.
     * 
     * @param expression the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitCompoundMatchExpression(CompoundMatchExpression expression) throws VilException;
    
}
