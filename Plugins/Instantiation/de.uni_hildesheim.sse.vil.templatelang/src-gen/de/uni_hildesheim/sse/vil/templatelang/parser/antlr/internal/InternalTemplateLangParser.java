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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'template'", "'('", "')'", "'extends'", "'{'", "'}'", "'@indent'", "','", "'='", "'def'", "';'", "'if'", "'else'", "'print'", "'|'", "'switch'", "'default'", "':'", "'for'", "'multiSelect'", "'case'", "':='", "'generic-multiSelect'", "'extension'", "'.'", "'const'", "'typedef'", "'@advice'", "'with'", "'version'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
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
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:82:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_typeDefs_13_0= ruleTypeDef ) )* ( (lv_vars_14_0= ruleVariableDeclaration ) )* ( (lv_defs_15_0= ruleVilDef ) )* otherlv_16= '}' ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_16=null;
        EObject lv_imports_0_0 = null;

        EObject lv_javaExts_1_0 = null;

        EObject lv_advices_2_0 = null;

        EObject lv_indent_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_param_7_0 = null;

        AntlrDatatypeRuleToken lv_ext_10_0 = null;

        EObject lv_version_12_0 = null;

        EObject lv_typeDefs_13_0 = null;

        EObject lv_vars_14_0 = null;

        EObject lv_defs_15_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:85:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_typeDefs_13_0= ruleTypeDef ) )* ( (lv_vars_14_0= ruleVariableDeclaration ) )* ( (lv_defs_15_0= ruleVilDef ) )* otherlv_16= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_typeDefs_13_0= ruleTypeDef ) )* ( (lv_vars_14_0= ruleVariableDeclaration ) )* ( (lv_defs_15_0= ruleVilDef ) )* otherlv_16= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_typeDefs_13_0= ruleTypeDef ) )* ( (lv_vars_14_0= ruleVariableDeclaration ) )* ( (lv_defs_15_0= ruleVilDef ) )* otherlv_16= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? otherlv_4= 'template' ( (lv_name_5_0= ruleIdentifier ) ) otherlv_6= '(' ( (lv_param_7_0= ruleParameterList ) )? otherlv_8= ')' (otherlv_9= 'extends' ( (lv_ext_10_0= ruleIdentifier ) ) )? otherlv_11= '{' ( (lv_version_12_0= ruleVersionStmt ) )? ( (lv_typeDefs_13_0= ruleTypeDef ) )* ( (lv_vars_14_0= ruleVariableDeclaration ) )* ( (lv_defs_15_0= ruleVilDef ) )* otherlv_16= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:86:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==43) ) {
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

                if ( (LA3_0==40) ) {
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

            if ( ((LA5_0>=RULE_VERSION && LA5_0<=RULE_EXPONENT)||LA5_0==42||(LA5_0>=69 && LA5_0<=72)) ) {
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

            if ( (LA7_0==42) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_VERSION) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==23) ) {
                        int LA7_4 = input.LA(4);

                        if ( (synpred7_InternalTemplateLang()) ) {
                            alt7=1;
                        }
                    }
                }
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:250:3: ( (lv_typeDefs_13_0= ruleTypeDef ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==39) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:251:1: (lv_typeDefs_13_0= ruleTypeDef )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:251:1: (lv_typeDefs_13_0= ruleTypeDef )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:252:3: lv_typeDefs_13_0= ruleTypeDef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getTypeDefsTypeDefParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDef_in_ruleLanguageUnit374);
            	    lv_typeDefs_13_0=ruleTypeDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"typeDefs",
            	              		lv_typeDefs_13_0, 
            	              		"TypeDef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:268:3: ( (lv_vars_14_0= ruleVariableDeclaration ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_VERSION && LA9_0<=RULE_EXPONENT)||LA9_0==38||LA9_0==42||(LA9_0>=69 && LA9_0<=72)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:269:1: (lv_vars_14_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:269:1: (lv_vars_14_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:270:3: lv_vars_14_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVarsVariableDeclarationParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleLanguageUnit396);
            	    lv_vars_14_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"vars",
            	              		lv_vars_14_0, 
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:286:3: ( (lv_defs_15_0= ruleVilDef ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:287:1: (lv_defs_15_0= ruleVilDef )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:287:1: (lv_defs_15_0= ruleVilDef )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:288:3: lv_defs_15_0= ruleVilDef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getDefsVilDefParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVilDef_in_ruleLanguageUnit418);
            	    lv_defs_15_0=ruleVilDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"defs",
            	              		lv_defs_15_0, 
            	              		"VilDef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleLanguageUnit431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_15());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:316:1: entryRuleIndentationHint returns [EObject current=null] : iv_ruleIndentationHint= ruleIndentationHint EOF ;
    public final EObject entryRuleIndentationHint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHint = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:317:2: (iv_ruleIndentationHint= ruleIndentationHint EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:318:2: iv_ruleIndentationHint= ruleIndentationHint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintRule()); 
            }
            pushFollow(FOLLOW_ruleIndentationHint_in_entryRuleIndentationHint467);
            iv_ruleIndentationHint=ruleIndentationHint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndentationHint477); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:325:1: ruleIndentationHint returns [EObject current=null] : (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:328:28: ( (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:329:1: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:329:1: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:329:3: otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleIndentationHint514); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIndentationHintAccess().getIndentKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleIndentationHint526); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIndentationHintAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:337:1: ( (lv_parts_2_0= ruleIndentationHintPart ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:338:1: (lv_parts_2_0= ruleIndentationHintPart )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:338:1: (lv_parts_2_0= ruleIndentationHintPart )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:339:3: lv_parts_2_0= ruleIndentationHintPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint547);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:355:2: (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:355:4: otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleIndentationHint560); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getIndentationHintAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:359:1: ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:360:1: (lv_parts_4_0= ruleIndentationHintPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:360:1: (lv_parts_4_0= ruleIndentationHintPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:361:3: lv_parts_4_0= ruleIndentationHintPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint581);
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
            	    break loop11;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleIndentationHint595); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:389:1: entryRuleIndentationHintPart returns [EObject current=null] : iv_ruleIndentationHintPart= ruleIndentationHintPart EOF ;
    public final EObject entryRuleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHintPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:390:2: (iv_ruleIndentationHintPart= ruleIndentationHintPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:391:2: iv_ruleIndentationHintPart= ruleIndentationHintPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintPartRule()); 
            }
            pushFollow(FOLLOW_ruleIndentationHintPart_in_entryRuleIndentationHintPart631);
            iv_ruleIndentationHintPart=ruleIndentationHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHintPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndentationHintPart641); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:398:1: ruleIndentationHintPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:401:28: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:402:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:402:1: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:402:2: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:402:2: ( (lv_name_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:403:1: (lv_name_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:403:1: (lv_name_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:404:3: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIndentationHintPartAccess().getNameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleIndentationHintPart687);
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

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleIndentationHintPart699); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIndentationHintPartAccess().getEqualsSignKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:424:1: ( (lv_value_2_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:425:1: (lv_value_2_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:425:1: (lv_value_2_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:426:3: lv_value_2_0= RULE_NUMBER
            {
            lv_value_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleIndentationHintPart716); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:450:1: entryRuleVilDef returns [EObject current=null] : iv_ruleVilDef= ruleVilDef EOF ;
    public final EObject entryRuleVilDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVilDef = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:451:2: (iv_ruleVilDef= ruleVilDef EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:452:2: iv_ruleVilDef= ruleVilDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVilDefRule()); 
            }
            pushFollow(FOLLOW_ruleVilDef_in_entryRuleVilDef757);
            iv_ruleVilDef=ruleVilDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVilDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVilDef767); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:459:1: ruleVilDef returns [EObject current=null] : (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:462:28: ( (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:1: (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:1: (otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:3: otherlv_0= 'def' ( (lv_type_1_0= ruleType ) )? ( (lv_id_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_stmts_6_0= ruleStmtBlock ) ) (otherlv_7= ';' )?
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleVilDef804); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVilDefAccess().getDefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:467:1: ( (lv_type_1_0= ruleType ) )?
            int alt12=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA12_1 = input.LA(2);

                    if ( ((LA12_1>=RULE_VERSION && LA12_1<=RULE_EXPONENT)||LA12_1==42||LA12_1==65) ) {
                        alt12=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA12_2 = input.LA(2);

                    if ( ((LA12_2>=RULE_VERSION && LA12_2<=RULE_EXPONENT)||LA12_2==42||LA12_2==65) ) {
                        alt12=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA12_3 = input.LA(2);

                    if ( ((LA12_3>=RULE_VERSION && LA12_3<=RULE_EXPONENT)||LA12_3==42||LA12_3==65) ) {
                        alt12=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA12_4 = input.LA(2);

                    if ( ((LA12_4>=RULE_VERSION && LA12_4<=RULE_EXPONENT)||LA12_4==42||LA12_4==65) ) {
                        alt12=1;
                    }
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt12=1;
                    }
                    break;
            }

            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:468:1: (lv_type_1_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:468:1: (lv_type_1_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:469:3: lv_type_1_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getTypeTypeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleVilDef825);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:485:3: ( (lv_id_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:486:1: (lv_id_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:486:1: (lv_id_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:487:3: lv_id_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getIdIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVilDef847);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleVilDef859); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getVilDefAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:507:1: ( (lv_param_4_0= ruleParameterList ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_VERSION && LA13_0<=RULE_EXPONENT)||LA13_0==42||(LA13_0>=69 && LA13_0<=72)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:508:1: (lv_param_4_0= ruleParameterList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:508:1: (lv_param_4_0= ruleParameterList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:509:3: lv_param_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getParamParameterListParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameterList_in_ruleVilDef880);
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleVilDef893); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getVilDefAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:529:1: ( (lv_stmts_6_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:530:1: (lv_stmts_6_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:530:1: (lv_stmts_6_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:531:3: lv_stmts_6_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getStmtsStmtBlockParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleVilDef914);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:547:2: (otherlv_7= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:547:4: otherlv_7= ';'
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleVilDef927); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:559:1: entryRuleStmtBlock returns [EObject current=null] : iv_ruleStmtBlock= ruleStmtBlock EOF ;
    public final EObject entryRuleStmtBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmtBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:560:2: (iv_ruleStmtBlock= ruleStmtBlock EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:561:2: iv_ruleStmtBlock= ruleStmtBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtBlockRule()); 
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock965);
            iv_ruleStmtBlock=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtBlock975); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:568:1: ruleStmtBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) ;
    public final EObject ruleStmtBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stmts_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:571:28: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:572:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:572:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:572:2: () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:572:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:573:2: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleStmtBlock1024); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:585:1: ( (lv_stmts_2_0= ruleStmt ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_NUMBER && LA15_0<=RULE_EXPONENT)||LA15_0==14||LA15_0==17||LA15_0==24||LA15_0==26||LA15_0==28||(LA15_0>=31 && LA15_0<=32)||LA15_0==38||LA15_0==42||LA15_0==55||(LA15_0>=58 && LA15_0<=61)||(LA15_0>=66 && LA15_0<=72)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:586:1: (lv_stmts_2_0= ruleStmt )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:586:1: (lv_stmts_2_0= ruleStmt )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:587:3: lv_stmts_2_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStmtBlockAccess().getStmtsStmtParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStmt_in_ruleStmtBlock1045);
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
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleStmtBlock1058); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:615:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:616:2: (iv_ruleStmt= ruleStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:617:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_ruleStmt_in_entryRuleStmt1094);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmt1104); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:624:1: ruleStmt returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:627:28: ( ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            int alt16=8;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:1: (lv_var_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:1: (lv_var_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:630:3: lv_var_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStmt1150);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:647:6: ( (lv_alt_1_0= ruleAlternative ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:647:6: ( (lv_alt_1_0= ruleAlternative ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:648:1: (lv_alt_1_0= ruleAlternative )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:648:1: (lv_alt_1_0= ruleAlternative )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:649:3: lv_alt_1_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getAltAlternativeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAlternative_in_ruleStmt1177);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:666:6: ( (lv_switch_2_0= ruleSwitch ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:666:6: ( (lv_switch_2_0= ruleSwitch ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:1: (lv_switch_2_0= ruleSwitch )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:667:1: (lv_switch_2_0= ruleSwitch )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:668:3: lv_switch_2_0= ruleSwitch
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getSwitchSwitchParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSwitch_in_ruleStmt1204);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:685:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:685:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:1: (lv_block_3_0= ruleStmtBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:1: (lv_block_3_0= ruleStmtBlock )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:3: lv_block_3_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtBlock_in_ruleStmt1231);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:704:6: ( (lv_multi_4_0= rulemultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:704:6: ( (lv_multi_4_0= rulemultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:1: (lv_multi_4_0= rulemultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:1: (lv_multi_4_0= rulemultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:706:3: lv_multi_4_0= rulemultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulemultiselect_in_ruleStmt1258);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:723:6: ( (lv_loop_5_0= ruleLoop ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:723:6: ( (lv_loop_5_0= ruleLoop ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:1: (lv_loop_5_0= ruleLoop )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:724:1: (lv_loop_5_0= ruleLoop )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:725:3: lv_loop_5_0= ruleLoop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getLoopLoopParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLoop_in_ruleStmt1285);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:742:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:742:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:744:3: lv_exprStmt_6_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleStmt1312);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:761:6: ( (lv_ctn_7_0= ruleContent ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:761:6: ( (lv_ctn_7_0= ruleContent ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:762:1: (lv_ctn_7_0= ruleContent )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:762:1: (lv_ctn_7_0= ruleContent )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:763:3: lv_ctn_7_0= ruleContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getCtnContentParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContent_in_ruleStmt1339);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:787:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:788:2: (iv_ruleAlternative= ruleAlternative EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:789:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_ruleAlternative_in_entryRuleAlternative1375);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternative1385); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:796:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:799:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:800:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:800:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:800:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleAlternative1422); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAlternative1434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:808:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:809:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:809:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:810:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlternative1455);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAlternative1467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:830:1: ( (lv_if_4_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:831:1: (lv_if_4_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:831:1: (lv_if_4_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:832:3: lv_if_4_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStmtParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1488);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred24_InternalTemplateLang()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAlternative1509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:853:2: ( (lv_else_6_0= ruleStmt ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:854:1: (lv_else_6_0= ruleStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:854:1: (lv_else_6_0= ruleStmt )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:855:3: lv_else_6_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1531);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:879:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:880:2: (iv_ruleContent= ruleContent EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:881:2: iv_ruleContent= ruleContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContentRule()); 
            }
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent1569);
            iv_ruleContent=ruleContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent1579); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:888:1: ruleContent returns [EObject current=null] : ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token lv_print_0_0=null;
        Token lv_ctn_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_indent_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:891:28: ( ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:892:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:892:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:892:2: ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:892:2: ( (lv_print_0_0= 'print' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:893:1: (lv_print_0_0= 'print' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:893:1: (lv_print_0_0= 'print' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:894:3: lv_print_0_0= 'print'
                    {
                    lv_print_0_0=(Token)match(input,26,FOLLOW_26_in_ruleContent1622); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:3: ( (lv_ctn_1_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:908:1: (lv_ctn_1_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:908:1: (lv_ctn_1_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:909:3: lv_ctn_1_0= RULE_STRING
            {
            lv_ctn_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleContent1653); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:925:2: (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:925:4: otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';'
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleContent1671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContentAccess().getVerticalLineKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:929:1: ( (lv_indent_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:930:1: (lv_indent_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:930:1: (lv_indent_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:931:3: lv_indent_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContentAccess().getIndentExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleContent1692);
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

                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleContent1704); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:959:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:960:2: (iv_ruleSwitch= ruleSwitch EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:961:2: iv_ruleSwitch= ruleSwitch EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchRule()); 
            }
            pushFollow(FOLLOW_ruleSwitch_in_entryRuleSwitch1742);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitch; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitch1752); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:968:1: ruleSwitch returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:971:28: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:972:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:972:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:972:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleSwitch1789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchAccess().getSwitchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleSwitch1801); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:980:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:981:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:981:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:982:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1822);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleSwitch1834); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSwitchAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleSwitch1846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1006:1: ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1006:2: ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1006:2: ( (lv_parts_5_0= ruleSwitchPart ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1007:1: (lv_parts_5_0= ruleSwitchPart )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1007:1: (lv_parts_5_0= ruleSwitchPart )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1008:3: lv_parts_5_0= ruleSwitchPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1868);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1024:2: (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==20) ) {
                    int LA20_1 = input.LA(2);

                    if ( ((LA20_1>=RULE_NUMBER && LA20_1<=RULE_EXPONENT)||LA20_1==14||LA20_1==17||LA20_1==42||LA20_1==55||(LA20_1>=58 && LA20_1<=61)||(LA20_1>=66 && LA20_1<=68)) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1024:4: otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1881); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getCommaKeyword_5_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1028:1: ( (lv_parts_7_0= ruleSwitchPart ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1029:1: (lv_parts_7_0= ruleSwitchPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1029:1: (lv_parts_7_0= ruleSwitchPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1030:3: lv_parts_7_0= ruleSwitchPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1902);
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
            	    break loop20;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1046:4: (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1046:6: otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1917); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSwitchAccess().getCommaKeyword_5_2_0());
                          
                    }
                    otherlv_9=(Token)match(input,29,FOLLOW_29_in_ruleSwitch1929); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSwitchAccess().getDefaultKeyword_5_2_1());
                          
                    }
                    otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleSwitch1941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSwitchAccess().getColonKeyword_5_2_2());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1058:1: ( (lv_dflt_11_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1059:1: (lv_dflt_11_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1059:1: (lv_dflt_11_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1060:3: lv_dflt_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSwitchAccess().getDfltExpressionParserRuleCall_5_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1962);
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

            otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleSwitch1977); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1088:1: entryRuleSwitchPart returns [EObject current=null] : iv_ruleSwitchPart= ruleSwitchPart EOF ;
    public final EObject entryRuleSwitchPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1089:2: (iv_ruleSwitchPart= ruleSwitchPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1090:2: iv_ruleSwitchPart= ruleSwitchPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchPartRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart2013);
            iv_ruleSwitchPart=ruleSwitchPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchPart2023); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1097:1: ruleSwitchPart returns [EObject current=null] : ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1100:28: ( ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1101:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1101:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1101:2: ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1101:2: ( (lv_left_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1102:1: (lv_left_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1102:1: (lv_left_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1103:3: lv_left_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getLeftExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2069);
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

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleSwitchPart2081); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchPartAccess().getColonKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1123:1: ( (lv_right_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1124:1: (lv_right_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1124:1: (lv_right_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1125:3: lv_right_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getRightExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2102);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1149:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1150:2: (iv_ruleLoop= ruleLoop EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1151:2: iv_ruleLoop= ruleLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopRule()); 
            }
            pushFollow(FOLLOW_ruleLoop_in_entryRuleLoop2138);
            iv_ruleLoop=ruleLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop2148); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1158:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1161:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1162:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1162:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1162:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleLoop2185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleLoop2197); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1170:1: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1171:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1171:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1172:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLoop2218);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1188:2: ( (lv_id_3_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1189:1: (lv_id_3_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1189:1: (lv_id_3_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1190:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLoop2239);
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

            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleLoop2251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getColonKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1210:1: ( (lv_expr_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1211:1: (lv_expr_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1211:1: (lv_expr_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1212:3: lv_expr_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLoop2272);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1228:2: (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==20) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1228:4: otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleLoop2285); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getCommaKeyword_6_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1232:1: ( (lv_separator_7_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1233:1: (lv_separator_7_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1233:1: (lv_separator_7_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1234:3: lv_separator_7_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopAccess().getSeparatorPrimaryExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2306);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1250:2: (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==20) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1250:4: otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            {
                            otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleLoop2319); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getCommaKeyword_6_2_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1254:1: ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1255:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1255:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1256:3: lv_finalSeparator_9_0= rulePrimaryExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLoopAccess().getFinalSeparatorPrimaryExpressionParserRuleCall_6_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2340);
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

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleLoop2356); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getRightParenthesisKeyword_7());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1276:1: ( (lv_stmt_11_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1277:1: (lv_stmt_11_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1277:1: (lv_stmt_11_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1278:3: lv_stmt_11_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getStmtStmtParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleLoop2377);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1302:1: entryRulemultiselect returns [EObject current=null] : iv_rulemultiselect= rulemultiselect EOF ;
    public final EObject entryRulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1303:2: (iv_rulemultiselect= rulemultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1304:2: iv_rulemultiselect= rulemultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulemultiselect_in_entryRulemultiselect2413);
            iv_rulemultiselect=rulemultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiselect2423); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1311:1: rulemultiselect returns [EObject current=null] : ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) ;
    public final EObject rulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject lv_gen_0_0 = null;

        EObject lv_user_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1314:28: ( ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1315:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1315:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=RULE_VERSION && LA24_0<=RULE_EXPONENT)||LA24_0==42) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1315:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1315:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1316:1: (lv_gen_0_0= rulegenericMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1316:1: (lv_gen_0_0= rulegenericMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1317:3: lv_gen_0_0= rulegenericMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getGenGenericMultiselectParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulegenericMultiselect_in_rulemultiselect2469);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1334:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1334:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1335:1: (lv_user_1_0= ruleuserMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1335:1: (lv_user_1_0= ruleuserMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1336:3: lv_user_1_0= ruleuserMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getUserUserMultiselectParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleuserMultiselect_in_rulemultiselect2496);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1360:1: entryRulegenericMultiselect returns [EObject current=null] : iv_rulegenericMultiselect= rulegenericMultiselect EOF ;
    public final EObject entryRulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulegenericMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1361:2: (iv_rulegenericMultiselect= rulegenericMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1362:2: iv_rulegenericMultiselect= rulegenericMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2532);
            iv_rulegenericMultiselect=rulegenericMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegenericMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegenericMultiselect2542); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1369:1: rulegenericMultiselect returns [EObject current=null] : (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) ;
    public final EObject rulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_preamble_1_0 = null;

        EObject lv_selector_2_0 = null;

        EObject lv_part_3_0 = null;

        EObject lv_trailer_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1372:28: ( (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1373:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1373:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1373:3: otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_rulegenericMultiselect2579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGenericMultiselectAccess().getMultiSelectKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1377:1: ( (lv_preamble_1_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1378:1: (lv_preamble_1_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1378:1: (lv_preamble_1_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1379:3: lv_preamble_1_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPreambleStmtBlockParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2600);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1395:2: ( (lv_selector_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1396:1: (lv_selector_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1396:1: (lv_selector_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1397:3: lv_selector_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getSelectorStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2621);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1413:2: ( (lv_part_3_0= rulemultiSelectPart ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==33) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1414:1: (lv_part_3_0= rulemultiSelectPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1414:1: (lv_part_3_0= rulemultiSelectPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1415:3: lv_part_3_0= rulemultiSelectPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPartMultiSelectPartParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2642);
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
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1431:3: ( (lv_trailer_4_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1432:1: (lv_trailer_4_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1432:1: (lv_trailer_4_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1433:3: lv_trailer_4_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getTrailerStmtBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2664);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1457:1: entryRulemultiSelectPart returns [EObject current=null] : iv_rulemultiSelectPart= rulemultiSelectPart EOF ;
    public final EObject entryRulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiSelectPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1458:2: (iv_rulemultiSelectPart= rulemultiSelectPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1459:2: iv_rulemultiSelectPart= rulemultiSelectPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiSelectPartRule()); 
            }
            pushFollow(FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2700);
            iv_rulemultiSelectPart=rulemultiSelectPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiSelectPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiSelectPart2710); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1466:1: rulemultiSelectPart returns [EObject current=null] : (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) ;
    public final EObject rulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_case_1_0 = null;

        EObject lv_code_2_0 = null;

        EObject lv_selector_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1469:28: ( (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1470:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1470:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1470:3: otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_rulemultiSelectPart2747); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiSelectPartAccess().getCaseKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1474:1: ( (lv_case_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1475:1: (lv_case_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1475:1: (lv_case_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1476:3: lv_case_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCaseExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_rulemultiSelectPart2768);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1492:2: ( (lv_code_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1493:1: (lv_code_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1493:1: (lv_code_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1494:3: lv_code_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCodeStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2789);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1510:2: ( (lv_selector_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1511:1: (lv_selector_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1511:1: (lv_selector_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1512:3: lv_selector_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getSelectorStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2810);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1536:1: entryRuleuserMultiselect returns [EObject current=null] : iv_ruleuserMultiselect= ruleuserMultiselect EOF ;
    public final EObject entryRuleuserMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuserMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1537:2: (iv_ruleuserMultiselect= ruleuserMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1538:2: iv_ruleuserMultiselect= ruleuserMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUserMultiselectRule()); 
            }
            pushFollow(FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2846);
            iv_ruleuserMultiselect=ruleuserMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuserMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleuserMultiselect2856); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1545:1: ruleuserMultiselect returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleuserMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_stmt_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1548:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1549:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1549:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1549:2: ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1549:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1550:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1550:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1551:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleuserMultiselect2902);
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleuserMultiselect2914); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUserMultiselectAccess().getColonEqualsSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleuserMultiselect2926); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUserMultiselectAccess().getGenericMultiSelectKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1575:1: ( (lv_stmt_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1576:1: (lv_stmt_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1576:1: (lv_stmt_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1577:3: lv_stmt_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getStmtStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2947);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1593:2: (otherlv_4= ';' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==23) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1593:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleuserMultiselect2960); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1605:1: entryRuleExtension returns [EObject current=null] : iv_ruleExtension= ruleExtension EOF ;
    public final EObject entryRuleExtension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtension = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1606:2: (iv_ruleExtension= ruleExtension EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1607:2: iv_ruleExtension= ruleExtension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRule()); 
            }
            pushFollow(FOLLOW_ruleExtension_in_entryRuleExtension2998);
            iv_ruleExtension=ruleExtension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtension; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtension3008); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1614:1: ruleExtension returns [EObject current=null] : (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleExtension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1617:28: ( (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1618:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1618:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1618:3: otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleExtension3045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExtensionAccess().getExtensionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1622:1: ( (lv_name_1_0= ruleJavaQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1623:1: (lv_name_1_0= ruleJavaQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1623:1: (lv_name_1_0= ruleJavaQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1624:3: lv_name_1_0= ruleJavaQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExtensionAccess().getNameJavaQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_ruleExtension3066);
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

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleExtension3078); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1652:1: entryRuleJavaQualifiedName returns [EObject current=null] : iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF ;
    public final EObject entryRuleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1653:2: (iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1654:2: iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3114);
            iv_ruleJavaQualifiedName=ruleJavaQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaQualifiedName3124); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1661:1: ruleJavaQualifiedName returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1664:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1665:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1666:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1666:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1667:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3170);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1683:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==37) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1683:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1683:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1684:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1684:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1685:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleJavaQualifiedName3189); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1698:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1699:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1699:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1700:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3223);
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
    // $ANTLR end "ruleJavaQualifiedName"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1724:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1725:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1726:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3261);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3271); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1733:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1736:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1737:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1737:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1737:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1737:2: ( (lv_const_0_0= 'const' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==38) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1738:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1738:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1739:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,38,FOLLOW_38_in_ruleVariableDeclaration3314); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1754:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3349);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1770:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1771:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1771:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1772:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3370);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1788:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==21) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1788:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleVariableDeclaration3383); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1792:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1793:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1793:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1794:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3404);
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

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3418); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTypeDef"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1822:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1823:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1824:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDef_in_entryRuleTypeDef3454);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDef3464); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1831:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1834:28: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1835:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1835:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1835:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleTypeDef3501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1839:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1840:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1840:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1841:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeDef3522);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1857:2: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1858:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1858:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1859:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeDef3543);
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
                      		"Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleTypeDef3555); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1887:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1888:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1889:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3591);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3601); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1896:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1899:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1900:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1900:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1900:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleAdvice3638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAdvice3650); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1908:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1909:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1909:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1910:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice3671);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAdvice3683); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1930:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==41) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1931:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1931:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1932:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice3704);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1956:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1957:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1958:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3741);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec3751); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1965:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1968:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1969:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1969:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1969:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleVersionSpec3788); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1973:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1974:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1974:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1975:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec3809);
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


    // $ANTLR start "entryRuleParameterList"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1999:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2000:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2001:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList3845);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList3855); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2008:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2011:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2012:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2012:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2012:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2012:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2013:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2013:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2014:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList3901);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2030:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==20) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2030:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleParameterList3914); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2034:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2035:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2035:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2036:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList3935);
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
            	    break loop31;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2060:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2061:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2062:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter3973);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter3983); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2069:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2072:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2073:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2073:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2073:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2073:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2074:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2074:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4029);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2091:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2092:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2092:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2093:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4050);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2117:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2118:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2119:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4086);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4096); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2126:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2129:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2130:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2130:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2130:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleVersionStmt4133); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2134:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2135:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2135:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2136:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4150); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleVersionStmt4167); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2164:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2165:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2166:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4203);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4213); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2173:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2176:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2177:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2177:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2177:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleImport4250); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2181:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2182:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2182:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2183:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4271);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2199:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2200:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2200:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2201:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4292);
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

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleImport4305); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2229:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2230:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2231:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4341);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement4351); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2238:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        AntlrDatatypeRuleToken lv_field_2_0 = null;

        EObject lv_expr_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2241:28: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:3: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2242:3: ( (lv_var_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2243:1: (lv_var_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2243:1: (lv_var_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2244:3: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4398);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2260:2: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==37) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2260:4: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleExpressionStatement4411); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2264:1: ( (lv_field_2_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2265:1: (lv_field_2_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2265:1: (lv_field_2_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2266:3: lv_field_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4432);
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
                                      		"Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleExpressionStatement4446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2286:3: ( (lv_expr_4_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2287:1: (lv_expr_4_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2287:1: (lv_expr_4_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2288:3: lv_expr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement4469);
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
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement4481); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2316:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2317:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2318:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4517);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4527); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2325:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2328:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2329:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2329:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_NUMBER && LA35_0<=RULE_EXPONENT)||LA35_0==14||LA35_0==42||LA35_0==55||(LA35_0>=58 && LA35_0<=61)||(LA35_0>=66 && LA35_0<=68)) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2329:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2329:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2330:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2330:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2331:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4573);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2348:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2348:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2349:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2349:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2350:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4600);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2374:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2375:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2376:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4636);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4646); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2383:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2386:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2387:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2387:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2387:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2387:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2388:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2388:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2389:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4692);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2405:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=44 && LA36_0<=46)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2406:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2406:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2407:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4713);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2431:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2432:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2433:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4750);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart4760); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2440:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2443:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2444:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2444:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2444:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2444:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2445:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2445:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2446:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4806);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2462:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2463:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2463:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2464:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4827);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2488:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2489:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2490:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4864);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator4875); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2497:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2500:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2501:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2501:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt37=1;
                }
                break;
            case 45:
                {
                alt37=2;
                }
                break;
            case 46:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2502:2: kw= 'and'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleLogicalOperator4913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2509:2: kw= 'or'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleLogicalOperator4932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2516:2: kw= 'xor'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleLogicalOperator4951); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2529:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2530:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2531:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression4991);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5001); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2538:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2541:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2542:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2543:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2543:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2544:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5047);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2560:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=47 && LA38_0<=49)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2561:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2561:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2562:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5068);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2586:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2587:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2588:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5105);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5115); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2595:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2598:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2599:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2599:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2599:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2599:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2600:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2600:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2601:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5161);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2617:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2618:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2618:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2619:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5182);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2643:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2644:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2645:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5219);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5230); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2652:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2655:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2656:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2656:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt39=1;
                }
                break;
            case 48:
                {
                alt39=2;
                }
                break;
            case 49:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2657:2: kw= '=='
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleEqualityOperator5268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2664:2: kw= '<>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleEqualityOperator5287); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2671:2: kw= '!='
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleEqualityOperator5306); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2684:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2685:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2686:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5346);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5356); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2693:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2696:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2697:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2698:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2698:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2699:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5402);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2715:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=50 && LA40_0<=53)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2716:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2716:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2717:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5423);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2741:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2742:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2743:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5460);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5470); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2750:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2753:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2754:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2754:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2754:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2754:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2755:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2755:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2756:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5516);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2772:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2773:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2773:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2774:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5537);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2798:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2799:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2800:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5574);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5585); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2807:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2810:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2811:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2811:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt41=1;
                }
                break;
            case 51:
                {
                alt41=2;
                }
                break;
            case 52:
                {
                alt41=3;
                }
                break;
            case 53:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2812:2: kw= '>'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleRelationalOperator5623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2819:2: kw= '<'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleRelationalOperator5642); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2826:2: kw= '>='
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleRelationalOperator5661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2833:2: kw= '<='
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleRelationalOperator5680); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2846:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2847:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2848:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5720);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5730); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2855:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2858:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2859:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2859:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2859:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2859:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2860:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2860:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2861:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5776);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2877:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=54 && LA42_0<=55)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2878:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2878:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2879:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5797);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2903:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2904:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2905:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5834);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5844); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2912:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2915:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2916:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2916:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2916:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2916:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2917:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2917:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2918:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5890);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2934:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2935:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2935:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2936:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5911);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2960:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2961:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2962:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator5948);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator5959); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2969:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2972:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2973:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2973:1: (kw= '+' | kw= '-' )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==54) ) {
                alt43=1;
            }
            else if ( (LA43_0==55) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2974:2: kw= '+'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleAdditiveOperator5997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2981:2: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleAdditiveOperator6016); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2994:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2995:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2996:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6056);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6066); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3003:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3006:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3007:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3007:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3007:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3007:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3008:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3008:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3009:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6112);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3025:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=56 && LA44_0<=57)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3026:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3026:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3027:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6133);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3051:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3052:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3053:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6170);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6180); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3060:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3063:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3064:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3064:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3064:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3064:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3065:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3065:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3066:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6226);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3082:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3083:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3083:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3084:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6247);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3108:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3109:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3110:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6284);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6295); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3117:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3120:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3121:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3121:1: (kw= '*' | kw= '/' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            else if ( (LA45_0==57) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3122:2: kw= '*'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleMultiplicativeOperator6333); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3129:2: kw= '/'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleMultiplicativeOperator6352); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3142:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3143:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3144:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6392);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6402); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3151:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3154:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3155:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3155:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3155:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3155:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==55||(LA46_0>=58 && LA46_0<=59)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3156:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3156:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3157:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6448);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3173:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3174:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3174:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3175:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6470);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3199:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3200:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3201:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6507);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6518); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3208:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3211:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3212:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3212:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt47=1;
                }
                break;
            case 59:
                {
                alt47=2;
                }
                break;
            case 55:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3213:2: kw= 'not'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleUnaryOperator6556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3220:2: kw= '!'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleUnaryOperator6575); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3227:2: kw= '-'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleUnaryOperator6594); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3240:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3241:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3242:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6634);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6644); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3249:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3252:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3253:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3253:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3254:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3254:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3255:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6689);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3279:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3280:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3281:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6724);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression6734); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3288:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3291:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3292:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3292:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt48=4;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3292:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3292:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3293:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3293:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3294:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6780);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3311:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3311:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3312:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3312:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3313:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6807);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3330:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3330:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3331:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3331:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3332:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6834);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3349:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3349:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3350:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3350:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3351:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression6861);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3375:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3376:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3377:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6897);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6907); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3384:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3387:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=RULE_NUMBER && LA49_0<=RULE_EXPONENT)||LA49_0==42||(LA49_0>=66 && LA49_0<=68)) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3388:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3389:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3389:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3390:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6954);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3407:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3407:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3407:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution6973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3411:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3412:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3412:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3413:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6994);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution7006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3433:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==37||(LA50_0>=62 && LA50_0<=63)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3434:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3434:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3435:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7029);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3459:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3460:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3461:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7066);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7076); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3468:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3471:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3472:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3472:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3472:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3472:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3473:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3473:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3474:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7122);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3490:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==37||(LA51_0>=62 && LA51_0<=63)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3491:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3491:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3492:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7143);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3516:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3517:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3518:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7180);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7190); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3525:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3528:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3529:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3529:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3529:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleSuperExecution7227); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleSuperExecution7239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3537:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3538:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3538:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3539:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7260);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3555:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==37||(LA52_0>=62 && LA52_0<=63)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3556:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3556:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3557:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7281);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3581:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3582:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3583:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7318);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7328); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3590:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3593:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3594:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3594:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3594:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleConstructorExecution7365); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3598:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3599:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3599:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3600:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7386);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution7398); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3620:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_NUMBER && LA53_0<=RULE_EXPONENT)||LA53_0==14||LA53_0==17||LA53_0==42||LA53_0==55||(LA53_0>=58 && LA53_0<=61)||(LA53_0>=66 && LA53_0<=68)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3621:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3621:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3622:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7419);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution7432); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3642:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==37||(LA54_0>=62 && LA54_0<=63)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3643:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3643:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3644:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7453);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3668:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3669:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3670:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7490);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7500); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3677:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3680:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==37||LA56_0==62) ) {
                alt56=1;
            }
            else if ( (LA56_0==63) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3681:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3682:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3682:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3683:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3683:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==37) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==62) ) {
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3684:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,37,FOLLOW_37_in_ruleSubCall7546); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,62,FOLLOW_62_in_ruleSubCall7575); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3711:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3712:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3712:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3713:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7612);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3730:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3730:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3730:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleSubCall7632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3734:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3735:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3735:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3736:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7653);
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

                    otherlv_4=(Token)match(input,64,FOLLOW_64_in_ruleSubCall7665); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3764:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3765:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3766:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7702);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7712); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3773:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3776:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3777:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3777:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3777:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3777:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3778:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3778:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3779:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7758);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3795:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==23) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3795:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleDeclarator7771); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3799:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3800:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3800:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3801:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7792);
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

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleDeclarator7806); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3829:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3830:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3831:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration7842);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration7852); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3838:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3841:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3842:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3842:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3842:2: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3842:2: ( (lv_type_0_0= ruleType ) )?
            int alt58=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA58_1 = input.LA(2);

                    if ( ((LA58_1>=RULE_VERSION && LA58_1<=RULE_EXPONENT)||LA58_1==42||LA58_1==65) ) {
                        alt58=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA58_2 = input.LA(2);

                    if ( ((LA58_2>=RULE_VERSION && LA58_2<=RULE_EXPONENT)||LA58_2==42||LA58_2==65) ) {
                        alt58=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA58_3 = input.LA(2);

                    if ( ((LA58_3>=RULE_VERSION && LA58_3<=RULE_EXPONENT)||LA58_3==42||LA58_3==65) ) {
                        alt58=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA58_4 = input.LA(2);

                    if ( ((LA58_4>=RULE_VERSION && LA58_4<=RULE_EXPONENT)||LA58_4==42||LA58_4==65) ) {
                        alt58=1;
                    }
                    }
                    break;
                case 69:
                case 70:
                case 71:
                case 72:
                    {
                    alt58=1;
                    }
                    break;
            }

            switch (alt58) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3843:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3843:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3844:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration7898);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3860:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3861:1: (lv_units_1_0= ruleDeclarationUnit )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3861:1: (lv_units_1_0= ruleDeclarationUnit )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3862:3: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7920);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3878:2: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==20) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3878:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration7933); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3882:1: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:1: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3883:1: (lv_units_3_0= ruleDeclarationUnit )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3884:3: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7954);
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


    // $ANTLR start "entryRuleDeclarationUnit"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3908:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3909:2: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3910:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationUnitRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit7992);
            iv_ruleDeclarationUnit=ruleDeclarationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarationUnit8002); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3917:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3920:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3921:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3921:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3921:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3921:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3922:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3922:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3923:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclarationUnit8048);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3939:2: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==21) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3939:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclarationUnit8061); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3943:1: ( (lv_deflt_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3944:1: (lv_deflt_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3944:1: (lv_deflt_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3945:3: lv_deflt_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getDefltExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclarationUnit8082);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3969:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3970:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3971:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall8120);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall8130); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3978:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3981:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3982:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3982:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3982:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3982:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3983:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3983:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3984:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8176);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall8188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4004:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt61=2;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4005:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4005:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4006:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8209);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4022:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_NUMBER && LA62_0<=RULE_EXPONENT)||LA62_0==14||LA62_0==17||LA62_0==42||LA62_0==55||(LA62_0>=58 && LA62_0<=61)||(LA62_0>=66 && LA62_0<=68)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4023:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4023:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4024:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8231);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall8244); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4052:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4053:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4054:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8280);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8290); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4061:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4064:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4065:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4065:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4065:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4065:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4066:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4066:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4067:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8336);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4083:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==20) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4083:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleArgumentList8349); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4087:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4088:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4088:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4089:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8370);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4113:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4114:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4115:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8408);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8418); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4122:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4125:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt64=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA64_1 = input.LA(2);

                    if ( (LA64_1==21) ) {
                        alt64=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==21) ) {
                        alt64=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA64_3 = input.LA(2);

                    if ( (LA64_3==21) ) {
                        alt64=1;
                    }
                    }
                    break;
                case 42:
                    {
                    int LA64_4 = input.LA(2);

                    if ( (LA64_4==21) ) {
                        alt64=1;
                    }
                    }
                    break;
            }

            switch (alt64) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4126:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4127:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4127:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4128:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8465);
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

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleNamedArgument8477); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4148:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4149:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4149:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4150:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8500);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4174:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4175:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4176:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8536);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8546); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4183:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4186:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4187:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4187:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4187:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4187:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4188:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4188:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4189:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8592);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4205:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==65) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4205:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4205:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4206:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4206:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4207:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,65,FOLLOW_65_in_ruleQualifiedPrefix8611); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4220:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4221:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4221:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4222:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8645);
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
            	    break loop65;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4246:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4247:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4248:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8683);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8693); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4255:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4258:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4259:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4259:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4259:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4259:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4260:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4260:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4261:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8739);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4277:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==37) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA66_3 = input.LA(3);

                        if ( (LA66_3==EOF||LA66_3==13||LA66_3==15||(LA66_3>=17 && LA66_3<=20)||LA66_3==23||LA66_3==27||LA66_3==30||LA66_3==37||LA66_3==40||(LA66_3>=44 && LA66_3<=57)||(LA66_3>=62 && LA66_3<=64)) ) {
                            alt66=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA66_4 = input.LA(3);

                        if ( (LA66_4==EOF||LA66_4==13||LA66_4==15||(LA66_4>=17 && LA66_4<=20)||LA66_4==23||LA66_4==27||LA66_4==30||LA66_4==37||LA66_4==40||(LA66_4>=44 && LA66_4<=57)||(LA66_4>=62 && LA66_4<=64)) ) {
                            alt66=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA66_5 = input.LA(3);

                        if ( (LA66_5==EOF||LA66_5==13||LA66_5==15||(LA66_5>=17 && LA66_5<=20)||LA66_5==23||LA66_5==27||LA66_5==30||LA66_5==37||LA66_5==40||(LA66_5>=44 && LA66_5<=57)||(LA66_5>=62 && LA66_5<=64)) ) {
                            alt66=1;
                        }


                        }
                        break;
                    case 42:
                        {
                        int LA66_6 = input.LA(3);

                        if ( (LA66_6==EOF||LA66_6==13||LA66_6==15||(LA66_6>=17 && LA66_6<=20)||LA66_6==23||LA66_6==27||LA66_6==30||LA66_6==37||LA66_6==40||(LA66_6>=44 && LA66_6<=57)||(LA66_6>=62 && LA66_6<=64)) ) {
                            alt66=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt66) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4277:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4277:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4278:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4278:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4279:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName8758); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4292:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4293:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4293:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4294:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8792);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4318:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4319:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4320:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8830);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8840); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4327:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4330:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt68=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt68=1;
                }
                break;
            case RULE_STRING:
                {
                alt68=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 42:
                {
                alt68=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA68_4 = input.LA(2);

                if ( (synpred83_InternalTemplateLang()) ) {
                    alt68=3;
                }
                else if ( (synpred87_InternalTemplateLang()) ) {
                    alt68=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 4, input);

                    throw nvae;
                }
                }
                break;
            case 66:
            case 67:
                {
                alt68=4;
                }
                break;
            case 68:
                {
                alt68=5;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4331:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4332:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4332:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4333:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8886);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4350:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4350:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4351:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4351:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4352:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8909); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4371:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8941);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4388:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4388:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4389:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4389:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4390:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4390:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==66) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==67) ) {
                        alt67=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4391:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,66,FOLLOW_66_in_ruleConstant8967); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4403:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,67,FOLLOW_67_in_ruleConstant8996); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4419:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4419:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4420:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4420:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4421:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,68,FOLLOW_68_in_ruleConstant9036); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4441:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4442:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant9083); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4466:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4467:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4468:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue9124);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue9134); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4475:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4478:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4479:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4479:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4480:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4480:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4481:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9175); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4505:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4506:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4507:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9216);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9227); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4514:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4517:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt69=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt69=1;
                }
                break;
            case RULE_VERSION:
                {
                alt69=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt69=3;
                }
                break;
            case 42:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4518:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9267); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4526:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4534:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4543:2: kw= 'version'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleIdentifier9343); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4556:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4557:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4558:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9383);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9393); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4565:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4568:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4569:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4569:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt71=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 42:
                {
                alt71=1;
                }
                break;
            case 69:
                {
                alt71=2;
                }
                break;
            case 70:
                {
                alt71=3;
                }
                break;
            case 71:
                {
                alt71=4;
                }
                break;
            case 72:
                {
                alt71=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4569:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4569:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4570:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4570:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9439);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4588:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4588:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4588:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4588:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4589:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4589:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4590:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,69,FOLLOW_69_in_ruleType9464); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4603:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4604:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4604:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9498);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4622:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4622:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4622:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4622:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4623:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4623:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4624:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,70,FOLLOW_70_in_ruleType9524); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4637:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4638:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4638:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4639:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9558);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4656:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4656:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4656:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4656:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4657:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4657:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4658:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,71,FOLLOW_71_in_ruleType9584); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4671:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4672:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4672:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4673:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9618);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4690:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4690:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4690:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4690:7: ( (lv_call_7_0= 'callOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4691:1: (lv_call_7_0= 'callOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4691:1: (lv_call_7_0= 'callOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4692:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,72,FOLLOW_72_in_ruleType9644); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4705:2: ( (lv_return_8_0= ruleType ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=RULE_VERSION && LA70_0<=RULE_EXPONENT)||LA70_0==42||(LA70_0>=69 && LA70_0<=72)) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4706:1: (lv_return_8_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4706:1: (lv_return_8_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4707:3: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleType9678);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4723:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4724:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4724:1: (lv_param_9_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4725:3: lv_param_9_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9700);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4749:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4750:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4751:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9737);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9747); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4758:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4761:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4762:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4762:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4762:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters9784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4766:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4767:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4767:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4768:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9805);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4784:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==20) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4784:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTypeParameters9818); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4788:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4789:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4789:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4790:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9839);
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
            	    break loop72;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters9853); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4818:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4819:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4820:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9889);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9899); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4827:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4830:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4831:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4831:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4831:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4831:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4832:2: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleContainerInitializer9948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4844:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=RULE_NUMBER && LA74_0<=RULE_EXPONENT)||LA74_0==14||LA74_0==17||LA74_0==42||LA74_0==55||(LA74_0>=58 && LA74_0<=61)||(LA74_0>=66 && LA74_0<=68)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4844:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4844:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4845:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4845:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4846:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9970);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4862:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==20) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4862:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleContainerInitializer9983); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4866:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4867:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4867:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4868:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10004);
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
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer10020); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4896:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4897:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4898:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10056);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression10066); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4905:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4908:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4909:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4909:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_NUMBER && LA75_0<=RULE_EXPONENT)||LA75_0==14||LA75_0==42||LA75_0==55||(LA75_0>=58 && LA75_0<=61)||(LA75_0>=66 && LA75_0<=68)) ) {
                alt75=1;
            }
            else if ( (LA75_0==17) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4909:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4909:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4910:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4910:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4911:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10112);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4928:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4928:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4929:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4929:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4930:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10139);
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

    // $ANTLR start synpred7_InternalTemplateLang
    public final void synpred7_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_version_12_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:233:1: ( (lv_version_12_0= ruleVersionStmt ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:233:1: (lv_version_12_0= ruleVersionStmt )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:233:1: (lv_version_12_0= ruleVersionStmt )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:234:3: lv_version_12_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_11_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVersionStmt_in_synpred7_InternalTemplateLang352);
        lv_version_12_0=ruleVersionStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalTemplateLang

    // $ANTLR start synpred16_InternalTemplateLang
    public final void synpred16_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_var_0_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:628:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:1: (lv_var_0_0= ruleVariableDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:629:1: (lv_var_0_0= ruleVariableDeclaration )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:630:3: lv_var_0_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred16_InternalTemplateLang1150);
        lv_var_0_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred16_InternalTemplateLang

    // $ANTLR start synpred19_InternalTemplateLang
    public final void synpred19_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_block_3_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:685:6: ( ( (lv_block_3_0= ruleStmtBlock ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:685:6: ( (lv_block_3_0= ruleStmtBlock ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:685:6: ( (lv_block_3_0= ruleStmtBlock ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:1: (lv_block_3_0= ruleStmtBlock )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:686:1: (lv_block_3_0= ruleStmtBlock )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:687:3: lv_block_3_0= ruleStmtBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmtBlock_in_synpred19_InternalTemplateLang1231);
        lv_block_3_0=ruleStmtBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred19_InternalTemplateLang

    // $ANTLR start synpred20_InternalTemplateLang
    public final void synpred20_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_multi_4_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:704:6: ( ( (lv_multi_4_0= rulemultiselect ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:704:6: ( (lv_multi_4_0= rulemultiselect ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:704:6: ( (lv_multi_4_0= rulemultiselect ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:1: (lv_multi_4_0= rulemultiselect )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:705:1: (lv_multi_4_0= rulemultiselect )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:706:3: lv_multi_4_0= rulemultiselect
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
          	    
        }
        pushFollow(FOLLOW_rulemultiselect_in_synpred20_InternalTemplateLang1258);
        lv_multi_4_0=rulemultiselect();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred20_InternalTemplateLang

    // $ANTLR start synpred22_InternalTemplateLang
    public final void synpred22_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_exprStmt_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:742:6: ( ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:742:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:742:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:743:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:744:3: lv_exprStmt_6_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionStatement_in_synpred22_InternalTemplateLang1312);
        lv_exprStmt_6_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred22_InternalTemplateLang

    // $ANTLR start synpred24_InternalTemplateLang
    public final void synpred24_InternalTemplateLang_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:3: ( ( 'else' )=>otherlv_5= 'else' )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:848:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,25,FOLLOW_25_in_synpred24_InternalTemplateLang1509); if (state.failed) return ;

        }

        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:853:2: ( (lv_else_6_0= ruleStmt ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:854:1: (lv_else_6_0= ruleStmt )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:854:1: (lv_else_6_0= ruleStmt )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:855:3: lv_else_6_0= ruleStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmt_in_synpred24_InternalTemplateLang1531);
        lv_else_6_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalTemplateLang

    // $ANTLR start synpred75_InternalTemplateLang
    public final void synpred75_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4005:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4005:1: (lv_decl_2_0= ruleDeclarator )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4005:1: (lv_decl_2_0= ruleDeclarator )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4006:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDeclarator_in_synpred75_InternalTemplateLang8209);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred75_InternalTemplateLang

    // $ANTLR start synpred83_InternalTemplateLang
    public final void synpred83_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4369:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4370:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4371:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred83_InternalTemplateLang8941);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred83_InternalTemplateLang

    // $ANTLR start synpred87_InternalTemplateLang
    public final void synpred87_InternalTemplateLang_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4436:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4436:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4437:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred87_InternalTemplateLang9069); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred87_InternalTemplateLang

    // Delegated rules

    public final boolean synpred16_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred75_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred75_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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
    public final boolean synpred7_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA61 dfa61 = new DFA61(this);
    static final String DFA16_eotS =
        "\34\uffff";
    static final String DFA16_eofS =
        "\34\uffff";
    static final String DFA16_minS =
        "\1\4\1\uffff\4\0\6\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA16_maxS =
        "\1\110\1\uffff\4\0\6\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\12\uffff\1\10"+
        "\1\4";
    static final String DFA16_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\6\uffff\1\4\6\uffff\1\5\10\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\17\1\23\1\3\1\2\1\4\5\uffff\1\17\2\uffff\1\14\6\uffff\1"+
            "\12\1\uffff\1\32\1\uffff\1\13\2\uffff\1\16\1\15\5\uffff\1\1"+
            "\3\uffff\1\5\14\uffff\1\17\2\uffff\4\17\4\uffff\3\17\4\1",
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

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "628:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_2 = input.LA(1);

                         
                        int index16_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred20_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index16_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_3 = input.LA(1);

                         
                        int index16_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred20_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index16_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA16_4 = input.LA(1);

                         
                        int index16_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred20_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index16_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA16_5 = input.LA(1);

                         
                        int index16_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred20_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index16_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA16_12 = input.LA(1);

                         
                        int index16_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalTemplateLang()) ) {s = 27;}

                        else if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index16_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA16_19 = input.LA(1);

                         
                        int index16_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalTemplateLang()) ) {s = 15;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index16_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\14\uffff";
    static final String DFA34_eofS =
        "\14\uffff";
    static final String DFA34_minS =
        "\1\4\4\16\1\uffff\1\6\1\uffff\4\16";
    static final String DFA34_maxS =
        "\1\104\4\101\1\uffff\1\52\1\uffff\4\101";
    static final String DFA34_acceptS =
        "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA34_specialS =
        "\14\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\2\uffff\1\5\30\uffff\1\4\14\uffff"+
            "\1\5\2\uffff\4\5\4\uffff\3\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "",
            "\1\11\1\10\1\12\41\uffff\1\13",
            "",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\1\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5"
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "2242:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA48_eotS =
        "\16\uffff";
    static final String DFA48_eofS =
        "\2\uffff\4\1\4\uffff\4\1";
    static final String DFA48_minS =
        "\1\4\1\uffff\4\15\2\uffff\1\6\1\uffff\4\15";
    static final String DFA48_maxS =
        "\1\104\1\uffff\4\101\2\uffff\1\52\1\uffff\4\101";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\uffff\1\2\4\uffff";
    static final String DFA48_specialS =
        "\16\uffff}>";
    static final String[] DFA48_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\1\33\uffff\1\5\21\uffff\1\6\1\7"+
            "\4\uffff\3\1",
            "",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "",
            "",
            "\1\13\1\12\1\14\41\uffff\1\15",
            "",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\2\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10"
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
            return "3292:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA61_eotS =
        "\26\uffff";
    static final String DFA61_eofS =
        "\26\uffff";
    static final String DFA61_minS =
        "\1\4\4\0\21\uffff";
    static final String DFA61_maxS =
        "\1\110\4\0\21\uffff";
    static final String DFA61_acceptS =
        "\5\uffff\1\1\3\uffff\1\2\14\uffff";
    static final String DFA61_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\21\uffff}>";
    static final String[] DFA61_transitionS = {
            "\2\11\1\2\1\1\1\3\5\uffff\2\11\1\uffff\1\11\30\uffff\1\4\14"+
            "\uffff\1\11\2\uffff\4\11\4\uffff\3\11\4\5",
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

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "4004:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
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
                        if ( (synpred75_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index61_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA61_2 = input.LA(1);

                         
                        int index61_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index61_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA61_3 = input.LA(1);

                         
                        int index61_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index61_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA61_4 = input.LA(1);

                         
                        int index61_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred75_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index61_4);
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
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000091000082000L});
    public static final BitSet FOLLOW_ruleExtension_in_ruleLanguageUnit159 = new BitSet(new long[]{0x0000011000082000L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit181 = new BitSet(new long[]{0x0000010000082000L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_ruleLanguageUnit203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLanguageUnit216 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit237 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit249 = new BitSet(new long[]{0x00000400000081C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit270 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit283 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit296 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit317 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit331 = new BitSet(new long[]{0x000004C0004401C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit352 = new BitSet(new long[]{0x000004C0004401C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleTypeDef_in_ruleLanguageUnit374 = new BitSet(new long[]{0x000004C0004401C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleLanguageUnit396 = new BitSet(new long[]{0x00000440004401C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleVilDef_in_ruleLanguageUnit418 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_entryRuleIndentationHint467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHint477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIndentationHint514 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIndentationHint526 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint547 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleIndentationHint560 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint581 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleIndentationHint595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_entryRuleIndentationHintPart631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHintPart641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleIndentationHintPart687 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIndentationHintPart699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleIndentationHintPart716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVilDef_in_entryRuleVilDef757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVilDef767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVilDef804 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVilDef825 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVilDef847 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVilDef859 = new BitSet(new long[]{0x00000400000081C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleVilDef880 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVilDef893 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleVilDef914 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleVilDef927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtBlock975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleStmtBlock1024 = new BitSet(new long[]{0x3C800441950641F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmtBlock1045 = new BitSet(new long[]{0x3C800441950641F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_18_in_ruleStmtBlock1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_entryRuleStmt1094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmt1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStmt1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_ruleStmt1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_ruleStmt1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleStmt1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_ruleStmt1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_ruleStmt1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleStmt1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_ruleStmt1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative1375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternative1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAlternative1422 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAlternative1434 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlternative1455 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAlternative1467 = new BitSet(new long[]{0x3C800441950241F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1488 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternative1509 = new BitSet(new long[]{0x3C800441950241F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent1569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleContent1622 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleContent1653 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleContent1671 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleContent1692 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleContent1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_entryRuleSwitch1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitch1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleSwitch1789 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSwitch1801 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1822 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSwitch1834 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSwitch1846 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1868 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1881 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1902 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1917 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSwitch1929 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSwitch1941 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1962 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSwitch1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart2013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchPart2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2069 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSwitchPart2081 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop2138 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop2148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleLoop2185 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoop2197 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLoop2218 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLoop2239 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLoop2251 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoop2272 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2285 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2306 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2319 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2340 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLoop2356 = new BitSet(new long[]{0x3C800441950241F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleStmt_in_ruleLoop2377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_entryRulemultiselect2413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiselect2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_rulemultiselect2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_rulemultiselect2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegenericMultiselect2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rulegenericMultiselect2579 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2600 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2621 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2642 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiSelectPart2710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulemultiSelectPart2747 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_rulemultiSelectPart2768 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2789 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleuserMultiselect2856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleuserMultiselect2902 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleuserMultiselect2914 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleuserMultiselect2926 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2947 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleuserMultiselect2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtension_in_entryRuleExtension2998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtension3008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleExtension3045 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_ruleExtension3066 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExtension3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaQualifiedName3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3170 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleJavaQualifiedName3189 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3223 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleVariableDeclaration3314 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3349 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3370 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_21_in_ruleVariableDeclaration3383 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3404 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDef_in_entryRuleTypeDef3454 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDef3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleTypeDef3501 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeDef3522 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeDef3543 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTypeDef3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleAdvice3638 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice3650 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice3671 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice3683 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec3751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleVersionSpec3788 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList3845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList3855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList3901 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleParameterList3914 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList3935 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter3973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter3983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4029 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVersionStmt4133 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4150 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVersionStmt4167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleImport4250 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4271 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4292 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleImport4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4398 = new BitSet(new long[]{0x0000002000200000L});
    public static final BitSet FOLLOW_37_in_ruleExpressionStatement4411 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4432 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleExpressionStatement4446 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement4469 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4692 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4713 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4806 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLogicalOperator4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLogicalOperator4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLogicalOperator4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression4991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5047 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5161 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEqualityOperator5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEqualityOperator5287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEqualityOperator5306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5402 = new BitSet(new long[]{0x003C000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5516 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator5623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalOperator5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleRelationalOperator5661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleRelationalOperator5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5776 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5797 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5890 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator5948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAdditiveOperator5997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAdditiveOperator6016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6112 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6226 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleMultiplicativeOperator6333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleMultiplicativeOperator6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6448 = new BitSet(new long[]{0x3C800400000041F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUnaryOperator6556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUnaryOperator6575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnaryOperator6594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression6734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression6861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6954 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution6973 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution6994 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution7006 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7029 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7066 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7122 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7143 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSuperExecution7227 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleSuperExecution7239 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7260 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7281 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleConstructorExecution7365 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7386 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution7398 = new BitSet(new long[]{0x3C8004000002C1F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7419 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution7432 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7453 = new BitSet(new long[]{0xC000002000000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7490 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSubCall7546 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_62_in_ruleSubCall7575 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleSubCall7632 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleSubCall7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7758 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_23_in_ruleDeclarator7771 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7792 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_ruleDeclarator7806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration7842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration7898 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7920 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration7933 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7954 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit7992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarationUnit8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclarationUnit8048 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleDeclarationUnit8061 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclarationUnit8082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall8120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall8130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8176 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall8188 = new BitSet(new long[]{0x3C8004000002C1F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8209 = new BitSet(new long[]{0x3C8004000002C1F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8231 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall8244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8336 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleArgumentList8349 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8370 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8465 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNamedArgument8477 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8592 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleQualifiedPrefix8611 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8645 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8739 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName8758 = new BitSet(new long[]{0x00000400000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8792 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConstant8967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConstant8996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleConstant9036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant9083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue9124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue9134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleIdentifier9343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleType9464 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleType9524 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleType9584 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleType9644 = new BitSet(new long[]{0x00000400000041C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleType9678 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters9784 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9805 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTypeParameters9818 = new BitSet(new long[]{0x00000400000001C0L,0x00000000000001E0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9839 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters9853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleContainerInitializer9948 = new BitSet(new long[]{0x3C800400000641F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer9970 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleContainerInitializer9983 = new BitSet(new long[]{0x3C800400000241F0L,0x000000000000001CL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10004 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer10020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression10066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred7_InternalTemplateLang352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred16_InternalTemplateLang1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_synpred19_InternalTemplateLang1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_synpred20_InternalTemplateLang1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_synpred22_InternalTemplateLang1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_synpred24_InternalTemplateLang1509 = new BitSet(new long[]{0x3C800441950241F0L,0x00000000000001FCL});
    public static final BitSet FOLLOW_ruleStmt_in_synpred24_InternalTemplateLang1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_synpred75_InternalTemplateLang8209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred83_InternalTemplateLang8941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred87_InternalTemplateLang9069 = new BitSet(new long[]{0x0000000000000002L});

}