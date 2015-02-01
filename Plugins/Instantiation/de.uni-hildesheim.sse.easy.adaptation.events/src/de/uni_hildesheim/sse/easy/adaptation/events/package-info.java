/**
 * Defines the basic interfaces that a System Under Adaptation (SUA) must provide in order to be adapted at
 * runtime and controlled by the adaptation behavior specification language rt-VIL.
 * This package defines 
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.easy.adaptation.events.IAdaptationEvent} an event that shall
 *   cause an adaptation, at least the check whether an adaptation is needed. Specific adaptation events must
 *   be defined by the implementation of the SUA as on this level EASy-Producer is agnostic of the SUA.
 *   <li>The interface {@link de.uni_hildesheim.sse.easy.adaptation.events.IEnactionCommand} 
 *   representing an enactment on the system to be adapted. Akin to the adaptation events, specific enactment commands
 *   must be defined by the SUA.</li>
 *   <li>{@link de.uni_hildesheim.sse.easy.adaptation.events.AbstractAdaptationManager} providing an interface to cause
 *   an adaptation (by handing an adaptation event) and for registering SUA-specific events and commands. Registration
 *   is important as this leads to the respective types in rt-VIL specifications.
 * </ul>
 * 
 * @author Holger Eichelberger
 */
package de.uni_hildesheim.sse.easy.adaptation.events;