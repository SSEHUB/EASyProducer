package de.uni_hildesheim.sse.easy.adaptation.events;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the very basic event handling interface of an adaptation manager. The main
 * aim is to provide methods to register {@link IAdaptationEvent adaptation event types} and
 * {@link IEnactionCommand enactment command types} that are application domain specific and
 * that must be known to rt-VIL before system startup. Use {@link #getInstance()} for that purpose.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractAdaptationManager {
   
    private static AbstractAdaptationManager instance = new InitialAdaptationManager();

    /**
     * Defines the initial adaptation manager that collects the initial registrations (so that they
     * are not lost) but does not perform any adaptation. This manager allows the transferral
     * of the registered events and commands to the actual manager provided by 
     * {@link #setInstance(AbstractAdaptationManager)}.
     * 
     * @author Holger Eichelberger
     */
    private static class InitialAdaptationManager extends AbstractAdaptationManager {

        private List<Class<? extends IAdaptationEvent>> events;
        private List<Class<? extends IEnactionCommand>> commands;
        private List<Class<? extends IAdaptationCriterion>> criteria;
        
        @Override
        public void handleAdaptationEvent(IAdaptationEvent event) {
            // do nothing
        }

        @Override
        public void registerAdaptationEvent(Class<? extends IAdaptationEvent> eventClass) {
            if (null == events) {
                events = new ArrayList<Class<? extends IAdaptationEvent>>();
            }
            events.add(eventClass);
        }

        @Override
        public void registerEnactmentCommand(Class<? extends IEnactionCommand> eventClass) {
            if (null == commands) {
                commands = new ArrayList<Class<? extends IEnactionCommand>>();
            }
            commands.add(eventClass);
        }

        @Override
        public void registerAdaptationCriterion(Class<? extends IAdaptationCriterion> criterionClass) {
            if (null == criteria) {
                criteria = new ArrayList<Class<? extends IAdaptationCriterion>>();
            }
            criteria.add(criterionClass);
        }

        /**
         * Transfers the collected events and commands to the specified adaptation manager. The assumption is
         * that the receiving adaptation manager will do the final registration.
         * 
         * @param manager the receiving adaptation manager
         */
        private void transferTo(AbstractAdaptationManager manager) {
            if (null != events) {
                for (int e = 0, n = events.size(); e < n; e++) {
                    manager.registerAdaptationEvent(events.get(e));
                }
            }
            if (null != commands) {
                for (int e = 0, n = commands.size(); e < n; e++) {
                    manager.registerEnactmentCommand(commands.get(e));
                }
            }
        }

    }
    
    /**
     * Sets the adaptation manager instance. This shall be called by a complete adaptation implementation 
     * upon startup (this protected).
     * 
     * @param manager the manager instance (ignored if <b>null</b>, has only an effect if {@link #instance} is 
     *   not <b>null</b>
     */
    protected static void setInstance(AbstractAdaptationManager manager) {
        if (instance instanceof InitialAdaptationManager && null != manager) {
            ((InitialAdaptationManager) instance).transferTo(manager);
            instance = manager;
        }
    }

    /**
     * Returns the actual adaptation manager instance.
     * 
     * @return the actual adaptation manager instance
     */
    public static AbstractAdaptationManager getInstance() {
        return instance;
    }
    
    /**
     * Handles an adaptation event, i.e., causes an evaluation of the actual adaptation behavior specification and 
     * may ultimately cause an adaptation.
     * 
     * @param event the adaptation event
     */
    public abstract void handleAdaptationEvent(IAdaptationEvent event);
    
    /**
     * Registers an adaptation event type.
     * 
     * @param eventClass the event class
     */
    public abstract void registerAdaptationEvent(Class<? extends IAdaptationEvent> eventClass);

    /**
     * Registers an enactment command type.
     * 
     * @param commandClass the enactment command type
     */
    public abstract void registerEnactmentCommand(Class<? extends IEnactionCommand> commandClass);

    /**
     * Registers an adaptation criterion type.
     * 
     * @param criterionClass the adaptation criterion type
     */
    public abstract void registerAdaptationCriterion(Class<? extends IAdaptationCriterion> criterionClass);

}
