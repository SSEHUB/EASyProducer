/*
 * Copyright 2009-2022 University of Hildesheim, Software Systems Engineering
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

import java.io.File;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.github.dockerjava.api.command.BuildImageCmd;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.model.AuthConfigurations;
import com.github.dockerjava.api.model.BuildResponseItem;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * Builds Docker images.
 * 
 * @author Monika Staciwa
 */
@Instantiator("dockerBuildImage")
public class DockerBuildImage extends AbstractDockerInstantiator {

    private static final boolean BUILD_WITH_CACHE = Boolean.valueOf(
        System.getProperty("easy.docker.buildImageWithCache", "true"));
    
    // checkstyle: stop exception type check
    
    /**
     * Executes a specific Dockerfile and builds an image.
     * 
     * @param baseDirectory the base directory for the build context
     * @param dockerFile the docker file for the container to create
     * @param name name of the image with following schema (repository:tag)
     * @return the container id, may be <b>null</b>/undefined
     * @throws VilException in case of artifact / parameter problems
     */
    public static String dockerBuildImage(Path baseDirectory, Path dockerFile, String name) throws VilException {
        HashSet<String> tags = new HashSet<String>();
        tags.add(name);
        
        IInstantiatorTracer tracer = TracerFactory.getInstance().createInstantiatorTracerImpl();
        try {
            long start = System.currentTimeMillis();
            File dockerfile = dockerFile.getAbsolutePath();
            BuildImageCmd cmd = createClient().buildImageCmd()
                .withDockerfile(dockerfile)
                .withPull(true)
                .withNoCache(!BUILD_WITH_CACHE)  // false - building multiply images from one build context not possible
                .withBaseDirectory(baseDirectory.getAbsolutePath())
                .withTags(tags);
            AuthConfigurations aCfgs = DockerLogin.getAuthConfigs();
            if (null != aCfgs) {
                cmd.withBuildAuthConfigs(aCfgs);
            }

            tracer.traceMessage("Building docker image " + name + ". Please wait...");
            final String taskDescription = "Docker build";
            TracerFactory.ensureTasks(taskDescription);
            final AtomicInteger count = new AtomicInteger(0);
            final AtomicReference<Throwable> cbThrowable = new AtomicReference<>();
            String imageId = cmd.exec(new BuildImageResultCallback() {
                
                @Override
                public void onNext(BuildResponseItem item) {
                    super.onNext(item);
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), "docker").info(
                        "Docker response " + taskDescription + ": " + item.getId() + " " + item.getStatus());
                    int cnt = count.incrementAndGet(); // preliminary, unknown number of subtasks
                    TracerFactory.progressSubTask(cnt, cnt + 1, taskDescription);
                }
                
                @Override
                public void onError(Throwable th) {
                    cbThrowable.set(th);
                }

            }).awaitImageId();
            TracerFactory.closeTasks(taskDescription);
            handleThrowable(cbThrowable.get(), tracer, getTask(name));
            tracer.traceMessage(getTask(name) + " completed " + imageId + " in " 
                + (System.currentTimeMillis() - start) + " ms");
            return imageId;        
        } catch (Exception e) {
            handleThrowable(e, tracer, getTask(name));
            return null;
        }
    }

    /**
     * Returns the task at hands.
     * 
     * @param name the name of the task
     * @return the composed name
     */
    private static String getTask(String name) {
        return "Building docker image " + name;
    }
    
    // checkstyle: resume exception type check
  
}