/**
 * Tests for the reasoner core. Please note the following hints and considerations:
 * <ul>
 *   <li>The reasoner core is not able to reason without an installed reasoner. Therefore, 
 *       the test cases for the reasoner core can either be specific for the reasoner core
 *       functionality itself or abstract regarding the reasoning capabilities.</li>
 *   <li>Currently only one reasoner-core specific test is implemented which targets
 *       the reasoner upgrader {@link test.net.ssehub.easy.reasoning.core.upgrader.UpgraderTests}.</li>
 *   <li>Tests for several (generic) reasoning capabilities are specified but can only be
 *       executed in the context of the tests for a specific reasoner, i.e., they are not executed 
 *       by the reasoner core. Therefore, the tests receive an instance of 
 *       {@link test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor} or, better, 
 *       {@link test.net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor}. New tests shall inherit from 
 *       {@link test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest}. Currently, the concrete reasoning tests
 *       must inherit the existing core tests, specify the test descriptor and may override and ignore individual
 *       test cases depending on the implementation state.
 *   </li>
 * </ul>
 */
package test.net.ssehub.easy.reasoning.core;

