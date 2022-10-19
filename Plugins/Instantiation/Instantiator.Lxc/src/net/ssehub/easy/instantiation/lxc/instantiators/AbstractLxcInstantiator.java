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
package net.ssehub.easy.instantiation.lxc.instantiators;

import org.apache.commons.lang.SystemUtils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.transport.SSLConfig;

import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;

/**
 * Abstract reusable LXC instantiator, basic implementation for the individual commands.
 *  
 * @author Monika Staciwa
 */
public abstract class AbstractLxcInstantiator extends AbstractFileInstantiator {

    protected static final boolean FAIL_ON_ERROR = Boolean.valueOf(
        System.getProperty("easy.lxc.failOnError", "true"));

    private static final String LXC_HOST = System.getProperty("easy.lxc.host", 
        SystemUtils.IS_OS_WINDOWS ? "http://localhost:2375" : "unix:///var/run/docker.sock");

    /**
     * Returns the docker client instance.
     * 
     * @return the docker client instance
     */
    protected static DockerClient createClient() {
        // Setting the docker client
        DockerClientConfig standardConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .withDockerHost(LXC_HOST).build(); 
        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
            .dockerHost(standardConfig.getDockerHost())
            .sslConfig((SSLConfig) standardConfig.getSSLConfig())
            .build();
        return DockerClientImpl.getInstance(standardConfig, httpClient);        
    }

}
