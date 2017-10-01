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
import de.uni_hildesheim.sse.services.VilBuildLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalVilBuildLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'.'", "'instantiate'", "'map'", "'for'", "'while'", "'if'", "'else'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'abstract'", "'compound'", "'refines'", "'typedef'", "'@advice'", "'version'", "'import'", "'and'", "'or'", "'xor'", "'implies'", "'iff'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=5;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=6;
    public static final int RULE_EXPONENT=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalVilBuildLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVilBuildLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVilBuildLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVilBuildLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private VilBuildLanguageGrammarAccess grammarAccess;
     	
        public InternalVilBuildLanguageParser(TokenStream input, VilBuildLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ImplementationUnit";	
       	}
       	
       	@Override
       	protected VilBuildLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleImplementationUnit"
    // InternalVilBuildLanguage.g:73:1: entryRuleImplementationUnit returns [EObject current=null] : iv_ruleImplementationUnit= ruleImplementationUnit EOF ;
    public final EObject entryRuleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementationUnit = null;


        try {
            // InternalVilBuildLanguage.g:74:2: (iv_ruleImplementationUnit= ruleImplementationUnit EOF )
            // InternalVilBuildLanguage.g:75:2: iv_ruleImplementationUnit= ruleImplementationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplementationUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImplementationUnit=ruleImplementationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplementationUnit; 
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
    // $ANTLR end "entryRuleImplementationUnit"


    // $ANTLR start "ruleImplementationUnit"
    // InternalVilBuildLanguage.g:82:1: ruleImplementationUnit returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) ;
    public final EObject ruleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_requires_2_0 = null;

        EObject lv_scripts_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:85:28: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) )
            // InternalVilBuildLanguage.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            {
            // InternalVilBuildLanguage.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            // InternalVilBuildLanguage.g:86:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            {
            // InternalVilBuildLanguage.g:86:2: ()
            // InternalVilBuildLanguage.g:87:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getImplementationUnitAccess().getImplementationUnitAction_0(),
                          current);
                  
            }

            }

            // InternalVilBuildLanguage.g:95:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==45) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:96:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalVilBuildLanguage.g:96:1: (lv_imports_1_0= ruleImport )
            	    // InternalVilBuildLanguage.g:97:3: lv_imports_1_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getImportsImportParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImplementationUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_1_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalVilBuildLanguage.g:113:3: ( (lv_requires_2_0= ruleRequire ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:114:1: (lv_requires_2_0= ruleRequire )
            	    {
            	    // InternalVilBuildLanguage.g:114:1: (lv_requires_2_0= ruleRequire )
            	    // InternalVilBuildLanguage.g:115:3: lv_requires_2_0= ruleRequire
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getRequiresRequireParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_requires_2_0=ruleRequire();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImplementationUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_2_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.Require");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalVilBuildLanguage.g:131:3: ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==43) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    {
            	    // InternalVilBuildLanguage.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    // InternalVilBuildLanguage.g:133:3: lv_scripts_3_0= ruleLanguageUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getScriptsLanguageUnitParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_scripts_3_0=ruleLanguageUnit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImplementationUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"scripts",
            	              		lv_scripts_3_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.LanguageUnit");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleImplementationUnit"


    // $ANTLR start "entryRuleRequire"
    // InternalVilBuildLanguage.g:157:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // InternalVilBuildLanguage.g:158:2: (iv_ruleRequire= ruleRequire EOF )
            // InternalVilBuildLanguage.g:159:2: iv_ruleRequire= ruleRequire EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequireRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequire=ruleRequire();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequire; 
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
    // $ANTLR end "entryRuleRequire"


    // $ANTLR start "ruleRequire"
    // InternalVilBuildLanguage.g:166:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:169:28: ( (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:170:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:170:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:170:3: otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireVTLKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:174:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalVilBuildLanguage.g:175:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalVilBuildLanguage.g:175:1: (lv_name_1_0= RULE_STRING )
            // InternalVilBuildLanguage.g:176:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRequireAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRequireRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:192:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )
            // InternalVilBuildLanguage.g:193:1: (lv_versionSpec_2_0= ruleVersionSpec )
            {
            // InternalVilBuildLanguage.g:193:1: (lv_versionSpec_2_0= ruleVersionSpec )
            // InternalVilBuildLanguage.g:194:3: lv_versionSpec_2_0= ruleVersionSpec
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRequireAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_versionSpec_2_0=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRequireRule());
              	        }
                     		set(
                     			current, 
                     			"versionSpec",
                      		lv_versionSpec_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionSpec");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRequireAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleRequire"


    // $ANTLR start "entryRuleLanguageUnit"
    // InternalVilBuildLanguage.g:222:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // InternalVilBuildLanguage.g:223:2: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // InternalVilBuildLanguage.g:224:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLanguageUnit=ruleLanguageUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageUnit; 
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
    // $ANTLR end "entryRuleLanguageUnit"


    // $ANTLR start "ruleLanguageUnit"
    // InternalVilBuildLanguage.g:231:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_advices_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_parent_6_0 = null;

        EObject lv_version_8_0 = null;

        EObject lv_loadProperties_9_0 = null;

        EObject lv_contents_10_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:234:28: ( ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) )
            // InternalVilBuildLanguage.g:235:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // InternalVilBuildLanguage.g:235:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            // InternalVilBuildLanguage.g:235:2: ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )?
            {
            // InternalVilBuildLanguage.g:235:2: ( (lv_advices_0_0= ruleAdvice ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==43) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:236:1: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // InternalVilBuildLanguage.g:236:1: (lv_advices_0_0= ruleAdvice )
            	    // InternalVilBuildLanguage.g:237:3: lv_advices_0_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_advices_0_0=ruleAdvice();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"advices",
            	              		lv_advices_0_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Advice");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_1=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLanguageUnitAccess().getVilScriptKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:257:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:258:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:258:1: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:259:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLanguageUnitAccess().getLeftParenthesisKeyword_3());
                  
            }
            // InternalVilBuildLanguage.g:279:1: ( (lv_param_4_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||LA5_0==44||(LA5_0>=74 && LA5_0<=77)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVilBuildLanguage.g:280:1: (lv_param_4_0= ruleParameterList )
                    {
                    // InternalVilBuildLanguage.g:280:1: (lv_param_4_0= ruleParameterList )
                    // InternalVilBuildLanguage.g:281:3: lv_param_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getParamParameterListParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_param_4_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLanguageUnitAccess().getRightParenthesisKeyword_5());
                  
            }
            // InternalVilBuildLanguage.g:301:1: ( (lv_parent_6_0= ruleScriptParentDecl ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVilBuildLanguage.g:302:1: (lv_parent_6_0= ruleScriptParentDecl )
                    {
                    // InternalVilBuildLanguage.g:302:1: (lv_parent_6_0= ruleScriptParentDecl )
                    // InternalVilBuildLanguage.g:303:3: lv_parent_6_0= ruleScriptParentDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getParentScriptParentDeclParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_15);
                    lv_parent_6_0=ruleScriptParentDecl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"parent",
                              		lv_parent_6_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.ScriptParentDecl");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getLanguageUnitAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // InternalVilBuildLanguage.g:323:1: ( (lv_version_8_0= ruleVersionStmt ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==44) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_VERSION) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==14) ) {
                        int LA7_4 = input.LA(4);

                        if ( (synpred7_InternalVilBuildLanguage()) ) {
                            alt7=1;
                        }
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
                    {
                    // InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
                    // InternalVilBuildLanguage.g:325:3: lv_version_8_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_16);
                    lv_version_8_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_8_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:341:3: ( (lv_loadProperties_9_0= ruleLoadProperties ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:342:1: (lv_loadProperties_9_0= ruleLoadProperties )
            	    {
            	    // InternalVilBuildLanguage.g:342:1: (lv_loadProperties_9_0= ruleLoadProperties )
            	    // InternalVilBuildLanguage.g:343:3: lv_loadProperties_9_0= ruleLoadProperties
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getLoadPropertiesLoadPropertiesParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_loadProperties_9_0=ruleLoadProperties();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"loadProperties",
            	              		lv_loadProperties_9_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.LoadProperties");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalVilBuildLanguage.g:359:3: ( (lv_contents_10_0= ruleScriptContents ) )
            // InternalVilBuildLanguage.g:360:1: (lv_contents_10_0= ruleScriptContents )
            {
            // InternalVilBuildLanguage.g:360:1: (lv_contents_10_0= ruleScriptContents )
            // InternalVilBuildLanguage.g:361:3: lv_contents_10_0= ruleScriptContents
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getContentsScriptContentsParserRuleCall_10_0()); 
              	    
            }
            pushFollow(FOLLOW_17);
            lv_contents_10_0=ruleScriptContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              	        }
                     		set(
                     			current, 
                     			"contents",
                      		lv_contents_10_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.ScriptContents");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_11=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_11());
                  
            }
            // InternalVilBuildLanguage.g:381:1: (otherlv_12= ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVilBuildLanguage.g:381:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getLanguageUnitAccess().getSemicolonKeyword_12());
                          
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
    // $ANTLR end "ruleLanguageUnit"


    // $ANTLR start "entryRuleScriptParentDecl"
    // InternalVilBuildLanguage.g:393:1: entryRuleScriptParentDecl returns [EObject current=null] : iv_ruleScriptParentDecl= ruleScriptParentDecl EOF ;
    public final EObject entryRuleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptParentDecl = null;


        try {
            // InternalVilBuildLanguage.g:394:2: (iv_ruleScriptParentDecl= ruleScriptParentDecl EOF )
            // InternalVilBuildLanguage.g:395:2: iv_ruleScriptParentDecl= ruleScriptParentDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScriptParentDeclRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScriptParentDecl=ruleScriptParentDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScriptParentDecl; 
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
    // $ANTLR end "entryRuleScriptParentDecl"


    // $ANTLR start "ruleScriptParentDecl"
    // InternalVilBuildLanguage.g:402:1: ruleScriptParentDecl returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:405:28: ( (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalVilBuildLanguage.g:406:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalVilBuildLanguage.g:406:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalVilBuildLanguage.g:406:3: otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScriptParentDeclAccess().getExtendsKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:410:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:411:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:411:1: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:412:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScriptParentDeclAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScriptParentDeclRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
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
    // $ANTLR end "ruleScriptParentDecl"


    // $ANTLR start "entryRuleLoadProperties"
    // InternalVilBuildLanguage.g:436:1: entryRuleLoadProperties returns [EObject current=null] : iv_ruleLoadProperties= ruleLoadProperties EOF ;
    public final EObject entryRuleLoadProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoadProperties = null;


        try {
            // InternalVilBuildLanguage.g:437:2: (iv_ruleLoadProperties= ruleLoadProperties EOF )
            // InternalVilBuildLanguage.g:438:2: iv_ruleLoadProperties= ruleLoadProperties EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoadPropertiesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoadProperties=ruleLoadProperties();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoadProperties; 
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
    // $ANTLR end "entryRuleLoadProperties"


    // $ANTLR start "ruleLoadProperties"
    // InternalVilBuildLanguage.g:445:1: ruleLoadProperties returns [EObject current=null] : (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) ;
    public final EObject ruleLoadProperties() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:448:28: ( (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:449:1: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:449:1: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:449:3: otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLoadPropertiesAccess().getLoadKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLoadPropertiesAccess().getPropertiesKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:457:1: ( (lv_path_2_0= RULE_STRING ) )
            // InternalVilBuildLanguage.g:458:1: (lv_path_2_0= RULE_STRING )
            {
            // InternalVilBuildLanguage.g:458:1: (lv_path_2_0= RULE_STRING )
            // InternalVilBuildLanguage.g:459:3: lv_path_2_0= RULE_STRING
            {
            lv_path_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_path_2_0, grammarAccess.getLoadPropertiesAccess().getPathSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLoadPropertiesRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"path",
                      		lv_path_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLoadPropertiesAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleLoadProperties"


    // $ANTLR start "entryRuleScriptContents"
    // InternalVilBuildLanguage.g:487:1: entryRuleScriptContents returns [EObject current=null] : iv_ruleScriptContents= ruleScriptContents EOF ;
    public final EObject entryRuleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptContents = null;


        try {
            // InternalVilBuildLanguage.g:488:2: (iv_ruleScriptContents= ruleScriptContents EOF )
            // InternalVilBuildLanguage.g:489:2: iv_ruleScriptContents= ruleScriptContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScriptContentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleScriptContents=ruleScriptContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScriptContents; 
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
    // $ANTLR end "entryRuleScriptContents"


    // $ANTLR start "ruleScriptContents"
    // InternalVilBuildLanguage.g:496:1: ruleScriptContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* ) ;
    public final EObject ruleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:499:28: ( ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* ) )
            // InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* )
            {
            // InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* )
            // InternalVilBuildLanguage.g:500:2: () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*
            {
            // InternalVilBuildLanguage.g:500:2: ()
            // InternalVilBuildLanguage.g:501:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getScriptContentsAccess().getScriptContentsAction_0(),
                          current);
                  
            }

            }

            // InternalVilBuildLanguage.g:509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*
            loop10:
            do {
                int alt10=5;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    // InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
            	    // InternalVilBuildLanguage.g:511:3: lv_elements_1_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsVariableDeclarationParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_1_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScriptContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_1_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleCompound ) )
            	    {
            	    // InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleCompound ) )
            	    // InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleCompound )
            	    {
            	    // InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleCompound )
            	    // InternalVilBuildLanguage.g:530:3: lv_elements_2_0= ruleCompound
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsCompoundParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_2_0=ruleCompound();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScriptContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Compound");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleTypeDef ) )
            	    {
            	    // InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleTypeDef ) )
            	    // InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleTypeDef )
            	    {
            	    // InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleTypeDef )
            	    // InternalVilBuildLanguage.g:549:3: lv_elements_3_0= ruleTypeDef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsTypeDefParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_3_0=ruleTypeDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScriptContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeDef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalVilBuildLanguage.g:566:6: ( (lv_elements_4_0= ruleRuleDeclaration ) )
            	    {
            	    // InternalVilBuildLanguage.g:566:6: ( (lv_elements_4_0= ruleRuleDeclaration ) )
            	    // InternalVilBuildLanguage.g:567:1: (lv_elements_4_0= ruleRuleDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:567:1: (lv_elements_4_0= ruleRuleDeclaration )
            	    // InternalVilBuildLanguage.g:568:3: lv_elements_4_0= ruleRuleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_elements_4_0=ruleRuleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScriptContentsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_4_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end "ruleScriptContents"


    // $ANTLR start "entryRuleRuleDeclaration"
    // InternalVilBuildLanguage.g:592:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:593:2: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // InternalVilBuildLanguage.g:594:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleDeclaration=ruleRuleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDeclaration; 
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
    // $ANTLR end "entryRuleRuleDeclaration"


    // $ANTLR start "ruleRuleDeclaration"
    // InternalVilBuildLanguage.g:601:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) ;
    public final EObject ruleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_modifier_1_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;

        EObject lv_conditions_8_0 = null;

        EObject lv_block_9_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:604:28: ( ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) )
            // InternalVilBuildLanguage.g:605:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            {
            // InternalVilBuildLanguage.g:605:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            // InternalVilBuildLanguage.g:605:2: () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )?
            {
            // InternalVilBuildLanguage.g:605:2: ()
            // InternalVilBuildLanguage.g:606:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRuleDeclarationAccess().getRuleDeclarationAction_0(),
                          current);
                  
            }

            }

            // InternalVilBuildLanguage.g:614:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalVilBuildLanguage.g:614:3: ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
                    {
                    // InternalVilBuildLanguage.g:614:3: ( (lv_modifier_1_0= ruleRuleModifier ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==26) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalVilBuildLanguage.g:615:1: (lv_modifier_1_0= ruleRuleModifier )
                            {
                            // InternalVilBuildLanguage.g:615:1: (lv_modifier_1_0= ruleRuleModifier )
                            // InternalVilBuildLanguage.g:616:3: lv_modifier_1_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_21);
                            lv_modifier_1_0=ruleRuleModifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"modifier",
                                      		lv_modifier_1_0, 
                                      		"de.uni_hildesheim.sse.VilBuildLanguage.RuleModifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:632:3: ( (lv_type_2_0= ruleType ) )?
                    int alt12=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1==RULE_VERSION||(LA12_1>=RULE_ID && LA12_1<=RULE_EXPONENT)||LA12_1==44||LA12_1==70) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA12_2 = input.LA(2);

                            if ( (LA12_2==RULE_VERSION||(LA12_2>=RULE_ID && LA12_2<=RULE_EXPONENT)||LA12_2==44||LA12_2==70) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA12_3 = input.LA(2);

                            if ( (LA12_3==RULE_VERSION||(LA12_3>=RULE_ID && LA12_3<=RULE_EXPONENT)||LA12_3==44||LA12_3==70) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case 44:
                            {
                            int LA12_4 = input.LA(2);

                            if ( (LA12_4==RULE_VERSION||(LA12_4>=RULE_ID && LA12_4<=RULE_EXPONENT)||LA12_4==44||LA12_4==70) ) {
                                alt12=1;
                            }
                            }
                            break;
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                            {
                            alt12=1;
                            }
                            break;
                    }

                    switch (alt12) {
                        case 1 :
                            // InternalVilBuildLanguage.g:633:1: (lv_type_2_0= ruleType )
                            {
                            // InternalVilBuildLanguage.g:633:1: (lv_type_2_0= ruleType )
                            // InternalVilBuildLanguage.g:634:3: lv_type_2_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_10);
                            lv_type_2_0=ruleType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"type",
                                      		lv_type_2_0, 
                                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:650:3: ( (lv_name_3_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:651:1: (lv_name_3_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:651:1: (lv_name_3_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:652:3: lv_name_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_11);
                    lv_name_3_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_3());
                          
                    }
                    // InternalVilBuildLanguage.g:672:1: ( (lv_paramList_5_0= ruleParameterList ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_VERSION||(LA13_0>=RULE_ID && LA13_0<=RULE_EXPONENT)||LA13_0==44||(LA13_0>=74 && LA13_0<=77)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalVilBuildLanguage.g:673:1: (lv_paramList_5_0= ruleParameterList )
                            {
                            // InternalVilBuildLanguage.g:673:1: (lv_paramList_5_0= ruleParameterList )
                            // InternalVilBuildLanguage.g:674:3: lv_paramList_5_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_13);
                            lv_paramList_5_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"paramList",
                                      		lv_paramList_5_0, 
                                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,17,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_5());
                          
                    }
                    otherlv_7=(Token)match(input,23,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_6());
                          
                    }

                    }
                    break;

            }

            // InternalVilBuildLanguage.g:698:3: ( (lv_conditions_8_0= ruleRuleConditions ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_EXPONENT)||LA15_0==16||LA15_0==24||(LA15_0>=28 && LA15_0<=29)||LA15_0==34||LA15_0==37||LA15_0==44||LA15_0==59||(LA15_0>=62 && LA15_0<=65)||(LA15_0>=71 && LA15_0<=73)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalVilBuildLanguage.g:699:1: (lv_conditions_8_0= ruleRuleConditions )
                    {
                    // InternalVilBuildLanguage.g:699:1: (lv_conditions_8_0= ruleRuleConditions )
                    // InternalVilBuildLanguage.g:700:3: lv_conditions_8_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_23);
                    lv_conditions_8_0=ruleRuleConditions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"conditions",
                              		lv_conditions_8_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleConditions");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:716:3: ( (lv_block_9_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:717:1: (lv_block_9_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:717:1: (lv_block_9_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:718:3: lv_block_9_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_18);
            lv_block_9_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_9_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElementBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:734:2: (otherlv_10= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVilBuildLanguage.g:734:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getRuleDeclarationAccess().getSemicolonKeyword_4());
                          
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
    // $ANTLR end "ruleRuleDeclaration"


    // $ANTLR start "entryRuleRuleConditions"
    // InternalVilBuildLanguage.g:746:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // InternalVilBuildLanguage.g:747:2: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // InternalVilBuildLanguage.g:748:2: iv_ruleRuleConditions= ruleRuleConditions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleConditionsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleConditions=ruleRuleConditions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleConditions; 
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
    // $ANTLR end "entryRuleRuleConditions"


    // $ANTLR start "ruleRuleConditions"
    // InternalVilBuildLanguage.g:755:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:758:28: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // InternalVilBuildLanguage.g:759:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // InternalVilBuildLanguage.g:759:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // InternalVilBuildLanguage.g:759:2: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // InternalVilBuildLanguage.g:759:2: ()
            // InternalVilBuildLanguage.g:760:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRuleConditionsAccess().getRuleConditionsAction_0(),
                          current);
                  
            }

            }

            // InternalVilBuildLanguage.g:768:2: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_EXPONENT)||LA17_0==16||(LA17_0>=28 && LA17_0<=29)||LA17_0==34||LA17_0==37||LA17_0==44||LA17_0==59||(LA17_0>=62 && LA17_0<=65)||(LA17_0>=71 && LA17_0<=73)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVilBuildLanguage.g:769:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:769:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:770:3: lv_postcondition_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPostconditionLogicalExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_24);
                    lv_postcondition_1_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleConditionsRule());
                      	        }
                             		add(
                             			current, 
                             			"postcondition",
                              		lv_postcondition_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
                  
            }
            // InternalVilBuildLanguage.g:790:1: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_EXPONENT)||LA19_0==16||(LA19_0>=28 && LA19_0<=29)||LA19_0==34||LA19_0==37||LA19_0==44||LA19_0==59||(LA19_0>=62 && LA19_0<=65)||(LA19_0>=71 && LA19_0<=73)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalVilBuildLanguage.g:790:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // InternalVilBuildLanguage.g:790:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:791:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:791:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:792:3: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_26);
                    lv_preconditions_3_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleConditionsRule());
                      	        }
                             		add(
                             			current, 
                             			"preconditions",
                              		lv_preconditions_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:808:2: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:808:4: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalVilBuildLanguage.g:812:1: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // InternalVilBuildLanguage.g:813:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // InternalVilBuildLanguage.g:813:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // InternalVilBuildLanguage.g:814:3: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_preconditions_5_0=ruleLogicalExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRuleConditionsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"preconditions",
                    	              		lv_preconditions_5_0, 
                    	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
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
    // $ANTLR end "ruleRuleConditions"


    // $ANTLR start "entryRuleRuleElementBlock"
    // InternalVilBuildLanguage.g:838:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // InternalVilBuildLanguage.g:839:2: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // InternalVilBuildLanguage.g:840:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleElementBlock=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElementBlock; 
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
    // $ANTLR end "entryRuleRuleElementBlock"


    // $ANTLR start "ruleRuleElementBlock"
    // InternalVilBuildLanguage.g:847:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:850:28: ( ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) )
            // InternalVilBuildLanguage.g:851:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            {
            // InternalVilBuildLanguage.g:851:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            // InternalVilBuildLanguage.g:851:2: () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}'
            {
            // InternalVilBuildLanguage.g:851:2: ()
            // InternalVilBuildLanguage.g:852:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRuleElementBlockAccess().getRuleElementBlockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:864:1: ( (lv_elements_2_0= ruleRuleElement ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_EXPONENT)||LA20_0==16||LA20_0==18||(LA20_0>=28 && LA20_0<=32)||LA20_0==34||(LA20_0>=37 && LA20_0<=38)||LA20_0==44||LA20_0==59||(LA20_0>=62 && LA20_0<=65)||(LA20_0>=71 && LA20_0<=77)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:865:1: (lv_elements_2_0= ruleRuleElement )
            	    {
            	    // InternalVilBuildLanguage.g:865:1: (lv_elements_2_0= ruleRuleElement )
            	    // InternalVilBuildLanguage.g:866:3: lv_elements_2_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_elements_2_0=ruleRuleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRuleElementBlockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_2_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRuleElementBlockAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleRuleElementBlock"


    // $ANTLR start "entryRuleRuleElement"
    // InternalVilBuildLanguage.g:894:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // InternalVilBuildLanguage.g:895:2: (iv_ruleRuleElement= ruleRuleElement EOF )
            // InternalVilBuildLanguage.g:896:2: iv_ruleRuleElement= ruleRuleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleElement=ruleRuleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElement; 
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
    // $ANTLR end "entryRuleRuleElement"


    // $ANTLR start "ruleRuleElement"
    // InternalVilBuildLanguage.g:903:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) ) ;
    public final EObject ruleRuleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;

        EObject lv_while_2_0 = null;

        EObject lv_for_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:906:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) ) )
            // InternalVilBuildLanguage.g:907:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )
            {
            // InternalVilBuildLanguage.g:907:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )
            int alt23=4;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalVilBuildLanguage.g:907:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalVilBuildLanguage.g:907:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalVilBuildLanguage.g:908:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalVilBuildLanguage.g:908:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalVilBuildLanguage.g:909:3: lv_varDecl_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_varDecl_0_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      	        }
                             		set(
                             			current, 
                             			"varDecl",
                              		lv_varDecl_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:926:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalVilBuildLanguage.g:926:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalVilBuildLanguage.g:927:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalVilBuildLanguage.g:927:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalVilBuildLanguage.g:928:3: lv_exprStmt_1_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_exprStmt_1_0=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      	        }
                             		set(
                             			current, 
                             			"exprStmt",
                              		lv_exprStmt_1_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.ExpressionStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:945:6: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:945:6: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    // InternalVilBuildLanguage.g:945:7: ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )?
                    {
                    // InternalVilBuildLanguage.g:945:7: ( (lv_while_2_0= ruleWhile ) )
                    // InternalVilBuildLanguage.g:946:1: (lv_while_2_0= ruleWhile )
                    {
                    // InternalVilBuildLanguage.g:946:1: (lv_while_2_0= ruleWhile )
                    // InternalVilBuildLanguage.g:947:3: lv_while_2_0= ruleWhile
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getWhileWhileParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_18);
                    lv_while_2_0=ruleWhile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      	        }
                             		set(
                             			current, 
                             			"while",
                              		lv_while_2_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.While");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:963:2: (otherlv_3= ';' )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==14) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalVilBuildLanguage.g:963:4: otherlv_3= ';'
                            {
                            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getRuleElementAccess().getSemicolonKeyword_2_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:968:6: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:968:6: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    // InternalVilBuildLanguage.g:968:7: ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )?
                    {
                    // InternalVilBuildLanguage.g:968:7: ( (lv_for_4_0= ruleFor ) )
                    // InternalVilBuildLanguage.g:969:1: (lv_for_4_0= ruleFor )
                    {
                    // InternalVilBuildLanguage.g:969:1: (lv_for_4_0= ruleFor )
                    // InternalVilBuildLanguage.g:970:3: lv_for_4_0= ruleFor
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getForForParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_18);
                    lv_for_4_0=ruleFor();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      	        }
                             		set(
                             			current, 
                             			"for",
                              		lv_for_4_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.For");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:986:2: (otherlv_5= ';' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==14) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalVilBuildLanguage.g:986:4: otherlv_5= ';'
                            {
                            otherlv_5=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getRuleElementAccess().getSemicolonKeyword_3_1());
                                  
                            }

                            }
                            break;

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
    // $ANTLR end "ruleRuleElement"


    // $ANTLR start "entryRuleRuleModifier"
    // InternalVilBuildLanguage.g:998:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // InternalVilBuildLanguage.g:999:2: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // InternalVilBuildLanguage.g:1000:2: iv_ruleRuleModifier= ruleRuleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRuleModifier=ruleRuleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleModifier; 
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
    // $ANTLR end "entryRuleRuleModifier"


    // $ANTLR start "ruleRuleModifier"
    // InternalVilBuildLanguage.g:1007:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1010:28: ( ( (lv_protected_0_0= 'protected' ) ) )
            // InternalVilBuildLanguage.g:1011:1: ( (lv_protected_0_0= 'protected' ) )
            {
            // InternalVilBuildLanguage.g:1011:1: ( (lv_protected_0_0= 'protected' ) )
            // InternalVilBuildLanguage.g:1012:1: (lv_protected_0_0= 'protected' )
            {
            // InternalVilBuildLanguage.g:1012:1: (lv_protected_0_0= 'protected' )
            // InternalVilBuildLanguage.g:1013:3: lv_protected_0_0= 'protected'
            {
            lv_protected_0_0=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_protected_0_0, grammarAccess.getRuleModifierAccess().getProtectedProtectedKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRuleModifierRule());
              	        }
                     		setWithLastConsumed(current, "protected", lv_protected_0_0, "protected");
              	    
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
    // $ANTLR end "ruleRuleModifier"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalVilBuildLanguage.g:1034:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalVilBuildLanguage.g:1035:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalVilBuildLanguage.g:1036:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalVilBuildLanguage.g:1043:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        AntlrDatatypeRuleToken lv_field_2_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_alt_6_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1046:28: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) )
            // InternalVilBuildLanguage.g:1047:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            {
            // InternalVilBuildLanguage.g:1047:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_EXPONENT)||LA27_0==16||LA27_0==18||(LA27_0>=28 && LA27_0<=29)||LA27_0==34||LA27_0==37||LA27_0==44||LA27_0==59||(LA27_0>=62 && LA27_0<=65)||(LA27_0>=71 && LA27_0<=73)) ) {
                alt27=1;
            }
            else if ( (LA27_0==32) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalVilBuildLanguage.g:1047:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    {
                    // InternalVilBuildLanguage.g:1047:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    // InternalVilBuildLanguage.g:1047:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
                    {
                    // InternalVilBuildLanguage.g:1047:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
                    int alt25=2;
                    alt25 = dfa25.predict(input);
                    switch (alt25) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1047:4: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                            {
                            // InternalVilBuildLanguage.g:1047:4: ( (lv_var_0_0= ruleIdentifier ) )
                            // InternalVilBuildLanguage.g:1048:1: (lv_var_0_0= ruleIdentifier )
                            {
                            // InternalVilBuildLanguage.g:1048:1: (lv_var_0_0= ruleIdentifier )
                            // InternalVilBuildLanguage.g:1049:3: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_29);
                            lv_var_0_0=ruleIdentifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"var",
                                      		lv_var_0_0, 
                                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalVilBuildLanguage.g:1065:2: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==27) ) {
                                alt24=1;
                            }
                            switch (alt24) {
                                case 1 :
                                    // InternalVilBuildLanguage.g:1065:4: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                                    {
                                    otherlv_1=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_0_1_0());
                                          
                                    }
                                    // InternalVilBuildLanguage.g:1069:1: ( (lv_field_2_0= ruleIdentifier ) )
                                    // InternalVilBuildLanguage.g:1070:1: (lv_field_2_0= ruleIdentifier )
                                    {
                                    // InternalVilBuildLanguage.g:1070:1: (lv_field_2_0= ruleIdentifier )
                                    // InternalVilBuildLanguage.g:1071:3: lv_field_2_0= ruleIdentifier
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_0_1_1_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_22);
                                    lv_field_2_0=ruleIdentifier();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"field",
                                              		lv_field_2_0, 
                                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }

                            otherlv_3=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_0_2());
                                  
                            }

                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:1091:3: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:1092:1: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:1092:1: (lv_expr_4_0= ruleExpression )
                    // InternalVilBuildLanguage.g:1093:3: lv_expr_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_8);
                    lv_expr_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1114:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:1114:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    // InternalVilBuildLanguage.g:1114:7: ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )?
                    {
                    // InternalVilBuildLanguage.g:1114:7: ( (lv_alt_6_0= ruleAlternative ) )
                    // InternalVilBuildLanguage.g:1115:1: (lv_alt_6_0= ruleAlternative )
                    {
                    // InternalVilBuildLanguage.g:1115:1: (lv_alt_6_0= ruleAlternative )
                    // InternalVilBuildLanguage.g:1116:3: lv_alt_6_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getAltAlternativeParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_18);
                    lv_alt_6_0=ruleAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"alt",
                              		lv_alt_6_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.Alternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:1132:2: (otherlv_7= ';' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==14) ) {
                        int LA26_1 = input.LA(2);

                        if ( (synpred32_InternalVilBuildLanguage()) ) {
                            alt26=1;
                        }
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1132:4: otherlv_7= ';'
                            {
                            otherlv_7=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1_1());
                                  
                            }

                            }
                            break;

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
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalVilBuildLanguage.g:1144:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalVilBuildLanguage.g:1145:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalVilBuildLanguage.g:1146:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalVilBuildLanguage.g:1153:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_sysEx_3_0 = null;

        EObject lv_map_4_0 = null;

        EObject lv_join_5_0 = null;

        EObject lv_instantiate_6_0 = null;

        EObject lv_newEx_7_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1156:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // InternalVilBuildLanguage.g:1157:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // InternalVilBuildLanguage.g:1157:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt28=8;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalVilBuildLanguage.g:1157:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1157:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // InternalVilBuildLanguage.g:1158:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // InternalVilBuildLanguage.g:1158:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // InternalVilBuildLanguage.g:1159:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_otherEx_0_0=ruleExpressionOrQualifiedExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"otherEx",
                              		lv_otherEx_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ExpressionOrQualifiedExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1176:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1176:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // InternalVilBuildLanguage.g:1177:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // InternalVilBuildLanguage.g:1177:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // InternalVilBuildLanguage.g:1178:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_unqEx_1_0=ruleUnqualifiedExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"unqEx",
                              		lv_unqEx_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.UnqualifiedExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:1195:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1195:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // InternalVilBuildLanguage.g:1196:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // InternalVilBuildLanguage.g:1196:1: (lv_superEx_2_0= ruleSuperExecution )
                    // InternalVilBuildLanguage.g:1197:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_superEx_2_0=ruleSuperExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"superEx",
                              		lv_superEx_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SuperExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:1214:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1214:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // InternalVilBuildLanguage.g:1215:1: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // InternalVilBuildLanguage.g:1215:1: (lv_sysEx_3_0= ruleSystemExecution )
                    // InternalVilBuildLanguage.g:1216:3: lv_sysEx_3_0= ruleSystemExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSysExSystemExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_sysEx_3_0=ruleSystemExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"sysEx",
                              		lv_sysEx_3_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.SystemExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalVilBuildLanguage.g:1233:6: ( (lv_map_4_0= ruleMap ) )
                    {
                    // InternalVilBuildLanguage.g:1233:6: ( (lv_map_4_0= ruleMap ) )
                    // InternalVilBuildLanguage.g:1234:1: (lv_map_4_0= ruleMap )
                    {
                    // InternalVilBuildLanguage.g:1234:1: (lv_map_4_0= ruleMap )
                    // InternalVilBuildLanguage.g:1235:3: lv_map_4_0= ruleMap
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMapMapParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_map_4_0=ruleMap();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"map",
                              		lv_map_4_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.Map");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalVilBuildLanguage.g:1252:6: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // InternalVilBuildLanguage.g:1252:6: ( (lv_join_5_0= ruleJoin ) )
                    // InternalVilBuildLanguage.g:1253:1: (lv_join_5_0= ruleJoin )
                    {
                    // InternalVilBuildLanguage.g:1253:1: (lv_join_5_0= ruleJoin )
                    // InternalVilBuildLanguage.g:1254:3: lv_join_5_0= ruleJoin
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getJoinJoinParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_join_5_0=ruleJoin();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"join",
                              		lv_join_5_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.Join");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalVilBuildLanguage.g:1271:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // InternalVilBuildLanguage.g:1271:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // InternalVilBuildLanguage.g:1272:1: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // InternalVilBuildLanguage.g:1272:1: (lv_instantiate_6_0= ruleInstantiate )
                    // InternalVilBuildLanguage.g:1273:3: lv_instantiate_6_0= ruleInstantiate
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInstantiateInstantiateParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_instantiate_6_0=ruleInstantiate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"instantiate",
                              		lv_instantiate_6_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.Instantiate");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalVilBuildLanguage.g:1290:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1290:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // InternalVilBuildLanguage.g:1291:1: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // InternalVilBuildLanguage.g:1291:1: (lv_newEx_7_0= ruleConstructorExecution )
                    // InternalVilBuildLanguage.g:1292:3: lv_newEx_7_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_newEx_7_0=ruleConstructorExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"newEx",
                              		lv_newEx_7_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ConstructorExecution");
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleInstantiate"
    // InternalVilBuildLanguage.g:1316:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // InternalVilBuildLanguage.g:1317:2: (iv_ruleInstantiate= ruleInstantiate EOF )
            // InternalVilBuildLanguage.g:1318:2: iv_ruleInstantiate= ruleInstantiate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstantiateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInstantiate=ruleInstantiate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstantiate; 
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
    // $ANTLR end "entryRuleInstantiate"


    // $ANTLR start "ruleInstantiate"
    // InternalVilBuildLanguage.g:1325:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleInstantiate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ruleName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_project_1_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_versionSpec_6_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1328:28: ( (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) )
            // InternalVilBuildLanguage.g:1329:1: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            {
            // InternalVilBuildLanguage.g:1329:1: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            // InternalVilBuildLanguage.g:1329:3: otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:1333:1: ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_VERSION||(LA29_0>=RULE_ID && LA29_0<=RULE_EXPONENT)||LA29_0==44) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_STRING) ) {
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
                    // InternalVilBuildLanguage.g:1333:2: ( (lv_project_1_0= ruleIdentifier ) )
                    {
                    // InternalVilBuildLanguage.g:1333:2: ( (lv_project_1_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:1334:1: (lv_project_1_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:1334:1: (lv_project_1_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:1335:3: lv_project_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getProjectIdentifierParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_11);
                    lv_project_1_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstantiateRule());
                      	        }
                             		set(
                             			current, 
                             			"project",
                              		lv_project_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1352:6: ( (lv_ruleName_2_0= RULE_STRING ) )
                    {
                    // InternalVilBuildLanguage.g:1352:6: ( (lv_ruleName_2_0= RULE_STRING ) )
                    // InternalVilBuildLanguage.g:1353:1: (lv_ruleName_2_0= RULE_STRING )
                    {
                    // InternalVilBuildLanguage.g:1353:1: (lv_ruleName_2_0= RULE_STRING )
                    // InternalVilBuildLanguage.g:1354:3: lv_ruleName_2_0= RULE_STRING
                    {
                    lv_ruleName_2_0=(Token)match(input,RULE_STRING,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_ruleName_2_0, grammarAccess.getInstantiateAccess().getRuleNameSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInstantiateRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"ruleName",
                              		lv_ruleName_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,16,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalVilBuildLanguage.g:1374:1: ( (lv_param_4_0= ruleArgumentList ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_EXPONENT)||LA30_0==16||LA30_0==18||(LA30_0>=28 && LA30_0<=29)||LA30_0==34||LA30_0==37||LA30_0==44||LA30_0==59||(LA30_0>=62 && LA30_0<=65)||(LA30_0>=71 && LA30_0<=73)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalVilBuildLanguage.g:1375:1: (lv_param_4_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:1375:1: (lv_param_4_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:1376:3: lv_param_4_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_param_4_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstantiateRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalVilBuildLanguage.g:1396:1: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==35) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalVilBuildLanguage.g:1397:1: (lv_versionSpec_6_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:1397:1: (lv_versionSpec_6_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:1398:3: lv_versionSpec_6_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getVersionSpecVersionSpecParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_versionSpec_6_0=ruleVersionSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstantiateRule());
                      	        }
                             		set(
                             			current, 
                             			"versionSpec",
                              		lv_versionSpec_6_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionSpec");
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
    // $ANTLR end "ruleInstantiate"


    // $ANTLR start "entryRuleLoopVariable"
    // InternalVilBuildLanguage.g:1422:1: entryRuleLoopVariable returns [EObject current=null] : iv_ruleLoopVariable= ruleLoopVariable EOF ;
    public final EObject entryRuleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariable = null;


        try {
            // InternalVilBuildLanguage.g:1423:2: (iv_ruleLoopVariable= ruleLoopVariable EOF )
            // InternalVilBuildLanguage.g:1424:2: iv_ruleLoopVariable= ruleLoopVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopVariable=ruleLoopVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopVariable; 
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
    // $ANTLR end "entryRuleLoopVariable"


    // $ANTLR start "ruleLoopVariable"
    // InternalVilBuildLanguage.g:1431:1: ruleLoopVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1434:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // InternalVilBuildLanguage.g:1435:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // InternalVilBuildLanguage.g:1435:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // InternalVilBuildLanguage.g:1435:2: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // InternalVilBuildLanguage.g:1435:2: ( (lv_type_0_0= ruleType ) )?
            int alt32=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_VERSION||(LA32_1>=RULE_ID && LA32_1<=RULE_EXPONENT)||LA32_1==44||LA32_1==70) ) {
                        alt32=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_VERSION||(LA32_2>=RULE_ID && LA32_2<=RULE_EXPONENT)||LA32_2==44||LA32_2==70) ) {
                        alt32=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA32_3 = input.LA(2);

                    if ( (LA32_3==RULE_VERSION||(LA32_3>=RULE_ID && LA32_3<=RULE_EXPONENT)||LA32_3==44||LA32_3==70) ) {
                        alt32=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA32_4 = input.LA(2);

                    if ( (LA32_4==RULE_VERSION||(LA32_4>=RULE_ID && LA32_4<=RULE_EXPONENT)||LA32_4==44||LA32_4==70) ) {
                        alt32=1;
                    }
                    }
                    break;
                case 74:
                case 75:
                case 76:
                case 77:
                    {
                    alt32=1;
                    }
                    break;
            }

            switch (alt32) {
                case 1 :
                    // InternalVilBuildLanguage.g:1436:1: (lv_type_0_0= ruleType )
                    {
                    // InternalVilBuildLanguage.g:1436:1: (lv_type_0_0= ruleType )
                    // InternalVilBuildLanguage.g:1437:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopVariableAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_type_0_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLoopVariableRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:1453:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:1454:1: (lv_var_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:1454:1: (lv_var_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:1455:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_var_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopVariableRule());
              	        }
                     		set(
                     			current, 
                     			"var",
                      		lv_var_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
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
    // $ANTLR end "ruleLoopVariable"


    // $ANTLR start "entryRuleMap"
    // InternalVilBuildLanguage.g:1479:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalVilBuildLanguage.g:1480:2: (iv_ruleMap= ruleMap EOF )
            // InternalVilBuildLanguage.g:1481:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
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
    // $ANTLR end "entryRuleMap"


    // $ANTLR start "ruleMap"
    // InternalVilBuildLanguage.g:1488:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleMap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_separator_5_1=null;
        Token lv_separator_5_2=null;
        Token otherlv_7=null;
        EObject lv_var_2_0 = null;

        EObject lv_var_4_0 = null;

        EObject lv_expr_6_0 = null;

        EObject lv_block_8_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1491:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1492:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1492:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1492:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:1500:1: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalVilBuildLanguage.g:1501:1: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalVilBuildLanguage.g:1501:1: (lv_var_2_0= ruleLoopVariable )
            // InternalVilBuildLanguage.g:1502:3: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
            lv_var_2_0=ruleLoopVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapRule());
              	        }
                     		add(
                     			current, 
                     			"var",
                      		lv_var_2_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.LoopVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:1518:2: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==25) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:1518:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:1522:1: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalVilBuildLanguage.g:1523:1: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalVilBuildLanguage.g:1523:1: (lv_var_4_0= ruleLoopVariable )
            	    // InternalVilBuildLanguage.g:1524:3: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_var_4_0=ruleLoopVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMapRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"var",
            	              		lv_var_4_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.LoopVariable");
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

            // InternalVilBuildLanguage.g:1540:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalVilBuildLanguage.g:1541:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalVilBuildLanguage.g:1541:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalVilBuildLanguage.g:1542:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalVilBuildLanguage.g:1542:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==23) ) {
                alt34=1;
            }
            else if ( (LA34_0==24) ) {
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
                    // InternalVilBuildLanguage.g:1543:3: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_separator_5_1, grammarAccess.getMapAccess().getSeparatorEqualsSignKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMapRule());
                      	        }
                             		setWithLastConsumed(current, "separator", lv_separator_5_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1555:8: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_separator_5_2, grammarAccess.getMapAccess().getSeparatorColonKeyword_4_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMapRule());
                      	        }
                             		setWithLastConsumed(current, "separator", lv_separator_5_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalVilBuildLanguage.g:1570:2: ( (lv_expr_6_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1571:1: (lv_expr_6_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1571:1: (lv_expr_6_0= ruleExpression )
            // InternalVilBuildLanguage.g:1572:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_expr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_6_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
                  
            }
            // InternalVilBuildLanguage.g:1592:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1593:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1593:1: (lv_block_8_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1594:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_block_8_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_8_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElementBlock");
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
    // $ANTLR end "ruleMap"


    // $ANTLR start "entryRuleFor"
    // InternalVilBuildLanguage.g:1618:1: entryRuleFor returns [EObject current=null] : iv_ruleFor= ruleFor EOF ;
    public final EObject entryRuleFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor = null;


        try {
            // InternalVilBuildLanguage.g:1619:2: (iv_ruleFor= ruleFor EOF )
            // InternalVilBuildLanguage.g:1620:2: iv_ruleFor= ruleFor EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFor=ruleFor();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFor; 
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
    // $ANTLR end "entryRuleFor"


    // $ANTLR start "ruleFor"
    // InternalVilBuildLanguage.g:1627:1: ruleFor returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleFor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_separator_5_1=null;
        Token lv_separator_5_2=null;
        Token otherlv_7=null;
        EObject lv_var_2_0 = null;

        EObject lv_var_4_0 = null;

        EObject lv_expr_6_0 = null;

        EObject lv_block_8_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1630:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1631:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1631:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1631:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getForAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getForAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:1639:1: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalVilBuildLanguage.g:1640:1: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalVilBuildLanguage.g:1640:1: (lv_var_2_0= ruleLoopVariable )
            // InternalVilBuildLanguage.g:1641:3: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_34);
            lv_var_2_0=ruleLoopVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForRule());
              	        }
                     		add(
                     			current, 
                     			"var",
                      		lv_var_2_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.LoopVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:1657:2: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==25) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:1657:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getForAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:1661:1: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalVilBuildLanguage.g:1662:1: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalVilBuildLanguage.g:1662:1: (lv_var_4_0= ruleLoopVariable )
            	    // InternalVilBuildLanguage.g:1663:3: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_var_4_0=ruleLoopVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getForRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"var",
            	              		lv_var_4_0, 
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.LoopVariable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalVilBuildLanguage.g:1679:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalVilBuildLanguage.g:1680:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalVilBuildLanguage.g:1680:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalVilBuildLanguage.g:1681:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalVilBuildLanguage.g:1681:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==23) ) {
                alt36=1;
            }
            else if ( (LA36_0==24) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalVilBuildLanguage.g:1682:3: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_separator_5_1, grammarAccess.getForAccess().getSeparatorEqualsSignKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getForRule());
                      	        }
                             		setWithLastConsumed(current, "separator", lv_separator_5_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1694:8: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_separator_5_2, grammarAccess.getForAccess().getSeparatorColonKeyword_4_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getForRule());
                      	        }
                             		setWithLastConsumed(current, "separator", lv_separator_5_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalVilBuildLanguage.g:1709:2: ( (lv_expr_6_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1710:1: (lv_expr_6_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1710:1: (lv_expr_6_0= ruleExpression )
            // InternalVilBuildLanguage.g:1711:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_expr_6_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_6_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getForAccess().getRightParenthesisKeyword_6());
                  
            }
            // InternalVilBuildLanguage.g:1731:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1732:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1732:1: (lv_block_8_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1733:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_block_8_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_8_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElementBlock");
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
    // $ANTLR end "ruleFor"


    // $ANTLR start "entryRuleWhile"
    // InternalVilBuildLanguage.g:1757:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalVilBuildLanguage.g:1758:2: (iv_ruleWhile= ruleWhile EOF )
            // InternalVilBuildLanguage.g:1759:2: iv_ruleWhile= ruleWhile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhile=ruleWhile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhile; 
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
    // $ANTLR end "entryRuleWhile"


    // $ANTLR start "ruleWhile"
    // InternalVilBuildLanguage.g:1766:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;

        EObject lv_block_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1769:28: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1770:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1770:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1770:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:1778:1: ( (lv_expr_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1779:1: (lv_expr_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1779:1: (lv_expr_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:1780:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getWhileAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalVilBuildLanguage.g:1800:1: ( (lv_block_4_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1801:1: (lv_block_4_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1801:1: (lv_block_4_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1802:3: lv_block_4_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileAccess().getBlockRuleElementBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_block_4_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_4_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElementBlock");
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
    // $ANTLR end "ruleWhile"


    // $ANTLR start "entryRuleAlternative"
    // InternalVilBuildLanguage.g:1826:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalVilBuildLanguage.g:1827:2: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalVilBuildLanguage.g:1828:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
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
    // $ANTLR end "entryRuleAlternative"


    // $ANTLR start "ruleAlternative"
    // InternalVilBuildLanguage.g:1835:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
    public final EObject ruleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expr_2_0 = null;

        EObject lv_if_4_0 = null;

        EObject lv_else_6_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1838:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // InternalVilBuildLanguage.g:1839:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // InternalVilBuildLanguage.g:1839:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // InternalVilBuildLanguage.g:1839:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:1847:1: ( (lv_expr_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1848:1: (lv_expr_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1848:1: (lv_expr_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:1849:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAlternativeRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalVilBuildLanguage.g:1869:1: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // InternalVilBuildLanguage.g:1870:1: (lv_if_4_0= ruleStatementOrBlock )
            {
            // InternalVilBuildLanguage.g:1870:1: (lv_if_4_0= ruleStatementOrBlock )
            // InternalVilBuildLanguage.g:1871:3: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_36);
            lv_if_4_0=ruleStatementOrBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAlternativeRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_4_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.StatementOrBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:1887:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred49_InternalVilBuildLanguage()) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalVilBuildLanguage.g:1887:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // InternalVilBuildLanguage.g:1887:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalVilBuildLanguage.g:1887:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // InternalVilBuildLanguage.g:1892:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // InternalVilBuildLanguage.g:1893:1: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // InternalVilBuildLanguage.g:1893:1: (lv_else_6_0= ruleStatementOrBlock )
                    // InternalVilBuildLanguage.g:1894:3: lv_else_6_0= ruleStatementOrBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleStatementOrBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAlternativeRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_6_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.StatementOrBlock");
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
    // $ANTLR end "ruleAlternative"


    // $ANTLR start "entryRuleStatementOrBlock"
    // InternalVilBuildLanguage.g:1918:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // InternalVilBuildLanguage.g:1919:2: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // InternalVilBuildLanguage.g:1920:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementOrBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementOrBlock=ruleStatementOrBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementOrBlock; 
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
    // $ANTLR end "entryRuleStatementOrBlock"


    // $ANTLR start "ruleStatementOrBlock"
    // InternalVilBuildLanguage.g:1927:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1930:28: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1931:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1931:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // InternalVilBuildLanguage.g:1931:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // InternalVilBuildLanguage.g:1931:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // InternalVilBuildLanguage.g:1932:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // InternalVilBuildLanguage.g:1932:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    // InternalVilBuildLanguage.g:1933:3: lv_exStmt_0_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_exStmt_0_0=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementOrBlockRule());
                      	        }
                             		set(
                             			current, 
                             			"exStmt",
                              		lv_exStmt_0_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.ExpressionStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:1950:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // InternalVilBuildLanguage.g:1950:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // InternalVilBuildLanguage.g:1951:1: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // InternalVilBuildLanguage.g:1951:1: (lv_block_1_0= ruleRuleElementBlock )
                    // InternalVilBuildLanguage.g:1952:3: lv_block_1_0= ruleRuleElementBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getBlockRuleElementBlockParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_1_0=ruleRuleElementBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementOrBlockRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_1_0, 
                              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleElementBlock");
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
    // $ANTLR end "ruleStatementOrBlock"


    // $ANTLR start "entryRuleJoin"
    // InternalVilBuildLanguage.g:1976:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalVilBuildLanguage.g:1977:2: (iv_ruleJoin= ruleJoin EOF )
            // InternalVilBuildLanguage.g:1978:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
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
    // $ANTLR end "entryRuleJoin"


    // $ANTLR start "ruleJoin"
    // InternalVilBuildLanguage.g:1985:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_var1_2_0 = null;

        EObject lv_var2_4_0 = null;

        EObject lv_condition_8_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:1988:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // InternalVilBuildLanguage.g:1989:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // InternalVilBuildLanguage.g:1989:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // InternalVilBuildLanguage.g:1989:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:1997:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // InternalVilBuildLanguage.g:1998:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // InternalVilBuildLanguage.g:1998:1: (lv_var1_2_0= ruleJoinVariable )
            // InternalVilBuildLanguage.g:1999:3: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_38);
            lv_var1_2_0=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJoinRule());
              	        }
                     		set(
                     			current, 
                     			"var1",
                      		lv_var1_2_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // InternalVilBuildLanguage.g:2019:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // InternalVilBuildLanguage.g:2020:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // InternalVilBuildLanguage.g:2020:1: (lv_var2_4_0= ruleJoinVariable )
            // InternalVilBuildLanguage.g:2021:3: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_var2_4_0=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJoinRule());
              	        }
                     		set(
                     			current, 
                     			"var2",
                      		lv_var2_4_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // InternalVilBuildLanguage.g:2041:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalVilBuildLanguage.g:2041:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // InternalVilBuildLanguage.g:2049:1: ( (lv_condition_8_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2050:1: (lv_condition_8_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2050:1: (lv_condition_8_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2051:3: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_condition_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJoinRule());
                      	        }
                             		set(
                             			current, 
                             			"condition",
                              		lv_condition_8_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getJoinAccess().getRightParenthesisKeyword_6_3());
                          
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
    // $ANTLR end "ruleJoin"


    // $ANTLR start "entryRuleJoinVariable"
    // InternalVilBuildLanguage.g:2079:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // InternalVilBuildLanguage.g:2080:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // InternalVilBuildLanguage.g:2081:2: iv_ruleJoinVariable= ruleJoinVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJoinVariable=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoinVariable; 
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
    // $ANTLR end "entryRuleJoinVariable"


    // $ANTLR start "ruleJoinVariable"
    // InternalVilBuildLanguage.g:2088:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2091:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:2092:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:2092:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:2092:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // InternalVilBuildLanguage.g:2092:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==36) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalVilBuildLanguage.g:2093:1: (lv_excl_0_0= 'exclude' )
                    {
                    // InternalVilBuildLanguage.g:2093:1: (lv_excl_0_0= 'exclude' )
                    // InternalVilBuildLanguage.g:2094:3: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,36,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_excl_0_0, grammarAccess.getJoinVariableAccess().getExclExcludeKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getJoinVariableRule());
                      	        }
                             		setWithLastConsumed(current, "excl", lv_excl_0_0, "exclude");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:2107:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2108:1: (lv_var_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2108:1: (lv_var_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2109:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_24);
            lv_var_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJoinVariableRule());
              	        }
                     		set(
                     			current, 
                     			"var",
                      		lv_var_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
                  
            }
            // InternalVilBuildLanguage.g:2129:1: ( (lv_expr_3_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:2130:1: (lv_expr_3_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:2130:1: (lv_expr_3_0= ruleExpression )
            // InternalVilBuildLanguage.g:2131:3: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getExprExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expr_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJoinVariableRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_3_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
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
    // $ANTLR end "ruleJoinVariable"


    // $ANTLR start "entryRuleSystemExecution"
    // InternalVilBuildLanguage.g:2155:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // InternalVilBuildLanguage.g:2156:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // InternalVilBuildLanguage.g:2157:2: iv_ruleSystemExecution= ruleSystemExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemExecutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSystemExecution=ruleSystemExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemExecution; 
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
    // $ANTLR end "entryRuleSystemExecution"


    // $ANTLR start "ruleSystemExecution"
    // InternalVilBuildLanguage.g:2164:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2167:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:2168:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:2168:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:2168:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,37,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:2172:1: ( (lv_call_1_0= ruleCall ) )
            // InternalVilBuildLanguage.g:2173:1: (lv_call_1_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:2173:1: (lv_call_1_0= ruleCall )
            // InternalVilBuildLanguage.g:2174:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
            lv_call_1_0=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSystemExecutionRule());
              	        }
                     		set(
                     			current, 
                     			"call",
                      		lv_call_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2190:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==27||(LA41_0>=66 && LA41_0<=67)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2191:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:2191:1: (lv_calls_2_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:2192:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_calls_2_0=ruleSubCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSystemExecutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalVilBuildLanguage.g:2216:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:2217:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalVilBuildLanguage.g:2218:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalVilBuildLanguage.g:2225:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_const_0_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2228:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // InternalVilBuildLanguage.g:2229:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // InternalVilBuildLanguage.g:2229:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // InternalVilBuildLanguage.g:2229:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // InternalVilBuildLanguage.g:2229:2: ( (lv_const_0_0= 'const' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==38) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalVilBuildLanguage.g:2230:1: (lv_const_0_0= 'const' )
                    {
                    // InternalVilBuildLanguage.g:2230:1: (lv_const_0_0= 'const' )
                    // InternalVilBuildLanguage.g:2231:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,38,FOLLOW_21); if (state.failed) return current;
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

            // InternalVilBuildLanguage.g:2244:3: ( (lv_type_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:2245:1: (lv_type_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2245:1: (lv_type_1_0= ruleType )
            // InternalVilBuildLanguage.g:2246:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2262:2: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2263:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2263:1: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2264:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_40);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2280:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==23) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalVilBuildLanguage.g:2280:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalVilBuildLanguage.g:2284:1: ( (lv_expression_4_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2285:1: (lv_expression_4_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2285:1: (lv_expression_4_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2286:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_8);
                    lv_expression_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCompound"
    // InternalVilBuildLanguage.g:2314:1: entryRuleCompound returns [EObject current=null] : iv_ruleCompound= ruleCompound EOF ;
    public final EObject entryRuleCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompound = null;


        try {
            // InternalVilBuildLanguage.g:2315:2: (iv_ruleCompound= ruleCompound EOF )
            // InternalVilBuildLanguage.g:2316:2: iv_ruleCompound= ruleCompound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompound=ruleCompound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompound; 
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
    // $ANTLR end "entryRuleCompound"


    // $ANTLR start "ruleCompound"
    // InternalVilBuildLanguage.g:2323:1: ruleCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' ) ;
    public final EObject ruleCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        EObject lv_vars_6_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2326:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' ) )
            // InternalVilBuildLanguage.g:2327:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )
            {
            // InternalVilBuildLanguage.g:2327:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' )
            // InternalVilBuildLanguage.g:2327:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}'
            {
            // InternalVilBuildLanguage.g:2327:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==39) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalVilBuildLanguage.g:2328:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalVilBuildLanguage.g:2328:1: (lv_abstract_0_0= 'abstract' )
                    // InternalVilBuildLanguage.g:2329:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,39,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_abstract_0_0, grammarAccess.getCompoundAccess().getAbstractAbstractKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCompoundRule());
                      	        }
                             		setWithLastConsumed(current, "abstract", lv_abstract_0_0, "abstract");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,40,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCompoundAccess().getCompoundKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:2346:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2347:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2347:1: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2348:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCompoundAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_42);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCompoundRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2364:2: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==41) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalVilBuildLanguage.g:2364:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCompoundAccess().getRefinesKeyword_3_0());
                          
                    }
                    // InternalVilBuildLanguage.g:2368:1: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:2369:1: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:2369:1: (lv_super_4_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:2370:3: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_15);
                    lv_super_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCompoundRule());
                      	        }
                             		set(
                             			current, 
                             			"super",
                              		lv_super_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCompoundAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalVilBuildLanguage.g:2390:1: ( (lv_vars_6_0= ruleVariableDeclaration ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_VERSION||(LA46_0>=RULE_ID && LA46_0<=RULE_EXPONENT)||LA46_0==38||LA46_0==44||(LA46_0>=74 && LA46_0<=77)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2391:1: (lv_vars_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:2391:1: (lv_vars_6_0= ruleVariableDeclaration )
            	    // InternalVilBuildLanguage.g:2392:3: lv_vars_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompoundAccess().getVarsVariableDeclarationParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_vars_6_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCompoundRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"vars",
            	              		lv_vars_6_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_7=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCompoundAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleCompound"


    // $ANTLR start "entryRuleTypeDef"
    // InternalVilBuildLanguage.g:2420:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalVilBuildLanguage.g:2421:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalVilBuildLanguage.g:2422:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
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
    // $ANTLR end "entryRuleTypeDef"


    // $ANTLR start "ruleTypeDef"
    // InternalVilBuildLanguage.g:2429:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2432:28: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:2433:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:2433:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:2433:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:2437:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2438:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2438:1: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2439:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_21);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2455:2: ( (lv_type_2_0= ruleType ) )
            // InternalVilBuildLanguage.g:2456:1: (lv_type_2_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2456:1: (lv_type_2_0= ruleType )
            // InternalVilBuildLanguage.g:2457:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDefRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypeDefAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleTypeDef"


    // $ANTLR start "entryRuleAdvice"
    // InternalVilBuildLanguage.g:2485:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalVilBuildLanguage.g:2486:2: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalVilBuildLanguage.g:2487:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
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
    // $ANTLR end "entryRuleAdvice"


    // $ANTLR start "ruleAdvice"
    // InternalVilBuildLanguage.g:2494:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2497:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // InternalVilBuildLanguage.g:2498:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // InternalVilBuildLanguage.g:2498:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // InternalVilBuildLanguage.g:2498:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:2506:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalVilBuildLanguage.g:2507:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalVilBuildLanguage.g:2507:1: (lv_name_2_0= ruleQualifiedName )
            // InternalVilBuildLanguage.g:2508:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_13);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAdviceRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalVilBuildLanguage.g:2528:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==35) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalVilBuildLanguage.g:2529:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:2529:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:2530:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_versionSpec_4_0=ruleVersionSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAdviceRule());
                      	        }
                             		set(
                             			current, 
                             			"versionSpec",
                              		lv_versionSpec_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionSpec");
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
    // $ANTLR end "ruleAdvice"


    // $ANTLR start "entryRuleVersionSpec"
    // InternalVilBuildLanguage.g:2554:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // InternalVilBuildLanguage.g:2555:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // InternalVilBuildLanguage.g:2556:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
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
    // $ANTLR end "entryRuleVersionSpec"


    // $ANTLR start "ruleVersionSpec"
    // InternalVilBuildLanguage.g:2563:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2566:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:2567:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:2567:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:2567:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:2571:1: ( (lv_restriction_1_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:2572:1: (lv_restriction_1_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:2572:1: (lv_restriction_1_0= ruleExpression )
            // InternalVilBuildLanguage.g:2573:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_restriction_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionSpecRule());
              	        }
                     		set(
                     			current, 
                     			"restriction",
                      		lv_restriction_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
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
    // $ANTLR end "ruleVersionSpec"


    // $ANTLR start "entryRuleParameterList"
    // InternalVilBuildLanguage.g:2597:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalVilBuildLanguage.g:2598:2: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalVilBuildLanguage.g:2599:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
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
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalVilBuildLanguage.g:2606:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2609:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // InternalVilBuildLanguage.g:2610:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // InternalVilBuildLanguage.g:2610:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // InternalVilBuildLanguage.g:2610:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // InternalVilBuildLanguage.g:2610:2: ( (lv_param_0_0= ruleParameter ) )
            // InternalVilBuildLanguage.g:2611:1: (lv_param_0_0= ruleParameter )
            {
            // InternalVilBuildLanguage.g:2611:1: (lv_param_0_0= ruleParameter )
            // InternalVilBuildLanguage.g:2612:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_param_0_0=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterListRule());
              	        }
                     		add(
                     			current, 
                     			"param",
                      		lv_param_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Parameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2628:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==25) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2628:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:2632:1: ( (lv_param_2_0= ruleParameter ) )
            	    // InternalVilBuildLanguage.g:2633:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // InternalVilBuildLanguage.g:2633:1: (lv_param_2_0= ruleParameter )
            	    // InternalVilBuildLanguage.g:2634:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_param_2_0=ruleParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"param",
            	              		lv_param_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Parameter");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // InternalVilBuildLanguage.g:2658:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalVilBuildLanguage.g:2659:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalVilBuildLanguage.g:2660:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalVilBuildLanguage.g:2667:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dflt_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2670:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) )
            // InternalVilBuildLanguage.g:2671:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            {
            // InternalVilBuildLanguage.g:2671:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            // InternalVilBuildLanguage.g:2671:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            {
            // InternalVilBuildLanguage.g:2671:2: ( (lv_type_0_0= ruleType ) )
            // InternalVilBuildLanguage.g:2672:1: (lv_type_0_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2672:1: (lv_type_0_0= ruleType )
            // InternalVilBuildLanguage.g:2673:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_10);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2689:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2690:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2690:1: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2691:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_44);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2707:2: (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalVilBuildLanguage.g:2707:4: otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // InternalVilBuildLanguage.g:2711:1: ( (lv_dflt_3_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2712:1: (lv_dflt_3_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2712:1: (lv_dflt_3_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2713:3: lv_dflt_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getParameterAccess().getDfltExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_dflt_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getParameterRule());
                      	        }
                             		set(
                             			current, 
                             			"dflt",
                              		lv_dflt_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleVersionStmt"
    // InternalVilBuildLanguage.g:2737:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalVilBuildLanguage.g:2738:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalVilBuildLanguage.g:2739:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalVilBuildLanguage.g:2746:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2749:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalVilBuildLanguage.g:2750:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalVilBuildLanguage.g:2750:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalVilBuildLanguage.g:2750:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:2754:1: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalVilBuildLanguage.g:2755:1: (lv_version_1_0= RULE_VERSION )
            {
            // InternalVilBuildLanguage.g:2755:1: (lv_version_1_0= RULE_VERSION )
            // InternalVilBuildLanguage.g:2756:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_8); if (state.failed) return current;
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VERSION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleImport"
    // InternalVilBuildLanguage.g:2784:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalVilBuildLanguage.g:2785:2: (iv_ruleImport= ruleImport EOF )
            // InternalVilBuildLanguage.g:2786:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalVilBuildLanguage.g:2793:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2796:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:2797:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:2797:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // InternalVilBuildLanguage.g:2797:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:2801:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2802:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2802:1: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2803:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_46);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2819:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==35) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalVilBuildLanguage.g:2820:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:2820:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:2821:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_8);
                    lv_versionSpec_2_0=ruleVersionSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImportRule());
                      	        }
                             		set(
                             			current, 
                             			"versionSpec",
                              		lv_versionSpec_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionSpec");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getImportAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleExpression"
    // InternalVilBuildLanguage.g:2849:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalVilBuildLanguage.g:2850:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalVilBuildLanguage.g:2851:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalVilBuildLanguage.g:2858:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2861:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // InternalVilBuildLanguage.g:2862:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // InternalVilBuildLanguage.g:2862:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_EXPONENT)||LA51_0==16||(LA51_0>=28 && LA51_0<=29)||LA51_0==34||LA51_0==37||LA51_0==44||LA51_0==59||(LA51_0>=62 && LA51_0<=65)||(LA51_0>=71 && LA51_0<=73)) ) {
                alt51=1;
            }
            else if ( (LA51_0==18) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalVilBuildLanguage.g:2862:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // InternalVilBuildLanguage.g:2862:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:2863:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:2863:1: (lv_expr_0_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:2864:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_0_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expr",
                              		lv_expr_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:2881:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // InternalVilBuildLanguage.g:2881:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // InternalVilBuildLanguage.g:2882:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // InternalVilBuildLanguage.g:2882:1: (lv_init_1_0= ruleContainerInitializer )
                    // InternalVilBuildLanguage.g:2883:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_init_1_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"init",
                              		lv_init_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ContainerInitializer");
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


    // $ANTLR start "entryRuleLogicalExpression"
    // InternalVilBuildLanguage.g:2907:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalVilBuildLanguage.g:2908:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalVilBuildLanguage.g:2909:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalVilBuildLanguage.g:2916:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2919:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalVilBuildLanguage.g:2920:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalVilBuildLanguage.g:2920:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalVilBuildLanguage.g:2920:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalVilBuildLanguage.g:2920:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalVilBuildLanguage.g:2921:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalVilBuildLanguage.g:2921:1: (lv_left_0_0= ruleEqualityExpression )
            // InternalVilBuildLanguage.g:2922:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2938:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop52:
            do {
                int alt52=2;
                switch ( input.LA(1) ) {
                case 46:
                    {
                    int LA52_2 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 47:
                    {
                    int LA52_3 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 48:
                    {
                    int LA52_4 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA52_5 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt52=1;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA52_6 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt52=1;
                    }


                    }
                    break;

                }

                switch (alt52) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2939:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalVilBuildLanguage.g:2939:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalVilBuildLanguage.g:2940:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_47);
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
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalVilBuildLanguage.g:2964:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:2965:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalVilBuildLanguage.g:2966:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalVilBuildLanguage.g:2973:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:2976:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalVilBuildLanguage.g:2977:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalVilBuildLanguage.g:2977:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalVilBuildLanguage.g:2977:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalVilBuildLanguage.g:2977:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalVilBuildLanguage.g:2978:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalVilBuildLanguage.g:2978:1: (lv_op_0_0= ruleLogicalOperator )
            // InternalVilBuildLanguage.g:2979:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:2995:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalVilBuildLanguage.g:2996:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalVilBuildLanguage.g:2996:1: (lv_ex_1_0= ruleEqualityExpression )
            // InternalVilBuildLanguage.g:2997:3: lv_ex_1_0= ruleEqualityExpression
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityExpression");
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
    // InternalVilBuildLanguage.g:3021:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalVilBuildLanguage.g:3022:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalVilBuildLanguage.g:3023:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalVilBuildLanguage.g:3030:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3033:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) )
            // InternalVilBuildLanguage.g:3034:1: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            {
            // InternalVilBuildLanguage.g:3034:1: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            int alt53=5;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt53=1;
                }
                break;
            case 47:
                {
                alt53=2;
                }
                break;
            case 48:
                {
                alt53=3;
                }
                break;
            case 49:
                {
                alt53=4;
                }
                break;
            case 50:
                {
                alt53=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalVilBuildLanguage.g:3035:2: kw= 'and'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3042:2: kw= 'or'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3049:2: kw= 'xor'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:3056:2: kw= 'implies'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getImpliesKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalVilBuildLanguage.g:3063:2: kw= 'iff'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getIffKeyword_4()); 
                          
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
    // InternalVilBuildLanguage.g:3076:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalVilBuildLanguage.g:3077:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalVilBuildLanguage.g:3078:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalVilBuildLanguage.g:3085:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3088:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalVilBuildLanguage.g:3089:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalVilBuildLanguage.g:3089:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalVilBuildLanguage.g:3089:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalVilBuildLanguage.g:3089:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalVilBuildLanguage.g:3090:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalVilBuildLanguage.g:3090:1: (lv_left_0_0= ruleRelationalExpression )
            // InternalVilBuildLanguage.g:3091:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_48);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3107:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt54=2;
            switch ( input.LA(1) ) {
                case 51:
                    {
                    int LA54_1 = input.LA(2);

                    if ( (synpred69_InternalVilBuildLanguage()) ) {
                        alt54=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA54_2 = input.LA(2);

                    if ( (synpred69_InternalVilBuildLanguage()) ) {
                        alt54=1;
                    }
                    }
                    break;
                case 53:
                    {
                    int LA54_3 = input.LA(2);

                    if ( (synpred69_InternalVilBuildLanguage()) ) {
                        alt54=1;
                    }
                    }
                    break;
            }

            switch (alt54) {
                case 1 :
                    // InternalVilBuildLanguage.g:3108:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3108:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalVilBuildLanguage.g:3109:3: lv_right_1_0= ruleEqualityExpressionPart
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
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityExpressionPart");
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
    // InternalVilBuildLanguage.g:3133:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3134:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalVilBuildLanguage.g:3135:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3142:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3145:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // InternalVilBuildLanguage.g:3146:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3146:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // InternalVilBuildLanguage.g:3146:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // InternalVilBuildLanguage.g:3146:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalVilBuildLanguage.g:3147:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalVilBuildLanguage.g:3147:1: (lv_op_0_0= ruleEqualityOperator )
            // InternalVilBuildLanguage.g:3148:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3164:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // InternalVilBuildLanguage.g:3165:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // InternalVilBuildLanguage.g:3165:1: (lv_ex_1_0= ruleRelationalExpression )
            // InternalVilBuildLanguage.g:3166:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpression");
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
    // $ANTLR end "ruleEqualityExpressionPart"


    // $ANTLR start "entryRuleEqualityOperator"
    // InternalVilBuildLanguage.g:3190:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalVilBuildLanguage.g:3191:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalVilBuildLanguage.g:3192:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalVilBuildLanguage.g:3199:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3202:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalVilBuildLanguage.g:3203:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalVilBuildLanguage.g:3203:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt55=1;
                }
                break;
            case 52:
                {
                alt55=2;
                }
                break;
            case 53:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalVilBuildLanguage.g:3204:2: kw= '=='
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3211:2: kw= '<>'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3218:2: kw= '!='
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3231:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalVilBuildLanguage.g:3232:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalVilBuildLanguage.g:3233:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalVilBuildLanguage.g:3240:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3243:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalVilBuildLanguage.g:3244:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalVilBuildLanguage.g:3244:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalVilBuildLanguage.g:3244:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalVilBuildLanguage.g:3244:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalVilBuildLanguage.g:3245:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalVilBuildLanguage.g:3245:1: (lv_left_0_0= ruleAdditiveExpression )
            // InternalVilBuildLanguage.g:3246:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_49);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3262:2: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt57=2;
            switch ( input.LA(1) ) {
                case 54:
                    {
                    int LA57_1 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt57=1;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA57_2 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt57=1;
                    }
                    }
                    break;
                case 56:
                    {
                    int LA57_3 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt57=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA57_4 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt57=1;
                    }
                    }
                    break;
            }

            switch (alt57) {
                case 1 :
                    // InternalVilBuildLanguage.g:3262:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalVilBuildLanguage.g:3262:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalVilBuildLanguage.g:3263:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3263:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalVilBuildLanguage.g:3264:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_49);
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
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpressionPart");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:3280:2: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt56=2;
                    switch ( input.LA(1) ) {
                        case 54:
                            {
                            int LA56_1 = input.LA(2);

                            if ( (synpred72_InternalVilBuildLanguage()) ) {
                                alt56=1;
                            }
                            }
                            break;
                        case 55:
                            {
                            int LA56_2 = input.LA(2);

                            if ( (synpred72_InternalVilBuildLanguage()) ) {
                                alt56=1;
                            }
                            }
                            break;
                        case 56:
                            {
                            int LA56_3 = input.LA(2);

                            if ( (synpred72_InternalVilBuildLanguage()) ) {
                                alt56=1;
                            }
                            }
                            break;
                        case 57:
                            {
                            int LA56_4 = input.LA(2);

                            if ( (synpred72_InternalVilBuildLanguage()) ) {
                                alt56=1;
                            }
                            }
                            break;
                    }

                    switch (alt56) {
                        case 1 :
                            // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalVilBuildLanguage.g:3282:3: lv_right2_2_0= ruleRelationalExpressionPart
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
                                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpressionPart");
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
    // InternalVilBuildLanguage.g:3306:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3307:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalVilBuildLanguage.g:3308:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3315:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3318:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalVilBuildLanguage.g:3319:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3319:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalVilBuildLanguage.g:3319:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalVilBuildLanguage.g:3319:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalVilBuildLanguage.g:3320:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalVilBuildLanguage.g:3320:1: (lv_op_0_0= ruleRelationalOperator )
            // InternalVilBuildLanguage.g:3321:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3337:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalVilBuildLanguage.g:3338:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalVilBuildLanguage.g:3338:1: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalVilBuildLanguage.g:3339:3: lv_ex_1_0= ruleAdditiveExpression
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveExpression");
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
    // InternalVilBuildLanguage.g:3363:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalVilBuildLanguage.g:3364:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalVilBuildLanguage.g:3365:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalVilBuildLanguage.g:3372:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3375:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalVilBuildLanguage.g:3376:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalVilBuildLanguage.g:3376:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt58=4;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt58=1;
                }
                break;
            case 55:
                {
                alt58=2;
                }
                break;
            case 56:
                {
                alt58=3;
                }
                break;
            case 57:
                {
                alt58=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalVilBuildLanguage.g:3377:2: kw= '>'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3384:2: kw= '<'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3391:2: kw= '>='
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:3398:2: kw= '<='
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3411:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalVilBuildLanguage.g:3412:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalVilBuildLanguage.g:3413:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalVilBuildLanguage.g:3420:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3423:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalVilBuildLanguage.g:3424:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalVilBuildLanguage.g:3424:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalVilBuildLanguage.g:3424:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalVilBuildLanguage.g:3424:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalVilBuildLanguage.g:3425:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalVilBuildLanguage.g:3425:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalVilBuildLanguage.g:3426:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3442:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==58) ) {
                    int LA59_2 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt59=1;
                    }


                }
                else if ( (LA59_0==59) ) {
                    int LA59_3 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt59=1;
                    }


                }


                switch (alt59) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3443:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalVilBuildLanguage.g:3443:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalVilBuildLanguage.g:3444:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_50);
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
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalVilBuildLanguage.g:3468:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3469:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalVilBuildLanguage.g:3470:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3477:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3480:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalVilBuildLanguage.g:3481:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3481:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalVilBuildLanguage.g:3481:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalVilBuildLanguage.g:3481:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalVilBuildLanguage.g:3482:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalVilBuildLanguage.g:3482:1: (lv_op_0_0= ruleAdditiveOperator )
            // InternalVilBuildLanguage.g:3483:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3499:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalVilBuildLanguage.g:3500:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalVilBuildLanguage.g:3500:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalVilBuildLanguage.g:3501:3: lv_ex_1_0= ruleMultiplicativeExpression
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.MultiplicativeExpression");
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
    // InternalVilBuildLanguage.g:3525:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalVilBuildLanguage.g:3526:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalVilBuildLanguage.g:3527:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalVilBuildLanguage.g:3534:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3537:28: ( (kw= '+' | kw= '-' ) )
            // InternalVilBuildLanguage.g:3538:1: (kw= '+' | kw= '-' )
            {
            // InternalVilBuildLanguage.g:3538:1: (kw= '+' | kw= '-' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==58) ) {
                alt60=1;
            }
            else if ( (LA60_0==59) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalVilBuildLanguage.g:3539:2: kw= '+'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3546:2: kw= '-'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3559:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalVilBuildLanguage.g:3560:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalVilBuildLanguage.g:3561:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalVilBuildLanguage.g:3568:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3571:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalVilBuildLanguage.g:3572:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalVilBuildLanguage.g:3572:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalVilBuildLanguage.g:3572:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalVilBuildLanguage.g:3572:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalVilBuildLanguage.g:3573:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalVilBuildLanguage.g:3573:1: (lv_left_0_0= ruleUnaryExpression )
            // InternalVilBuildLanguage.g:3574:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3590:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                int LA61_1 = input.LA(2);

                if ( (synpred79_InternalVilBuildLanguage()) ) {
                    alt61=1;
                }
            }
            else if ( (LA61_0==61) ) {
                int LA61_2 = input.LA(2);

                if ( (synpred79_InternalVilBuildLanguage()) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalVilBuildLanguage.g:3591:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3591:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalVilBuildLanguage.g:3592:3: lv_right_1_0= ruleMultiplicativeExpressionPart
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
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.MultiplicativeExpressionPart");
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
    // InternalVilBuildLanguage.g:3616:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3617:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalVilBuildLanguage.g:3618:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3625:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3628:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalVilBuildLanguage.g:3629:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3629:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalVilBuildLanguage.g:3629:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalVilBuildLanguage.g:3629:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalVilBuildLanguage.g:3630:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalVilBuildLanguage.g:3630:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalVilBuildLanguage.g:3631:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.MultiplicativeOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3647:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalVilBuildLanguage.g:3648:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalVilBuildLanguage.g:3648:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalVilBuildLanguage.g:3649:3: lv_expr_1_0= ruleUnaryExpression
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.UnaryExpression");
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
    // InternalVilBuildLanguage.g:3673:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalVilBuildLanguage.g:3674:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalVilBuildLanguage.g:3675:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalVilBuildLanguage.g:3682:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3685:28: ( (kw= '*' | kw= '/' ) )
            // InternalVilBuildLanguage.g:3686:1: (kw= '*' | kw= '/' )
            {
            // InternalVilBuildLanguage.g:3686:1: (kw= '*' | kw= '/' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==60) ) {
                alt62=1;
            }
            else if ( (LA62_0==61) ) {
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
                    // InternalVilBuildLanguage.g:3687:2: kw= '*'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3694:2: kw= '/'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3707:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalVilBuildLanguage.g:3708:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalVilBuildLanguage.g:3709:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalVilBuildLanguage.g:3716:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3719:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalVilBuildLanguage.g:3720:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3720:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalVilBuildLanguage.g:3720:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalVilBuildLanguage.g:3720:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==59||(LA63_0>=62 && LA63_0<=63)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalVilBuildLanguage.g:3721:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalVilBuildLanguage.g:3721:1: (lv_op_0_0= ruleUnaryOperator )
                    // InternalVilBuildLanguage.g:3722:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_27);
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
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:3738:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalVilBuildLanguage.g:3739:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalVilBuildLanguage.g:3739:1: (lv_expr_1_0= rulePostfixExpression )
            // InternalVilBuildLanguage.g:3740:3: lv_expr_1_0= rulePostfixExpression
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.PostfixExpression");
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
    // InternalVilBuildLanguage.g:3764:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalVilBuildLanguage.g:3765:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalVilBuildLanguage.g:3766:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalVilBuildLanguage.g:3773:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3776:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // InternalVilBuildLanguage.g:3777:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // InternalVilBuildLanguage.g:3777:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt64=1;
                }
                break;
            case 63:
                {
                alt64=2;
                }
                break;
            case 59:
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
                    // InternalVilBuildLanguage.g:3778:2: kw= 'not'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3785:2: kw= '!'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3792:2: kw= '-'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_2()); 
                          
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
    // InternalVilBuildLanguage.g:3805:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalVilBuildLanguage.g:3806:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalVilBuildLanguage.g:3807:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalVilBuildLanguage.g:3814:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3817:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // InternalVilBuildLanguage.g:3818:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // InternalVilBuildLanguage.g:3818:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // InternalVilBuildLanguage.g:3819:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // InternalVilBuildLanguage.g:3819:1: (lv_left_0_0= rulePrimaryExpression )
            // InternalVilBuildLanguage.g:3820:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_left_0_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"de.uni_hildesheim.sse.VilBuildLanguage.PrimaryExpression");
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRuleExpressionOrQualifiedExecution"
    // InternalVilBuildLanguage.g:3844:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // InternalVilBuildLanguage.g:3845:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // InternalVilBuildLanguage.g:3846:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
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
    // $ANTLR end "entryRuleExpressionOrQualifiedExecution"


    // $ANTLR start "ruleExpressionOrQualifiedExecution"
    // InternalVilBuildLanguage.g:3853:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3856:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:3857:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:3857:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:3857:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // InternalVilBuildLanguage.g:3857:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_EXPONENT)||LA65_0==44||(LA65_0>=71 && LA65_0<=73)) ) {
                alt65=1;
            }
            else if ( (LA65_0==16) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalVilBuildLanguage.g:3857:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // InternalVilBuildLanguage.g:3857:3: ( (lv_val_0_0= ruleConstant ) )
                    // InternalVilBuildLanguage.g:3858:1: (lv_val_0_0= ruleConstant )
                    {
                    // InternalVilBuildLanguage.g:3858:1: (lv_val_0_0= ruleConstant )
                    // InternalVilBuildLanguage.g:3859:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_39);
                    lv_val_0_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionOrQualifiedExecutionRule());
                      	        }
                             		set(
                             			current, 
                             			"val",
                              		lv_val_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Constant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3876:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalVilBuildLanguage.g:3876:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalVilBuildLanguage.g:3876:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // InternalVilBuildLanguage.g:3880:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:3881:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:3881:1: (lv_parenthesis_2_0= ruleExpression )
                    // InternalVilBuildLanguage.g:3882:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_parenthesis_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionOrQualifiedExecutionRule());
                      	        }
                             		set(
                             			current, 
                             			"parenthesis",
                              		lv_parenthesis_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,17,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:3902:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==27||(LA66_0>=66 && LA66_0<=67)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3903:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:3903:1: (lv_calls_4_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:3904:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_calls_4_0=ruleSubCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExpressionOrQualifiedExecutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_4_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // InternalVilBuildLanguage.g:3928:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // InternalVilBuildLanguage.g:3929:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // InternalVilBuildLanguage.g:3930:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
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
    // $ANTLR end "entryRuleUnqualifiedExecution"


    // $ANTLR start "ruleUnqualifiedExecution"
    // InternalVilBuildLanguage.g:3937:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3940:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:3941:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:3941:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:3941:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // InternalVilBuildLanguage.g:3941:2: ( (lv_call_0_0= ruleCall ) )
            // InternalVilBuildLanguage.g:3942:1: (lv_call_0_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:3942:1: (lv_call_0_0= ruleCall )
            // InternalVilBuildLanguage.g:3943:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
            lv_call_0_0=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnqualifiedExecutionRule());
              	        }
                     		set(
                     			current, 
                     			"call",
                      		lv_call_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:3959:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==27||(LA67_0>=66 && LA67_0<=67)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3960:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:3960:1: (lv_calls_1_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:3961:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_calls_1_0=ruleSubCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnqualifiedExecutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_1_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // InternalVilBuildLanguage.g:3985:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // InternalVilBuildLanguage.g:3986:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // InternalVilBuildLanguage.g:3987:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
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
    // $ANTLR end "entryRuleSuperExecution"


    // $ANTLR start "ruleSuperExecution"
    // InternalVilBuildLanguage.g:3994:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:3997:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:3998:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:3998:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:3998:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,64,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:4006:1: ( (lv_call_2_0= ruleCall ) )
            // InternalVilBuildLanguage.g:4007:1: (lv_call_2_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:4007:1: (lv_call_2_0= ruleCall )
            // InternalVilBuildLanguage.g:4008:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_39);
            lv_call_2_0=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSuperExecutionRule());
              	        }
                     		set(
                     			current, 
                     			"call",
                      		lv_call_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4024:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==27||(LA68_0>=66 && LA68_0<=67)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4025:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:4025:1: (lv_calls_3_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4026:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_calls_3_0=ruleSubCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSuperExecutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_3_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop68;
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // InternalVilBuildLanguage.g:4050:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // InternalVilBuildLanguage.g:4051:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // InternalVilBuildLanguage.g:4052:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
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
    // $ANTLR end "entryRuleConstructorExecution"


    // $ANTLR start "ruleConstructorExecution"
    // InternalVilBuildLanguage.g:4059:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
    public final EObject ruleConstructorExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_1_0 = null;

        EObject lv_param_3_0 = null;

        EObject lv_calls_5_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4062:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:4063:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:4063:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:4063:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,65,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:4067:1: ( (lv_type_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:4068:1: (lv_type_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:4068:1: (lv_type_1_0= ruleType )
            // InternalVilBuildLanguage.g:4069:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstructorExecutionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalVilBuildLanguage.g:4089:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_EXPONENT)||LA69_0==16||LA69_0==18||(LA69_0>=28 && LA69_0<=29)||LA69_0==34||LA69_0==37||LA69_0==44||LA69_0==59||(LA69_0>=62 && LA69_0<=65)||(LA69_0>=71 && LA69_0<=73)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalVilBuildLanguage.g:4090:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:4090:1: (lv_param_3_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:4091:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_param_3_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConstructorExecutionRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalVilBuildLanguage.g:4111:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==27||(LA70_0>=66 && LA70_0<=67)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4112:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:4112:1: (lv_calls_5_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4113:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_calls_5_0=ruleSubCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConstructorExecutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"calls",
            	              		lv_calls_5_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
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
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // InternalVilBuildLanguage.g:4137:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // InternalVilBuildLanguage.g:4138:2: (iv_ruleSubCall= ruleSubCall EOF )
            // InternalVilBuildLanguage.g:4139:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
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
    // $ANTLR end "entryRuleSubCall"


    // $ANTLR start "ruleSubCall"
    // InternalVilBuildLanguage.g:4146:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
    public final EObject ruleSubCall() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_call_1_0 = null;

        EObject lv_arrayEx_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4149:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // InternalVilBuildLanguage.g:4150:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // InternalVilBuildLanguage.g:4150:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==27||LA72_0==66) ) {
                alt72=1;
            }
            else if ( (LA72_0==67) ) {
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
                    // InternalVilBuildLanguage.g:4150:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // InternalVilBuildLanguage.g:4150:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // InternalVilBuildLanguage.g:4150:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // InternalVilBuildLanguage.g:4150:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // InternalVilBuildLanguage.g:4151:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // InternalVilBuildLanguage.g:4151:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // InternalVilBuildLanguage.g:4152:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // InternalVilBuildLanguage.g:4152:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==27) ) {
                        alt71=1;
                    }
                    else if ( (LA71_0==66) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalVilBuildLanguage.g:4153:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_type_0_1, grammarAccess.getSubCallAccess().getTypeFullStopKeyword_0_0_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSubCallRule());
                              	        }
                                     		setWithLastConsumed(current, "type", lv_type_0_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalVilBuildLanguage.g:4165:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,66,FOLLOW_10); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_type_0_2, grammarAccess.getSubCallAccess().getTypeHyphenMinusGreaterThanSignKeyword_0_0_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSubCallRule());
                              	        }
                                     		setWithLastConsumed(current, "type", lv_type_0_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalVilBuildLanguage.g:4180:2: ( (lv_call_1_0= ruleCall ) )
                    // InternalVilBuildLanguage.g:4181:1: (lv_call_1_0= ruleCall )
                    {
                    // InternalVilBuildLanguage.g:4181:1: (lv_call_1_0= ruleCall )
                    // InternalVilBuildLanguage.g:4182:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_call_1_0=ruleCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSubCallRule());
                      	        }
                             		set(
                             			current, 
                             			"call",
                              		lv_call_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Call");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:4199:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalVilBuildLanguage.g:4199:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalVilBuildLanguage.g:4199:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,67,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // InternalVilBuildLanguage.g:4203:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:4204:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:4204:1: (lv_arrayEx_3_0= ruleExpression )
                    // InternalVilBuildLanguage.g:4205:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_53);
                    lv_arrayEx_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSubCallRule());
                      	        }
                             		set(
                             			current, 
                             			"arrayEx",
                              		lv_arrayEx_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSubCallAccess().getRightSquareBracketKeyword_1_2());
                          
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
    // $ANTLR end "ruleSubCall"


    // $ANTLR start "entryRuleDeclarator"
    // InternalVilBuildLanguage.g:4233:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalVilBuildLanguage.g:4234:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalVilBuildLanguage.g:4235:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalVilBuildLanguage.g:4242:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4245:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalVilBuildLanguage.g:4246:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalVilBuildLanguage.g:4246:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalVilBuildLanguage.g:4246:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalVilBuildLanguage.g:4246:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalVilBuildLanguage.g:4247:1: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalVilBuildLanguage.g:4247:1: (lv_decl_0_0= ruleDeclaration )
            // InternalVilBuildLanguage.g:4248:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_54);
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Declaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4264:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==14) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4264:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:4268:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalVilBuildLanguage.g:4269:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:4269:1: (lv_decl_2_0= ruleDeclaration )
            	    // InternalVilBuildLanguage.g:4270:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_54);
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
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            otherlv_3=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:4298:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:4299:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalVilBuildLanguage.g:4300:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalVilBuildLanguage.g:4307:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4310:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // InternalVilBuildLanguage.g:4311:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // InternalVilBuildLanguage.g:4311:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // InternalVilBuildLanguage.g:4311:2: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // InternalVilBuildLanguage.g:4311:2: ( (lv_type_0_0= ruleType ) )?
            int alt74=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA74_1 = input.LA(2);

                    if ( (LA74_1==RULE_VERSION||(LA74_1>=RULE_ID && LA74_1<=RULE_EXPONENT)||LA74_1==44||LA74_1==70) ) {
                        alt74=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA74_2 = input.LA(2);

                    if ( (LA74_2==RULE_VERSION||(LA74_2>=RULE_ID && LA74_2<=RULE_EXPONENT)||LA74_2==44||LA74_2==70) ) {
                        alt74=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA74_3 = input.LA(2);

                    if ( (LA74_3==RULE_VERSION||(LA74_3>=RULE_ID && LA74_3<=RULE_EXPONENT)||LA74_3==44||LA74_3==70) ) {
                        alt74=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA74_4 = input.LA(2);

                    if ( (LA74_4==RULE_VERSION||(LA74_4>=RULE_ID && LA74_4<=RULE_EXPONENT)||LA74_4==44||LA74_4==70) ) {
                        alt74=1;
                    }
                    }
                    break;
                case 74:
                case 75:
                case 76:
                case 77:
                    {
                    alt74=1;
                    }
                    break;
            }

            switch (alt74) {
                case 1 :
                    // InternalVilBuildLanguage.g:4312:1: (lv_type_0_0= ruleType )
                    {
                    // InternalVilBuildLanguage.g:4312:1: (lv_type_0_0= ruleType )
                    // InternalVilBuildLanguage.g:4313:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
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
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:4329:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // InternalVilBuildLanguage.g:4330:1: (lv_units_1_0= ruleDeclarationUnit )
            {
            // InternalVilBuildLanguage.g:4330:1: (lv_units_1_0= ruleDeclarationUnit )
            // InternalVilBuildLanguage.g:4331:3: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_units_1_0=ruleDeclarationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
              	        }
                     		add(
                     			current, 
                     			"units",
                      		lv_units_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.DeclarationUnit");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4347:2: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==25) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4347:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:4351:1: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // InternalVilBuildLanguage.g:4352:1: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // InternalVilBuildLanguage.g:4352:1: (lv_units_3_0= ruleDeclarationUnit )
            	    // InternalVilBuildLanguage.g:4353:3: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_units_3_0=ruleDeclarationUnit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDeclarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"units",
            	              		lv_units_3_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.DeclarationUnit");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleDeclarationUnit"
    // InternalVilBuildLanguage.g:4377:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // InternalVilBuildLanguage.g:4378:2: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // InternalVilBuildLanguage.g:4379:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclarationUnit=ruleDeclarationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationUnit; 
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
    // $ANTLR end "entryRuleDeclarationUnit"


    // $ANTLR start "ruleDeclarationUnit"
    // InternalVilBuildLanguage.g:4386:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4389:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // InternalVilBuildLanguage.g:4390:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // InternalVilBuildLanguage.g:4390:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // InternalVilBuildLanguage.g:4390:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // InternalVilBuildLanguage.g:4390:2: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:4391:1: (lv_id_0_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:4391:1: (lv_id_0_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:4392:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_44);
            lv_id_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDeclarationUnitRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4408:2: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==23) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalVilBuildLanguage.g:4408:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalVilBuildLanguage.g:4412:1: ( (lv_deflt_2_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:4413:1: (lv_deflt_2_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:4413:1: (lv_deflt_2_0= ruleExpression )
                    // InternalVilBuildLanguage.g:4414:3: lv_deflt_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getDefltExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_deflt_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDeclarationUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"deflt",
                              		lv_deflt_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
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
    // $ANTLR end "ruleDeclarationUnit"


    // $ANTLR start "entryRuleCall"
    // InternalVilBuildLanguage.g:4438:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalVilBuildLanguage.g:4439:2: (iv_ruleCall= ruleCall EOF )
            // InternalVilBuildLanguage.g:4440:2: iv_ruleCall= ruleCall EOF
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
    // InternalVilBuildLanguage.g:4447:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4450:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // InternalVilBuildLanguage.g:4451:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // InternalVilBuildLanguage.g:4451:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // InternalVilBuildLanguage.g:4451:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // InternalVilBuildLanguage.g:4451:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // InternalVilBuildLanguage.g:4452:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // InternalVilBuildLanguage.g:4452:1: (lv_name_0_0= ruleQualifiedPrefix )
            // InternalVilBuildLanguage.g:4453:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_11);
            lv_name_0_0=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCallRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedPrefix");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:4473:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // InternalVilBuildLanguage.g:4474:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalVilBuildLanguage.g:4474:1: (lv_decl_2_0= ruleDeclarator )
                    // InternalVilBuildLanguage.g:4475:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_32);
                    lv_decl_2_0=ruleDeclarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"decl",
                              		lv_decl_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Declarator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:4491:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_EXPONENT)||LA78_0==16||LA78_0==18||(LA78_0>=28 && LA78_0<=29)||LA78_0==34||LA78_0==37||LA78_0==44||LA78_0==59||(LA78_0>=62 && LA78_0<=65)||(LA78_0>=71 && LA78_0<=73)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalVilBuildLanguage.g:4492:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:4492:1: (lv_param_3_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:4493:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_13);
                    lv_param_3_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCallRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_3_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCallAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleArgumentList"
    // InternalVilBuildLanguage.g:4521:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // InternalVilBuildLanguage.g:4522:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // InternalVilBuildLanguage.g:4523:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
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
    // $ANTLR end "entryRuleArgumentList"


    // $ANTLR start "ruleArgumentList"
    // InternalVilBuildLanguage.g:4530:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4533:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // InternalVilBuildLanguage.g:4534:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // InternalVilBuildLanguage.g:4534:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // InternalVilBuildLanguage.g:4534:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // InternalVilBuildLanguage.g:4534:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // InternalVilBuildLanguage.g:4535:1: (lv_param_0_0= ruleNamedArgument )
            {
            // InternalVilBuildLanguage.g:4535:1: (lv_param_0_0= ruleNamedArgument )
            // InternalVilBuildLanguage.g:4536:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_param_0_0=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArgumentListRule());
              	        }
                     		add(
                     			current, 
                     			"param",
                      		lv_param_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NamedArgument");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4552:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==25) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4552:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_30); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:4556:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // InternalVilBuildLanguage.g:4557:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // InternalVilBuildLanguage.g:4557:1: (lv_param_2_0= ruleNamedArgument )
            	    // InternalVilBuildLanguage.g:4558:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_param_2_0=ruleNamedArgument();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getArgumentListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"param",
            	              		lv_param_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NamedArgument");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalVilBuildLanguage.g:4582:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalVilBuildLanguage.g:4583:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalVilBuildLanguage.g:4584:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
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
    // $ANTLR end "entryRuleNamedArgument"


    // $ANTLR start "ruleNamedArgument"
    // InternalVilBuildLanguage.g:4591:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4594:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:4595:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:4595:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:4595:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // InternalVilBuildLanguage.g:4595:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt80=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA80_1 = input.LA(2);

                    if ( (LA80_1==23) ) {
                        alt80=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA80_2 = input.LA(2);

                    if ( (LA80_2==23) ) {
                        alt80=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA80_3 = input.LA(2);

                    if ( (LA80_3==23) ) {
                        alt80=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA80_4 = input.LA(2);

                    if ( (LA80_4==23) ) {
                        alt80=1;
                    }
                    }
                    break;
            }

            switch (alt80) {
                case 1 :
                    // InternalVilBuildLanguage.g:4595:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalVilBuildLanguage.g:4595:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:4596:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:4596:1: (lv_name_0_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:4597:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_22);
                    lv_name_0_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNamedArgumentRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,23,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // InternalVilBuildLanguage.g:4617:3: ( (lv_ex_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:4618:1: (lv_ex_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:4618:1: (lv_ex_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:4619:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_ex_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedArgumentRule());
              	        }
                     		set(
                     			current, 
                     			"ex",
                      		lv_ex_2_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
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
    // $ANTLR end "ruleNamedArgument"


    // $ANTLR start "entryRuleQualifiedPrefix"
    // InternalVilBuildLanguage.g:4643:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // InternalVilBuildLanguage.g:4644:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // InternalVilBuildLanguage.g:4645:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
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
    // $ANTLR end "entryRuleQualifiedPrefix"


    // $ANTLR start "ruleQualifiedPrefix"
    // InternalVilBuildLanguage.g:4652:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4655:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalVilBuildLanguage.g:4656:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalVilBuildLanguage.g:4656:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalVilBuildLanguage.g:4656:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalVilBuildLanguage.g:4656:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:4657:1: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:4657:1: (lv_qname_0_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:4658:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_56);
            lv_qname_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedPrefixRule());
              	        }
                     		add(
                     			current, 
                     			"qname",
                      		lv_qname_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4674:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==70) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4674:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalVilBuildLanguage.g:4674:3: ( (lv_qname_1_0= '::' ) )
            	    // InternalVilBuildLanguage.g:4675:1: (lv_qname_1_0= '::' )
            	    {
            	    // InternalVilBuildLanguage.g:4675:1: (lv_qname_1_0= '::' )
            	    // InternalVilBuildLanguage.g:4676:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,70,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_qname_1_0, grammarAccess.getQualifiedPrefixAccess().getQnameColonColonKeyword_1_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getQualifiedPrefixRule());
            	      	        }
            	             		addWithLastConsumed(current, "qname", lv_qname_1_0, "::");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalVilBuildLanguage.g:4689:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalVilBuildLanguage.g:4690:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalVilBuildLanguage.g:4690:1: (lv_qname_2_0= ruleIdentifier )
            	    // InternalVilBuildLanguage.g:4691:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_qname_2_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getQualifiedPrefixRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"qname",
            	              		lv_qname_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalVilBuildLanguage.g:4715:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalVilBuildLanguage.g:4716:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalVilBuildLanguage.g:4717:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalVilBuildLanguage.g:4724:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4727:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalVilBuildLanguage.g:4728:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalVilBuildLanguage.g:4728:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalVilBuildLanguage.g:4728:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalVilBuildLanguage.g:4728:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // InternalVilBuildLanguage.g:4729:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // InternalVilBuildLanguage.g:4729:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // InternalVilBuildLanguage.g:4730:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_57);
            lv_prefix_0_0=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
              	        }
                     		set(
                     			current, 
                     			"prefix",
                      		lv_prefix_0_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedPrefix");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:4746:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==27) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA82_3 = input.LA(3);

                        if ( (LA82_3==EOF||(LA82_3>=14 && LA82_3<=15)||(LA82_3>=17 && LA82_3<=19)||(LA82_3>=24 && LA82_3<=25)||LA82_3==27||LA82_3==43||(LA82_3>=46 && LA82_3<=61)||(LA82_3>=66 && LA82_3<=69)) ) {
                            alt82=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA82_4 = input.LA(3);

                        if ( (LA82_4==EOF||(LA82_4>=14 && LA82_4<=15)||(LA82_4>=17 && LA82_4<=19)||(LA82_4>=24 && LA82_4<=25)||LA82_4==27||LA82_4==43||(LA82_4>=46 && LA82_4<=61)||(LA82_4>=66 && LA82_4<=69)) ) {
                            alt82=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA82_5 = input.LA(3);

                        if ( (LA82_5==EOF||(LA82_5>=14 && LA82_5<=15)||(LA82_5>=17 && LA82_5<=19)||(LA82_5>=24 && LA82_5<=25)||LA82_5==27||LA82_5==43||(LA82_5>=46 && LA82_5<=61)||(LA82_5>=66 && LA82_5<=69)) ) {
                            alt82=1;
                        }


                        }
                        break;
                    case 44:
                        {
                        int LA82_6 = input.LA(3);

                        if ( (LA82_6==EOF||(LA82_6>=14 && LA82_6<=15)||(LA82_6>=17 && LA82_6<=19)||(LA82_6>=24 && LA82_6<=25)||LA82_6==27||LA82_6==43||(LA82_6>=46 && LA82_6<=61)||(LA82_6>=66 && LA82_6<=69)) ) {
                            alt82=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt82) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4746:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalVilBuildLanguage.g:4746:3: ( (lv_qname_1_0= '.' ) )
            	    // InternalVilBuildLanguage.g:4747:1: (lv_qname_1_0= '.' )
            	    {
            	    // InternalVilBuildLanguage.g:4747:1: (lv_qname_1_0= '.' )
            	    // InternalVilBuildLanguage.g:4748:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_qname_1_0, grammarAccess.getQualifiedNameAccess().getQnameFullStopKeyword_1_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	      	        }
            	             		addWithLastConsumed(current, "qname", lv_qname_1_0, ".");
            	      	    
            	    }

            	    }


            	    }

            	    // InternalVilBuildLanguage.g:4761:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalVilBuildLanguage.g:4762:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalVilBuildLanguage.g:4762:1: (lv_qname_2_0= ruleIdentifier )
            	    // InternalVilBuildLanguage.g:4763:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_qname_2_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getQualifiedNameRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"qname",
            	              		lv_qname_2_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // InternalVilBuildLanguage.g:4787:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalVilBuildLanguage.g:4788:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalVilBuildLanguage.g:4789:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
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
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalVilBuildLanguage.g:4796:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token lv_null_4_0=null;
        Token lv_version_5_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4799:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // InternalVilBuildLanguage.g:4800:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // InternalVilBuildLanguage.g:4800:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt84=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt84=1;
                }
                break;
            case RULE_STRING:
                {
                alt84=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 44:
                {
                alt84=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA84_4 = input.LA(2);

                if ( (synpred104_InternalVilBuildLanguage()) ) {
                    alt84=3;
                }
                else if ( (synpred108_InternalVilBuildLanguage()) ) {
                    alt84=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 4, input);

                    throw nvae;
                }
                }
                break;
            case 71:
            case 72:
                {
                alt84=4;
                }
                break;
            case 73:
                {
                alt84=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalVilBuildLanguage.g:4800:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalVilBuildLanguage.g:4800:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalVilBuildLanguage.g:4801:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalVilBuildLanguage.g:4801:1: (lv_nValue_0_0= ruleNumValue )
                    // InternalVilBuildLanguage.g:4802:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_nValue_0_0=ruleNumValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConstantRule());
                      	        }
                             		set(
                             			current, 
                             			"nValue",
                              		lv_nValue_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:4819:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalVilBuildLanguage.g:4819:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalVilBuildLanguage.g:4820:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalVilBuildLanguage.g:4820:1: (lv_sValue_1_0= RULE_STRING )
                    // InternalVilBuildLanguage.g:4821:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sValue_1_0, grammarAccess.getConstantAccess().getSValueSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstantRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"sValue",
                              		lv_sValue_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:4838:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalVilBuildLanguage.g:4838:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalVilBuildLanguage.g:4839:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalVilBuildLanguage.g:4839:1: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalVilBuildLanguage.g:4840:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_qValue_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConstantRule());
                      	        }
                             		set(
                             			current, 
                             			"qValue",
                              		lv_qValue_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:4857:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalVilBuildLanguage.g:4857:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalVilBuildLanguage.g:4858:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalVilBuildLanguage.g:4858:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalVilBuildLanguage.g:4859:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalVilBuildLanguage.g:4859:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==71) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==72) ) {
                        alt83=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 0, input);

                        throw nvae;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalVilBuildLanguage.g:4860:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_1, grammarAccess.getConstantAccess().getBValueTrueKeyword_3_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getConstantRule());
                              	        }
                                     		setWithLastConsumed(current, "bValue", lv_bValue_3_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalVilBuildLanguage.g:4872:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_bValue_3_2, grammarAccess.getConstantAccess().getBValueFalseKeyword_3_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getConstantRule());
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
                    // InternalVilBuildLanguage.g:4888:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // InternalVilBuildLanguage.g:4888:6: ( (lv_null_4_0= 'null' ) )
                    // InternalVilBuildLanguage.g:4889:1: (lv_null_4_0= 'null' )
                    {
                    // InternalVilBuildLanguage.g:4889:1: (lv_null_4_0= 'null' )
                    // InternalVilBuildLanguage.g:4890:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_null_4_0, grammarAccess.getConstantAccess().getNullNullKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstantRule());
                      	        }
                             		setWithLastConsumed(current, "null", lv_null_4_0, "null");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalVilBuildLanguage.g:4904:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // InternalVilBuildLanguage.g:4904:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // InternalVilBuildLanguage.g:4904:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // InternalVilBuildLanguage.g:4910:1: (lv_version_5_0= RULE_VERSION )
                    // InternalVilBuildLanguage.g:4911:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_version_5_0, grammarAccess.getConstantAccess().getVersionVERSIONTerminalRuleCall_5_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstantRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"version",
                              		lv_version_5_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VERSION");
                      	    
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleNumValue"
    // InternalVilBuildLanguage.g:4935:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalVilBuildLanguage.g:4936:2: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalVilBuildLanguage.g:4937:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalVilBuildLanguage.g:4944:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4947:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalVilBuildLanguage.g:4948:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalVilBuildLanguage.g:4948:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalVilBuildLanguage.g:4949:1: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalVilBuildLanguage.g:4949:1: (lv_val_0_0= RULE_NUMBER )
            // InternalVilBuildLanguage.g:4950:3: lv_val_0_0= RULE_NUMBER
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
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NUMBER");
              	    
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


    // $ANTLR start "entryRuleIdentifier"
    // InternalVilBuildLanguage.g:4974:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalVilBuildLanguage.g:4975:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalVilBuildLanguage.g:4976:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalVilBuildLanguage.g:4983:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:4986:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalVilBuildLanguage.g:4987:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalVilBuildLanguage.g:4987:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt85=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt85=1;
                }
                break;
            case RULE_VERSION:
                {
                alt85=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt85=3;
                }
                break;
            case 44:
                {
                alt85=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalVilBuildLanguage.g:4987:6: this_ID_0= RULE_ID
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
                    // InternalVilBuildLanguage.g:4995:10: this_VERSION_1= RULE_VERSION
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
                    // InternalVilBuildLanguage.g:5003:10: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalVilBuildLanguage.g:5012:2: kw= 'version'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleType"
    // InternalVilBuildLanguage.g:5025:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalVilBuildLanguage.g:5026:2: (iv_ruleType= ruleType EOF )
            // InternalVilBuildLanguage.g:5027:2: iv_ruleType= ruleType EOF
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
    // InternalVilBuildLanguage.g:5034:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_set_1_0=null;
        Token lv_seq_3_0=null;
        Token lv_map_5_0=null;
        Token lv_call_7_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_param_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_return_8_0 = null;

        EObject lv_param_9_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:5037:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // InternalVilBuildLanguage.g:5038:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // InternalVilBuildLanguage.g:5038:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt87=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 44:
                {
                alt87=1;
                }
                break;
            case 74:
                {
                alt87=2;
                }
                break;
            case 75:
                {
                alt87=3;
                }
                break;
            case 76:
                {
                alt87=4;
                }
                break;
            case 77:
                {
                alt87=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalVilBuildLanguage.g:5038:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // InternalVilBuildLanguage.g:5038:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // InternalVilBuildLanguage.g:5039:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // InternalVilBuildLanguage.g:5039:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // InternalVilBuildLanguage.g:5040:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_0_0=ruleQualifiedPrefix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedPrefix");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:5057:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5057:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5057:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5057:7: ( (lv_set_1_0= 'setOf' ) )
                    // InternalVilBuildLanguage.g:5058:1: (lv_set_1_0= 'setOf' )
                    {
                    // InternalVilBuildLanguage.g:5058:1: (lv_set_1_0= 'setOf' )
                    // InternalVilBuildLanguage.g:5059:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,74,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_set_1_0, grammarAccess.getTypeAccess().getSetSetOfKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(current, "set", lv_set_1_0, "setOf");
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:5072:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5073:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5073:1: (lv_param_2_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5074:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_param_2_0=ruleTypeParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:5091:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5091:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5091:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5091:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // InternalVilBuildLanguage.g:5092:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // InternalVilBuildLanguage.g:5092:1: (lv_seq_3_0= 'sequenceOf' )
                    // InternalVilBuildLanguage.g:5093:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,75,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_seq_3_0, grammarAccess.getTypeAccess().getSeqSequenceOfKeyword_2_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(current, "seq", lv_seq_3_0, "sequenceOf");
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:5106:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5107:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5107:1: (lv_param_4_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5108:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_param_4_0=ruleTypeParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_4_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:5125:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5125:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5125:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5125:7: ( (lv_map_5_0= 'mapOf' ) )
                    // InternalVilBuildLanguage.g:5126:1: (lv_map_5_0= 'mapOf' )
                    {
                    // InternalVilBuildLanguage.g:5126:1: (lv_map_5_0= 'mapOf' )
                    // InternalVilBuildLanguage.g:5127:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,76,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_map_5_0, grammarAccess.getTypeAccess().getMapMapOfKeyword_3_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(current, "map", lv_map_5_0, "mapOf");
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:5140:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5141:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5141:1: (lv_param_6_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5142:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_param_6_0=ruleTypeParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_6_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalVilBuildLanguage.g:5159:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5159:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5159:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5159:7: ( (lv_call_7_0= 'callOf' ) )
                    // InternalVilBuildLanguage.g:5160:1: (lv_call_7_0= 'callOf' )
                    {
                    // InternalVilBuildLanguage.g:5160:1: (lv_call_7_0= 'callOf' )
                    // InternalVilBuildLanguage.g:5161:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,77,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_call_7_0, grammarAccess.getTypeAccess().getCallCallOfKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRule());
                      	        }
                             		setWithLastConsumed(current, "call", lv_call_7_0, "callOf");
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:5174:2: ( (lv_return_8_0= ruleType ) )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==RULE_VERSION||(LA86_0>=RULE_ID && LA86_0<=RULE_EXPONENT)||LA86_0==44||(LA86_0>=74 && LA86_0<=77)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalVilBuildLanguage.g:5175:1: (lv_return_8_0= ruleType )
                            {
                            // InternalVilBuildLanguage.g:5175:1: (lv_return_8_0= ruleType )
                            // InternalVilBuildLanguage.g:5176:3: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_11);
                            lv_return_8_0=ruleType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"return",
                                      		lv_return_8_0, 
                                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:5192:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5193:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5193:1: (lv_param_9_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5194:3: lv_param_9_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_param_9_0=ruleTypeParameters();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_9_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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


    // $ANTLR start "entryRuleTypeParameters"
    // InternalVilBuildLanguage.g:5218:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // InternalVilBuildLanguage.g:5219:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // InternalVilBuildLanguage.g:5220:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
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
    // $ANTLR end "entryRuleTypeParameters"


    // $ANTLR start "ruleTypeParameters"
    // InternalVilBuildLanguage.g:5227:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:5230:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // InternalVilBuildLanguage.g:5231:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // InternalVilBuildLanguage.g:5231:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // InternalVilBuildLanguage.g:5231:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalVilBuildLanguage.g:5235:1: ( (lv_param_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:5236:1: (lv_param_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:5236:1: (lv_param_1_0= ruleType )
            // InternalVilBuildLanguage.g:5237:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
            lv_param_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeParametersRule());
              	        }
                     		add(
                     			current, 
                     			"param",
                      		lv_param_1_0, 
                      		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalVilBuildLanguage.g:5253:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==25) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:5253:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalVilBuildLanguage.g:5257:1: ( (lv_param_3_0= ruleType ) )
            	    // InternalVilBuildLanguage.g:5258:1: (lv_param_3_0= ruleType )
            	    {
            	    // InternalVilBuildLanguage.g:5258:1: (lv_param_3_0= ruleType )
            	    // InternalVilBuildLanguage.g:5259:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_param_3_0=ruleType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypeParametersRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"param",
            	              		lv_param_3_0, 
            	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTypeParametersAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleTypeParameters"


    // $ANTLR start "entryRuleContainerInitializer"
    // InternalVilBuildLanguage.g:5287:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalVilBuildLanguage.g:5288:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalVilBuildLanguage.g:5289:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalVilBuildLanguage.g:5296:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:5299:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // InternalVilBuildLanguage.g:5300:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // InternalVilBuildLanguage.g:5300:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // InternalVilBuildLanguage.g:5300:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // InternalVilBuildLanguage.g:5300:2: ()
            // InternalVilBuildLanguage.g:5301:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalVilBuildLanguage.g:5313:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=RULE_STRING && LA90_0<=RULE_EXPONENT)||LA90_0==16||LA90_0==18||(LA90_0>=28 && LA90_0<=29)||LA90_0==34||LA90_0==37||LA90_0==44||LA90_0==59||(LA90_0>=62 && LA90_0<=65)||(LA90_0>=71 && LA90_0<=73)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalVilBuildLanguage.g:5313:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // InternalVilBuildLanguage.g:5313:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // InternalVilBuildLanguage.g:5314:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // InternalVilBuildLanguage.g:5314:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // InternalVilBuildLanguage.g:5315:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_61);
                    lv_exprs_2_0=ruleContainerInitializerExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
                      	        }
                             		add(
                             			current, 
                             			"exprs",
                              		lv_exprs_2_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ContainerInitializerExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:5331:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==25) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:5331:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_30); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalVilBuildLanguage.g:5335:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // InternalVilBuildLanguage.g:5336:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // InternalVilBuildLanguage.g:5336:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // InternalVilBuildLanguage.g:5337:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_61);
                    	    lv_exprs_4_0=ruleContainerInitializerExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getContainerInitializerRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exprs",
                    	              		lv_exprs_4_0, 
                    	              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ContainerInitializerExpression");
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
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getContainerInitializerAccess().getRightCurlyBracketKeyword_3());
                  
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


    // $ANTLR start "entryRuleContainerInitializerExpression"
    // InternalVilBuildLanguage.g:5365:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // InternalVilBuildLanguage.g:5366:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // InternalVilBuildLanguage.g:5367:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
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
    // $ANTLR end "entryRuleContainerInitializerExpression"


    // $ANTLR start "ruleContainerInitializerExpression"
    // InternalVilBuildLanguage.g:5374:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // InternalVilBuildLanguage.g:5377:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // InternalVilBuildLanguage.g:5378:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // InternalVilBuildLanguage.g:5378:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=RULE_STRING && LA91_0<=RULE_EXPONENT)||LA91_0==16||(LA91_0>=28 && LA91_0<=29)||LA91_0==34||LA91_0==37||LA91_0==44||LA91_0==59||(LA91_0>=62 && LA91_0<=65)||(LA91_0>=71 && LA91_0<=73)) ) {
                alt91=1;
            }
            else if ( (LA91_0==18) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalVilBuildLanguage.g:5378:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // InternalVilBuildLanguage.g:5378:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:5379:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:5379:1: (lv_logical_0_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:5380:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_logical_0_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerInitializerExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"logical",
                              		lv_logical_0_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:5397:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // InternalVilBuildLanguage.g:5397:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // InternalVilBuildLanguage.g:5398:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // InternalVilBuildLanguage.g:5398:1: (lv_container_1_0= ruleContainerInitializer )
                    // InternalVilBuildLanguage.g:5399:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_container_1_0=ruleContainerInitializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainerInitializerExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"container",
                              		lv_container_1_0, 
                              		"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ContainerInitializer");
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
    // $ANTLR end "ruleContainerInitializerExpression"

    // $ANTLR start synpred7_InternalVilBuildLanguage
    public final void synpred7_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_version_8_0 = null;


        // InternalVilBuildLanguage.g:324:1: ( (lv_version_8_0= ruleVersionStmt ) )
        // InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
        {
        // InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
        // InternalVilBuildLanguage.g:325:3: lv_version_8_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_8_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_version_8_0=ruleVersionStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalVilBuildLanguage

    // $ANTLR start synpred10_InternalVilBuildLanguage
    public final void synpred10_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_elements_1_0 = null;


        // InternalVilBuildLanguage.g:509:3: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) )
        // InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        {
        // InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        // InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
        {
        // InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
        // InternalVilBuildLanguage.g:511:3: lv_elements_1_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsVariableDeclarationParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_1_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalVilBuildLanguage

    // $ANTLR start synpred13_InternalVilBuildLanguage
    public final void synpred13_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_elements_4_0 = null;


        // InternalVilBuildLanguage.g:566:6: ( ( (lv_elements_4_0= ruleRuleDeclaration ) ) )
        // InternalVilBuildLanguage.g:566:6: ( (lv_elements_4_0= ruleRuleDeclaration ) )
        {
        // InternalVilBuildLanguage.g:566:6: ( (lv_elements_4_0= ruleRuleDeclaration ) )
        // InternalVilBuildLanguage.g:567:1: (lv_elements_4_0= ruleRuleDeclaration )
        {
        // InternalVilBuildLanguage.g:567:1: (lv_elements_4_0= ruleRuleDeclaration )
        // InternalVilBuildLanguage.g:568:3: lv_elements_4_0= ruleRuleDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_3_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elements_4_0=ruleRuleDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred13_InternalVilBuildLanguage

    // $ANTLR start synpred17_InternalVilBuildLanguage
    public final void synpred17_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_modifier_1_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;


        // InternalVilBuildLanguage.g:614:3: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )
        // InternalVilBuildLanguage.g:614:3: ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
        {
        // InternalVilBuildLanguage.g:614:3: ( (lv_modifier_1_0= ruleRuleModifier ) )?
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==26) ) {
            alt92=1;
        }
        switch (alt92) {
            case 1 :
                // InternalVilBuildLanguage.g:615:1: (lv_modifier_1_0= ruleRuleModifier )
                {
                // InternalVilBuildLanguage.g:615:1: (lv_modifier_1_0= ruleRuleModifier )
                // InternalVilBuildLanguage.g:616:3: lv_modifier_1_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_0_0()); 
                  	    
                }
                pushFollow(FOLLOW_21);
                lv_modifier_1_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalVilBuildLanguage.g:632:3: ( (lv_type_2_0= ruleType ) )?
        int alt93=2;
        switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==RULE_VERSION||(LA93_1>=RULE_ID && LA93_1<=RULE_EXPONENT)||LA93_1==44||LA93_1==70) ) {
                    alt93=1;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA93_2 = input.LA(2);

                if ( (LA93_2==RULE_VERSION||(LA93_2>=RULE_ID && LA93_2<=RULE_EXPONENT)||LA93_2==44||LA93_2==70) ) {
                    alt93=1;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA93_3 = input.LA(2);

                if ( (LA93_3==RULE_VERSION||(LA93_3>=RULE_ID && LA93_3<=RULE_EXPONENT)||LA93_3==44||LA93_3==70) ) {
                    alt93=1;
                }
                }
                break;
            case 44:
                {
                int LA93_4 = input.LA(2);

                if ( (LA93_4==RULE_VERSION||(LA93_4>=RULE_ID && LA93_4<=RULE_EXPONENT)||LA93_4==44||LA93_4==70) ) {
                    alt93=1;
                }
                }
                break;
            case 74:
            case 75:
            case 76:
            case 77:
                {
                alt93=1;
                }
                break;
        }

        switch (alt93) {
            case 1 :
                // InternalVilBuildLanguage.g:633:1: (lv_type_2_0= ruleType )
                {
                // InternalVilBuildLanguage.g:633:1: (lv_type_2_0= ruleType )
                // InternalVilBuildLanguage.g:634:3: lv_type_2_0= ruleType
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_10);
                lv_type_2_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalVilBuildLanguage.g:650:3: ( (lv_name_3_0= ruleIdentifier ) )
        // InternalVilBuildLanguage.g:651:1: (lv_name_3_0= ruleIdentifier )
        {
        // InternalVilBuildLanguage.g:651:1: (lv_name_3_0= ruleIdentifier )
        // InternalVilBuildLanguage.g:652:3: lv_name_3_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_11);
        lv_name_3_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,16,FOLLOW_12); if (state.failed) return ;
        // InternalVilBuildLanguage.g:672:1: ( (lv_paramList_5_0= ruleParameterList ) )?
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_VERSION||(LA94_0>=RULE_ID && LA94_0<=RULE_EXPONENT)||LA94_0==44||(LA94_0>=74 && LA94_0<=77)) ) {
            alt94=1;
        }
        switch (alt94) {
            case 1 :
                // InternalVilBuildLanguage.g:673:1: (lv_paramList_5_0= ruleParameterList )
                {
                // InternalVilBuildLanguage.g:673:1: (lv_paramList_5_0= ruleParameterList )
                // InternalVilBuildLanguage.g:674:3: lv_paramList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                  	    
                }
                pushFollow(FOLLOW_13);
                lv_paramList_5_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,17,FOLLOW_22); if (state.failed) return ;
        otherlv_7=(Token)match(input,23,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalVilBuildLanguage

    // $ANTLR start synpred32_InternalVilBuildLanguage
    public final void synpred32_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // InternalVilBuildLanguage.g:1132:4: (otherlv_7= ';' )
        // InternalVilBuildLanguage.g:1132:4: otherlv_7= ';'
        {
        otherlv_7=(Token)match(input,14,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalVilBuildLanguage

    // $ANTLR start synpred49_InternalVilBuildLanguage
    public final void synpred49_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // InternalVilBuildLanguage.g:1887:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // InternalVilBuildLanguage.g:1887:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // InternalVilBuildLanguage.g:1887:3: ( ( 'else' )=>otherlv_5= 'else' )
        // InternalVilBuildLanguage.g:1887:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,33,FOLLOW_35); if (state.failed) return ;

        }

        // InternalVilBuildLanguage.g:1892:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // InternalVilBuildLanguage.g:1893:1: (lv_else_6_0= ruleStatementOrBlock )
        {
        // InternalVilBuildLanguage.g:1893:1: (lv_else_6_0= ruleStatementOrBlock )
        // InternalVilBuildLanguage.g:1894:3: lv_else_6_0= ruleStatementOrBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_else_6_0=ruleStatementOrBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred49_InternalVilBuildLanguage

    // $ANTLR start synpred50_InternalVilBuildLanguage
    public final void synpred50_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // InternalVilBuildLanguage.g:1931:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // InternalVilBuildLanguage.g:1931:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // InternalVilBuildLanguage.g:1931:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // InternalVilBuildLanguage.g:1932:1: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // InternalVilBuildLanguage.g:1932:1: (lv_exStmt_0_0= ruleExpressionStatement )
        // InternalVilBuildLanguage.g:1933:3: lv_exStmt_0_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_exStmt_0_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred50_InternalVilBuildLanguage

    // $ANTLR start synpred64_InternalVilBuildLanguage
    public final void synpred64_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:2939:1: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // InternalVilBuildLanguage.g:2939:1: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // InternalVilBuildLanguage.g:2939:1: (lv_right_1_0= ruleLogicalExpressionPart )
        // InternalVilBuildLanguage.g:2940:3: lv_right_1_0= ruleLogicalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_right_1_0=ruleLogicalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred64_InternalVilBuildLanguage

    // $ANTLR start synpred69_InternalVilBuildLanguage
    public final void synpred69_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3108:1: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // InternalVilBuildLanguage.g:3108:1: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // InternalVilBuildLanguage.g:3108:1: (lv_right_1_0= ruleEqualityExpressionPart )
        // InternalVilBuildLanguage.g:3109:3: lv_right_1_0= ruleEqualityExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_right_1_0=ruleEqualityExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred69_InternalVilBuildLanguage

    // $ANTLR start synpred72_InternalVilBuildLanguage
    public final void synpred72_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right2_2_0 = null;


        // InternalVilBuildLanguage.g:3281:1: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )
        // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
        {
        // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
        // InternalVilBuildLanguage.g:3282:3: lv_right2_2_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRight2RelationalExpressionPartParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_right2_2_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred72_InternalVilBuildLanguage

    // $ANTLR start synpred73_InternalVilBuildLanguage
    public final void synpred73_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


        // InternalVilBuildLanguage.g:3262:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )
        // InternalVilBuildLanguage.g:3262:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        {
        // InternalVilBuildLanguage.g:3262:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // InternalVilBuildLanguage.g:3263:1: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // InternalVilBuildLanguage.g:3263:1: (lv_right_1_0= ruleRelationalExpressionPart )
        // InternalVilBuildLanguage.g:3264:3: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_49);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalVilBuildLanguage.g:3280:2: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( ((LA100_0>=54 && LA100_0<=57)) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                {
                // InternalVilBuildLanguage.g:3281:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                // InternalVilBuildLanguage.g:3282:3: lv_right2_2_0= ruleRelationalExpressionPart
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRight2RelationalExpressionPartParserRuleCall_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_2);
                lv_right2_2_0=ruleRelationalExpressionPart();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred73_InternalVilBuildLanguage

    // $ANTLR start synpred77_InternalVilBuildLanguage
    public final void synpred77_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3443:1: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // InternalVilBuildLanguage.g:3443:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // InternalVilBuildLanguage.g:3443:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        // InternalVilBuildLanguage.g:3444:3: lv_right_1_0= ruleAdditiveExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_right_1_0=ruleAdditiveExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred77_InternalVilBuildLanguage

    // $ANTLR start synpred79_InternalVilBuildLanguage
    public final void synpred79_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3591:1: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // InternalVilBuildLanguage.g:3591:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // InternalVilBuildLanguage.g:3591:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // InternalVilBuildLanguage.g:3592:3: lv_right_1_0= ruleMultiplicativeExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_right_1_0=ruleMultiplicativeExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred79_InternalVilBuildLanguage

    // $ANTLR start synpred96_InternalVilBuildLanguage
    public final void synpred96_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalVilBuildLanguage.g:4474:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalVilBuildLanguage.g:4474:1: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalVilBuildLanguage.g:4474:1: (lv_decl_2_0= ruleDeclarator )
        // InternalVilBuildLanguage.g:4475:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred96_InternalVilBuildLanguage

    // $ANTLR start synpred104_InternalVilBuildLanguage
    public final void synpred104_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalVilBuildLanguage.g:4838:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalVilBuildLanguage.g:4838:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalVilBuildLanguage.g:4838:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalVilBuildLanguage.g:4839:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalVilBuildLanguage.g:4839:1: (lv_qValue_2_0= ruleQualifiedName )
        // InternalVilBuildLanguage.g:4840:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred104_InternalVilBuildLanguage

    // $ANTLR start synpred108_InternalVilBuildLanguage
    public final void synpred108_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        // InternalVilBuildLanguage.g:4904:7: ( ( RULE_VERSION ) )
        // InternalVilBuildLanguage.g:4905:1: ( RULE_VERSION )
        {
        // InternalVilBuildLanguage.g:4905:1: ( RULE_VERSION )
        // InternalVilBuildLanguage.g:4906:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred108_InternalVilBuildLanguage

    // Delegated rules

    public final boolean synpred79_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred73_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred73_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA77 dfa77 = new DFA77(this);
    static final String dfa_1s = "\41\uffff";
    static final String dfa_2s = "\1\1\40\uffff";
    static final String dfa_3s = "\1\4\3\uffff\10\0\25\uffff";
    static final String dfa_4s = "\1\115\3\uffff\10\0\25\uffff";
    static final String dfa_5s = "\1\uffff\1\5\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\1\4\21\uffff";
    static final String dfa_6s = "\4\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\25\uffff}>";
    static final String[] dfa_7s = {
            "\1\17\1\5\1\17\1\4\1\6\7\uffff\1\17\1\uffff\1\17\1\1\4\uffff\1\17\1\uffff\1\17\1\uffff\2\17\4\uffff\1\17\2\uffff\1\17\1\3\2\14\1\uffff\1\16\1\uffff\1\7\16\uffff\1\17\2\uffff\4\17\5\uffff\3\17\1\10\1\11\1\12\1\13",
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

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_4 = input.LA(1);

                         
                        int index10_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred13_InternalVilBuildLanguage()) ) {s = 15;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\33\uffff";
    static final String dfa_9s = "\1\4\1\uffff\4\0\25\uffff";
    static final String dfa_10s = "\1\115\1\uffff\4\0\25\uffff";
    static final String dfa_11s = "\1\uffff\1\1\10\uffff\1\2\20\uffff";
    static final String dfa_12s = "\2\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_13s = {
            "\1\12\1\3\1\12\1\2\1\4\7\uffff\1\12\1\uffff\1\12\5\uffff\1\12\1\uffff\1\1\1\uffff\2\12\4\uffff\1\12\2\uffff\1\12\6\uffff\1\5\16\uffff\1\12\2\uffff\4\12\5\uffff\3\12\4\1",
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

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "614:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_5 = input.LA(1);

                         
                        int index14_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_14s = "\16\uffff";
    static final String dfa_15s = "\1\4\1\uffff\4\5\3\uffff\5\5";
    static final String dfa_16s = "\1\115\1\uffff\4\106\3\uffff\1\54\4\106";
    static final String dfa_17s = "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\5\uffff";
    static final String dfa_18s = "\16\uffff}>";
    static final String[] dfa_19s = {
            "\1\6\1\3\1\6\1\2\1\4\7\uffff\1\6\1\uffff\1\6\11\uffff\2\6\1\10\1\7\1\6\1\uffff\1\6\2\uffff\1\6\1\1\5\uffff\1\5\16\uffff\1\6\2\uffff\4\6\5\uffff\3\6\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "",
            "",
            "",
            "\1\13\1\uffff\1\12\1\14\43\uffff\1\15",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\1\uffff\20\6\4\uffff\2\6\2\uffff\1\11"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "907:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )";
        }
    }
    static final String dfa_20s = "\14\uffff";
    static final String dfa_21s = "\1\4\4\16\1\uffff\1\5\1\uffff\4\16";
    static final String dfa_22s = "\1\111\4\106\1\uffff\1\54\1\uffff\4\106";
    static final String dfa_23s = "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String dfa_24s = "\14\uffff}>";
    static final String[] dfa_25s = {
            "\1\5\1\2\1\5\1\1\1\3\7\uffff\1\5\1\uffff\1\5\11\uffff\2\5\4\uffff\1\5\2\uffff\1\5\6\uffff\1\4\16\uffff\1\5\2\uffff\4\5\5\uffff\3\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "",
            "\1\11\1\uffff\1\10\1\12\43\uffff\1\13",
            "",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "1047:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String dfa_26s = "\22\uffff";
    static final String dfa_27s = "\2\uffff\4\1\10\uffff\4\1";
    static final String dfa_28s = "\1\4\1\uffff\4\16\6\uffff\1\5\1\uffff\4\16";
    static final String dfa_29s = "\1\111\1\uffff\4\106\6\uffff\1\54\1\uffff\4\106";
    static final String dfa_30s = "\1\uffff\1\1\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\4\uffff";
    static final String dfa_31s = "\22\uffff}>";
    static final String[] dfa_32s = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\13\uffff\1\12\1\10\4\uffff\1\11\2\uffff\1\7\6\uffff\1\5\23\uffff\1\6\1\13\5\uffff\3\1",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16\1\20\43\uffff\1\21",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\2\uffff\20\1\4\uffff\4\1\1\14"
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_26;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "1157:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String dfa_33s = "\27\uffff";
    static final String dfa_34s = "\1\4\23\uffff\1\0\2\uffff";
    static final String dfa_35s = "\1\111\23\uffff\1\0\2\uffff";
    static final String dfa_36s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_37s = "\24\uffff\1\0\2\uffff}>";
    static final String[] dfa_38s = {
            "\5\1\7\uffff\1\1\1\uffff\1\24\11\uffff\2\1\2\uffff\1\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\16\uffff\1\1\2\uffff\4\1\5\uffff\3\1",
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
            "",
            ""
    };

    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_33;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "1931:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_20 = input.LA(1);

                         
                        int index38_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred50_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index38_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_39s = "\32\uffff";
    static final String dfa_40s = "\1\4\4\0\25\uffff";
    static final String dfa_41s = "\1\115\4\0\25\uffff";
    static final String dfa_42s = "\5\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String dfa_43s = "\1\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_44s = {
            "\1\11\1\2\1\11\1\1\1\3\7\uffff\3\11\11\uffff\2\11\4\uffff\1\11\2\uffff\1\11\6\uffff\1\4\16\uffff\1\11\2\uffff\4\11\5\uffff\3\11\4\5",
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
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "4473:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_1 = input.LA(1);

                         
                        int index77_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index77_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA77_2 = input.LA(1);

                         
                        int index77_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index77_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA77_3 = input.LA(1);

                         
                        int index77_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index77_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA77_4 = input.LA(1);

                         
                        int index77_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred96_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index77_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000028000000A002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000008000000A002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000080000008002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00001000000001A0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00001000000201A0L,0x0000000000003C00L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0xC80015E4352D01F0L,0x0000000000003F83L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xC80015E4350501F2L,0x0000000000003F83L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00001000000001A0L,0x0000000000003C00L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xC80015E4350501F0L,0x0000000000003F83L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xC8001024300101F2L,0x0000000000000383L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xC8001024300101F0L,0x0000000000000383L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xC8001065F00D01F0L,0x0000000000003F83L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xC8001024300501F0L,0x0000000000000383L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00001000000001B0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xC8001024300701F0L,0x0000000000000383L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0xC80015E5350501F0L,0x0000000000003F83L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00001010000001A0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000008000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000040000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00001040000801A0L,0x0000000000003C00L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0007C00000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x03C0000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0C00000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000020L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xC8001024300701F0L,0x0000000000003F83L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x00001000000101A0L,0x0000000000003C00L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0xC8001024300D01F0L,0x0000000000000383L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000002080000L});

}