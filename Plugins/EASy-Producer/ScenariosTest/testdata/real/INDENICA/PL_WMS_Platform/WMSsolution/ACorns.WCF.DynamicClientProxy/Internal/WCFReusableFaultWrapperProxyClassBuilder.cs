using System;
using System.Reflection;
using System.Reflection.Emit;
using System.ServiceModel;

namespace ACorns.WCF.DynamicClientProxy.Internal
{
	/// <summary>
	/// Builds a proxy via the ChannelFactory and not via a ClientBase
	/// </summary>
	/// <typeparam name="TInterface"></typeparam>
	internal class WCFReusableFaultWrapperChannelProxyClassBuilder<TInterface>
		: WCFReusableFaultWrapperProxyClassBuilder<TInterface> where TInterface : class
	{
		public WCFReusableFaultWrapperChannelProxyClassBuilder()
			: base(typeof (WCFReusableFaultWrapperChannelProxy<TInterface>))
		{
		}
	}

    /// <summary>
    /// Builds a proxy via the DuplexChannelFactory and not via a ClientBase
    /// </summary>
    /// <typeparam name="TInterface"></typeparam>
    internal class WCFReusableFaultWrapperDuplexChannelProxyClassBuilder<TInterface>
        : WCFReusableFaultWrapperProxyClassBuilder<TInterface> where TInterface : class
    {
        public WCFReusableFaultWrapperDuplexChannelProxyClassBuilder()
            : base(typeof(WCFReusableFaultWrapperDuplexChannelProxy<TInterface>))
        {
        }
    }

	/// <summary>
	/// Builds a class inheriting from WCFAbstractClientProxy.cs that will wrap a WCF Proxy
	/// and automatically rebuild the proxy if the channel is faulted.
	/// The class will also unwrap any FaultException and throw the original Exception
	/// </summary>
	internal class WCFReusableFaultWrapperProxyClassBuilder<TInterface> : WCFReusableProxyClassBuilder<TInterface> where TInterface : class
	{
		public WCFReusableFaultWrapperProxyClassBuilder()
			: base(typeof (WCFReusableFaultWrapperClientProxy<TInterface>))
		{
		}

		public WCFReusableFaultWrapperProxyClassBuilder(Type proxyType)
			: base(proxyType)
		{
		}

		/// <summary>
		/// Generate the contents of the method. This will generate:
		/// ...
		/// try
		///	{
		///		return Proxy.MethodName(arg1, arg2);
		///	}
		///	catch( FaultException< MyFaultException > fex )
		///	{
		///		CloseProxyBecauseOfException();
		/// 
		///		HandleFault<MyFaultException>( fex );
		/// 
		///		throw;
		///	}
		/// ...
		/// </summary>
		/// <param name="method"></param>
		/// <param name="parameterTypes"></param>
		/// <param name="iLGenerator"></param>
		protected override void GenerateMethodImpl(MethodInfo method, Type[] parameterTypes, ILGenerator iLGenerator)
		{
			bool hasReturn = !IsVoidMethod(method);
			if (hasReturn)
			{
				// declare a variable to contain the return type
				// string returnValue;
				iLGenerator.DeclareLocal(method.ReturnType);
			}

			// try {
			Label tryLabel = iLGenerator.BeginExceptionBlock();
			{
				// this
				iLGenerator.Emit(OpCodes.Ldarg_0);

				// Get the details Property of the ClientBase
				MethodInfo proxyProperty = GetMethodFromBaseClass("get_Proxy");
				// Get the channel: "base.Channel<TInterface>."
				iLGenerator.EmitCall(OpCodes.Call, proxyProperty, null);

				// Prepare the parameters for the call
				ParameterInfo[] parameters = method.GetParameters();
				for (int index = 0; index < parameterTypes.Length; index++)
				{
					iLGenerator.Emit(OpCodes.Ldarg, (((short) index) + 1));
				}

				// Call the Proxy via the interface
				iLGenerator.Emit(OpCodes.Callvirt, method);

				if (hasReturn)
				{
					// returnValue = result of the function call
					iLGenerator.Emit(OpCodes.Stloc_0);
				}
			}

			// we need one catch for each [FaultContract(typeof(T))] defined on the interface!
			object[] objAttributes = method.GetCustomAttributes(typeof (FaultContractAttribute), true);

			int localVariableIndex = 0;

			foreach (FaultContractAttribute faultAttribute in objAttributes)
			{
				// catch {
				if (typeof (Exception).IsAssignableFrom(faultAttribute.DetailType))
				{
					// we have a valid exception!		
					// [FaultContract(typeof(MyCustomException))] becomes
					// FaultException<MyCustomException>
					Type faultExceptionOfDetail = typeof (FaultException<>).MakeGenericType(faultAttribute.DetailType);

					localVariableIndex = iLGenerator.DeclareLocal(faultExceptionOfDetail).LocalIndex;

					// catch ( FaultException<MyCustomException> fex )
					iLGenerator.BeginCatchBlock(faultExceptionOfDetail);
					iLGenerator.Emit(OpCodes.Stloc_S, localVariableIndex); // get the exception from the stack

					// this
					iLGenerator.Emit(OpCodes.Ldarg_0);

					//call base.CloseProxyBecauseOfException();
					MethodInfo closeProxyMethod = GetMethodFromBaseClass("CloseProxyBecauseOfException");
					iLGenerator.Emit(OpCodes.Call, closeProxyMethod);

					// this
					iLGenerator.Emit(OpCodes.Ldarg_0);

					// load fex
					iLGenerator.Emit(OpCodes.Ldloc_S, localVariableIndex);

					// Call "HandleFault<MyCustomException>( fex )
					MethodInfo handleExceptionMethod = GetMethodFromBaseClass("HandleFault");
					MethodInfo typedHandleExceptionMethod = handleExceptionMethod.MakeGenericMethod(faultAttribute.DetailType);
					iLGenerator.Emit(OpCodes.Callvirt, typedHandleExceptionMethod);

					// throw;
					iLGenerator.Emit(OpCodes.Rethrow);
					// }
				}
			}

			GenerateStandardCatch(iLGenerator);

			iLGenerator.EndExceptionBlock();

			if (hasReturn)
			{
				// return returnValue;
				iLGenerator.Emit(OpCodes.Ldloc_0);
			}

			// Thanks, all done
			iLGenerator.Emit(OpCodes.Ret);
		}
	}
}