package de.uni_hildesheim.sse.vil.expressions.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.vil.expressions.services.ExpressionDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VERSION", "RULE_STRING", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@advice'", "'('", "')'", "'with'", "'version'", "';'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'->'", "'['", "']'", "'|'", "','", "'='", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'{'", "'}'"
    };
    public static final int RULE_ID=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int RULE_VERSION=4;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_EXPONENT=8;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalExpressionDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionDslParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private ExpressionDslGrammarAccess grammarAccess;
     	
        public InternalExpressionDslParser(TokenStream input, ExpressionDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "LanguageUnit";	
       	}
       	
       	@Override
       	protected ExpressionDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLanguageUnit"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:73:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:74:2: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:75:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageUnitRule()); 
            }
            pushFollow(FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81);
            iv_ruleLanguageUnit=ruleLanguageUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLanguageUnit91); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:82:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_version_2_0= ruleVersionStmt ) )? ( (lv_imports_3_0= ruleImport ) )* ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_advices_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_2_0 = null;

        EObject lv_imports_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:85:28: ( ( ( (lv_advices_0_0= ruleAdvice ) )* ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_version_2_0= ruleVersionStmt ) )? ( (lv_imports_3_0= ruleImport ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:86:1: ( ( (lv_advices_0_0= ruleAdvice ) )* ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_version_2_0= ruleVersionStmt ) )? ( (lv_imports_3_0= ruleImport ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:86:1: ( ( (lv_advices_0_0= ruleAdvice ) )* ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_version_2_0= ruleVersionStmt ) )? ( (lv_imports_3_0= ruleImport ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:86:2: ( (lv_advices_0_0= ruleAdvice ) )* ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_version_2_0= ruleVersionStmt ) )? ( (lv_imports_3_0= ruleImport ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:86:2: ( (lv_advices_0_0= ruleAdvice ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:87:1: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:87:1: (lv_advices_0_0= ruleAdvice )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:88:3: lv_advices_0_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdvice_in_ruleLanguageUnit137);
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
            	              		"Advice");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:104:3: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:105:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:105:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:106:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLanguageUnit159);
            lv_name_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:122:2: ( (lv_version_2_0= ruleVersionStmt ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:123:1: (lv_version_2_0= ruleVersionStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:123:1: (lv_version_2_0= ruleVersionStmt )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:124:3: lv_version_2_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionStmt_in_ruleLanguageUnit180);
                    lv_version_2_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_2_0, 
                              		"VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:140:3: ( (lv_imports_3_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:141:1: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:141:1: (lv_imports_3_0= ruleImport )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:142:3: lv_imports_3_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getImportsImportParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleLanguageUnit202);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_3_0, 
            	              		"Import");
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
    // $ANTLR end "ruleLanguageUnit"


    // $ANTLR start "entryRuleAdvice"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:168:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:169:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:170:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice241);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice251); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:177:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:180:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:181:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:181:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:181:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAdvice288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAdvice300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:189:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:190:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:190:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:191:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice321);
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
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAdvice333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:211:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:212:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:212:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:213:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice354);
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
                              		"VersionSpec");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:237:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:238:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:239:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec391);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec401); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:246:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:249:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVersionSpec438); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:254:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:255:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:255:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:256:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec459);
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
                      		"Expression");
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


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:282:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:283:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:284:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter497);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter507); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:291:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:294:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:295:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:295:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:295:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:295:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:296:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:296:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:297:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter553);
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
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:313:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:314:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:314:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:315:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter574);
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
                      		"Identifier");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleVersionStmt"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:339:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:340:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:341:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt610);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt620); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:348:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:351:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:352:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:352:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:352:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleVersionStmt657); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:356:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:357:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:357:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:358:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt674); if (state.failed) return current;
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
                      		"VERSION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVersionStmt691); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:386:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:387:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:388:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport727);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport737); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:395:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:398:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:399:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:399:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:399:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleImport774); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:403:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:404:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:404:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:405:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport795);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:421:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:422:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:422:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:423:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport816);
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
                              		"VersionSpec");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleImport829); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:453:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:454:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:455:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression867);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression877); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:462:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:465:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:466:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:466:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_VERSION && LA6_0<=RULE_EXPONENT)||LA6_0==14||LA6_0==17||LA6_0==31||(LA6_0>=34 && LA6_0<=36)||LA6_0==38||(LA6_0>=46 && LA6_0<=48)) ) {
                alt6=1;
            }
            else if ( (LA6_0==52) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:466:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:466:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:467:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:467:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:468:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression923);
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
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:485:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:485:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:486:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:486:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:487:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression950);
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
                              		"ContainerInitializer");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:511:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:512:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:513:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression986);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression996); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:520:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:523:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:524:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:524:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:524:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:524:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:525:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:525:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:526:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1042);
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
                      		"EqualityExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:542:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=20 && LA7_0<=22)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:543:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:543:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:544:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1063);
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
            	              		"LogicalExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:568:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:569:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:570:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1100);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart1110); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:577:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:580:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:581:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:581:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:581:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:581:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:582:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:582:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:583:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1156);
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
                      		"LogicalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:599:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:600:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:600:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:601:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1177);
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
                      		"EqualityExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:625:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:626:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:627:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1214);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator1225); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:634:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:637:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:638:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:638:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt8=1;
                }
                break;
            case 21:
                {
                alt8=2;
                }
                break;
            case 22:
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:639:2: kw= 'and'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleLogicalOperator1263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:646:2: kw= 'or'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleLogicalOperator1282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:653:2: kw= 'xor'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleLogicalOperator1301); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:666:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:667:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:668:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1341);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1351); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:675:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:678:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:679:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:679:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:679:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:679:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:680:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:680:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:681:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1397);
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
                      		"RelationalExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:697:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=23 && LA9_0<=25)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:698:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:698:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:699:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1418);
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
                              		"EqualityExpressionPart");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:723:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:724:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:725:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1455);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart1465); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:732:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:735:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:736:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:736:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:736:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:736:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:737:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:737:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:738:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1511);
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
                      		"EqualityOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:754:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:755:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:755:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:756:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1532);
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
                      		"RelationalExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:780:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:781:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:782:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1569);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator1580); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:789:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:792:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:793:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:793:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt10=1;
                }
                break;
            case 24:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:794:2: kw= '=='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleEqualityOperator1618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:801:2: kw= '<>'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleEqualityOperator1637); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:808:2: kw= '!='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleEqualityOperator1656); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:821:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:822:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:823:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1696);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1706); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:830:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:833:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:834:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:834:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:834:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:834:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:835:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:835:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:836:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1752);
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
                      		"AdditiveExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:852:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=26 && LA11_0<=29)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:853:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:853:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:854:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression1773);
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
                              		"RelationalExpressionPart");
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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleRelationalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:878:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:879:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:880:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1810);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart1820); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:887:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:890:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:891:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:891:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:891:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:891:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:892:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:892:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:893:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart1866);
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
                      		"RelationalOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:909:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:910:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:910:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:911:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart1887);
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
                      		"AdditiveExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:935:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:936:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:937:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1924);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator1935); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:944:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:947:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:948:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:948:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 27:
                {
                alt12=2;
                }
                break;
            case 28:
                {
                alt12=3;
                }
                break;
            case 29:
                {
                alt12=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:949:2: kw= '>'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleRelationalOperator1973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:956:2: kw= '<'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleRelationalOperator1992); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:963:2: kw= '>='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleRelationalOperator2011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:970:2: kw= '<='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleRelationalOperator2030); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:983:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:984:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:985:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2070);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression2080); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:992:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:995:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:996:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:996:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:996:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:996:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:997:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:997:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2126);
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
                      		"MultiplicativeExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1014:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=30 && LA13_0<=31)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1015:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1015:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1016:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2147);
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
            	              		"AdditiveExpressionPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1040:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1041:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1042:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2184);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2194); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1049:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1052:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1053:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1053:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1053:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1053:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1054:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1054:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2240);
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
                      		"AdditiveOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1071:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1072:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1072:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1073:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2261);
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
                      		"MultiplicativeExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1097:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1098:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1099:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2298);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator2309); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1106:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1109:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1110:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1110:1: (kw= '+' | kw= '-' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1111:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleAdditiveOperator2347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1118:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleAdditiveOperator2366); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1131:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1132:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1133:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2406);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2416); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1140:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1143:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1144:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1144:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1144:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1144:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1145:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1145:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1146:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2462);
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
                      		"UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1162:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=32 && LA15_0<=33)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1163:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1163:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1164:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2483);
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
                              		"MultiplicativeExpressionPart");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1188:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1189:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1190:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2520);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2530); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1197:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1200:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1201:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1201:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1201:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1201:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1202:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1202:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1203:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2576);
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
                      		"MultiplicativeOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1219:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1220:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1220:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1221:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2597);
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
                      		"UnaryExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1245:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1246:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1247:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2634);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator2645); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1254:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1257:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1258:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1258:1: (kw= '*' | kw= '/' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==32) ) {
                alt16=1;
            }
            else if ( (LA16_0==33) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1259:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleMultiplicativeOperator2683); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1266:2: kw= '/'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleMultiplicativeOperator2702); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1279:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1280:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1281:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2742);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression2752); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1288:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1291:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1292:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1292:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1292:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1292:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31||(LA17_0>=34 && LA17_0<=35)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1293:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1293:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1294:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression2798);
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
                              		"UnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1310:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1311:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1311:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1312:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression2820);
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
                      		"PostfixExpression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1336:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1337:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1338:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2857);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator2868); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1345:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1348:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1349:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1349:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt18=1;
                }
                break;
            case 35:
                {
                alt18=2;
                }
                break;
            case 31:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1350:2: kw= 'not'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleUnaryOperator2906); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1357:2: kw= '!'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleUnaryOperator2925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1364:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleUnaryOperator2944); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1377:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1378:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1379:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression2984);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression2994); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1386:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1389:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1390:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1390:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1391:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1391:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1392:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3039);
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
                      		"PrimaryExpression");
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


    // $ANTLR start "entryRulePrimaryExpression"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1416:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1417:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1418:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3074);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3084); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1425:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1428:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1429:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1429:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1429:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1429:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1430:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1430:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1431:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3130);
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
                              		"ExpressionOrQualifiedExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1448:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1448:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1449:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1449:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1450:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3157);
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
                              		"UnqualifiedExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1467:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1467:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1468:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1468:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1469:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3184);
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
                              		"SuperExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1486:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1486:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1487:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1487:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1488:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3211);
                    lv_newEx_3_0=ruleConstructorExecution();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"newEx",
                              		lv_newEx_3_0, 
                              		"ConstructorExecution");
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


    // $ANTLR start "entryRuleExpressionOrQualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1512:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1513:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1514:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3247);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3257); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1521:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1524:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_VERSION && LA20_0<=RULE_EXPONENT)||LA20_0==17||(LA20_0>=46 && LA20_0<=48)) ) {
                alt20=1;
            }
            else if ( (LA20_0==14) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1526:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1526:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3304);
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
                              		"Constant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1544:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1544:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1544:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution3323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1548:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1549:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1549:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1550:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3344);
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
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution3356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1570:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==37||(LA21_0>=39 && LA21_0<=40)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1571:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1571:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1572:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3379);
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
            	              		"SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1596:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1597:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1598:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3416);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution3426); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1605:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1608:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1609:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1609:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1609:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1609:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1610:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1610:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1611:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution3472);
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
                      		"Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1627:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==37||(LA22_0>=39 && LA22_0<=40)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1628:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1628:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1629:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3493);
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
            	              		"SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1653:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1654:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1655:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3530);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution3540); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1662:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1665:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1666:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1666:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1666:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleSuperExecution3577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSuperExecution3589); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1674:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1675:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1675:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1676:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution3610);
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
                      		"Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1692:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==37||(LA23_0>=39 && LA23_0<=40)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1693:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1693:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1694:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution3631);
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
            	              		"SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1718:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1719:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1720:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution3668);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution3678); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1727:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1730:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1731:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1731:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1731:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleConstructorExecution3715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1735:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1736:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1736:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1737:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution3736);
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
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution3748); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1757:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_VERSION && LA24_0<=RULE_EXPONENT)||LA24_0==14||LA24_0==17||LA24_0==31||(LA24_0>=34 && LA24_0<=36)||LA24_0==38||(LA24_0>=46 && LA24_0<=48)||LA24_0==52) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1758:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1758:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1759:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution3769);
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
                              		"ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution3782); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1779:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37||(LA25_0>=39 && LA25_0<=40)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1780:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1780:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1781:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution3803);
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
            	              		"SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1805:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1806:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1807:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall3840);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall3850); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1814:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1817:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37||LA27_0==39) ) {
                alt27=1;
            }
            else if ( (LA27_0==40) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1818:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1819:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1819:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==37) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==39) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1821:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,37,FOLLOW_37_in_ruleSubCall3896); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1833:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,39,FOLLOW_39_in_ruleSubCall3925); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1848:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1849:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1849:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1850:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall3962);
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
                              		"Call");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1867:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1867:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1867:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleSubCall3982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1871:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1872:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1872:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1873:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall4003);
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
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,41,FOLLOW_41_in_ruleSubCall4015); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1901:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1902:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1903:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator4052);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator4062); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1910:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1913:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1914:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1914:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1914:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1914:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1915:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1915:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1916:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4108);
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
                      		"Declaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1932:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==18) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1932:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleDeclarator4121); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1936:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1937:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1937:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1938:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4142);
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
            	              		"Declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleDeclarator4156); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1966:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1967:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1968:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration4192);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration4202); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1975:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1978:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1979:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1979:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1979:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1979:2: ( (lv_type_0_0= ruleType ) )?
            int alt29=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==RULE_VERSION||(LA29_1>=RULE_ID && LA29_1<=RULE_EXPONENT)||LA29_1==17||LA29_1==45) ) {
                        alt29=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA29_2 = input.LA(2);

                    if ( (LA29_2==RULE_VERSION||(LA29_2>=RULE_ID && LA29_2<=RULE_EXPONENT)||LA29_2==17||LA29_2==45) ) {
                        alt29=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA29_3 = input.LA(2);

                    if ( (LA29_3==RULE_VERSION||(LA29_3>=RULE_ID && LA29_3<=RULE_EXPONENT)||LA29_3==17||LA29_3==45) ) {
                        alt29=1;
                    }
                    }
                    break;
                case 17:
                    {
                    int LA29_4 = input.LA(2);

                    if ( (LA29_4==RULE_VERSION||(LA29_4>=RULE_ID && LA29_4<=RULE_EXPONENT)||LA29_4==17||LA29_4==45) ) {
                        alt29=1;
                    }
                    }
                    break;
                case 49:
                case 50:
                case 51:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1980:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1980:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1981:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration4248);
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
                              		"Type");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1997:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1998:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1998:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1999:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration4270);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2015:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==43) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2015:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleDeclaration4283); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2019:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2020:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2020:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2021:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration4304);
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
            	              		"Identifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2045:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2046:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2047:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall4342);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall4352); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2054:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2057:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2058:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2058:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2058:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2058:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2059:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2059:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall4398);
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
                      		"QualifiedPrefix");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall4410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2080:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2081:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2081:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2082:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall4431);
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
                              		"Declarator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2098:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_VERSION && LA32_0<=RULE_EXPONENT)||LA32_0==14||LA32_0==17||LA32_0==31||(LA32_0>=34 && LA32_0<=36)||LA32_0==38||(LA32_0>=46 && LA32_0<=48)||LA32_0==52) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2099:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2099:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2100:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall4453);
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
                              		"ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall4466); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2128:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2129:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2130:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList4502);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList4512); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2137:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2140:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2141:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2141:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2141:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2141:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2142:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2142:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2143:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4558);
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
                      		"NamedArgument");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2159:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==43) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2159:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleArgumentList4571); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2163:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2164:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2164:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2165:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4592);
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
            	              		"NamedArgument");
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2189:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2190:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2191:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4630);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument4640); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2198:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2201:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt34=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==44) ) {
                        alt34=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA34_2 = input.LA(2);

                    if ( (LA34_2==44) ) {
                        alt34=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA34_3 = input.LA(2);

                    if ( (LA34_3==44) ) {
                        alt34=1;
                    }
                    }
                    break;
                case 17:
                    {
                    int LA34_4 = input.LA(2);

                    if ( (LA34_4==44) ) {
                        alt34=1;
                    }
                    }
                    break;
            }

            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2202:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2203:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2203:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument4687);
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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleNamedArgument4699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2224:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2225:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2225:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2226:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument4722);
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
                      		"Expression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2250:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2251:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2252:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix4758);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix4768); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2259:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2262:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2263:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2263:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2263:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2263:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2264:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2264:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4814);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2281:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==45) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2281:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2281:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2282:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2282:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2283:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,45,FOLLOW_45_in_ruleQualifiedPrefix4833); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2296:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2297:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2297:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2298:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4867);
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
            	              		"Identifier");
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2322:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2323:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2324:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4905);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName4915); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2331:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2334:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2335:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2335:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2335:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2335:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2336:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2336:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2337:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName4961);
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
                      		"QualifiedPrefix");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2353:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==37) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA36_3 = input.LA(3);

                        if ( (LA36_3==EOF||LA36_3==RULE_VERSION||(LA36_3>=RULE_ID && LA36_3<=RULE_EXPONENT)||LA36_3==13||LA36_3==15||(LA36_3>=17 && LA36_3<=18)||(LA36_3>=20 && LA36_3<=33)||LA36_3==37||(LA36_3>=39 && LA36_3<=41)||LA36_3==43||LA36_3==53) ) {
                            alt36=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA36_4 = input.LA(3);

                        if ( (LA36_4==EOF||LA36_4==RULE_VERSION||(LA36_4>=RULE_ID && LA36_4<=RULE_EXPONENT)||LA36_4==13||LA36_4==15||(LA36_4>=17 && LA36_4<=18)||(LA36_4>=20 && LA36_4<=33)||LA36_4==37||(LA36_4>=39 && LA36_4<=41)||LA36_4==43||LA36_4==53) ) {
                            alt36=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA36_5 = input.LA(3);

                        if ( (LA36_5==EOF||LA36_5==RULE_VERSION||(LA36_5>=RULE_ID && LA36_5<=RULE_EXPONENT)||LA36_5==13||LA36_5==15||(LA36_5>=17 && LA36_5<=18)||(LA36_5>=20 && LA36_5<=33)||LA36_5==37||(LA36_5>=39 && LA36_5<=41)||LA36_5==43||LA36_5==53) ) {
                            alt36=1;
                        }
                        }
                        break;
                    case 17:
                        {
                        int LA36_6 = input.LA(3);

                        if ( (LA36_6==EOF||LA36_6==RULE_VERSION||(LA36_6>=RULE_ID && LA36_6<=RULE_EXPONENT)||LA36_6==13||LA36_6==15||(LA36_6>=17 && LA36_6<=18)||(LA36_6>=20 && LA36_6<=33)||LA36_6==37||(LA36_6>=39 && LA36_6<=41)||LA36_6==43||LA36_6==53) ) {
                            alt36=1;
                        }
                        }
                        break;
                }

            }
            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2353:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2353:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2354:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2354:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2355:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName4980); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2368:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2369:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2369:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2370:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName5014);
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
                              		"Identifier");
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2394:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2395:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2396:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant5052);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant5062); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2403:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2406:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2407:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2407:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt38=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt38=1;
                }
                break;
            case RULE_STRING:
                {
                alt38=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 17:
                {
                alt38=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA38_4 = input.LA(2);

                if ( (synpred46_InternalExpressionDsl()) ) {
                    alt38=3;
                }
                else if ( (synpred50_InternalExpressionDsl()) ) {
                    alt38=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 4, input);

                    throw nvae;
                }
                }
                break;
            case 46:
            case 47:
                {
                alt38=4;
                }
                break;
            case 48:
                {
                alt38=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2407:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2407:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2408:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2408:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2409:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant5108);
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
                              		"NumValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2426:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2426:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2427:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2427:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2428:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant5131); if (state.failed) return current;
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
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2445:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2445:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2446:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2446:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2447:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant5163);
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
                              		"QualifiedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2464:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2464:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2465:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2465:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2466:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2466:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==46) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==47) ) {
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2467:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,46,FOLLOW_46_in_ruleConstant5189); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2479:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,47,FOLLOW_47_in_ruleConstant5218); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2495:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2495:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2496:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2496:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2497:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,48,FOLLOW_48_in_ruleConstant5258); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2511:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2511:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2511:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2517:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2518:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant5305); if (state.failed) return current;
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
                              		"VERSION");
                      	    
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2542:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2543:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2544:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue5346);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue5356); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2551:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2554:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2555:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2555:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2556:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2556:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2557:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue5397); if (state.failed) return current;
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
                      		"NUMBER");
              	    
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2581:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2582:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2583:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier5438);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier5449); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2590:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2593:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2594:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2594:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt39=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt39=1;
                }
                break;
            case RULE_VERSION:
                {
                alt39=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt39=3;
                }
                break;
            case 17:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2594:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier5489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2602:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier5515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2610:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier5541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2619:2: kw= 'version'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleIdentifier5565); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2632:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2633:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2634:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType5605);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType5615); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2641:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_set_1_0=null;
        Token lv_seq_3_0=null;
        Token lv_map_5_0=null;
        EObject lv_name_0_0 = null;

        EObject lv_param_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_param_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2644:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2645:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2645:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 17:
                {
                alt40=1;
                }
                break;
            case 49:
                {
                alt40=2;
                }
                break;
            case 50:
                {
                alt40=3;
                }
                break;
            case 51:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2645:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2645:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2646:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2646:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2647:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType5661);
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
                              		"QualifiedPrefix");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2664:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2664:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2664:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2664:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2665:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2665:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2666:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,49,FOLLOW_49_in_ruleType5686); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2679:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2680:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2680:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2681:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5720);
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
                              		"TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2698:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2698:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2698:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2698:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2699:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2699:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2700:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,50,FOLLOW_50_in_ruleType5746); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2713:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2714:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2714:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2715:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5780);
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
                              		"TypeParameters");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2732:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2732:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2732:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2732:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2733:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2733:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2734:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,51,FOLLOW_51_in_ruleType5806); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2747:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2748:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2748:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2749:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5840);
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
                              		"TypeParameters");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2773:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2774:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2775:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters5877);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters5887); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2782:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2785:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2786:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2786:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2786:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters5924); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2790:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2791:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2791:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2792:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters5945);
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
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2808:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==43) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2808:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleTypeParameters5958); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2812:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2814:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters5979);
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
            	              		"Type");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters5993); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2842:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2843:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2844:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6029);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer6039); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2851:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2854:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2855:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2855:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2855:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2855:2: ()
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2856:2: 
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

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleContainerInitializer6088); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2868:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_VERSION && LA43_0<=RULE_EXPONENT)||LA43_0==14||LA43_0==17||LA43_0==31||(LA43_0>=34 && LA43_0<=36)||LA43_0==38||(LA43_0>=46 && LA43_0<=48)||LA43_0==52) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2868:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2868:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2869:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2869:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2870:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6110);
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
                              		"ContainerInitializerExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2886:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==43) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2886:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleContainerInitializer6123); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2890:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2891:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2891:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2892:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6144);
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
                    	              		"ContainerInitializerExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,53,FOLLOW_53_in_ruleContainerInitializer6160); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2920:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2921:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2922:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6196);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression6206); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2929:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2932:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2933:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2933:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_VERSION && LA44_0<=RULE_EXPONENT)||LA44_0==14||LA44_0==17||LA44_0==31||(LA44_0>=34 && LA44_0<=36)||LA44_0==38||(LA44_0>=46 && LA44_0<=48)) ) {
                alt44=1;
            }
            else if ( (LA44_0==52) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2933:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2933:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2934:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2934:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2935:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6252);
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
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2952:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2952:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2953:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2953:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2954:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6279);
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
                              		"ContainerInitializer");
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

    // $ANTLR start synpred46_InternalExpressionDsl
    public final void synpred46_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2445:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2445:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2445:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2446:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2446:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2447:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred46_InternalExpressionDsl5163);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred46_InternalExpressionDsl

    // $ANTLR start synpred50_InternalExpressionDsl
    public final void synpred50_InternalExpressionDsl_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2511:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2512:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2512:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2513:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred50_InternalExpressionDsl5291); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred50_InternalExpressionDsl

    // Delegated rules

    public final boolean synpred50_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA19 dfa19 = new DFA19(this);
    protected DFA31 dfa31 = new DFA31(this);
    static final String DFA19_eotS =
        "\16\uffff";
    static final String DFA19_eofS =
        "\2\uffff\4\1\4\uffff\4\1";
    static final String DFA19_minS =
        "\1\4\1\uffff\4\4\2\uffff\1\4\1\uffff\4\4";
    static final String DFA19_maxS =
        "\1\60\1\uffff\4\65\2\uffff\1\21\1\uffff\4\65";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\uffff\1\2\4\uffff";
    static final String DFA19_specialS =
        "\16\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\3\2\1\1\2\1\4\5\uffff\1\1\2\uffff\1\5\22\uffff\1\6\1\uffff"+
            "\1\7\7\uffff\3\1",
            "",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "",
            "",
            "\1\13\2\uffff\1\12\1\14\10\uffff\1\15",
            "",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\10\7\uffff"+
            "\1\1"
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1429:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA31_eotS =
        "\21\uffff";
    static final String DFA31_eofS =
        "\21\uffff";
    static final String DFA31_minS =
        "\5\4\2\uffff\6\4\4\16";
    static final String DFA31_maxS =
        "\1\64\4\55\2\uffff\1\21\1\64\10\55";
    static final String DFA31_acceptS =
        "\5\uffff\1\1\1\2\12\uffff";
    static final String DFA31_specialS =
        "\21\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\2\6\1\1\1\3\5\uffff\2\6\1\uffff\1\4\15\uffff\1\6\2\uffff"+
            "\3\6\1\uffff\1\6\7\uffff\3\6\3\5\1\6",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\2\5\1\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\1\uffff\1\5\1\10\1\6\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\2\5\1\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\1\uffff\1\5\1\10\1\6\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\2\5\1\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\1\uffff\1\5\1\10\1\6\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\2\5\1\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\1\uffff\1\5\1\10\1\6\1\7",
            "",
            "",
            "\1\12\2\uffff\1\11\1\13\10\uffff\1\14",
            "\1\16\2\6\1\15\1\17\5\uffff\1\6\2\uffff\1\20\15\uffff\1\6"+
            "\2\uffff\3\6\1\uffff\1\6\7\uffff\3\6\3\uffff\1\6",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\1\5\2\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\2\uffff\1\6\1\uffff\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\1\5\2\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\2\uffff\1\6\1\uffff\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\1\5\2\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\2\uffff\1\6\1\uffff\1\7",
            "\1\5\2\uffff\2\5\5\uffff\2\6\1\uffff\1\5\2\uffff\16\6\3\uffff"+
            "\1\6\1\uffff\2\6\2\uffff\1\6\1\uffff\1\7",
            "\2\6\2\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\10\2\6",
            "\2\6\2\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\10\2\6",
            "\2\6\2\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\10\2\6",
            "\2\6\2\uffff\1\5\1\uffff\16\6\3\uffff\1\6\1\uffff\2\6\1\uffff"+
            "\1\5\1\10\2\6"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "2080:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000000000022190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit159 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit180 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit202 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAdvice288 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice300 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice321 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice333 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVersionSpec438 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter553 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVersionStmt657 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt674 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVersionStmt691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleImport774 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport795 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport816 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleImport829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1042 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1063 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1156 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleLogicalOperator1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLogicalOperator1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLogicalOperator1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1397 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1511 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleEqualityOperator1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEqualityOperator1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleEqualityOperator1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1752 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart1866 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRelationalOperator1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleRelationalOperator1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleRelationalOperator2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleRelationalOperator2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2126 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2147 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2240 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAdditiveOperator2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAdditiveOperator2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2462 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2576 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMultiplicativeOperator2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeOperator2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression2798 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleUnaryOperator2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryOperator2925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnaryOperator2944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression2984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3304 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution3323 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3344 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution3356 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3379 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution3472 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3493 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSuperExecution3577 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSuperExecution3589 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution3610 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution3631 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution3668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution3678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleConstructorExecution3715 = new BitSet(new long[]{0x000E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution3736 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution3748 = new BitSet(new long[]{0x0011C05C8002C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution3769 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution3782 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution3803 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall3840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSubCall3896 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_39_in_ruleSubCall3925 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleSubCall3982 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall4003 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSubCall4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator4052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4108 = new BitSet(new long[]{0x0000040000040000L});
    public static final BitSet FOLLOW_18_in_ruleDeclarator4121 = new BitSet(new long[]{0x000E000000020190L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4142 = new BitSet(new long[]{0x0000040000040000L});
    public static final BitSet FOLLOW_42_in_ruleDeclarator4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration4192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration4202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration4248 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration4270 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleDeclaration4283 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration4304 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall4342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall4352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall4398 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall4410 = new BitSet(new long[]{0x001FC05C8002C1F0L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall4431 = new BitSet(new long[]{0x0011C05C8002C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall4453 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall4466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList4502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4558 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleArgumentList4571 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4592 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument4687 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleNamedArgument4699 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument4722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix4758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix4768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4814 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleQualifiedPrefix4833 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4867 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName4961 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName4980 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName5014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant5052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleConstant5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleConstant5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConstant5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue5346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue5397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier5438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier5449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleIdentifier5565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType5605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType5615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType5661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleType5686 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleType5746 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleType5806 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters5877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters5924 = new BitSet(new long[]{0x000E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters5945 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_43_in_ruleTypeParameters5958 = new BitSet(new long[]{0x000E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters5979 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters5993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleContainerInitializer6088 = new BitSet(new long[]{0x0031C05C800241F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6110 = new BitSet(new long[]{0x0020080000000000L});
    public static final BitSet FOLLOW_43_in_ruleContainerInitializer6123 = new BitSet(new long[]{0x0011C05C800241F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6144 = new BitSet(new long[]{0x0020080000000000L});
    public static final BitSet FOLLOW_53_in_ruleContainerInitializer6160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression6206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred46_InternalExpressionDsl5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred50_InternalExpressionDsl5291 = new BitSet(new long[]{0x0000000000000002L});

}