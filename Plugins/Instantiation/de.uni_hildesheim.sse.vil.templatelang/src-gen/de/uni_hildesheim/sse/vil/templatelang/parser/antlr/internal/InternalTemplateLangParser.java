package de.uni_hildesheim.sse.vil.templatelang.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.vil.templatelang.services.TemplateLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTemplateLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'template'", "'('", "')'", "'extends'", "'{'", "'}'", "'@indent'", "','", "'='", "'def'", "';'", "'if'", "'else'", "'print'", "'|'", "'switch'", "'default'", "':'", "'for'", "'multiSelect'", "'case'", "':='", "'generic-multiSelect'", "'extension'", "'.'", "'const'", "'@advice'", "'with'", "'version'", "'=='", "'>'", "'<'", "'>='", "'<='", "'import'", "'and'", "'or'", "'xor'", "'<>'", "'!='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=7;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int RULE_VERSION=6;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NUMBER=4;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
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
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int RULE_EXPONENT=8;
    public static final int T__39=39;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public InternalTemplateLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTemplateLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTemplateLangParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private TemplateLangGrammarAccess grammarAccess;
     	
        public InternalTemplateLangParser(TokenStream input, TemplateLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "LanguageUnit";	
       	}
       	
       	@Override
       	protected TemplateLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLanguageUnit"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:73:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:74:2: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:75:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:82:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_vars_13_0= ruleVariableDeclaration ) )* ( (lv_defs_14_0= ruleVilDef ) )* otherlv_15= '}' ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_15=null;
        EObject lv_imports_0_0 = null;

        EObject lv_javaExts_1_0 = null;

        EObject lv_advices_2_0 = null;

        EObject lv_indent_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_param_7_0 = null;

        AntlrDatatypeRuleToken lv_ext_10_0 = null;

        EObject lv_version_12_0 = null;

        EObject lv_vars_13_0 = null;

        EObject lv_defs_14_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:85:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_vars_13_0= ruleVariableDeclaration ) )* ( (lv_defs_14_0= ruleVilDef ) )* otherlv_15= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_vars_13_0= ruleVariableDeclaration ) )* ( (lv_defs_14_0= ruleVilDef ) )* otherlv_15= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_vars_13_0= ruleVariableDeclaration ) )* ( (lv_defs_14_0= ruleVilDef ) )* otherlv_15= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_vars_13_0= ruleVariableDeclaration ) )* ( (lv_defs_14_0= ruleVilDef ) )* otherlv_15= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==47) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:87:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:87:1: (lv_imports_0_0= ruleImport )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:88:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getImportsImportParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleLanguageUnit137);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_0_0, 
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:104:3: ( (lv_javaExts_1_0= ruleExtension ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==36) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:105:1: (lv_javaExts_1_0= ruleExtension )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:105:1: (lv_javaExts_1_0= ruleExtension )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:106:3: lv_javaExts_1_0= ruleExtension
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getJavaExtsExtensionParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExtension_in_ruleLanguageUnit159);
            	    lv_javaExts_1_0=ruleExtension();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"javaExts",
            	              		lv_javaExts_1_0, 
            	              		"Extension");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:122:3: ( (lv_advices_2_0= ruleAdvice ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==39) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:123:1: (lv_advices_2_0= ruleAdvice )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:123:1: (lv_advices_2_0= ruleAdvice )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:124:3: lv_advices_2_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdvice_in_ruleLanguageUnit181);
            	    lv_advices_2_0=ruleAdvice();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"advices",
            	              		lv_advices_2_0, 
            	              		"Advice");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:140:3: ( (lv_indent_3_0= ruleIndentationHint ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:141:1: (lv_indent_3_0= ruleIndentationHint )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:141:1: (lv_indent_3_0= ruleIndentationHint )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:142:3: lv_indent_3_0= ruleIndentationHint
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getIndentIndentationHintParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIndentationHint_in_ruleLanguageUnit203);
                    lv_indent_3_0=ruleIndentationHint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"indent",
                              		lv_indent_3_0, 
                              		"IndentationHint");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleLanguageUnit216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLanguageUnitAccess().getTemplateKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:162:1: ( (lv_name_5_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:163:1: (lv_name_5_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:163:1: (lv_name_5_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:164:3: lv_name_5_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLanguageUnit237);
            lv_name_5_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleLanguageUnit249); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getLanguageUnitAccess().getLeftParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:184:1: ( (lv_param_7_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_VERSION && LA5_0<=RULE_EXPONENT)||(LA5_0>=68 && LA5_0<=70)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:185:1: (lv_param_7_0= ruleParameterList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:185:1: (lv_param_7_0= ruleParameterList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:186:3: lv_param_7_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getParamParameterListParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameterList_in_ruleLanguageUnit270);
                    lv_param_7_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_7_0, 
                              		"ParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleLanguageUnit283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getLanguageUnitAccess().getRightParenthesisKeyword_8());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:206:1: (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:206:3: otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) )
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleLanguageUnit296); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getLanguageUnitAccess().getExtendsKeyword_9_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:210:1: ( (lv_ext_10_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:211:1: (lv_ext_10_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:211:1: (lv_ext_10_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:212:3: lv_ext_10_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getExtIdentifierParserRuleCall_9_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleLanguageUnit317);
                    lv_ext_10_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"ext",
                              		lv_ext_10_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleLanguageUnit331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getLanguageUnitAccess().getLeftCurlyBracketKeyword_10());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:232:1: ( (lv_version_12_0= ruleVersionStmt ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:233:1: (lv_version_12_0= ruleVersionStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:233:1: (lv_version_12_0= ruleVersionStmt )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:234:3: lv_version_12_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_11_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionStmt_in_ruleLanguageUnit352);
                    lv_version_12_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_12_0, 
                              		"VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:250:3: ( (lv_vars_13_0= ruleVariableDeclaration ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_VERSION && LA8_0<=RULE_EXPONENT)||LA8_0==38||(LA8_0>=68 && LA8_0<=70)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:251:1: (lv_vars_13_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:251:1: (lv_vars_13_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:252:3: lv_vars_13_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVarsVariableDeclarationParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleLanguageUnit374);
            	    lv_vars_13_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"vars",
            	              		lv_vars_13_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:268:3: ( (lv_defs_14_0= ruleVilDef ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:269:1: (lv_defs_14_0= ruleVilDef )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:269:1: (lv_defs_14_0= ruleVilDef )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:270:3: lv_defs_14_0= ruleVilDef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getDefsVilDefParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVilDef_in_ruleLanguageUnit396);
            	    lv_defs_14_0=ruleVilDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"defs",
            	              		lv_defs_14_0, 
            	              		"VilDef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleLanguageUnit409); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_14());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleIndentationHint"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:298:1: entryRuleIndentationHint returns [EObject current=null] : iv_ruleIndentationHint= ruleIndentationHint EOF ;
    public final EObject entryRuleIndentationHint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHint = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:299:2: (iv_ruleIndentationHint= ruleIndentationHint EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:300:2: iv_ruleIndentationHint= ruleIndentationHint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintRule()); 
            }
            pushFollow(FOLLOW_ruleIndentationHint_in_entryRuleIndentationHint445);
            iv_ruleIndentationHint=ruleIndentationHint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndentationHint455); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndentationHint"


    // $ANTLR start "ruleIndentationHint"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:307:1: ruleIndentationHint returns [EObject current=null] : (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleIndentationHint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parts_2_0 = null;

        EObject lv_parts_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:310:28: ( (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:311:1: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:311:1: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:311:3: otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleIndentationHint492); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIndentationHintAccess().getIndentKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleIndentationHint504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIndentationHintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:319:1: ( (lv_parts_2_0= ruleIndentationHintPart ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:320:1: (lv_parts_2_0= ruleIndentationHintPart )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:320:1: (lv_parts_2_0= ruleIndentationHintPart )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:321:3: lv_parts_2_0= ruleIndentationHintPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint525);
            lv_parts_2_0=ruleIndentationHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIndentationHintRule());
              	        }
                     		add(
                     			current, 
                     			"parts",
                      		lv_parts_2_0, 
                      		"IndentationHintPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:337:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:337:4: otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleIndentationHint538); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getIndentationHintAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:341:1: ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:342:1: (lv_parts_4_0= ruleIndentationHintPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:342:1: (lv_parts_4_0= ruleIndentationHintPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:343:3: lv_parts_4_0= ruleIndentationHintPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint559);
            	    lv_parts_4_0=ruleIndentationHintPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIndentationHintRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_4_0, 
            	              		"IndentationHintPart");
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleIndentationHint573); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIndentationHintAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndentationHint"


    // $ANTLR start "entryRuleIndentationHintPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:371:1: entryRuleIndentationHintPart returns [EObject current=null] : iv_ruleIndentationHintPart= ruleIndentationHintPart EOF ;
    public final EObject entryRuleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHintPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:372:2: (iv_ruleIndentationHintPart= ruleIndentationHintPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:373:2: iv_ruleIndentationHintPart= ruleIndentationHintPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintPartRule()); 
            }
            pushFollow(FOLLOW_ruleIndentationHintPart_in_entryRuleIndentationHintPart609);
            iv_ruleIndentationHintPart=ruleIndentationHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHintPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndentationHintPart619); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndentationHintPart"


    // $ANTLR start "ruleIndentationHintPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:380:1: ruleIndentationHintPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:383:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:384:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:384:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:384:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:384:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:385:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:385:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:386:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIndentationHintPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleIndentationHintPart665);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIndentationHintPartRule());
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

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleIndentationHintPart677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIndentationHintPartAccess().getEqualsSignKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:406:1: ( (lv_value_2_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:407:1: (lv_value_2_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:407:1: (lv_value_2_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:408:3: lv_value_2_0= RULE_NUMBER
            {
            lv_value_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleIndentationHintPart694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_2_0, grammarAccess.getIndentationHintPartAccess().getValueNUMBERTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIndentationHintPartRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"NUMBER");
              	    
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
    // $ANTLR end "ruleIndentationHintPart"


    // $ANTLR start "entryRuleVilDef"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:432:1: entryRuleVilDef returns [EObject current=null] : iv_ruleVilDef= ruleVilDef EOF ;
    public final EObject entryRuleVilDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVilDef = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:433:2: (iv_ruleVilDef= ruleVilDef EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:434:2: iv_ruleVilDef= ruleVilDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVilDefRule()); 
            }
            pushFollow(FOLLOW_ruleVilDef_in_entryRuleVilDef735);
            iv_ruleVilDef=ruleVilDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVilDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVilDef745); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVilDef"


    // $ANTLR start "ruleVilDef"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:441:1: ruleVilDef returns [EObject current=null] : (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? ) ;
    public final EObject ruleVilDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_id_2_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_stmts_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:444:28: ( (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:445:1: (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:445:1: (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:445:3: otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleVilDef782); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVilDefAccess().getDefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:449:1: ( (lv_type_1_0= ruleType ) )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA11_1 = input.LA(2);

                    if ( ((LA11_1>=RULE_VERSION && LA11_1<=RULE_EXPONENT)||LA11_1==64) ) {
                        alt11=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA11_2 = input.LA(2);

                    if ( ((LA11_2>=RULE_VERSION && LA11_2<=RULE_EXPONENT)||LA11_2==64) ) {
                        alt11=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA11_3 = input.LA(2);

                    if ( ((LA11_3>=RULE_VERSION && LA11_3<=RULE_EXPONENT)||LA11_3==64) ) {
                        alt11=1;
                    }
                    }
                    break;
                case 68:
                case 69:
                case 70:
                    {
                    alt11=1;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:450:1: (lv_type_1_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:450:1: (lv_type_1_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:451:3: lv_type_1_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getTypeTypeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleVilDef803);
                    lv_type_1_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVilDefRule());
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
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:467:3: ( (lv_id_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:468:1: (lv_id_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:468:1: (lv_id_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:469:3: lv_id_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getIdIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVilDef825);
            lv_id_2_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVilDefRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_2_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleVilDef837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getVilDefAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:489:1: ( (lv_param_4_0= ruleParameterList ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_VERSION && LA12_0<=RULE_EXPONENT)||(LA12_0>=68 && LA12_0<=70)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:490:1: (lv_param_4_0= ruleParameterList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:490:1: (lv_param_4_0= ruleParameterList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:491:3: lv_param_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getParamParameterListParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameterList_in_ruleVilDef858);
                    lv_param_4_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVilDefRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_4_0, 
                              		"ParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleVilDef871); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getVilDefAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:511:1: ( (lv_stmts_6_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:512:1: (lv_stmts_6_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:512:1: (lv_stmts_6_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:513:3: lv_stmts_6_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getStmtsStmtBlockParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleVilDef892);
            lv_stmts_6_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVilDefRule());
              	        }
                     		set(
                     			current, 
                     			"stmts",
                      		lv_stmts_6_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:529:2: (otherlv_7= ';' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:529:4: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleVilDef905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getVilDefAccess().getSemicolonKeyword_7());
                          
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
    // $ANTLR end "ruleVilDef"


    // $ANTLR start "entryRuleStmtBlock"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:541:1: entryRuleStmtBlock returns [EObject current=null] : iv_ruleStmtBlock= ruleStmtBlock EOF ;
    public final EObject entryRuleStmtBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmtBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:542:2: (iv_ruleStmtBlock= ruleStmtBlock EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:543:2: iv_ruleStmtBlock= ruleStmtBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtBlockRule()); 
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock943);
            iv_ruleStmtBlock=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtBlock953); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStmtBlock"


    // $ANTLR start "ruleStmtBlock"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:550:1: ruleStmtBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) ;
    public final EObject ruleStmtBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stmts_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:553:28: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:554:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:554:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:554:2: () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:554:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:555:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStmtBlockAccess().getStmtBlockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleStmtBlock1002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:567:1: ( (lv_stmts_2_0= ruleStmt ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_NUMBER && LA14_0<=RULE_EXPONENT)||LA14_0==14||LA14_0==17||LA14_0==24||LA14_0==26||LA14_0==28||(LA14_0>=31 && LA14_0<=32)||LA14_0==38||LA14_0==54||(LA14_0>=57 && LA14_0<=60)||(LA14_0>=65 && LA14_0<=70)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:568:1: (lv_stmts_2_0= ruleStmt )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:568:1: (lv_stmts_2_0= ruleStmt )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:569:3: lv_stmts_2_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStmtBlockAccess().getStmtsStmtParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStmt_in_ruleStmtBlock1023);
            	    lv_stmts_2_0=ruleStmt();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStmtBlockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"stmts",
            	              		lv_stmts_2_0, 
            	              		"Stmt");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleStmtBlock1036); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStmtBlockAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStmtBlock"


    // $ANTLR start "entryRuleStmt"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:597:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:598:2: (iv_ruleStmt= ruleStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:599:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_ruleStmt_in_entryRuleStmt1072);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmt1082); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStmt"


    // $ANTLR start "ruleStmt"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:606:1: ruleStmt returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) ;
    public final EObject ruleStmt() throws RecognitionException {
        EObject current = null;

        EObject lv_var_0_0 = null;

        EObject lv_alt_1_0 = null;

        EObject lv_switch_2_0 = null;

        EObject lv_block_3_0 = null;

        EObject lv_multi_4_0 = null;

        EObject lv_loop_5_0 = null;

        EObject lv_exprStmt_6_0 = null;

        EObject lv_ctn_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:609:28: ( ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            int alt15=8;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:611:1: (lv_var_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:611:1: (lv_var_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:612:3: lv_var_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStmt1128);
                    lv_var_0_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"var",
                              		lv_var_0_0, 
                              		"VariableDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:6: ( (lv_alt_1_0= ruleAlternative ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:6: ( (lv_alt_1_0= ruleAlternative ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:630:1: (lv_alt_1_0= ruleAlternative )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:630:1: (lv_alt_1_0= ruleAlternative )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:631:3: lv_alt_1_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getAltAlternativeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAlternative_in_ruleStmt1155);
                    lv_alt_1_0=ruleAlternative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"alt",
                              		lv_alt_1_0, 
                              		"Alternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:648:6: ( (lv_switch_2_0= ruleSwitch ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:648:6: ( (lv_switch_2_0= ruleSwitch ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:649:1: (lv_switch_2_0= ruleSwitch )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:649:1: (lv_switch_2_0= ruleSwitch )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:650:3: lv_switch_2_0= ruleSwitch
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getSwitchSwitchParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSwitch_in_ruleStmt1182);
                    lv_switch_2_0=ruleSwitch();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"switch",
                              		lv_switch_2_0, 
                              		"Switch");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:668:1: (lv_block_3_0= ruleStmtBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:668:1: (lv_block_3_0= ruleStmtBlock )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:669:3: lv_block_3_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtBlock_in_ruleStmt1209);
                    lv_block_3_0=ruleStmtBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"block",
                              		lv_block_3_0, 
                              		"StmtBlock");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:6: ( (lv_multi_4_0= rulemultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:6: ( (lv_multi_4_0= rulemultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:1: (lv_multi_4_0= rulemultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:1: (lv_multi_4_0= rulemultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:688:3: lv_multi_4_0= rulemultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulemultiselect_in_ruleStmt1236);
                    lv_multi_4_0=rulemultiselect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"multi",
                              		lv_multi_4_0, 
                              		"multiselect");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:6: ( (lv_loop_5_0= ruleLoop ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:6: ( (lv_loop_5_0= ruleLoop ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:706:1: (lv_loop_5_0= ruleLoop )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:706:1: (lv_loop_5_0= ruleLoop )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:707:3: lv_loop_5_0= ruleLoop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getLoopLoopParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLoop_in_ruleStmt1263);
                    lv_loop_5_0=ruleLoop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"loop",
                              		lv_loop_5_0, 
                              		"Loop");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:725:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:725:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:726:3: lv_exprStmt_6_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleStmt1290);
                    lv_exprStmt_6_0=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"exprStmt",
                              		lv_exprStmt_6_0, 
                              		"ExpressionStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:6: ( (lv_ctn_7_0= ruleContent ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:6: ( (lv_ctn_7_0= ruleContent ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:744:1: (lv_ctn_7_0= ruleContent )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:744:1: (lv_ctn_7_0= ruleContent )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:745:3: lv_ctn_7_0= ruleContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getCtnContentParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContent_in_ruleStmt1317);
                    lv_ctn_7_0=ruleContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStmtRule());
                      	        }
                             		set(
                             			current, 
                             			"ctn",
                              		lv_ctn_7_0, 
                              		"Content");
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
    // $ANTLR end "ruleStmt"


    // $ANTLR start "entryRuleAlternative"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:769:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:770:2: (iv_ruleAlternative= ruleAlternative EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:771:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_ruleAlternative_in_entryRuleAlternative1353);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternative1363); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:778:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:781:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:782:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:782:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:782:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleAlternative1400); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAlternative1412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:790:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:791:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:791:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:792:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlternative1433);
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
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAlternative1445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:812:1: ( (lv_if_4_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:813:1: (lv_if_4_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:813:1: (lv_if_4_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:814:3: lv_if_4_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStmtParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1466);
            lv_if_4_0=ruleStmt();

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
                      		"Stmt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred23_InternalTemplateLang()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAlternative1487); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:835:2: ( (lv_else_6_0= ruleStmt ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:836:1: (lv_else_6_0= ruleStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:836:1: (lv_else_6_0= ruleStmt )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:837:3: lv_else_6_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1509);
                    lv_else_6_0=ruleStmt();

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
                              		"Stmt");
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


    // $ANTLR start "entryRuleContent"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:861:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:862:2: (iv_ruleContent= ruleContent EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:2: iv_ruleContent= ruleContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContentRule()); 
            }
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent1547);
            iv_ruleContent=ruleContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent1557); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:870:1: ruleContent returns [EObject current=null] : ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token lv_print_0_0=null;
        Token lv_ctn_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_indent_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:873:28: ( ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:874:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:874:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:874:2: ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:874:2: ( (lv_print_0_0= 'print' ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:875:1: (lv_print_0_0= 'print' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:875:1: (lv_print_0_0= 'print' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:876:3: lv_print_0_0= 'print'
                    {
                    lv_print_0_0=(Token)match(input,26,FOLLOW_26_in_ruleContent1600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_print_0_0, grammarAccess.getContentAccess().getPrintPrintKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContentRule());
                      	        }
                             		setWithLastConsumed(current, "print", lv_print_0_0, "print");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:889:3: ( (lv_ctn_1_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:890:1: (lv_ctn_1_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:890:1: (lv_ctn_1_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:891:3: lv_ctn_1_0= RULE_STRING
            {
            lv_ctn_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleContent1631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_ctn_1_0, grammarAccess.getContentAccess().getCtnSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getContentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"ctn",
                      		lv_ctn_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:2: (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:4: otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';'
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleContent1649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContentAccess().getVerticalLineKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:911:1: ( (lv_indent_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:912:1: (lv_indent_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:912:1: (lv_indent_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:913:3: lv_indent_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContentAccess().getIndentExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleContent1670);
                    lv_indent_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContentRule());
                      	        }
                             		set(
                             			current, 
                             			"indent",
                              		lv_indent_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleContent1682); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getContentAccess().getSemicolonKeyword_2_2());
                          
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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleSwitch"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:941:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:942:2: (iv_ruleSwitch= ruleSwitch EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:943:2: iv_ruleSwitch= ruleSwitch EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchRule()); 
            }
            pushFollow(FOLLOW_ruleSwitch_in_entryRuleSwitch1720);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitch; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitch1730); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitch"


    // $ANTLR start "ruleSwitch"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:950:1: ruleSwitch returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) ;
    public final EObject ruleSwitch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_expr_2_0 = null;

        EObject lv_parts_5_0 = null;

        EObject lv_parts_7_0 = null;

        EObject lv_dflt_11_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:953:28: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:954:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:954:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:954:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleSwitch1767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchAccess().getSwitchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleSwitch1779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:962:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:963:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:963:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:964:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1800);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleSwitch1812); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSwitchAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleSwitch1824); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:988:1: ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:988:2: ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:988:2: ( (lv_parts_5_0= ruleSwitchPart ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:989:1: (lv_parts_5_0= ruleSwitchPart )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:989:1: (lv_parts_5_0= ruleSwitchPart )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:990:3: lv_parts_5_0= ruleSwitchPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1846);
            lv_parts_5_0=ruleSwitchPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchRule());
              	        }
                     		add(
                     			current, 
                     			"parts",
                      		lv_parts_5_0, 
                      		"SwitchPart");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1006:2: (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    int LA19_1 = input.LA(2);

                    if ( ((LA19_1>=RULE_NUMBER && LA19_1<=RULE_EXPONENT)||LA19_1==14||LA19_1==17||LA19_1==54||(LA19_1>=57 && LA19_1<=60)||(LA19_1>=65 && LA19_1<=67)) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1006:4: otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1859); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getCommaKeyword_5_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1010:1: ( (lv_parts_7_0= ruleSwitchPart ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1011:1: (lv_parts_7_0= ruleSwitchPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1011:1: (lv_parts_7_0= ruleSwitchPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1012:3: lv_parts_7_0= ruleSwitchPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1880);
            	    lv_parts_7_0=ruleSwitchPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitchRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parts",
            	              		lv_parts_7_0, 
            	              		"SwitchPart");
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1028:4: (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1028:6: otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1895); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSwitchAccess().getCommaKeyword_5_2_0());
                          
                    }
                    otherlv_9=(Token)match(input,29,FOLLOW_29_in_ruleSwitch1907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSwitchAccess().getDefaultKeyword_5_2_1());
                          
                    }
                    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleSwitch1919); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSwitchAccess().getColonKeyword_5_2_2());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1040:1: ( (lv_dflt_11_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1041:1: (lv_dflt_11_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1041:1: (lv_dflt_11_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1042:3: lv_dflt_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSwitchAccess().getDfltExpressionParserRuleCall_5_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1940);
                    lv_dflt_11_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSwitchRule());
                      	        }
                             		set(
                             			current, 
                             			"dflt",
                              		lv_dflt_11_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleSwitch1955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getSwitchAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitch"


    // $ANTLR start "entryRuleSwitchPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1070:1: entryRuleSwitchPart returns [EObject current=null] : iv_ruleSwitchPart= ruleSwitchPart EOF ;
    public final EObject entryRuleSwitchPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1071:2: (iv_ruleSwitchPart= ruleSwitchPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1072:2: iv_ruleSwitchPart= ruleSwitchPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchPartRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart1991);
            iv_ruleSwitchPart=ruleSwitchPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchPart2001); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchPart"


    // $ANTLR start "ruleSwitchPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1079:1: ruleSwitchPart returns [EObject current=null] : ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1082:28: ( ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1083:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1083:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1083:2: ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1083:2: ( (lv_left_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1084:1: (lv_left_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1084:1: (lv_left_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1085:3: lv_left_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getLeftExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2047);
            lv_left_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchPartRule());
              	        }
                     		set(
                     			current, 
                     			"left",
                      		lv_left_0_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleSwitchPart2059); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchPartAccess().getColonKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1105:1: ( (lv_right_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1106:1: (lv_right_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1106:1: (lv_right_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1107:3: lv_right_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getRightExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2080);
            lv_right_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchPartRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
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
    // $ANTLR end "ruleSwitchPart"


    // $ANTLR start "entryRuleLoop"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1131:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1132:2: (iv_ruleLoop= ruleLoop EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1133:2: iv_ruleLoop= ruleLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopRule()); 
            }
            pushFollow(FOLLOW_ruleLoop_in_entryRuleLoop2116);
            iv_ruleLoop=ruleLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop2126); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1140:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) ;
    public final EObject ruleLoop() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_expr_5_0 = null;

        EObject lv_separator_7_0 = null;

        EObject lv_finalSeparator_9_0 = null;

        EObject lv_stmt_11_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1143:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1144:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1144:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1144:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleLoop2163); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleLoop2175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1152:1: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1153:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1153:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1154:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLoop2196);
            lv_type_2_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1170:2: ( (lv_id_3_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1171:1: (lv_id_3_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1171:1: (lv_id_3_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1172:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLoop2217);
            lv_id_3_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopRule());
              	        }
                     		set(
                     			current, 
                     			"id",
                      		lv_id_3_0, 
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleLoop2229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getColonKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1192:1: ( (lv_expr_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1193:1: (lv_expr_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1193:1: (lv_expr_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1194:3: lv_expr_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLoop2250);
            lv_expr_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_5_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1210:2: (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1210:4: otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleLoop2263); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getCommaKeyword_6_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1214:1: ( (lv_separator_7_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1215:1: (lv_separator_7_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1215:1: (lv_separator_7_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1216:3: lv_separator_7_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopAccess().getSeparatorPrimaryExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2284);
                    lv_separator_7_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLoopRule());
                      	        }
                             		set(
                             			current, 
                             			"separator",
                              		lv_separator_7_0, 
                              		"PrimaryExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1232:2: (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==20) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1232:4: otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            {
                            otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleLoop2297); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getCommaKeyword_6_2_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1236:1: ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1237:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1237:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1238:3: lv_finalSeparator_9_0= rulePrimaryExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLoopAccess().getFinalSeparatorPrimaryExpressionParserRuleCall_6_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2318);
                            lv_finalSeparator_9_0=rulePrimaryExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getLoopRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"finalSeparator",
                                      		lv_finalSeparator_9_0, 
                                      		"PrimaryExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleLoop2334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getRightParenthesisKeyword_7());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1258:1: ( (lv_stmt_11_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1259:1: (lv_stmt_11_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1259:1: (lv_stmt_11_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1260:3: lv_stmt_11_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getStmtStmtParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleLoop2355);
            lv_stmt_11_0=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopRule());
              	        }
                     		set(
                     			current, 
                     			"stmt",
                      		lv_stmt_11_0, 
                      		"Stmt");
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
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRulemultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1284:1: entryRulemultiselect returns [EObject current=null] : iv_rulemultiselect= rulemultiselect EOF ;
    public final EObject entryRulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1285:2: (iv_rulemultiselect= rulemultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1286:2: iv_rulemultiselect= rulemultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulemultiselect_in_entryRulemultiselect2391);
            iv_rulemultiselect=rulemultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiselect2401); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemultiselect"


    // $ANTLR start "rulemultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1293:1: rulemultiselect returns [EObject current=null] : ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) ;
    public final EObject rulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject lv_gen_0_0 = null;

        EObject lv_user_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1296:28: ( ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1297:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1297:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==32) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=RULE_VERSION && LA23_0<=RULE_EXPONENT)) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1297:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1297:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1298:1: (lv_gen_0_0= rulegenericMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1298:1: (lv_gen_0_0= rulegenericMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1299:3: lv_gen_0_0= rulegenericMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getGenGenericMultiselectParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulegenericMultiselect_in_rulemultiselect2447);
                    lv_gen_0_0=rulegenericMultiselect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiselectRule());
                      	        }
                             		set(
                             			current, 
                             			"gen",
                              		lv_gen_0_0, 
                              		"genericMultiselect");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1316:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1316:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1317:1: (lv_user_1_0= ruleuserMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1317:1: (lv_user_1_0= ruleuserMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1318:3: lv_user_1_0= ruleuserMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getUserUserMultiselectParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleuserMultiselect_in_rulemultiselect2474);
                    lv_user_1_0=ruleuserMultiselect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiselectRule());
                      	        }
                             		set(
                             			current, 
                             			"user",
                              		lv_user_1_0, 
                              		"userMultiselect");
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
    // $ANTLR end "rulemultiselect"


    // $ANTLR start "entryRulegenericMultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1342:1: entryRulegenericMultiselect returns [EObject current=null] : iv_rulegenericMultiselect= rulegenericMultiselect EOF ;
    public final EObject entryRulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulegenericMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1343:2: (iv_rulegenericMultiselect= rulegenericMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1344:2: iv_rulegenericMultiselect= rulegenericMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2510);
            iv_rulegenericMultiselect=rulegenericMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegenericMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegenericMultiselect2520); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulegenericMultiselect"


    // $ANTLR start "rulegenericMultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1351:1: rulegenericMultiselect returns [EObject current=null] : (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) ;
    public final EObject rulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_preamble_1_0 = null;

        EObject lv_selector_2_0 = null;

        EObject lv_part_3_0 = null;

        EObject lv_trailer_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1354:28: ( (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1355:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1355:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1355:3: otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_rulegenericMultiselect2557); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGenericMultiselectAccess().getMultiSelectKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1359:1: ( (lv_preamble_1_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1360:1: (lv_preamble_1_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1360:1: (lv_preamble_1_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1361:3: lv_preamble_1_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPreambleStmtBlockParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2578);
            lv_preamble_1_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGenericMultiselectRule());
              	        }
                     		set(
                     			current, 
                     			"preamble",
                      		lv_preamble_1_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1377:2: ( (lv_selector_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1378:1: (lv_selector_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1378:1: (lv_selector_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1379:3: lv_selector_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getSelectorStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2599);
            lv_selector_2_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGenericMultiselectRule());
              	        }
                     		set(
                     			current, 
                     			"selector",
                      		lv_selector_2_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1395:2: ( (lv_part_3_0= rulemultiSelectPart ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==33) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1396:1: (lv_part_3_0= rulemultiSelectPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1396:1: (lv_part_3_0= rulemultiSelectPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1397:3: lv_part_3_0= rulemultiSelectPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPartMultiSelectPartParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2620);
            	    lv_part_3_0=rulemultiSelectPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getGenericMultiselectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"part",
            	              		lv_part_3_0, 
            	              		"multiSelectPart");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1413:3: ( (lv_trailer_4_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1414:1: (lv_trailer_4_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1414:1: (lv_trailer_4_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1415:3: lv_trailer_4_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getTrailerStmtBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2642);
            lv_trailer_4_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGenericMultiselectRule());
              	        }
                     		set(
                     			current, 
                     			"trailer",
                      		lv_trailer_4_0, 
                      		"StmtBlock");
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
    // $ANTLR end "rulegenericMultiselect"


    // $ANTLR start "entryRulemultiSelectPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1439:1: entryRulemultiSelectPart returns [EObject current=null] : iv_rulemultiSelectPart= rulemultiSelectPart EOF ;
    public final EObject entryRulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiSelectPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1440:2: (iv_rulemultiSelectPart= rulemultiSelectPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1441:2: iv_rulemultiSelectPart= rulemultiSelectPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiSelectPartRule()); 
            }
            pushFollow(FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2678);
            iv_rulemultiSelectPart=rulemultiSelectPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiSelectPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiSelectPart2688); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemultiSelectPart"


    // $ANTLR start "rulemultiSelectPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1448:1: rulemultiSelectPart returns [EObject current=null] : (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) ;
    public final EObject rulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_case_1_0 = null;

        EObject lv_code_2_0 = null;

        EObject lv_selector_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1451:28: ( (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1452:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1452:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1452:3: otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_rulemultiSelectPart2725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiSelectPartAccess().getCaseKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1456:1: ( (lv_case_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1457:1: (lv_case_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1457:1: (lv_case_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1458:3: lv_case_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCaseExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_rulemultiSelectPart2746);
            lv_case_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiSelectPartRule());
              	        }
                     		set(
                     			current, 
                     			"case",
                      		lv_case_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1474:2: ( (lv_code_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1475:1: (lv_code_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1475:1: (lv_code_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1476:3: lv_code_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCodeStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2767);
            lv_code_2_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiSelectPartRule());
              	        }
                     		set(
                     			current, 
                     			"code",
                      		lv_code_2_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1492:2: ( (lv_selector_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1493:1: (lv_selector_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1493:1: (lv_selector_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1494:3: lv_selector_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getSelectorStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2788);
            lv_selector_3_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiSelectPartRule());
              	        }
                     		set(
                     			current, 
                     			"selector",
                      		lv_selector_3_0, 
                      		"StmtBlock");
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
    // $ANTLR end "rulemultiSelectPart"


    // $ANTLR start "entryRuleuserMultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1518:1: entryRuleuserMultiselect returns [EObject current=null] : iv_ruleuserMultiselect= ruleuserMultiselect EOF ;
    public final EObject entryRuleuserMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuserMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1519:2: (iv_ruleuserMultiselect= ruleuserMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1520:2: iv_ruleuserMultiselect= ruleuserMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUserMultiselectRule()); 
            }
            pushFollow(FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2824);
            iv_ruleuserMultiselect=ruleuserMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuserMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleuserMultiselect2834); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuserMultiselect"


    // $ANTLR start "ruleuserMultiselect"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1527:1: ruleuserMultiselect returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleuserMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_stmt_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1530:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1531:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1531:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1531:2: ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1531:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1532:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1532:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1533:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleuserMultiselect2880);
            lv_id_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUserMultiselectRule());
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleuserMultiselect2892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUserMultiselectAccess().getColonEqualsSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleuserMultiselect2904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUserMultiselectAccess().getGenericMultiSelectKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1557:1: ( (lv_stmt_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1558:1: (lv_stmt_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1558:1: (lv_stmt_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1559:3: lv_stmt_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getStmtStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2925);
            lv_stmt_3_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUserMultiselectRule());
              	        }
                     		set(
                     			current, 
                     			"stmt",
                      		lv_stmt_3_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1575:2: (otherlv_4= ';' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1575:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleuserMultiselect2938); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getUserMultiselectAccess().getSemicolonKeyword_4());
                          
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
    // $ANTLR end "ruleuserMultiselect"


    // $ANTLR start "entryRuleExtension"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1587:1: entryRuleExtension returns [EObject current=null] : iv_ruleExtension= ruleExtension EOF ;
    public final EObject entryRuleExtension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtension = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1588:2: (iv_ruleExtension= ruleExtension EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1589:2: iv_ruleExtension= ruleExtension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRule()); 
            }
            pushFollow(FOLLOW_ruleExtension_in_entryRuleExtension2976);
            iv_ruleExtension=ruleExtension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtension; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtension2986); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtension"


    // $ANTLR start "ruleExtension"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1596:1: ruleExtension returns [EObject current=null] : (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleExtension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1599:28: ( (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1600:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1600:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1600:3: otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleExtension3023); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExtensionAccess().getExtensionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1604:1: ( (lv_name_1_0= ruleJavaQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1605:1: (lv_name_1_0= ruleJavaQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1605:1: (lv_name_1_0= ruleJavaQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1606:3: lv_name_1_0= ruleJavaQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExtensionAccess().getNameJavaQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_ruleExtension3044);
            lv_name_1_0=ruleJavaQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExtensionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"JavaQualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleExtension3056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getExtensionAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtension"


    // $ANTLR start "entryRuleJavaQualifiedName"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1634:1: entryRuleJavaQualifiedName returns [EObject current=null] : iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF ;
    public final EObject entryRuleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1635:2: (iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1636:2: iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3092);
            iv_ruleJavaQualifiedName=ruleJavaQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaQualifiedName3102); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJavaQualifiedName"


    // $ANTLR start "ruleJavaQualifiedName"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1643:1: ruleJavaQualifiedName returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1646:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1647:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1647:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1647:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1647:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1648:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1648:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1649:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3148);
            lv_qname_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJavaQualifiedNameRule());
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==37) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1666:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1666:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1667:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleJavaQualifiedName3167); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_qname_1_0, grammarAccess.getJavaQualifiedNameAccess().getQnameFullStopKeyword_1_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getJavaQualifiedNameRule());
            	      	        }
            	             		addWithLastConsumed(current, "qname", lv_qname_1_0, ".");
            	      	    
            	    }

            	    }


            	    }

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1680:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1681:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1681:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1682:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3201);
            	    lv_qname_2_0=ruleIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getJavaQualifiedNameRule());
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
            	    break loop26;
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
    // $ANTLR end "ruleJavaQualifiedName"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1706:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1707:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1708:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3239);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3249); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1715:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1718:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1719:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1719:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1719:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1719:2: ( (lv_const_0_0= 'const' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1720:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1720:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1721:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,38,FOLLOW_38_in_ruleVariableDeclaration3292); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1734:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1735:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1735:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1736:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3327);
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
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1754:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3348);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1770:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==21) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1770:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleVariableDeclaration3361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1774:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1775:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1775:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1776:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3382);
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
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3396); if (state.failed) return current;
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


    // $ANTLR start "entryRuleAdvice"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1804:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1805:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1806:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3432);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3442); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1813:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1816:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1817:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1817:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1817:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleAdvice3479); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAdvice3491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1825:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1826:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1826:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1827:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice3512);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAdvice3524); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1847:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==40) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1848:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1848:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1849:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice3545);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1873:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1874:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1875:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3582);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec3592); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1882:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1885:28: ( (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1886:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1886:1: (otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1886:3: otherlv_0= 'with' otherlv_1= '(' ( (lv_conflicts_2_0= ruleVersionedId ) ) (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleVersionSpec3629); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleVersionSpec3641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVersionSpecAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1894:1: ( (lv_conflicts_2_0= ruleVersionedId ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1895:1: (lv_conflicts_2_0= ruleVersionedId )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1895:1: (lv_conflicts_2_0= ruleVersionedId )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1896:3: lv_conflicts_2_0= ruleVersionedId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3662);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1912:2: (otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==20) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1912:4: otherlv_3= ',' ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleVersionSpec3675); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVersionSpecAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1916:1: ( (lv_conflicts_4_0= ruleVersionedId ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1917:1: (lv_conflicts_4_0= ruleVersionedId )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1917:1: (lv_conflicts_4_0= ruleVersionedId )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1918:3: lv_conflicts_4_0= ruleVersionedId
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVersionSpecAccess().getConflictsVersionedIdParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVersionedId_in_ruleVersionSpec3696);
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
            	    break loop30;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleVersionSpec3710); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1946:1: entryRuleVersionedId returns [EObject current=null] : iv_ruleVersionedId= ruleVersionedId EOF ;
    public final EObject entryRuleVersionedId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionedId = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1947:2: (iv_ruleVersionedId= ruleVersionedId EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1948:2: iv_ruleVersionedId= ruleVersionedId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionedIdRule()); 
            }
            pushFollow(FOLLOW_ruleVersionedId_in_entryRuleVersionedId3746);
            iv_ruleVersionedId=ruleVersionedId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionedId; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionedId3756); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1955:1: ruleVersionedId returns [EObject current=null] : (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) ;
    public final EObject ruleVersionedId() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_2_0=null;
        AntlrDatatypeRuleToken lv_op_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1958:28: ( (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1959:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1959:1: (otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1959:3: otherlv_0= 'version' ( (lv_op_1_0= ruleVersionOperator ) ) ( (lv_version_2_0= RULE_VERSION ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleVersionedId3793); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionedIdAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1963:1: ( (lv_op_1_0= ruleVersionOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1964:1: (lv_op_1_0= ruleVersionOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1964:1: (lv_op_1_0= ruleVersionOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1965:3: lv_op_1_0= ruleVersionOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionedIdAccess().getOpVersionOperatorParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_ruleVersionedId3814);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1981:2: ( (lv_version_2_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1982:1: (lv_version_2_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1982:1: (lv_version_2_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1983:3: lv_version_2_0= RULE_VERSION
            {
            lv_version_2_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionedId3831); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2007:1: entryRuleVersionOperator returns [String current=null] : iv_ruleVersionOperator= ruleVersionOperator EOF ;
    public final String entryRuleVersionOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2008:2: (iv_ruleVersionOperator= ruleVersionOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2009:2: iv_ruleVersionOperator= ruleVersionOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3873);
            iv_ruleVersionOperator=ruleVersionOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionOperator3884); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2016:1: ruleVersionOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleVersionOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2019:28: ( (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2020:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2020:1: (kw= '==' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt31=5;
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
            case 45:
                {
                alt31=4;
                }
                break;
            case 46:
                {
                alt31=5;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2021:2: kw= '=='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleVersionOperator3922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2028:2: kw= '>'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleVersionOperator3941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2035:2: kw= '<'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleVersionOperator3960); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getLessThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2042:2: kw= '>='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleVersionOperator3979); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionOperatorAccess().getGreaterThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2049:2: kw= '<='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleVersionOperator3998); if (state.failed) return current;
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


    // $ANTLR start "entryRuleParameterList"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2062:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2063:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2064:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList4038);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList4048); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2071:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2074:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2076:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2076:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2077:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4094);
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
                      		"Parameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2093:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==20) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2093:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleParameterList4107); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2097:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2098:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2098:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2099:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4128);
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
            	              		"Parameter");
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2123:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2124:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2125:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4166);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4176); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2132:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2135:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2136:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2136:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2136:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2136:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2137:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2137:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2138:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4222);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2154:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2155:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2155:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2156:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4243);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2180:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2181:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2182:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4279);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4289); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2189:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2192:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2193:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2193:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2193:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleVersionStmt4326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2197:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2198:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2198:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2199:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4343); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleVersionStmt4360); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2227:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2228:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2229:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4396);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4406); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2236:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2239:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2240:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2240:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2240:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleImport4443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2244:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2245:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2245:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2246:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4464);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2262:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==40) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2263:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2263:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2264:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4485);
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

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleImport4498); if (state.failed) return current;
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


    // $ANTLR start "entryRuleExpressionStatement"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2292:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2293:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2294:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4534);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement4544); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2301:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2304:28: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:2: ( ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt34=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==21) ) {
                        alt34=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA34_2 = input.LA(2);

                    if ( (LA34_2==21) ) {
                        alt34=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA34_3 = input.LA(2);

                    if ( (LA34_3==21) ) {
                        alt34=1;
                    }
                    }
                    break;
            }

            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:3: ( (lv_var_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2305:3: ( (lv_var_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2306:1: (lv_var_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2306:1: (lv_var_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2307:3: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4591);
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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleExpressionStatement4603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2327:3: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2328:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2328:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2329:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement4626);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expr",
                      		lv_expr_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement4638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2357:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2358:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2359:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4674);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4684); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2366:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2369:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2370:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2370:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_NUMBER && LA35_0<=RULE_EXPONENT)||LA35_0==14||LA35_0==54||(LA35_0>=57 && LA35_0<=60)||(LA35_0>=65 && LA35_0<=67)) ) {
                alt35=1;
            }
            else if ( (LA35_0==17) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2370:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2370:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2371:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2371:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2372:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4730);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2389:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2389:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2390:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2390:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2391:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4757);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2415:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2416:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2417:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4793);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4803); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2424:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2427:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2428:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2428:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2428:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2428:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2429:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2429:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2430:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4849);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2446:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=48 && LA36_0<=50)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2447:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2447:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2448:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4870);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2472:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2473:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2474:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4907);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart4917); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2481:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2484:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2485:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2485:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2485:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2485:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2486:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2486:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2487:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4963);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2503:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2504:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2504:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2505:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4984);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2529:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2530:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2531:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5021);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator5032); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2538:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2541:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt37=1;
                }
                break;
            case 49:
                {
                alt37=2;
                }
                break;
            case 50:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2543:2: kw= 'and'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleLogicalOperator5070); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2550:2: kw= 'or'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleLogicalOperator5089); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2557:2: kw= 'xor'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleLogicalOperator5108); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2570:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2571:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2572:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5148);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5158); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2579:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2582:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2583:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2583:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2583:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2583:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2584:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2584:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2585:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5204);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2601:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==42||(LA38_0>=51 && LA38_0<=52)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2602:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2602:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2603:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5225);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2627:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2628:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2629:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5262);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5272); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2636:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2639:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2640:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2640:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2640:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2640:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2641:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2641:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2642:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5318);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2658:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2659:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2659:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2660:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5339);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2684:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2685:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2686:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5376);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5387); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2693:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2696:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt39=1;
                }
                break;
            case 51:
                {
                alt39=2;
                }
                break;
            case 52:
                {
                alt39=3;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2698:2: kw= '=='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleEqualityOperator5425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2705:2: kw= '<>'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleEqualityOperator5444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2712:2: kw= '!='
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleEqualityOperator5463); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2725:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2726:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2727:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5503);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5513); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2734:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2737:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2738:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2738:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2738:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2738:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2739:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2739:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2740:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5559);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2756:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=43 && LA40_0<=46)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2757:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2757:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2758:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5580);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2782:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2783:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2784:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5617);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5627); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2791:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2794:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2795:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2795:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2795:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2795:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2796:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2796:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2797:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5673);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2813:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2814:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2814:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2815:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5694);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2839:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2840:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2841:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5731);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5742); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2848:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2851:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2852:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2852:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt41=1;
                }
                break;
            case 44:
                {
                alt41=2;
                }
                break;
            case 45:
                {
                alt41=3;
                }
                break;
            case 46:
                {
                alt41=4;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2853:2: kw= '>'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleRelationalOperator5780); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2860:2: kw= '<'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleRelationalOperator5799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2867:2: kw= '>='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleRelationalOperator5818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2874:2: kw= '<='
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleRelationalOperator5837); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2887:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2888:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2889:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5877);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5887); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2896:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2899:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2900:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2900:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2900:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2900:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2901:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2901:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2902:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5933);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2918:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=53 && LA42_0<=54)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2919:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2919:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2920:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5954);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2944:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2945:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2946:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5991);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6001); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2953:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2956:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2957:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2957:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2957:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2957:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2958:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2958:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2959:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6047);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2975:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2976:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2976:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2977:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6068);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3001:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3002:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3003:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6105);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6116); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3010:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3013:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3014:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3014:1: (kw= '+' | kw= '-' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==53) ) {
                alt43=1;
            }
            else if ( (LA43_0==54) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3015:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleAdditiveOperator6154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3022:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleAdditiveOperator6173); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3035:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3036:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3037:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6213);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6223); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3044:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3047:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3048:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3048:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3048:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3048:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3049:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3049:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3050:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6269);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3066:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=55 && LA44_0<=56)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3067:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3067:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3068:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6290);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3092:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3093:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3094:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6327);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6337); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3101:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3104:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3105:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3105:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3105:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3105:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3106:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3106:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3107:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6383);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3123:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3124:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3124:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3125:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6404);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3149:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3150:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3151:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6441);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6452); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3158:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3161:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3162:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3162:1: (kw= '*' | kw= '/' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==55) ) {
                alt45=1;
            }
            else if ( (LA45_0==56) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3163:2: kw= '*'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleMultiplicativeOperator6490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3170:2: kw= '/'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleMultiplicativeOperator6509); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3183:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3184:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3185:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6549);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6559); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3192:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3195:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3196:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3196:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3196:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3196:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==54||(LA46_0>=57 && LA46_0<=58)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3197:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3197:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3198:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6605);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3214:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3215:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3215:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3216:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6627);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3240:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3241:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3242:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6664);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6675); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3249:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3252:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3253:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3253:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt47=1;
                }
                break;
            case 58:
                {
                alt47=2;
                }
                break;
            case 54:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3254:2: kw= 'not'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleUnaryOperator6713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3261:2: kw= '!'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleUnaryOperator6732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3268:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleUnaryOperator6751); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3281:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3282:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3283:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6791);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6801); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3290:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3293:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3294:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3294:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3295:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3295:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3296:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6846);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3320:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3321:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3322:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6881);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression6891); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3329:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3332:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3333:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3333:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt48=4;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3333:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3333:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3334:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3334:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3335:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6937);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3352:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3352:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3353:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3353:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3354:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6964);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3371:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3371:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3372:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3372:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3373:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6991);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3390:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3390:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3391:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3391:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3392:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression7018);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3416:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3417:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3418:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution7054);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution7064); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3425:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3428:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_NUMBER && LA49_0<=RULE_EXPONENT)||(LA49_0>=65 && LA49_0<=67)) ) {
                alt49=1;
            }
            else if ( (LA49_0==14) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3429:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3430:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3430:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3431:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7111);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3448:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3448:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3448:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution7130); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3452:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3453:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3453:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3454:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7151);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution7163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3474:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==37||(LA50_0>=61 && LA50_0<=62)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3475:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3475:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3476:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7186);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3500:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3501:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3502:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7223);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7233); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3509:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3512:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3513:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3513:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3513:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3513:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3514:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3514:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3515:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7279);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3531:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==37||(LA51_0>=61 && LA51_0<=62)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3532:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3532:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3533:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7300);
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
            	    break loop51;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3557:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3558:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3559:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7337);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7347); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3566:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3569:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3570:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3570:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3570:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleSuperExecution7384); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSuperExecution7396); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3578:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3579:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3579:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3580:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7417);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3596:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==37||(LA52_0>=61 && LA52_0<=62)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3597:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3597:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3598:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7438);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3622:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3623:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3624:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7475);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7485); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3631:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3634:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3635:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3635:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3635:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleConstructorExecution7522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3639:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3640:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3640:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3641:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7543);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution7555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3661:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_NUMBER && LA53_0<=RULE_EXPONENT)||LA53_0==14||LA53_0==17||LA53_0==54||(LA53_0>=57 && LA53_0<=60)||(LA53_0>=65 && LA53_0<=67)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3662:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3662:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3663:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7576);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution7589); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3683:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==37||(LA54_0>=61 && LA54_0<=62)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3684:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3684:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3685:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7610);
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
            	    break loop54;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3709:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3710:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3711:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7647);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7657); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3718:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3721:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==37||LA56_0==61) ) {
                alt56=1;
            }
            else if ( (LA56_0==62) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3722:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3723:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3723:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3724:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3724:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==37) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==61) ) {
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3725:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,37,FOLLOW_37_in_ruleSubCall7703); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3737:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,61,FOLLOW_61_in_ruleSubCall7732); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3752:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3753:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3753:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3754:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7769);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3771:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3771:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3771:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_62_in_ruleSubCall7789); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3775:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3776:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3776:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3777:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7810);
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

                    otherlv_4=(Token)match(input,63,FOLLOW_63_in_ruleSubCall7822); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3805:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3806:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3807:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7859);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7869); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3814:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3817:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3818:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3818:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3818:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3818:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3819:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3819:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3820:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7915);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3836:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==23) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3836:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleDeclarator7928); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3840:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3841:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3841:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3842:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7949);
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
            	    break loop57;
                }
            } while (true);

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleDeclarator7963); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3870:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3871:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3872:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration7999);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration8009); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3879:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3882:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:2: ( (lv_type_0_0= ruleType ) )?
            int alt58=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA58_1 = input.LA(2);

                    if ( ((LA58_1>=RULE_VERSION && LA58_1<=RULE_EXPONENT)||LA58_1==64) ) {
                        alt58=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA58_2 = input.LA(2);

                    if ( ((LA58_2>=RULE_VERSION && LA58_2<=RULE_EXPONENT)||LA58_2==64) ) {
                        alt58=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA58_3 = input.LA(2);

                    if ( ((LA58_3>=RULE_VERSION && LA58_3<=RULE_EXPONENT)||LA58_3==64) ) {
                        alt58=1;
                    }
                    }
                    break;
                case 68:
                case 69:
                case 70:
                    {
                    alt58=1;
                    }
                    break;
            }

            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3884:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3884:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3885:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration8055);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3901:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3902:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3902:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3903:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration8077);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3919:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==20) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3919:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration8090); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3923:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3924:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3924:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3925:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration8111);
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3949:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3950:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3951:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall8149);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall8159); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3958:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3961:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3962:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3962:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3962:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3962:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3963:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3963:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3964:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8205);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall8217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3984:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3985:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3985:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3986:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8238);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4002:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=RULE_NUMBER && LA61_0<=RULE_EXPONENT)||LA61_0==14||LA61_0==17||LA61_0==54||(LA61_0>=57 && LA61_0<=60)||(LA61_0>=65 && LA61_0<=67)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4003:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4003:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4004:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8260);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall8273); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4032:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4033:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4034:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8309);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8319); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4041:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4044:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4045:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4045:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4045:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4045:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4046:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4046:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4047:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8365);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4063:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==20) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4063:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleArgumentList8378); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4067:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4068:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4068:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4069:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8399);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4093:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4094:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4095:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8437);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8447); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4102:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4105:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt63=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA63_1 = input.LA(2);

                    if ( (LA63_1==21) ) {
                        alt63=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA63_2 = input.LA(2);

                    if ( (LA63_2==21) ) {
                        alt63=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA63_3 = input.LA(2);

                    if ( (LA63_3==21) ) {
                        alt63=1;
                    }
                    }
                    break;
            }

            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4106:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4107:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4107:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4108:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8494);
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

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleNamedArgument8506); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4128:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4129:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4129:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4130:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8529);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4154:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4155:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4156:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8565);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8575); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4163:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4166:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4167:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4167:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4167:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4167:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4168:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4168:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4169:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8621);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4185:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==64) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4185:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4185:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4186:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4186:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4187:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,64,FOLLOW_64_in_ruleQualifiedPrefix8640); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4200:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4201:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4201:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4202:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8674);
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
            	    break loop64;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4226:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4227:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4228:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8712);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8722); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4235:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4238:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4239:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4239:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4239:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4239:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4240:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4240:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4241:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8768);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4257:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==37) ) {
                switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA65_3 = input.LA(3);

                        if ( (LA65_3==EOF||LA65_3==15||(LA65_3>=17 && LA65_3<=18)||LA65_3==20||LA65_3==23||LA65_3==30||LA65_3==37||(LA65_3>=42 && LA65_3<=46)||(LA65_3>=48 && LA65_3<=56)||(LA65_3>=61 && LA65_3<=63)) ) {
                            alt65=1;
                        }
                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA65_4 = input.LA(3);

                        if ( (LA65_4==EOF||LA65_4==15||(LA65_4>=17 && LA65_4<=18)||LA65_4==20||LA65_4==23||LA65_4==30||LA65_4==37||(LA65_4>=42 && LA65_4<=46)||(LA65_4>=48 && LA65_4<=56)||(LA65_4>=61 && LA65_4<=63)) ) {
                            alt65=1;
                        }
                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA65_5 = input.LA(3);

                        if ( (LA65_5==EOF||LA65_5==15||(LA65_5>=17 && LA65_5<=18)||LA65_5==20||LA65_5==23||LA65_5==30||LA65_5==37||(LA65_5>=42 && LA65_5<=46)||(LA65_5>=48 && LA65_5<=56)||(LA65_5>=61 && LA65_5<=63)) ) {
                            alt65=1;
                        }
                        }
                        break;
                }

            }
            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4257:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4257:3: ( (lv_qname_1_0= '.' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4258:1: (lv_qname_1_0= '.' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4258:1: (lv_qname_1_0= '.' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4259:3: lv_qname_1_0= '.'
                    {
                    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName8787); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4272:2: ( (lv_qname_2_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4273:1: (lv_qname_2_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4273:1: (lv_qname_2_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4274:3: lv_qname_2_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8821);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4298:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4299:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4300:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8859);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8869); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4307:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4310:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4311:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4311:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) )
            int alt67=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt67=1;
                }
                break;
            case RULE_STRING:
                {
                alt67=2;
                }
                break;
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt67=3;
                }
                break;
            case 65:
            case 66:
                {
                alt67=4;
                }
                break;
            case 67:
                {
                alt67=5;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4311:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4311:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4312:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4312:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4313:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8915);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4330:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4330:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4332:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8938); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4349:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4349:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4350:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4350:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4351:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8970);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4368:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4368:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==65) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==66) ) {
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4371:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,65,FOLLOW_65_in_ruleConstant8996); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4383:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,66,FOLLOW_66_in_ruleConstant9025); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4399:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4399:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4400:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4400:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4401:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,67,FOLLOW_67_in_ruleConstant9065); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4422:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4423:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4424:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue9114);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue9124); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4431:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4434:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4436:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4436:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4437:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9165); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4461:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4462:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4463:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9206);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9217); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4470:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4473:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4474:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4474:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT )
            int alt68=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt68=1;
                }
                break;
            case RULE_VERSION:
                {
                alt68=2;
                }
                break;
            case RULE_EXPONENT:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4474:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9257); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4482:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4490:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9309); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4505:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4506:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4507:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9354);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9364); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4514:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4517:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
                {
                alt69=1;
                }
                break;
            case 68:
                {
                alt69=2;
                }
                break;
            case 69:
                {
                alt69=3;
                }
                break;
            case 70:
                {
                alt69=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4519:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4519:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4520:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9410);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4537:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4537:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4537:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4537:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4538:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4538:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4539:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,68,FOLLOW_68_in_ruleType9435); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4552:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4553:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4553:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4554:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9469);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4572:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4572:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4573:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,69,FOLLOW_69_in_ruleType9495); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4586:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4587:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4587:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4588:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9529);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4606:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4606:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4607:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,70,FOLLOW_70_in_ruleType9555); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4620:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4621:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4621:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4622:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9589);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4646:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4647:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4648:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9626);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9636); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4655:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_param_1_0 = null;

        AntlrDatatypeRuleToken lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4658:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4659:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4659:1: (otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4659:3: otherlv_0= '(' ( (lv_param_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters9673); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4663:1: ( (lv_param_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4664:1: (lv_param_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4664:1: (lv_param_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4665:3: lv_param_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9694);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4681:2: (otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==20) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4681:4: otherlv_2= ',' ( (lv_param_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTypeParameters9707); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4685:1: ( (lv_param_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4686:1: (lv_param_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4686:1: (lv_param_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4687:3: lv_param_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeParameters9728);
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
            	    break loop70;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters9742); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4715:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4716:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4717:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9778);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9788); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4724:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4727:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4728:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4728:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4728:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4728:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4729:2: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleContainerInitializer9837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4741:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_NUMBER && LA72_0<=RULE_EXPONENT)||LA72_0==14||LA72_0==17||LA72_0==54||(LA72_0>=57 && LA72_0<=60)||(LA72_0>=65 && LA72_0<=67)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4741:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4741:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4742:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4742:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4743:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9859);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4759:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==20) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4759:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleContainerInitializer9872); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4763:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4764:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4764:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4765:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9893);
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
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer9909); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4793:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4794:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4795:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9945);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression9955); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4802:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4805:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4806:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4806:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_NUMBER && LA73_0<=RULE_EXPONENT)||LA73_0==14||LA73_0==54||(LA73_0>=57 && LA73_0<=60)||(LA73_0>=65 && LA73_0<=67)) ) {
                alt73=1;
            }
            else if ( (LA73_0==17) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4806:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4806:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4807:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4807:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4808:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10001);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4825:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4825:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4826:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4826:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4827:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10028);
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

    // $ANTLR start synpred15_InternalTemplateLang
    public final void synpred15_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_var_0_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:610:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:611:1: (lv_var_0_0= ruleVariableDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:611:1: (lv_var_0_0= ruleVariableDeclaration )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:612:3: lv_var_0_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred15_InternalTemplateLang1128);
        lv_var_0_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred15_InternalTemplateLang

    // $ANTLR start synpred18_InternalTemplateLang
    public final void synpred18_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_block_3_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:6: ( ( (lv_block_3_0= ruleStmtBlock ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:6: ( (lv_block_3_0= ruleStmtBlock ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:6: ( (lv_block_3_0= ruleStmtBlock ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:668:1: (lv_block_3_0= ruleStmtBlock )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:668:1: (lv_block_3_0= ruleStmtBlock )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:669:3: lv_block_3_0= ruleStmtBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmtBlock_in_synpred18_InternalTemplateLang1209);
        lv_block_3_0=ruleStmtBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred18_InternalTemplateLang

    // $ANTLR start synpred19_InternalTemplateLang
    public final void synpred19_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_multi_4_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:6: ( ( (lv_multi_4_0= rulemultiselect ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:6: ( (lv_multi_4_0= rulemultiselect ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:6: ( (lv_multi_4_0= rulemultiselect ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:1: (lv_multi_4_0= rulemultiselect )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:1: (lv_multi_4_0= rulemultiselect )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:688:3: lv_multi_4_0= rulemultiselect
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
          	    
        }
        pushFollow(FOLLOW_rulemultiselect_in_synpred19_InternalTemplateLang1236);
        lv_multi_4_0=rulemultiselect();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19_InternalTemplateLang

    // $ANTLR start synpred21_InternalTemplateLang
    public final void synpred21_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_exprStmt_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:6: ( ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:725:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:725:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:726:3: lv_exprStmt_6_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionStatement_in_synpred21_InternalTemplateLang1290);
        lv_exprStmt_6_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred21_InternalTemplateLang

    // $ANTLR start synpred23_InternalTemplateLang
    public final void synpred23_InternalTemplateLang_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:3: ( ( 'else' )=>otherlv_5= 'else' )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,25,FOLLOW_25_in_synpred23_InternalTemplateLang1487); if (state.failed) return ;

        }

        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:835:2: ( (lv_else_6_0= ruleStmt ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:836:1: (lv_else_6_0= ruleStmt )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:836:1: (lv_else_6_0= ruleStmt )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:837:3: lv_else_6_0= ruleStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmt_in_synpred23_InternalTemplateLang1509);
        lv_else_6_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred23_InternalTemplateLang

    // Delegated rules

    public final boolean synpred19_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA60 dfa60 = new DFA60(this);
    static final String DFA15_eotS =
        "\32\uffff";
    static final String DFA15_eofS =
        "\32\uffff";
    static final String DFA15_minS =
        "\1\4\1\uffff\3\0\5\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA15_maxS =
        "\1\106\1\uffff\3\0\5\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\6\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\12\uffff\1\10"+
        "\1\4";
    static final String DFA15_specialS =
        "\2\uffff\1\0\1\1\1\2\5\uffff\1\3\6\uffff\1\4\10\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\15\1\21\1\3\1\2\1\4\5\uffff\1\15\2\uffff\1\12\6\uffff\1"+
            "\10\1\uffff\1\30\1\uffff\1\11\2\uffff\1\14\1\13\5\uffff\1\1"+
            "\17\uffff\1\15\2\uffff\4\15\4\uffff\3\15\3\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "610:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred19_InternalTemplateLang()) ) {s = 11;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred19_InternalTemplateLang()) ) {s = 11;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred19_InternalTemplateLang()) ) {s = 11;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_10 = input.LA(1);

                         
                        int index15_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalTemplateLang()) ) {s = 25;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                         
                        input.seek(index15_10);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_17 = input.LA(1);

                         
                        int index15_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                        else if ( (true) ) {s = 24;}

                         
                        input.seek(index15_17);
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
    static final String DFA48_eotS =
        "\14\uffff";
    static final String DFA48_eofS =
        "\2\uffff\3\1\4\uffff\3\1";
    static final String DFA48_minS =
        "\1\4\1\uffff\3\16\2\uffff\1\6\1\uffff\3\16";
    static final String DFA48_maxS =
        "\1\103\1\uffff\3\100\2\uffff\1\10\1\uffff\3\100";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\3\uffff\1\3\1\4\1\uffff\1\2\3\uffff";
    static final String DFA48_specialS =
        "\14\uffff}>";
    static final String[] DFA48_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\1\54\uffff\1\5\1\6\4\uffff\3\1",
            "",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7",
            "",
            "",
            "\1\12\1\11\1\13",
            "",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7",
            "\1\10\1\1\1\uffff\2\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1"+
            "\6\uffff\1\1\4\uffff\5\1\1\uffff\11\1\4\uffff\3\1\1\7"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "3333:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA60_eotS =
        "\16\uffff";
    static final String DFA60_eofS =
        "\16\uffff";
    static final String DFA60_minS =
        "\1\4\3\6\2\uffff\1\6\1\4\3\6\3\16";
    static final String DFA60_maxS =
        "\1\106\3\100\2\uffff\1\10\1\103\6\100";
    static final String DFA60_acceptS =
        "\4\uffff\1\1\1\2\10\uffff";
    static final String DFA60_specialS =
        "\16\uffff}>";
    static final String[] DFA60_transitionS = {
            "\2\5\1\2\1\1\1\3\5\uffff\2\5\1\uffff\1\5\44\uffff\1\5\2\uffff"+
            "\4\5\4\uffff\3\5\3\4",
            "\3\4\5\uffff\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11"+
            "\uffff\1\5\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\6",
            "\3\4\5\uffff\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11"+
            "\uffff\1\5\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\6",
            "\3\4\5\uffff\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11"+
            "\uffff\1\5\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\6",
            "",
            "",
            "\1\11\1\10\1\12",
            "\2\5\1\14\1\13\1\15\5\uffff\1\5\2\uffff\1\5\44\uffff\1\5\2"+
            "\uffff\4\5\4\uffff\3\5",
            "\3\4\5\uffff\2\5\4\uffff\1\5\20\uffff\1\5\4\uffff\5\5\1\uffff"+
            "\11\5\4\uffff\2\5\1\uffff\1\6",
            "\3\4\5\uffff\2\5\4\uffff\1\5\20\uffff\1\5\4\uffff\5\5\1\uffff"+
            "\11\5\4\uffff\2\5\1\uffff\1\6",
            "\3\4\5\uffff\2\5\4\uffff\1\5\20\uffff\1\5\4\uffff\5\5\1\uffff"+
            "\11\5\4\uffff\2\5\1\uffff\1\6",
            "\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11\uffff\1\5"+
            "\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\5",
            "\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11\uffff\1\5"+
            "\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\5",
            "\2\5\4\uffff\1\7\1\5\1\uffff\1\4\3\uffff\1\4\11\uffff\1\5"+
            "\4\uffff\5\5\1\uffff\11\5\4\uffff\2\5\1\uffff\1\5"
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "3984:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000809000082000L});
    public static final BitSet FOLLOW_ruleExtension_in_ruleLanguageUnit159 = new BitSet(new long[]{0x0000009000082000L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit181 = new BitSet(new long[]{0x0000008000082000L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_ruleLanguageUnit203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLanguageUnit216 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit237 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit249 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit270 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit283 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit296 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit317 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit331 = new BitSet(new long[]{0x00000240004401C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit352 = new BitSet(new long[]{0x00000040004401C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleLanguageUnit374 = new BitSet(new long[]{0x00000040004401C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleVilDef_in_ruleLanguageUnit396 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_entryRuleIndentationHint445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHint455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIndentationHint492 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIndentationHint504 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint525 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleIndentationHint538 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint559 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleIndentationHint573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_entryRuleIndentationHintPart609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHintPart619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleIndentationHintPart665 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIndentationHintPart677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleIndentationHintPart694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVilDef_in_entryRuleVilDef735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVilDef745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVilDef782 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleType_in_ruleVilDef803 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVilDef825 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVilDef837 = new BitSet(new long[]{0x00000000000081C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleVilDef858 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVilDef871 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleVilDef892 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVilDef905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtBlock953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleStmtBlock1002 = new BitSet(new long[]{0x1E400041950641F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmtBlock1023 = new BitSet(new long[]{0x1E400041950641F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_18_in_ruleStmtBlock1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_entryRuleStmt1072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmt1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStmt1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_ruleStmt1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_ruleStmt1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleStmt1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_ruleStmt1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_ruleStmt1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleStmt1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_ruleStmt1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative1353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternative1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAlternative1400 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAlternative1412 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlternative1433 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAlternative1445 = new BitSet(new long[]{0x1E400041950241F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1466 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternative1487 = new BitSet(new long[]{0x1E400041950241F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent1547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleContent1600 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleContent1631 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleContent1649 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleContent1670 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleContent1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_entryRuleSwitch1720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitch1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleSwitch1767 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSwitch1779 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1800 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSwitch1812 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSwitch1824 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1846 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1859 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1880 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1895 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSwitch1907 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSwitch1919 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1940 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSwitch1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart1991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchPart2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2047 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSwitchPart2059 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop2116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleLoop2163 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoop2175 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleType_in_ruleLoop2196 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLoop2217 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLoop2229 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoop2250 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2263 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2284 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2297 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2318 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLoop2334 = new BitSet(new long[]{0x1E400041950241F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleLoop2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_entryRulemultiselect2391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiselect2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_rulemultiselect2447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_rulemultiselect2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegenericMultiselect2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulegenericMultiselect2557 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2578 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2599 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2620 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiSelectPart2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulemultiSelectPart2725 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_rulemultiSelectPart2746 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2767 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleuserMultiselect2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleuserMultiselect2880 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleuserMultiselect2892 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleuserMultiselect2904 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2925 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleuserMultiselect2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtension_in_entryRuleExtension2976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtension2986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleExtension3023 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_ruleExtension3044 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExtension3056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaQualifiedName3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3148 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleJavaQualifiedName3167 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3201 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3239 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration3292 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3327 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3348 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_21_in_ruleVariableDeclaration3361 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3382 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAdvice3479 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice3491 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice3512 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice3524 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleVersionSpec3629 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionSpec3641 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3662 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleVersionSpec3675 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleVersionedId_in_ruleVersionSpec3696 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleVersionSpec3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionedId_in_entryRuleVersionedId3746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionedId3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleVersionedId3793 = new BitSet(new long[]{0x00007C0000000000L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_ruleVersionedId3814 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionedId3831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionOperator_in_entryRuleVersionOperator3873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionOperator3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVersionOperator3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVersionOperator3941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleVersionOperator3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleVersionOperator3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleVersionOperator3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList4038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4094 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleParameterList4107 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4128 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4222 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleVersionStmt4326 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4343 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVersionStmt4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleImport4443 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4464 = new BitSet(new long[]{0x0000010000800000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4485 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleImport4498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement4544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4591 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleExpressionStatement4603 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement4626 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4849 = new BitSet(new long[]{0x0007000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4870 = new BitSet(new long[]{0x0007000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4963 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleLogicalOperator5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleLogicalOperator5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalOperator5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5204 = new BitSet(new long[]{0x0018040000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5318 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleEqualityOperator5425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleEqualityOperator5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleEqualityOperator5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5559 = new BitSet(new long[]{0x0000780000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5673 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5731 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRelationalOperator5780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRelationalOperator5799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelationalOperator5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelationalOperator5837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5933 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5954 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6047 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleAdditiveOperator6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAdditiveOperator6173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6269 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6383 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiplicativeOperator6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleMultiplicativeOperator6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6605 = new BitSet(new long[]{0x1E400000000041F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUnaryOperator6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUnaryOperator6732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleUnaryOperator6751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression7018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution7054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution7064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7111 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution7130 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7151 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution7163 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7186 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7279 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7300 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleSuperExecution7384 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSuperExecution7396 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7417 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7438 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleConstructorExecution7522 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7543 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution7555 = new BitSet(new long[]{0x1E4000000002C1F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7576 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution7589 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7610 = new BitSet(new long[]{0x6000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSubCall7703 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_61_in_ruleSubCall7732 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleSubCall7789 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7810 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleSubCall7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7915 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_23_in_ruleDeclarator7928 = new BitSet(new long[]{0x00000000000001C0L,0x0000000000000070L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7949 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_ruleDeclarator7963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration7999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration8009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration8055 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration8077 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration8090 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration8111 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall8149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall8159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8205 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall8217 = new BitSet(new long[]{0x1E4000000002C1F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8238 = new BitSet(new long[]{0x1E4000000002C1F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8260 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall8273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8365 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleArgumentList8378 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8399 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8494 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNamedArgument8506 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8621 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleQualifiedPrefix8640 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8674 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8768 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName8787 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConstant8996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConstant9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConstant9065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue9114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue9124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleType9435 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleType9495 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleType9555 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters9673 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9694 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTypeParameters9707 = new BitSet(new long[]{0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeParameters9728 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters9742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleContainerInitializer9837 = new BitSet(new long[]{0x1E400000000641F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9859 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleContainerInitializer9872 = new BitSet(new long[]{0x1E400000000241F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9893 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer9909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression9945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression9955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred15_InternalTemplateLang1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_synpred18_InternalTemplateLang1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_synpred19_InternalTemplateLang1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_synpred21_InternalTemplateLang1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred23_InternalTemplateLang1487 = new BitSet(new long[]{0x1E400041950241F0L,0x000000000000007EL});
    public static final BitSet FOLLOW_ruleStmt_in_synpred23_InternalTemplateLang1509 = new BitSet(new long[]{0x0000000000000002L});

}