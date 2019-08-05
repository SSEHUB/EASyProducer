/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.varModel.testSupport;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;

/**
 * Support methods for reflection-based class tests.
 * 
 * @author Holger Eichelberger
 */
public class ClassTestUtils {
    
    /**
     * Asserts that a no-arg constructor exists irrespective of its visibility and that it can 
     * be called without exception creating an instance. This method is intend to test no-arg
     * constructors for serialization that are not used anywhere else.
     * 
     * @param cls the classes to test for
     */
    public static void assertNoArgConstructor(Class<?>... cls) {
        for (Class<?> c : cls) {
            try {
                Constructor<?> cons = c.getDeclaredConstructor();
                cons.setAccessible(true);
                Object o = cons.newInstance();
                Assert.assertTrue(c.isInstance(o));
            } catch (NoSuchMethodException e) {
                Assert.fail("No-arg constructor missing for class " + c.getName());
            } catch (InstantiationException e) {
                Assert.fail("No-arg constructor instantiation fails for class " + c.getName());
            } catch (IllegalAccessException e) {
                Assert.fail("No-arg constructor access fails for class " + c.getName());
            } catch (IllegalArgumentException e) {
                Assert.fail("No-arg constructor arguments fails for class " + c.getName());
            } catch (InvocationTargetException e) {
                Assert.fail("No-arg constructor invocation fails for class " + c.getName() + ":" 
                    + e.getCause().getClass().getName() + " " + e.getCause().getMessage());
            }
        }
    }
    
}
