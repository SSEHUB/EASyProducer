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

import au.com.jcloud.lxd.bean.LxdServerCredential;
import au.com.jcloud.lxd.service.ILinuxCliService;
import au.com.jcloud.lxd.service.ILxdApiService;
import au.com.jcloud.lxd.service.ILxdService;
import au.com.jcloud.lxd.service.impl.LinuxCliServiceImpl;
import au.com.jcloud.lxd.service.impl.LxdApiServiceImpl;
import au.com.jcloud.lxd.service.impl.LxdServiceImpl;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;

/**
 * Abstract reusable LXC instantiator, basic implementation for the individual
 * commands.
 * 
 * @author Luca Schulz
 */
public abstract class AbstractLxcInstantiator extends AbstractFileInstantiator {

    protected static final boolean FAIL_ON_ERROR = Boolean.valueOf(System.getProperty("easy.lxc.failOnError", "true"));

    private static final String LXC_HOST = System.getProperty("easy.lxc.host", "localhost:8443");

    /**
     * Returns the LXC client instance to use API.
     * 
     * @return the LXC client instance
     */
    protected static ILxdService createClient() {
        // Setting the lxc client

        ILxdService lxcClient = new LxdServiceImpl();
        ILxdApiService lxdApiService = new LxdApiServiceImpl();
        ILinuxCliService linuxCliService = new LinuxCliServiceImpl();
        lxdApiService.setLinuxCliService(linuxCliService);
        lxcClient.setLxdApiService(lxdApiService);

        LxdServerCredential credential = new LxdServerCredential(LXC_HOST);
        lxcClient.setLxdServerCredential(credential);

        return lxcClient;
    }

    /**
     * Returns the client instance to execute a Linux-Command.
     * 
     * @return the LXC client instance
     */
    protected static ILinuxCliService createCmdClient() {

        ILinuxCliService lxcClient = new LinuxCliServiceImpl();

        return lxcClient;
    }

}
