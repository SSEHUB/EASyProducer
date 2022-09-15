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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'rtVilScript'", "'('", "')'", "'{'", "'}'", "';'", "'persistent'", "'strategy'", "'='", "'objective'", "'breakdown'", "'weighting'", "':'", "'tactic'", "'with'", "','", "'@'", "'intent'", "'fail'", "'refail'", "'requireVTL'", "'extends'", "'protected'", "'.'", "'instantiate'", "'map'", "'for'", "'while'", "'if'", "'else'", "'join'", "'exclude'", "'execute'", "'const'", "'abstract'", "'compound'", "'refines'", "'typedef'", "'@advice'", "'version'", "'import'", "'insert'", "'*'", "'and'", "'or'", "'xor'", "'implies'", "'iff'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    // InternalRtVil.g:73:1: entryRuleImplementationUnit returns [EObject current=null] : iv_ruleImplementationUnit= ruleImplementationUnit EOF ;
    public final EObject entryRuleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementationUnit = null;


        try {
            // InternalRtVil.g:74:2: (iv_ruleImplementationUnit= ruleImplementationUnit EOF )
            // InternalRtVil.g:75:2: iv_ruleImplementationUnit= ruleImplementationUnit EOF
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
    // InternalRtVil.g:82:1: ruleImplementationUnit returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) ;
    public final EObject ruleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_requires_2_0 = null;

        EObject lv_scripts_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:85:28: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) )
            // InternalRtVil.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            {
            // InternalRtVil.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            // InternalRtVil.g:86:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            {
            // InternalRtVil.g:86:2: ()
            // InternalRtVil.g:87:2: 
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

            // InternalRtVil.g:95:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=53 && LA1_0<=54)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRtVil.g:96:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalRtVil.g:96:1: (lv_imports_1_0= ruleImport )
            	    // InternalRtVil.g:97:3: lv_imports_1_0= ruleImport
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

            // InternalRtVil.g:113:3: ( (lv_requires_2_0= ruleRequire ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==33) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRtVil.g:114:1: (lv_requires_2_0= ruleRequire )
            	    {
            	    // InternalRtVil.g:114:1: (lv_requires_2_0= ruleRequire )
            	    // InternalRtVil.g:115:3: lv_requires_2_0= ruleRequire
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

            // InternalRtVil.g:131:3: ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13||LA3_0==51) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRtVil.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    {
            	    // InternalRtVil.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    // InternalRtVil.g:133:3: lv_scripts_3_0= ruleLanguageUnit
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
    // InternalRtVil.g:157:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // InternalRtVil.g:158:2: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // InternalRtVil.g:159:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
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
    // InternalRtVil.g:166:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? ) ;
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
            // InternalRtVil.g:169:28: ( ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? ) )
            // InternalRtVil.g:170:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? )
            {
            // InternalRtVil.g:170:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )? )
            // InternalRtVil.g:170:2: ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'rtVilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_rtContents_9_0= rulertContents ) ) otherlv_10= '}' (otherlv_11= ';' )?
            {
            // InternalRtVil.g:170:2: ( (lv_advices_0_0= ruleAdvice ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==51) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRtVil.g:171:1: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // InternalRtVil.g:171:1: (lv_advices_0_0= ruleAdvice )
            	    // InternalRtVil.g:172:3: lv_advices_0_0= ruleAdvice
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
            // InternalRtVil.g:192:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:193:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:193:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:194:3: lv_name_2_0= ruleIdentifier
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
            // InternalRtVil.g:214:1: ( (lv_param_4_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||LA5_0==52||(LA5_0>=83 && LA5_0<=86)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRtVil.g:215:1: (lv_param_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:215:1: (lv_param_4_0= ruleParameterList )
                    // InternalRtVil.g:216:3: lv_param_4_0= ruleParameterList
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
            // InternalRtVil.g:236:1: ( (lv_parent_6_0= ruleScriptParentDecl ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==34) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRtVil.g:237:1: (lv_parent_6_0= ruleScriptParentDecl )
                    {
                    // InternalRtVil.g:237:1: (lv_parent_6_0= ruleScriptParentDecl )
                    // InternalRtVil.g:238:3: lv_parent_6_0= ruleScriptParentDecl
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.ScriptParentDecl");
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
            // InternalRtVil.g:258:1: ( (lv_version_8_0= ruleVersionStmt ) )?
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
                    // InternalRtVil.g:259:1: (lv_version_8_0= ruleVersionStmt )
                    {
                    // InternalRtVil.g:259:1: (lv_version_8_0= ruleVersionStmt )
                    // InternalRtVil.g:260:3: lv_version_8_0= ruleVersionStmt
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

            // InternalRtVil.g:276:3: ( (lv_rtContents_9_0= rulertContents ) )
            // InternalRtVil.g:277:1: (lv_rtContents_9_0= rulertContents )
            {
            // InternalRtVil.g:277:1: (lv_rtContents_9_0= rulertContents )
            // InternalRtVil.g:278:3: lv_rtContents_9_0= rulertContents
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
            // InternalRtVil.g:298:1: (otherlv_11= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRtVil.g:298:3: otherlv_11= ';'
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
    // InternalRtVil.g:310:1: entryRulertContents returns [EObject current=null] : iv_rulertContents= rulertContents EOF ;
    public final EObject entryRulertContents() throws RecognitionException {
        EObject current = null;

        EObject iv_rulertContents = null;


        try {
            // InternalRtVil.g:311:2: (iv_rulertContents= rulertContents EOF )
            // InternalRtVil.g:312:2: iv_rulertContents= rulertContents EOF
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
    // InternalRtVil.g:319:1: rulertContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* ) ;
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
            // InternalRtVil.g:322:28: ( ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* ) )
            // InternalRtVil.g:323:1: ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* )
            {
            // InternalRtVil.g:323:1: ( () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )* )
            // InternalRtVil.g:323:2: () ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*
            {
            // InternalRtVil.g:323:2: ()
            // InternalRtVil.g:324:2: 
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

            // InternalRtVil.g:332:2: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*
            loop9:
            do {
                int alt9=7;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalRtVil.g:332:3: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
            	    {
            	    // InternalRtVil.g:332:3: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
            	    // InternalRtVil.g:333:1: (lv_elements_1_0= ruleGlobalVariableDeclaration )
            	    {
            	    // InternalRtVil.g:333:1: (lv_elements_1_0= ruleGlobalVariableDeclaration )
            	    // InternalRtVil.g:334:3: lv_elements_1_0= ruleGlobalVariableDeclaration
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
            	    // InternalRtVil.g:351:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    {
            	    // InternalRtVil.g:351:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
            	    // InternalRtVil.g:352:1: (lv_elements_2_0= ruleRuleDeclaration )
            	    {
            	    // InternalRtVil.g:352:1: (lv_elements_2_0= ruleRuleDeclaration )
            	    // InternalRtVil.g:353:3: lv_elements_2_0= ruleRuleDeclaration
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
            	              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRtVil.g:370:6: ( (lv_elements_3_0= ruleStrategyDeclaration ) )
            	    {
            	    // InternalRtVil.g:370:6: ( (lv_elements_3_0= ruleStrategyDeclaration ) )
            	    // InternalRtVil.g:371:1: (lv_elements_3_0= ruleStrategyDeclaration )
            	    {
            	    // InternalRtVil.g:371:1: (lv_elements_3_0= ruleStrategyDeclaration )
            	    // InternalRtVil.g:372:3: lv_elements_3_0= ruleStrategyDeclaration
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
            	    // InternalRtVil.g:389:6: ( (lv_elements_4_0= ruleTacticDeclaration ) )
            	    {
            	    // InternalRtVil.g:389:6: ( (lv_elements_4_0= ruleTacticDeclaration ) )
            	    // InternalRtVil.g:390:1: (lv_elements_4_0= ruleTacticDeclaration )
            	    {
            	    // InternalRtVil.g:390:1: (lv_elements_4_0= ruleTacticDeclaration )
            	    // InternalRtVil.g:391:3: lv_elements_4_0= ruleTacticDeclaration
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
            	    // InternalRtVil.g:408:6: ( (lv_elements_5_0= ruleTypeDef ) )
            	    {
            	    // InternalRtVil.g:408:6: ( (lv_elements_5_0= ruleTypeDef ) )
            	    // InternalRtVil.g:409:1: (lv_elements_5_0= ruleTypeDef )
            	    {
            	    // InternalRtVil.g:409:1: (lv_elements_5_0= ruleTypeDef )
            	    // InternalRtVil.g:410:3: lv_elements_5_0= ruleTypeDef
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
            	    // InternalRtVil.g:427:6: ( (lv_elements_6_0= ruleCompound ) )
            	    {
            	    // InternalRtVil.g:427:6: ( (lv_elements_6_0= ruleCompound ) )
            	    // InternalRtVil.g:428:1: (lv_elements_6_0= ruleCompound )
            	    {
            	    // InternalRtVil.g:428:1: (lv_elements_6_0= ruleCompound )
            	    // InternalRtVil.g:429:3: lv_elements_6_0= ruleCompound
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
    // InternalRtVil.g:453:1: entryRuleGlobalVariableDeclaration returns [EObject current=null] : iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF ;
    public final EObject entryRuleGlobalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariableDeclaration = null;


        try {
            // InternalRtVil.g:454:2: (iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF )
            // InternalRtVil.g:455:2: iv_ruleGlobalVariableDeclaration= ruleGlobalVariableDeclaration EOF
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
    // InternalRtVil.g:462:1: ruleGlobalVariableDeclaration returns [EObject current=null] : ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) ) ;
    public final EObject ruleGlobalVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_persistent_0_0=null;
        EObject lv_varDecl_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:465:28: ( ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) ) )
            // InternalRtVil.g:466:1: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) )
            {
            // InternalRtVil.g:466:1: ( ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) ) )
            // InternalRtVil.g:466:2: ( (lv_persistent_0_0= 'persistent' ) )? ( (lv_varDecl_1_0= ruleVariableDeclaration ) )
            {
            // InternalRtVil.g:466:2: ( (lv_persistent_0_0= 'persistent' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRtVil.g:467:1: (lv_persistent_0_0= 'persistent' )
                    {
                    // InternalRtVil.g:467:1: (lv_persistent_0_0= 'persistent' )
                    // InternalRtVil.g:468:3: lv_persistent_0_0= 'persistent'
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

            // InternalRtVil.g:481:3: ( (lv_varDecl_1_0= ruleVariableDeclaration ) )
            // InternalRtVil.g:482:1: (lv_varDecl_1_0= ruleVariableDeclaration )
            {
            // InternalRtVil.g:482:1: (lv_varDecl_1_0= ruleVariableDeclaration )
            // InternalRtVil.g:483:3: lv_varDecl_1_0= ruleVariableDeclaration
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
    // InternalRtVil.g:507:1: entryRuleStrategyDeclaration returns [EObject current=null] : iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF ;
    public final EObject entryRuleStrategyDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategyDeclaration = null;


        try {
            // InternalRtVil.g:508:2: (iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF )
            // InternalRtVil.g:509:2: iv_ruleStrategyDeclaration= ruleStrategyDeclaration EOF
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
    // InternalRtVil.g:516:1: ruleStrategyDeclaration returns [EObject current=null] : ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? ) ;
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
            // InternalRtVil.g:519:28: ( ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? ) )
            // InternalRtVil.g:520:1: ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? )
            {
            // InternalRtVil.g:520:1: ( () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )? )
            // InternalRtVil.g:520:2: () otherlv_1= 'strategy' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? otherlv_8= '{' ( (lv_varDecls_9_0= ruleVariableDeclaration ) )* (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )? (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' ) ( (lv_post_18_0= ruleRuleElement ) )* otherlv_19= '}' (otherlv_20= ';' )?
            {
            // InternalRtVil.g:520:2: ()
            // InternalRtVil.g:521:2: 
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
            // InternalRtVil.g:533:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:534:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:534:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:535:3: lv_name_2_0= ruleIdentifier
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
            // InternalRtVil.g:555:1: ( (lv_paramList_4_0= ruleParameterList ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_VERSION||(LA11_0>=RULE_ID && LA11_0<=RULE_EXPONENT)||LA11_0==52||(LA11_0>=83 && LA11_0<=86)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRtVil.g:556:1: (lv_paramList_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:556:1: (lv_paramList_4_0= ruleParameterList )
                    // InternalRtVil.g:557:3: lv_paramList_4_0= ruleParameterList
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
            // InternalRtVil.g:581:1: ( (lv_conditions_7_0= ruleRuleConditions ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_EXPONENT)||LA12_0==14||LA12_0==25||(LA12_0>=37 && LA12_0<=38)||LA12_0==43||LA12_0==45||LA12_0==52||LA12_0==69||(LA12_0>=71 && LA12_0<=74)||(LA12_0>=80 && LA12_0<=82)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRtVil.g:582:1: (lv_conditions_7_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:582:1: (lv_conditions_7_0= ruleRuleConditions )
                    // InternalRtVil.g:583:3: lv_conditions_7_0= ruleRuleConditions
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleConditions");
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
            // InternalRtVil.g:603:1: ( (lv_varDecls_9_0= ruleVariableDeclaration ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_VERSION||(LA13_0>=RULE_ID && LA13_0<=RULE_EXPONENT)||LA13_0==46||LA13_0==52||(LA13_0>=83 && LA13_0<=86)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalRtVil.g:604:1: (lv_varDecls_9_0= ruleVariableDeclaration )
            	    {
            	    // InternalRtVil.g:604:1: (lv_varDecls_9_0= ruleVariableDeclaration )
            	    // InternalRtVil.g:605:3: lv_varDecls_9_0= ruleVariableDeclaration
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

            // InternalRtVil.g:621:3: (otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRtVil.g:621:5: otherlv_10= 'objective' ( (lv_objective_11_0= ruleExpression ) ) otherlv_12= ';'
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getStrategyDeclarationAccess().getObjectiveKeyword_10_0());
                          
                    }
                    // InternalRtVil.g:625:1: ( (lv_objective_11_0= ruleExpression ) )
                    // InternalRtVil.g:626:1: (lv_objective_11_0= ruleExpression )
                    {
                    // InternalRtVil.g:626:1: (lv_objective_11_0= ruleExpression )
                    // InternalRtVil.g:627:3: lv_objective_11_0= ruleExpression
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

            // InternalRtVil.g:647:3: (otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}' )
            // InternalRtVil.g:647:5: otherlv_13= 'breakdown' otherlv_14= '{' ( (lv_weighting_15_0= ruleWeightingStatement ) )? ( (lv_breakdown_16_0= ruleBreakdownElement ) )+ otherlv_17= '}'
            {
            otherlv_13=(Token)match(input,23,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getStrategyDeclarationAccess().getBreakdownKeyword_11_0());
                  
            }
            otherlv_14=(Token)match(input,16,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getStrategyDeclarationAccess().getLeftCurlyBracketKeyword_11_1());
                  
            }
            // InternalRtVil.g:655:1: ( (lv_weighting_15_0= ruleWeightingStatement ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRtVil.g:656:1: (lv_weighting_15_0= ruleWeightingStatement )
                    {
                    // InternalRtVil.g:656:1: (lv_weighting_15_0= ruleWeightingStatement )
                    // InternalRtVil.g:657:3: lv_weighting_15_0= ruleWeightingStatement
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

            // InternalRtVil.g:673:3: ( (lv_breakdown_16_0= ruleBreakdownElement ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_EXPONENT)||LA16_0==14||LA16_0==16||LA16_0==20||LA16_0==26||(LA16_0>=37 && LA16_0<=38)||LA16_0==41||LA16_0==43||(LA16_0>=45 && LA16_0<=46)||LA16_0==52||LA16_0==69||(LA16_0>=71 && LA16_0<=74)||(LA16_0>=80 && LA16_0<=86)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRtVil.g:674:1: (lv_breakdown_16_0= ruleBreakdownElement )
            	    {
            	    // InternalRtVil.g:674:1: (lv_breakdown_16_0= ruleBreakdownElement )
            	    // InternalRtVil.g:675:3: lv_breakdown_16_0= ruleBreakdownElement
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

            // InternalRtVil.g:695:2: ( (lv_post_18_0= ruleRuleElement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_EXPONENT)||LA17_0==14||LA17_0==16||(LA17_0>=31 && LA17_0<=32)||(LA17_0>=37 && LA17_0<=41)||LA17_0==43||(LA17_0>=45 && LA17_0<=46)||LA17_0==52||LA17_0==69||(LA17_0>=71 && LA17_0<=74)||(LA17_0>=80 && LA17_0<=86)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRtVil.g:696:1: (lv_post_18_0= ruleRuleElement )
            	    {
            	    // InternalRtVil.g:696:1: (lv_post_18_0= ruleRuleElement )
            	    // InternalRtVil.g:697:3: lv_post_18_0= ruleRuleElement
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
            // InternalRtVil.g:717:1: (otherlv_20= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==18) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRtVil.g:717:3: otherlv_20= ';'
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
    // InternalRtVil.g:729:1: entryRuleBreakdownElement returns [EObject current=null] : iv_ruleBreakdownElement= ruleBreakdownElement EOF ;
    public final EObject entryRuleBreakdownElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownElement = null;


        try {
            // InternalRtVil.g:730:2: (iv_ruleBreakdownElement= ruleBreakdownElement EOF )
            // InternalRtVil.g:731:2: iv_ruleBreakdownElement= ruleBreakdownElement EOF
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
    // InternalRtVil.g:738:1: ruleBreakdownElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) ) ;
    public final EObject ruleBreakdownElement() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;

        EObject lv_breakdownStmt_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:741:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) ) )
            // InternalRtVil.g:742:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )
            {
            // InternalRtVil.g:742:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalRtVil.g:742:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalRtVil.g:742:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalRtVil.g:743:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalRtVil.g:743:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalRtVil.g:744:3: lv_varDecl_0_0= ruleVariableDeclaration
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
                    // InternalRtVil.g:761:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:761:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:762:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:762:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalRtVil.g:763:3: lv_exprStmt_1_0= ruleExpressionStatement
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.ExpressionStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRtVil.g:780:6: ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) )
                    {
                    // InternalRtVil.g:780:6: ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) )
                    // InternalRtVil.g:781:1: (lv_breakdownStmt_2_0= ruleBreakdownStatement )
                    {
                    // InternalRtVil.g:781:1: (lv_breakdownStmt_2_0= ruleBreakdownStatement )
                    // InternalRtVil.g:782:3: lv_breakdownStmt_2_0= ruleBreakdownStatement
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
    // InternalRtVil.g:806:1: entryRuleWeightingStatement returns [EObject current=null] : iv_ruleWeightingStatement= ruleWeightingStatement EOF ;
    public final EObject entryRuleWeightingStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWeightingStatement = null;


        try {
            // InternalRtVil.g:807:2: (iv_ruleWeightingStatement= ruleWeightingStatement EOF )
            // InternalRtVil.g:808:2: iv_ruleWeightingStatement= ruleWeightingStatement EOF
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
    // InternalRtVil.g:815:1: ruleWeightingStatement returns [EObject current=null] : (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) ;
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
            // InternalRtVil.g:818:28: ( (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) )
            // InternalRtVil.g:819:1: (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            {
            // InternalRtVil.g:819:1: (otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            // InternalRtVil.g:819:3: otherlv_0= 'weighting' otherlv_1= '(' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= ':' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWeightingStatementAccess().getWeightingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWeightingStatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:827:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:828:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:828:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:829:3: lv_name_2_0= ruleIdentifier
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
            // InternalRtVil.g:849:1: ( (lv_expr_4_0= ruleExpression ) )
            // InternalRtVil.g:850:1: (lv_expr_4_0= ruleExpression )
            {
            // InternalRtVil.g:850:1: (lv_expr_4_0= ruleExpression )
            // InternalRtVil.g:851:3: lv_expr_4_0= ruleExpression
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
    // InternalRtVil.g:883:1: entryRuleBreakdownStatement returns [EObject current=null] : iv_ruleBreakdownStatement= ruleBreakdownStatement EOF ;
    public final EObject entryRuleBreakdownStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownStatement = null;


        try {
            // InternalRtVil.g:884:2: (iv_ruleBreakdownStatement= ruleBreakdownStatement EOF )
            // InternalRtVil.g:885:2: iv_ruleBreakdownStatement= ruleBreakdownStatement EOF
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
    // InternalRtVil.g:892:1: ruleBreakdownStatement returns [EObject current=null] : ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' ) ;
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
            // InternalRtVil.g:895:28: ( ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' ) )
            // InternalRtVil.g:896:1: ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' )
            {
            // InternalRtVil.g:896:1: ( ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';' )
            // InternalRtVil.g:896:2: ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) ) (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )? ( (lv_name_4_0= ruleQualifiedPrefix ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )? (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )? otherlv_16= ';'
            {
            // InternalRtVil.g:896:2: ( ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) ) )
            // InternalRtVil.g:897:1: ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) )
            {
            // InternalRtVil.g:897:1: ( (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' ) )
            // InternalRtVil.g:898:1: (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' )
            {
            // InternalRtVil.g:898:1: (lv_type_0_1= 'strategy' | lv_type_0_2= 'tactic' )
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
                    // InternalRtVil.g:899:3: lv_type_0_1= 'strategy'
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
                    // InternalRtVil.g:911:8: lv_type_0_2= 'tactic'
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

            // InternalRtVil.g:926:2: (otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==14) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRtVil.g:926:4: otherlv_1= '(' ( (lv_guard_2_0= ruleLogicalExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getBreakdownStatementAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // InternalRtVil.g:930:1: ( (lv_guard_2_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:931:1: (lv_guard_2_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:931:1: (lv_guard_2_0= ruleLogicalExpression )
                    // InternalRtVil.g:932:3: lv_guard_2_0= ruleLogicalExpression
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

            // InternalRtVil.g:952:3: ( (lv_name_4_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:953:1: (lv_name_4_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:953:1: (lv_name_4_0= ruleQualifiedPrefix )
            // InternalRtVil.g:954:3: lv_name_4_0= ruleQualifiedPrefix
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
            // InternalRtVil.g:974:1: ( (lv_param_6_0= ruleArgumentList ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_STRING && LA22_0<=RULE_EXPONENT)||LA22_0==14||LA22_0==16||(LA22_0>=37 && LA22_0<=38)||LA22_0==43||LA22_0==45||LA22_0==52||LA22_0==69||(LA22_0>=71 && LA22_0<=74)||(LA22_0>=80 && LA22_0<=82)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalRtVil.g:975:1: (lv_param_6_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:975:1: (lv_param_6_0= ruleArgumentList )
                    // InternalRtVil.g:976:3: lv_param_6_0= ruleArgumentList
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
            // InternalRtVil.g:996:1: (otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRtVil.g:996:3: otherlv_8= 'with' otherlv_9= '(' ( (lv_part_10_0= ruleBreakdownWithPart ) ) (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) ) otherlv_13= ')'
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getBreakdownStatementAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_9=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getBreakdownStatementAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // InternalRtVil.g:1004:1: ( (lv_part_10_0= ruleBreakdownWithPart ) )
                    // InternalRtVil.g:1005:1: (lv_part_10_0= ruleBreakdownWithPart )
                    {
                    // InternalRtVil.g:1005:1: (lv_part_10_0= ruleBreakdownWithPart )
                    // InternalRtVil.g:1006:3: lv_part_10_0= ruleBreakdownWithPart
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

                    // InternalRtVil.g:1022:2: (otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) ) )
                    // InternalRtVil.g:1022:4: otherlv_11= ',' ( (lv_part_12_0= ruleBreakdownWithPart ) )
                    {
                    otherlv_11=(Token)match(input,28,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getBreakdownStatementAccess().getCommaKeyword_6_3_0());
                          
                    }
                    // InternalRtVil.g:1026:1: ( (lv_part_12_0= ruleBreakdownWithPart ) )
                    // InternalRtVil.g:1027:1: (lv_part_12_0= ruleBreakdownWithPart )
                    {
                    // InternalRtVil.g:1027:1: (lv_part_12_0= ruleBreakdownWithPart )
                    // InternalRtVil.g:1028:3: lv_part_12_0= ruleBreakdownWithPart
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

            // InternalRtVil.g:1048:3: (otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRtVil.g:1048:5: otherlv_14= '@' ( (lv_time_15_0= ruleExpression ) )
                    {
                    otherlv_14=(Token)match(input,29,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getBreakdownStatementAccess().getCommercialAtKeyword_7_0());
                          
                    }
                    // InternalRtVil.g:1052:1: ( (lv_time_15_0= ruleExpression ) )
                    // InternalRtVil.g:1053:1: (lv_time_15_0= ruleExpression )
                    {
                    // InternalRtVil.g:1053:1: (lv_time_15_0= ruleExpression )
                    // InternalRtVil.g:1054:3: lv_time_15_0= ruleExpression
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
    // InternalRtVil.g:1082:1: entryRuleBreakdownWithPart returns [EObject current=null] : iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF ;
    public final EObject entryRuleBreakdownWithPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakdownWithPart = null;


        try {
            // InternalRtVil.g:1083:2: (iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF )
            // InternalRtVil.g:1084:2: iv_ruleBreakdownWithPart= ruleBreakdownWithPart EOF
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
    // InternalRtVil.g:1091:1: ruleBreakdownWithPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleBreakdownWithPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1094:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalRtVil.g:1095:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:1095:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalRtVil.g:1095:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalRtVil.g:1095:2: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalRtVil.g:1096:1: (lv_name_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:1096:1: (lv_name_0_0= ruleIdentifier )
            // InternalRtVil.g:1097:3: lv_name_0_0= ruleIdentifier
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
            // InternalRtVil.g:1117:1: ( (lv_value_2_0= ruleExpression ) )
            // InternalRtVil.g:1118:1: (lv_value_2_0= ruleExpression )
            {
            // InternalRtVil.g:1118:1: (lv_value_2_0= ruleExpression )
            // InternalRtVil.g:1119:3: lv_value_2_0= ruleExpression
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
    // InternalRtVil.g:1143:1: entryRuleTacticDeclaration returns [EObject current=null] : iv_ruleTacticDeclaration= ruleTacticDeclaration EOF ;
    public final EObject entryRuleTacticDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTacticDeclaration = null;


        try {
            // InternalRtVil.g:1144:2: (iv_ruleTacticDeclaration= ruleTacticDeclaration EOF )
            // InternalRtVil.g:1145:2: iv_ruleTacticDeclaration= ruleTacticDeclaration EOF
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
    // InternalRtVil.g:1152:1: ruleTacticDeclaration returns [EObject current=null] : ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? ) ;
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
            // InternalRtVil.g:1155:28: ( ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? ) )
            // InternalRtVil.g:1156:1: ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? )
            {
            // InternalRtVil.g:1156:1: ( () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )? )
            // InternalRtVil.g:1156:2: () otherlv_1= 'tactic' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_paramList_4_0= ruleParameterList ) )? otherlv_5= ')' otherlv_6= '=' ( (lv_conditions_7_0= ruleRuleConditions ) )? ( (lv_block_8_0= ruleRuleElementBlock ) ) (otherlv_9= ';' )?
            {
            // InternalRtVil.g:1156:2: ()
            // InternalRtVil.g:1157:2: 
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
            // InternalRtVil.g:1169:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:1170:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:1170:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:1171:3: lv_name_2_0= ruleIdentifier
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
            // InternalRtVil.g:1191:1: ( (lv_paramList_4_0= ruleParameterList ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_VERSION||(LA25_0>=RULE_ID && LA25_0<=RULE_EXPONENT)||LA25_0==52||(LA25_0>=83 && LA25_0<=86)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalRtVil.g:1192:1: (lv_paramList_4_0= ruleParameterList )
                    {
                    // InternalRtVil.g:1192:1: (lv_paramList_4_0= ruleParameterList )
                    // InternalRtVil.g:1193:3: lv_paramList_4_0= ruleParameterList
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
            // InternalRtVil.g:1217:1: ( (lv_conditions_7_0= ruleRuleConditions ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_EXPONENT)||LA26_0==14||LA26_0==25||(LA26_0>=37 && LA26_0<=38)||LA26_0==43||LA26_0==45||LA26_0==52||LA26_0==69||(LA26_0>=71 && LA26_0<=74)||(LA26_0>=80 && LA26_0<=82)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRtVil.g:1218:1: (lv_conditions_7_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:1218:1: (lv_conditions_7_0= ruleRuleConditions )
                    // InternalRtVil.g:1219:3: lv_conditions_7_0= ruleRuleConditions
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.RuleConditions");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:1235:3: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:1236:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:1236:1: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:1237:3: lv_block_8_0= ruleRuleElementBlock
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

            // InternalRtVil.g:1253:2: (otherlv_9= ';' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==18) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRtVil.g:1253:4: otherlv_9= ';'
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
    // InternalRtVil.g:1265:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // InternalRtVil.g:1266:2: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // InternalRtVil.g:1267:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
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
    // InternalRtVil.g:1274:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_intent_2_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1277:28: ( ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' ) )
            // InternalRtVil.g:1278:1: ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' )
            {
            // InternalRtVil.g:1278:1: ( () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}' )
            // InternalRtVil.g:1278:2: () otherlv_1= '{' ( (lv_intent_2_0= ruleIntentDeclaration ) )? ( (lv_elements_3_0= ruleRuleElement ) )* otherlv_4= '}'
            {
            // InternalRtVil.g:1278:2: ()
            // InternalRtVil.g:1279:2: 
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
            // InternalRtVil.g:1291:1: ( (lv_intent_2_0= ruleIntentDeclaration ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRtVil.g:1292:1: (lv_intent_2_0= ruleIntentDeclaration )
                    {
                    // InternalRtVil.g:1292:1: (lv_intent_2_0= ruleIntentDeclaration )
                    // InternalRtVil.g:1293:3: lv_intent_2_0= ruleIntentDeclaration
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

            // InternalRtVil.g:1309:3: ( (lv_elements_3_0= ruleRuleElement ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_EXPONENT)||LA29_0==14||LA29_0==16||(LA29_0>=31 && LA29_0<=32)||(LA29_0>=37 && LA29_0<=41)||LA29_0==43||(LA29_0>=45 && LA29_0<=46)||LA29_0==52||LA29_0==69||(LA29_0>=71 && LA29_0<=74)||(LA29_0>=80 && LA29_0<=86)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalRtVil.g:1310:1: (lv_elements_3_0= ruleRuleElement )
            	    {
            	    // InternalRtVil.g:1310:1: (lv_elements_3_0= ruleRuleElement )
            	    // InternalRtVil.g:1311:3: lv_elements_3_0= ruleRuleElement
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
    // InternalRtVil.g:1339:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // InternalRtVil.g:1340:2: (iv_ruleRuleElement= ruleRuleElement EOF )
            // InternalRtVil.g:1341:2: iv_ruleRuleElement= ruleRuleElement EOF
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
    // InternalRtVil.g:1348:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) ) ;
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
            // InternalRtVil.g:1351:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) ) )
            // InternalRtVil.g:1352:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )
            {
            // InternalRtVil.g:1352:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )
            int alt32=5;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalRtVil.g:1352:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalRtVil.g:1352:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // InternalRtVil.g:1353:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // InternalRtVil.g:1353:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // InternalRtVil.g:1354:3: lv_varDecl_0_0= ruleVariableDeclaration
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
                    // InternalRtVil.g:1371:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:1371:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:1372:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:1372:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // InternalRtVil.g:1373:3: lv_exprStmt_1_0= ruleExpressionStatement
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
                    // InternalRtVil.g:1390:6: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    {
                    // InternalRtVil.g:1390:6: ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? )
                    // InternalRtVil.g:1390:7: ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )?
                    {
                    // InternalRtVil.g:1390:7: ( (lv_while_2_0= ruleWhile ) )
                    // InternalRtVil.g:1391:1: (lv_while_2_0= ruleWhile )
                    {
                    // InternalRtVil.g:1391:1: (lv_while_2_0= ruleWhile )
                    // InternalRtVil.g:1392:3: lv_while_2_0= ruleWhile
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.While");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalRtVil.g:1408:2: (otherlv_3= ';' )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==18) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // InternalRtVil.g:1408:4: otherlv_3= ';'
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
                    // InternalRtVil.g:1413:6: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    {
                    // InternalRtVil.g:1413:6: ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? )
                    // InternalRtVil.g:1413:7: ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )?
                    {
                    // InternalRtVil.g:1413:7: ( (lv_for_4_0= ruleFor ) )
                    // InternalRtVil.g:1414:1: (lv_for_4_0= ruleFor )
                    {
                    // InternalRtVil.g:1414:1: (lv_for_4_0= ruleFor )
                    // InternalRtVil.g:1415:3: lv_for_4_0= ruleFor
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.For");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalRtVil.g:1431:2: (otherlv_5= ';' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==18) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalRtVil.g:1431:4: otherlv_5= ';'
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
                    // InternalRtVil.g:1436:6: ( (lv_fail_6_0= ruleFailStatement ) )
                    {
                    // InternalRtVil.g:1436:6: ( (lv_fail_6_0= ruleFailStatement ) )
                    // InternalRtVil.g:1437:1: (lv_fail_6_0= ruleFailStatement )
                    {
                    // InternalRtVil.g:1437:1: (lv_fail_6_0= ruleFailStatement )
                    // InternalRtVil.g:1438:3: lv_fail_6_0= ruleFailStatement
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
    // InternalRtVil.g:1462:1: entryRuleIntentDeclaration returns [EObject current=null] : iv_ruleIntentDeclaration= ruleIntentDeclaration EOF ;
    public final EObject entryRuleIntentDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentDeclaration = null;


        try {
            // InternalRtVil.g:1463:2: (iv_ruleIntentDeclaration= ruleIntentDeclaration EOF )
            // InternalRtVil.g:1464:2: iv_ruleIntentDeclaration= ruleIntentDeclaration EOF
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
    // InternalRtVil.g:1471:1: ruleIntentDeclaration returns [EObject current=null] : (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) ;
    public final EObject ruleIntentDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_exprStmt_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1474:28: ( (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) )
            // InternalRtVil.g:1475:1: (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            {
            // InternalRtVil.g:1475:1: (otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            // InternalRtVil.g:1475:3: otherlv_0= 'intent' ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIntentDeclarationAccess().getIntentKeyword_0());
                  
            }
            // InternalRtVil.g:1479:1: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
            // InternalRtVil.g:1480:1: (lv_exprStmt_1_0= ruleExpressionStatement )
            {
            // InternalRtVil.g:1480:1: (lv_exprStmt_1_0= ruleExpressionStatement )
            // InternalRtVil.g:1481:3: lv_exprStmt_1_0= ruleExpressionStatement
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
                      		"de.uni_hildesheim.sse.VilBuildLanguage.ExpressionStatement");
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
    // InternalRtVil.g:1505:1: entryRuleFailStatement returns [EObject current=null] : iv_ruleFailStatement= ruleFailStatement EOF ;
    public final EObject entryRuleFailStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailStatement = null;


        try {
            // InternalRtVil.g:1506:2: (iv_ruleFailStatement= ruleFailStatement EOF )
            // InternalRtVil.g:1507:2: iv_ruleFailStatement= ruleFailStatement EOF
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
    // InternalRtVil.g:1514:1: ruleFailStatement returns [EObject current=null] : ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' ) ;
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
            // InternalRtVil.g:1517:28: ( ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' ) )
            // InternalRtVil.g:1518:1: ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' )
            {
            // InternalRtVil.g:1518:1: ( ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';' )
            // InternalRtVil.g:1518:2: ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) ) otherlv_5= ';'
            {
            // InternalRtVil.g:1518:2: ( ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? ) | ( (lv_name_4_0= 'refail' ) ) )
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
                    // InternalRtVil.g:1518:3: ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? )
                    {
                    // InternalRtVil.g:1518:3: ( ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )? )
                    // InternalRtVil.g:1518:4: ( (lv_name_0_0= 'fail' ) ) ( (lv_reason_1_0= ruleExpression ) )? (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )?
                    {
                    // InternalRtVil.g:1518:4: ( (lv_name_0_0= 'fail' ) )
                    // InternalRtVil.g:1519:1: (lv_name_0_0= 'fail' )
                    {
                    // InternalRtVil.g:1519:1: (lv_name_0_0= 'fail' )
                    // InternalRtVil.g:1520:3: lv_name_0_0= 'fail'
                    {
                    lv_name_0_0=(Token)match(input,31,FOLLOW_37); if (state.failed) return current;
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

                    // InternalRtVil.g:1533:2: ( (lv_reason_1_0= ruleExpression ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_EXPONENT)||LA33_0==14||LA33_0==16||(LA33_0>=37 && LA33_0<=38)||LA33_0==43||LA33_0==45||LA33_0==52||LA33_0==69||(LA33_0>=71 && LA33_0<=74)||(LA33_0>=80 && LA33_0<=82)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // InternalRtVil.g:1534:1: (lv_reason_1_0= ruleExpression )
                            {
                            // InternalRtVil.g:1534:1: (lv_reason_1_0= ruleExpression )
                            // InternalRtVil.g:1535:3: lv_reason_1_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFailStatementAccess().getReasonExpressionParserRuleCall_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_38);
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

                    // InternalRtVil.g:1551:3: (otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==27) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalRtVil.g:1551:5: otherlv_2= 'with' ( (lv_code_3_0= ruleExpression ) )
                            {
                            otherlv_2=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getFailStatementAccess().getWithKeyword_0_0_2_0());
                                  
                            }
                            // InternalRtVil.g:1555:1: ( (lv_code_3_0= ruleExpression ) )
                            // InternalRtVil.g:1556:1: (lv_code_3_0= ruleExpression )
                            {
                            // InternalRtVil.g:1556:1: (lv_code_3_0= ruleExpression )
                            // InternalRtVil.g:1557:3: lv_code_3_0= ruleExpression
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
                    // InternalRtVil.g:1574:6: ( (lv_name_4_0= 'refail' ) )
                    {
                    // InternalRtVil.g:1574:6: ( (lv_name_4_0= 'refail' ) )
                    // InternalRtVil.g:1575:1: (lv_name_4_0= 'refail' )
                    {
                    // InternalRtVil.g:1575:1: (lv_name_4_0= 'refail' )
                    // InternalRtVil.g:1576:3: lv_name_4_0= 'refail'
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
    // InternalRtVil.g:1601:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // InternalRtVil.g:1602:2: (iv_ruleRequire= ruleRequire EOF )
            // InternalRtVil.g:1603:2: iv_ruleRequire= ruleRequire EOF
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
    // InternalRtVil.g:1610:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1613:28: ( (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) )
            // InternalRtVil.g:1614:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            {
            // InternalRtVil.g:1614:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            // InternalRtVil.g:1614:3: otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireVTLKeyword_0());
                  
            }
            // InternalRtVil.g:1618:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalRtVil.g:1619:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalRtVil.g:1619:1: (lv_name_1_0= RULE_STRING )
            // InternalRtVil.g:1620:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_40); if (state.failed) return current;
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

            // InternalRtVil.g:1636:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )
            // InternalRtVil.g:1637:1: (lv_versionSpec_2_0= ruleVersionSpec )
            {
            // InternalRtVil.g:1637:1: (lv_versionSpec_2_0= ruleVersionSpec )
            // InternalRtVil.g:1638:3: lv_versionSpec_2_0= ruleVersionSpec
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
    // InternalRtVil.g:1666:1: entryRuleScriptParentDecl returns [EObject current=null] : iv_ruleScriptParentDecl= ruleScriptParentDecl EOF ;
    public final EObject entryRuleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptParentDecl = null;


        try {
            // InternalRtVil.g:1667:2: (iv_ruleScriptParentDecl= ruleScriptParentDecl EOF )
            // InternalRtVil.g:1668:2: iv_ruleScriptParentDecl= ruleScriptParentDecl EOF
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
    // InternalRtVil.g:1675:1: ruleScriptParentDecl returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1678:28: ( (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // InternalRtVil.g:1679:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // InternalRtVil.g:1679:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            // InternalRtVil.g:1679:3: otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScriptParentDeclAccess().getExtendsKeyword_0());
                  
            }
            // InternalRtVil.g:1683:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:1684:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:1684:1: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:1685:3: lv_name_1_0= ruleIdentifier
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
    // InternalRtVil.g:1713:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // InternalRtVil.g:1714:2: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // InternalRtVil.g:1715:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
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
    // InternalRtVil.g:1722:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) ;
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
            // InternalRtVil.g:1725:28: ( ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) )
            // InternalRtVil.g:1726:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            {
            // InternalRtVil.g:1726:1: ( () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            // InternalRtVil.g:1726:2: () ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )?
            {
            // InternalRtVil.g:1726:2: ()
            // InternalRtVil.g:1727:2: 
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

            // InternalRtVil.g:1735:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // InternalRtVil.g:1735:3: ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
                    {
                    // InternalRtVil.g:1735:3: ( (lv_modifier_1_0= ruleRuleModifier ) )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==35) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // InternalRtVil.g:1736:1: (lv_modifier_1_0= ruleRuleModifier )
                            {
                            // InternalRtVil.g:1736:1: (lv_modifier_1_0= ruleRuleModifier )
                            // InternalRtVil.g:1737:3: lv_modifier_1_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_41);
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

                    // InternalRtVil.g:1753:3: ( (lv_type_2_0= ruleType ) )?
                    int alt37=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA37_1 = input.LA(2);

                            if ( (LA37_1==RULE_VERSION||(LA37_1>=RULE_ID && LA37_1<=RULE_EXPONENT)||LA37_1==52||LA37_1==79) ) {
                                alt37=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA37_2 = input.LA(2);

                            if ( (LA37_2==RULE_VERSION||(LA37_2>=RULE_ID && LA37_2<=RULE_EXPONENT)||LA37_2==52||LA37_2==79) ) {
                                alt37=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA37_3 = input.LA(2);

                            if ( (LA37_3==RULE_VERSION||(LA37_3>=RULE_ID && LA37_3<=RULE_EXPONENT)||LA37_3==52||LA37_3==79) ) {
                                alt37=1;
                            }
                            }
                            break;
                        case 52:
                            {
                            int LA37_4 = input.LA(2);

                            if ( (LA37_4==RULE_VERSION||(LA37_4>=RULE_ID && LA37_4<=RULE_EXPONENT)||LA37_4==52||LA37_4==79) ) {
                                alt37=1;
                            }
                            }
                            break;
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                            {
                            alt37=1;
                            }
                            break;
                    }

                    switch (alt37) {
                        case 1 :
                            // InternalRtVil.g:1754:1: (lv_type_2_0= ruleType )
                            {
                            // InternalRtVil.g:1754:1: (lv_type_2_0= ruleType )
                            // InternalRtVil.g:1755:3: lv_type_2_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_7);
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

                    // InternalRtVil.g:1771:3: ( (lv_name_3_0= ruleIdentifier ) )
                    // InternalRtVil.g:1772:1: (lv_name_3_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:1772:1: (lv_name_3_0= ruleIdentifier )
                    // InternalRtVil.g:1773:3: lv_name_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_8);
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

                    otherlv_4=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_3());
                          
                    }
                    // InternalRtVil.g:1793:1: ( (lv_paramList_5_0= ruleParameterList ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_VERSION||(LA38_0>=RULE_ID && LA38_0<=RULE_EXPONENT)||LA38_0==52||(LA38_0>=83 && LA38_0<=86)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalRtVil.g:1794:1: (lv_paramList_5_0= ruleParameterList )
                            {
                            // InternalRtVil.g:1794:1: (lv_paramList_5_0= ruleParameterList )
                            // InternalRtVil.g:1795:3: lv_paramList_5_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_10);
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

                    otherlv_6=(Token)match(input,15,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_5());
                          
                    }
                    otherlv_7=(Token)match(input,21,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_6());
                          
                    }

                    }
                    break;

            }

            // InternalRtVil.g:1819:3: ( (lv_conditions_8_0= ruleRuleConditions ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_EXPONENT)||LA40_0==14||LA40_0==25||(LA40_0>=37 && LA40_0<=38)||LA40_0==43||LA40_0==45||LA40_0==52||LA40_0==69||(LA40_0>=71 && LA40_0<=74)||(LA40_0>=80 && LA40_0<=82)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalRtVil.g:1820:1: (lv_conditions_8_0= ruleRuleConditions )
                    {
                    // InternalRtVil.g:1820:1: (lv_conditions_8_0= ruleRuleConditions )
                    // InternalRtVil.g:1821:3: lv_conditions_8_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_34);
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

            // InternalRtVil.g:1837:3: ( (lv_block_9_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:1838:1: (lv_block_9_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:1838:1: (lv_block_9_0= ruleRuleElementBlock )
            // InternalRtVil.g:1839:3: lv_block_9_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_15);
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
                      		"de.uni_hildesheim.sse.vil.rt.RtVil.RuleElementBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalRtVil.g:1855:2: (otherlv_10= ';' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==18) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRtVil.g:1855:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:1867:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // InternalRtVil.g:1868:2: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // InternalRtVil.g:1869:2: iv_ruleRuleConditions= ruleRuleConditions EOF
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
    // InternalRtVil.g:1876:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:1879:28: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // InternalRtVil.g:1880:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // InternalRtVil.g:1880:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // InternalRtVil.g:1880:2: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // InternalRtVil.g:1880:2: ()
            // InternalRtVil.g:1881:2: 
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

            // InternalRtVil.g:1889:2: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_EXPONENT)||LA42_0==14||(LA42_0>=37 && LA42_0<=38)||LA42_0==43||LA42_0==45||LA42_0==52||LA42_0==69||(LA42_0>=71 && LA42_0<=74)||(LA42_0>=80 && LA42_0<=82)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRtVil.g:1890:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:1890:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    // InternalRtVil.g:1891:3: lv_postcondition_1_0= ruleLogicalExpression
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

            otherlv_2=(Token)match(input,25,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
                  
            }
            // InternalRtVil.g:1911:1: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_EXPONENT)||LA44_0==14||(LA44_0>=37 && LA44_0<=38)||LA44_0==43||LA44_0==45||LA44_0==52||LA44_0==69||(LA44_0>=71 && LA44_0<=74)||(LA44_0>=80 && LA44_0<=82)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalRtVil.g:1911:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // InternalRtVil.g:1911:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:1912:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:1912:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    // InternalRtVil.g:1913:3: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_43);
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

                    // InternalRtVil.g:1929:2: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==28) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalRtVil.g:1929:4: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,28,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // InternalRtVil.g:1933:1: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // InternalRtVil.g:1934:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // InternalRtVil.g:1934:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // InternalRtVil.g:1935:3: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_43);
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
                    	    break loop43;
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
    // InternalRtVil.g:1959:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // InternalRtVil.g:1960:2: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // InternalRtVil.g:1961:2: iv_ruleRuleModifier= ruleRuleModifier EOF
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
    // InternalRtVil.g:1968:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:1971:28: ( ( (lv_protected_0_0= 'protected' ) ) )
            // InternalRtVil.g:1972:1: ( (lv_protected_0_0= 'protected' ) )
            {
            // InternalRtVil.g:1972:1: ( (lv_protected_0_0= 'protected' ) )
            // InternalRtVil.g:1973:1: (lv_protected_0_0= 'protected' )
            {
            // InternalRtVil.g:1973:1: (lv_protected_0_0= 'protected' )
            // InternalRtVil.g:1974:3: lv_protected_0_0= 'protected'
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
    // InternalRtVil.g:1995:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalRtVil.g:1996:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalRtVil.g:1997:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalRtVil.g:2004:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) ;
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
            // InternalRtVil.g:2007:28: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) )
            // InternalRtVil.g:2008:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            {
            // InternalRtVil.g:2008:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_STRING && LA48_0<=RULE_EXPONENT)||LA48_0==14||LA48_0==16||(LA48_0>=37 && LA48_0<=38)||LA48_0==43||LA48_0==45||LA48_0==52||LA48_0==69||(LA48_0>=71 && LA48_0<=74)||(LA48_0>=80 && LA48_0<=82)) ) {
                alt48=1;
            }
            else if ( (LA48_0==41) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalRtVil.g:2008:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    {
                    // InternalRtVil.g:2008:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    // InternalRtVil.g:2008:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
                    {
                    // InternalRtVil.g:2008:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
                    int alt46=2;
                    alt46 = dfa46.predict(input);
                    switch (alt46) {
                        case 1 :
                            // InternalRtVil.g:2008:4: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                            {
                            // InternalRtVil.g:2008:4: ( (lv_var_0_0= ruleIdentifier ) )
                            // InternalRtVil.g:2009:1: (lv_var_0_0= ruleIdentifier )
                            {
                            // InternalRtVil.g:2009:1: (lv_var_0_0= ruleIdentifier )
                            // InternalRtVil.g:2010:3: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_44);
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

                            // InternalRtVil.g:2026:2: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==36) ) {
                                alt45=1;
                            }
                            switch (alt45) {
                                case 1 :
                                    // InternalRtVil.g:2026:4: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                                    {
                                    otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_0_1_0());
                                          
                                    }
                                    // InternalRtVil.g:2030:1: ( (lv_field_2_0= ruleIdentifier ) )
                                    // InternalRtVil.g:2031:1: (lv_field_2_0= ruleIdentifier )
                                    {
                                    // InternalRtVil.g:2031:1: (lv_field_2_0= ruleIdentifier )
                                    // InternalRtVil.g:2032:3: lv_field_2_0= ruleIdentifier
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

                    // InternalRtVil.g:2052:3: ( (lv_expr_4_0= ruleExpression ) )
                    // InternalRtVil.g:2053:1: (lv_expr_4_0= ruleExpression )
                    {
                    // InternalRtVil.g:2053:1: (lv_expr_4_0= ruleExpression )
                    // InternalRtVil.g:2054:3: lv_expr_4_0= ruleExpression
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
                    // InternalRtVil.g:2075:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    {
                    // InternalRtVil.g:2075:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    // InternalRtVil.g:2075:7: ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )?
                    {
                    // InternalRtVil.g:2075:7: ( (lv_alt_6_0= ruleAlternative ) )
                    // InternalRtVil.g:2076:1: (lv_alt_6_0= ruleAlternative )
                    {
                    // InternalRtVil.g:2076:1: (lv_alt_6_0= ruleAlternative )
                    // InternalRtVil.g:2077:3: lv_alt_6_0= ruleAlternative
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
                              		"de.uni_hildesheim.sse.VilBuildLanguage.Alternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalRtVil.g:2093:2: (otherlv_7= ';' )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==18) ) {
                        int LA47_1 = input.LA(2);

                        if ( (synpred57_InternalRtVil()) ) {
                            alt47=1;
                        }
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalRtVil.g:2093:4: otherlv_7= ';'
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
    // InternalRtVil.g:2105:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalRtVil.g:2106:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalRtVil.g:2107:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalRtVil.g:2114:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // InternalRtVil.g:2117:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // InternalRtVil.g:2118:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // InternalRtVil.g:2118:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt49=8;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // InternalRtVil.g:2118:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // InternalRtVil.g:2118:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // InternalRtVil.g:2119:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // InternalRtVil.g:2119:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // InternalRtVil.g:2120:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
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
                    // InternalRtVil.g:2137:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // InternalRtVil.g:2137:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // InternalRtVil.g:2138:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // InternalRtVil.g:2138:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // InternalRtVil.g:2139:3: lv_unqEx_1_0= ruleUnqualifiedExecution
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
                    // InternalRtVil.g:2156:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // InternalRtVil.g:2156:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // InternalRtVil.g:2157:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // InternalRtVil.g:2157:1: (lv_superEx_2_0= ruleSuperExecution )
                    // InternalRtVil.g:2158:3: lv_superEx_2_0= ruleSuperExecution
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
                    // InternalRtVil.g:2175:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // InternalRtVil.g:2175:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // InternalRtVil.g:2176:1: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // InternalRtVil.g:2176:1: (lv_sysEx_3_0= ruleSystemExecution )
                    // InternalRtVil.g:2177:3: lv_sysEx_3_0= ruleSystemExecution
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
                    // InternalRtVil.g:2194:6: ( (lv_map_4_0= ruleMap ) )
                    {
                    // InternalRtVil.g:2194:6: ( (lv_map_4_0= ruleMap ) )
                    // InternalRtVil.g:2195:1: (lv_map_4_0= ruleMap )
                    {
                    // InternalRtVil.g:2195:1: (lv_map_4_0= ruleMap )
                    // InternalRtVil.g:2196:3: lv_map_4_0= ruleMap
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
                    // InternalRtVil.g:2213:6: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // InternalRtVil.g:2213:6: ( (lv_join_5_0= ruleJoin ) )
                    // InternalRtVil.g:2214:1: (lv_join_5_0= ruleJoin )
                    {
                    // InternalRtVil.g:2214:1: (lv_join_5_0= ruleJoin )
                    // InternalRtVil.g:2215:3: lv_join_5_0= ruleJoin
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
                    // InternalRtVil.g:2232:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // InternalRtVil.g:2232:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // InternalRtVil.g:2233:1: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // InternalRtVil.g:2233:1: (lv_instantiate_6_0= ruleInstantiate )
                    // InternalRtVil.g:2234:3: lv_instantiate_6_0= ruleInstantiate
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
                    // InternalRtVil.g:2251:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // InternalRtVil.g:2251:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // InternalRtVil.g:2252:1: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // InternalRtVil.g:2252:1: (lv_newEx_7_0= ruleConstructorExecution )
                    // InternalRtVil.g:2253:3: lv_newEx_7_0= ruleConstructorExecution
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
    // InternalRtVil.g:2277:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // InternalRtVil.g:2278:2: (iv_ruleInstantiate= ruleInstantiate EOF )
            // InternalRtVil.g:2279:2: iv_ruleInstantiate= ruleInstantiate EOF
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
    // InternalRtVil.g:2286:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) ;
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
            // InternalRtVil.g:2289:28: ( (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? ) )
            // InternalRtVil.g:2290:1: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            {
            // InternalRtVil.g:2290:1: (otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )? )
            // InternalRtVil.g:2290:3: otherlv_0= 'instantiate' ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) ) otherlv_3= '(' ( (lv_param_4_0= ruleArgumentList ) )? otherlv_5= ')' ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
                  
            }
            // InternalRtVil.g:2294:1: ( ( (lv_project_1_0= ruleIdentifier ) ) | ( (lv_ruleName_2_0= RULE_STRING ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_VERSION||(LA50_0>=RULE_ID && LA50_0<=RULE_EXPONENT)||LA50_0==52) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_STRING) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalRtVil.g:2294:2: ( (lv_project_1_0= ruleIdentifier ) )
                    {
                    // InternalRtVil.g:2294:2: ( (lv_project_1_0= ruleIdentifier ) )
                    // InternalRtVil.g:2295:1: (lv_project_1_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:2295:1: (lv_project_1_0= ruleIdentifier )
                    // InternalRtVil.g:2296:3: lv_project_1_0= ruleIdentifier
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
                    // InternalRtVil.g:2313:6: ( (lv_ruleName_2_0= RULE_STRING ) )
                    {
                    // InternalRtVil.g:2313:6: ( (lv_ruleName_2_0= RULE_STRING ) )
                    // InternalRtVil.g:2314:1: (lv_ruleName_2_0= RULE_STRING )
                    {
                    // InternalRtVil.g:2314:1: (lv_ruleName_2_0= RULE_STRING )
                    // InternalRtVil.g:2315:3: lv_ruleName_2_0= RULE_STRING
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
            // InternalRtVil.g:2335:1: ( (lv_param_4_0= ruleArgumentList ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=RULE_STRING && LA51_0<=RULE_EXPONENT)||LA51_0==14||LA51_0==16||(LA51_0>=37 && LA51_0<=38)||LA51_0==43||LA51_0==45||LA51_0==52||LA51_0==69||(LA51_0>=71 && LA51_0<=74)||(LA51_0>=80 && LA51_0<=82)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRtVil.g:2336:1: (lv_param_4_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:2336:1: (lv_param_4_0= ruleArgumentList )
                    // InternalRtVil.g:2337:3: lv_param_4_0= ruleArgumentList
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

            otherlv_5=(Token)match(input,15,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalRtVil.g:2357:1: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalRtVil.g:2358:1: (lv_versionSpec_6_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:2358:1: (lv_versionSpec_6_0= ruleVersionSpec )
                    // InternalRtVil.g:2359:3: lv_versionSpec_6_0= ruleVersionSpec
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
    // InternalRtVil.g:2383:1: entryRuleLoopVariable returns [EObject current=null] : iv_ruleLoopVariable= ruleLoopVariable EOF ;
    public final EObject entryRuleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariable = null;


        try {
            // InternalRtVil.g:2384:2: (iv_ruleLoopVariable= ruleLoopVariable EOF )
            // InternalRtVil.g:2385:2: iv_ruleLoopVariable= ruleLoopVariable EOF
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
    // InternalRtVil.g:2392:1: ruleLoopVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleLoopVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:2395:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // InternalRtVil.g:2396:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // InternalRtVil.g:2396:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // InternalRtVil.g:2396:2: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // InternalRtVil.g:2396:2: ( (lv_type_0_0= ruleType ) )?
            int alt53=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==RULE_VERSION||(LA53_1>=RULE_ID && LA53_1<=RULE_EXPONENT)||LA53_1==52||LA53_1==79) ) {
                        alt53=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA53_2 = input.LA(2);

                    if ( (LA53_2==RULE_VERSION||(LA53_2>=RULE_ID && LA53_2<=RULE_EXPONENT)||LA53_2==52||LA53_2==79) ) {
                        alt53=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA53_3 = input.LA(2);

                    if ( (LA53_3==RULE_VERSION||(LA53_3>=RULE_ID && LA53_3<=RULE_EXPONENT)||LA53_3==52||LA53_3==79) ) {
                        alt53=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA53_4 = input.LA(2);

                    if ( (LA53_4==RULE_VERSION||(LA53_4>=RULE_ID && LA53_4<=RULE_EXPONENT)||LA53_4==52||LA53_4==79) ) {
                        alt53=1;
                    }
                    }
                    break;
                case 83:
                case 84:
                case 85:
                case 86:
                    {
                    alt53=1;
                    }
                    break;
            }

            switch (alt53) {
                case 1 :
                    // InternalRtVil.g:2397:1: (lv_type_0_0= ruleType )
                    {
                    // InternalRtVil.g:2397:1: (lv_type_0_0= ruleType )
                    // InternalRtVil.g:2398:3: lv_type_0_0= ruleType
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

            // InternalRtVil.g:2414:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalRtVil.g:2415:1: (lv_var_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:2415:1: (lv_var_1_0= ruleIdentifier )
            // InternalRtVil.g:2416:3: lv_var_1_0= ruleIdentifier
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
    // InternalRtVil.g:2440:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // InternalRtVil.g:2441:2: (iv_ruleMap= ruleMap EOF )
            // InternalRtVil.g:2442:2: iv_ruleMap= ruleMap EOF
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
    // InternalRtVil.g:2449:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalRtVil.g:2452:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2453:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2453:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2453:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:2461:1: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalRtVil.g:2462:1: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalRtVil.g:2462:1: (lv_var_2_0= ruleLoopVariable )
            // InternalRtVil.g:2463:3: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
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

            // InternalRtVil.g:2479:2: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==28) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalRtVil.g:2479:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalRtVil.g:2483:1: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalRtVil.g:2484:1: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalRtVil.g:2484:1: (lv_var_4_0= ruleLoopVariable )
            	    // InternalRtVil.g:2485:3: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarLoopVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_47);
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
            	    break loop54;
                }
            } while (true);

            // InternalRtVil.g:2501:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalRtVil.g:2502:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalRtVil.g:2502:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalRtVil.g:2503:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalRtVil.g:2503:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==21) ) {
                alt55=1;
            }
            else if ( (LA55_0==25) ) {
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
                    // InternalRtVil.g:2504:3: lv_separator_5_1= '='
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
                    // InternalRtVil.g:2516:8: lv_separator_5_2= ':'
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

            // InternalRtVil.g:2531:2: ( (lv_expr_6_0= ruleExpression ) )
            // InternalRtVil.g:2532:1: (lv_expr_6_0= ruleExpression )
            {
            // InternalRtVil.g:2532:1: (lv_expr_6_0= ruleExpression )
            // InternalRtVil.g:2533:3: lv_expr_6_0= ruleExpression
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
            // InternalRtVil.g:2553:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2554:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2554:1: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:2555:3: lv_block_8_0= ruleRuleElementBlock
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
    // InternalRtVil.g:2579:1: entryRuleFor returns [EObject current=null] : iv_ruleFor= ruleFor EOF ;
    public final EObject entryRuleFor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor = null;


        try {
            // InternalRtVil.g:2580:2: (iv_ruleFor= ruleFor EOF )
            // InternalRtVil.g:2581:2: iv_ruleFor= ruleFor EOF
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
    // InternalRtVil.g:2588:1: ruleFor returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // InternalRtVil.g:2591:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2592:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2592:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2592:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_var_2_0= ruleLoopVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getForAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getForAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:2600:1: ( (lv_var_2_0= ruleLoopVariable ) )
            // InternalRtVil.g:2601:1: (lv_var_2_0= ruleLoopVariable )
            {
            // InternalRtVil.g:2601:1: (lv_var_2_0= ruleLoopVariable )
            // InternalRtVil.g:2602:3: lv_var_2_0= ruleLoopVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_47);
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

            // InternalRtVil.g:2618:2: (otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==28) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalRtVil.g:2618:4: otherlv_3= ',' ( (lv_var_4_0= ruleLoopVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,28,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getForAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // InternalRtVil.g:2622:1: ( (lv_var_4_0= ruleLoopVariable ) )
            	    // InternalRtVil.g:2623:1: (lv_var_4_0= ruleLoopVariable )
            	    {
            	    // InternalRtVil.g:2623:1: (lv_var_4_0= ruleLoopVariable )
            	    // InternalRtVil.g:2624:3: lv_var_4_0= ruleLoopVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getForAccess().getVarLoopVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_47);
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
            	    break loop56;
                }
            } while (true);

            // InternalRtVil.g:2640:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // InternalRtVil.g:2641:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // InternalRtVil.g:2641:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // InternalRtVil.g:2642:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // InternalRtVil.g:2642:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==21) ) {
                alt57=1;
            }
            else if ( (LA57_0==25) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalRtVil.g:2643:3: lv_separator_5_1= '='
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
                    // InternalRtVil.g:2655:8: lv_separator_5_2= ':'
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

            // InternalRtVil.g:2670:2: ( (lv_expr_6_0= ruleExpression ) )
            // InternalRtVil.g:2671:1: (lv_expr_6_0= ruleExpression )
            {
            // InternalRtVil.g:2671:1: (lv_expr_6_0= ruleExpression )
            // InternalRtVil.g:2672:3: lv_expr_6_0= ruleExpression
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
            // InternalRtVil.g:2692:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2693:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2693:1: (lv_block_8_0= ruleRuleElementBlock )
            // InternalRtVil.g:2694:3: lv_block_8_0= ruleRuleElementBlock
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
    // InternalRtVil.g:2718:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalRtVil.g:2719:2: (iv_ruleWhile= ruleWhile EOF )
            // InternalRtVil.g:2720:2: iv_ruleWhile= ruleWhile EOF
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
    // InternalRtVil.g:2727:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;

        EObject lv_block_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:2730:28: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2731:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2731:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) ) )
            // InternalRtVil.g:2731:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:2739:1: ( (lv_expr_2_0= ruleExpression ) )
            // InternalRtVil.g:2740:1: (lv_expr_2_0= ruleExpression )
            {
            // InternalRtVil.g:2740:1: (lv_expr_2_0= ruleExpression )
            // InternalRtVil.g:2741:3: lv_expr_2_0= ruleExpression
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
            // InternalRtVil.g:2761:1: ( (lv_block_4_0= ruleRuleElementBlock ) )
            // InternalRtVil.g:2762:1: (lv_block_4_0= ruleRuleElementBlock )
            {
            // InternalRtVil.g:2762:1: (lv_block_4_0= ruleRuleElementBlock )
            // InternalRtVil.g:2763:3: lv_block_4_0= ruleRuleElementBlock
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
    // InternalRtVil.g:2787:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalRtVil.g:2788:2: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalRtVil.g:2789:2: iv_ruleAlternative= ruleAlternative EOF
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
    // InternalRtVil.g:2796:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
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
            // InternalRtVil.g:2799:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // InternalRtVil.g:2800:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // InternalRtVil.g:2800:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // InternalRtVil.g:2800:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:2808:1: ( (lv_expr_2_0= ruleExpression ) )
            // InternalRtVil.g:2809:1: (lv_expr_2_0= ruleExpression )
            {
            // InternalRtVil.g:2809:1: (lv_expr_2_0= ruleExpression )
            // InternalRtVil.g:2810:3: lv_expr_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,15,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalRtVil.g:2830:1: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // InternalRtVil.g:2831:1: (lv_if_4_0= ruleStatementOrBlock )
            {
            // InternalRtVil.g:2831:1: (lv_if_4_0= ruleStatementOrBlock )
            // InternalRtVil.g:2832:3: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_49);
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

            // InternalRtVil.g:2848:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==42) ) {
                int LA58_1 = input.LA(2);

                if ( (synpred74_InternalRtVil()) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // InternalRtVil.g:2848:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // InternalRtVil.g:2848:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalRtVil.g:2848:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // InternalRtVil.g:2853:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // InternalRtVil.g:2854:1: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // InternalRtVil.g:2854:1: (lv_else_6_0= ruleStatementOrBlock )
                    // InternalRtVil.g:2855:3: lv_else_6_0= ruleStatementOrBlock
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
    // InternalRtVil.g:2879:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // InternalRtVil.g:2880:2: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // InternalRtVil.g:2881:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
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
    // InternalRtVil.g:2888:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:2891:28: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // InternalRtVil.g:2892:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // InternalRtVil.g:2892:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt59=2;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // InternalRtVil.g:2892:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // InternalRtVil.g:2892:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // InternalRtVil.g:2893:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // InternalRtVil.g:2893:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    // InternalRtVil.g:2894:3: lv_exStmt_0_0= ruleExpressionStatement
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
                    // InternalRtVil.g:2911:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // InternalRtVil.g:2911:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // InternalRtVil.g:2912:1: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // InternalRtVil.g:2912:1: (lv_block_1_0= ruleRuleElementBlock )
                    // InternalRtVil.g:2913:3: lv_block_1_0= ruleRuleElementBlock
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
    // InternalRtVil.g:2937:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalRtVil.g:2938:2: (iv_ruleJoin= ruleJoin EOF )
            // InternalRtVil.g:2939:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalRtVil.g:2946:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // InternalRtVil.g:2949:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // InternalRtVil.g:2950:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // InternalRtVil.g:2950:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // InternalRtVil.g:2950:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:2958:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // InternalRtVil.g:2959:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // InternalRtVil.g:2959:1: (lv_var1_2_0= ruleJoinVariable )
            // InternalRtVil.g:2960:3: lv_var1_2_0= ruleJoinVariable
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
                      		"de.uni_hildesheim.sse.VilBuildLanguage.JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // InternalRtVil.g:2980:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // InternalRtVil.g:2981:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // InternalRtVil.g:2981:1: (lv_var2_4_0= ruleJoinVariable )
            // InternalRtVil.g:2982:3: lv_var2_4_0= ruleJoinVariable
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
                      		"de.uni_hildesheim.sse.VilBuildLanguage.JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // InternalRtVil.g:3002:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalRtVil.g:3002:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // InternalRtVil.g:3010:1: ( (lv_condition_8_0= ruleExpression ) )
                    // InternalRtVil.g:3011:1: (lv_condition_8_0= ruleExpression )
                    {
                    // InternalRtVil.g:3011:1: (lv_condition_8_0= ruleExpression )
                    // InternalRtVil.g:3012:3: lv_condition_8_0= ruleExpression
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
    // InternalRtVil.g:3040:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // InternalRtVil.g:3041:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // InternalRtVil.g:3042:2: iv_ruleJoinVariable= ruleJoinVariable EOF
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
    // InternalRtVil.g:3049:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3052:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // InternalRtVil.g:3053:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:3053:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // InternalRtVil.g:3053:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // InternalRtVil.g:3053:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==44) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRtVil.g:3054:1: (lv_excl_0_0= 'exclude' )
                    {
                    // InternalRtVil.g:3054:1: (lv_excl_0_0= 'exclude' )
                    // InternalRtVil.g:3055:3: lv_excl_0_0= 'exclude'
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

            // InternalRtVil.g:3068:3: ( (lv_var_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3069:1: (lv_var_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3069:1: (lv_var_1_0= ruleIdentifier )
            // InternalRtVil.g:3070:3: lv_var_1_0= ruleIdentifier
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
            // InternalRtVil.g:3090:1: ( (lv_expr_3_0= ruleExpression ) )
            // InternalRtVil.g:3091:1: (lv_expr_3_0= ruleExpression )
            {
            // InternalRtVil.g:3091:1: (lv_expr_3_0= ruleExpression )
            // InternalRtVil.g:3092:3: lv_expr_3_0= ruleExpression
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
    // InternalRtVil.g:3116:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // InternalRtVil.g:3117:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // InternalRtVil.g:3118:2: iv_ruleSystemExecution= ruleSystemExecution EOF
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
    // InternalRtVil.g:3125:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3128:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:3129:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:3129:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // InternalRtVil.g:3129:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,45,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // InternalRtVil.g:3133:1: ( (lv_call_1_0= ruleCall ) )
            // InternalRtVil.g:3134:1: (lv_call_1_0= ruleCall )
            {
            // InternalRtVil.g:3134:1: (lv_call_1_0= ruleCall )
            // InternalRtVil.g:3135:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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

            // InternalRtVil.g:3151:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==36||(LA62_0>=75 && LA62_0<=76)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalRtVil.g:3152:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:3152:1: (lv_calls_2_0= ruleSubCall )
            	    // InternalRtVil.g:3153:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    break loop62;
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
    // InternalRtVil.g:3177:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalRtVil.g:3178:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalRtVil.g:3179:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalRtVil.g:3186:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // InternalRtVil.g:3189:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // InternalRtVil.g:3190:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // InternalRtVil.g:3190:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // InternalRtVil.g:3190:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // InternalRtVil.g:3190:2: ( (lv_const_0_0= 'const' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==46) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRtVil.g:3191:1: (lv_const_0_0= 'const' )
                    {
                    // InternalRtVil.g:3191:1: (lv_const_0_0= 'const' )
                    // InternalRtVil.g:3192:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,46,FOLLOW_41); if (state.failed) return current;
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

            // InternalRtVil.g:3205:3: ( (lv_type_1_0= ruleType ) )
            // InternalRtVil.g:3206:1: (lv_type_1_0= ruleType )
            {
            // InternalRtVil.g:3206:1: (lv_type_1_0= ruleType )
            // InternalRtVil.g:3207:3: lv_type_1_0= ruleType
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

            // InternalRtVil.g:3223:2: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3224:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3224:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3225:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_52);
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

            // InternalRtVil.g:3241:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==21) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRtVil.g:3241:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // InternalRtVil.g:3245:1: ( (lv_expression_4_0= ruleExpression ) )
                    // InternalRtVil.g:3246:1: (lv_expression_4_0= ruleExpression )
                    {
                    // InternalRtVil.g:3246:1: (lv_expression_4_0= ruleExpression )
                    // InternalRtVil.g:3247:3: lv_expression_4_0= ruleExpression
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
    // InternalRtVil.g:3275:1: entryRuleCompound returns [EObject current=null] : iv_ruleCompound= ruleCompound EOF ;
    public final EObject entryRuleCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompound = null;


        try {
            // InternalRtVil.g:3276:2: (iv_ruleCompound= ruleCompound EOF )
            // InternalRtVil.g:3277:2: iv_ruleCompound= ruleCompound EOF
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
    // InternalRtVil.g:3284:1: ruleCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) ;
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
            // InternalRtVil.g:3287:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) )
            // InternalRtVil.g:3288:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            {
            // InternalRtVil.g:3288:1: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            // InternalRtVil.g:3288:2: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )?
            {
            // InternalRtVil.g:3288:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==47) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRtVil.g:3289:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalRtVil.g:3289:1: (lv_abstract_0_0= 'abstract' )
                    // InternalRtVil.g:3290:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,47,FOLLOW_53); if (state.failed) return current;
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
            // InternalRtVil.g:3307:1: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3308:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3308:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3309:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCompoundAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_54);
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

            // InternalRtVil.g:3325:2: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==49) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRtVil.g:3325:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,49,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCompoundAccess().getRefinesKeyword_3_0());
                          
                    }
                    // InternalRtVil.g:3329:1: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalRtVil.g:3330:1: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:3330:1: (lv_super_4_0= ruleIdentifier )
                    // InternalRtVil.g:3331:3: lv_super_4_0= ruleIdentifier
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

            otherlv_5=(Token)match(input,16,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCompoundAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalRtVil.g:3351:1: ( (lv_vars_6_0= ruleVariableDeclaration ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_VERSION||(LA67_0>=RULE_ID && LA67_0<=RULE_EXPONENT)||LA67_0==46||LA67_0==52||(LA67_0>=83 && LA67_0<=86)) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalRtVil.g:3352:1: (lv_vars_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalRtVil.g:3352:1: (lv_vars_6_0= ruleVariableDeclaration )
            	    // InternalRtVil.g:3353:3: lv_vars_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompoundAccess().getVarsVariableDeclarationParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop67;
                }
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCompoundAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // InternalRtVil.g:3373:1: (otherlv_8= ';' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==18) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRtVil.g:3373:3: otherlv_8= ';'
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
    // InternalRtVil.g:3385:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalRtVil.g:3386:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalRtVil.g:3387:2: iv_ruleTypeDef= ruleTypeDef EOF
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
    // InternalRtVil.g:3394:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3397:28: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // InternalRtVil.g:3398:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // InternalRtVil.g:3398:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // InternalRtVil.g:3398:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
                  
            }
            // InternalRtVil.g:3402:1: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3403:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3403:1: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:3404:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_41);
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

            // InternalRtVil.g:3420:2: ( (lv_type_2_0= ruleType ) )
            // InternalRtVil.g:3421:1: (lv_type_2_0= ruleType )
            {
            // InternalRtVil.g:3421:1: (lv_type_2_0= ruleType )
            // InternalRtVil.g:3422:3: lv_type_2_0= ruleType
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
    // InternalRtVil.g:3450:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalRtVil.g:3451:2: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalRtVil.g:3452:2: iv_ruleAdvice= ruleAdvice EOF
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
    // InternalRtVil.g:3459:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3462:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // InternalRtVil.g:3463:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // InternalRtVil.g:3463:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // InternalRtVil.g:3463:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:3471:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalRtVil.g:3472:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalRtVil.g:3472:1: (lv_name_2_0= ruleQualifiedName )
            // InternalRtVil.g:3473:3: lv_name_2_0= ruleQualifiedName
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

            otherlv_3=(Token)match(input,15,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalRtVil.g:3493:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==27) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRtVil.g:3494:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:3494:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalRtVil.g:3495:3: lv_versionSpec_4_0= ruleVersionSpec
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
    // InternalRtVil.g:3519:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // InternalRtVil.g:3520:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // InternalRtVil.g:3521:2: iv_ruleVersionSpec= ruleVersionSpec EOF
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
    // InternalRtVil.g:3528:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3531:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // InternalRtVil.g:3532:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:3532:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // InternalRtVil.g:3532:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // InternalRtVil.g:3536:1: ( (lv_restriction_1_0= ruleExpression ) )
            // InternalRtVil.g:3537:1: (lv_restriction_1_0= ruleExpression )
            {
            // InternalRtVil.g:3537:1: (lv_restriction_1_0= ruleExpression )
            // InternalRtVil.g:3538:3: lv_restriction_1_0= ruleExpression
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
    // InternalRtVil.g:3562:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRtVil.g:3563:2: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRtVil.g:3564:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRtVil.g:3571:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3574:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // InternalRtVil.g:3575:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // InternalRtVil.g:3575:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // InternalRtVil.g:3575:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // InternalRtVil.g:3575:2: ( (lv_param_0_0= ruleParameter ) )
            // InternalRtVil.g:3576:1: (lv_param_0_0= ruleParameter )
            {
            // InternalRtVil.g:3576:1: (lv_param_0_0= ruleParameter )
            // InternalRtVil.g:3577:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
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

            // InternalRtVil.g:3593:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==28) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalRtVil.g:3593:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalRtVil.g:3597:1: ( (lv_param_2_0= ruleParameter ) )
            	    // InternalRtVil.g:3598:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // InternalRtVil.g:3598:1: (lv_param_2_0= ruleParameter )
            	    // InternalRtVil.g:3599:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // InternalRtVil.g:3623:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRtVil.g:3624:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalRtVil.g:3625:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRtVil.g:3632:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dflt_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3635:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) )
            // InternalRtVil.g:3636:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            {
            // InternalRtVil.g:3636:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            // InternalRtVil.g:3636:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            {
            // InternalRtVil.g:3636:2: ( (lv_type_0_0= ruleType ) )
            // InternalRtVil.g:3637:1: (lv_type_0_0= ruleType )
            {
            // InternalRtVil.g:3637:1: (lv_type_0_0= ruleType )
            // InternalRtVil.g:3638:3: lv_type_0_0= ruleType
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

            // InternalRtVil.g:3654:2: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalRtVil.g:3655:1: (lv_name_1_0= ruleIdentifier )
            {
            // InternalRtVil.g:3655:1: (lv_name_1_0= ruleIdentifier )
            // InternalRtVil.g:3656:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_56);
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

            // InternalRtVil.g:3672:2: (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==21) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRtVil.g:3672:4: otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2_0());
                          
                    }
                    // InternalRtVil.g:3676:1: ( (lv_dflt_3_0= ruleExpression ) )
                    // InternalRtVil.g:3677:1: (lv_dflt_3_0= ruleExpression )
                    {
                    // InternalRtVil.g:3677:1: (lv_dflt_3_0= ruleExpression )
                    // InternalRtVil.g:3678:3: lv_dflt_3_0= ruleExpression
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
    // InternalRtVil.g:3702:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalRtVil.g:3703:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalRtVil.g:3704:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalRtVil.g:3711:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:3714:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalRtVil.g:3715:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalRtVil.g:3715:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalRtVil.g:3715:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_57); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // InternalRtVil.g:3719:1: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalRtVil.g:3720:1: (lv_version_1_0= RULE_VERSION )
            {
            // InternalRtVil.g:3720:1: (lv_version_1_0= RULE_VERSION )
            // InternalRtVil.g:3721:3: lv_version_1_0= RULE_VERSION
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
    // InternalRtVil.g:3749:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalRtVil.g:3750:2: (iv_ruleImport= ruleImport EOF )
            // InternalRtVil.g:3751:2: iv_ruleImport= ruleImport EOF
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
    // InternalRtVil.g:3758:1: ruleImport returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) ;
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
            // InternalRtVil.g:3761:28: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) )
            // InternalRtVil.g:3762:1: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            {
            // InternalRtVil.g:3762:1: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            // InternalRtVil.g:3762:2: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';'
            {
            // InternalRtVil.g:3762:2: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==53) ) {
                alt72=1;
            }
            else if ( (LA72_0==54) ) {
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
                    // InternalRtVil.g:3762:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,53,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:3767:6: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalRtVil.g:3767:6: ( (lv_insert_1_0= 'insert' ) )
                    // InternalRtVil.g:3768:1: (lv_insert_1_0= 'insert' )
                    {
                    // InternalRtVil.g:3768:1: (lv_insert_1_0= 'insert' )
                    // InternalRtVil.g:3769:3: lv_insert_1_0= 'insert'
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

            // InternalRtVil.g:3782:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalRtVil.g:3783:1: (lv_name_2_0= ruleIdentifier )
            {
            // InternalRtVil.g:3783:1: (lv_name_2_0= ruleIdentifier )
            // InternalRtVil.g:3784:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_58);
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

            // InternalRtVil.g:3800:2: ( (lv_wildcard_3_0= '*' ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==55) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRtVil.g:3801:1: (lv_wildcard_3_0= '*' )
                    {
                    // InternalRtVil.g:3801:1: (lv_wildcard_3_0= '*' )
                    // InternalRtVil.g:3802:3: lv_wildcard_3_0= '*'
                    {
                    lv_wildcard_3_0=(Token)match(input,55,FOLLOW_38); if (state.failed) return current;
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

            // InternalRtVil.g:3815:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==27) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRtVil.g:3816:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalRtVil.g:3816:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalRtVil.g:3817:3: lv_versionSpec_4_0= ruleVersionSpec
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
    // InternalRtVil.g:3845:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalRtVil.g:3846:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalRtVil.g:3847:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalRtVil.g:3854:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3857:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // InternalRtVil.g:3858:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // InternalRtVil.g:3858:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_STRING && LA75_0<=RULE_EXPONENT)||LA75_0==14||(LA75_0>=37 && LA75_0<=38)||LA75_0==43||LA75_0==45||LA75_0==52||LA75_0==69||(LA75_0>=71 && LA75_0<=74)||(LA75_0>=80 && LA75_0<=82)) ) {
                alt75=1;
            }
            else if ( (LA75_0==16) ) {
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
                    // InternalRtVil.g:3858:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // InternalRtVil.g:3858:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:3859:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:3859:1: (lv_expr_0_0= ruleLogicalExpression )
                    // InternalRtVil.g:3860:3: lv_expr_0_0= ruleLogicalExpression
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
                    // InternalRtVil.g:3877:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // InternalRtVil.g:3877:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // InternalRtVil.g:3878:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // InternalRtVil.g:3878:1: (lv_init_1_0= ruleContainerInitializer )
                    // InternalRtVil.g:3879:3: lv_init_1_0= ruleContainerInitializer
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
    // InternalRtVil.g:3903:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalRtVil.g:3904:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalRtVil.g:3905:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalRtVil.g:3912:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3915:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalRtVil.g:3916:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalRtVil.g:3916:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalRtVil.g:3916:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalRtVil.g:3916:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalRtVil.g:3917:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalRtVil.g:3917:1: (lv_left_0_0= ruleEqualityExpression )
            // InternalRtVil.g:3918:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_59);
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

            // InternalRtVil.g:3934:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop76:
            do {
                int alt76=2;
                switch ( input.LA(1) ) {
                case 56:
                    {
                    int LA76_2 = input.LA(2);

                    if ( (synpred92_InternalRtVil()) ) {
                        alt76=1;
                    }


                    }
                    break;
                case 57:
                    {
                    int LA76_3 = input.LA(2);

                    if ( (synpred92_InternalRtVil()) ) {
                        alt76=1;
                    }


                    }
                    break;
                case 58:
                    {
                    int LA76_4 = input.LA(2);

                    if ( (synpred92_InternalRtVil()) ) {
                        alt76=1;
                    }


                    }
                    break;
                case 59:
                    {
                    int LA76_5 = input.LA(2);

                    if ( (synpred92_InternalRtVil()) ) {
                        alt76=1;
                    }


                    }
                    break;
                case 60:
                    {
                    int LA76_6 = input.LA(2);

                    if ( (synpred92_InternalRtVil()) ) {
                        alt76=1;
                    }


                    }
                    break;

                }

                switch (alt76) {
            	case 1 :
            	    // InternalRtVil.g:3935:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalRtVil.g:3935:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalRtVil.g:3936:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop76;
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
    // InternalRtVil.g:3960:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalRtVil.g:3961:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalRtVil.g:3962:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalRtVil.g:3969:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:3972:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalRtVil.g:3973:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalRtVil.g:3973:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalRtVil.g:3973:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalRtVil.g:3973:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalRtVil.g:3974:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalRtVil.g:3974:1: (lv_op_0_0= ruleLogicalOperator )
            // InternalRtVil.g:3975:3: lv_op_0_0= ruleLogicalOperator
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

            // InternalRtVil.g:3991:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalRtVil.g:3992:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalRtVil.g:3992:1: (lv_ex_1_0= ruleEqualityExpression )
            // InternalRtVil.g:3993:3: lv_ex_1_0= ruleEqualityExpression
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
    // InternalRtVil.g:4017:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalRtVil.g:4018:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalRtVil.g:4019:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalRtVil.g:4026:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4029:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) )
            // InternalRtVil.g:4030:1: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            {
            // InternalRtVil.g:4030:1: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            int alt77=5;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt77=1;
                }
                break;
            case 57:
                {
                alt77=2;
                }
                break;
            case 58:
                {
                alt77=3;
                }
                break;
            case 59:
                {
                alt77=4;
                }
                break;
            case 60:
                {
                alt77=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalRtVil.g:4031:2: kw= 'and'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4038:2: kw= 'or'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4045:2: kw= 'xor'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalRtVil.g:4052:2: kw= 'implies'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getImpliesKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalRtVil.g:4059:2: kw= 'iff'
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
    // InternalRtVil.g:4072:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalRtVil.g:4073:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalRtVil.g:4074:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalRtVil.g:4081:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4084:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalRtVil.g:4085:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalRtVil.g:4085:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalRtVil.g:4085:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalRtVil.g:4085:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalRtVil.g:4086:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalRtVil.g:4086:1: (lv_left_0_0= ruleRelationalExpression )
            // InternalRtVil.g:4087:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_60);
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

            // InternalRtVil.g:4103:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt78=2;
            switch ( input.LA(1) ) {
                case 61:
                    {
                    int LA78_1 = input.LA(2);

                    if ( (synpred97_InternalRtVil()) ) {
                        alt78=1;
                    }
                    }
                    break;
                case 62:
                    {
                    int LA78_2 = input.LA(2);

                    if ( (synpred97_InternalRtVil()) ) {
                        alt78=1;
                    }
                    }
                    break;
                case 63:
                    {
                    int LA78_3 = input.LA(2);

                    if ( (synpred97_InternalRtVil()) ) {
                        alt78=1;
                    }
                    }
                    break;
            }

            switch (alt78) {
                case 1 :
                    // InternalRtVil.g:4104:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalRtVil.g:4104:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalRtVil.g:4105:3: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalRtVil.g:4129:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalRtVil.g:4130:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalRtVil.g:4131:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalRtVil.g:4138:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4141:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // InternalRtVil.g:4142:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // InternalRtVil.g:4142:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // InternalRtVil.g:4142:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // InternalRtVil.g:4142:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalRtVil.g:4143:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalRtVil.g:4143:1: (lv_op_0_0= ruleEqualityOperator )
            // InternalRtVil.g:4144:3: lv_op_0_0= ruleEqualityOperator
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

            // InternalRtVil.g:4160:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // InternalRtVil.g:4161:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // InternalRtVil.g:4161:1: (lv_ex_1_0= ruleRelationalExpression )
            // InternalRtVil.g:4162:3: lv_ex_1_0= ruleRelationalExpression
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
    // InternalRtVil.g:4186:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalRtVil.g:4187:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalRtVil.g:4188:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalRtVil.g:4195:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4198:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalRtVil.g:4199:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalRtVil.g:4199:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt79=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt79=1;
                }
                break;
            case 62:
                {
                alt79=2;
                }
                break;
            case 63:
                {
                alt79=3;
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
                    // InternalRtVil.g:4200:2: kw= '=='
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4207:2: kw= '<>'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4214:2: kw= '!='
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
    // InternalRtVil.g:4227:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalRtVil.g:4228:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalRtVil.g:4229:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalRtVil.g:4236:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4239:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalRtVil.g:4240:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalRtVil.g:4240:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalRtVil.g:4240:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalRtVil.g:4240:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalRtVil.g:4241:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalRtVil.g:4241:1: (lv_left_0_0= ruleAdditiveExpression )
            // InternalRtVil.g:4242:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_61);
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

            // InternalRtVil.g:4258:2: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
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
                    // InternalRtVil.g:4258:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalRtVil.g:4258:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalRtVil.g:4259:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalRtVil.g:4259:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalRtVil.g:4260:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_61);
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

                    // InternalRtVil.g:4276:2: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt80=2;
                    switch ( input.LA(1) ) {
                        case 64:
                            {
                            int LA80_1 = input.LA(2);

                            if ( (synpred100_InternalRtVil()) ) {
                                alt80=1;
                            }
                            }
                            break;
                        case 65:
                            {
                            int LA80_2 = input.LA(2);

                            if ( (synpred100_InternalRtVil()) ) {
                                alt80=1;
                            }
                            }
                            break;
                        case 66:
                            {
                            int LA80_3 = input.LA(2);

                            if ( (synpred100_InternalRtVil()) ) {
                                alt80=1;
                            }
                            }
                            break;
                        case 67:
                            {
                            int LA80_4 = input.LA(2);

                            if ( (synpred100_InternalRtVil()) ) {
                                alt80=1;
                            }
                            }
                            break;
                    }

                    switch (alt80) {
                        case 1 :
                            // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalRtVil.g:4278:3: lv_right2_2_0= ruleRelationalExpressionPart
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
    // InternalRtVil.g:4302:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalRtVil.g:4303:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalRtVil.g:4304:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalRtVil.g:4311:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4314:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalRtVil.g:4315:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalRtVil.g:4315:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalRtVil.g:4315:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalRtVil.g:4315:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalRtVil.g:4316:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalRtVil.g:4316:1: (lv_op_0_0= ruleRelationalOperator )
            // InternalRtVil.g:4317:3: lv_op_0_0= ruleRelationalOperator
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

            // InternalRtVil.g:4333:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalRtVil.g:4334:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalRtVil.g:4334:1: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalRtVil.g:4335:3: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalRtVil.g:4359:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalRtVil.g:4360:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalRtVil.g:4361:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalRtVil.g:4368:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4371:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalRtVil.g:4372:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalRtVil.g:4372:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt82=4;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt82=1;
                }
                break;
            case 65:
                {
                alt82=2;
                }
                break;
            case 66:
                {
                alt82=3;
                }
                break;
            case 67:
                {
                alt82=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRtVil.g:4373:2: kw= '>'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4380:2: kw= '<'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4387:2: kw= '>='
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalRtVil.g:4394:2: kw= '<='
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
    // InternalRtVil.g:4407:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalRtVil.g:4408:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalRtVil.g:4409:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalRtVil.g:4416:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4419:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalRtVil.g:4420:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalRtVil.g:4420:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalRtVil.g:4420:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalRtVil.g:4420:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalRtVil.g:4421:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalRtVil.g:4421:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalRtVil.g:4422:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_62);
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

            // InternalRtVil.g:4438:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==68) ) {
                    int LA83_2 = input.LA(2);

                    if ( (synpred105_InternalRtVil()) ) {
                        alt83=1;
                    }


                }
                else if ( (LA83_0==69) ) {
                    int LA83_3 = input.LA(2);

                    if ( (synpred105_InternalRtVil()) ) {
                        alt83=1;
                    }


                }


                switch (alt83) {
            	case 1 :
            	    // InternalRtVil.g:4439:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalRtVil.g:4439:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalRtVil.g:4440:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_62);
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
            	    break loop83;
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
    // InternalRtVil.g:4464:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalRtVil.g:4465:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalRtVil.g:4466:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalRtVil.g:4473:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4476:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalRtVil.g:4477:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalRtVil.g:4477:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalRtVil.g:4477:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalRtVil.g:4477:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalRtVil.g:4478:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalRtVil.g:4478:1: (lv_op_0_0= ruleAdditiveOperator )
            // InternalRtVil.g:4479:3: lv_op_0_0= ruleAdditiveOperator
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

            // InternalRtVil.g:4495:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalRtVil.g:4496:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalRtVil.g:4496:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalRtVil.g:4497:3: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalRtVil.g:4521:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalRtVil.g:4522:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalRtVil.g:4523:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalRtVil.g:4530:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4533:28: ( (kw= '+' | kw= '-' ) )
            // InternalRtVil.g:4534:1: (kw= '+' | kw= '-' )
            {
            // InternalRtVil.g:4534:1: (kw= '+' | kw= '-' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==68) ) {
                alt84=1;
            }
            else if ( (LA84_0==69) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalRtVil.g:4535:2: kw= '+'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4542:2: kw= '-'
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
    // InternalRtVil.g:4555:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalRtVil.g:4556:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalRtVil.g:4557:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalRtVil.g:4564:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4567:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalRtVil.g:4568:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalRtVil.g:4568:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalRtVil.g:4568:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalRtVil.g:4568:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalRtVil.g:4569:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalRtVil.g:4569:1: (lv_left_0_0= ruleUnaryExpression )
            // InternalRtVil.g:4570:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_63);
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

            // InternalRtVil.g:4586:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==55) ) {
                int LA85_1 = input.LA(2);

                if ( (synpred107_InternalRtVil()) ) {
                    alt85=1;
                }
            }
            else if ( (LA85_0==70) ) {
                int LA85_2 = input.LA(2);

                if ( (synpred107_InternalRtVil()) ) {
                    alt85=1;
                }
            }
            switch (alt85) {
                case 1 :
                    // InternalRtVil.g:4587:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalRtVil.g:4587:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalRtVil.g:4588:3: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalRtVil.g:4612:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalRtVil.g:4613:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalRtVil.g:4614:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalRtVil.g:4621:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4624:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalRtVil.g:4625:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalRtVil.g:4625:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalRtVil.g:4625:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalRtVil.g:4625:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalRtVil.g:4626:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalRtVil.g:4626:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalRtVil.g:4627:3: lv_op_0_0= ruleMultiplicativeOperator
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

            // InternalRtVil.g:4643:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalRtVil.g:4644:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalRtVil.g:4644:1: (lv_expr_1_0= ruleUnaryExpression )
            // InternalRtVil.g:4645:3: lv_expr_1_0= ruleUnaryExpression
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
    // InternalRtVil.g:4669:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalRtVil.g:4670:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalRtVil.g:4671:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalRtVil.g:4678:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4681:28: ( (kw= '*' | kw= '/' ) )
            // InternalRtVil.g:4682:1: (kw= '*' | kw= '/' )
            {
            // InternalRtVil.g:4682:1: (kw= '*' | kw= '/' )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==55) ) {
                alt86=1;
            }
            else if ( (LA86_0==70) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalRtVil.g:4683:2: kw= '*'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4690:2: kw= '/'
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
    // InternalRtVil.g:4703:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalRtVil.g:4704:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalRtVil.g:4705:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalRtVil.g:4712:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4715:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalRtVil.g:4716:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalRtVil.g:4716:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalRtVil.g:4716:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalRtVil.g:4716:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==69||(LA87_0>=71 && LA87_0<=72)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRtVil.g:4717:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalRtVil.g:4717:1: (lv_op_0_0= ruleUnaryOperator )
                    // InternalRtVil.g:4718:3: lv_op_0_0= ruleUnaryOperator
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

            // InternalRtVil.g:4734:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalRtVil.g:4735:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalRtVil.g:4735:1: (lv_expr_1_0= rulePostfixExpression )
            // InternalRtVil.g:4736:3: lv_expr_1_0= rulePostfixExpression
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
    // InternalRtVil.g:4760:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalRtVil.g:4761:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalRtVil.g:4762:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalRtVil.g:4769:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:4772:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // InternalRtVil.g:4773:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // InternalRtVil.g:4773:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt88=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt88=1;
                }
                break;
            case 72:
                {
                alt88=2;
                }
                break;
            case 69:
                {
                alt88=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalRtVil.g:4774:2: kw= 'not'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalRtVil.g:4781:2: kw= '!'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalRtVil.g:4788:2: kw= '-'
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
    // InternalRtVil.g:4801:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalRtVil.g:4802:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalRtVil.g:4803:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalRtVil.g:4810:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4813:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // InternalRtVil.g:4814:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // InternalRtVil.g:4814:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // InternalRtVil.g:4815:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // InternalRtVil.g:4815:1: (lv_left_0_0= rulePrimaryExpression )
            // InternalRtVil.g:4816:3: lv_left_0_0= rulePrimaryExpression
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
    // InternalRtVil.g:4840:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // InternalRtVil.g:4841:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // InternalRtVil.g:4842:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
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
    // InternalRtVil.g:4849:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4852:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:4853:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:4853:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // InternalRtVil.g:4853:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // InternalRtVil.g:4853:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=RULE_STRING && LA89_0<=RULE_EXPONENT)||LA89_0==52||(LA89_0>=80 && LA89_0<=82)) ) {
                alt89=1;
            }
            else if ( (LA89_0==14) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalRtVil.g:4853:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // InternalRtVil.g:4853:3: ( (lv_val_0_0= ruleConstant ) )
                    // InternalRtVil.g:4854:1: (lv_val_0_0= ruleConstant )
                    {
                    // InternalRtVil.g:4854:1: (lv_val_0_0= ruleConstant )
                    // InternalRtVil.g:4855:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_51);
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
                    // InternalRtVil.g:4872:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalRtVil.g:4872:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalRtVil.g:4872:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // InternalRtVil.g:4876:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // InternalRtVil.g:4877:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // InternalRtVil.g:4877:1: (lv_parenthesis_2_0= ruleExpression )
                    // InternalRtVil.g:4878:3: lv_parenthesis_2_0= ruleExpression
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

                    otherlv_3=(Token)match(input,15,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // InternalRtVil.g:4898:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==36||(LA90_0>=75 && LA90_0<=76)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalRtVil.g:4899:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:4899:1: (lv_calls_4_0= ruleSubCall )
            	    // InternalRtVil.g:4900:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    break loop90;
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
    // InternalRtVil.g:4924:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // InternalRtVil.g:4925:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // InternalRtVil.g:4926:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
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
    // InternalRtVil.g:4933:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4936:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:4937:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:4937:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // InternalRtVil.g:4937:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // InternalRtVil.g:4937:2: ( (lv_call_0_0= ruleCall ) )
            // InternalRtVil.g:4938:1: (lv_call_0_0= ruleCall )
            {
            // InternalRtVil.g:4938:1: (lv_call_0_0= ruleCall )
            // InternalRtVil.g:4939:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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

            // InternalRtVil.g:4955:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==36||(LA91_0>=75 && LA91_0<=76)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalRtVil.g:4956:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:4956:1: (lv_calls_1_0= ruleSubCall )
            	    // InternalRtVil.g:4957:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // InternalRtVil.g:4981:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // InternalRtVil.g:4982:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // InternalRtVil.g:4983:2: iv_ruleSuperExecution= ruleSuperExecution EOF
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
    // InternalRtVil.g:4990:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:4993:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:4994:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:4994:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // InternalRtVil.g:4994:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,73,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,36,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // InternalRtVil.g:5002:1: ( (lv_call_2_0= ruleCall ) )
            // InternalRtVil.g:5003:1: (lv_call_2_0= ruleCall )
            {
            // InternalRtVil.g:5003:1: (lv_call_2_0= ruleCall )
            // InternalRtVil.g:5004:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_51);
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

            // InternalRtVil.g:5020:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==36||(LA92_0>=75 && LA92_0<=76)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalRtVil.g:5021:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:5021:1: (lv_calls_3_0= ruleSubCall )
            	    // InternalRtVil.g:5022:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // InternalRtVil.g:5046:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // InternalRtVil.g:5047:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // InternalRtVil.g:5048:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
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
    // InternalRtVil.g:5055:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // InternalRtVil.g:5058:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // InternalRtVil.g:5059:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // InternalRtVil.g:5059:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // InternalRtVil.g:5059:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,74,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // InternalRtVil.g:5063:1: ( (lv_type_1_0= ruleType ) )
            // InternalRtVil.g:5064:1: (lv_type_1_0= ruleType )
            {
            // InternalRtVil.g:5064:1: (lv_type_1_0= ruleType )
            // InternalRtVil.g:5065:3: lv_type_1_0= ruleType
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
            // InternalRtVil.g:5085:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( ((LA93_0>=RULE_STRING && LA93_0<=RULE_EXPONENT)||LA93_0==14||LA93_0==16||(LA93_0>=37 && LA93_0<=38)||LA93_0==43||LA93_0==45||LA93_0==52||LA93_0==69||(LA93_0>=71 && LA93_0<=74)||(LA93_0>=80 && LA93_0<=82)) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRtVil.g:5086:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:5086:1: (lv_param_3_0= ruleArgumentList )
                    // InternalRtVil.g:5087:3: lv_param_3_0= ruleArgumentList
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

            otherlv_4=(Token)match(input,15,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalRtVil.g:5107:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==36||(LA94_0>=75 && LA94_0<=76)) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // InternalRtVil.g:5108:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // InternalRtVil.g:5108:1: (lv_calls_5_0= ruleSubCall )
            	    // InternalRtVil.g:5109:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    break loop94;
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
    // InternalRtVil.g:5133:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // InternalRtVil.g:5134:2: (iv_ruleSubCall= ruleSubCall EOF )
            // InternalRtVil.g:5135:2: iv_ruleSubCall= ruleSubCall EOF
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
    // InternalRtVil.g:5142:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // InternalRtVil.g:5145:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // InternalRtVil.g:5146:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // InternalRtVil.g:5146:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==36||LA96_0==75) ) {
                alt96=1;
            }
            else if ( (LA96_0==76) ) {
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
                    // InternalRtVil.g:5146:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // InternalRtVil.g:5146:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // InternalRtVil.g:5146:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // InternalRtVil.g:5146:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // InternalRtVil.g:5147:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // InternalRtVil.g:5147:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // InternalRtVil.g:5148:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // InternalRtVil.g:5148:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==36) ) {
                        alt95=1;
                    }
                    else if ( (LA95_0==75) ) {
                        alt95=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 95, 0, input);

                        throw nvae;
                    }
                    switch (alt95) {
                        case 1 :
                            // InternalRtVil.g:5149:3: lv_type_0_1= '.'
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
                            // InternalRtVil.g:5161:8: lv_type_0_2= '->'
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

                    // InternalRtVil.g:5176:2: ( (lv_call_1_0= ruleCall ) )
                    // InternalRtVil.g:5177:1: (lv_call_1_0= ruleCall )
                    {
                    // InternalRtVil.g:5177:1: (lv_call_1_0= ruleCall )
                    // InternalRtVil.g:5178:3: lv_call_1_0= ruleCall
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
                    // InternalRtVil.g:5195:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalRtVil.g:5195:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalRtVil.g:5195:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,76,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // InternalRtVil.g:5199:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // InternalRtVil.g:5200:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // InternalRtVil.g:5200:1: (lv_arrayEx_3_0= ruleExpression )
                    // InternalRtVil.g:5201:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_65);
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
    // InternalRtVil.g:5229:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalRtVil.g:5230:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalRtVil.g:5231:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalRtVil.g:5238:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5241:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalRtVil.g:5242:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalRtVil.g:5242:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalRtVil.g:5242:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalRtVil.g:5242:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalRtVil.g:5243:1: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalRtVil.g:5243:1: (lv_decl_0_0= ruleDeclaration )
            // InternalRtVil.g:5244:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_66);
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

            // InternalRtVil.g:5260:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==18) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalRtVil.g:5260:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // InternalRtVil.g:5264:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalRtVil.g:5265:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalRtVil.g:5265:1: (lv_decl_2_0= ruleDeclaration )
            	    // InternalRtVil.g:5266:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_66);
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
            	    break loop97;
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
    // InternalRtVil.g:5294:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalRtVil.g:5295:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalRtVil.g:5296:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalRtVil.g:5303:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5306:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // InternalRtVil.g:5307:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // InternalRtVil.g:5307:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // InternalRtVil.g:5307:2: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // InternalRtVil.g:5307:2: ( (lv_type_0_0= ruleType ) )?
            int alt98=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA98_1 = input.LA(2);

                    if ( (LA98_1==RULE_VERSION||(LA98_1>=RULE_ID && LA98_1<=RULE_EXPONENT)||LA98_1==52||LA98_1==79) ) {
                        alt98=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA98_2 = input.LA(2);

                    if ( (LA98_2==RULE_VERSION||(LA98_2>=RULE_ID && LA98_2<=RULE_EXPONENT)||LA98_2==52||LA98_2==79) ) {
                        alt98=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA98_3 = input.LA(2);

                    if ( (LA98_3==RULE_VERSION||(LA98_3>=RULE_ID && LA98_3<=RULE_EXPONENT)||LA98_3==52||LA98_3==79) ) {
                        alt98=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA98_4 = input.LA(2);

                    if ( (LA98_4==RULE_VERSION||(LA98_4>=RULE_ID && LA98_4<=RULE_EXPONENT)||LA98_4==52||LA98_4==79) ) {
                        alt98=1;
                    }
                    }
                    break;
                case 83:
                case 84:
                case 85:
                case 86:
                    {
                    alt98=1;
                    }
                    break;
            }

            switch (alt98) {
                case 1 :
                    // InternalRtVil.g:5308:1: (lv_type_0_0= ruleType )
                    {
                    // InternalRtVil.g:5308:1: (lv_type_0_0= ruleType )
                    // InternalRtVil.g:5309:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_41);
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

            // InternalRtVil.g:5325:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // InternalRtVil.g:5326:1: (lv_units_1_0= ruleDeclarationUnit )
            {
            // InternalRtVil.g:5326:1: (lv_units_1_0= ruleDeclarationUnit )
            // InternalRtVil.g:5327:3: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
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

            // InternalRtVil.g:5343:2: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==28) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalRtVil.g:5343:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalRtVil.g:5347:1: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // InternalRtVil.g:5348:1: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // InternalRtVil.g:5348:1: (lv_units_3_0= ruleDeclarationUnit )
            	    // InternalRtVil.g:5349:3: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
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
            	    break loop99;
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
    // InternalRtVil.g:5373:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // InternalRtVil.g:5374:2: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // InternalRtVil.g:5375:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
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
    // InternalRtVil.g:5382:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5385:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // InternalRtVil.g:5386:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // InternalRtVil.g:5386:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // InternalRtVil.g:5386:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // InternalRtVil.g:5386:2: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalRtVil.g:5387:1: (lv_id_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:5387:1: (lv_id_0_0= ruleIdentifier )
            // InternalRtVil.g:5388:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_56);
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

            // InternalRtVil.g:5404:2: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==21) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalRtVil.g:5404:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // InternalRtVil.g:5408:1: ( (lv_deflt_2_0= ruleExpression ) )
                    // InternalRtVil.g:5409:1: (lv_deflt_2_0= ruleExpression )
                    {
                    // InternalRtVil.g:5409:1: (lv_deflt_2_0= ruleExpression )
                    // InternalRtVil.g:5410:3: lv_deflt_2_0= ruleExpression
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
    // InternalRtVil.g:5434:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalRtVil.g:5435:2: (iv_ruleCall= ruleCall EOF )
            // InternalRtVil.g:5436:2: iv_ruleCall= ruleCall EOF
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
    // InternalRtVil.g:5443:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5446:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // InternalRtVil.g:5447:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // InternalRtVil.g:5447:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // InternalRtVil.g:5447:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // InternalRtVil.g:5447:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:5448:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:5448:1: (lv_name_0_0= ruleQualifiedPrefix )
            // InternalRtVil.g:5449:3: lv_name_0_0= ruleQualifiedPrefix
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

            otherlv_1=(Token)match(input,14,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalRtVil.g:5469:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt101=2;
            alt101 = dfa101.predict(input);
            switch (alt101) {
                case 1 :
                    // InternalRtVil.g:5470:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalRtVil.g:5470:1: (lv_decl_2_0= ruleDeclarator )
                    // InternalRtVil.g:5471:3: lv_decl_2_0= ruleDeclarator
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

            // InternalRtVil.g:5487:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( ((LA102_0>=RULE_STRING && LA102_0<=RULE_EXPONENT)||LA102_0==14||LA102_0==16||(LA102_0>=37 && LA102_0<=38)||LA102_0==43||LA102_0==45||LA102_0==52||LA102_0==69||(LA102_0>=71 && LA102_0<=74)||(LA102_0>=80 && LA102_0<=82)) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // InternalRtVil.g:5488:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalRtVil.g:5488:1: (lv_param_3_0= ruleArgumentList )
                    // InternalRtVil.g:5489:3: lv_param_3_0= ruleArgumentList
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
    // InternalRtVil.g:5517:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // InternalRtVil.g:5518:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // InternalRtVil.g:5519:2: iv_ruleArgumentList= ruleArgumentList EOF
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
    // InternalRtVil.g:5526:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5529:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // InternalRtVil.g:5530:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // InternalRtVil.g:5530:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // InternalRtVil.g:5530:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // InternalRtVil.g:5530:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // InternalRtVil.g:5531:1: (lv_param_0_0= ruleNamedArgument )
            {
            // InternalRtVil.g:5531:1: (lv_param_0_0= ruleNamedArgument )
            // InternalRtVil.g:5532:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_43);
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

            // InternalRtVil.g:5548:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==28) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // InternalRtVil.g:5548:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // InternalRtVil.g:5552:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // InternalRtVil.g:5553:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // InternalRtVil.g:5553:1: (lv_param_2_0= ruleNamedArgument )
            	    // InternalRtVil.g:5554:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_43);
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
            	    break loop103;
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
    // InternalRtVil.g:5578:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalRtVil.g:5579:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalRtVil.g:5580:2: iv_ruleNamedArgument= ruleNamedArgument EOF
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
    // InternalRtVil.g:5587:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5590:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // InternalRtVil.g:5591:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // InternalRtVil.g:5591:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // InternalRtVil.g:5591:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // InternalRtVil.g:5591:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt104=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA104_1 = input.LA(2);

                    if ( (LA104_1==21) ) {
                        alt104=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA104_2 = input.LA(2);

                    if ( (LA104_2==21) ) {
                        alt104=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA104_3 = input.LA(2);

                    if ( (LA104_3==21) ) {
                        alt104=1;
                    }
                    }
                    break;
                case 52:
                    {
                    int LA104_4 = input.LA(2);

                    if ( (LA104_4==21) ) {
                        alt104=1;
                    }
                    }
                    break;
            }

            switch (alt104) {
                case 1 :
                    // InternalRtVil.g:5591:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalRtVil.g:5591:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalRtVil.g:5592:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalRtVil.g:5592:1: (lv_name_0_0= ruleIdentifier )
                    // InternalRtVil.g:5593:3: lv_name_0_0= ruleIdentifier
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

            // InternalRtVil.g:5613:3: ( (lv_ex_2_0= ruleExpression ) )
            // InternalRtVil.g:5614:1: (lv_ex_2_0= ruleExpression )
            {
            // InternalRtVil.g:5614:1: (lv_ex_2_0= ruleExpression )
            // InternalRtVil.g:5615:3: lv_ex_2_0= ruleExpression
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
    // InternalRtVil.g:5639:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // InternalRtVil.g:5640:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // InternalRtVil.g:5641:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
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
    // InternalRtVil.g:5648:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5651:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalRtVil.g:5652:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalRtVil.g:5652:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalRtVil.g:5652:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalRtVil.g:5652:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalRtVil.g:5653:1: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalRtVil.g:5653:1: (lv_qname_0_0= ruleIdentifier )
            // InternalRtVil.g:5654:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_68);
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

            // InternalRtVil.g:5670:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==79) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalRtVil.g:5670:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalRtVil.g:5670:3: ( (lv_qname_1_0= '::' ) )
            	    // InternalRtVil.g:5671:1: (lv_qname_1_0= '::' )
            	    {
            	    // InternalRtVil.g:5671:1: (lv_qname_1_0= '::' )
            	    // InternalRtVil.g:5672:3: lv_qname_1_0= '::'
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

            	    // InternalRtVil.g:5685:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalRtVil.g:5686:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalRtVil.g:5686:1: (lv_qname_2_0= ruleIdentifier )
            	    // InternalRtVil.g:5687:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_68);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRtVil.g:5711:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalRtVil.g:5712:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRtVil.g:5713:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalRtVil.g:5720:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:5723:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalRtVil.g:5724:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalRtVil.g:5724:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalRtVil.g:5724:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalRtVil.g:5724:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // InternalRtVil.g:5725:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // InternalRtVil.g:5725:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // InternalRtVil.g:5726:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_69);
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

            // InternalRtVil.g:5742:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==36) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA106_3 = input.LA(3);

                        if ( (LA106_3==EOF||LA106_3==13||(LA106_3>=15 && LA106_3<=18)||LA106_3==25||(LA106_3>=27 && LA106_3<=28)||LA106_3==36||LA106_3==51||(LA106_3>=55 && LA106_3<=70)||(LA106_3>=75 && LA106_3<=78)) ) {
                            alt106=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA106_4 = input.LA(3);

                        if ( (LA106_4==EOF||LA106_4==13||(LA106_4>=15 && LA106_4<=18)||LA106_4==25||(LA106_4>=27 && LA106_4<=28)||LA106_4==36||LA106_4==51||(LA106_4>=55 && LA106_4<=70)||(LA106_4>=75 && LA106_4<=78)) ) {
                            alt106=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA106_5 = input.LA(3);

                        if ( (LA106_5==EOF||LA106_5==13||(LA106_5>=15 && LA106_5<=18)||LA106_5==25||(LA106_5>=27 && LA106_5<=28)||LA106_5==36||LA106_5==51||(LA106_5>=55 && LA106_5<=70)||(LA106_5>=75 && LA106_5<=78)) ) {
                            alt106=1;
                        }


                        }
                        break;
                    case 52:
                        {
                        int LA106_6 = input.LA(3);

                        if ( (LA106_6==EOF||LA106_6==13||(LA106_6>=15 && LA106_6<=18)||LA106_6==25||(LA106_6>=27 && LA106_6<=28)||LA106_6==36||LA106_6==51||(LA106_6>=55 && LA106_6<=70)||(LA106_6>=75 && LA106_6<=78)) ) {
                            alt106=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt106) {
            	case 1 :
            	    // InternalRtVil.g:5742:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalRtVil.g:5742:3: ( (lv_qname_1_0= '.' ) )
            	    // InternalRtVil.g:5743:1: (lv_qname_1_0= '.' )
            	    {
            	    // InternalRtVil.g:5743:1: (lv_qname_1_0= '.' )
            	    // InternalRtVil.g:5744:3: lv_qname_1_0= '.'
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

            	    // InternalRtVil.g:5757:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalRtVil.g:5758:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalRtVil.g:5758:1: (lv_qname_2_0= ruleIdentifier )
            	    // InternalRtVil.g:5759:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_69);
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
            	    break loop106;
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
    // InternalRtVil.g:5783:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalRtVil.g:5784:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalRtVil.g:5785:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalRtVil.g:5792:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // InternalRtVil.g:5795:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // InternalRtVil.g:5796:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // InternalRtVil.g:5796:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt108=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt108=1;
                }
                break;
            case RULE_STRING:
                {
                alt108=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 52:
                {
                alt108=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA108_4 = input.LA(2);

                if ( (synpred132_InternalRtVil()) ) {
                    alt108=3;
                }
                else if ( (synpred136_InternalRtVil()) ) {
                    alt108=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 4, input);

                    throw nvae;
                }
                }
                break;
            case 80:
            case 81:
                {
                alt108=4;
                }
                break;
            case 82:
                {
                alt108=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // InternalRtVil.g:5796:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalRtVil.g:5796:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalRtVil.g:5797:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalRtVil.g:5797:1: (lv_nValue_0_0= ruleNumValue )
                    // InternalRtVil.g:5798:3: lv_nValue_0_0= ruleNumValue
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
                    // InternalRtVil.g:5815:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalRtVil.g:5815:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalRtVil.g:5816:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalRtVil.g:5816:1: (lv_sValue_1_0= RULE_STRING )
                    // InternalRtVil.g:5817:3: lv_sValue_1_0= RULE_STRING
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
                    // InternalRtVil.g:5834:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalRtVil.g:5834:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalRtVil.g:5835:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalRtVil.g:5835:1: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalRtVil.g:5836:3: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalRtVil.g:5853:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalRtVil.g:5853:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalRtVil.g:5854:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalRtVil.g:5854:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalRtVil.g:5855:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalRtVil.g:5855:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==80) ) {
                        alt107=1;
                    }
                    else if ( (LA107_0==81) ) {
                        alt107=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }
                    switch (alt107) {
                        case 1 :
                            // InternalRtVil.g:5856:3: lv_bValue_3_1= 'true'
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
                            // InternalRtVil.g:5868:8: lv_bValue_3_2= 'false'
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
                    // InternalRtVil.g:5884:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // InternalRtVil.g:5884:6: ( (lv_null_4_0= 'null' ) )
                    // InternalRtVil.g:5885:1: (lv_null_4_0= 'null' )
                    {
                    // InternalRtVil.g:5885:1: (lv_null_4_0= 'null' )
                    // InternalRtVil.g:5886:3: lv_null_4_0= 'null'
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
                    // InternalRtVil.g:5900:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // InternalRtVil.g:5900:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // InternalRtVil.g:5900:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // InternalRtVil.g:5906:1: (lv_version_5_0= RULE_VERSION )
                    // InternalRtVil.g:5907:3: lv_version_5_0= RULE_VERSION
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
    // InternalRtVil.g:5931:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalRtVil.g:5932:2: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalRtVil.g:5933:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalRtVil.g:5940:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:5943:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalRtVil.g:5944:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalRtVil.g:5944:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalRtVil.g:5945:1: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalRtVil.g:5945:1: (lv_val_0_0= RULE_NUMBER )
            // InternalRtVil.g:5946:3: lv_val_0_0= RULE_NUMBER
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
    // InternalRtVil.g:5970:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalRtVil.g:5971:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalRtVil.g:5972:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalRtVil.g:5979:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // InternalRtVil.g:5982:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalRtVil.g:5983:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalRtVil.g:5983:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt109=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt109=1;
                }
                break;
            case RULE_VERSION:
                {
                alt109=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt109=3;
                }
                break;
            case 52:
                {
                alt109=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // InternalRtVil.g:5983:6: this_ID_0= RULE_ID
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
                    // InternalRtVil.g:5991:10: this_VERSION_1= RULE_VERSION
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
                    // InternalRtVil.g:5999:10: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalRtVil.g:6008:2: kw= 'version'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
    // InternalRtVil.g:6021:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalRtVil.g:6022:2: (iv_ruleType= ruleType EOF )
            // InternalRtVil.g:6023:2: iv_ruleType= ruleType EOF
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
    // InternalRtVil.g:6030:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // InternalRtVil.g:6033:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // InternalRtVil.g:6034:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // InternalRtVil.g:6034:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt111=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 52:
                {
                alt111=1;
                }
                break;
            case 83:
                {
                alt111=2;
                }
                break;
            case 84:
                {
                alt111=3;
                }
                break;
            case 85:
                {
                alt111=4;
                }
                break;
            case 86:
                {
                alt111=5;
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
                    // InternalRtVil.g:6034:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // InternalRtVil.g:6034:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // InternalRtVil.g:6035:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // InternalRtVil.g:6035:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // InternalRtVil.g:6036:3: lv_name_0_0= ruleQualifiedPrefix
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
                    // InternalRtVil.g:6053:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6053:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6053:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6053:7: ( (lv_set_1_0= 'setOf' ) )
                    // InternalRtVil.g:6054:1: (lv_set_1_0= 'setOf' )
                    {
                    // InternalRtVil.g:6054:1: (lv_set_1_0= 'setOf' )
                    // InternalRtVil.g:6055:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,83,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6068:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6069:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6069:1: (lv_param_2_0= ruleTypeParameters )
                    // InternalRtVil.g:6070:3: lv_param_2_0= ruleTypeParameters
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
                    // InternalRtVil.g:6087:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6087:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6087:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6087:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // InternalRtVil.g:6088:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // InternalRtVil.g:6088:1: (lv_seq_3_0= 'sequenceOf' )
                    // InternalRtVil.g:6089:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,84,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6102:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6103:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6103:1: (lv_param_4_0= ruleTypeParameters )
                    // InternalRtVil.g:6104:3: lv_param_4_0= ruleTypeParameters
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
                    // InternalRtVil.g:6121:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6121:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6121:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6121:7: ( (lv_map_5_0= 'mapOf' ) )
                    // InternalRtVil.g:6122:1: (lv_map_5_0= 'mapOf' )
                    {
                    // InternalRtVil.g:6122:1: (lv_map_5_0= 'mapOf' )
                    // InternalRtVil.g:6123:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,85,FOLLOW_8); if (state.failed) return current;
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

                    // InternalRtVil.g:6136:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6137:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6137:1: (lv_param_6_0= ruleTypeParameters )
                    // InternalRtVil.g:6138:3: lv_param_6_0= ruleTypeParameters
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
                    // InternalRtVil.g:6155:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // InternalRtVil.g:6155:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // InternalRtVil.g:6155:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // InternalRtVil.g:6155:7: ( (lv_call_7_0= 'callOf' ) )
                    // InternalRtVil.g:6156:1: (lv_call_7_0= 'callOf' )
                    {
                    // InternalRtVil.g:6156:1: (lv_call_7_0= 'callOf' )
                    // InternalRtVil.g:6157:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,86,FOLLOW_70); if (state.failed) return current;
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

                    // InternalRtVil.g:6170:2: ( (lv_return_8_0= ruleType ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==RULE_VERSION||(LA110_0>=RULE_ID && LA110_0<=RULE_EXPONENT)||LA110_0==52||(LA110_0>=83 && LA110_0<=86)) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalRtVil.g:6171:1: (lv_return_8_0= ruleType )
                            {
                            // InternalRtVil.g:6171:1: (lv_return_8_0= ruleType )
                            // InternalRtVil.g:6172:3: lv_return_8_0= ruleType
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

                    // InternalRtVil.g:6188:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // InternalRtVil.g:6189:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // InternalRtVil.g:6189:1: (lv_param_9_0= ruleTypeParameters )
                    // InternalRtVil.g:6190:3: lv_param_9_0= ruleTypeParameters
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
    // InternalRtVil.g:6214:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // InternalRtVil.g:6215:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // InternalRtVil.g:6216:2: iv_ruleTypeParameters= ruleTypeParameters EOF
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
    // InternalRtVil.g:6223:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:6226:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // InternalRtVil.g:6227:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // InternalRtVil.g:6227:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // InternalRtVil.g:6227:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalRtVil.g:6231:1: ( (lv_param_1_0= ruleType ) )
            // InternalRtVil.g:6232:1: (lv_param_1_0= ruleType )
            {
            // InternalRtVil.g:6232:1: (lv_param_1_0= ruleType )
            // InternalRtVil.g:6233:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_71);
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

            // InternalRtVil.g:6249:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==28) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // InternalRtVil.g:6249:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // InternalRtVil.g:6253:1: ( (lv_param_3_0= ruleType ) )
            	    // InternalRtVil.g:6254:1: (lv_param_3_0= ruleType )
            	    {
            	    // InternalRtVil.g:6254:1: (lv_param_3_0= ruleType )
            	    // InternalRtVil.g:6255:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_71);
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
            	    break loop112;
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
    // InternalRtVil.g:6283:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalRtVil.g:6284:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalRtVil.g:6285:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalRtVil.g:6292:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:6295:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // InternalRtVil.g:6296:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // InternalRtVil.g:6296:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // InternalRtVil.g:6296:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // InternalRtVil.g:6296:2: ()
            // InternalRtVil.g:6297:2: 
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

            otherlv_1=(Token)match(input,16,FOLLOW_72); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalRtVil.g:6309:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( ((LA114_0>=RULE_STRING && LA114_0<=RULE_EXPONENT)||LA114_0==14||LA114_0==16||(LA114_0>=37 && LA114_0<=38)||LA114_0==43||LA114_0==45||LA114_0==52||LA114_0==69||(LA114_0>=71 && LA114_0<=74)||(LA114_0>=80 && LA114_0<=82)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalRtVil.g:6309:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // InternalRtVil.g:6309:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // InternalRtVil.g:6310:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // InternalRtVil.g:6310:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // InternalRtVil.g:6311:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_73);
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

                    // InternalRtVil.g:6327:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==28) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // InternalRtVil.g:6327:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // InternalRtVil.g:6331:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // InternalRtVil.g:6332:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // InternalRtVil.g:6332:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // InternalRtVil.g:6333:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_73);
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
                    	    break loop113;
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
    // InternalRtVil.g:6361:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // InternalRtVil.g:6362:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // InternalRtVil.g:6363:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
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
    // InternalRtVil.g:6370:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // InternalRtVil.g:6373:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // InternalRtVil.g:6374:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // InternalRtVil.g:6374:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( ((LA115_0>=RULE_STRING && LA115_0<=RULE_EXPONENT)||LA115_0==14||(LA115_0>=37 && LA115_0<=38)||LA115_0==43||LA115_0==45||LA115_0==52||LA115_0==69||(LA115_0>=71 && LA115_0<=74)||(LA115_0>=80 && LA115_0<=82)) ) {
                alt115=1;
            }
            else if ( (LA115_0==16) ) {
                alt115=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }
            switch (alt115) {
                case 1 :
                    // InternalRtVil.g:6374:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // InternalRtVil.g:6374:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // InternalRtVil.g:6375:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // InternalRtVil.g:6375:1: (lv_logical_0_0= ruleLogicalExpression )
                    // InternalRtVil.g:6376:3: lv_logical_0_0= ruleLogicalExpression
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
                    // InternalRtVil.g:6393:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // InternalRtVil.g:6393:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // InternalRtVil.g:6394:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // InternalRtVil.g:6394:1: (lv_container_1_0= ruleContainerInitializer )
                    // InternalRtVil.g:6395:3: lv_container_1_0= ruleContainerInitializer
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


        // InternalRtVil.g:259:1: ( (lv_version_8_0= ruleVersionStmt ) )
        // InternalRtVil.g:259:1: (lv_version_8_0= ruleVersionStmt )
        {
        // InternalRtVil.g:259:1: (lv_version_8_0= ruleVersionStmt )
        // InternalRtVil.g:260:3: lv_version_8_0= ruleVersionStmt
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


        // InternalRtVil.g:332:3: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) )
        // InternalRtVil.g:332:3: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
        {
        // InternalRtVil.g:332:3: ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) )
        // InternalRtVil.g:333:1: (lv_elements_1_0= ruleGlobalVariableDeclaration )
        {
        // InternalRtVil.g:333:1: (lv_elements_1_0= ruleGlobalVariableDeclaration )
        // InternalRtVil.g:334:3: lv_elements_1_0= ruleGlobalVariableDeclaration
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


        // InternalRtVil.g:351:6: ( ( (lv_elements_2_0= ruleRuleDeclaration ) ) )
        // InternalRtVil.g:351:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        {
        // InternalRtVil.g:351:6: ( (lv_elements_2_0= ruleRuleDeclaration ) )
        // InternalRtVil.g:352:1: (lv_elements_2_0= ruleRuleDeclaration )
        {
        // InternalRtVil.g:352:1: (lv_elements_2_0= ruleRuleDeclaration )
        // InternalRtVil.g:353:3: lv_elements_2_0= ruleRuleDeclaration
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

    // $ANTLR start synpred48_InternalRtVil
    public final void synpred48_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_modifier_1_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;


        // InternalRtVil.g:1735:3: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )
        // InternalRtVil.g:1735:3: ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
        {
        // InternalRtVil.g:1735:3: ( (lv_modifier_1_0= ruleRuleModifier ) )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==35) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // InternalRtVil.g:1736:1: (lv_modifier_1_0= ruleRuleModifier )
                {
                // InternalRtVil.g:1736:1: (lv_modifier_1_0= ruleRuleModifier )
                // InternalRtVil.g:1737:3: lv_modifier_1_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_0_0()); 
                  	    
                }
                pushFollow(FOLLOW_41);
                lv_modifier_1_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalRtVil.g:1753:3: ( (lv_type_2_0= ruleType ) )?
        int alt121=2;
        switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==RULE_VERSION||(LA121_1>=RULE_ID && LA121_1<=RULE_EXPONENT)||LA121_1==52||LA121_1==79) ) {
                    alt121=1;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA121_2 = input.LA(2);

                if ( (LA121_2==RULE_VERSION||(LA121_2>=RULE_ID && LA121_2<=RULE_EXPONENT)||LA121_2==52||LA121_2==79) ) {
                    alt121=1;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA121_3 = input.LA(2);

                if ( (LA121_3==RULE_VERSION||(LA121_3>=RULE_ID && LA121_3<=RULE_EXPONENT)||LA121_3==52||LA121_3==79) ) {
                    alt121=1;
                }
                }
                break;
            case 52:
                {
                int LA121_4 = input.LA(2);

                if ( (LA121_4==RULE_VERSION||(LA121_4>=RULE_ID && LA121_4<=RULE_EXPONENT)||LA121_4==52||LA121_4==79) ) {
                    alt121=1;
                }
                }
                break;
            case 83:
            case 84:
            case 85:
            case 86:
                {
                alt121=1;
                }
                break;
        }

        switch (alt121) {
            case 1 :
                // InternalRtVil.g:1754:1: (lv_type_2_0= ruleType )
                {
                // InternalRtVil.g:1754:1: (lv_type_2_0= ruleType )
                // InternalRtVil.g:1755:3: lv_type_2_0= ruleType
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_7);
                lv_type_2_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // InternalRtVil.g:1771:3: ( (lv_name_3_0= ruleIdentifier ) )
        // InternalRtVil.g:1772:1: (lv_name_3_0= ruleIdentifier )
        {
        // InternalRtVil.g:1772:1: (lv_name_3_0= ruleIdentifier )
        // InternalRtVil.g:1773:3: lv_name_3_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_8);
        lv_name_3_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,14,FOLLOW_9); if (state.failed) return ;
        // InternalRtVil.g:1793:1: ( (lv_paramList_5_0= ruleParameterList ) )?
        int alt122=2;
        int LA122_0 = input.LA(1);

        if ( (LA122_0==RULE_VERSION||(LA122_0>=RULE_ID && LA122_0<=RULE_EXPONENT)||LA122_0==52||(LA122_0>=83 && LA122_0<=86)) ) {
            alt122=1;
        }
        switch (alt122) {
            case 1 :
                // InternalRtVil.g:1794:1: (lv_paramList_5_0= ruleParameterList )
                {
                // InternalRtVil.g:1794:1: (lv_paramList_5_0= ruleParameterList )
                // InternalRtVil.g:1795:3: lv_paramList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                  	    
                }
                pushFollow(FOLLOW_10);
                lv_paramList_5_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,15,FOLLOW_18); if (state.failed) return ;
        otherlv_7=(Token)match(input,21,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred48_InternalRtVil

    // $ANTLR start synpred57_InternalRtVil
    public final void synpred57_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // InternalRtVil.g:2093:4: (otherlv_7= ';' )
        // InternalRtVil.g:2093:4: otherlv_7= ';'
        {
        otherlv_7=(Token)match(input,18,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred57_InternalRtVil

    // $ANTLR start synpred67_InternalRtVil
    public final void synpred67_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_versionSpec_6_0 = null;


        // InternalRtVil.g:2358:1: ( (lv_versionSpec_6_0= ruleVersionSpec ) )
        // InternalRtVil.g:2358:1: (lv_versionSpec_6_0= ruleVersionSpec )
        {
        // InternalRtVil.g:2358:1: (lv_versionSpec_6_0= ruleVersionSpec )
        // InternalRtVil.g:2359:3: lv_versionSpec_6_0= ruleVersionSpec
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
    // $ANTLR end synpred67_InternalRtVil

    // $ANTLR start synpred74_InternalRtVil
    public final void synpred74_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // InternalRtVil.g:2848:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // InternalRtVil.g:2848:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // InternalRtVil.g:2848:3: ( ( 'else' )=>otherlv_5= 'else' )
        // InternalRtVil.g:2848:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,42,FOLLOW_48); if (state.failed) return ;

        }

        // InternalRtVil.g:2853:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // InternalRtVil.g:2854:1: (lv_else_6_0= ruleStatementOrBlock )
        {
        // InternalRtVil.g:2854:1: (lv_else_6_0= ruleStatementOrBlock )
        // InternalRtVil.g:2855:3: lv_else_6_0= ruleStatementOrBlock
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
    // $ANTLR end synpred74_InternalRtVil

    // $ANTLR start synpred75_InternalRtVil
    public final void synpred75_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // InternalRtVil.g:2892:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // InternalRtVil.g:2892:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // InternalRtVil.g:2892:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // InternalRtVil.g:2893:1: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // InternalRtVil.g:2893:1: (lv_exStmt_0_0= ruleExpressionStatement )
        // InternalRtVil.g:2894:3: lv_exStmt_0_0= ruleExpressionStatement
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
    // $ANTLR end synpred75_InternalRtVil

    // $ANTLR start synpred76_InternalRtVil
    public final void synpred76_InternalRtVil_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_condition_8_0 = null;


        // InternalRtVil.g:3002:3: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )
        // InternalRtVil.g:3002:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
        {
        otherlv_6=(Token)match(input,27,FOLLOW_8); if (state.failed) return ;
        otherlv_7=(Token)match(input,14,FOLLOW_21); if (state.failed) return ;
        // InternalRtVil.g:3010:1: ( (lv_condition_8_0= ruleExpression ) )
        // InternalRtVil.g:3011:1: (lv_condition_8_0= ruleExpression )
        {
        // InternalRtVil.g:3011:1: (lv_condition_8_0= ruleExpression )
        // InternalRtVil.g:3012:3: lv_condition_8_0= ruleExpression
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
    // $ANTLR end synpred76_InternalRtVil

    // $ANTLR start synpred92_InternalRtVil
    public final void synpred92_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:3935:1: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // InternalRtVil.g:3935:1: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // InternalRtVil.g:3935:1: (lv_right_1_0= ruleLogicalExpressionPart )
        // InternalRtVil.g:3936:3: lv_right_1_0= ruleLogicalExpressionPart
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
    // $ANTLR end synpred92_InternalRtVil

    // $ANTLR start synpred97_InternalRtVil
    public final void synpred97_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4104:1: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // InternalRtVil.g:4104:1: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // InternalRtVil.g:4104:1: (lv_right_1_0= ruleEqualityExpressionPart )
        // InternalRtVil.g:4105:3: lv_right_1_0= ruleEqualityExpressionPart
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
    // $ANTLR end synpred97_InternalRtVil

    // $ANTLR start synpred100_InternalRtVil
    public final void synpred100_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right2_2_0 = null;


        // InternalRtVil.g:4277:1: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )
        // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
        {
        // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
        // InternalRtVil.g:4278:3: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred100_InternalRtVil

    // $ANTLR start synpred101_InternalRtVil
    public final void synpred101_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;


        // InternalRtVil.g:4258:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )
        // InternalRtVil.g:4258:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        {
        // InternalRtVil.g:4258:3: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // InternalRtVil.g:4259:1: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // InternalRtVil.g:4259:1: (lv_right_1_0= ruleRelationalExpressionPart )
        // InternalRtVil.g:4260:3: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_61);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalRtVil.g:4276:2: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
        int alt127=2;
        int LA127_0 = input.LA(1);

        if ( ((LA127_0>=64 && LA127_0<=67)) ) {
            alt127=1;
        }
        switch (alt127) {
            case 1 :
                // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                {
                // InternalRtVil.g:4277:1: (lv_right2_2_0= ruleRelationalExpressionPart )
                // InternalRtVil.g:4278:3: lv_right2_2_0= ruleRelationalExpressionPart
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
    // $ANTLR end synpred101_InternalRtVil

    // $ANTLR start synpred105_InternalRtVil
    public final void synpred105_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4439:1: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // InternalRtVil.g:4439:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // InternalRtVil.g:4439:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        // InternalRtVil.g:4440:3: lv_right_1_0= ruleAdditiveExpressionPart
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
    // $ANTLR end synpred105_InternalRtVil

    // $ANTLR start synpred107_InternalRtVil
    public final void synpred107_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // InternalRtVil.g:4587:1: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // InternalRtVil.g:4587:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // InternalRtVil.g:4587:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // InternalRtVil.g:4588:3: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // $ANTLR end synpred107_InternalRtVil

    // $ANTLR start synpred124_InternalRtVil
    public final void synpred124_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalRtVil.g:5470:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalRtVil.g:5470:1: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalRtVil.g:5470:1: (lv_decl_2_0= ruleDeclarator )
        // InternalRtVil.g:5471:3: lv_decl_2_0= ruleDeclarator
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
    // $ANTLR end synpred124_InternalRtVil

    // $ANTLR start synpred132_InternalRtVil
    public final void synpred132_InternalRtVil_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalRtVil.g:5834:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalRtVil.g:5834:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalRtVil.g:5834:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalRtVil.g:5835:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalRtVil.g:5835:1: (lv_qValue_2_0= ruleQualifiedName )
        // InternalRtVil.g:5836:3: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred132_InternalRtVil

    // $ANTLR start synpred136_InternalRtVil
    public final void synpred136_InternalRtVil_fragment() throws RecognitionException {   
        // InternalRtVil.g:5900:7: ( ( RULE_VERSION ) )
        // InternalRtVil.g:5901:1: ( RULE_VERSION )
        {
        // InternalRtVil.g:5901:1: ( RULE_VERSION )
        // InternalRtVil.g:5902:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred136_InternalRtVil

    // Delegated rules

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
    public final boolean synpred97_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_InternalRtVil_fragment(); // can never throw exception
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
    public final boolean synpred92_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred74_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred74_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_InternalRtVil_fragment(); // can never throw exception
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
    public final boolean synpred67_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred124_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred124_InternalRtVil_fragment(); // can never throw exception
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
    public final boolean synpred132_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_InternalRtVil_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_InternalRtVil() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_InternalRtVil_fragment(); // can never throw exception
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


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA101 dfa101 = new DFA101(this);
    static final String dfa_1s = "\44\uffff";
    static final String dfa_2s = "\1\1\43\uffff";
    static final String dfa_3s = "\1\4\4\uffff\10\0\27\uffff";
    static final String dfa_4s = "\1\126\4\uffff\10\0\27\uffff";
    static final String dfa_5s = "\1\uffff\1\7\1\uffff\1\1\11\uffff\1\2\21\uffff\1\3\1\4\1\5\1\6\1\uffff";
    static final String dfa_6s = "\5\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\27\uffff}>";
    static final String[] dfa_7s = {
            "\1\15\1\6\1\15\1\5\1\7\5\uffff\1\15\1\uffff\1\15\1\1\1\uffff\1\3\1\37\4\uffff\1\15\1\40\10\uffff\1\15\1\uffff\2\15\4\uffff\1\15\1\uffff\1\15\1\3\2\42\1\uffff\1\41\1\uffff\1\10\20\uffff\1\15\1\uffff\4\15\5\uffff\3\15\1\11\1\12\1\13\1\14",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
            return "()* loopback of 332:2: ( ( (lv_elements_1_0= ruleGlobalVariableDeclaration ) ) | ( (lv_elements_2_0= ruleRuleDeclaration ) ) | ( (lv_elements_3_0= ruleStrategyDeclaration ) ) | ( (lv_elements_4_0= ruleTacticDeclaration ) ) | ( (lv_elements_5_0= ruleTypeDef ) ) | ( (lv_elements_6_0= ruleCompound ) ) )*";
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

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA9_6 = input.LA(1);

                         
                        int index9_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA9_7 = input.LA(1);

                         
                        int index9_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA9_8 = input.LA(1);

                         
                        int index9_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA9_9 = input.LA(1);

                         
                        int index9_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA9_10 = input.LA(1);

                         
                        int index9_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_10);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA9_11 = input.LA(1);

                         
                        int index9_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_11);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA9_12 = input.LA(1);

                         
                        int index9_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRtVil()) ) {s = 3;}

                        else if ( (synpred10_InternalRtVil()) ) {s = 13;}

                         
                        input.seek(index9_12);
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
    static final String dfa_8s = "\15\uffff";
    static final String dfa_9s = "\1\4\1\uffff\4\5\2\uffff\5\5";
    static final String dfa_10s = "\1\126\1\uffff\4\117\2\uffff\1\64\4\117";
    static final String dfa_11s = "\1\uffff\1\1\4\uffff\1\2\1\3\5\uffff";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\6\1\3\1\6\1\2\1\4\5\uffff\1\6\1\uffff\1\6\3\uffff\1\7\5\uffff\1\7\12\uffff\2\6\2\uffff\1\6\1\uffff\1\6\1\uffff\1\6\1\1\5\uffff\1\5\20\uffff\1\6\1\uffff\4\6\5\uffff\3\6\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "",
            "",
            "\1\12\1\uffff\1\11\1\13\53\uffff\1\14",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\10"
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
            return "742:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( (lv_breakdownStmt_2_0= ruleBreakdownStatement ) ) )";
        }
    }
    static final String dfa_14s = "\17\uffff";
    static final String dfa_15s = "\1\4\1\uffff\4\5\4\uffff\5\5";
    static final String dfa_16s = "\1\126\1\uffff\4\117\4\uffff\1\64\4\117";
    static final String dfa_17s = "\1\uffff\1\1\4\uffff\1\2\1\3\1\4\1\5\5\uffff";
    static final String dfa_18s = "\17\uffff}>";
    static final String[] dfa_19s = {
            "\1\6\1\3\1\6\1\2\1\4\5\uffff\1\6\1\uffff\1\6\16\uffff\2\11\4\uffff\2\6\1\10\1\7\1\6\1\uffff\1\6\1\uffff\1\6\1\1\5\uffff\1\5\20\uffff\1\6\1\uffff\4\6\5\uffff\3\6\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\2\uffff\1\6\16\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "",
            "",
            "",
            "",
            "\1\14\1\uffff\1\13\1\15\53\uffff\1\16",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12",
            "\1\1\1\uffff\2\1\5\uffff\1\6\3\uffff\1\6\21\uffff\1\6\17\uffff\1\1\2\uffff\20\6\4\uffff\2\6\2\uffff\1\12"
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
            return "1352:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) | ( ( (lv_while_2_0= ruleWhile ) ) (otherlv_3= ';' )? ) | ( ( (lv_for_4_0= ruleFor ) ) (otherlv_5= ';' )? ) | ( (lv_fail_6_0= ruleFailStatement ) ) )";
        }
    }
    static final String dfa_20s = "\33\uffff";
    static final String dfa_21s = "\1\4\1\uffff\4\0\25\uffff";
    static final String dfa_22s = "\1\126\1\uffff\4\0\25\uffff";
    static final String dfa_23s = "\1\uffff\1\1\10\uffff\1\2\20\uffff";
    static final String dfa_24s = "\2\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_25s = {
            "\1\12\1\3\1\12\1\2\1\4\5\uffff\1\12\1\uffff\1\12\10\uffff\1\12\11\uffff\1\1\1\uffff\2\12\4\uffff\1\12\1\uffff\1\12\6\uffff\1\5\20\uffff\1\12\1\uffff\4\12\5\uffff\3\12\4\1",
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

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "1735:2: ( ( (lv_modifier_1_0= ruleRuleModifier ) )? ( (lv_type_2_0= ruleType ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred48_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index39_5);
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
    static final String dfa_26s = "\14\uffff";
    static final String dfa_27s = "\1\4\4\16\1\uffff\1\5\1\uffff\4\16";
    static final String dfa_28s = "\1\122\4\117\1\uffff\1\64\1\uffff\4\117";
    static final String dfa_29s = "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String dfa_30s = "\14\uffff}>";
    static final String[] dfa_31s = {
            "\1\5\1\2\1\5\1\1\1\3\5\uffff\1\5\1\uffff\1\5\24\uffff\2\5\4\uffff\1\5\1\uffff\1\5\6\uffff\1\4\20\uffff\1\5\1\uffff\4\5\5\uffff\3\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\6\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "",
            "\1\11\1\uffff\1\10\1\12\53\uffff\1\13",
            "",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5",
            "\1\5\3\uffff\1\5\2\uffff\1\7\16\uffff\1\5\22\uffff\20\5\4\uffff\2\5\2\uffff\1\5"
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "2008:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String dfa_32s = "\22\uffff";
    static final String dfa_33s = "\2\uffff\4\1\10\uffff\4\1";
    static final String dfa_34s = "\1\4\1\uffff\4\15\6\uffff\1\5\1\uffff\4\15";
    static final String dfa_35s = "\1\122\1\uffff\4\117\6\uffff\1\64\1\uffff\4\117";
    static final String dfa_36s = "\1\uffff\1\1\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\4\uffff";
    static final String dfa_37s = "\22\uffff}>";
    static final String[] dfa_38s = {
            "\1\1\1\3\1\1\1\2\1\4\5\uffff\1\1\26\uffff\1\12\1\10\4\uffff\1\11\1\uffff\1\7\6\uffff\1\5\24\uffff\1\6\1\13\5\uffff\3\1",
            "",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16\1\20\53\uffff\1\21",
            "",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14",
            "\1\1\1\15\4\1\6\uffff\1\1\1\uffff\2\1\7\uffff\1\1\16\uffff\1\1\3\uffff\20\1\4\uffff\4\1\1\14"
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "2118:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String dfa_39s = "\36\uffff";
    static final String dfa_40s = "\1\2\35\uffff";
    static final String dfa_41s = "\1\15\1\0\34\uffff";
    static final String dfa_42s = "\1\116\1\0\34\uffff";
    static final String dfa_43s = "\2\uffff\1\2\32\uffff\1\1";
    static final String dfa_44s = "\1\uffff\1\0\34\uffff}>";
    static final String[] dfa_45s = {
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

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_39;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "2357:1: ( (lv_versionSpec_6_0= ruleVersionSpec ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_InternalRtVil()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index52_1);
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
    static final String dfa_46s = "\27\uffff";
    static final String dfa_47s = "\1\4\23\uffff\1\0\2\uffff";
    static final String dfa_48s = "\1\122\23\uffff\1\0\2\uffff";
    static final String dfa_49s = "\1\uffff\1\1\24\uffff\1\2";
    static final String dfa_50s = "\24\uffff\1\0\2\uffff}>";
    static final String[] dfa_51s = {
            "\5\1\5\uffff\1\1\1\uffff\1\24\24\uffff\2\1\2\uffff\1\1\1\uffff\1\1\1\uffff\1\1\6\uffff\1\1\20\uffff\1\1\1\uffff\4\1\5\uffff\3\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "2892:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA59_20 = input.LA(1);

                         
                        int index59_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_InternalRtVil()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index59_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 59, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_39;
            this.eof = dfa_40;
            this.min = dfa_41;
            this.max = dfa_42;
            this.accept = dfa_43;
            this.special = dfa_44;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "3002:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalRtVil()) ) {s = 29;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index60_1);
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
    static final String dfa_52s = "\32\uffff";
    static final String dfa_53s = "\1\4\4\0\25\uffff";
    static final String dfa_54s = "\1\126\4\0\25\uffff";
    static final String dfa_55s = "\5\uffff\1\1\3\uffff\1\2\20\uffff";
    static final String dfa_56s = "\1\uffff\1\0\1\1\1\2\1\3\25\uffff}>";
    static final String[] dfa_57s = {
            "\1\11\1\2\1\11\1\1\1\3\5\uffff\3\11\24\uffff\2\11\4\uffff\1\11\1\uffff\1\11\6\uffff\1\4\20\uffff\1\11\1\uffff\4\11\5\uffff\3\11\4\5",
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

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "5469:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA101_1 = input.LA(1);

                         
                        int index101_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalRtVil()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index101_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA101_2 = input.LA(1);

                         
                        int index101_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalRtVil()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index101_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA101_3 = input.LA(1);

                         
                        int index101_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalRtVil()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index101_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA101_4 = input.LA(1);

                         
                        int index101_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred124_InternalRtVil()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index101_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 101, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0068000200002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0008000200002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0008000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0008000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00100000000001A0L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00100000000081A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0015E868061B41F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0015E868061941F2L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00104000000801A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00102860020141F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0010400000C801A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00102860000141F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00106A60051941F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00106A60051B41F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00106BE1800B41F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00100000000041A0L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00102860000041F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x001028600001C1F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000028040000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00102868020141F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00106BE1C00B41F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00102A60000141F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00102860080541F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000008040000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00100000000001A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x00102860000041F2L,0x00000000000707A0L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000001000200000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00100000000001B0L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000012200000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00102A68020141F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00101000000001A0L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000001000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00104000000A01A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0080000008040000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x1F00000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0xE000000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000FL});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0080000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000040000L,0x0000000000004000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x001028600001C1F0L,0x00000000007F07A0L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x00100000000041A0L,0x0000000000780000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000010008000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x00102860000341F0L,0x00000000000707A0L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000010020000L});

}