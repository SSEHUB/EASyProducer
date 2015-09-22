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
        conf.registerSerialization(FPreprocessor.IFPreprocessorSpringStreamInput.class, FPreprocessorSerializers.IFPreprocessorSpringStreamInputSerializer.class);
        conf.registerSerialization(FPreprocessor.IFPreprocessorPreprocessedStreamOutput.class, FPreprocessorSerializers.IFPreprocessorPreprocessedStreamOutputSerializer.class);
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialPreprocessedStreamInput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialPreprocessedStreamInputSerializer.class);
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialSymbolListInput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialSymbolListInputSerializer.class);
        conf.registerSerialization(FCorrelationFinancial.IFCorrelationFinancialPairwiseFinancialOutput.class, FCorrelationFinancialSerializers.IFCorrelationFinancialPairwiseFinancialOutputSerializer.class);
        conf.registerSerialization(FSentimentAnalysis.IFSentimentAnalysisTwitterStreamInput.class, FSentimentAnalysisSerializers.IFSentimentAnalysisTwitterStreamInputSerializer.class);
        conf.registerSerialization(FSentimentAnalysis.IFSentimentAnalysisAnalyzedStreamOutput.class, FSentimentAnalysisSerializers.IFSentimentAnalysisAnalyzedStreamOutputSerializer.class);
        conf.registerSerialization(FCorrelationTwitter.IFCorrelationTwitterAnalyzedStreamInput.class, FCorrelationTwitterSerializers.IFCorrelationTwitterAnalyzedStreamInputSerializer.class);
        conf.registerSerialization(FCorrelationTwitter.IFCorrelationTwitterSymbolListInput.class, FCorrelationTwitterSerializers.IFCorrelationTwitterSymbolListInputSerializer.class);
        conf.registerSerialization(FCorrelationTwitter.IFCorrelationTwitterPairwiseTwitterOutput.class, FCorrelationTwitterSerializers.IFCorrelationTwitterPairwiseTwitterOutputSerializer.class);
        conf.registerSerialization(FMismatchedFamily.IFMismatchedFamilyMisStringInput.class, FMismatchedFamilySerializers.IFMismatchedFamilyMisStringInputSerializer.class);
        conf.registerSerialization(FMismatchedFamily.IFMismatchedFamilyMisStringOutput.class, FMismatchedFamilySerializers.IFMismatchedFamilyMisStringOutputSerializer.class);
        conf.registerSerialization(RandomFamily.IRandomFamilyRandomDataInput.class, RandomFamilySerializers.IRandomFamilyRandomDataInputSerializer.class);
        conf.registerSerialization(RandomFamily.IRandomFamilyProccessedDataOutput.class, RandomFamilySerializers.IRandomFamilyProccessedDataOutputSerializer.class);
        conf.registerSerialization(SwitchFamily.ISwitchFamilyRandomDataInput.class, SwitchFamilySerializers.ISwitchFamilyRandomDataInputSerializer.class);
        conf.registerSerialization(SwitchFamily.ISwitchFamilyProccessedDataOutput.class, SwitchFamilySerializers.ISwitchFamilyProccessedDataOutputSerializer.class);
        conf.registerSerialization(AggregateFamily.IAggregateFamilyRandomDataInput.class, AggregateFamilySerializers.IAggregateFamilyRandomDataInputSerializer.class);
        conf.registerSerialization(AggregateFamily.IAggregateFamilyRandomDataOutput.class, AggregateFamilySerializers.IAggregateFamilyRandomDataOutputSerializer.class);
        conf.registerSerialization(FExpertSearch.IFExpertSearchAnalysisInput.class, FExpertSearchSerializers.IFExpertSearchAnalysisInputSerializer.class);
        conf.registerSerialization(FExpertSearch.IFExpertSearchAnalysisOutput.class, FExpertSearchSerializers.IFExpertSearchAnalysisOutputSerializer.class);
        conf.registerSerialization(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput.class, FFinancialNetworkExtractionSerializers.IFFinancialNetworkExtractionAnalysisInputSerializer.class);
        conf.registerSerialization(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput.class, FFinancialNetworkExtractionSerializers.IFFinancialNetworkExtractionAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterCrawling.IFTwitterCrawlingAnalysisInput.class, FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterCrawling.IFTwitterCrawlingAnalysisOutput.class, FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterEventDetection.IFTwitterEventDetectionAnalysisInput.class, FTwitterEventDetectionSerializers.IFTwitterEventDetectionAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterEventDetection.IFTwitterEventDetectionAnalysisOutput.class, FTwitterEventDetectionSerializers.IFTwitterEventDetectionAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput.class, FTwitterEventPredictionSerializers.IFTwitterEventPredictionAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput.class, FTwitterEventPredictionSerializers.IFTwitterEventPredictionAnalysisOutputSerializer.class);
    }

/**
 * Registers all generated hardware serializers. To be called from a topology.
 */
    public static final void registerHardwareSerializers() {
    }
}
