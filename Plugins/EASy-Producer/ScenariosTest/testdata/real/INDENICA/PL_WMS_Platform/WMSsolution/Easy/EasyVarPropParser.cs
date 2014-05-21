using System;
using System.Text.RegularExpressions;
using System.Xml;
using Spring.Objects.Factory.Support;
using Spring.Objects.Factory.Xml;
using Spring.Util;


namespace Easy
{
    class EasyVarPropParser : AbstractSimpleObjectDefinitionParser
    {

        protected override Type GetObjectType(XmlElement element)
        {
            return typeof(Object);
        }

        protected override void DoParse(XmlElement element, ObjectDefinitionBuilder builder)
        {
            // all we want is ignoring the tag
        }

        protected override bool ShouldGenerateIdAsFallback
        {
            get { return false; }
        }
    }
}