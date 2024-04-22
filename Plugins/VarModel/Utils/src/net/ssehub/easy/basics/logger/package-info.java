/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
/**
 * The core logging mechanism for the variability model (and indirectly for EASy). This
 * logger abstracts specific logging mechanisms in order to provide a unified frontend, in
 * particular to support UI-based and headless operations.
 * <br>
 * <b>Usage:</b>
 * <pre>
 *   EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(My.class, "myBundle");
 *   logger.warn("a warning ;)");
 * </pre>
 */
package net.ssehub.easy.basics.logger;
