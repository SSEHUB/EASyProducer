package eu.qualimaster.families.imp;

import javax.annotation.Generated;
import backtype.storm.Config;

/**
 * The registration of the generated serializers (GEN).
 */
@Generated(value="EASy-Producer")
public class SerializationRegistry {

    /**
     * Registers all generated kryo serializers. To be called from a topology.
     */
    public static final void registerKryoSerializers(Config conf) {
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialPreprocessedStreamInputSerializer.class);
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialSymbolListInput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialSymbolListInputSerializer.class);
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialPairwiseFinancialOutputSerializer.class);
        conf.registerSerialization(FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput.class, FSentimentAnalysisSerializers.IFSentimentAnalysisAnalyzedStreamOutputSerializer.class);
    }

    /**
     * Registers all generated hardware serializers. To be called from a topology.
     */
    public static final void registerHardwareSerializers() {
    }
}
