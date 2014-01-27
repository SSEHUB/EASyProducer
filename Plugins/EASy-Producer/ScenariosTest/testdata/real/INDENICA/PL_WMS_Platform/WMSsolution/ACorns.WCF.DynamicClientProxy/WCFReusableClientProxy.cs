using System;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.ComponentModel;

namespace ACorns.WCF.DynamicClientProxy
{
	/// <summary>
	/// Class that can be used with PolicyInjection. Dynamically generated classes will inherit from this class.
	/// </summary>
	[EditorBrowsable(EditorBrowsableState.Never)]
	public abstract class WCFReusableClientProxy<T> : IClientBase
		where T : class
	{
		protected T cachedProxy;
		private readonly string configName;
		protected volatile bool manuallyClosed;

		private static readonly Type _instanceType;

		static WCFReusableClientProxy()
		{
			_instanceType = WCFClientProxy<T>.GetInstanceType();
		}

		protected WCFReusableClientProxy(string configName)
		{
			this.configName = configName;
		}

		/// <summary>
		/// Called to retrieve a cached instance of the proxy.
		/// </summary>
		protected T Proxy
		{
			get
			{
				AssureProxy();
				return cachedProxy;
			}
		}

		protected string ConfigName
		{
			get { return configName; }
		}

		/// <summary>
		/// Close the proxy because it was fauled.
		/// </summary>
		protected void CloseProxyBecauseOfException()
		{
			if (cachedProxy != null)
			{
				ICommunicationObject wcfProxy = cachedProxy as ICommunicationObject;
				try
				{
					if (wcfProxy != null)
					{
						if (wcfProxy.State != CommunicationState.Faulted)
						{
							wcfProxy.Close();
						}
						else
						{
							wcfProxy.Abort();
						}
					}
				}
				catch (CommunicationException)
				{
					if (wcfProxy != null) wcfProxy.Abort();
				}
				catch (TimeoutException)
				{
					if (wcfProxy != null) wcfProxy.Abort();
				}
				catch
				{
					if (wcfProxy != null) wcfProxy.Abort();
					throw;
				}
				finally
				{
					cachedProxy = null;
				}
			}
		}

		/// <summary>
		/// Create a new proxy if there is none already in use.
		/// If the previous proxy was faulted, it will be nulled and a new proxy is created
		/// </summary>
		protected void AssureProxy()
		{
			if (manuallyClosed)
			{
				throw new ObjectDisposedException("This proxy was already closed.");
			}
			if (cachedProxy == null)
			{
				cachedProxy = CreateProxyInstance();

				if (ProxyCreated != null)
				{
					ProxyCreated(this);
				}
			}
		}

		protected virtual T CreateProxyInstance()
		{
			T instance = (T) Activator.CreateInstance(_instanceType, new object[] {configName});
			return instance;
		}

		#region IClientBase Members

		public event ProxyCreatedHandler ProxyCreated;

		public virtual ClientCredentials ClientCredentials
		{
			get { return (Proxy as ClientBase<T>).ClientCredentials; }
		}

		public virtual ServiceEndpoint CurrentEndpoint
		{
			get
			{
				if (manuallyClosed)
					return null;
				else
				{
					if (cachedProxy == null)
						return null;
					else
						return (cachedProxy as ClientBase<T>).Endpoint;
				}
			}
		}

		public virtual ServiceEndpoint Endpoint
		{
			get
			{
				if (manuallyClosed)
					return null;
				else
					return (Proxy as ClientBase<T>).Endpoint;
			}
		}

		public virtual IClientChannel InnerChannel
		{
			get { return (Proxy as ClientBase<T>).InnerChannel; }
		}

		public virtual CommunicationState State
		{
			get
			{
				if (cachedProxy != null)
				{
					return (cachedProxy as ICommunicationObject).State;
				}
				else
				{
					return CommunicationState.Closed;
				}
			}
		}

		public virtual void Abort()
		{
			try
			{
				if (cachedProxy != null)
				{
					(cachedProxy as ICommunicationObject).Abort();
				}
			}
			finally
			{
				CloseProxyBecauseOfException();
			}
		}

		public virtual void Close()
		{
			try
			{
				if (cachedProxy != null)
				{
					(cachedProxy as ICommunicationObject).Close();
				}
				manuallyClosed = true;
			}
			finally
			{
				CloseProxyBecauseOfException();
			}
		}

		public virtual void Open()
		{
			try
			{
				(Proxy as ICommunicationObject).Open();
				return;
			}
			catch
			{
				CloseProxyBecauseOfException();
				throw;
			}
		}

		public object Tag { get; set; }

		#endregion

		public void Dispose()
		{
			try
			{
				CloseProxyBecauseOfException();
			}
			catch
			{
				// no throw 
			}
		}
	}
}