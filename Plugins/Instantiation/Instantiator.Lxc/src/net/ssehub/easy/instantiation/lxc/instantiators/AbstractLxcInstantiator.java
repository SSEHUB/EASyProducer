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

import java.io.File;

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
    private static String baseDirectory;

    /**
     * Returns the LXC client instance to use API.
     * 
     * @return the LXC client instance
     */
    protected static ILxdService createClient() {
        // Setting the lxc client

        setLxcProperties();
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
        setLxcProperties();
        ILinuxCliService lxcClient = new LinuxCliServiceImpl();
        return lxcClient;
    }

    /**
     * Defines the LXC base directory also used for authentication/as parent folder for certificates.
     * 
     * @param directory the base directory. If given, used for authentication. If empty or <b>null</b> 
     * resets authentication/logon.
     */
    protected static void setBaseDirectory(String directory) {
        baseDirectory = directory;
    }

    /**
     * Sets the LXC system properties depending on {@link #baseDirectory}.
     */
    protected static void setLxcProperties() {
        if (null != baseDirectory && baseDirectory.length() > 0) {
            System.setProperty("snap_cert", baseDirectory + File.separator + "snap/lxd/common/config/client.crt");
            System.setProperty("snap_key", baseDirectory + File.separator + "snap/lxd/common/config/client.key");
        } else {
            System.setProperty("snap_cert", "");
            System.setProperty("snap_key", "");
        }
    }

}
