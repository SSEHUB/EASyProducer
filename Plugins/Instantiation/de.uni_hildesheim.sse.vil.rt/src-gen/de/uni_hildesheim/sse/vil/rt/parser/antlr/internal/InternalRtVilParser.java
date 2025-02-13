package de.uni_hildesheim.sse.vil.rt.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.vil.rt.services.RtVilGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalRtVilParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'rtVilScript'", "'('", "')'", "'{'", "'}'", "';'", "'persistent'", "'strategy'", "'='", "'objective'", "'breakdown'", "'weighting'", "':'", "'tactic'", "'with'", "','", "'@'", "'intent'", "'fail'", "'refail'", "'requireVTL'", "'extends'", "'protected'", "'.'", "'instantiate'", "'map'", "'for'", "'while'", "'if'", "'else'", "'join'", "'exclude'", "'execute'", "'const'", "'abstract'", "'compound'", "'refines'", "'typedef'", "'@advice'", "'version'", "'import'", "'insert'", "'*'", "'and'", "'or'", "'xor'", "'implies'", "'iff'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'switch'", "'static'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_NUMBER=6;
    public static final int RULE_EXPONENT=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalRtVilParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRtVilParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRtVilParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRtVil.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private RtVilGrammarAccess grammarAccess;

        public InternalRtVilParser(TokenStream input, RtVilGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ImplementationUnit";
       	}

       	@Override
       	protected RtVilGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleImplementationUnit"
    // InternalRtVil.g:70:1: entryRuleImplementationUnit returns [EObject current=null] : iv_ruleImplementationUnit= ruleImplementationUnit EOF ;
    public final EObject entryRuleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementationUnit = null;


        try {
            // InternalRtVil.g:70:59: (iv_ruleImplementationUnit= ruleImplementationUnit EOF )
            // InternalRtVil.g:71:2: iv_ruleImplementationUnit= ruleImplementationUnit EOF
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
    // InternalRtVil.g:77:1: ruleImplementationUnit returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) ;
    public final EObject ruleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_requires_2_0 = null;

        EObject lv_scripts_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:83:2: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) )
            // InternalRtVil.g:84:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            {
            // InternalRtVil.g:84:2: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            // InternalRtVil.g:85:3: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            {
            // InternalRtVil.g:85:3: ()
            // InternalRtVil.g:86:4: 
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

            // InternalRtVil.g:95:3: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=53 && LA1_0<=54)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRtVil.g:96:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalRtVil.g:96:4: (lv_imports_1_0= ruleImport )
            	    // InternalRtVil.g:97:5: lv_imports_1_0= ruleImport
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

            // InternalRtVil.g:114:3: ( (lv_requires_2_0= ruleRequire ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==33) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRtVil.g:115:4: (lv_requires_2_0= ruleRequire )
            	    {
            	    // InternalRtVil.g:115:4: (lv_requires_2_0= ruleRequire )
            	    // InternalRtVil.g:116:5: lv_requires_2_0= ruleRequire
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

            // InternalRtVil.g:133:3: ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13||LA3_0==51) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRtVil.g:134:4: (lv_scripts_3_0= ruleLanguageUnit )
            	    {
            	    // InternalRtVil.g:134:4: (lv_scripts_3_0= ruleLanguageUnit )
            	    // InternalRtVil.g:135:5: lv_scripts_3_0= ruleLanguageUnit
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
            	      						"de.uni_hildesheim.sse.vil.rt.RtVil.LanguageUnit");
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


    // $ANTLR start "entryRuleLanguageUnit"
    // InternalRtVil.g:156:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // InternalRtVil.g:156:53: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // InternalRtVil.g:157:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
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
    // InternalRtVil.g:163:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_advices_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_parent_6_0 = null;

        EObject lv_version_8_0 = null;

        EObject lv_rtContents_9_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:169:2: ( ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? ) )
            // InternalRtVil.g:170:2: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? )
            {
            // InternalRtVil.g:170:2: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? )
            // InternalRtVil.g:171:3: ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )?
            {
            // InternalRtVil.g:171:3: ( (lv_advices_0_0= ruleAdvice ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==51) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRtVil.g:172:4: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // InternalRtVil.g:172:4: (lv_advices_0_0= ruleAdvice )
            	    // InternalRtVil.g:173:5: lv_advices_0_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_6);
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

            otherlv_1=(Token)match(input,13,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLanguageUnitAccess().getRtVilScriptKeyword_1());
              		
            }
            // InternalRtVil.g:194:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:195:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:195:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:196:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_3=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLanguageUnitAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:217:3: ( (lv_param_4_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||(LA5_0>=34 && LA5_0<=35)||LA5_0==39||(LA5_0>=41 && LA5_0<=42)||LA5_0==52||(LA5_0>=83 && LA5_0<=88)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRtVil.g:218:4: (lv_param_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:218:4: (lv_param_4_0= ruleParameterList )
                    // InternalRtVil.g:219:5: lv_param_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getParamParameterListParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
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

            otherlv_5=(Token)match(input,15,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLanguageUnitAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalRtVil.g:240:3: ( (lv_parent_6_0= ruleScriptParentDecl ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==34) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRtVil.g:241:4: (lv_parent_6_0= ruleScriptParentDecl )
                    {
                    // InternalRtVil.g:241:4: (lv_parent_6_0= ruleScriptParentDecl )
                    // InternalRtVil.g:242:5: lv_parent_6_0= ruleScriptParentDecl
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getParentScriptParentDeclParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_7=(Token)match(input,16,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getLanguageUnitAccess().getLeftCurlyBracketKeyword_7());
              		
            }
            // InternalRtVil.g:263:3: ( (lv_version_8_0= ruleVersionStmt ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==52) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_VERSION) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==18) ) {
                        int LA7_4 = input.LA(4);

                        if ( (synpred7_InternalRtVil()) ) {
                            alt7=1;
                        }
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // InternalRtVil.g:264:4: (lv_version_8_0= ruleVersionStmt )
                    {
                    // InternalRtVil.g:264:4: (lv_version_8_0= ruleVersionStmt )
                    // InternalRtVil.g:265:5: lv_version_8_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_8_0());
                      				
                    }
                    pushFollow(FOLLOW_13);
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

            // InternalRtVil.g:282:3: ( (lv_rtContents_9_0= rulertContents ) )
            // InternalRtVil.g:283:4: (lv_rtContents_9_0= rulertContents )
            {
            // InternalRtVil.g:283:4: (lv_rtContents_9_0= rulertContents )
            // InternalRtVil.g:284:5: lv_rtContents_9_0= rulertContents
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLanguageUnitAccess().getRtContentsRtContentsParserRuleCall_9_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_rtContents_9_0=rulertContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              					}
              					set(
              						current,
              						"rtContents",
              						lv_rtContents_9_0,
              						"de.uni_hildesheim.sse.vil.rt.RtVil.rtContents");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_10=(Token)match(input,17,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_10());
              		
            }
            // InternalRtVil.g:305:3: (otherlv_11= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRtVil.g:306:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getLanguageUnitAccess().getSemicolonKeyword_11());
                      			
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


    // $ANTLR start "entryRulertContents"
    // InternalRtVil.g:315:1: entryRulertContents returns [EObject current=null] : iv_rulertContents= rulertContents EOF ;
    public final EObject entryRulertContents() throws RecognitionException {
        EObject current = null;

        EObject iv_rulertContents = null;


        try {
            // InternalRtVil.g:315:51: (iv_rulertContents= rulertContents EOF )
            // InternalRtVil.g:316:2: iv_rulertContents= rulertContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRtContentsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulertContents=rulertContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulertContents; 
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
    // $ANTLR end "entryRulertContents"


    // $ANTLR start "rulertContents"
    // InternalRtVil.g:322:1: rulertContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* ) ;
    public final EObject rulertContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;

        EObject lv_elements_4_0 = null;

        EObject lv_elements_5_0 = null;

        EObject lv_elements_6_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:328:2: ( ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* ) )
            // InternalRtVil.g:329:2: ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* )
            {
            // InternalRtVil.g:329:2: ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* )
            // InternalRtVil.g:330:3: () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*
            {
            // InternalRtVil.g:330:3: ()
            // InternalRtVil.g:331:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRtContentsAccess().getRtContentsAction_0(),
              					current);
              			
            }

            }

            // InternalRtVil.g:340:3: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*
            loop9:
            do {
                int alt9=7;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalRtVil.g:341:4: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
            	    {
            	    // InternalRtVil.g:341:4: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
            	    // InternalRtVil.g:342:5: (lv_elements_1_0= ruleGlobalVariableDeclaration )
            	    {
            	    // InternalRtVil.g:342:5: (lv_elements_1_0= ruleGlobalVariableDeclaration )
            	    // InternalRtVil.g:343:6: lv_elements_1_0= ruleGlobalVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsGlobalVariableDeclarationParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_1_0=ruleGlobalVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_1_0,
            	      							"de.uni_hildesheim.sse.vil.rt.RtVil.GlobalVariableDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRtVil.g:361:4: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    {
            	    // InternalRtVil.g:361:4: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    // InternalRtVil.g:362:5: (lv_elements_2_0= ruleRuleDeclaration )
            	    {
            	    // InternalRtVil.g:362:5: (lv_elements_2_0= ruleRuleDeclaration )
            	    // InternalRtVil.g:363:6: lv_elements_2_0= ruleRuleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsRuleDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_2_0=ruleRuleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_2_0,
            	      							"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRtVil.g:381:4: ( (lv_elements_3_0= ruleStrategyDeclaration ) )
            	    {
            	    // InternalRtVil.g:381:4: ( (lv_elements_3_0= ruleStrategyDeclaration ) )
            	    // InternalRtVil.g:382:5: (lv_elements_3_0= ruleStrategyDeclaration )
            	    {
            	    // InternalRtVil.g:382:5: (lv_elements_3_0= ruleStrategyDeclaration )
            	    // InternalRtVil.g:383:6: lv_elements_3_0= ruleStrategyDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsStrategyDeclarationParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_3_0=ruleStrategyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_3_0,
            	      							"de.uni_hildesheim.sse.vil.rt.RtVil.StrategyDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRtVil.g:401:4: ( (lv_elements_4_0= ruleTacticDeclaration ) )
            	    {
            	    // InternalRtVil.g:401:4: ( (lv_elements_4_0= ruleTacticDeclaration ) )
            	    // InternalRtVil.g:402:5: (lv_elements_4_0= ruleTacticDeclaration )
            	    {
            	    // InternalRtVil.g:402:5: (lv_elements_4_0= ruleTacticDeclaration )
            	    // InternalRtVil.g:403:6: lv_elements_4_0= ruleTacticDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsTacticDeclarationParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_4_0=ruleTacticDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_4_0,
            	      							"de.uni_hildesheim.sse.vil.rt.RtVil.TacticDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRtVil.g:421:4: ( (lv_elements_5_0= ruleTypeDef ) )
            	    {
            	    // InternalRtVil.g:421:4: ( (lv_elements_5_0= ruleTypeDef ) )
            	    // InternalRtVil.g:422:5: (lv_elements_5_0= ruleTypeDef )
            	    {
            	    // InternalRtVil.g:422:5: (lv_elements_5_0= ruleTypeDef )
            	    // InternalRtVil.g:423:6: lv_elements_5_0= ruleTypeDef
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsTypeDefParserRuleCall_1_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_5_0=ruleTypeDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_5_0,
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeDef");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRtVil.g:441:4: ( (lv_elements_6_0= ruleCompound ) )
            	    {
            	    // InternalRtVil.g:441:4: ( (lv_elements_6_0= ruleCompound ) )
            	    // InternalRtVil.g:442:5: (lv_elements_6_0= ruleCompound )
            	    {
            	    // InternalRtVil.g:442:5: (lv_elements_6_0= ruleCompound )
            	    // InternalRtVil.g:443:6: lv_elements_6_0= ruleCompound
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsCompoundParserRuleCall_1_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_elements_6_0=ruleCompound();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRtContentsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_6_0,
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Compound");
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
    // $ANTLR end "rulertContents"


    // $ANTLR start "entryRuleGlobalVariableDeclaration"
    // InternalRtVil.g:465:1: entryRuleGlobalVariableDeclaration returns [EObject current=null] : iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF ;
    public final EObject entryRuleGlobalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariableDeclaration = null;


        try {
            // InternalRtVil.g:465:66: (iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF )
            // InternalRtVil.g:466:2: iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVariableDeclaration=ruleGlobalVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalVariableDeclaration; 
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
    // $ANTLR end "entryRuleGlobalVariableDeclaration"


    // $ANTLR start "ruleGlobalVariableDeclaration"
    // InternalRtVil.g:472:1: ruleGlobalVariableDeclaration returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) ) ;
    public final EObject ruleGlobalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_persistent_0_0=null;
        EObject lv_varDecl_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:478:2: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) ) )
            // InternalRtVil.g:479:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) )
            {
            // InternalRtVil.g:479:2: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) )
            // InternalRtVil.g:480:3: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) )
            {
            // InternalRtVil.g:480:3: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRtVil.g:481:4: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalRtVil.g:481:4: (lv_persistent_0_0= 'persistent' )
                    // InternalRtVil.g:482:5: lv_persistent_0_0= 'persistent'
                    {
                    lv_persistent_0_0=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_persistent_0_0, grammarAccess.getGlobalVariableDeclarationAccess().getPersistentPersistentKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getGlobalVariableDeclarationRule());
                      					}
                      					setWithLastConsumed(current, "persistent", lv_persistent_0_0, "persistent");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:494:3: ( (lv_varDecl_1_0= ruleVariableDeclaration ) )
            // InternalRtVil.g:495:4: (lv_varDecl_1_0= ruleVariableDeclaration )
            {
            // InternalRtVil.g:495:4: (lv_varDecl_1_0= ruleVariableDeclaration )
            // InternalRtVil.g:496:5: lv_varDecl_1_0= ruleVariableDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGlobalVariableDeclarationAccess().getVarDeclVariableDeclarationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_varDecl_1_0=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGlobalVariableDeclarationRule());
              					}
              					set(
              						current,
              						"varDecl",
              						lv_varDecl_1_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
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
    // $ANTLR end "ruleGlobalVariableDeclaration"


    // $ANTLR start "entryRuleStrategyDeclaration"
    // InternalRtVil.g:517:1: entryRuleStrategyDeclaration returns [EObject current=null] : iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF ;
    public final EObject entryRuleStrategyDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategyDeclaration = null;


        try {
            // InternalRtVil.g:517:60: (iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF )
            // InternalRtVil.g:518:2: iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStrategyDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStrategyDeclaration=ruleStrategyDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStrategyDeclaration; 
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
    // $ANTLR end "entryRuleStrategyDeclaration"


    // $ANTLR start "ruleStrategyDeclaration"
    // InternalRtVil.g:524:1: ruleStrategyDeclaration returns [EObject current=null] : ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? ) ;
    public final EObject ruleStrategyDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_paramList_4_0 = null;

        EObject lv_conditions_7_0 = null;

        EObject lv_varDecls_9_0 = null;

        EObject lv_objective_11_0 = null;

        EObject lv_weighting_15_0 = null;

        EObject lv_breakdown_16_0 = null;

        EObject lv_post_18_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:530:2: ( ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? ) )
            // InternalRtVil.g:531:2: ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? )
            {
            // InternalRtVil.g:531:2: ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? )
            // InternalRtVil.g:532:3: () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )?
            {
            // InternalRtVil.g:532:3: ()
            // InternalRtVil.g:533:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStrategyDeclarationAccess().getStrategyDeclarationAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStrategyDeclarationAccess().getStrategyKeyword_1());
              		
            }
            // InternalRtVil.g:546:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:547:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:547:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:548:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
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

            otherlv_3=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStrategyDeclarationAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:569:3: ( (lv_paramList_4_0= ruleParameterList ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_VERSION||(LA11_0>=RULE_ID && LA11_0<=RULE_EXPONENT)||(LA11_0>=34 && LA11_0<=35)||LA11_0==39||(LA11_0>=41 && LA11_0<=42)||LA11_0==52||(LA11_0>=83 && LA11_0<=88)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRtVil.g:570:4: (lv_paramList_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:570:4: (lv_paramList_4_0= ruleParameterList )
                    // InternalRtVil.g:571:5: lv_paramList_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getParamListParameterListParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_paramList_4_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"paramList",
                      						lv_paramList_4_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStrategyDeclarationAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,21,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getStrategyDeclarationAccess().getEqualsSignKeyword_6());
              		
            }
            // InternalRtVil.g:596:3: ( (lv_conditions_7_0= ruleRuleConditions ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_EXPONENT)||LA12_0==14||LA12_0==25||(LA12_0>=34 && LA12_0<=35)||(LA12_0>=37 && LA12_0<=39)||(LA12_0>=41 && LA12_0<=43)||LA12_0==45||LA12_0==52||LA12_0==69||(LA12_0>=71 && LA12_0<=74)||(LA12_0>=80 && LA12_0<=84)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRtVil.g:597:4: (lv_conditions_7_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:597:4: (lv_conditions_7_0= ruleRuleConditions )
                    // InternalRtVil.g:598:5: lv_conditions_7_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getConditionsRuleConditionsParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_12);
                    lv_conditions_7_0=ruleRuleConditions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"conditions",
                      						lv_conditions_7_0,
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleConditions");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,16,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getStrategyDeclarationAccess().getLeftCurlyBracketKeyword_8());
              		
            }
            // InternalRtVil.g:619:3: ( (lv_varDecls_9_0= ruleVariableDeclaration ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_VERSION||(LA13_0>=RULE_ID && LA13_0<=RULE_EXPONENT)||(LA13_0>=34 && LA13_0<=35)||LA13_0==39||(LA13_0>=41 && LA13_0<=42)||LA13_0==46||LA13_0==52||(LA13_0>=83 && LA13_0<=88)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalRtVil.g:620:4: (lv_varDecls_9_0= ruleVariableDeclaration )
            	    {
            	    // InternalRtVil.g:620:4: (lv_varDecls_9_0= ruleVariableDeclaration )
            	    // InternalRtVil.g:621:5: lv_varDecls_9_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getVarDeclsVariableDeclarationParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_varDecls_9_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
            	      					}
            	      					add(
            	      						current,
            	      						"varDecls",
            	      						lv_varDecls_9_0,
            	      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalRtVil.g:638:3: (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRtVil.g:639:4: otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';'
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getStrategyDeclarationAccess().getObjectiveKeyword_10_0());
                      			
                    }
                    // InternalRtVil.g:643:4: ( (lv_objective_11_0= ruleExpression ) )
                    // InternalRtVil.g:644:5: (lv_objective_11_0= ruleExpression )
                    {
                    // InternalRtVil.g:644:5: (lv_objective_11_0= ruleExpression )
                    // InternalRtVil.g:645:6: lv_objective_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getObjectiveExpressionParserRuleCall_10_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
                    lv_objective_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"objective",
                      							lv_objective_11_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,18,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getStrategyDeclarationAccess().getSemicolonKeyword_10_2());
                      			
                    }

                    }
                    break;

            }

            // InternalRtVil.g:667:3: (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' )
            // InternalRtVil.g:668:4: otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}'
            {
            otherlv_13=(Token)match(input,23,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_13, grammarAccess.getStrategyDeclarationAccess().getBreakdownKeyword_11_0());
              			
            }
            otherlv_14=(Token)match(input,16,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_14, grammarAccess.getStrategyDeclarationAccess().getLeftCurlyBracketKeyword_11_1());
              			
            }
            // InternalRtVil.g:676:4: ( (lv_weighting_15_0= ruleWeightingStatement ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRtVil.g:677:5: (lv_weighting_15_0= ruleWeightingStatement )
                    {
                    // InternalRtVil.g:677:5: (lv_weighting_15_0= ruleWeightingStatement )
                    // InternalRtVil.g:678:6: lv_weighting_15_0= ruleWeightingStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getWeightingWeightingStatementParserRuleCall_11_2_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_weighting_15_0=ruleWeightingStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"weighting",
                      							lv_weighting_15_0,
                      							"de.uni_hildesheim.sse.vil.rt.RtVil.WeightingStatement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:695:4: ( (lv_breakdown_16_0= ruleBreakdownElement ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_EXPONENT)||LA16_0==14||LA16_0==16||LA16_0==20||LA16_0==26||(LA16_0>=34 && LA16_0<=35)||(LA16_0>=37 && LA16_0<=39)||(LA16_0>=41 && LA16_0<=43)||(LA16_0>=45 && LA16_0<=46)||LA16_0==52||LA16_0==69||(LA16_0>=71 && LA16_0<=74)||(LA16_0>=80 && LA16_0<=88)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRtVil.g:696:5: (lv_breakdown_16_0= ruleBreakdownElement )
            	    {
            	    // InternalRtVil.g:696:5: (lv_breakdown_16_0= ruleBreakdownElement )
            	    // InternalRtVil.g:697:6: lv_breakdown_16_0= ruleBreakdownElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getBreakdownBreakdownElementParserRuleCall_11_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_breakdown_16_0=ruleBreakdownElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
            	      						}
            	      						add(
            	      							current,
            	      							"breakdown",
            	      							lv_breakdown_16_0,
            	      							"de.uni_hildesheim.sse.vil.rt.RtVil.BreakdownElement");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_17=(Token)match(input,17,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_17, grammarAccess.getStrategyDeclarationAccess().getRightCurlyBracketKeyword_11_4());
              			
            }

            }

            // InternalRtVil.g:719:3: ( (lv_post_18_0= ruleRuleElement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_EXPONENT)||LA17_0==14||LA17_0==16||(LA17_0>=31 && LA17_0<=32)||(LA17_0>=34 && LA17_0<=35)||(LA17_0>=37 && LA17_0<=43)||(LA17_0>=45 && LA17_0<=46)||LA17_0==52||LA17_0==69||(LA17_0>=71 && LA17_0<=74)||(LA17_0>=80 && LA17_0<=88)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRtVil.g:720:4: (lv_post_18_0= ruleRuleElement )
            	    {
            	    // InternalRtVil.g:720:4: (lv_post_18_0= ruleRuleElement )
            	    // InternalRtVil.g:721:5: lv_post_18_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStrategyDeclarationAccess().getPostRuleElementParserRuleCall_12_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_post_18_0=ruleRuleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStrategyDeclarationRule());
            	      					}
            	      					add(
            	      						current,
            	      						"post",
            	      						lv_post_18_0,
            	      						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_19=(Token)match(input,17,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_19, grammarAccess.getStrategyDeclarationAccess().getRightCurlyBracketKeyword_13());
              		
            }
            // InternalRtVil.g:742:3: (otherlv_20= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRtVil.g:743:4: otherlv_20= ';'
                    {
                    otherlv_20=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getStrategyDeclarationAccess().getSemicolonKeyword_14());
                      			
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
    // $ANTLR end "ruleStrategyDeclaration"


    // $ANTLR start "entryRuleBreakdownElement"
    // InternalRtVil.g:752:1: entryRuleBreakdownElement returns [EObject current=null] : iv_ruleBreakdownElement= ruleBreakdownElement EOF ;
    public final EObject entryRuleBreakdownElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownElement = null;


        try {
            // InternalRtVil.g:752:57: (iv_ruleBreakdownElement= ruleBreakdownElement EOF )
            // InternalRtVil.g:753:2: iv_ruleBreakdownElement= ruleBreakdownElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakdownElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakdownElement=ruleBreakdownElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakdownElement; 
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
    // $ANTLR end "entryRuleBreakdownElement"


    // $ANTLR start "ruleBreakdownElement"
    // InternalRtVil.g:759:1: ruleBreakdownElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) ) ;
    public final EObject ruleBreakdownElement() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;

        EObject lv_breakdownStmt_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:765:2: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) ) )
            // InternalRtVil.g:766:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )
            {
            // InternalRtVil.g:766:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalRtVil.g:767:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalRtVil.g:767:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalRtVil.g:768:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalRtVil.g:768:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalRtVil.g:769:5: lv_varDecl_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBreakdownElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_varDecl_0_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBreakdownElementRule());
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
                    // InternalRtVil.g:787:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:787:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:788:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:788:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalRtVil.g:789:5: lv_exprStmt_1_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBreakdownElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_exprStmt_1_0=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBreakdownElementRule());
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
                    // InternalRtVil.g:807:3: ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) )
                    {
                    // InternalRtVil.g:807:3: ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) )
                    // InternalRtVil.g:808:4: (lv_breakdownStmt_2_0= ruleBreakdownStatement )
                    {
                    // InternalRtVil.g:808:4: (lv_breakdownStmt_2_0= ruleBreakdownStatement )
                    // InternalRtVil.g:809:5: lv_breakdownStmt_2_0= ruleBreakdownStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBreakdownElementAccess().getBreakdownStmtBreakdownStatementParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_breakdownStmt_2_0=ruleBreakdownStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBreakdownElementRule());
                      					}
                      					set(
                      						current,
                      						"breakdownStmt",
                      						lv_breakdownStmt_2_0,
                      						"de.uni_hildesheim.sse.vil.rt.RtVil.BreakdownStatement");
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
    // $ANTLR end "ruleBreakdownElement"


    // $ANTLR start "entryRuleWeightingStatement"
    // InternalRtVil.g:830:1: entryRuleWeightingStatement returns [EObject current=null] : iv_ruleWeightingStatement= ruleWeightingStatement EOF ;
    public final EObject entryRuleWeightingStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWeightingStatement = null;


        try {
            // InternalRtVil.g:830:59: (iv_ruleWeightingStatement= ruleWeightingStatement EOF )
            // InternalRtVil.g:831:2: iv_ruleWeightingStatement= ruleWeightingStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWeightingStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWeightingStatement=ruleWeightingStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWeightingStatement; 
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
    // $ANTLR end "entryRuleWeightingStatement"


    // $ANTLR start "ruleWeightingStatement"
    // InternalRtVil.g:837:1: ruleWeightingStatement returns [EObject current=null] : (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleWeightingStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_expr_4_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:843:2: ( (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) )
            // InternalRtVil.g:844:2: (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalRtVil.g:844:2: (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            // InternalRtVil.g:845:3: otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWeightingStatementAccess().getWeightingKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWeightingStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:853:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:854:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:854:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:855:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWeightingStatementAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWeightingStatementRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getWeightingStatementAccess().getColonKeyword_3());
              		
            }
            // InternalRtVil.g:876:3: ( (lv_expr_4_0= ruleExpression ) )
            // InternalRtVil.g:877:4: (lv_expr_4_0= ruleExpression )
            {
            // InternalRtVil.g:877:4: (lv_expr_4_0= ruleExpression )
            // InternalRtVil.g:878:5: lv_expr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWeightingStatementAccess().getExprExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_expr_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWeightingStatementRule());
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

            otherlv_5=(Token)match(input,15,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getWeightingStatementAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getWeightingStatementAccess().getSemicolonKeyword_6());
              		
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
    // $ANTLR end "ruleWeightingStatement"


    // $ANTLR start "entryRuleBreakdownStatement"
    // InternalRtVil.g:907:1: entryRuleBreakdownStatement returns [EObject current=null] : iv_ruleBreakdownStatement= ruleBreakdownStatement EOF ;
    public final EObject entryRuleBreakdownStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownStatement = null;


        try {
            // InternalRtVil.g:907:59: (iv_ruleBreakdownStatement= ruleBreakdownStatement EOF )
            // InternalRtVil.g:908:2: iv_ruleBreakdownStatement= ruleBreakdownStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakdownStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakdownStatement=ruleBreakdownStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakdownStatement; 
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
    // $ANTLR end "entryRuleBreakdownStatement"


    // $ANTLR start "ruleBreakdownStatement"
    // InternalRtVil.g:914:1: ruleBreakdownStatement returns [EObject current=null] : ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' ) ;
    public final EObject ruleBreakdownStatement() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_guard_2_0 = null;

        EObject lv_name_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_part_10_0 = null;

        EObject lv_part_12_0 = null;

        EObject lv_time_15_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:920:2: ( ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' ) )
            // InternalRtVil.g:921:2: ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' )
            {
            // InternalRtVil.g:921:2: ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' )
            // InternalRtVil.g:922:3: ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';'
            {
            // InternalRtVil.g:922:3: ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) )
            // InternalRtVil.g:923:4: ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) )
            {
            // InternalRtVil.g:923:4: ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) )
            // InternalRtVil.g:924:5: (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' )
            {
            // InternalRtVil.g:924:5: (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            else if ( (LA20_0==26) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalRtVil.g:925:6: lv_type_0_1= 'strategy'
                    {
                    lv_type_0_1=(Token)match(input,20,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_0_1, grammarAccess.getBreakdownStatementAccess().getTypeStrategyKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBreakdownStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_0_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:936:6: lv_type_0_2= 'tactic'
                    {
                    lv_type_0_2=(Token)match(input,26,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_type_0_2, grammarAccess.getBreakdownStatementAccess().getTypeTacticKeyword_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBreakdownStatementRule());
                      						}
                      						setWithLastConsumed(current, "type", lv_type_0_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalRtVil.g:949:3: (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==14) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRtVil.g:950:4: otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBreakdownStatementAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalRtVil.g:954:4: ( (lv_guard_2_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:955:5: (lv_guard_2_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:955:5: (lv_guard_2_0= ruleLogicalExpression )
                    // InternalRtVil.g:956:6: lv_guard_2_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakdownStatementAccess().getGuardLogicalExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_guard_2_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
                      						}
                      						set(
                      							current,
                      							"guard",
                      							lv_guard_2_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.LogicalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,15,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getBreakdownStatementAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }
                    break;

            }

            // InternalRtVil.g:978:3: ( (lv_name_4_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:979:4: (lv_name_4_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:979:4: (lv_name_4_0= ruleQualifiedPrefix )
            // InternalRtVil.g:980:5: lv_name_4_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBreakdownStatementAccess().getNameQualifiedPrefixParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_name_4_0=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_4_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.QualifiedPrefix");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getBreakdownStatementAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:1001:3: ( (lv_param_6_0= ruleArgumentList ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_EXPONENT)||LA22_0==14||LA22_0==16||(LA22_0>=34 && LA22_0<=35)||(LA22_0>=37 && LA22_0<=39)||(LA22_0>=41 && LA22_0<=43)||LA22_0==45||LA22_0==52||LA22_0==69||(LA22_0>=71 && LA22_0<=74)||(LA22_0>=80 && LA22_0<=84)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRtVil.g:1002:4: (lv_param_6_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:1002:4: (lv_param_6_0= ruleArgumentList )
                    // InternalRtVil.g:1003:5: lv_param_6_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBreakdownStatementAccess().getParamArgumentListParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_param_6_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
                      					}
                      					set(
                      						current,
                      						"param",
                      						lv_param_6_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ArgumentList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getBreakdownStatementAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalRtVil.g:1024:3: (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRtVil.g:1025:4: otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')'
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getBreakdownStatementAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_9=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getBreakdownStatementAccess().getLeftParenthesisKeyword_6_1());
                      			
                    }
                    // InternalRtVil.g:1033:4: ( (lv_part_10_0= ruleBreakdownWithPart ) )
                    // InternalRtVil.g:1034:5: (lv_part_10_0= ruleBreakdownWithPart )
                    {
                    // InternalRtVil.g:1034:5: (lv_part_10_0= ruleBreakdownWithPart )
                    // InternalRtVil.g:1035:6: lv_part_10_0= ruleBreakdownWithPart
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakdownStatementAccess().getPartBreakdownWithPartParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_32);
                    lv_part_10_0=ruleBreakdownWithPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
                      						}
                      						add(
                      							current,
                      							"part",
                      							lv_part_10_0,
                      							"de.uni_hildesheim.sse.vil.rt.RtVil.BreakdownWithPart");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRtVil.g:1052:4: (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) )
                    // InternalRtVil.g:1053:5: otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) )
                    {
                    otherlv_11=(Token)match(input,28,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getBreakdownStatementAccess().getCommaKeyword_6_3_0());
                      				
                    }
                    // InternalRtVil.g:1057:5: ( (lv_part_12_0= ruleBreakdownWithPart ) )
                    // InternalRtVil.g:1058:6: (lv_part_12_0= ruleBreakdownWithPart )
                    {
                    // InternalRtVil.g:1058:6: (lv_part_12_0= ruleBreakdownWithPart )
                    // InternalRtVil.g:1059:7: lv_part_12_0= ruleBreakdownWithPart
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getBreakdownStatementAccess().getPartBreakdownWithPartParserRuleCall_6_3_1_0());
                      						
                    }
                    pushFollow(FOLLOW_10);
                    lv_part_12_0=ruleBreakdownWithPart();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
                      							}
                      							add(
                      								current,
                      								"part",
                      								lv_part_12_0,
                      								"de.uni_hildesheim.sse.vil.rt.RtVil.BreakdownWithPart");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }

                    otherlv_13=(Token)match(input,15,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getBreakdownStatementAccess().getRightParenthesisKeyword_6_4());
                      			
                    }

                    }
                    break;

            }

            // InternalRtVil.g:1082:3: (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRtVil.g:1083:4: otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) )
                    {
                    otherlv_14=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getBreakdownStatementAccess().getCommercialAtKeyword_7_0());
                      			
                    }
                    // InternalRtVil.g:1087:4: ( (lv_time_15_0= ruleExpression ) )
                    // InternalRtVil.g:1088:5: (lv_time_15_0= ruleExpression )
                    {
                    // InternalRtVil.g:1088:5: (lv_time_15_0= ruleExpression )
                    // InternalRtVil.g:1089:6: lv_time_15_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getBreakdownStatementAccess().getTimeExpressionParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
                    lv_time_15_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getBreakdownStatementRule());
                      						}
                      						set(
                      							current,
                      							"time",
                      							lv_time_15_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_16, grammarAccess.getBreakdownStatementAccess().getSemicolonKeyword_8());
              		
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
    // $ANTLR end "ruleBreakdownStatement"


    // $ANTLR start "entryRuleBreakdownWithPart"
    // InternalRtVil.g:1115:1: entryRuleBreakdownWithPart returns [EObject current=null] : iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF ;
    public final EObject entryRuleBreakdownWithPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownWithPart = null;


        try {
            // InternalRtVil.g:1115:58: (iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF )
            // InternalRtVil.g:1116:2: iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakdownWithPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakdownWithPart=ruleBreakdownWithPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakdownWithPart; 
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
    // $ANTLR end "entryRuleBreakdownWithPart"


    // $ANTLR start "ruleBreakdownWithPart"
    // InternalRtVil.g:1122:1: ruleBreakdownWithPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleBreakdownWithPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1128:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalRtVil.g:1129:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:1129:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalRtVil.g:1130:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalRtVil.g:1130:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalRtVil.g:1131:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:1131:4: (lv_name_0_0= ruleIdentifier )
            // InternalRtVil.g:1132:5: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBreakdownWithPartAccess().getNameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBreakdownWithPartRule());
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

            otherlv_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBreakdownWithPartAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalRtVil.g:1153:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalRtVil.g:1154:4: (lv_value_2_0= ruleExpression )
            {
            // InternalRtVil.g:1154:4: (lv_value_2_0= ruleExpression )
            // InternalRtVil.g:1155:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBreakdownWithPartAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBreakdownWithPartRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
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
    // $ANTLR end "ruleBreakdownWithPart"


    // $ANTLR start "entryRuleTacticDeclaration"
    // InternalRtVil.g:1176:1: entryRuleTacticDeclaration returns [EObject current=null] : iv_ruleTacticDeclaration= ruleTacticDeclaration EOF ;
    public final EObject entryRuleTacticDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTacticDeclaration = null;


        try {
            // InternalRtVil.g:1176:58: (iv_ruleTacticDeclaration= ruleTacticDeclaration EOF )
            // InternalRtVil.g:1177:2: iv_ruleTacticDeclaration= ruleTacticDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTacticDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTacticDeclaration=ruleTacticDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTacticDeclaration; 
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
    // $ANTLR end "entryRuleTacticDeclaration"


    // $ANTLR start "ruleTacticDeclaration"
    // InternalRtVil.g:1183:1: ruleTacticDeclaration returns [EObject current=null] : ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? ) ;
    public final EObject ruleTacticDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_paramList_4_0 = null;

        EObject lv_conditions_7_0 = null;

        EObject lv_block_8_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1189:2: ( ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? ) )
            // InternalRtVil.g:1190:2: ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? )
            {
            // InternalRtVil.g:1190:2: ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? )
            // InternalRtVil.g:1191:3: () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )?
            {
            // InternalRtVil.g:1191:3: ()
            // InternalRtVil.g:1192:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTacticDeclarationAccess().getTacticDeclarationAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTacticDeclarationAccess().getTacticKeyword_1());
              		
            }
            // InternalRtVil.g:1205:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:1206:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:1206:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:1207:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTacticDeclarationAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_name_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTacticDeclarationRule());
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

            otherlv_3=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTacticDeclarationAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:1228:3: ( (lv_paramList_4_0= ruleParameterList ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_VERSION||(LA25_0>=RULE_ID && LA25_0<=RULE_EXPONENT)||(LA25_0>=34 && LA25_0<=35)||LA25_0==39||(LA25_0>=41 && LA25_0<=42)||LA25_0==52||(LA25_0>=83 && LA25_0<=88)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRtVil.g:1229:4: (lv_paramList_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:1229:4: (lv_paramList_4_0= ruleParameterList )
                    // InternalRtVil.g:1230:5: lv_paramList_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTacticDeclarationAccess().getParamListParameterListParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
                    lv_paramList_4_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTacticDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"paramList",
                      						lv_paramList_4_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getTacticDeclarationAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_6=(Token)match(input,21,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getTacticDeclarationAccess().getEqualsSignKeyword_6());
              		
            }
            // InternalRtVil.g:1255:3: ( (lv_conditions_7_0= ruleRuleConditions ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_EXPONENT)||LA26_0==14||LA26_0==25||(LA26_0>=34 && LA26_0<=35)||(LA26_0>=37 && LA26_0<=39)||(LA26_0>=41 && LA26_0<=43)||LA26_0==45||LA26_0==52||LA26_0==69||(LA26_0>=71 && LA26_0<=74)||(LA26_0>=80 && LA26_0<=84)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRtVil.g:1256:4: (lv_conditions_7_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:1256:4: (lv_conditions_7_0= ruleRuleConditions )
                    // InternalRtVil.g:1257:5: lv_conditions_7_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTacticDeclarationAccess().getConditionsRuleConditionsParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_34);
                    lv_conditions_7_0=ruleRuleConditions();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTacticDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"conditions",
                      						lv_conditions_7_0,
                      						"de.uni_hildesheim.sse.vil.buildlang.VilBuildLanguage.RuleConditions");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:1274:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:1275:4: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:1275:4: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:1276:5: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTacticDeclarationAccess().getBlockRuleElementBlockParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_block_8_0=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTacticDeclarationRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_8_0,
              						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRtVil.g:1293:3: (otherlv_9= ';' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==18) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRtVil.g:1294:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getTacticDeclarationAccess().getSemicolonKeyword_9());
                      			
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
    // $ANTLR end "ruleTacticDeclaration"


    // $ANTLR start "entryRuleRuleElementBlock"
    // InternalRtVil.g:1303:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // InternalRtVil.g:1303:57: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // InternalRtVil.g:1304:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
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
    // InternalRtVil.g:1310:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_intent_2_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1316:2: ( ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' ) )
            // InternalRtVil.g:1317:2: ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' )
            {
            // InternalRtVil.g:1317:2: ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' )
            // InternalRtVil.g:1318:3: () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}'
            {
            // InternalRtVil.g:1318:3: ()
            // InternalRtVil.g:1319:4: 
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

            otherlv_1=(Token)match(input,16,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalRtVil.g:1332:3: ( (lv_intent_2_0= ruleIntentDeclaration ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRtVil.g:1333:4: (lv_intent_2_0= ruleIntentDeclaration )
                    {
                    // InternalRtVil.g:1333:4: (lv_intent_2_0= ruleIntentDeclaration )
                    // InternalRtVil.g:1334:5: lv_intent_2_0= ruleIntentDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleElementBlockAccess().getIntentIntentDeclarationParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_26);
                    lv_intent_2_0=ruleIntentDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRuleElementBlockRule());
                      					}
                      					set(
                      						current,
                      						"intent",
                      						lv_intent_2_0,
                      						"de.uni_hildesheim.sse.vil.rt.RtVil.IntentDeclaration");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:1351:3: ( (lv_elements_3_0= ruleRuleElement ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_EXPONENT)||LA29_0==14||LA29_0==16||(LA29_0>=31 && LA29_0<=32)||(LA29_0>=34 && LA29_0<=35)||(LA29_0>=37 && LA29_0<=43)||(LA29_0>=45 && LA29_0<=46)||LA29_0==52||LA29_0==69||(LA29_0>=71 && LA29_0<=74)||(LA29_0>=80 && LA29_0<=88)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalRtVil.g:1352:4: (lv_elements_3_0= ruleRuleElement )
            	    {
            	    // InternalRtVil.g:1352:4: (lv_elements_3_0= ruleRuleElement )
            	    // InternalRtVil.g:1353:5: lv_elements_3_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_elements_3_0=ruleRuleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRuleElementBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elements",
            	      						lv_elements_3_0,
            	      						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRuleElementBlockAccess().getRightCurlyBracketKeyword_4());
              		
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
    // InternalRtVil.g:1378:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // InternalRtVil.g:1378:52: (iv_ruleRuleElement= ruleRuleElement EOF )
            // InternalRtVil.g:1379:2: iv_ruleRuleElement= ruleRuleElement EOF
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
    // InternalRtVil.g:1385:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) ) ;
    public final EObject ruleRuleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;

        EObject lv_while_2_0 = null;

        EObject lv_for_4_0 = null;

        EObject lv_fail_6_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1391:2: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) ) )
            // InternalRtVil.g:1392:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )
            {
            // InternalRtVil.g:1392:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )
            int alt32=5;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalRtVil.g:1393:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalRtVil.g:1393:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalRtVil.g:1394:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalRtVil.g:1394:4: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalRtVil.g:1395:5: lv_varDecl_0_0= ruleVariableDeclaration
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
                    // InternalRtVil.g:1413:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:1413:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:1414:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:1414:4: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalRtVil.g:1415:5: lv_exprStmt_1_0= ruleExpressionStatement
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
                    // InternalRtVil.g:1433:3: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    {
                    // InternalRtVil.g:1433:3: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    // InternalRtVil.g:1434:4: ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )?
                    {
                    // InternalRtVil.g:1434:4: ( (lv_while_2_0= ruleWhile ) )
                    // InternalRtVil.g:1435:5: (lv_while_2_0= ruleWhile )
                    {
                    // InternalRtVil.g:1435:5: (lv_while_2_0= ruleWhile )
                    // InternalRtVil.g:1436:6: lv_while_2_0= ruleWhile
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleElementAccess().getWhileWhileParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    // InternalRtVil.g:1453:4: (otherlv_3= ';' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==18) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalRtVil.g:1454:5: otherlv_3= ';'
                            {
                            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
                    // InternalRtVil.g:1461:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    {
                    // InternalRtVil.g:1461:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    // InternalRtVil.g:1462:4: ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )?
                    {
                    // InternalRtVil.g:1462:4: ( (lv_for_4_0= ruleFor ) )
                    // InternalRtVil.g:1463:5: (lv_for_4_0= ruleFor )
                    {
                    // InternalRtVil.g:1463:5: (lv_for_4_0= ruleFor )
                    // InternalRtVil.g:1464:6: lv_for_4_0= ruleFor
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleElementAccess().getForForParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    // InternalRtVil.g:1481:4: (otherlv_5= ';' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==18) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalRtVil.g:1482:5: otherlv_5= ';'
                            {
                            otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getRuleElementAccess().getSemicolonKeyword_3_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalRtVil.g:1489:3: ( (lv_fail_6_0= ruleFailStatement ) )
                    {
                    // InternalRtVil.g:1489:3: ( (lv_fail_6_0= ruleFailStatement ) )
                    // InternalRtVil.g:1490:4: (lv_fail_6_0= ruleFailStatement )
                    {
                    // InternalRtVil.g:1490:4: (lv_fail_6_0= ruleFailStatement )
                    // InternalRtVil.g:1491:5: lv_fail_6_0= ruleFailStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleElementAccess().getFailFailStatementParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_fail_6_0=ruleFailStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getRuleElementRule());
                      					}
                      					set(
                      						current,
                      						"fail",
                      						lv_fail_6_0,
                      						"de.uni_hildesheim.sse.vil.rt.RtVil.FailStatement");
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
    // $ANTLR end "ruleRuleElement"


    // $ANTLR start "entryRuleIntentDeclaration"
    // InternalRtVil.g:1512:1: entryRuleIntentDeclaration returns [EObject current=null] : iv_ruleIntentDeclaration= ruleIntentDeclaration EOF ;
    public final EObject entryRuleIntentDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentDeclaration = null;


        try {
            // InternalRtVil.g:1512:58: (iv_ruleIntentDeclaration= ruleIntentDeclaration EOF )
            // InternalRtVil.g:1513:2: iv_ruleIntentDeclaration= ruleIntentDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntentDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntentDeclaration=ruleIntentDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntentDeclaration; 
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
    // $ANTLR end "entryRuleIntentDeclaration"


    // $ANTLR start "ruleIntentDeclaration"
    // InternalRtVil.g:1519:1: ruleIntentDeclaration returns [EObject current=null] : (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) ;
    public final EObject ruleIntentDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_exprStmt_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1525:2: ( (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) )
            // InternalRtVil.g:1526:2: (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            {
            // InternalRtVil.g:1526:2: (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            // InternalRtVil.g:1527:3: otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIntentDeclarationAccess().getIntentKeyword_0());
              		
            }
            // InternalRtVil.g:1531:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
            // InternalRtVil.g:1532:4: (lv_exprStmt_1_0= ruleExpressionStatement )
            {
            // InternalRtVil.g:1532:4: (lv_exprStmt_1_0= ruleExpressionStatement )
            // InternalRtVil.g:1533:5: lv_exprStmt_1_0= ruleExpressionStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIntentDeclarationAccess().getExprStmtExpressionStatementParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_exprStmt_1_0=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIntentDeclarationRule());
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
    // $ANTLR end "ruleIntentDeclaration"


    // $ANTLR start "entryRuleFailStatement"
    // InternalRtVil.g:1554:1: entryRuleFailStatement returns [EObject current=null] : iv_ruleFailStatement= ruleFailStatement EOF ;
    public final EObject entryRuleFailStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailStatement = null;


        try {
            // InternalRtVil.g:1554:54: (iv_ruleFailStatement= ruleFailStatement EOF )
            // InternalRtVil.g:1555:2: iv_ruleFailStatement= ruleFailStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFailStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFailStatement=ruleFailStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFailStatement; 
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
    // $ANTLR end "entryRuleFailStatement"


    // $ANTLR start "ruleFailStatement"
    // InternalRtVil.g:1561:1: ruleFailStatement returns [EObject current=null] : ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' ) ;
    public final EObject ruleFailStatement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        EObject lv_reason_1_0 = null;

        EObject lv_code_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1567:2: ( ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' ) )
            // InternalRtVil.g:1568:2: ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' )
            {
            // InternalRtVil.g:1568:2: ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' )
            // InternalRtVil.g:1569:3: ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';'
            {
            // InternalRtVil.g:1569:3: ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==31) ) {
                alt35=1;
            }
            else if ( (LA35_0==32) ) {
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
                    // InternalRtVil.g:1570:4: ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? )
                    {
                    // InternalRtVil.g:1570:4: ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? )
                    // InternalRtVil.g:1571:5: ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )?
                    {
                    // InternalRtVil.g:1571:5: ( (lv_name_0_0= 'fail' ) )
                    // InternalRtVil.g:1572:6: (lv_name_0_0= 'fail' )
                    {
                    // InternalRtVil.g:1572:6: (lv_name_0_0= 'fail' )
                    // InternalRtVil.g:1573:7: lv_name_0_0= 'fail'
                    {
                    lv_name_0_0=(Token)match(input,31,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_0_0, grammarAccess.getFailStatementAccess().getNameFailKeyword_0_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getFailStatementRule());
                      							}
                      							setWithLastConsumed(current, "name", lv_name_0_0, "fail");
                      						
                    }

                    }


                    }

                    // InternalRtVil.g:1585:5: ( (lv_reason_1_0= ruleExpression ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_EXPONENT)||LA33_0==14||LA33_0==16||(LA33_0>=34 && LA33_0<=35)||(LA33_0>=37 && LA33_0<=39)||(LA33_0>=41 && LA33_0<=43)||LA33_0==45||LA33_0==52||LA33_0==69||(LA33_0>=71 && LA33_0<=74)||(LA33_0>=80 && LA33_0<=84)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalRtVil.g:1586:6: (lv_reason_1_0= ruleExpression )
                            {
                            // InternalRtVil.g:1586:6: (lv_reason_1_0= ruleExpression )
                            // InternalRtVil.g:1587:7: lv_reason_1_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFailStatementAccess().getReasonExpressionParserRuleCall_0_0_1_0());
                              						
                            }
                            pushFollow(FOLLOW_37);
                            lv_reason_1_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFailStatementRule());
                              							}
                              							set(
                              								current,
                              								"reason",
                              								lv_reason_1_0,
                              								"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalRtVil.g:1604:5: (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==27) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalRtVil.g:1605:6: otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) )
                            {
                            otherlv_2=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getFailStatementAccess().getWithKeyword_0_0_2_0());
                              					
                            }
                            // InternalRtVil.g:1609:6: ( (lv_code_3_0= ruleExpression ) )
                            // InternalRtVil.g:1610:7: (lv_code_3_0= ruleExpression )
                            {
                            // InternalRtVil.g:1610:7: (lv_code_3_0= ruleExpression )
                            // InternalRtVil.g:1611:8: lv_code_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getFailStatementAccess().getCodeExpressionParserRuleCall_0_0_2_1_0());
                              							
                            }
                            pushFollow(FOLLOW_22);
                            lv_code_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getFailStatementRule());
                              								}
                              								set(
                              									current,
                              									"code",
                              									lv_code_3_0,
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
                    break;
                case 2 :
                    // InternalRtVil.g:1631:4: ( (lv_name_4_0= 'refail' ) )
                    {
                    // InternalRtVil.g:1631:4: ( (lv_name_4_0= 'refail' ) )
                    // InternalRtVil.g:1632:5: (lv_name_4_0= 'refail' )
                    {
                    // InternalRtVil.g:1632:5: (lv_name_4_0= 'refail' )
                    // InternalRtVil.g:1633:6: lv_name_4_0= 'refail'
                    {
                    lv_name_4_0=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_4_0, grammarAccess.getFailStatementAccess().getNameRefailKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFailStatementRule());
                      						}
                      						setWithLastConsumed(current, "name", lv_name_4_0, "refail");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFailStatementAccess().getSemicolonKeyword_1());
              		
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
    // $ANTLR end "ruleFailStatement"


    // $ANTLR start "entryRuleRequire"
    // InternalRtVil.g:1654:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // InternalRtVil.g:1654:48: (iv_ruleRequire= ruleRequire EOF )
            // InternalRtVil.g:1655:2: iv_ruleRequire= ruleRequire EOF
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
    // InternalRtVil.g:1661:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_versionSpec_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1667:2: ( (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) )
            // InternalRtVil.g:1668:2: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            {
            // InternalRtVil.g:1668:2: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            // InternalRtVil.g:1669:3: otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireVTLKeyword_0());
              		
            }
            // InternalRtVil.g:1673:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalRtVil.g:1674:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalRtVil.g:1674:4: (lv_name_1_0= RULE_STRING )
            // InternalRtVil.g:1675:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_39); if (state.failed) return current;
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

            // InternalRtVil.g:1691:3: ( (lv_versionSpec_2_0= ruleVersionSpec ) )
            // InternalRtVil.g:1692:4: (lv_versionSpec_2_0= ruleVersionSpec )
            {
            // InternalRtVil.g:1692:4: (lv_versionSpec_2_0= ruleVersionSpec )
            // InternalRtVil.g:1693:5: lv_versionSpec_2_0= ruleVersionSpec
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRequireAccess().getVersionSpecVersionSpecParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleScriptParentDecl"
    // InternalRtVil.g:1718:1: entryRuleScriptParentDecl returns [EObject current=null] : iv_ruleScriptParentDecl= ruleScriptParentDecl EOF ;
    public final EObject entryRuleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptParentDecl = null;


        try {
            // InternalRtVil.g:1718:57: (iv_ruleScriptParentDecl= ruleScriptParentDecl EOF )
            // InternalRtVil.g:1719:2: iv_ruleScriptParentDecl= ruleScriptParentDecl EOF
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
    // InternalRtVil.g:1725:1: ruleScriptParentDecl returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1731:2: ( (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalRtVil.g:1732:2: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalRtVil.g:1732:2: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalRtVil.g:1733:3: otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getScriptParentDeclAccess().getExtendsKeyword_0());
              		
            }
            // InternalRtVil.g:1737:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:1738:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:1738:4: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:1739:5: lv_name_1_0= ruleIdentifier
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


    // $ANTLR start "entryRuleRuleDeclaration"
    // InternalRtVil.g:1760:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // InternalRtVil.g:1760:56: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // InternalRtVil.g:1761:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
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
    // InternalRtVil.g:1767:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? ) ;
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
            // InternalRtVil.g:1773:2: ( ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? ) )
            // InternalRtVil.g:1774:2: ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? )
            {
            // InternalRtVil.g:1774:2: ( () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )? )
            // InternalRtVil.g:1775:3: () ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )? ( (lv_conditions_9_0= ruleRuleConditions ) )? ( (lv_block_10_0= ruleRuleElementBlock ) ) (otherlv_11= ';' )?
            {
            // InternalRtVil.g:1775:3: ()
            // InternalRtVil.g:1776:4: 
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

            // InternalRtVil.g:1785:3: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )?
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalRtVil.g:1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '='
                    {
                    // InternalRtVil.g:1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?
                    int alt36=2;
                    alt36 = dfa36.predict(input);
                    switch (alt36) {
                        case 1 :
                            // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                            {
                            // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                            // InternalRtVil.g:1788:6: lv_annotations_1_0= ruleAnnotationDeclarations
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_1_0_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
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

                    // InternalRtVil.g:1805:4: ( (lv_modifier_2_0= ruleRuleModifier ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==35) ) {
                        int LA37_1 = input.LA(2);

                        if ( (synpred46_InternalRtVil()) ) {
                            alt37=1;
                        }
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
                            {
                            // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
                            // InternalRtVil.g:1807:6: lv_modifier_2_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0());
                              					
                            }
                            pushFollow(FOLLOW_40);
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

                    // InternalRtVil.g:1824:4: ( (lv_type_3_0= ruleType ) )?
                    int alt38=2;
                    alt38 = dfa38.predict(input);
                    switch (alt38) {
                        case 1 :
                            // InternalRtVil.g:1825:5: (lv_type_3_0= ruleType )
                            {
                            // InternalRtVil.g:1825:5: (lv_type_3_0= ruleType )
                            // InternalRtVil.g:1826:6: lv_type_3_0= ruleType
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_2_0());
                              					
                            }
                            pushFollow(FOLLOW_7);
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

                    // InternalRtVil.g:1843:4: ( (lv_name_4_0= ruleIdentifier ) )
                    // InternalRtVil.g:1844:5: (lv_name_4_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:1844:5: (lv_name_4_0= ruleIdentifier )
                    // InternalRtVil.g:1845:6: lv_name_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_5=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_4());
                      			
                    }
                    // InternalRtVil.g:1866:4: ( (lv_paramList_6_0= ruleParameterList ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==RULE_VERSION||(LA39_0>=RULE_ID && LA39_0<=RULE_EXPONENT)||(LA39_0>=34 && LA39_0<=35)||LA39_0==39||(LA39_0>=41 && LA39_0<=42)||LA39_0==52||(LA39_0>=83 && LA39_0<=88)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalRtVil.g:1867:5: (lv_paramList_6_0= ruleParameterList )
                            {
                            // InternalRtVil.g:1867:5: (lv_paramList_6_0= ruleParameterList )
                            // InternalRtVil.g:1868:6: lv_paramList_6_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_5_0());
                              					
                            }
                            pushFollow(FOLLOW_10);
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

                    otherlv_7=(Token)match(input,15,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_6());
                      			
                    }
                    otherlv_8=(Token)match(input,21,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_7());
                      			
                    }

                    }
                    break;

            }

            // InternalRtVil.g:1894:3: ( (lv_conditions_9_0= ruleRuleConditions ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_EXPONENT)||LA41_0==14||LA41_0==25||(LA41_0>=34 && LA41_0<=35)||(LA41_0>=37 && LA41_0<=39)||(LA41_0>=41 && LA41_0<=43)||LA41_0==45||LA41_0==52||LA41_0==69||(LA41_0>=71 && LA41_0<=74)||(LA41_0>=80 && LA41_0<=84)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRtVil.g:1895:4: (lv_conditions_9_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:1895:4: (lv_conditions_9_0= ruleRuleConditions )
                    // InternalRtVil.g:1896:5: lv_conditions_9_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_34);
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

            // InternalRtVil.g:1913:3: ( (lv_block_10_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:1914:4: (lv_block_10_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:1914:4: (lv_block_10_0= ruleRuleElementBlock )
            // InternalRtVil.g:1915:5: lv_block_10_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_15);
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
              						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRtVil.g:1932:3: (otherlv_11= ';' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==18) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRtVil.g:1933:4: otherlv_11= ';'
                    {
                    otherlv_11=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:1942:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // InternalRtVil.g:1942:55: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // InternalRtVil.g:1943:2: iv_ruleRuleConditions= ruleRuleConditions EOF
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
    // InternalRtVil.g:1949:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:1955:2: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // InternalRtVil.g:1956:2: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // InternalRtVil.g:1956:2: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // InternalRtVil.g:1957:3: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // InternalRtVil.g:1957:3: ()
            // InternalRtVil.g:1958:4: 
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

            // InternalRtVil.g:1967:3: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_EXPONENT)||LA43_0==14||(LA43_0>=34 && LA43_0<=35)||(LA43_0>=37 && LA43_0<=39)||(LA43_0>=41 && LA43_0<=43)||LA43_0==45||LA43_0==52||LA43_0==69||(LA43_0>=71 && LA43_0<=74)||(LA43_0>=80 && LA43_0<=84)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRtVil.g:1968:4: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:1968:4: (lv_postcondition_1_0= ruleLogicalExpression )
                    // InternalRtVil.g:1969:5: lv_postcondition_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getRuleConditionsAccess().getPostconditionLogicalExpressionParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_27);
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

            otherlv_2=(Token)match(input,25,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
              		
            }
            // InternalRtVil.g:1990:3: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_STRING && LA45_0<=RULE_EXPONENT)||LA45_0==14||(LA45_0>=34 && LA45_0<=35)||(LA45_0>=37 && LA45_0<=39)||(LA45_0>=41 && LA45_0<=43)||LA45_0==45||LA45_0==52||LA45_0==69||(LA45_0>=71 && LA45_0<=74)||(LA45_0>=80 && LA45_0<=84)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRtVil.g:1991:4: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // InternalRtVil.g:1991:4: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:1992:5: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:1992:5: (lv_preconditions_3_0= ruleLogicalExpression )
                    // InternalRtVil.g:1993:6: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_42);
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

                    // InternalRtVil.g:2010:4: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==28) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalRtVil.g:2011:5: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalRtVil.g:2015:5: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // InternalRtVil.g:2016:6: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // InternalRtVil.g:2016:6: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // InternalRtVil.g:2017:7: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop44;
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


    // $ANTLR start "entryRuleRuleModifier"
    // InternalRtVil.g:2040:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // InternalRtVil.g:2040:53: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // InternalRtVil.g:2041:2: iv_ruleRuleModifier= ruleRuleModifier EOF
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
    // InternalRtVil.g:2047:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;


        	enterRule();

        try {
            // InternalRtVil.g:2053:2: ( ( (lv_protected_0_0= 'protected' ) ) )
            // InternalRtVil.g:2054:2: ( (lv_protected_0_0= 'protected' ) )
            {
            // InternalRtVil.g:2054:2: ( (lv_protected_0_0= 'protected' ) )
            // InternalRtVil.g:2055:3: (lv_protected_0_0= 'protected' )
            {
            // InternalRtVil.g:2055:3: (lv_protected_0_0= 'protected' )
            // InternalRtVil.g:2056:4: lv_protected_0_0= 'protected'
            {
            lv_protected_0_0=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:2071:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalRtVil.g:2071:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalRtVil.g:2072:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalRtVil.g:2078:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) ;
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
            // InternalRtVil.g:2084:2: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) )
            // InternalRtVil.g:2085:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            {
            // InternalRtVil.g:2085:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // InternalRtVil.g:2086:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    {
                    // InternalRtVil.g:2086:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    // InternalRtVil.g:2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
                    {
                    // InternalRtVil.g:2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
                    int alt47=2;
                    alt47 = dfa47.predict(input);
                    switch (alt47) {
                        case 1 :
                            // InternalRtVil.g:2088:5: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                            {
                            // InternalRtVil.g:2088:5: ( (lv_var_0_0= ruleIdentifier ) )
                            // InternalRtVil.g:2089:6: (lv_var_0_0= ruleIdentifier )
                            {
                            // InternalRtVil.g:2089:6: (lv_var_0_0= ruleIdentifier )
                            // InternalRtVil.g:2090:7: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0());
                              						
                            }
                            pushFollow(FOLLOW_43);
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

                            // InternalRtVil.g:2107:5: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                            int alt46=2;
                            int LA46_0 = input.LA(1);

                            if ( (LA46_0==36) ) {
                                alt46=1;
                            }
                            switch (alt46) {
                                case 1 :
                                    // InternalRtVil.g:2108:6: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                                    {
                                    otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_0_1_0());
                                      					
                                    }
                                    // InternalRtVil.g:2112:6: ( (lv_field_2_0= ruleIdentifier ) )
                                    // InternalRtVil.g:2113:7: (lv_field_2_0= ruleIdentifier )
                                    {
                                    // InternalRtVil.g:2113:7: (lv_field_2_0= ruleIdentifier )
                                    // InternalRtVil.g:2114:8: lv_field_2_0= ruleIdentifier
                                    {
                                    if ( state.backtracking==0 ) {

                                      								newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_0_1_1_0());
                                      							
                                    }
                                    pushFollow(FOLLOW_18);
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

                            otherlv_3=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_0_2());
                              				
                            }

                            }
                            break;

                    }

                    // InternalRtVil.g:2137:4: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalRtVil.g:2138:5: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalRtVil.g:2138:5: (lv_expr_4_0= ruleExpression )
                    // InternalRtVil.g:2139:6: lv_expr_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
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

                    otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRtVil.g:2162:3: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    {
                    // InternalRtVil.g:2162:3: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    // InternalRtVil.g:2163:4: ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )?
                    {
                    // InternalRtVil.g:2163:4: ( (lv_alt_6_0= ruleAlternative ) )
                    // InternalRtVil.g:2164:5: (lv_alt_6_0= ruleAlternative )
                    {
                    // InternalRtVil.g:2164:5: (lv_alt_6_0= ruleAlternative )
                    // InternalRtVil.g:2165:6: lv_alt_6_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionStatementAccess().getAltAlternativeParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
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

                    // InternalRtVil.g:2182:4: (otherlv_7= ';' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==18) ) {
                        int LA48_1 = input.LA(2);

                        if ( (synpred58_InternalRtVil()) ) {
                            alt48=1;
                        }
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalRtVil.g:2183:5: otherlv_7= ';'
                            {
                            otherlv_7=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:2193:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalRtVil.g:2193:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalRtVil.g:2194:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalRtVil.g:2200:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // InternalRtVil.g:2206:2: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // InternalRtVil.g:2207:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // InternalRtVil.g:2207:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt50=8;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // InternalRtVil.g:2208:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // InternalRtVil.g:2208:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // InternalRtVil.g:2209:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // InternalRtVil.g:2209:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // InternalRtVil.g:2210:5: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
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
                    // InternalRtVil.g:2228:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // InternalRtVil.g:2228:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // InternalRtVil.g:2229:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // InternalRtVil.g:2229:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // InternalRtVil.g:2230:5: lv_unqEx_1_0= ruleUnqualifiedExecution
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
                    // InternalRtVil.g:2248:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // InternalRtVil.g:2248:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // InternalRtVil.g:2249:4: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // InternalRtVil.g:2249:4: (lv_superEx_2_0= ruleSuperExecution )
                    // InternalRtVil.g:2250:5: lv_superEx_2_0= ruleSuperExecution
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
                    // InternalRtVil.g:2268:3: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // InternalRtVil.g:2268:3: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // InternalRtVil.g:2269:4: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // InternalRtVil.g:2269:4: (lv_sysEx_3_0= ruleSystemExecution )
                    // InternalRtVil.g:2270:5: lv_sysEx_3_0= ruleSystemExecution
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
                    // InternalRtVil.g:2288:3: ( (lv_map_4_0= ruleMap ) )
                    {
                    // InternalRtVil.g:2288:3: ( (lv_map_4_0= ruleMap ) )
                    // InternalRtVil.g:2289:4: (lv_map_4_0= ruleMap )
                    {
                    // InternalRtVil.g:2289:4: (lv_map_4_0= ruleMap )
                    // InternalRtVil.g:2290:5: lv_map_4_0= ruleMap
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
                    // InternalRtVil.g:2308:3: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // InternalRtVil.g:2308:3: ( (lv_join_5_0= ruleJoin ) )
                    // InternalRtVil.g:2309:4: (lv_join_5_0= ruleJoin )
                    {
                    // InternalRtVil.g:2309:4: (lv_join_5_0= ruleJoin )
                    // InternalRtVil.g:2310:5: lv_join_5_0= ruleJoin
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
                    // InternalRtVil.g:2328:3: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // InternalRtVil.g:2328:3: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // InternalRtVil.g:2329:4: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // InternalRtVil.g:2329:4: (lv_instantiate_6_0= ruleInstantiate )
                    // InternalRtVil.g:2330:5: lv_instantiate_6_0= ruleInstantiate
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
                    // InternalRtVil.g:2348:3: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // InternalRtVil.g:2348:3: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // InternalRtVil.g:2349:4: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // InternalRtVil.g:2349:4: (lv_newEx_7_0= ruleConstructorExecution )
                    // InternalRtVil.g:2350:5: lv_newEx_7_0= ruleConstructorExecution
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
    // InternalRtVil.g:2371:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // InternalRtVil.g:2371:52: (iv_ruleInstantiate= ruleInstantiate EOF )
            // InternalRtVil.g:2372:2: iv_ruleInstantiate= ruleInstantiate EOF
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
    // InternalRtVil.g:2378:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) ;
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
            // InternalRtVil.g:2384:2: ( (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) )
            // InternalRtVil.g:2385:2: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            {
            // InternalRtVil.g:2385:2: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            // InternalRtVil.g:2386:3: otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
              		
            }
            // InternalRtVil.g:2390:3: ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_VERSION||(LA51_0>=RULE_ID && LA51_0<=RULE_EXPONENT)||(LA51_0>=34 && LA51_0<=35)||LA51_0==39||(LA51_0>=41 && LA51_0<=42)||LA51_0==52||(LA51_0>=83 && LA51_0<=84)) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_STRING) ) {
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
                    // InternalRtVil.g:2391:4: ( (lv_project_1_0= ruleIdentifier ) )
                    {
                    // InternalRtVil.g:2391:4: ( (lv_project_1_0= ruleIdentifier ) )
                    // InternalRtVil.g:2392:5: (lv_project_1_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:2392:5: (lv_project_1_0= ruleIdentifier )
                    // InternalRtVil.g:2393:6: lv_project_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getInstantiateAccess().getProjectIdentifierParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
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
                    // InternalRtVil.g:2411:4: ( (lv_ruleName_2_0= RULE_STRING ) )
                    {
                    // InternalRtVil.g:2411:4: ( (lv_ruleName_2_0= RULE_STRING ) )
                    // InternalRtVil.g:2412:5: (lv_ruleName_2_0= RULE_STRING )
                    {
                    // InternalRtVil.g:2412:5: (lv_ruleName_2_0= RULE_STRING )
                    // InternalRtVil.g:2413:6: lv_ruleName_2_0= RULE_STRING
                    {
                    lv_ruleName_2_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,14,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRtVil.g:2434:3: ( (lv_param_4_0= ruleArgumentList ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_EXPONENT)||LA52_0==14||LA52_0==16||(LA52_0>=34 && LA52_0<=35)||(LA52_0>=37 && LA52_0<=39)||(LA52_0>=41 && LA52_0<=43)||LA52_0==45||LA52_0==52||LA52_0==69||(LA52_0>=71 && LA52_0<=74)||(LA52_0>=80 && LA52_0<=84)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRtVil.g:2435:4: (lv_param_4_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:2435:4: (lv_param_4_0= ruleArgumentList )
                    // InternalRtVil.g:2436:5: lv_param_4_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInstantiateAccess().getParamArgumentListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
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

            otherlv_5=(Token)match(input,15,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalRtVil.g:2457:3: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // InternalRtVil.g:2458:4: (lv_versionSpec_6_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:2458:4: (lv_versionSpec_6_0= ruleVersionSpec )
                    // InternalRtVil.g:2459:5: lv_versionSpec_6_0= ruleVersionSpec
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
    // InternalRtVil.g:2480:1: entryRuleLoopVariable returns [EObject current=null] : iv_ruleLoopVariable= ruleLoopVariable EOF ;
    public final EObject entryRuleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariable = null;


        try {
            // InternalRtVil.g:2480:53: (iv_ruleLoopVariable= ruleLoopVariable EOF )
            // InternalRtVil.g:2481:2: iv_ruleLoopVariable= ruleLoopVariable EOF
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
    // InternalRtVil.g:2487:1: ruleLoopVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:2493:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // InternalRtVil.g:2494:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // InternalRtVil.g:2494:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // InternalRtVil.g:2495:3: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // InternalRtVil.g:2495:3: ( (lv_type_0_0= ruleType ) )?
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalRtVil.g:2496:4: (lv_type_0_0= ruleType )
                    {
                    // InternalRtVil.g:2496:4: (lv_type_0_0= ruleType )
                    // InternalRtVil.g:2497:5: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLoopVariableAccess().getTypeTypeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_7);
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

            // InternalRtVil.g:2514:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalRtVil.g:2515:4: (lv_var_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:2515:4: (lv_var_1_0= ruleIdentifier )
            // InternalRtVil.g:2516:5: lv_var_1_0= ruleIdentifier
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
    // InternalRtVil.g:2537:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalRtVil.g:2537:44: (iv_ruleMap= ruleMap EOF )
            // InternalRtVil.g:2538:2: iv_ruleMap= ruleMap EOF
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
    // InternalRtVil.g:2544:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalRtVil.g:2550:2: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2551:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2551:2: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2552:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:2560:3: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalRtVil.g:2561:4: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalRtVil.g:2561:4: (lv_var_2_0= ruleLoopVariable )
            // InternalRtVil.g:2562:5: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_46);
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

            // InternalRtVil.g:2579:3: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==28) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalRtVil.g:2580:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalRtVil.g:2584:4: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalRtVil.g:2585:5: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalRtVil.g:2585:5: (lv_var_4_0= ruleLoopVariable )
            	    // InternalRtVil.g:2586:6: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
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
            	    break loop55;
                }
            } while (true);

            // InternalRtVil.g:2604:3: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalRtVil.g:2605:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalRtVil.g:2605:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalRtVil.g:2606:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalRtVil.g:2606:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==21) ) {
                alt56=1;
            }
            else if ( (LA56_0==25) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalRtVil.g:2607:6: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
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
                    // InternalRtVil.g:2618:6: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
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

            // InternalRtVil.g:2631:3: ( (lv_expr_6_0= ruleExpression ) )
            // InternalRtVil.g:2632:4: (lv_expr_6_0= ruleExpression )
            {
            // InternalRtVil.g:2632:4: (lv_expr_6_0= ruleExpression )
            // InternalRtVil.g:2633:5: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_7=(Token)match(input,15,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalRtVil.g:2654:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2655:4: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2655:4: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:2656:5: lv_block_8_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
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
    // InternalRtVil.g:2677:1: entryRuleFor returns [EObject current=null] : iv_ruleFor= ruleFor EOF ;
    public final EObject entryRuleFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor = null;


        try {
            // InternalRtVil.g:2677:44: (iv_ruleFor= ruleFor EOF )
            // InternalRtVil.g:2678:2: iv_ruleFor= ruleFor EOF
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
    // InternalRtVil.g:2684:1: ruleFor returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalRtVil.g:2690:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2691:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2691:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2692:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getForAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getForAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:2700:3: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalRtVil.g:2701:4: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalRtVil.g:2701:4: (lv_var_2_0= ruleLoopVariable )
            // InternalRtVil.g:2702:5: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_46);
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

            // InternalRtVil.g:2719:3: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==28) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalRtVil.g:2720:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getForAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalRtVil.g:2724:4: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalRtVil.g:2725:5: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalRtVil.g:2725:5: (lv_var_4_0= ruleLoopVariable )
            	    // InternalRtVil.g:2726:6: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
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
            	    break loop57;
                }
            } while (true);

            // InternalRtVil.g:2744:3: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalRtVil.g:2745:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalRtVil.g:2745:4: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalRtVil.g:2746:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalRtVil.g:2746:5: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==21) ) {
                alt58=1;
            }
            else if ( (LA58_0==25) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalRtVil.g:2747:6: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
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
                    // InternalRtVil.g:2758:6: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
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

            // InternalRtVil.g:2771:3: ( (lv_expr_6_0= ruleExpression ) )
            // InternalRtVil.g:2772:4: (lv_expr_6_0= ruleExpression )
            {
            // InternalRtVil.g:2772:4: (lv_expr_6_0= ruleExpression )
            // InternalRtVil.g:2773:5: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForAccess().getExprExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_7=(Token)match(input,15,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getForAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalRtVil.g:2794:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2795:4: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2795:4: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:2796:5: lv_block_8_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
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
    // InternalRtVil.g:2817:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalRtVil.g:2817:46: (iv_ruleWhile= ruleWhile EOF )
            // InternalRtVil.g:2818:2: iv_ruleWhile= ruleWhile EOF
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
    // InternalRtVil.g:2824:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;

        EObject lv_block_4_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:2830:2: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2831:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2831:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2832:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:2840:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalRtVil.g:2841:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalRtVil.g:2841:4: (lv_expr_2_0= ruleExpression )
            // InternalRtVil.g:2842:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_3=(Token)match(input,15,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getWhileAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:2863:3: ( (lv_block_4_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2864:4: (lv_block_4_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2864:4: (lv_block_4_0= ruleRuleElementBlock )
            // InternalRtVil.g:2865:5: lv_block_4_0= ruleRuleElementBlock
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
              						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
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
    // InternalRtVil.g:2886:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalRtVil.g:2886:52: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalRtVil.g:2887:2: iv_ruleAlternative= ruleAlternative EOF
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
    // InternalRtVil.g:2893:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
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
            // InternalRtVil.g:2899:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // InternalRtVil.g:2900:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // InternalRtVil.g:2900:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // InternalRtVil.g:2901:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:2909:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalRtVil.g:2910:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalRtVil.g:2910:4: (lv_expr_2_0= ruleExpression )
            // InternalRtVil.g:2911:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_3=(Token)match(input,15,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:2932:3: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // InternalRtVil.g:2933:4: (lv_if_4_0= ruleStatementOrBlock )
            {
            // InternalRtVil.g:2933:4: (lv_if_4_0= ruleStatementOrBlock )
            // InternalRtVil.g:2934:5: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_47);
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

            // InternalRtVil.g:2951:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==42) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred75_InternalRtVil()) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalRtVil.g:2952:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // InternalRtVil.g:2952:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalRtVil.g:2953:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalRtVil.g:2959:4: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // InternalRtVil.g:2960:5: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // InternalRtVil.g:2960:5: (lv_else_6_0= ruleStatementOrBlock )
                    // InternalRtVil.g:2961:6: lv_else_6_0= ruleStatementOrBlock
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
    // InternalRtVil.g:2983:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // InternalRtVil.g:2983:57: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // InternalRtVil.g:2984:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
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
    // InternalRtVil.g:2990:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:2996:2: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2997:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2997:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalRtVil.g:2998:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:2998:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:2999:4: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:2999:4: (lv_exStmt_0_0= ruleExpressionStatement )
                    // InternalRtVil.g:3000:5: lv_exStmt_0_0= ruleExpressionStatement
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
                    // InternalRtVil.g:3018:3: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // InternalRtVil.g:3018:3: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // InternalRtVil.g:3019:4: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // InternalRtVil.g:3019:4: (lv_block_1_0= ruleRuleElementBlock )
                    // InternalRtVil.g:3020:5: lv_block_1_0= ruleRuleElementBlock
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
                      						"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
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
    // InternalRtVil.g:3041:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalRtVil.g:3041:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalRtVil.g:3042:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalRtVil.g:3048:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // InternalRtVil.g:3054:2: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // InternalRtVil.g:3055:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // InternalRtVil.g:3055:2: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // InternalRtVil.g:3056:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:3064:3: ( (lv_var1_2_0= ruleJoinVariable ) )
            // InternalRtVil.g:3065:4: (lv_var1_2_0= ruleJoinVariable )
            {
            // InternalRtVil.g:3065:4: (lv_var1_2_0= ruleJoinVariable )
            // InternalRtVil.g:3066:5: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_32);
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

            otherlv_3=(Token)match(input,28,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
              		
            }
            // InternalRtVil.g:3087:3: ( (lv_var2_4_0= ruleJoinVariable ) )
            // InternalRtVil.g:3088:4: (lv_var2_4_0= ruleJoinVariable )
            {
            // InternalRtVil.g:3088:4: (lv_var2_4_0= ruleJoinVariable )
            // InternalRtVil.g:3089:5: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_5=(Token)match(input,15,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalRtVil.g:3110:3: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // InternalRtVil.g:3111:4: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                      			
                    }
                    otherlv_7=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                      			
                    }
                    // InternalRtVil.g:3119:4: ( (lv_condition_8_0= ruleExpression ) )
                    // InternalRtVil.g:3120:5: (lv_condition_8_0= ruleExpression )
                    {
                    // InternalRtVil.g:3120:5: (lv_condition_8_0= ruleExpression )
                    // InternalRtVil.g:3121:6: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
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

                    otherlv_9=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3147:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // InternalRtVil.g:3147:53: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // InternalRtVil.g:3148:2: iv_ruleJoinVariable= ruleJoinVariable EOF
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
    // InternalRtVil.g:3154:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3160:2: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // InternalRtVil.g:3161:2: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:3161:2: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // InternalRtVil.g:3162:3: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // InternalRtVil.g:3162:3: ( (lv_excl_0_0= 'exclude' ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==44) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRtVil.g:3163:4: (lv_excl_0_0= 'exclude' )
                    {
                    // InternalRtVil.g:3163:4: (lv_excl_0_0= 'exclude' )
                    // InternalRtVil.g:3164:5: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,44,FOLLOW_7); if (state.failed) return current;
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

            // InternalRtVil.g:3176:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3177:4: (lv_var_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3177:4: (lv_var_1_0= ruleIdentifier )
            // InternalRtVil.g:3178:5: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
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

            otherlv_2=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
              		
            }
            // InternalRtVil.g:3199:3: ( (lv_expr_3_0= ruleExpression ) )
            // InternalRtVil.g:3200:4: (lv_expr_3_0= ruleExpression )
            {
            // InternalRtVil.g:3200:4: (lv_expr_3_0= ruleExpression )
            // InternalRtVil.g:3201:5: lv_expr_3_0= ruleExpression
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
    // InternalRtVil.g:3222:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // InternalRtVil.g:3222:56: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // InternalRtVil.g:3223:2: iv_ruleSystemExecution= ruleSystemExecution EOF
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
    // InternalRtVil.g:3229:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3235:2: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:3236:2: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:3236:2: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // InternalRtVil.g:3237:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,45,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
              		
            }
            // InternalRtVil.g:3241:3: ( (lv_call_1_0= ruleCall ) )
            // InternalRtVil.g:3242:4: (lv_call_1_0= ruleCall )
            {
            // InternalRtVil.g:3242:4: (lv_call_1_0= ruleCall )
            // InternalRtVil.g:3243:5: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            // InternalRtVil.g:3260:3: ( (lv_calls_2_0= ruleSubCall ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==36||(LA63_0>=75 && LA63_0<=76)) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalRtVil.g:3261:4: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:3261:4: (lv_calls_2_0= ruleSubCall )
            	    // InternalRtVil.g:3262:5: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalRtVil.g:3283:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalRtVil.g:3283:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalRtVil.g:3284:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalRtVil.g:3290:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // InternalRtVil.g:3296:2: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // InternalRtVil.g:3297:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // InternalRtVil.g:3297:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // InternalRtVil.g:3298:3: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // InternalRtVil.g:3298:3: ( (lv_const_0_0= 'const' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==46) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRtVil.g:3299:4: (lv_const_0_0= 'const' )
                    {
                    // InternalRtVil.g:3299:4: (lv_const_0_0= 'const' )
                    // InternalRtVil.g:3300:5: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,46,FOLLOW_40); if (state.failed) return current;
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

            // InternalRtVil.g:3312:3: ( (lv_type_1_0= ruleType ) )
            // InternalRtVil.g:3313:4: (lv_type_1_0= ruleType )
            {
            // InternalRtVil.g:3313:4: (lv_type_1_0= ruleType )
            // InternalRtVil.g:3314:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_7);
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

            // InternalRtVil.g:3331:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3332:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3332:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3333:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_50);
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

            // InternalRtVil.g:3350:3: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==21) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRtVil.g:3351:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalRtVil.g:3355:4: ( (lv_expression_4_0= ruleExpression ) )
                    // InternalRtVil.g:3356:5: (lv_expression_4_0= ruleExpression )
                    {
                    // InternalRtVil.g:3356:5: (lv_expression_4_0= ruleExpression )
                    // InternalRtVil.g:3357:6: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
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

            otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3383:1: entryRuleCompound returns [EObject current=null] : iv_ruleCompound= ruleCompound EOF ;
    public final EObject entryRuleCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompound = null;


        try {
            // InternalRtVil.g:3383:49: (iv_ruleCompound= ruleCompound EOF )
            // InternalRtVil.g:3384:2: iv_ruleCompound= ruleCompound EOF
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
    // InternalRtVil.g:3390:1: ruleCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) ;
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
            // InternalRtVil.g:3396:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) )
            // InternalRtVil.g:3397:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            {
            // InternalRtVil.g:3397:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            // InternalRtVil.g:3398:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )?
            {
            // InternalRtVil.g:3398:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==47) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRtVil.g:3399:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalRtVil.g:3399:4: (lv_abstract_0_0= 'abstract' )
                    // InternalRtVil.g:3400:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,47,FOLLOW_51); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,48,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundAccess().getCompoundKeyword_1());
              		
            }
            // InternalRtVil.g:3416:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3417:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3417:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3418:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCompoundAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_52);
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

            // InternalRtVil.g:3435:3: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==49) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRtVil.g:3436:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,49,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCompoundAccess().getRefinesKeyword_3_0());
                      			
                    }
                    // InternalRtVil.g:3440:4: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalRtVil.g:3441:5: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:3441:5: (lv_super_4_0= ruleIdentifier )
                    // InternalRtVil.g:3442:6: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
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

            otherlv_5=(Token)match(input,16,FOLLOW_53); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCompoundAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalRtVil.g:3464:3: ( (lv_vars_6_0= ruleVariableDeclaration ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_VERSION||(LA68_0>=RULE_ID && LA68_0<=RULE_EXPONENT)||(LA68_0>=34 && LA68_0<=35)||LA68_0==39||(LA68_0>=41 && LA68_0<=42)||LA68_0==46||LA68_0==52||(LA68_0>=83 && LA68_0<=88)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalRtVil.g:3465:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalRtVil.g:3465:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    // InternalRtVil.g:3466:5: lv_vars_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundAccess().getVarsVariableDeclarationParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_53);
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
            	    break loop68;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getCompoundAccess().getRightCurlyBracketKeyword_6());
              		
            }
            // InternalRtVil.g:3487:3: (otherlv_8= ';' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==18) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRtVil.g:3488:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3497:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalRtVil.g:3497:48: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalRtVil.g:3498:2: iv_ruleTypeDef= ruleTypeDef EOF
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
    // InternalRtVil.g:3504:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3510:2: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // InternalRtVil.g:3511:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // InternalRtVil.g:3511:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // InternalRtVil.g:3512:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
              		
            }
            // InternalRtVil.g:3516:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3517:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3517:4: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:3518:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalRtVil.g:3535:3: ( (lv_type_2_0= ruleType ) )
            // InternalRtVil.g:3536:4: (lv_type_2_0= ruleType )
            {
            // InternalRtVil.g:3536:4: (lv_type_2_0= ruleType )
            // InternalRtVil.g:3537:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
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

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3562:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalRtVil.g:3562:47: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalRtVil.g:3563:2: iv_ruleAdvice= ruleAdvice EOF
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
    // InternalRtVil.g:3569:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3575:2: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // InternalRtVil.g:3576:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // InternalRtVil.g:3576:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // InternalRtVil.g:3577:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:3585:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalRtVil.g:3586:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalRtVil.g:3586:4: (lv_name_2_0= ruleQualifiedName )
            // InternalRtVil.g:3587:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_10);
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

            otherlv_3=(Token)match(input,15,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalRtVil.g:3608:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==27) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRtVil.g:3609:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:3609:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalRtVil.g:3610:5: lv_versionSpec_4_0= ruleVersionSpec
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
    // InternalRtVil.g:3631:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // InternalRtVil.g:3631:52: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // InternalRtVil.g:3632:2: iv_ruleVersionSpec= ruleVersionSpec EOF
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
    // InternalRtVil.g:3638:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3644:2: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // InternalRtVil.g:3645:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:3645:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // InternalRtVil.g:3646:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
              		
            }
            // InternalRtVil.g:3650:3: ( (lv_restriction_1_0= ruleExpression ) )
            // InternalRtVil.g:3651:4: (lv_restriction_1_0= ruleExpression )
            {
            // InternalRtVil.g:3651:4: (lv_restriction_1_0= ruleExpression )
            // InternalRtVil.g:3652:5: lv_restriction_1_0= ruleExpression
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
    // InternalRtVil.g:3673:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRtVil.g:3673:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRtVil.g:3674:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRtVil.g:3680:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3686:2: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // InternalRtVil.g:3687:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // InternalRtVil.g:3687:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // InternalRtVil.g:3688:3: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // InternalRtVil.g:3688:3: ( (lv_param_0_0= ruleParameter ) )
            // InternalRtVil.g:3689:4: (lv_param_0_0= ruleParameter )
            {
            // InternalRtVil.g:3689:4: (lv_param_0_0= ruleParameter )
            // InternalRtVil.g:3690:5: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_42);
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

            // InternalRtVil.g:3707:3: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==28) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalRtVil.g:3708:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalRtVil.g:3712:4: ( (lv_param_2_0= ruleParameter ) )
            	    // InternalRtVil.g:3713:5: (lv_param_2_0= ruleParameter )
            	    {
            	    // InternalRtVil.g:3713:5: (lv_param_2_0= ruleParameter )
            	    // InternalRtVil.g:3714:6: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // InternalRtVil.g:3736:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRtVil.g:3736:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRtVil.g:3737:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRtVil.g:3743:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dflt_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3749:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) )
            // InternalRtVil.g:3750:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            {
            // InternalRtVil.g:3750:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            // InternalRtVil.g:3751:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            {
            // InternalRtVil.g:3751:3: ( (lv_type_0_0= ruleType ) )
            // InternalRtVil.g:3752:4: (lv_type_0_0= ruleType )
            {
            // InternalRtVil.g:3752:4: (lv_type_0_0= ruleType )
            // InternalRtVil.g:3753:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_7);
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

            // InternalRtVil.g:3770:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3771:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3771:4: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:3772:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_54);
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

            // InternalRtVil.g:3789:3: (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==21) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRtVil.g:3790:4: otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalRtVil.g:3794:4: ( (lv_dflt_3_0= ruleExpression ) )
                    // InternalRtVil.g:3795:5: (lv_dflt_3_0= ruleExpression )
                    {
                    // InternalRtVil.g:3795:5: (lv_dflt_3_0= ruleExpression )
                    // InternalRtVil.g:3796:6: lv_dflt_3_0= ruleExpression
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
    // InternalRtVil.g:3818:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalRtVil.g:3818:52: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalRtVil.g:3819:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalRtVil.g:3825:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRtVil.g:3831:2: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalRtVil.g:3832:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalRtVil.g:3832:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalRtVil.g:3833:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
              		
            }
            // InternalRtVil.g:3837:3: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalRtVil.g:3838:4: (lv_version_1_0= RULE_VERSION )
            {
            // InternalRtVil.g:3838:4: (lv_version_1_0= RULE_VERSION )
            // InternalRtVil.g:3839:5: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_22); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3863:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRtVil.g:3863:47: (iv_ruleImport= ruleImport EOF )
            // InternalRtVil.g:3864:2: iv_ruleImport= ruleImport EOF
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
    // InternalRtVil.g:3870:1: ruleImport returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) ;
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
            // InternalRtVil.g:3876:2: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) )
            // InternalRtVil.g:3877:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            {
            // InternalRtVil.g:3877:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            // InternalRtVil.g:3878:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';'
            {
            // InternalRtVil.g:3878:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==53) ) {
                alt73=1;
            }
            else if ( (LA73_0==54) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalRtVil.g:3879:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,53,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:3884:4: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalRtVil.g:3884:4: ( (lv_insert_1_0= 'insert' ) )
                    // InternalRtVil.g:3885:5: (lv_insert_1_0= 'insert' )
                    {
                    // InternalRtVil.g:3885:5: (lv_insert_1_0= 'insert' )
                    // InternalRtVil.g:3886:6: lv_insert_1_0= 'insert'
                    {
                    lv_insert_1_0=(Token)match(input,54,FOLLOW_7); if (state.failed) return current;
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

            // InternalRtVil.g:3899:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3900:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3900:4: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3901:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalRtVil.g:3918:3: ( (lv_wildcard_3_0= '*' ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==55) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRtVil.g:3919:4: (lv_wildcard_3_0= '*' )
                    {
                    // InternalRtVil.g:3919:4: (lv_wildcard_3_0= '*' )
                    // InternalRtVil.g:3920:5: lv_wildcard_3_0= '*'
                    {
                    lv_wildcard_3_0=(Token)match(input,55,FOLLOW_37); if (state.failed) return current;
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

            // InternalRtVil.g:3932:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==27) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRtVil.g:3933:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:3933:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalRtVil.g:3934:5: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_22);
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

            otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:3959:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalRtVil.g:3959:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalRtVil.g:3960:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalRtVil.g:3966:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:3972:2: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // InternalRtVil.g:3973:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // InternalRtVil.g:3973:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_STRING && LA76_0<=RULE_EXPONENT)||LA76_0==14||(LA76_0>=34 && LA76_0<=35)||(LA76_0>=37 && LA76_0<=39)||(LA76_0>=41 && LA76_0<=43)||LA76_0==45||LA76_0==52||LA76_0==69||(LA76_0>=71 && LA76_0<=74)||(LA76_0>=80 && LA76_0<=84)) ) {
                alt76=1;
            }
            else if ( (LA76_0==16) ) {
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
                    // InternalRtVil.g:3974:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // InternalRtVil.g:3974:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:3975:4: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:3975:4: (lv_expr_0_0= ruleLogicalExpression )
                    // InternalRtVil.g:3976:5: lv_expr_0_0= ruleLogicalExpression
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
                    // InternalRtVil.g:3994:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // InternalRtVil.g:3994:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // InternalRtVil.g:3995:4: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // InternalRtVil.g:3995:4: (lv_init_1_0= ruleContainerInitializer )
                    // InternalRtVil.g:3996:5: lv_init_1_0= ruleContainerInitializer
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
    // InternalRtVil.g:4017:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalRtVil.g:4017:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalRtVil.g:4018:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalRtVil.g:4024:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4030:2: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalRtVil.g:4031:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalRtVil.g:4031:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalRtVil.g:4032:3: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalRtVil.g:4032:3: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalRtVil.g:4033:4: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalRtVil.g:4033:4: (lv_left_0_0= ruleEqualityExpression )
            // InternalRtVil.g:4034:5: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_57);
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

            // InternalRtVil.g:4051:3: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop77:
            do {
                int alt77=2;
                switch ( input.LA(1) ) {
                case 56:
                    {
                    int LA77_2 = input.LA(2);

                    if ( (synpred93_InternalRtVil()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA77_3 = input.LA(2);

                    if ( (synpred93_InternalRtVil()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 58:
                    {
                    int LA77_4 = input.LA(2);

                    if ( (synpred93_InternalRtVil()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 59:
                    {
                    int LA77_5 = input.LA(2);

                    if ( (synpred93_InternalRtVil()) ) {
                        alt77=1;
                    }


                    }
                    break;
                case 60:
                    {
                    int LA77_6 = input.LA(2);

                    if ( (synpred93_InternalRtVil()) ) {
                        alt77=1;
                    }


                    }
                    break;

                }

                switch (alt77) {
            	case 1 :
            	    // InternalRtVil.g:4052:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalRtVil.g:4052:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalRtVil.g:4053:5: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_57);
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
            	    break loop77;
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
    // InternalRtVil.g:4074:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalRtVil.g:4074:62: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalRtVil.g:4075:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalRtVil.g:4081:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4087:2: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalRtVil.g:4088:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalRtVil.g:4088:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalRtVil.g:4089:3: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalRtVil.g:4089:3: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalRtVil.g:4090:4: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalRtVil.g:4090:4: (lv_op_0_0= ruleLogicalOperator )
            // InternalRtVil.g:4091:5: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4108:3: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalRtVil.g:4109:4: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalRtVil.g:4109:4: (lv_ex_1_0= ruleEqualityExpression )
            // InternalRtVil.g:4110:5: lv_ex_1_0= ruleEqualityExpression
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
    // InternalRtVil.g:4131:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalRtVil.g:4131:55: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalRtVil.g:4132:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalRtVil.g:4138:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4144:2: ( (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) )
            // InternalRtVil.g:4145:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            {
            // InternalRtVil.g:4145:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            int alt78=5;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt78=1;
                }
                break;
            case 57:
                {
                alt78=2;
                }
                break;
            case 58:
                {
                alt78=3;
                }
                break;
            case 59:
                {
                alt78=4;
                }
                break;
            case 60:
                {
                alt78=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalRtVil.g:4146:3: kw= 'and'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4152:3: kw= 'or'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4158:3: kw= 'xor'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRtVil.g:4164:3: kw= 'implies'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getImpliesKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRtVil.g:4170:3: kw= 'iff'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4179:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalRtVil.g:4179:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalRtVil.g:4180:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalRtVil.g:4186:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4192:2: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalRtVil.g:4193:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalRtVil.g:4193:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalRtVil.g:4194:3: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalRtVil.g:4194:3: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalRtVil.g:4195:4: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalRtVil.g:4195:4: (lv_left_0_0= ruleRelationalExpression )
            // InternalRtVil.g:4196:5: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_58);
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

            // InternalRtVil.g:4213:3: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt79=2;
            switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA79_1 = input.LA(2);

                    if ( (synpred98_InternalRtVil()) ) {
                        alt79=1;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA79_2 = input.LA(2);

                    if ( (synpred98_InternalRtVil()) ) {
                        alt79=1;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA79_3 = input.LA(2);

                    if ( (synpred98_InternalRtVil()) ) {
                        alt79=1;
                    }
                    }
                    break;
            }

            switch (alt79) {
                case 1 :
                    // InternalRtVil.g:4214:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalRtVil.g:4214:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalRtVil.g:4215:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalRtVil.g:4236:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalRtVil.g:4236:63: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalRtVil.g:4237:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalRtVil.g:4243:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4249:2: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // InternalRtVil.g:4250:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // InternalRtVil.g:4250:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // InternalRtVil.g:4251:3: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // InternalRtVil.g:4251:3: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalRtVil.g:4252:4: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalRtVil.g:4252:4: (lv_op_0_0= ruleEqualityOperator )
            // InternalRtVil.g:4253:5: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4270:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // InternalRtVil.g:4271:4: (lv_ex_1_0= ruleRelationalExpression )
            {
            // InternalRtVil.g:4271:4: (lv_ex_1_0= ruleRelationalExpression )
            // InternalRtVil.g:4272:5: lv_ex_1_0= ruleRelationalExpression
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
    // InternalRtVil.g:4293:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalRtVil.g:4293:56: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalRtVil.g:4294:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalRtVil.g:4300:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4306:2: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalRtVil.g:4307:2: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalRtVil.g:4307:2: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt80=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt80=1;
                }
                break;
            case 62:
                {
                alt80=2;
                }
                break;
            case 63:
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
                    // InternalRtVil.g:4308:3: kw= '=='
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4314:3: kw= '<>'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4320:3: kw= '!='
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4329:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalRtVil.g:4329:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalRtVil.g:4330:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalRtVil.g:4336:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4342:2: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalRtVil.g:4343:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalRtVil.g:4343:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalRtVil.g:4344:3: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalRtVil.g:4344:3: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalRtVil.g:4345:4: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalRtVil.g:4345:4: (lv_left_0_0= ruleAdditiveExpression )
            // InternalRtVil.g:4346:5: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalRtVil.g:4363:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt82=2;
            switch ( input.LA(1) ) {
                case 64:
                    {
                    int LA82_1 = input.LA(2);

                    if ( (synpred102_InternalRtVil()) ) {
                        alt82=1;
                    }
                    }
                    break;
                case 65:
                    {
                    int LA82_2 = input.LA(2);

                    if ( (synpred102_InternalRtVil()) ) {
                        alt82=1;
                    }
                    }
                    break;
                case 66:
                    {
                    int LA82_3 = input.LA(2);

                    if ( (synpred102_InternalRtVil()) ) {
                        alt82=1;
                    }
                    }
                    break;
                case 67:
                    {
                    int LA82_4 = input.LA(2);

                    if ( (synpred102_InternalRtVil()) ) {
                        alt82=1;
                    }
                    }
                    break;
            }

            switch (alt82) {
                case 1 :
                    // InternalRtVil.g:4364:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalRtVil.g:4364:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalRtVil.g:4365:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalRtVil.g:4365:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalRtVil.g:4366:6: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_59);
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

                    // InternalRtVil.g:4383:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt81=2;
                    switch ( input.LA(1) ) {
                        case 64:
                            {
                            int LA81_1 = input.LA(2);

                            if ( (synpred101_InternalRtVil()) ) {
                                alt81=1;
                            }
                            }
                            break;
                        case 65:
                            {
                            int LA81_2 = input.LA(2);

                            if ( (synpred101_InternalRtVil()) ) {
                                alt81=1;
                            }
                            }
                            break;
                        case 66:
                            {
                            int LA81_3 = input.LA(2);

                            if ( (synpred101_InternalRtVil()) ) {
                                alt81=1;
                            }
                            }
                            break;
                        case 67:
                            {
                            int LA81_4 = input.LA(2);

                            if ( (synpred101_InternalRtVil()) ) {
                                alt81=1;
                            }
                            }
                            break;
                    }

                    switch (alt81) {
                        case 1 :
                            // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalRtVil.g:4385:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // InternalRtVil.g:4407:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalRtVil.g:4407:65: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalRtVil.g:4408:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalRtVil.g:4414:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4420:2: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalRtVil.g:4421:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalRtVil.g:4421:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalRtVil.g:4422:3: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalRtVil.g:4422:3: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalRtVil.g:4423:4: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalRtVil.g:4423:4: (lv_op_0_0= ruleRelationalOperator )
            // InternalRtVil.g:4424:5: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4441:3: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalRtVil.g:4442:4: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalRtVil.g:4442:4: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalRtVil.g:4443:5: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalRtVil.g:4464:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalRtVil.g:4464:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalRtVil.g:4465:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalRtVil.g:4471:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4477:2: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalRtVil.g:4478:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalRtVil.g:4478:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt83=4;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt83=1;
                }
                break;
            case 65:
                {
                alt83=2;
                }
                break;
            case 66:
                {
                alt83=3;
                }
                break;
            case 67:
                {
                alt83=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalRtVil.g:4479:3: kw= '>'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4485:3: kw= '<'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4491:3: kw= '>='
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRtVil.g:4497:3: kw= '<='
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4506:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalRtVil.g:4506:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalRtVil.g:4507:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalRtVil.g:4513:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4519:2: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalRtVil.g:4520:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalRtVil.g:4520:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalRtVil.g:4521:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalRtVil.g:4521:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalRtVil.g:4522:4: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalRtVil.g:4522:4: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalRtVil.g:4523:5: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_60);
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

            // InternalRtVil.g:4540:3: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==68) ) {
                    int LA84_2 = input.LA(2);

                    if ( (synpred106_InternalRtVil()) ) {
                        alt84=1;
                    }


                }
                else if ( (LA84_0==69) ) {
                    int LA84_3 = input.LA(2);

                    if ( (synpred106_InternalRtVil()) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // InternalRtVil.g:4541:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalRtVil.g:4541:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalRtVil.g:4542:5: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_60);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // InternalRtVil.g:4563:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalRtVil.g:4563:63: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalRtVil.g:4564:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalRtVil.g:4570:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4576:2: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalRtVil.g:4577:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalRtVil.g:4577:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalRtVil.g:4578:3: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalRtVil.g:4578:3: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalRtVil.g:4579:4: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalRtVil.g:4579:4: (lv_op_0_0= ruleAdditiveOperator )
            // InternalRtVil.g:4580:5: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4597:3: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalRtVil.g:4598:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalRtVil.g:4598:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalRtVil.g:4599:5: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalRtVil.g:4620:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalRtVil.g:4620:56: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalRtVil.g:4621:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalRtVil.g:4627:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4633:2: ( (kw= '+' | kw= '-' ) )
            // InternalRtVil.g:4634:2: (kw= '+' | kw= '-' )
            {
            // InternalRtVil.g:4634:2: (kw= '+' | kw= '-' )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==68) ) {
                alt85=1;
            }
            else if ( (LA85_0==69) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalRtVil.g:4635:3: kw= '+'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4641:3: kw= '-'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4650:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalRtVil.g:4650:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalRtVil.g:4651:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalRtVil.g:4657:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4663:2: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalRtVil.g:4664:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalRtVil.g:4664:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalRtVil.g:4665:3: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalRtVil.g:4665:3: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalRtVil.g:4666:4: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalRtVil.g:4666:4: (lv_left_0_0= ruleUnaryExpression )
            // InternalRtVil.g:4667:5: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_61);
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

            // InternalRtVil.g:4684:3: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==55) ) {
                int LA86_1 = input.LA(2);

                if ( (synpred108_InternalRtVil()) ) {
                    alt86=1;
                }
            }
            else if ( (LA86_0==70) ) {
                int LA86_2 = input.LA(2);

                if ( (synpred108_InternalRtVil()) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // InternalRtVil.g:4685:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalRtVil.g:4685:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalRtVil.g:4686:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalRtVil.g:4707:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalRtVil.g:4707:69: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalRtVil.g:4708:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalRtVil.g:4714:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4720:2: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalRtVil.g:4721:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalRtVil.g:4721:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalRtVil.g:4722:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalRtVil.g:4722:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalRtVil.g:4723:4: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalRtVil.g:4723:4: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalRtVil.g:4724:5: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4741:3: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalRtVil.g:4742:4: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalRtVil.g:4742:4: (lv_expr_1_0= ruleUnaryExpression )
            // InternalRtVil.g:4743:5: lv_expr_1_0= ruleUnaryExpression
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
    // InternalRtVil.g:4764:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalRtVil.g:4764:62: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalRtVil.g:4765:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalRtVil.g:4771:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4777:2: ( (kw= '*' | kw= '/' ) )
            // InternalRtVil.g:4778:2: (kw= '*' | kw= '/' )
            {
            // InternalRtVil.g:4778:2: (kw= '*' | kw= '/' )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==55) ) {
                alt87=1;
            }
            else if ( (LA87_0==70) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalRtVil.g:4779:3: kw= '*'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4785:3: kw= '/'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4794:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalRtVil.g:4794:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalRtVil.g:4795:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalRtVil.g:4801:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4807:2: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalRtVil.g:4808:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalRtVil.g:4808:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalRtVil.g:4809:3: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalRtVil.g:4809:3: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==69||(LA88_0>=71 && LA88_0<=72)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRtVil.g:4810:4: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalRtVil.g:4810:4: (lv_op_0_0= ruleUnaryOperator )
                    // InternalRtVil.g:4811:5: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_29);
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

            // InternalRtVil.g:4828:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalRtVil.g:4829:4: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalRtVil.g:4829:4: (lv_expr_1_0= rulePostfixExpression )
            // InternalRtVil.g:4830:5: lv_expr_1_0= rulePostfixExpression
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
    // InternalRtVil.g:4851:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalRtVil.g:4851:53: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalRtVil.g:4852:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalRtVil.g:4858:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:4864:2: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // InternalRtVil.g:4865:2: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // InternalRtVil.g:4865:2: (kw= 'not' | kw= '!' | kw= '-' )
            int alt89=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt89=1;
                }
                break;
            case 72:
                {
                alt89=2;
                }
                break;
            case 69:
                {
                alt89=3;
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
                    // InternalRtVil.g:4866:3: kw= 'not'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4872:3: kw= '!'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4878:3: kw= '-'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:4887:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalRtVil.g:4887:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalRtVil.g:4888:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalRtVil.g:4894:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4900:2: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // InternalRtVil.g:4901:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // InternalRtVil.g:4901:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            // InternalRtVil.g:4902:3: (lv_left_0_0= rulePrimaryExpression )
            {
            // InternalRtVil.g:4902:3: (lv_left_0_0= rulePrimaryExpression )
            // InternalRtVil.g:4903:4: lv_left_0_0= rulePrimaryExpression
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
    // InternalRtVil.g:4923:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // InternalRtVil.g:4923:71: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // InternalRtVil.g:4924:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
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
    // InternalRtVil.g:4930:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:4936:2: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:4937:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:4937:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // InternalRtVil.g:4938:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // InternalRtVil.g:4938:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( ((LA90_0>=RULE_STRING && LA90_0<=RULE_EXPONENT)||(LA90_0>=34 && LA90_0<=35)||LA90_0==39||(LA90_0>=41 && LA90_0<=42)||LA90_0==52||(LA90_0>=80 && LA90_0<=84)) ) {
                alt90=1;
            }
            else if ( (LA90_0==14) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalRtVil.g:4939:4: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // InternalRtVil.g:4939:4: ( (lv_val_0_0= ruleConstant ) )
                    // InternalRtVil.g:4940:5: (lv_val_0_0= ruleConstant )
                    {
                    // InternalRtVil.g:4940:5: (lv_val_0_0= ruleConstant )
                    // InternalRtVil.g:4941:6: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_49);
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
                    // InternalRtVil.g:4959:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalRtVil.g:4959:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalRtVil.g:4960:5: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                      				
                    }
                    // InternalRtVil.g:4964:5: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // InternalRtVil.g:4965:6: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // InternalRtVil.g:4965:6: (lv_parenthesis_2_0= ruleExpression )
                    // InternalRtVil.g:4966:7: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_10);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:4989:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==36||(LA91_0>=75 && LA91_0<=76)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalRtVil.g:4990:4: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:4990:4: (lv_calls_4_0= ruleSubCall )
            	    // InternalRtVil.g:4991:5: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop91;
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
    // InternalRtVil.g:5012:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // InternalRtVil.g:5012:61: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // InternalRtVil.g:5013:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
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
    // InternalRtVil.g:5019:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5025:2: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:5026:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:5026:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // InternalRtVil.g:5027:3: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // InternalRtVil.g:5027:3: ( (lv_call_0_0= ruleCall ) )
            // InternalRtVil.g:5028:4: (lv_call_0_0= ruleCall )
            {
            // InternalRtVil.g:5028:4: (lv_call_0_0= ruleCall )
            // InternalRtVil.g:5029:5: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            // InternalRtVil.g:5046:3: ( (lv_calls_1_0= ruleSubCall ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==36||(LA92_0>=75 && LA92_0<=76)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalRtVil.g:5047:4: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:5047:4: (lv_calls_1_0= ruleSubCall )
            	    // InternalRtVil.g:5048:5: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop92;
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
    // InternalRtVil.g:5069:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // InternalRtVil.g:5069:55: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // InternalRtVil.g:5070:2: iv_ruleSuperExecution= ruleSuperExecution EOF
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
    // InternalRtVil.g:5076:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5082:2: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:5083:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:5083:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // InternalRtVil.g:5084:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,73,FOLLOW_62); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
              		
            }
            // InternalRtVil.g:5092:3: ( (lv_call_2_0= ruleCall ) )
            // InternalRtVil.g:5093:4: (lv_call_2_0= ruleCall )
            {
            // InternalRtVil.g:5093:4: (lv_call_2_0= ruleCall )
            // InternalRtVil.g:5094:5: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            // InternalRtVil.g:5111:3: ( (lv_calls_3_0= ruleSubCall ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==36||(LA93_0>=75 && LA93_0<=76)) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalRtVil.g:5112:4: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:5112:4: (lv_calls_3_0= ruleSubCall )
            	    // InternalRtVil.g:5113:5: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop93;
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
    // InternalRtVil.g:5134:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // InternalRtVil.g:5134:61: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // InternalRtVil.g:5135:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
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
    // InternalRtVil.g:5141:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // InternalRtVil.g:5147:2: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:5148:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:5148:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // InternalRtVil.g:5149:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,74,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
              		
            }
            // InternalRtVil.g:5153:3: ( (lv_type_1_0= ruleType ) )
            // InternalRtVil.g:5154:4: (lv_type_1_0= ruleType )
            {
            // InternalRtVil.g:5154:4: (lv_type_1_0= ruleType )
            // InternalRtVil.g:5155:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_2=(Token)match(input,14,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRtVil.g:5176:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=RULE_STRING && LA94_0<=RULE_EXPONENT)||LA94_0==14||LA94_0==16||(LA94_0>=34 && LA94_0<=35)||(LA94_0>=37 && LA94_0<=39)||(LA94_0>=41 && LA94_0<=43)||LA94_0==45||LA94_0==52||LA94_0==69||(LA94_0>=71 && LA94_0<=74)||(LA94_0>=80 && LA94_0<=84)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalRtVil.g:5177:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:5177:4: (lv_param_3_0= ruleArgumentList )
                    // InternalRtVil.g:5178:5: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
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

            otherlv_4=(Token)match(input,15,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalRtVil.g:5199:3: ( (lv_calls_5_0= ruleSubCall ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==36||(LA95_0>=75 && LA95_0<=76)) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalRtVil.g:5200:4: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:5200:4: (lv_calls_5_0= ruleSubCall )
            	    // InternalRtVil.g:5201:5: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop95;
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
    // InternalRtVil.g:5222:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // InternalRtVil.g:5222:48: (iv_ruleSubCall= ruleSubCall EOF )
            // InternalRtVil.g:5223:2: iv_ruleSubCall= ruleSubCall EOF
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
    // InternalRtVil.g:5229:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // InternalRtVil.g:5235:2: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // InternalRtVil.g:5236:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // InternalRtVil.g:5236:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==36||LA97_0==75) ) {
                alt97=1;
            }
            else if ( (LA97_0==76) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalRtVil.g:5237:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // InternalRtVil.g:5237:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // InternalRtVil.g:5238:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // InternalRtVil.g:5238:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // InternalRtVil.g:5239:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // InternalRtVil.g:5239:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // InternalRtVil.g:5240:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // InternalRtVil.g:5240:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==36) ) {
                        alt96=1;
                    }
                    else if ( (LA96_0==75) ) {
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
                            // InternalRtVil.g:5241:7: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
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
                            // InternalRtVil.g:5252:7: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,75,FOLLOW_7); if (state.failed) return current;
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

                    // InternalRtVil.g:5265:4: ( (lv_call_1_0= ruleCall ) )
                    // InternalRtVil.g:5266:5: (lv_call_1_0= ruleCall )
                    {
                    // InternalRtVil.g:5266:5: (lv_call_1_0= ruleCall )
                    // InternalRtVil.g:5267:6: lv_call_1_0= ruleCall
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
                    // InternalRtVil.g:5286:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalRtVil.g:5286:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalRtVil.g:5287:4: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalRtVil.g:5291:4: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // InternalRtVil.g:5292:5: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // InternalRtVil.g:5292:5: (lv_arrayEx_3_0= ruleExpression )
                    // InternalRtVil.g:5293:6: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_63);
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

                    otherlv_4=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:5319:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalRtVil.g:5319:51: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalRtVil.g:5320:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalRtVil.g:5326:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5332:2: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalRtVil.g:5333:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalRtVil.g:5333:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalRtVil.g:5334:3: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalRtVil.g:5334:3: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalRtVil.g:5335:4: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalRtVil.g:5335:4: (lv_decl_0_0= ruleDeclaration )
            // InternalRtVil.g:5336:5: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_64);
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

            // InternalRtVil.g:5353:3: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==18) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalRtVil.g:5354:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalRtVil.g:5358:4: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalRtVil.g:5359:5: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalRtVil.g:5359:5: (lv_decl_2_0= ruleDeclaration )
            	    // InternalRtVil.g:5360:6: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_64);
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
            	    break loop98;
                }
            } while (true);

            otherlv_3=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:5386:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalRtVil.g:5386:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalRtVil.g:5387:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalRtVil.g:5393:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5399:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // InternalRtVil.g:5400:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // InternalRtVil.g:5400:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // InternalRtVil.g:5401:3: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // InternalRtVil.g:5401:3: ( (lv_type_0_0= ruleType ) )?
            int alt99=2;
            alt99 = dfa99.predict(input);
            switch (alt99) {
                case 1 :
                    // InternalRtVil.g:5402:4: (lv_type_0_0= ruleType )
                    {
                    // InternalRtVil.g:5402:4: (lv_type_0_0= ruleType )
                    // InternalRtVil.g:5403:5: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_40);
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

            // InternalRtVil.g:5420:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // InternalRtVil.g:5421:4: (lv_units_1_0= ruleDeclarationUnit )
            {
            // InternalRtVil.g:5421:4: (lv_units_1_0= ruleDeclarationUnit )
            // InternalRtVil.g:5422:5: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_42);
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

            // InternalRtVil.g:5439:3: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==28) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // InternalRtVil.g:5440:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalRtVil.g:5444:4: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // InternalRtVil.g:5445:5: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // InternalRtVil.g:5445:5: (lv_units_3_0= ruleDeclarationUnit )
            	    // InternalRtVil.g:5446:6: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
            	    break loop100;
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
    // InternalRtVil.g:5468:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // InternalRtVil.g:5468:56: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // InternalRtVil.g:5469:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
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
    // InternalRtVil.g:5475:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5481:2: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // InternalRtVil.g:5482:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // InternalRtVil.g:5482:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // InternalRtVil.g:5483:3: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // InternalRtVil.g:5483:3: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalRtVil.g:5484:4: (lv_id_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:5484:4: (lv_id_0_0= ruleIdentifier )
            // InternalRtVil.g:5485:5: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_54);
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

            // InternalRtVil.g:5502:3: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==21) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalRtVil.g:5503:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalRtVil.g:5507:4: ( (lv_deflt_2_0= ruleExpression ) )
                    // InternalRtVil.g:5508:5: (lv_deflt_2_0= ruleExpression )
                    {
                    // InternalRtVil.g:5508:5: (lv_deflt_2_0= ruleExpression )
                    // InternalRtVil.g:5509:6: lv_deflt_2_0= ruleExpression
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
    // InternalRtVil.g:5531:1: entryRuleAnnotationDeclarations returns [EObject current=null] : iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF ;
    public final EObject entryRuleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationDeclarations = null;


        try {
            // InternalRtVil.g:5531:63: (iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF )
            // InternalRtVil.g:5532:2: iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF
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
    // InternalRtVil.g:5538:1: ruleAnnotationDeclarations returns [EObject current=null] : ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5544:2: ( ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) )
            // InternalRtVil.g:5545:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            {
            // InternalRtVil.g:5545:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            // InternalRtVil.g:5546:3: () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            {
            // InternalRtVil.g:5546:3: ()
            // InternalRtVil.g:5547:4: 
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

            // InternalRtVil.g:5556:3: (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==29) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // InternalRtVil.g:5557:4: otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAnnotationDeclarationsAccess().getCommercialAtKeyword_1_0());
            	      			
            	    }
            	    // InternalRtVil.g:5561:4: ( (lv_id_2_0= ruleIdentifier ) )
            	    // InternalRtVil.g:5562:5: (lv_id_2_0= ruleIdentifier )
            	    {
            	    // InternalRtVil.g:5562:5: (lv_id_2_0= ruleIdentifier )
            	    // InternalRtVil.g:5563:6: lv_id_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAnnotationDeclarationsAccess().getIdIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_65);
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
            	    break loop102;
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
    // InternalRtVil.g:5585:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalRtVil.g:5585:45: (iv_ruleCall= ruleCall EOF )
            // InternalRtVil.g:5586:2: iv_ruleCall= ruleCall EOF
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
    // InternalRtVil.g:5592:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5598:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // InternalRtVil.g:5599:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // InternalRtVil.g:5599:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // InternalRtVil.g:5600:3: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // InternalRtVil.g:5600:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:5601:4: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:5601:4: (lv_name_0_0= ruleQualifiedPrefix )
            // InternalRtVil.g:5602:5: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            otherlv_1=(Token)match(input,14,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRtVil.g:5623:3: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt103=2;
            alt103 = dfa103.predict(input);
            switch (alt103) {
                case 1 :
                    // InternalRtVil.g:5624:4: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalRtVil.g:5624:4: (lv_decl_2_0= ruleDeclarator )
                    // InternalRtVil.g:5625:5: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_30);
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

            // InternalRtVil.g:5642:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=RULE_STRING && LA104_0<=RULE_EXPONENT)||LA104_0==14||LA104_0==16||(LA104_0>=34 && LA104_0<=35)||(LA104_0>=37 && LA104_0<=39)||(LA104_0>=41 && LA104_0<=43)||LA104_0==45||LA104_0==52||LA104_0==69||(LA104_0>=71 && LA104_0<=74)||(LA104_0>=80 && LA104_0<=84)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalRtVil.g:5643:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:5643:4: (lv_param_3_0= ruleArgumentList )
                    // InternalRtVil.g:5644:5: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_10);
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

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:5669:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // InternalRtVil.g:5669:53: (iv_ruleArgumentList= ruleArgumentList EOF )
            // InternalRtVil.g:5670:2: iv_ruleArgumentList= ruleArgumentList EOF
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
    // InternalRtVil.g:5676:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5682:2: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // InternalRtVil.g:5683:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // InternalRtVil.g:5683:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // InternalRtVil.g:5684:3: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // InternalRtVil.g:5684:3: ( (lv_param_0_0= ruleNamedArgument ) )
            // InternalRtVil.g:5685:4: (lv_param_0_0= ruleNamedArgument )
            {
            // InternalRtVil.g:5685:4: (lv_param_0_0= ruleNamedArgument )
            // InternalRtVil.g:5686:5: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_42);
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

            // InternalRtVil.g:5703:3: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==28) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalRtVil.g:5704:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalRtVil.g:5708:4: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // InternalRtVil.g:5709:5: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // InternalRtVil.g:5709:5: (lv_param_2_0= ruleNamedArgument )
            	    // InternalRtVil.g:5710:6: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
            	    break loop105;
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
    // InternalRtVil.g:5732:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalRtVil.g:5732:54: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalRtVil.g:5733:2: iv_ruleNamedArgument= ruleNamedArgument EOF
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
    // InternalRtVil.g:5739:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5745:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // InternalRtVil.g:5746:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:5746:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // InternalRtVil.g:5747:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // InternalRtVil.g:5747:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt106=2;
            alt106 = dfa106.predict(input);
            switch (alt106) {
                case 1 :
                    // InternalRtVil.g:5748:4: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalRtVil.g:5748:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalRtVil.g:5749:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:5749:5: (lv_name_0_0= ruleIdentifier )
                    // InternalRtVil.g:5750:6: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_18);
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

                    otherlv_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalRtVil.g:5772:3: ( (lv_ex_2_0= ruleExpression ) )
            // InternalRtVil.g:5773:4: (lv_ex_2_0= ruleExpression )
            {
            // InternalRtVil.g:5773:4: (lv_ex_2_0= ruleExpression )
            // InternalRtVil.g:5774:5: lv_ex_2_0= ruleExpression
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
    // InternalRtVil.g:5795:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // InternalRtVil.g:5795:56: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // InternalRtVil.g:5796:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
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
    // InternalRtVil.g:5802:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5808:2: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalRtVil.g:5809:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalRtVil.g:5809:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalRtVil.g:5810:3: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalRtVil.g:5810:3: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalRtVil.g:5811:4: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:5811:4: (lv_qname_0_0= ruleIdentifier )
            // InternalRtVil.g:5812:5: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_67);
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

            // InternalRtVil.g:5829:3: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==79) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalRtVil.g:5830:4: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalRtVil.g:5830:4: ( (lv_qname_1_0= '::' ) )
            	    // InternalRtVil.g:5831:5: (lv_qname_1_0= '::' )
            	    {
            	    // InternalRtVil.g:5831:5: (lv_qname_1_0= '::' )
            	    // InternalRtVil.g:5832:6: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,79,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalRtVil.g:5844:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalRtVil.g:5845:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalRtVil.g:5845:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalRtVil.g:5846:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_67);
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
            	    break loop107;
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
    // InternalRtVil.g:5868:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalRtVil.g:5868:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRtVil.g:5869:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalRtVil.g:5875:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:5881:2: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalRtVil.g:5882:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalRtVil.g:5882:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalRtVil.g:5883:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalRtVil.g:5883:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:5884:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:5884:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            // InternalRtVil.g:5885:5: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_68);
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

            // InternalRtVil.g:5902:3: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop108:
            do {
                int alt108=2;
                alt108 = dfa108.predict(input);
                switch (alt108) {
            	case 1 :
            	    // InternalRtVil.g:5903:4: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalRtVil.g:5903:4: ( (lv_qname_1_0= '.' ) )
            	    // InternalRtVil.g:5904:5: (lv_qname_1_0= '.' )
            	    {
            	    // InternalRtVil.g:5904:5: (lv_qname_1_0= '.' )
            	    // InternalRtVil.g:5905:6: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
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

            	    // InternalRtVil.g:5917:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalRtVil.g:5918:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalRtVil.g:5918:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalRtVil.g:5919:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_68);
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
            	    break loop108;
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
    // InternalRtVil.g:5941:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalRtVil.g:5941:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalRtVil.g:5942:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalRtVil.g:5948:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // InternalRtVil.g:5954:2: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // InternalRtVil.g:5955:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // InternalRtVil.g:5955:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt110=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt110=1;
                }
                break;
            case RULE_STRING:
                {
                alt110=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 34:
            case 35:
            case 39:
            case 41:
            case 42:
            case 52:
            case 83:
            case 84:
                {
                alt110=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA110_4 = input.LA(2);

                if ( (synpred134_InternalRtVil()) ) {
                    alt110=3;
                }
                else if ( (synpred138_InternalRtVil()) ) {
                    alt110=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 110, 4, input);

                    throw nvae;
                }
                }
                break;
            case 80:
            case 81:
                {
                alt110=4;
                }
                break;
            case 82:
                {
                alt110=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // InternalRtVil.g:5956:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalRtVil.g:5956:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalRtVil.g:5957:4: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalRtVil.g:5957:4: (lv_nValue_0_0= ruleNumValue )
                    // InternalRtVil.g:5958:5: lv_nValue_0_0= ruleNumValue
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
                    // InternalRtVil.g:5976:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalRtVil.g:5976:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalRtVil.g:5977:4: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalRtVil.g:5977:4: (lv_sValue_1_0= RULE_STRING )
                    // InternalRtVil.g:5978:5: lv_sValue_1_0= RULE_STRING
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
                    // InternalRtVil.g:5995:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalRtVil.g:5995:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalRtVil.g:5996:4: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalRtVil.g:5996:4: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalRtVil.g:5997:5: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalRtVil.g:6015:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalRtVil.g:6015:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalRtVil.g:6016:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalRtVil.g:6016:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalRtVil.g:6017:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalRtVil.g:6017:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==80) ) {
                        alt109=1;
                    }
                    else if ( (LA109_0==81) ) {
                        alt109=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 109, 0, input);

                        throw nvae;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalRtVil.g:6018:6: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
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
                            // InternalRtVil.g:6029:6: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
                    // InternalRtVil.g:6043:3: ( (lv_null_4_0= 'null' ) )
                    {
                    // InternalRtVil.g:6043:3: ( (lv_null_4_0= 'null' ) )
                    // InternalRtVil.g:6044:4: (lv_null_4_0= 'null' )
                    {
                    // InternalRtVil.g:6044:4: (lv_null_4_0= 'null' )
                    // InternalRtVil.g:6045:5: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
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
                    // InternalRtVil.g:6058:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // InternalRtVil.g:6058:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // InternalRtVil.g:6059:4: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // InternalRtVil.g:6063:4: (lv_version_5_0= RULE_VERSION )
                    // InternalRtVil.g:6064:5: lv_version_5_0= RULE_VERSION
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
    // InternalRtVil.g:6084:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalRtVil.g:6084:49: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalRtVil.g:6085:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalRtVil.g:6091:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalRtVil.g:6097:2: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalRtVil.g:6098:2: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalRtVil.g:6098:2: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalRtVil.g:6099:3: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalRtVil.g:6099:3: (lv_val_0_0= RULE_NUMBER )
            // InternalRtVil.g:6100:4: lv_val_0_0= RULE_NUMBER
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
    // InternalRtVil.g:6119:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalRtVil.g:6119:50: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalRtVil.g:6120:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalRtVil.g:6126:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' | kw= 'for' | kw= 'protected' | kw= 'switch' | kw= 'if' | kw= 'else' | kw= 'extends' | kw= 'static' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRtVil.g:6132:2: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' | kw= 'for' | kw= 'protected' | kw= 'switch' | kw= 'if' | kw= 'else' | kw= 'extends' | kw= 'static' ) )
            // InternalRtVil.g:6133:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' | kw= 'for' | kw= 'protected' | kw= 'switch' | kw= 'if' | kw= 'else' | kw= 'extends' | kw= 'static' )
            {
            // InternalRtVil.g:6133:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' | kw= 'for' | kw= 'protected' | kw= 'switch' | kw= 'if' | kw= 'else' | kw= 'extends' | kw= 'static' )
            int alt111=11;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt111=1;
                }
                break;
            case RULE_VERSION:
                {
                alt111=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt111=3;
                }
                break;
            case 52:
                {
                alt111=4;
                }
                break;
            case 39:
                {
                alt111=5;
                }
                break;
            case 35:
                {
                alt111=6;
                }
                break;
            case 83:
                {
                alt111=7;
                }
                break;
            case 41:
                {
                alt111=8;
                }
                break;
            case 42:
                {
                alt111=9;
                }
                break;
            case 34:
                {
                alt111=10;
                }
                break;
            case 84:
                {
                alt111=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // InternalRtVil.g:6134:3: this_ID_0= RULE_ID
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
                    // InternalRtVil.g:6142:3: this_VERSION_1= RULE_VERSION
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
                    // InternalRtVil.g:6150:3: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalRtVil.g:6158:3: kw= 'version'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getVersionKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRtVil.g:6164:3: kw= 'for'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getForKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRtVil.g:6170:3: kw= 'protected'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getProtectedKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRtVil.g:6176:3: kw= 'switch'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getSwitchKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRtVil.g:6182:3: kw= 'if'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getIfKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRtVil.g:6188:3: kw= 'else'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getElseKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRtVil.g:6194:3: kw= 'extends'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getExtendsKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRtVil.g:6200:3: kw= 'static'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdentifierAccess().getStaticKeyword_10());
                      		
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
    // InternalRtVil.g:6209:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalRtVil.g:6209:45: (iv_ruleType= ruleType EOF )
            // InternalRtVil.g:6210:2: iv_ruleType= ruleType EOF
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
    // InternalRtVil.g:6216:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // InternalRtVil.g:6222:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // InternalRtVil.g:6223:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // InternalRtVil.g:6223:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt113=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 34:
            case 35:
            case 39:
            case 41:
            case 42:
            case 52:
            case 83:
            case 84:
                {
                alt113=1;
                }
                break;
            case 85:
                {
                alt113=2;
                }
                break;
            case 86:
                {
                alt113=3;
                }
                break;
            case 87:
                {
                alt113=4;
                }
                break;
            case 88:
                {
                alt113=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalRtVil.g:6224:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // InternalRtVil.g:6224:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // InternalRtVil.g:6225:4: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // InternalRtVil.g:6225:4: (lv_name_0_0= ruleQualifiedPrefix )
                    // InternalRtVil.g:6226:5: lv_name_0_0= ruleQualifiedPrefix
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
                    // InternalRtVil.g:6244:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6244:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6245:4: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6245:4: ( (lv_set_1_0= 'setOf' ) )
                    // InternalRtVil.g:6246:5: (lv_set_1_0= 'setOf' )
                    {
                    // InternalRtVil.g:6246:5: (lv_set_1_0= 'setOf' )
                    // InternalRtVil.g:6247:6: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,85,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6259:4: ( (lv_param_2_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6260:5: (lv_param_2_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6260:5: (lv_param_2_0= ruleTypeParameters )
                    // InternalRtVil.g:6261:6: lv_param_2_0= ruleTypeParameters
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
                    // InternalRtVil.g:6280:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6280:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6281:4: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6281:4: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // InternalRtVil.g:6282:5: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // InternalRtVil.g:6282:5: (lv_seq_3_0= 'sequenceOf' )
                    // InternalRtVil.g:6283:6: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,86,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6295:4: ( (lv_param_4_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6296:5: (lv_param_4_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6296:5: (lv_param_4_0= ruleTypeParameters )
                    // InternalRtVil.g:6297:6: lv_param_4_0= ruleTypeParameters
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
                    // InternalRtVil.g:6316:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6316:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6317:4: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6317:4: ( (lv_map_5_0= 'mapOf' ) )
                    // InternalRtVil.g:6318:5: (lv_map_5_0= 'mapOf' )
                    {
                    // InternalRtVil.g:6318:5: (lv_map_5_0= 'mapOf' )
                    // InternalRtVil.g:6319:6: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,87,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6331:4: ( (lv_param_6_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6332:5: (lv_param_6_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6332:5: (lv_param_6_0= ruleTypeParameters )
                    // InternalRtVil.g:6333:6: lv_param_6_0= ruleTypeParameters
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
                    // InternalRtVil.g:6352:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6352:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6353:4: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6353:4: ( (lv_call_7_0= 'callOf' ) )
                    // InternalRtVil.g:6354:5: (lv_call_7_0= 'callOf' )
                    {
                    // InternalRtVil.g:6354:5: (lv_call_7_0= 'callOf' )
                    // InternalRtVil.g:6355:6: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,88,FOLLOW_69); if (state.failed) return current;
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

                    // InternalRtVil.g:6367:4: ( (lv_return_8_0= ruleType ) )?
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==RULE_VERSION||(LA112_0>=RULE_ID && LA112_0<=RULE_EXPONENT)||(LA112_0>=34 && LA112_0<=35)||LA112_0==39||(LA112_0>=41 && LA112_0<=42)||LA112_0==52||(LA112_0>=83 && LA112_0<=88)) ) {
                        alt112=1;
                    }
                    switch (alt112) {
                        case 1 :
                            // InternalRtVil.g:6368:5: (lv_return_8_0= ruleType )
                            {
                            // InternalRtVil.g:6368:5: (lv_return_8_0= ruleType )
                            // InternalRtVil.g:6369:6: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0());
                              					
                            }
                            pushFollow(FOLLOW_8);
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

                    // InternalRtVil.g:6386:4: ( (lv_param_9_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6387:5: (lv_param_9_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6387:5: (lv_param_9_0= ruleTypeParameters )
                    // InternalRtVil.g:6388:6: lv_param_9_0= ruleTypeParameters
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
    // InternalRtVil.g:6410:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // InternalRtVil.g:6410:55: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // InternalRtVil.g:6411:2: iv_ruleTypeParameters= ruleTypeParameters EOF
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
    // InternalRtVil.g:6417:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:6423:2: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // InternalRtVil.g:6424:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // InternalRtVil.g:6424:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // InternalRtVil.g:6425:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalRtVil.g:6429:3: ( (lv_param_1_0= ruleType ) )
            // InternalRtVil.g:6430:4: (lv_param_1_0= ruleType )
            {
            // InternalRtVil.g:6430:4: (lv_param_1_0= ruleType )
            // InternalRtVil.g:6431:5: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_70);
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

            // InternalRtVil.g:6448:3: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==28) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // InternalRtVil.g:6449:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_40); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalRtVil.g:6453:4: ( (lv_param_3_0= ruleType ) )
            	    // InternalRtVil.g:6454:5: (lv_param_3_0= ruleType )
            	    {
            	    // InternalRtVil.g:6454:5: (lv_param_3_0= ruleType )
            	    // InternalRtVil.g:6455:6: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_70);
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
            	    break loop114;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:6481:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalRtVil.g:6481:61: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalRtVil.g:6482:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalRtVil.g:6488:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:6494:2: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // InternalRtVil.g:6495:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // InternalRtVil.g:6495:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // InternalRtVil.g:6496:3: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // InternalRtVil.g:6496:3: ()
            // InternalRtVil.g:6497:4: 
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

            otherlv_1=(Token)match(input,16,FOLLOW_71); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalRtVil.g:6510:3: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( ((LA116_0>=RULE_STRING && LA116_0<=RULE_EXPONENT)||LA116_0==14||LA116_0==16||(LA116_0>=34 && LA116_0<=35)||(LA116_0>=37 && LA116_0<=39)||(LA116_0>=41 && LA116_0<=43)||LA116_0==45||LA116_0==52||LA116_0==69||(LA116_0>=71 && LA116_0<=74)||(LA116_0>=80 && LA116_0<=84)) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalRtVil.g:6511:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // InternalRtVil.g:6511:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // InternalRtVil.g:6512:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // InternalRtVil.g:6512:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // InternalRtVil.g:6513:6: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_72);
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

                    // InternalRtVil.g:6530:4: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==28) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalRtVil.g:6531:5: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalRtVil.g:6535:5: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // InternalRtVil.g:6536:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // InternalRtVil.g:6536:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // InternalRtVil.g:6537:7: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_72);
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
                    	    break loop115;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:6564:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // InternalRtVil.g:6564:71: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // InternalRtVil.g:6565:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
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
    // InternalRtVil.g:6571:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;



        	enterRule();

        try {
            // InternalRtVil.g:6577:2: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // InternalRtVil.g:6578:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // InternalRtVil.g:6578:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( ((LA117_0>=RULE_STRING && LA117_0<=RULE_EXPONENT)||LA117_0==14||(LA117_0>=34 && LA117_0<=35)||(LA117_0>=37 && LA117_0<=39)||(LA117_0>=41 && LA117_0<=43)||LA117_0==45||LA117_0==52||LA117_0==69||(LA117_0>=71 && LA117_0<=74)||(LA117_0>=80 && LA117_0<=84)) ) {
                alt117=1;
            }
            else if ( (LA117_0==16) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // InternalRtVil.g:6579:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // InternalRtVil.g:6579:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:6580:4: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:6580:4: (lv_logical_0_0= ruleLogicalExpression )
                    // InternalRtVil.g:6581:5: lv_logical_0_0= ruleLogicalExpression
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
                    // InternalRtVil.g:6599:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // InternalRtVil.g:6599:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // InternalRtVil.g:6600:4: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // InternalRtVil.g:6600:4: (lv_container_1_0= ruleContainerInitializer )
                    // InternalRtVil.g:6601:5: lv_container_1_0= ruleContainerInitializer
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

    // $ANTLR start synpred7_InternalRtVil
    public final void synpred7_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_version_8_0 = null;


        // InternalRtVil.g:264:4: ( (lv_version_8_0= ruleVersionStmt ) )
        // InternalRtVil.g:264:4: (lv_version_8_0= ruleVersionStmt )
        {
        // InternalRtVil.g:264:4: (lv_version_8_0= ruleVersionStmt )
        // InternalRtVil.g:265:5: lv_version_8_0= ruleVersionStmt
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
    // $ANTLR end synpred7_InternalRtVil

    // $ANTLR start synpred9_InternalRtVil
    public final void synpred9_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_elements_1_0 = null;


        // InternalRtVil.g:341:4: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) )
        // InternalRtVil.g:341:4: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
        {
        // InternalRtVil.g:341:4: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
        // InternalRtVil.g:342:5: (lv_elements_1_0= ruleGlobalVariableDeclaration )
        {
        // InternalRtVil.g:342:5: (lv_elements_1_0= ruleGlobalVariableDeclaration )
        // InternalRtVil.g:343:6: lv_elements_1_0= ruleGlobalVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsGlobalVariableDeclarationParserRuleCall_1_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_1_0=ruleGlobalVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred9_InternalRtVil

    // $ANTLR start synpred10_InternalRtVil
    public final void synpred10_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_elements_2_0 = null;


        // InternalRtVil.g:361:4: ( ( (lv_elements_2_0= ruleRuleDeclaration ) ) )
        // InternalRtVil.g:361:4: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        {
        // InternalRtVil.g:361:4: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        // InternalRtVil.g:362:5: (lv_elements_2_0= ruleRuleDeclaration )
        {
        // InternalRtVil.g:362:5: (lv_elements_2_0= ruleRuleDeclaration )
        // InternalRtVil.g:363:6: lv_elements_2_0= ruleRuleDeclaration
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRtContentsAccess().getElementsRuleDeclarationParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_elements_2_0=ruleRuleDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalRtVil

    // $ANTLR start synpred36_InternalRtVil
    public final void synpred36_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_varDecl_0_0 = null;


        // InternalRtVil.g:1393:3: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) )
        // InternalRtVil.g:1393:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
        {
        // InternalRtVil.g:1393:3: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
        // InternalRtVil.g:1394:4: (lv_varDecl_0_0= ruleVariableDeclaration )
        {
        // InternalRtVil.g:1394:4: (lv_varDecl_0_0= ruleVariableDeclaration )
        // InternalRtVil.g:1395:5: lv_varDecl_0_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getRuleElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_varDecl_0_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred36_InternalRtVil

    // $ANTLR start synpred37_InternalRtVil
    public final void synpred37_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_exprStmt_1_0 = null;


        // InternalRtVil.g:1413:3: ( ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
        // InternalRtVil.g:1413:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
        {
        // InternalRtVil.g:1413:3: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
        // InternalRtVil.g:1414:4: (lv_exprStmt_1_0= ruleExpressionStatement )
        {
        // InternalRtVil.g:1414:4: (lv_exprStmt_1_0= ruleExpressionStatement )
        // InternalRtVil.g:1415:5: lv_exprStmt_1_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getRuleElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_exprStmt_1_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred37_InternalRtVil

    // $ANTLR start synpred41_InternalRtVil
    public final void synpred41_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_for_4_0 = null;


        // InternalRtVil.g:1461:3: ( ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) )
        // InternalRtVil.g:1461:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
        {
        // InternalRtVil.g:1461:3: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
        // InternalRtVil.g:1462:4: ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )?
        {
        // InternalRtVil.g:1462:4: ( (lv_for_4_0= ruleFor ) )
        // InternalRtVil.g:1463:5: (lv_for_4_0= ruleFor )
        {
        // InternalRtVil.g:1463:5: (lv_for_4_0= ruleFor )
        // InternalRtVil.g:1464:6: lv_for_4_0= ruleFor
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRuleElementAccess().getForForParserRuleCall_3_0_0());
          					
        }
        pushFollow(FOLLOW_15);
        lv_for_4_0=ruleFor();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalRtVil.g:1481:4: (otherlv_5= ';' )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==18) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // InternalRtVil.g:1482:5: otherlv_5= ';'
                {
                otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred41_InternalRtVil

    // $ANTLR start synpred45_InternalRtVil
    public final void synpred45_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_annotations_1_0 = null;


        // InternalRtVil.g:1787:5: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )
        // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
        {
        // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
        // InternalRtVil.g:1788:6: lv_annotations_1_0= ruleAnnotationDeclarations
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
    // $ANTLR end synpred45_InternalRtVil

    // $ANTLR start synpred46_InternalRtVil
    public final void synpred46_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_modifier_2_0 = null;


        // InternalRtVil.g:1806:5: ( (lv_modifier_2_0= ruleRuleModifier ) )
        // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
        {
        // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
        // InternalRtVil.g:1807:6: lv_modifier_2_0= ruleRuleModifier
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_modifier_2_0=ruleRuleModifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred46_InternalRtVil

    // $ANTLR start synpred49_InternalRtVil
    public final void synpred49_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_modifier_2_0 = null;

        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_paramList_6_0 = null;


        // InternalRtVil.g:1786:4: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )
        // InternalRtVil.g:1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '='
        {
        // InternalRtVil.g:1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?
        int alt122=2;
        alt122 = dfa122.predict(input);
        switch (alt122) {
            case 1 :
                // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                {
                // InternalRtVil.g:1787:5: (lv_annotations_1_0= ruleAnnotationDeclarations )
                // InternalRtVil.g:1788:6: lv_annotations_1_0= ruleAnnotationDeclarations
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_1_0_0());
                  					
                }
                pushFollow(FOLLOW_40);
                lv_annotations_1_0=ruleAnnotationDeclarations();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalRtVil.g:1805:4: ( (lv_modifier_2_0= ruleRuleModifier ) )?
        int alt123=2;
        int LA123_0 = input.LA(1);

        if ( (LA123_0==35) ) {
            int LA123_1 = input.LA(2);

            if ( (synpred46_InternalRtVil()) ) {
                alt123=1;
            }
        }
        switch (alt123) {
            case 1 :
                // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
                {
                // InternalRtVil.g:1806:5: (lv_modifier_2_0= ruleRuleModifier )
                // InternalRtVil.g:1807:6: lv_modifier_2_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0());
                  					
                }
                pushFollow(FOLLOW_40);
                lv_modifier_2_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalRtVil.g:1824:4: ( (lv_type_3_0= ruleType ) )?
        int alt124=2;
        alt124 = dfa124.predict(input);
        switch (alt124) {
            case 1 :
                // InternalRtVil.g:1825:5: (lv_type_3_0= ruleType )
                {
                // InternalRtVil.g:1825:5: (lv_type_3_0= ruleType )
                // InternalRtVil.g:1826:6: lv_type_3_0= ruleType
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_2_0());
                  					
                }
                pushFollow(FOLLOW_7);
                lv_type_3_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalRtVil.g:1843:4: ( (lv_name_4_0= ruleIdentifier ) )
        // InternalRtVil.g:1844:5: (lv_name_4_0= ruleIdentifier )
        {
        // InternalRtVil.g:1844:5: (lv_name_4_0= ruleIdentifier )
        // InternalRtVil.g:1845:6: lv_name_4_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_3_0());
          					
        }
        pushFollow(FOLLOW_8);
        lv_name_4_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,14,FOLLOW_9); if (state.failed) return ;
        // InternalRtVil.g:1866:4: ( (lv_paramList_6_0= ruleParameterList ) )?
        int alt125=2;
        int LA125_0 = input.LA(1);

        if ( (LA125_0==RULE_VERSION||(LA125_0>=RULE_ID && LA125_0<=RULE_EXPONENT)||(LA125_0>=34 && LA125_0<=35)||LA125_0==39||(LA125_0>=41 && LA125_0<=42)||LA125_0==52||(LA125_0>=83 && LA125_0<=88)) ) {
            alt125=1;
        }
        switch (alt125) {
            case 1 :
                // InternalRtVil.g:1867:5: (lv_paramList_6_0= ruleParameterList )
                {
                // InternalRtVil.g:1867:5: (lv_paramList_6_0= ruleParameterList )
                // InternalRtVil.g:1868:6: lv_paramList_6_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {

                  						newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_5_0());
                  					
                }
                pushFollow(FOLLOW_10);
                lv_paramList_6_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_7=(Token)match(input,15,FOLLOW_18); if (state.failed) return ;
        otherlv_8=(Token)match(input,21,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred49_InternalRtVil

    // $ANTLR start synpred57_InternalRtVil
    public final void synpred57_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        AntlrDatatypeRuleToken lv_field_2_0 = null;

        EObject lv_expr_4_0 = null;


        // InternalRtVil.g:2086:3: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) )
        // InternalRtVil.g:2086:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
        {
        // InternalRtVil.g:2086:3: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
        // InternalRtVil.g:2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
        {
        // InternalRtVil.g:2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
        int alt129=2;
        alt129 = dfa129.predict(input);
        switch (alt129) {
            case 1 :
                // InternalRtVil.g:2088:5: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                {
                // InternalRtVil.g:2088:5: ( (lv_var_0_0= ruleIdentifier ) )
                // InternalRtVil.g:2089:6: (lv_var_0_0= ruleIdentifier )
                {
                // InternalRtVil.g:2089:6: (lv_var_0_0= ruleIdentifier )
                // InternalRtVil.g:2090:7: lv_var_0_0= ruleIdentifier
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0());
                  						
                }
                pushFollow(FOLLOW_43);
                lv_var_0_0=ruleIdentifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalRtVil.g:2107:5: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==36) ) {
                    alt128=1;
                }
                switch (alt128) {
                    case 1 :
                        // InternalRtVil.g:2108:6: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                        {
                        otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return ;
                        // InternalRtVil.g:2112:6: ( (lv_field_2_0= ruleIdentifier ) )
                        // InternalRtVil.g:2113:7: (lv_field_2_0= ruleIdentifier )
                        {
                        // InternalRtVil.g:2113:7: (lv_field_2_0= ruleIdentifier )
                        // InternalRtVil.g:2114:8: lv_field_2_0= ruleIdentifier
                        {
                        if ( state.backtracking==0 ) {

                          								newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_0_1_1_0());
                          							
                        }
                        pushFollow(FOLLOW_18);
                        lv_field_2_0=ruleIdentifier();

                        state._fsp--;
                        if (state.failed) return ;

                        }


                        }


                        }
                        break;

                }

                otherlv_3=(Token)match(input,21,FOLLOW_21); if (state.failed) return ;

                }
                break;

        }

        // InternalRtVil.g:2137:4: ( (lv_expr_4_0= ruleExpression ) )
        // InternalRtVil.g:2138:5: (lv_expr_4_0= ruleExpression )
        {
        // InternalRtVil.g:2138:5: (lv_expr_4_0= ruleExpression )
        // InternalRtVil.g:2139:6: lv_expr_4_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_1_0());
          					
        }
        pushFollow(FOLLOW_22);
        lv_expr_4_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred57_InternalRtVil

    // $ANTLR start synpred58_InternalRtVil
    public final void synpred58_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // InternalRtVil.g:2183:5: (otherlv_7= ';' )
        // InternalRtVil.g:2183:5: otherlv_7= ';'
        {
        otherlv_7=(Token)match(input,18,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalRtVil

    // $ANTLR start synpred68_InternalRtVil
    public final void synpred68_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_versionSpec_6_0 = null;


        // InternalRtVil.g:2458:4: ( (lv_versionSpec_6_0= ruleVersionSpec ) )
        // InternalRtVil.g:2458:4: (lv_versionSpec_6_0= ruleVersionSpec )
        {
        // InternalRtVil.g:2458:4: (lv_versionSpec_6_0= ruleVersionSpec )
        // InternalRtVil.g:2459:5: lv_versionSpec_6_0= ruleVersionSpec
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getInstantiateAccess().getVersionSpecVersionSpecParserRuleCall_5_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_versionSpec_6_0=ruleVersionSpec();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred68_InternalRtVil

    // $ANTLR start synpred75_InternalRtVil
    public final void synpred75_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // InternalRtVil.g:2952:4: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // InternalRtVil.g:2952:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // InternalRtVil.g:2952:4: ( ( 'else' )=>otherlv_5= 'else' )
        // InternalRtVil.g:2953:5: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,42,FOLLOW_34); if (state.failed) return ;

        }

        // InternalRtVil.g:2959:4: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // InternalRtVil.g:2960:5: (lv_else_6_0= ruleStatementOrBlock )
        {
        // InternalRtVil.g:2960:5: (lv_else_6_0= ruleStatementOrBlock )
        // InternalRtVil.g:2961:6: lv_else_6_0= ruleStatementOrBlock
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
    // $ANTLR end synpred75_InternalRtVil

    // $ANTLR start synpred76_InternalRtVil
    public final void synpred76_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // InternalRtVil.g:2998:3: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // InternalRtVil.g:2998:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // InternalRtVil.g:2998:3: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // InternalRtVil.g:2999:4: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // InternalRtVil.g:2999:4: (lv_exStmt_0_0= ruleExpressionStatement )
        // InternalRtVil.g:3000:5: lv_exStmt_0_0= ruleExpressionStatement
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
    // $ANTLR end synpred76_InternalRtVil

    // $ANTLR start synpred77_InternalRtVil
    public final void synpred77_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condition_8_0 = null;


        // InternalRtVil.g:3111:4: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )
        // InternalRtVil.g:3111:4: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
        {
        otherlv_6=(Token)match(input,27,FOLLOW_8); if (state.failed) return ;
        otherlv_7=(Token)match(input,14,FOLLOW_21); if (state.failed) return ;
        // InternalRtVil.g:3119:4: ( (lv_condition_8_0= ruleExpression ) )
        // InternalRtVil.g:3120:5: (lv_condition_8_0= ruleExpression )
        {
        // InternalRtVil.g:3120:5: (lv_condition_8_0= ruleExpression )
        // InternalRtVil.g:3121:6: lv_condition_8_0= ruleExpression
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0());
          					
        }
        pushFollow(FOLLOW_10);
        lv_condition_8_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_9=(Token)match(input,15,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_InternalRtVil

    // $ANTLR start synpred93_InternalRtVil
    public final void synpred93_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4052:4: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // InternalRtVil.g:4052:4: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // InternalRtVil.g:4052:4: (lv_right_1_0= ruleLogicalExpressionPart )
        // InternalRtVil.g:4053:5: lv_right_1_0= ruleLogicalExpressionPart
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
    // $ANTLR end synpred93_InternalRtVil

    // $ANTLR start synpred98_InternalRtVil
    public final void synpred98_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4214:4: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // InternalRtVil.g:4214:4: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // InternalRtVil.g:4214:4: (lv_right_1_0= ruleEqualityExpressionPart )
        // InternalRtVil.g:4215:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // $ANTLR end synpred98_InternalRtVil

    // $ANTLR start synpred101_InternalRtVil
    public final void synpred101_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right2_2_0 = null;


        // InternalRtVil.g:4384:5: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )
        // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
        {
        // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
        // InternalRtVil.g:4385:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred101_InternalRtVil

    // $ANTLR start synpred102_InternalRtVil
    public final void synpred102_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


        // InternalRtVil.g:4364:4: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )
        // InternalRtVil.g:4364:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        {
        // InternalRtVil.g:4364:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // InternalRtVil.g:4365:5: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // InternalRtVil.g:4365:5: (lv_right_1_0= ruleRelationalExpressionPart )
        // InternalRtVil.g:4366:6: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0());
          					
        }
        pushFollow(FOLLOW_59);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalRtVil.g:4383:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( ((LA130_0>=64 && LA130_0<=67)) ) {
            alt130=1;
        }
        switch (alt130) {
            case 1 :
                // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                {
                // InternalRtVil.g:4384:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                // InternalRtVil.g:4385:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred102_InternalRtVil

    // $ANTLR start synpred106_InternalRtVil
    public final void synpred106_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4541:4: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // InternalRtVil.g:4541:4: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // InternalRtVil.g:4541:4: (lv_right_1_0= ruleAdditiveExpressionPart )
        // InternalRtVil.g:4542:5: lv_right_1_0= ruleAdditiveExpressionPart
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
    // $ANTLR end synpred106_InternalRtVil

    // $ANTLR start synpred108_InternalRtVil
    public final void synpred108_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4685:4: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // InternalRtVil.g:4685:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // InternalRtVil.g:4685:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // InternalRtVil.g:4686:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // $ANTLR end synpred108_InternalRtVil

    // $ANTLR start synpred126_InternalRtVil
    public final void synpred126_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalRtVil.g:5624:4: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalRtVil.g:5624:4: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalRtVil.g:5624:4: (lv_decl_2_0= ruleDeclarator )
        // InternalRtVil.g:5625:5: lv_decl_2_0= ruleDeclarator
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
    // $ANTLR end synpred126_InternalRtVil

    // $ANTLR start synpred134_InternalRtVil
    public final void synpred134_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalRtVil.g:5995:3: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalRtVil.g:5995:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalRtVil.g:5995:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalRtVil.g:5996:4: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalRtVil.g:5996:4: (lv_qValue_2_0= ruleQualifiedName )
        // InternalRtVil.g:5997:5: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred134_InternalRtVil

    // $ANTLR start synpred138_InternalRtVil
    public final void synpred138_InternalRtVil_fragment() throws RecognitionException {   
        // InternalRtVil.g:6059:4: ( ( RULE_VERSION ) )
        // InternalRtVil.g:6059:5: ( RULE_VERSION )
        {
        // InternalRtVil.g:6059:5: ( RULE_VERSION )
        // InternalRtVil.g:6060:5: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred138_InternalRtVil

    // Delegated rules

    public final boolean synpred68_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA99 dfa99 = new DFA99(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA106 dfa106 = new DFA106(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA122 dfa122 = new DFA122(this);
    protected DFA124 dfa124 = new DFA124(this);
    protected DFA129 dfa129 = new DFA129(this);
    static final String dfa_1s = "\53\uffff";
    static final String dfa_2s = "\1\1\52\uffff";
    static final String dfa_3s = "\1\4\4\uffff\17\0\27\uffff";
    static final String dfa_4s = "\1\130\4\uffff\17\0\27\uffff";
    static final String dfa_5s = "\1\uffff\1\7\1\uffff\1\1\20\uffff\1\2\21\uffff\1\3\1\4\1\5\1\6\1\uffff";
    static final String dfa_6s = "\5\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\27\uffff}>";
    static final String[] dfa_7s = {
            "\1\24\1\6\1\24\1\5\1\7\5\uffff\1\24\1\uffff\1\24\1\1\1\uffff\1\3\1\46\4\uffff\1\24\1\47\2\uffff\1\24\4\uffff\1\16\1\12\1\uffff\2\24\1\11\1\uffff\1\14\1\15\1\24\1\uffff\1\24\1\3\2\51\1\uffff\1\50\1\uffff\1\10\20\uffff\1\24\1\uffff\4\24\5\uffff\3\24\1\13\1\17\1\20\1\21\1\22\1\23",
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
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 340:3: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_5 = input.LA(1);

                         
                        int index9_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_10 = input.LA(1);

                         
                        int index9_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_11 = input.LA(1);

                         
                        int index9_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_12 = input.LA(1);

                         
                        int index9_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA9_13 = input.LA(1);

                         
                        int index9_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_13);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA9_14 = input.LA(1);

                         
                        int index9_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_14);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA9_15 = input.LA(1);

                         
                        int index9_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_15);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA9_16 = input.LA(1);

                         
                        int index9_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_16);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA9_17 = input.LA(1);

                         
                        int index9_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_17);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA9_18 = input.LA(1);

                         
                        int index9_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_18);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA9_19 = input.LA(1);

                         
                        int index9_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 20;}

                         
                        input.seek(index9_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\33\uffff";
    static final String dfa_9s = "\1\4\1\uffff\13\5\2\uffff\14\5";
    static final String dfa_10s = "\1\130\1\uffff\13\124\2\uffff\14\124";
    static final String dfa_11s = "\1\uffff\1\1\13\uffff\1\2\1\3\14\uffff";
    static final String dfa_12s = "\33\uffff}>";
    static final String[] dfa_13s = {
            "\1\15\1\3\1\15\1\2\1\4\5\uffff\1\15\1\uffff\1\15\3\uffff\1\16\5\uffff\1\16\7\uffff\1\13\1\7\1\uffff\2\15\1\6\1\uffff\1\11\1\12\1\15\1\uffff\1\15\1\1\5\uffff\1\5\20\uffff\1\15\1\uffff\4\15\5\uffff\3\15\1\10\1\14\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\2\uffff\1\15\14\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "",
            "",
            "\1\21\1\uffff\1\20\1\22\31\uffff\1\31\1\25\3\uffff\1\24\1\uffff\1\27\1\30\11\uffff\1\23\36\uffff\1\26\1\32",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1",
            "\1\1\1\uffff\2\1\5\uffff\1\15\3\uffff\1\15\17\uffff\2\1\1\15\2\uffff\1\1\1\uffff\2\1\11\uffff\1\1\2\uffff\20\15\4\uffff\2\15\2\uffff\1\17\3\uffff\2\1"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "766:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )";
        }
    }
    static final String dfa_14s = "\45\uffff";
    static final String dfa_15s = "\1\4\1\uffff\13\0\30\uffff";
    static final String dfa_16s = "\1\130\1\uffff\13\0\30\uffff";
    static final String dfa_17s = "\1\uffff\1\1\17\uffff\1\2\17\uffff\1\3\1\5\1\uffff\1\4";
    static final String dfa_18s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\30\uffff}>";
    static final String[] dfa_19s = {
            "\1\21\1\3\1\21\1\2\1\4\5\uffff\1\21\1\uffff\1\21\16\uffff\2\42\1\uffff\1\13\1\7\1\uffff\2\21\1\6\1\41\1\11\1\12\1\21\1\uffff\1\21\1\1\5\uffff\1\5\20\uffff\1\21\1\uffff\4\21\5\uffff\3\21\1\10\1\14\4\1",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1392:2: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                        else if ( (synpred41_InternalRtVil()) ) {s = 36;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_10 = input.LA(1);

                         
                        int index32_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_12 = input.LA(1);

                         
                        int index32_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRtVil()) ) {s = 1;}

                        else if ( (synpred37_InternalRtVil()) ) {s = 17;}

                         
                        input.seek(index32_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_20s = "\42\uffff";
    static final String dfa_21s = "\1\4\1\uffff\13\0\25\uffff";
    static final String dfa_22s = "\1\130\1\uffff\13\0\25\uffff";
    static final String dfa_23s = "\1\uffff\1\1\17\uffff\1\2\20\uffff";
    static final String dfa_24s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\25\uffff}>";
    static final String[] dfa_25s = {
            "\1\21\1\4\1\21\1\3\1\5\5\uffff\1\21\1\uffff\1\21\10\uffff\1\21\3\uffff\1\1\4\uffff\1\13\1\2\1\uffff\2\21\1\7\1\uffff\1\11\1\12\1\21\1\uffff\1\21\6\uffff\1\6\20\uffff\1\21\1\uffff\4\21\5\uffff\3\21\1\10\1\14\4\1",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "1785:3: ( ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_type_3_0= ruleType ) )? ( (lv_name_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_paramList_6_0= ruleParameterList ) )? otherlv_7= ')' otherlv_8= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_2 = input.LA(1);

                         
                        int index40_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_3 = input.LA(1);

                         
                        int index40_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_4 = input.LA(1);

                         
                        int index40_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_5 = input.LA(1);

                         
                        int index40_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_6 = input.LA(1);

                         
                        int index40_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA40_8 = input.LA(1);

                         
                        int index40_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA40_9 = input.LA(1);

                         
                        int index40_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA40_10 = input.LA(1);

                         
                        int index40_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred49_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_26s = "\22\uffff";
    static final String dfa_27s = "\1\5\1\uffff\17\0\1\uffff";
    static final String dfa_28s = "\1\130\1\uffff\17\0\1\uffff";
    static final String dfa_29s = "\1\uffff\1\1\17\uffff\1\2";
    static final String dfa_30s = "\2\uffff\1\3\1\7\1\10\1\11\1\13\1\0\1\1\1\14\1\2\1\15\1\16\1\12\1\4\1\5\1\6\1\uffff}>";
    static final String[] dfa_31s = {
            "\1\4\1\uffff\1\3\1\5\24\uffff\1\1\4\uffff\1\13\1\2\3\uffff\1\7\1\uffff\1\11\1\12\11\uffff\1\6\36\uffff\1\10\1\14\1\15\1\16\1\17\1\20",
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
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_7 = input.LA(1);

                         
                        int index36_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_8);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_10 = input.LA(1);

                         
                        int index36_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_2 = input.LA(1);

                         
                        int index36_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_2);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_14 = input.LA(1);

                         
                        int index36_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_15 = input.LA(1);

                         
                        int index36_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_15);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_16);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_3 = input.LA(1);

                         
                        int index36_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_3);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA36_4 = input.LA(1);

                         
                        int index36_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_4);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA36_5 = input.LA(1);

                         
                        int index36_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_5);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA36_13 = input.LA(1);

                         
                        int index36_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_13);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA36_6 = input.LA(1);

                         
                        int index36_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_6);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA36_11 = input.LA(1);

                         
                        int index36_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_11);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA36_12 = input.LA(1);

                         
                        int index36_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index36_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_32s = "\16\uffff";
    static final String dfa_33s = "\14\5\2\uffff";
    static final String dfa_34s = "\1\130\13\124\2\uffff";
    static final String dfa_35s = "\14\uffff\1\1\1\2";
    static final String dfa_36s = "\16\uffff}>";
    static final String[] dfa_37s = {
            "\1\2\1\uffff\1\1\1\3\31\uffff\1\12\1\6\3\uffff\1\5\1\uffff\1\10\1\11\11\uffff\1\4\36\uffff\1\7\1\13\4\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\5\uffff\1\15\23\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "",
            ""
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "1824:4: ( (lv_type_3_0= ruleType ) )?";
        }
    }
    static final String dfa_38s = "\35\uffff";
    static final String dfa_39s = "\1\4\7\uffff\1\0\24\uffff";
    static final String dfa_40s = "\1\124\7\uffff\1\0\24\uffff";
    static final String dfa_41s = "\1\uffff\1\1\32\uffff\1\2";
    static final String dfa_42s = "\10\uffff\1\0\24\uffff}>";
    static final String[] dfa_43s = {
            "\5\1\5\uffff\1\1\1\uffff\1\1\21\uffff\2\1\1\uffff\3\1\1\uffff\1\10\2\1\1\uffff\1\1\6\uffff\1\1\20\uffff\1\1\1\uffff\4\1\5\uffff\5\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            ""
    };

    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[][] dfa_43 = unpackEncodedStringArray(dfa_43s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_38;
            this.eof = dfa_38;
            this.min = dfa_39;
            this.max = dfa_40;
            this.accept = dfa_41;
            this.special = dfa_42;
            this.transition = dfa_43;
        }
        public String getDescription() {
            return "2085:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_8 = input.LA(1);

                         
                        int index49_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index49_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_44s = "\32\uffff";
    static final String dfa_45s = "\1\4\13\16\1\uffff\1\5\1\uffff\13\16";
    static final String dfa_46s = "\1\124\13\117\1\uffff\1\124\1\uffff\13\117";
    static final String dfa_47s = "\14\uffff\1\2\1\uffff\1\1\13\uffff";
    static final String dfa_48s = "\32\uffff}>";
    static final String[] dfa_49s = {
            "\1\14\1\2\1\14\1\1\1\3\5\uffff\1\14\1\uffff\1\14\21\uffff\1\12\1\6\1\uffff\2\14\1\5\1\uffff\1\10\1\11\1\14\1\uffff\1\14\6\uffff\1\4\20\uffff\1\14\1\uffff\4\14\5\uffff\3\14\1\7\1\13",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\15\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "",
            "\1\20\1\uffff\1\17\1\21\31\uffff\1\30\1\24\3\uffff\1\23\1\uffff\1\26\1\27\11\uffff\1\22\36\uffff\1\25\1\31",
            "",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\1\14\3\uffff\1\14\2\uffff\1\16\16\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14"
    };

    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_44;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String dfa_50s = "\40\uffff";
    static final String dfa_51s = "\2\uffff\13\1\10\uffff\13\1";
    static final String dfa_52s = "\1\4\1\uffff\13\15\6\uffff\1\5\1\uffff\13\15";
    static final String dfa_53s = "\1\124\1\uffff\13\117\6\uffff\1\124\1\uffff\13\117";
    static final String dfa_54s = "\1\uffff\1\1\13\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\13\uffff";
    static final String dfa_55s = "\40\uffff}>";
    static final String[] dfa_56s = {
            "\1\1\1\3\1\1\1\2\1\4\5\uffff\1\1\23\uffff\1\13\1\7\1\uffff\1\21\1\17\1\6\1\uffff\1\11\1\12\1\20\1\uffff\1\16\6\uffff\1\5\24\uffff\1\15\1\22\5\uffff\3\1\1\10\1\14",
            "",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26\1\uffff\1\25\1\27\31\uffff\1\36\1\32\3\uffff\1\31\1\uffff\1\34\1\35\11\uffff\1\30\36\uffff\1\33\1\37",
            "",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23",
            "\1\1\1\24\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\23"
    };

    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = dfa_50;
            this.eof = dfa_51;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_55;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "2207:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String dfa_57s = "\36\uffff";
    static final String dfa_58s = "\1\2\35\uffff";
    static final String dfa_59s = "\1\15\1\0\34\uffff";
    static final String dfa_60s = "\1\116\1\0\34\uffff";
    static final String dfa_61s = "\2\uffff\1\2\32\uffff\1\1";
    static final String dfa_62s = "\1\uffff\1\0\34\uffff}>";
    static final String[] dfa_63s = {
            "\1\2\1\uffff\4\2\6\uffff\1\2\1\uffff\1\1\1\2\26\uffff\1\2\3\uffff\20\2\6\uffff\2\2",
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
            ""
    };

    static final short[] dfa_57 = DFA.unpackEncodedString(dfa_57s);
    static final short[] dfa_58 = DFA.unpackEncodedString(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final short[][] dfa_63 = unpackEncodedStringArray(dfa_63s);

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = dfa_57;
            this.eof = dfa_58;
            this.min = dfa_59;
            this.max = dfa_60;
            this.accept = dfa_61;
            this.special = dfa_62;
            this.transition = dfa_63;
        }
        public String getDescription() {
            return "2457:3: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA53_1 = input.LA(1);

                         
                        int index53_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred68_InternalRtVil()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index53_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 53, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_64s = "\1\uffff\13\15\2\uffff";
    static final String[] dfa_65s = {
            "\1\2\1\uffff\1\1\1\3\31\uffff\1\12\1\6\3\uffff\1\5\1\uffff\1\10\1\11\11\uffff\1\4\36\uffff\1\7\1\13\4\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\14\uffff\1\15\3\uffff\1\15\2\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\32\uffff\1\14\3\uffff\2\14",
            "",
            ""
    };
    static final short[] dfa_64 = DFA.unpackEncodedString(dfa_64s);
    static final short[][] dfa_65 = unpackEncodedStringArray(dfa_65s);

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_32;
            this.eof = dfa_64;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_65;
        }
        public String getDescription() {
            return "2495:3: ( (lv_type_0_0= ruleType ) )?";
        }
    }
    static final String dfa_66s = "\1\4\32\uffff\1\0\1\uffff";
    static final String dfa_67s = "\1\124\32\uffff\1\0\1\uffff";
    static final String dfa_68s = "\33\uffff\1\0\1\uffff}>";
    static final String[] dfa_69s = {
            "\5\1\5\uffff\1\1\1\uffff\1\33\21\uffff\2\1\1\uffff\3\1\1\uffff\3\1\1\uffff\1\1\6\uffff\1\1\20\uffff\1\1\1\uffff\4\1\5\uffff\5\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
    static final char[] dfa_66 = DFA.unpackEncodedStringToUnsignedChars(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final short[] dfa_68 = DFA.unpackEncodedString(dfa_68s);
    static final short[][] dfa_69 = unpackEncodedStringArray(dfa_69s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_38;
            this.eof = dfa_38;
            this.min = dfa_66;
            this.max = dfa_67;
            this.accept = dfa_41;
            this.special = dfa_68;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "2997:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_27 = input.LA(1);

                         
                        int index60_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index60_27);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = dfa_57;
            this.eof = dfa_58;
            this.min = dfa_59;
            this.max = dfa_60;
            this.accept = dfa_61;
            this.special = dfa_62;
            this.transition = dfa_63;
        }
        public String getDescription() {
            return "3110:3: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA61_1 = input.LA(1);

                         
                        int index61_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_InternalRtVil()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 61, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_70s = {
            "\1\2\1\uffff\1\1\1\3\31\uffff\1\12\1\6\3\uffff\1\5\1\uffff\1\10\1\11\11\uffff\1\4\36\uffff\1\7\1\13\4\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "\1\14\1\uffff\2\14\11\uffff\1\15\2\uffff\1\15\6\uffff\1\15\5\uffff\2\14\3\uffff\1\14\1\uffff\2\14\11\uffff\1\14\31\uffff\1\15\1\14\3\uffff\2\14",
            "",
            ""
    };
    static final short[][] dfa_70 = unpackEncodedStringArray(dfa_70s);

    class DFA99 extends DFA {

        public DFA99(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 99;
            this.eot = dfa_32;
            this.eof = dfa_64;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_70;
        }
        public String getDescription() {
            return "5401:3: ( (lv_type_0_0= ruleType ) )?";
        }
    }
    static final String dfa_71s = "\41\uffff";
    static final String dfa_72s = "\1\4\13\0\25\uffff";
    static final String dfa_73s = "\1\130\13\0\25\uffff";
    static final String dfa_74s = "\14\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String dfa_75s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\25\uffff}>";
    static final String[] dfa_76s = {
            "\1\20\1\2\1\20\1\1\1\3\5\uffff\3\20\21\uffff\1\12\1\6\1\uffff\2\20\1\5\1\uffff\1\10\1\11\1\20\1\uffff\1\20\6\uffff\1\4\20\uffff\1\20\1\uffff\4\20\5\uffff\3\20\1\7\1\13\4\14",
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
            ""
    };

    static final short[] dfa_71 = DFA.unpackEncodedString(dfa_71s);
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final char[] dfa_73 = DFA.unpackEncodedStringToUnsignedChars(dfa_73s);
    static final short[] dfa_74 = DFA.unpackEncodedString(dfa_74s);
    static final short[] dfa_75 = DFA.unpackEncodedString(dfa_75s);
    static final short[][] dfa_76 = unpackEncodedStringArray(dfa_76s);

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_71;
            this.eof = dfa_71;
            this.min = dfa_72;
            this.max = dfa_73;
            this.accept = dfa_74;
            this.special = dfa_75;
            this.transition = dfa_76;
        }
        public String getDescription() {
            return "5623:3: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_1 = input.LA(1);

                         
                        int index103_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA103_2 = input.LA(1);

                         
                        int index103_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA103_3 = input.LA(1);

                         
                        int index103_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA103_4 = input.LA(1);

                         
                        int index103_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA103_5 = input.LA(1);

                         
                        int index103_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA103_6 = input.LA(1);

                         
                        int index103_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA103_7 = input.LA(1);

                         
                        int index103_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA103_8 = input.LA(1);

                         
                        int index103_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA103_9 = input.LA(1);

                         
                        int index103_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA103_10 = input.LA(1);

                         
                        int index103_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA103_11 = input.LA(1);

                         
                        int index103_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalRtVil()) ) {s = 12;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index103_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 103, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_77s = "\1\uffff\13\14\2\uffff";
    static final String dfa_78s = "\1\4\13\16\2\uffff";
    static final String dfa_79s = "\1\124\13\117\2\uffff";
    static final String dfa_80s = "\14\uffff\1\2\1\1";
    static final String[] dfa_81s = {
            "\1\14\1\2\1\14\1\1\1\3\5\uffff\1\14\1\uffff\1\14\21\uffff\1\12\1\6\1\uffff\2\14\1\5\1\uffff\1\10\1\11\1\14\1\uffff\1\14\6\uffff\1\4\20\uffff\1\14\1\uffff\4\14\5\uffff\3\14\1\7\1\13",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "\2\14\5\uffff\1\15\6\uffff\1\14\7\uffff\1\14\22\uffff\20\14\4\uffff\2\14\2\uffff\1\14",
            "",
            ""
    };
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final char[] dfa_78 = DFA.unpackEncodedStringToUnsignedChars(dfa_78s);
    static final char[] dfa_79 = DFA.unpackEncodedStringToUnsignedChars(dfa_79s);
    static final short[] dfa_80 = DFA.unpackEncodedString(dfa_80s);
    static final short[][] dfa_81 = unpackEncodedStringArray(dfa_81s);

    class DFA106 extends DFA {

        public DFA106(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 106;
            this.eot = dfa_32;
            this.eof = dfa_77;
            this.min = dfa_78;
            this.max = dfa_79;
            this.accept = dfa_80;
            this.special = dfa_36;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "5747:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?";
        }
    }
    static final String dfa_82s = "\17\uffff";
    static final String dfa_83s = "\1\1\2\uffff\13\16\1\uffff";
    static final String dfa_84s = "\1\15\1\uffff\1\5\13\15\1\uffff";
    static final String dfa_85s = "\1\116\1\uffff\1\124\13\117\1\uffff";
    static final String dfa_86s = "\1\uffff\1\2\14\uffff\1\1";
    static final String dfa_87s = "\17\uffff}>";
    static final String[] dfa_88s = {
            "\1\1\1\uffff\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\2\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1",
            "",
            "\1\4\1\uffff\1\3\1\5\31\uffff\1\14\1\10\3\uffff\1\7\1\uffff\1\12\1\13\11\uffff\1\6\36\uffff\1\11\1\15",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            "\1\16\1\1\4\16\6\uffff\1\16\1\uffff\2\16\7\uffff\1\16\16\uffff\1\16\3\uffff\20\16\4\uffff\4\16\1\1",
            ""
    };

    static final short[] dfa_82 = DFA.unpackEncodedString(dfa_82s);
    static final short[] dfa_83 = DFA.unpackEncodedString(dfa_83s);
    static final char[] dfa_84 = DFA.unpackEncodedStringToUnsignedChars(dfa_84s);
    static final char[] dfa_85 = DFA.unpackEncodedStringToUnsignedChars(dfa_85s);
    static final short[] dfa_86 = DFA.unpackEncodedString(dfa_86s);
    static final short[] dfa_87 = DFA.unpackEncodedString(dfa_87s);
    static final short[][] dfa_88 = unpackEncodedStringArray(dfa_88s);

    class DFA108 extends DFA {

        public DFA108(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 108;
            this.eot = dfa_82;
            this.eof = dfa_83;
            this.min = dfa_84;
            this.max = dfa_85;
            this.accept = dfa_86;
            this.special = dfa_87;
            this.transition = dfa_88;
        }
        public String getDescription() {
            return "()* loopback of 5902:3: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*";
        }
    }
    static final String dfa_89s = "\2\uffff\1\0\1\10\1\11\1\12\1\3\1\14\1\15\1\4\1\16\1\5\1\6\1\13\1\1\1\2\1\7\1\uffff}>";
    static final short[] dfa_89 = DFA.unpackEncodedString(dfa_89s);

    class DFA122 extends DFA {

        public DFA122(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 122;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_89;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "1786:4: ( (lv_annotations_1_0= ruleAnnotationDeclarations ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA122_2 = input.LA(1);

                         
                        int index122_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA122_14 = input.LA(1);

                         
                        int index122_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_14);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA122_15 = input.LA(1);

                         
                        int index122_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA122_6 = input.LA(1);

                         
                        int index122_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA122_9 = input.LA(1);

                         
                        int index122_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA122_11 = input.LA(1);

                         
                        int index122_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA122_12 = input.LA(1);

                         
                        int index122_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_12);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA122_16 = input.LA(1);

                         
                        int index122_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_16);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA122_3 = input.LA(1);

                         
                        int index122_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_3);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA122_4 = input.LA(1);

                         
                        int index122_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_4);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA122_5 = input.LA(1);

                         
                        int index122_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_5);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA122_13 = input.LA(1);

                         
                        int index122_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_13);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA122_7 = input.LA(1);

                         
                        int index122_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_7);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA122_8 = input.LA(1);

                         
                        int index122_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_8);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA122_10 = input.LA(1);

                         
                        int index122_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index122_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 122, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA124 extends DFA {

        public DFA124(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 124;
            this.eot = dfa_32;
            this.eof = dfa_32;
            this.min = dfa_33;
            this.max = dfa_34;
            this.accept = dfa_35;
            this.special = dfa_36;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "1824:4: ( (lv_type_3_0= ruleType ) )?";
        }
    }

    class DFA129 extends DFA {

        public DFA129(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 129;
            this.eot = dfa_44;
            this.eof = dfa_44;
            this.min = dfa_45;
            this.max = dfa_46;
            this.accept = dfa_47;
            this.special = dfa_48;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "2087:4: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0068000200002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0008000200002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0008000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0010068C000001A0L,0x0000000000180000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0010068C000081A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0015EEEC261B41F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0015EEEC261941F2L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0010468C000801A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00102EEC020141F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0010468C00C801A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00102EEC000141F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00106EEC051941F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00106EEC051B41F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00106FED800B41F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0010068C000041A0L,0x0000000000180000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00102EEC000041F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00102EEC0001C1F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000028040000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00102EEC220141F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00106FEDC00B41F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00102EEC080541F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000008040000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0010068C000001A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00102EEC000041F2L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000001000200000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0010068C000001B0L,0x0000000000180000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000012200000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0010168C000001A0L,0x0000000000180000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000001000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0010468C000A01A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0080000008040000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x1F00000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0xE000000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000FL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000040000L,0x0000000000004000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x00102EEC0001C1F0L,0x0000000001FF07A0L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0010068C000041A0L,0x0000000001F80000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x00102EEC000341F0L,0x00000000001F07A0L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000010020000L});

}