/**
 * Tests for the reasoner core. Please note the following hints and considerations:
 * <ul>
 *   <li>The reasoner core is not able to reason without an installed reasoner. Therefore, 
 *       the test cases for the reasoner core can either be specific for the reasoner core
 *       functionality itself or abstract regarding the reasoning capabilities.</li>
 *   <li>Currently only one reasoner-core specific test is implemented which targets
 *       the reasoner upgrader {@link de.uni_hildesheim.sse.reasoning.core.upgrader.UpgraderTests}.</li>
 *   <li>Tests for several (generic) reasoning capabilities are specified but can only be
 *       executed in the context of the tests for a specific reasoner, i.e., they are not executed 
 *       by the reasoner core.
 *       <ul>
 *         <li>A test can be specified in terms of a variability model file or as source code.
 *             Variability model files are preferred, as they also test the parser and as
 *             they can be changed more easily without deeper knowledge in programming EASys.
 *             <i>Please note that each variability model project shall have its unique name!</i></li>
 *         <li>{@link de.uni_hildesheim.sse.reasoning.core.frontend.AbstractReasonerFrontendTest} 
 *             builds a small test framework. It provides methods for setting up the reasoners,
 *             the environment (depending on the continuous integration), loading models etc.</li>
 *         <li>Specific test classes shall inherit from 
 *             {@link de.uni_hildesheim.sse.reasoning.core.frontend.AbstractReasonerFrontendTest} class 
 *             but still be abstract as their setup method needs to be defined in the context of the
 *             reasoner to be tested. Test methods within that class shall specify tests on
 *             variability models defined in the reasoner core test.</li>
 *         <li>A specific reasoner test suite (currently) needs to subclass the abstract tests and call 
 *             {@link de.uni_hildesheim.sse.reasoning.core.frontend.AbstractReasonerFrontendTest#setupTests}.
 *             This method requires two parameters, a test configuration and a reasoner initializer. The
 *             first defines the test environment in terms of bundleId, environment variable (for loading
 *             the models) and reasoner capabilities to be tested. The second one provides a mechanism to
 *             create a reasoner instance if required (this shall be implemented by the reasoner as its
 *             implementing classes may be not exported. We recommend to write this initialization once
 *             in a utility class and to use it in all test classes. Finally, the test suite needs
 *             to link the subclassed test classes.</li>
 *       </ul>
 *    </li>
 * </ul>
 */
package test.de.uni_hildesheim.sse;

