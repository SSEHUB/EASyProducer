using System;
using System.Collections.Generic;
using System.Text;
using System.Web;
using System.ServiceModel;

namespace ACorns.WCF.DynamicClientProxy.Pool
{
	/// <summary>
	/// A connection pool that will pickup all created dynamic proxies and will release them
	/// once the HttpConnection is finished or the WCF operation is finished.
	/// </summary>
	public class ProxyConnectionPool : IDisposable
	{
		private const string HttpContextPoolKey = "Acorns.WCF.ProxyConnectionPool";

		private readonly Dictionary<IClientBase, IClientBase> _openProxies = new Dictionary<IClientBase, IClientBase>();
		private readonly Dictionary<Type, IClientBase> _openProxiesByType = new Dictionary<Type, IClientBase>();

		private static bool _enableConnectionPool;

		private ProxyConnectionPool()
		{
		}

		// there can be a single connection pool per call
		// where a call is either a HttpContext request or a WCF Operation
		public static void Register<T>(T connection)
		{
			if (EnableConnectionPool)
			{
				IClientBase clientBase = connection as IClientBase;
				if (clientBase == null)
				{
					throw new InvalidOperationException("Connection is not of type IClientBase. Are you sure this connection was created by this dynamic proxy?");
				}
				clientBase.ProxyCreated += new ProxyCreatedHandler(clientBase_ProxyCreated);
				
				Current.InternalRegister(clientBase);
				Current._openProxiesByType[typeof(T)] = clientBase;
			}
		}
		internal static T RequestFromPool<T>()
			where T : class
		{
			if (EnableConnectionPool)
			{
				IClientBase instance;
				if (Current._openProxiesByType.TryGetValue(typeof(T), out instance))
				{
					return (T) instance;
				}
			}
			return null;
		}
		static void clientBase_ProxyCreated(IClientBase proxy)
		{	// we only register in the connection pool when the proxy is created 
			// so the original instance can be moved safely accross threads
			ProxyConnectionPool.Current.InternalRegister(proxy);
		}

		private void InternalRegister(IClientBase clientBase)
		{
			_openProxies[clientBase] = clientBase;
		}
		
		private void DisposeAllConnections()
		{
			foreach(IClientBase client in _openProxies.Values)
			{
				try
				{
					client.Close();
				}
				catch (Exception)
				{					
				}
			}
			_openProxies.Clear();
			if ( _proxyConnectionPool == this )
				_proxyConnectionPool = null;
		}



		public static ProxyConnectionPool Current
		{
			get
			{
				if (HttpContext.Current != null)
				{
					// we are in a web call, use the HttpContext to pool the proxies
					ProxyConnectionPool current = HttpContext.Current.Items[HttpContextPoolKey] as ProxyConnectionPool;
					if (current == null)
					{
						current = new ProxyConnectionPool();
						HttpContext.Current.Items[HttpContextPoolKey] = current;
					}
					return current;
				}
				else
				{
					// we are in a WCF OperationContext
					ProxyConnectionPoolExtension extension = ProxyConnectionPoolExtension.Current;
					if (extension != null)
					{
						return extension.Pool;
					}
					// fall back to a thread static
					if (_proxyConnectionPool == null)
					{
						_proxyConnectionPool = new ProxyConnectionPool();
					}
					return _proxyConnectionPool;
				}
			}
		}

		[ThreadStaticAttribute] private static ProxyConnectionPool _proxyConnectionPool;

		/// <summary>
		/// Whenever the connection pool is automatically enabled
		/// </summary>
		public static bool EnableConnectionPool
		{
			get { return _enableConnectionPool; }
			set { _enableConnectionPool = value; }
		}

		#region WCF Extension
		private class ProxyConnectionPoolExtension : IExtension<OperationContext>
		{
			private readonly ProxyConnectionPool _pool = new ProxyConnectionPool();

			public static ProxyConnectionPoolExtension Current
			{
				get
				{
					if (OperationContext.Current == null)
						return null;

					ProxyConnectionPoolExtension extension = OperationContext.Current.Extensions.Find<ProxyConnectionPoolExtension>();
					if (extension == null)
					{
						extension = new ProxyConnectionPoolExtension();
						OperationContext.Current.Extensions.Add(extension);
					}
					return extension;
				}
			}

			#region IExtension<long> Members

			public void Attach(OperationContext owner)
			{
				
			}

			public void Detach(OperationContext owner)
			{
				
			}

			#endregion

			public ProxyConnectionPool Pool
			{
				get { return _pool; }
			}
		}
		#endregion

		#region IDisposable Members
		public void Dispose()
		{
			Dispose(true);
			GC.SuppressFinalize(this);
		}
		~ProxyConnectionPool()
		{
			Dispose(false);
		}
		private void Dispose(bool disposing)
		{
			if ( disposing && EnableConnectionPool )
			{
				DisposeAllConnections();
			}
		}
		#endregion
	}
}
