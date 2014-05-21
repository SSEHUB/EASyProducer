/**
 * All classes and interfaces needed to implement a reasoner.<br/><br/>
 * 
 * How to write a reasoner:
 * <ul>
 *   <li>Create an Eclipse Plugin project with Activator (even if "empty").</li>
 *   <li>Add <code>org.eclipse.equinox.ds</code> to the required plugins and <code>org.osgi.service.component</code>
 *       to the imported packages as your reasoner will be linked using OSGi descriptive services (DS) to the 
 *       reasoner core. As in our case the automatic registering via references in DS turned out to be instable,
 *       we will combine the automatic initialization capabilities with hand-crafted code.</li>
 *   <li>Implement {@link de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner}, the interface which 
 *       represents an individual reasoner. Provide the reasoner with an appropriate instance of 
 *       {@link de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor} which is used to describe
 *       the license of the reasoner as well as additional information such as a URL to download licensed parts.</li> 
 *    <li>Add the following methods to the class implementing 
 *       {@link de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner}: <code>
 *          protected void activate(org.osgi.service.component.ComponentContext context){
 *              ReasonerFrontend.getInstance().getRegistry().register(this);
 *          }
 *
 *          protected void deactivate(org.osgi.service.component.ComponentContext context){
 *              ReasonerFrontend.getInstance().getRegistry().unregister(this);
 *          }</code>
 *        Upon creation of your reasoner class the <code>activate</code> method will be called and it will register
 *        your instance with the reasoner core.</li>
 *   <li>Create a folder named <code>OSGI-INF</code> and put an XML file with the following contents into the new 
 *       folder (let's call that file <code>reasoner.xml</code>).
 *       <code>
 *         &lt;?xml version="1.0" encoding="UTF-8"?&rt;
 *         &lt;scr:component xmlns:scr="http://www.osgi.org/xmlns/scr/v1.1.0" immediate="true" 
 *           name="<i>&lt;your descriptive name&rt;</i>"&rt;
 *           &lt;implementation class="<i>&lt;your class name&rt;</i>"/&rt;
 *           &lt;service&rt;
 *           &lt;provide interface="de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner"/&rt;
 *           &lt;/service&rt;
 *         &lt;/scr:component&rt;
 *       </code></li>
 *    <li>Link the XML file to the manifest by adding 
 *      <code>Service-Component: OSGI-INF/reasoner.xml</code> (i.e. your specific name).</li>
 *    <li>While refactoring your code please note that Eclipse typically does not consider the names
 *      in the XML file, i.e. they have to be adjusted manually if required.</li>
 *    <li>For debugging output please specify <code>-Dequinox.ds.debug=true -Dequinox.ds.print=true</code> as
 *      JVM parameter.</li>
 * </ul>
 */
package de.uni_hildesheim.sse.reasoning.core.reasoner;

