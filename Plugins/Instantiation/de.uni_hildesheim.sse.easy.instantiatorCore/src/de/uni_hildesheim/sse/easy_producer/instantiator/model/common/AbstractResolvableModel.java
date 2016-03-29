package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.ModelEvents;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A basic implementation of {@link IResolvableModel}. It registers itself
 * as model listener in order to be informed when advices are updated causing
 * the model to be flagged as dirty (direct reload may cause uncoordinated model 
 * reloads).
 * 
 * @param <V> the actual type of variable declaration
 * @param <M> the actual type of model
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractResolvableModel<V extends IResolvable, M extends IModel> implements IResolvableModel<V>, 
    IModelListener<Project>, ITypedefReceiver {

    private transient boolean dirty = false;
    private Imports<M> imports;
    private TypeRegistry registry;
    private Advice[] advices;
    private List<Typedef> typedefs;

    /**
     * Creates an abstract resolvable model.
     * 
     * @param imports the imports
     * @param registry the registry which is responsible for this type
     * @param advices the advices (may be <b>null</b>)
     */
    protected AbstractResolvableModel(Imports<M> imports, TypeRegistry registry, Advice[] advices) {
        this.imports = imports;
        this.registry = registry;
        this.advices = advices;
        processModelListeners(true);
    }
    
    /**
     * Processes the model listeners for the advices.
     * 
     * @param add add or remove the model listeners
     */
    private void processModelListeners(boolean add) {
        if (null != advices) {
            ModelEvents<Project> events = VarModel.INSTANCE.events();
            for (int a = 0; a < advices.length; a++) {
                Project resolved = advices[a].getResolved();
                if (null != resolved) {
                    if (add) {
                        events.addModelListener(resolved, this);
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Added model listener to " 
                            + resolved.getName() + " " + System.identityHashCode(resolved) + " from " + getName() 
                            + " " + System.identityHashCode(this)); // for Cui
                    } else {
                        events.removeModelListener(resolved, this);
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Removed model listener to " 
                            + resolved.getName() + " " + System.identityHashCode(resolved) + " from " + getName() + " " 
                            + System.identityHashCode(this)); // for Cui
                    }
                }
            }
        }
    }
    
    @Override
    public int getImportsCount() {
        return null == imports ? 0 : imports.getImportsCount();
    }

    @Override
    public ModelImport<M> getImport(int index) {
        if (null == imports) {
            throw new IllegalArgumentException();
        }
        return imports.getImport(index);
    }
    
    /**
     * Creates an empty imports instance (in case that a specialized instance
     * shall be used).
     * 
     * @return the created instance
     */
    protected Imports<M> createImports() {
        return new Imports<M>((List<ModelImport<M>>) null);
    }
    
    /**
     * Add a project import to this model.
     * 
     * @param imp The additional project import.
     */
    public void addImport(ModelImport<M> imp) {
        if (null == imports) {
            imports = createImports();
        }
        imports.add(imp);
    }
    
    /**
     * Returns the imports instance.
     * 
     * @return the imports instance
     */
    protected Imports<M> getImports() {
        return imports;
    }
    
    @Override
    public TypeRegistry getTypeRegistry() {
        return registry;
    }

    /**
     * Get the number of advices of this model.
     * 
     * @return The number of advices of this model.
     */
    public int getAdviceCount() {
        return null == advices ? 0 : advices.length;
    }
    
    /**
     * Get the advice at the specified index.
     * 
     * @param index The 0-based index of the advice to be returned.
     * @return The advice parameter at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getAdviceCount()}</code>
     */
    public Advice getAdvice(int index) {
        if (null == advices) {
            throw new IndexOutOfBoundsException();
        }
        return advices[index];
    }
    
    /**
     * Get the number of typedefs of this model.
     * 
     * @return The number of typedefs of this model.
     */
    public int getTypedefCount() {
        return null == typedefs ? 0 : typedefs.size();
    }
    
    /**
     * Get the typedef at the specified index.
     * 
     * @param index The 0-based index of the advice to be returned.
     * @return The advice parameter at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getTypedefCount()}</code>
     */
    public Typedef getTypedef(int index) {
        if (null == typedefs) {
            throw new IndexOutOfBoundsException();
        }
        return typedefs.get(index);
    }
    
    /**
     * Adds a typedef.
     * 
     * @param typedef the typedef to be added
     */
    public void addTypedef(Typedef typedef) {
        if (null == typedefs) {
            typedefs = new ArrayList<Typedef>();
        }
        typedefs.add(typedef);
    }

    @Override
    public void dispose() {
        processModelListeners(false);
    }

    /**
     * Returns whether this model has become dirty, e.g., due to updates
     * of the underlying adviced models.
     * 
     * @return <code>true</code> if this model has become dirty and
     *   shall be at least reloaded before execution, <code>false</code> else
     */
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public void notifyReplaced(Project oldModel, Project newModel) {
        if (null != newModel) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Model " + getName() + " " 
                + System.identityHashCode(this) + " became dirty as " + newModel.getName() 
                + " was changed."); // for Cui
        }
        // Use both as long as editor updates will not work every time
        dirty = true;
        //reload(); // this causes loops
    }
    
    @Override
    public Object getIvmlElement(String name) {
        Object result = null;
        // TODO consider parent?
        for (int a = 0; null == result && a < getAdviceCount(); a++) {
            result = getAdvice(a).getIvmlElement(name);
        }
        return result;
    }
    
    /**
     * Causes a reload of this model.
     */
    protected abstract void reload();

}
