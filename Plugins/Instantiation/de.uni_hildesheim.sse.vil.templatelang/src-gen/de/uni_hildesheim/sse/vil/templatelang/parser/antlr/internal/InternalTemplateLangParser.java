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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'template'", "'('", "')'", "'extends'", "'{'", "'}'", "'@indent'", "','", "'='", "'protected'", "'def'", "';'", "'if'", "'else'", "'print'", "'|'", "'switch'", "'default'", "':'", "'for'", "'multiSelect'", "'case'", "':='", "'generic-multiSelect'", "'extension'", "'.'", "'const'", "'typedef'", "'@advice'", "'with'", "'version'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    public static final int T__73=73;
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

                if ( (LA1_0==44) ) {
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

                if ( (LA2_0==37) ) {
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

                if ( (LA3_0==41) ) {
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

            if ( ((LA5_0>=RULE_VERSION && LA5_0<=RULE_EXPONENT)||LA5_0==43||(LA5_0>=70 && LA5_0<=73)) ) {
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

            if ( (LA7_0==43) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_VERSION) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==24) ) {
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

                if ( (LA8_0==40) ) {
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

                if ( ((LA9_0>=RULE_VERSION && LA9_0<=RULE_EXPONENT)||LA9_0==39||LA9_0==43||(LA9_0>=70 && LA9_0<=73)) ) {
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

                if ( ((LA10_0>=22 && LA10_0<=23)) ) {
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:459:1: ruleVilDef returns [EObject current=null] : ( ( (lv_protected_0_0= 'protected' ) )? otherlv_1= 'def' ( (lv_type_2_0= ruleType ) )? ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleParameterList ) )? otherlv_6= ')' ( (lv_stmts_7_0= ruleStmtBlock ) ) (otherlv_8= ';' )? ) ;
    public final EObject ruleVilDef() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;

        EObject lv_param_5_0 = null;

        EObject lv_stmts_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:462:28: ( ( ( (lv_protected_0_0= 'protected' ) )? otherlv_1= 'def' ( (lv_type_2_0= ruleType ) )? ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleParameterList ) )? otherlv_6= ')' ( (lv_stmts_7_0= ruleStmtBlock ) ) (otherlv_8= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:1: ( ( (lv_protected_0_0= 'protected' ) )? otherlv_1= 'def' ( (lv_type_2_0= ruleType ) )? ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleParameterList ) )? otherlv_6= ')' ( (lv_stmts_7_0= ruleStmtBlock ) ) (otherlv_8= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:1: ( ( (lv_protected_0_0= 'protected' ) )? otherlv_1= 'def' ( (lv_type_2_0= ruleType ) )? ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleParameterList ) )? otherlv_6= ')' ( (lv_stmts_7_0= ruleStmtBlock ) ) (otherlv_8= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:2: ( (lv_protected_0_0= 'protected' ) )? otherlv_1= 'def' ( (lv_type_2_0= ruleType ) )? ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_param_5_0= ruleParameterList ) )? otherlv_6= ')' ( (lv_stmts_7_0= ruleStmtBlock ) ) (otherlv_8= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:463:2: ( (lv_protected_0_0= 'protected' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:464:1: (lv_protected_0_0= 'protected' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:464:1: (lv_protected_0_0= 'protected' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:465:3: lv_protected_0_0= 'protected'
                    {
                    lv_protected_0_0=(Token)match(input,22,FOLLOW_22_in_ruleVilDef810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_protected_0_0, grammarAccess.getVilDefAccess().getProtectedProtectedKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getVilDefRule());
                      	        }
                             		setWithLastConsumed(current, "protected", lv_protected_0_0, "protected");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleVilDef836); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVilDefAccess().getDefKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:482:1: ( (lv_type_2_0= ruleType ) )?
            int alt13=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA13_1 = input.LA(2);

                    if ( ((LA13_1>=RULE_VERSION && LA13_1<=RULE_EXPONENT)||LA13_1==43||LA13_1==66) ) {
                        alt13=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA13_2 = input.LA(2);

                    if ( ((LA13_2>=RULE_VERSION && LA13_2<=RULE_EXPONENT)||LA13_2==43||LA13_2==66) ) {
                        alt13=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA13_3 = input.LA(2);

                    if ( ((LA13_3>=RULE_VERSION && LA13_3<=RULE_EXPONENT)||LA13_3==43||LA13_3==66) ) {
                        alt13=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA13_4 = input.LA(2);

                    if ( ((LA13_4>=RULE_VERSION && LA13_4<=RULE_EXPONENT)||LA13_4==43||LA13_4==66) ) {
                        alt13=1;
                    }
                    }
                    break;
                case 70:
                case 71:
                case 72:
                case 73:
                    {
                    alt13=1;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:483:1: (lv_type_2_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:483:1: (lv_type_2_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:484:3: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getTypeTypeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleVilDef857);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVilDefRule());
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
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:500:3: ( (lv_id_3_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:501:1: (lv_id_3_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:501:1: (lv_id_3_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:502:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVilDef879);
            lv_id_3_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVilDefRule());
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleVilDef891); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getVilDefAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:522:1: ( (lv_param_5_0= ruleParameterList ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_VERSION && LA14_0<=RULE_EXPONENT)||LA14_0==43||(LA14_0>=70 && LA14_0<=73)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:523:1: (lv_param_5_0= ruleParameterList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:523:1: (lv_param_5_0= ruleParameterList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:524:3: lv_param_5_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVilDefAccess().getParamParameterListParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameterList_in_ruleVilDef912);
                    lv_param_5_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVilDefRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_5_0, 
                              		"ParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleVilDef925); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getVilDefAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:544:1: ( (lv_stmts_7_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:545:1: (lv_stmts_7_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:545:1: (lv_stmts_7_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:546:3: lv_stmts_7_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVilDefAccess().getStmtsStmtBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleVilDef946);
            lv_stmts_7_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVilDefRule());
              	        }
                     		set(
                     			current, 
                     			"stmts",
                      		lv_stmts_7_0, 
                      		"StmtBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:562:2: (otherlv_8= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:562:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleVilDef959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getVilDefAccess().getSemicolonKeyword_8());
                          
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:574:1: entryRuleStmtBlock returns [EObject current=null] : iv_ruleStmtBlock= ruleStmtBlock EOF ;
    public final EObject entryRuleStmtBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmtBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:575:2: (iv_ruleStmtBlock= ruleStmtBlock EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:576:2: iv_ruleStmtBlock= ruleStmtBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtBlockRule()); 
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock997);
            iv_ruleStmtBlock=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmtBlock1007); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:583:1: ruleStmtBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) ;
    public final EObject ruleStmtBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stmts_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:586:28: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:587:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:587:1: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:587:2: () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:587:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:588:2: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleStmtBlock1056); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStmtBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:600:1: ( (lv_stmts_2_0= ruleStmt ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_NUMBER && LA16_0<=RULE_EXPONENT)||LA16_0==14||LA16_0==17||LA16_0==25||LA16_0==27||LA16_0==29||(LA16_0>=32 && LA16_0<=33)||LA16_0==39||LA16_0==43||LA16_0==56||(LA16_0>=59 && LA16_0<=62)||(LA16_0>=67 && LA16_0<=73)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:601:1: (lv_stmts_2_0= ruleStmt )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:601:1: (lv_stmts_2_0= ruleStmt )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:602:3: lv_stmts_2_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStmtBlockAccess().getStmtsStmtParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStmt_in_ruleStmtBlock1077);
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
            	    break loop16;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleStmtBlock1090); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:630:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:631:2: (iv_ruleStmt= ruleStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:632:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_ruleStmt_in_entryRuleStmt1126);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStmt1136); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:639:1: ruleStmt returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:642:28: ( ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )
            int alt17=8;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:644:1: (lv_var_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:644:1: (lv_var_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:645:3: lv_var_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleStmt1182);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:662:6: ( (lv_alt_1_0= ruleAlternative ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:662:6: ( (lv_alt_1_0= ruleAlternative ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:663:1: (lv_alt_1_0= ruleAlternative )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:663:1: (lv_alt_1_0= ruleAlternative )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:664:3: lv_alt_1_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getAltAlternativeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAlternative_in_ruleStmt1209);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:681:6: ( (lv_switch_2_0= ruleSwitch ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:681:6: ( (lv_switch_2_0= ruleSwitch ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:682:1: (lv_switch_2_0= ruleSwitch )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:682:1: (lv_switch_2_0= ruleSwitch )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:683:3: lv_switch_2_0= ruleSwitch
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getSwitchSwitchParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSwitch_in_ruleStmt1236);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:700:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:700:6: ( (lv_block_3_0= ruleStmtBlock ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:701:1: (lv_block_3_0= ruleStmtBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:701:1: (lv_block_3_0= ruleStmtBlock )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:702:3: lv_block_3_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmtBlock_in_ruleStmt1263);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:719:6: ( (lv_multi_4_0= rulemultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:719:6: ( (lv_multi_4_0= rulemultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:720:1: (lv_multi_4_0= rulemultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:720:1: (lv_multi_4_0= rulemultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:721:3: lv_multi_4_0= rulemultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulemultiselect_in_ruleStmt1290);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:738:6: ( (lv_loop_5_0= ruleLoop ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:738:6: ( (lv_loop_5_0= ruleLoop ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:739:1: (lv_loop_5_0= ruleLoop )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:739:1: (lv_loop_5_0= ruleLoop )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:740:3: lv_loop_5_0= ruleLoop
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getLoopLoopParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLoop_in_ruleStmt1317);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:757:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:757:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:758:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:758:1: (lv_exprStmt_6_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:759:3: lv_exprStmt_6_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleStmt1344);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:776:6: ( (lv_ctn_7_0= ruleContent ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:776:6: ( (lv_ctn_7_0= ruleContent ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:777:1: (lv_ctn_7_0= ruleContent )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:777:1: (lv_ctn_7_0= ruleContent )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:778:3: lv_ctn_7_0= ruleContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStmtAccess().getCtnContentParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContent_in_ruleStmt1371);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:802:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:803:2: (iv_ruleAlternative= ruleAlternative EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:804:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_ruleAlternative_in_entryRuleAlternative1407);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternative1417); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:811:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:814:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:815:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:815:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:815:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStmt ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleAlternative1454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAlternative1466); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:823:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:824:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:824:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:825:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlternative1487);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAlternative1499); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:845:1: ( (lv_if_4_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:846:1: (lv_if_4_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:846:1: (lv_if_4_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:847:3: lv_if_4_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStmtParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1520);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred25_InternalTemplateLang()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleAlternative1541); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:868:2: ( (lv_else_6_0= ruleStmt ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:869:1: (lv_else_6_0= ruleStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:869:1: (lv_else_6_0= ruleStmt )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:870:3: lv_else_6_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStmt_in_ruleAlternative1563);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:894:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:895:2: (iv_ruleContent= ruleContent EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:896:2: iv_ruleContent= ruleContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContentRule()); 
            }
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent1601);
            iv_ruleContent=ruleContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent1611); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:903:1: ruleContent returns [EObject current=null] : ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token lv_print_0_0=null;
        Token lv_ctn_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_indent_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:906:28: ( ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:1: ( ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:2: ( (lv_print_0_0= 'print' ) )? ( (lv_ctn_1_0= RULE_STRING ) ) (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:907:2: ( (lv_print_0_0= 'print' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:908:1: (lv_print_0_0= 'print' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:908:1: (lv_print_0_0= 'print' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:909:3: lv_print_0_0= 'print'
                    {
                    lv_print_0_0=(Token)match(input,27,FOLLOW_27_in_ruleContent1654); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:922:3: ( (lv_ctn_1_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:923:1: (lv_ctn_1_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:923:1: (lv_ctn_1_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:924:3: lv_ctn_1_0= RULE_STRING
            {
            lv_ctn_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleContent1685); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:940:2: (otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:940:4: otherlv_2= '|' ( (lv_indent_3_0= ruleExpression ) ) otherlv_4= ';'
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleContent1703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContentAccess().getVerticalLineKeyword_2_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:944:1: ( (lv_indent_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:945:1: (lv_indent_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:945:1: (lv_indent_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:946:3: lv_indent_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContentAccess().getIndentExpressionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleContent1724);
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

                    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleContent1736); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:974:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:975:2: (iv_ruleSwitch= ruleSwitch EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:976:2: iv_ruleSwitch= ruleSwitch EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchRule()); 
            }
            pushFollow(FOLLOW_ruleSwitch_in_entryRuleSwitch1774);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitch; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitch1784); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:983:1: ruleSwitch returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:986:28: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:987:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:987:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:987:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleSwitch1821); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchAccess().getSwitchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleSwitch1833); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:995:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:996:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:996:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:997:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1854);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleSwitch1866); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSwitchAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleSwitch1878); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1021:1: ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1021:2: ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1021:2: ( (lv_parts_5_0= ruleSwitchPart ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1022:1: (lv_parts_5_0= ruleSwitchPart )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1022:1: (lv_parts_5_0= ruleSwitchPart )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1023:3: lv_parts_5_0= ruleSwitchPart
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1900);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1039:2: (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==20) ) {
                    int LA21_1 = input.LA(2);

                    if ( ((LA21_1>=RULE_NUMBER && LA21_1<=RULE_EXPONENT)||LA21_1==14||LA21_1==17||LA21_1==43||LA21_1==56||(LA21_1>=59 && LA21_1<=62)||(LA21_1>=67 && LA21_1<=69)) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1039:4: otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1913); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getCommaKeyword_5_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1043:1: ( (lv_parts_7_0= ruleSwitchPart ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1044:1: (lv_parts_7_0= ruleSwitchPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1044:1: (lv_parts_7_0= ruleSwitchPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1045:3: lv_parts_7_0= ruleSwitchPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSwitchPart_in_ruleSwitch1934);
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
            	    break loop21;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1061:4: (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1061:6: otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleSwitch1949); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSwitchAccess().getCommaKeyword_5_2_0());
                          
                    }
                    otherlv_9=(Token)match(input,30,FOLLOW_30_in_ruleSwitch1961); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSwitchAccess().getDefaultKeyword_5_2_1());
                          
                    }
                    otherlv_10=(Token)match(input,31,FOLLOW_31_in_ruleSwitch1973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSwitchAccess().getColonKeyword_5_2_2());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1073:1: ( (lv_dflt_11_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1074:1: (lv_dflt_11_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1074:1: (lv_dflt_11_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1075:3: lv_dflt_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSwitchAccess().getDfltExpressionParserRuleCall_5_2_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSwitch1994);
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

            otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleSwitch2009); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1103:1: entryRuleSwitchPart returns [EObject current=null] : iv_ruleSwitchPart= ruleSwitchPart EOF ;
    public final EObject entryRuleSwitchPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1104:2: (iv_ruleSwitchPart= ruleSwitchPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1105:2: iv_ruleSwitchPart= ruleSwitchPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchPartRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart2045);
            iv_ruleSwitchPart=ruleSwitchPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchPart2055); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1112:1: ruleSwitchPart returns [EObject current=null] : ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1115:28: ( ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1116:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1116:1: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1116:2: ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1116:2: ( (lv_left_0_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1117:1: (lv_left_0_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1117:1: (lv_left_0_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1118:3: lv_left_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getLeftExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2101);
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

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleSwitchPart2113); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchPartAccess().getColonKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1138:1: ( (lv_right_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1139:1: (lv_right_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1139:1: (lv_right_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1140:3: lv_right_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchPartAccess().getRightExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchPart2134);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1164:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1165:2: (iv_ruleLoop= ruleLoop EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1166:2: iv_ruleLoop= ruleLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopRule()); 
            }
            pushFollow(FOLLOW_ruleLoop_in_entryRuleLoop2170);
            iv_ruleLoop=ruleLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoop; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoop2180); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1173:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1176:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1177:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1177:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1177:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( (lv_stmt_11_0= ruleStmt ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleLoop2217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleLoop2229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1185:1: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1186:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1186:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1187:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleLoop2250);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1203:2: ( (lv_id_3_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1204:1: (lv_id_3_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1204:1: (lv_id_3_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1205:3: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getIdIdentifierParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLoop2271);
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

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleLoop2283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getColonKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1225:1: ( (lv_expr_5_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1226:1: (lv_expr_5_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1226:1: (lv_expr_5_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1227:3: lv_expr_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLoop2304);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1243:2: (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==20) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1243:4: otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleLoop2317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getCommaKeyword_6_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1247:1: ( (lv_separator_7_0= rulePrimaryExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1248:1: (lv_separator_7_0= rulePrimaryExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1248:1: (lv_separator_7_0= rulePrimaryExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1249:3: lv_separator_7_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopAccess().getSeparatorPrimaryExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2338);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1265:2: (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==20) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1265:4: otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            {
                            otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleLoop2351); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getCommaKeyword_6_2_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1269:1: ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1270:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1270:1: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1271:3: lv_finalSeparator_9_0= rulePrimaryExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getLoopAccess().getFinalSeparatorPrimaryExpressionParserRuleCall_6_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleLoop2372);
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

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleLoop2388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getRightParenthesisKeyword_7());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1291:1: ( (lv_stmt_11_0= ruleStmt ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1292:1: (lv_stmt_11_0= ruleStmt )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1292:1: (lv_stmt_11_0= ruleStmt )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1293:3: lv_stmt_11_0= ruleStmt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopAccess().getStmtStmtParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmt_in_ruleLoop2409);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1317:1: entryRulemultiselect returns [EObject current=null] : iv_rulemultiselect= rulemultiselect EOF ;
    public final EObject entryRulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1318:2: (iv_rulemultiselect= rulemultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1319:2: iv_rulemultiselect= rulemultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulemultiselect_in_entryRulemultiselect2445);
            iv_rulemultiselect=rulemultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiselect2455); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1326:1: rulemultiselect returns [EObject current=null] : ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) ;
    public final EObject rulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject lv_gen_0_0 = null;

        EObject lv_user_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1329:28: ( ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1330:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1330:1: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=RULE_VERSION && LA25_0<=RULE_EXPONENT)||LA25_0==43) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1330:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1330:2: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1331:1: (lv_gen_0_0= rulegenericMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1331:1: (lv_gen_0_0= rulegenericMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1332:3: lv_gen_0_0= rulegenericMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getGenGenericMultiselectParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulegenericMultiselect_in_rulemultiselect2501);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1349:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1349:6: ( (lv_user_1_0= ruleuserMultiselect ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1350:1: (lv_user_1_0= ruleuserMultiselect )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1350:1: (lv_user_1_0= ruleuserMultiselect )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1351:3: lv_user_1_0= ruleuserMultiselect
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiselectAccess().getUserUserMultiselectParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleuserMultiselect_in_rulemultiselect2528);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1375:1: entryRulegenericMultiselect returns [EObject current=null] : iv_rulegenericMultiselect= rulegenericMultiselect EOF ;
    public final EObject entryRulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulegenericMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1376:2: (iv_rulegenericMultiselect= rulegenericMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1377:2: iv_rulegenericMultiselect= rulegenericMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericMultiselectRule()); 
            }
            pushFollow(FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2564);
            iv_rulegenericMultiselect=rulegenericMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegenericMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegenericMultiselect2574); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1384:1: rulegenericMultiselect returns [EObject current=null] : (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) ;
    public final EObject rulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_preamble_1_0 = null;

        EObject lv_selector_2_0 = null;

        EObject lv_part_3_0 = null;

        EObject lv_trailer_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1387:28: ( (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1388:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1388:1: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1388:3: otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_rulegenericMultiselect2611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGenericMultiselectAccess().getMultiSelectKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1392:1: ( (lv_preamble_1_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1393:1: (lv_preamble_1_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1393:1: (lv_preamble_1_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1394:3: lv_preamble_1_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPreambleStmtBlockParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2632);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1410:2: ( (lv_selector_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1411:1: (lv_selector_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1411:1: (lv_selector_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1412:3: lv_selector_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getSelectorStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2653);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1428:2: ( (lv_part_3_0= rulemultiSelectPart ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==34) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1429:1: (lv_part_3_0= rulemultiSelectPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1429:1: (lv_part_3_0= rulemultiSelectPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1430:3: lv_part_3_0= rulemultiSelectPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPartMultiSelectPartParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2674);
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
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1446:3: ( (lv_trailer_4_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1447:1: (lv_trailer_4_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1447:1: (lv_trailer_4_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1448:3: lv_trailer_4_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGenericMultiselectAccess().getTrailerStmtBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2696);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1472:1: entryRulemultiSelectPart returns [EObject current=null] : iv_rulemultiSelectPart= rulemultiSelectPart EOF ;
    public final EObject entryRulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiSelectPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1473:2: (iv_rulemultiSelectPart= rulemultiSelectPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1474:2: iv_rulemultiSelectPart= rulemultiSelectPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiSelectPartRule()); 
            }
            pushFollow(FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2732);
            iv_rulemultiSelectPart=rulemultiSelectPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiSelectPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulemultiSelectPart2742); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1481:1: rulemultiSelectPart returns [EObject current=null] : (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) ;
    public final EObject rulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_case_1_0 = null;

        EObject lv_code_2_0 = null;

        EObject lv_selector_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1484:28: ( (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1485:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1485:1: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1485:3: otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_rulemultiSelectPart2779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiSelectPartAccess().getCaseKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1489:1: ( (lv_case_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1490:1: (lv_case_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1490:1: (lv_case_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1491:3: lv_case_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCaseExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_rulemultiSelectPart2800);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1507:2: ( (lv_code_2_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1508:1: (lv_code_2_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1508:1: (lv_code_2_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1509:3: lv_code_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCodeStmtBlockParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2821);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1525:2: ( (lv_selector_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1526:1: (lv_selector_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1526:1: (lv_selector_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1527:3: lv_selector_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiSelectPartAccess().getSelectorStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2842);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1551:1: entryRuleuserMultiselect returns [EObject current=null] : iv_ruleuserMultiselect= ruleuserMultiselect EOF ;
    public final EObject entryRuleuserMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuserMultiselect = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1552:2: (iv_ruleuserMultiselect= ruleuserMultiselect EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1553:2: iv_ruleuserMultiselect= ruleuserMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUserMultiselectRule()); 
            }
            pushFollow(FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2878);
            iv_ruleuserMultiselect=ruleuserMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuserMultiselect; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleuserMultiselect2888); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1560:1: ruleuserMultiselect returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleuserMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_stmt_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1563:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1564:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1564:1: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1564:2: ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1564:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1565:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1565:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1566:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleuserMultiselect2934);
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

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleuserMultiselect2946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUserMultiselectAccess().getColonEqualsSignKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleuserMultiselect2958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUserMultiselectAccess().getGenericMultiSelectKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1590:1: ( (lv_stmt_3_0= ruleStmtBlock ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1591:1: (lv_stmt_3_0= ruleStmtBlock )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1591:1: (lv_stmt_3_0= ruleStmtBlock )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1592:3: lv_stmt_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserMultiselectAccess().getStmtStmtBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2979);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1608:2: (otherlv_4= ';' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==24) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1608:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleuserMultiselect2992); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1620:1: entryRuleExtension returns [EObject current=null] : iv_ruleExtension= ruleExtension EOF ;
    public final EObject entryRuleExtension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtension = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1621:2: (iv_ruleExtension= ruleExtension EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1622:2: iv_ruleExtension= ruleExtension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRule()); 
            }
            pushFollow(FOLLOW_ruleExtension_in_entryRuleExtension3030);
            iv_ruleExtension=ruleExtension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtension; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtension3040); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1629:1: ruleExtension returns [EObject current=null] : (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleExtension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1632:28: ( (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1633:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1633:1: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1633:3: otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleExtension3077); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getExtensionAccess().getExtensionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1637:1: ( (lv_name_1_0= ruleJavaQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1638:1: (lv_name_1_0= ruleJavaQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1638:1: (lv_name_1_0= ruleJavaQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1639:3: lv_name_1_0= ruleJavaQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExtensionAccess().getNameJavaQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_ruleExtension3098);
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleExtension3110); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1667:1: entryRuleJavaQualifiedName returns [EObject current=null] : iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF ;
    public final EObject entryRuleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1668:2: (iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1669:2: iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3146);
            iv_ruleJavaQualifiedName=ruleJavaQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaQualifiedName3156); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1676:1: ruleJavaQualifiedName returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1679:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1680:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1680:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1680:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1680:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1681:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1681:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1682:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3202);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1698:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==38) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1698:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1698:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1699:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1699:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1700:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,38,FOLLOW_38_in_ruleJavaQualifiedName3221); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1713:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1714:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1714:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1715:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3255);
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
            	    break loop28;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1739:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1740:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1741:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3293);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3303); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1748:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1751:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1752:2: ( (lv_const_0_0= 'const' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==39) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1753:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1754:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,39,FOLLOW_39_in_ruleVariableDeclaration3346); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1767:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1768:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1768:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1769:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3381);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1785:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1786:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1786:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1787:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3402);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1803:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==21) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1803:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleVariableDeclaration3415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1807:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1808:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1808:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1809:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3436);
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

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleVariableDeclaration3450); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1837:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1838:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1839:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDef_in_entryRuleTypeDef3486);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDef3496); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1846:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1849:28: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1850:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1850:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1850:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleTypeDef3533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1854:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1855:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1855:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1856:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeDef3554);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1872:2: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1873:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1873:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1874:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeDef3575);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleTypeDef3587); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1902:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1903:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1904:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice3623);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice3633); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1911:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1914:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1915:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1915:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1915:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleAdvice3670); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleAdvice3682); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1923:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1924:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1924:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1925:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice3703);
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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleAdvice3715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1945:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==42) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1946:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1946:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1947:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice3736);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1971:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1972:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1973:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3773);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec3783); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1980:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1983:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1984:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1984:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1984:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleVersionSpec3820); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1988:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1989:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1989:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:1990:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec3841);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2014:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2015:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2016:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList3877);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList3887); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2023:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2026:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2027:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2027:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2027:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2027:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2028:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2028:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2029:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList3933);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2045:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==20) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2045:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleParameterList3946); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2049:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2050:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2050:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2051:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList3967);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2075:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2076:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2077:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4005);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4015); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2084:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2087:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2088:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2088:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2088:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2088:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2089:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2089:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2090:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4061);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2106:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2107:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2107:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2108:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4082);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2132:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2133:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2134:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4118);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4128); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2141:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2144:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2145:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2145:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2145:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleVersionStmt4165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2149:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2150:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2150:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2151:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4182); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleVersionStmt4199); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2179:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2180:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2181:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4235);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4245); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2188:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2191:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2192:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2192:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2192:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleImport4282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2196:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2197:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2197:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2198:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4303);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2214:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==42) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2215:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2215:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2216:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4324);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleImport4337); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2244:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2245:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2246:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4373);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement4383); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2253:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2256:28: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:1: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:3: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2257:3: ( (lv_var_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2258:1: (lv_var_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2258:1: (lv_var_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2259:3: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4430);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2275:2: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==38) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2275:4: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleExpressionStatement4443); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2279:1: ( (lv_field_2_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2280:1: (lv_field_2_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2280:1: (lv_field_2_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2281:3: lv_field_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement4464);
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

                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleExpressionStatement4478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2301:3: ( (lv_expr_4_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2302:1: (lv_expr_4_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2302:1: (lv_expr_4_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2303:3: lv_expr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement4501);
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

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleExpressionStatement4513); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2331:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2332:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2333:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4549);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4559); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2340:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2343:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2344:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2344:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_NUMBER && LA36_0<=RULE_EXPONENT)||LA36_0==14||LA36_0==43||LA36_0==56||(LA36_0>=59 && LA36_0<=62)||(LA36_0>=67 && LA36_0<=69)) ) {
                alt36=1;
            }
            else if ( (LA36_0==17) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2344:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2344:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2345:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2345:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2346:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4605);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2363:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2363:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2364:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2364:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2365:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4632);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2389:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2390:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2391:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4668);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression4678); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2398:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2401:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2402:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2402:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2402:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2402:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2403:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2403:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2404:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4724);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2420:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=45 && LA37_0<=47)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2421:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2421:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2422:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4745);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2446:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2447:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2448:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4782);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart4792); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2455:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2458:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2459:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2459:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2459:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2459:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2460:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2460:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2461:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4838);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2477:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2478:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2478:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2479:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4859);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2503:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2504:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2505:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4896);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator4907); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2512:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2515:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2516:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2516:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt38=1;
                }
                break;
            case 46:
                {
                alt38=2;
                }
                break;
            case 47:
                {
                alt38=3;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2517:2: kw= 'and'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleLogicalOperator4945); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2524:2: kw= 'or'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleLogicalOperator4964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2531:2: kw= 'xor'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleLogicalOperator4983); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2544:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2545:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2546:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5023);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5033); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2553:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2556:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2557:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2557:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2557:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2557:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2558:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2558:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2559:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5079);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2575:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=48 && LA39_0<=50)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2576:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2576:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2577:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5100);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2601:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2602:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2603:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5137);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5147); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2610:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2613:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2614:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2614:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2614:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2614:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2615:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2615:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2616:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5193);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2632:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2633:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2633:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2634:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5214);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2658:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2659:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2660:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5251);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5262); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2667:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2670:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2671:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2671:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 48:
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
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2672:2: kw= '=='
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleEqualityOperator5300); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2679:2: kw= '<>'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleEqualityOperator5319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2686:2: kw= '!='
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleEqualityOperator5338); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2699:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2700:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2701:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5378);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5388); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2708:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2711:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2712:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2712:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2712:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2712:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2713:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2713:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2714:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5434);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2730:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=51 && LA41_0<=54)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2731:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2731:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2732:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5455);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2756:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2757:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2758:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5492);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5502); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2765:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2768:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2769:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2769:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2769:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2769:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2770:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2770:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2771:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5548);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2787:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2788:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2788:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2789:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5569);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2813:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2814:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2815:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5606);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5617); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2822:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2825:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2826:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2826:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt42=1;
                }
                break;
            case 52:
                {
                alt42=2;
                }
                break;
            case 53:
                {
                alt42=3;
                }
                break;
            case 54:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2827:2: kw= '>'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleRelationalOperator5655); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2834:2: kw= '<'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleRelationalOperator5674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2841:2: kw= '>='
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleRelationalOperator5693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2848:2: kw= '<='
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleRelationalOperator5712); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2861:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2862:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2863:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5752);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression5762); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2870:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2873:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2874:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2874:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2874:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2874:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2875:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2875:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2876:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5808);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2892:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=55 && LA43_0<=56)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2893:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2893:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2894:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5829);
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
            	    break loop43;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2918:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2919:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2920:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5866);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5876); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2927:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2930:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2931:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2931:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2931:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2931:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2932:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2932:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2933:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5922);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2949:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2950:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2950:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2951:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5943);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2975:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2976:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2977:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator5980);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator5991); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2984:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2987:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2988:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2988:1: (kw= '+' | kw= '-' )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==55) ) {
                alt44=1;
            }
            else if ( (LA44_0==56) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2989:2: kw= '+'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleAdditiveOperator6029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:2996:2: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleAdditiveOperator6048); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3009:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3010:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3011:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6088);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6098); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3018:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3021:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3022:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3022:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3022:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3022:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3023:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3023:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3024:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6144);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3040:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=57 && LA45_0<=58)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3041:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3041:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3042:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6165);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3066:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3067:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3068:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6202);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6212); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3075:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3078:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3079:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3079:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3079:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3079:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3080:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3080:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3081:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6258);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3097:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3098:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3098:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3099:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6279);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3123:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3124:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3125:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6316);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6327); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3132:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3135:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3136:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3136:1: (kw= '*' | kw= '/' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==57) ) {
                alt46=1;
            }
            else if ( (LA46_0==58) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3137:2: kw= '*'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleMultiplicativeOperator6365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3144:2: kw= '/'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleMultiplicativeOperator6384); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3157:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3158:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3159:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6424);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6434); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3166:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3169:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3170:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3170:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3170:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3170:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==56||(LA47_0>=59 && LA47_0<=60)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3171:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3171:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3172:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6480);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3188:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3189:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3189:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3190:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6502);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3214:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3215:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3216:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6539);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6550); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3223:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3226:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3227:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3227:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt48=1;
                }
                break;
            case 60:
                {
                alt48=2;
                }
                break;
            case 56:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3228:2: kw= 'not'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleUnaryOperator6588); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3235:2: kw= '!'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleUnaryOperator6607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3242:2: kw= '-'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleUnaryOperator6626); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3255:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3256:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3257:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6666);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression6676); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3264:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3267:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3268:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3268:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3269:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3269:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3270:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6721);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3294:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3295:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3296:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6756);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression6766); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3303:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3306:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3307:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3307:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt49=4;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3307:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3307:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3308:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3308:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3309:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6812);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3326:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3326:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3327:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3327:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3328:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6839);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3345:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3345:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3346:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3346:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3347:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6866);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3364:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3364:6: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3365:1: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3365:1: (lv_newEx_3_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3366:3: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression6893);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3390:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3391:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3392:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6929);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6939); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3399:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3402:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=RULE_NUMBER && LA50_0<=RULE_EXPONENT)||LA50_0==43||(LA50_0>=67 && LA50_0<=69)) ) {
                alt50=1;
            }
            else if ( (LA50_0==14) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3403:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3404:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3404:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3405:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6986);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3422:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3422:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3422:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionOrQualifiedExecution7005); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3426:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3427:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3427:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3428:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7026);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleExpressionOrQualifiedExecution7038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3448:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==38||(LA51_0>=63 && LA51_0<=64)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3449:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3449:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3450:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7061);
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
    // $ANTLR end "ruleExpressionOrQualifiedExecution"


    // $ANTLR start "entryRuleUnqualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3474:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3475:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3476:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7098);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7108); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3483:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3486:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3487:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3487:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3487:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3487:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3488:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3488:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3489:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7154);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3505:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==38||(LA52_0>=63 && LA52_0<=64)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3506:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3506:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3507:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7175);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3531:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3532:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3533:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7212);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7222); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3540:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3543:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3544:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3544:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3544:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleSuperExecution7259); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleSuperExecution7271); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3552:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3553:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3553:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3554:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7292);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3570:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==38||(LA53_0>=63 && LA53_0<=64)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3571:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3571:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3572:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7313);
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
            	    break loop53;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3596:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3597:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3598:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7350);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7360); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3605:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3608:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3609:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3609:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3609:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleConstructorExecution7397); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3613:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3614:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3614:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3615:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7418);
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleConstructorExecution7430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3635:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( ((LA54_0>=RULE_NUMBER && LA54_0<=RULE_EXPONENT)||LA54_0==14||LA54_0==17||LA54_0==43||LA54_0==56||(LA54_0>=59 && LA54_0<=62)||(LA54_0>=67 && LA54_0<=69)) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3636:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3636:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3637:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7451);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleConstructorExecution7464); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3657:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==38||(LA55_0>=63 && LA55_0<=64)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3658:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3658:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3659:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7485);
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
            	    break loop55;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3683:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3684:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3685:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7522);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7532); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3692:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3695:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==38||LA57_0==63) ) {
                alt57=1;
            }
            else if ( (LA57_0==64) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3696:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3697:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3697:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3698:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3698:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==38) ) {
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3699:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,38,FOLLOW_38_in_ruleSubCall7578); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3711:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,63,FOLLOW_63_in_ruleSubCall7607); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3726:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3727:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3727:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3728:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7644);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3745:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3745:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3745:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_64_in_ruleSubCall7664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3749:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3750:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3750:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3751:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7685);
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

                    otherlv_4=(Token)match(input,65,FOLLOW_65_in_ruleSubCall7697); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3779:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3780:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3781:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7734);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7744); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3788:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3791:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3792:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3792:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3792:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3792:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3793:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3793:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3794:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7790);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3810:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==24) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3810:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleDeclarator7803); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3814:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3815:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3815:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3816:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7824);
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
            	    break loop58;
                }
            } while (true);

            otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleDeclarator7838); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3844:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3845:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3846:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration7874);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration7884); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3853:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3856:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3857:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3857:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3857:2: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3857:2: ( (lv_type_0_0= ruleType ) )?
            int alt59=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA59_1 = input.LA(2);

                    if ( ((LA59_1>=RULE_VERSION && LA59_1<=RULE_EXPONENT)||LA59_1==43||LA59_1==66) ) {
                        alt59=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA59_2 = input.LA(2);

                    if ( ((LA59_2>=RULE_VERSION && LA59_2<=RULE_EXPONENT)||LA59_2==43||LA59_2==66) ) {
                        alt59=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA59_3 = input.LA(2);

                    if ( ((LA59_3>=RULE_VERSION && LA59_3<=RULE_EXPONENT)||LA59_3==43||LA59_3==66) ) {
                        alt59=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA59_4 = input.LA(2);

                    if ( ((LA59_4>=RULE_VERSION && LA59_4<=RULE_EXPONENT)||LA59_4==43||LA59_4==66) ) {
                        alt59=1;
                    }
                    }
                    break;
                case 70:
                case 71:
                case 72:
                case 73:
                    {
                    alt59=1;
                    }
                    break;
            }

            switch (alt59) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3858:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3858:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3859:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration7930);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3875:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3876:1: (lv_units_1_0= ruleDeclarationUnit )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3876:1: (lv_units_1_0= ruleDeclarationUnit )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3877:3: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7952);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3893:2: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==20) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3893:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleDeclaration7965); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3897:1: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3898:1: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3898:1: (lv_units_3_0= ruleDeclarationUnit )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3899:3: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7986);
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
            	    break loop60;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3923:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3924:2: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3925:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationUnitRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit8024);
            iv_ruleDeclarationUnit=ruleDeclarationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarationUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarationUnit8034); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3932:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3935:28: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3936:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3936:1: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3936:2: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3936:2: ( (lv_id_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3937:1: (lv_id_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3937:1: (lv_id_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3938:3: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclarationUnit8080);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3954:2: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==21) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3954:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleDeclarationUnit8093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3958:1: ( (lv_deflt_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3959:1: (lv_deflt_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3959:1: (lv_deflt_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3960:3: lv_deflt_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationUnitAccess().getDefltExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleDeclarationUnit8114);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3984:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3985:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3986:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall8152);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall8162); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3993:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3996:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3997:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3997:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3997:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3997:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3998:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3998:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:3999:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8208);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleCall8220); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4019:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4020:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4020:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4021:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8241);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4037:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( ((LA63_0>=RULE_NUMBER && LA63_0<=RULE_EXPONENT)||LA63_0==14||LA63_0==17||LA63_0==43||LA63_0==56||(LA63_0>=59 && LA63_0<=62)||(LA63_0>=67 && LA63_0<=69)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4038:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4038:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4039:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8263);
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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCall8276); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4067:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4068:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4069:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8312);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8322); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4076:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4079:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4080:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4080:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4080:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4080:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4081:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4081:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4082:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8368);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4098:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==20) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4098:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleArgumentList8381); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4102:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4103:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4103:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4104:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8402);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4128:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4129:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4130:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8440);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8450); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4137:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4140:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt65=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA65_1 = input.LA(2);

                    if ( (LA65_1==21) ) {
                        alt65=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==21) ) {
                        alt65=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA65_3 = input.LA(2);

                    if ( (LA65_3==21) ) {
                        alt65=1;
                    }
                    }
                    break;
                case 43:
                    {
                    int LA65_4 = input.LA(2);

                    if ( (LA65_4==21) ) {
                        alt65=1;
                    }
                    }
                    break;
            }

            switch (alt65) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4141:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4142:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4142:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4143:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8497);
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

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleNamedArgument8509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4163:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4164:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4164:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4165:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8532);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4189:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4190:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4191:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8568);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8578); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4198:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4201:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4202:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4202:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4202:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4202:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4203:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4203:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4204:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8624);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4220:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==66) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4220:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4220:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4221:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4221:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4222:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,66,FOLLOW_66_in_ruleQualifiedPrefix8643); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4235:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4236:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4236:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4237:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8677);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4261:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4262:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4263:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8715);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8725); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4270:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4273:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4274:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4274:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4274:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4274:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4275:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4275:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4276:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8771);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4292:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==38) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA67_3 = input.LA(3);

                        if ( (LA67_3==EOF||LA67_3==13||LA67_3==15||(LA67_3>=17 && LA67_3<=20)||LA67_3==24||LA67_3==28||LA67_3==31||LA67_3==38||LA67_3==41||(LA67_3>=45 && LA67_3<=58)||(LA67_3>=63 && LA67_3<=65)) ) {
                            alt67=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA67_4 = input.LA(3);

                        if ( (LA67_4==EOF||LA67_4==13||LA67_4==15||(LA67_4>=17 && LA67_4<=20)||LA67_4==24||LA67_4==28||LA67_4==31||LA67_4==38||LA67_4==41||(LA67_4>=45 && LA67_4<=58)||(LA67_4>=63 && LA67_4<=65)) ) {
                            alt67=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA67_5 = input.LA(3);

                        if ( (LA67_5==EOF||LA67_5==13||LA67_5==15||(LA67_5>=17 && LA67_5<=20)||LA67_5==24||LA67_5==28||LA67_5==31||LA67_5==38||LA67_5==41||(LA67_5>=45 && LA67_5<=58)||(LA67_5>=63 && LA67_5<=65)) ) {
                            alt67=1;
                        }


                        }
                        break;
                    case 43:
                        {
                        int LA67_6 = input.LA(3);

                        if ( (LA67_6==EOF||LA67_6==13||LA67_6==15||(LA67_6>=17 && LA67_6<=20)||LA67_6==24||LA67_6==28||LA67_6==31||LA67_6==38||LA67_6==41||(LA67_6>=45 && LA67_6<=58)||(LA67_6>=63 && LA67_6<=65)) ) {
                            alt67=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt67) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4292:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4292:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4293:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4293:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4294:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedName8790); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4307:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4308:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4308:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4309:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8824);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4333:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4334:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4335:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8862);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8872); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4342:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4345:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4346:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4346:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt69=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt69=1;
                }
                break;
            case RULE_STRING:
                {
                alt69=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 43:
                {
                alt69=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA69_4 = input.LA(2);

                if ( (synpred84_InternalTemplateLang()) ) {
                    alt69=3;
                }
                else if ( (synpred88_InternalTemplateLang()) ) {
                    alt69=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 4, input);

                    throw nvae;
                }
                }
                break;
            case 67:
            case 68:
                {
                alt69=4;
                }
                break;
            case 69:
                {
                alt69=5;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4346:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4346:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4347:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4347:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4348:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8918);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4365:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4365:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4366:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4366:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4367:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8941); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4384:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4384:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4385:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4385:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4386:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant8973);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4403:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4403:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4404:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4404:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4405:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4405:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==67) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==68) ) {
                        alt68=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4406:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,67,FOLLOW_67_in_ruleConstant8999); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4418:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,68,FOLLOW_68_in_ruleConstant9028); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4434:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4434:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4435:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4436:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,69,FOLLOW_69_in_ruleConstant9068); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4450:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4450:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4450:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4456:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4457:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant9115); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4481:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4482:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4483:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue9156);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue9166); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4490:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4493:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4494:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4494:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4495:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4495:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4496:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9207); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4520:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4521:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4522:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9248);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9259); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4529:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4532:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4533:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4533:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt70=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt70=1;
                }
                break;
            case RULE_VERSION:
                {
                alt70=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt70=3;
                }
                break;
            case 43:
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4533:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4541:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4549:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4558:2: kw= 'version'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleIdentifier9375); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4571:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4572:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4573:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9415);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9425); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4580:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4583:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4584:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4584:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt72=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 43:
                {
                alt72=1;
                }
                break;
            case 70:
                {
                alt72=2;
                }
                break;
            case 71:
                {
                alt72=3;
                }
                break;
            case 72:
                {
                alt72=4;
                }
                break;
            case 73:
                {
                alt72=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4584:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4584:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4585:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4585:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4586:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9471);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4603:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4603:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4603:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4603:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4604:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4604:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4605:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,70,FOLLOW_70_in_ruleType9496); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4618:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4619:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4619:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4620:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9530);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4637:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4637:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4637:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4637:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4638:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4638:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4639:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,71,FOLLOW_71_in_ruleType9556); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4652:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4653:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4653:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4654:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9590);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4671:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4671:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4671:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4671:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4672:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4672:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4673:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,72,FOLLOW_72_in_ruleType9616); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4686:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4687:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4687:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4688:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9650);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4705:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4705:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4705:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4705:7: ( (lv_call_7_0= 'callOf' ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4706:1: (lv_call_7_0= 'callOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4706:1: (lv_call_7_0= 'callOf' )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4707:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,73,FOLLOW_73_in_ruleType9676); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4720:2: ( (lv_return_8_0= ruleType ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( ((LA71_0>=RULE_VERSION && LA71_0<=RULE_EXPONENT)||LA71_0==43||(LA71_0>=70 && LA71_0<=73)) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4721:1: (lv_return_8_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4721:1: (lv_return_8_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4722:3: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleType9710);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4738:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4739:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4739:1: (lv_param_9_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4740:3: lv_param_9_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9732);
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4764:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4765:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4766:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9769);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9779); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4773:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4776:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4777:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4777:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4777:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleTypeParameters9816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4781:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4782:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4782:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4783:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9837);
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

            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4799:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==20) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4799:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTypeParameters9850); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4803:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4804:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4804:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4805:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9871);
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
            	    break loop73;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleTypeParameters9885); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4833:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4834:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4835:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9921);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9931); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4842:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4845:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4846:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4846:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4846:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4846:2: ()
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4847:2: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleContainerInitializer9980); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4859:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_NUMBER && LA75_0<=RULE_EXPONENT)||LA75_0==14||LA75_0==17||LA75_0==43||LA75_0==56||(LA75_0>=59 && LA75_0<=62)||(LA75_0>=67 && LA75_0<=69)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4859:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4859:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4860:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4860:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4861:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10002);
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

                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4877:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==20) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4877:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleContainerInitializer10015); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4881:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4882:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4882:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4883:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10036);
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
                    	    break loop74;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer10052); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4911:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4912:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4913:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10088);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression10098); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4920:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4923:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4924:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4924:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_NUMBER && LA76_0<=RULE_EXPONENT)||LA76_0==14||LA76_0==43||LA76_0==56||(LA76_0>=59 && LA76_0<=62)||(LA76_0>=67 && LA76_0<=69)) ) {
                alt76=1;
            }
            else if ( (LA76_0==17) ) {
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4924:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4924:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4925:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4925:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4926:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10144);
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
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4943:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4943:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4944:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4944:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4945:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10171);
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

    // $ANTLR start synpred17_InternalTemplateLang
    public final void synpred17_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_var_0_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:643:2: ( (lv_var_0_0= ruleVariableDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:644:1: (lv_var_0_0= ruleVariableDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:644:1: (lv_var_0_0= ruleVariableDeclaration )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:645:3: lv_var_0_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred17_InternalTemplateLang1182);
        lv_var_0_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred17_InternalTemplateLang

    // $ANTLR start synpred20_InternalTemplateLang
    public final void synpred20_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_block_3_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:700:6: ( ( (lv_block_3_0= ruleStmtBlock ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:700:6: ( (lv_block_3_0= ruleStmtBlock ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:700:6: ( (lv_block_3_0= ruleStmtBlock ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:701:1: (lv_block_3_0= ruleStmtBlock )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:701:1: (lv_block_3_0= ruleStmtBlock )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:702:3: lv_block_3_0= ruleStmtBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getBlockStmtBlockParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmtBlock_in_synpred20_InternalTemplateLang1263);
        lv_block_3_0=ruleStmtBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred20_InternalTemplateLang

    // $ANTLR start synpred21_InternalTemplateLang
    public final void synpred21_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_multi_4_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:719:6: ( ( (lv_multi_4_0= rulemultiselect ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:719:6: ( (lv_multi_4_0= rulemultiselect ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:719:6: ( (lv_multi_4_0= rulemultiselect ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:720:1: (lv_multi_4_0= rulemultiselect )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:720:1: (lv_multi_4_0= rulemultiselect )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:721:3: lv_multi_4_0= rulemultiselect
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_4_0()); 
          	    
        }
        pushFollow(FOLLOW_rulemultiselect_in_synpred21_InternalTemplateLang1290);
        lv_multi_4_0=rulemultiselect();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred21_InternalTemplateLang

    // $ANTLR start synpred23_InternalTemplateLang
    public final void synpred23_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_exprStmt_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:757:6: ( ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:757:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:757:6: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:758:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:758:1: (lv_exprStmt_6_0= ruleExpressionStatement )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:759:3: lv_exprStmt_6_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionStatement_in_synpred23_InternalTemplateLang1344);
        lv_exprStmt_6_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred23_InternalTemplateLang

    // $ANTLR start synpred25_InternalTemplateLang
    public final void synpred25_InternalTemplateLang_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStmt ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:3: ( ( 'else' )=>otherlv_5= 'else' )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:863:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,26,FOLLOW_26_in_synpred25_InternalTemplateLang1541); if (state.failed) return ;

        }

        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:868:2: ( (lv_else_6_0= ruleStmt ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:869:1: (lv_else_6_0= ruleStmt )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:869:1: (lv_else_6_0= ruleStmt )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:870:3: lv_else_6_0= ruleStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStmt_in_synpred25_InternalTemplateLang1563);
        lv_else_6_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred25_InternalTemplateLang

    // $ANTLR start synpred76_InternalTemplateLang
    public final void synpred76_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4020:1: ( (lv_decl_2_0= ruleDeclarator ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4020:1: (lv_decl_2_0= ruleDeclarator )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4020:1: (lv_decl_2_0= ruleDeclarator )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4021:3: lv_decl_2_0= ruleDeclarator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleDeclarator_in_synpred76_InternalTemplateLang8241);
        lv_decl_2_0=ruleDeclarator();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred76_InternalTemplateLang

    // $ANTLR start synpred84_InternalTemplateLang
    public final void synpred84_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4384:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4384:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4384:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4385:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4385:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4386:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred84_InternalTemplateLang8973);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred84_InternalTemplateLang

    // $ANTLR start synpred88_InternalTemplateLang
    public final void synpred88_InternalTemplateLang_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4450:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4451:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4451:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.templatelang/src-gen/de/uni_hildesheim/sse/vil/templatelang/parser/antlr/internal/InternalTemplateLang.g:4452:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred88_InternalTemplateLang9101); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred88_InternalTemplateLang

    // Delegated rules

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
    public final boolean synpred88_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_InternalTemplateLang_fragment(); // can never throw exception
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
    public final boolean synpred25_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalTemplateLang_fragment(); // can never throw exception
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
    public final boolean synpred76_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA62 dfa62 = new DFA62(this);
    static final String DFA17_eotS =
        "\34\uffff";
    static final String DFA17_eofS =
        "\34\uffff";
    static final String DFA17_minS =
        "\1\4\1\uffff\4\0\6\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA17_maxS =
        "\1\111\1\uffff\4\0\6\uffff\1\0\6\uffff\1\0\10\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\10\uffff\1\2\1\3\1\uffff\1\5\1\6\1\7\12\uffff\1\10"+
        "\1\4";
    static final String DFA17_specialS =
        "\2\uffff\1\0\1\1\1\2\1\3\6\uffff\1\4\6\uffff\1\5\10\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\17\1\23\1\3\1\2\1\4\5\uffff\1\17\2\uffff\1\14\7\uffff\1"+
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

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "643:1: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_block_3_0= ruleStmtBlock ) ) | ( (lv_multi_4_0= rulemultiselect ) ) | ( (lv_loop_5_0= ruleLoop ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index17_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_3 = input.LA(1);

                         
                        int index17_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index17_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_4 = input.LA(1);

                         
                        int index17_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index17_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA17_5 = input.LA(1);

                         
                        int index17_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred21_InternalTemplateLang()) ) {s = 13;}

                        else if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index17_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalTemplateLang()) ) {s = 27;}

                        else if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA17_19 = input.LA(1);

                         
                        int index17_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_InternalTemplateLang()) ) {s = 15;}

                        else if ( (true) ) {s = 26;}

                         
                        input.seek(index17_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\14\uffff";
    static final String DFA35_eofS =
        "\14\uffff";
    static final String DFA35_minS =
        "\1\4\4\16\1\uffff\1\6\1\uffff\4\16";
    static final String DFA35_maxS =
        "\1\105\4\102\1\uffff\1\53\1\uffff\4\102";
    static final String DFA35_acceptS =
        "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA35_specialS =
        "\14\uffff}>";
    static final String[] DFA35_transitionS = {
            "\2\5\1\2\1\1\1\3\5\uffff\1\5\2\uffff\1\5\31\uffff\1\4\14\uffff"+
            "\1\5\2\uffff\4\5\4\uffff\3\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\6\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "",
            "\1\11\1\10\1\12\42\uffff\1\13",
            "",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5",
            "\1\5\6\uffff\1\7\2\uffff\1\5\15\uffff\1\5\6\uffff\16\5\4\uffff"+
            "\2\5\1\uffff\1\5"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "2257:2: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA49_eotS =
        "\16\uffff";
    static final String DFA49_eofS =
        "\2\uffff\4\1\4\uffff\4\1";
    static final String DFA49_minS =
        "\1\4\1\uffff\4\15\2\uffff\1\6\1\uffff\4\15";
    static final String DFA49_maxS =
        "\1\105\1\uffff\4\102\2\uffff\1\53\1\uffff\4\102";
    static final String DFA49_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\uffff\1\2\4\uffff";
    static final String DFA49_specialS =
        "\16\uffff}>";
    static final String[] DFA49_transitionS = {
            "\2\1\1\3\1\2\1\4\5\uffff\1\1\34\uffff\1\5\21\uffff\1\6\1\7"+
            "\4\uffff\3\1",
            "",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "",
            "",
            "\1\13\1\12\1\14\42\uffff\1\15",
            "",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10",
            "\1\1\1\11\1\1\1\uffff\4\1\3\uffff\1\1\3\uffff\1\1\2\uffff"+
            "\1\1\6\uffff\1\1\2\uffff\1\1\3\uffff\16\1\4\uffff\3\1\1\10"
    };

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "3307:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA62_eotS =
        "\26\uffff";
    static final String DFA62_eofS =
        "\26\uffff";
    static final String DFA62_minS =
        "\1\4\4\0\21\uffff";
    static final String DFA62_maxS =
        "\1\111\4\0\21\uffff";
    static final String DFA62_acceptS =
        "\5\uffff\1\1\3\uffff\1\2\14\uffff";
    static final String DFA62_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\21\uffff}>";
    static final String[] DFA62_transitionS = {
            "\2\11\1\2\1\1\1\3\5\uffff\2\11\1\uffff\1\11\31\uffff\1\4\14"+
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "4019:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred76_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleLanguageUnit137 = new BitSet(new long[]{0x0000122000082000L});
    public static final BitSet FOLLOW_ruleExtension_in_ruleLanguageUnit159 = new BitSet(new long[]{0x0000022000082000L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit181 = new BitSet(new long[]{0x0000020000082000L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_ruleLanguageUnit203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLanguageUnit216 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit237 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit249 = new BitSet(new long[]{0x00000800000081C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit270 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit283 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit296 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit317 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit331 = new BitSet(new long[]{0x0000098000C401C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit352 = new BitSet(new long[]{0x0000098000C401C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleTypeDef_in_ruleLanguageUnit374 = new BitSet(new long[]{0x0000098000C401C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleLanguageUnit396 = new BitSet(new long[]{0x0000088000C401C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleVilDef_in_ruleLanguageUnit418 = new BitSet(new long[]{0x0000000000C40000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHint_in_entryRuleIndentationHint467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHint477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIndentationHint514 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleIndentationHint526 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint547 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleIndentationHint560 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_ruleIndentationHint581 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleIndentationHint595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndentationHintPart_in_entryRuleIndentationHintPart631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndentationHintPart641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleIndentationHintPart687 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleIndentationHintPart699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleIndentationHintPart716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVilDef_in_entryRuleVilDef757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVilDef767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleVilDef810 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVilDef836 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVilDef857 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVilDef879 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVilDef891 = new BitSet(new long[]{0x00000800000081C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleVilDef912 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleVilDef925 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleVilDef946 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleVilDef959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_entryRuleStmtBlock997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmtBlock1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleStmtBlock1056 = new BitSet(new long[]{0x790008832A0641F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleStmt_in_ruleStmtBlock1077 = new BitSet(new long[]{0x790008832A0641F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_18_in_ruleStmtBlock1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmt_in_entryRuleStmt1126 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStmt1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleStmt1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_ruleStmt1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_ruleStmt1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleStmt1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_ruleStmt1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_ruleStmt1317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleStmt1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_ruleStmt1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative1407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternative1417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAlternative1454 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAlternative1466 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlternative1487 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAlternative1499 = new BitSet(new long[]{0x790008832A0241F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1520 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleAlternative1541 = new BitSet(new long[]{0x790008832A0241F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleStmt_in_ruleAlternative1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent1601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleContent1654 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleContent1685 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleContent1703 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleContent1724 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleContent1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_entryRuleSwitch1774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitch1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleSwitch1821 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSwitch1833 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1854 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSwitch1866 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSwitch1878 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1900 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1913 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleSwitchPart_in_ruleSwitch1934 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleSwitch1949 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleSwitch1961 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSwitch1973 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitch1994 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSwitch2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchPart_in_entryRuleSwitchPart2045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchPart2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2101 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleSwitchPart2113 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchPart2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoop_in_entryRuleLoop2170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoop2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleLoop2217 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoop2229 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLoop2250 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLoop2271 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleLoop2283 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoop2304 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2317 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2338 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleLoop2351 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleLoop2372 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLoop2388 = new BitSet(new long[]{0x790008832A0241F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleStmt_in_ruleLoop2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_entryRulemultiselect2445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiselect2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_rulemultiselect2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_rulemultiselect2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegenericMultiselect_in_entryRulegenericMultiselect2564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegenericMultiselect2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulegenericMultiselect2611 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2632 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2653 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_rulegenericMultiselect2674 = new BitSet(new long[]{0x0000000400020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulegenericMultiselect2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiSelectPart_in_entryRulemultiSelectPart2732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulemultiSelectPart2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulemultiSelectPart2779 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_rulemultiSelectPart2800 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2821 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_rulemultiSelectPart2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleuserMultiselect_in_entryRuleuserMultiselect2878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleuserMultiselect2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleuserMultiselect2934 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleuserMultiselect2946 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleuserMultiselect2958 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_ruleuserMultiselect2979 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleuserMultiselect2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtension_in_entryRuleExtension3030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtension3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleExtension3077 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_ruleExtension3098 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleExtension3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaQualifiedName_in_entryRuleJavaQualifiedName3146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaQualifiedName3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3202 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleJavaQualifiedName3221 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJavaQualifiedName3255 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleVariableDeclaration3346 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3381 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3402 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_21_in_ruleVariableDeclaration3415 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3436 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleVariableDeclaration3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDef_in_entryRuleTypeDef3486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDef3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleTypeDef3533 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeDef3554 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeDef3575 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTypeDef3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice3623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleAdvice3670 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAdvice3682 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice3703 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAdvice3715 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec3773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec3783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVersionSpec3820 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList3877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList3933 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleParameterList3946 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList3967 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4061 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleVersionStmt4165 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4182 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleVersionStmt4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleImport4282 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4303 = new BitSet(new long[]{0x0000040001000000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4324 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleImport4337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement4373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4430 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_38_in_ruleExpressionStatement4443 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement4464 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleExpressionStatement4478 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement4501 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleExpressionStatement4513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression4724 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression4745 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart4782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart4792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart4838 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator4896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator4907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleLogicalOperator4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleLogicalOperator4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleLogicalOperator4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5079 = new BitSet(new long[]{0x0007000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5137 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5193 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleEqualityOperator5300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleEqualityOperator5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleEqualityOperator5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5434 = new BitSet(new long[]{0x0078000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5548 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalOperator5655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleRelationalOperator5674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleRelationalOperator5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleRelationalOperator5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression5752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression5808 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression5829 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart5866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart5876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart5922 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart5943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator5980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAdditiveOperator6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleAdditiveOperator6048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6144 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6258 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleMultiplicativeOperator6365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMultiplicativeOperator6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6480 = new BitSet(new long[]{0x79000800000041F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUnaryOperator6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnaryOperator6607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUnaryOperator6626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression6676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression6756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression6812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression6839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression6866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution6929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution6939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution6986 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_14_in_ruleExpressionOrQualifiedExecution7005 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7026 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleExpressionOrQualifiedExecution7038 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7061 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7098 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7154 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7175 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleSuperExecution7259 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSuperExecution7271 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7292 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7313 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleConstructorExecution7397 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7418 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleConstructorExecution7430 = new BitSet(new long[]{0x790008000002C1F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7451 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConstructorExecution7464 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7485 = new BitSet(new long[]{0x8000004000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSubCall7578 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_63_in_ruleSubCall7607 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleSubCall7664 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleSubCall7697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7790 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_24_in_ruleDeclarator7803 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7824 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_28_in_ruleDeclarator7838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration7874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration7884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration7930 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7952 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleDeclaration7965 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_ruleDeclaration7986 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleDeclarationUnit_in_entryRuleDeclarationUnit8024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarationUnit8034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclarationUnit8080 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleDeclarationUnit8093 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDeclarationUnit8114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall8152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall8162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8208 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleCall8220 = new BitSet(new long[]{0x790008000002C1F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8241 = new BitSet(new long[]{0x790008000002C1F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8263 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCall8276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8368 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleArgumentList8381 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8402 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8497 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNamedArgument8509 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8624 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleQualifiedPrefix8643 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8677 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8771 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedName8790 = new BitSet(new long[]{0x00000800000001C0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8824 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant8973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConstant8999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleConstant9028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleConstant9068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant9115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue9156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue9166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleIdentifier9375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleType9496 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleType9556 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleType9616 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleType9676 = new BitSet(new long[]{0x00000800000041C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleType9710 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleTypeParameters9816 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9837 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTypeParameters9850 = new BitSet(new long[]{0x00000800000001C0L,0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9871 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTypeParameters9885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleContainerInitializer9980 = new BitSet(new long[]{0x79000800000641F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10002 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_20_in_ruleContainerInitializer10015 = new BitSet(new long[]{0x79000800000241F0L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10036 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer10052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression10098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred7_InternalTemplateLang352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred17_InternalTemplateLang1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStmtBlock_in_synpred20_InternalTemplateLang1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulemultiselect_in_synpred21_InternalTemplateLang1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_synpred23_InternalTemplateLang1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_synpred25_InternalTemplateLang1541 = new BitSet(new long[]{0x790008832A0241F0L,0x00000000000003F8L});
    public static final BitSet FOLLOW_ruleStmt_in_synpred25_InternalTemplateLang1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_synpred76_InternalTemplateLang8241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred84_InternalTemplateLang8973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred88_InternalTemplateLang9101 = new BitSet(new long[]{0x0000000000000002L});

}