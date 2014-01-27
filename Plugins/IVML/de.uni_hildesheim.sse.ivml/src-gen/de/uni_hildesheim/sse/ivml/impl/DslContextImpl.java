/**
 * <copyright>
 * </copyright>
 *

 */
package de.uni_hildesheim.sse.ivml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.uni_hildesheim.sse.ivml.DslContext;
import de.uni_hildesheim.sse.ivml.IvmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dsl Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl#getStop <em>Stop</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl#getEscape <em>Escape</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link de.uni_hildesheim.sse.ivml.impl.DslContextImpl#getDsl <em>Dsl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DslContextImpl extends MinimalEObjectImpl.Container implements DslContext
{
  /**
   * The default value of the '{@link #getStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStop()
   * @generated
   * @ordered
   */
  protected static final String STOP_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStop() <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStop()
   * @generated
   * @ordered
   */
  protected String stop = STOP_EDEFAULT;

  /**
   * The default value of the '{@link #getEscape() <em>Escape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscape()
   * @generated
   * @ordered
   */
  protected static final String ESCAPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEscape() <em>Escape</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscape()
   * @generated
   * @ordered
   */
  protected String escape = ESCAPE_EDEFAULT;

  /**
   * The default value of the '{@link #getCommand() <em>Command</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected static final String COMMAND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCommand() <em>Command</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCommand()
   * @generated
   * @ordered
   */
  protected String command = COMMAND_EDEFAULT;

  /**
   * The default value of the '{@link #getDsl() <em>Dsl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDsl()
   * @generated
   * @ordered
   */
  protected static final String DSL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDsl() <em>Dsl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDsl()
   * @generated
   * @ordered
   */
  protected String dsl = DSL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DslContextImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return IvmlPackage.Literals.DSL_CONTEXT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStop()
  {
    return stop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStop(String newStop)
  {
    String oldStop = stop;
    stop = newStop;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.DSL_CONTEXT__STOP, oldStop, stop));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEscape()
  {
    return escape;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscape(String newEscape)
  {
    String oldEscape = escape;
    escape = newEscape;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.DSL_CONTEXT__ESCAPE, oldEscape, escape));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCommand()
  {
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCommand(String newCommand)
  {
    String oldCommand = command;
    command = newCommand;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.DSL_CONTEXT__COMMAND, oldCommand, command));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDsl()
  {
    return dsl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDsl(String newDsl)
  {
    String oldDsl = dsl;
    dsl = newDsl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, IvmlPackage.DSL_CONTEXT__DSL, oldDsl, dsl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case IvmlPackage.DSL_CONTEXT__STOP:
        return getStop();
      case IvmlPackage.DSL_CONTEXT__ESCAPE:
        return getEscape();
      case IvmlPackage.DSL_CONTEXT__COMMAND:
        return getCommand();
      case IvmlPackage.DSL_CONTEXT__DSL:
        return getDsl();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case IvmlPackage.DSL_CONTEXT__STOP:
        setStop((String)newValue);
        return;
      case IvmlPackage.DSL_CONTEXT__ESCAPE:
        setEscape((String)newValue);
        return;
      case IvmlPackage.DSL_CONTEXT__COMMAND:
        setCommand((String)newValue);
        return;
      case IvmlPackage.DSL_CONTEXT__DSL:
        setDsl((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case IvmlPackage.DSL_CONTEXT__STOP:
        setStop(STOP_EDEFAULT);
        return;
      case IvmlPackage.DSL_CONTEXT__ESCAPE:
        setEscape(ESCAPE_EDEFAULT);
        return;
      case IvmlPackage.DSL_CONTEXT__COMMAND:
        setCommand(COMMAND_EDEFAULT);
        return;
      case IvmlPackage.DSL_CONTEXT__DSL:
        setDsl(DSL_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case IvmlPackage.DSL_CONTEXT__STOP:
        return STOP_EDEFAULT == null ? stop != null : !STOP_EDEFAULT.equals(stop);
      case IvmlPackage.DSL_CONTEXT__ESCAPE:
        return ESCAPE_EDEFAULT == null ? escape != null : !ESCAPE_EDEFAULT.equals(escape);
      case IvmlPackage.DSL_CONTEXT__COMMAND:
        return COMMAND_EDEFAULT == null ? command != null : !COMMAND_EDEFAULT.equals(command);
      case IvmlPackage.DSL_CONTEXT__DSL:
        return DSL_EDEFAULT == null ? dsl != null : !DSL_EDEFAULT.equals(dsl);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (stop: ");
    result.append(stop);
    result.append(", escape: ");
    result.append(escape);
    result.append(", command: ");
    result.append(command);
    result.append(", dsl: ");
    result.append(dsl);
    result.append(')');
    return result.toString();
  }

} //DslContextImpl
