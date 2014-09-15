/**
 * All classes related to the EASy integration of configuration and decisions. Special 
 * requirements for this package: 
 * <ol>
 *   <li>IVML elements must provide a valid <code>equals</code> method for comparing values.</li>
 * </ol>
 * In addition, this package implements the dynamic part of the VIL/VTL type system, in particular
 * a type resolver for IVML models in order to make the IVML types available to VIL/VTL upon advice.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;