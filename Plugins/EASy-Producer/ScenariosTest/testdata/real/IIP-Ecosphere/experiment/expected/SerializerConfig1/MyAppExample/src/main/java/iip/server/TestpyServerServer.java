package iip.server;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import de.iip_ecosphere.platform.services.environment.PythonAsyncProcessService;
import de.iip_ecosphere.platform.services.environment.ServiceState;
import de.iip_ecosphere.platform.services.environment.Starter;
import de.iip_ecosphere.platform.services.environment.YamlArtifact;
import de.iip_ecosphere.platform.services.environment.YamlServer;
import de.iip_ecosphere.platform.support.Server;
import de.iip_ecosphere.platform.support.resources.ResourceLoader;
import de.iip_ecosphere.platform.transport.serialization.TypeTranslators;

import org.slf4j.LoggerFactory;

/**
 * Service-based server 'test-pyServer'.
 * Generated by: EASy-Producer.
 */
public class TestpyServerServer implements Server {

    private PythonAsyncProcessService service;
    
    /**
     * Creates a server instance.
     * 
     * @throws ExecutionException if the server cannot be created
     */
    public TestpyServerServer() throws ExecutionException {
        InputStream desc = ResourceLoader.getResourceAsStream(TestpyServerServer.class, "deployment.yml");
        YamlArtifact artifact = YamlArtifact.readFromYamlSafe(desc);
        YamlServer yServer = artifact.getServer("test-pyServer");
        if (null == yServer) {
            throw new ExecutionException("No such server known: test-pyServer", null);
        }
        service = new PythonAsyncProcessService(yServer.toService());
        service.addParameterConfigurer(c -> {});
        Runtime.getRuntime()
            .addShutdownHook(new Thread(() -> { stop(true); }));
    }
    
    @Override
    public Server start() {
        Starter.mapService(service);
        try {
            service.setState(ServiceState.STARTING);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass())
                .error("Starting server service test-pyServer: {}", e.getMessage());
        }
        return this;
    }
    
    @Override
    public void stop(boolean dispose) {
        try {
            service.setState(ServiceState.STOPPING);
        } catch (ExecutionException e) {
            LoggerFactory.getLogger(getClass())
                .error("Stopping server service test-pyServer: {}", e.getMessage());
        }
    }

}