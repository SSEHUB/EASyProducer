package iip.nodes;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.PostConstruct;

import de.iip_ecosphere.platform.connectors.Connector;
import de.iip_ecosphere.platform.connectors.ConnectorFactory;
import de.iip_ecosphere.platform.connectors.ConnectorParameter;
import de.iip_ecosphere.platform.connectors.ConnectorParameter.CacheMode;
import de.iip_ecosphere.platform.connectors.ConnectorParameter.ConnectorParameterBuilder;
import de.iip_ecosphere.platform.connectors.model.ModelAccess;
import de.iip_ecosphere.platform.connectors.model.ModelInputConverter;
import de.iip_ecosphere.platform.connectors.model.ModelOutputConverter;
import de.iip_ecosphere.platform.connectors.rest.RESTItem;
import de.iip_ecosphere.platform.connectors.types.AbstractConnectorInputTypeTranslator;
import de.iip_ecosphere.platform.connectors.types.AbstractConnectorOutputTypeTranslator;
import de.iip_ecosphere.platform.connectors.types.TranslatingProtocolAdapter;
import de.iip_ecosphere.platform.services.environment.ConnectorServiceWrapper;
import de.iip_ecosphere.platform.services.environment.MonitoringService;
import de.iip_ecosphere.platform.services.environment.YamlArtifact;
import de.iip_ecosphere.platform.services.environment.YamlService;
import de.iip_ecosphere.platform.services.environment.metricsProvider.MonitoredTranslatingProtocolAdapter;
import de.iip_ecosphere.platform.services.environment.spring.SpringAsyncServiceBase;
import de.iip_ecosphere.platform.services.environment.spring.Starter;
import de.iip_ecosphere.platform.services.environment.spring.metricsProvider.MetricsProvider;
import de.iip_ecosphere.platform.services.environment.switching.ServiceBase;
import de.iip_ecosphere.platform.support.ServerAddress;
import de.iip_ecosphere.platform.support.iip_aas.NameplateSetup;
import de.iip_ecosphere.platform.support.iip_aas.NameplateSetup.Service;
import de.iip_ecosphere.platform.support.net.NetworkManagerFactory;
import de.iip_ecosphere.platform.support.resources.ResourceLoader;
import de.iip_ecosphere.platform.transport.Transport;
import de.iip_ecosphere.platform.transport.connectors.ReceptionCallback;

import iip.datatypes.RestPhoenixEEMMixed;
import iip.datatypes.RestPhoenixEEMMixedImpl;
import iip.datatypes.RestPhoenixEEMResponseInformation;
import iip.datatypes.RestPhoenixEEMResponseInformationInfoItem;
import iip.datatypes.RestPhoenixEEMResponseInformationRootItem;
import iip.datatypes.RestPhoenixEEMResponseMeasurementSet;
import iip.datatypes.RestPhoenixEEMResponseMeasurementSetItem;
import iip.datatypes.RestPhoenixEEMResponseMeasurementSingle;
import iip.datatypes.RestPhoenixEEMResponseTariffNumber;
import iip.datatypes.RestPhoenixRwEEMMixed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Spring Cloud Stream service frame for net node 'myRestConnEEMMixed example'.
 * Generated by: EASy-Producer.
 */
@Component
@ConditionalOnProperty(value = "iip.service.myRestConnEEMMixed", havingValue = "true", matchIfMissing = true)
@EnableScheduling
public class MyRestConnEEMMixedExample extends SpringAsyncServiceBase {

    @Value("${iip.service.myRestConnEEMMixed:true}")
    private String activated;
    @Autowired
    private StreamBridge streamBridge;
    private ConnectorServiceWrapper<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed> service;
    @Autowired
    private MetricsProvider metrics;
    private Counter serviceSent;
    private Counter serviceReceived;
    private Timer processingTime;
    private String appInstId = "";

