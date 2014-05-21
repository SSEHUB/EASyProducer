using System;

namespace ACorns.WCF.DynamicClientProxy.Internal
{
	internal interface ITypeBuilder
	{
		Type GenerateType(string className);
	}
}