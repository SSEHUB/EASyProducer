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
/**
 * Implements the evaluation of constraint syntax trees. Operations evaluators to
 * be considered shall be registered with the evaluator registry. Indeed, we will 
 * repeat some code for implementing the operations, but we fear that the more 
 * generic versions will be slower as they imply either repeated array creation 
 * or polymorphic calls. Typically, one can rely on that the types passed into
 * an operation evaluator comply to the types of the operation as the compliance
 * is checked during the creation of the constraint syntax tree. To avoid index access
 * and type cast exceptions, we check for the argument number and types anyway and
 * return <b>null</b> in case of problems (that shall typically not occur).
 */
package net.ssehub.easy.varModel.cstEvaluation;