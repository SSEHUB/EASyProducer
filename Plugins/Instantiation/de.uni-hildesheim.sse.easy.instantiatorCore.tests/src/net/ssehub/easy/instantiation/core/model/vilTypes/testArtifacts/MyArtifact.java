package net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactChangedListener;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * An own artifact. Please adjust the declared arrays in case that further VIL
 * constructors or visible operations are added so that the test cases can react
 * appropriately and automatically.
 * 
 * @author Holger Eichelberger
 *
 */
public class MyArtifact extends DefaultSimpleArtifact implements IMyArtifact, IArtifactChangedListener {
    
    /**
     * The constructor shall not be visible although public.
     */
    public MyArtifact() {
    }
    
    /**
     * This is the VIL "constructor" method as constructors may be used for internal purposes.
     * 
     * @param test a parameter
     * @return the created artifact
     */
    public static MyArtifact create(String test) {
        return new MyArtifact();
    }
    
    /**
     * This method shall not be visible at all.
     */
    @Invisible
    public void doInternalStuff() {
    }

    /**
     * This method shall also not be visible as protected.
     */
    protected void doMoreInternalStuff() {
        doEvenMoreInternalStuff();
    }

    /**
     * This method shall also not be visible as private.
     */
    private void doEvenMoreInternalStuff() {
    }

    /**
     * Neither this nor overriding methods shall be visible to VIL.
     */
    @Invisible(inherit = true)
    public void invisible() {
    }

    /**
     * Neither this nor overriding methods shall be visible to VIL due to an inherited annotation.
     */
    @Override
    public void internal() {
    }

    /**
     * This shall be visible (implementing an interface).
     */
    @Override
    public void shallBeVisible() {
    }

    @Override
    public void artifactChanged(Object cause) throws VilException {
    }
   
    /**
     * Shall be invisible by default (see 
     * {@link net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry#INVISIBLE_BY_DEFAULT}).
     * 
     * @return the textual representation of this object
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void store() throws VilException {
        // does not care here as we use this class just for testing the TypeRegistry
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public long lastModification() {
        return 0; // does not care here as we use this class just for testing the TypeRegistry
    }

    @Override
    public void update() throws VilException {
    }

}
