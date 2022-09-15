package de.uni_hildesheim.sse.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.services.IvmlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalIvmlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'project'", "'{'", "'}'", "';'", "'enum'", "','", "'='", "'abstract'", "'compound'", "'refines'", "'assign'", "'('", "')'", "'to'", "'typedef'", "'with'", "'const'", "'Integer'", "'Real'", "'Boolean'", "'String'", "'Constraint'", "'Any'", "'::'", "'.'", "'true'", "'false'", "'self'", "'null'", "'setOf'", "'sequenceOf'", "'refTo'", "'attribute'", "'annotate'", "'freeze'", "'but'", "'|'", "'eval'", "'interface'", "'export'", "'import'", "'insert'", "'*'", "'conflicts'", "'version'", "'def'", "'static'", "'let'", "'in'", "'implies'", "'iff'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'->'", "'['", "']'", "'refBy'", "'if'", "'then'", "'else'", "'endif'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=6;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=4;
    public static final int RULE_EXPONENT=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalIvmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIvmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIvmlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIvml.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private IvmlGrammarAccess grammarAccess;
     	
        public InternalIvmlParser(TokenStream input, IvmlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "VariabilityUnit";	
       	}
       	
       	@Override
       	protected IvmlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleVariabilityUnit"
    // InternalIvml.g:73:1: entryRuleVariabilityUnit returns [EObject current=null] : iv_ruleVariabilityUnit= ruleVariabilityUnit EOF ;
    public final EObject entryRuleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariabilityUnit = null;


        try {
            // InternalIvml.g:74:2: (iv_ruleVariabilityUnit= ruleVariabilityUnit EOF )
            // InternalIvml.g:75:2: iv_ruleVariabilityUnit= ruleVariabilityUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariabilityUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariabilityUnit=ruleVariabilityUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariabilityUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariabilityUnit"


    // $ANTLR start "ruleVariabilityUnit"
    // InternalIvml.g:82:1: ruleVariabilityUnit returns [EObject current=null] : ( () ( (lv_projects_1_0= ruleProject ) )* ) ;
    public final EObject ruleVariabilityUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_projects_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:85:28: ( ( () ( (lv_projects_1_0= ruleProject ) )* ) )
            // InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            {
            // InternalIvml.g:86:1: ( () ( (lv_projects_1_0= ruleProject ) )* )
            // InternalIvml.g:86:2: () ( (lv_projects_1_0= ruleProject ) )*
            {
            // InternalIvml.g:86:2: ()
            // InternalIvml.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariabilityUnitAccess().getVariabilityUnitAction_0(),
                          current);
                  
            }

            }

            // InternalIvml.g:95:2: ( (lv_projects_1_0= ruleProject ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    {
            	    // InternalIvml.g:96:1: (lv_projects_1_0= ruleProject )
            	    // InternalIvml.g:97:3: lv_projects_1_0= ruleProject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariabilityUnitAccess().getProjectsProjectParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_projects_1_0=ruleProject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariabilityUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"projects",
            	              		lv_projects_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Project");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariabilityUnit"


    // $ANTLR start "entryRuleProject"
    // InternalIvml.g:121:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalIvml.g:122:2: (iv_ruleProject= ruleProject EOF )
            // InternalIvml.g:123:2: iv_ruleProject= ruleProject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProject; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalIvml.g:130:1: ruleProject returns [EObject current=null] : (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_3_0 = null;

        EObject lv_imports_4_0 = null;

        EObject lv_conflicts_5_0 = null;

        EObject lv_interfaces_6_0 = null;

        EObject lv_contents_7_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:133:28: ( (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? ) )
            // InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            {
            // InternalIvml.g:134:1: (otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )? )
            // InternalIvml.g:134:3: otherlv_0= 'project' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_version_3_0= ruleVersionStmt ) )? ( (lv_imports_4_0= ruleImportStmt ) )* ( (lv_conflicts_5_0= ruleConflictStmt ) )* ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )* ( (lv_contents_7_0= ruleProjectContents ) ) otherlv_8= '}' (otherlv_9= ';' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProjectAccess().getProjectKeyword_0());
                  
            }
            // InternalIvml.g:138:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:139:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:140:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProjectRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:160:1: ( (lv_version_3_0= ruleVersionStmt ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==57) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_VERSION) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==16) ) {
                        int LA2_4 = input.LA(4);

                        if ( (synpred2_InternalIvml()) ) {
                            alt2=1;
                        }
                    }
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    {
                    // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
                    // InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_version_3_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getProjectRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:178:3: ( (lv_imports_4_0= ruleImportStmt ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=53 && LA3_0<=54)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    {
            	    // InternalIvml.g:179:1: (lv_imports_4_0= ruleImportStmt )
            	    // InternalIvml.g:180:3: lv_imports_4_0= ruleImportStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getImportsImportStmtParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_imports_4_0=ruleImportStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ImportStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalIvml.g:196:3: ( (lv_conflicts_5_0= ruleConflictStmt ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==56) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    {
            	    // InternalIvml.g:197:1: (lv_conflicts_5_0= ruleConflictStmt )
            	    // InternalIvml.g:198:3: lv_conflicts_5_0= ruleConflictStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getConflictsConflictStmtParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_conflicts_5_0=ruleConflictStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"conflicts",
            	              		lv_conflicts_5_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ConflictStmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalIvml.g:214:3: ( (lv_interfaces_6_0= ruleInterfaceDeclaration ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==51) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    {
            	    // InternalIvml.g:215:1: (lv_interfaces_6_0= ruleInterfaceDeclaration )
            	    // InternalIvml.g:216:3: lv_interfaces_6_0= ruleInterfaceDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectAccess().getInterfacesInterfaceDeclarationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_interfaces_6_0=ruleInterfaceDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"interfaces",
            	              		lv_interfaces_6_0, 
            	              		"de.uni_hildesheim.sse.Ivml.InterfaceDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalIvml.g:232:3: ( (lv_contents_7_0= ruleProjectContents ) )
            // InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            {
            // InternalIvml.g:233:1: (lv_contents_7_0= ruleProjectContents )
            // InternalIvml.g:234:3: lv_contents_7_0= ruleProjectContents
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProjectAccess().getContentsProjectContentsParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_9);
            lv_contents_7_0=ruleProjectContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProjectRule());
              	        }
                     		set(
                     			current, 
                     			"contents",
                      		lv_contents_7_0, 
                      		"de.uni_hildesheim.sse.Ivml.ProjectContents");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // InternalIvml.g:254:1: (otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalIvml.g:254:3: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getProjectAccess().getSemicolonKeyword_9());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleProjectContents"
    // InternalIvml.g:266:1: entryRuleProjectContents returns [EObject current=null] : iv_ruleProjectContents= ruleProjectContents EOF ;
    public final EObject entryRuleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectContents = null;


        try {
            // InternalIvml.g:267:2: (iv_ruleProjectContents= ruleProjectContents EOF )
            // InternalIvml.g:268:2: iv_ruleProjectContents= ruleProjectContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProjectContentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProjectContents=ruleProjectContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProjectContents; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectContents"


    // $ANTLR start "ruleProjectContents"
    // InternalIvml.g:275:1: ruleProjectContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) ;
    public final EObject ruleProjectContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;

        EObject lv_elements_7_0 = null;

        EObject lv_elements_8_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:278:28: ( ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* ) )
            // InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            {
            // InternalIvml.g:279:1: ( () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )* )
            // InternalIvml.g:279:2: () ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            {
            // InternalIvml.g:279:2: ()
            // InternalIvml.g:280:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getProjectContentsAccess().getProjectContentsAction_0(),
                          current);
                  
            }

            }

            // InternalIvml.g:288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*
            loop7:
            do {
                int alt7=9;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    {
            	    // InternalIvml.g:288:3: ( (lv_elements_1_0= ruleTypedef ) )
            	    // InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    {
            	    // InternalIvml.g:289:1: (lv_elements_1_0= ruleTypedef )
            	    // InternalIvml.g:290:3: lv_elements_1_0= ruleTypedef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsTypedefParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_1_0=ruleTypedef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Typedef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
            	    // InternalIvml.g:309:3: lv_elements_2_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsVariableDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_2_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    {
            	    // InternalIvml.g:326:6: ( (lv_elements_3_0= ruleFreeze ) )
            	    // InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    {
            	    // InternalIvml.g:327:1: (lv_elements_3_0= ruleFreeze )
            	    // InternalIvml.g:328:3: lv_elements_3_0= ruleFreeze
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsFreezeParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_3_0=ruleFreeze();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Freeze");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:345:6: ( (lv_elements_4_0= ruleEval ) )
            	    // InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    {
            	    // InternalIvml.g:346:1: (lv_elements_4_0= ruleEval )
            	    // InternalIvml.g:347:3: lv_elements_4_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsEvalParserRuleCall_1_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_4_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
            	    // InternalIvml.g:366:3: lv_elements_5_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsExpressionStatementParserRuleCall_1_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_5_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_5_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    {
            	    // InternalIvml.g:383:6: ( (lv_elements_6_0= ruleAnnotateTo ) )
            	    // InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    {
            	    // InternalIvml.g:384:1: (lv_elements_6_0= ruleAnnotateTo )
            	    // InternalIvml.g:385:3: lv_elements_6_0= ruleAnnotateTo
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAnnotateToParserRuleCall_1_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_6_0=ruleAnnotateTo();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_6_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AnnotateTo");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    {
            	    // InternalIvml.g:402:6: ( (lv_elements_7_0= ruleOpDefStatement ) )
            	    // InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    {
            	    // InternalIvml.g:403:1: (lv_elements_7_0= ruleOpDefStatement )
            	    // InternalIvml.g:404:3: lv_elements_7_0= ruleOpDefStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsOpDefStatementParserRuleCall_1_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_7_0=ruleOpDefStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_7_0, 
            	              		"de.uni_hildesheim.sse.Ivml.OpDefStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:421:6: ( (lv_elements_8_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:422:1: (lv_elements_8_0= ruleAttrAssignment )
            	    // InternalIvml.g:423:3: lv_elements_8_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsAttrAssignmentParserRuleCall_1_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_elements_8_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProjectContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectContents"


    // $ANTLR start "entryRuleTypedef"
    // InternalIvml.g:447:1: entryRuleTypedef returns [EObject current=null] : iv_ruleTypedef= ruleTypedef EOF ;
    public final EObject entryRuleTypedef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedef = null;


        try {
            // InternalIvml.g:448:2: (iv_ruleTypedef= ruleTypedef EOF )
            // InternalIvml.g:449:2: iv_ruleTypedef= ruleTypedef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedef=ruleTypedef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedef"


    // $ANTLR start "ruleTypedef"
    // InternalIvml.g:456:1: ruleTypedef returns [EObject current=null] : ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) ;
    public final EObject ruleTypedef() throws RecognitionException {
        EObject current = null;

        EObject lv_tEnum_0_0 = null;

        EObject lv_tCompound_1_0 = null;

        EObject lv_tMapping_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:459:28: ( ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) ) )
            // InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            {
            // InternalIvml.g:460:1: ( ( (lv_tEnum_0_0= ruleTypedefEnum ) ) | ( (lv_tCompound_1_0= ruleTypedefCompound ) ) | ( (lv_tMapping_2_0= ruleTypedefMapping ) ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 20:
            case 21:
                {
                alt8=2;
                }
                break;
            case 27:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    {
                    // InternalIvml.g:460:2: ( (lv_tEnum_0_0= ruleTypedefEnum ) )
                    // InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    {
                    // InternalIvml.g:461:1: (lv_tEnum_0_0= ruleTypedefEnum )
                    // InternalIvml.g:462:3: lv_tEnum_0_0= ruleTypedefEnum
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTEnumTypedefEnumParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_tEnum_0_0=ruleTypedefEnum();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tEnum",
                              		lv_tEnum_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.TypedefEnum");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    {
                    // InternalIvml.g:479:6: ( (lv_tCompound_1_0= ruleTypedefCompound ) )
                    // InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    {
                    // InternalIvml.g:480:1: (lv_tCompound_1_0= ruleTypedefCompound )
                    // InternalIvml.g:481:3: lv_tCompound_1_0= ruleTypedefCompound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTCompoundTypedefCompoundParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_tCompound_1_0=ruleTypedefCompound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tCompound",
                              		lv_tCompound_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.TypedefCompound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    {
                    // InternalIvml.g:498:6: ( (lv_tMapping_2_0= ruleTypedefMapping ) )
                    // InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    {
                    // InternalIvml.g:499:1: (lv_tMapping_2_0= ruleTypedefMapping )
                    // InternalIvml.g:500:3: lv_tMapping_2_0= ruleTypedefMapping
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefAccess().getTMappingTypedefMappingParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_tMapping_2_0=ruleTypedefMapping();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefRule());
                      	        }
                             		set(
                             			current, 
                             			"tMapping",
                              		lv_tMapping_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.TypedefMapping");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedef"


    // $ANTLR start "entryRuleTypedefEnum"
    // InternalIvml.g:524:1: entryRuleTypedefEnum returns [EObject current=null] : iv_ruleTypedefEnum= ruleTypedefEnum EOF ;
    public final EObject entryRuleTypedefEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnum = null;


        try {
            // InternalIvml.g:525:2: (iv_ruleTypedefEnum= ruleTypedefEnum EOF )
            // InternalIvml.g:526:2: iv_ruleTypedefEnum= ruleTypedefEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefEnum=ruleTypedefEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefEnum"


    // $ANTLR start "ruleTypedefEnum"
    // InternalIvml.g:533:1: ruleTypedefEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) ;
    public final EObject ruleTypedefEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;

        EObject lv_constraint_7_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:536:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' ) )
            // InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            {
            // InternalIvml.g:537:1: (otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';' )
            // InternalIvml.g:537:3: otherlv_0= 'enum' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_literals_3_0= ruleTypedefEnumLiteral ) ) (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )* otherlv_6= '}' ( (lv_constraint_7_0= ruleTypedefConstraint ) )? otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefEnumAccess().getEnumKeyword_0());
                  
            }
            // InternalIvml.g:541:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:542:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:543:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypedefEnumAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:563:1: ( (lv_literals_3_0= ruleTypedefEnumLiteral ) )
            // InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            {
            // InternalIvml.g:564:1: (lv_literals_3_0= ruleTypedefEnumLiteral )
            // InternalIvml.g:565:3: lv_literals_3_0= ruleTypedefEnumLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_12);
            lv_literals_3_0=ruleTypedefEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
              	        }
                     		add(
                     			current, 
                     			"literals",
                      		lv_literals_3_0, 
                      		"de.uni_hildesheim.sse.Ivml.TypedefEnumLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:581:2: (otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIvml.g:581:4: otherlv_4= ',' ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getTypedefEnumAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // InternalIvml.g:585:1: ( (lv_literals_5_0= ruleTypedefEnumLiteral ) )
            	    // InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    {
            	    // InternalIvml.g:586:1: (lv_literals_5_0= ruleTypedefEnumLiteral )
            	    // InternalIvml.g:587:3: lv_literals_5_0= ruleTypedefEnumLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getLiteralsTypedefEnumLiteralParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_literals_5_0=ruleTypedefEnumLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"literals",
            	              		lv_literals_5_0, 
            	              		"de.uni_hildesheim.sse.Ivml.TypedefEnumLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTypedefEnumAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // InternalIvml.g:607:1: ( (lv_constraint_7_0= ruleTypedefConstraint ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:608:1: (lv_constraint_7_0= ruleTypedefConstraint )
                    // InternalIvml.g:609:3: lv_constraint_7_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumAccess().getConstraintTypedefConstraintParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_constraint_7_0=ruleTypedefConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefEnumRule());
                      	        }
                             		set(
                             			current, 
                             			"constraint",
                              		lv_constraint_7_0, 
                              		"de.uni_hildesheim.sse.Ivml.TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getTypedefEnumAccess().getSemicolonKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefEnum"


    // $ANTLR start "entryRuleTypedefEnumLiteral"
    // InternalIvml.g:637:1: entryRuleTypedefEnumLiteral returns [EObject current=null] : iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF ;
    public final EObject entryRuleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefEnumLiteral = null;


        try {
            // InternalIvml.g:638:2: (iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF )
            // InternalIvml.g:639:2: iv_ruleTypedefEnumLiteral= ruleTypedefEnumLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefEnumLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefEnumLiteral=ruleTypedefEnumLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefEnumLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefEnumLiteral"


    // $ANTLR start "ruleTypedefEnumLiteral"
    // InternalIvml.g:646:1: ruleTypedefEnumLiteral returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) ;
    public final EObject ruleTypedefEnumLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:649:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? ) )
            // InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            {
            // InternalIvml.g:650:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )? )
            // InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            {
            // InternalIvml.g:650:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:651:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:652:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefEnumLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:668:2: (otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalIvml.g:668:4: otherlv_1= '=' ( (lv_value_2_0= ruleNumValue ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedefEnumLiteralAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:672:1: ( (lv_value_2_0= ruleNumValue ) )
                    // InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    {
                    // InternalIvml.g:673:1: (lv_value_2_0= ruleNumValue )
                    // InternalIvml.g:674:3: lv_value_2_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefEnumLiteralAccess().getValueNumValueParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleNumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefEnumLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.NumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefEnumLiteral"


    // $ANTLR start "entryRuleTypedefCompound"
    // InternalIvml.g:698:1: entryRuleTypedefCompound returns [EObject current=null] : iv_ruleTypedefCompound= ruleTypedefCompound EOF ;
    public final EObject entryRuleTypedefCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefCompound = null;


        try {
            // InternalIvml.g:699:2: (iv_ruleTypedefCompound= ruleTypedefCompound EOF )
            // InternalIvml.g:700:2: iv_ruleTypedefCompound= ruleTypedefCompound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefCompoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefCompound=ruleTypedefCompound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefCompound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefCompound"


    // $ANTLR start "ruleTypedefCompound"
    // InternalIvml.g:707:1: ruleTypedefCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? ) ;
    public final EObject ruleTypedefCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        AntlrDatatypeRuleToken lv_super_6_0 = null;

        EObject lv_elements_8_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_10_0 = null;

        EObject lv_elements_11_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:710:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? ) )
            // InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? )
            {
            // InternalIvml.g:711:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )? )
            // InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )? otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )* otherlv_12= '}' (otherlv_13= ';' )?
            {
            // InternalIvml.g:711:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalIvml.g:712:1: (lv_abstract_0_0= 'abstract' )
                    // InternalIvml.g:713:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,20,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_abstract_0_0, grammarAccess.getTypedefCompoundAccess().getAbstractAbstractKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypedefCompoundRule());
                      	        }
                             		setWithLastConsumed(current, "abstract", lv_abstract_0_0, "abstract");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,21,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefCompoundAccess().getCompoundKeyword_1());
                  
            }
            // InternalIvml.g:730:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:731:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:732:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_18);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:748:2: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalIvml.g:748:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )*
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedefCompoundAccess().getRefinesKeyword_3_0());
                          
                    }
                    // InternalIvml.g:752:1: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalIvml.g:753:1: (lv_super_4_0= ruleIdentifier )
                    // InternalIvml.g:754:3: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_super_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                      	        }
                             		add(
                             			current, 
                             			"super",
                              		lv_super_4_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:770:2: (otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==18) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalIvml.g:770:4: otherlv_5= ',' ( (lv_super_6_0= ruleIdentifier ) )
                    	    {
                    	    otherlv_5=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getTypedefCompoundAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // InternalIvml.g:774:1: ( (lv_super_6_0= ruleIdentifier ) )
                    	    // InternalIvml.g:775:1: (lv_super_6_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:775:1: (lv_super_6_0= ruleIdentifier )
                    	    // InternalIvml.g:776:3: lv_super_6_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getSuperIdentifierParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_19);
                    	    lv_super_6_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"super",
                    	              		lv_super_6_0, 
                    	              		"de.uni_hildesheim.sse.Ivml.Identifier");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getTypedefCompoundAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:796:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )*
            loop15:
            do {
                int alt15=5;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // InternalIvml.g:796:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:796:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:797:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:797:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    // InternalIvml.g:798:3: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_8_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:815:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:815:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:816:1: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:816:1: (lv_elements_9_0= ruleExpressionStatement )
            	    // InternalIvml.g:817:3: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_9_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_9_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:834:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:834:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:835:1: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:835:1: (lv_elements_10_0= ruleAttrAssignment )
            	    // InternalIvml.g:836:3: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsAttrAssignmentParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_10_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_10_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalIvml.g:853:6: ( (lv_elements_11_0= ruleEval ) )
            	    {
            	    // InternalIvml.g:853:6: ( (lv_elements_11_0= ruleEval ) )
            	    // InternalIvml.g:854:1: (lv_elements_11_0= ruleEval )
            	    {
            	    // InternalIvml.g:854:1: (lv_elements_11_0= ruleEval )
            	    // InternalIvml.g:855:3: lv_elements_11_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsEvalParserRuleCall_5_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_11_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypedefCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_11_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_12=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getTypedefCompoundAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // InternalIvml.g:875:1: (otherlv_13= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalIvml.g:875:3: otherlv_13= ';'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypedefCompoundAccess().getSemicolonKeyword_7());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefCompound"


    // $ANTLR start "entryRuleAttrAssignment"
    // InternalIvml.g:887:1: entryRuleAttrAssignment returns [EObject current=null] : iv_ruleAttrAssignment= ruleAttrAssignment EOF ;
    public final EObject entryRuleAttrAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignment = null;


        try {
            // InternalIvml.g:888:2: (iv_ruleAttrAssignment= ruleAttrAssignment EOF )
            // InternalIvml.g:889:2: iv_ruleAttrAssignment= ruleAttrAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttrAssignment=ruleAttrAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrAssignment"


    // $ANTLR start "ruleAttrAssignment"
    // InternalIvml.g:896:1: ruleAttrAssignment returns [EObject current=null] : (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) ;
    public final EObject ruleAttrAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_parts_2_0 = null;

        EObject lv_parts_4_0 = null;

        EObject lv_elements_8_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_10_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:899:28: ( (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? ) )
            // InternalIvml.g:900:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // InternalIvml.g:900:1: (otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )? )
            // InternalIvml.g:900:3: otherlv_0= 'assign' otherlv_1= '(' ( (lv_parts_2_0= ruleAttrAssignmentPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )* otherlv_5= ')' otherlv_6= 'to' otherlv_7= '{' ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+ otherlv_11= '}' (otherlv_12= ';' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAttrAssignmentAccess().getAssignKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:908:1: ( (lv_parts_2_0= ruleAttrAssignmentPart ) )
            // InternalIvml.g:909:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            {
            // InternalIvml.g:909:1: (lv_parts_2_0= ruleAttrAssignmentPart )
            // InternalIvml.g:910:3: lv_parts_2_0= ruleAttrAssignmentPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_22);
            lv_parts_2_0=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
              	        }
                     		add(
                     			current, 
                     			"parts",
                      		lv_parts_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.AttrAssignmentPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:926:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==18) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalIvml.g:926:4: otherlv_3= ',' ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getAttrAssignmentAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalIvml.g:930:1: ( (lv_parts_4_0= ruleAttrAssignmentPart ) )
            	    // InternalIvml.g:931:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    {
            	    // InternalIvml.g:931:1: (lv_parts_4_0= ruleAttrAssignmentPart )
            	    // InternalIvml.g:932:3: lv_parts_4_0= ruleAttrAssignmentPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getPartsAttrAssignmentPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_parts_4_0=ruleAttrAssignmentPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignmentPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAttrAssignmentAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_6=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAttrAssignmentAccess().getToKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,14,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAttrAssignmentAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // InternalIvml.g:960:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=4;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // InternalIvml.g:960:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalIvml.g:960:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
            	    // InternalIvml.g:961:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    {
            	    // InternalIvml.g:961:1: (lv_elements_8_0= ruleVariableDeclaration )
            	    // InternalIvml.g:962:3: lv_elements_8_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_8_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_8_0, 
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalIvml.g:979:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    {
            	    // InternalIvml.g:979:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
            	    // InternalIvml.g:980:1: (lv_elements_9_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:980:1: (lv_elements_9_0= ruleExpressionStatement )
            	    // InternalIvml.g:981:3: lv_elements_9_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_9_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_9_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalIvml.g:998:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    {
            	    // InternalIvml.g:998:6: ( (lv_elements_10_0= ruleAttrAssignment ) )
            	    // InternalIvml.g:999:1: (lv_elements_10_0= ruleAttrAssignment )
            	    {
            	    // InternalIvml.g:999:1: (lv_elements_10_0= ruleAttrAssignment )
            	    // InternalIvml.g:1000:3: lv_elements_10_0= ruleAttrAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsAttrAssignmentParserRuleCall_7_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_10_0=ruleAttrAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAttrAssignmentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_10_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AttrAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAttrAssignmentAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // InternalIvml.g:1020:1: (otherlv_12= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==16) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalIvml.g:1020:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getAttrAssignmentAccess().getSemicolonKeyword_9());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrAssignment"


    // $ANTLR start "entryRuleAttrAssignmentPart"
    // InternalIvml.g:1032:1: entryRuleAttrAssignmentPart returns [EObject current=null] : iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF ;
    public final EObject entryRuleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrAssignmentPart = null;


        try {
            // InternalIvml.g:1033:2: (iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF )
            // InternalIvml.g:1034:2: iv_ruleAttrAssignmentPart= ruleAttrAssignmentPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrAssignmentPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttrAssignmentPart=ruleAttrAssignmentPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrAssignmentPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrAssignmentPart"


    // $ANTLR start "ruleAttrAssignmentPart"
    // InternalIvml.g:1041:1: ruleAttrAssignmentPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) ;
    public final EObject ruleAttrAssignmentPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1044:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) ) )
            // InternalIvml.g:1045:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            {
            // InternalIvml.g:1045:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) ) )
            // InternalIvml.g:1045:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleLogicalExpression ) )
            {
            // InternalIvml.g:1045:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1046:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1046:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1047:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentPartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAttrAssignmentPartAccess().getEqualsSignKeyword_1());
                  
            }
            // InternalIvml.g:1067:1: ( (lv_value_2_0= ruleLogicalExpression ) )
            // InternalIvml.g:1068:1: (lv_value_2_0= ruleLogicalExpression )
            {
            // InternalIvml.g:1068:1: (lv_value_2_0= ruleLogicalExpression )
            // InternalIvml.g:1069:3: lv_value_2_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttrAssignmentPartAccess().getValueLogicalExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttrAssignmentPartRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrAssignmentPart"


    // $ANTLR start "entryRuleTypedefMapping"
    // InternalIvml.g:1093:1: entryRuleTypedefMapping returns [EObject current=null] : iv_ruleTypedefMapping= ruleTypedefMapping EOF ;
    public final EObject entryRuleTypedefMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefMapping = null;


        try {
            // InternalIvml.g:1094:2: (iv_ruleTypedefMapping= ruleTypedefMapping EOF )
            // InternalIvml.g:1095:2: iv_ruleTypedefMapping= ruleTypedefMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefMapping=ruleTypedefMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefMapping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefMapping"


    // $ANTLR start "ruleTypedefMapping"
    // InternalIvml.g:1102:1: ruleTypedefMapping returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) ;
    public final EObject ruleTypedefMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_newType_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_constraint_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1105:28: ( (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' ) )
            // InternalIvml.g:1106:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:1106:1: (otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';' )
            // InternalIvml.g:1106:3: otherlv_0= 'typedef' ( (lv_newType_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) ( (lv_constraint_3_0= ruleTypedefConstraint ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefMappingAccess().getTypedefKeyword_0());
                  
            }
            // InternalIvml.g:1110:1: ( (lv_newType_1_0= ruleIdentifier ) )
            // InternalIvml.g:1111:1: (lv_newType_1_0= ruleIdentifier )
            {
            // InternalIvml.g:1111:1: (lv_newType_1_0= ruleIdentifier )
            // InternalIvml.g:1112:3: lv_newType_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getNewTypeIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
            lv_newType_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
              	        }
                     		set(
                     			current, 
                     			"newType",
                      		lv_newType_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1128:2: ( (lv_type_2_0= ruleType ) )
            // InternalIvml.g:1129:1: (lv_type_2_0= ruleType )
            {
            // InternalIvml.g:1129:1: (lv_type_2_0= ruleType )
            // InternalIvml.g:1130:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1146:2: ( (lv_constraint_3_0= ruleTypedefConstraint ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalIvml.g:1147:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    {
                    // InternalIvml.g:1147:1: (lv_constraint_3_0= ruleTypedefConstraint )
                    // InternalIvml.g:1148:3: lv_constraint_3_0= ruleTypedefConstraint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedefMappingAccess().getConstraintTypedefConstraintParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_constraint_3_0=ruleTypedefConstraint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedefMappingRule());
                      	        }
                             		set(
                             			current, 
                             			"constraint",
                              		lv_constraint_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.TypedefConstraint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTypedefMappingAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefMapping"


    // $ANTLR start "entryRuleTypedefConstraint"
    // InternalIvml.g:1176:1: entryRuleTypedefConstraint returns [EObject current=null] : iv_ruleTypedefConstraint= ruleTypedefConstraint EOF ;
    public final EObject entryRuleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedefConstraint = null;


        try {
            // InternalIvml.g:1177:2: (iv_ruleTypedefConstraint= ruleTypedefConstraint EOF )
            // InternalIvml.g:1178:2: iv_ruleTypedefConstraint= ruleTypedefConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefConstraintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedefConstraint=ruleTypedefConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedefConstraint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedefConstraint"


    // $ANTLR start "ruleTypedefConstraint"
    // InternalIvml.g:1185:1: ruleTypedefConstraint returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleTypedefConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1188:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalIvml.g:1189:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalIvml.g:1189:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalIvml.g:1189:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_expressions_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypedefConstraintAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypedefConstraintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:1197:1: ( (lv_expressions_2_0= ruleExpression ) )
            // InternalIvml.g:1198:1: (lv_expressions_2_0= ruleExpression )
            {
            // InternalIvml.g:1198:1: (lv_expressions_2_0= ruleExpression )
            // InternalIvml.g:1199:3: lv_expressions_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedefConstraintAccess().getExpressionsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_expressions_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedefConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"expressions",
                      		lv_expressions_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypedefConstraintAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedefConstraint"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalIvml.g:1227:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalIvml.g:1228:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalIvml.g:1229:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalIvml.g:1236:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject lv_decls_2_0 = null;

        EObject lv_decls_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1239:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' ) )
            // InternalIvml.g:1240:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            {
            // InternalIvml.g:1240:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';' )
            // InternalIvml.g:1240:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_decls_2_0= ruleVariableDeclarationPart ) ) (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )* otherlv_5= ';'
            {
            // InternalIvml.g:1240:2: ( (lv_const_0_0= 'const' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIvml.g:1241:1: (lv_const_0_0= 'const' )
                    {
                    // InternalIvml.g:1241:1: (lv_const_0_0= 'const' )
                    // InternalIvml.g:1242:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,29,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_const_0_0, grammarAccess.getVariableDeclarationAccess().getConstConstKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      	        }
                             		setWithLastConsumed(current, "const", lv_const_0_0, "const");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:1255:3: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:1256:1: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:1256:1: (lv_type_1_0= ruleType )
            // InternalIvml.g:1257:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1273:2: ( (lv_decls_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:1274:1: (lv_decls_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:1274:1: (lv_decls_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:1275:3: lv_decls_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
            lv_decls_2_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"decls",
                      		lv_decls_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1291:2: (otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==18) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalIvml.g:1291:4: otherlv_3= ',' ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalIvml.g:1295:1: ( (lv_decls_4_0= ruleVariableDeclarationPart ) )
            	    // InternalIvml.g:1296:1: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    {
            	    // InternalIvml.g:1296:1: (lv_decls_4_0= ruleVariableDeclarationPart )
            	    // InternalIvml.g:1297:3: lv_decls_4_0= ruleVariableDeclarationPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getDeclsVariableDeclarationPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_decls_4_0=ruleVariableDeclarationPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decls",
            	              		lv_decls_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleVariableDeclarationPart"
    // InternalIvml.g:1325:1: entryRuleVariableDeclarationPart returns [EObject current=null] : iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF ;
    public final EObject entryRuleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationPart = null;


        try {
            // InternalIvml.g:1326:2: (iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF )
            // InternalIvml.g:1327:2: iv_ruleVariableDeclarationPart= ruleVariableDeclarationPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclarationPart=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclarationPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclarationPart"


    // $ANTLR start "ruleVariableDeclarationPart"
    // InternalIvml.g:1334:1: ruleVariableDeclarationPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclarationPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_default_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1337:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:1338:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:1338:1: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )? )
            // InternalIvml.g:1338:2: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:1338:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:1339:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:1339:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:1340:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationPartRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:1356:2: (otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalIvml.g:1356:4: otherlv_1= '=' ( (lv_default_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationPartAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:1360:1: ( (lv_default_2_0= ruleExpression ) )
                    // InternalIvml.g:1361:1: (lv_default_2_0= ruleExpression )
                    {
                    // InternalIvml.g:1361:1: (lv_default_2_0= ruleExpression )
                    // InternalIvml.g:1362:3: lv_default_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationPartAccess().getDefaultExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationPartRule());
                      	        }
                             		set(
                             			current, 
                             			"default",
                              		lv_default_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclarationPart"


    // $ANTLR start "entryRuleBasicType"
    // InternalIvml.g:1386:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalIvml.g:1387:2: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalIvml.g:1388:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalIvml.g:1395:1: ruleBasicType returns [EObject current=null] : ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_type_1_0=null;
        Token lv_type_2_0=null;
        Token lv_type_3_0=null;
        Token lv_type_4_0=null;
        Token lv_type_5_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1398:28: ( ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) ) )
            // InternalIvml.g:1399:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) )
            {
            // InternalIvml.g:1399:1: ( ( (lv_type_0_0= 'Integer' ) ) | ( (lv_type_1_0= 'Real' ) ) | ( (lv_type_2_0= 'Boolean' ) ) | ( (lv_type_3_0= 'String' ) ) | ( (lv_type_4_0= 'Constraint' ) ) | ( (lv_type_5_0= 'Any' ) ) )
            int alt24=6;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt24=1;
                }
                break;
            case 31:
                {
                alt24=2;
                }
                break;
            case 32:
                {
                alt24=3;
                }
                break;
            case 33:
                {
                alt24=4;
                }
                break;
            case 34:
                {
                alt24=5;
                }
                break;
            case 35:
                {
                alt24=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalIvml.g:1399:2: ( (lv_type_0_0= 'Integer' ) )
                    {
                    // InternalIvml.g:1399:2: ( (lv_type_0_0= 'Integer' ) )
                    // InternalIvml.g:1400:1: (lv_type_0_0= 'Integer' )
                    {
                    // InternalIvml.g:1400:1: (lv_type_0_0= 'Integer' )
                    // InternalIvml.g:1401:3: lv_type_0_0= 'Integer'
                    {
                    lv_type_0_0=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_0, grammarAccess.getBasicTypeAccess().getTypeIntegerKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_0, "Integer");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1415:6: ( (lv_type_1_0= 'Real' ) )
                    {
                    // InternalIvml.g:1415:6: ( (lv_type_1_0= 'Real' ) )
                    // InternalIvml.g:1416:1: (lv_type_1_0= 'Real' )
                    {
                    // InternalIvml.g:1416:1: (lv_type_1_0= 'Real' )
                    // InternalIvml.g:1417:3: lv_type_1_0= 'Real'
                    {
                    lv_type_1_0=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_1_0, grammarAccess.getBasicTypeAccess().getTypeRealKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_1_0, "Real");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:1431:6: ( (lv_type_2_0= 'Boolean' ) )
                    {
                    // InternalIvml.g:1431:6: ( (lv_type_2_0= 'Boolean' ) )
                    // InternalIvml.g:1432:1: (lv_type_2_0= 'Boolean' )
                    {
                    // InternalIvml.g:1432:1: (lv_type_2_0= 'Boolean' )
                    // InternalIvml.g:1433:3: lv_type_2_0= 'Boolean'
                    {
                    lv_type_2_0=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_2_0, grammarAccess.getBasicTypeAccess().getTypeBooleanKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_2_0, "Boolean");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:1447:6: ( (lv_type_3_0= 'String' ) )
                    {
                    // InternalIvml.g:1447:6: ( (lv_type_3_0= 'String' ) )
                    // InternalIvml.g:1448:1: (lv_type_3_0= 'String' )
                    {
                    // InternalIvml.g:1448:1: (lv_type_3_0= 'String' )
                    // InternalIvml.g:1449:3: lv_type_3_0= 'String'
                    {
                    lv_type_3_0=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_3_0, grammarAccess.getBasicTypeAccess().getTypeStringKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_3_0, "String");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalIvml.g:1463:6: ( (lv_type_4_0= 'Constraint' ) )
                    {
                    // InternalIvml.g:1463:6: ( (lv_type_4_0= 'Constraint' ) )
                    // InternalIvml.g:1464:1: (lv_type_4_0= 'Constraint' )
                    {
                    // InternalIvml.g:1464:1: (lv_type_4_0= 'Constraint' )
                    // InternalIvml.g:1465:3: lv_type_4_0= 'Constraint'
                    {
                    lv_type_4_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_4_0, grammarAccess.getBasicTypeAccess().getTypeConstraintKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_4_0, "Constraint");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalIvml.g:1479:6: ( (lv_type_5_0= 'Any' ) )
                    {
                    // InternalIvml.g:1479:6: ( (lv_type_5_0= 'Any' ) )
                    // InternalIvml.g:1480:1: (lv_type_5_0= 'Any' )
                    {
                    // InternalIvml.g:1480:1: (lv_type_5_0= 'Any' )
                    // InternalIvml.g:1481:3: lv_type_5_0= 'Any'
                    {
                    lv_type_5_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_5_0, grammarAccess.getBasicTypeAccess().getTypeAnyKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBasicTypeRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_5_0, "Any");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleType"
    // InternalIvml.g:1502:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalIvml.g:1503:2: (iv_ruleType= ruleType EOF )
            // InternalIvml.g:1504:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalIvml.g:1511:1: ruleType returns [EObject current=null] : ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        EObject lv_id_1_0 = null;

        EObject lv_derived_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1514:28: ( ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) ) )
            // InternalIvml.g:1515:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            {
            // InternalIvml.g:1515:1: ( ( (lv_type_0_0= ruleBasicType ) ) | ( (lv_id_1_0= ruleQualifiedName ) ) | ( (lv_derived_2_0= ruleDerivedType ) ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                {
                alt25=1;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 57:
                {
                alt25=2;
                }
                break;
            case 42:
            case 43:
            case 44:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalIvml.g:1515:2: ( (lv_type_0_0= ruleBasicType ) )
                    {
                    // InternalIvml.g:1515:2: ( (lv_type_0_0= ruleBasicType ) )
                    // InternalIvml.g:1516:1: (lv_type_0_0= ruleBasicType )
                    {
                    // InternalIvml.g:1516:1: (lv_type_0_0= ruleBasicType )
                    // InternalIvml.g:1517:3: lv_type_0_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getTypeBasicTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_0_0=ruleBasicType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.BasicType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1534:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1534:6: ( (lv_id_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:1535:1: (lv_id_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1535:1: (lv_id_1_0= ruleQualifiedName )
                    // InternalIvml.g:1536:3: lv_id_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getIdQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_id_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"id",
                              		lv_id_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:1553:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    {
                    // InternalIvml.g:1553:6: ( (lv_derived_2_0= ruleDerivedType ) )
                    // InternalIvml.g:1554:1: (lv_derived_2_0= ruleDerivedType )
                    {
                    // InternalIvml.g:1554:1: (lv_derived_2_0= ruleDerivedType )
                    // InternalIvml.g:1555:3: lv_derived_2_0= ruleDerivedType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getDerivedDerivedTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_derived_2_0=ruleDerivedType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"derived",
                              		lv_derived_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.DerivedType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleNumValue"
    // InternalIvml.g:1579:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalIvml.g:1580:2: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalIvml.g:1581:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumValue"


    // $ANTLR start "ruleNumValue"
    // InternalIvml.g:1588:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:1591:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalIvml.g:1592:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalIvml.g:1592:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalIvml.g:1593:1: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalIvml.g:1593:1: (lv_val_0_0= RULE_NUMBER )
            // InternalIvml.g:1594:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_val_0_0, grammarAccess.getNumValueAccess().getValNUMBERTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumValueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"val",
                      		lv_val_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.NUMBER");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumValue"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalIvml.g:1618:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalIvml.g:1619:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalIvml.g:1620:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalIvml.g:1627:1: ruleQualifiedName returns [EObject current=null] : ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qName_1_0=null;
        Token lv_qName_3_0=null;
        AntlrDatatypeRuleToken lv_qName_0_0 = null;

        AntlrDatatypeRuleToken lv_qName_2_0 = null;

        AntlrDatatypeRuleToken lv_qName_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1630:28: ( ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) ) )
            // InternalIvml.g:1631:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            {
            // InternalIvml.g:1631:1: ( ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) ) )
            // InternalIvml.g:1631:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )? ( (lv_qName_4_0= ruleIdentifier ) )
            {
            // InternalIvml.g:1631:2: ( ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )* )?
            int alt27=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (LA27_3==36) ) {
                        alt27=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (LA27_4==36) ) {
                        alt27=1;
                    }
                    }
                    break;
            }

            switch (alt27) {
                case 1 :
                    // InternalIvml.g:1631:3: ( (lv_qName_0_0= ruleIdentifier ) ) ( (lv_qName_1_0= '::' ) ) ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    {
                    // InternalIvml.g:1631:3: ( (lv_qName_0_0= ruleIdentifier ) )
                    // InternalIvml.g:1632:1: (lv_qName_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:1632:1: (lv_qName_0_0= ruleIdentifier )
                    // InternalIvml.g:1633:3: lv_qName_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_31);
                    lv_qName_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                      	        }
                             		add(
                             			current, 
                             			"qName",
                              		lv_qName_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:1649:2: ( (lv_qName_1_0= '::' ) )
                    // InternalIvml.g:1650:1: (lv_qName_1_0= '::' )
                    {
                    // InternalIvml.g:1650:1: (lv_qName_1_0= '::' )
                    // InternalIvml.g:1651:3: lv_qName_1_0= '::'
                    {
                    lv_qName_1_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_qName_1_0, grammarAccess.getQualifiedNameAccess().getQNameColonColonKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getQualifiedNameRule());
                      	        }
                             		addWithLastConsumed(current, "qName", lv_qName_1_0, "::");
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:1664:2: ( ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA26_1 = input.LA(2);

                            if ( (LA26_1==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA26_2 = input.LA(2);

                            if ( (LA26_2==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA26_3 = input.LA(2);

                            if ( (LA26_3==36) ) {
                                alt26=1;
                            }


                            }
                            break;
                        case 57:
                            {
                            int LA26_4 = input.LA(2);

                            if ( (LA26_4==36) ) {
                                alt26=1;
                            }


                            }
                            break;

                        }

                        switch (alt26) {
                    	case 1 :
                    	    // InternalIvml.g:1664:3: ( (lv_qName_2_0= ruleIdentifier ) ) ( (lv_qName_3_0= '::' ) )
                    	    {
                    	    // InternalIvml.g:1664:3: ( (lv_qName_2_0= ruleIdentifier ) )
                    	    // InternalIvml.g:1665:1: (lv_qName_2_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:1665:1: (lv_qName_2_0= ruleIdentifier )
                    	    // InternalIvml.g:1666:3: lv_qName_2_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_0_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_31);
                    	    lv_qName_2_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"qName",
                    	              		lv_qName_2_0, 
                    	              		"de.uni_hildesheim.sse.Ivml.Identifier");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // InternalIvml.g:1682:2: ( (lv_qName_3_0= '::' ) )
                    	    // InternalIvml.g:1683:1: (lv_qName_3_0= '::' )
                    	    {
                    	    // InternalIvml.g:1683:1: (lv_qName_3_0= '::' )
                    	    // InternalIvml.g:1684:3: lv_qName_3_0= '::'
                    	    {
                    	    lv_qName_3_0=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	              newLeafNode(lv_qName_3_0, grammarAccess.getQualifiedNameAccess().getQNameColonColonKeyword_0_2_1_0());
                    	          
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getQualifiedNameRule());
                    	      	        }
                    	             		addWithLastConsumed(current, "qName", lv_qName_3_0, "::");
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalIvml.g:1697:6: ( (lv_qName_4_0= ruleIdentifier ) )
            // InternalIvml.g:1698:1: (lv_qName_4_0= ruleIdentifier )
            {
            // InternalIvml.g:1698:1: (lv_qName_4_0= ruleIdentifier )
            // InternalIvml.g:1699:3: lv_qName_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_qName_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
              	        }
                     		add(
                     			current, 
                     			"qName",
                      		lv_qName_4_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleAccessName"
    // InternalIvml.g:1723:1: entryRuleAccessName returns [EObject current=null] : iv_ruleAccessName= ruleAccessName EOF ;
    public final EObject entryRuleAccessName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessName = null;


        try {
            // InternalIvml.g:1724:2: (iv_ruleAccessName= ruleAccessName EOF )
            // InternalIvml.g:1725:2: iv_ruleAccessName= ruleAccessName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAccessName=ruleAccessName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessName"


    // $ANTLR start "ruleAccessName"
    // InternalIvml.g:1732:1: ruleAccessName returns [EObject current=null] : ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ ;
    public final EObject ruleAccessName() throws RecognitionException {
        EObject current = null;

        Token lv_aName_0_0=null;
        AntlrDatatypeRuleToken lv_aName_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1735:28: ( ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+ )
            // InternalIvml.g:1736:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            {
            // InternalIvml.g:1736:1: ( ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==37) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalIvml.g:1736:2: ( (lv_aName_0_0= '.' ) ) ( (lv_aName_1_0= ruleIdentifier ) )
            	    {
            	    // InternalIvml.g:1736:2: ( (lv_aName_0_0= '.' ) )
            	    // InternalIvml.g:1737:1: (lv_aName_0_0= '.' )
            	    {
            	    // InternalIvml.g:1737:1: (lv_aName_0_0= '.' )
            	    // InternalIvml.g:1738:3: lv_aName_0_0= '.'
            	    {
            	    lv_aName_0_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_aName_0_0, grammarAccess.getAccessNameAccess().getANameFullStopKeyword_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAccessNameRule());
            	      	        }
            	             		addWithLastConsumed(current, "aName", lv_aName_0_0, ".");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalIvml.g:1751:2: ( (lv_aName_1_0= ruleIdentifier ) )
            	    // InternalIvml.g:1752:1: (lv_aName_1_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:1752:1: (lv_aName_1_0= ruleIdentifier )
            	    // InternalIvml.g:1753:3: lv_aName_1_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAccessNameAccess().getANameIdentifierParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_aName_1_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAccessNameRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"aName",
            	              		lv_aName_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessName"


    // $ANTLR start "entryRuleValue"
    // InternalIvml.g:1777:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalIvml.g:1778:2: (iv_ruleValue= ruleValue EOF )
            // InternalIvml.g:1779:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalIvml.g:1786:1: ruleValue returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token lv_self_4_0=null;
        Token lv_nullValue_5_0=null;
        Token lv_version_7_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;

        EObject lv_tValue_6_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1789:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) ) )
            // InternalIvml.g:1790:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )
            {
            // InternalIvml.g:1790:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )
            int alt30=8;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalIvml.g:1790:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalIvml.g:1790:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalIvml.g:1791:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalIvml.g:1791:1: (lv_nValue_0_0= ruleNumValue )
                    // InternalIvml.g:1792:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_nValue_0_0=ruleNumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
                      	        }
                             		set(
                             			current, 
                             			"nValue",
                              		lv_nValue_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.NumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1809:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalIvml.g:1809:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalIvml.g:1810:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalIvml.g:1810:1: (lv_sValue_1_0= RULE_STRING )
                    // InternalIvml.g:1811:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sValue_1_0, grammarAccess.getValueAccess().getSValueSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"sValue",
                              		lv_sValue_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:1828:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalIvml.g:1828:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalIvml.g:1829:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:1829:1: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalIvml.g:1830:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_qValue_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
                      	        }
                             		set(
                             			current, 
                             			"qValue",
                              		lv_qValue_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:1847:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalIvml.g:1847:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalIvml.g:1848:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalIvml.g:1848:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalIvml.g:1849:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalIvml.g:1849:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==38) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==39) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalIvml.g:1850:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_1, grammarAccess.getValueAccess().getBValueTrueKeyword_3_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueRule());
                              	        }
                                     		setWithLastConsumed(current, "bValue", lv_bValue_3_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalIvml.g:1862:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_2, grammarAccess.getValueAccess().getBValueFalseKeyword_3_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getValueRule());
                              	        }
                                     		setWithLastConsumed(current, "bValue", lv_bValue_3_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalIvml.g:1878:6: ( (lv_self_4_0= 'self' ) )
                    {
                    // InternalIvml.g:1878:6: ( (lv_self_4_0= 'self' ) )
                    // InternalIvml.g:1879:1: (lv_self_4_0= 'self' )
                    {
                    // InternalIvml.g:1879:1: (lv_self_4_0= 'self' )
                    // InternalIvml.g:1880:3: lv_self_4_0= 'self'
                    {
                    lv_self_4_0=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_self_4_0, grammarAccess.getValueAccess().getSelfSelfKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "self", lv_self_4_0, "self");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalIvml.g:1894:6: ( (lv_nullValue_5_0= 'null' ) )
                    {
                    // InternalIvml.g:1894:6: ( (lv_nullValue_5_0= 'null' ) )
                    // InternalIvml.g:1895:1: (lv_nullValue_5_0= 'null' )
                    {
                    // InternalIvml.g:1895:1: (lv_nullValue_5_0= 'null' )
                    // InternalIvml.g:1896:3: lv_nullValue_5_0= 'null'
                    {
                    lv_nullValue_5_0=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_nullValue_5_0, grammarAccess.getValueAccess().getNullValueNullKeyword_5_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "nullValue", lv_nullValue_5_0, "null");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalIvml.g:1910:6: ( (lv_tValue_6_0= ruleType ) )
                    {
                    // InternalIvml.g:1910:6: ( (lv_tValue_6_0= ruleType ) )
                    // InternalIvml.g:1911:1: (lv_tValue_6_0= ruleType )
                    {
                    // InternalIvml.g:1911:1: (lv_tValue_6_0= ruleType )
                    // InternalIvml.g:1912:3: lv_tValue_6_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getTValueTypeParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_tValue_6_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
                      	        }
                             		set(
                             			current, 
                             			"tValue",
                              		lv_tValue_6_0, 
                              		"de.uni_hildesheim.sse.Ivml.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalIvml.g:1929:6: ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) )
                    {
                    // InternalIvml.g:1929:6: ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) )
                    // InternalIvml.g:1929:7: ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION )
                    {
                    // InternalIvml.g:1935:1: (lv_version_7_0= RULE_VERSION )
                    // InternalIvml.g:1936:3: lv_version_7_0= RULE_VERSION
                    {
                    lv_version_7_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_version_7_0, grammarAccess.getValueAccess().getVersionVERSIONTerminalRuleCall_7_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"version",
                              		lv_version_7_0, 
                              		"de.uni_hildesheim.sse.Ivml.VERSION");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleDerivedType"
    // InternalIvml.g:1960:1: entryRuleDerivedType returns [EObject current=null] : iv_ruleDerivedType= ruleDerivedType EOF ;
    public final EObject entryRuleDerivedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDerivedType = null;


        try {
            // InternalIvml.g:1961:2: (iv_ruleDerivedType= ruleDerivedType EOF )
            // InternalIvml.g:1962:2: iv_ruleDerivedType= ruleDerivedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDerivedTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDerivedType=ruleDerivedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDerivedType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDerivedType"


    // $ANTLR start "ruleDerivedType"
    // InternalIvml.g:1969:1: ruleDerivedType returns [EObject current=null] : ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) ;
    public final EObject ruleDerivedType() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        Token lv_op_1_0=null;
        Token lv_op_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:1972:28: ( ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' ) )
            // InternalIvml.g:1973:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            {
            // InternalIvml.g:1973:1: ( ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')' )
            // InternalIvml.g:1973:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) ) otherlv_3= '(' ( (lv_type_4_0= ruleType ) ) otherlv_5= ')'
            {
            // InternalIvml.g:1973:2: ( ( (lv_op_0_0= 'setOf' ) ) | ( (lv_op_1_0= 'sequenceOf' ) ) | ( (lv_op_2_0= 'refTo' ) ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt31=1;
                }
                break;
            case 43:
                {
                alt31=2;
                }
                break;
            case 44:
                {
                alt31=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalIvml.g:1973:3: ( (lv_op_0_0= 'setOf' ) )
                    {
                    // InternalIvml.g:1973:3: ( (lv_op_0_0= 'setOf' ) )
                    // InternalIvml.g:1974:1: (lv_op_0_0= 'setOf' )
                    {
                    // InternalIvml.g:1974:1: (lv_op_0_0= 'setOf' )
                    // InternalIvml.g:1975:3: lv_op_0_0= 'setOf'
                    {
                    lv_op_0_0=(Token)match(input,42,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_0_0, grammarAccess.getDerivedTypeAccess().getOpSetOfKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_0_0, "setOf");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:1989:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    {
                    // InternalIvml.g:1989:6: ( (lv_op_1_0= 'sequenceOf' ) )
                    // InternalIvml.g:1990:1: (lv_op_1_0= 'sequenceOf' )
                    {
                    // InternalIvml.g:1990:1: (lv_op_1_0= 'sequenceOf' )
                    // InternalIvml.g:1991:3: lv_op_1_0= 'sequenceOf'
                    {
                    lv_op_1_0=(Token)match(input,43,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_1_0, grammarAccess.getDerivedTypeAccess().getOpSequenceOfKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_1_0, "sequenceOf");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:2005:6: ( (lv_op_2_0= 'refTo' ) )
                    {
                    // InternalIvml.g:2005:6: ( (lv_op_2_0= 'refTo' ) )
                    // InternalIvml.g:2006:1: (lv_op_2_0= 'refTo' )
                    {
                    // InternalIvml.g:2006:1: (lv_op_2_0= 'refTo' )
                    // InternalIvml.g:2007:3: lv_op_2_0= 'refTo'
                    {
                    lv_op_2_0=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_op_2_0, grammarAccess.getDerivedTypeAccess().getOpRefToKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDerivedTypeRule());
                      	        }
                             		setWithLastConsumed(current, "op", lv_op_2_0, "refTo");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDerivedTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:2024:1: ( (lv_type_4_0= ruleType ) )
            // InternalIvml.g:2025:1: (lv_type_4_0= ruleType )
            {
            // InternalIvml.g:2025:1: (lv_type_4_0= ruleType )
            // InternalIvml.g:2026:3: lv_type_4_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDerivedTypeAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_type_4_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDerivedTypeRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_4_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDerivedTypeAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDerivedType"


    // $ANTLR start "entryRuleAnnotateTo"
    // InternalIvml.g:2054:1: entryRuleAnnotateTo returns [EObject current=null] : iv_ruleAnnotateTo= ruleAnnotateTo EOF ;
    public final EObject entryRuleAnnotateTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotateTo = null;


        try {
            // InternalIvml.g:2055:2: (iv_ruleAnnotateTo= ruleAnnotateTo EOF )
            // InternalIvml.g:2056:2: iv_ruleAnnotateTo= ruleAnnotateTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotateToRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotateTo=ruleAnnotateTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotateTo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotateTo"


    // $ANTLR start "ruleAnnotateTo"
    // InternalIvml.g:2063:1: ruleAnnotateTo returns [EObject current=null] : ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' ) ;
    public final EObject ruleAnnotateTo() throws RecognitionException {
        EObject current = null;

        Token lv_sname_0_1=null;
        Token lv_sname_0_2=null;
        Token otherlv_3=null;
        Token lv_names_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_annotationType_1_0 = null;

        EObject lv_annotationDecl_2_0 = null;

        AntlrDatatypeRuleToken lv_names_5_0 = null;

        AntlrDatatypeRuleToken lv_names_7_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2066:28: ( ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' ) )
            // InternalIvml.g:2067:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' )
            {
            // InternalIvml.g:2067:1: ( ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';' )
            // InternalIvml.g:2067:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) ) ( (lv_annotationType_1_0= ruleType ) ) ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) ) otherlv_3= 'to' ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) ) otherlv_8= ';'
            {
            // InternalIvml.g:2067:2: ( ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) ) )
            // InternalIvml.g:2068:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            {
            // InternalIvml.g:2068:1: ( (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' ) )
            // InternalIvml.g:2069:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            {
            // InternalIvml.g:2069:1: (lv_sname_0_1= 'attribute' | lv_sname_0_2= 'annotate' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            else if ( (LA32_0==46) ) {
                alt32=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalIvml.g:2070:3: lv_sname_0_1= 'attribute'
                    {
                    lv_sname_0_1=(Token)match(input,45,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sname_0_1, grammarAccess.getAnnotateToAccess().getSnameAttributeKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAnnotateToRule());
                      	        }
                             		setWithLastConsumed(current, "sname", lv_sname_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:2082:8: lv_sname_0_2= 'annotate'
                    {
                    lv_sname_0_2=(Token)match(input,46,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_sname_0_2, grammarAccess.getAnnotateToAccess().getSnameAnnotateKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAnnotateToRule());
                      	        }
                             		setWithLastConsumed(current, "sname", lv_sname_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalIvml.g:2097:2: ( (lv_annotationType_1_0= ruleType ) )
            // InternalIvml.g:2098:1: (lv_annotationType_1_0= ruleType )
            {
            // InternalIvml.g:2098:1: (lv_annotationType_1_0= ruleType )
            // InternalIvml.g:2099:3: lv_annotationType_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_annotationType_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
              	        }
                     		set(
                     			current, 
                     			"annotationType",
                      		lv_annotationType_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2115:2: ( (lv_annotationDecl_2_0= ruleVariableDeclarationPart ) )
            // InternalIvml.g:2116:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            {
            // InternalIvml.g:2116:1: (lv_annotationDecl_2_0= ruleVariableDeclarationPart )
            // InternalIvml.g:2117:3: lv_annotationDecl_2_0= ruleVariableDeclarationPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAnnotateToAccess().getAnnotationDeclVariableDeclarationPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_23);
            lv_annotationDecl_2_0=ruleVariableDeclarationPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
              	        }
                     		set(
                     			current, 
                     			"annotationDecl",
                      		lv_annotationDecl_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.VariableDeclarationPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAnnotateToAccess().getToKeyword_3());
                  
            }
            // InternalIvml.g:2137:1: ( ( (lv_names_4_0= '.' ) ) | ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==37) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=RULE_VERSION && LA34_0<=RULE_EXPONENT)||LA34_0==57) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalIvml.g:2137:2: ( (lv_names_4_0= '.' ) )
                    {
                    // InternalIvml.g:2137:2: ( (lv_names_4_0= '.' ) )
                    // InternalIvml.g:2138:1: (lv_names_4_0= '.' )
                    {
                    // InternalIvml.g:2138:1: (lv_names_4_0= '.' )
                    // InternalIvml.g:2139:3: lv_names_4_0= '.'
                    {
                    lv_names_4_0=(Token)match(input,37,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_names_4_0, grammarAccess.getAnnotateToAccess().getNamesFullStopKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAnnotateToRule());
                      	        }
                             		addWithLastConsumed(current, "names", lv_names_4_0, ".");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2153:6: ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* )
                    {
                    // InternalIvml.g:2153:6: ( ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )* )
                    // InternalIvml.g:2153:7: ( (lv_names_5_0= ruleIdentifier ) ) (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )*
                    {
                    // InternalIvml.g:2153:7: ( (lv_names_5_0= ruleIdentifier ) )
                    // InternalIvml.g:2154:1: (lv_names_5_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2154:1: (lv_names_5_0= ruleIdentifier )
                    // InternalIvml.g:2155:3: lv_names_5_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_30);
                    lv_names_5_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
                      	        }
                             		add(
                             			current, 
                             			"names",
                              		lv_names_5_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:2171:2: (otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==18) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalIvml.g:2171:4: otherlv_6= ',' ( (lv_names_7_0= ruleIdentifier ) )
                    	    {
                    	    otherlv_6=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getAnnotateToAccess().getCommaKeyword_4_1_1_0());
                    	          
                    	    }
                    	    // InternalIvml.g:2175:1: ( (lv_names_7_0= ruleIdentifier ) )
                    	    // InternalIvml.g:2176:1: (lv_names_7_0= ruleIdentifier )
                    	    {
                    	    // InternalIvml.g:2176:1: (lv_names_7_0= ruleIdentifier )
                    	    // InternalIvml.g:2177:3: lv_names_7_0= ruleIdentifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAnnotateToAccess().getNamesIdentifierParserRuleCall_4_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_names_7_0=ruleIdentifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAnnotateToRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"names",
                    	              		lv_names_7_0, 
                    	              		"de.uni_hildesheim.sse.Ivml.Identifier");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAnnotateToAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotateTo"


    // $ANTLR start "entryRuleFreeze"
    // InternalIvml.g:2205:1: entryRuleFreeze returns [EObject current=null] : iv_ruleFreeze= ruleFreeze EOF ;
    public final EObject entryRuleFreeze() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreeze = null;


        try {
            // InternalIvml.g:2206:2: (iv_ruleFreeze= ruleFreeze EOF )
            // InternalIvml.g:2207:2: iv_ruleFreeze= ruleFreeze EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFreeze=ruleFreeze();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreeze; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreeze"


    // $ANTLR start "ruleFreeze"
    // InternalIvml.g:2214:1: ruleFreeze returns [EObject current=null] : (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) ;
    public final EObject ruleFreeze() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_names_2_0 = null;

        AntlrDatatypeRuleToken lv_id_6_0 = null;

        EObject lv_ex_8_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2217:28: ( (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? ) )
            // InternalIvml.g:2218:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            {
            // InternalIvml.g:2218:1: (otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )? )
            // InternalIvml.g:2218:3: otherlv_0= 'freeze' otherlv_1= '{' ( (lv_names_2_0= ruleFreezeStatement ) )+ otherlv_3= '}' (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )? (otherlv_10= ';' )?
            {
            otherlv_0=(Token)match(input,47,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFreezeAccess().getFreezeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFreezeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalIvml.g:2226:1: ( (lv_names_2_0= ruleFreezeStatement ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_VERSION && LA35_0<=RULE_EXPONENT)||LA35_0==37||LA35_0==57) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalIvml.g:2227:1: (lv_names_2_0= ruleFreezeStatement )
            	    {
            	    // InternalIvml.g:2227:1: (lv_names_2_0= ruleFreezeStatement )
            	    // InternalIvml.g:2228:3: lv_names_2_0= ruleFreezeStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFreezeAccess().getNamesFreezeStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_names_2_0=ruleFreezeStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.FreezeStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            otherlv_3=(Token)match(input,15,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeAccess().getRightCurlyBracketKeyword_3());
                  
            }
            // InternalIvml.g:2248:1: (otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalIvml.g:2248:3: otherlv_4= 'but' otherlv_5= '(' ( (lv_id_6_0= ruleIdentifier ) ) otherlv_7= '|' ( (lv_ex_8_0= ruleLogicalExpression ) ) otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,48,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFreezeAccess().getButKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFreezeAccess().getLeftParenthesisKeyword_4_1());
                          
                    }
                    // InternalIvml.g:2256:1: ( (lv_id_6_0= ruleIdentifier ) )
                    // InternalIvml.g:2257:1: (lv_id_6_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2257:1: (lv_id_6_0= ruleIdentifier )
                    // InternalIvml.g:2258:3: lv_id_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getIdIdentifierParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_36);
                    lv_id_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
                      	        }
                             		set(
                             			current, 
                             			"id",
                              		lv_id_6_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,49,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getFreezeAccess().getVerticalLineKeyword_4_3());
                          
                    }
                    // InternalIvml.g:2278:1: ( (lv_ex_8_0= ruleLogicalExpression ) )
                    // InternalIvml.g:2279:1: (lv_ex_8_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:2279:1: (lv_ex_8_0= ruleLogicalExpression )
                    // InternalIvml.g:2280:3: lv_ex_8_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeAccess().getExLogicalExpressionParserRuleCall_4_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_29);
                    lv_ex_8_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_8_0, 
                              		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,25,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFreezeAccess().getRightParenthesisKeyword_4_5());
                          
                    }

                    }
                    break;

            }

            // InternalIvml.g:2300:3: (otherlv_10= ';' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==16) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalIvml.g:2300:5: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFreezeAccess().getSemicolonKeyword_5());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFreeze"


    // $ANTLR start "entryRuleFreezeStatement"
    // InternalIvml.g:2312:1: entryRuleFreezeStatement returns [EObject current=null] : iv_ruleFreezeStatement= ruleFreezeStatement EOF ;
    public final EObject entryRuleFreezeStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFreezeStatement = null;


        try {
            // InternalIvml.g:2313:2: (iv_ruleFreezeStatement= ruleFreezeStatement EOF )
            // InternalIvml.g:2314:2: iv_ruleFreezeStatement= ruleFreezeStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFreezeStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFreezeStatement=ruleFreezeStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFreezeStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFreezeStatement"


    // $ANTLR start "ruleFreezeStatement"
    // InternalIvml.g:2321:1: ruleFreezeStatement returns [EObject current=null] : ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' ) ;
    public final EObject ruleFreezeStatement() throws RecognitionException {
        EObject current = null;

        Token lv_dot_0_0=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;

        EObject lv_access_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2324:28: ( ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' ) )
            // InternalIvml.g:2325:1: ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' )
            {
            // InternalIvml.g:2325:1: ( ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';' )
            // InternalIvml.g:2325:2: ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) ) otherlv_3= ';'
            {
            // InternalIvml.g:2325:2: ( ( (lv_dot_0_0= '.' ) ) | ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==37) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=RULE_VERSION && LA39_0<=RULE_EXPONENT)||LA39_0==57) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalIvml.g:2325:3: ( (lv_dot_0_0= '.' ) )
                    {
                    // InternalIvml.g:2325:3: ( (lv_dot_0_0= '.' ) )
                    // InternalIvml.g:2326:1: (lv_dot_0_0= '.' )
                    {
                    // InternalIvml.g:2326:1: (lv_dot_0_0= '.' )
                    // InternalIvml.g:2327:3: lv_dot_0_0= '.'
                    {
                    lv_dot_0_0=(Token)match(input,37,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_dot_0_0, grammarAccess.getFreezeStatementAccess().getDotFullStopKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFreezeStatementRule());
                      	        }
                             		setWithLastConsumed(current, "dot", lv_dot_0_0, ".");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2341:6: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? )
                    {
                    // InternalIvml.g:2341:6: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )? )
                    // InternalIvml.g:2341:7: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_access_2_0= ruleAccessName ) )?
                    {
                    // InternalIvml.g:2341:7: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalIvml.g:2342:1: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:2342:1: (lv_name_1_0= ruleQualifiedName )
                    // InternalIvml.g:2343:3: lv_name_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getNameQualifiedNameParserRuleCall_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_37);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:2359:2: ( (lv_access_2_0= ruleAccessName ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==37) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalIvml.g:2360:1: (lv_access_2_0= ruleAccessName )
                            {
                            // InternalIvml.g:2360:1: (lv_access_2_0= ruleAccessName )
                            // InternalIvml.g:2361:3: lv_access_2_0= ruleAccessName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFreezeStatementAccess().getAccessAccessNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_14);
                            lv_access_2_0=ruleAccessName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getFreezeStatementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"access",
                                      		lv_access_2_0, 
                                      		"de.uni_hildesheim.sse.Ivml.AccessName");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFreezeStatementAccess().getSemicolonKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFreezeStatement"


    // $ANTLR start "entryRuleEval"
    // InternalIvml.g:2389:1: entryRuleEval returns [EObject current=null] : iv_ruleEval= ruleEval EOF ;
    public final EObject entryRuleEval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEval = null;


        try {
            // InternalIvml.g:2390:2: (iv_ruleEval= ruleEval EOF )
            // InternalIvml.g:2391:2: iv_ruleEval= ruleEval EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEvalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEval=ruleEval();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEval; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEval"


    // $ANTLR start "ruleEval"
    // InternalIvml.g:2398:1: ruleEval returns [EObject current=null] : ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) ;
    public final EObject ruleEval() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_nested_3_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2401:28: ( ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? ) )
            // InternalIvml.g:2402:1: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            {
            // InternalIvml.g:2402:1: ( () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )? )
            // InternalIvml.g:2402:2: () otherlv_1= 'eval' otherlv_2= '{' ( (lv_nested_3_0= ruleEval ) )* ( (lv_statements_4_0= ruleExpressionStatement ) )* otherlv_5= '}' (otherlv_6= ';' )?
            {
            // InternalIvml.g:2402:2: ()
            // InternalIvml.g:2403:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEvalAccess().getEvalAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEvalAccess().getEvalKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,14,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEvalAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:2419:1: ( (lv_nested_3_0= ruleEval ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==50) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalIvml.g:2420:1: (lv_nested_3_0= ruleEval )
            	    {
            	    // InternalIvml.g:2420:1: (lv_nested_3_0= ruleEval )
            	    // InternalIvml.g:2421:3: lv_nested_3_0= ruleEval
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getNestedEvalParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_nested_3_0=ruleEval();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nested",
            	              		lv_nested_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Eval");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            // InternalIvml.g:2437:3: ( (lv_statements_4_0= ruleExpressionStatement ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_NUMBER && LA41_0<=RULE_EXPONENT)||LA41_0==14||LA41_0==24||(LA41_0>=30 && LA41_0<=35)||(LA41_0>=38 && LA41_0<=44)||LA41_0==55||LA41_0==57||LA41_0==60||(LA41_0>=62 && LA41_0<=77)||(LA41_0>=81 && LA41_0<=82)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalIvml.g:2438:1: (lv_statements_4_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:2438:1: (lv_statements_4_0= ruleExpressionStatement )
            	    // InternalIvml.g:2439:3: lv_statements_4_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEvalAccess().getStatementsExpressionStatementParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_statements_4_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEvalRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_4_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEvalAccess().getRightCurlyBracketKeyword_5());
                  
            }
            // InternalIvml.g:2459:1: (otherlv_6= ';' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==16) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalIvml.g:2459:3: otherlv_6= ';'
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getEvalAccess().getSemicolonKeyword_6());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEval"


    // $ANTLR start "entryRuleInterfaceDeclaration"
    // InternalIvml.g:2471:1: entryRuleInterfaceDeclaration returns [EObject current=null] : iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF ;
    public final EObject entryRuleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceDeclaration = null;


        try {
            // InternalIvml.g:2472:2: (iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF )
            // InternalIvml.g:2473:2: iv_ruleInterfaceDeclaration= ruleInterfaceDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceDeclaration=ruleInterfaceDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceDeclaration"


    // $ANTLR start "ruleInterfaceDeclaration"
    // InternalIvml.g:2480:1: ruleInterfaceDeclaration returns [EObject current=null] : (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) ;
    public final EObject ruleInterfaceDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_exports_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2483:28: ( (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? ) )
            // InternalIvml.g:2484:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            {
            // InternalIvml.g:2484:1: (otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )? )
            // InternalIvml.g:2484:3: otherlv_0= 'interface' ( (lv_name_1_0= ruleIdentifier ) ) otherlv_2= '{' ( (lv_exports_3_0= ruleExport ) )* otherlv_4= '}' (otherlv_5= ';' )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInterfaceDeclarationAccess().getInterfaceKeyword_0());
                  
            }
            // InternalIvml.g:2488:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2489:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2489:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2490:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInterfaceDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInterfaceDeclarationAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:2510:1: ( (lv_exports_3_0= ruleExport ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==52) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalIvml.g:2511:1: (lv_exports_3_0= ruleExport )
            	    {
            	    // InternalIvml.g:2511:1: (lv_exports_3_0= ruleExport )
            	    // InternalIvml.g:2512:3: lv_exports_3_0= ruleExport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterfaceDeclarationAccess().getExportsExportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_exports_3_0=ruleExport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInterfaceDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exports",
            	              		lv_exports_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Export");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getInterfaceDeclarationAccess().getRightCurlyBracketKeyword_4());
                  
            }
            // InternalIvml.g:2532:1: (otherlv_5= ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==16) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalIvml.g:2532:3: otherlv_5= ';'
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getInterfaceDeclarationAccess().getSemicolonKeyword_5());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterfaceDeclaration"


    // $ANTLR start "entryRuleExport"
    // InternalIvml.g:2544:1: entryRuleExport returns [EObject current=null] : iv_ruleExport= ruleExport EOF ;
    public final EObject entryRuleExport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExport = null;


        try {
            // InternalIvml.g:2545:2: (iv_ruleExport= ruleExport EOF )
            // InternalIvml.g:2546:2: iv_ruleExport= ruleExport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExport=ruleExport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExport"


    // $ANTLR start "ruleExport"
    // InternalIvml.g:2553:1: ruleExport returns [EObject current=null] : (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleExport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_names_1_0 = null;

        EObject lv_names_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2556:28: ( (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' ) )
            // InternalIvml.g:2557:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            {
            // InternalIvml.g:2557:1: (otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';' )
            // InternalIvml.g:2557:3: otherlv_0= 'export' ( (lv_names_1_0= ruleQualifiedName ) ) (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExportAccess().getExportKeyword_0());
                  
            }
            // InternalIvml.g:2561:1: ( (lv_names_1_0= ruleQualifiedName ) )
            // InternalIvml.g:2562:1: (lv_names_1_0= ruleQualifiedName )
            {
            // InternalIvml.g:2562:1: (lv_names_1_0= ruleQualifiedName )
            // InternalIvml.g:2563:3: lv_names_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_30);
            lv_names_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExportRule());
              	        }
                     		add(
                     			current, 
                     			"names",
                      		lv_names_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2579:2: (otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==18) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalIvml.g:2579:4: otherlv_2= ',' ( (lv_names_3_0= ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getExportAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:2583:1: ( (lv_names_3_0= ruleQualifiedName ) )
            	    // InternalIvml.g:2584:1: (lv_names_3_0= ruleQualifiedName )
            	    {
            	    // InternalIvml.g:2584:1: (lv_names_3_0= ruleQualifiedName )
            	    // InternalIvml.g:2585:3: lv_names_3_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExportAccess().getNamesQualifiedNameParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_names_3_0=ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExportRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getExportAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExport"


    // $ANTLR start "entryRuleImportStmt"
    // InternalIvml.g:2613:1: entryRuleImportStmt returns [EObject current=null] : iv_ruleImportStmt= ruleImportStmt EOF ;
    public final EObject entryRuleImportStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportStmt = null;


        try {
            // InternalIvml.g:2614:2: (iv_ruleImportStmt= ruleImportStmt EOF )
            // InternalIvml.g:2615:2: iv_ruleImportStmt= ruleImportStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportStmt=ruleImportStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportStmt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportStmt"


    // $ANTLR start "ruleImportStmt"
    // InternalIvml.g:2622:1: ruleImportStmt returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' ) ;
    public final EObject ruleImportStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_insert_1_0=null;
        Token otherlv_3=null;
        Token lv_wildcard_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_interface_4_0 = null;

        EObject lv_restriction_7_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2625:28: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' ) )
            // InternalIvml.g:2626:1: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' )
            {
            // InternalIvml.g:2626:1: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';' )
            // InternalIvml.g:2626:2: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )? ( (lv_wildcard_5_0= '*' ) )? (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )? otherlv_8= ';'
            {
            // InternalIvml.g:2626:2: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            else if ( (LA46_0==54) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalIvml.g:2626:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,53,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getImportStmtAccess().getImportKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:2631:6: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalIvml.g:2631:6: ( (lv_insert_1_0= 'insert' ) )
                    // InternalIvml.g:2632:1: (lv_insert_1_0= 'insert' )
                    {
                    // InternalIvml.g:2632:1: (lv_insert_1_0= 'insert' )
                    // InternalIvml.g:2633:3: lv_insert_1_0= 'insert'
                    {
                    lv_insert_1_0=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_insert_1_0, grammarAccess.getImportStmtAccess().getInsertInsertKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportStmtRule());
                      	        }
                             		setWithLastConsumed(current, "insert", lv_insert_1_0, "insert");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalIvml.g:2646:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:2647:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:2647:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:2648:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_41);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2664:2: (otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==36) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalIvml.g:2664:4: otherlv_3= '::' ( (lv_interface_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getImportStmtAccess().getColonColonKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2668:1: ( (lv_interface_4_0= ruleIdentifier ) )
                    // InternalIvml.g:2669:1: (lv_interface_4_0= ruleIdentifier )
                    {
                    // InternalIvml.g:2669:1: (lv_interface_4_0= ruleIdentifier )
                    // InternalIvml.g:2670:3: lv_interface_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getInterfaceIdentifierParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_42);
                    lv_interface_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"interface",
                              		lv_interface_4_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalIvml.g:2686:4: ( (lv_wildcard_5_0= '*' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalIvml.g:2687:1: (lv_wildcard_5_0= '*' )
                    {
                    // InternalIvml.g:2687:1: (lv_wildcard_5_0= '*' )
                    // InternalIvml.g:2688:3: lv_wildcard_5_0= '*'
                    {
                    lv_wildcard_5_0=(Token)match(input,55,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_wildcard_5_0, grammarAccess.getImportStmtAccess().getWildcardAsteriskKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportStmtRule());
                      	        }
                             		setWithLastConsumed(current, "wildcard", lv_wildcard_5_0, "*");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:2701:3: (otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==28) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalIvml.g:2701:5: otherlv_6= 'with' ( (lv_restriction_7_0= ruleExpression ) )
                    {
                    otherlv_6=(Token)match(input,28,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getImportStmtAccess().getWithKeyword_4_0());
                          
                    }
                    // InternalIvml.g:2705:1: ( (lv_restriction_7_0= ruleExpression ) )
                    // InternalIvml.g:2706:1: (lv_restriction_7_0= ruleExpression )
                    {
                    // InternalIvml.g:2706:1: (lv_restriction_7_0= ruleExpression )
                    // InternalIvml.g:2707:3: lv_restriction_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportStmtAccess().getRestrictionExpressionParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_restriction_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"restriction",
                              		lv_restriction_7_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getImportStmtAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportStmt"


    // $ANTLR start "entryRuleConflictStmt"
    // InternalIvml.g:2735:1: entryRuleConflictStmt returns [EObject current=null] : iv_ruleConflictStmt= ruleConflictStmt EOF ;
    public final EObject entryRuleConflictStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictStmt = null;


        try {
            // InternalIvml.g:2736:2: (iv_ruleConflictStmt= ruleConflictStmt EOF )
            // InternalIvml.g:2737:2: iv_ruleConflictStmt= ruleConflictStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConflictStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConflictStmt=ruleConflictStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConflictStmt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConflictStmt"


    // $ANTLR start "ruleConflictStmt"
    // InternalIvml.g:2744:1: ruleConflictStmt returns [EObject current=null] : (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleConflictStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_restriction_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2747:28: ( (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' ) )
            // InternalIvml.g:2748:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            {
            // InternalIvml.g:2748:1: (otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';' )
            // InternalIvml.g:2748:3: otherlv_0= 'conflicts' ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConflictStmtAccess().getConflictsKeyword_0());
                  
            }
            // InternalIvml.g:2752:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:2753:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:2753:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:2754:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConflictStmtAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2770:2: (otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==28) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalIvml.g:2770:4: otherlv_2= 'with' ( (lv_restriction_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConflictStmtAccess().getWithKeyword_2_0());
                          
                    }
                    // InternalIvml.g:2774:1: ( (lv_restriction_3_0= ruleExpression ) )
                    // InternalIvml.g:2775:1: (lv_restriction_3_0= ruleExpression )
                    {
                    // InternalIvml.g:2775:1: (lv_restriction_3_0= ruleExpression )
                    // InternalIvml.g:2776:3: lv_restriction_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConflictStmtAccess().getRestrictionExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_restriction_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConflictStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"restriction",
                              		lv_restriction_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConflictStmtAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConflictStmt"


    // $ANTLR start "entryRuleVersionStmt"
    // InternalIvml.g:2804:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalIvml.g:2805:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalIvml.g:2806:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionStmt"


    // $ANTLR start "ruleVersionStmt"
    // InternalIvml.g:2813:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:2816:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalIvml.g:2817:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalIvml.g:2817:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalIvml.g:2817:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // InternalIvml.g:2821:1: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalIvml.g:2822:1: (lv_version_1_0= RULE_VERSION )
            {
            // InternalIvml.g:2822:1: (lv_version_1_0= RULE_VERSION )
            // InternalIvml.g:2823:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_version_1_0, grammarAccess.getVersionStmtAccess().getVersionVERSIONTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVersionStmtRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"version",
                      		lv_version_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.VERSION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getVersionStmtAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersionStmt"


    // $ANTLR start "entryRuleOpDefStatement"
    // InternalIvml.g:2851:1: entryRuleOpDefStatement returns [EObject current=null] : iv_ruleOpDefStatement= ruleOpDefStatement EOF ;
    public final EObject entryRuleOpDefStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefStatement = null;


        try {
            // InternalIvml.g:2852:2: (iv_ruleOpDefStatement= ruleOpDefStatement EOF )
            // InternalIvml.g:2853:2: iv_ruleOpDefStatement= ruleOpDefStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefStatement=ruleOpDefStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefStatement"


    // $ANTLR start "ruleOpDefStatement"
    // InternalIvml.g:2860:1: ruleOpDefStatement returns [EObject current=null] : (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) ) ;
    public final EObject ruleOpDefStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_result_2_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_param_5_0 = null;

        EObject lv_impl_8_0 = null;

        EObject lv_block_10_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:2863:28: ( (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) ) )
            // InternalIvml.g:2864:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) )
            {
            // InternalIvml.g:2864:1: (otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:2864:3: otherlv_0= 'def' ( (lv_static_1_0= 'static' ) )? ( (lv_result_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleOpDefParameterList ) ) otherlv_6= ')' otherlv_7= '=' ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOpDefStatementAccess().getDefKeyword_0());
                  
            }
            // InternalIvml.g:2868:1: ( (lv_static_1_0= 'static' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==59) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalIvml.g:2869:1: (lv_static_1_0= 'static' )
                    {
                    // InternalIvml.g:2869:1: (lv_static_1_0= 'static' )
                    // InternalIvml.g:2870:3: lv_static_1_0= 'static'
                    {
                    lv_static_1_0=(Token)match(input,59,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_static_1_0, grammarAccess.getOpDefStatementAccess().getStaticStaticKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getOpDefStatementRule());
                      	        }
                             		setWithLastConsumed(current, "static", lv_static_1_0, "static");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:2883:3: ( (lv_result_2_0= ruleType ) )
            // InternalIvml.g:2884:1: (lv_result_2_0= ruleType )
            {
            // InternalIvml.g:2884:1: (lv_result_2_0= ruleType )
            // InternalIvml.g:2885:3: lv_result_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getResultTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_result_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"result",
                      		lv_result_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:2901:2: ( (lv_id_3_0= ruleIdentifier ) )
            // InternalIvml.g:2902:1: (lv_id_3_0= ruleIdentifier )
            {
            // InternalIvml.g:2902:1: (lv_id_3_0= ruleIdentifier )
            // InternalIvml.g:2903:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_id_3_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOpDefStatementAccess().getLeftParenthesisKeyword_4());
                  
            }
            // InternalIvml.g:2923:1: ( (lv_param_5_0= ruleOpDefParameterList ) )
            // InternalIvml.g:2924:1: (lv_param_5_0= ruleOpDefParameterList )
            {
            // InternalIvml.g:2924:1: (lv_param_5_0= ruleOpDefParameterList )
            // InternalIvml.g:2925:3: lv_param_5_0= ruleOpDefParameterList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getParamOpDefParameterListParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_29);
            lv_param_5_0=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
              	        }
                     		set(
                     			current, 
                     			"param",
                      		lv_param_5_0, 
                      		"de.uni_hildesheim.sse.Ivml.OpDefParameterList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOpDefStatementAccess().getRightParenthesisKeyword_6());
                  
            }
            otherlv_7=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getOpDefStatementAccess().getEqualsSignKeyword_7());
                  
            }
            // InternalIvml.g:2949:1: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalIvml.g:2949:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
                    {
                    // InternalIvml.g:2949:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
                    // InternalIvml.g:2949:3: ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';'
                    {
                    // InternalIvml.g:2949:3: ( (lv_impl_8_0= ruleExpression ) )
                    // InternalIvml.g:2950:1: (lv_impl_8_0= ruleExpression )
                    {
                    // InternalIvml.g:2950:1: (lv_impl_8_0= ruleExpression )
                    // InternalIvml.g:2951:3: lv_impl_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_8_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_14);
                    lv_impl_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"impl",
                              		lv_impl_8_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getOpDefStatementAccess().getSemicolonKeyword_8_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:2972:6: ( (lv_block_10_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:2972:6: ( (lv_block_10_0= ruleBlockExpression ) )
                    // InternalIvml.g:2973:1: (lv_block_10_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:2973:1: (lv_block_10_0= ruleBlockExpression )
                    // InternalIvml.g:2974:3: lv_block_10_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getBlockBlockExpressionParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_10_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_10_0, 
                              		"de.uni_hildesheim.sse.Ivml.BlockExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpDefStatement"


    // $ANTLR start "entryRuleOpDefParameterList"
    // InternalIvml.g:2998:1: entryRuleOpDefParameterList returns [EObject current=null] : iv_ruleOpDefParameterList= ruleOpDefParameterList EOF ;
    public final EObject entryRuleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameterList = null;


        try {
            // InternalIvml.g:2999:2: (iv_ruleOpDefParameterList= ruleOpDefParameterList EOF )
            // InternalIvml.g:3000:2: iv_ruleOpDefParameterList= ruleOpDefParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefParameterList=ruleOpDefParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameterList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefParameterList"


    // $ANTLR start "ruleOpDefParameterList"
    // InternalIvml.g:3007:1: ruleOpDefParameterList returns [EObject current=null] : ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) ;
    public final EObject ruleOpDefParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        EObject lv_list_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3010:28: ( ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? ) )
            // InternalIvml.g:3011:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            {
            // InternalIvml.g:3011:1: ( () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )? )
            // InternalIvml.g:3011:2: () ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            {
            // InternalIvml.g:3011:2: ()
            // InternalIvml.g:3012:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOpDefParameterListAccess().getOpDefParameterListAction_0(),
                          current);
                  
            }

            }

            // InternalIvml.g:3020:2: ( ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_VERSION && LA54_0<=RULE_EXPONENT)||(LA54_0>=30 && LA54_0<=35)||(LA54_0>=42 && LA54_0<=44)||LA54_0==57) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalIvml.g:3020:3: ( (lv_list_1_0= ruleOpDefParameter ) ) (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    {
                    // InternalIvml.g:3020:3: ( (lv_list_1_0= ruleOpDefParameter ) )
                    // InternalIvml.g:3021:1: (lv_list_1_0= ruleOpDefParameter )
                    {
                    // InternalIvml.g:3021:1: (lv_list_1_0= ruleOpDefParameter )
                    // InternalIvml.g:3022:3: lv_list_1_0= ruleOpDefParameter
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_46);
                    lv_list_1_0=ruleOpDefParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefParameterListRule());
                      	        }
                             		add(
                             			current, 
                             			"list",
                              		lv_list_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.OpDefParameter");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:3038:2: (otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==18) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalIvml.g:3038:4: otherlv_2= ',' ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,18,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // InternalIvml.g:3042:1: ( (lv_list_3_0= ruleOpDefParameter ) )
                    	    // InternalIvml.g:3043:1: (lv_list_3_0= ruleOpDefParameter )
                    	    {
                    	    // InternalIvml.g:3043:1: (lv_list_3_0= ruleOpDefParameter )
                    	    // InternalIvml.g:3044:3: lv_list_3_0= ruleOpDefParameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOpDefParameterListAccess().getListOpDefParameterParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_list_3_0=ruleOpDefParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOpDefParameterListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"list",
                    	              		lv_list_3_0, 
                    	              		"de.uni_hildesheim.sse.Ivml.OpDefParameter");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpDefParameterList"


    // $ANTLR start "entryRuleOpDefParameter"
    // InternalIvml.g:3068:1: entryRuleOpDefParameter returns [EObject current=null] : iv_ruleOpDefParameter= ruleOpDefParameter EOF ;
    public final EObject entryRuleOpDefParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpDefParameter = null;


        try {
            // InternalIvml.g:3069:2: (iv_ruleOpDefParameter= ruleOpDefParameter EOF )
            // InternalIvml.g:3070:2: iv_ruleOpDefParameter= ruleOpDefParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpDefParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpDefParameter=ruleOpDefParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpDefParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpDefParameter"


    // $ANTLR start "ruleOpDefParameter"
    // InternalIvml.g:3077:1: ruleOpDefParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleOpDefParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_val_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3080:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:3081:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:3081:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )? )
            // InternalIvml.g:3081:2: ( (lv_type_0_0= ruleType ) ) ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:3081:2: ( (lv_type_0_0= ruleType ) )
            // InternalIvml.g:3082:1: (lv_type_0_0= ruleType )
            {
            // InternalIvml.g:3082:1: (lv_type_0_0= ruleType )
            // InternalIvml.g:3083:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3099:2: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:3100:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:3100:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:3101:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
            lv_id_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3117:2: (otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==19) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalIvml.g:3117:4: otherlv_2= '=' ( (lv_val_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getOpDefParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // InternalIvml.g:3121:1: ( (lv_val_3_0= ruleExpression ) )
                    // InternalIvml.g:3122:1: (lv_val_3_0= ruleExpression )
                    {
                    // InternalIvml.g:3122:1: (lv_val_3_0= ruleExpression )
                    // InternalIvml.g:3123:3: lv_val_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOpDefParameterAccess().getValExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_val_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOpDefParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpDefParameter"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalIvml.g:3147:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalIvml.g:3148:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalIvml.g:3149:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalIvml.g:3156:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3159:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalIvml.g:3160:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalIvml.g:3160:1: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalIvml.g:3160:2: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalIvml.g:3160:2: ( (lv_expr_0_0= ruleExpression ) )
            // InternalIvml.g:3161:1: (lv_expr_0_0= ruleExpression )
            {
            // InternalIvml.g:3161:1: (lv_expr_0_0= ruleExpression )
            // InternalIvml.g:3162:3: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_14);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRuleExpression"
    // InternalIvml.g:3190:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalIvml.g:3191:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalIvml.g:3192:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalIvml.g:3199:1: ruleExpression returns [EObject current=null] : ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_let_0_0 = null;

        EObject lv_expr_1_0 = null;

        EObject lv_container_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3202:28: ( ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:3203:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:3203:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt56=3;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // InternalIvml.g:3203:2: ( (lv_let_0_0= ruleLetExpression ) )
                    {
                    // InternalIvml.g:3203:2: ( (lv_let_0_0= ruleLetExpression ) )
                    // InternalIvml.g:3204:1: (lv_let_0_0= ruleLetExpression )
                    {
                    // InternalIvml.g:3204:1: (lv_let_0_0= ruleLetExpression )
                    // InternalIvml.g:3205:3: lv_let_0_0= ruleLetExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLetLetExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_let_0_0=ruleLetExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"let",
                              		lv_let_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.LetExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3222:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:3222:6: ( (lv_expr_1_0= ruleImplicationExpression ) )
                    // InternalIvml.g:3223:1: (lv_expr_1_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:3223:1: (lv_expr_1_0= ruleImplicationExpression )
                    // InternalIvml.g:3224:3: lv_expr_1_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprImplicationExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_1_0=ruleImplicationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.ImplicationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:3241:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:3241:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:3242:1: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:3242:1: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:3243:3: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getContainerContainerInitializerParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"container",
                              		lv_container_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLetExpression"
    // InternalIvml.g:3267:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // InternalIvml.g:3268:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // InternalIvml.g:3269:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetExpression"


    // $ANTLR start "ruleLetExpression"
    // InternalIvml.g:3276:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) ;
    public final EObject ruleLetExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_valueExpr_4_0 = null;

        EObject lv_subExpr_6_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3279:28: ( (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) ) )
            // InternalIvml.g:3280:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            {
            // InternalIvml.g:3280:1: (otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) ) )
            // InternalIvml.g:3280:3: otherlv_0= 'let' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '=' ( (lv_valueExpr_4_0= ruleExpression ) ) otherlv_5= 'in' ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                  
            }
            // InternalIvml.g:3284:1: ( (lv_type_1_0= ruleType ) )
            // InternalIvml.g:3285:1: (lv_type_1_0= ruleType )
            {
            // InternalIvml.g:3285:1: (lv_type_1_0= ruleType )
            // InternalIvml.g:3286:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3302:2: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalIvml.g:3303:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalIvml.g:3303:1: (lv_name_2_0= ruleIdentifier )
            // InternalIvml.g:3304:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLetExpressionAccess().getEqualsSignKeyword_3());
                  
            }
            // InternalIvml.g:3324:1: ( (lv_valueExpr_4_0= ruleExpression ) )
            // InternalIvml.g:3325:1: (lv_valueExpr_4_0= ruleExpression )
            {
            // InternalIvml.g:3325:1: (lv_valueExpr_4_0= ruleExpression )
            // InternalIvml.g:3326:3: lv_valueExpr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getValueExprExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
            lv_valueExpr_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"valueExpr",
                      		lv_valueExpr_4_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,61,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLetExpressionAccess().getInKeyword_5());
                  
            }
            // InternalIvml.g:3346:1: ( (lv_subExpr_6_0= ruleOptBlockExpression ) )
            // InternalIvml.g:3347:1: (lv_subExpr_6_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:3347:1: (lv_subExpr_6_0= ruleOptBlockExpression )
            // InternalIvml.g:3348:3: lv_subExpr_6_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpressionAccess().getSubExprOptBlockExpressionParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_subExpr_6_0=ruleOptBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"subExpr",
                      		lv_subExpr_6_0, 
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetExpression"


    // $ANTLR start "entryRuleOptBlockExpression"
    // InternalIvml.g:3372:1: entryRuleOptBlockExpression returns [EObject current=null] : iv_ruleOptBlockExpression= ruleOptBlockExpression EOF ;
    public final EObject entryRuleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptBlockExpression = null;


        try {
            // InternalIvml.g:3373:2: (iv_ruleOptBlockExpression= ruleOptBlockExpression EOF )
            // InternalIvml.g:3374:2: iv_ruleOptBlockExpression= ruleOptBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOptBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOptBlockExpression=ruleOptBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOptBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptBlockExpression"


    // $ANTLR start "ruleOptBlockExpression"
    // InternalIvml.g:3381:1: ruleOptBlockExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) ;
    public final EObject ruleOptBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3384:28: ( ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) ) )
            // InternalIvml.g:3385:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            {
            // InternalIvml.g:3385:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // InternalIvml.g:3385:2: ( (lv_expr_0_0= ruleExpression ) )
                    {
                    // InternalIvml.g:3385:2: ( (lv_expr_0_0= ruleExpression ) )
                    // InternalIvml.g:3386:1: (lv_expr_0_0= ruleExpression )
                    {
                    // InternalIvml.g:3386:1: (lv_expr_0_0= ruleExpression )
                    // InternalIvml.g:3387:3: lv_expr_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getExprExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_0_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOptBlockExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3404:6: ( (lv_block_1_0= ruleBlockExpression ) )
                    {
                    // InternalIvml.g:3404:6: ( (lv_block_1_0= ruleBlockExpression ) )
                    // InternalIvml.g:3405:1: (lv_block_1_0= ruleBlockExpression )
                    {
                    // InternalIvml.g:3405:1: (lv_block_1_0= ruleBlockExpression )
                    // InternalIvml.g:3406:3: lv_block_1_0= ruleBlockExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getBlockBlockExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_1_0=ruleBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOptBlockExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.BlockExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptBlockExpression"


    // $ANTLR start "entryRuleBlockExpression"
    // InternalIvml.g:3430:1: entryRuleBlockExpression returns [EObject current=null] : iv_ruleBlockExpression= ruleBlockExpression EOF ;
    public final EObject entryRuleBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockExpression = null;


        try {
            // InternalIvml.g:3431:2: (iv_ruleBlockExpression= ruleBlockExpression EOF )
            // InternalIvml.g:3432:2: iv_ruleBlockExpression= ruleBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlockExpression=ruleBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockExpression"


    // $ANTLR start "ruleBlockExpression"
    // InternalIvml.g:3439:1: ruleBlockExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) ;
    public final EObject ruleBlockExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_exprs_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3442:28: ( (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' ) )
            // InternalIvml.g:3443:1: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            {
            // InternalIvml.g:3443:1: (otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}' )
            // InternalIvml.g:3443:3: otherlv_0= '{' ( (lv_exprs_1_0= ruleExpressionStatement ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBlockExpressionAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // InternalIvml.g:3447:1: ( (lv_exprs_1_0= ruleExpressionStatement ) )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=RULE_NUMBER && LA58_0<=RULE_EXPONENT)||LA58_0==14||LA58_0==24||(LA58_0>=30 && LA58_0<=35)||(LA58_0>=38 && LA58_0<=44)||LA58_0==55||LA58_0==57||LA58_0==60||(LA58_0>=62 && LA58_0<=77)||(LA58_0>=81 && LA58_0<=82)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalIvml.g:3448:1: (lv_exprs_1_0= ruleExpressionStatement )
            	    {
            	    // InternalIvml.g:3448:1: (lv_exprs_1_0= ruleExpressionStatement )
            	    // InternalIvml.g:3449:3: lv_exprs_1_0= ruleExpressionStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBlockExpressionAccess().getExprsExpressionStatementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_exprs_1_0=ruleExpressionStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBlockExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"exprs",
            	              		lv_exprs_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionStatement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt58 >= 1 ) break loop58;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
            } while (true);

            otherlv_2=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBlockExpressionAccess().getRightCurlyBracketKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalIvml.g:3477:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalIvml.g:3478:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalIvml.g:3479:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalIvml.g:3486:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3489:28: ( ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? ) )
            // InternalIvml.g:3490:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            {
            // InternalIvml.g:3490:1: ( ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )? )
            // InternalIvml.g:3490:2: ( (lv_left_0_0= ruleLogicalExpression ) ) ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            {
            // InternalIvml.g:3490:2: ( (lv_left_0_0= ruleLogicalExpression ) )
            // InternalIvml.g:3491:1: (lv_left_0_0= ruleLogicalExpression )
            {
            // InternalIvml.g:3491:1: (lv_left_0_0= ruleLogicalExpression )
            // InternalIvml.g:3492:3: lv_left_0_0= ruleLogicalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftLogicalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
            lv_left_0_0=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3508:2: ( (lv_right_1_0= ruleAssignmentExpressionPart ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==19) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalIvml.g:3509:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    {
                    // InternalIvml.g:3509:1: (lv_right_1_0= ruleAssignmentExpressionPart )
                    // InternalIvml.g:3510:3: lv_right_1_0= ruleAssignmentExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightAssignmentExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_1_0=ruleAssignmentExpressionPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      	        }
                             		add(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.AssignmentExpressionPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleAssignmentExpressionPart"
    // InternalIvml.g:3534:1: entryRuleAssignmentExpressionPart returns [EObject current=null] : iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF ;
    public final EObject entryRuleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpressionPart = null;


        try {
            // InternalIvml.g:3535:2: (iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF )
            // InternalIvml.g:3536:2: iv_ruleAssignmentExpressionPart= ruleAssignmentExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpressionPart=ruleAssignmentExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpressionPart"


    // $ANTLR start "ruleAssignmentExpressionPart"
    // InternalIvml.g:3543:1: ruleAssignmentExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleAssignmentExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_container_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3546:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:3547:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:3547:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:3547:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:3547:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // InternalIvml.g:3548:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // InternalIvml.g:3548:1: (lv_op_0_0= ruleAssignmentOperator )
            // InternalIvml.g:3549:3: lv_op_0_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getOpAssignmentOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
            lv_op_0_0=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.AssignmentOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3565:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalIvml.g:3565:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    {
                    // InternalIvml.g:3565:3: ( (lv_ex_1_0= ruleLogicalExpression ) )
                    // InternalIvml.g:3566:1: (lv_ex_1_0= ruleLogicalExpression )
                    {
                    // InternalIvml.g:3566:1: (lv_ex_1_0= ruleLogicalExpression )
                    // InternalIvml.g:3567:3: lv_ex_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getExLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_ex_1_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:3584:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:3584:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:3585:1: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:3585:1: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:3586:3: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentExpressionPartAccess().getContainerContainerInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"container",
                              		lv_container_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpressionPart"


    // $ANTLR start "entryRuleAssignmentOperator"
    // InternalIvml.g:3610:1: entryRuleAssignmentOperator returns [String current=null] : iv_ruleAssignmentOperator= ruleAssignmentOperator EOF ;
    public final String entryRuleAssignmentOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAssignmentOperator = null;


        try {
            // InternalIvml.g:3611:2: (iv_ruleAssignmentOperator= ruleAssignmentOperator EOF )
            // InternalIvml.g:3612:2: iv_ruleAssignmentOperator= ruleAssignmentOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOperator=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // InternalIvml.g:3619:1: ruleAssignmentOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
    public final AntlrDatatypeRuleToken ruleAssignmentOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3622:28: (kw= '=' )
            // InternalIvml.g:3624:2: kw= '='
            {
            kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAssignmentOperatorAccess().getEqualsSignKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "entryRuleImplicationExpression"
    // InternalIvml.g:3637:1: entryRuleImplicationExpression returns [EObject current=null] : iv_ruleImplicationExpression= ruleImplicationExpression EOF ;
    public final EObject entryRuleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpression = null;


        try {
            // InternalIvml.g:3638:2: (iv_ruleImplicationExpression= ruleImplicationExpression EOF )
            // InternalIvml.g:3639:2: iv_ruleImplicationExpression= ruleImplicationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationExpression=ruleImplicationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationExpression"


    // $ANTLR start "ruleImplicationExpression"
    // InternalIvml.g:3646:1: ruleImplicationExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) ;
    public final EObject ruleImplicationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3649:28: ( ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* ) )
            // InternalIvml.g:3650:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            {
            // InternalIvml.g:3650:1: ( ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )* )
            // InternalIvml.g:3650:2: ( (lv_left_0_0= ruleAssignmentExpression ) ) ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            {
            // InternalIvml.g:3650:2: ( (lv_left_0_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3651:1: (lv_left_0_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3651:1: (lv_left_0_0= ruleAssignmentExpression )
            // InternalIvml.g:3652:3: lv_left_0_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getLeftAssignmentExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_48);
            lv_left_0_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.AssignmentExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3668:2: ( (lv_right_1_0= ruleImplicationExpressionPart ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=62 && LA61_0<=63)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalIvml.g:3669:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    {
            	    // InternalIvml.g:3669:1: (lv_right_1_0= ruleImplicationExpressionPart )
            	    // InternalIvml.g:3670:3: lv_right_1_0= ruleImplicationExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplicationExpressionAccess().getRightImplicationExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_right_1_0=ruleImplicationExpressionPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImplicationExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ImplicationExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationExpression"


    // $ANTLR start "entryRuleImplicationExpressionPart"
    // InternalIvml.g:3694:1: entryRuleImplicationExpressionPart returns [EObject current=null] : iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF ;
    public final EObject entryRuleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplicationExpressionPart = null;


        try {
            // InternalIvml.g:3695:2: (iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF )
            // InternalIvml.g:3696:2: iv_ruleImplicationExpressionPart= ruleImplicationExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationExpressionPart=ruleImplicationExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationExpressionPart"


    // $ANTLR start "ruleImplicationExpressionPart"
    // InternalIvml.g:3703:1: ruleImplicationExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) ;
    public final EObject ruleImplicationExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3706:28: ( ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) ) )
            // InternalIvml.g:3707:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            {
            // InternalIvml.g:3707:1: ( ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) ) )
            // InternalIvml.g:3707:2: ( (lv_op_0_0= ruleImplicationOperator ) ) ( (lv_ex_1_0= ruleAssignmentExpression ) )
            {
            // InternalIvml.g:3707:2: ( (lv_op_0_0= ruleImplicationOperator ) )
            // InternalIvml.g:3708:1: (lv_op_0_0= ruleImplicationOperator )
            {
            // InternalIvml.g:3708:1: (lv_op_0_0= ruleImplicationOperator )
            // InternalIvml.g:3709:3: lv_op_0_0= ruleImplicationOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getOpImplicationOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_op_0_0=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.ImplicationOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3725:2: ( (lv_ex_1_0= ruleAssignmentExpression ) )
            // InternalIvml.g:3726:1: (lv_ex_1_0= ruleAssignmentExpression )
            {
            // InternalIvml.g:3726:1: (lv_ex_1_0= ruleAssignmentExpression )
            // InternalIvml.g:3727:3: lv_ex_1_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImplicationExpressionPartAccess().getExAssignmentExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ex_1_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImplicationExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.AssignmentExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationExpressionPart"


    // $ANTLR start "entryRuleImplicationOperator"
    // InternalIvml.g:3751:1: entryRuleImplicationOperator returns [String current=null] : iv_ruleImplicationOperator= ruleImplicationOperator EOF ;
    public final String entryRuleImplicationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplicationOperator = null;


        try {
            // InternalIvml.g:3752:2: (iv_ruleImplicationOperator= ruleImplicationOperator EOF )
            // InternalIvml.g:3753:2: iv_ruleImplicationOperator= ruleImplicationOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplicationOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplicationOperator=ruleImplicationOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplicationOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplicationOperator"


    // $ANTLR start "ruleImplicationOperator"
    // InternalIvml.g:3760:1: ruleImplicationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleImplicationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3763:28: ( (kw= 'implies' | kw= 'iff' ) )
            // InternalIvml.g:3764:1: (kw= 'implies' | kw= 'iff' )
            {
            // InternalIvml.g:3764:1: (kw= 'implies' | kw= 'iff' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==62) ) {
                alt62=1;
            }
            else if ( (LA62_0==63) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalIvml.g:3765:2: kw= 'implies'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getImpliesKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3772:2: kw= 'iff'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getImplicationOperatorAccess().getIffKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplicationOperator"


    // $ANTLR start "entryRuleLogicalExpression"
    // InternalIvml.g:3785:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalIvml.g:3786:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalIvml.g:3787:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // InternalIvml.g:3794:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3797:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalIvml.g:3798:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalIvml.g:3798:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalIvml.g:3798:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalIvml.g:3798:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalIvml.g:3799:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3799:1: (lv_left_0_0= ruleEqualityExpression )
            // InternalIvml.g:3800:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_49);
            lv_left_0_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3816:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=64 && LA63_0<=66)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalIvml.g:3817:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalIvml.g:3817:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalIvml.g:3818:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_49);
            	    lv_right_1_0=ruleLogicalExpressionPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.LogicalExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // InternalIvml.g:3842:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalIvml.g:3843:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalIvml.g:3844:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalExpressionPart"


    // $ANTLR start "ruleLogicalExpressionPart"
    // InternalIvml.g:3851:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3854:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalIvml.g:3855:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalIvml.g:3855:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalIvml.g:3855:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalIvml.g:3855:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalIvml.g:3856:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalIvml.g:3856:1: (lv_op_0_0= ruleLogicalOperator )
            // InternalIvml.g:3857:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_op_0_0=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.LogicalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3873:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalIvml.g:3874:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalIvml.g:3874:1: (lv_ex_1_0= ruleEqualityExpression )
            // InternalIvml.g:3875:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ex_1_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalExpressionPart"


    // $ANTLR start "entryRuleLogicalOperator"
    // InternalIvml.g:3899:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalIvml.g:3900:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalIvml.g:3901:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOperator"


    // $ANTLR start "ruleLogicalOperator"
    // InternalIvml.g:3908:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:3911:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // InternalIvml.g:3912:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // InternalIvml.g:3912:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt64=1;
                }
                break;
            case 65:
                {
                alt64=2;
                }
                break;
            case 66:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalIvml.g:3913:2: kw= 'and'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:3920:2: kw= 'or'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:3927:2: kw= 'xor'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOperator"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalIvml.g:3940:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalIvml.g:3941:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalIvml.g:3942:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalIvml.g:3949:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:3952:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalIvml.g:3953:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalIvml.g:3953:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalIvml.g:3953:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalIvml.g:3953:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalIvml.g:3954:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalIvml.g:3954:1: (lv_left_0_0= ruleRelationalExpression )
            // InternalIvml.g:3955:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_left_0_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:3971:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=67 && LA65_0<=69)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalIvml.g:3972:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalIvml.g:3972:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalIvml.g:3973:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_1_0=ruleEqualityExpressionPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.EqualityExpressionPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleEqualityExpressionPart"
    // InternalIvml.g:3997:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalIvml.g:3998:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalIvml.g:3999:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpressionPart"


    // $ANTLR start "ruleEqualityExpressionPart"
    // InternalIvml.g:4006:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;

        EObject lv_container_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4009:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:4010:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:4010:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:4010:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:4010:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalIvml.g:4011:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalIvml.g:4011:1: (lv_op_0_0= ruleEqualityOperator )
            // InternalIvml.g:4012:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_28);
            lv_op_0_0=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEqualityExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.EqualityOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4028:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // InternalIvml.g:4028:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    {
                    // InternalIvml.g:4028:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
                    // InternalIvml.g:4029:1: (lv_ex_1_0= ruleRelationalExpression )
                    {
                    // InternalIvml.g:4029:1: (lv_ex_1_0= ruleRelationalExpression )
                    // InternalIvml.g:4030:3: lv_ex_1_0= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_ex_1_0=ruleRelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.RelationalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:4047:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:4047:6: ( (lv_container_2_0= ruleContainerInitializer ) )
                    // InternalIvml.g:4048:1: (lv_container_2_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:4048:1: (lv_container_2_0= ruleContainerInitializer )
                    // InternalIvml.g:4049:3: lv_container_2_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getContainerContainerInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_2_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionPartRule());
                      	        }
                             		set(
                             			current, 
                             			"container",
                              		lv_container_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpressionPart"


    // $ANTLR start "entryRuleEqualityOperator"
    // InternalIvml.g:4073:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalIvml.g:4074:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalIvml.g:4075:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityOperator"


    // $ANTLR start "ruleEqualityOperator"
    // InternalIvml.g:4082:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4085:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalIvml.g:4086:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalIvml.g:4086:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt67=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt67=1;
                }
                break;
            case 68:
                {
                alt67=2;
                }
                break;
            case 69:
                {
                alt67=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalIvml.g:4087:2: kw= '=='
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4094:2: kw= '<>'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4101:2: kw= '!='
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getExclamationMarkEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalIvml.g:4114:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalIvml.g:4115:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalIvml.g:4116:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalIvml.g:4123:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4126:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalIvml.g:4127:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalIvml.g:4127:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalIvml.g:4127:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalIvml.g:4127:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4128:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4128:1: (lv_left_0_0= ruleAdditiveExpression )
            // InternalIvml.g:4129:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
            lv_left_0_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4145:2: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=70 && LA69_0<=73)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalIvml.g:4145:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalIvml.g:4145:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalIvml.g:4146:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalIvml.g:4146:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalIvml.g:4147:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
                    lv_right_1_0=ruleRelationalExpressionPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.RelationalExpressionPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:4163:2: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=70 && LA68_0<=73)) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalIvml.g:4164:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalIvml.g:4164:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalIvml.g:4165:3: lv_right2_2_0= ruleRelationalExpressionPart
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRight2RelationalExpressionPartParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_right2_2_0=ruleRelationalExpressionPart();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"right2",
                                      		lv_right2_2_0, 
                                      		"de.uni_hildesheim.sse.Ivml.RelationalExpressionPart");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleRelationalExpressionPart"
    // InternalIvml.g:4189:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalIvml.g:4190:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalIvml.g:4191:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpressionPart"


    // $ANTLR start "ruleRelationalExpressionPart"
    // InternalIvml.g:4198:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4201:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalIvml.g:4202:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalIvml.g:4202:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalIvml.g:4202:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalIvml.g:4202:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalIvml.g:4203:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalIvml.g:4203:1: (lv_op_0_0= ruleRelationalOperator )
            // InternalIvml.g:4204:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_op_0_0=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.RelationalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4220:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalIvml.g:4221:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalIvml.g:4221:1: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalIvml.g:4222:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ex_1_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpressionPart"


    // $ANTLR start "entryRuleRelationalOperator"
    // InternalIvml.g:4246:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalIvml.g:4247:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalIvml.g:4248:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalIvml.g:4255:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4258:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalIvml.g:4259:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalIvml.g:4259:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt70=4;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt70=1;
                }
                break;
            case 71:
                {
                alt70=2;
                }
                break;
            case 72:
                {
                alt70=3;
                }
                break;
            case 73:
                {
                alt70=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalIvml.g:4260:2: kw= '>'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4267:2: kw= '<'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:4274:2: kw= '>='
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalIvml.g:4281:2: kw= '<='
                    {
                    kw=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalIvml.g:4294:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalIvml.g:4295:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalIvml.g:4296:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalIvml.g:4303:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4306:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalIvml.g:4307:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalIvml.g:4307:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalIvml.g:4307:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalIvml.g:4307:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4308:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4308:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4309:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_52);
            lv_left_0_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4325:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=74 && LA71_0<=75)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalIvml.g:4326:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalIvml.g:4326:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalIvml.g:4327:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_52);
            	    lv_right_1_0=ruleAdditiveExpressionPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"right",
            	              		lv_right_1_0, 
            	              		"de.uni_hildesheim.sse.Ivml.AdditiveExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // InternalIvml.g:4351:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalIvml.g:4352:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalIvml.g:4353:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpressionPart"


    // $ANTLR start "ruleAdditiveExpressionPart"
    // InternalIvml.g:4360:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4363:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalIvml.g:4364:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalIvml.g:4364:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalIvml.g:4364:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalIvml.g:4364:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalIvml.g:4365:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalIvml.g:4365:1: (lv_op_0_0= ruleAdditiveOperator )
            // InternalIvml.g:4366:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_op_0_0=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.AdditiveOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4382:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalIvml.g:4383:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalIvml.g:4383:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalIvml.g:4384:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ex_1_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpressionPart"


    // $ANTLR start "entryRuleAdditiveOperator"
    // InternalIvml.g:4408:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalIvml.g:4409:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalIvml.g:4410:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // InternalIvml.g:4417:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4420:28: ( (kw= '+' | kw= '-' ) )
            // InternalIvml.g:4421:1: (kw= '+' | kw= '-' )
            {
            // InternalIvml.g:4421:1: (kw= '+' | kw= '-' )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==74) ) {
                alt72=1;
            }
            else if ( (LA72_0==75) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalIvml.g:4422:2: kw= '+'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4429:2: kw= '-'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalIvml.g:4442:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalIvml.g:4443:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalIvml.g:4444:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalIvml.g:4451:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4454:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalIvml.g:4455:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalIvml.g:4455:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalIvml.g:4455:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalIvml.g:4455:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalIvml.g:4456:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4456:1: (lv_left_0_0= ruleUnaryExpression )
            // InternalIvml.g:4457:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_53);
            lv_left_0_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4473:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==55||LA73_0==76) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalIvml.g:4474:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalIvml.g:4474:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalIvml.g:4475:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_1_0=ruleMultiplicativeExpressionPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.MultiplicativeExpressionPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeExpressionPart"
    // InternalIvml.g:4499:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalIvml.g:4500:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalIvml.g:4501:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpressionPart"


    // $ANTLR start "ruleMultiplicativeExpressionPart"
    // InternalIvml.g:4508:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4511:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalIvml.g:4512:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalIvml.g:4512:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalIvml.g:4512:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalIvml.g:4512:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalIvml.g:4513:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalIvml.g:4513:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalIvml.g:4514:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_op_0_0=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.MultiplicativeOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:4530:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalIvml.g:4531:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalIvml.g:4531:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalIvml.g:4532:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_1_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionPartRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpressionPart"


    // $ANTLR start "entryRuleMultiplicativeOperator"
    // InternalIvml.g:4556:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalIvml.g:4557:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalIvml.g:4558:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // InternalIvml.g:4565:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4568:28: ( (kw= '*' | kw= '/' ) )
            // InternalIvml.g:4569:1: (kw= '*' | kw= '/' )
            {
            // InternalIvml.g:4569:1: (kw= '*' | kw= '/' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==55) ) {
                alt74=1;
            }
            else if ( (LA74_0==76) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalIvml.g:4570:2: kw= '*'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4577:2: kw= '/'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalIvml.g:4590:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalIvml.g:4591:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalIvml.g:4592:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalIvml.g:4599:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4602:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalIvml.g:4603:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalIvml.g:4603:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalIvml.g:4603:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalIvml.g:4603:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalIvml.g:4604:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalIvml.g:4604:1: (lv_op_0_0= ruleUnaryOperator )
                    // InternalIvml.g:4605:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_26);
                    lv_op_0_0=ruleUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:4621:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalIvml.g:4622:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalIvml.g:4622:1: (lv_expr_1_0= rulePostfixExpression )
            // InternalIvml.g:4623:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_1_0=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.PostfixExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalIvml.g:4647:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalIvml.g:4648:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalIvml.g:4649:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalIvml.g:4656:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:4659:28: ( (kw= 'not' | kw= '-' ) )
            // InternalIvml.g:4660:1: (kw= 'not' | kw= '-' )
            {
            // InternalIvml.g:4660:1: (kw= 'not' | kw= '-' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==77) ) {
                alt76=1;
            }
            else if ( (LA76_0==75) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalIvml.g:4661:2: kw= 'not'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:4668:2: kw= '-'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePostfixExpression"
    // InternalIvml.g:4681:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalIvml.g:4682:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalIvml.g:4683:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // InternalIvml.g:4690:1: rulePostfixExpression returns [EObject current=null] : ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_fCalls_1_0 = null;

        EObject lv_access_2_0 = null;

        EObject lv_left_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4693:28: ( ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) ) )
            // InternalIvml.g:4694:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            {
            // InternalIvml.g:4694:1: ( ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? ) | ( (lv_left_3_0= rulePrimaryExpression ) ) )
            int alt79=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==24) ) {
                    alt79=1;
                }
                else if ( (LA79_1==EOF||(LA79_1>=15 && LA79_1<=16)||(LA79_1>=18 && LA79_1<=19)||(LA79_1>=25 && LA79_1<=26)||(LA79_1>=36 && LA79_1<=37)||LA79_1==49||LA79_1==55||(LA79_1>=61 && LA79_1<=76)||(LA79_1>=78 && LA79_1<=80)||(LA79_1>=83 && LA79_1<=85)) ) {
                    alt79=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA79_2 = input.LA(2);

                if ( (LA79_2==EOF||(LA79_2>=15 && LA79_2<=16)||(LA79_2>=18 && LA79_2<=19)||(LA79_2>=25 && LA79_2<=26)||(LA79_2>=36 && LA79_2<=37)||LA79_2==49||LA79_2==55||(LA79_2>=61 && LA79_2<=76)||(LA79_2>=78 && LA79_2<=80)||(LA79_2>=83 && LA79_2<=85)) ) {
                    alt79=2;
                }
                else if ( (LA79_2==24) ) {
                    alt79=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA79_3 = input.LA(2);

                if ( (LA79_3==24) ) {
                    alt79=1;
                }
                else if ( (LA79_3==EOF||(LA79_3>=15 && LA79_3<=16)||(LA79_3>=18 && LA79_3<=19)||(LA79_3>=25 && LA79_3<=26)||(LA79_3>=36 && LA79_3<=37)||LA79_3==49||LA79_3==55||(LA79_3>=61 && LA79_3<=76)||(LA79_3>=78 && LA79_3<=80)||(LA79_3>=83 && LA79_3<=85)) ) {
                    alt79=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 3, input);

                    throw nvae;
                }
                }
                break;
            case 57:
                {
                int LA79_4 = input.LA(2);

                if ( (LA79_4==EOF||(LA79_4>=15 && LA79_4<=16)||(LA79_4>=18 && LA79_4<=19)||(LA79_4>=25 && LA79_4<=26)||(LA79_4>=36 && LA79_4<=37)||LA79_4==49||LA79_4==55||(LA79_4>=61 && LA79_4<=76)||(LA79_4>=78 && LA79_4<=80)||(LA79_4>=83 && LA79_4<=85)) ) {
                    alt79=2;
                }
                else if ( (LA79_4==24) ) {
                    alt79=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 4, input);

                    throw nvae;
                }
                }
                break;
            case 55:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
                {
                alt79=1;
                }
                break;
            case RULE_NUMBER:
            case RULE_STRING:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 81:
            case 82:
                {
                alt79=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // InternalIvml.g:4694:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    {
                    // InternalIvml.g:4694:2: ( ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )? )
                    // InternalIvml.g:4694:3: ( (lv_call_0_0= ruleFeatureCall ) ) ( (lv_fCalls_1_0= ruleCall ) )* ( (lv_access_2_0= ruleExpressionAccess ) )?
                    {
                    // InternalIvml.g:4694:3: ( (lv_call_0_0= ruleFeatureCall ) )
                    // InternalIvml.g:4695:1: (lv_call_0_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4695:1: (lv_call_0_0= ruleFeatureCall )
                    // InternalIvml.g:4696:3: lv_call_0_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getCallFeatureCallParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_54);
                    lv_call_0_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"call",
                              		lv_call_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:4712:2: ( (lv_fCalls_1_0= ruleCall ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==37) ) {
                            switch ( input.LA(2) ) {
                            case RULE_ID:
                                {
                                int LA77_4 = input.LA(3);

                                if ( (LA77_4==24) ) {
                                    alt77=1;
                                }


                                }
                                break;
                            case RULE_VERSION:
                                {
                                int LA77_5 = input.LA(3);

                                if ( (LA77_5==24) ) {
                                    alt77=1;
                                }


                                }
                                break;
                            case RULE_EXPONENT:
                                {
                                int LA77_6 = input.LA(3);

                                if ( (LA77_6==24) ) {
                                    alt77=1;
                                }


                                }
                                break;
                            case 57:
                                {
                                int LA77_7 = input.LA(3);

                                if ( (LA77_7==24) ) {
                                    alt77=1;
                                }


                                }
                                break;
                            case 55:
                            case 62:
                            case 63:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                            case 76:
                            case 77:
                                {
                                alt77=1;
                                }
                                break;

                            }

                        }
                        else if ( ((LA77_0>=78 && LA77_0<=79)) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalIvml.g:4713:1: (lv_fCalls_1_0= ruleCall )
                    	    {
                    	    // InternalIvml.g:4713:1: (lv_fCalls_1_0= ruleCall )
                    	    // InternalIvml.g:4714:3: lv_fCalls_1_0= ruleCall
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getFCallsCallParserRuleCall_0_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_54);
                    	    lv_fCalls_1_0=ruleCall();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"fCalls",
                    	              		lv_fCalls_1_0, 
                    	              		"de.uni_hildesheim.sse.Ivml.Call");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);

                    // InternalIvml.g:4730:3: ( (lv_access_2_0= ruleExpressionAccess ) )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==37) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalIvml.g:4731:1: (lv_access_2_0= ruleExpressionAccess )
                            {
                            // InternalIvml.g:4731:1: (lv_access_2_0= ruleExpressionAccess )
                            // InternalIvml.g:4732:3: lv_access_2_0= ruleExpressionAccess
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getAccessExpressionAccessParserRuleCall_0_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_access_2_0=ruleExpressionAccess();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"access",
                                      		lv_access_2_0, 
                                      		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:4749:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    {
                    // InternalIvml.g:4749:6: ( (lv_left_3_0= rulePrimaryExpression ) )
                    // InternalIvml.g:4750:1: (lv_left_3_0= rulePrimaryExpression )
                    {
                    // InternalIvml.g:4750:1: (lv_left_3_0= rulePrimaryExpression )
                    // InternalIvml.g:4751:3: lv_left_3_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_left_3_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"left",
                              		lv_left_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.PrimaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRuleCall"
    // InternalIvml.g:4775:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalIvml.g:4776:2: (iv_ruleCall= ruleCall EOF )
            // InternalIvml.g:4777:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // InternalIvml.g:4784:1: ruleCall returns [EObject current=null] : ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_call_1_0 = null;

        EObject lv_containerOp_3_0 = null;

        EObject lv_arrayEx_5_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4787:28: ( ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) ) )
            // InternalIvml.g:4788:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            {
            // InternalIvml.g:4788:1: ( (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) ) | (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) ) | (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' ) )
            int alt80=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt80=1;
                }
                break;
            case 78:
                {
                alt80=2;
                }
                break;
            case 79:
                {
                alt80=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalIvml.g:4788:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    {
                    // InternalIvml.g:4788:2: (otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) ) )
                    // InternalIvml.g:4788:4: otherlv_0= '.' ( (lv_call_1_0= ruleFeatureCall ) )
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getFullStopKeyword_0_0());
                          
                    }
                    // InternalIvml.g:4792:1: ( (lv_call_1_0= ruleFeatureCall ) )
                    // InternalIvml.g:4793:1: (lv_call_1_0= ruleFeatureCall )
                    {
                    // InternalIvml.g:4793:1: (lv_call_1_0= ruleFeatureCall )
                    // InternalIvml.g:4794:3: lv_call_1_0= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getCallFeatureCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_call_1_0=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"call",
                              		lv_call_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.FeatureCall");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:4811:6: (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) )
                    {
                    // InternalIvml.g:4811:6: (otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) ) )
                    // InternalIvml.g:4811:8: otherlv_2= '->' ( (lv_containerOp_3_0= ruleContainerOp ) )
                    {
                    otherlv_2=(Token)match(input,78,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // InternalIvml.g:4815:1: ( (lv_containerOp_3_0= ruleContainerOp ) )
                    // InternalIvml.g:4816:1: (lv_containerOp_3_0= ruleContainerOp )
                    {
                    // InternalIvml.g:4816:1: (lv_containerOp_3_0= ruleContainerOp )
                    // InternalIvml.g:4817:3: lv_containerOp_3_0= ruleContainerOp
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getContainerOpContainerOpParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_containerOp_3_0=ruleContainerOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"containerOp",
                              		lv_containerOp_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.ContainerOp");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:4834:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    {
                    // InternalIvml.g:4834:6: (otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // InternalIvml.g:4834:8: otherlv_4= '[' ( (lv_arrayEx_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,79,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getLeftSquareBracketKeyword_2_0());
                          
                    }
                    // InternalIvml.g:4838:1: ( (lv_arrayEx_5_0= ruleExpression ) )
                    // InternalIvml.g:4839:1: (lv_arrayEx_5_0= ruleExpression )
                    {
                    // InternalIvml.g:4839:1: (lv_arrayEx_5_0= ruleExpression )
                    // InternalIvml.g:4840:3: lv_arrayEx_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getArrayExExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_56);
                    lv_arrayEx_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"arrayEx",
                              		lv_arrayEx_5_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCallAccess().getRightSquareBracketKeyword_2_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalIvml.g:4868:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalIvml.g:4869:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalIvml.g:4870:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalIvml.g:4877:1: ruleFeatureCall returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject this_ActualArgumentList_9 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:4880:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' ) )
            // InternalIvml.g:4881:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' )
            {
            // InternalIvml.g:4881:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')' )
            // InternalIvml.g:4881:2: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) ) otherlv_8= '(' (this_ActualArgumentList_9= ruleActualArgumentList[$current] )? otherlv_10= ')'
            {
            // InternalIvml.g:4881:2: ( ( (lv_name_0_0= ruleIdentifier ) ) | ( (lv_name_1_0= ruleRelationalOperator ) ) | ( (lv_name_2_0= ruleAdditiveOperator ) ) | ( (lv_name_3_0= ruleMultiplicativeOperator ) ) | ( (lv_name_4_0= ruleEqualityOperator ) ) | ( (lv_name_5_0= ruleImplicationOperator ) ) | ( (lv_name_6_0= ruleLogicalOperator ) ) | ( (lv_name_7_0= 'not' ) ) )
            int alt81=8;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 57:
                {
                alt81=1;
                }
                break;
            case 70:
            case 71:
            case 72:
            case 73:
                {
                alt81=2;
                }
                break;
            case 74:
            case 75:
                {
                alt81=3;
                }
                break;
            case 55:
            case 76:
                {
                alt81=4;
                }
                break;
            case 67:
            case 68:
            case 69:
                {
                alt81=5;
                }
                break;
            case 62:
            case 63:
                {
                alt81=6;
                }
                break;
            case 64:
            case 65:
            case 66:
                {
                alt81=7;
                }
                break;
            case 77:
                {
                alt81=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalIvml.g:4881:3: ( (lv_name_0_0= ruleIdentifier ) )
                    {
                    // InternalIvml.g:4881:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:4882:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:4882:1: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:4883:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:4900:6: ( (lv_name_1_0= ruleRelationalOperator ) )
                    {
                    // InternalIvml.g:4900:6: ( (lv_name_1_0= ruleRelationalOperator ) )
                    // InternalIvml.g:4901:1: (lv_name_1_0= ruleRelationalOperator )
                    {
                    // InternalIvml.g:4901:1: (lv_name_1_0= ruleRelationalOperator )
                    // InternalIvml.g:4902:3: lv_name_1_0= ruleRelationalOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameRelationalOperatorParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_1_0=ruleRelationalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.RelationalOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:4919:6: ( (lv_name_2_0= ruleAdditiveOperator ) )
                    {
                    // InternalIvml.g:4919:6: ( (lv_name_2_0= ruleAdditiveOperator ) )
                    // InternalIvml.g:4920:1: (lv_name_2_0= ruleAdditiveOperator )
                    {
                    // InternalIvml.g:4920:1: (lv_name_2_0= ruleAdditiveOperator )
                    // InternalIvml.g:4921:3: lv_name_2_0= ruleAdditiveOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameAdditiveOperatorParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_2_0=ruleAdditiveOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.AdditiveOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:4938:6: ( (lv_name_3_0= ruleMultiplicativeOperator ) )
                    {
                    // InternalIvml.g:4938:6: ( (lv_name_3_0= ruleMultiplicativeOperator ) )
                    // InternalIvml.g:4939:1: (lv_name_3_0= ruleMultiplicativeOperator )
                    {
                    // InternalIvml.g:4939:1: (lv_name_3_0= ruleMultiplicativeOperator )
                    // InternalIvml.g:4940:3: lv_name_3_0= ruleMultiplicativeOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameMultiplicativeOperatorParserRuleCall_0_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_3_0=ruleMultiplicativeOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.MultiplicativeOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalIvml.g:4957:6: ( (lv_name_4_0= ruleEqualityOperator ) )
                    {
                    // InternalIvml.g:4957:6: ( (lv_name_4_0= ruleEqualityOperator ) )
                    // InternalIvml.g:4958:1: (lv_name_4_0= ruleEqualityOperator )
                    {
                    // InternalIvml.g:4958:1: (lv_name_4_0= ruleEqualityOperator )
                    // InternalIvml.g:4959:3: lv_name_4_0= ruleEqualityOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameEqualityOperatorParserRuleCall_0_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_4_0=ruleEqualityOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"de.uni_hildesheim.sse.Ivml.EqualityOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalIvml.g:4976:6: ( (lv_name_5_0= ruleImplicationOperator ) )
                    {
                    // InternalIvml.g:4976:6: ( (lv_name_5_0= ruleImplicationOperator ) )
                    // InternalIvml.g:4977:1: (lv_name_5_0= ruleImplicationOperator )
                    {
                    // InternalIvml.g:4977:1: (lv_name_5_0= ruleImplicationOperator )
                    // InternalIvml.g:4978:3: lv_name_5_0= ruleImplicationOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameImplicationOperatorParserRuleCall_0_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_5_0=ruleImplicationOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_5_0, 
                              		"de.uni_hildesheim.sse.Ivml.ImplicationOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalIvml.g:4995:6: ( (lv_name_6_0= ruleLogicalOperator ) )
                    {
                    // InternalIvml.g:4995:6: ( (lv_name_6_0= ruleLogicalOperator ) )
                    // InternalIvml.g:4996:1: (lv_name_6_0= ruleLogicalOperator )
                    {
                    // InternalIvml.g:4996:1: (lv_name_6_0= ruleLogicalOperator )
                    // InternalIvml.g:4997:3: lv_name_6_0= ruleLogicalOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureCallAccess().getNameLogicalOperatorParserRuleCall_0_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_name_6_0=ruleLogicalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_6_0, 
                              		"de.uni_hildesheim.sse.Ivml.LogicalOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalIvml.g:5014:6: ( (lv_name_7_0= 'not' ) )
                    {
                    // InternalIvml.g:5014:6: ( (lv_name_7_0= 'not' ) )
                    // InternalIvml.g:5015:1: (lv_name_7_0= 'not' )
                    {
                    // InternalIvml.g:5015:1: (lv_name_7_0= 'not' )
                    // InternalIvml.g:5016:3: lv_name_7_0= 'not'
                    {
                    lv_name_7_0=(Token)match(input,77,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_name_7_0, grammarAccess.getFeatureCallAccess().getNameNotKeyword_0_7_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureCallRule());
                      	        }
                             		setWithLastConsumed(current, "name", lv_name_7_0, "not");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,24,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:5033:1: (this_ActualArgumentList_9= ruleActualArgumentList[$current] )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_NUMBER && LA82_0<=RULE_EXPONENT)||LA82_0==14||LA82_0==24||(LA82_0>=30 && LA82_0<=35)||(LA82_0>=38 && LA82_0<=44)||LA82_0==55||LA82_0==57||LA82_0==60||(LA82_0>=62 && LA82_0<=77)||(LA82_0>=81 && LA82_0<=82)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalIvml.g:5034:2: this_ActualArgumentList_9= ruleActualArgumentList[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getFeatureCallRule());
                      		}
                              newCompositeNode(grammarAccess.getFeatureCallAccess().getActualArgumentListParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_29);
                    this_ActualArgumentList_9=ruleActualArgumentList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ActualArgumentList_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleContainerOp"
    // InternalIvml.g:5060:1: entryRuleContainerOp returns [EObject current=null] : iv_ruleContainerOp= ruleContainerOp EOF ;
    public final EObject entryRuleContainerOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerOp = null;


        try {
            // InternalIvml.g:5061:2: (iv_ruleContainerOp= ruleContainerOp EOF )
            // InternalIvml.g:5062:2: iv_ruleContainerOp= ruleContainerOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainerOp=ruleContainerOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainerOp"


    // $ANTLR start "ruleContainerOp"
    // InternalIvml.g:5069:1: ruleContainerOp returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' ) ;
    public final EObject ruleContainerOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject this_ActualArgumentList_3 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5072:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' ) )
            // InternalIvml.g:5073:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' )
            {
            // InternalIvml.g:5073:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')' )
            // InternalIvml.g:5073:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? (this_ActualArgumentList_3= ruleActualArgumentList[$current] )? otherlv_4= ')'
            {
            // InternalIvml.g:5073:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalIvml.g:5074:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalIvml.g:5074:1: (lv_name_0_0= ruleIdentifier )
            // InternalIvml.g:5075:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainerOpAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainerOpRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerOpAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalIvml.g:5095:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalIvml.g:5096:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalIvml.g:5096:1: (lv_decl_2_0= ruleDeclarator )
                    // InternalIvml.g:5097:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_57);
                    lv_decl_2_0=ruleDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerOpRule());
                      	        }
                             		set(
                             			current, 
                             			"decl",
                              		lv_decl_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.Declarator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:5113:3: (this_ActualArgumentList_3= ruleActualArgumentList[$current] )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=RULE_NUMBER && LA84_0<=RULE_EXPONENT)||LA84_0==14||LA84_0==24||(LA84_0>=30 && LA84_0<=35)||(LA84_0>=38 && LA84_0<=44)||LA84_0==55||LA84_0==57||LA84_0==60||(LA84_0>=62 && LA84_0<=77)||(LA84_0>=81 && LA84_0<=82)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalIvml.g:5114:2: this_ActualArgumentList_3= ruleActualArgumentList[$current]
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                      		if (current==null) {
                      			current = createModelElement(grammarAccess.getContainerOpRule());
                      		}
                              newCompositeNode(grammarAccess.getContainerOpAccess().getActualArgumentListParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_29);
                    this_ActualArgumentList_3=ruleActualArgumentList(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ActualArgumentList_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getContainerOpAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainerOp"


    // $ANTLR start "entryRuleDeclarator"
    // InternalIvml.g:5140:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalIvml.g:5141:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalIvml.g:5142:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarator"


    // $ANTLR start "ruleDeclarator"
    // InternalIvml.g:5149:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5152:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalIvml.g:5153:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalIvml.g:5153:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalIvml.g:5153:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalIvml.g:5153:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalIvml.g:5154:1: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalIvml.g:5154:1: (lv_decl_0_0= ruleDeclaration )
            // InternalIvml.g:5155:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_58);
            lv_decl_0_0=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclaratorRule());
              	        }
                     		add(
                     			current, 
                     			"decl",
                      		lv_decl_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Declaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5171:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==16) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalIvml.g:5171:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,16,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5175:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalIvml.g:5176:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalIvml.g:5176:1: (lv_decl_2_0= ruleDeclaration )
            	    // InternalIvml.g:5177:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_58);
            	    lv_decl_2_0=ruleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclaratorRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"decl",
            	              		lv_decl_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDeclaratorAccess().getVerticalLineKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarator"


    // $ANTLR start "entryRuleDeclaration"
    // InternalIvml.g:5205:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalIvml.g:5206:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalIvml.g:5207:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalIvml.g:5214:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5217:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? ) )
            // InternalIvml.g:5218:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            {
            // InternalIvml.g:5218:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )? )
            // InternalIvml.g:5218:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            {
            // InternalIvml.g:5218:2: ( (lv_type_0_0= ruleType ) )?
            int alt86=2;
            switch ( input.LA(1) ) {
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 42:
                case 43:
                case 44:
                    {
                    alt86=1;
                    }
                    break;
                case RULE_ID:
                    {
                    int LA86_2 = input.LA(2);

                    if ( ((LA86_2>=RULE_VERSION && LA86_2<=RULE_EXPONENT)||LA86_2==36||LA86_2==57) ) {
                        alt86=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA86_3 = input.LA(2);

                    if ( ((LA86_3>=RULE_VERSION && LA86_3<=RULE_EXPONENT)||LA86_3==36||LA86_3==57) ) {
                        alt86=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA86_4 = input.LA(2);

                    if ( ((LA86_4>=RULE_VERSION && LA86_4<=RULE_EXPONENT)||LA86_4==36||LA86_4==57) ) {
                        alt86=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA86_5 = input.LA(2);

                    if ( ((LA86_5>=RULE_VERSION && LA86_5<=RULE_EXPONENT)||LA86_5==36||LA86_5==57) ) {
                        alt86=1;
                    }
                    }
                    break;
            }

            switch (alt86) {
                case 1 :
                    // InternalIvml.g:5219:1: (lv_type_0_0= ruleType )
                    {
                    // InternalIvml.g:5219:1: (lv_type_0_0= ruleType )
                    // InternalIvml.g:5220:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_4);
                    lv_type_0_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:5236:3: ( (lv_id_1_0= ruleIdentifier ) )
            // InternalIvml.g:5237:1: (lv_id_1_0= ruleIdentifier )
            {
            // InternalIvml.g:5237:1: (lv_id_1_0= ruleIdentifier )
            // InternalIvml.g:5238:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
            lv_id_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"id",
                      		lv_id_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5254:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==18) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // InternalIvml.g:5254:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalIvml.g:5258:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // InternalIvml.g:5259:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // InternalIvml.g:5259:1: (lv_id_3_0= ruleIdentifier )
            	    // InternalIvml.g:5260:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_id_3_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"id",
            	              		lv_id_3_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            // InternalIvml.g:5276:4: (otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==19) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalIvml.g:5276:6: otherlv_4= '=' ( (lv_init_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalIvml.g:5280:1: ( (lv_init_5_0= ruleExpression ) )
                    // InternalIvml.g:5281:1: (lv_init_5_0= ruleExpression )
                    {
                    // InternalIvml.g:5281:1: (lv_init_5_0= ruleExpression )
                    // InternalIvml.g:5282:3: lv_init_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getInitExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_init_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_5_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "ruleActualArgumentList"
    // InternalIvml.g:5307:1: ruleActualArgumentList[EObject in_current] returns [EObject current=in_current] : ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* ) ;
    public final EObject ruleActualArgumentList(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_args_0_0 = null;

        EObject lv_args_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5310:28: ( ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* ) )
            // InternalIvml.g:5311:1: ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* )
            {
            // InternalIvml.g:5311:1: ( ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )* )
            // InternalIvml.g:5311:2: ( (lv_args_0_0= ruleActualArgument ) ) (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )*
            {
            // InternalIvml.g:5311:2: ( (lv_args_0_0= ruleActualArgument ) )
            // InternalIvml.g:5312:1: (lv_args_0_0= ruleActualArgument )
            {
            // InternalIvml.g:5312:1: (lv_args_0_0= ruleActualArgument )
            // InternalIvml.g:5313:3: lv_args_0_0= ruleActualArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualArgumentListAccess().getArgsActualArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
            lv_args_0_0=ruleActualArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualArgumentListRule());
              	        }
                     		add(
                     			current, 
                     			"args",
                      		lv_args_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.ActualArgument");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5329:2: (otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==18) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // InternalIvml.g:5329:4: otherlv_1= ',' ( (lv_args_2_0= ruleActualArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getActualArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5333:1: ( (lv_args_2_0= ruleActualArgument ) )
            	    // InternalIvml.g:5334:1: (lv_args_2_0= ruleActualArgument )
            	    {
            	    // InternalIvml.g:5334:1: (lv_args_2_0= ruleActualArgument )
            	    // InternalIvml.g:5335:3: lv_args_2_0= ruleActualArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualArgumentListAccess().getArgsActualArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_46);
            	    lv_args_2_0=ruleActualArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualArgumentListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"args",
            	              		lv_args_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ActualArgument");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActualArgumentList"


    // $ANTLR start "entryRuleActualArgument"
    // InternalIvml.g:5359:1: entryRuleActualArgument returns [EObject current=null] : iv_ruleActualArgument= ruleActualArgument EOF ;
    public final EObject entryRuleActualArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualArgument = null;


        try {
            // InternalIvml.g:5360:2: (iv_ruleActualArgument= ruleActualArgument EOF )
            // InternalIvml.g:5361:2: iv_ruleActualArgument= ruleActualArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleActualArgument=ruleActualArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActualArgument"


    // $ANTLR start "ruleActualArgument"
    // InternalIvml.g:5368:1: ruleActualArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) ) ;
    public final EObject ruleActualArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_arg_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5371:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) ) )
            // InternalIvml.g:5372:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) )
            {
            // InternalIvml.g:5372:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) ) )
            // InternalIvml.g:5372:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_arg_2_0= ruleExpression ) )
            {
            // InternalIvml.g:5372:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt90=2;
            alt90 = dfa90.predict(input);
            switch (alt90) {
                case 1 :
                    // InternalIvml.g:5372:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalIvml.g:5372:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5373:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5373:1: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5374:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getActualArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_25);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getActualArgumentRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getActualArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // InternalIvml.g:5394:3: ( (lv_arg_2_0= ruleExpression ) )
            // InternalIvml.g:5395:1: (lv_arg_2_0= ruleExpression )
            {
            // InternalIvml.g:5395:1: (lv_arg_2_0= ruleExpression )
            // InternalIvml.g:5396:3: lv_arg_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualArgumentAccess().getArgExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_arg_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualArgumentRule());
              	        }
                     		set(
                     			current, 
                     			"arg",
                      		lv_arg_2_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActualArgument"


    // $ANTLR start "entryRuleExpressionAccess"
    // InternalIvml.g:5420:1: entryRuleExpressionAccess returns [EObject current=null] : iv_ruleExpressionAccess= ruleExpressionAccess EOF ;
    public final EObject entryRuleExpressionAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionAccess = null;


        try {
            // InternalIvml.g:5421:2: (iv_ruleExpressionAccess= ruleExpressionAccess EOF )
            // InternalIvml.g:5422:2: iv_ruleExpressionAccess= ruleExpressionAccess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionAccessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionAccess=ruleExpressionAccess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionAccess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionAccess"


    // $ANTLR start "ruleExpressionAccess"
    // InternalIvml.g:5429:1: ruleExpressionAccess returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) ;
    public final EObject ruleExpressionAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_calls_2_0 = null;

        EObject lv_access_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5432:28: ( (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5433:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5433:1: (otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5433:3: otherlv_0= '.' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_calls_2_0= ruleCall ) )* ( (lv_access_3_0= ruleExpressionAccess ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExpressionAccessAccess().getFullStopKeyword_0());
                  
            }
            // InternalIvml.g:5437:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalIvml.g:5438:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalIvml.g:5438:1: (lv_name_1_0= ruleIdentifier )
            // InternalIvml.g:5439:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_54);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5455:2: ( (lv_calls_2_0= ruleCall ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA91_4 = input.LA(3);

                        if ( (LA91_4==24) ) {
                            alt91=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA91_5 = input.LA(3);

                        if ( (LA91_5==24) ) {
                            alt91=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA91_6 = input.LA(3);

                        if ( (LA91_6==24) ) {
                            alt91=1;
                        }


                        }
                        break;
                    case 57:
                        {
                        int LA91_7 = input.LA(3);

                        if ( (LA91_7==24) ) {
                            alt91=1;
                        }


                        }
                        break;
                    case 55:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        {
                        alt91=1;
                        }
                        break;

                    }

                }
                else if ( ((LA91_0>=78 && LA91_0<=79)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalIvml.g:5456:1: (lv_calls_2_0= ruleCall )
            	    {
            	    // InternalIvml.g:5456:1: (lv_calls_2_0= ruleCall )
            	    // InternalIvml.g:5457:3: lv_calls_2_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getCallsCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_calls_2_0=ruleCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);

            // InternalIvml.g:5473:3: ( (lv_access_3_0= ruleExpressionAccess ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==37) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalIvml.g:5474:1: (lv_access_3_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5474:1: (lv_access_3_0= ruleExpressionAccess )
                    // InternalIvml.g:5475:3: lv_access_3_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccessAccess().getAccessExpressionAccessParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_access_3_0=ruleExpressionAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionAccessRule());
                      	        }
                             		set(
                             			current, 
                             			"access",
                              		lv_access_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionAccess"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalIvml.g:5499:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalIvml.g:5500:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalIvml.g:5501:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalIvml.g:5508:1: rulePrimaryExpression returns [EObject current=null] : ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_lit_0_0 = null;

        EObject lv_ex_2_0 = null;

        EObject lv_ifEx_4_0 = null;

        EObject lv_refEx_7_0 = null;

        EObject lv_calls_9_0 = null;

        EObject lv_access_10_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5511:28: ( ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? ) )
            // InternalIvml.g:5512:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            {
            // InternalIvml.g:5512:1: ( ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )? )
            // InternalIvml.g:5512:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) ) ( (lv_calls_9_0= ruleCall ) )* ( (lv_access_10_0= ruleExpressionAccess ) )?
            {
            // InternalIvml.g:5512:2: ( ( (lv_lit_0_0= ruleLiteral ) ) | (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' ) | ( (lv_ifEx_4_0= ruleIfExpression ) ) | (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' ) )
            int alt93=4;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case RULE_STRING:
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 57:
                {
                alt93=1;
                }
                break;
            case 24:
                {
                alt93=2;
                }
                break;
            case 82:
                {
                alt93=3;
                }
                break;
            case 81:
                {
                alt93=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalIvml.g:5512:3: ( (lv_lit_0_0= ruleLiteral ) )
                    {
                    // InternalIvml.g:5512:3: ( (lv_lit_0_0= ruleLiteral ) )
                    // InternalIvml.g:5513:1: (lv_lit_0_0= ruleLiteral )
                    {
                    // InternalIvml.g:5513:1: (lv_lit_0_0= ruleLiteral )
                    // InternalIvml.g:5514:3: lv_lit_0_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLitLiteralParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_54);
                    lv_lit_0_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"lit",
                              		lv_lit_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Literal");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:5531:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalIvml.g:5531:6: (otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalIvml.g:5531:8: otherlv_1= '(' ( (lv_ex_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // InternalIvml.g:5535:1: ( (lv_ex_2_0= ruleExpression ) )
                    // InternalIvml.g:5536:1: (lv_ex_2_0= ruleExpression )
                    {
                    // InternalIvml.g:5536:1: (lv_ex_2_0= ruleExpression )
                    // InternalIvml.g:5537:3: lv_ex_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_29);
                    lv_ex_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"ex",
                              		lv_ex_2_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalIvml.g:5558:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    {
                    // InternalIvml.g:5558:6: ( (lv_ifEx_4_0= ruleIfExpression ) )
                    // InternalIvml.g:5559:1: (lv_ifEx_4_0= ruleIfExpression )
                    {
                    // InternalIvml.g:5559:1: (lv_ifEx_4_0= ruleIfExpression )
                    // InternalIvml.g:5560:3: lv_ifEx_4_0= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIfExIfExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_54);
                    lv_ifEx_4_0=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"ifEx",
                              		lv_ifEx_4_0, 
                              		"de.uni_hildesheim.sse.Ivml.IfExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalIvml.g:5577:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    {
                    // InternalIvml.g:5577:6: (otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')' )
                    // InternalIvml.g:5577:8: otherlv_5= 'refBy' otherlv_6= '(' ( (lv_refEx_7_0= ruleExpression ) ) otherlv_8= ')'
                    {
                    otherlv_5=(Token)match(input,81,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPrimaryExpressionAccess().getRefByKeyword_0_3_0());
                          
                    }
                    otherlv_6=(Token)match(input,24,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_3_1());
                          
                    }
                    // InternalIvml.g:5585:1: ( (lv_refEx_7_0= ruleExpression ) )
                    // InternalIvml.g:5586:1: (lv_refEx_7_0= ruleExpression )
                    {
                    // InternalIvml.g:5586:1: (lv_refEx_7_0= ruleExpression )
                    // InternalIvml.g:5587:3: lv_refEx_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRefExExpressionParserRuleCall_0_3_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_29);
                    lv_refEx_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"refEx",
                              		lv_refEx_7_0, 
                              		"de.uni_hildesheim.sse.Ivml.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_8=(Token)match(input,25,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_3_3());
                          
                    }

                    }


                    }
                    break;

            }

            // InternalIvml.g:5607:3: ( (lv_calls_9_0= ruleCall ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA94_4 = input.LA(3);

                        if ( (LA94_4==24) ) {
                            alt94=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA94_5 = input.LA(3);

                        if ( (LA94_5==24) ) {
                            alt94=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA94_6 = input.LA(3);

                        if ( (LA94_6==24) ) {
                            alt94=1;
                        }


                        }
                        break;
                    case 57:
                        {
                        int LA94_7 = input.LA(3);

                        if ( (LA94_7==24) ) {
                            alt94=1;
                        }


                        }
                        break;
                    case 55:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        {
                        alt94=1;
                        }
                        break;

                    }

                }
                else if ( ((LA94_0>=78 && LA94_0<=79)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalIvml.g:5608:1: (lv_calls_9_0= ruleCall )
            	    {
            	    // InternalIvml.g:5608:1: (lv_calls_9_0= ruleCall )
            	    // InternalIvml.g:5609:3: lv_calls_9_0= ruleCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getCallsCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_calls_9_0=ruleCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_9_0, 
            	              		"de.uni_hildesheim.sse.Ivml.Call");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);

            // InternalIvml.g:5625:3: ( (lv_access_10_0= ruleExpressionAccess ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==37) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalIvml.g:5626:1: (lv_access_10_0= ruleExpressionAccess )
                    {
                    // InternalIvml.g:5626:1: (lv_access_10_0= ruleExpressionAccess )
                    // InternalIvml.g:5627:3: lv_access_10_0= ruleExpressionAccess
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAccessExpressionAccessParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_access_10_0=ruleExpressionAccess();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"access",
                              		lv_access_10_0, 
                              		"de.uni_hildesheim.sse.Ivml.ExpressionAccess");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleContainerInitializer"
    // InternalIvml.g:5651:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalIvml.g:5652:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalIvml.g:5653:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainerInitializer"


    // $ANTLR start "ruleContainerInitializer"
    // InternalIvml.g:5660:1: ruleContainerInitializer returns [EObject current=null] : ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_init_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5663:28: ( ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' ) )
            // InternalIvml.g:5664:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            {
            // InternalIvml.g:5664:1: ( () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}' )
            // InternalIvml.g:5664:2: () ( (lv_type_1_0= ruleQualifiedName ) )? otherlv_2= '{' ( (lv_init_3_0= ruleExpressionListOrRange ) )? otherlv_4= '}'
            {
            // InternalIvml.g:5664:2: ()
            // InternalIvml.g:5665:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getContainerInitializerAccess().getContainerInitializerAction_0(),
                          current);
                  
            }

            }

            // InternalIvml.g:5673:2: ( (lv_type_1_0= ruleQualifiedName ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_VERSION && LA96_0<=RULE_EXPONENT)||LA96_0==57) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalIvml.g:5674:1: (lv_type_1_0= ruleQualifiedName )
                    {
                    // InternalIvml.g:5674:1: (lv_type_1_0= ruleQualifiedName )
                    // InternalIvml.g:5675:3: lv_type_1_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getTypeQualifiedNameParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_5);
                    lv_type_1_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_1_0, 
                              		"de.uni_hildesheim.sse.Ivml.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,14,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // InternalIvml.g:5695:1: ( (lv_init_3_0= ruleExpressionListOrRange ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( ((LA97_0>=RULE_NUMBER && LA97_0<=RULE_EXPONENT)||LA97_0==14||LA97_0==24||(LA97_0>=30 && LA97_0<=35)||(LA97_0>=38 && LA97_0<=44)||LA97_0==55||LA97_0==57||(LA97_0>=62 && LA97_0<=77)||(LA97_0>=81 && LA97_0<=82)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // InternalIvml.g:5696:1: (lv_init_3_0= ruleExpressionListOrRange )
                    {
                    // InternalIvml.g:5696:1: (lv_init_3_0= ruleExpressionListOrRange )
                    // InternalIvml.g:5697:3: lv_init_3_0= ruleExpressionListOrRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getInitExpressionListOrRangeParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_9);
                    lv_init_3_0=ruleExpressionListOrRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_3_0, 
                              		"de.uni_hildesheim.sse.Ivml.ExpressionListOrRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getContainerInitializerAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainerInitializer"


    // $ANTLR start "entryRuleExpressionListOrRange"
    // InternalIvml.g:5725:1: entryRuleExpressionListOrRange returns [EObject current=null] : iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF ;
    public final EObject entryRuleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListOrRange = null;


        try {
            // InternalIvml.g:5726:2: (iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF )
            // InternalIvml.g:5727:2: iv_ruleExpressionListOrRange= ruleExpressionListOrRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListOrRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionListOrRange=ruleExpressionListOrRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListOrRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionListOrRange"


    // $ANTLR start "ruleExpressionListOrRange"
    // InternalIvml.g:5734:1: ruleExpressionListOrRange returns [EObject current=null] : ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) ;
    public final EObject ruleExpressionListOrRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_list_0_0 = null;

        EObject lv_list_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5737:28: ( ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* ) )
            // InternalIvml.g:5738:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            {
            // InternalIvml.g:5738:1: ( ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )* )
            // InternalIvml.g:5738:2: ( (lv_list_0_0= ruleExpressionListEntry ) ) (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            {
            // InternalIvml.g:5738:2: ( (lv_list_0_0= ruleExpressionListEntry ) )
            // InternalIvml.g:5739:1: (lv_list_0_0= ruleExpressionListEntry )
            {
            // InternalIvml.g:5739:1: (lv_list_0_0= ruleExpressionListEntry )
            // InternalIvml.g:5740:3: lv_list_0_0= ruleExpressionListEntry
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
            lv_list_0_0=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
              	        }
                     		add(
                     			current, 
                     			"list",
                      		lv_list_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.ExpressionListEntry");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalIvml.g:5756:2: (otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==18) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalIvml.g:5756:4: otherlv_1= ',' ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getExpressionListOrRangeAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalIvml.g:5760:1: ( (lv_list_2_0= ruleExpressionListEntry ) )
            	    // InternalIvml.g:5761:1: (lv_list_2_0= ruleExpressionListEntry )
            	    {
            	    // InternalIvml.g:5761:1: (lv_list_2_0= ruleExpressionListEntry )
            	    // InternalIvml.g:5762:3: lv_list_2_0= ruleExpressionListEntry
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionListOrRangeAccess().getListExpressionListEntryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_46);
            	    lv_list_2_0=ruleExpressionListEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionListOrRangeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"list",
            	              		lv_list_2_0, 
            	              		"de.uni_hildesheim.sse.Ivml.ExpressionListEntry");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionListOrRange"


    // $ANTLR start "entryRuleExpressionListEntry"
    // InternalIvml.g:5786:1: entryRuleExpressionListEntry returns [EObject current=null] : iv_ruleExpressionListEntry= ruleExpressionListEntry EOF ;
    public final EObject entryRuleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionListEntry = null;


        try {
            // InternalIvml.g:5787:2: (iv_ruleExpressionListEntry= ruleExpressionListEntry EOF )
            // InternalIvml.g:5788:2: iv_ruleExpressionListEntry= ruleExpressionListEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionListEntry=ruleExpressionListEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionListEntry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionListEntry"


    // $ANTLR start "ruleExpressionListEntry"
    // InternalIvml.g:5795:1: ruleExpressionListEntry returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) ) ;
    public final EObject ruleExpressionListEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_container_5_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5798:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) ) )
            // InternalIvml.g:5799:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) )
            {
            // InternalIvml.g:5799:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) ) )
            // InternalIvml.g:5799:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )
            {
            // InternalIvml.g:5799:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt100=2;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // InternalIvml.g:5799:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // InternalIvml.g:5799:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalIvml.g:5800:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalIvml.g:5800:1: (lv_name_0_0= ruleIdentifier )
                    // InternalIvml.g:5801:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_60);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"de.uni_hildesheim.sse.Ivml.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalIvml.g:5817:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==37) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalIvml.g:5817:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,37,FOLLOW_4); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionListEntryAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // InternalIvml.g:5821:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                            // InternalIvml.g:5822:1: (lv_attrib_2_0= ruleIdentifier )
                            {
                            // InternalIvml.g:5822:1: (lv_attrib_2_0= ruleIdentifier )
                            // InternalIvml.g:5823:3: lv_attrib_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_25);
                            lv_attrib_2_0=ruleIdentifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"attrib",
                                      		lv_attrib_2_0, 
                                      		"de.uni_hildesheim.sse.Ivml.Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionListEntryAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // InternalIvml.g:5843:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )
            int alt101=2;
            alt101 = dfa101.predict(input);
            switch (alt101) {
                case 1 :
                    // InternalIvml.g:5843:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    {
                    // InternalIvml.g:5843:4: ( (lv_value_4_0= ruleImplicationExpression ) )
                    // InternalIvml.g:5844:1: (lv_value_4_0= ruleImplicationExpression )
                    {
                    // InternalIvml.g:5844:1: (lv_value_4_0= ruleImplicationExpression )
                    // InternalIvml.g:5845:3: lv_value_4_0= ruleImplicationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getValueImplicationExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleImplicationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"de.uni_hildesheim.sse.Ivml.ImplicationExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIvml.g:5862:6: ( (lv_container_5_0= ruleContainerInitializer ) )
                    {
                    // InternalIvml.g:5862:6: ( (lv_container_5_0= ruleContainerInitializer ) )
                    // InternalIvml.g:5863:1: (lv_container_5_0= ruleContainerInitializer )
                    {
                    // InternalIvml.g:5863:1: (lv_container_5_0= ruleContainerInitializer )
                    // InternalIvml.g:5864:3: lv_container_5_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getContainerContainerInitializerParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_5_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListEntryRule());
                      	        }
                             		set(
                             			current, 
                             			"container",
                              		lv_container_5_0, 
                              		"de.uni_hildesheim.sse.Ivml.ContainerInitializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionListEntry"


    // $ANTLR start "entryRuleLiteral"
    // InternalIvml.g:5888:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalIvml.g:5889:2: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalIvml.g:5890:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalIvml.g:5897:1: ruleLiteral returns [EObject current=null] : ( (lv_val_0_0= ruleValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject lv_val_0_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5900:28: ( ( (lv_val_0_0= ruleValue ) ) )
            // InternalIvml.g:5901:1: ( (lv_val_0_0= ruleValue ) )
            {
            // InternalIvml.g:5901:1: ( (lv_val_0_0= ruleValue ) )
            // InternalIvml.g:5902:1: (lv_val_0_0= ruleValue )
            {
            // InternalIvml.g:5902:1: (lv_val_0_0= ruleValue )
            // InternalIvml.g:5903:3: lv_val_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralAccess().getValValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_val_0_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLiteralRule());
              	        }
                     		set(
                     			current, 
                     			"val",
                      		lv_val_0_0, 
                      		"de.uni_hildesheim.sse.Ivml.Value");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleIfExpression"
    // InternalIvml.g:5927:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalIvml.g:5928:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalIvml.g:5929:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalIvml.g:5936:1: ruleIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ifEx_1_0 = null;

        EObject lv_thenEx_3_0 = null;

        EObject lv_elseEx_5_0 = null;


         enterRule(); 
            
        try {
            // InternalIvml.g:5939:28: ( (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' ) )
            // InternalIvml.g:5940:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            {
            // InternalIvml.g:5940:1: (otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif' )
            // InternalIvml.g:5940:3: otherlv_0= 'if' ( (lv_ifEx_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_thenEx_3_0= ruleOptBlockExpression ) ) otherlv_4= 'else' ( (lv_elseEx_5_0= ruleOptBlockExpression ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpressionAccess().getIfKeyword_0());
                  
            }
            // InternalIvml.g:5944:1: ( (lv_ifEx_1_0= ruleExpression ) )
            // InternalIvml.g:5945:1: (lv_ifEx_1_0= ruleExpression )
            {
            // InternalIvml.g:5945:1: (lv_ifEx_1_0= ruleExpression )
            // InternalIvml.g:5946:3: lv_ifEx_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getIfExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_61);
            lv_ifEx_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"ifEx",
                      		lv_ifEx_1_0, 
                      		"de.uni_hildesheim.sse.Ivml.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,83,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getThenKeyword_2());
                  
            }
            // InternalIvml.g:5966:1: ( (lv_thenEx_3_0= ruleOptBlockExpression ) )
            // InternalIvml.g:5967:1: (lv_thenEx_3_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:5967:1: (lv_thenEx_3_0= ruleOptBlockExpression )
            // InternalIvml.g:5968:3: lv_thenEx_3_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExOptBlockExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_62);
            lv_thenEx_3_0=ruleOptBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"thenEx",
                      		lv_thenEx_3_0, 
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,84,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getElseKeyword_4());
                  
            }
            // InternalIvml.g:5988:1: ( (lv_elseEx_5_0= ruleOptBlockExpression ) )
            // InternalIvml.g:5989:1: (lv_elseEx_5_0= ruleOptBlockExpression )
            {
            // InternalIvml.g:5989:1: (lv_elseEx_5_0= ruleOptBlockExpression )
            // InternalIvml.g:5990:3: lv_elseEx_5_0= ruleOptBlockExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExOptBlockExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_63);
            lv_elseEx_5_0=ruleOptBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"elseEx",
                      		lv_elseEx_5_0, 
                      		"de.uni_hildesheim.sse.Ivml.OptBlockExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIfExpressionAccess().getEndifKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleIdentifier"
    // InternalIvml.g:6018:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalIvml.g:6019:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalIvml.g:6020:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalIvml.g:6027:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalIvml.g:6030:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalIvml.g:6031:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalIvml.g:6031:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt102=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt102=1;
                }
                break;
            case RULE_VERSION:
                {
                alt102=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt102=3;
                }
                break;
            case 57:
                {
                alt102=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalIvml.g:6031:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalIvml.g:6039:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalIvml.g:6047:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalIvml.g:6056:2: kw= 'version'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIdentifierAccess().getVersionKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"

    // $ANTLR start synpred2_InternalIvml
    public final void synpred2_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_version_3_0 = null;


        // InternalIvml.g:161:1: ( (lv_version_3_0= ruleVersionStmt ) )
        // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        {
        // InternalIvml.g:161:1: (lv_version_3_0= ruleVersionStmt )
        // InternalIvml.g:162:3: lv_version_3_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getProjectAccess().getVersionVersionStmtParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_version_3_0=ruleVersionStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalIvml

    // $ANTLR start synpred8_InternalIvml
    public final void synpred8_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_2_0 = null;


        // InternalIvml.g:307:6: ( ( (lv_elements_2_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:307:6: ( (lv_elements_2_0= ruleVariableDeclaration ) )
        // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:308:1: (lv_elements_2_0= ruleVariableDeclaration )
        // InternalIvml.g:309:3: lv_elements_2_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsVariableDeclarationParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_2_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred8_InternalIvml

    // $ANTLR start synpred11_InternalIvml
    public final void synpred11_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_5_0 = null;


        // InternalIvml.g:364:6: ( ( (lv_elements_5_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:364:6: ( (lv_elements_5_0= ruleExpressionStatement ) )
        // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
        {
        // InternalIvml.g:365:1: (lv_elements_5_0= ruleExpressionStatement )
        // InternalIvml.g:366:3: lv_elements_5_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getProjectContentsAccess().getElementsExpressionStatementParserRuleCall_1_4_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_5_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred11_InternalIvml

    // $ANTLR start synpred23_InternalIvml
    public final void synpred23_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_8_0 = null;


        // InternalIvml.g:796:2: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:796:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:796:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        // InternalIvml.g:797:1: (lv_elements_8_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:797:1: (lv_elements_8_0= ruleVariableDeclaration )
        // InternalIvml.g:798:3: lv_elements_8_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsVariableDeclarationParserRuleCall_5_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_8_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred23_InternalIvml

    // $ANTLR start synpred24_InternalIvml
    public final void synpred24_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_9_0 = null;


        // InternalIvml.g:815:6: ( ( (lv_elements_9_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:815:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:815:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
        // InternalIvml.g:816:1: (lv_elements_9_0= ruleExpressionStatement )
        {
        // InternalIvml.g:816:1: (lv_elements_9_0= ruleExpressionStatement )
        // InternalIvml.g:817:3: lv_elements_9_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTypedefCompoundAccess().getElementsExpressionStatementParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_9_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalIvml

    // $ANTLR start synpred29_InternalIvml
    public final void synpred29_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_8_0 = null;


        // InternalIvml.g:960:2: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) )
        // InternalIvml.g:960:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        {
        // InternalIvml.g:960:2: ( (lv_elements_8_0= ruleVariableDeclaration ) )
        // InternalIvml.g:961:1: (lv_elements_8_0= ruleVariableDeclaration )
        {
        // InternalIvml.g:961:1: (lv_elements_8_0= ruleVariableDeclaration )
        // InternalIvml.g:962:3: lv_elements_8_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsVariableDeclarationParserRuleCall_7_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_8_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred29_InternalIvml

    // $ANTLR start synpred30_InternalIvml
    public final void synpred30_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_elements_9_0 = null;


        // InternalIvml.g:979:6: ( ( (lv_elements_9_0= ruleExpressionStatement ) ) )
        // InternalIvml.g:979:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
        {
        // InternalIvml.g:979:6: ( (lv_elements_9_0= ruleExpressionStatement ) )
        // InternalIvml.g:980:1: (lv_elements_9_0= ruleExpressionStatement )
        {
        // InternalIvml.g:980:1: (lv_elements_9_0= ruleExpressionStatement )
        // InternalIvml.g:981:3: lv_elements_9_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAttrAssignmentAccess().getElementsExpressionStatementParserRuleCall_7_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_9_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred30_InternalIvml

    // $ANTLR start synpred49_InternalIvml
    public final void synpred49_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalIvml.g:1828:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalIvml.g:1828:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalIvml.g:1828:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalIvml.g:1829:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalIvml.g:1829:1: (lv_qValue_2_0= ruleQualifiedName )
        // InternalIvml.g:1830:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getValueAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred49_InternalIvml

    // $ANTLR start synpred54_InternalIvml
    public final void synpred54_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_tValue_6_0 = null;


        // InternalIvml.g:1910:6: ( ( (lv_tValue_6_0= ruleType ) ) )
        // InternalIvml.g:1910:6: ( (lv_tValue_6_0= ruleType ) )
        {
        // InternalIvml.g:1910:6: ( (lv_tValue_6_0= ruleType ) )
        // InternalIvml.g:1911:1: (lv_tValue_6_0= ruleType )
        {
        // InternalIvml.g:1911:1: (lv_tValue_6_0= ruleType )
        // InternalIvml.g:1912:3: lv_tValue_6_0= ruleType
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getValueAccess().getTValueTypeParserRuleCall_6_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_tValue_6_0=ruleType();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred54_InternalIvml

    // $ANTLR start synpred55_InternalIvml
    public final void synpred55_InternalIvml_fragment() throws RecognitionException {   
        // InternalIvml.g:1929:7: ( ( RULE_VERSION ) )
        // InternalIvml.g:1930:1: ( RULE_VERSION )
        {
        // InternalIvml.g:1930:1: ( RULE_VERSION )
        // InternalIvml.g:1931:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred55_InternalIvml

    // $ANTLR start synpred78_InternalIvml
    public final void synpred78_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_9=null;
        EObject lv_impl_8_0 = null;


        // InternalIvml.g:2949:2: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) )
        // InternalIvml.g:2949:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
        {
        // InternalIvml.g:2949:2: ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' )
        // InternalIvml.g:2949:3: ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';'
        {
        // InternalIvml.g:2949:3: ( (lv_impl_8_0= ruleExpression ) )
        // InternalIvml.g:2950:1: (lv_impl_8_0= ruleExpression )
        {
        // InternalIvml.g:2950:1: (lv_impl_8_0= ruleExpression )
        // InternalIvml.g:2951:3: lv_impl_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOpDefStatementAccess().getImplExpressionParserRuleCall_8_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_14);
        lv_impl_8_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred78_InternalIvml

    // $ANTLR start synpred84_InternalIvml
    public final void synpred84_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_expr_0_0 = null;


        // InternalIvml.g:3385:2: ( ( (lv_expr_0_0= ruleExpression ) ) )
        // InternalIvml.g:3385:2: ( (lv_expr_0_0= ruleExpression ) )
        {
        // InternalIvml.g:3385:2: ( (lv_expr_0_0= ruleExpression ) )
        // InternalIvml.g:3386:1: (lv_expr_0_0= ruleExpression )
        {
        // InternalIvml.g:3386:1: (lv_expr_0_0= ruleExpression )
        // InternalIvml.g:3387:3: lv_expr_0_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOptBlockExpressionAccess().getExprExpressionParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_expr_0_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred84_InternalIvml

    // $ANTLR start synpred106_InternalIvml
    public final void synpred106_InternalIvml_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_op_0_0 = null;


        // InternalIvml.g:4604:1: ( (lv_op_0_0= ruleUnaryOperator ) )
        // InternalIvml.g:4604:1: (lv_op_0_0= ruleUnaryOperator )
        {
        // InternalIvml.g:4604:1: (lv_op_0_0= ruleUnaryOperator )
        // InternalIvml.g:4605:3: lv_op_0_0= ruleUnaryOperator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_op_0_0=ruleUnaryOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred106_InternalIvml

    // $ANTLR start synpred121_InternalIvml
    public final void synpred121_InternalIvml_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalIvml.g:5096:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalIvml.g:5096:1: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalIvml.g:5096:1: (lv_decl_2_0= ruleDeclarator )
        // InternalIvml.g:5097:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getContainerOpAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred121_InternalIvml

    // $ANTLR start synpred128_InternalIvml
    public final void synpred128_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


        // InternalIvml.g:5372:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )
        // InternalIvml.g:5372:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
        {
        // InternalIvml.g:5372:3: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5373:1: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5373:1: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5374:3: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getActualArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_25);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_1=(Token)match(input,19,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred128_InternalIvml

    // $ANTLR start synpred140_InternalIvml
    public final void synpred140_InternalIvml_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_attrib_2_0 = null;


        // InternalIvml.g:5799:3: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )
        // InternalIvml.g:5799:3: ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '='
        {
        // InternalIvml.g:5799:3: ( (lv_name_0_0= ruleIdentifier ) )
        // InternalIvml.g:5800:1: (lv_name_0_0= ruleIdentifier )
        {
        // InternalIvml.g:5800:1: (lv_name_0_0= ruleIdentifier )
        // InternalIvml.g:5801:3: lv_name_0_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getNameIdentifierParserRuleCall_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_60);
        lv_name_0_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalIvml.g:5817:2: (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )?
        int alt110=2;
        int LA110_0 = input.LA(1);

        if ( (LA110_0==37) ) {
            alt110=1;
        }
        switch (alt110) {
            case 1 :
                // InternalIvml.g:5817:4: otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) )
                {
                otherlv_1=(Token)match(input,37,FOLLOW_4); if (state.failed) return ;
                // InternalIvml.g:5821:1: ( (lv_attrib_2_0= ruleIdentifier ) )
                // InternalIvml.g:5822:1: (lv_attrib_2_0= ruleIdentifier )
                {
                // InternalIvml.g:5822:1: (lv_attrib_2_0= ruleIdentifier )
                // InternalIvml.g:5823:3: lv_attrib_2_0= ruleIdentifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpressionListEntryAccess().getAttribIdentifierParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_25);
                lv_attrib_2_0=ruleIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred140_InternalIvml

    // Delegated rules

    public final boolean synpred11_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalIvml() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalIvml_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA66 dfa66 = new DFA66(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA90 dfa90 = new DFA90(this);
    protected DFA100 dfa100 = new DFA100(this);
    protected DFA101 dfa101 = new DFA101(this);
    static final String dfa_1s = "\67\uffff";
    static final String dfa_2s = "\1\1\66\uffff";
    static final String dfa_3s = "\1\4\7\uffff\15\0\42\uffff";
    static final String dfa_4s = "\1\122\7\uffff\15\0\42\uffff";
    static final String dfa_5s = "\1\uffff\1\11\1\uffff\1\1\3\uffff\1\2\15\uffff\1\3\1\4\1\5\33\uffff\1\6\1\uffff\1\7\1\10";
    static final String dfa_6s = "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\42\uffff}>";
    static final String[] dfa_7s = {
            "\2\27\1\17\1\16\1\20\5\uffff\1\27\1\1\1\uffff\1\3\2\uffff\2\3\1\uffff\1\66\1\27\2\uffff\1\3\1\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\2\uffff\4\27\1\22\1\23\1\24\2\63\1\25\2\uffff\1\26\4\uffff\1\27\1\uffff\1\21\1\65\1\uffff\1\27\1\uffff\20\27\3\uffff\2\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 288:2: ( ( (lv_elements_1_0= ruleTypedef ) ) | ( (lv_elements_2_0= ruleVariableDeclaration ) ) | ( (lv_elements_3_0= ruleFreeze ) ) | ( (lv_elements_4_0= ruleEval ) ) | ( (lv_elements_5_0= ruleExpressionStatement ) ) | ( (lv_elements_6_0= ruleAnnotateTo ) ) | ( (lv_elements_7_0= ruleOpDefStatement ) ) | ( (lv_elements_8_0= ruleAttrAssignment ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_8 = input.LA(1);

                         
                        int index7_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_10 = input.LA(1);

                         
                        int index7_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_12 = input.LA(1);

                         
                        int index7_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_13 = input.LA(1);

                         
                        int index7_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA7_14 = input.LA(1);

                         
                        int index7_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_14);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA7_15 = input.LA(1);

                         
                        int index7_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_15);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA7_16 = input.LA(1);

                         
                        int index7_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA7_17 = input.LA(1);

                         
                        int index7_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_17);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_18);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA7_19 = input.LA(1);

                         
                        int index7_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_19);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA7_20 = input.LA(1);

                         
                        int index7_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_InternalIvml()) ) {s = 7;}

                        else if ( (synpred11_InternalIvml()) ) {s = 23;}

                         
                        input.seek(index7_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\56\uffff";
    static final String dfa_9s = "\1\4\2\uffff\15\0\36\uffff";
    static final String dfa_10s = "\1\122\2\uffff\15\0\36\uffff";
    static final String dfa_11s = "\1\uffff\1\5\1\1\15\uffff\1\2\33\uffff\1\3\1\4";
    static final String dfa_12s = "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\36\uffff}>";
    static final String[] dfa_13s = {
            "\2\20\1\12\1\11\1\13\5\uffff\1\20\1\1\7\uffff\1\54\1\20\4\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\4\20\1\15\1\16\1\17\5\uffff\1\55\4\uffff\1\20\1\uffff\1\14\2\uffff\1\20\1\uffff\20\20\3\uffff\2\20",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "()* loopback of 796:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) | ( (lv_elements_11_0= ruleEval ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_6 = input.LA(1);

                         
                        int index15_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_7 = input.LA(1);

                         
                        int index15_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_8 = input.LA(1);

                         
                        int index15_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_9 = input.LA(1);

                         
                        int index15_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA15_10 = input.LA(1);

                         
                        int index15_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA15_11 = input.LA(1);

                         
                        int index15_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA15_12 = input.LA(1);

                         
                        int index15_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA15_13 = input.LA(1);

                         
                        int index15_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA15_14 = input.LA(1);

                         
                        int index15_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA15_15 = input.LA(1);

                         
                        int index15_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalIvml()) ) {s = 2;}

                        else if ( (synpred24_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index15_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\55\uffff";
    static final String dfa_15s = "\1\4\2\uffff\15\0\35\uffff";
    static final String dfa_16s = "\1\122\2\uffff\15\0\35\uffff";
    static final String dfa_17s = "\1\uffff\1\4\1\1\15\uffff\1\2\33\uffff\1\3";
    static final String dfa_18s = "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\35\uffff}>";
    static final String[] dfa_19s = {
            "\2\20\1\12\1\11\1\13\5\uffff\1\20\1\1\7\uffff\1\54\1\20\4\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\4\20\1\15\1\16\1\17\12\uffff\1\20\1\uffff\1\14\2\uffff\1\20\1\uffff\20\20\3\uffff\2\20",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "()+ loopback of 960:1: ( ( (lv_elements_8_0= ruleVariableDeclaration ) ) | ( (lv_elements_9_0= ruleExpressionStatement ) ) | ( (lv_elements_10_0= ruleAttrAssignment ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_3 = input.LA(1);

                         
                        int index18_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA18_4 = input.LA(1);

                         
                        int index18_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA18_5 = input.LA(1);

                         
                        int index18_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA18_6 = input.LA(1);

                         
                        int index18_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA18_7 = input.LA(1);

                         
                        int index18_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA18_8 = input.LA(1);

                         
                        int index18_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_8);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA18_9 = input.LA(1);

                         
                        int index18_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_9);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA18_10 = input.LA(1);

                         
                        int index18_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA18_11 = input.LA(1);

                         
                        int index18_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA18_12 = input.LA(1);

                         
                        int index18_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_12);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA18_13 = input.LA(1);

                         
                        int index18_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA18_14 = input.LA(1);

                         
                        int index18_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_14);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA18_15 = input.LA(1);

                         
                        int index18_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_InternalIvml()) ) {s = 2;}

                        else if ( (synpred30_InternalIvml()) ) {s = 16;}

                         
                        input.seek(index18_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_20s = "\15\uffff";
    static final String dfa_21s = "\1\4\2\uffff\4\0\6\uffff";
    static final String dfa_22s = "\1\71\2\uffff\4\0\6\uffff";
    static final String dfa_23s = "\1\uffff\1\1\1\2\4\uffff\1\4\1\5\1\6\1\7\1\3\1\10";
    static final String dfa_24s = "\3\uffff\1\1\1\0\1\2\1\3\6\uffff}>";
    static final String[] dfa_25s = {
            "\1\1\1\2\1\4\1\3\1\5\25\uffff\6\12\2\uffff\2\7\1\10\1\11\3\12\14\uffff\1\6",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "1790:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_self_4_0= 'self' ) ) | ( (lv_nullValue_5_0= 'null' ) ) | ( (lv_tValue_6_0= ruleType ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_7_0= RULE_VERSION ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_4 = input.LA(1);

                         
                        int index30_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                        else if ( (synpred55_InternalIvml()) ) {s = 12;}

                         
                        input.seek(index30_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_3 = input.LA(1);

                         
                        int index30_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_5 = input.LA(1);

                         
                        int index30_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_6 = input.LA(1);

                         
                        int index30_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalIvml()) ) {s = 11;}

                        else if ( (synpred54_InternalIvml()) ) {s = 10;}

                         
                        input.seek(index30_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_26s = "\53\uffff";
    static final String dfa_27s = "\1\4\50\uffff\1\0\1\uffff";
    static final String dfa_28s = "\1\122\50\uffff\1\0\1\uffff";
    static final String dfa_29s = "\1\uffff\1\1\50\uffff\1\2";
    static final String dfa_30s = "\51\uffff\1\0\1\uffff}>";
    static final String[] dfa_31s = {
            "\5\1\5\uffff\1\51\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\1\2\uffff\1\1\1\uffff\20\1\3\uffff\2\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "2949:1: ( ( ( (lv_impl_8_0= ruleExpression ) ) otherlv_9= ';' ) | ( (lv_block_10_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_41 = input.LA(1);

                         
                        int index52_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index52_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_32s = "\16\uffff";
    static final String dfa_33s = "\3\uffff\4\2\2\uffff\4\2\1\uffff";
    static final String dfa_34s = "\1\4\2\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_35s = "\1\122\2\uffff\4\125\1\uffff\1\71\4\125\1\71";
    static final String dfa_36s = "\1\uffff\1\1\1\2\4\uffff\1\3\6\uffff";
    static final String dfa_37s = "\16\uffff}>";
    static final String[] dfa_38s = {
            "\2\2\1\4\1\3\1\5\5\uffff\1\7\11\uffff\1\2\5\uffff\6\2\2\uffff\7\2\12\uffff\1\2\1\uffff\1\6\2\uffff\1\1\1\uffff\20\2\3\uffff\2\2",
            "",
            "",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\4\uffff\3\2\11\uffff\1\10\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "",
            "\1\12\1\11\1\13\60\uffff\1\14",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\7\1\uffff\1\2\1\uffff\2\2\5\uffff\2\2\11\uffff\1\15\1\2\13\uffff\1\2\5\uffff\1\2\5\uffff\20\2\1\uffff\3\2\2\uffff\3\2",
            "\1\12\1\11\1\13\60\uffff\1\14"
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "3203:1: ( ( (lv_let_0_0= ruleLetExpression ) ) | ( (lv_expr_1_0= ruleImplicationExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "3385:1: ( ( (lv_expr_0_0= ruleExpression ) ) | ( (lv_block_1_0= ruleBlockExpression ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA57_41 = input.LA(1);

                         
                        int index57_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred84_InternalIvml()) ) {s = 1;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index57_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 57, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_39s = "\2\uffff\4\1\2\uffff\4\1\1\uffff";
    static final String dfa_40s = "\1\4\1\uffff\4\16\1\uffff\1\6\4\16\1\6";
    static final String dfa_41s = "\1\122\1\uffff\4\125\1\uffff\1\71\4\125\1\71";
    static final String dfa_42s = "\1\uffff\1\1\4\uffff\1\2\6\uffff";
    static final String dfa_43s = "\15\uffff}>";
    static final String[] dfa_44s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\4\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\5\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\1\1\6\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\20\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_20;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "3565:2: ( ( (lv_ex_1_0= ruleLogicalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }
    static final String[] dfa_45s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\4\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\4\uffff\3\1\11\uffff\1\7\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\6\2\1\1\uffff\2\1\5\uffff\2\1\11\uffff\1\14\1\1\13\uffff\1\1\5\uffff\1\1\5\uffff\6\1\3\uffff\7\1\1\uffff\3\1\2\uffff\3\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = dfa_20;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "4028:2: ( ( (lv_ex_1_0= ruleRelationalExpression ) ) | ( (lv_container_2_0= ruleContainerInitializer ) ) )";
        }
    }
    static final String dfa_46s = "\51\uffff";
    static final String dfa_47s = "\1\4\2\0\46\uffff";
    static final String dfa_48s = "\1\122\2\0\46\uffff";
    static final String dfa_49s = "\3\uffff\1\2\44\uffff\1\1";
    static final String dfa_50s = "\1\uffff\1\0\1\1\46\uffff}>";
    static final String[] dfa_51s = {
            "\5\3\17\uffff\1\3\5\uffff\6\3\2\uffff\7\3\12\uffff\1\3\1\uffff\1\3\4\uffff\15\3\1\2\1\3\1\1\3\uffff\2\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "4603:2: ( (lv_op_0_0= ruleUnaryOperator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 40;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA75_2 = input.LA(1);

                         
                        int index75_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred106_InternalIvml()) ) {s = 40;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index75_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\54\uffff";
    static final String dfa_53s = "\1\4\15\0\36\uffff";
    static final String dfa_54s = "\1\122\15\0\36\uffff";
    static final String dfa_55s = "\16\uffff\1\2\34\uffff\1\1";
    static final String dfa_56s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\36\uffff}>";
    static final String[] dfa_57s = {
            "\2\16\1\10\1\7\1\11\5\uffff\1\16\11\uffff\2\16\4\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\4\16\1\13\1\14\1\15\12\uffff\1\16\1\uffff\1\12\2\uffff\1\16\1\uffff\20\16\3\uffff\2\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "5095:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_1 = input.LA(1);

                         
                        int index83_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA83_2 = input.LA(1);

                         
                        int index83_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA83_3 = input.LA(1);

                         
                        int index83_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA83_4 = input.LA(1);

                         
                        int index83_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA83_5 = input.LA(1);

                         
                        int index83_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA83_6 = input.LA(1);

                         
                        int index83_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA83_7 = input.LA(1);

                         
                        int index83_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA83_8 = input.LA(1);

                         
                        int index83_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA83_9 = input.LA(1);

                         
                        int index83_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA83_10 = input.LA(1);

                         
                        int index83_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA83_11 = input.LA(1);

                         
                        int index83_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA83_12 = input.LA(1);

                         
                        int index83_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA83_13 = input.LA(1);

                         
                        int index83_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred121_InternalIvml()) ) {s = 43;}

                        else if ( (true) ) {s = 14;}

                         
                        input.seek(index83_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_58s = "\1\4\4\0\46\uffff";
    static final String dfa_59s = "\1\122\4\0\46\uffff";
    static final String dfa_60s = "\5\uffff\1\2\44\uffff\1\1";
    static final String dfa_61s = "\1\uffff\1\0\1\1\1\2\1\3\46\uffff}>";
    static final String[] dfa_62s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\5\uffff\6\5\2\uffff\7\5\12\uffff\1\5\1\uffff\1\4\2\uffff\1\5\1\uffff\20\5\3\uffff\2\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[][] dfa_62 = unpackEncodedStringArray(dfa_62s);

    class DFA90 extends DFA {

        public DFA90(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 90;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_58;
            this.max = dfa_59;
            this.accept = dfa_60;
            this.special = dfa_61;
            this.transition = dfa_62;
        }
        public String getDescription() {
            return "5372:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA90_1 = input.LA(1);

                         
                        int index90_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred128_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA90_2 = input.LA(1);

                         
                        int index90_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred128_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA90_3 = input.LA(1);

                         
                        int index90_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred128_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA90_4 = input.LA(1);

                         
                        int index90_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred128_InternalIvml()) ) {s = 42;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index90_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 90, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_63s = "\52\uffff";
    static final String dfa_64s = "\1\4\4\0\45\uffff";
    static final String dfa_65s = "\1\122\4\0\45\uffff";
    static final String dfa_66s = "\5\uffff\1\2\43\uffff\1\1";
    static final String dfa_67s = "\1\uffff\1\0\1\1\1\2\1\3\45\uffff}>";
    static final String[] dfa_68s = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\11\uffff\1\5\5\uffff\6\5\2\uffff\7\5\12\uffff\1\5\1\uffff\1\4\4\uffff\20\5\3\uffff\2\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final char[] dfa_65 = DFA.unpackEncodedStringToUnsignedChars(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final short[] dfa_67 = DFA.unpackEncodedString(dfa_67s);
    static final short[][] dfa_68 = unpackEncodedStringArray(dfa_68s);

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_63;
            this.eof = dfa_63;
            this.min = dfa_64;
            this.max = dfa_65;
            this.accept = dfa_66;
            this.special = dfa_67;
            this.transition = dfa_68;
        }
        public String getDescription() {
            return "5799:2: ( ( (lv_name_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_attrib_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA100_1 = input.LA(1);

                         
                        int index100_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred140_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index100_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA100_2 = input.LA(1);

                         
                        int index100_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred140_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index100_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA100_3 = input.LA(1);

                         
                        int index100_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred140_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index100_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA100_4 = input.LA(1);

                         
                        int index100_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred140_InternalIvml()) ) {s = 41;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index100_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 100, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_69s = "\1\122\1\uffff\4\117\1\uffff\1\71\4\117\1\71";
    static final String[] dfa_70s = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\6\11\uffff\1\1\5\uffff\6\1\2\uffff\7\1\12\uffff\1\1\1\uffff\1\5\4\uffff\20\1\3\uffff\2\1",
            "",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\4\uffff\1\1\13\uffff\1\7\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "",
            "\1\11\1\10\1\12\60\uffff\1\13",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\6\1\1\2\uffff\2\1\20\uffff\1\14\1\1\21\uffff\1\1\6\uffff\17\1\1\uffff\2\1",
            "\1\11\1\10\1\12\60\uffff\1\13"
    };
    static final char[] dfa_69 = DFA.unpackEncodedStringToUnsignedChars(dfa_69s);
    static final short[][] dfa_70 = unpackEncodedStringArray(dfa_70s);

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = dfa_20;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_69;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_70;
        }
        public String getDescription() {
            return "5843:3: ( ( (lv_value_4_0= ruleImplicationExpression ) ) | ( (lv_container_5_0= ruleContainerInitializer ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x02000000000001C0L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xD7ECFFCFE9B2C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xD78CFFCFE9B2C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xD68CFFCFE9B2C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xD684FFCFE9B241F2L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xD684FFCFE9B2C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xD684FFCFE9B241F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xC2801FCFE10001F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x02001C0FE00001C0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xD2801FCFE10041F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x02000020000001C0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x02000020000081C0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0001000000010002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xD2841FCFE100C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xD2801FCFE100C1F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010000000008000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0080001010010000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0080000010010000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0A001C0FE00001C0L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x02001C0FE20001C0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000038L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0080000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000002000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xC2800000000001C0L,0x0000000000003FFFL});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xD2801FCFE30041F0L,0x0000000000063FFFL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000002000080000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});

}