using System;
using System.ComponentModel;
using System.ServiceModel;

namespace ACorns.WCF.DynamicClientProxy
{
	/// <summary>
	/// Class that can be used with PolicyInjection. Dynamically generated classes will inherit from this class.
	/// This class will also take care to unwrap any FaultException and extract and throw the original exception.
	/// </summary>
	[EditorBrowsable(EditorBrowsableState.Never)] 
	public abstract class WCFReusableFaultWrapperClientProxy<T> : WCFReusableClientProxy<T> where T : class
	{
		protected WCFReusableFaultWrapperClientProxy(string configName)
			: base(configName)
		{
		}

		protected virtual void HandleFault<TFaultDetail>(FaultException<TFaultDetail> fault)
		{
			Exception ex = fault.Detail as Exception;
			if (ex != null)
			{
				throw ex;
			}
			// else do nothing, the calee will throw the original fault
		}
	}
}