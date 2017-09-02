package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IRestrictionEvaluationContext;
import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaField;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaParameterDeclaration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a dummy model used for properly initializing {@link RuntimeEnvironment}.
 * 
 * @param <V> the variable declaration type
 * @param <M> the model type
 * @author Holger Eichelberger
 */
class DummyModel<V extends IMetaParameterDeclaration, M extends IModel> implements IResolvableModel<V, M> {

    /**
     * Prevents external instantiation (singleton).
     */
    public DummyModel() {
    }
    
    @Override
    public void setVersion(Version version) {
    }

    @Override
    public Version getVersion() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ModelImport<?> getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public ModelImport<?> getSuper() {
        return null;
    }

    @Override
    public IndentationConfiguration getIndentationConfiguration() {
        return null;
    }

    @Override
    public void dispose() {
    }

    @Override
    public IRestrictionEvaluationContext getRestrictionEvaluationContext() {
        return null;
    }

    @Override
    public String getQualifiedName() {
        return "";
    }

    @Override
    public int getOperationsCount() {
        return 0;
    }

    @Override
    public IMetaOperation getOperation(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isAssignableFrom(IMetaType type) {
        return false;
    }

    @Override
    public IMetaOperation findConversion(IMetaType sourceType, IMetaType targetType) {
        return null;
    }

    @Override
    public boolean isBasicType() {
        return false;
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return TypeRegistry.DEFAULT;
    }

    @Override
    public boolean enableDynamicDispatch() {
        return false;
    }

    @Override
    public boolean isPlaceholder() {
        return true;
    }

    @Override
    public IMetaOperation addPlaceholderOperation(String name, int parameterCount, boolean acceptsNamedParameters) {
        return null;
    }

    @Override
    public boolean isActualTypeOf(IMetaType type) {
        return false;
    }

    @Override
    public IMetaType getBaseType() {
        return null;
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public IMetaField getField(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public IMetaType getSuperType() {
        return null;
    }
    
    @Override
    public int getGenericParameterCount() {
        return 0;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        throw new IllegalArgumentException();
    }
    
    @Override
    public boolean checkConversion(IMetaType param, IMetaOperation conversion) {
        return true;
    }

    @Override
    public int getParameterCount() {
        return 0;
    }

    @Override
    public V getParameter(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getRequiredParameterCount() {
        return 0;
    }

    @Override
    public V getParameter(String name) {
        return null;
    }

    @Override
    public Object getIvmlElement(String name) {
        return null;
    }

    @Override
    public IResolvableModel<V, M> getParent() {
        return null;
    }

    @Override
    public int getExtensionTypesCount() {
        return 0;
    }

    @Override
    public IMetaType getExtensionType(int index) {
        return null;
    }

    @Override
    public int getVariableDeclarationCount() {
        return 0;
    }

    @Override
    public V getVariableDeclaration(int index) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isImplicit(IMetaParameterDeclaration decl) {
        return false;
    }

    @Override
    public int getTypedefCount() {
        return 0;
    }

    @Override
    public Typedef getTypedef(int index) {
        return null;
    }

    @Override
    public void addRuntimeImport(ModelImport<M> imp) {
    }

}
