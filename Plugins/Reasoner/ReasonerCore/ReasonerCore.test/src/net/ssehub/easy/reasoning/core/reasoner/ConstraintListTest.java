/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Tests {@link ConstraintList} with no modification listener.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintListTest {

    /**
     * Performs tests for an empty list.
     */
    @Test
    public void testEmptyList() {
        ConstraintList list = new ConstraintList();
        assertEmptyList(list);
        
        list.clear();
        assertEmptyList(list);
    }

    /**
     * Tests all non-modifying operations assuming that <code>list</code> is empty.
     * 
     * @param list the list to test
     */
    protected void assertEmptyList(ConstraintList list) {
        Constraint constraint = new Constraint(null);
        List<Constraint> constraints = new ArrayList<Constraint>();
        constraints.add(constraint);

        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(null));
        Assert.assertFalse(list.contains(constraint));
        try {
            list.getFirst();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        try {
            list.getLast();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        Assert.assertEquals(-1, list.indexOf(null));
        Assert.assertFalse(list.contains(null));
        Assert.assertEquals(-1, list.indexOf(constraint));
        Assert.assertFalse(list.contains(constraint));
        try {
            list.removeFirst();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        try {
            list.pop();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        try {
            list.removeLast();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        try {
            Assert.assertFalse(list.removeAll(null));
            Assert.fail();
        } catch (NullPointerException e) {
            // ok
        }
        Assert.assertFalse(list.removeAll(constraints));
        assertIteratorRead(list.iterator());
        assertAsArray(list);
        assertAsCollection(list);
        Assert.assertEquals("[]", list.toString());
    }

    /**
     * Tests the constraint list with different numbers of elements.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testListAddSingleElements() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        assertConstraints(first);
        Constraint second = createTestConstraint(2);
        assertConstraints(first, second);
        Constraint third = createTestConstraint(3);
        assertConstraints(first, second, third);
        
        ConstraintList list = new ConstraintList();
        list.add(null);
        Assert.assertEquals(0, list.indexOf(null));
        
        list.clear();
        assertEmptyList(list);
        
        list.addFirst(first);
        list.addFirst(second);
        list.addFirst(third);
        assertAsArray(list, third, second, first);
        assertAsCollection(list, third, second, first);
        assertIteratorRead(list.iterator(), third, second, first);
        assertIteratorRead(list.iterator(), third, second, first); // just do it twice
        
        list.clear();
        assertEmptyList(list);

        list.addLast(first);
        list.addLast(second);
        list.addLast(third);
        assertArray(list.toArray(), first, second, third);
        assertAsCollection(list, first, second, third);
        assertIteratorRead(list.iterator(), first, second, third);
        assertIteratorRead(list.iterator(), first, second, third); // just do it twice
        Assert.assertNotEquals("[]", list.toString());
    }
    
    /**
     * Adds and asserts the given constraints.
     * 
     * @param constraints the constraints
     */
    protected void assertConstraints(Constraint... constraints) {
        ConstraintList list = new ConstraintList();
        for (Constraint c : constraints) {
            list.add(c);
        }
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(constraints.length, list.size());
        Assert.assertTrue(constraints[0] == list.getFirst());
        Assert.assertTrue(constraints[constraints.length - 1] == list.getLast());
        for (int i = 0; i < constraints.length; i++) {
            Assert.assertEquals(i, list.indexOf(constraints[i]));
            Assert.assertEquals(-1, list.indexOf(null));
            Assert.assertTrue(list.contains(constraints[i]));
        }
        assertArray(list.toArray(), constraints);
        assertIteratorRead(list.iterator(), constraints);
        assertIteratorRead(list.iterator(), constraints); // just do it twice
    }

    /**
     * Asserts the contents of {@code actual} via {@link ConstraintList#toArray()}.
     * 
     * @param actual the actual constraint list
     * @param expected the expected array elements
     */
    protected void assertAsArray(ConstraintList actual, Constraint... expected) {
        assertArray(actual.toArray(), expected);
    }
    
    /**
     * Asserts the contents of an array.
     * 
     * @param actual the actual array
     * @param expected the expected array elements
     */
    protected void assertArray(Constraint[] actual, Constraint... expected) {
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        for (int c = 0; c < expected.length; c++) {
            Assert.assertTrue(actual[c] == expected[c]);
        }
    }

    /**
     * Asserts the contents of a collection.
     * 
     * @param actual the actual collection
     * @param expected the expected array elements
     */
    protected void assertCollection(Collection<Constraint> actual, Constraint... expected) {
        Assert.assertNotNull(actual);
        Constraint[] tmp = new Constraint[actual.size()];
        actual.toArray(tmp);
        assertArray(tmp, expected);
    }

    /**
     * Asserts the contents of a {@code actual} via {@link ConstraintList#toCollection(Collection)}.
     * 
     * @param actual the actual constraint list
     * @param expected the expected array elements
     */
    protected void assertAsCollection(ConstraintList actual, Constraint... expected) {
        Collection<Constraint> coll = new ArrayList<Constraint>();
        actual.toCollection(coll);
        assertCollection(coll, expected);
    }
    
    /**
     * Asserts the non-destructive traversal of an iterator.
     * 
     * @param actual the actual iterator
     * @param expected the expected elements in sequence
     */
    protected void assertIteratorRead(Iterator<Constraint> actual, Constraint... expected) {
        Assert.assertNotNull(actual);
        int index = 0;
        while (index < expected.length) {
            Assert.assertTrue(actual.hasNext());
            try {
                Constraint cstr = actual.next();
                Assert.assertTrue(cstr == expected[index]);
            } catch (NoSuchElementException e) {
                Assert.fail("Not expected exception " + e.getMessage());
            }
            index++;
        }

        Assert.assertFalse(actual.hasNext());
        try {
            actual.next();
            Assert.fail();
        } catch (NoSuchElementException e) {
            // ok
        }
        try {
            actual.remove();
            Assert.fail();
        } catch (IllegalStateException e) {
            // ok
        }
    }

    /**
     * Creates a test constraint with a constant value expression.
     *  
     * @param nr the integer constant value
     * @return the constraint
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    protected Constraint createTestConstraint(int nr) throws CSTSemanticException, ValueDoesNotMatchTypeException {
        return new Constraint(
            new OCLFeatureCall(
                new Variable(new DecisionVariableDeclaration("var", IntegerType.TYPE, null)),
                OclKeyWords.EQUALS,
                new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, nr)))
            , null);
    }
    
    /**
     * Tests adding multiple elements at once.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAddMulti1() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);
        List<Constraint> constraints = new ArrayList<Constraint>();
        
        // util.list to constraint list, but empty add
        ConstraintList list = new ConstraintList();
        list.addAll(constraints);
        Assert.assertEquals(0, list.size());
        assertAsArray(list);
        assertIteratorRead(list.iterator());

        // adding some elements
        constraints.add(first);
        constraints.add(second);
        constraints.add(third);
        
        // util.list to constraint list, @start
        list.addAll(constraints);
        Assert.assertEquals(3, list.size());
        assertAsArray(list, first, second, third);
        assertIteratorRead(list.iterator(), first, second, third);

        // constraint list to constraint list @start
        ConstraintList list2 = new ConstraintList();
        list2.addAll(list);
        Assert.assertEquals(3, list2.size());
        
        try {
            list.addAll(1000, constraints);
            Assert.fail("Index out of bounds exception expected");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
        try {
            list.addAll(-1, constraints);
            Assert.fail("Index out of bounds exception expected");
        } catch (IndexOutOfBoundsException e) {
            // ok
        }
        
        // util.list to constraint list, @pos
        list.addAll(1, constraints);
        Assert.assertEquals(6, list.size());
        assertAsArray(list, first, first, second, third, second, third);
        assertAsCollection(list, first, first, second, third, second, third);
        assertIteratorRead(list.iterator(), first, first, second, third, second, third);
        
        // list2 not modified
        Assert.assertEquals(3, list2.size());
    }
    
    /**
     * Tests adding multiple elements at once.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testAddMulti2() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        ConstraintList list = new ConstraintList();
        ConstraintList list2 = new ConstraintList();
        
        list2.clear();
        assertEmptyList(list2);
        list.clear();
        
        // adding empty
        list.addAll(list2);
        Assert.assertEquals(0, list.size());
        assertAsArray(list);
        assertAsCollection(list);
        assertIteratorRead(list.iterator());
        
        // again first, second, third
        list.add(first);
        list.add(second);
        list.add(third);
        
        // constraint list to constraint list @pos
        list2.add(third);
        list2.add(second);
        list2.addAll(1, list);
        Assert.assertEquals(5, list2.size());
        assertAsArray(list2, third, first, second, third, second);
        assertAsCollection(list2, third, first, second, third, second);
        assertIteratorRead(list2.iterator(), third, first, second, third, second);
     
        // add all @end, target clear
        list.clear();
        assertEmptyList(list);
        list.addAll(list2, true);
        assertEmptyList(list2);
        Assert.assertEquals(5, list.size());
        assertAsArray(list, third, first, second, third, second);
        assertAsCollection(list, third, first, second, third, second);
        assertIteratorRead(list.iterator(), third, first, second, third, second);

        // add all @pos
        list.clear();
        list.add(first);
        list.add(second);
        list2.clear();
        list2.add(second);
        list2.add(third);
        list.addAll(1, list2, true);
        assertEmptyList(list2);
        Assert.assertEquals(4, list.size());
        assertAsArray(list, first, second, third, second);
        assertAsCollection(list, first, second, third, second);
        assertIteratorRead(list.iterator(), first, second, third, second);

        // add all @end, target not clear
        list.clear();
        list.add(first);
        list2.clear();
        list2.add(second);
        list2.add(third);
        list.addAll(list2, true);
        Assert.assertEquals(3, list.size());
        assertAsArray(list, first, second, third);
        assertAsCollection(list, first, second, third);
        assertIteratorRead(list.iterator(), first, second, third);
    }

    /**
     * Test removing elements.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testRemove() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        ConstraintList list = new ConstraintList();
        list.add(first);
        list.add(second);
        list.add(third);
        list.pop();
        Assert.assertEquals(2, list.size());
        assertAsArray(list, second, third);
        assertAsCollection(list, second, third);
        assertIteratorRead(list.iterator(), second, third);
        list.removeFirst();
        Assert.assertEquals(1, list.size());
        assertAsArray(list, third);
        assertAsCollection(list, third);
        assertIteratorRead(list.iterator(), third);
        list.removeFirst();
        Assert.assertEquals(0, list.size());
        assertAsArray(list);
        assertAsCollection(list);
        assertIteratorRead(list.iterator());
        assertEmptyList(list);

        list.add(first);
        list.add(second);
        list.removeLast();
        Assert.assertEquals(1, list.size());
        assertAsArray(list, first);
        assertAsCollection(list, first);
        assertIteratorRead(list.iterator(), first);
        list.removeLast();
        Assert.assertEquals(0, list.size());
        assertAsArray(list);
        assertAsCollection(list);
        assertIteratorRead(list.iterator());
        
        list.add(first);
        list.add(second);
        list.add(third);
        
        List<Constraint> constraints = new ArrayList<Constraint>();
        constraints.add(third);
        constraints.add(second);
        list.removeAll(constraints);
        Assert.assertEquals(1, list.size());
        assertAsArray(list, first);
        assertAsCollection(list, first);
        assertIteratorRead(list.iterator(), first);
        constraints.clear();
        constraints.add(first);
        list.removeAll(constraints);
        Assert.assertEquals(0, list.size());
        assertAsArray(list);
        assertAsCollection(list);
        assertIteratorRead(list.iterator());
    }

    /**
     * Test removing elements via an iterator.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIteratorDelete() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        ConstraintList list = new ConstraintList();
        list.add(first);
        list.add(second);
        list.add(third);

        Iterator<Constraint> iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
            try {
                iter.remove();
                Assert.fail("Illegal state exception expected");
            } catch (IllegalStateException e) {
                // ok
            }
        }
        assertEmptyList(list);
    }
    
    /**
     * Test iterator for concurrent modifications.
     * 
     * @throws CSTSemanticException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     */
    @Test
    public void testIteratorConcurrent() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Constraint first = createTestConstraint(1);
        Constraint second = createTestConstraint(2);
        Constraint third = createTestConstraint(3);

        ConstraintList list = new ConstraintList();
        list.add(first);
        list.add(second);
        list.add(third);
        int count = 0;
        Iterator<Constraint> iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            if (count < 3) {
                list.add(first);
                count++; // otherwise endless loop
            }
        }

        count = 0;
        iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            if (count < 3) {
                list.add(first);
                count++; // otherwise endless loop
            }
            try {
                iter.remove();
                Assert.fail("Concurrent modification exception expected");
            } catch (ConcurrentModificationException e) {
                // ok
            }
        }
    }
    
    
    
}
