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
package de.uni_hildesheim.sse.persistency;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.varModel.AbstractVisitor;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.IPartialEvaluable;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Super class for translating the variability model to a <code>StringBuffer</code>, which can be used for saving.
 * @author El-Sharkawy
 * 
 * @see de.uni_hildesheim.sse.model.varModel.values.IValueVisitor
 * @see Project
 */
public abstract class AbstractVarModelWriter extends AbstractVisitor 
    implements IValueVisitor, IConstraintTreeVisitor {

    /**
     * Defines a dummy model element for additional formatting.
     */
    protected static final ModelElement DUMMY_PARENT = new ModelElement("dummy") {
        
        @Override
        public void accept(IModelVisitor visitor) {
            // do nothing
        }
    };

    /**
     * The number of whitespaces per indentation (if {@link #useWhitespace} is enabled), otherwise one tab is inserted.
     * Currently we assume that one central configuration for the indentation is sufficient and that it will not be
     * changed during the output of this or subclasses.
     */
    private static String indentStep = "    ";
    
    /**
     * Use whitespaces or tabs.
     * Currently we assume that one central configuration for the indentation is sufficient and that it will not be
     * changed during the output of this or subclasses.
     */
    private static boolean useWhitespace = true;
    
    private String myIndentStep = indentStep;
    private boolean myUseWhitespace = useWhitespace;
    
    /**
     * Stores the all parents of the currently visited element.<br/>
     * Can be an empty list in case of root elements.
     */
    private List<IModelElement> parents;
    
    /**
     * This attribute should be used for storing the output.
     */
    private Writer out;

    private IModelElement expressionContext;

    /**
     * Defines default space locations.
     * 
     * @author Holger Eichelberger
     */
    protected enum DefaultSpace {
        
        /**
         * The default space for project.
         */
        PROJECT
    }
    
    /**
     * Sole constructor for this class.
     * @param writer Writer which should be used for writing the output.
     */
    protected AbstractVarModelWriter(Writer writer) {
        parents = new ArrayList<IModelElement>();
        out = new BufferedWriter(writer);
    }

    /**
     * Changes the expression context.
     * 
     * @param expressionContext the expression context
     */
    protected void setExpressionContext(IModelElement expressionContext) {
        this.expressionContext = expressionContext;
    }
    
    /**
     * Returns the expression context.
     * 
     * @return the expression context
     */
    protected IModelElement getExpressionContext() {
        return expressionContext;
    }

    /**
     * Defines the number of spaces used in one indentation step if {@link #useWhitespace}.
     * 
     * @param count the number of spaces (negative values are ignored)
     */
    public static void setIndentStep(int count) {
        indentStep = deriveIndentStep(count);
    }

    /**
     * Defines the number of spaces used in one indentation step if {@link #useWhitespace} for this writer.
     * 
     * @param count the number of spaces (negative values are ignored)
     */
    public void setIndentationStep(int count) {
        if (count != myIndentStep.length()) {
            myIndentStep = deriveIndentStep(count);
        }
    }
    
    /**
     * Defines whether whitespaces or tabs shall be used for indentation in this editor.
     * 
     * @param useWhitespaces if <code>true</code> whitespaces, tabs if <code>false</code>
     */
    public void setUseWhitespaces(boolean useWhitespaces) {
        this.myUseWhitespace = useWhitespaces;
    }

    /**
     * Creates the indentation step in terms of numbers of spaces to be used.
     * 
     * @param count the number of spaces (negative values are ignored)
     * @return the indentation step
     */
    private static String deriveIndentStep(int count) {
        count = Math.max(0, count);
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < count; i++) {
            tmp.append(" ");
        }
        return tmp.toString();
    }
    
    /**
     * Return the indent-step for ivml.
     * @return indent step.
     */
    public static String getIvmlIndentStep() {
        return indentStep;
    }
    
    /**
     * Defines whether whitespaces or tabs shall be used for indentation.
     * 
     * @param use if <code>true</code> whitespaces, tabs if <code>false</code>
     */
    public static void setUseIvmlWhitespace(boolean use) {
        useWhitespace = use;
    }
    
    /**
     * Defines whether whitespaces or tabs shall be used for indentation.
     * 
     * @return useWhitespace if <code>true</code> whitespaces, tabs if <code>false</code>
     * 
     */
    public static boolean getUseIvmlWhitespace() {
        return useWhitespace;
    }
    
    /**
     * Changes the writer. (for reuse)
     * 
     * @param writer the new writer
     */
    public void setWriter(Writer writer) {
        out = writer;
    }
    
    /**
     * Returns the actual writer.
     * 
     * @return the actual writer
     */
    public Writer getWriter() {
        return out;
    }
    
