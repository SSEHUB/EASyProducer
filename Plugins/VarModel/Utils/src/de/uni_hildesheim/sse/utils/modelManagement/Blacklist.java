package de.uni_hildesheim.sse.utils.modelManagement;

import java.util.ArrayList;
import java.util.Hashtable;

import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction.Operator;


/**
 * Contains all version restrictions from given model name.
 * 
 * @param <M> the specific type of model
 * 
 * @author Patrik J
 */
class Blacklist <M extends IModel> {
    private static boolean usesTemporaryRestrictions = true;
    private String modelName;
    private ArrayList<VersionRestriction> restrictions;
    private Hashtable<ModelInfo<M>, ArrayList<VersionRestriction>> temporaryRestrictions;
    private boolean blockAll = false; // if there is a conflict with no version
    
    /**
     * constructor.
     * @param modelName to check.
     */
    public Blacklist(String modelName) {
        this.modelName = modelName;
        restrictions = new ArrayList<VersionRestriction>();
        temporaryRestrictions = new Hashtable<ModelInfo<M>, ArrayList<VersionRestriction>>();
    }
    
    /**
     * clears temporary-restriction-list.
     */
    public void clearTemporaryRestrictions() {
        if (null != temporaryRestrictions && temporaryRestrictions.size() > 0) {
            temporaryRestrictions.clear();
        }
    }
    
    /**
     * Returns the model name.
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }
    
    /**
     * validates a version against all restrictions.
     * @param version to validate.
     * @param modelInfo parent model info of the model import.
     * @return whether it's a valid model info or not.
     */
    public boolean isValid(Version version, ModelInfo<M> modelInfo) {
        boolean success = true;
        if (!blockAll) {
            if (restrictions.size() > 0) {
                for (VersionRestriction vr : restrictions) {
                    if (!validate(version, vr)) {
                        success = false;
                        break;
                    }
                }
            }
            if (usesTemporaryRestrictions && hashsetContainsModelInfo(modelInfo)
                    && temporaryRestrictions.size() > 0) {
                for (VersionRestriction vr : temporaryRestrictions.get(modelInfo)) {
                    if (!validate(version, vr)) {
                        success = false;
                        break;
                    }
                }
            }
        }
        
        return success && !blockAll;
    }
    /**
     * returns true, if the model info is in the hashset.
     * @param modelInfo to look for.
     * @return success.
     */
    private boolean hashsetContainsModelInfo(ModelInfo<M> modelInfo) {
        boolean found = false;
        for (ModelInfo<M> pInfo : temporaryRestrictions.keySet()) {
            if (Version.equals(pInfo.getVersion(), modelInfo.getVersion())
                    && pInfo.getName().compareTo(modelInfo.getName()) == 0
                    && pInfo.getLocation().compareTo(modelInfo.getLocation()) == 0) {
                found = true;
                break;
            }
        }
        return found;
    }
    
    /**
     * validates a version against all permanent restrictions.
     * @param version to validate.
     * @return whether it's a valid model info or not.
     */
    public boolean isValidPermanentOnly(Version version) {
        boolean success = true;
        if (!blockAll) {
            if (restrictions.size() > 0) {
                for (VersionRestriction vr : restrictions) {
                    if (!validate(version, vr)) {
                        success = false;
                        break;
                    }
                }
            }
        }
        
        return success && !blockAll;
    }
    
    /**
     * validates a single version against a given restriction.
     * @param version to check.
     * @param versionRestriction to validate against.
     * @return whether it's valid against given restriction.
     */
    private boolean validate(Version version, VersionRestriction versionRestriction) {
        boolean isValid = true;
        if (null == version && null == versionRestriction.getVersion()) { // if both equal null => true
            isValid = true;
        } else if (null == version ^ null == versionRestriction.getVersion()) { // if only one equals null
            isValid = false;
        } else { // both are not equal null
            if (!blockAll) {
                switch(versionRestriction.getOperator()) {
                case EQUALS:
                    isValid = version.compareTo(versionRestriction.getVersion()) != 0;
                    break;
                case GREATER:
                    isValid = version.compareTo(versionRestriction.getVersion()) <= 0;
                    break;
                case GREATER_EQUALS:
                    isValid = version.compareTo(versionRestriction.getVersion()) < 0;
                    break;
                case LESS:
                    isValid = version.compareTo(versionRestriction.getVersion()) >= 0;
                    break;
                case LESS_EQUALS:
                    isValid = version.compareTo(versionRestriction.getVersion()) > 0;
                    break;
                case UNEQUALS:
                    isValid = version.compareTo(versionRestriction.getVersion()) == 0;
                    break;
                default:
                    break;
                }
            } else {
                isValid = false;
            }
        }
        return isValid;
    }

    /**
     * adds restriction to list.
     * @param restriction restriction to check against.
     * @param isConflict whether it's an import or conflict.
     * @param modelInfo parent model info of the model import.
     * 
     */
    public void addRestriction(VersionRestriction restriction, boolean isConflict, ModelInfo<M> modelInfo) {
        if (restriction.getVersion() == null && isConflict) {
            blockAll = true;
        }
        if (!blockAll) {
            if (restriction.getName().compareTo(modelName) == 0) {
                if (isConflict) {
                    restrictions.add(restriction);
                } else { // invert the operator
                    Operator operator = Operator.EQUALS;
                    switch (restriction.getOperator()) {
                    case EQUALS:
                        operator = Operator.UNEQUALS;
                        break;
                    case GREATER:
                        operator = Operator.LESS_EQUALS;
                        break;
                    case GREATER_EQUALS:
                        operator = Operator.LESS;
                        break;
                    case LESS:
                        operator = Operator.GREATER_EQUALS;
                        break;
                    case LESS_EQUALS:
                        operator = Operator.GREATER;
                        break;
                    case UNEQUALS:
                        operator = Operator.EQUALS;
                        break;
                    default:
                        break;
                    }
                    if (usesTemporaryRestrictions && !hashsetContainsModelInfo(modelInfo)) {
                        temporaryRestrictions.put(modelInfo, new ArrayList<VersionRestriction>());
                        temporaryRestrictions.get(modelInfo).add(
                                new VersionRestriction(restriction.getName(), operator, restriction
                                .getVersion()));
                    } else if (usesTemporaryRestrictions) {
                        temporaryRestrictions.get(modelInfo).add(
                                new VersionRestriction(restriction.getName(), operator, restriction
                                .getVersion()));
                    } else {
                        restrictions.add(new VersionRestriction(restriction.getName(), operator, restriction
                                .getVersion()));
                    }
                }
            }
        }
    }
}
