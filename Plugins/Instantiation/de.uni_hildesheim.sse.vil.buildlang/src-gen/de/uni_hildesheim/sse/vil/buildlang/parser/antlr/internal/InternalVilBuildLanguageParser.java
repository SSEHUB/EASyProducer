package de.uni_hildesheim.sse.vil.buildlang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.vil.buildlang.services.VilBuildLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalVilBuildLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'.'", "'instantiate'", "'map'", "'for'", "'while'", "'if'", "'else'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'abstract'", "'compound'", "'refines'", "'typedef'", "'@advice'", "'version'", "'import'", "'insert'", "'*'", "'and'", "'or'", "'xor'", "'implies'", "'iff'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'|'", "'@'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    // InternalVilBuildLanguage.g:70:1: entryRuleImplementationUnit returns [EObject current=null] : iv_ruleImplementationUnit= ruleImplementationUnit EOF ;
    public final EObject entryRuleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementationUnit = null;


        try {
            // InternalVilBuildLanguage.g:70:59: (iv_ruleImplementationUnit= ruleImplementationUnit EOF )
            // InternalVilBuildLanguage.g:71:2: iv_ruleImplementationUnit= ruleImplementationUnit EOF
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
    // InternalVilBuildLanguage.g:77:1: ruleImplementationUnit returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) ;
    public final EObject ruleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_requires_2_0 = null;

        EObject lv_scripts_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:83:2: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) )
            // InternalVilBuildLanguage.g:84:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            {
            // InternalVilBuildLanguage.g:84:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            // InternalVilBuildLanguage.g:85:3: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            {
            // InternalVilBuildLanguage.g:85:3: ()
            // InternalVilBuildLanguage.g:86:4: 
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

            // InternalVilBuildLanguage.g:95:3: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=45 && LA1_0<=46)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:96:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalVilBuildLanguage.g:96:4: (lv_imports_1_0= ruleImport )
            	    // InternalVilBuildLanguage.g:97:5: lv_imports_1_0= ruleImport
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

            // InternalVilBuildLanguage.g:114:3: ( (lv_requires_2_0= ruleRequire ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:115:4: (lv_requires_2_0= ruleRequire )
            	    {
            	    // InternalVilBuildLanguage.g:115:4: (lv_requires_2_0= ruleRequire )
            	    // InternalVilBuildLanguage.g:116:5: lv_requires_2_0= ruleRequire
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
            	      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.Require");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalVilBuildLanguage.g:133:3: ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==43) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:134:4: (lv_scripts_3_0= ruleLanguageUnit )
            	    {
            	    // InternalVilBuildLanguage.g:134:4: (lv_scripts_3_0= ruleLanguageUnit )
            	    // InternalVilBuildLanguage.g:135:5: lv_scripts_3_0= ruleLanguageUnit
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
            	      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LanguageUnit");
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
    // InternalVilBuildLanguage.g:156:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // InternalVilBuildLanguage.g:156:48: (iv_ruleRequire= ruleRequire EOF )
            // InternalVilBuildLanguage.g:157:2: iv_ruleRequire= ruleRequire EOF
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
    // InternalVilBuildLanguage.g:163:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_versionSpec_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:169:2: ( (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:170:2: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:170:2: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:171:3: otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireVTLKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:175:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalVilBuildLanguage.g:176:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalVilBuildLanguage.g:176:4: (lv_name_1_0= RULE_STRING )
            // InternalVilBuildLanguage.g:177:5: lv_name_1_0= RULE_STRING
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

            // InternalVilBuildLanguage.g:193:3: ( (lv_versionSpec_2_0= ruleVersionSpec ) )
            // InternalVilBuildLanguage.g:194:4: (lv_versionSpec_2_0= ruleVersionSpec )
            {
            // InternalVilBuildLanguage.g:194:4: (lv_versionSpec_2_0= ruleVersionSpec )
            // InternalVilBuildLanguage.g:195:5: lv_versionSpec_2_0= ruleVersionSpec
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
    // InternalVilBuildLanguage.g:220:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // InternalVilBuildLanguage.g:220:53: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // InternalVilBuildLanguage.g:221:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
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
    // InternalVilBuildLanguage.g:227:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) ;
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
            // InternalVilBuildLanguage.g:233:2: ( ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) )
            // InternalVilBuildLanguage.g:234:2: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // InternalVilBuildLanguage.g:234:2: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            // InternalVilBuildLanguage.g:235:3: ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )?
            {
            // InternalVilBuildLanguage.g:235:3: ( (lv_advices_0_0= ruleAdvice ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==43) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:236:4: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // InternalVilBuildLanguage.g:236:4: (lv_advices_0_0= ruleAdvice )
            	    // InternalVilBuildLanguage.g:237:5: lv_advices_0_0= ruleAdvice
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
            // InternalVilBuildLanguage.g:258:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:259:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:259:4: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:260:5: lv_name_2_0= ruleIdentifier
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
            // InternalVilBuildLanguage.g:281:3: ( (lv_param_4_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||LA5_0==44||(LA5_0>=76 && LA5_0<=79)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVilBuildLanguage.g:282:4: (lv_param_4_0= ruleParameterList )
                    {
                    // InternalVilBuildLanguage.g:282:4: (lv_param_4_0= ruleParameterList )
                    // InternalVilBuildLanguage.g:283:5: lv_param_4_0= ruleParameterList
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
            // InternalVilBuildLanguage.g:304:3: ( (lv_parent_6_0= ruleScriptParentDecl ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalVilBuildLanguage.g:305:4: (lv_parent_6_0= ruleScriptParentDecl )
                    {
                    // InternalVilBuildLanguage.g:305:4: (lv_parent_6_0= ruleScriptParentDecl )
                    // InternalVilBuildLanguage.g:306:5: lv_parent_6_0= ruleScriptParentDecl
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.ScriptParentDecl");
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
            // InternalVilBuildLanguage.g:327:3: ( (lv_version_8_0= ruleVersionStmt ) )?
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
                    // InternalVilBuildLanguage.g:328:4: (lv_version_8_0= ruleVersionStmt )
                    {
                    // InternalVilBuildLanguage.g:328:4: (lv_version_8_0= ruleVersionStmt )
                    // InternalVilBuildLanguage.g:329:5: lv_version_8_0= ruleVersionStmt
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

            // InternalVilBuildLanguage.g:346:3: ( (lv_loadProperties_9_0= ruleLoadProperties ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:347:4: (lv_loadProperties_9_0= ruleLoadProperties )
            	    {
            	    // InternalVilBuildLanguage.g:347:4: (lv_loadProperties_9_0= ruleLoadProperties )
            	    // InternalVilBuildLanguage.g:348:5: lv_loadProperties_9_0= ruleLoadProperties
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
            	      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LoadProperties");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalVilBuildLanguage.g:365:3: ( (lv_contents_10_0= ruleScriptContents ) )
            // InternalVilBuildLanguage.g:366:4: (lv_contents_10_0= ruleScriptContents )
            {
            // InternalVilBuildLanguage.g:366:4: (lv_contents_10_0= ruleScriptContents )
            // InternalVilBuildLanguage.g:367:5: lv_contents_10_0= ruleScriptContents
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.ScriptContents");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_11=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_11());
              		
            }
            // InternalVilBuildLanguage.g:388:3: (otherlv_12= ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalVilBuildLanguage.g:389:4: otherlv_12= ';'
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
    // InternalVilBuildLanguage.g:398:1: entryRuleScriptParentDecl returns [EObject current=null] : iv_ruleScriptParentDecl= ruleScriptParentDecl EOF ;
    public final EObject entryRuleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptParentDecl = null;


        try {
            // InternalVilBuildLanguage.g:398:57: (iv_ruleScriptParentDecl= ruleScriptParentDecl EOF )
            // InternalVilBuildLanguage.g:399:2: iv_ruleScriptParentDecl= ruleScriptParentDecl EOF
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
    // InternalVilBuildLanguage.g:405:1: ruleScriptParentDecl returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:411:2: ( (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalVilBuildLanguage.g:412:2: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalVilBuildLanguage.g:412:2: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalVilBuildLanguage.g:413:3: otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getScriptParentDeclAccess().getExtendsKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:417:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:418:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:418:4: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:419:5: lv_name_1_0= ruleIdentifier
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
    // InternalVilBuildLanguage.g:440:1: entryRuleLoadProperties returns [EObject current=null] : iv_ruleLoadProperties= ruleLoadProperties EOF ;
    public final EObject entryRuleLoadProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoadProperties = null;


        try {
            // InternalVilBuildLanguage.g:440:55: (iv_ruleLoadProperties= ruleLoadProperties EOF )
            // InternalVilBuildLanguage.g:441:2: iv_ruleLoadProperties= ruleLoadProperties EOF
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
    // InternalVilBuildLanguage.g:447:1: ruleLoadProperties returns [EObject current=null] : (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) ;
    public final EObject ruleLoadProperties() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:453:2: ( (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:454:2: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:454:2: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:455:3: otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLoadPropertiesAccess().getLoadKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoadPropertiesAccess().getPropertiesKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:463:3: ( (lv_path_2_0= RULE_STRING ) )
            // InternalVilBuildLanguage.g:464:4: (lv_path_2_0= RULE_STRING )
            {
            // InternalVilBuildLanguage.g:464:4: (lv_path_2_0= RULE_STRING )
            // InternalVilBuildLanguage.g:465:5: lv_path_2_0= RULE_STRING
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
    // InternalVilBuildLanguage.g:489:1: entryRuleScriptContents returns [EObject current=null] : iv_ruleScriptContents= ruleScriptContents EOF ;
    public final EObject entryRuleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptContents = null;


        try {
            // InternalVilBuildLanguage.g:489:55: (iv_ruleScriptContents= ruleScriptContents EOF )
            // InternalVilBuildLanguage.g:490:2: iv_ruleScriptContents= ruleScriptContents EOF
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
            // InternalVilBuildLanguage.g:502:2: ( ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* ) )
            // InternalVilBuildLanguage.g:503:2: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* )
            {
            // InternalVilBuildLanguage.g:503:2: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )* )
            // InternalVilBuildLanguage.g:504:3: () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*
            {
            // InternalVilBuildLanguage.g:504:3: ()
            // InternalVilBuildLanguage.g:505:4: 
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

            // InternalVilBuildLanguage.g:514:3: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*
            loop10:
            do {
                int alt10=5;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:515:4: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalVilBuildLanguage.g:515:4: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    // InternalVilBuildLanguage.g:516:5: (lv_elements_1_0= ruleVariableDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:516:5: (lv_elements_1_0= ruleVariableDeclaration )
            	    // InternalVilBuildLanguage.g:517:6: lv_elements_1_0= ruleVariableDeclaration
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
            	    // InternalVilBuildLanguage.g:535:4: ( (lv_elements_2_0= ruleCompound ) )
            	    {
            	    // InternalVilBuildLanguage.g:535:4: ( (lv_elements_2_0= ruleCompound ) )
            	    // InternalVilBuildLanguage.g:536:5: (lv_elements_2_0= ruleCompound )
            	    {
            	    // InternalVilBuildLanguage.g:536:5: (lv_elements_2_0= ruleCompound )
            	    // InternalVilBuildLanguage.g:537:6: lv_elements_2_0= ruleCompound
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
            	    // InternalVilBuildLanguage.g:555:4: ( (lv_elements_3_0= ruleTypeDef ) )
            	    {
            	    // InternalVilBuildLanguage.g:555:4: ( (lv_elements_3_0= ruleTypeDef ) )
            	    // InternalVilBuildLanguage.g:556:5: (lv_elements_3_0= ruleTypeDef )
            	    {
            	    // InternalVilBuildLanguage.g:556:5: (lv_elements_3_0= ruleTypeDef )
            	    // InternalVilBuildLanguage.g:557:6: lv_elements_3_0= ruleTypeDef
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
            	    // InternalVilBuildLanguage.g:575:4: ( (lv_elements_4_0= ruleRuleDeclaration ) )
            	    {
            	    // InternalVilBuildLanguage.g:575:4: ( (lv_elements_4_0= ruleRuleDeclaration ) )
            	    // InternalVilBuildLanguage.g:576:5: (lv_elements_4_0= ruleRuleDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:576:5: (lv_elements_4_0= ruleRuleDeclaration )
            	    // InternalVilBuildLanguage.g:577:6: lv_elements_4_0= ruleRuleDeclaration
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
            	      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleDeclaration");
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
    // InternalVilBuildLanguage.g:599:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:599:56: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // InternalVilBuildLanguage.g:600:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
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
    // InternalVilBuildLanguage.g:606:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? ) ;
    public final EObject ruleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_modifier_2_0 = null;

        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_paramList_6_0 = null;

        EObject lv_conditions_9_0 = null;

        EObject lv_block_10_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:612:2: ( ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? ) )
            // InternalVilBuildLanguage.g:613:2: ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? )
            {
            // InternalVilBuildLanguage.g:613:2: ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? )
            // InternalVilBuildLanguage.g:614:3: () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )?
            {
            // InternalVilBuildLanguage.g:614:3: ()
            // InternalVilBuildLanguage.g:615:4: 
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

            // InternalVilBuildLanguage.g:624:3: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )?
            int alt15=2;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalVilBuildLanguage.g:625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '='
                    {
                    // InternalVilBuildLanguage.g:625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?
                    int alt11=2;
                    alt11 = dfa11.predict(input);
                    switch (alt11) {
                        case 1 :
                            // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                            {
                            // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                            // InternalVilBuildLanguage.g:627:6: lv_annotations_1_0= ruleAnnotationDeclarations
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_1_0_0());
                              					
                            }
                            pushFollow(FOLLOW_21);
                            lv_annotations_1_0=ruleAnnotationDeclarations();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              						}
                              						set(
                              							current,
                              							"annotations",
                              							lv_annotations_1_0,
                              							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AnnotationDeclarations");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:644:4: ( (lv_modifier_2_0= ruleRuleModifier ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==26) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalVilBuildLanguage.g:645:5: (lv_modifier_2_0= ruleRuleModifier )
                            {
                            // InternalVilBuildLanguage.g:645:5: (lv_modifier_2_0= ruleRuleModifier )
                            // InternalVilBuildLanguage.g:646:6: lv_modifier_2_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0());
                              					
                            }
                            pushFollow(FOLLOW_22);
                            lv_modifier_2_0=ruleRuleModifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              						}
                              						set(
                              							current,
                              							"modifier",
                              							lv_modifier_2_0,
                              							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleModifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:663:4: ( (lv_type_3_0= ruleType ) )?
                    int alt13=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==RULE_VERSION||(LA13_1>=RULE_ID && LA13_1<=RULE_EXPONENT)||LA13_1==44||LA13_1==72) ) {
                                alt13=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA13_2 = input.LA(2);

                            if ( (LA13_2==RULE_VERSION||(LA13_2>=RULE_ID && LA13_2<=RULE_EXPONENT)||LA13_2==44||LA13_2==72) ) {
                                alt13=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA13_3 = input.LA(2);

                            if ( (LA13_3==RULE_VERSION||(LA13_3>=RULE_ID && LA13_3<=RULE_EXPONENT)||LA13_3==44||LA13_3==72) ) {
                                alt13=1;
                            }
                            }
                            break;
                        case 44:
                            {
                            int LA13_4 = input.LA(2);

                            if ( (LA13_4==RULE_VERSION||(LA13_4>=RULE_ID && LA13_4<=RULE_EXPONENT)||LA13_4==44||LA13_4==72) ) {
                                alt13=1;
                            }
                            }
                            break;
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                            {
                            alt13=1;
                            }
                            break;
                    }

                    switch (alt13) {
                        case 1 :
                            // InternalVilBuildLanguage.g:664:5: (lv_type_3_0= ruleType )
                            {
                            // InternalVilBuildLanguage.g:664:5: (lv_type_3_0= ruleType )
                            // InternalVilBuildLanguage.g:665:6: lv_type_3_0= ruleType
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FOLLOW_10);
                            lv_type_3_0=ruleType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              						}
                              						set(
                              							current,
                              							"type",
                              							lv_type_3_0,
                              							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:682:4: ( (lv_name_4_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:683:5: (lv_name_4_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:683:5: (lv_name_4_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:684:6: lv_name_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_name_4_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_4_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,16,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_4());
                      			
                    }
                    // InternalVilBuildLanguage.g:705:4: ( (lv_paramList_6_0= ruleParameterList ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_VERSION||(LA14_0>=RULE_ID && LA14_0<=RULE_EXPONENT)||LA14_0==44||(LA14_0>=76 && LA14_0<=79)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalVilBuildLanguage.g:706:5: (lv_paramList_6_0= ruleParameterList )
                            {
                            // InternalVilBuildLanguage.g:706:5: (lv_paramList_6_0= ruleParameterList )
                            // InternalVilBuildLanguage.g:707:6: lv_paramList_6_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_5_0());
                              					
                            }
                            pushFollow(FOLLOW_13);
                            lv_paramList_6_0=ruleParameterList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                              						}
                              						set(
                              							current,
                              							"paramList",
                              							lv_paramList_6_0,
                              							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,17,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_6());
                      			
                    }
                    otherlv_8=(Token)match(input,23,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_7());
                      			
                    }

                    }
                    break;

            }

            // InternalVilBuildLanguage.g:733:3: ( (lv_conditions_9_0= ruleRuleConditions ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_EXPONENT)||LA16_0==16||LA16_0==24||(LA16_0>=28 && LA16_0<=29)||LA16_0==34||LA16_0==37||LA16_0==44||LA16_0==61||(LA16_0>=63 && LA16_0<=66)||(LA16_0>=73 && LA16_0<=75)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalVilBuildLanguage.g:734:4: (lv_conditions_9_0= ruleRuleConditions )
                    {
                    // InternalVilBuildLanguage.g:734:4: (lv_conditions_9_0= ruleRuleConditions )
                    // InternalVilBuildLanguage.g:735:5: lv_conditions_9_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_24);
                    lv_conditions_9_0=ruleRuleConditions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"conditions",
                      						lv_conditions_9_0,
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleConditions");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:752:3: ( (lv_block_10_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:753:4: (lv_block_10_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:753:4: (lv_block_10_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:754:5: lv_block_10_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_block_10_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_10_0,
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElementBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:771:3: (otherlv_11= ';' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalVilBuildLanguage.g:772:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getRuleDeclarationAccess().getSemicolonKeyword_4());
                      			
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
    // InternalVilBuildLanguage.g:781:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // InternalVilBuildLanguage.g:781:55: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // InternalVilBuildLanguage.g:782:2: iv_ruleRuleConditions= ruleRuleConditions EOF
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
    // InternalVilBuildLanguage.g:788:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:794:2: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // InternalVilBuildLanguage.g:795:2: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // InternalVilBuildLanguage.g:795:2: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // InternalVilBuildLanguage.g:796:3: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // InternalVilBuildLanguage.g:796:3: ()
            // InternalVilBuildLanguage.g:797:4: 
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

            // InternalVilBuildLanguage.g:806:3: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_STRING && LA18_0<=RULE_EXPONENT)||LA18_0==16||(LA18_0>=28 && LA18_0<=29)||LA18_0==34||LA18_0==37||LA18_0==44||LA18_0==61||(LA18_0>=63 && LA18_0<=66)||(LA18_0>=73 && LA18_0<=75)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalVilBuildLanguage.g:807:4: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:807:4: (lv_postcondition_1_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:808:5: lv_postcondition_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleConditionsAccess().getPostconditionLogicalExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_25);
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

            otherlv_2=(Token)match(input,24,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
              		
            }
            // InternalVilBuildLanguage.g:829:3: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_EXPONENT)||LA20_0==16||(LA20_0>=28 && LA20_0<=29)||LA20_0==34||LA20_0==37||LA20_0==44||LA20_0==61||(LA20_0>=63 && LA20_0<=66)||(LA20_0>=73 && LA20_0<=75)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalVilBuildLanguage.g:830:4: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // InternalVilBuildLanguage.g:830:4: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:831:5: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:831:5: (lv_preconditions_3_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:832:6: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

                    // InternalVilBuildLanguage.g:849:4: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==25) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:850:5: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_28); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalVilBuildLanguage.g:854:5: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // InternalVilBuildLanguage.g:855:6: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // InternalVilBuildLanguage.g:855:6: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // InternalVilBuildLanguage.g:856:7: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
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
                    	    break loop19;
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
    // InternalVilBuildLanguage.g:879:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // InternalVilBuildLanguage.g:879:57: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // InternalVilBuildLanguage.g:880:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
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
    // InternalVilBuildLanguage.g:886:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:892:2: ( ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) )
            // InternalVilBuildLanguage.g:893:2: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            {
            // InternalVilBuildLanguage.g:893:2: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            // InternalVilBuildLanguage.g:894:3: () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}'
            {
            // InternalVilBuildLanguage.g:894:3: ()
            // InternalVilBuildLanguage.g:895:4: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:908:3: ( (lv_elements_2_0= ruleRuleElement ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_EXPONENT)||LA21_0==16||LA21_0==18||(LA21_0>=28 && LA21_0<=32)||LA21_0==34||(LA21_0>=37 && LA21_0<=38)||LA21_0==44||LA21_0==61||(LA21_0>=63 && LA21_0<=66)||(LA21_0>=73 && LA21_0<=79)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:909:4: (lv_elements_2_0= ruleRuleElement )
            	    {
            	    // InternalVilBuildLanguage.g:909:4: (lv_elements_2_0= ruleRuleElement )
            	    // InternalVilBuildLanguage.g:910:5: lv_elements_2_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_29);
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
            	      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalVilBuildLanguage.g:935:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // InternalVilBuildLanguage.g:935:52: (iv_ruleRuleElement= ruleRuleElement EOF )
            // InternalVilBuildLanguage.g:936:2: iv_ruleRuleElement= ruleRuleElement EOF
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
    // InternalVilBuildLanguage.g:942:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) ) ;
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
            // InternalVilBuildLanguage.g:948:2: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) ) )
            // InternalVilBuildLanguage.g:949:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )
            {
            // InternalVilBuildLanguage.g:949:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )
            int alt24=4;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalVilBuildLanguage.g:950:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalVilBuildLanguage.g:950:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalVilBuildLanguage.g:951:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalVilBuildLanguage.g:951:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalVilBuildLanguage.g:952:5: lv_varDecl_0_0= ruleVariableDeclaration
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
                    // InternalVilBuildLanguage.g:970:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalVilBuildLanguage.g:970:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalVilBuildLanguage.g:971:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalVilBuildLanguage.g:971:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalVilBuildLanguage.g:972:5: lv_exprStmt_1_0= ruleExpressionStatement
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.ExpressionStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:990:3: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:990:3: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    // InternalVilBuildLanguage.g:991:4: ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )?
                    {
                    // InternalVilBuildLanguage.g:991:4: ( (lv_while_2_0= ruleWhile ) )
                    // InternalVilBuildLanguage.g:992:5: (lv_while_2_0= ruleWhile )
                    {
                    // InternalVilBuildLanguage.g:992:5: (lv_while_2_0= ruleWhile )
                    // InternalVilBuildLanguage.g:993:6: lv_while_2_0= ruleWhile
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
                      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.While");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:1010:4: (otherlv_3= ';' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==14) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1011:5: otherlv_3= ';'
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
                    // InternalVilBuildLanguage.g:1018:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:1018:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    // InternalVilBuildLanguage.g:1019:4: ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )?
                    {
                    // InternalVilBuildLanguage.g:1019:4: ( (lv_for_4_0= ruleFor ) )
                    // InternalVilBuildLanguage.g:1020:5: (lv_for_4_0= ruleFor )
                    {
                    // InternalVilBuildLanguage.g:1020:5: (lv_for_4_0= ruleFor )
                    // InternalVilBuildLanguage.g:1021:6: lv_for_4_0= ruleFor
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
                      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.For");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:1038:4: (otherlv_5= ';' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==14) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1039:5: otherlv_5= ';'
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
    // InternalVilBuildLanguage.g:1049:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // InternalVilBuildLanguage.g:1049:53: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // InternalVilBuildLanguage.g:1050:2: iv_ruleRuleModifier= ruleRuleModifier EOF
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
    // InternalVilBuildLanguage.g:1056:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:1062:2: ( ( (lv_protected_0_0= 'protected' ) ) )
            // InternalVilBuildLanguage.g:1063:2: ( (lv_protected_0_0= 'protected' ) )
            {
            // InternalVilBuildLanguage.g:1063:2: ( (lv_protected_0_0= 'protected' ) )
            // InternalVilBuildLanguage.g:1064:3: (lv_protected_0_0= 'protected' )
            {
            // InternalVilBuildLanguage.g:1064:3: (lv_protected_0_0= 'protected' )
            // InternalVilBuildLanguage.g:1065:4: lv_protected_0_0= 'protected'
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
    // InternalVilBuildLanguage.g:1080:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalVilBuildLanguage.g:1080:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalVilBuildLanguage.g:1081:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalVilBuildLanguage.g:1087:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) ;
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
            // InternalVilBuildLanguage.g:1093:2: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) )
            // InternalVilBuildLanguage.g:1094:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            {
            // InternalVilBuildLanguage.g:1094:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_EXPONENT)||LA28_0==16||LA28_0==18||(LA28_0>=28 && LA28_0<=29)||LA28_0==34||LA28_0==37||LA28_0==44||LA28_0==61||(LA28_0>=63 && LA28_0<=66)||(LA28_0>=73 && LA28_0<=75)) ) {
                alt28=1;
            }
            else if ( (LA28_0==32) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalVilBuildLanguage.g:1095:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    {
                    // InternalVilBuildLanguage.g:1095:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    // InternalVilBuildLanguage.g:1096:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
                    {
                    // InternalVilBuildLanguage.g:1096:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
                    int alt26=2;
                    alt26 = dfa26.predict(input);
                    switch (alt26) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1097:5: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                            {
                            // InternalVilBuildLanguage.g:1097:5: ( (lv_var_0_0= ruleIdentifier ) )
                            // InternalVilBuildLanguage.g:1098:6: (lv_var_0_0= ruleIdentifier )
                            {
                            // InternalVilBuildLanguage.g:1098:6: (lv_var_0_0= ruleIdentifier )
                            // InternalVilBuildLanguage.g:1099:7: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0());
                              						
                            }
                            pushFollow(FOLLOW_30);
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

                            // InternalVilBuildLanguage.g:1116:5: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==27) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // InternalVilBuildLanguage.g:1117:6: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                                    {
                                    otherlv_1=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_0_1_0());
                                      					
                                    }
                                    // InternalVilBuildLanguage.g:1121:6: ( (lv_field_2_0= ruleIdentifier ) )
                                    // InternalVilBuildLanguage.g:1122:7: (lv_field_2_0= ruleIdentifier )
                                    {
                                    // InternalVilBuildLanguage.g:1122:7: (lv_field_2_0= ruleIdentifier )
                                    // InternalVilBuildLanguage.g:1123:8: lv_field_2_0= ruleIdentifier
                                    {
                                    if ( state.backtracking==0 ) {

                                      								newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_0_1_1_0());
                                      							
                                    }
                                    pushFollow(FOLLOW_23);
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

                            otherlv_3=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_0_2());
                              				
                            }

                            }
                            break;

                    }

                    // InternalVilBuildLanguage.g:1146:4: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:1147:5: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:1147:5: (lv_expr_4_0= ruleExpression )
                    // InternalVilBuildLanguage.g:1148:6: lv_expr_4_0= ruleExpression
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
                    // InternalVilBuildLanguage.g:1171:3: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    {
                    // InternalVilBuildLanguage.g:1171:3: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    // InternalVilBuildLanguage.g:1172:4: ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )?
                    {
                    // InternalVilBuildLanguage.g:1172:4: ( (lv_alt_6_0= ruleAlternative ) )
                    // InternalVilBuildLanguage.g:1173:5: (lv_alt_6_0= ruleAlternative )
                    {
                    // InternalVilBuildLanguage.g:1173:5: (lv_alt_6_0= ruleAlternative )
                    // InternalVilBuildLanguage.g:1174:6: lv_alt_6_0= ruleAlternative
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
                      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.Alternative");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:1191:4: (otherlv_7= ';' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==14) ) {
                        int LA27_1 = input.LA(2);

                        if ( (synpred33_InternalVilBuildLanguage()) ) {
                            alt27=1;
                        }
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalVilBuildLanguage.g:1192:5: otherlv_7= ';'
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
    // InternalVilBuildLanguage.g:1202:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalVilBuildLanguage.g:1202:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalVilBuildLanguage.g:1203:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalVilBuildLanguage.g:1209:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // InternalVilBuildLanguage.g:1215:2: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // InternalVilBuildLanguage.g:1216:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // InternalVilBuildLanguage.g:1216:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt29=8;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalVilBuildLanguage.g:1217:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1217:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // InternalVilBuildLanguage.g:1218:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // InternalVilBuildLanguage.g:1218:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // InternalVilBuildLanguage.g:1219:5: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
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
                    // InternalVilBuildLanguage.g:1237:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1237:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // InternalVilBuildLanguage.g:1238:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // InternalVilBuildLanguage.g:1238:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // InternalVilBuildLanguage.g:1239:5: lv_unqEx_1_0= ruleUnqualifiedExecution
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
                    // InternalVilBuildLanguage.g:1257:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1257:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // InternalVilBuildLanguage.g:1258:4: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // InternalVilBuildLanguage.g:1258:4: (lv_superEx_2_0= ruleSuperExecution )
                    // InternalVilBuildLanguage.g:1259:5: lv_superEx_2_0= ruleSuperExecution
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
                    // InternalVilBuildLanguage.g:1277:3: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1277:3: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // InternalVilBuildLanguage.g:1278:4: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // InternalVilBuildLanguage.g:1278:4: (lv_sysEx_3_0= ruleSystemExecution )
                    // InternalVilBuildLanguage.g:1279:5: lv_sysEx_3_0= ruleSystemExecution
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.SystemExecution");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalVilBuildLanguage.g:1297:3: ( (lv_map_4_0= ruleMap ) )
                    {
                    // InternalVilBuildLanguage.g:1297:3: ( (lv_map_4_0= ruleMap ) )
                    // InternalVilBuildLanguage.g:1298:4: (lv_map_4_0= ruleMap )
                    {
                    // InternalVilBuildLanguage.g:1298:4: (lv_map_4_0= ruleMap )
                    // InternalVilBuildLanguage.g:1299:5: lv_map_4_0= ruleMap
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.Map");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalVilBuildLanguage.g:1317:3: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // InternalVilBuildLanguage.g:1317:3: ( (lv_join_5_0= ruleJoin ) )
                    // InternalVilBuildLanguage.g:1318:4: (lv_join_5_0= ruleJoin )
                    {
                    // InternalVilBuildLanguage.g:1318:4: (lv_join_5_0= ruleJoin )
                    // InternalVilBuildLanguage.g:1319:5: lv_join_5_0= ruleJoin
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.Join");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalVilBuildLanguage.g:1337:3: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // InternalVilBuildLanguage.g:1337:3: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // InternalVilBuildLanguage.g:1338:4: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // InternalVilBuildLanguage.g:1338:4: (lv_instantiate_6_0= ruleInstantiate )
                    // InternalVilBuildLanguage.g:1339:5: lv_instantiate_6_0= ruleInstantiate
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.Instantiate");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalVilBuildLanguage.g:1357:3: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // InternalVilBuildLanguage.g:1357:3: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // InternalVilBuildLanguage.g:1358:4: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // InternalVilBuildLanguage.g:1358:4: (lv_newEx_7_0= ruleConstructorExecution )
                    // InternalVilBuildLanguage.g:1359:5: lv_newEx_7_0= ruleConstructorExecution
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
    // InternalVilBuildLanguage.g:1380:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // InternalVilBuildLanguage.g:1380:52: (iv_ruleInstantiate= ruleInstantiate EOF )
            // InternalVilBuildLanguage.g:1381:2: iv_ruleInstantiate= ruleInstantiate EOF
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
    // InternalVilBuildLanguage.g:1387:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) ;
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
            // InternalVilBuildLanguage.g:1393:2: ( (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) )
            // InternalVilBuildLanguage.g:1394:2: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            {
            // InternalVilBuildLanguage.g:1394:2: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            // InternalVilBuildLanguage.g:1395:3: otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:1399:3: ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_VERSION||(LA30_0>=RULE_ID && LA30_0<=RULE_EXPONENT)||LA30_0==44) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_STRING) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalVilBuildLanguage.g:1400:4: ( (lv_project_1_0= ruleIdentifier ) )
                    {
                    // InternalVilBuildLanguage.g:1400:4: ( (lv_project_1_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:1401:5: (lv_project_1_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:1401:5: (lv_project_1_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:1402:6: lv_project_1_0= ruleIdentifier
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
                    // InternalVilBuildLanguage.g:1420:4: ( (lv_ruleName_2_0= RULE_STRING ) )
                    {
                    // InternalVilBuildLanguage.g:1420:4: ( (lv_ruleName_2_0= RULE_STRING ) )
                    // InternalVilBuildLanguage.g:1421:5: (lv_ruleName_2_0= RULE_STRING )
                    {
                    // InternalVilBuildLanguage.g:1421:5: (lv_ruleName_2_0= RULE_STRING )
                    // InternalVilBuildLanguage.g:1422:6: lv_ruleName_2_0= RULE_STRING
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

            otherlv_3=(Token)match(input,16,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalVilBuildLanguage.g:1443:3: ( (lv_param_4_0= ruleArgumentList ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_EXPONENT)||LA31_0==16||LA31_0==18||(LA31_0>=28 && LA31_0<=29)||LA31_0==34||LA31_0==37||LA31_0==44||LA31_0==61||(LA31_0>=63 && LA31_0<=66)||(LA31_0>=73 && LA31_0<=75)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalVilBuildLanguage.g:1444:4: (lv_param_4_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:1444:4: (lv_param_4_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:1445:5: lv_param_4_0= ruleArgumentList
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

            otherlv_5=(Token)match(input,17,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalVilBuildLanguage.g:1466:3: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==35) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalVilBuildLanguage.g:1467:4: (lv_versionSpec_6_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:1467:4: (lv_versionSpec_6_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:1468:5: lv_versionSpec_6_0= ruleVersionSpec
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
    // InternalVilBuildLanguage.g:1489:1: entryRuleLoopVariable returns [EObject current=null] : iv_ruleLoopVariable= ruleLoopVariable EOF ;
    public final EObject entryRuleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariable = null;


        try {
            // InternalVilBuildLanguage.g:1489:53: (iv_ruleLoopVariable= ruleLoopVariable EOF )
            // InternalVilBuildLanguage.g:1490:2: iv_ruleLoopVariable= ruleLoopVariable EOF
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
    // InternalVilBuildLanguage.g:1496:1: ruleLoopVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:1502:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // InternalVilBuildLanguage.g:1503:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // InternalVilBuildLanguage.g:1503:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // InternalVilBuildLanguage.g:1504:3: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // InternalVilBuildLanguage.g:1504:3: ( (lv_type_0_0= ruleType ) )?
            int alt33=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1==RULE_VERSION||(LA33_1>=RULE_ID && LA33_1<=RULE_EXPONENT)||LA33_1==44||LA33_1==72) ) {
                        alt33=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA33_2 = input.LA(2);

                    if ( (LA33_2==RULE_VERSION||(LA33_2>=RULE_ID && LA33_2<=RULE_EXPONENT)||LA33_2==44||LA33_2==72) ) {
                        alt33=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA33_3 = input.LA(2);

                    if ( (LA33_3==RULE_VERSION||(LA33_3>=RULE_ID && LA33_3<=RULE_EXPONENT)||LA33_3==44||LA33_3==72) ) {
                        alt33=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA33_4 = input.LA(2);

                    if ( (LA33_4==RULE_VERSION||(LA33_4>=RULE_ID && LA33_4<=RULE_EXPONENT)||LA33_4==44||LA33_4==72) ) {
                        alt33=1;
                    }
                    }
                    break;
                case 76:
                case 77:
                case 78:
                case 79:
                    {
                    alt33=1;
                    }
                    break;
            }

            switch (alt33) {
                case 1 :
                    // InternalVilBuildLanguage.g:1505:4: (lv_type_0_0= ruleType )
                    {
                    // InternalVilBuildLanguage.g:1505:4: (lv_type_0_0= ruleType )
                    // InternalVilBuildLanguage.g:1506:5: lv_type_0_0= ruleType
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

            // InternalVilBuildLanguage.g:1523:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:1524:4: (lv_var_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:1524:4: (lv_var_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:1525:5: lv_var_1_0= ruleIdentifier
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
    // InternalVilBuildLanguage.g:1546:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalVilBuildLanguage.g:1546:44: (iv_ruleMap= ruleMap EOF )
            // InternalVilBuildLanguage.g:1547:2: iv_ruleMap= ruleMap EOF
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
    // InternalVilBuildLanguage.g:1553:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalVilBuildLanguage.g:1559:2: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1560:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1560:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1561:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:1569:3: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalVilBuildLanguage.g:1570:4: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalVilBuildLanguage.g:1570:4: (lv_var_2_0= ruleLoopVariable )
            // InternalVilBuildLanguage.g:1571:5: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_35);
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LoopVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:1588:3: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==25) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:1589:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:1593:4: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalVilBuildLanguage.g:1594:5: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalVilBuildLanguage.g:1594:5: (lv_var_4_0= ruleLoopVariable )
            	    // InternalVilBuildLanguage.g:1595:6: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LoopVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // InternalVilBuildLanguage.g:1613:3: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalVilBuildLanguage.g:1614:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalVilBuildLanguage.g:1614:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalVilBuildLanguage.g:1615:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalVilBuildLanguage.g:1615:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            else if ( (LA35_0==24) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalVilBuildLanguage.g:1616:6: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
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
                    // InternalVilBuildLanguage.g:1627:6: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_31); if (state.failed) return current;
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

            // InternalVilBuildLanguage.g:1640:3: ( (lv_expr_6_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1641:4: (lv_expr_6_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1641:4: (lv_expr_6_0= ruleExpression )
            // InternalVilBuildLanguage.g:1642:5: lv_expr_6_0= ruleExpression
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

            otherlv_7=(Token)match(input,17,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalVilBuildLanguage.g:1663:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1664:4: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1664:4: (lv_block_8_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1665:5: lv_block_8_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElementBlock");
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
    // InternalVilBuildLanguage.g:1686:1: entryRuleFor returns [EObject current=null] : iv_ruleFor= ruleFor EOF ;
    public final EObject entryRuleFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor = null;


        try {
            // InternalVilBuildLanguage.g:1686:44: (iv_ruleFor= ruleFor EOF )
            // InternalVilBuildLanguage.g:1687:2: iv_ruleFor= ruleFor EOF
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
    // InternalVilBuildLanguage.g:1693:1: ruleFor returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalVilBuildLanguage.g:1699:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1700:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1700:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1701:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:1709:3: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalVilBuildLanguage.g:1710:4: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalVilBuildLanguage.g:1710:4: (lv_var_2_0= ruleLoopVariable )
            // InternalVilBuildLanguage.g:1711:5: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_35);
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LoopVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:1728:3: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:1729:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getForAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:1733:4: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalVilBuildLanguage.g:1734:5: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalVilBuildLanguage.g:1734:5: (lv_var_4_0= ruleLoopVariable )
            	    // InternalVilBuildLanguage.g:1735:6: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
            	      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.LoopVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalVilBuildLanguage.g:1753:3: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalVilBuildLanguage.g:1754:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalVilBuildLanguage.g:1754:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalVilBuildLanguage.g:1755:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalVilBuildLanguage.g:1755:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==23) ) {
                alt37=1;
            }
            else if ( (LA37_0==24) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalVilBuildLanguage.g:1756:6: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
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
                    // InternalVilBuildLanguage.g:1767:6: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_31); if (state.failed) return current;
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

            // InternalVilBuildLanguage.g:1780:3: ( (lv_expr_6_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1781:4: (lv_expr_6_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1781:4: (lv_expr_6_0= ruleExpression )
            // InternalVilBuildLanguage.g:1782:5: lv_expr_6_0= ruleExpression
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

            otherlv_7=(Token)match(input,17,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getForAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalVilBuildLanguage.g:1803:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1804:4: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1804:4: (lv_block_8_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1805:5: lv_block_8_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElementBlock");
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
    // InternalVilBuildLanguage.g:1826:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalVilBuildLanguage.g:1826:46: (iv_ruleWhile= ruleWhile EOF )
            // InternalVilBuildLanguage.g:1827:2: iv_ruleWhile= ruleWhile EOF
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
    // InternalVilBuildLanguage.g:1833:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;

        EObject lv_block_4_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:1839:2: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:1840:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:1840:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            // InternalVilBuildLanguage.g:1841:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:1849:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1850:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1850:4: (lv_expr_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:1851:5: lv_expr_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,17,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getWhileAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalVilBuildLanguage.g:1872:3: ( (lv_block_4_0= ruleRuleElementBlock ) )
            // InternalVilBuildLanguage.g:1873:4: (lv_block_4_0= ruleRuleElementBlock )
            {
            // InternalVilBuildLanguage.g:1873:4: (lv_block_4_0= ruleRuleElementBlock )
            // InternalVilBuildLanguage.g:1874:5: lv_block_4_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElementBlock");
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
    // InternalVilBuildLanguage.g:1895:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalVilBuildLanguage.g:1895:52: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalVilBuildLanguage.g:1896:2: iv_ruleAlternative= ruleAlternative EOF
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
    // InternalVilBuildLanguage.g:1902:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
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
            // InternalVilBuildLanguage.g:1908:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // InternalVilBuildLanguage.g:1909:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // InternalVilBuildLanguage.g:1909:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // InternalVilBuildLanguage.g:1910:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:1918:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:1919:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:1919:4: (lv_expr_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:1920:5: lv_expr_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,17,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalVilBuildLanguage.g:1941:3: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // InternalVilBuildLanguage.g:1942:4: (lv_if_4_0= ruleStatementOrBlock )
            {
            // InternalVilBuildLanguage.g:1942:4: (lv_if_4_0= ruleStatementOrBlock )
            // InternalVilBuildLanguage.g:1943:5: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_37);
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.StatementOrBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:1960:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==33) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred50_InternalVilBuildLanguage()) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalVilBuildLanguage.g:1961:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // InternalVilBuildLanguage.g:1961:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalVilBuildLanguage.g:1962:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalVilBuildLanguage.g:1968:4: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // InternalVilBuildLanguage.g:1969:5: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // InternalVilBuildLanguage.g:1969:5: (lv_else_6_0= ruleStatementOrBlock )
                    // InternalVilBuildLanguage.g:1970:6: lv_else_6_0= ruleStatementOrBlock
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
                      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.StatementOrBlock");
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
    // InternalVilBuildLanguage.g:1992:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // InternalVilBuildLanguage.g:1992:57: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // InternalVilBuildLanguage.g:1993:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
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
    // InternalVilBuildLanguage.g:1999:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2005:2: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // InternalVilBuildLanguage.g:2006:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // InternalVilBuildLanguage.g:2006:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalVilBuildLanguage.g:2007:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // InternalVilBuildLanguage.g:2007:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // InternalVilBuildLanguage.g:2008:4: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // InternalVilBuildLanguage.g:2008:4: (lv_exStmt_0_0= ruleExpressionStatement )
                    // InternalVilBuildLanguage.g:2009:5: lv_exStmt_0_0= ruleExpressionStatement
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.ExpressionStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:2027:3: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // InternalVilBuildLanguage.g:2027:3: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // InternalVilBuildLanguage.g:2028:4: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // InternalVilBuildLanguage.g:2028:4: (lv_block_1_0= ruleRuleElementBlock )
                    // InternalVilBuildLanguage.g:2029:5: lv_block_1_0= ruleRuleElementBlock
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
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleElementBlock");
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
    // InternalVilBuildLanguage.g:2050:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalVilBuildLanguage.g:2050:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalVilBuildLanguage.g:2051:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalVilBuildLanguage.g:2057:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // InternalVilBuildLanguage.g:2063:2: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // InternalVilBuildLanguage.g:2064:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // InternalVilBuildLanguage.g:2064:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // InternalVilBuildLanguage.g:2065:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:2073:3: ( (lv_var1_2_0= ruleJoinVariable ) )
            // InternalVilBuildLanguage.g:2074:4: (lv_var1_2_0= ruleJoinVariable )
            {
            // InternalVilBuildLanguage.g:2074:4: (lv_var1_2_0= ruleJoinVariable )
            // InternalVilBuildLanguage.g:2075:5: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_39);
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.JoinVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
              		
            }
            // InternalVilBuildLanguage.g:2096:3: ( (lv_var2_4_0= ruleJoinVariable ) )
            // InternalVilBuildLanguage.g:2097:4: (lv_var2_4_0= ruleJoinVariable )
            {
            // InternalVilBuildLanguage.g:2097:4: (lv_var2_4_0= ruleJoinVariable )
            // InternalVilBuildLanguage.g:2098:5: lv_var2_4_0= ruleJoinVariable
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
              						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.JoinVariable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalVilBuildLanguage.g:2119:3: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalVilBuildLanguage.g:2120:4: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                      			
                    }
                    // InternalVilBuildLanguage.g:2128:4: ( (lv_condition_8_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2129:5: (lv_condition_8_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2129:5: (lv_condition_8_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2130:6: lv_condition_8_0= ruleExpression
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
    // InternalVilBuildLanguage.g:2156:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // InternalVilBuildLanguage.g:2156:53: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // InternalVilBuildLanguage.g:2157:2: iv_ruleJoinVariable= ruleJoinVariable EOF
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
    // InternalVilBuildLanguage.g:2163:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2169:2: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:2170:2: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:2170:2: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:2171:3: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // InternalVilBuildLanguage.g:2171:3: ( (lv_excl_0_0= 'exclude' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==36) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalVilBuildLanguage.g:2172:4: (lv_excl_0_0= 'exclude' )
                    {
                    // InternalVilBuildLanguage.g:2172:4: (lv_excl_0_0= 'exclude' )
                    // InternalVilBuildLanguage.g:2173:5: lv_excl_0_0= 'exclude'
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

            // InternalVilBuildLanguage.g:2185:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2186:4: (lv_var_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2186:4: (lv_var_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2187:5: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            otherlv_2=(Token)match(input,24,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
              		
            }
            // InternalVilBuildLanguage.g:2208:3: ( (lv_expr_3_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:2209:4: (lv_expr_3_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:2209:4: (lv_expr_3_0= ruleExpression )
            // InternalVilBuildLanguage.g:2210:5: lv_expr_3_0= ruleExpression
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
    // InternalVilBuildLanguage.g:2231:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // InternalVilBuildLanguage.g:2231:56: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // InternalVilBuildLanguage.g:2232:2: iv_ruleSystemExecution= ruleSystemExecution EOF
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
    // InternalVilBuildLanguage.g:2238:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2244:2: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:2245:2: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:2245:2: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:2246:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,37,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:2250:3: ( (lv_call_1_0= ruleCall ) )
            // InternalVilBuildLanguage.g:2251:4: (lv_call_1_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:2251:4: (lv_call_1_0= ruleCall )
            // InternalVilBuildLanguage.g:2252:5: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalVilBuildLanguage.g:2269:3: ( (lv_calls_2_0= ruleSubCall ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==27||(LA42_0>=67 && LA42_0<=68)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2270:4: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:2270:4: (lv_calls_2_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:2271:5: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop42;
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
    // InternalVilBuildLanguage.g:2292:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:2292:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalVilBuildLanguage.g:2293:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalVilBuildLanguage.g:2299:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // InternalVilBuildLanguage.g:2305:2: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // InternalVilBuildLanguage.g:2306:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // InternalVilBuildLanguage.g:2306:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // InternalVilBuildLanguage.g:2307:3: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // InternalVilBuildLanguage.g:2307:3: ( (lv_const_0_0= 'const' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalVilBuildLanguage.g:2308:4: (lv_const_0_0= 'const' )
                    {
                    // InternalVilBuildLanguage.g:2308:4: (lv_const_0_0= 'const' )
                    // InternalVilBuildLanguage.g:2309:5: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,38,FOLLOW_22); if (state.failed) return current;
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

            // InternalVilBuildLanguage.g:2321:3: ( (lv_type_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:2322:4: (lv_type_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2322:4: (lv_type_1_0= ruleType )
            // InternalVilBuildLanguage.g:2323:5: lv_type_1_0= ruleType
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

            // InternalVilBuildLanguage.g:2340:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2341:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2341:4: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2342:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_41);
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

            // InternalVilBuildLanguage.g:2359:3: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalVilBuildLanguage.g:2360:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalVilBuildLanguage.g:2364:4: ( (lv_expression_4_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2365:5: (lv_expression_4_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2365:5: (lv_expression_4_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2366:6: lv_expression_4_0= ruleExpression
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
    // InternalVilBuildLanguage.g:2392:1: entryRuleCompound returns [EObject current=null] : iv_ruleCompound= ruleCompound EOF ;
    public final EObject entryRuleCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompound = null;


        try {
            // InternalVilBuildLanguage.g:2392:49: (iv_ruleCompound= ruleCompound EOF )
            // InternalVilBuildLanguage.g:2393:2: iv_ruleCompound= ruleCompound EOF
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
    // InternalVilBuildLanguage.g:2399:1: ruleCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) ;
    public final EObject ruleCompound() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_super_4_0 = null;

        EObject lv_vars_6_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2405:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) )
            // InternalVilBuildLanguage.g:2406:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            {
            // InternalVilBuildLanguage.g:2406:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            // InternalVilBuildLanguage.g:2407:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )?
            {
            // InternalVilBuildLanguage.g:2407:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalVilBuildLanguage.g:2408:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalVilBuildLanguage.g:2408:4: (lv_abstract_0_0= 'abstract' )
                    // InternalVilBuildLanguage.g:2409:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,39,FOLLOW_42); if (state.failed) return current;
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
            // InternalVilBuildLanguage.g:2425:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2426:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2426:4: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2427:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCompoundAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_43);
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

            // InternalVilBuildLanguage.g:2444:3: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==41) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalVilBuildLanguage.g:2445:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,41,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCompoundAccess().getRefinesKeyword_3_0());
                      			
                    }
                    // InternalVilBuildLanguage.g:2449:4: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:2450:5: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:2450:5: (lv_super_4_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:2451:6: lv_super_4_0= ruleIdentifier
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

            otherlv_5=(Token)match(input,18,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCompoundAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalVilBuildLanguage.g:2473:3: ( (lv_vars_6_0= ruleVariableDeclaration ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_VERSION||(LA47_0>=RULE_ID && LA47_0<=RULE_EXPONENT)||LA47_0==38||LA47_0==44||(LA47_0>=76 && LA47_0<=79)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2474:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:2474:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    // InternalVilBuildLanguage.g:2475:5: lv_vars_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundAccess().getVarsVariableDeclarationParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_44);
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
            	    break loop47;
                }
            } while (true);

            otherlv_7=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getCompoundAccess().getRightCurlyBracketKeyword_6());
              		
            }
            // InternalVilBuildLanguage.g:2496:3: (otherlv_8= ';' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==14) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalVilBuildLanguage.g:2497:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCompoundAccess().getSemicolonKeyword_7());
                      			
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
    // $ANTLR end "ruleCompound"


    // $ANTLR start "entryRuleTypeDef"
    // InternalVilBuildLanguage.g:2506:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalVilBuildLanguage.g:2506:48: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalVilBuildLanguage.g:2507:2: iv_ruleTypeDef= ruleTypeDef EOF
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
    // InternalVilBuildLanguage.g:2513:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2519:2: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // InternalVilBuildLanguage.g:2520:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // InternalVilBuildLanguage.g:2520:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // InternalVilBuildLanguage.g:2521:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:2525:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2526:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2526:4: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2527:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            // InternalVilBuildLanguage.g:2544:3: ( (lv_type_2_0= ruleType ) )
            // InternalVilBuildLanguage.g:2545:4: (lv_type_2_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2545:4: (lv_type_2_0= ruleType )
            // InternalVilBuildLanguage.g:2546:5: lv_type_2_0= ruleType
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
    // InternalVilBuildLanguage.g:2571:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalVilBuildLanguage.g:2571:47: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalVilBuildLanguage.g:2572:2: iv_ruleAdvice= ruleAdvice EOF
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
    // InternalVilBuildLanguage.g:2578:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2584:2: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // InternalVilBuildLanguage.g:2585:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // InternalVilBuildLanguage.g:2585:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // InternalVilBuildLanguage.g:2586:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,16,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:2594:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalVilBuildLanguage.g:2595:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalVilBuildLanguage.g:2595:4: (lv_name_2_0= ruleQualifiedName )
            // InternalVilBuildLanguage.g:2596:5: lv_name_2_0= ruleQualifiedName
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

            otherlv_3=(Token)match(input,17,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalVilBuildLanguage.g:2617:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==35) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalVilBuildLanguage.g:2618:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:2618:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:2619:5: lv_versionSpec_4_0= ruleVersionSpec
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
    // InternalVilBuildLanguage.g:2640:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // InternalVilBuildLanguage.g:2640:52: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // InternalVilBuildLanguage.g:2641:2: iv_ruleVersionSpec= ruleVersionSpec EOF
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
    // InternalVilBuildLanguage.g:2647:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2653:2: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:2654:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:2654:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:2655:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:2659:3: ( (lv_restriction_1_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:2660:4: (lv_restriction_1_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:2660:4: (lv_restriction_1_0= ruleExpression )
            // InternalVilBuildLanguage.g:2661:5: lv_restriction_1_0= ruleExpression
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
    // InternalVilBuildLanguage.g:2682:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalVilBuildLanguage.g:2682:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalVilBuildLanguage.g:2683:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalVilBuildLanguage.g:2689:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2695:2: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // InternalVilBuildLanguage.g:2696:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // InternalVilBuildLanguage.g:2696:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // InternalVilBuildLanguage.g:2697:3: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // InternalVilBuildLanguage.g:2697:3: ( (lv_param_0_0= ruleParameter ) )
            // InternalVilBuildLanguage.g:2698:4: (lv_param_0_0= ruleParameter )
            {
            // InternalVilBuildLanguage.g:2698:4: (lv_param_0_0= ruleParameter )
            // InternalVilBuildLanguage.g:2699:5: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalVilBuildLanguage.g:2716:3: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==25) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:2717:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:2721:4: ( (lv_param_2_0= ruleParameter ) )
            	    // InternalVilBuildLanguage.g:2722:5: (lv_param_2_0= ruleParameter )
            	    {
            	    // InternalVilBuildLanguage.g:2722:5: (lv_param_2_0= ruleParameter )
            	    // InternalVilBuildLanguage.g:2723:6: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop50;
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
    // InternalVilBuildLanguage.g:2745:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalVilBuildLanguage.g:2745:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalVilBuildLanguage.g:2746:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalVilBuildLanguage.g:2752:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dflt_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2758:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) )
            // InternalVilBuildLanguage.g:2759:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            {
            // InternalVilBuildLanguage.g:2759:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            // InternalVilBuildLanguage.g:2760:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            {
            // InternalVilBuildLanguage.g:2760:3: ( (lv_type_0_0= ruleType ) )
            // InternalVilBuildLanguage.g:2761:4: (lv_type_0_0= ruleType )
            {
            // InternalVilBuildLanguage.g:2761:4: (lv_type_0_0= ruleType )
            // InternalVilBuildLanguage.g:2762:5: lv_type_0_0= ruleType
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

            // InternalVilBuildLanguage.g:2779:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2780:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2780:4: (lv_name_1_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2781:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalVilBuildLanguage.g:2798:3: (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalVilBuildLanguage.g:2799:4: otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalVilBuildLanguage.g:2803:4: ( (lv_dflt_3_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:2804:5: (lv_dflt_3_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:2804:5: (lv_dflt_3_0= ruleExpression )
                    // InternalVilBuildLanguage.g:2805:6: lv_dflt_3_0= ruleExpression
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
    // InternalVilBuildLanguage.g:2827:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalVilBuildLanguage.g:2827:52: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalVilBuildLanguage.g:2828:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalVilBuildLanguage.g:2834:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2840:2: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalVilBuildLanguage.g:2841:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalVilBuildLanguage.g:2841:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalVilBuildLanguage.g:2842:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:2846:3: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalVilBuildLanguage.g:2847:4: (lv_version_1_0= RULE_VERSION )
            {
            // InternalVilBuildLanguage.g:2847:4: (lv_version_1_0= RULE_VERSION )
            // InternalVilBuildLanguage.g:2848:5: lv_version_1_0= RULE_VERSION
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
    // InternalVilBuildLanguage.g:2872:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalVilBuildLanguage.g:2872:47: (iv_ruleImport= ruleImport EOF )
            // InternalVilBuildLanguage.g:2873:2: iv_ruleImport= ruleImport EOF
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
    // InternalVilBuildLanguage.g:2879:1: ruleImport returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_insert_1_0=null;
        Token lv_wildcard_3_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2885:2: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) )
            // InternalVilBuildLanguage.g:2886:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            {
            // InternalVilBuildLanguage.g:2886:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            // InternalVilBuildLanguage.g:2887:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';'
            {
            // InternalVilBuildLanguage.g:2887:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==45) ) {
                alt52=1;
            }
            else if ( (LA52_0==46) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalVilBuildLanguage.g:2888:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:2893:4: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalVilBuildLanguage.g:2893:4: ( (lv_insert_1_0= 'insert' ) )
                    // InternalVilBuildLanguage.g:2894:5: (lv_insert_1_0= 'insert' )
                    {
                    // InternalVilBuildLanguage.g:2894:5: (lv_insert_1_0= 'insert' )
                    // InternalVilBuildLanguage.g:2895:6: lv_insert_1_0= 'insert'
                    {
                    lv_insert_1_0=(Token)match(input,46,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_insert_1_0, grammarAccess.getImportAccess().getInsertInsertKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getImportRule());
                      						}
                      						setWithLastConsumed(current, "insert", lv_insert_1_0, "insert");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:2908:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:2909:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:2909:4: (lv_name_2_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:2910:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_47);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImportRule());
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

            // InternalVilBuildLanguage.g:2927:3: ( (lv_wildcard_3_0= '*' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==47) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalVilBuildLanguage.g:2928:4: (lv_wildcard_3_0= '*' )
                    {
                    // InternalVilBuildLanguage.g:2928:4: (lv_wildcard_3_0= '*' )
                    // InternalVilBuildLanguage.g:2929:5: lv_wildcard_3_0= '*'
                    {
                    lv_wildcard_3_0=(Token)match(input,47,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_wildcard_3_0, grammarAccess.getImportAccess().getWildcardAsteriskKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getImportRule());
                      					}
                      					setWithLastConsumed(current, "wildcard", lv_wildcard_3_0, "*");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:2941:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==35) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalVilBuildLanguage.g:2942:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalVilBuildLanguage.g:2942:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalVilBuildLanguage.g:2943:5: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_versionSpec_4_0=ruleVersionSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getImportRule());
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

            otherlv_5=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getImportAccess().getSemicolonKeyword_4());
              		
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
    // InternalVilBuildLanguage.g:2968:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalVilBuildLanguage.g:2968:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalVilBuildLanguage.g:2969:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalVilBuildLanguage.g:2975:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:2981:2: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // InternalVilBuildLanguage.g:2982:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // InternalVilBuildLanguage.g:2982:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=RULE_STRING && LA55_0<=RULE_EXPONENT)||LA55_0==16||(LA55_0>=28 && LA55_0<=29)||LA55_0==34||LA55_0==37||LA55_0==44||LA55_0==61||(LA55_0>=63 && LA55_0<=66)||(LA55_0>=73 && LA55_0<=75)) ) {
                alt55=1;
            }
            else if ( (LA55_0==18) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalVilBuildLanguage.g:2983:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // InternalVilBuildLanguage.g:2983:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:2984:4: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:2984:4: (lv_expr_0_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:2985:5: lv_expr_0_0= ruleLogicalExpression
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
                    // InternalVilBuildLanguage.g:3003:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // InternalVilBuildLanguage.g:3003:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // InternalVilBuildLanguage.g:3004:4: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // InternalVilBuildLanguage.g:3004:4: (lv_init_1_0= ruleContainerInitializer )
                    // InternalVilBuildLanguage.g:3005:5: lv_init_1_0= ruleContainerInitializer
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
    // InternalVilBuildLanguage.g:3026:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalVilBuildLanguage.g:3026:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalVilBuildLanguage.g:3027:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalVilBuildLanguage.g:3033:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3039:2: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalVilBuildLanguage.g:3040:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalVilBuildLanguage.g:3040:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalVilBuildLanguage.g:3041:3: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalVilBuildLanguage.g:3041:3: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalVilBuildLanguage.g:3042:4: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalVilBuildLanguage.g:3042:4: (lv_left_0_0= ruleEqualityExpression )
            // InternalVilBuildLanguage.g:3043:5: lv_left_0_0= ruleEqualityExpression
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3060:3: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop56:
            do {
                int alt56=2;
                switch ( input.LA(1) ) {
                case 48:
                    {
                    int LA56_2 = input.LA(2);

                    if ( (synpred68_InternalVilBuildLanguage()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA56_3 = input.LA(2);

                    if ( (synpred68_InternalVilBuildLanguage()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA56_4 = input.LA(2);

                    if ( (synpred68_InternalVilBuildLanguage()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 51:
                    {
                    int LA56_5 = input.LA(2);

                    if ( (synpred68_InternalVilBuildLanguage()) ) {
                        alt56=1;
                    }


                    }
                    break;
                case 52:
                    {
                    int LA56_6 = input.LA(2);

                    if ( (synpred68_InternalVilBuildLanguage()) ) {
                        alt56=1;
                    }


                    }
                    break;

                }

                switch (alt56) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3061:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalVilBuildLanguage.g:3061:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalVilBuildLanguage.g:3062:5: lv_right_1_0= ruleLogicalExpressionPart
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
            	      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpressionPart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalVilBuildLanguage.g:3083:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3083:62: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalVilBuildLanguage.g:3084:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3090:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3096:2: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalVilBuildLanguage.g:3097:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3097:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalVilBuildLanguage.g:3098:3: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalVilBuildLanguage.g:3098:3: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalVilBuildLanguage.g:3099:4: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalVilBuildLanguage.g:3099:4: (lv_op_0_0= ruleLogicalOperator )
            // InternalVilBuildLanguage.g:3100:5: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalVilBuildLanguage.g:3117:3: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalVilBuildLanguage.g:3118:4: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalVilBuildLanguage.g:3118:4: (lv_ex_1_0= ruleEqualityExpression )
            // InternalVilBuildLanguage.g:3119:5: lv_ex_1_0= ruleEqualityExpression
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
    // InternalVilBuildLanguage.g:3140:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalVilBuildLanguage.g:3140:55: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalVilBuildLanguage.g:3141:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalVilBuildLanguage.g:3147:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3153:2: ( (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) )
            // InternalVilBuildLanguage.g:3154:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            {
            // InternalVilBuildLanguage.g:3154:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            int alt57=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt57=1;
                }
                break;
            case 49:
                {
                alt57=2;
                }
                break;
            case 50:
                {
                alt57=3;
                }
                break;
            case 51:
                {
                alt57=4;
                }
                break;
            case 52:
                {
                alt57=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalVilBuildLanguage.g:3155:3: kw= 'and'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3161:3: kw= 'or'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3167:3: kw= 'xor'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:3173:3: kw= 'implies'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getImpliesKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalVilBuildLanguage.g:3179:3: kw= 'iff'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3188:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalVilBuildLanguage.g:3188:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalVilBuildLanguage.g:3189:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalVilBuildLanguage.g:3195:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3201:2: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalVilBuildLanguage.g:3202:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalVilBuildLanguage.g:3202:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalVilBuildLanguage.g:3203:3: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalVilBuildLanguage.g:3203:3: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalVilBuildLanguage.g:3204:4: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalVilBuildLanguage.g:3204:4: (lv_left_0_0= ruleRelationalExpression )
            // InternalVilBuildLanguage.g:3205:5: lv_left_0_0= ruleRelationalExpression
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3222:3: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt58=2;
            switch ( input.LA(1) ) {
                case 53:
                    {
                    int LA58_1 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt58=1;
                    }
                    }
                    break;
                case 54:
                    {
                    int LA58_2 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt58=1;
                    }
                    }
                    break;
                case 55:
                    {
                    int LA58_3 = input.LA(2);

                    if ( (synpred73_InternalVilBuildLanguage()) ) {
                        alt58=1;
                    }
                    }
                    break;
            }

            switch (alt58) {
                case 1 :
                    // InternalVilBuildLanguage.g:3223:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3223:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalVilBuildLanguage.g:3224:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalVilBuildLanguage.g:3245:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3245:63: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalVilBuildLanguage.g:3246:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3252:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3258:2: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // InternalVilBuildLanguage.g:3259:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3259:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // InternalVilBuildLanguage.g:3260:3: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // InternalVilBuildLanguage.g:3260:3: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalVilBuildLanguage.g:3261:4: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalVilBuildLanguage.g:3261:4: (lv_op_0_0= ruleEqualityOperator )
            // InternalVilBuildLanguage.g:3262:5: lv_op_0_0= ruleEqualityOperator
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.EqualityOperator");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3279:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // InternalVilBuildLanguage.g:3280:4: (lv_ex_1_0= ruleRelationalExpression )
            {
            // InternalVilBuildLanguage.g:3280:4: (lv_ex_1_0= ruleRelationalExpression )
            // InternalVilBuildLanguage.g:3281:5: lv_ex_1_0= ruleRelationalExpression
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
    // InternalVilBuildLanguage.g:3302:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalVilBuildLanguage.g:3302:56: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalVilBuildLanguage.g:3303:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalVilBuildLanguage.g:3309:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3315:2: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalVilBuildLanguage.g:3316:2: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalVilBuildLanguage.g:3316:2: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt59=1;
                }
                break;
            case 54:
                {
                alt59=2;
                }
                break;
            case 55:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalVilBuildLanguage.g:3317:3: kw= '=='
                    {
                    kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3323:3: kw= '<>'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3329:3: kw= '!='
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3338:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalVilBuildLanguage.g:3338:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalVilBuildLanguage.g:3339:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalVilBuildLanguage.g:3345:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3351:2: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalVilBuildLanguage.g:3352:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalVilBuildLanguage.g:3352:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalVilBuildLanguage.g:3353:3: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalVilBuildLanguage.g:3353:3: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalVilBuildLanguage.g:3354:4: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalVilBuildLanguage.g:3354:4: (lv_left_0_0= ruleAdditiveExpression )
            // InternalVilBuildLanguage.g:3355:5: lv_left_0_0= ruleAdditiveExpression
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3372:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt61=2;
            switch ( input.LA(1) ) {
                case 56:
                    {
                    int LA61_1 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt61=1;
                    }
                    }
                    break;
                case 57:
                    {
                    int LA61_2 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt61=1;
                    }
                    }
                    break;
                case 58:
                    {
                    int LA61_3 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt61=1;
                    }
                    }
                    break;
                case 59:
                    {
                    int LA61_4 = input.LA(2);

                    if ( (synpred77_InternalVilBuildLanguage()) ) {
                        alt61=1;
                    }
                    }
                    break;
            }

            switch (alt61) {
                case 1 :
                    // InternalVilBuildLanguage.g:3373:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalVilBuildLanguage.g:3373:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalVilBuildLanguage.g:3374:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3374:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalVilBuildLanguage.g:3375:6: lv_right_1_0= ruleRelationalExpressionPart
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
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.RelationalExpressionPart");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalVilBuildLanguage.g:3392:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt60=2;
                    switch ( input.LA(1) ) {
                        case 56:
                            {
                            int LA60_1 = input.LA(2);

                            if ( (synpred76_InternalVilBuildLanguage()) ) {
                                alt60=1;
                            }
                            }
                            break;
                        case 57:
                            {
                            int LA60_2 = input.LA(2);

                            if ( (synpred76_InternalVilBuildLanguage()) ) {
                                alt60=1;
                            }
                            }
                            break;
                        case 58:
                            {
                            int LA60_3 = input.LA(2);

                            if ( (synpred76_InternalVilBuildLanguage()) ) {
                                alt60=1;
                            }
                            }
                            break;
                        case 59:
                            {
                            int LA60_4 = input.LA(2);

                            if ( (synpred76_InternalVilBuildLanguage()) ) {
                                alt60=1;
                            }
                            }
                            break;
                    }

                    switch (alt60) {
                        case 1 :
                            // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalVilBuildLanguage.g:3394:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // InternalVilBuildLanguage.g:3416:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3416:65: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalVilBuildLanguage.g:3417:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3423:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3429:2: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalVilBuildLanguage.g:3430:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3430:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalVilBuildLanguage.g:3431:3: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalVilBuildLanguage.g:3431:3: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalVilBuildLanguage.g:3432:4: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalVilBuildLanguage.g:3432:4: (lv_op_0_0= ruleRelationalOperator )
            // InternalVilBuildLanguage.g:3433:5: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalVilBuildLanguage.g:3450:3: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalVilBuildLanguage.g:3451:4: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalVilBuildLanguage.g:3451:4: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalVilBuildLanguage.g:3452:5: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalVilBuildLanguage.g:3473:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalVilBuildLanguage.g:3473:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalVilBuildLanguage.g:3474:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalVilBuildLanguage.g:3480:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3486:2: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalVilBuildLanguage.g:3487:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalVilBuildLanguage.g:3487:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt62=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt62=1;
                }
                break;
            case 57:
                {
                alt62=2;
                }
                break;
            case 58:
                {
                alt62=3;
                }
                break;
            case 59:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalVilBuildLanguage.g:3488:3: kw= '>'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3494:3: kw= '<'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3500:3: kw= '>='
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalVilBuildLanguage.g:3506:3: kw= '<='
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3515:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalVilBuildLanguage.g:3515:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalVilBuildLanguage.g:3516:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalVilBuildLanguage.g:3522:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3528:2: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalVilBuildLanguage.g:3529:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalVilBuildLanguage.g:3529:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalVilBuildLanguage.g:3530:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalVilBuildLanguage.g:3530:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalVilBuildLanguage.g:3531:4: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalVilBuildLanguage.g:3531:4: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalVilBuildLanguage.g:3532:5: lv_left_0_0= ruleMultiplicativeExpression
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.MultiplicativeExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3549:3: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==60) ) {
                    int LA63_2 = input.LA(2);

                    if ( (synpred81_InternalVilBuildLanguage()) ) {
                        alt63=1;
                    }


                }
                else if ( (LA63_0==61) ) {
                    int LA63_3 = input.LA(2);

                    if ( (synpred81_InternalVilBuildLanguage()) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3550:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalVilBuildLanguage.g:3550:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalVilBuildLanguage.g:3551:5: lv_right_1_0= ruleAdditiveExpressionPart
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
            	      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AdditiveExpressionPart");
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // InternalVilBuildLanguage.g:3572:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3572:63: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalVilBuildLanguage.g:3573:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3579:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3585:2: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalVilBuildLanguage.g:3586:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3586:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalVilBuildLanguage.g:3587:3: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalVilBuildLanguage.g:3587:3: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalVilBuildLanguage.g:3588:4: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalVilBuildLanguage.g:3588:4: (lv_op_0_0= ruleAdditiveOperator )
            // InternalVilBuildLanguage.g:3589:5: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalVilBuildLanguage.g:3606:3: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalVilBuildLanguage.g:3607:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalVilBuildLanguage.g:3607:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalVilBuildLanguage.g:3608:5: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalVilBuildLanguage.g:3629:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalVilBuildLanguage.g:3629:56: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalVilBuildLanguage.g:3630:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalVilBuildLanguage.g:3636:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3642:2: ( (kw= '+' | kw= '-' ) )
            // InternalVilBuildLanguage.g:3643:2: (kw= '+' | kw= '-' )
            {
            // InternalVilBuildLanguage.g:3643:2: (kw= '+' | kw= '-' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==60) ) {
                alt64=1;
            }
            else if ( (LA64_0==61) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalVilBuildLanguage.g:3644:3: kw= '+'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3650:3: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3659:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalVilBuildLanguage.g:3659:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalVilBuildLanguage.g:3660:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalVilBuildLanguage.g:3666:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3672:2: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalVilBuildLanguage.g:3673:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalVilBuildLanguage.g:3673:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalVilBuildLanguage.g:3674:3: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalVilBuildLanguage.g:3674:3: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalVilBuildLanguage.g:3675:4: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalVilBuildLanguage.g:3675:4: (lv_left_0_0= ruleUnaryExpression )
            // InternalVilBuildLanguage.g:3676:5: lv_left_0_0= ruleUnaryExpression
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.UnaryExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalVilBuildLanguage.g:3693:3: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==47) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred83_InternalVilBuildLanguage()) ) {
                    alt65=1;
                }
            }
            else if ( (LA65_0==62) ) {
                int LA65_2 = input.LA(2);

                if ( (synpred83_InternalVilBuildLanguage()) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalVilBuildLanguage.g:3694:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalVilBuildLanguage.g:3694:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalVilBuildLanguage.g:3695:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalVilBuildLanguage.g:3716:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalVilBuildLanguage.g:3716:69: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalVilBuildLanguage.g:3717:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalVilBuildLanguage.g:3723:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3729:2: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalVilBuildLanguage.g:3730:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3730:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalVilBuildLanguage.g:3731:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalVilBuildLanguage.g:3731:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalVilBuildLanguage.g:3732:4: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalVilBuildLanguage.g:3732:4: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalVilBuildLanguage.g:3733:5: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_28);
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

            // InternalVilBuildLanguage.g:3750:3: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalVilBuildLanguage.g:3751:4: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalVilBuildLanguage.g:3751:4: (lv_expr_1_0= ruleUnaryExpression )
            // InternalVilBuildLanguage.g:3752:5: lv_expr_1_0= ruleUnaryExpression
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
    // InternalVilBuildLanguage.g:3773:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalVilBuildLanguage.g:3773:62: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalVilBuildLanguage.g:3774:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalVilBuildLanguage.g:3780:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3786:2: ( (kw= '*' | kw= '/' ) )
            // InternalVilBuildLanguage.g:3787:2: (kw= '*' | kw= '/' )
            {
            // InternalVilBuildLanguage.g:3787:2: (kw= '*' | kw= '/' )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==47) ) {
                alt66=1;
            }
            else if ( (LA66_0==62) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalVilBuildLanguage.g:3788:3: kw= '*'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3794:3: kw= '/'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3803:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalVilBuildLanguage.g:3803:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalVilBuildLanguage.g:3804:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalVilBuildLanguage.g:3810:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3816:2: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalVilBuildLanguage.g:3817:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalVilBuildLanguage.g:3817:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalVilBuildLanguage.g:3818:3: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalVilBuildLanguage.g:3818:3: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==61||(LA67_0>=63 && LA67_0<=64)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalVilBuildLanguage.g:3819:4: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalVilBuildLanguage.g:3819:4: (lv_op_0_0= ruleUnaryOperator )
                    // InternalVilBuildLanguage.g:3820:5: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_28);
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

            // InternalVilBuildLanguage.g:3837:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalVilBuildLanguage.g:3838:4: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalVilBuildLanguage.g:3838:4: (lv_expr_1_0= rulePostfixExpression )
            // InternalVilBuildLanguage.g:3839:5: lv_expr_1_0= rulePostfixExpression
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
    // InternalVilBuildLanguage.g:3860:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalVilBuildLanguage.g:3860:53: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalVilBuildLanguage.g:3861:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalVilBuildLanguage.g:3867:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3873:2: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // InternalVilBuildLanguage.g:3874:2: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // InternalVilBuildLanguage.g:3874:2: (kw= 'not' | kw= '!' | kw= '-' )
            int alt68=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt68=1;
                }
                break;
            case 64:
                {
                alt68=2;
                }
                break;
            case 61:
                {
                alt68=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalVilBuildLanguage.g:3875:3: kw= 'not'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalVilBuildLanguage.g:3881:3: kw= '!'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalVilBuildLanguage.g:3887:3: kw= '-'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:3896:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalVilBuildLanguage.g:3896:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalVilBuildLanguage.g:3897:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalVilBuildLanguage.g:3903:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3909:2: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // InternalVilBuildLanguage.g:3910:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // InternalVilBuildLanguage.g:3910:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            // InternalVilBuildLanguage.g:3911:3: (lv_left_0_0= rulePrimaryExpression )
            {
            // InternalVilBuildLanguage.g:3911:3: (lv_left_0_0= rulePrimaryExpression )
            // InternalVilBuildLanguage.g:3912:4: lv_left_0_0= rulePrimaryExpression
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
              					"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.PrimaryExpression");
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
    // InternalVilBuildLanguage.g:3932:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // InternalVilBuildLanguage.g:3932:71: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // InternalVilBuildLanguage.g:3933:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
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
    // InternalVilBuildLanguage.g:3939:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:3945:2: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:3946:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:3946:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:3947:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // InternalVilBuildLanguage.g:3947:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_EXPONENT)||LA69_0==44||(LA69_0>=73 && LA69_0<=75)) ) {
                alt69=1;
            }
            else if ( (LA69_0==16) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalVilBuildLanguage.g:3948:4: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // InternalVilBuildLanguage.g:3948:4: ( (lv_val_0_0= ruleConstant ) )
                    // InternalVilBuildLanguage.g:3949:5: (lv_val_0_0= ruleConstant )
                    {
                    // InternalVilBuildLanguage.g:3949:5: (lv_val_0_0= ruleConstant )
                    // InternalVilBuildLanguage.g:3950:6: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
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
                    // InternalVilBuildLanguage.g:3968:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalVilBuildLanguage.g:3968:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalVilBuildLanguage.g:3969:5: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                      				
                    }
                    // InternalVilBuildLanguage.g:3973:5: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:3974:6: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:3974:6: (lv_parenthesis_2_0= ruleExpression )
                    // InternalVilBuildLanguage.g:3975:7: lv_parenthesis_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,17,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalVilBuildLanguage.g:3998:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==27||(LA70_0>=67 && LA70_0<=68)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:3999:4: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:3999:4: (lv_calls_4_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4000:5: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // InternalVilBuildLanguage.g:4021:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // InternalVilBuildLanguage.g:4021:61: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // InternalVilBuildLanguage.g:4022:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
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
    // InternalVilBuildLanguage.g:4028:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4034:2: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:4035:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:4035:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:4036:3: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // InternalVilBuildLanguage.g:4036:3: ( (lv_call_0_0= ruleCall ) )
            // InternalVilBuildLanguage.g:4037:4: (lv_call_0_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:4037:4: (lv_call_0_0= ruleCall )
            // InternalVilBuildLanguage.g:4038:5: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalVilBuildLanguage.g:4055:3: ( (lv_calls_1_0= ruleSubCall ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==27||(LA71_0>=67 && LA71_0<=68)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4056:4: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:4056:4: (lv_calls_1_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4057:5: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // InternalVilBuildLanguage.g:4078:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // InternalVilBuildLanguage.g:4078:55: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // InternalVilBuildLanguage.g:4079:2: iv_ruleSuperExecution= ruleSuperExecution EOF
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
    // InternalVilBuildLanguage.g:4085:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4091:2: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:4092:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:4092:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:4093:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,65,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,27,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:4101:3: ( (lv_call_2_0= ruleCall ) )
            // InternalVilBuildLanguage.g:4102:4: (lv_call_2_0= ruleCall )
            {
            // InternalVilBuildLanguage.g:4102:4: (lv_call_2_0= ruleCall )
            // InternalVilBuildLanguage.g:4103:5: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalVilBuildLanguage.g:4120:3: ( (lv_calls_3_0= ruleSubCall ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==27||(LA72_0>=67 && LA72_0<=68)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4121:4: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:4121:4: (lv_calls_3_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4122:5: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop72;
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
    // InternalVilBuildLanguage.g:4143:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // InternalVilBuildLanguage.g:4143:61: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // InternalVilBuildLanguage.g:4144:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
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
    // InternalVilBuildLanguage.g:4150:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // InternalVilBuildLanguage.g:4156:2: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // InternalVilBuildLanguage.g:4157:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // InternalVilBuildLanguage.g:4157:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // InternalVilBuildLanguage.g:4158:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,66,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:4162:3: ( (lv_type_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:4163:4: (lv_type_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:4163:4: (lv_type_1_0= ruleType )
            // InternalVilBuildLanguage.g:4164:5: lv_type_1_0= ruleType
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

            otherlv_2=(Token)match(input,16,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalVilBuildLanguage.g:4185:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_STRING && LA73_0<=RULE_EXPONENT)||LA73_0==16||LA73_0==18||(LA73_0>=28 && LA73_0<=29)||LA73_0==34||LA73_0==37||LA73_0==44||LA73_0==61||(LA73_0>=63 && LA73_0<=66)||(LA73_0>=73 && LA73_0<=75)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalVilBuildLanguage.g:4186:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:4186:4: (lv_param_3_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:4187:5: lv_param_3_0= ruleArgumentList
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

            otherlv_4=(Token)match(input,17,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalVilBuildLanguage.g:4208:3: ( (lv_calls_5_0= ruleSubCall ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==27||(LA74_0>=67 && LA74_0<=68)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4209:4: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // InternalVilBuildLanguage.g:4209:4: (lv_calls_5_0= ruleSubCall )
            	    // InternalVilBuildLanguage.g:4210:5: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop74;
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
    // InternalVilBuildLanguage.g:4231:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // InternalVilBuildLanguage.g:4231:48: (iv_ruleSubCall= ruleSubCall EOF )
            // InternalVilBuildLanguage.g:4232:2: iv_ruleSubCall= ruleSubCall EOF
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
    // InternalVilBuildLanguage.g:4238:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // InternalVilBuildLanguage.g:4244:2: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // InternalVilBuildLanguage.g:4245:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // InternalVilBuildLanguage.g:4245:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==27||LA76_0==67) ) {
                alt76=1;
            }
            else if ( (LA76_0==68) ) {
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
                    // InternalVilBuildLanguage.g:4246:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // InternalVilBuildLanguage.g:4246:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // InternalVilBuildLanguage.g:4247:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // InternalVilBuildLanguage.g:4247:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // InternalVilBuildLanguage.g:4248:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // InternalVilBuildLanguage.g:4248:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // InternalVilBuildLanguage.g:4249:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // InternalVilBuildLanguage.g:4249:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==27) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==67) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalVilBuildLanguage.g:4250:7: lv_type_0_1= '.'
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
                            // InternalVilBuildLanguage.g:4261:7: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,67,FOLLOW_10); if (state.failed) return current;
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

                    // InternalVilBuildLanguage.g:4274:4: ( (lv_call_1_0= ruleCall ) )
                    // InternalVilBuildLanguage.g:4275:5: (lv_call_1_0= ruleCall )
                    {
                    // InternalVilBuildLanguage.g:4275:5: (lv_call_1_0= ruleCall )
                    // InternalVilBuildLanguage.g:4276:6: lv_call_1_0= ruleCall
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
                    // InternalVilBuildLanguage.g:4295:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalVilBuildLanguage.g:4295:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalVilBuildLanguage.g:4296:4: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,68,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalVilBuildLanguage.g:4300:4: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:4301:5: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:4301:5: (lv_arrayEx_3_0= ruleExpression )
                    // InternalVilBuildLanguage.g:4302:6: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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

                    otherlv_4=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:4328:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalVilBuildLanguage.g:4328:51: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalVilBuildLanguage.g:4329:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalVilBuildLanguage.g:4335:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4341:2: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalVilBuildLanguage.g:4342:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalVilBuildLanguage.g:4342:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalVilBuildLanguage.g:4343:3: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalVilBuildLanguage.g:4343:3: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalVilBuildLanguage.g:4344:4: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalVilBuildLanguage.g:4344:4: (lv_decl_0_0= ruleDeclaration )
            // InternalVilBuildLanguage.g:4345:5: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalVilBuildLanguage.g:4362:3: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==14) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4363:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:4367:4: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalVilBuildLanguage.g:4368:5: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalVilBuildLanguage.g:4368:5: (lv_decl_2_0= ruleDeclaration )
            	    // InternalVilBuildLanguage.g:4369:6: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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
            	    break loop77;
                }
            } while (true);

            otherlv_3=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalVilBuildLanguage.g:4395:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalVilBuildLanguage.g:4395:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalVilBuildLanguage.g:4396:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalVilBuildLanguage.g:4402:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4408:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // InternalVilBuildLanguage.g:4409:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // InternalVilBuildLanguage.g:4409:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // InternalVilBuildLanguage.g:4410:3: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // InternalVilBuildLanguage.g:4410:3: ( (lv_type_0_0= ruleType ) )?
            int alt78=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA78_1 = input.LA(2);

                    if ( (LA78_1==RULE_VERSION||(LA78_1>=RULE_ID && LA78_1<=RULE_EXPONENT)||LA78_1==44||LA78_1==72) ) {
                        alt78=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA78_2 = input.LA(2);

                    if ( (LA78_2==RULE_VERSION||(LA78_2>=RULE_ID && LA78_2<=RULE_EXPONENT)||LA78_2==44||LA78_2==72) ) {
                        alt78=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA78_3 = input.LA(2);

                    if ( (LA78_3==RULE_VERSION||(LA78_3>=RULE_ID && LA78_3<=RULE_EXPONENT)||LA78_3==44||LA78_3==72) ) {
                        alt78=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA78_4 = input.LA(2);

                    if ( (LA78_4==RULE_VERSION||(LA78_4>=RULE_ID && LA78_4<=RULE_EXPONENT)||LA78_4==44||LA78_4==72) ) {
                        alt78=1;
                    }
                    }
                    break;
                case 76:
                case 77:
                case 78:
                case 79:
                    {
                    alt78=1;
                    }
                    break;
            }

            switch (alt78) {
                case 1 :
                    // InternalVilBuildLanguage.g:4411:4: (lv_type_0_0= ruleType )
                    {
                    // InternalVilBuildLanguage.g:4411:4: (lv_type_0_0= ruleType )
                    // InternalVilBuildLanguage.g:4412:5: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_22);
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

            // InternalVilBuildLanguage.g:4429:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // InternalVilBuildLanguage.g:4430:4: (lv_units_1_0= ruleDeclarationUnit )
            {
            // InternalVilBuildLanguage.g:4430:4: (lv_units_1_0= ruleDeclarationUnit )
            // InternalVilBuildLanguage.g:4431:5: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalVilBuildLanguage.g:4448:3: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==25) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4449:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:4453:4: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // InternalVilBuildLanguage.g:4454:5: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // InternalVilBuildLanguage.g:4454:5: (lv_units_3_0= ruleDeclarationUnit )
            	    // InternalVilBuildLanguage.g:4455:6: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleDeclarationUnit"
    // InternalVilBuildLanguage.g:4477:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // InternalVilBuildLanguage.g:4477:56: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // InternalVilBuildLanguage.g:4478:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
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
    // InternalVilBuildLanguage.g:4484:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4490:2: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // InternalVilBuildLanguage.g:4491:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // InternalVilBuildLanguage.g:4491:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // InternalVilBuildLanguage.g:4492:3: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // InternalVilBuildLanguage.g:4492:3: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:4493:4: (lv_id_0_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:4493:4: (lv_id_0_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:4494:5: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalVilBuildLanguage.g:4511:3: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==23) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalVilBuildLanguage.g:4512:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalVilBuildLanguage.g:4516:4: ( (lv_deflt_2_0= ruleExpression ) )
                    // InternalVilBuildLanguage.g:4517:5: (lv_deflt_2_0= ruleExpression )
                    {
                    // InternalVilBuildLanguage.g:4517:5: (lv_deflt_2_0= ruleExpression )
                    // InternalVilBuildLanguage.g:4518:6: lv_deflt_2_0= ruleExpression
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


    // $ANTLR start "entryRuleAnnotationDeclarations"
    // InternalVilBuildLanguage.g:4540:1: entryRuleAnnotationDeclarations returns [EObject current=null] : iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF ;
    public final EObject entryRuleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationDeclarations = null;


        try {
            // InternalVilBuildLanguage.g:4540:63: (iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF )
            // InternalVilBuildLanguage.g:4541:2: iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotationDeclarationsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationDeclarations=ruleAnnotationDeclarations();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotationDeclarations; 
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
    // $ANTLR end "entryRuleAnnotationDeclarations"


    // $ANTLR start "ruleAnnotationDeclarations"
    // InternalVilBuildLanguage.g:4547:1: ruleAnnotationDeclarations returns [EObject current=null] : ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4553:2: ( ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) )
            // InternalVilBuildLanguage.g:4554:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            {
            // InternalVilBuildLanguage.g:4554:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            // InternalVilBuildLanguage.g:4555:3: () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            {
            // InternalVilBuildLanguage.g:4555:3: ()
            // InternalVilBuildLanguage.g:4556:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAnnotationDeclarationsAccess().getAnnotationDeclarationsAction_0(),
              					current);
              			
            }

            }

            // InternalVilBuildLanguage.g:4565:3: (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==71) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4566:4: otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,71,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAnnotationDeclarationsAccess().getCommercialAtKeyword_1_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:4570:4: ( (lv_id_2_0= ruleIdentifier ) )
            	    // InternalVilBuildLanguage.g:4571:5: (lv_id_2_0= ruleIdentifier )
            	    {
            	    // InternalVilBuildLanguage.g:4571:5: (lv_id_2_0= ruleIdentifier )
            	    // InternalVilBuildLanguage.g:4572:6: lv_id_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAnnotationDeclarationsAccess().getIdIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_id_2_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAnnotationDeclarationsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"id",
            	      							lv_id_2_0,
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
    // $ANTLR end "ruleAnnotationDeclarations"


    // $ANTLR start "entryRuleCall"
    // InternalVilBuildLanguage.g:4594:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalVilBuildLanguage.g:4594:45: (iv_ruleCall= ruleCall EOF )
            // InternalVilBuildLanguage.g:4595:2: iv_ruleCall= ruleCall EOF
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
    // InternalVilBuildLanguage.g:4601:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4607:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // InternalVilBuildLanguage.g:4608:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // InternalVilBuildLanguage.g:4608:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // InternalVilBuildLanguage.g:4609:3: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // InternalVilBuildLanguage.g:4609:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // InternalVilBuildLanguage.g:4610:4: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // InternalVilBuildLanguage.g:4610:4: (lv_name_0_0= ruleQualifiedPrefix )
            // InternalVilBuildLanguage.g:4611:5: lv_name_0_0= ruleQualifiedPrefix
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

            otherlv_1=(Token)match(input,16,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:4632:3: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalVilBuildLanguage.g:4633:4: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalVilBuildLanguage.g:4633:4: (lv_decl_2_0= ruleDeclarator )
                    // InternalVilBuildLanguage.g:4634:5: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_33);
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

            // InternalVilBuildLanguage.g:4651:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_STRING && LA83_0<=RULE_EXPONENT)||LA83_0==16||LA83_0==18||(LA83_0>=28 && LA83_0<=29)||LA83_0==34||LA83_0==37||LA83_0==44||LA83_0==61||(LA83_0>=63 && LA83_0<=66)||(LA83_0>=73 && LA83_0<=75)) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalVilBuildLanguage.g:4652:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalVilBuildLanguage.g:4652:4: (lv_param_3_0= ruleArgumentList )
                    // InternalVilBuildLanguage.g:4653:5: lv_param_3_0= ruleArgumentList
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
    // InternalVilBuildLanguage.g:4678:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // InternalVilBuildLanguage.g:4678:53: (iv_ruleArgumentList= ruleArgumentList EOF )
            // InternalVilBuildLanguage.g:4679:2: iv_ruleArgumentList= ruleArgumentList EOF
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
    // InternalVilBuildLanguage.g:4685:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4691:2: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // InternalVilBuildLanguage.g:4692:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // InternalVilBuildLanguage.g:4692:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // InternalVilBuildLanguage.g:4693:3: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // InternalVilBuildLanguage.g:4693:3: ( (lv_param_0_0= ruleNamedArgument ) )
            // InternalVilBuildLanguage.g:4694:4: (lv_param_0_0= ruleNamedArgument )
            {
            // InternalVilBuildLanguage.g:4694:4: (lv_param_0_0= ruleNamedArgument )
            // InternalVilBuildLanguage.g:4695:5: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            // InternalVilBuildLanguage.g:4712:3: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==25) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4713:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:4717:4: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // InternalVilBuildLanguage.g:4718:5: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // InternalVilBuildLanguage.g:4718:5: (lv_param_2_0= ruleNamedArgument )
            	    // InternalVilBuildLanguage.g:4719:6: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop84;
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
    // InternalVilBuildLanguage.g:4741:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalVilBuildLanguage.g:4741:54: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalVilBuildLanguage.g:4742:2: iv_ruleNamedArgument= ruleNamedArgument EOF
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
    // InternalVilBuildLanguage.g:4748:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4754:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // InternalVilBuildLanguage.g:4755:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // InternalVilBuildLanguage.g:4755:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // InternalVilBuildLanguage.g:4756:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // InternalVilBuildLanguage.g:4756:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt85=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA85_1 = input.LA(2);

                    if ( (LA85_1==23) ) {
                        alt85=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA85_2 = input.LA(2);

                    if ( (LA85_2==23) ) {
                        alt85=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA85_3 = input.LA(2);

                    if ( (LA85_3==23) ) {
                        alt85=1;
                    }
                    }
                    break;
                case 44:
                    {
                    int LA85_4 = input.LA(2);

                    if ( (LA85_4==23) ) {
                        alt85=1;
                    }
                    }
                    break;
            }

            switch (alt85) {
                case 1 :
                    // InternalVilBuildLanguage.g:4757:4: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalVilBuildLanguage.g:4757:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalVilBuildLanguage.g:4758:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalVilBuildLanguage.g:4758:5: (lv_name_0_0= ruleIdentifier )
                    // InternalVilBuildLanguage.g:4759:6: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalVilBuildLanguage.g:4781:3: ( (lv_ex_2_0= ruleExpression ) )
            // InternalVilBuildLanguage.g:4782:4: (lv_ex_2_0= ruleExpression )
            {
            // InternalVilBuildLanguage.g:4782:4: (lv_ex_2_0= ruleExpression )
            // InternalVilBuildLanguage.g:4783:5: lv_ex_2_0= ruleExpression
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
    // InternalVilBuildLanguage.g:4804:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // InternalVilBuildLanguage.g:4804:56: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // InternalVilBuildLanguage.g:4805:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
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
    // InternalVilBuildLanguage.g:4811:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4817:2: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalVilBuildLanguage.g:4818:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalVilBuildLanguage.g:4818:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalVilBuildLanguage.g:4819:3: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalVilBuildLanguage.g:4819:3: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalVilBuildLanguage.g:4820:4: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalVilBuildLanguage.g:4820:4: (lv_qname_0_0= ruleIdentifier )
            // InternalVilBuildLanguage.g:4821:5: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalVilBuildLanguage.g:4838:3: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==72) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4839:4: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalVilBuildLanguage.g:4839:4: ( (lv_qname_1_0= '::' ) )
            	    // InternalVilBuildLanguage.g:4840:5: (lv_qname_1_0= '::' )
            	    {
            	    // InternalVilBuildLanguage.g:4840:5: (lv_qname_1_0= '::' )
            	    // InternalVilBuildLanguage.g:4841:6: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,72,FOLLOW_10); if (state.failed) return current;
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

            	    // InternalVilBuildLanguage.g:4853:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalVilBuildLanguage.g:4854:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalVilBuildLanguage.g:4854:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalVilBuildLanguage.g:4855:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop86;
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
    // InternalVilBuildLanguage.g:4877:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalVilBuildLanguage.g:4877:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalVilBuildLanguage.g:4878:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalVilBuildLanguage.g:4884:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:4890:2: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalVilBuildLanguage.g:4891:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalVilBuildLanguage.g:4891:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalVilBuildLanguage.g:4892:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalVilBuildLanguage.g:4892:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // InternalVilBuildLanguage.g:4893:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // InternalVilBuildLanguage.g:4893:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            // InternalVilBuildLanguage.g:4894:5: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_60);
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

            // InternalVilBuildLanguage.g:4911:3: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==27) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA87_3 = input.LA(3);

                        if ( (LA87_3==EOF||(LA87_3>=14 && LA87_3<=15)||(LA87_3>=17 && LA87_3<=19)||(LA87_3>=24 && LA87_3<=25)||LA87_3==27||LA87_3==43||(LA87_3>=47 && LA87_3<=62)||(LA87_3>=67 && LA87_3<=70)) ) {
                            alt87=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA87_4 = input.LA(3);

                        if ( (LA87_4==EOF||(LA87_4>=14 && LA87_4<=15)||(LA87_4>=17 && LA87_4<=19)||(LA87_4>=24 && LA87_4<=25)||LA87_4==27||LA87_4==43||(LA87_4>=47 && LA87_4<=62)||(LA87_4>=67 && LA87_4<=70)) ) {
                            alt87=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA87_5 = input.LA(3);

                        if ( (LA87_5==EOF||(LA87_5>=14 && LA87_5<=15)||(LA87_5>=17 && LA87_5<=19)||(LA87_5>=24 && LA87_5<=25)||LA87_5==27||LA87_5==43||(LA87_5>=47 && LA87_5<=62)||(LA87_5>=67 && LA87_5<=70)) ) {
                            alt87=1;
                        }


                        }
                        break;
                    case 44:
                        {
                        int LA87_6 = input.LA(3);

                        if ( (LA87_6==EOF||(LA87_6>=14 && LA87_6<=15)||(LA87_6>=17 && LA87_6<=19)||(LA87_6>=24 && LA87_6<=25)||LA87_6==27||LA87_6==43||(LA87_6>=47 && LA87_6<=62)||(LA87_6>=67 && LA87_6<=70)) ) {
                            alt87=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt87) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:4912:4: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalVilBuildLanguage.g:4912:4: ( (lv_qname_1_0= '.' ) )
            	    // InternalVilBuildLanguage.g:4913:5: (lv_qname_1_0= '.' )
            	    {
            	    // InternalVilBuildLanguage.g:4913:5: (lv_qname_1_0= '.' )
            	    // InternalVilBuildLanguage.g:4914:6: lv_qname_1_0= '.'
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

            	    // InternalVilBuildLanguage.g:4926:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalVilBuildLanguage.g:4927:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalVilBuildLanguage.g:4927:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalVilBuildLanguage.g:4928:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
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
            	    break loop87;
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
    // InternalVilBuildLanguage.g:4950:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalVilBuildLanguage.g:4950:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalVilBuildLanguage.g:4951:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalVilBuildLanguage.g:4957:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // InternalVilBuildLanguage.g:4963:2: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // InternalVilBuildLanguage.g:4964:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // InternalVilBuildLanguage.g:4964:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt89=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt89=1;
                }
                break;
            case RULE_STRING:
                {
                alt89=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 44:
                {
                alt89=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA89_4 = input.LA(2);

                if ( (synpred109_InternalVilBuildLanguage()) ) {
                    alt89=3;
                }
                else if ( (synpred113_InternalVilBuildLanguage()) ) {
                    alt89=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 4, input);

                    throw nvae;
                }
                }
                break;
            case 73:
            case 74:
                {
                alt89=4;
                }
                break;
            case 75:
                {
                alt89=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalVilBuildLanguage.g:4965:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalVilBuildLanguage.g:4965:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalVilBuildLanguage.g:4966:4: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalVilBuildLanguage.g:4966:4: (lv_nValue_0_0= ruleNumValue )
                    // InternalVilBuildLanguage.g:4967:5: lv_nValue_0_0= ruleNumValue
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
                    // InternalVilBuildLanguage.g:4985:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalVilBuildLanguage.g:4985:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalVilBuildLanguage.g:4986:4: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalVilBuildLanguage.g:4986:4: (lv_sValue_1_0= RULE_STRING )
                    // InternalVilBuildLanguage.g:4987:5: lv_sValue_1_0= RULE_STRING
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
                    // InternalVilBuildLanguage.g:5004:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalVilBuildLanguage.g:5004:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalVilBuildLanguage.g:5005:4: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalVilBuildLanguage.g:5005:4: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalVilBuildLanguage.g:5006:5: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalVilBuildLanguage.g:5024:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalVilBuildLanguage.g:5024:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalVilBuildLanguage.g:5025:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalVilBuildLanguage.g:5025:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalVilBuildLanguage.g:5026:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalVilBuildLanguage.g:5026:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==73) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==74) ) {
                        alt88=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalVilBuildLanguage.g:5027:6: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
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
                            // InternalVilBuildLanguage.g:5038:6: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
                    // InternalVilBuildLanguage.g:5052:3: ( (lv_null_4_0= 'null' ) )
                    {
                    // InternalVilBuildLanguage.g:5052:3: ( (lv_null_4_0= 'null' ) )
                    // InternalVilBuildLanguage.g:5053:4: (lv_null_4_0= 'null' )
                    {
                    // InternalVilBuildLanguage.g:5053:4: (lv_null_4_0= 'null' )
                    // InternalVilBuildLanguage.g:5054:5: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
                    // InternalVilBuildLanguage.g:5067:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // InternalVilBuildLanguage.g:5067:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // InternalVilBuildLanguage.g:5068:4: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // InternalVilBuildLanguage.g:5072:4: (lv_version_5_0= RULE_VERSION )
                    // InternalVilBuildLanguage.g:5073:5: lv_version_5_0= RULE_VERSION
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
    // InternalVilBuildLanguage.g:5093:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalVilBuildLanguage.g:5093:49: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalVilBuildLanguage.g:5094:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalVilBuildLanguage.g:5100:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:5106:2: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalVilBuildLanguage.g:5107:2: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalVilBuildLanguage.g:5107:2: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalVilBuildLanguage.g:5108:3: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalVilBuildLanguage.g:5108:3: (lv_val_0_0= RULE_NUMBER )
            // InternalVilBuildLanguage.g:5109:4: lv_val_0_0= RULE_NUMBER
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
    // InternalVilBuildLanguage.g:5128:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalVilBuildLanguage.g:5128:50: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalVilBuildLanguage.g:5129:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalVilBuildLanguage.g:5135:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalVilBuildLanguage.g:5141:2: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalVilBuildLanguage.g:5142:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalVilBuildLanguage.g:5142:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt90=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt90=1;
                }
                break;
            case RULE_VERSION:
                {
                alt90=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt90=3;
                }
                break;
            case 44:
                {
                alt90=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalVilBuildLanguage.g:5143:3: this_ID_0= RULE_ID
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
                    // InternalVilBuildLanguage.g:5151:3: this_VERSION_1= RULE_VERSION
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
                    // InternalVilBuildLanguage.g:5159:3: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalVilBuildLanguage.g:5167:3: kw= 'version'
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
    // InternalVilBuildLanguage.g:5176:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalVilBuildLanguage.g:5176:45: (iv_ruleType= ruleType EOF )
            // InternalVilBuildLanguage.g:5177:2: iv_ruleType= ruleType EOF
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
    // InternalVilBuildLanguage.g:5183:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // InternalVilBuildLanguage.g:5189:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // InternalVilBuildLanguage.g:5190:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // InternalVilBuildLanguage.g:5190:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt92=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 44:
                {
                alt92=1;
                }
                break;
            case 76:
                {
                alt92=2;
                }
                break;
            case 77:
                {
                alt92=3;
                }
                break;
            case 78:
                {
                alt92=4;
                }
                break;
            case 79:
                {
                alt92=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalVilBuildLanguage.g:5191:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // InternalVilBuildLanguage.g:5191:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // InternalVilBuildLanguage.g:5192:4: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // InternalVilBuildLanguage.g:5192:4: (lv_name_0_0= ruleQualifiedPrefix )
                    // InternalVilBuildLanguage.g:5193:5: lv_name_0_0= ruleQualifiedPrefix
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
                    // InternalVilBuildLanguage.g:5211:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5211:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5212:4: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5212:4: ( (lv_set_1_0= 'setOf' ) )
                    // InternalVilBuildLanguage.g:5213:5: (lv_set_1_0= 'setOf' )
                    {
                    // InternalVilBuildLanguage.g:5213:5: (lv_set_1_0= 'setOf' )
                    // InternalVilBuildLanguage.g:5214:6: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,76,FOLLOW_11); if (state.failed) return current;
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

                    // InternalVilBuildLanguage.g:5226:4: ( (lv_param_2_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5227:5: (lv_param_2_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5227:5: (lv_param_2_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5228:6: lv_param_2_0= ruleTypeParameters
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
                    // InternalVilBuildLanguage.g:5247:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5247:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5248:4: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5248:4: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // InternalVilBuildLanguage.g:5249:5: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // InternalVilBuildLanguage.g:5249:5: (lv_seq_3_0= 'sequenceOf' )
                    // InternalVilBuildLanguage.g:5250:6: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,77,FOLLOW_11); if (state.failed) return current;
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

                    // InternalVilBuildLanguage.g:5262:4: ( (lv_param_4_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5263:5: (lv_param_4_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5263:5: (lv_param_4_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5264:6: lv_param_4_0= ruleTypeParameters
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
                    // InternalVilBuildLanguage.g:5283:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5283:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5284:4: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5284:4: ( (lv_map_5_0= 'mapOf' ) )
                    // InternalVilBuildLanguage.g:5285:5: (lv_map_5_0= 'mapOf' )
                    {
                    // InternalVilBuildLanguage.g:5285:5: (lv_map_5_0= 'mapOf' )
                    // InternalVilBuildLanguage.g:5286:6: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,78,FOLLOW_11); if (state.failed) return current;
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

                    // InternalVilBuildLanguage.g:5298:4: ( (lv_param_6_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5299:5: (lv_param_6_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5299:5: (lv_param_6_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5300:6: lv_param_6_0= ruleTypeParameters
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
                    // InternalVilBuildLanguage.g:5319:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // InternalVilBuildLanguage.g:5319:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // InternalVilBuildLanguage.g:5320:4: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // InternalVilBuildLanguage.g:5320:4: ( (lv_call_7_0= 'callOf' ) )
                    // InternalVilBuildLanguage.g:5321:5: (lv_call_7_0= 'callOf' )
                    {
                    // InternalVilBuildLanguage.g:5321:5: (lv_call_7_0= 'callOf' )
                    // InternalVilBuildLanguage.g:5322:6: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,79,FOLLOW_61); if (state.failed) return current;
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

                    // InternalVilBuildLanguage.g:5334:4: ( (lv_return_8_0= ruleType ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==RULE_VERSION||(LA91_0>=RULE_ID && LA91_0<=RULE_EXPONENT)||LA91_0==44||(LA91_0>=76 && LA91_0<=79)) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalVilBuildLanguage.g:5335:5: (lv_return_8_0= ruleType )
                            {
                            // InternalVilBuildLanguage.g:5335:5: (lv_return_8_0= ruleType )
                            // InternalVilBuildLanguage.g:5336:6: lv_return_8_0= ruleType
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

                    // InternalVilBuildLanguage.g:5353:4: ( (lv_param_9_0= ruleTypeParameters ) )
                    // InternalVilBuildLanguage.g:5354:5: (lv_param_9_0= ruleTypeParameters )
                    {
                    // InternalVilBuildLanguage.g:5354:5: (lv_param_9_0= ruleTypeParameters )
                    // InternalVilBuildLanguage.g:5355:6: lv_param_9_0= ruleTypeParameters
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
    // InternalVilBuildLanguage.g:5377:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // InternalVilBuildLanguage.g:5377:55: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // InternalVilBuildLanguage.g:5378:2: iv_ruleTypeParameters= ruleTypeParameters EOF
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
    // InternalVilBuildLanguage.g:5384:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:5390:2: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // InternalVilBuildLanguage.g:5391:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // InternalVilBuildLanguage.g:5391:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // InternalVilBuildLanguage.g:5392:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalVilBuildLanguage.g:5396:3: ( (lv_param_1_0= ruleType ) )
            // InternalVilBuildLanguage.g:5397:4: (lv_param_1_0= ruleType )
            {
            // InternalVilBuildLanguage.g:5397:4: (lv_param_1_0= ruleType )
            // InternalVilBuildLanguage.g:5398:5: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_62);
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

            // InternalVilBuildLanguage.g:5415:3: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==25) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalVilBuildLanguage.g:5416:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalVilBuildLanguage.g:5420:4: ( (lv_param_3_0= ruleType ) )
            	    // InternalVilBuildLanguage.g:5421:5: (lv_param_3_0= ruleType )
            	    {
            	    // InternalVilBuildLanguage.g:5421:5: (lv_param_3_0= ruleType )
            	    // InternalVilBuildLanguage.g:5422:6: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
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
            	    break loop93;
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
    // InternalVilBuildLanguage.g:5448:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalVilBuildLanguage.g:5448:61: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalVilBuildLanguage.g:5449:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalVilBuildLanguage.g:5455:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:5461:2: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // InternalVilBuildLanguage.g:5462:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // InternalVilBuildLanguage.g:5462:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // InternalVilBuildLanguage.g:5463:3: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // InternalVilBuildLanguage.g:5463:3: ()
            // InternalVilBuildLanguage.g:5464:4: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalVilBuildLanguage.g:5477:3: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=RULE_STRING && LA95_0<=RULE_EXPONENT)||LA95_0==16||LA95_0==18||(LA95_0>=28 && LA95_0<=29)||LA95_0==34||LA95_0==37||LA95_0==44||LA95_0==61||(LA95_0>=63 && LA95_0<=66)||(LA95_0>=73 && LA95_0<=75)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalVilBuildLanguage.g:5478:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // InternalVilBuildLanguage.g:5478:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // InternalVilBuildLanguage.g:5479:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // InternalVilBuildLanguage.g:5479:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // InternalVilBuildLanguage.g:5480:6: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_64);
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

                    // InternalVilBuildLanguage.g:5497:4: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==25) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalVilBuildLanguage.g:5498:5: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalVilBuildLanguage.g:5502:5: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // InternalVilBuildLanguage.g:5503:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // InternalVilBuildLanguage.g:5503:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // InternalVilBuildLanguage.g:5504:7: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_64);
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
                    	    break loop94;
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
    // InternalVilBuildLanguage.g:5531:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // InternalVilBuildLanguage.g:5531:71: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // InternalVilBuildLanguage.g:5532:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
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
    // InternalVilBuildLanguage.g:5538:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;



        	enterRule();

        try {
            // InternalVilBuildLanguage.g:5544:2: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // InternalVilBuildLanguage.g:5545:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // InternalVilBuildLanguage.g:5545:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=RULE_STRING && LA96_0<=RULE_EXPONENT)||LA96_0==16||(LA96_0>=28 && LA96_0<=29)||LA96_0==34||LA96_0==37||LA96_0==44||LA96_0==61||(LA96_0>=63 && LA96_0<=66)||(LA96_0>=73 && LA96_0<=75)) ) {
                alt96=1;
            }
            else if ( (LA96_0==18) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalVilBuildLanguage.g:5546:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // InternalVilBuildLanguage.g:5546:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // InternalVilBuildLanguage.g:5547:4: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // InternalVilBuildLanguage.g:5547:4: (lv_logical_0_0= ruleLogicalExpression )
                    // InternalVilBuildLanguage.g:5548:5: lv_logical_0_0= ruleLogicalExpression
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
                    // InternalVilBuildLanguage.g:5566:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // InternalVilBuildLanguage.g:5566:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // InternalVilBuildLanguage.g:5567:4: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // InternalVilBuildLanguage.g:5567:4: (lv_container_1_0= ruleContainerInitializer )
                    // InternalVilBuildLanguage.g:5568:5: lv_container_1_0= ruleContainerInitializer
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


        // InternalVilBuildLanguage.g:328:4: ( (lv_version_8_0= ruleVersionStmt ) )
        // InternalVilBuildLanguage.g:328:4: (lv_version_8_0= ruleVersionStmt )
        {
        // InternalVilBuildLanguage.g:328:4: (lv_version_8_0= ruleVersionStmt )
        // InternalVilBuildLanguage.g:329:5: lv_version_8_0= ruleVersionStmt
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


        // InternalVilBuildLanguage.g:515:4: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) )
        // InternalVilBuildLanguage.g:515:4: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        {
        // InternalVilBuildLanguage.g:515:4: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        // InternalVilBuildLanguage.g:516:5: (lv_elements_1_0= ruleVariableDeclaration )
        {
        // InternalVilBuildLanguage.g:516:5: (lv_elements_1_0= ruleVariableDeclaration )
        // InternalVilBuildLanguage.g:517:6: lv_elements_1_0= ruleVariableDeclaration
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


        // InternalVilBuildLanguage.g:575:4: ( ( (lv_elements_4_0= ruleRuleDeclaration ) ) )
        // InternalVilBuildLanguage.g:575:4: ( (lv_elements_4_0= ruleRuleDeclaration ) )
        {
        // InternalVilBuildLanguage.g:575:4: ( (lv_elements_4_0= ruleRuleDeclaration ) )
        // InternalVilBuildLanguage.g:576:5: (lv_elements_4_0= ruleRuleDeclaration )
        {
        // InternalVilBuildLanguage.g:576:5: (lv_elements_4_0= ruleRuleDeclaration )
        // InternalVilBuildLanguage.g:577:6: lv_elements_4_0= ruleRuleDeclaration
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

    // $ANTLR start synpred14_InternalVilBuildLanguage
    public final void synpred14_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_annotations_1_0 = null;


        // InternalVilBuildLanguage.g:626:5: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )
        // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
        {
        // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
        // InternalVilBuildLanguage.g:627:6: lv_annotations_1_0= ruleAnnotationDeclarations
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_1_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_annotations_1_0=ruleAnnotationDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalVilBuildLanguage

    // $ANTLR start synpred18_InternalVilBuildLanguage
    public final void synpred18_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_modifier_2_0 = null;

        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_paramList_6_0 = null;


        // InternalVilBuildLanguage.g:625:4: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )
        // InternalVilBuildLanguage.g:625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '='
        {
        // InternalVilBuildLanguage.g:625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?
        int alt97=2;
        alt97 = dfa97.predict(input);
        switch (alt97) {
            case 1 :
                // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                {
                // InternalVilBuildLanguage.g:626:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                // InternalVilBuildLanguage.g:627:6: lv_annotations_1_0= ruleAnnotationDeclarations
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_1_0_0());
                  					
                }
                pushFollow(FOLLOW_21);
                lv_annotations_1_0=ruleAnnotationDeclarations();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalVilBuildLanguage.g:644:4: ( (lv_modifier_2_0= ruleRuleModifier ) )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==26) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // InternalVilBuildLanguage.g:645:5: (lv_modifier_2_0= ruleRuleModifier )
                {
                // InternalVilBuildLanguage.g:645:5: (lv_modifier_2_0= ruleRuleModifier )
                // InternalVilBuildLanguage.g:646:6: lv_modifier_2_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0());
                  					
                }
                pushFollow(FOLLOW_22);
                lv_modifier_2_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalVilBuildLanguage.g:663:4: ( (lv_type_3_0= ruleType ) )?
        int alt99=2;
        switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA99_1 = input.LA(2);

                if ( (LA99_1==RULE_VERSION||(LA99_1>=RULE_ID && LA99_1<=RULE_EXPONENT)||LA99_1==44||LA99_1==72) ) {
                    alt99=1;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA99_2 = input.LA(2);

                if ( (LA99_2==RULE_VERSION||(LA99_2>=RULE_ID && LA99_2<=RULE_EXPONENT)||LA99_2==44||LA99_2==72) ) {
                    alt99=1;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA99_3 = input.LA(2);

                if ( (LA99_3==RULE_VERSION||(LA99_3>=RULE_ID && LA99_3<=RULE_EXPONENT)||LA99_3==44||LA99_3==72) ) {
                    alt99=1;
                }
                }
                break;
            case 44:
                {
                int LA99_4 = input.LA(2);

                if ( (LA99_4==RULE_VERSION||(LA99_4>=RULE_ID && LA99_4<=RULE_EXPONENT)||LA99_4==44||LA99_4==72) ) {
                    alt99=1;
                }
                }
                break;
            case 76:
            case 77:
            case 78:
            case 79:
                {
                alt99=1;
                }
                break;
        }

        switch (alt99) {
            case 1 :
                // InternalVilBuildLanguage.g:664:5: (lv_type_3_0= ruleType )
                {
                // InternalVilBuildLanguage.g:664:5: (lv_type_3_0= ruleType )
                // InternalVilBuildLanguage.g:665:6: lv_type_3_0= ruleType
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_2_0());
                  					
                }
                pushFollow(FOLLOW_10);
                lv_type_3_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalVilBuildLanguage.g:682:4: ( (lv_name_4_0= ruleIdentifier ) )
        // InternalVilBuildLanguage.g:683:5: (lv_name_4_0= ruleIdentifier )
        {
        // InternalVilBuildLanguage.g:683:5: (lv_name_4_0= ruleIdentifier )
        // InternalVilBuildLanguage.g:684:6: lv_name_4_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_3_0());
          					
        }
        pushFollow(FOLLOW_11);
        lv_name_4_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,16,FOLLOW_12); if (state.failed) return ;
        // InternalVilBuildLanguage.g:705:4: ( (lv_paramList_6_0= ruleParameterList ) )?
        int alt100=2;
        int LA100_0 = input.LA(1);

        if ( (LA100_0==RULE_VERSION||(LA100_0>=RULE_ID && LA100_0<=RULE_EXPONENT)||LA100_0==44||(LA100_0>=76 && LA100_0<=79)) ) {
            alt100=1;
        }
        switch (alt100) {
            case 1 :
                // InternalVilBuildLanguage.g:706:5: (lv_paramList_6_0= ruleParameterList )
                {
                // InternalVilBuildLanguage.g:706:5: (lv_paramList_6_0= ruleParameterList )
                // InternalVilBuildLanguage.g:707:6: lv_paramList_6_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_5_0());
                  					
                }
                pushFollow(FOLLOW_13);
                lv_paramList_6_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_7=(Token)match(input,17,FOLLOW_23); if (state.failed) return ;
        otherlv_8=(Token)match(input,23,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalVilBuildLanguage

    // $ANTLR start synpred33_InternalVilBuildLanguage
    public final void synpred33_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // InternalVilBuildLanguage.g:1192:5: (otherlv_7= ';' )
        // InternalVilBuildLanguage.g:1192:5: otherlv_7= ';'
        {
        otherlv_7=(Token)match(input,14,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalVilBuildLanguage

    // $ANTLR start synpred50_InternalVilBuildLanguage
    public final void synpred50_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // InternalVilBuildLanguage.g:1961:4: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // InternalVilBuildLanguage.g:1961:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // InternalVilBuildLanguage.g:1961:4: ( ( 'else' )=>otherlv_5= 'else' )
        // InternalVilBuildLanguage.g:1962:5: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,33,FOLLOW_36); if (state.failed) return ;

        }

        // InternalVilBuildLanguage.g:1968:4: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // InternalVilBuildLanguage.g:1969:5: (lv_else_6_0= ruleStatementOrBlock )
        {
        // InternalVilBuildLanguage.g:1969:5: (lv_else_6_0= ruleStatementOrBlock )
        // InternalVilBuildLanguage.g:1970:6: lv_else_6_0= ruleStatementOrBlock
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
    // $ANTLR end synpred50_InternalVilBuildLanguage

    // $ANTLR start synpred51_InternalVilBuildLanguage
    public final void synpred51_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // InternalVilBuildLanguage.g:2007:3: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // InternalVilBuildLanguage.g:2007:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // InternalVilBuildLanguage.g:2007:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // InternalVilBuildLanguage.g:2008:4: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // InternalVilBuildLanguage.g:2008:4: (lv_exStmt_0_0= ruleExpressionStatement )
        // InternalVilBuildLanguage.g:2009:5: lv_exStmt_0_0= ruleExpressionStatement
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
    // $ANTLR end synpred51_InternalVilBuildLanguage

    // $ANTLR start synpred68_InternalVilBuildLanguage
    public final void synpred68_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3061:4: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // InternalVilBuildLanguage.g:3061:4: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // InternalVilBuildLanguage.g:3061:4: (lv_right_1_0= ruleLogicalExpressionPart )
        // InternalVilBuildLanguage.g:3062:5: lv_right_1_0= ruleLogicalExpressionPart
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
    // $ANTLR end synpred68_InternalVilBuildLanguage

    // $ANTLR start synpred73_InternalVilBuildLanguage
    public final void synpred73_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3223:4: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // InternalVilBuildLanguage.g:3223:4: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // InternalVilBuildLanguage.g:3223:4: (lv_right_1_0= ruleEqualityExpressionPart )
        // InternalVilBuildLanguage.g:3224:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // $ANTLR end synpred73_InternalVilBuildLanguage

    // $ANTLR start synpred76_InternalVilBuildLanguage
    public final void synpred76_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right2_2_0 = null;


        // InternalVilBuildLanguage.g:3393:5: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )
        // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
        {
        // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
        // InternalVilBuildLanguage.g:3394:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred76_InternalVilBuildLanguage

    // $ANTLR start synpred77_InternalVilBuildLanguage
    public final void synpred77_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


        // InternalVilBuildLanguage.g:3373:4: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )
        // InternalVilBuildLanguage.g:3373:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        {
        // InternalVilBuildLanguage.g:3373:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // InternalVilBuildLanguage.g:3374:5: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // InternalVilBuildLanguage.g:3374:5: (lv_right_1_0= ruleRelationalExpressionPart )
        // InternalVilBuildLanguage.g:3375:6: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0());
          					
        }
        pushFollow(FOLLOW_51);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalVilBuildLanguage.g:3392:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        int alt106=2;
        int LA106_0 = input.LA(1);

        if ( ((LA106_0>=56 && LA106_0<=59)) ) {
            alt106=1;
        }
        switch (alt106) {
            case 1 :
                // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                {
                // InternalVilBuildLanguage.g:3393:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                // InternalVilBuildLanguage.g:3394:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred77_InternalVilBuildLanguage

    // $ANTLR start synpred81_InternalVilBuildLanguage
    public final void synpred81_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3550:4: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // InternalVilBuildLanguage.g:3550:4: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // InternalVilBuildLanguage.g:3550:4: (lv_right_1_0= ruleAdditiveExpressionPart )
        // InternalVilBuildLanguage.g:3551:5: lv_right_1_0= ruleAdditiveExpressionPart
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
    // $ANTLR end synpred81_InternalVilBuildLanguage

    // $ANTLR start synpred83_InternalVilBuildLanguage
    public final void synpred83_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalVilBuildLanguage.g:3694:4: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // InternalVilBuildLanguage.g:3694:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // InternalVilBuildLanguage.g:3694:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // InternalVilBuildLanguage.g:3695:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // $ANTLR end synpred83_InternalVilBuildLanguage

    // $ANTLR start synpred101_InternalVilBuildLanguage
    public final void synpred101_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalVilBuildLanguage.g:4633:4: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalVilBuildLanguage.g:4633:4: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalVilBuildLanguage.g:4633:4: (lv_decl_2_0= ruleDeclarator )
        // InternalVilBuildLanguage.g:4634:5: lv_decl_2_0= ruleDeclarator
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
    // $ANTLR end synpred101_InternalVilBuildLanguage

    // $ANTLR start synpred109_InternalVilBuildLanguage
    public final void synpred109_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalVilBuildLanguage.g:5004:3: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalVilBuildLanguage.g:5004:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalVilBuildLanguage.g:5004:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalVilBuildLanguage.g:5005:4: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalVilBuildLanguage.g:5005:4: (lv_qValue_2_0= ruleQualifiedName )
        // InternalVilBuildLanguage.g:5006:5: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred109_InternalVilBuildLanguage

    // $ANTLR start synpred113_InternalVilBuildLanguage
    public final void synpred113_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        // InternalVilBuildLanguage.g:5068:4: ( ( RULE_VERSION ) )
        // InternalVilBuildLanguage.g:5068:5: ( RULE_VERSION )
        {
        // InternalVilBuildLanguage.g:5068:5: ( RULE_VERSION )
        // InternalVilBuildLanguage.g:5069:5: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred113_InternalVilBuildLanguage

    // Delegated rules

    public final boolean synpred109_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred14_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred113_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred51_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred83_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA97 dfa97 = new DFA97(this);
    static final String dfa_1s = "\42\uffff";
    static final String dfa_2s = "\1\1\41\uffff";
    static final String dfa_3s = "\1\4\3\uffff\10\0\26\uffff";
    static final String dfa_4s = "\1\117\3\uffff\10\0\26\uffff";
    static final String dfa_5s = "\1\uffff\1\5\1\uffff\1\1\10\uffff\1\2\1\uffff\1\3\1\4\22\uffff";
    static final String dfa_6s = "\4\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\17\1\5\1\17\1\4\1\6\7\uffff\1\17\1\uffff\1\17\1\1\4\uffff\1\17\1\uffff\1\17\1\uffff\2\17\4\uffff\1\17\2\uffff\1\17\1\3\2\14\1\uffff\1\16\1\uffff\1\7\20\uffff\1\17\1\uffff\4\17\4\uffff\1\17\1\uffff\3\17\1\10\1\11\1\12\1\13",
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
            return "()* loopback of 514:3: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleCompound ) ) | ( (lv_elements_3_0= ruleTypeDef ) ) | ( (lv_elements_4_0= ruleRuleDeclaration ) ) )*";
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
    static final String dfa_8s = "\34\uffff";
    static final String dfa_9s = "\1\4\2\uffff\4\0\25\uffff";
    static final String dfa_10s = "\1\117\2\uffff\4\0\25\uffff";
    static final String dfa_11s = "\1\uffff\1\1\11\uffff\1\2\20\uffff";
    static final String dfa_12s = "\3\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_13s = {
            "\1\13\1\4\1\13\1\3\1\5\7\uffff\1\13\1\uffff\1\13\5\uffff\1\13\1\uffff\1\1\1\uffff\2\13\4\uffff\1\13\2\uffff\1\13\6\uffff\1\6\20\uffff\1\13\1\uffff\4\13\4\uffff\1\1\1\uffff\3\13\4\1",
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
            return "624:3: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )?";
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
                        if ( (synpred18_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_6 = input.LA(1);

                         
                        int index15_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index15_6);
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
    static final String dfa_14s = "\14\uffff";
    static final String dfa_15s = "\1\5\1\uffff\11\0\1\uffff";
    static final String dfa_16s = "\1\117\1\uffff\11\0\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\11\uffff\1\2";
    static final String dfa_18s = "\2\uffff\1\4\1\0\1\1\1\2\1\3\1\5\1\7\1\10\1\6\1\uffff}>";
    static final String[] dfa_19s = {
            "\1\4\1\uffff\1\3\1\5\21\uffff\1\2\21\uffff\1\6\32\uffff\1\1\4\uffff\1\7\1\10\1\11\1\12",
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
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA11_9 = input.LA(1);

                         
                        int index11_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index11_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_20s = "\16\uffff";
    static final String dfa_21s = "\1\4\1\uffff\4\5\3\uffff\5\5";
    static final String dfa_22s = "\1\117\1\uffff\4\110\3\uffff\1\54\4\110";
    static final String dfa_23s = "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\5\uffff";
    static final String dfa_24s = "\16\uffff}>";
    static final String[] dfa_25s = {
            "\1\6\1\3\1\6\1\2\1\4\7\uffff\1\6\1\uffff\1\6\11\uffff\2\6\1\10\1\7\1\6\1\uffff\1\6\2\uffff\1\6\1\1\5\uffff\1\5\20\uffff\1\6\1\uffff\4\6\6\uffff\3\6\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "",
            "",
            "",
            "\1\13\1\uffff\1\12\1\14\43\uffff\1\15",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\20\uffff\1\1\2\uffff\20\6\4\uffff\2\6\3\uffff\1\11"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "949:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )";
        }
    }
    static final String dfa_26s = "\1\4\4\16\1\uffff\1\5\1\uffff\4\16";
    static final String dfa_27s = "\1\113\4\110\1\uffff\1\54\1\uffff\4\110";
    static final String dfa_28s = "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String dfa_29s = "\14\uffff}>";
    static final String[] dfa_30s = {
            "\1\5\1\2\1\5\1\1\1\3\7\uffff\1\5\1\uffff\1\5\11\uffff\2\5\4\uffff\1\5\2\uffff\1\5\6\uffff\1\4\20\uffff\1\5\1\uffff\4\5\6\uffff\3\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "",
            "\1\11\1\uffff\1\10\1\12\43\uffff\1\13",
            "",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\23\uffff\20\5\4\uffff\2\5\3\uffff\1\5"
    };
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "1096:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String dfa_31s = "\22\uffff";
    static final String dfa_32s = "\2\uffff\4\1\10\uffff\4\1";
    static final String dfa_33s = "\1\4\1\uffff\4\16\6\uffff\1\5\1\uffff\4\16";
    static final String dfa_34s = "\1\113\1\uffff\4\110\6\uffff\1\54\1\uffff\4\110";
    static final String dfa_35s = "\1\uffff\1\1\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\4\uffff";
    static final String dfa_36s = "\22\uffff}>";
    static final String[] dfa_37s = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\13\uffff\1\12\1\10\4\uffff\1\11\2\uffff\1\7\6\uffff\1\5\24\uffff\1\6\1\13\6\uffff\3\1",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16\1\20\43\uffff\1\21",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\17\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\uffff\1\14"
    };

    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_31;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "1216:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String dfa_38s = "\27\uffff";
    static final String dfa_39s = "\1\4\23\uffff\1\0\2\uffff";
    static final String dfa_40s = "\1\113\23\uffff\1\0\2\uffff";
    static final String dfa_41s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_42s = "\24\uffff\1\0\2\uffff}>";
    static final String[] dfa_43s = {
            "\5\1\7\uffff\1\1\1\uffff\1\24\11\uffff\2\1\2\uffff\1\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\20\uffff\1\1\1\uffff\4\1\6\uffff\3\1",
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

    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[][] dfa_43 = unpackEncodedStringArray(dfa_43s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_38;
            this.eof = dfa_38;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_42;
            this.transition = dfa_43;
        }
        public String getDescription() {
            return "2006:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_20 = input.LA(1);

                         
                        int index39_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred51_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index39_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_44s = "\32\uffff";
    static final String dfa_45s = "\1\4\4\0\25\uffff";
    static final String dfa_46s = "\1\117\4\0\25\uffff";
    static final String dfa_47s = "\5\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String dfa_48s = "\1\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_49s = {
            "\1\11\1\2\1\11\1\1\1\3\7\uffff\3\11\11\uffff\2\11\4\uffff\1\11\2\uffff\1\11\6\uffff\1\4\20\uffff\1\11\1\uffff\4\11\6\uffff\3\11\4\5",
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

    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_44;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "4632:3: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA82_2 = input.LA(1);

                         
                        int index82_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index82_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA82_3 = input.LA(1);

                         
                        int index82_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index82_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA82_4 = input.LA(1);

                         
                        int index82_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index82_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_50s = "\2\uffff\1\5\1\0\1\1\1\2\1\3\1\4\1\7\1\10\1\6\1\uffff}>";
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_50;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "625:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_3 = input.LA(1);

                         
                        int index97_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA97_4 = input.LA(1);

                         
                        int index97_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA97_5 = input.LA(1);

                         
                        int index97_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA97_6 = input.LA(1);

                         
                        int index97_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA97_7 = input.LA(1);

                         
                        int index97_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA97_2 = input.LA(1);

                         
                        int index97_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_2);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA97_10 = input.LA(1);

                         
                        int index97_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA97_8 = input.LA(1);

                         
                        int index97_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA97_9 = input.LA(1);

                         
                        int index97_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index97_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 97, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000068000000A002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000008000000A002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000080000008002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00001000000001A0L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00001000000201A0L,0x000000000000F000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0xA00015E4352D01F0L,0x000000000000FE87L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xA00015E4350501F2L,0x000000000000FE87L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00001000040001A0L,0x000000000000F000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00001000000001A0L,0x000000000000F000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xA00015E4350501F0L,0x000000000000FE87L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0xA0001024300101F2L,0x0000000000000E07L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0xA0001024300101F0L,0x0000000000000E07L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xA0001065F00D01F0L,0x000000000000FE07L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0xA0001024300501F0L,0x0000000000000E07L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00001000000001B0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0xA0001024300701F0L,0x0000000000000E07L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xA00015E5350501F0L,0x000000000000FE87L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00001010000001A0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000008000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000040000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00001040000801A0L,0x000000000000F000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800800004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x001F000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0F00000000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x4000800000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0xA0001024300701F0L,0x000000000000FE07L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x00001000000101A0L,0x000000000000F000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0xA0001024300D01F0L,0x0000000000000E07L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000002080000L});

}