    /**
     * Creates an instance.
     */
    public MyRestConnEEMMixedExample() {
        ConnectorParameter param = createConnectorParameter();
        Connector<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed> conn = ConnectorFactory.createConnector(
            "MyRestConnEEMMixedExampleImpl", () -> param, createConnectorAdapter(()->service.getInPath(
            ""), ()->service.getOutPath("")));
        conn.enablePolling(false);
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader.getResourceAsStream("deployment.yml"));
        YamlService serviceData = art.getServiceSafe("myRestConnEEMMixed");
        service = new ConnectorServiceWrapper<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>(serviceData,
            conn, () -> param);
        service.setReceptionCallback(new ConnectorReceptionCallback());
        appInstId = getAppInstIdSuffix(service, "_");
    }

    /**
     * Creates the default connector adapter without path suppliers. [public for testing]
     *
     * @return the connector adapter
     */
    public static TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>
        createConnectorAdapter() {
        return createConnectorAdapter(null, null, null, null);
    }

    /**
     * Creates the connector adapter. [public for testing]
     *
     * @param inPathSupplier function returning the actual input base path to use for data accesses, may be <b>null</b>
     * @param outPathSupplier function returning the actual output base path to use for data accesses, may be <b>null</b>
     * @return the connector adapter
     */
    public static TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>
        createConnectorAdapter(Supplier<String> inPathSupplier, Supplier<String>
        outPathSupplier) {
        return createConnectorAdapter(null, null, inPathSupplier, outPathSupplier);
    }

    /**
     * Creates the connector adapter. [public for testing]
     *
     * @param metrics the metrics provider to use, <b>null</b> for no metric measurements
     * @param log the log file to use to record individual measurements in experiments, <b>null</b> for no logging. Only
     * becomes active if {@code metrics} is not <b>null</b>
     * @return the connector adapter
     */
    public static TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>
        createConnectorAdapter(de.iip_ecosphere.platform.services.environment.metricsProvider.
        MetricsProvider metrics, File log) {
        return createConnectorAdapter(metrics, log, null, null);
    }

    /**
     * Creates the connector adapter. [public for testing]
     *
     * @param metrics the metrics provider to use, <b>null</b> for no metric measurements
     * @param log the log file to use to record individual measurements in experiments, <b>null</b> for no logging. Only
     * becomes active if {@code metrics} is not <b>null</b>
     * @param inPathSupplier function returning the actual input base path to use for data accesses, may be <b>null</b>
     * @param outPathSupplier function returning the actual output base path to use for data accesses, may be <b>null</b>
     * @return the connector adapter
     */
    public static TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>
        createConnectorAdapter(de.iip_ecosphere.platform.services.environment.metricsProvider.
        MetricsProvider metrics, File log, Supplier<String> inPathSupplier, Supplier<String>
        outPathSupplier) {
        TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed> adapter;
        if (metrics != null) {
            adapter = new MonitoredTranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed,
                RestPhoenixRwEEMMixed>(new MachineOutputTranslator(outPathSupplier), new
                MachineInputTranslator(inPathSupplier), metrics, log);
        } else {
            adapter = new TranslatingProtocolAdapter<RESTItem, Object, RestPhoenixEEMMixed, RestPhoenixRwEEMMixed>(new
                MachineOutputTranslator(outPathSupplier), new MachineInputTranslator(inPathSupplier));
        }
        return adapter;
    }

    /**
     * Called when data arrived that shall be passed on to the connector.
     *
     * @return the data consumer functor
     */
    @Bean
    public Consumer<RestPhoenixRwEEMMixed> createRestPhoenixRwEEMMixed_myRestConnEEMMixed() {
        return data -> {
            MetricsProvider.increaseCounterBy(serviceReceived, 1.0);
            processingTime.record(() -> service.send(data));
        };
    }

    /**
     * Creates the connector parameter instance. [public for testing]
     *
     * @return the instance to be passed to the connector
     */
    public static ConnectorParameter createConnectorParameter() {
        YamlArtifact art = YamlArtifact.readFromYamlSafe(ResourceLoader.getResourceAsStream("deployment.yml"));
        YamlService yaml = art.getServiceSafe("myRestConnEEMMixed");
        String host = "localhost";
        String hostOverride = null;
        int port = 8080;
        if (null != yaml.getNetMgtKey() && yaml.getNetMgtKey().length() > 0) {
            ServerAddress netKeyMgtAddress = NetworkManagerFactory.getInstance()
                .getPort(yaml.getNetMgtKey());
            if (null != netKeyMgtAddress) {
                host = netKeyMgtAddress.getHost();
                hostOverride = host;
                port = netKeyMgtAddress.getPort();
                System.out.println(host+" "+port);
            }
        }
        Service svc = NameplateSetup.resolveServiceFromAas("REST");
        if (null != svc) {
            host = svc.getHost();
            port = svc.getPort();
        }
        return ConnectorParameterBuilder.newBuilder(host, port)
            .setService(svc)
            .setApplicationInformation("myRestApp", "")
            .setCacheMode(CacheMode.NONE)
            .setNotificationInterval(0)
            .setSpecificSettingFromResourceSafe("SERVER_STRUCTURE", "myRestConnEEMMixedexample.server")
            .build();
    }

    /**
     * Initializes the service when feasible in Spring lifecycle.
     */
    @PostConstruct
    public void initService() {
        if (null == activated || "".equals(activated) || "true".equals(activated)) {
            LoggerFactory.getLogger(getClass())
                .info("Initializing service myRestConnEEMMixed: {}", activated);
            String iId;
            String sId;
            sId = Starter.getServiceId(service);
            iId = ServiceBase.getApplicationInstanceId(sId);
            if (iId == null || iId.length() == 0) {
                iId = "dflt";
            }
            serviceSent = metrics.createServiceSentCounter("myRestConnEEMMixed", sId, "myRestApp", iId);
            serviceReceived = metrics.createServiceReceivedCounter("myRestConnEEMMixed", sId, "myRestApp", iId);
            processingTime = metrics.createServiceProcessingTimer("myRestConnEEMMixed", sId, "myRestApp", iId);
            MonitoringService.setUp(service, metrics);
            Starter.mapService(service);
            // if notifications enabled, enable now also polling as @Autowired is done
            service.enablePolling(true);
        }
    }

    private static class MachineInputTranslator extends AbstractConnectorInputTypeTranslator<RestPhoenixRwEEMMixed,
        Object> {

        private Supplier<String> pathSupplier;

        private MachineInputTranslator(Supplier<String> pathSupplier) {
            this.pathSupplier = pathSupplier;
        }

        private void fromRestPhoenixEEMResponseTariffNumber(ModelAccess access, ModelOutputConverter outConverter,
            RestPhoenixRwEEMMixed data, String path) throws IOException {
            access.set(path + "context", outConverter.fromString(data.getTn2().getContext()));
            access.set(path + "id", outConverter.fromString(data.getTn2().getId()));
            access.set(path + "timestamp", outConverter.fromString(data.getTn2().getTimestamp()));
            access.set(path + "name", outConverter.fromString(data.getTn2().getName()));
            access.set(path + "value", outConverter.fromObject(data.getTn2().getValue()));
            access.set(path + "description", outConverter.fromString(data.getTn2().getDescription()));
        }

        @Override
        public Object from(RestPhoenixRwEEMMixed data) throws IOException {
            ModelAccess access = getModelAccess();
            final ModelInputConverter inConverter = access.getInputConverter();
            final ModelOutputConverter outConverter = access.getOutputConverter();
            final String path = pathSupplier == null ? "" : pathSupplier.get();
            access = access.stepInto("tn1");
            access = access.stepInto(path + "tn1");
            fromRestPhoenixEEMResponseTariffNumber(access, outConverter, data, path);
            access = access.stepOut();
            access = access.stepOut();
            access = access.stepInto("tn2");
            access = access.stepInto(path + "tn2");
            fromRestPhoenixEEMResponseTariffNumber(access, outConverter, data, path);
            access = access.stepOut();
            access = access.stepOut();
            // done, no instance of pseudo type
            return null;
        }

        @Override
        public Class<? extends Object> getSourceType() {
            return Object.class;
        }

        @Override
        public Class<? extends RestPhoenixRwEEMMixed> getTargetType() {
            return RestPhoenixRwEEMMixed.class;
        }

    }

    private static class MachineOutputTranslator extends AbstractConnectorOutputTypeTranslator<RESTItem,
        RestPhoenixEEMMixed> {

        private Supplier<String> pathSupplier;

        private MachineOutputTranslator(Supplier<String> pathSupplier) {
            this.pathSupplier = pathSupplier;
        }

        private void toRestPhoenixEEMResponseInformation(ModelAccess access, ModelInputConverter inConverter,
            RestPhoenixEEMResponseInformation resultgetInformation7, String path) throws IOException {
            resultgetInformation7.setContext(inConverter.toString(access.get(path + "context", -1)));
            resultgetInformation7.setTimestamp(inConverter.toString(access.get(path + "timestamp", -1)));
            resultgetInformation7.setRootItems((RestPhoenixEEMResponseInformationRootItem[]) inConverter.toObject(access.
                get(path + "rootItems", -1)));
            resultgetInformation7.setInfoItems((RestPhoenixEEMResponseInformationInfoItem[]) inConverter.toObject(access.
                get(path + "infoItems", -1)));
        }

        private void toRestPhoenixEEMResponseMeasurementSet(ModelAccess access, ModelInputConverter inConverter,
            RestPhoenixEEMResponseMeasurementSet resultgetAll6, String path) throws IOException {
            resultgetAll6.setContext(inConverter.toString(access.get(path + "context", -1)));
            resultgetAll6.setTimestamp(inConverter.toString(access.get(path + "timestamp", -1)));
            resultgetAll6.setItems((RestPhoenixEEMResponseMeasurementSetItem[]) inConverter.toObject(access.get(path + 
                "items", -1)));
        }

        private void toRestPhoenixEEMResponseMeasurementSingle(ModelAccess access, ModelInputConverter inConverter,
            RestPhoenixEEMResponseMeasurementSingle resultgetU35, String path) throws IOException {
            resultgetU35.setContext(inConverter.toString(access.get(path + "context", -1)));
            resultgetU35.setId(inConverter.toString(access.get(path + "id", -1)));
            resultgetU35.setTimestamp(inConverter.toString(access.get(path + "timestamp", -1)));
            resultgetU35.setName(inConverter.toString(access.get(path + "name", -1)));
            resultgetU35.setValue(inConverter.toObject(access.get(path + "value", -1)));
            resultgetU35.setUnit(inConverter.toString(access.get(path + "unit", -1)));
            resultgetU35.setDescription(inConverter.toString(access.get(path + "description", -1)));
        }

        private void toRestPhoenixEEMResponseTariffNumber(ModelAccess access, ModelInputConverter inConverter,
            RestPhoenixEEMResponseTariffNumber resultgetTn21, String path) throws IOException {
            resultgetTn21.setContext(inConverter.toString(access.get(path + "context", -1)));
            resultgetTn21.setId(inConverter.toString(access.get(path + "id", -1)));
            resultgetTn21.setTimestamp(inConverter.toString(access.get(path + "timestamp", -1)));
            resultgetTn21.setName(inConverter.toString(access.get(path + "name", -1)));
            resultgetTn21.setValue(inConverter.toObject(access.get(path + "value", -1)));
            resultgetTn21.setDescription(inConverter.toString(access.get(path + "description", -1)));
        }

        @Override
        public RestPhoenixEEMMixed to(RESTItem source) throws IOException {
            ModelAccess access = getModelAccess();
            final ModelInputConverter inConverter = access.getInputConverter();
            final ModelOutputConverter outConverter = access.getOutputConverter();
            final String path = pathSupplier == null ? "" : pathSupplier.get();
            RestPhoenixEEMMixed result = new RestPhoenixEEMMixedImpl();
            RestPhoenixEEMResponseTariffNumber resultgetTn10 = new iip.datatypes.RestPhoenixEEMResponseTariffNumberImpl(
                );
            result.setTn1(resultgetTn10);
            access = access.stepInto("tn1");
            access = access.stepInto(path + "tn1");
            toRestPhoenixEEMResponseTariffNumber(access, inConverter, resultgetTn10, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseTariffNumber resultgetTn21 = new iip.datatypes.RestPhoenixEEMResponseTariffNumberImpl(
                );
            result.setTn2(resultgetTn21);
            access = access.stepInto("tn2");
            access = access.stepInto(path + "tn2");
            toRestPhoenixEEMResponseTariffNumber(access, inConverter, resultgetTn21, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseMeasurementSingle resultgetF2 = new iip.datatypes.
                RestPhoenixEEMResponseMeasurementSingleImpl();
            result.setF(resultgetF2);
            access = access.stepInto("f");
            access = access.stepInto(path + "f");
            toRestPhoenixEEMResponseMeasurementSingle(access, inConverter, resultgetF2, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseMeasurementSingle resultgetU13 = new iip.datatypes.
                RestPhoenixEEMResponseMeasurementSingleImpl();
            result.setU1(resultgetU13);
            access = access.stepInto("U1");
            access = access.stepInto(path + "U1");
            toRestPhoenixEEMResponseMeasurementSingle(access, inConverter, resultgetU13, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseMeasurementSingle resultgetU24 = new iip.datatypes.
                RestPhoenixEEMResponseMeasurementSingleImpl();
            result.setU2(resultgetU24);
            access = access.stepInto("U2");
            access = access.stepInto(path + "U2");
            toRestPhoenixEEMResponseMeasurementSingle(access, inConverter, resultgetU24, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseMeasurementSingle resultgetU35 = new iip.datatypes.
                RestPhoenixEEMResponseMeasurementSingleImpl();
            result.setU3(resultgetU35);
            access = access.stepInto("U3");
            access = access.stepInto(path + "U3");
            toRestPhoenixEEMResponseMeasurementSingle(access, inConverter, resultgetU35, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseMeasurementSet resultgetAll6 = new iip.datatypes.
                RestPhoenixEEMResponseMeasurementSetImpl();
            result.setAll(resultgetAll6);
            access = access.stepInto("all");
            access = access.stepInto(path + "all");
            toRestPhoenixEEMResponseMeasurementSet(access, inConverter, resultgetAll6, path);
            access = access.stepOut();
            access = access.stepOut();
            RestPhoenixEEMResponseInformation resultgetInformation7 = new iip.datatypes.
                RestPhoenixEEMResponseInformationImpl();
            result.setInformation(resultgetInformation7);
            access = access.stepInto("information");
            access = access.stepInto(path + "information");
            toRestPhoenixEEMResponseInformation(access, inConverter, resultgetInformation7, path);
            access = access.stepOut();
            access = access.stepOut();
            return result;
        }

        @Override
        public void initializeModelAccess() throws IOException {
            ModelAccess access = getModelAccess();
            access.useNotifications(true);
        }

        @Override
        public Class<? extends RESTItem> getSourceType() {
            return RESTItem.class;
        }

        @Override
        public Class<? extends RestPhoenixEEMMixed> getTargetType() {
            return RestPhoenixEEMMixed.class;
        }

    }

    private class ConnectorReceptionCallback implements ReceptionCallback<RestPhoenixEEMMixed> {

        {
            // initialize Transport if needed
            Starter.getSetup();
        }

        @Override
        public void received(RestPhoenixEEMMixed data) {
            MetricsProvider.increaseCounterBy(serviceSent, 1.0);
            Transport.send(c -> c.asyncSend("data_myRestConnEEMMixed_RestPhoenixEEMMixed_myRestApp" + appInstId, data),
                "myRestConnEEMMixed", "receiveRestPhoenixEEMMixed_RestReceiver-in-0");
        }

        @Override
        public Class<RestPhoenixEEMMixed> getType() {
            return RestPhoenixEEMMixed.class;
        }

    }

}
