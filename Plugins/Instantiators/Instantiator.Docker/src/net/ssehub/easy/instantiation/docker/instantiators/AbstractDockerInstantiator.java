/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.docker.instantiators;

import org.apache.commons.lang.SystemUtils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.transport.SSLConfig;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;

/**
 * Abstract reusable docker instantiator, basic implementation for the individual commands.
 *  
 * @author Monika Staciwa
 */
public abstract class AbstractDockerInstantiator extends AbstractFileInstantiator {

    protected static final boolean FAIL_ON_ERROR = Boolean.valueOf(
        System.getProperty("easy.docker.failOnError", "true"));
    // pretend there is docker, return success or the given container ID
    protected static final String SKIP_ID = System.getProperty("easy.docker.skip");

    // http://localhost:2375 causes unsupported schema problems on Windows although explained in internet
    private static final String DOCKER_HOST = System.getProperty("easy.docker.host", 
        SystemUtils.IS_OS_WINDOWS ? "unix:///var/run/docker.sock" : "unix:///var/run/docker.sock");

    /**
     * Returns the docker client instance.
     * 
     * @return the docker client instance
     */
    protected static DockerClient createClient() {
        // Setting the docker client
        DockerClientConfig standardConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .withDockerHost(DOCKER_HOST).build(); 
        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
            .dockerHost(standardConfig.getDockerHost())
            .sslConfig((SSLConfig) standardConfig.getSSLConfig())
            .build();
        return DockerClientImpl.getInstance(standardConfig, httpClient);        
    }

    /**
     * Handles a throwable depending on {@link #FAIL_ON_ERROR}.
     * 
     * @param th the throwable (may be <b>null</b> for none)
     * @param tracer the tracer to inform
     * @param task a task description to include into the message
     * @throws VilException if not {@link #FAIL_ON_ERROR} and {@code th} is given, {@code th} is turned into 
     *     a {@link VilException} 
     */
    static void handleThrowable(Throwable th, IInstantiatorTracer tracer, String task) throws VilException {
        if (null != th && FAIL_ON_ERROR) {
            tracer.traceMessage(task + "failed: " + th.getMessage());
            throw new VilException(th.getMessage(), VilException.ID_RUNTIME);
        }
    }
    
    /**
     * Shall we skip?
     * 
     * @return {@code true} for skip, {@code false} for run Docker
     */
    static boolean skip() {
        return SKIP_ID != null && SKIP_ID.length() > 0;
    }

}
