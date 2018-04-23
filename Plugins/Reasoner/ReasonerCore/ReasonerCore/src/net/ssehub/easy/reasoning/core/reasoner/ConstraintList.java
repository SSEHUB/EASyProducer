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

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import net.ssehub.easy.varModel.model.Constraint;

/**
 * Implements a constraint list. This list assumes
 * reference equality for constraints. Partially taken over from 
 * {@link LinkedList} to fix types and to allow access from subclasses.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintList implements Iterable<Constraint> {

    protected transient int modCount = 0;
    private int size = 0;
    private Node first;
    private Node last;
    private transient IModificationListener listener;
    
    /**
     * Constructs an empty constraint base.
     */
    public ConstraintList() {
        this(null);
    }

    /**
     * Constructs an empty constraint base.
     * 
     * @param listener the modification listener (<b>null</b> for none)
     */
    protected ConstraintList(IModificationListener listener) {
        setModificationListener(listener);
    }

    /**
     * Changes the modification listener.
     * 
     * @param listener the modification listener (<b>null</b> for none)
     */
    protected void setModificationListener(IModificationListener listener) {
        this.listener = listener;
    }
    
    /**
     * A listener to be informed if the underlying list changes.
     * 
     * @author Holger Eichelberger
     */
    protected interface IModificationListener {

        /**
         * Is called when a new node has been added for <code>constraint</code>. <code>node</code> may already be linked
         * into the list.
         * 
         * @param constraint the constraint
         * @param node the node
         */
        public void notifyAdded(Constraint constraint, Node node);

        /**
         * Is called when a new node is being removed through removing <code>constraint</code>. <code>node</code> may 
         * already be cleared and must not contain valid information.
         * 
         * @param constraint the constraint
         * @param node the node
         */
        public void notifyRemoved(Constraint constraint, Node node);

        /**
         * Is called when all nodes have been removed at once.
         */
        public void notifyRemovedAll();
        
    }
    
    /**
     * The node type in a linked constraint base.
     * 
     * @author Holger Eichelberger
     */
    protected static class Node {
        
        private Constraint constraint;
        private Node next;
        private Node prev;

        /**
         * Creates a node.
         * 
         * @param prev the previous node
         * @param constraint the constraint assigned to the node
         * @param next the next node
         */
        private Node(Node prev, Constraint constraint, Node next) {
            this.constraint = constraint;
            this.next = next;
            this.prev = prev;
        }
    }
    
    /**
     * Returns {@code true} if this list contains the specified <code>constraint</code>.
     * More formally, returns {@code true} if and only if this list contains
     * at least one constraint {@code constraint} such that
     * {@code o == constraint}.
     *
     * @param constraint the constraint whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(Constraint constraint) {
        return indexOf(constraint) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified <code>constraint</code>
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code o == get(i)},
     * or -1 if there is no such index.
     *
     * @param constraint constraint to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Constraint constraint) {
        int index = 0;
        int result = -1;
        if (null == constraint) {
            for (Node x = first; x != null; x = x.next) {
                if (x.constraint == null) {
                    result = index;
                    break;
                }
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.next) {
                if (constraint == x.constraint) {
                    result = index;
                    break;
                }
                index++;
            }
        }
        return result;
    }

    /**
     * Returns the first constraint in this list.
     *
     * @return the first constraint in this list
     * @throws NoSuchElementException if this list is empty
     */
    public Constraint getFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.constraint;
    }

    /**
     * Returns the last constraint in this list.
     *
     * @return the last constraint in this list
     * @throws NoSuchElementException if this list is empty
     */
    public Constraint getLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.constraint;
    }
    
    /**
     * Returns the number of constraints in this constraint base.
     *
     * @return the number of constraints in this constraint base
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns {@code true} if this list contains no constraints.
     *
     * @return {@code true} if this list contains no constraints
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified constraint to the end of this constraint base.
     *
     * @param constraint constraint to be appended 
     */
    public void add(Constraint constraint) {
        linkLast(constraint);
    }
    
    /**
     * Inserts the specified <code>constraint</code> at the beginning of this constraint base.
     *
     * @param constraint the constraint to add
     */
    public void addFirst(Constraint constraint) {
        linkFirst(constraint);
    }

    /**
     * Appends the specified <code>constraint</code> to the end of this constraint base.
     *
     * @param constraint the constraint to add
     */
    public void addLast(Constraint constraint) {
        linkLast(constraint);
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        Node x = first;
        while (null != x) {
            Node next = x.next;
            if (null != listener) {
                listener.notifyRemoved(x.constraint, x);
            }
            x.constraint = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
        if (null != listener) {
            listener.notifyRemovedAll();
        }
        modCount++;
    }
    
    /**
     * Appends all of the constraints in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param constraints collection containing constraints to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(Collection<? extends Constraint> constraints) {
        return addAll(size, constraints);
    }

    /**
     * Inserts all of the constraints in the specified collection into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).  The new elements will appear
     * in the list in the order that they are returned by the
     * specified collection's iterator.
     *
     * @param index index at which to insert the first element
     *              from the specified collection
     * @param constraints collection containing constraints to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, Collection<? extends Constraint> constraints) {
        checkPositionIndex(index);

        boolean result;
        int numNew = constraints.size();
        if (0 == numNew) {
            result = false;
        } else {
            Constraint[] cArray = new Constraint[numNew];
            constraints.toArray(cArray);
            addAll(index, cArray);
            result = true;
        } 
        return result;
    }
    
    /**
     * Adds all constraints from <code>cArray</code> to this collection at position <code>index</code>.
     * 
     * @param index index at which to insert the first element
     *        from the specified collection
     * @param cArray the constraints as array
     */
    private void addAll(int index, Constraint[] cArray) {
        Node pred;
        Node succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Constraint c : cArray) {
            Node newNode = new Node(pred, c, null);
            if (pred == null) {
                first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += cArray.length;
        modCount++;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param constraints collection containing constraints to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(ConstraintList constraints) {
        return addAll(constraints, false);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param constraints collection containing constraints to be added to this list
     * @param clear clears <code>constraints</code> by taking over all internal nodes
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(ConstraintList constraints, boolean clear) {
        return addAll(size, constraints, clear);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element
     *        from the specified collection
     * @param constraints collection containing constraints to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, ConstraintList constraints) {
        return addAll(index, constraints, false);
    }
    
    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator.  The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in
     * progress.  (Note that this will occur if the specified collection is
     * this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element
     *        from the specified collection
     * @param constraints collection containing constraints to be added to this list
     * @param clear clears <code>constraints</code> by taking over all internal nodes
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, ConstraintList constraints, boolean clear) {
        checkPositionIndex(index);
        boolean result;
        int numNew = constraints.size();
        if (0 == numNew) {
            result = false;
        } else {
            if (!clear) {
                addAll(index, constraints.toArray());
            } else {
                if (null == first) {
                    first = constraints.first;
                    last = constraints.last;
                } else {
                    Node pred;
                    Node succ;
                    if (index == size) {
                        succ = null;
                        pred = last;
                    } else {
                        succ = node(index);
                        pred = succ.prev;
                    }                    
                    constraints.first.prev = pred;
                    pred.next = constraints.first;
                    if (null == succ) {
                        last = constraints.last;
                    } else {
                        succ.prev = constraints.last;
                        constraints.last.next = succ;
                    }
                }

                // notify listener for all nodes
                if (null != listener) {
                    Node x = constraints.first; 
                    while (null != x) {
                        listener.notifyAdded(x.constraint, x);
                        x = x.next;
                    }                    
                }

                size += constraints.size;
                // unlink constraints and notify listener
                constraints.first = null;
                constraints.last = null;
                constraints.size = 0;
                constraints.modCount++;
                if (null != constraints.listener) {
                    constraints.listener.notifyRemovedAll();
                }
                modCount++;
            }
            result = true;
        } 
        return result;
    }
    
    /**
     * Turns this list into an array containing all constraints.
     * 
     * @return the array
     */
    public Constraint[] toArray() {
        Constraint[] result = new Constraint[size];
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            result[index] = x.constraint;
            index++;
        }
        return result;
    }
    
    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this list (which is the top
     *         of the stack represented by this list)
     * @throws NoSuchElementException if this list is empty
     * @since 1.6
     */
    public Constraint pop() {
        return removeFirst();
    }
    
    /**
     * Removes and returns the first constraint from this list.
     *
     * @return the first constraint from this list
     * @throws NoSuchElementException if this list is empty
     */
    public Constraint removeFirst() {
        final Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }

    /**
     * Removes and returns the last constraint from this list.
     *
     * @return the last constraint from this list
     * @throws NoSuchElementException if this list is empty
     */
    public Constraint removeLast() {
        final Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }

    /**
     * Returns an iterator over the elements in this list (in proper
     * sequence).<p>
     *
     * This implementation merely returns a list iterator over the list.
     *
     * @return an iterator over the elements in this list (in proper sequence)
     */
    public Iterator<Constraint> iterator() {
        return new Iterator<Constraint>() {

            private Node last = null;
            private Node cursor = first;
            private int expectedModCount = modCount;
            
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public Constraint next() {
                last = cursor;
                Constraint result;
                if (null == cursor) {
                    throw new NoSuchElementException();
                }
                result = cursor.constraint;
                cursor = cursor.next;
                return result;
            }
            
            @Override
            public void remove() {
                if (null == last) {
                    throw new IllegalStateException();
                }
                checkForComodification();
                unlink(last);
                last = null; // avoid double delete
                expectedModCount = modCount;
            }

            /**
             * Checks for an unintend co-modification.
             */
            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
            
        };
    }
    
    /**
     * Removes all elements from this list, which are also in <code>constraints</code>.
     * 
     * @param constraints the elements to remove
     * @return the removed elements
     * @throws NullPointerException if <code><b>null</b> == constraints</code>
     */
    public boolean removeAll(Collection<? extends Constraint> constraints) {
        Objects.requireNonNull(constraints);
        boolean modified = false;
        Iterator<Constraint> it = iterator();
        while (it.hasNext()) {
            if (constraints.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    // internal operations

    /**
     * Links <code>constraint</code> as first constraint.
     * 
     * @param constraint the constraint to be linked
     * @see #notifyNodeAdded(Constraint, Node)
     */
    private void linkFirst(Constraint constraint) {
        final Node f = first;
        final Node newNode = new Node(null, constraint, f);
        first = newNode;
        if (null == f) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        modCount++;
        if (null != listener) {
            listener.notifyAdded(constraint, newNode);
        }
    }

    /**
     * Links <code>constraint</code> as last constraint.
     * 
     * @param constraint the constraint to be linked
     * @see #notifyNodeAdded(Constraint, Node)
     */
    private void linkLast(Constraint constraint) {
        final Node l = last;
        final Node newNode = new Node(l, constraint, null);
        last = newNode;
        if (null == l) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
        if (null != listener) {
            listener.notifyAdded(constraint, newNode);
        }
    }

    /**
     * Unlinks non-null first node <code>node</code>.
     * 
     * @param node the node to unlink
     * @return constraint the removed constraint
     */
    private Constraint unlinkFirst(Node node) {
        final Constraint constraint = node.constraint;
        final Node next = node.next;
        node.constraint = null;
        node.next = null; // help GC
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        modCount++;
        if (null != listener) {
            listener.notifyRemoved(constraint, node);
        }
        return constraint;
    }

    /**
     * Unlinks non-null last node <code>node</code>.
     * 
     * @param node the node to unlink
     * @return constraint the removed constraint
     */
    private Constraint unlinkLast(Node node) {
        final Constraint constraint = node.constraint;
        final Node prev = node.prev;
        node.constraint = null;
        node.prev = null; // help GC
        last = prev;
        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
        size--;
        modCount++;
        if (null != listener) {
            listener.notifyRemoved(constraint, node);
        }
        return constraint;
    }
    
    /**
     * Unlinks non-null node x.
     * 
     * @param node the node to unlink
     * @return constraint the removed constraint
     */
    Constraint unlink(Node node) {
        // assert x != null;
        final Constraint constraint = node.constraint;
        final Node next = node.next;
        final Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.constraint = null;
        size--;
        modCount++;
        if (null != listener) {
            listener.notifyRemoved(constraint, node);
        }
        return constraint;
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     * 
     * @param index the failing index
     * @return the out of bounds message
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
    
    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     * 
     * @param index the index to check
     * @return returns whether <code>index</code> is a valid position
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }
    
    /**
     * Checks <code>index</code> to be a valid position. If not, throws an
     * {@link IndexOutOfBoundsException}.
     * 
     * @param index the index to check
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }
    
    /**
     * Returns the (non-null) Node at the specified element index.
     * 
     * @param index the index
     * @return the node 
     */
    private Node node(int index) {
        // assert isElementIndex(index);
        Node result;
        if (index < (size >> 1)) {
            result = first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = last;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }
    
    /**
     * Turns the list into its string representation.
     * 
     * @return the string representation
     */
    public String toString() {
        String result = "[";
        for (Node x = first; x != null; x = x.next) {
            result += x.constraint;
            if (x.next != null) {
                result += ", "; 
            }
        }
        result += "]";
        return result;
    }

}