//    /**
//     * Getter for the output writer.
//     * @return string buffer containing the output
//     */
//    public BufferedWriter getOutput() {
//        return out;
//    }
    
    /**
     * Method to append the output.
     * @param appendableOutput String containing the output, which should be added.
     */
    protected final void appendOutput(String appendableOutput) {
        try {
            out.write(appendableOutput);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(AbstractVarModelWriter.class, Bundle.ID).exception(e);
        }
    }

    /**
     * Method to append the output.
     * @param appendableOutput char containing the output, which should be added.
     */
    protected final void appendOutput(char appendableOutput) {
        try {
            out.write(appendableOutput);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(AbstractVarModelWriter.class, Bundle.ID).exception(e);
        }
    }

    /**
     * Method to append the current indentation.
     */
    protected final void appendIndentation() {
        try {
            out.write(getIndentation().toString());
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(AbstractVarModelWriter.class, Bundle.ID).exception(e);
        }
    }

    /**
     * Flushes the writer. Should be used if there aren't any more elements to read.
     * @throws IOException If an I/O error occurs
     */
    public final void flush() throws IOException {
        out.flush();
    }
    
    /**
     * Returns the current indentation for (nested) elements.
     * @return The correct indentation for nested elements or an empty StringBuffer in case of an top level element.
     */
    protected StringBuffer getIndentation() {
        int depth = parents.size();
        StringBuffer indent = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            if (myUseWhitespace) {
                indent.append(myIndentStep);
            } else {
                indent.append("\t");
            }
        }
        return indent;
    }
    
    /**
     * Returns the direct parent of the current visited object. Ignors {@link #DUMMY_PARENT}.
     * @return The direct parent or <b>null</b> in case of an element from the top layer.
     */
    protected IModelElement getParent() {
        IModelElement parent = null;
        if (parents.size() > 0) {
            int lastPosition = parents.size() - 1;
            while (lastPosition >= 0 && DUMMY_PARENT == parents.get(lastPosition)) {
                lastPosition--;
            }
            parent = parents.get(lastPosition);
        }
        
        return parent;
    }
    
    /**
     * Returns the latest parent with the given <code>type</code>.
     * 
     * @param <T> the actual type of the parent to be returned
     * @param type the type to search for
     * @return the latest parent with given <code>type</code> or {@link #getParent()} if <code>type==<b>null</b></code>
     */
    protected <T extends IModelElement> T getParent(Class<T> type) {
        T result = null;
        for (int p = parents.size() - 1; null == result && p >= 0; p--) {
            IModelElement tmp = parents.get(p);
            if (type.isInstance(tmp)) {
                result = type.cast(tmp);
            }
        }
        return result;
    }
    
    /**
     * Removes the last parent from the list of all parents.
     * This method should be used inside the <b>after</b> visit methods.
     */
    protected void removeLastParent() {
        if (parents.size() > 0) {
            int lastPosition = parents.size() - 1;
            parents.remove(lastPosition);
        }
    }

    /**
     * Adds the given element to the list of all parents.
     * 
     * @param parent the parent to be added
     */
    protected void addParent(IModelElement parent) {
        parents.add(parent);
    }

    /**
     * Returns whether comments are emitted by this writer.
     * 
     * @return <code>true</code> if comments are emitted, <code>false</code> else
     */
    public abstract boolean emitComments();

    /**
     * Prints default spaces.
     * 
     * @param location the intended location of the space
     */
    protected abstract void printDefaultSpace(DefaultSpace location);
    
    /**
     * Processes a version information.
     * 
     * @param version the version to be processed
     */
    protected abstract void processVersion(Version version);
    
    @Override
    public void visitProject(Project project) {
        //Write beginning
        appendIndentation();
        startWritingProject(project);
        
        //Add project to list of parents (for writing nested elements)
        parents.add(project);
        
        if (project.getVersion() != null) {
            boolean defltSpace = true;
            Comment comment = project.getNestedComment(project.getVersion());
            if (null != comment) {
                defltSpace = false;
                appendOutput(comment.getName());
            }
            if (defltSpace) {
                printDefaultSpace(DefaultSpace.PROJECT);
            }
            processVersion(project.getVersion());
        } else {
            printDefaultSpace(DefaultSpace.PROJECT);
        }

        int count;
        //Projects imports
        count = project.getImportsCount();
        for (int p = 0; p < count; p++) {
            project.getImport(p).accept(this);
        }
        //Elements on top layer inside the project
        count = project.getElementCount();
        for (int c = 0; c < count; c++) {
            ContainableModelElement element = project.getElement(c);
            if (element instanceof ProjectInterface) {
                project.getElement(c).accept(this);
            }
        }
        count = project.getAttributesCount();
        for (int a = project.getAttributesCount(); a < count; a++) {
            project.getAttribute(a).accept(this);
        }
        //Elements on top layer inside the project
        count = project.getElementCount();
        for (int c = 0; c < count; c++) {
            ContainableModelElement element = project.getElement(c);
            if (!(element instanceof ProjectInterface)) {
                project.getElement(c).accept(this);
            }
        }

        //No more nested elements, remove project from list of parents
        removeLastParent();
        
        //write end of project.
        appendIndentation();
        endWritingProject(project);
        
        //Project is closed, there shouldn't be any further elements to read. Thus, flush the writer.
        try {
            flush();
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(AbstractVarModelWriter.class, Bundle.ID).exception(e);
        }
    }
    
    /**
     * Method for visiting an orded enum.
     * 
     * @param eenum The enum which should be visited.
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        visitEnum(eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        //Write beginning
        appendIndentation();
        startWritingCompound(compound);
        
        //Add compound to list of parents (for writing nested elements)
        parents.add(compound);
        //Nested DecisionVariableDeclarations
        int meCount = compound.getModelElementCount();
        for (int e = 0; e < meCount; e++) {
            ContainableModelElement elt = compound.getModelElement(e);
            beforeNestedElement(elt);
            elt.accept(this);
        }
        //Close Compound
        removeLastParent();
        
        //write end of project.
        appendIndentation();
        endWritingCompound(compound);
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        parents.add(assignment);
        for (int m = 0; m < assignment.getModelElementCount(); m++) {
            assignment.getModelElement(m).accept(this);
        }
        removeLastParent();
    }
    
    /**
     * Method for writing a compound, first part.<br/>
     * @param compound The compound which should be saved.
     */
    protected abstract void startWritingCompound(Compound compound);
    
    /**
     * Method for writing a compound, second part.<br/>
     * @param compound The compound which should be saved.
     */
    protected abstract void endWritingCompound(Compound compound);

    /**
     * Method for writing a project, first part.<br/>
     * @param project The project which should be saved.
     */
    protected abstract void startWritingProject(Project project);
    
    
    /**
     * Method for writing a project, second part.<br/>
     * @param project The project which should be saved.
     */
    protected abstract void endWritingProject(Project project);
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        Value val = value.getConstantValue();
        if (null != val) {
            // dispatch ;)
            val.accept(this);
        } else {
            appendOutput("<null>");  // debugging only!
        }
    }

    @Override
    public void visitConstraintValue(ConstraintValue value) {
        ConstraintSyntaxTree val = value.getValue();
        if (null != val) {
            emitConstraintExpression(expressionContext, val);
        }
    }
    
    @Override
    public void visitConstraint(Constraint constraint) {
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        if (null != cst) {
            emitConstraintExpression(constraint, constraint.getConsSyntax());
        }
    }
    
    /**
     * Visits the expression of a constraint (for extension).
     * 
     * @param context the visiting context
     * @param constraint the (specified) constraint;
     */
    protected void emitConstraintExpression(IModelElement context, ConstraintSyntaxTree constraint) {
        expressionContext = context;
        constraint.accept(this);
        expressionContext = null;
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        parents.add(block);
        for (int e = 0; e < block.getModelElementCount(); e++) {
            ContainableModelElement cme = block.getModelElement(e);
            if (!(cme instanceof IPartialEvaluable)) {
                block.getModelElement(e).accept(this);
            }
        }
        for (int e = 0; e < block.getEvaluableCount(); e++) {
            IPartialEvaluable evaluable = block.getEvaluable(e);
            beforeNestedElement(evaluable);
            evaluable.accept(this);
        }
        removeLastParent();
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        parents.add(freeze);
        for (int f = 0; f < freeze.getFreezableCount(); f++) {
            IFreezable freezable = freeze.getFreezable(f);
            beforeNestedElement(freezable);
            freezable.accept(this);
        }
        removeLastParent();
    }
    
    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        if (expression.isLeaf()) {
            appendOutput(expression.getUnresolvedLeaf());
        } else {
            ConstraintSyntaxTree actual = expression.getActualExpression();
            if (null != actual) {
                actual.accept(this);
            }
        }
    }
    
    /**
     * This method is called before a nested element is emitted. This enables the output of comments before the
     * <code>element</code> etc.
     * 
     * @param element the element (no specific type needed, see {@link Comment}
     */
    protected void beforeNestedElement(Object element) {
    }
    
    /**
     * Returns the number of hierarchically visited parents.
     * 
     * @return the number of hierarchically visited parents
     */
    protected int getParentCount() {
        return parents.size();
    }
    
    /**
     * Returns the specified hierarchically visited parent.
     * 
     * @param index the 0-based index of the visited parent
     * @return the specified visited parent
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParentCount()}</code>
     */
    protected IModelElement getParent(int index) {
        return parents.get(index);
    }

}

