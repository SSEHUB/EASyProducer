using System;
using System.Collections.Generic;

namespace ACorns.WCF.DynamicClientProxy.Internal
{
	/// <summary>
	/// Builder and cache of proxies
	/// </summary>
	internal static class ProxyBuilder
	{
		// Generated Types Dictionary
		private static readonly IDictionary<string, Type> generatedTypes = new Dictionary<string, Type>();
		private static readonly object generateLock = new object();

		public static Type BuildType<TInterface, TBuilder>()
			where TInterface : class
			where TBuilder : ITypeBuilder, new()
		{
			string typeName = GetTypeName<TInterface>(typeof (TBuilder).Name.Replace("ClassBuilder", ""));

			Type type = TryGetType(typeName);
			if (type != null)
				return type;

			lock (generateLock)
			{
				type = TryGetType(typeName);
				if (type != null)
					return type;

				TBuilder builder = new TBuilder();

				type = builder.GenerateType(typeName);

				lock (generatedTypes)
				{
					generatedTypes[typeName] = type;
				}
				return type;
			}
		}


		private static Type TryGetType(string className)
		{
			lock (generatedTypes)
			{
				Type generatedType;
				if (generatedTypes.TryGetValue(className, out generatedType))
					return generatedType;
			}
			return null;
		}

		private static string GetTypeName<TType>(string classNameSuffix)
		{
			Type iType = typeof (TType);
			if (iType.Name.StartsWith("I") && char.IsUpper(iType.Name, 1))
			{
				return iType.Name.Substring(1) + classNameSuffix;
			}
			else
			{
				return iType.Name + classNameSuffix;
			}
		}
	}
}