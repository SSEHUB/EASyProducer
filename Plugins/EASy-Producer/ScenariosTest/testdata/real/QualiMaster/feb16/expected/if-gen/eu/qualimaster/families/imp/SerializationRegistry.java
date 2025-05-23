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
        conf.registerSerialization(FExpertSearch.IFExpertSearchAnalysisInput.class, FExpertSearchSerializers.IFExpertSearchAnalysisInputSerializer.class);
        conf.registerSerialization(FExpertSearch.IFExpertSearchAnalysisOutput.class, FExpertSearchSerializers.IFExpertSearchAnalysisOutputSerializer.class);
        conf.registerSerialization(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisInput.class, FFinancialNetworkExtractionSerializers.IFFinancialNetworkExtractionAnalysisInputSerializer.class);
        conf.registerSerialization(FFinancialNetworkExtraction.IFFinancialNetworkExtractionAnalysisOutput.class, FFinancialNetworkExtractionSerializers.IFFinancialNetworkExtractionAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterCrawling.IFTwitterCrawlingAnalysisInput.class, FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterCrawling.IFTwitterCrawlingAnalysisOutput.class, FTwitterCrawlingSerializers.IFTwitterCrawlingAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamInput.class, FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamInputSerializer.class);
        conf.registerSerialization(FTwitterEventDetection.IFTwitterEventDetectionTwitterStreamOutput.class, FTwitterEventDetectionSerializers.IFTwitterEventDetectionTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FTwitterEventPrediction.IFTwitterEventPredictionAnalysisInput.class, FTwitterEventPredictionSerializers.IFTwitterEventPredictionAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterEventPrediction.IFTwitterEventPredictionAnalysisOutput.class, FTwitterEventPredictionSerializers.IFTwitterEventPredictionAnalysisOutputSerializer.class);
        conf.registerSerialization(FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisInput.class, FTwitterStreamFilteringSerializers.IFTwitterStreamFilteringAnalysisInputSerializer.class);
        conf.registerSerialization(FTwitterStreamFiltering.IFTwitterStreamFilteringAnalysisOutput.class, FTwitterStreamFilteringSerializers.IFTwitterStreamFilteringAnalysisOutputSerializer.class);
        conf.registerSerialization(FSpamDetection.IFSpamDetectionTwitterStreamInput.class, FSpamDetectionSerializers.IFSpamDetectionTwitterStreamInputSerializer.class);
        conf.registerSerialization(FSpamDetection.IFSpamDetectionTwitterStreamOutput.class, FSpamDetectionSerializers.IFSpamDetectionTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FSpamRemoval.IFSpamRemovalTwitterStreamInput.class, FSpamRemovalSerializers.IFSpamRemovalTwitterStreamInputSerializer.class);
        conf.registerSerialization(FSpamRemoval.IFSpamRemovalTwitterStreamOutput.class, FSpamRemovalSerializers.IFSpamRemovalTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FTweetClassifier.IFTweetClassifierModifiedTwitterStreamInput.class, FTweetClassifierSerializers.IFTweetClassifierModifiedTwitterStreamInputSerializer.class);
        conf.registerSerialization(FTweetClassifier.IFTweetClassifierKeywordStreamInput.class, FTweetClassifierSerializers.IFTweetClassifierKeywordStreamInputSerializer.class);
        conf.registerSerialization(FTweetClassifier.IFTweetClassifierModifiedTwitterStreamOutput.class, FTweetClassifierSerializers.IFTweetClassifierModifiedTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamInput.class, FKeywordAnalyzerSerializers.IFKeywordAnalyzerTwitterStreamInputSerializer.class);
        conf.registerSerialization(FKeywordAnalyzer.IFKeywordAnalyzerTwitterStreamOutput.class, FKeywordAnalyzerSerializers.IFKeywordAnalyzerTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FEventEnrichment.IFEventEnrichmentEventStreamInput.class, FEventEnrichmentSerializers.IFEventEnrichmentEventStreamInputSerializer.class);
        conf.registerSerialization(FEventEnrichment.IFEventEnrichmentKeywordStreamInput.class, FEventEnrichmentSerializers.IFEventEnrichmentKeywordStreamInputSerializer.class);
        conf.registerSerialization(FEventEnrichment.IFEventEnrichmentEnrichedEventsStreamOutput.class, FEventEnrichmentSerializers.IFEventEnrichmentEnrichedEventsStreamOutputSerializer.class);
        conf.registerSerialization(FRecommendations.IFRecommendationsTwitterStreamInput.class, FRecommendationsSerializers.IFRecommendationsTwitterStreamInputSerializer.class);
        conf.registerSerialization(FRecommendations.IFRecommendationsRecommendationStreamOutput.class, FRecommendationsSerializers.IFRecommendationsRecommendationStreamOutputSerializer.class);
        conf.registerSerialization(FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamInput.class, FSimpleRecommendationsSerializers.IFSimpleRecommendationsTwitterStreamInputSerializer.class);
        conf.registerSerialization(FSimpleRecommendations.IFSimpleRecommendationsTwitterStreamOutput.class, FSimpleRecommendationsSerializers.IFSimpleRecommendationsTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FStockParser.IFStockParserTwitterStreamInput.class, FStockParserSerializers.IFStockParserTwitterStreamInputSerializer.class);
        conf.registerSerialization(FStockParser.IFStockParserTwitterStreamOutput.class, FStockParserSerializers.IFStockParserTwitterStreamOutputSerializer.class);
        conf.registerSerialization(FDynamicGraphCompilation.IFDynamicGraphCompilationPairwiseFinancialInput.class, FDynamicGraphCompilationSerializers.IFDynamicGraphCompilationPairwiseFinancialInputSerializer.class);
        conf.registerSerialization(FDynamicGraphCompilation.IFDynamicGraphCompilationEdgeStreamOutput.class, FDynamicGraphCompilationSerializers.IFDynamicGraphCompilationEdgeStreamOutputSerializer.class);
        conf.registerSerialization(FDynamicHubComputation.IFDynamicHubComputationEdgeStreamInput.class, FDynamicHubComputationSerializers.IFDynamicHubComputationEdgeStreamInputSerializer.class);
        conf.registerSerialization(FDynamicHubComputation.IFDynamicHubComputationHubStreamOutput.class, FDynamicHubComputationSerializers.IFDynamicHubComputationHubStreamOutputSerializer.class);
        conf.registerSerialization(FTransferEntropy.IFTransferEntropyPreprocessedStreamInput.class, FTransferEntropySerializers.IFTransferEntropyPreprocessedStreamInputSerializer.class);
        conf.registerSerialization(FTransferEntropy.IFTransferEntropySymbolListInput.class, FTransferEntropySerializers.IFTransferEntropySymbolListInputSerializer.class);
        conf.registerSerialization(FTransferEntropy.IFTransferEntropyPairwiseFinancialOutput.class, FTransferEntropySerializers.IFTransferEntropyPairwiseFinancialOutputSerializer.class);
    }

/**
 * Registers all generated hardware serializers. To be called from a topology.
 */
    public static final void registerHardwareSerializers() {
    }
}
