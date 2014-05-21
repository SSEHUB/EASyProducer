/**
 * The core logging mechanism for the variability model (and indirectly for EASy). This
 * logger abstracts specific logging mechanisms in order to provide a unified frontend, in
 * particular to support UI-based and headless operations.
 * <br/>
 * <b>Usage:</b>
 * <pre>
 *   EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(My.class, "myBundle");
 *   logger.warn("a warning ;)");
 * </pre>
 */
package de.uni_hildesheim.sse.utils.logger;
