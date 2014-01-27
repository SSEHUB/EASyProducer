using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Spring.Objects.Factory.Xml;

namespace Easy
{
    

          [NamespaceParser(
            Namespace = "http://projects.sse.uni-hildesheim.de/easy/",
            SchemaLocationAssemblyHint = typeof(EasyNamespaceParser),
            SchemaLocation = "/Easy/EasySpringExtension.xsd"
            )
        ]
        public class EasyNamespaceParser : NamespaceParserSupport
        {
            public override void Init()
            {
                RegisterObjectDefinitionParser("varprop", new EasyVarPropParser());
            }
        }
}
