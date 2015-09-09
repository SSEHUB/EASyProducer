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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VERSION", "RULE_STRING", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'@advice'", "'('", "')'", "'with'", "'version'", "';'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'.'", "'new'", "'->'", "'['", "']'", "'|'", "','", "'='", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'", "'{'", "'}'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=4;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:170:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:171:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:172:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice243);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice253); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:179:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:182:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:183:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:183:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:183:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleAdvice290); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAdvice302); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:191:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:192:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:192:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:193:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice323);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAdvice335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:213:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:214:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:214:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:215:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice356);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:239:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:240:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:241:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec393);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec403); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:248:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:251:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:252:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:252:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:252:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVersionSpec440); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:256:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:257:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:257:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:258:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec461);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:284:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:285:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:286:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter499);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter509); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:293:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:296:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:297:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:297:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:297:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:297:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:298:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:298:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:299:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter555);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:315:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:316:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:316:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:317:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter576);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:341:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:342:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:343:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt612);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt622); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:350:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:353:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:354:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:354:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:354:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleVersionStmt659); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:358:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:359:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:359:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:360:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt676); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVersionStmt693); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:388:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:389:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:390:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport729);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport739); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:397:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:400:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:401:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:401:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:401:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleImport776); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:405:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:406:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:406:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:407:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport797);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:423:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:424:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:424:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:425:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport818);
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

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleImport831); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:455:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:456:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:457:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression869);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression879); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:464:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:467:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:468:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:468:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_VERSION && LA6_0<=RULE_EXPONENT)||LA6_0==14||LA6_0==17||LA6_0==31||(LA6_0>=34 && LA6_0<=36)||LA6_0==38||(LA6_0>=46 && LA6_0<=48)) ) {
                alt6=1;
            }
            else if ( (LA6_0==53) ) {
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:468:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:468:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:469:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:469:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:470:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression925);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:487:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:487:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:488:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:488:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:489:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression952);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:513:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:514:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:515:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression988);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression998); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:522:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:525:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:526:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:526:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:526:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:526:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:527:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:527:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:528:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1044);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:544:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=20 && LA7_0<=22)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:545:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:545:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:546:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1065);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:570:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:571:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:572:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1102);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart1112); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:579:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:582:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:583:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:583:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:583:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:583:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:584:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:584:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:585:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1158);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:601:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:602:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:602:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:603:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1179);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:627:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:628:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:629:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1216);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator1227); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:636:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:639:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:640:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:640:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:641:2: kw= 'and'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleLogicalOperator1265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:648:2: kw= 'or'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleLogicalOperator1284); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:655:2: kw= 'xor'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleLogicalOperator1303); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:668:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:669:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:670:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1343);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression1353); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:677:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:680:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:681:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:681:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:681:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:681:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:682:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:682:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:683:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1399);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:699:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=23 && LA9_0<=25)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:700:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:700:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:701:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1420);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:725:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:726:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:727:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1457);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart1467); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:734:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:737:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:738:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:738:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:738:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:738:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:739:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:739:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:740:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1513);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:756:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:757:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:757:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:758:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1534);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:782:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:783:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:784:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1571);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator1582); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:791:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:794:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:795:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:795:1: (kw= '==' | kw= '<>' | kw= '!=' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:796:2: kw= '=='
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleEqualityOperator1620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:803:2: kw= '<>'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleEqualityOperator1639); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:810:2: kw= '!='
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleEqualityOperator1658); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:823:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:824:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:825:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1698);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression1708); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:832:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:835:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:836:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:836:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:836:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:836:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:837:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:837:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:838:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1754);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:854:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=26 && LA11_0<=29)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:855:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:855:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:856:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression1775);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:880:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:881:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:882:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1812);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart1822); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:889:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:892:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:893:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:893:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:893:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:893:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:894:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:894:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:895:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart1868);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:911:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:912:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:912:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:913:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart1889);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:937:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:938:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:939:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1926);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator1937); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:946:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:949:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:950:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:950:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:951:2: kw= '>'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleRelationalOperator1975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:958:2: kw= '<'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleRelationalOperator1994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:965:2: kw= '>='
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleRelationalOperator2013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:972:2: kw= '<='
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleRelationalOperator2032); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:985:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:986:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:987:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2072);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression2082); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:994:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:997:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:998:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:999:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:999:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1000:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2128);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1016:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=30 && LA13_0<=31)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1017:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1017:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1018:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2149);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1042:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1043:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1044:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2186);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2196); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1051:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1054:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1055:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1056:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1056:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1057:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2242);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1073:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1074:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1074:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1075:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2263);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1099:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1100:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1101:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2300);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator2311); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1108:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1111:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1112:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1112:1: (kw= '+' | kw= '-' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1113:2: kw= '+'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleAdditiveOperator2349); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1120:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleAdditiveOperator2368); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1133:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1134:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1135:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2408);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression2418); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1142:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1145:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1146:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1146:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1146:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1146:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1147:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1147:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1148:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2464);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1164:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=32 && LA15_0<=33)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1165:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1165:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1166:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2485);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1190:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1191:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1192:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2522);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2532); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1199:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1202:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1203:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1203:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1203:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1203:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1204:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1204:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1205:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2578);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1221:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1222:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1222:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1223:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2599);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1247:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1248:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1249:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2636);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator2647); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1256:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1259:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1260:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1260:1: (kw= '*' | kw= '/' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1261:2: kw= '*'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleMultiplicativeOperator2685); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1268:2: kw= '/'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleMultiplicativeOperator2704); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1281:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1282:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1283:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2744);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression2754); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1290:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1293:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1294:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1294:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1294:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1294:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31||(LA17_0>=34 && LA17_0<=35)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1295:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1295:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1296:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression2800);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1312:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1313:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1313:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1314:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression2822);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1338:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1339:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1340:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2859);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator2870); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1347:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1350:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1351:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1351:1: (kw= 'not' | kw= '!' | kw= '-' )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1352:2: kw= 'not'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleUnaryOperator2908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1359:2: kw= '!'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleUnaryOperator2927); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1366:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleUnaryOperator2946); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1379:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1380:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1381:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression2986);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression2996); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1388:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1391:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1392:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1392:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1393:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1393:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1394:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3041);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1418:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1419:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1420:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3076);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3086); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1427:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1430:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1431:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1431:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt19=4;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1431:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1431:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1432:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1432:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1433:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3132);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1450:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1450:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1451:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1451:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1452:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3159);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1469:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1469:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1470:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1470:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1471:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3186);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1488:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1488:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1489:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1489:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1490:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3213);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1514:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1515:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1516:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3249);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3259); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1523:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1526:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1527:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1528:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1528:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1529:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3306);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1546:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1546:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1546:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution3325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1550:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1551:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1551:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1552:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3346);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution3358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1572:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==37||(LA21_0>=39 && LA21_0<=40)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1573:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1573:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1574:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3381);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1598:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1599:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1600:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3418);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution3428); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1607:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1610:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1611:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1611:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1611:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1611:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1612:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1612:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1613:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution3474);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1629:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==37||(LA22_0>=39 && LA22_0<=40)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1630:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1630:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1631:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3495);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1655:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1656:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1657:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3532);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution3542); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1664:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1667:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1668:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1668:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1668:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleSuperExecution3579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSuperExecution3591); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1676:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1677:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1677:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1678:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution3612);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1694:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==37||(LA23_0>=39 && LA23_0<=40)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1695:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1695:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1696:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution3633);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1720:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1721:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1722:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution3670);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution3680); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1729:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1732:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1733:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1733:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1733:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleConstructorExecution3717); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1737:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1738:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1738:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1739:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution3738);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution3750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1759:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_VERSION && LA24_0<=RULE_EXPONENT)||LA24_0==14||LA24_0==17||LA24_0==31||(LA24_0>=34 && LA24_0<=36)||LA24_0==38||(LA24_0>=46 && LA24_0<=48)||LA24_0==53) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1760:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1760:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1761:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution3771);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution3784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1781:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37||(LA25_0>=39 && LA25_0<=40)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1782:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1782:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1783:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution3805);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1807:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1808:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1809:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall3842);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall3852); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1816:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1819:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1820:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1821:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1821:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1822:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1822:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1823:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,37,FOLLOW_37_in_ruleSubCall3898); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1835:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,39,FOLLOW_39_in_ruleSubCall3927); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1850:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1851:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1851:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1852:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall3964);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1869:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1869:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1869:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleSubCall3984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1873:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1874:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1874:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1875:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall4005);
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

                    otherlv_4=(Token)match(input,41,FOLLOW_41_in_ruleSubCall4017); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1903:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1904:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1905:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator4054);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator4064); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1912:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1915:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1916:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1916:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1916:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1916:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1917:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1917:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1918:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4110);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1934:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==18) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1934:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleDeclarator4123); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1938:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1939:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1939:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1940:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator4144);
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

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleDeclarator4158); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1968:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1969:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1970:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration4194);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration4204); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1977:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1980:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1981:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1981:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1981:2: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1981:2: ( (lv_type_0_0= ruleType ) )?
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
                case 52:
                    {
                    alt29=1;
                    }
                    break;
            }

            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1982:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1982:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1983:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration4250);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:1999:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2000:1: (lv_units_1_0= ruleDeclarationUnit )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2000:1: (lv_units_1_0= ruleDeclarationUnit )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2001:3: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration4272);
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
                      		"DeclarationUnit");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2017:2: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==43) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2017:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleDeclaration4285); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2021:1: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2022:1: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2022:1: (lv_units_3_0= ruleDeclarationUnit )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2023:3: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration4306);
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
            	              		"DeclarationUnit");
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


    // $ANTLR start "entryRuleDeclarationUnit"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2047:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2048:2: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2049:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationUnitRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit4344);
            iv_ruleDeclarationUnit=ruleDeclarationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarationUnit4354); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2056:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2059:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2060:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2061:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2061:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2062:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclarationUnit4400);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2078:2: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2078:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleDeclarationUnit4413); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2082:1: ( (lv_deflt_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2083:1: (lv_deflt_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2083:1: (lv_deflt_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2084:3: lv_deflt_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getDefltExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclarationUnit4434);
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
                              		"Expression");
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2108:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2109:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2110:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall4472);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall4482); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2117:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2120:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2121:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2121:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2121:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2121:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2122:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2122:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2123:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall4528);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall4540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2143:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2145:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall4561);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2161:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_VERSION && LA33_0<=RULE_EXPONENT)||LA33_0==14||LA33_0==17||LA33_0==31||(LA33_0>=34 && LA33_0<=36)||LA33_0==38||(LA33_0>=46 && LA33_0<=48)||LA33_0==53) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2162:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2162:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2163:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall4583);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall4596); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2191:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2192:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2193:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList4632);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList4642); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2200:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2203:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2204:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2205:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2205:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2206:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4688);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2222:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==43) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2222:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleArgumentList4701); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2226:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2227:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2227:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2228:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList4722);
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
            	    break loop34;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2252:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2253:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2254:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4760);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument4770); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2261:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2264:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt35=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA35_1 = input.LA(2);

                    if ( (LA35_1==44) ) {
                        alt35=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==44) ) {
                        alt35=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (LA35_3==44) ) {
                        alt35=1;
                    }
                    }
                    break;
                case 17:
                    {
                    int LA35_4 = input.LA(2);

                    if ( (LA35_4==44) ) {
                        alt35=1;
                    }
                    }
                    break;
            }

            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2265:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2266:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2266:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2267:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument4817);
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

                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleNamedArgument4829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2287:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2288:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2288:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2289:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument4852);
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2313:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2314:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2315:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix4888);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix4898); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2322:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2325:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2326:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2326:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2326:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2326:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2327:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2327:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2328:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4944);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2344:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==45) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2344:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2344:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2345:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2345:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2346:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,45,FOLLOW_45_in_ruleQualifiedPrefix4963); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2359:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2360:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2360:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2361:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4997);
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
            	    break loop36;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2385:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2386:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2387:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5035);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName5045); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2394:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2397:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2398:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2398:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2398:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2398:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2399:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2399:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2400:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName5091);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2416:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA37_3 = input.LA(3);

                        if ( (LA37_3==EOF||LA37_3==RULE_VERSION||(LA37_3>=RULE_ID && LA37_3<=RULE_EXPONENT)||LA37_3==13||LA37_3==15||(LA37_3>=17 && LA37_3<=18)||(LA37_3>=20 && LA37_3<=33)||LA37_3==37||(LA37_3>=39 && LA37_3<=43)||LA37_3==54) ) {
                            alt37=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA37_4 = input.LA(3);

                        if ( (LA37_4==EOF||LA37_4==RULE_VERSION||(LA37_4>=RULE_ID && LA37_4<=RULE_EXPONENT)||LA37_4==13||LA37_4==15||(LA37_4>=17 && LA37_4<=18)||(LA37_4>=20 && LA37_4<=33)||LA37_4==37||(LA37_4>=39 && LA37_4<=43)||LA37_4==54) ) {
                            alt37=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA37_5 = input.LA(3);

                        if ( (LA37_5==EOF||LA37_5==RULE_VERSION||(LA37_5>=RULE_ID && LA37_5<=RULE_EXPONENT)||LA37_5==13||LA37_5==15||(LA37_5>=17 && LA37_5<=18)||(LA37_5>=20 && LA37_5<=33)||LA37_5==37||(LA37_5>=39 && LA37_5<=43)||LA37_5==54) ) {
                            alt37=1;
                        }


                        }
                        break;
                    case 17:
                        {
                        int LA37_6 = input.LA(3);

                        if ( (LA37_6==EOF||LA37_6==RULE_VERSION||(LA37_6>=RULE_ID && LA37_6<=RULE_EXPONENT)||LA37_6==13||LA37_6==15||(LA37_6>=17 && LA37_6<=18)||(LA37_6>=20 && LA37_6<=33)||LA37_6==37||(LA37_6>=39 && LA37_6<=43)||LA37_6==54) ) {
                            alt37=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2416:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2416:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2417:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2417:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2418:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName5110); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2431:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2432:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2432:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2433:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName5144);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2457:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2458:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2459:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant5182);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant5192); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2466:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2469:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2470:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2470:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt39=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt39=1;
                }
                break;
            case RULE_STRING:
                {
                alt39=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 17:
                {
                alt39=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA39_4 = input.LA(2);

                if ( (synpred47_InternalExpressionDsl()) ) {
                    alt39=3;
                }
                else if ( (synpred51_InternalExpressionDsl()) ) {
                    alt39=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 4, input);

                    throw nvae;
                }
                }
                break;
            case 46:
            case 47:
                {
                alt39=4;
                }
                break;
            case 48:
                {
                alt39=5;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2470:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2470:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2471:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2471:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2472:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant5238);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2489:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2489:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2490:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2490:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2491:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant5261); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2508:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2508:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2509:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2509:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2510:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant5293);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2527:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2527:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2528:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2528:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2529:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2529:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==46) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==47) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2530:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,46,FOLLOW_46_in_ruleConstant5319); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2542:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,47,FOLLOW_47_in_ruleConstant5348); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2558:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2558:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2559:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2559:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2560:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,48,FOLLOW_48_in_ruleConstant5388); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2574:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2574:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2574:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2580:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2581:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant5435); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2605:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2606:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2607:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue5476);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue5486); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2614:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2617:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2618:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2618:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2619:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2619:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2620:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue5527); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2644:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2645:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2646:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier5568);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier5579); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2653:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2656:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2657:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2657:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt40=1;
                }
                break;
            case RULE_VERSION:
                {
                alt40=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt40=3;
                }
                break;
            case 17:
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2657:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier5619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2665:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier5645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2673:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier5671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2682:2: kw= 'version'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleIdentifier5695); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2695:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2696:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2697:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType5735);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType5745); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2704:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2707:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2708:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2708:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt42=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 17:
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
            case 52:
                {
                alt42=5;
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2708:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2708:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2709:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2709:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2710:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType5791);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2727:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2727:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2727:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2727:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2728:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2728:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2729:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,49,FOLLOW_49_in_ruleType5816); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2742:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2743:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2743:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2744:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5850);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2761:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2762:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2762:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2763:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,50,FOLLOW_50_in_ruleType5876); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2776:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2777:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2777:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2778:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5910);
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
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2795:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2796:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2796:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2797:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,51,FOLLOW_51_in_ruleType5936); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2810:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2811:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2811:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2812:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType5970);
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
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2829:7: ( (lv_call_7_0= 'callOf' ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2830:1: (lv_call_7_0= 'callOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2830:1: (lv_call_7_0= 'callOf' )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2831:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,52,FOLLOW_52_in_ruleType5996); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2844:2: ( (lv_return_8_0= ruleType ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==RULE_VERSION||(LA41_0>=RULE_ID && LA41_0<=RULE_EXPONENT)||LA41_0==17||(LA41_0>=49 && LA41_0<=52)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2845:1: (lv_return_8_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2845:1: (lv_return_8_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2846:3: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleType6030);
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
                                      		"Type");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2862:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2863:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2863:1: (lv_param_9_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2864:3: lv_param_9_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType6052);
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
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters6089);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters6099); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2897:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2900:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2901:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters6136); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2905:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2906:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2906:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2907:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters6157);
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

            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2923:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==43) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2923:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleTypeParameters6170); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2927:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2928:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2928:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2929:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters6191);
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
            	    break loop43;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters6205); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6241);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer6251); if (state.failed) return current;

            }

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

            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleContainerInitializer6300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2983:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_VERSION && LA45_0<=RULE_EXPONENT)||LA45_0==14||LA45_0==17||LA45_0==31||(LA45_0>=34 && LA45_0<=36)||LA45_0==38||(LA45_0>=46 && LA45_0<=48)||LA45_0==53) ) {
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
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6322);
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

                        if ( (LA44_0==43) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:3001:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleContainerInitializer6335); if (state.failed) return current;
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
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6356);
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

            otherlv_5=(Token)match(input,54,FOLLOW_54_in_ruleContainerInitializer6372); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6408);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression6418); if (state.failed) return current;

            }

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

            if ( ((LA46_0>=RULE_VERSION && LA46_0<=RULE_EXPONENT)||LA46_0==14||LA46_0==17||LA46_0==31||(LA46_0>=34 && LA46_0<=36)||LA46_0==38||(LA46_0>=46 && LA46_0<=48)) ) {
                alt46=1;
            }
            else if ( (LA46_0==53) ) {
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
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6464);
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
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6491);
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

    // $ANTLR start synpred39_InternalExpressionDsl
    public final void synpred39_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_decl_2_0= ruleDeclarator )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2144:1: (lv_decl_2_0= ruleDeclarator )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2145:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDeclarator_in_synpred39_InternalExpressionDsl4561);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred39_InternalExpressionDsl

    // $ANTLR start synpred47_InternalExpressionDsl
    public final void synpred47_InternalExpressionDsl_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2508:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2508:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2508:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2509:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2509:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2510:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred47_InternalExpressionDsl5293);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred47_InternalExpressionDsl

    // $ANTLR start synpred51_InternalExpressionDsl
    public final void synpred51_InternalExpressionDsl_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2574:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2575:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2575:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.expressions/src-gen/de/uni_hildesheim/sse/vil/expressions/parser/antlr/internal/InternalExpressionDsl.g:2576:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred51_InternalExpressionDsl5421); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred51_InternalExpressionDsl

    // Delegated rules

    public final boolean synpred39_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_InternalExpressionDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalExpressionDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalExpressionDsl_fragment(); // can never throw exception
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
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA19_eotS =
        "\16\uffff";
    static final String DFA19_eofS =
        "\2\uffff\4\1\4\uffff\4\1";
    static final String DFA19_minS =
        "\1\4\1\uffff\4\4\2\uffff\1\4\1\uffff\4\4";
    static final String DFA19_maxS =
        "\1\60\1\uffff\4\66\2\uffff\1\21\1\uffff\4\66";
    static final String DFA19_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\uffff\1\2\4\uffff";
    static final String DFA19_specialS =
        "\16\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\3\2\1\1\2\1\4\5\uffff\1\1\2\uffff\1\5\22\uffff\1\6\1\uffff"+
            "\1\7\7\uffff\3\1",
            "",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "",
            "",
            "\1\13\2\uffff\1\12\1\14\10\uffff\1\15",
            "",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1",
            "\1\1\2\uffff\2\1\4\uffff\1\1\1\11\1\1\1\uffff\2\1\1\uffff"+
            "\16\1\3\uffff\1\1\1\uffff\5\1\1\uffff\1\10\10\uffff\1\1"
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
            return "1431:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA32_eotS =
        "\26\uffff";
    static final String DFA32_eofS =
        "\26\uffff";
    static final String DFA32_minS =
        "\1\4\4\0\21\uffff";
    static final String DFA32_maxS =
        "\1\65\4\0\21\uffff";
    static final String DFA32_acceptS =
        "\5\uffff\1\1\3\uffff\1\2\14\uffff";
    static final String DFA32_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\21\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\2\11\1\1\1\3\5\uffff\2\11\1\uffff\1\4\15\uffff\1\11\2"+
            "\uffff\3\11\1\uffff\1\11\7\uffff\3\11\4\5\1\11",
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
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "2143:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalExpressionDsl()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalExpressionDsl()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalExpressionDsl()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred39_InternalExpressionDsl()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index32_4);
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
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000000000022190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit159 = new BitSet(new long[]{0x00000000000A0002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit180 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit202 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAdvice290 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice302 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice323 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice335 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVersionSpec440 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter499 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter555 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVersionStmt659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt676 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleVersionStmt693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleImport776 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport797 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport818 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleImport831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression988 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression1044 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression1065 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart1102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart1158 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleLogicalOperator1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLogicalOperator1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLogicalOperator1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression1343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression1399 = new BitSet(new long[]{0x0000000003800002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart1457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart1513 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator1571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleEqualityOperator1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEqualityOperator1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleEqualityOperator1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression1698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression1754 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart1812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart1868 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator1926 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRelationalOperator1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleRelationalOperator1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleRelationalOperator2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleRelationalOperator2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression2072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression2128 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression2149 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart2186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart2242 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator2300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAdditiveOperator2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAdditiveOperator2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression2408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression2464 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart2522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart2578 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart2599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator2636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMultiplicativeOperator2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplicativeOperator2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression2744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression2800 = new BitSet(new long[]{0x0001C05C800241F0L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator2870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleUnaryOperator2908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryOperator2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnaryOperator2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression2986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution3249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution3306 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution3325 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution3346 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution3358 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution3381 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution3418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution3474 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution3495 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution3532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSuperExecution3579 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSuperExecution3591 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution3612 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution3633 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution3670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleConstructorExecution3717 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution3738 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution3750 = new BitSet(new long[]{0x0021C05C8002C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution3771 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution3784 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution3805 = new BitSet(new long[]{0x000001A000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall3842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSubCall3898 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_39_in_ruleSubCall3927 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleSubCall3984 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall4005 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleSubCall4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator4054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4110 = new BitSet(new long[]{0x0000040000040000L});
    public static final BitSet FOLLOW_18_in_ruleDeclarator4123 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator4144 = new BitSet(new long[]{0x0000040000040000L});
    public static final BitSet FOLLOW_42_in_ruleDeclarator4158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration4194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration4250 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration4272 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleDeclaration4285 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration4306 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit4344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarationUnit4354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclarationUnit4400 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleDeclarationUnit4413 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclarationUnit4434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall4472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall4528 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall4540 = new BitSet(new long[]{0x003FC05C8002C1F0L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall4561 = new BitSet(new long[]{0x0021C05C8002C1F0L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall4583 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList4632 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4688 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleArgumentList4701 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList4722 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument4760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument4817 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleNamedArgument4829 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument4852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix4888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4944 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleQualifiedPrefix4963 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix4997 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName5045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName5091 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName5110 = new BitSet(new long[]{0x0000000000020190L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName5144 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant5182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant5238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant5261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleConstant5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleConstant5348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConstant5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant5435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue5476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue5486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue5527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier5568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleIdentifier5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType5735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleType5816 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleType5876 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleType5936 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleType5996 = new BitSet(new long[]{0x001E000000024190L});
    public static final BitSet FOLLOW_ruleType_in_ruleType6030 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType6052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters6089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters6136 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters6157 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_43_in_ruleTypeParameters6170 = new BitSet(new long[]{0x001E000000020190L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters6191 = new BitSet(new long[]{0x0000080000008000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters6205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer6241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleContainerInitializer6300 = new BitSet(new long[]{0x0061C05C800241F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6322 = new BitSet(new long[]{0x0040080000000000L});
    public static final BitSet FOLLOW_43_in_ruleContainerInitializer6335 = new BitSet(new long[]{0x0021C05C800241F0L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer6356 = new BitSet(new long[]{0x0040080000000000L});
    public static final BitSet FOLLOW_54_in_ruleContainerInitializer6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression6408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression6418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression6464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression6491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_synpred39_InternalExpressionDsl4561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred47_InternalExpressionDsl5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred51_InternalExpressionDsl5421 = new BitSet(new long[]{0x0000000000000002L});

}