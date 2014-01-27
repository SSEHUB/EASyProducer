using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace ACorns.WCF.DynamicClientProxy
{
	public delegate void ProxyCreatedHandler(IClientBase proxy);

	/// <summary>
	/// Interface to expose the inner ClientBase properties hidden by the Proxy
	/// </summary>
	public interface IClientBase : IDisposable
	{
		/// <summary>
		/// Fired when a new proxy is created.
		/// In here you can initialize the Credentials and EndPoints.
		/// </summary>
		event ProxyCreatedHandler ProxyCreated;

		/// <summary>
		/// Gets the client credentials used to call an operation.
		/// Returns a System.ServiceModel.Description.ClientCredentials that represents
		/// the proof of identity presented by the client.
		/// </summary>
		ClientCredentials ClientCredentials { get; }

		/// <summary>
		/// Gets the target endpoint for the service to which the WCF client can connect.
		/// </summary>
		ServiceEndpoint Endpoint { get; }


		/// <summary>
		/// Gets the target endpoint for the service to which the WCF client can connect.
		/// This will return the real one. Will not try to create a new one.
		/// </summary>
		ServiceEndpoint CurrentEndpoint { get; }

		/// <summary>
		/// Gets the underlying System.ServiceModel.IClientChannel implementation.
		/// </summary>
		/// <value>The client channel for the WCF client object.</value>
		IClientChannel InnerChannel { get; }

		/// <summary>
		/// Gets the current state of the System.ServiceModel.ClientBase<TChannel> object.
		/// </summary>
		CommunicationState State { get; }

		/// <summary>
		/// Causes the System.ServiceModel.ClientBase<TChannel> object to transition
		//     immediately from its current state into the closed state.
		/// </summary>
		void Abort();

		/// <summary>
		/// Causes the System.ServiceModel.ClientBase<TChannel> object to transition
		//     from its current state into the closed state.
		/// </summary>
		void Close();

		/// <summary>
		/// Causes the System.ServiceModel.ClientBase<TChannel> object to transition
		//     from the created state into the opened state.
		/// </summary>
		void Open();

		/// <summary>
		/// Use this to store a user defined tag on the proxy.
		/// </summary>
		object Tag { get; set; }
	}
}