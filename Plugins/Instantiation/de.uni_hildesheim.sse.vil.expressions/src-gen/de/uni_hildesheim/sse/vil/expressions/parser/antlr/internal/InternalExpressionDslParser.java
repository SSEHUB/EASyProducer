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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VERSION", "RULE_STRING", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@advice'", "'('", "')'", "'with'", "','", "'version'", "'=='", "'>'", "'<'", "'>='", "'<='", "';'", "'import'", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'->'", "'['", "']'", "'|'", "'='", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'{'", "'}'"
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

            if ( (LA2_0==18) ) {
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

                if ( (LA3_0==25) ) {
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:246:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_conflicts_2_0 = null;

        EObject lv_conflicts_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:249:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:250:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVersionSpec438); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleVersionSpec450); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:258:1: ( (lv_conflicts_2_0= ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:259:1: (lv_conflicts_2_0= ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:259:1: (lv_conflicts_2_0= ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:260:3: lv_conflicts_2_0= ruleVersionedId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec471);
            lv_conflicts_2_0=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionSpecRule());
              	        }
                     		add(
                     			current, 
                     			"conflicts",
                      		lv_conflicts_2_0, 
                      		"VersionedId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:276:2: (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:276:4: otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleVersionSpec484); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:280:1: ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:281:1: (lv_conflicts_4_0= ruleVersionedId )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:281:1: (lv_conflicts_4_0= ruleVersionedId )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:282:3: lv_conflicts_4_0= ruleVersionedId
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec505);
            	    lv_conflicts_4_0=ruleVersionedId();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVersionSpecRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"conflicts",
            	              		lv_conflicts_4_0, 
            	              		"VersionedId");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleVersionSpec519); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getVersionSpecAccess().getRightParenthesisKeyword_4());
                  
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


    // $ANTLR start "entryRuleVersionedId"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:310:1: entryRuleVersionedId returns [EObject current=null] : iv_ruleVersionedId= ruleVersionedId EOF ;
    public final EObject entryRuleVersionedId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionedId = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:311:2: (iv_ruleVersionedId= ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:312:2: iv_ruleVersionedId= ruleVersionedId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionedIdRule()); 
            }
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId555);
            iv_ruleVersionedId=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionedId; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId565); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionedId"


    // $ANTLR start "ruleVersionedId"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:319:1: ruleVersionedId returns [EObject current=null] : (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) ;
    public final EObject ruleVersionedId() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_2_0=null;
        AntlrDatatypeRuleToken lv_op_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:322:28: ( (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:323:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:323:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:323:3: otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVersionedId602); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionedIdAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:327:1: ( (lv_op_1_0= ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:328:1: (lv_op_1_0= ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:328:1: (lv_op_1_0= ruleVersionOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:329:3: lv_op_1_0= ruleVersionOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_ruleVersionedId623);
            lv_op_1_0=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionedIdRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_1_0, 
                      		"VersionOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:345:2: ( (lv_version_2_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:346:1: (lv_version_2_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:346:1: (lv_version_2_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:347:3: lv_version_2_0= RULE_VERSION
            {
            lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionedId640); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_version_2_0, grammarAccess.getVersionedIdAccess().getVersionVERSIONTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVersionedIdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"version",
                      		lv_version_2_0, 
                      		"VERSION");
              	    
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
    // $ANTLR end "ruleVersionedId"


    // $ANTLR start "entryRuleVersionOperator"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:371:1: entryRuleVersionOperator returns [String current=null] : iv_ruleVersionOperator= ruleVersionOperator EOF ;
    public final String entryRuleVersionOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:372:2: (iv_ruleVersionOperator= ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:373:2: iv_ruleVersionOperator= ruleVersionOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator682);
            iv_ruleVersionOperator=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator693); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionOperator"


    // $ANTLR start "ruleVersionOperator"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:380:1: ruleVersionOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleVersionOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:383:28: ( (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:384:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:384:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt6=5;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt6=1;
                }
                break;
            case 20:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            case 23:
                {
                alt6=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:385:2: kw= '=='
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleVersionOperator731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:392:2: kw= '>'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleVersionOperator750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:399:2: kw= '<'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleVersionOperator769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:406:2: kw= '>='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleVersionOperator788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:413:2: kw= '<='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleVersionOperator807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignEqualsSignKeyword_4()); 
                          
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
    // $ANTLR end "ruleVersionOperator"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:428:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:429:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:430:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter849);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter859); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:437:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:440:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:441:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:441:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:441:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:442:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:442:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:443:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter905);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:459:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:460:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:460:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:461:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter926);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:485:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:486:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:487:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt962);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt972); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:494:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:497:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:498:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:498:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:498:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleVersionStmt1009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:502:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:503:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:503:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:504:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt1026); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleVersionStmt1043); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:532:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:533:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:534:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport1079);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport1089); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:541:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:544:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:545:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:545:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:545:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleImport1126); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:549:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:550:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:550:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:551:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport1147);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:567:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:568:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:568:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:569:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport1168);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleImport1181); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:599:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:600:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:601:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1219);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1229); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:608:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:611:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:612:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:612:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_VERSION && LA8_0<=RULE_EXPONENT)||LA8_0==14||LA8_0==32||(LA8_0>=35 && LA8_0<=37)||LA8_0==39||(LA8_0>=46 && LA8_0<=48)) ) {
                alt8=1;
            }
            else if ( (LA8_0==52) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:612:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:612:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:613:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:613:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:614:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression1275);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:631:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:631:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:632:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:632:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:633:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression1302);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:657:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:658:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:659:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression1338);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression1348); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:666:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:669:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:670:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:670:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:670:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:670:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:671:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:671:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:672:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1394);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:688:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=26 && LA9_0<=28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:689:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:689:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:690:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1415);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:714:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:715:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:716:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1452);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart1462); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:723:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:726:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:727:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:727:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:727:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:727:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:728:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:728:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:729:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1508);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:745:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:746:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:746:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:747:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1529);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:771:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:772:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:773:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1566);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator1577); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:780:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:783:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:784:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:784:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt10=1;
                }
                break;
            case 27:
                {
                alt10=2;
                }
                break;
            case 28:
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:785:2: kw= 'and'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleLogicalOperator1615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:792:2: kw= 'or'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleLogicalOperator1634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:799:2: kw= 'xor'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleLogicalOperator1653); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:812:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:813:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:814:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1693);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1703); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:821:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:824:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:825:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:825:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:825:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:825:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:826:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:826:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:827:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1749);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:843:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19||(LA11_0>=29 && LA11_0<=30)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:844:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:844:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:845:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1770);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:869:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:870:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:871:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1807);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart1817); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:878:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:881:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:882:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:882:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:882:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:882:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:883:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:883:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:884:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1863);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:900:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:901:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:901:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:902:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1884);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:926:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:927:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:928:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1921);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator1932); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:935:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:938:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:939:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:939:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt12=1;
                }
                break;
            case 29:
                {
                alt12=2;
                }
                break;
            case 30:
                {
                alt12=3;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:940:2: kw= '=='
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleEqualityOperator1970); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:947:2: kw= '<>'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleEqualityOperator1989); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:954:2: kw= '!='
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleEqualityOperator2008); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:967:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:968:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:969:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2048);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression2058); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:976:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:979:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:980:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:980:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:980:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:980:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:981:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:981:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:982:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression2104);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=20 && LA13_0<=23)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:999:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:999:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1000:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression2125);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1024:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1025:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1026:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart2162);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart2172); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1033:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1036:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1037:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1037:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1037:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1037:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1038:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1038:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1039:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart2218);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1056:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1056:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1057:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart2239);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1081:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1082:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1083:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator2276);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator2287); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1090:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1093:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1094:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1094:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt14=1;
                }
                break;
            case 21:
                {
                alt14=2;
                }
                break;
            case 22:
                {
                alt14=3;
                }
                break;
            case 23:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1095:2: kw= '>'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleRelationalOperator2325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1102:2: kw= '<'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleRelationalOperator2344); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1109:2: kw= '>='
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleRelationalOperator2363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1116:2: kw= '<='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleRelationalOperator2382); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1129:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1130:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1131:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2422);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression2432); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1138:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1141:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1142:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1142:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1142:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1142:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1143:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1143:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1144:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2478);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1160:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=31 && LA15_0<=32)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1161:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1161:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1162:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2499);
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
            	    break loop15;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1186:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1187:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1188:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2536);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2546); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1195:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1198:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1199:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1199:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1199:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1199:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1200:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1200:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1201:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2592);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1217:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1218:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1218:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1219:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2613);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1243:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1244:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1245:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2650);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator2661); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1252:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1255:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1256:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1256:1: (kw= '+' | kw= '-' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==31) ) {
                alt16=1;
            }
            else if ( (LA16_0==32) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1257:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleAdditiveOperator2699); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1264:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleAdditiveOperator2718); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1277:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1278:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1279:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2758);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2768); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1286:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1289:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1290:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1290:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1290:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1290:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1291:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1291:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1292:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2814);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1308:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=33 && LA17_0<=34)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1309:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1309:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1310:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2835);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1334:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1335:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1336:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2872);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2882); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1343:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1346:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1347:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1347:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1347:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1347:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1348:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1348:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1349:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2928);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1365:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1366:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1366:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1367:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2949);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1391:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1392:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1393:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2986);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator2997); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1400:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1403:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1404:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1404:1: (kw= '*' | kw= '/' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==33) ) {
                alt18=1;
            }
            else if ( (LA18_0==34) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1405:2: kw= '*'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleMultiplicativeOperator3035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1412:2: kw= '/'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleMultiplicativeOperator3054); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1425:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1426:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1427:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression3094);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression3104); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1434:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1437:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1438:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1438:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1438:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1438:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32||(LA19_0>=35 && LA19_0<=36)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1439:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1439:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1440:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression3150);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1456:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1457:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1457:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1458:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression3172);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1482:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1483:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1484:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3209);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator3220); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1491:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1494:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1495:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1495:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt20=1;
                }
                break;
            case 36:
                {
                alt20=2;
                }
                break;
            case 32:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1496:2: kw= 'not'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleUnaryOperator3258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1503:2: kw= '!'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleUnaryOperator3277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1510:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleUnaryOperator3296); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1523:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1524:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1525:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression3336);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression3346); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1532:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1535:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1536:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1536:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1537:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1537:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1538:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3391);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1562:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1563:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1564:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3426);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3436); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1571:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1574:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1575:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1575:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt21=4;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1575:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1575:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1576:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1576:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1577:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3482);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1594:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1594:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1595:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1595:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1596:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3509);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1613:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1613:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1614:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1614:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1615:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3536);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1632:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1632:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1633:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1633:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1634:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3563);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1658:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1659:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1660:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3599);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3609); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1667:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1670:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_VERSION && LA22_0<=RULE_EXPONENT)||(LA22_0>=46 && LA22_0<=48)) ) {
                alt22=1;
            }
            else if ( (LA22_0==14) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1671:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1672:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1672:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1673:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3656);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1690:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1690:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1690:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution3675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1694:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1695:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1695:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1696:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3696);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution3708); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1716:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==38||(LA23_0>=40 && LA23_0<=41)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1717:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1717:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1718:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3731);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1742:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1743:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1744:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3768);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution3778); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1751:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1754:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1755:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1755:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1755:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1755:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1756:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1756:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1757:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution3824);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1773:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==38||(LA24_0>=40 && LA24_0<=41)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1774:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1774:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1775:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3845);
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
            	    break loop24;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1799:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1800:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1801:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3882);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution3892); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1808:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1811:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1812:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1812:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1812:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleSuperExecution3929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleSuperExecution3941); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1821:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1821:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1822:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution3962);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1838:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38||(LA25_0>=40 && LA25_0<=41)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1839:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1839:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1840:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution3983);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1864:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1865:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1866:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution4020);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution4030); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1873:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1876:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1877:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1877:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1877:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleConstructorExecution4067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1881:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1882:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1882:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1883:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution4088);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution4100); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1903:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_VERSION && LA26_0<=RULE_EXPONENT)||LA26_0==14||LA26_0==32||(LA26_0>=35 && LA26_0<=37)||LA26_0==39||(LA26_0>=46 && LA26_0<=48)||LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1904:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1904:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1905:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution4121);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution4134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1925:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==38||(LA27_0>=40 && LA27_0<=41)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1926:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1926:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1927:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution4155);
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
            	    break loop27;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1951:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1952:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1953:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall4192);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall4202); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1960:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1963:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==38||LA29_0==40) ) {
                alt29=1;
            }
            else if ( (LA29_0==41) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1964:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1965:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1965:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1966:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1966:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==38) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==40) ) {
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1967:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,38,FOLLOW_38_in_ruleSubCall4248); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1979:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,40,FOLLOW_40_in_ruleSubCall4277); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1994:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1995:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1995:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1996:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall4314);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2013:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2013:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2013:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_41_in_ruleSubCall4334); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2017:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2018:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2018:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2019:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall4355);
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

                    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleSubCall4367); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2047:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2048:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2049:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator4404);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator4414); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2056:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2059:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2061:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2061:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2062:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4460);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2078:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==24) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2078:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleDeclarator4473); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2082:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2083:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2083:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2084:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4494);
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
            	    break loop30;
                }
            } while (true);

            otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleDeclarator4508); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2112:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2113:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2114:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration4544);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration4554); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2121:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2124:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2125:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2125:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2125:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2125:2: ( (lv_type_0_0= ruleType ) )?
            int alt31=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==RULE_VERSION||(LA31_1>=RULE_ID && LA31_1<=RULE_EXPONENT)||LA31_1==45) ) {
                        alt31=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==RULE_VERSION||(LA31_2>=RULE_ID && LA31_2<=RULE_EXPONENT)||LA31_2==45) ) {
                        alt31=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (LA31_3==RULE_VERSION||(LA31_3>=RULE_ID && LA31_3<=RULE_EXPONENT)||LA31_3==45) ) {
                        alt31=1;
                    }
                    }
                    break;
                case 49:
                case 50:
                case 51:
                    {
                    alt31=1;
                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2126:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2126:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2127:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration4600);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2143:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2145:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration4622);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2161:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==17) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2161:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleDeclaration4635); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2165:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2166:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2166:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2167:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration4656);
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
            	    break loop32;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2191:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2192:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2193:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall4694);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall4704); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2200:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2203:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2205:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2205:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2206:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall4750);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall4762); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2226:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2227:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2227:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2228:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall4783);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2244:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_VERSION && LA34_0<=RULE_EXPONENT)||LA34_0==14||LA34_0==32||(LA34_0>=35 && LA34_0<=37)||LA34_0==39||(LA34_0>=46 && LA34_0<=48)||LA34_0==52) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2245:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2245:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2246:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall4805);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall4818); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2274:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2275:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2276:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList4854);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList4864); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2283:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2286:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2287:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2287:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2287:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2287:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2288:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2288:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2289:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4910);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2305:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==17) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2305:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleArgumentList4923); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2309:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2310:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2310:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2311:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4944);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2335:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2336:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2337:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4982);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument4992); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2344:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2347:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt36=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==44) ) {
                        alt36=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (LA36_2==44) ) {
                        alt36=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (LA36_3==44) ) {
                        alt36=1;
                    }
                    }
                    break;
            }

            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2348:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2349:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2349:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2350:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument5039);
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

                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleNamedArgument5051); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2370:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2371:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2371:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2372:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument5074);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2396:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2397:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2398:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix5110);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix5120); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2405:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2408:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2409:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2409:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2409:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2409:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2410:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2410:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2411:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix5166);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2427:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==45) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2427:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2427:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2428:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2428:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2429:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,45,FOLLOW_45_in_ruleQualifiedPrefix5185); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2442:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2443:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2443:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2444:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix5219);
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
            	    break loop37;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2468:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2469:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2470:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5257);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName5267); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2477:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2480:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2481:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2481:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2481:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2481:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2482:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2482:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2483:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName5313);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2499:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==38) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA38_3 = input.LA(3);

                        if ( (LA38_3==EOF||LA38_3==15||LA38_3==17||(LA38_3>=19 && LA38_3<=23)||(LA38_3>=26 && LA38_3<=34)||LA38_3==38||(LA38_3>=40 && LA38_3<=42)||LA38_3==53) ) {
                            alt38=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA38_4 = input.LA(3);

                        if ( (LA38_4==EOF||LA38_4==15||LA38_4==17||(LA38_4>=19 && LA38_4<=23)||(LA38_4>=26 && LA38_4<=34)||LA38_4==38||(LA38_4>=40 && LA38_4<=42)||LA38_4==53) ) {
                            alt38=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA38_5 = input.LA(3);

                        if ( (LA38_5==EOF||LA38_5==15||LA38_5==17||(LA38_5>=19 && LA38_5<=23)||(LA38_5>=26 && LA38_5<=34)||LA38_5==38||(LA38_5>=40 && LA38_5<=42)||LA38_5==53) ) {
                            alt38=1;
                        }
                        }
                        break;
                }

            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2499:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2499:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2500:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2500:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2501:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedName5332); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2514:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2515:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2515:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2516:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName5366);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2540:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2541:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2542:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant5404);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant5414); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2549:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_sValue_1_0=null;
        Token lv_bValue_3_1=null;
        Token lv_bValue_3_2=null;
        Token lv_null_4_0=null;
        EObject lv_nValue_0_0 = null;

        EObject lv_qValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2552:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2553:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2553:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            int alt40=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt40=1;
                }
                break;
            case RULE_STRING:
                {
                alt40=2;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt40=3;
                }
                break;
            case 46:
            case 47:
                {
                alt40=4;
                }
                break;
            case 48:
                {
                alt40=5;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2553:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2553:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2554:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2554:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2555:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant5460);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2572:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2572:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2573:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2573:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2574:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant5483); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2591:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2591:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2592:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2592:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2593:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant5515);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2610:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2610:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2611:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2611:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2612:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2612:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==46) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==47) ) {
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2613:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,46,FOLLOW_46_in_ruleConstant5541); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2625:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,47,FOLLOW_47_in_ruleConstant5570); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2641:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2641:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2642:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2642:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2643:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,48,FOLLOW_48_in_ruleConstant5610); if (state.failed) return current;
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

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2664:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2665:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2666:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue5659);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue5669); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2673:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2676:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2677:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2677:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2678:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2678:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2679:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue5710); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2703:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2704:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2705:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier5751);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier5762); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2712:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2715:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2716:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2716:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            int alt41=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt41=1;
                }
                break;
            case RULE_VERSION:
                {
                alt41=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2716:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier5802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2724:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier5828); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2732:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier5854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2747:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2748:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2749:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType5899);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType5909); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2756:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2759:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2760:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2760:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt42=1;
                }
                break;
            case 49:
                {
                alt42=2;
                }
                break;
            case 50:
                {
                alt42=3;
                }
                break;
            case 51:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2760:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2760:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2762:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType5955);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2779:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2779:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2779:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2779:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2780:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2780:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2781:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,49,FOLLOW_49_in_ruleType5980); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2794:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2796:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType6014);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2813:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2814:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2814:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2815:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,50,FOLLOW_50_in_ruleType6040); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2828:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2830:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType6074);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2847:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2847:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2847:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2847:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2848:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2848:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2849:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,51,FOLLOW_51_in_ruleType6100); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2862:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2863:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2863:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2864:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType6134);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2888:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2889:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2890:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters6171);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters6181); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2897:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_param_1_0 = null;

        AntlrDatatypeRuleToken lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2900:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:3: otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters6218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2905:1: ( (lv_param_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2906:1: (lv_param_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2906:1: (lv_param_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2907:3: lv_param_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters6239);
            lv_param_1_0=ruleIdentifier();

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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2923:2: (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==17) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2923:4: otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeParameters6252); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2927:1: ( (lv_param_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2928:1: (lv_param_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2928:1: (lv_param_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2929:3: lv_param_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters6273);
            	    lv_param_3_0=ruleIdentifier();

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
            	              		"Identifier");
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters6287); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2957:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2958:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2959:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6323);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer6333); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2966:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2969:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2970:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2970:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2970:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2970:2: ()
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2971:2: 
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

            otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleContainerInitializer6382); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2983:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_VERSION && LA45_0<=RULE_EXPONENT)||LA45_0==14||LA45_0==32||(LA45_0>=35 && LA45_0<=37)||LA45_0==39||(LA45_0>=46 && LA45_0<=48)||LA45_0==52) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2983:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2983:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2984:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2984:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2985:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6404);
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3001:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==17) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3001:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleContainerInitializer6417); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3005:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3006:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3006:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3007:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6438);
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
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,53,FOLLOW_53_in_ruleContainerInitializer6454); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3035:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3036:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3037:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6490);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression6500); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3044:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3047:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3048:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3048:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_VERSION && LA46_0<=RULE_EXPONENT)||LA46_0==14||LA46_0==32||(LA46_0>=35 && LA46_0<=37)||LA46_0==39||(LA46_0>=46 && LA46_0<=48)) ) {
                alt46=1;
            }
            else if ( (LA46_0==52) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3048:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3048:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3049:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3049:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3050:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6546);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3067:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3067:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3068:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3068:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3069:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6573);
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

    // Delegated rules


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA21_eotS =
        "\14\uffff";
    static final String DFA21_eofS =
        "\2\uffff\3\1\4\uffff\3\1";
    static final String DFA21_minS =
        "\1\4\1\uffff\3\16\2\uffff\1\4\1\uffff\3\16";
    static final String DFA21_maxS =
        "\1\60\1\uffff\3\65\2\uffff\1\10\1\uffff\3\65";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\4\1\uffff\1\2\3\uffff";
    static final String DFA21_specialS =
        "\14\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\2\1\1\2\1\4\5\uffff\1\1\26\uffff\1\5\1\uffff\1\6\6\uffff"+
            "\3\1",
            "",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1",
            "",
            "",
            "\1\12\2\uffff\1\11\1\13",
            "",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1",
            "\1\10\1\1\1\uffff\1\1\1\uffff\5\1\2\uffff\11\1\3\uffff\1\1"+
            "\1\uffff\3\1\2\uffff\1\7\7\uffff\1\1"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1575:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA33_eotS =
        "\16\uffff";
    static final String DFA33_eofS =
        "\16\uffff";
    static final String DFA33_minS =
        "\4\4\2\uffff\5\4\3\16";
    static final String DFA33_maxS =
        "\1\64\3\55\2\uffff\1\10\1\64\6\55";
    static final String DFA33_acceptS =
        "\4\uffff\1\1\1\2\10\uffff";
    static final String DFA33_specialS =
        "\16\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\2\5\1\1\1\3\5\uffff\2\5\20\uffff\1\5\2\uffff\3\5\1\uffff"+
            "\1\5\6\uffff\3\5\3\4\1\5",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1"+
            "\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5\1\6",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1"+
            "\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5\1\6",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1"+
            "\uffff\11\5\3\uffff\1\5\1\uffff\2\5\1\uffff\1\4\1\5\1\6",
            "",
            "",
            "\1\11\2\uffff\1\10\1\12",
            "\1\14\2\5\1\13\1\15\5\uffff\1\5\21\uffff\1\5\2\uffff\3\5\1"+
            "\uffff\1\5\6\uffff\3\5\3\uffff\1\5",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\5\1\uffff\5\5\2\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\3\uffff\1\6",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\5\1\uffff\5\5\2\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\3\uffff\1\6",
            "\1\4\2\uffff\2\4\5\uffff\2\5\1\uffff\1\5\1\uffff\5\5\2\uffff"+
            "\11\5\3\uffff\1\5\1\uffff\2\5\3\uffff\1\6",
            "\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1\uffff\11\5\3\uffff\1\5"+
            "\1\uffff\2\5\1\uffff\1\4\2\5",
            "\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1\uffff\11\5\3\uffff\1\5"+
            "\1\uffff\2\5\1\uffff\1\4\2\5",
            "\2\5\1\uffff\1\7\1\uffff\5\5\1\4\1\uffff\11\5\3\uffff\1\5"+
            "\1\uffff\2\5\1\uffff\1\4\2\5"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "2226:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000000000002190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit159 = new BitSet(new long[]{0x0000000002040002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit180 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit202 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAdvice288 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice300 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice321 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice333 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVersionSpec438 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionSpec450 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec471 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_ruleVersionSpec484 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec505 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_ruleVersionSpec519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVersionedId602 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_ruleVersionedId623 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionedId640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleVersionOperator731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleVersionOperator750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleVersionOperator769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVersionOperator788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVersionOperator807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter905 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleVersionStmt1009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt1026 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleVersionStmt1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleImport1126 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport1147 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport1168 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleImport1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression1338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1394 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1415 = new BitSet(new long[]{0x000000001C000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1508 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleLogicalOperator1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleLogicalOperator1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleLogicalOperator1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1749 = new BitSet(new long[]{0x0000000060080002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1863 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleEqualityOperator1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEqualityOperator1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleEqualityOperator2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression2048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression2104 = new BitSet(new long[]{0x0000000000F00002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart2218 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator2276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRelationalOperator2325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleRelationalOperator2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleRelationalOperator2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRelationalOperator2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2478 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2499 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2592 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAdditiveOperator2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAdditiveOperator2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2814 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2928 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeOperator3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleMultiplicativeOperator3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression3094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression3104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression3150 = new BitSet(new long[]{0x0001C0B9000041F0L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryOperator3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryOperator3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryOperator3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression3336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3656 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution3675 = new BitSet(new long[]{0x0011C0B9000041F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3696 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution3708 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3731 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution3824 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3845 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSuperExecution3929 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSuperExecution3941 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution3962 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution3983 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution4020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution4030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleConstructorExecution4067 = new BitSet(new long[]{0x000E000000000190L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution4088 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution4100 = new BitSet(new long[]{0x0011C0B90000C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution4121 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution4134 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution4155 = new BitSet(new long[]{0x0000034000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall4192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall4202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSubCall4248 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_40_in_ruleSubCall4277 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall4314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleSubCall4334 = new BitSet(new long[]{0x0011C0B9000041F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall4355 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleSubCall4367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator4404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4460 = new BitSet(new long[]{0x0000080001000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclarator4473 = new BitSet(new long[]{0x000E000000000190L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4494 = new BitSet(new long[]{0x0000080001000000L});
    public static final BitSet FOLLOW_43_in_ruleDeclarator4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration4544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration4600 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration4622 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleDeclaration4635 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration4656 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall4694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall4750 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall4762 = new BitSet(new long[]{0x001FC0B90000C1F0L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall4783 = new BitSet(new long[]{0x0011C0B90000C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall4805 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList4854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4910 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleArgumentList4923 = new BitSet(new long[]{0x0011C0B9000041F0L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4944 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument5039 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleNamedArgument5051 = new BitSet(new long[]{0x0011C0B9000041F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument5074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix5110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix5166 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleQualifiedPrefix5185 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix5219 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName5267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName5313 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName5332 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant5404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant5414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant5460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant5483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleConstant5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleConstant5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConstant5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue5659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier5751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier5802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier5828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType5899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleType5980 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleType6040 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleType6100 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType6134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters6171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters6181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters6218 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters6239 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_17_in_ruleTypeParameters6252 = new BitSet(new long[]{0x0000000000000190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters6273 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters6287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6323 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer6333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleContainerInitializer6382 = new BitSet(new long[]{0x0031C0B9000041F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6404 = new BitSet(new long[]{0x0020000000020000L});
    public static final BitSet FOLLOW_17_in_ruleContainerInitializer6417 = new BitSet(new long[]{0x0011C0B9000041F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6438 = new BitSet(new long[]{0x0020000000020000L});
    public static final BitSet FOLLOW_53_in_ruleContainerInitializer6454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6573 = new BitSet(new long[]{0x0000000000000002L});

}