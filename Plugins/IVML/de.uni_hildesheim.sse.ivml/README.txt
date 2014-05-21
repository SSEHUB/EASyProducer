Hints:
 - Import: Provide referenced grammars via change in configuration and as referenced 
   projects (also in classpath).
 - Start generated grammar via Eclipse Run Configuration using
   -Xms40m -Xmx512m -XX:PermSize=128M -XX:MaxPermSize=256M
 - DSL currently implemented in XTEXT-style  
 

public class IvmlProposalProvider extends AbstractIvmlProposalProvider {

	/*
	public void complete_VersionedId(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal(  
			      "", "ID - name of project",  
			      null //getBlackImage()
				  , context));  	
	}*/

}