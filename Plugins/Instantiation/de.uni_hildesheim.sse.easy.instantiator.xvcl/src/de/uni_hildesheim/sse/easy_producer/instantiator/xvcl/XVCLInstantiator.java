package de.uni_hildesheim.sse.easy_producer.instantiator.xvcl;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;

/**
 * XVCL Instantiator.
 * @author El-Sharkawy
 *
 */
@Instantiator("xvcl")
public class XVCLInstantiator implements IVilType {
    
    /**
     * Instantiates the given XVCL specification file via VIL.
     * @param specification The stating point for instantiation with XVCL.
     * @throws ArtifactException If XVCL detects any errors, while parsing the specification.
     */
    public static void xvcl(FileArtifact specification) throws ArtifactException {
        XvclTransformatorEngine instantiator = new XvclTransformatorEngine();
        try {
            instantiator.clearContext();
            instantiator.instantiate(specification);
        } catch (InstantiatorException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        } finally {
            instantiator = null;
            System.gc();
        }
    }

}
