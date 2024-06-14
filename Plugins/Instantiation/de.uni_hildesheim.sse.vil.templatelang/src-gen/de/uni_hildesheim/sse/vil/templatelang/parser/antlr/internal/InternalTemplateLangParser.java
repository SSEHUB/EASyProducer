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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_NUMBER", "RULE_STRING", "RULE_VERSION", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'template'", "'('", "')'", "'extends'", "'{'", "'}'", "'|'", "'<'", "'@indent'", "','", "'='", "'@format'", "'protected'", "'def'", "';'", "'if'", "'else'", "'!'", "'<CR>'", "'switch'", "'default'", "':'", "'for'", "'while'", "'flush'", "'multiSelect'", "'case'", "':='", "'generic-multiSelect'", "'extension'", "'.'", "'const'", "'abstract'", "'compound'", "'refines'", "'typedef'", "'@advice'", "'with'", "'version'", "'import'", "'insert'", "'*'", "'and'", "'or'", "'xor'", "'implies'", "'iff'", "'=='", "'<>'", "'!='", "'>'", "'>='", "'<='", "'+'", "'-'", "'/'", "'not'", "'super'", "'new'", "'->'", "'['", "']'", "'@'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=7;
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
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=6;
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
    public static final int RULE_NUMBER=5;
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
    public String getGrammarFileName() { return "InternalTemplateLang.g"; }



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
    // InternalTemplateLang.g:70:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // InternalTemplateLang.g:70:53: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // InternalTemplateLang.g:71:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
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
    // InternalTemplateLang.g:77:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? ( (lv_formatting_4_0= ruleFormattingHint ) )? otherlv_5= 'template' ( (lv_name_6_0= ruleIdentifier ) ) otherlv_7= '(' ( (lv_param_8_0= ruleParameterList ) )? otherlv_9= ')' (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )? otherlv_12= '{' ( (lv_version_13_0= ruleVersionStmt ) )? ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )* otherlv_18= '}' ) ;
    public final EObject ruleLanguageUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_18=null;
        EObject lv_imports_0_0 = null;

        EObject lv_javaExts_1_0 = null;

        EObject lv_advices_2_0 = null;

        EObject lv_indent_3_0 = null;

        EObject lv_formatting_4_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject lv_param_8_0 = null;

        AntlrDatatypeRuleToken lv_ext_11_0 = null;

        EObject lv_version_13_0 = null;

        EObject lv_elements_14_0 = null;

        EObject lv_elements_15_0 = null;

        EObject lv_elements_16_0 = null;

        EObject lv_elements_17_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:83:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? ( (lv_formatting_4_0= ruleFormattingHint ) )? otherlv_5= 'template' ( (lv_name_6_0= ruleIdentifier ) ) otherlv_7= '(' ( (lv_param_8_0= ruleParameterList ) )? otherlv_9= ')' (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )? otherlv_12= '{' ( (lv_version_13_0= ruleVersionStmt ) )? ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )* otherlv_18= '}' ) )
            // InternalTemplateLang.g:84:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? ( (lv_formatting_4_0= ruleFormattingHint ) )? otherlv_5= 'template' ( (lv_name_6_0= ruleIdentifier ) ) otherlv_7= '(' ( (lv_param_8_0= ruleParameterList ) )? otherlv_9= ')' (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )? otherlv_12= '{' ( (lv_version_13_0= ruleVersionStmt ) )? ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )* otherlv_18= '}' )
            {
            // InternalTemplateLang.g:84:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? ( (lv_formatting_4_0= ruleFormattingHint ) )? otherlv_5= 'template' ( (lv_name_6_0= ruleIdentifier ) ) otherlv_7= '(' ( (lv_param_8_0= ruleParameterList ) )? otherlv_9= ')' (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )? otherlv_12= '{' ( (lv_version_13_0= ruleVersionStmt ) )? ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )* otherlv_18= '}' )
            // InternalTemplateLang.g:85:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_javaExts_1_0= ruleExtension ) )* ( (lv_advices_2_0= ruleAdvice ) )* ( (lv_indent_3_0= ruleIndentationHint ) )? ( (lv_formatting_4_0= ruleFormattingHint ) )? otherlv_5= 'template' ( (lv_name_6_0= ruleIdentifier ) ) otherlv_7= '(' ( (lv_param_8_0= ruleParameterList ) )? otherlv_9= ')' (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )? otherlv_12= '{' ( (lv_version_13_0= ruleVersionStmt ) )? ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )* otherlv_18= '}'
            {
            // InternalTemplateLang.g:85:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=52 && LA1_0<=53)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTemplateLang.g:86:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalTemplateLang.g:86:4: (lv_imports_0_0= ruleImport )
            	    // InternalTemplateLang.g:87:5: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getImportsImportParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_3);
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

            // InternalTemplateLang.g:104:3: ( (lv_javaExts_1_0= ruleExtension ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==42) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTemplateLang.g:105:4: (lv_javaExts_1_0= ruleExtension )
            	    {
            	    // InternalTemplateLang.g:105:4: (lv_javaExts_1_0= ruleExtension )
            	    // InternalTemplateLang.g:106:5: lv_javaExts_1_0= ruleExtension
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getJavaExtsExtensionParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
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
            	      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Extension");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalTemplateLang.g:123:3: ( (lv_advices_2_0= ruleAdvice ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==49) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalTemplateLang.g:124:4: (lv_advices_2_0= ruleAdvice )
            	    {
            	    // InternalTemplateLang.g:124:4: (lv_advices_2_0= ruleAdvice )
            	    // InternalTemplateLang.g:125:5: lv_advices_2_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
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
            	      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Advice");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalTemplateLang.g:142:3: ( (lv_indent_3_0= ruleIndentationHint ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalTemplateLang.g:143:4: (lv_indent_3_0= ruleIndentationHint )
                    {
                    // InternalTemplateLang.g:143:4: (lv_indent_3_0= ruleIndentationHint )
                    // InternalTemplateLang.g:144:5: lv_indent_3_0= ruleIndentationHint
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getIndentIndentationHintParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_6);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.IndentationHint");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTemplateLang.g:161:3: ( (lv_formatting_4_0= ruleFormattingHint ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTemplateLang.g:162:4: (lv_formatting_4_0= ruleFormattingHint )
                    {
                    // InternalTemplateLang.g:162:4: (lv_formatting_4_0= ruleFormattingHint )
                    // InternalTemplateLang.g:163:5: lv_formatting_4_0= ruleFormattingHint
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getFormattingFormattingHintParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_7);
                    lv_formatting_4_0=ruleFormattingHint();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      					}
                      					set(
                      						current,
                      						"formatting",
                      						lv_formatting_4_0,
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.FormattingHint");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getLanguageUnitAccess().getTemplateKeyword_5());
              		
            }
            // InternalTemplateLang.g:184:3: ( (lv_name_6_0= ruleIdentifier ) )
            // InternalTemplateLang.g:185:4: (lv_name_6_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:185:4: (lv_name_6_0= ruleIdentifier )
            // InternalTemplateLang.g:186:5: lv_name_6_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_name_6_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_6_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,14,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getLanguageUnitAccess().getLeftParenthesisKeyword_7());
              		
            }
            // InternalTemplateLang.g:207:3: ( (lv_param_8_0= ruleParameterList ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||(LA6_0>=RULE_VERSION && LA6_0<=RULE_EXPONENT)||LA6_0==51||(LA6_0>=80 && LA6_0<=83)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalTemplateLang.g:208:4: (lv_param_8_0= ruleParameterList )
                    {
                    // InternalTemplateLang.g:208:4: (lv_param_8_0= ruleParameterList )
                    // InternalTemplateLang.g:209:5: lv_param_8_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getParamParameterListParserRuleCall_8_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
                    lv_param_8_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      					}
                      					set(
                      						current,
                      						"param",
                      						lv_param_8_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getLanguageUnitAccess().getRightParenthesisKeyword_9());
              		
            }
            // InternalTemplateLang.g:230:3: (otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTemplateLang.g:231:4: otherlv_10= 'extends' ( (lv_ext_11_0= ruleIdentifier ) )
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getLanguageUnitAccess().getExtendsKeyword_10_0());
                      			
                    }
                    // InternalTemplateLang.g:235:4: ( (lv_ext_11_0= ruleIdentifier ) )
                    // InternalTemplateLang.g:236:5: (lv_ext_11_0= ruleIdentifier )
                    {
                    // InternalTemplateLang.g:236:5: (lv_ext_11_0= ruleIdentifier )
                    // InternalTemplateLang.g:237:6: lv_ext_11_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLanguageUnitAccess().getExtIdentifierParserRuleCall_10_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    lv_ext_11_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      						}
                      						set(
                      							current,
                      							"ext",
                      							lv_ext_11_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,17,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getLanguageUnitAccess().getLeftCurlyBracketKeyword_11());
              		
            }
            // InternalTemplateLang.g:259:3: ( (lv_version_13_0= ruleVersionStmt ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==51) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_VERSION) ) {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==27) ) {
                        int LA8_4 = input.LA(4);

                        if ( (synpred8_InternalTemplateLang()) ) {
                            alt8=1;
                        }
                    }
                }
            }
            switch (alt8) {
                case 1 :
                    // InternalTemplateLang.g:260:4: (lv_version_13_0= ruleVersionStmt )
                    {
                    // InternalTemplateLang.g:260:4: (lv_version_13_0= ruleVersionStmt )
                    // InternalTemplateLang.g:261:5: lv_version_13_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_12_0());
                      				
                    }
                    pushFollow(FOLLOW_14);
                    lv_version_13_0=ruleVersionStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
                      					}
                      					set(
                      						current,
                      						"version",
                      						lv_version_13_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VersionStmt");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTemplateLang.g:278:3: ( ( (lv_elements_14_0= ruleTypeDef ) ) | ( (lv_elements_15_0= ruleCompound ) ) | ( (lv_elements_16_0= ruleVariableDeclaration ) ) | ( (lv_elements_17_0= ruleVilDef ) ) )*
            loop9:
            do {
                int alt9=5;
                switch ( input.LA(1) ) {
                case 48:
                    {
                    alt9=1;
                    }
                    break;
                case 45:
                case 46:
                    {
                    alt9=2;
                    }
                    break;
                case RULE_ID:
                case RULE_VERSION:
                case RULE_EXPONENT:
                case 44:
                case 51:
                case 80:
                case 81:
                case 82:
                case 83:
                    {
                    alt9=3;
                    }
                    break;
                case EOF:
                case 25:
                case 26:
                case 75:
                    {
                    alt9=4;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // InternalTemplateLang.g:279:4: ( (lv_elements_14_0= ruleTypeDef ) )
            	    {
            	    // InternalTemplateLang.g:279:4: ( (lv_elements_14_0= ruleTypeDef ) )
            	    // InternalTemplateLang.g:280:5: (lv_elements_14_0= ruleTypeDef )
            	    {
            	    // InternalTemplateLang.g:280:5: (lv_elements_14_0= ruleTypeDef )
            	    // InternalTemplateLang.g:281:6: lv_elements_14_0= ruleTypeDef
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLanguageUnitAccess().getElementsTypeDefParserRuleCall_13_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_elements_14_0=ruleTypeDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_14_0,
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.TypeDef");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTemplateLang.g:299:4: ( (lv_elements_15_0= ruleCompound ) )
            	    {
            	    // InternalTemplateLang.g:299:4: ( (lv_elements_15_0= ruleCompound ) )
            	    // InternalTemplateLang.g:300:5: (lv_elements_15_0= ruleCompound )
            	    {
            	    // InternalTemplateLang.g:300:5: (lv_elements_15_0= ruleCompound )
            	    // InternalTemplateLang.g:301:6: lv_elements_15_0= ruleCompound
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLanguageUnitAccess().getElementsCompoundParserRuleCall_13_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_elements_15_0=ruleCompound();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_15_0,
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Compound");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTemplateLang.g:319:4: ( (lv_elements_16_0= ruleVariableDeclaration ) )
            	    {
            	    // InternalTemplateLang.g:319:4: ( (lv_elements_16_0= ruleVariableDeclaration ) )
            	    // InternalTemplateLang.g:320:5: (lv_elements_16_0= ruleVariableDeclaration )
            	    {
            	    // InternalTemplateLang.g:320:5: (lv_elements_16_0= ruleVariableDeclaration )
            	    // InternalTemplateLang.g:321:6: lv_elements_16_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLanguageUnitAccess().getElementsVariableDeclarationParserRuleCall_13_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_elements_16_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_16_0,
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTemplateLang.g:339:4: ( (lv_elements_17_0= ruleVilDef ) )
            	    {
            	    // InternalTemplateLang.g:339:4: ( (lv_elements_17_0= ruleVilDef ) )
            	    // InternalTemplateLang.g:340:5: (lv_elements_17_0= ruleVilDef )
            	    {
            	    // InternalTemplateLang.g:340:5: (lv_elements_17_0= ruleVilDef )
            	    // InternalTemplateLang.g:341:6: lv_elements_17_0= ruleVilDef
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLanguageUnitAccess().getElementsVilDefParserRuleCall_13_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_elements_17_0=ruleVilDef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLanguageUnitRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_17_0,
            	      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.VilDef");
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

            otherlv_18=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_18, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_14());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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


    // $ANTLR start "entryRuleHintedExpression"
    // InternalTemplateLang.g:367:1: entryRuleHintedExpression returns [EObject current=null] : iv_ruleHintedExpression= ruleHintedExpression EOF ;
    public final EObject entryRuleHintedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHintedExpression = null;


        try {
            // InternalTemplateLang.g:367:57: (iv_ruleHintedExpression= ruleHintedExpression EOF )
            // InternalTemplateLang.g:368:2: iv_ruleHintedExpression= ruleHintedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHintedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHintedExpression=ruleHintedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHintedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHintedExpression"


    // $ANTLR start "ruleHintedExpression"
    // InternalTemplateLang.g:374:1: ruleHintedExpression returns [EObject current=null] : ( ( (lv_ex_0_0= ruleExpression ) ) (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )? ) ;
    public final EObject ruleHintedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_hint_2_1=null;
        Token lv_hint_2_2=null;
        EObject lv_ex_0_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:380:2: ( ( ( (lv_ex_0_0= ruleExpression ) ) (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )? ) )
            // InternalTemplateLang.g:381:2: ( ( (lv_ex_0_0= ruleExpression ) ) (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )? )
            {
            // InternalTemplateLang.g:381:2: ( ( (lv_ex_0_0= ruleExpression ) ) (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )? )
            // InternalTemplateLang.g:382:3: ( (lv_ex_0_0= ruleExpression ) ) (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )?
            {
            // InternalTemplateLang.g:382:3: ( (lv_ex_0_0= ruleExpression ) )
            // InternalTemplateLang.g:383:4: (lv_ex_0_0= ruleExpression )
            {
            // InternalTemplateLang.g:383:4: (lv_ex_0_0= ruleExpression )
            // InternalTemplateLang.g:384:5: lv_ex_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getHintedExpressionAccess().getExExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_ex_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getHintedExpressionRule());
              					}
              					set(
              						current,
              						"ex",
              						lv_ex_0_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:401:3: (otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTemplateLang.g:402:4: otherlv_1= '|' ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getHintedExpressionAccess().getVerticalLineKeyword_1_0());
                      			
                    }
                    // InternalTemplateLang.g:406:4: ( ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) ) )
                    // InternalTemplateLang.g:407:5: ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) )
                    {
                    // InternalTemplateLang.g:407:5: ( (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' ) )
                    // InternalTemplateLang.g:408:6: (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' )
                    {
                    // InternalTemplateLang.g:408:6: (lv_hint_2_1= RULE_ID | lv_hint_2_2= '<' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==20) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalTemplateLang.g:409:7: lv_hint_2_1= RULE_ID
                            {
                            lv_hint_2_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_hint_2_1, grammarAccess.getHintedExpressionAccess().getHintIDTerminalRuleCall_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getHintedExpressionRule());
                              							}
                              							setWithLastConsumed(
                              								current,
                              								"hint",
                              								lv_hint_2_1,
                              								"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ID");
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalTemplateLang.g:424:7: lv_hint_2_2= '<'
                            {
                            lv_hint_2_2=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_hint_2_2, grammarAccess.getHintedExpressionAccess().getHintLessThanSignKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getHintedExpressionRule());
                              							}
                              							setWithLastConsumed(current, "hint", lv_hint_2_2, null);
                              						
                            }

                            }
                            break;

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
    // $ANTLR end "ruleHintedExpression"


    // $ANTLR start "entryRuleIndentationHint"
    // InternalTemplateLang.g:442:1: entryRuleIndentationHint returns [EObject current=null] : iv_ruleIndentationHint= ruleIndentationHint EOF ;
    public final EObject entryRuleIndentationHint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHint = null;


        try {
            // InternalTemplateLang.g:442:56: (iv_ruleIndentationHint= ruleIndentationHint EOF )
            // InternalTemplateLang.g:443:2: iv_ruleIndentationHint= ruleIndentationHint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndentationHint=ruleIndentationHint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:449:1: ruleIndentationHint returns [EObject current=null] : (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) ;
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
            // InternalTemplateLang.g:455:2: ( (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' ) )
            // InternalTemplateLang.g:456:2: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            {
            // InternalTemplateLang.g:456:2: (otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')' )
            // InternalTemplateLang.g:457:3: otherlv_0= '@indent' otherlv_1= '(' ( (lv_parts_2_0= ruleIndentationHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIndentationHintAccess().getIndentKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIndentationHintAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:465:3: ( (lv_parts_2_0= ruleIndentationHintPart ) )
            // InternalTemplateLang.g:466:4: (lv_parts_2_0= ruleIndentationHintPart )
            {
            // InternalTemplateLang.g:466:4: (lv_parts_2_0= ruleIndentationHintPart )
            // InternalTemplateLang.g:467:5: lv_parts_2_0= ruleIndentationHintPart
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.IndentationHintPart");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:484:3: (otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTemplateLang.g:485:4: otherlv_3= ',' ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getIndentationHintAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:489:4: ( (lv_parts_4_0= ruleIndentationHintPart ) )
            	    // InternalTemplateLang.g:490:5: (lv_parts_4_0= ruleIndentationHintPart )
            	    {
            	    // InternalTemplateLang.g:490:5: (lv_parts_4_0= ruleIndentationHintPart )
            	    // InternalTemplateLang.g:491:6: lv_parts_4_0= ruleIndentationHintPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getIndentationHintAccess().getPartsIndentationHintPartParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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
            	      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.IndentationHintPart");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:517:1: entryRuleIndentationHintPart returns [EObject current=null] : iv_ruleIndentationHintPart= ruleIndentationHintPart EOF ;
    public final EObject entryRuleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndentationHintPart = null;


        try {
            // InternalTemplateLang.g:517:60: (iv_ruleIndentationHintPart= ruleIndentationHintPart EOF )
            // InternalTemplateLang.g:518:2: iv_ruleIndentationHintPart= ruleIndentationHintPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndentationHintPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIndentationHintPart=ruleIndentationHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndentationHintPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:524:1: ruleIndentationHintPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleIndentationHintPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:530:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) ) )
            // InternalTemplateLang.g:531:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            {
            // InternalTemplateLang.g:531:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) ) )
            // InternalTemplateLang.g:532:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_NUMBER ) )
            {
            // InternalTemplateLang.g:532:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:533:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:533:4: (lv_name_0_0= ruleIdentifier )
            // InternalTemplateLang.g:534:5: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIndentationHintPartAccess().getNameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIndentationHintPartAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalTemplateLang.g:555:3: ( (lv_value_2_0= RULE_NUMBER ) )
            // InternalTemplateLang.g:556:4: (lv_value_2_0= RULE_NUMBER )
            {
            // InternalTemplateLang.g:556:4: (lv_value_2_0= RULE_NUMBER )
            // InternalTemplateLang.g:557:5: lv_value_2_0= RULE_NUMBER
            {
            lv_value_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NUMBER");
              				
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


    // $ANTLR start "entryRuleFormattingHint"
    // InternalTemplateLang.g:577:1: entryRuleFormattingHint returns [EObject current=null] : iv_ruleFormattingHint= ruleFormattingHint EOF ;
    public final EObject entryRuleFormattingHint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormattingHint = null;


        try {
            // InternalTemplateLang.g:577:55: (iv_ruleFormattingHint= ruleFormattingHint EOF )
            // InternalTemplateLang.g:578:2: iv_ruleFormattingHint= ruleFormattingHint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormattingHintRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFormattingHint=ruleFormattingHint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormattingHint; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormattingHint"


    // $ANTLR start "ruleFormattingHint"
    // InternalTemplateLang.g:584:1: ruleFormattingHint returns [EObject current=null] : (otherlv_0= '@format' otherlv_1= '(' ( (lv_parts_2_0= ruleFormattingHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleFormattingHint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parts_2_0 = null;

        EObject lv_parts_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:590:2: ( (otherlv_0= '@format' otherlv_1= '(' ( (lv_parts_2_0= ruleFormattingHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )* otherlv_5= ')' ) )
            // InternalTemplateLang.g:591:2: (otherlv_0= '@format' otherlv_1= '(' ( (lv_parts_2_0= ruleFormattingHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )* otherlv_5= ')' )
            {
            // InternalTemplateLang.g:591:2: (otherlv_0= '@format' otherlv_1= '(' ( (lv_parts_2_0= ruleFormattingHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )* otherlv_5= ')' )
            // InternalTemplateLang.g:592:3: otherlv_0= '@format' otherlv_1= '(' ( (lv_parts_2_0= ruleFormattingHintPart ) ) (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFormattingHintAccess().getFormatKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFormattingHintAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:600:3: ( (lv_parts_2_0= ruleFormattingHintPart ) )
            // InternalTemplateLang.g:601:4: (lv_parts_2_0= ruleFormattingHintPart )
            {
            // InternalTemplateLang.g:601:4: (lv_parts_2_0= ruleFormattingHintPart )
            // InternalTemplateLang.g:602:5: lv_parts_2_0= ruleFormattingHintPart
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFormattingHintAccess().getPartsFormattingHintPartParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_parts_2_0=ruleFormattingHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFormattingHintRule());
              					}
              					add(
              						current,
              						"parts",
              						lv_parts_2_0,
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.FormattingHintPart");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:619:3: (otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalTemplateLang.g:620:4: otherlv_3= ',' ( (lv_parts_4_0= ruleFormattingHintPart ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getFormattingHintAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:624:4: ( (lv_parts_4_0= ruleFormattingHintPart ) )
            	    // InternalTemplateLang.g:625:5: (lv_parts_4_0= ruleFormattingHintPart )
            	    {
            	    // InternalTemplateLang.g:625:5: (lv_parts_4_0= ruleFormattingHintPart )
            	    // InternalTemplateLang.g:626:6: lv_parts_4_0= ruleFormattingHintPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFormattingHintAccess().getPartsFormattingHintPartParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_parts_4_0=ruleFormattingHintPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFormattingHintRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parts",
            	      							lv_parts_4_0,
            	      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.FormattingHintPart");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFormattingHintAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormattingHint"


    // $ANTLR start "entryRuleFormattingHintPart"
    // InternalTemplateLang.g:652:1: entryRuleFormattingHintPart returns [EObject current=null] : iv_ruleFormattingHintPart= ruleFormattingHintPart EOF ;
    public final EObject entryRuleFormattingHintPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormattingHintPart = null;


        try {
            // InternalTemplateLang.g:652:59: (iv_ruleFormattingHintPart= ruleFormattingHintPart EOF )
            // InternalTemplateLang.g:653:2: iv_ruleFormattingHintPart= ruleFormattingHintPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFormattingHintPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFormattingHintPart=ruleFormattingHintPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFormattingHintPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormattingHintPart"


    // $ANTLR start "ruleFormattingHintPart"
    // InternalTemplateLang.g:659:1: ruleFormattingHintPart returns [EObject current=null] : ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) ) ) ;
    public final EObject ruleFormattingHintPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token lv_numValue_3_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:665:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) ) ) )
            // InternalTemplateLang.g:666:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) ) )
            {
            // InternalTemplateLang.g:666:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) ) )
            // InternalTemplateLang.g:667:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) )
            {
            // InternalTemplateLang.g:667:3: ( (lv_name_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:668:4: (lv_name_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:668:4: (lv_name_0_0= ruleIdentifier )
            // InternalTemplateLang.g:669:5: lv_name_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFormattingHintPartAccess().getNameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_name_0_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFormattingHintPartRule());
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

            otherlv_1=(Token)match(input,23,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFormattingHintPartAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalTemplateLang.g:690:3: ( ( (lv_value_2_0= RULE_STRING ) ) | ( (lv_numValue_3_0= RULE_NUMBER ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_NUMBER) ) {
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
                    // InternalTemplateLang.g:691:4: ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // InternalTemplateLang.g:691:4: ( (lv_value_2_0= RULE_STRING ) )
                    // InternalTemplateLang.g:692:5: (lv_value_2_0= RULE_STRING )
                    {
                    // InternalTemplateLang.g:692:5: (lv_value_2_0= RULE_STRING )
                    // InternalTemplateLang.g:693:6: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_0, grammarAccess.getFormattingHintPartAccess().getValueSTRINGTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFormattingHintPartRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:710:4: ( (lv_numValue_3_0= RULE_NUMBER ) )
                    {
                    // InternalTemplateLang.g:710:4: ( (lv_numValue_3_0= RULE_NUMBER ) )
                    // InternalTemplateLang.g:711:5: (lv_numValue_3_0= RULE_NUMBER )
                    {
                    // InternalTemplateLang.g:711:5: (lv_numValue_3_0= RULE_NUMBER )
                    // InternalTemplateLang.g:712:6: lv_numValue_3_0= RULE_NUMBER
                    {
                    lv_numValue_3_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_numValue_3_0, grammarAccess.getFormattingHintPartAccess().getNumValueNUMBERTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getFormattingHintPartRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"numValue",
                      							lv_numValue_3_0,
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.NUMBER");
                      					
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
    // $ANTLR end "ruleFormattingHintPart"


    // $ANTLR start "entryRuleVilDef"
    // InternalTemplateLang.g:733:1: entryRuleVilDef returns [EObject current=null] : iv_ruleVilDef= ruleVilDef EOF ;
    public final EObject entryRuleVilDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVilDef = null;


        try {
            // InternalTemplateLang.g:733:47: (iv_ruleVilDef= ruleVilDef EOF )
            // InternalTemplateLang.g:734:2: iv_ruleVilDef= ruleVilDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVilDefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVilDef=ruleVilDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVilDef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:740:1: ruleVilDef returns [EObject current=null] : ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? ( (lv_protected_1_0= 'protected' ) )? otherlv_2= 'def' ( (lv_type_3_0= ruleType ) )? ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleParameterList ) )? otherlv_7= ')' ( (lv_stmts_8_0= ruleStmtBlock ) ) (otherlv_9= ';' )? ) ;
    public final EObject ruleVilDef() throws RecognitionException {
        EObject current = null;

        Token lv_protected_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_annotations_0_0 = null;

        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_id_4_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_stmts_8_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:746:2: ( ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? ( (lv_protected_1_0= 'protected' ) )? otherlv_2= 'def' ( (lv_type_3_0= ruleType ) )? ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleParameterList ) )? otherlv_7= ')' ( (lv_stmts_8_0= ruleStmtBlock ) ) (otherlv_9= ';' )? ) )
            // InternalTemplateLang.g:747:2: ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? ( (lv_protected_1_0= 'protected' ) )? otherlv_2= 'def' ( (lv_type_3_0= ruleType ) )? ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleParameterList ) )? otherlv_7= ')' ( (lv_stmts_8_0= ruleStmtBlock ) ) (otherlv_9= ';' )? )
            {
            // InternalTemplateLang.g:747:2: ( ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? ( (lv_protected_1_0= 'protected' ) )? otherlv_2= 'def' ( (lv_type_3_0= ruleType ) )? ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleParameterList ) )? otherlv_7= ')' ( (lv_stmts_8_0= ruleStmtBlock ) ) (otherlv_9= ';' )? )
            // InternalTemplateLang.g:748:3: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )? ( (lv_protected_1_0= 'protected' ) )? otherlv_2= 'def' ( (lv_type_3_0= ruleType ) )? ( (lv_id_4_0= ruleIdentifier ) ) otherlv_5= '(' ( (lv_param_6_0= ruleParameterList ) )? otherlv_7= ')' ( (lv_stmts_8_0= ruleStmtBlock ) ) (otherlv_9= ';' )?
            {
            // InternalTemplateLang.g:748:3: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case 75:
                    {
                    alt15=1;
                    }
                    break;
                case 25:
                    {
                    int LA15_2 = input.LA(2);

                    if ( (synpred18_InternalTemplateLang()) ) {
                        alt15=1;
                    }
                    }
                    break;
                case 26:
                    {
                    int LA15_3 = input.LA(2);

                    if ( (synpred18_InternalTemplateLang()) ) {
                        alt15=1;
                    }
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // InternalTemplateLang.g:749:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
                    {
                    // InternalTemplateLang.g:749:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
                    // InternalTemplateLang.g:750:5: lv_annotations_0_0= ruleAnnotationDeclarations
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVilDefAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_21);
                    lv_annotations_0_0=ruleAnnotationDeclarations();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVilDefRule());
                      					}
                      					set(
                      						current,
                      						"annotations",
                      						lv_annotations_0_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.AnnotationDeclarations");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTemplateLang.g:767:3: ( (lv_protected_1_0= 'protected' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTemplateLang.g:768:4: (lv_protected_1_0= 'protected' )
                    {
                    // InternalTemplateLang.g:768:4: (lv_protected_1_0= 'protected' )
                    // InternalTemplateLang.g:769:5: lv_protected_1_0= 'protected'
                    {
                    lv_protected_1_0=(Token)match(input,25,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_protected_1_0, grammarAccess.getVilDefAccess().getProtectedProtectedKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVilDefRule());
                      					}
                      					setWithLastConsumed(current, "protected", lv_protected_1_0, "protected");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,26,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVilDefAccess().getDefKeyword_2());
              		
            }
            // InternalTemplateLang.g:785:3: ( (lv_type_3_0= ruleType ) )?
            int alt17=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==RULE_ID||(LA17_1>=RULE_VERSION && LA17_1<=RULE_EXPONENT)||LA17_1==51||LA17_1==76) ) {
                        alt17=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==RULE_ID||(LA17_2>=RULE_VERSION && LA17_2<=RULE_EXPONENT)||LA17_2==51||LA17_2==76) ) {
                        alt17=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (LA17_3==RULE_ID||(LA17_3>=RULE_VERSION && LA17_3<=RULE_EXPONENT)||LA17_3==51||LA17_3==76) ) {
                        alt17=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (LA17_4==RULE_ID||(LA17_4>=RULE_VERSION && LA17_4<=RULE_EXPONENT)||LA17_4==51||LA17_4==76) ) {
                        alt17=1;
                    }
                    }
                    break;
                case 80:
                case 81:
                case 82:
                case 83:
                    {
                    alt17=1;
                    }
                    break;
            }

            switch (alt17) {
                case 1 :
                    // InternalTemplateLang.g:786:4: (lv_type_3_0= ruleType )
                    {
                    // InternalTemplateLang.g:786:4: (lv_type_3_0= ruleType )
                    // InternalTemplateLang.g:787:5: lv_type_3_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVilDefAccess().getTypeTypeParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_type_3_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVilDefRule());
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

            // InternalTemplateLang.g:804:3: ( (lv_id_4_0= ruleIdentifier ) )
            // InternalTemplateLang.g:805:4: (lv_id_4_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:805:4: (lv_id_4_0= ruleIdentifier )
            // InternalTemplateLang.g:806:5: lv_id_4_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVilDefAccess().getIdIdentifierParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_id_4_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVilDefRule());
              					}
              					set(
              						current,
              						"id",
              						lv_id_4_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getVilDefAccess().getLeftParenthesisKeyword_5());
              		
            }
            // InternalTemplateLang.g:827:3: ( (lv_param_6_0= ruleParameterList ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||(LA18_0>=RULE_VERSION && LA18_0<=RULE_EXPONENT)||LA18_0==51||(LA18_0>=80 && LA18_0<=83)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTemplateLang.g:828:4: (lv_param_6_0= ruleParameterList )
                    {
                    // InternalTemplateLang.g:828:4: (lv_param_6_0= ruleParameterList )
                    // InternalTemplateLang.g:829:5: lv_param_6_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVilDefAccess().getParamParameterListParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
                    lv_param_6_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVilDefRule());
                      					}
                      					set(
                      						current,
                      						"param",
                      						lv_param_6_0,
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ParameterList");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getVilDefAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalTemplateLang.g:850:3: ( (lv_stmts_8_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:851:4: (lv_stmts_8_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:851:4: (lv_stmts_8_0= ruleStmtBlock )
            // InternalTemplateLang.g:852:5: lv_stmts_8_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVilDefAccess().getStmtsStmtBlockParserRuleCall_8_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_stmts_8_0=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVilDefRule());
              					}
              					set(
              						current,
              						"stmts",
              						lv_stmts_8_0,
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:869:3: (otherlv_9= ';' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalTemplateLang.g:870:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getVilDefAccess().getSemicolonKeyword_9());
                      			
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
    // InternalTemplateLang.g:879:1: entryRuleStmtBlock returns [EObject current=null] : iv_ruleStmtBlock= ruleStmtBlock EOF ;
    public final EObject entryRuleStmtBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmtBlock = null;


        try {
            // InternalTemplateLang.g:879:50: (iv_ruleStmtBlock= ruleStmtBlock EOF )
            // InternalTemplateLang.g:880:2: iv_ruleStmtBlock= ruleStmtBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStmtBlock=ruleStmtBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmtBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:886:1: ruleStmtBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) ;
    public final EObject ruleStmtBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_stmts_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:892:2: ( ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' ) )
            // InternalTemplateLang.g:893:2: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            {
            // InternalTemplateLang.g:893:2: ( () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}' )
            // InternalTemplateLang.g:894:3: () otherlv_1= '{' ( (lv_stmts_2_0= ruleStmt ) )* otherlv_3= '}'
            {
            // InternalTemplateLang.g:894:3: ()
            // InternalTemplateLang.g:895:4: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStmtBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalTemplateLang.g:908:3: ( (lv_stmts_2_0= ruleStmt ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_EXPONENT)||LA20_0==14||LA20_0==17||LA20_0==28||LA20_0==30||LA20_0==32||(LA20_0>=35 && LA20_0<=38)||LA20_0==44||LA20_0==51||LA20_0==67||(LA20_0>=69 && LA20_0<=71)||(LA20_0>=77 && LA20_0<=83)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTemplateLang.g:909:4: (lv_stmts_2_0= ruleStmt )
            	    {
            	    // InternalTemplateLang.g:909:4: (lv_stmts_2_0= ruleStmt )
            	    // InternalTemplateLang.g:910:5: lv_stmts_2_0= ruleStmt
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStmtBlockAccess().getStmtsStmtParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
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
            	      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Stmt");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:935:1: entryRuleStmt returns [EObject current=null] : iv_ruleStmt= ruleStmt EOF ;
    public final EObject entryRuleStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStmt = null;


        try {
            // InternalTemplateLang.g:935:45: (iv_ruleStmt= ruleStmt EOF )
            // InternalTemplateLang.g:936:2: iv_ruleStmt= ruleStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStmtRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStmt=ruleStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStmt; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:942:1: ruleStmt returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_multi_3_0= rulemultiselect ) ) | ( (lv_loop_4_0= ruleLoop ) ) | ( (lv_while_5_0= ruleWhile ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) | ( (lv_flush_8_0= ruleFlush ) ) ) ;
    public final EObject ruleStmt() throws RecognitionException {
        EObject current = null;

        EObject lv_var_0_0 = null;

        EObject lv_alt_1_0 = null;

        EObject lv_switch_2_0 = null;

        EObject lv_multi_3_0 = null;

        EObject lv_loop_4_0 = null;

        EObject lv_while_5_0 = null;

        EObject lv_exprStmt_6_0 = null;

        EObject lv_ctn_7_0 = null;

        AntlrDatatypeRuleToken lv_flush_8_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:948:2: ( ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_multi_3_0= rulemultiselect ) ) | ( (lv_loop_4_0= ruleLoop ) ) | ( (lv_while_5_0= ruleWhile ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) | ( (lv_flush_8_0= ruleFlush ) ) ) )
            // InternalTemplateLang.g:949:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_multi_3_0= rulemultiselect ) ) | ( (lv_loop_4_0= ruleLoop ) ) | ( (lv_while_5_0= ruleWhile ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) | ( (lv_flush_8_0= ruleFlush ) ) )
            {
            // InternalTemplateLang.g:949:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_multi_3_0= rulemultiselect ) ) | ( (lv_loop_4_0= ruleLoop ) ) | ( (lv_while_5_0= ruleWhile ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) | ( (lv_flush_8_0= ruleFlush ) ) )
            int alt21=9;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalTemplateLang.g:950:3: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    {
                    // InternalTemplateLang.g:950:3: ( (lv_var_0_0= ruleVariableDeclaration ) )
                    // InternalTemplateLang.g:951:4: (lv_var_0_0= ruleVariableDeclaration )
                    {
                    // InternalTemplateLang.g:951:4: (lv_var_0_0= ruleVariableDeclaration )
                    // InternalTemplateLang.g:952:5: lv_var_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.VariableDeclaration");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:970:3: ( (lv_alt_1_0= ruleAlternative ) )
                    {
                    // InternalTemplateLang.g:970:3: ( (lv_alt_1_0= ruleAlternative ) )
                    // InternalTemplateLang.g:971:4: (lv_alt_1_0= ruleAlternative )
                    {
                    // InternalTemplateLang.g:971:4: (lv_alt_1_0= ruleAlternative )
                    // InternalTemplateLang.g:972:5: lv_alt_1_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getAltAlternativeParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Alternative");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalTemplateLang.g:990:3: ( (lv_switch_2_0= ruleSwitch ) )
                    {
                    // InternalTemplateLang.g:990:3: ( (lv_switch_2_0= ruleSwitch ) )
                    // InternalTemplateLang.g:991:4: (lv_switch_2_0= ruleSwitch )
                    {
                    // InternalTemplateLang.g:991:4: (lv_switch_2_0= ruleSwitch )
                    // InternalTemplateLang.g:992:5: lv_switch_2_0= ruleSwitch
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getSwitchSwitchParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Switch");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalTemplateLang.g:1010:3: ( (lv_multi_3_0= rulemultiselect ) )
                    {
                    // InternalTemplateLang.g:1010:3: ( (lv_multi_3_0= rulemultiselect ) )
                    // InternalTemplateLang.g:1011:4: (lv_multi_3_0= rulemultiselect )
                    {
                    // InternalTemplateLang.g:1011:4: (lv_multi_3_0= rulemultiselect )
                    // InternalTemplateLang.g:1012:5: lv_multi_3_0= rulemultiselect
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_multi_3_0=rulemultiselect();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStmtRule());
                      					}
                      					set(
                      						current,
                      						"multi",
                      						lv_multi_3_0,
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.multiselect");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalTemplateLang.g:1030:3: ( (lv_loop_4_0= ruleLoop ) )
                    {
                    // InternalTemplateLang.g:1030:3: ( (lv_loop_4_0= ruleLoop ) )
                    // InternalTemplateLang.g:1031:4: (lv_loop_4_0= ruleLoop )
                    {
                    // InternalTemplateLang.g:1031:4: (lv_loop_4_0= ruleLoop )
                    // InternalTemplateLang.g:1032:5: lv_loop_4_0= ruleLoop
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getLoopLoopParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_loop_4_0=ruleLoop();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStmtRule());
                      					}
                      					set(
                      						current,
                      						"loop",
                      						lv_loop_4_0,
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Loop");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalTemplateLang.g:1050:3: ( (lv_while_5_0= ruleWhile ) )
                    {
                    // InternalTemplateLang.g:1050:3: ( (lv_while_5_0= ruleWhile ) )
                    // InternalTemplateLang.g:1051:4: (lv_while_5_0= ruleWhile )
                    {
                    // InternalTemplateLang.g:1051:4: (lv_while_5_0= ruleWhile )
                    // InternalTemplateLang.g:1052:5: lv_while_5_0= ruleWhile
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getWhileWhileParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_while_5_0=ruleWhile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStmtRule());
                      					}
                      					set(
                      						current,
                      						"while",
                      						lv_while_5_0,
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.While");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalTemplateLang.g:1070:3: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    {
                    // InternalTemplateLang.g:1070:3: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
                    // InternalTemplateLang.g:1071:4: (lv_exprStmt_6_0= ruleExpressionStatement )
                    {
                    // InternalTemplateLang.g:1071:4: (lv_exprStmt_6_0= ruleExpressionStatement )
                    // InternalTemplateLang.g:1072:5: lv_exprStmt_6_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.ExpressionStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalTemplateLang.g:1090:3: ( (lv_ctn_7_0= ruleContent ) )
                    {
                    // InternalTemplateLang.g:1090:3: ( (lv_ctn_7_0= ruleContent ) )
                    // InternalTemplateLang.g:1091:4: (lv_ctn_7_0= ruleContent )
                    {
                    // InternalTemplateLang.g:1091:4: (lv_ctn_7_0= ruleContent )
                    // InternalTemplateLang.g:1092:5: lv_ctn_7_0= ruleContent
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getCtnContentParserRuleCall_7_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Content");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalTemplateLang.g:1110:3: ( (lv_flush_8_0= ruleFlush ) )
                    {
                    // InternalTemplateLang.g:1110:3: ( (lv_flush_8_0= ruleFlush ) )
                    // InternalTemplateLang.g:1111:4: (lv_flush_8_0= ruleFlush )
                    {
                    // InternalTemplateLang.g:1111:4: (lv_flush_8_0= ruleFlush )
                    // InternalTemplateLang.g:1112:5: lv_flush_8_0= ruleFlush
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStmtAccess().getFlushFlushParserRuleCall_8_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_flush_8_0=ruleFlush();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStmtRule());
                      					}
                      					set(
                      						current,
                      						"flush",
                      						lv_flush_8_0,
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Flush");
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
    // InternalTemplateLang.g:1133:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // InternalTemplateLang.g:1133:52: (iv_ruleAlternative= ruleAlternative EOF )
            // InternalTemplateLang.g:1134:2: iv_ruleAlternative= ruleAlternative EOF
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
    // InternalTemplateLang.g:1140:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )? ) ;
    public final EObject ruleAlternative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_if_4_0 = null;

        EObject lv_ifBlock_5_0 = null;

        EObject lv_else_7_0 = null;

        EObject lv_elseBlock_8_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1146:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )? ) )
            // InternalTemplateLang.g:1147:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )? )
            {
            // InternalTemplateLang.g:1147:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )? )
            // InternalTemplateLang.g:1148:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:1156:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalTemplateLang.g:1157:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalTemplateLang.g:1157:4: (lv_expr_2_0= ruleExpression )
            // InternalTemplateLang.g:1158:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,15,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalTemplateLang.g:1179:3: ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalTemplateLang.g:1180:4: ( (lv_if_4_0= ruleStmt ) )
                    {
                    // InternalTemplateLang.g:1180:4: ( (lv_if_4_0= ruleStmt ) )
                    // InternalTemplateLang.g:1181:5: (lv_if_4_0= ruleStmt )
                    {
                    // InternalTemplateLang.g:1181:5: (lv_if_4_0= ruleStmt )
                    // InternalTemplateLang.g:1182:6: lv_if_4_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAlternativeAccess().getIfStmtParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
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
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Stmt");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:1200:4: ( (lv_ifBlock_5_0= ruleStmtBlock ) )
                    {
                    // InternalTemplateLang.g:1200:4: ( (lv_ifBlock_5_0= ruleStmtBlock ) )
                    // InternalTemplateLang.g:1201:5: (lv_ifBlock_5_0= ruleStmtBlock )
                    {
                    // InternalTemplateLang.g:1201:5: (lv_ifBlock_5_0= ruleStmtBlock )
                    // InternalTemplateLang.g:1202:6: lv_ifBlock_5_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAlternativeAccess().getIfBlockStmtBlockParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
                    lv_ifBlock_5_0=ruleStmtBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAlternativeRule());
                      						}
                      						set(
                      							current,
                      							"ifBlock",
                      							lv_ifBlock_5_0,
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalTemplateLang.g:1220:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==29) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred35_InternalTemplateLang()) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // InternalTemplateLang.g:1221:4: ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )
                    {
                    // InternalTemplateLang.g:1221:4: ( ( 'else' )=>otherlv_6= 'else' )
                    // InternalTemplateLang.g:1222:5: ( 'else' )=>otherlv_6= 'else'
                    {
                    otherlv_6=(Token)match(input,29,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalTemplateLang.g:1228:4: ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )
                    int alt23=2;
                    alt23 = dfa23.predict(input);
                    switch (alt23) {
                        case 1 :
                            // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
                            {
                            // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
                            // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
                            {
                            // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
                            // InternalTemplateLang.g:1231:7: lv_else_7_0= ruleStmt
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_else_7_0=ruleStmt();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAlternativeRule());
                              							}
                              							set(
                              								current,
                              								"else",
                              								lv_else_7_0,
                              								"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Stmt");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTemplateLang.g:1249:5: ( (lv_elseBlock_8_0= ruleStmtBlock ) )
                            {
                            // InternalTemplateLang.g:1249:5: ( (lv_elseBlock_8_0= ruleStmtBlock ) )
                            // InternalTemplateLang.g:1250:6: (lv_elseBlock_8_0= ruleStmtBlock )
                            {
                            // InternalTemplateLang.g:1250:6: (lv_elseBlock_8_0= ruleStmtBlock )
                            // InternalTemplateLang.g:1251:7: lv_elseBlock_8_0= ruleStmtBlock
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAlternativeAccess().getElseBlockStmtBlockParserRuleCall_5_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_elseBlock_8_0=ruleStmtBlock();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAlternativeRule());
                              							}
                              							set(
                              								current,
                              								"elseBlock",
                              								lv_elseBlock_8_0,
                              								"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
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


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
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
    // InternalTemplateLang.g:1274:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // InternalTemplateLang.g:1274:48: (iv_ruleContent= ruleContent EOF )
            // InternalTemplateLang.g:1275:2: iv_ruleContent= ruleContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContent=ruleContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContent; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1281:1: ruleContent returns [EObject current=null] : ( ( (lv_ctn_0_0= RULE_STRING ) ) ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )? ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        Token lv_ctn_0_0=null;
        Token lv_noCR_1_0=null;
        Token lv_CR_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_indent_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1287:2: ( ( ( (lv_ctn_0_0= RULE_STRING ) ) ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )? ) )
            // InternalTemplateLang.g:1288:2: ( ( (lv_ctn_0_0= RULE_STRING ) ) ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )? )
            {
            // InternalTemplateLang.g:1288:2: ( ( (lv_ctn_0_0= RULE_STRING ) ) ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )? )
            // InternalTemplateLang.g:1289:3: ( (lv_ctn_0_0= RULE_STRING ) ) ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )?
            {
            // InternalTemplateLang.g:1289:3: ( (lv_ctn_0_0= RULE_STRING ) )
            // InternalTemplateLang.g:1290:4: (lv_ctn_0_0= RULE_STRING )
            {
            // InternalTemplateLang.g:1290:4: (lv_ctn_0_0= RULE_STRING )
            // InternalTemplateLang.g:1291:5: lv_ctn_0_0= RULE_STRING
            {
            lv_ctn_0_0=(Token)match(input,RULE_STRING,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_ctn_0_0, grammarAccess.getContentAccess().getCtnSTRINGTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContentRule());
              					}
              					setWithLastConsumed(
              						current,
              						"ctn",
              						lv_ctn_0_0,
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.STRING");
              				
            }

            }


            }

            // InternalTemplateLang.g:1307:3: ( ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==30) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==31) ) {
                    alt28=1;
                }
            }
            else if ( (LA28_0==19||LA28_0==27||LA28_0==31) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTemplateLang.g:1308:4: ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )? (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )? otherlv_5= ';'
                    {
                    // InternalTemplateLang.g:1308:4: ( ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=30 && LA26_0<=31)) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalTemplateLang.g:1309:5: ( (lv_noCR_1_0= '!' ) )? ( (lv_CR_2_0= '<CR>' ) )
                            {
                            // InternalTemplateLang.g:1309:5: ( (lv_noCR_1_0= '!' ) )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==30) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // InternalTemplateLang.g:1310:6: (lv_noCR_1_0= '!' )
                                    {
                                    // InternalTemplateLang.g:1310:6: (lv_noCR_1_0= '!' )
                                    // InternalTemplateLang.g:1311:7: lv_noCR_1_0= '!'
                                    {
                                    lv_noCR_1_0=(Token)match(input,30,FOLLOW_30); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(lv_noCR_1_0, grammarAccess.getContentAccess().getNoCRExclamationMarkKeyword_1_0_0_0());
                                      						
                                    }
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElement(grammarAccess.getContentRule());
                                      							}
                                      							setWithLastConsumed(current, "noCR", lv_noCR_1_0, "!");
                                      						
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalTemplateLang.g:1323:5: ( (lv_CR_2_0= '<CR>' ) )
                            // InternalTemplateLang.g:1324:6: (lv_CR_2_0= '<CR>' )
                            {
                            // InternalTemplateLang.g:1324:6: (lv_CR_2_0= '<CR>' )
                            // InternalTemplateLang.g:1325:7: lv_CR_2_0= '<CR>'
                            {
                            lv_CR_2_0=(Token)match(input,31,FOLLOW_31); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_CR_2_0, grammarAccess.getContentAccess().getCRCRKeyword_1_0_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getContentRule());
                              							}
                              							setWithLastConsumed(current, "CR", lv_CR_2_0, "<CR>");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalTemplateLang.g:1338:4: (otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==19) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // InternalTemplateLang.g:1339:5: otherlv_3= '|' ( (lv_indent_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,19,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getContentAccess().getVerticalLineKeyword_1_1_0());
                              				
                            }
                            // InternalTemplateLang.g:1343:5: ( (lv_indent_4_0= ruleExpression ) )
                            // InternalTemplateLang.g:1344:6: (lv_indent_4_0= ruleExpression )
                            {
                            // InternalTemplateLang.g:1344:6: (lv_indent_4_0= ruleExpression )
                            // InternalTemplateLang.g:1345:7: lv_indent_4_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getContentAccess().getIndentExpressionParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            lv_indent_4_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getContentRule());
                              							}
                              							set(
                              								current,
                              								"indent",
                              								lv_indent_4_0,
                              								"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getContentAccess().getSemicolonKeyword_1_2());
                      			
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
    // InternalTemplateLang.g:1372:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // InternalTemplateLang.g:1372:47: (iv_ruleSwitch= ruleSwitch EOF )
            // InternalTemplateLang.g:1373:2: iv_ruleSwitch= ruleSwitch EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitch; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1379:1: ruleSwitch returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) ;
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
            // InternalTemplateLang.g:1385:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' ) )
            // InternalTemplateLang.g:1386:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            {
            // InternalTemplateLang.g:1386:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}' )
            // InternalTemplateLang.g:1387:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:1395:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalTemplateLang.g:1396:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalTemplateLang.g:1396:4: (lv_expr_2_0= ruleExpression )
            // InternalTemplateLang.g:1397:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,17,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalTemplateLang.g:1422:3: ( ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )? )
            // InternalTemplateLang.g:1423:4: ( (lv_parts_5_0= ruleSwitchPart ) ) (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )* (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            {
            // InternalTemplateLang.g:1423:4: ( (lv_parts_5_0= ruleSwitchPart ) )
            // InternalTemplateLang.g:1424:5: (lv_parts_5_0= ruleSwitchPart )
            {
            // InternalTemplateLang.g:1424:5: (lv_parts_5_0= ruleSwitchPart )
            // InternalTemplateLang.g:1425:6: lv_parts_5_0= ruleSwitchPart
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_0_0());
              					
            }
            pushFollow(FOLLOW_33);
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
              							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.SwitchPart");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalTemplateLang.g:1442:4: (otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==22) ) {
                    int LA29_1 = input.LA(2);

                    if ( ((LA29_1>=RULE_ID && LA29_1<=RULE_EXPONENT)||LA29_1==14||LA29_1==17||LA29_1==30||LA29_1==51||LA29_1==67||(LA29_1>=69 && LA29_1<=71)||(LA29_1>=77 && LA29_1<=79)) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalTemplateLang.g:1443:5: otherlv_6= ',' ( (lv_parts_7_0= ruleSwitchPart ) )
            	    {
            	    otherlv_6=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getCommaKeyword_5_1_0());
            	      				
            	    }
            	    // InternalTemplateLang.g:1447:5: ( (lv_parts_7_0= ruleSwitchPart ) )
            	    // InternalTemplateLang.g:1448:6: (lv_parts_7_0= ruleSwitchPart )
            	    {
            	    // InternalTemplateLang.g:1448:6: (lv_parts_7_0= ruleSwitchPart )
            	    // InternalTemplateLang.g:1449:7: lv_parts_7_0= ruleSwitchPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getSwitchAccess().getPartsSwitchPartParserRuleCall_5_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
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
            	      								"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.SwitchPart");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalTemplateLang.g:1467:4: (otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==22) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTemplateLang.g:1468:5: otherlv_8= ',' otherlv_9= 'default' otherlv_10= ':' ( (lv_dflt_11_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getSwitchAccess().getCommaKeyword_5_2_0());
                      				
                    }
                    otherlv_9=(Token)match(input,33,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_9, grammarAccess.getSwitchAccess().getDefaultKeyword_5_2_1());
                      				
                    }
                    otherlv_10=(Token)match(input,34,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getSwitchAccess().getColonKeyword_5_2_2());
                      				
                    }
                    // InternalTemplateLang.g:1480:5: ( (lv_dflt_11_0= ruleExpression ) )
                    // InternalTemplateLang.g:1481:6: (lv_dflt_11_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:1481:6: (lv_dflt_11_0= ruleExpression )
                    // InternalTemplateLang.g:1482:7: lv_dflt_11_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSwitchAccess().getDfltExpressionParserRuleCall_5_2_3_0());
                      						
                    }
                    pushFollow(FOLLOW_36);
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
                      								"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }
                    break;

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:1509:1: entryRuleSwitchPart returns [EObject current=null] : iv_ruleSwitchPart= ruleSwitchPart EOF ;
    public final EObject entryRuleSwitchPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchPart = null;


        try {
            // InternalTemplateLang.g:1509:51: (iv_ruleSwitchPart= ruleSwitchPart EOF )
            // InternalTemplateLang.g:1510:2: iv_ruleSwitchPart= ruleSwitchPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchPart=ruleSwitchPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1516:1: ruleSwitchPart returns [EObject current=null] : ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1522:2: ( ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) ) )
            // InternalTemplateLang.g:1523:2: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            {
            // InternalTemplateLang.g:1523:2: ( ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) ) )
            // InternalTemplateLang.g:1524:3: ( (lv_left_0_0= ruleExpression ) ) otherlv_1= ':' ( (lv_right_2_0= ruleExpression ) )
            {
            // InternalTemplateLang.g:1524:3: ( (lv_left_0_0= ruleExpression ) )
            // InternalTemplateLang.g:1525:4: (lv_left_0_0= ruleExpression )
            {
            // InternalTemplateLang.g:1525:4: (lv_left_0_0= ruleExpression )
            // InternalTemplateLang.g:1526:5: lv_left_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchPartAccess().getLeftExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchPartAccess().getColonKeyword_1());
              		
            }
            // InternalTemplateLang.g:1547:3: ( (lv_right_2_0= ruleExpression ) )
            // InternalTemplateLang.g:1548:4: (lv_right_2_0= ruleExpression )
            {
            // InternalTemplateLang.g:1548:4: (lv_right_2_0= ruleExpression )
            // InternalTemplateLang.g:1549:5: lv_right_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchPartAccess().getRightExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleSwitchPart"


    // $ANTLR start "entryRuleLoop"
    // InternalTemplateLang.g:1570:1: entryRuleLoop returns [EObject current=null] : iv_ruleLoop= ruleLoop EOF ;
    public final EObject entryRuleLoop() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop = null;


        try {
            // InternalTemplateLang.g:1570:45: (iv_ruleLoop= ruleLoop EOF )
            // InternalTemplateLang.g:1571:2: iv_ruleLoop= ruleLoop EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoop=ruleLoop();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoop; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1577:1: ruleLoop returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) ) ) ;
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

        EObject lv_block_12_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1583:2: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) ) ) )
            // InternalTemplateLang.g:1584:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) ) )
            {
            // InternalTemplateLang.g:1584:2: (otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) ) )
            // InternalTemplateLang.g:1585:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) ( (lv_id_3_0= ruleIdentifier ) ) otherlv_4= ':' ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )? otherlv_10= ')' ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLoopAccess().getForKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:1593:3: ( (lv_type_2_0= ruleType ) )
            // InternalTemplateLang.g:1594:4: (lv_type_2_0= ruleType )
            {
            // InternalTemplateLang.g:1594:4: (lv_type_2_0= ruleType )
            // InternalTemplateLang.g:1595:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:1612:3: ( (lv_id_3_0= ruleIdentifier ) )
            // InternalTemplateLang.g:1613:4: (lv_id_3_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:1613:4: (lv_id_3_0= ruleIdentifier )
            // InternalTemplateLang.g:1614:5: lv_id_3_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopAccess().getIdIdentifierParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_35);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,34,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getColonKeyword_4());
              		
            }
            // InternalTemplateLang.g:1635:3: ( (lv_expr_5_0= ruleExpression ) )
            // InternalTemplateLang.g:1636:4: (lv_expr_5_0= ruleExpression )
            {
            // InternalTemplateLang.g:1636:4: (lv_expr_5_0= ruleExpression )
            // InternalTemplateLang.g:1637:5: lv_expr_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopAccess().getExprExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_17);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:1654:3: (otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==22) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTemplateLang.g:1655:4: otherlv_6= ',' ( (lv_separator_7_0= rulePrimaryExpression ) ) (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getLoopAccess().getCommaKeyword_6_0());
                      			
                    }
                    // InternalTemplateLang.g:1659:4: ( (lv_separator_7_0= rulePrimaryExpression ) )
                    // InternalTemplateLang.g:1660:5: (lv_separator_7_0= rulePrimaryExpression )
                    {
                    // InternalTemplateLang.g:1660:5: (lv_separator_7_0= rulePrimaryExpression )
                    // InternalTemplateLang.g:1661:6: lv_separator_7_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getSeparatorPrimaryExpressionParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_17);
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
                      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.PrimaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalTemplateLang.g:1678:4: (otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==22) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalTemplateLang.g:1679:5: otherlv_8= ',' ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            {
                            otherlv_8=(Token)match(input,22,FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getCommaKeyword_6_2_0());
                              				
                            }
                            // InternalTemplateLang.g:1683:5: ( (lv_finalSeparator_9_0= rulePrimaryExpression ) )
                            // InternalTemplateLang.g:1684:6: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            {
                            // InternalTemplateLang.g:1684:6: (lv_finalSeparator_9_0= rulePrimaryExpression )
                            // InternalTemplateLang.g:1685:7: lv_finalSeparator_9_0= rulePrimaryExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getLoopAccess().getFinalSeparatorPrimaryExpressionParserRuleCall_6_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_11);
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
                              								"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.PrimaryExpression");
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

            otherlv_10=(Token)match(input,15,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLoopAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalTemplateLang.g:1708:3: ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalTemplateLang.g:1709:4: ( (lv_stmt_11_0= ruleStmt ) )
                    {
                    // InternalTemplateLang.g:1709:4: ( (lv_stmt_11_0= ruleStmt ) )
                    // InternalTemplateLang.g:1710:5: (lv_stmt_11_0= ruleStmt )
                    {
                    // InternalTemplateLang.g:1710:5: (lv_stmt_11_0= ruleStmt )
                    // InternalTemplateLang.g:1711:6: lv_stmt_11_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getStmtStmtParserRuleCall_8_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
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
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Stmt");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:1729:4: ( (lv_block_12_0= ruleStmtBlock ) )
                    {
                    // InternalTemplateLang.g:1729:4: ( (lv_block_12_0= ruleStmtBlock ) )
                    // InternalTemplateLang.g:1730:5: (lv_block_12_0= ruleStmtBlock )
                    {
                    // InternalTemplateLang.g:1730:5: (lv_block_12_0= ruleStmtBlock )
                    // InternalTemplateLang.g:1731:6: lv_block_12_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLoopAccess().getBlockStmtBlockParserRuleCall_8_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_12_0=ruleStmtBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLoopRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_12_0,
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
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
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleWhile"
    // InternalTemplateLang.g:1753:1: entryRuleWhile returns [EObject current=null] : iv_ruleWhile= ruleWhile EOF ;
    public final EObject entryRuleWhile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile = null;


        try {
            // InternalTemplateLang.g:1753:46: (iv_ruleWhile= ruleWhile EOF )
            // InternalTemplateLang.g:1754:2: iv_ruleWhile= ruleWhile EOF
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
    // InternalTemplateLang.g:1760:1: ruleWhile returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) ) ) ;
    public final EObject ruleWhile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expr_2_0 = null;

        EObject lv_stmt_4_0 = null;

        EObject lv_block_5_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1766:2: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) ) ) )
            // InternalTemplateLang.g:1767:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) ) )
            {
            // InternalTemplateLang.g:1767:2: (otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) ) )
            // InternalTemplateLang.g:1768:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhileAccess().getWhileKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getWhileAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:1776:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalTemplateLang.g:1777:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalTemplateLang.g:1777:4: (lv_expr_2_0= ruleExpression )
            // InternalTemplateLang.g:1778:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhileAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,15,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getWhileAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalTemplateLang.g:1799:3: ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) )
            int alt34=2;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // InternalTemplateLang.g:1800:4: ( (lv_stmt_4_0= ruleStmt ) )
                    {
                    // InternalTemplateLang.g:1800:4: ( (lv_stmt_4_0= ruleStmt ) )
                    // InternalTemplateLang.g:1801:5: (lv_stmt_4_0= ruleStmt )
                    {
                    // InternalTemplateLang.g:1801:5: (lv_stmt_4_0= ruleStmt )
                    // InternalTemplateLang.g:1802:6: lv_stmt_4_0= ruleStmt
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getWhileAccess().getStmtStmtParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_stmt_4_0=ruleStmt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getWhileRule());
                      						}
                      						set(
                      							current,
                      							"stmt",
                      							lv_stmt_4_0,
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.Stmt");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:1820:4: ( (lv_block_5_0= ruleStmtBlock ) )
                    {
                    // InternalTemplateLang.g:1820:4: ( (lv_block_5_0= ruleStmtBlock ) )
                    // InternalTemplateLang.g:1821:5: (lv_block_5_0= ruleStmtBlock )
                    {
                    // InternalTemplateLang.g:1821:5: (lv_block_5_0= ruleStmtBlock )
                    // InternalTemplateLang.g:1822:6: lv_block_5_0= ruleStmtBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getWhileAccess().getBlockStmtBlockParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_5_0=ruleStmtBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getWhileRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_5_0,
                      							"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
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
    // $ANTLR end "ruleWhile"


    // $ANTLR start "entryRuleFlush"
    // InternalTemplateLang.g:1844:1: entryRuleFlush returns [String current=null] : iv_ruleFlush= ruleFlush EOF ;
    public final String entryRuleFlush() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlush = null;


        try {
            // InternalTemplateLang.g:1844:45: (iv_ruleFlush= ruleFlush EOF )
            // InternalTemplateLang.g:1845:2: iv_ruleFlush= ruleFlush EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlushRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFlush=ruleFlush();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlush.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlush"


    // $ANTLR start "ruleFlush"
    // InternalTemplateLang.g:1851:1: ruleFlush returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'flush' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleFlush() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:1857:2: ( (kw= 'flush' kw= ';' ) )
            // InternalTemplateLang.g:1858:2: (kw= 'flush' kw= ';' )
            {
            // InternalTemplateLang.g:1858:2: (kw= 'flush' kw= ';' )
            // InternalTemplateLang.g:1859:3: kw= 'flush' kw= ';'
            {
            kw=(Token)match(input,37,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getFlushAccess().getFlushKeyword_0());
              		
            }
            kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getFlushAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlush"


    // $ANTLR start "entryRulemultiselect"
    // InternalTemplateLang.g:1873:1: entryRulemultiselect returns [EObject current=null] : iv_rulemultiselect= rulemultiselect EOF ;
    public final EObject entryRulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiselect = null;


        try {
            // InternalTemplateLang.g:1873:52: (iv_rulemultiselect= rulemultiselect EOF )
            // InternalTemplateLang.g:1874:2: iv_rulemultiselect= rulemultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiselectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulemultiselect=rulemultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiselect; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1880:1: rulemultiselect returns [EObject current=null] : ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) ;
    public final EObject rulemultiselect() throws RecognitionException {
        EObject current = null;

        EObject lv_gen_0_0 = null;

        EObject lv_user_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1886:2: ( ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) ) )
            // InternalTemplateLang.g:1887:2: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            {
            // InternalTemplateLang.g:1887:2: ( ( (lv_gen_0_0= rulegenericMultiselect ) ) | ( (lv_user_1_0= ruleuserMultiselect ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==38) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID||(LA35_0>=RULE_VERSION && LA35_0<=RULE_EXPONENT)||LA35_0==51) ) {
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
                    // InternalTemplateLang.g:1888:3: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    {
                    // InternalTemplateLang.g:1888:3: ( (lv_gen_0_0= rulegenericMultiselect ) )
                    // InternalTemplateLang.g:1889:4: (lv_gen_0_0= rulegenericMultiselect )
                    {
                    // InternalTemplateLang.g:1889:4: (lv_gen_0_0= rulegenericMultiselect )
                    // InternalTemplateLang.g:1890:5: lv_gen_0_0= rulegenericMultiselect
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getMultiselectAccess().getGenGenericMultiselectParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.genericMultiselect");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:1908:3: ( (lv_user_1_0= ruleuserMultiselect ) )
                    {
                    // InternalTemplateLang.g:1908:3: ( (lv_user_1_0= ruleuserMultiselect ) )
                    // InternalTemplateLang.g:1909:4: (lv_user_1_0= ruleuserMultiselect )
                    {
                    // InternalTemplateLang.g:1909:4: (lv_user_1_0= ruleuserMultiselect )
                    // InternalTemplateLang.g:1910:5: lv_user_1_0= ruleuserMultiselect
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getMultiselectAccess().getUserUserMultiselectParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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
                      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.userMultiselect");
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
    // InternalTemplateLang.g:1931:1: entryRulegenericMultiselect returns [EObject current=null] : iv_rulegenericMultiselect= rulegenericMultiselect EOF ;
    public final EObject entryRulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_rulegenericMultiselect = null;


        try {
            // InternalTemplateLang.g:1931:59: (iv_rulegenericMultiselect= rulegenericMultiselect EOF )
            // InternalTemplateLang.g:1932:2: iv_rulegenericMultiselect= rulegenericMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGenericMultiselectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulegenericMultiselect=rulegenericMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegenericMultiselect; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:1938:1: rulegenericMultiselect returns [EObject current=null] : (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) ;
    public final EObject rulegenericMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_preamble_1_0 = null;

        EObject lv_selector_2_0 = null;

        EObject lv_part_3_0 = null;

        EObject lv_trailer_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:1944:2: ( (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) ) )
            // InternalTemplateLang.g:1945:2: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            {
            // InternalTemplateLang.g:1945:2: (otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) ) )
            // InternalTemplateLang.g:1946:3: otherlv_0= 'multiSelect' ( (lv_preamble_1_0= ruleStmtBlock ) ) ( (lv_selector_2_0= ruleStmtBlock ) ) ( (lv_part_3_0= rulemultiSelectPart ) )+ ( (lv_trailer_4_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getGenericMultiselectAccess().getMultiSelectKeyword_0());
              		
            }
            // InternalTemplateLang.g:1950:3: ( (lv_preamble_1_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:1951:4: (lv_preamble_1_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:1951:4: (lv_preamble_1_0= ruleStmtBlock )
            // InternalTemplateLang.g:1952:5: lv_preamble_1_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPreambleStmtBlockParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:1969:3: ( (lv_selector_2_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:1970:4: (lv_selector_2_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:1970:4: (lv_selector_2_0= ruleStmtBlock )
            // InternalTemplateLang.g:1971:5: lv_selector_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGenericMultiselectAccess().getSelectorStmtBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_38);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:1988:3: ( (lv_part_3_0= rulemultiSelectPart ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==39) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalTemplateLang.g:1989:4: (lv_part_3_0= rulemultiSelectPart )
            	    {
            	    // InternalTemplateLang.g:1989:4: (lv_part_3_0= rulemultiSelectPart )
            	    // InternalTemplateLang.g:1990:5: lv_part_3_0= rulemultiSelectPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getGenericMultiselectAccess().getPartMultiSelectPartParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_39);
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
            	      						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.multiSelectPart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            // InternalTemplateLang.g:2007:3: ( (lv_trailer_4_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:2008:4: (lv_trailer_4_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:2008:4: (lv_trailer_4_0= ruleStmtBlock )
            // InternalTemplateLang.g:2009:5: lv_trailer_4_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGenericMultiselectAccess().getTrailerStmtBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
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
    // InternalTemplateLang.g:2030:1: entryRulemultiSelectPart returns [EObject current=null] : iv_rulemultiSelectPart= rulemultiSelectPart EOF ;
    public final EObject entryRulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemultiSelectPart = null;


        try {
            // InternalTemplateLang.g:2030:56: (iv_rulemultiSelectPart= rulemultiSelectPart EOF )
            // InternalTemplateLang.g:2031:2: iv_rulemultiSelectPart= rulemultiSelectPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiSelectPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulemultiSelectPart=rulemultiSelectPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulemultiSelectPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:2037:1: rulemultiSelectPart returns [EObject current=null] : (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) ;
    public final EObject rulemultiSelectPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_case_1_0 = null;

        EObject lv_code_2_0 = null;

        EObject lv_selector_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2043:2: ( (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) ) )
            // InternalTemplateLang.g:2044:2: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            {
            // InternalTemplateLang.g:2044:2: (otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) ) )
            // InternalTemplateLang.g:2045:3: otherlv_0= 'case' ( (lv_case_1_0= ruleExpression ) ) ( (lv_code_2_0= ruleStmtBlock ) ) ( (lv_selector_3_0= ruleStmtBlock ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMultiSelectPartAccess().getCaseKeyword_0());
              		
            }
            // InternalTemplateLang.g:2049:3: ( (lv_case_1_0= ruleExpression ) )
            // InternalTemplateLang.g:2050:4: (lv_case_1_0= ruleExpression )
            {
            // InternalTemplateLang.g:2050:4: (lv_case_1_0= ruleExpression )
            // InternalTemplateLang.g:2051:5: lv_case_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCaseExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_13);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:2068:3: ( (lv_code_2_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:2069:4: (lv_code_2_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:2069:4: (lv_code_2_0= ruleStmtBlock )
            // InternalTemplateLang.g:2070:5: lv_code_2_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiSelectPartAccess().getCodeStmtBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:2087:3: ( (lv_selector_3_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:2088:4: (lv_selector_3_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:2088:4: (lv_selector_3_0= ruleStmtBlock )
            // InternalTemplateLang.g:2089:5: lv_selector_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiSelectPartAccess().getSelectorStmtBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
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
    // InternalTemplateLang.g:2110:1: entryRuleuserMultiselect returns [EObject current=null] : iv_ruleuserMultiselect= ruleuserMultiselect EOF ;
    public final EObject entryRuleuserMultiselect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuserMultiselect = null;


        try {
            // InternalTemplateLang.g:2110:56: (iv_ruleuserMultiselect= ruleuserMultiselect EOF )
            // InternalTemplateLang.g:2111:2: iv_ruleuserMultiselect= ruleuserMultiselect EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUserMultiselectRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuserMultiselect=ruleuserMultiselect();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuserMultiselect; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:2117:1: ruleuserMultiselect returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) ;
    public final EObject ruleuserMultiselect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_stmt_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2123:2: ( ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? ) )
            // InternalTemplateLang.g:2124:2: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            {
            // InternalTemplateLang.g:2124:2: ( ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )? )
            // InternalTemplateLang.g:2125:3: ( (lv_id_0_0= ruleIdentifier ) ) otherlv_1= ':=' otherlv_2= 'generic-multiSelect' ( (lv_stmt_3_0= ruleStmtBlock ) ) (otherlv_4= ';' )?
            {
            // InternalTemplateLang.g:2125:3: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2126:4: (lv_id_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2126:4: (lv_id_0_0= ruleIdentifier )
            // InternalTemplateLang.g:2127:5: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUserMultiselectAccess().getIdIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_40);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,40,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUserMultiselectAccess().getColonEqualsSignKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,41,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getUserMultiselectAccess().getGenericMultiSelectKeyword_2());
              		
            }
            // InternalTemplateLang.g:2152:3: ( (lv_stmt_3_0= ruleStmtBlock ) )
            // InternalTemplateLang.g:2153:4: (lv_stmt_3_0= ruleStmtBlock )
            {
            // InternalTemplateLang.g:2153:4: (lv_stmt_3_0= ruleStmtBlock )
            // InternalTemplateLang.g:2154:5: lv_stmt_3_0= ruleStmtBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUserMultiselectAccess().getStmtStmtBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_24);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.StmtBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:2171:3: (otherlv_4= ';' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTemplateLang.g:2172:4: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2181:1: entryRuleExtension returns [EObject current=null] : iv_ruleExtension= ruleExtension EOF ;
    public final EObject entryRuleExtension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtension = null;


        try {
            // InternalTemplateLang.g:2181:50: (iv_ruleExtension= ruleExtension EOF )
            // InternalTemplateLang.g:2182:2: iv_ruleExtension= ruleExtension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtension=ruleExtension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtension; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:2188:1: ruleExtension returns [EObject current=null] : (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleExtension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2194:2: ( (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' ) )
            // InternalTemplateLang.g:2195:2: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalTemplateLang.g:2195:2: (otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';' )
            // InternalTemplateLang.g:2196:3: otherlv_0= 'extension' ( (lv_name_1_0= ruleJavaQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtensionAccess().getExtensionKeyword_0());
              		
            }
            // InternalTemplateLang.g:2200:3: ( (lv_name_1_0= ruleJavaQualifiedName ) )
            // InternalTemplateLang.g:2201:4: (lv_name_1_0= ruleJavaQualifiedName )
            {
            // InternalTemplateLang.g:2201:4: (lv_name_1_0= ruleJavaQualifiedName )
            // InternalTemplateLang.g:2202:5: lv_name_1_0= ruleJavaQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionAccess().getNameJavaQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_32);
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
              						"de.uni_hildesheim.sse.vil.templatelang.TemplateLang.JavaQualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2227:1: entryRuleJavaQualifiedName returns [EObject current=null] : iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF ;
    public final EObject entryRuleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaQualifiedName = null;


        try {
            // InternalTemplateLang.g:2227:58: (iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF )
            // InternalTemplateLang.g:2228:2: iv_ruleJavaQualifiedName= ruleJavaQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJavaQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJavaQualifiedName=ruleJavaQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJavaQualifiedName; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

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
    // InternalTemplateLang.g:2234:1: ruleJavaQualifiedName returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleJavaQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2240:2: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalTemplateLang.g:2241:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalTemplateLang.g:2241:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalTemplateLang.g:2242:3: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalTemplateLang.g:2242:3: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2243:4: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2243:4: (lv_qname_0_0= ruleIdentifier )
            // InternalTemplateLang.g:2244:5: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_42);
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
              						"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalTemplateLang.g:2261:3: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==43) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalTemplateLang.g:2262:4: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalTemplateLang.g:2262:4: ( (lv_qname_1_0= '.' ) )
            	    // InternalTemplateLang.g:2263:5: (lv_qname_1_0= '.' )
            	    {
            	    // InternalTemplateLang.g:2263:5: (lv_qname_1_0= '.' )
            	    // InternalTemplateLang.g:2264:6: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
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

            	    // InternalTemplateLang.g:2276:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalTemplateLang.g:2277:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalTemplateLang.g:2277:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalTemplateLang.g:2278:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getJavaQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
            	      							"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.Identifier");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalTemplateLang.g:2300:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalTemplateLang.g:2300:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalTemplateLang.g:2301:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
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
    // InternalTemplateLang.g:2307:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // InternalTemplateLang.g:2313:2: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // InternalTemplateLang.g:2314:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // InternalTemplateLang.g:2314:2: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // InternalTemplateLang.g:2315:3: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // InternalTemplateLang.g:2315:3: ( (lv_const_0_0= 'const' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==44) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalTemplateLang.g:2316:4: (lv_const_0_0= 'const' )
                    {
                    // InternalTemplateLang.g:2316:4: (lv_const_0_0= 'const' )
                    // InternalTemplateLang.g:2317:5: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,44,FOLLOW_23); if (state.failed) return current;
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

            // InternalTemplateLang.g:2329:3: ( (lv_type_1_0= ruleType ) )
            // InternalTemplateLang.g:2330:4: (lv_type_1_0= ruleType )
            {
            // InternalTemplateLang.g:2330:4: (lv_type_1_0= ruleType )
            // InternalTemplateLang.g:2331:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            // InternalTemplateLang.g:2348:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2349:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2349:4: (lv_name_2_0= ruleIdentifier )
            // InternalTemplateLang.g:2350:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_43);
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

            // InternalTemplateLang.g:2367:3: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==23) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTemplateLang.g:2368:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalTemplateLang.g:2372:4: ( (lv_expression_4_0= ruleExpression ) )
                    // InternalTemplateLang.g:2373:5: (lv_expression_4_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:2373:5: (lv_expression_4_0= ruleExpression )
                    // InternalTemplateLang.g:2374:6: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_32);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2400:1: entryRuleCompound returns [EObject current=null] : iv_ruleCompound= ruleCompound EOF ;
    public final EObject entryRuleCompound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompound = null;


        try {
            // InternalTemplateLang.g:2400:49: (iv_ruleCompound= ruleCompound EOF )
            // InternalTemplateLang.g:2401:2: iv_ruleCompound= ruleCompound EOF
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
    // InternalTemplateLang.g:2407:1: ruleCompound returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) ;
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
            // InternalTemplateLang.g:2413:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? ) )
            // InternalTemplateLang.g:2414:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            {
            // InternalTemplateLang.g:2414:2: ( ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )? )
            // InternalTemplateLang.g:2415:3: ( (lv_abstract_0_0= 'abstract' ) )? otherlv_1= 'compound' ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )? otherlv_5= '{' ( (lv_vars_6_0= ruleVariableDeclaration ) )* otherlv_7= '}' (otherlv_8= ';' )?
            {
            // InternalTemplateLang.g:2415:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==45) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTemplateLang.g:2416:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalTemplateLang.g:2416:4: (lv_abstract_0_0= 'abstract' )
                    // InternalTemplateLang.g:2417:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,45,FOLLOW_44); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,46,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundAccess().getCompoundKeyword_1());
              		
            }
            // InternalTemplateLang.g:2433:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2434:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2434:4: (lv_name_2_0= ruleIdentifier )
            // InternalTemplateLang.g:2435:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCompoundAccess().getNameIdentifierParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_45);
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

            // InternalTemplateLang.g:2452:3: (otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==47) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTemplateLang.g:2453:4: otherlv_3= 'refines' ( (lv_super_4_0= ruleIdentifier ) )
                    {
                    otherlv_3=(Token)match(input,47,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCompoundAccess().getRefinesKeyword_3_0());
                      			
                    }
                    // InternalTemplateLang.g:2457:4: ( (lv_super_4_0= ruleIdentifier ) )
                    // InternalTemplateLang.g:2458:5: (lv_super_4_0= ruleIdentifier )
                    {
                    // InternalTemplateLang.g:2458:5: (lv_super_4_0= ruleIdentifier )
                    // InternalTemplateLang.g:2459:6: lv_super_4_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCompoundAccess().getSuperIdentifierParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
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

            otherlv_5=(Token)match(input,17,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCompoundAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalTemplateLang.g:2481:3: ( (lv_vars_6_0= ruleVariableDeclaration ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||(LA43_0>=RULE_VERSION && LA43_0<=RULE_EXPONENT)||LA43_0==44||LA43_0==51||(LA43_0>=80 && LA43_0<=83)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTemplateLang.g:2482:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    {
            	    // InternalTemplateLang.g:2482:4: (lv_vars_6_0= ruleVariableDeclaration )
            	    // InternalTemplateLang.g:2483:5: lv_vars_6_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundAccess().getVarsVariableDeclarationParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_46);
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
            	    break loop43;
                }
            } while (true);

            otherlv_7=(Token)match(input,18,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getCompoundAccess().getRightCurlyBracketKeyword_6());
              		
            }
            // InternalTemplateLang.g:2504:3: (otherlv_8= ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==27) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTemplateLang.g:2505:4: otherlv_8= ';'
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2514:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // InternalTemplateLang.g:2514:48: (iv_ruleTypeDef= ruleTypeDef EOF )
            // InternalTemplateLang.g:2515:2: iv_ruleTypeDef= ruleTypeDef EOF
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
    // InternalTemplateLang.g:2521:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2527:2: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // InternalTemplateLang.g:2528:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // InternalTemplateLang.g:2528:2: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // InternalTemplateLang.g:2529:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
              		
            }
            // InternalTemplateLang.g:2533:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2534:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2534:4: (lv_name_1_0= ruleIdentifier )
            // InternalTemplateLang.g:2535:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_23);
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

            // InternalTemplateLang.g:2552:3: ( (lv_type_2_0= ruleType ) )
            // InternalTemplateLang.g:2553:4: (lv_type_2_0= ruleType )
            {
            // InternalTemplateLang.g:2553:4: (lv_type_2_0= ruleType )
            // InternalTemplateLang.g:2554:5: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_32);
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

            otherlv_3=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2579:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // InternalTemplateLang.g:2579:47: (iv_ruleAdvice= ruleAdvice EOF )
            // InternalTemplateLang.g:2580:2: iv_ruleAdvice= ruleAdvice EOF
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
    // InternalTemplateLang.g:2586:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2592:2: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // InternalTemplateLang.g:2593:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // InternalTemplateLang.g:2593:2: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // InternalTemplateLang.g:2594:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,14,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:2602:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTemplateLang.g:2603:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTemplateLang.g:2603:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTemplateLang.g:2604:5: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,15,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalTemplateLang.g:2625:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==50) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTemplateLang.g:2626:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalTemplateLang.g:2626:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalTemplateLang.g:2627:5: lv_versionSpec_4_0= ruleVersionSpec
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
    // InternalTemplateLang.g:2648:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // InternalTemplateLang.g:2648:52: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // InternalTemplateLang.g:2649:2: iv_ruleVersionSpec= ruleVersionSpec EOF
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
    // InternalTemplateLang.g:2655:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2661:2: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // InternalTemplateLang.g:2662:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // InternalTemplateLang.g:2662:2: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // InternalTemplateLang.g:2663:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
              		
            }
            // InternalTemplateLang.g:2667:3: ( (lv_restriction_1_0= ruleExpression ) )
            // InternalTemplateLang.g:2668:4: (lv_restriction_1_0= ruleExpression )
            {
            // InternalTemplateLang.g:2668:4: (lv_restriction_1_0= ruleExpression )
            // InternalTemplateLang.g:2669:5: lv_restriction_1_0= ruleExpression
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
    // InternalTemplateLang.g:2690:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalTemplateLang.g:2690:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalTemplateLang.g:2691:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalTemplateLang.g:2697:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2703:2: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // InternalTemplateLang.g:2704:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // InternalTemplateLang.g:2704:2: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // InternalTemplateLang.g:2705:3: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // InternalTemplateLang.g:2705:3: ( (lv_param_0_0= ruleParameter ) )
            // InternalTemplateLang.g:2706:4: (lv_param_0_0= ruleParameter )
            {
            // InternalTemplateLang.g:2706:4: (lv_param_0_0= ruleParameter )
            // InternalTemplateLang.g:2707:5: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_48);
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

            // InternalTemplateLang.g:2724:3: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==22) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalTemplateLang.g:2725:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:2729:4: ( (lv_param_2_0= ruleParameter ) )
            	    // InternalTemplateLang.g:2730:5: (lv_param_2_0= ruleParameter )
            	    {
            	    // InternalTemplateLang.g:2730:5: (lv_param_2_0= ruleParameter )
            	    // InternalTemplateLang.g:2731:6: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
            	    break loop46;
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
    // InternalTemplateLang.g:2753:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalTemplateLang.g:2753:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalTemplateLang.g:2754:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalTemplateLang.g:2760:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_dflt_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:2766:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? ) )
            // InternalTemplateLang.g:2767:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            {
            // InternalTemplateLang.g:2767:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )? )
            // InternalTemplateLang.g:2768:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            {
            // InternalTemplateLang.g:2768:3: ( (lv_type_0_0= ruleType ) )
            // InternalTemplateLang.g:2769:4: (lv_type_0_0= ruleType )
            {
            // InternalTemplateLang.g:2769:4: (lv_type_0_0= ruleType )
            // InternalTemplateLang.g:2770:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_8);
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

            // InternalTemplateLang.g:2787:3: ( (lv_name_1_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2788:4: (lv_name_1_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2788:4: (lv_name_1_0= ruleIdentifier )
            // InternalTemplateLang.g:2789:5: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            // InternalTemplateLang.g:2806:3: (otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==23) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTemplateLang.g:2807:4: otherlv_2= '=' ( (lv_dflt_3_0= ruleExpression ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEqualsSignKeyword_2_0());
                      			
                    }
                    // InternalTemplateLang.g:2811:4: ( (lv_dflt_3_0= ruleExpression ) )
                    // InternalTemplateLang.g:2812:5: (lv_dflt_3_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:2812:5: (lv_dflt_3_0= ruleExpression )
                    // InternalTemplateLang.g:2813:6: lv_dflt_3_0= ruleExpression
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
    // InternalTemplateLang.g:2835:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // InternalTemplateLang.g:2835:52: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // InternalTemplateLang.g:2836:2: iv_ruleVersionStmt= ruleVersionStmt EOF
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
    // InternalTemplateLang.g:2842:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:2848:2: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // InternalTemplateLang.g:2849:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // InternalTemplateLang.g:2849:2: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // InternalTemplateLang.g:2850:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
              		
            }
            // InternalTemplateLang.g:2854:3: ( (lv_version_1_0= RULE_VERSION ) )
            // InternalTemplateLang.g:2855:4: (lv_version_1_0= RULE_VERSION )
            {
            // InternalTemplateLang.g:2855:4: (lv_version_1_0= RULE_VERSION )
            // InternalTemplateLang.g:2856:5: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_32); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:2880:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalTemplateLang.g:2880:47: (iv_ruleImport= ruleImport EOF )
            // InternalTemplateLang.g:2881:2: iv_ruleImport= ruleImport EOF
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
    // InternalTemplateLang.g:2887:1: ruleImport returns [EObject current=null] : ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) ;
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
            // InternalTemplateLang.g:2893:2: ( ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' ) )
            // InternalTemplateLang.g:2894:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            {
            // InternalTemplateLang.g:2894:2: ( (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';' )
            // InternalTemplateLang.g:2895:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) ) ( (lv_name_2_0= ruleIdentifier ) ) ( (lv_wildcard_3_0= '*' ) )? ( (lv_versionSpec_4_0= ruleVersionSpec ) )? otherlv_5= ';'
            {
            // InternalTemplateLang.g:2895:3: (otherlv_0= 'import' | ( (lv_insert_1_0= 'insert' ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==52) ) {
                alt48=1;
            }
            else if ( (LA48_0==53) ) {
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
                    // InternalTemplateLang.g:2896:4: otherlv_0= 'import'
                    {
                    otherlv_0=(Token)match(input,52,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:2901:4: ( (lv_insert_1_0= 'insert' ) )
                    {
                    // InternalTemplateLang.g:2901:4: ( (lv_insert_1_0= 'insert' ) )
                    // InternalTemplateLang.g:2902:5: (lv_insert_1_0= 'insert' )
                    {
                    // InternalTemplateLang.g:2902:5: (lv_insert_1_0= 'insert' )
                    // InternalTemplateLang.g:2903:6: lv_insert_1_0= 'insert'
                    {
                    lv_insert_1_0=(Token)match(input,53,FOLLOW_8); if (state.failed) return current;
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

            // InternalTemplateLang.g:2916:3: ( (lv_name_2_0= ruleIdentifier ) )
            // InternalTemplateLang.g:2917:4: (lv_name_2_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:2917:4: (lv_name_2_0= ruleIdentifier )
            // InternalTemplateLang.g:2918:5: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_51);
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

            // InternalTemplateLang.g:2935:3: ( (lv_wildcard_3_0= '*' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==54) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalTemplateLang.g:2936:4: (lv_wildcard_3_0= '*' )
                    {
                    // InternalTemplateLang.g:2936:4: (lv_wildcard_3_0= '*' )
                    // InternalTemplateLang.g:2937:5: lv_wildcard_3_0= '*'
                    {
                    lv_wildcard_3_0=(Token)match(input,54,FOLLOW_52); if (state.failed) return current;
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

            // InternalTemplateLang.g:2949:3: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==50) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalTemplateLang.g:2950:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // InternalTemplateLang.g:2950:4: (lv_versionSpec_4_0= ruleVersionSpec )
                    // InternalTemplateLang.g:2951:5: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_32);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalTemplateLang.g:2976:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalTemplateLang.g:2976:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalTemplateLang.g:2977:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
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
    // InternalTemplateLang.g:2983:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
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
            // InternalTemplateLang.g:2989:2: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalTemplateLang.g:2990:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalTemplateLang.g:2990:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalTemplateLang.g:2991:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalTemplateLang.g:2991:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalTemplateLang.g:2992:4: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                    {
                    // InternalTemplateLang.g:2992:4: ( (lv_var_0_0= ruleIdentifier ) )
                    // InternalTemplateLang.g:2993:5: (lv_var_0_0= ruleIdentifier )
                    {
                    // InternalTemplateLang.g:2993:5: (lv_var_0_0= ruleIdentifier )
                    // InternalTemplateLang.g:2994:6: lv_var_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
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

                    // InternalTemplateLang.g:3011:4: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==43) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalTemplateLang.g:3012:5: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                            {
                            otherlv_1=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_1_0());
                              				
                            }
                            // InternalTemplateLang.g:3016:5: ( (lv_field_2_0= ruleIdentifier ) )
                            // InternalTemplateLang.g:3017:6: (lv_field_2_0= ruleIdentifier )
                            {
                            // InternalTemplateLang.g:3017:6: (lv_field_2_0= ruleIdentifier )
                            // InternalTemplateLang.g:3018:7: lv_field_2_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_1_1_0());
                              						
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

                    otherlv_3=(Token)match(input,23,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            // InternalTemplateLang.g:3041:3: ( (lv_expr_4_0= ruleExpression ) )
            // InternalTemplateLang.g:3042:4: (lv_expr_4_0= ruleExpression )
            {
            // InternalTemplateLang.g:3042:4: (lv_expr_4_0= ruleExpression )
            // InternalTemplateLang.g:3043:5: lv_expr_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_32);
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

            otherlv_5=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3068:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalTemplateLang.g:3068:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalTemplateLang.g:3069:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalTemplateLang.g:3075:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3081:2: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // InternalTemplateLang.g:3082:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // InternalTemplateLang.g:3082:2: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_EXPONENT)||LA53_0==14||LA53_0==30||LA53_0==51||LA53_0==67||(LA53_0>=69 && LA53_0<=71)||(LA53_0>=77 && LA53_0<=79)) ) {
                alt53=1;
            }
            else if ( (LA53_0==17) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalTemplateLang.g:3083:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // InternalTemplateLang.g:3083:3: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // InternalTemplateLang.g:3084:4: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // InternalTemplateLang.g:3084:4: (lv_expr_0_0= ruleLogicalExpression )
                    // InternalTemplateLang.g:3085:5: lv_expr_0_0= ruleLogicalExpression
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
                    // InternalTemplateLang.g:3103:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // InternalTemplateLang.g:3103:3: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // InternalTemplateLang.g:3104:4: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // InternalTemplateLang.g:3104:4: (lv_init_1_0= ruleContainerInitializer )
                    // InternalTemplateLang.g:3105:5: lv_init_1_0= ruleContainerInitializer
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
    // InternalTemplateLang.g:3126:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // InternalTemplateLang.g:3126:58: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // InternalTemplateLang.g:3127:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
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
    // InternalTemplateLang.g:3133:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3139:2: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // InternalTemplateLang.g:3140:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // InternalTemplateLang.g:3140:2: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // InternalTemplateLang.g:3141:3: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // InternalTemplateLang.g:3141:3: ( (lv_left_0_0= ruleEqualityExpression ) )
            // InternalTemplateLang.g:3142:4: (lv_left_0_0= ruleEqualityExpression )
            {
            // InternalTemplateLang.g:3142:4: (lv_left_0_0= ruleEqualityExpression )
            // InternalTemplateLang.g:3143:5: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_54);
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

            // InternalTemplateLang.g:3160:3: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=55 && LA54_0<=59)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalTemplateLang.g:3161:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // InternalTemplateLang.g:3161:4: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // InternalTemplateLang.g:3162:5: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_54);
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
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleLogicalExpressionPart"
    // InternalTemplateLang.g:3183:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // InternalTemplateLang.g:3183:62: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // InternalTemplateLang.g:3184:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
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
    // InternalTemplateLang.g:3190:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3196:2: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // InternalTemplateLang.g:3197:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // InternalTemplateLang.g:3197:2: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // InternalTemplateLang.g:3198:3: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // InternalTemplateLang.g:3198:3: ( (lv_op_0_0= ruleLogicalOperator ) )
            // InternalTemplateLang.g:3199:4: (lv_op_0_0= ruleLogicalOperator )
            {
            // InternalTemplateLang.g:3199:4: (lv_op_0_0= ruleLogicalOperator )
            // InternalTemplateLang.g:3200:5: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3217:3: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // InternalTemplateLang.g:3218:4: (lv_ex_1_0= ruleEqualityExpression )
            {
            // InternalTemplateLang.g:3218:4: (lv_ex_1_0= ruleEqualityExpression )
            // InternalTemplateLang.g:3219:5: lv_ex_1_0= ruleEqualityExpression
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
    // InternalTemplateLang.g:3240:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // InternalTemplateLang.g:3240:55: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // InternalTemplateLang.g:3241:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
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
    // InternalTemplateLang.g:3247:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3253:2: ( (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' ) )
            // InternalTemplateLang.g:3254:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            {
            // InternalTemplateLang.g:3254:2: (kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' | kw= 'iff' )
            int alt55=5;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt55=1;
                }
                break;
            case 56:
                {
                alt55=2;
                }
                break;
            case 57:
                {
                alt55=3;
                }
                break;
            case 58:
                {
                alt55=4;
                }
                break;
            case 59:
                {
                alt55=5;
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
                    // InternalTemplateLang.g:3255:3: kw= 'and'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3261:3: kw= 'or'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalTemplateLang.g:3267:3: kw= 'xor'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getXorKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalTemplateLang.g:3273:3: kw= 'implies'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getImpliesKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalTemplateLang.g:3279:3: kw= 'iff'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3288:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalTemplateLang.g:3288:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalTemplateLang.g:3289:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalTemplateLang.g:3295:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3301:2: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // InternalTemplateLang.g:3302:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // InternalTemplateLang.g:3302:2: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // InternalTemplateLang.g:3303:3: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // InternalTemplateLang.g:3303:3: ( (lv_left_0_0= ruleRelationalExpression ) )
            // InternalTemplateLang.g:3304:4: (lv_left_0_0= ruleRelationalExpression )
            {
            // InternalTemplateLang.g:3304:4: (lv_left_0_0= ruleRelationalExpression )
            // InternalTemplateLang.g:3305:5: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_55);
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

            // InternalTemplateLang.g:3322:3: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=60 && LA56_0<=62)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalTemplateLang.g:3323:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // InternalTemplateLang.g:3323:4: (lv_right_1_0= ruleEqualityExpressionPart )
                    // InternalTemplateLang.g:3324:5: lv_right_1_0= ruleEqualityExpressionPart
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
    // InternalTemplateLang.g:3345:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // InternalTemplateLang.g:3345:63: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // InternalTemplateLang.g:3346:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
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
    // InternalTemplateLang.g:3352:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3358:2: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // InternalTemplateLang.g:3359:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // InternalTemplateLang.g:3359:2: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // InternalTemplateLang.g:3360:3: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // InternalTemplateLang.g:3360:3: ( (lv_op_0_0= ruleEqualityOperator ) )
            // InternalTemplateLang.g:3361:4: (lv_op_0_0= ruleEqualityOperator )
            {
            // InternalTemplateLang.g:3361:4: (lv_op_0_0= ruleEqualityOperator )
            // InternalTemplateLang.g:3362:5: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3379:3: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // InternalTemplateLang.g:3380:4: (lv_ex_1_0= ruleRelationalExpression )
            {
            // InternalTemplateLang.g:3380:4: (lv_ex_1_0= ruleRelationalExpression )
            // InternalTemplateLang.g:3381:5: lv_ex_1_0= ruleRelationalExpression
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
    // InternalTemplateLang.g:3402:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // InternalTemplateLang.g:3402:56: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // InternalTemplateLang.g:3403:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
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
    // InternalTemplateLang.g:3409:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3415:2: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // InternalTemplateLang.g:3416:2: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // InternalTemplateLang.g:3416:2: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt57=1;
                }
                break;
            case 61:
                {
                alt57=2;
                }
                break;
            case 62:
                {
                alt57=3;
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
                    // InternalTemplateLang.g:3417:3: kw= '=='
                    {
                    kw=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3423:3: kw= '<>'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalTemplateLang.g:3429:3: kw= '!='
                    {
                    kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3438:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalTemplateLang.g:3438:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalTemplateLang.g:3439:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
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
    // InternalTemplateLang.g:3445:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;

        EObject lv_right2_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3451:2: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? ) )
            // InternalTemplateLang.g:3452:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            {
            // InternalTemplateLang.g:3452:2: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )? )
            // InternalTemplateLang.g:3453:3: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            {
            // InternalTemplateLang.g:3453:3: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // InternalTemplateLang.g:3454:4: (lv_left_0_0= ruleAdditiveExpression )
            {
            // InternalTemplateLang.g:3454:4: (lv_left_0_0= ruleAdditiveExpression )
            // InternalTemplateLang.g:3455:5: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_56);
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

            // InternalTemplateLang.g:3472:3: ( ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )? )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==20||(LA59_0>=63 && LA59_0<=65)) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalTemplateLang.g:3473:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) ) ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    {
                    // InternalTemplateLang.g:3473:4: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
                    // InternalTemplateLang.g:3474:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // InternalTemplateLang.g:3474:5: (lv_right_1_0= ruleRelationalExpressionPart )
                    // InternalTemplateLang.g:3475:6: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FOLLOW_56);
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

                    // InternalTemplateLang.g:3492:4: ( (lv_right2_2_0= ruleRelationalExpressionPart ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==20||(LA58_0>=63 && LA58_0<=65)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalTemplateLang.g:3493:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            {
                            // InternalTemplateLang.g:3493:5: (lv_right2_2_0= ruleRelationalExpressionPart )
                            // InternalTemplateLang.g:3494:6: lv_right2_2_0= ruleRelationalExpressionPart
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
    // InternalTemplateLang.g:3516:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // InternalTemplateLang.g:3516:65: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // InternalTemplateLang.g:3517:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
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
    // InternalTemplateLang.g:3523:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3529:2: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // InternalTemplateLang.g:3530:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // InternalTemplateLang.g:3530:2: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // InternalTemplateLang.g:3531:3: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // InternalTemplateLang.g:3531:3: ( (lv_op_0_0= ruleRelationalOperator ) )
            // InternalTemplateLang.g:3532:4: (lv_op_0_0= ruleRelationalOperator )
            {
            // InternalTemplateLang.g:3532:4: (lv_op_0_0= ruleRelationalOperator )
            // InternalTemplateLang.g:3533:5: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3550:3: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // InternalTemplateLang.g:3551:4: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // InternalTemplateLang.g:3551:4: (lv_ex_1_0= ruleAdditiveExpression )
            // InternalTemplateLang.g:3552:5: lv_ex_1_0= ruleAdditiveExpression
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
    // InternalTemplateLang.g:3573:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // InternalTemplateLang.g:3573:58: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // InternalTemplateLang.g:3574:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
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
    // InternalTemplateLang.g:3580:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3586:2: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // InternalTemplateLang.g:3587:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // InternalTemplateLang.g:3587:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt60=1;
                }
                break;
            case 20:
                {
                alt60=2;
                }
                break;
            case 64:
                {
                alt60=3;
                }
                break;
            case 65:
                {
                alt60=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalTemplateLang.g:3588:3: kw= '>'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3594:3: kw= '<'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalTemplateLang.g:3600:3: kw= '>='
                    {
                    kw=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalTemplateLang.g:3606:3: kw= '<='
                    {
                    kw=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3615:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalTemplateLang.g:3615:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalTemplateLang.g:3616:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalTemplateLang.g:3622:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3628:2: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // InternalTemplateLang.g:3629:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // InternalTemplateLang.g:3629:2: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // InternalTemplateLang.g:3630:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // InternalTemplateLang.g:3630:3: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // InternalTemplateLang.g:3631:4: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // InternalTemplateLang.g:3631:4: (lv_left_0_0= ruleMultiplicativeExpression )
            // InternalTemplateLang.g:3632:5: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_57);
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

            // InternalTemplateLang.g:3649:3: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=66 && LA61_0<=67)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalTemplateLang.g:3650:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // InternalTemplateLang.g:3650:4: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // InternalTemplateLang.g:3651:5: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_57);
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
            	    break loop61;
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
    // InternalTemplateLang.g:3672:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // InternalTemplateLang.g:3672:63: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // InternalTemplateLang.g:3673:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
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
    // InternalTemplateLang.g:3679:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3685:2: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // InternalTemplateLang.g:3686:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // InternalTemplateLang.g:3686:2: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // InternalTemplateLang.g:3687:3: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // InternalTemplateLang.g:3687:3: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // InternalTemplateLang.g:3688:4: (lv_op_0_0= ruleAdditiveOperator )
            {
            // InternalTemplateLang.g:3688:4: (lv_op_0_0= ruleAdditiveOperator )
            // InternalTemplateLang.g:3689:5: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3706:3: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // InternalTemplateLang.g:3707:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // InternalTemplateLang.g:3707:4: (lv_ex_1_0= ruleMultiplicativeExpression )
            // InternalTemplateLang.g:3708:5: lv_ex_1_0= ruleMultiplicativeExpression
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
    // InternalTemplateLang.g:3729:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // InternalTemplateLang.g:3729:56: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // InternalTemplateLang.g:3730:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
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
    // InternalTemplateLang.g:3736:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3742:2: ( (kw= '+' | kw= '-' ) )
            // InternalTemplateLang.g:3743:2: (kw= '+' | kw= '-' )
            {
            // InternalTemplateLang.g:3743:2: (kw= '+' | kw= '-' )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==66) ) {
                alt62=1;
            }
            else if ( (LA62_0==67) ) {
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
                    // InternalTemplateLang.g:3744:3: kw= '+'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3750:3: kw= '-'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3759:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalTemplateLang.g:3759:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalTemplateLang.g:3760:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalTemplateLang.g:3766:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3772:2: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // InternalTemplateLang.g:3773:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // InternalTemplateLang.g:3773:2: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // InternalTemplateLang.g:3774:3: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // InternalTemplateLang.g:3774:3: ( (lv_left_0_0= ruleUnaryExpression ) )
            // InternalTemplateLang.g:3775:4: (lv_left_0_0= ruleUnaryExpression )
            {
            // InternalTemplateLang.g:3775:4: (lv_left_0_0= ruleUnaryExpression )
            // InternalTemplateLang.g:3776:5: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_58);
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

            // InternalTemplateLang.g:3793:3: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==54||LA63_0==68) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalTemplateLang.g:3794:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // InternalTemplateLang.g:3794:4: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // InternalTemplateLang.g:3795:5: lv_right_1_0= ruleMultiplicativeExpressionPart
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
    // InternalTemplateLang.g:3816:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // InternalTemplateLang.g:3816:69: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // InternalTemplateLang.g:3817:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
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
    // InternalTemplateLang.g:3823:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3829:2: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // InternalTemplateLang.g:3830:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // InternalTemplateLang.g:3830:2: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // InternalTemplateLang.g:3831:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // InternalTemplateLang.g:3831:3: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // InternalTemplateLang.g:3832:4: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // InternalTemplateLang.g:3832:4: (lv_op_0_0= ruleMultiplicativeOperator )
            // InternalTemplateLang.g:3833:5: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3850:3: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // InternalTemplateLang.g:3851:4: (lv_expr_1_0= ruleUnaryExpression )
            {
            // InternalTemplateLang.g:3851:4: (lv_expr_1_0= ruleUnaryExpression )
            // InternalTemplateLang.g:3852:5: lv_expr_1_0= ruleUnaryExpression
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
    // InternalTemplateLang.g:3873:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // InternalTemplateLang.g:3873:62: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // InternalTemplateLang.g:3874:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
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
    // InternalTemplateLang.g:3880:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3886:2: ( (kw= '*' | kw= '/' ) )
            // InternalTemplateLang.g:3887:2: (kw= '*' | kw= '/' )
            {
            // InternalTemplateLang.g:3887:2: (kw= '*' | kw= '/' )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==54) ) {
                alt64=1;
            }
            else if ( (LA64_0==68) ) {
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
                    // InternalTemplateLang.g:3888:3: kw= '*'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3894:3: kw= '/'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3903:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalTemplateLang.g:3903:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalTemplateLang.g:3904:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalTemplateLang.g:3910:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:3916:2: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // InternalTemplateLang.g:3917:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // InternalTemplateLang.g:3917:2: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // InternalTemplateLang.g:3918:3: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // InternalTemplateLang.g:3918:3: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==30||LA65_0==67||LA65_0==69) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalTemplateLang.g:3919:4: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // InternalTemplateLang.g:3919:4: (lv_op_0_0= ruleUnaryOperator )
                    // InternalTemplateLang.g:3920:5: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_37);
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

            // InternalTemplateLang.g:3937:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // InternalTemplateLang.g:3938:4: (lv_expr_1_0= rulePostfixExpression )
            {
            // InternalTemplateLang.g:3938:4: (lv_expr_1_0= rulePostfixExpression )
            // InternalTemplateLang.g:3939:5: lv_expr_1_0= rulePostfixExpression
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
    // InternalTemplateLang.g:3960:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalTemplateLang.g:3960:53: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalTemplateLang.g:3961:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalTemplateLang.g:3967:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:3973:2: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // InternalTemplateLang.g:3974:2: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // InternalTemplateLang.g:3974:2: (kw= 'not' | kw= '!' | kw= '-' )
            int alt66=3;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt66=1;
                }
                break;
            case 30:
                {
                alt66=2;
                }
                break;
            case 67:
                {
                alt66=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalTemplateLang.g:3975:3: kw= 'not'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalTemplateLang.g:3981:3: kw= '!'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalTemplateLang.g:3987:3: kw= '-'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:3996:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // InternalTemplateLang.g:3996:58: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // InternalTemplateLang.g:3997:2: iv_rulePostfixExpression= rulePostfixExpression EOF
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
    // InternalTemplateLang.g:4003:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4009:2: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // InternalTemplateLang.g:4010:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // InternalTemplateLang.g:4010:2: ( (lv_left_0_0= rulePrimaryExpression ) )
            // InternalTemplateLang.g:4011:3: (lv_left_0_0= rulePrimaryExpression )
            {
            // InternalTemplateLang.g:4011:3: (lv_left_0_0= rulePrimaryExpression )
            // InternalTemplateLang.g:4012:4: lv_left_0_0= rulePrimaryExpression
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
              					"de.uni_hildesheim.sse.vil.expressions.ExpressionDsl.PrimaryExpression");
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
    // InternalTemplateLang.g:4032:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalTemplateLang.g:4032:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalTemplateLang.g:4033:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalTemplateLang.g:4039:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_otherEx_0_0 = null;

        EObject lv_unqEx_1_0 = null;

        EObject lv_superEx_2_0 = null;

        EObject lv_newEx_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4045:2: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) ) )
            // InternalTemplateLang.g:4046:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            {
            // InternalTemplateLang.g:4046:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )
            int alt67=4;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalTemplateLang.g:4047:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // InternalTemplateLang.g:4047:3: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // InternalTemplateLang.g:4048:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // InternalTemplateLang.g:4048:4: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // InternalTemplateLang.g:4049:5: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
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
                    // InternalTemplateLang.g:4067:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // InternalTemplateLang.g:4067:3: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // InternalTemplateLang.g:4068:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // InternalTemplateLang.g:4068:4: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // InternalTemplateLang.g:4069:5: lv_unqEx_1_0= ruleUnqualifiedExecution
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
                    // InternalTemplateLang.g:4087:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // InternalTemplateLang.g:4087:3: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // InternalTemplateLang.g:4088:4: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // InternalTemplateLang.g:4088:4: (lv_superEx_2_0= ruleSuperExecution )
                    // InternalTemplateLang.g:4089:5: lv_superEx_2_0= ruleSuperExecution
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
                    // InternalTemplateLang.g:4107:3: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    {
                    // InternalTemplateLang.g:4107:3: ( (lv_newEx_3_0= ruleConstructorExecution ) )
                    // InternalTemplateLang.g:4108:4: (lv_newEx_3_0= ruleConstructorExecution )
                    {
                    // InternalTemplateLang.g:4108:4: (lv_newEx_3_0= ruleConstructorExecution )
                    // InternalTemplateLang.g:4109:5: lv_newEx_3_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleExpressionOrQualifiedExecution"
    // InternalTemplateLang.g:4130:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // InternalTemplateLang.g:4130:71: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // InternalTemplateLang.g:4131:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
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
    // InternalTemplateLang.g:4137:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4143:2: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // InternalTemplateLang.g:4144:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // InternalTemplateLang.g:4144:2: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // InternalTemplateLang.g:4145:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // InternalTemplateLang.g:4145:3: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_EXPONENT)||LA68_0==51||(LA68_0>=77 && LA68_0<=79)) ) {
                alt68=1;
            }
            else if ( (LA68_0==14) ) {
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
                    // InternalTemplateLang.g:4146:4: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // InternalTemplateLang.g:4146:4: ( (lv_val_0_0= ruleConstant ) )
                    // InternalTemplateLang.g:4147:5: (lv_val_0_0= ruleConstant )
                    {
                    // InternalTemplateLang.g:4147:5: (lv_val_0_0= ruleConstant )
                    // InternalTemplateLang.g:4148:6: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_59);
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
                    // InternalTemplateLang.g:4166:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // InternalTemplateLang.g:4166:4: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // InternalTemplateLang.g:4167:5: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                      				
                    }
                    // InternalTemplateLang.g:4171:5: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // InternalTemplateLang.g:4172:6: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:4172:6: (lv_parenthesis_2_0= ruleExpression )
                    // InternalTemplateLang.g:4173:7: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_11);
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

                    otherlv_3=(Token)match(input,15,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalTemplateLang.g:4196:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==43||(LA69_0>=72 && LA69_0<=73)) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalTemplateLang.g:4197:4: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // InternalTemplateLang.g:4197:4: (lv_calls_4_0= ruleSubCall )
            	    // InternalTemplateLang.g:4198:5: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop69;
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
    // InternalTemplateLang.g:4219:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // InternalTemplateLang.g:4219:61: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // InternalTemplateLang.g:4220:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
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
    // InternalTemplateLang.g:4226:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4232:2: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // InternalTemplateLang.g:4233:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // InternalTemplateLang.g:4233:2: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // InternalTemplateLang.g:4234:3: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // InternalTemplateLang.g:4234:3: ( (lv_call_0_0= ruleCall ) )
            // InternalTemplateLang.g:4235:4: (lv_call_0_0= ruleCall )
            {
            // InternalTemplateLang.g:4235:4: (lv_call_0_0= ruleCall )
            // InternalTemplateLang.g:4236:5: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalTemplateLang.g:4253:3: ( (lv_calls_1_0= ruleSubCall ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==43||(LA70_0>=72 && LA70_0<=73)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalTemplateLang.g:4254:4: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // InternalTemplateLang.g:4254:4: (lv_calls_1_0= ruleSubCall )
            	    // InternalTemplateLang.g:4255:5: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_59);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // InternalTemplateLang.g:4276:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // InternalTemplateLang.g:4276:55: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // InternalTemplateLang.g:4277:2: iv_ruleSuperExecution= ruleSuperExecution EOF
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
    // InternalTemplateLang.g:4283:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4289:2: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // InternalTemplateLang.g:4290:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // InternalTemplateLang.g:4290:2: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // InternalTemplateLang.g:4291:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,70,FOLLOW_60); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
              		
            }
            // InternalTemplateLang.g:4299:3: ( (lv_call_2_0= ruleCall ) )
            // InternalTemplateLang.g:4300:4: (lv_call_2_0= ruleCall )
            {
            // InternalTemplateLang.g:4300:4: (lv_call_2_0= ruleCall )
            // InternalTemplateLang.g:4301:5: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_59);
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

            // InternalTemplateLang.g:4318:3: ( (lv_calls_3_0= ruleSubCall ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==43||(LA71_0>=72 && LA71_0<=73)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalTemplateLang.g:4319:4: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // InternalTemplateLang.g:4319:4: (lv_calls_3_0= ruleSubCall )
            	    // InternalTemplateLang.g:4320:5: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_59);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // InternalTemplateLang.g:4341:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // InternalTemplateLang.g:4341:61: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // InternalTemplateLang.g:4342:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
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
    // InternalTemplateLang.g:4348:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // InternalTemplateLang.g:4354:2: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // InternalTemplateLang.g:4355:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // InternalTemplateLang.g:4355:2: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // InternalTemplateLang.g:4356:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,71,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
              		
            }
            // InternalTemplateLang.g:4360:3: ( (lv_type_1_0= ruleType ) )
            // InternalTemplateLang.g:4361:4: (lv_type_1_0= ruleType )
            {
            // InternalTemplateLang.g:4361:4: (lv_type_1_0= ruleType )
            // InternalTemplateLang.g:4362:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_9);
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

            otherlv_2=(Token)match(input,14,FOLLOW_61); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalTemplateLang.g:4383:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_ID && LA72_0<=RULE_EXPONENT)||LA72_0==14||LA72_0==17||LA72_0==30||LA72_0==51||LA72_0==67||(LA72_0>=69 && LA72_0<=71)||(LA72_0>=77 && LA72_0<=79)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalTemplateLang.g:4384:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalTemplateLang.g:4384:4: (lv_param_3_0= ruleArgumentList )
                    // InternalTemplateLang.g:4385:5: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
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

            otherlv_4=(Token)match(input,15,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalTemplateLang.g:4406:3: ( (lv_calls_5_0= ruleSubCall ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==43||(LA73_0>=72 && LA73_0<=73)) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalTemplateLang.g:4407:4: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // InternalTemplateLang.g:4407:4: (lv_calls_5_0= ruleSubCall )
            	    // InternalTemplateLang.g:4408:5: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_59);
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
            	    break loop73;
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
    // InternalTemplateLang.g:4429:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // InternalTemplateLang.g:4429:48: (iv_ruleSubCall= ruleSubCall EOF )
            // InternalTemplateLang.g:4430:2: iv_ruleSubCall= ruleSubCall EOF
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
    // InternalTemplateLang.g:4436:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // InternalTemplateLang.g:4442:2: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // InternalTemplateLang.g:4443:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // InternalTemplateLang.g:4443:2: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==43||LA75_0==72) ) {
                alt75=1;
            }
            else if ( (LA75_0==73) ) {
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
                    // InternalTemplateLang.g:4444:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // InternalTemplateLang.g:4444:3: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // InternalTemplateLang.g:4445:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // InternalTemplateLang.g:4445:4: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // InternalTemplateLang.g:4446:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // InternalTemplateLang.g:4446:5: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // InternalTemplateLang.g:4447:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // InternalTemplateLang.g:4447:6: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==43) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==72) ) {
                        alt74=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // InternalTemplateLang.g:4448:7: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
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
                            // InternalTemplateLang.g:4459:7: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,72,FOLLOW_8); if (state.failed) return current;
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

                    // InternalTemplateLang.g:4472:4: ( (lv_call_1_0= ruleCall ) )
                    // InternalTemplateLang.g:4473:5: (lv_call_1_0= ruleCall )
                    {
                    // InternalTemplateLang.g:4473:5: (lv_call_1_0= ruleCall )
                    // InternalTemplateLang.g:4474:6: lv_call_1_0= ruleCall
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
                    // InternalTemplateLang.g:4493:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // InternalTemplateLang.g:4493:3: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // InternalTemplateLang.g:4494:4: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,73,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalTemplateLang.g:4498:4: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // InternalTemplateLang.g:4499:5: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:4499:5: (lv_arrayEx_3_0= ruleExpression )
                    // InternalTemplateLang.g:4500:6: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
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

                    otherlv_4=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:4526:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // InternalTemplateLang.g:4526:51: (iv_ruleDeclarator= ruleDeclarator EOF )
            // InternalTemplateLang.g:4527:2: iv_ruleDeclarator= ruleDeclarator EOF
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
    // InternalTemplateLang.g:4533:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4539:2: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // InternalTemplateLang.g:4540:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // InternalTemplateLang.g:4540:2: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // InternalTemplateLang.g:4541:3: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // InternalTemplateLang.g:4541:3: ( (lv_decl_0_0= ruleDeclaration ) )
            // InternalTemplateLang.g:4542:4: (lv_decl_0_0= ruleDeclaration )
            {
            // InternalTemplateLang.g:4542:4: (lv_decl_0_0= ruleDeclaration )
            // InternalTemplateLang.g:4543:5: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            // InternalTemplateLang.g:4560:3: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==27) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalTemplateLang.g:4561:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,27,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:4565:4: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // InternalTemplateLang.g:4566:5: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // InternalTemplateLang.g:4566:5: (lv_decl_2_0= ruleDeclaration )
            	    // InternalTemplateLang.g:4567:6: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
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
            	    break loop76;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:4593:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalTemplateLang.g:4593:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalTemplateLang.g:4594:2: iv_ruleDeclaration= ruleDeclaration EOF
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
    // InternalTemplateLang.g:4600:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_units_1_0 = null;

        EObject lv_units_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4606:2: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* ) )
            // InternalTemplateLang.g:4607:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            {
            // InternalTemplateLang.g:4607:2: ( ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )* )
            // InternalTemplateLang.g:4608:3: ( (lv_type_0_0= ruleType ) )? ( (lv_units_1_0= ruleDeclarationUnit ) ) (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            {
            // InternalTemplateLang.g:4608:3: ( (lv_type_0_0= ruleType ) )?
            int alt77=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA77_1 = input.LA(2);

                    if ( (LA77_1==RULE_ID||(LA77_1>=RULE_VERSION && LA77_1<=RULE_EXPONENT)||LA77_1==51||LA77_1==76) ) {
                        alt77=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA77_2 = input.LA(2);

                    if ( (LA77_2==RULE_ID||(LA77_2>=RULE_VERSION && LA77_2<=RULE_EXPONENT)||LA77_2==51||LA77_2==76) ) {
                        alt77=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA77_3 = input.LA(2);

                    if ( (LA77_3==RULE_ID||(LA77_3>=RULE_VERSION && LA77_3<=RULE_EXPONENT)||LA77_3==51||LA77_3==76) ) {
                        alt77=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA77_4 = input.LA(2);

                    if ( (LA77_4==RULE_ID||(LA77_4>=RULE_VERSION && LA77_4<=RULE_EXPONENT)||LA77_4==51||LA77_4==76) ) {
                        alt77=1;
                    }
                    }
                    break;
                case 80:
                case 81:
                case 82:
                case 83:
                    {
                    alt77=1;
                    }
                    break;
            }

            switch (alt77) {
                case 1 :
                    // InternalTemplateLang.g:4609:4: (lv_type_0_0= ruleType )
                    {
                    // InternalTemplateLang.g:4609:4: (lv_type_0_0= ruleType )
                    // InternalTemplateLang.g:4610:5: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_23);
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

            // InternalTemplateLang.g:4627:3: ( (lv_units_1_0= ruleDeclarationUnit ) )
            // InternalTemplateLang.g:4628:4: (lv_units_1_0= ruleDeclarationUnit )
            {
            // InternalTemplateLang.g:4628:4: (lv_units_1_0= ruleDeclarationUnit )
            // InternalTemplateLang.g:4629:5: lv_units_1_0= ruleDeclarationUnit
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_48);
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

            // InternalTemplateLang.g:4646:3: (otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==22) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalTemplateLang.g:4647:4: otherlv_2= ',' ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:4651:4: ( (lv_units_3_0= ruleDeclarationUnit ) )
            	    // InternalTemplateLang.g:4652:5: (lv_units_3_0= ruleDeclarationUnit )
            	    {
            	    // InternalTemplateLang.g:4652:5: (lv_units_3_0= ruleDeclarationUnit )
            	    // InternalTemplateLang.g:4653:6: lv_units_3_0= ruleDeclarationUnit
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDeclarationAccess().getUnitsDeclarationUnitParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
            	    break loop78;
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
    // InternalTemplateLang.g:4675:1: entryRuleDeclarationUnit returns [EObject current=null] : iv_ruleDeclarationUnit= ruleDeclarationUnit EOF ;
    public final EObject entryRuleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarationUnit = null;


        try {
            // InternalTemplateLang.g:4675:56: (iv_ruleDeclarationUnit= ruleDeclarationUnit EOF )
            // InternalTemplateLang.g:4676:2: iv_ruleDeclarationUnit= ruleDeclarationUnit EOF
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
    // InternalTemplateLang.g:4682:1: ruleDeclarationUnit returns [EObject current=null] : ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleDeclarationUnit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_0_0 = null;

        EObject lv_deflt_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4688:2: ( ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? ) )
            // InternalTemplateLang.g:4689:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            {
            // InternalTemplateLang.g:4689:2: ( ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )? )
            // InternalTemplateLang.g:4690:3: ( (lv_id_0_0= ruleIdentifier ) ) (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            {
            // InternalTemplateLang.g:4690:3: ( (lv_id_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:4691:4: (lv_id_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:4691:4: (lv_id_0_0= ruleIdentifier )
            // InternalTemplateLang.g:4692:5: lv_id_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclarationUnitAccess().getIdIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_49);
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

            // InternalTemplateLang.g:4709:3: (otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==23) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalTemplateLang.g:4710:4: otherlv_1= '=' ( (lv_deflt_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeclarationUnitAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalTemplateLang.g:4714:4: ( (lv_deflt_2_0= ruleExpression ) )
                    // InternalTemplateLang.g:4715:5: (lv_deflt_2_0= ruleExpression )
                    {
                    // InternalTemplateLang.g:4715:5: (lv_deflt_2_0= ruleExpression )
                    // InternalTemplateLang.g:4716:6: lv_deflt_2_0= ruleExpression
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
    // InternalTemplateLang.g:4738:1: entryRuleAnnotationDeclarations returns [EObject current=null] : iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF ;
    public final EObject entryRuleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotationDeclarations = null;


        try {
            // InternalTemplateLang.g:4738:63: (iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF )
            // InternalTemplateLang.g:4739:2: iv_ruleAnnotationDeclarations= ruleAnnotationDeclarations EOF
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
    // InternalTemplateLang.g:4745:1: ruleAnnotationDeclarations returns [EObject current=null] : ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleAnnotationDeclarations() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4751:2: ( ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* ) )
            // InternalTemplateLang.g:4752:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            {
            // InternalTemplateLang.g:4752:2: ( () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )* )
            // InternalTemplateLang.g:4753:3: () (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            {
            // InternalTemplateLang.g:4753:3: ()
            // InternalTemplateLang.g:4754:4: 
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

            // InternalTemplateLang.g:4763:3: (otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==75) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalTemplateLang.g:4764:4: otherlv_1= '@' ( (lv_id_2_0= ruleIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,75,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getAnnotationDeclarationsAccess().getCommercialAtKeyword_1_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:4768:4: ( (lv_id_2_0= ruleIdentifier ) )
            	    // InternalTemplateLang.g:4769:5: (lv_id_2_0= ruleIdentifier )
            	    {
            	    // InternalTemplateLang.g:4769:5: (lv_id_2_0= ruleIdentifier )
            	    // InternalTemplateLang.g:4770:6: lv_id_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAnnotationDeclarationsAccess().getIdIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_63);
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
            	    break loop80;
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
    // InternalTemplateLang.g:4792:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalTemplateLang.g:4792:45: (iv_ruleCall= ruleCall EOF )
            // InternalTemplateLang.g:4793:2: iv_ruleCall= ruleCall EOF
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
    // InternalTemplateLang.g:4799:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4805:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // InternalTemplateLang.g:4806:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // InternalTemplateLang.g:4806:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // InternalTemplateLang.g:4807:3: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // InternalTemplateLang.g:4807:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // InternalTemplateLang.g:4808:4: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // InternalTemplateLang.g:4808:4: (lv_name_0_0= ruleQualifiedPrefix )
            // InternalTemplateLang.g:4809:5: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
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

            otherlv_1=(Token)match(input,14,FOLLOW_64); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalTemplateLang.g:4830:3: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalTemplateLang.g:4831:4: (lv_decl_2_0= ruleDeclarator )
                    {
                    // InternalTemplateLang.g:4831:4: (lv_decl_2_0= ruleDeclarator )
                    // InternalTemplateLang.g:4832:5: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_61);
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

            // InternalTemplateLang.g:4849:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_ID && LA82_0<=RULE_EXPONENT)||LA82_0==14||LA82_0==17||LA82_0==30||LA82_0==51||LA82_0==67||(LA82_0>=69 && LA82_0<=71)||(LA82_0>=77 && LA82_0<=79)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalTemplateLang.g:4850:4: (lv_param_3_0= ruleArgumentList )
                    {
                    // InternalTemplateLang.g:4850:4: (lv_param_3_0= ruleArgumentList )
                    // InternalTemplateLang.g:4851:5: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
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
    // InternalTemplateLang.g:4876:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // InternalTemplateLang.g:4876:53: (iv_ruleArgumentList= ruleArgumentList EOF )
            // InternalTemplateLang.g:4877:2: iv_ruleArgumentList= ruleArgumentList EOF
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
    // InternalTemplateLang.g:4883:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4889:2: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // InternalTemplateLang.g:4890:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // InternalTemplateLang.g:4890:2: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // InternalTemplateLang.g:4891:3: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // InternalTemplateLang.g:4891:3: ( (lv_param_0_0= ruleNamedArgument ) )
            // InternalTemplateLang.g:4892:4: (lv_param_0_0= ruleNamedArgument )
            {
            // InternalTemplateLang.g:4892:4: (lv_param_0_0= ruleNamedArgument )
            // InternalTemplateLang.g:4893:5: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_48);
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

            // InternalTemplateLang.g:4910:3: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==22) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalTemplateLang.g:4911:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:4915:4: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // InternalTemplateLang.g:4916:5: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // InternalTemplateLang.g:4916:5: (lv_param_2_0= ruleNamedArgument )
            	    // InternalTemplateLang.g:4917:6: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // InternalTemplateLang.g:4939:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // InternalTemplateLang.g:4939:54: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // InternalTemplateLang.g:4940:2: iv_ruleNamedArgument= ruleNamedArgument EOF
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
    // InternalTemplateLang.g:4946:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:4952:2: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // InternalTemplateLang.g:4953:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // InternalTemplateLang.g:4953:2: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // InternalTemplateLang.g:4954:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // InternalTemplateLang.g:4954:3: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt84=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA84_1 = input.LA(2);

                    if ( (LA84_1==23) ) {
                        alt84=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA84_2 = input.LA(2);

                    if ( (LA84_2==23) ) {
                        alt84=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA84_3 = input.LA(2);

                    if ( (LA84_3==23) ) {
                        alt84=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA84_4 = input.LA(2);

                    if ( (LA84_4==23) ) {
                        alt84=1;
                    }
                    }
                    break;
            }

            switch (alt84) {
                case 1 :
                    // InternalTemplateLang.g:4955:4: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // InternalTemplateLang.g:4955:4: ( (lv_name_0_0= ruleIdentifier ) )
                    // InternalTemplateLang.g:4956:5: (lv_name_0_0= ruleIdentifier )
                    {
                    // InternalTemplateLang.g:4956:5: (lv_name_0_0= ruleIdentifier )
                    // InternalTemplateLang.g:4957:6: lv_name_0_0= ruleIdentifier
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

                    otherlv_1=(Token)match(input,23,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalTemplateLang.g:4979:3: ( (lv_ex_2_0= ruleExpression ) )
            // InternalTemplateLang.g:4980:4: (lv_ex_2_0= ruleExpression )
            {
            // InternalTemplateLang.g:4980:4: (lv_ex_2_0= ruleExpression )
            // InternalTemplateLang.g:4981:5: lv_ex_2_0= ruleExpression
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
    // InternalTemplateLang.g:5002:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // InternalTemplateLang.g:5002:56: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // InternalTemplateLang.g:5003:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
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
    // InternalTemplateLang.g:5009:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:5015:2: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalTemplateLang.g:5016:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalTemplateLang.g:5016:2: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalTemplateLang.g:5017:3: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalTemplateLang.g:5017:3: ( (lv_qname_0_0= ruleIdentifier ) )
            // InternalTemplateLang.g:5018:4: (lv_qname_0_0= ruleIdentifier )
            {
            // InternalTemplateLang.g:5018:4: (lv_qname_0_0= ruleIdentifier )
            // InternalTemplateLang.g:5019:5: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_65);
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

            // InternalTemplateLang.g:5036:3: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==76) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalTemplateLang.g:5037:4: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalTemplateLang.g:5037:4: ( (lv_qname_1_0= '::' ) )
            	    // InternalTemplateLang.g:5038:5: (lv_qname_1_0= '::' )
            	    {
            	    // InternalTemplateLang.g:5038:5: (lv_qname_1_0= '::' )
            	    // InternalTemplateLang.g:5039:6: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,76,FOLLOW_8); if (state.failed) return current;
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

            	    // InternalTemplateLang.g:5051:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalTemplateLang.g:5052:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalTemplateLang.g:5052:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalTemplateLang.g:5053:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_65);
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
            	    break loop85;
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
    // InternalTemplateLang.g:5075:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // InternalTemplateLang.g:5075:54: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTemplateLang.g:5076:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalTemplateLang.g:5082:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:5088:2: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // InternalTemplateLang.g:5089:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // InternalTemplateLang.g:5089:2: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // InternalTemplateLang.g:5090:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // InternalTemplateLang.g:5090:3: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // InternalTemplateLang.g:5091:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // InternalTemplateLang.g:5091:4: (lv_prefix_0_0= ruleQualifiedPrefix )
            // InternalTemplateLang.g:5092:5: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_42);
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

            // InternalTemplateLang.g:5109:3: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==43) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA86_3 = input.LA(3);

                        if ( (LA86_3==EOF||LA86_3==13||LA86_3==15||(LA86_3>=17 && LA86_3<=22)||LA86_3==24||LA86_3==27||LA86_3==34||LA86_3==43||LA86_3==49||(LA86_3>=54 && LA86_3<=68)||(LA86_3>=72 && LA86_3<=74)) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA86_4 = input.LA(3);

                        if ( (LA86_4==EOF||LA86_4==13||LA86_4==15||(LA86_4>=17 && LA86_4<=22)||LA86_4==24||LA86_4==27||LA86_4==34||LA86_4==43||LA86_4==49||(LA86_4>=54 && LA86_4<=68)||(LA86_4>=72 && LA86_4<=74)) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA86_5 = input.LA(3);

                        if ( (LA86_5==EOF||LA86_5==13||LA86_5==15||(LA86_5>=17 && LA86_5<=22)||LA86_5==24||LA86_5==27||LA86_5==34||LA86_5==43||LA86_5==49||(LA86_5>=54 && LA86_5<=68)||(LA86_5>=72 && LA86_5<=74)) ) {
                            alt86=1;
                        }


                        }
                        break;
                    case 51:
                        {
                        int LA86_6 = input.LA(3);

                        if ( (LA86_6==EOF||LA86_6==13||LA86_6==15||(LA86_6>=17 && LA86_6<=22)||LA86_6==24||LA86_6==27||LA86_6==34||LA86_6==43||LA86_6==49||(LA86_6>=54 && LA86_6<=68)||(LA86_6>=72 && LA86_6<=74)) ) {
                            alt86=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt86) {
            	case 1 :
            	    // InternalTemplateLang.g:5110:4: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // InternalTemplateLang.g:5110:4: ( (lv_qname_1_0= '.' ) )
            	    // InternalTemplateLang.g:5111:5: (lv_qname_1_0= '.' )
            	    {
            	    // InternalTemplateLang.g:5111:5: (lv_qname_1_0= '.' )
            	    // InternalTemplateLang.g:5112:6: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,43,FOLLOW_8); if (state.failed) return current;
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

            	    // InternalTemplateLang.g:5124:4: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // InternalTemplateLang.g:5125:5: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // InternalTemplateLang.g:5125:5: (lv_qname_2_0= ruleIdentifier )
            	    // InternalTemplateLang.g:5126:6: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // InternalTemplateLang.g:5148:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalTemplateLang.g:5148:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalTemplateLang.g:5149:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalTemplateLang.g:5155:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // InternalTemplateLang.g:5161:2: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // InternalTemplateLang.g:5162:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // InternalTemplateLang.g:5162:2: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt88=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt88=1;
                }
                break;
            case RULE_STRING:
                {
                alt88=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 51:
                {
                alt88=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA88_4 = input.LA(2);

                if ( (synpred109_InternalTemplateLang()) ) {
                    alt88=3;
                }
                else if ( (synpred113_InternalTemplateLang()) ) {
                    alt88=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 4, input);

                    throw nvae;
                }
                }
                break;
            case 77:
            case 78:
                {
                alt88=4;
                }
                break;
            case 79:
                {
                alt88=5;
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
                    // InternalTemplateLang.g:5163:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // InternalTemplateLang.g:5163:3: ( (lv_nValue_0_0= ruleNumValue ) )
                    // InternalTemplateLang.g:5164:4: (lv_nValue_0_0= ruleNumValue )
                    {
                    // InternalTemplateLang.g:5164:4: (lv_nValue_0_0= ruleNumValue )
                    // InternalTemplateLang.g:5165:5: lv_nValue_0_0= ruleNumValue
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
                    // InternalTemplateLang.g:5183:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // InternalTemplateLang.g:5183:3: ( (lv_sValue_1_0= RULE_STRING ) )
                    // InternalTemplateLang.g:5184:4: (lv_sValue_1_0= RULE_STRING )
                    {
                    // InternalTemplateLang.g:5184:4: (lv_sValue_1_0= RULE_STRING )
                    // InternalTemplateLang.g:5185:5: lv_sValue_1_0= RULE_STRING
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
                    // InternalTemplateLang.g:5202:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // InternalTemplateLang.g:5202:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // InternalTemplateLang.g:5203:4: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // InternalTemplateLang.g:5203:4: (lv_qValue_2_0= ruleQualifiedName )
                    // InternalTemplateLang.g:5204:5: lv_qValue_2_0= ruleQualifiedName
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
                    // InternalTemplateLang.g:5222:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // InternalTemplateLang.g:5222:3: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // InternalTemplateLang.g:5223:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // InternalTemplateLang.g:5223:4: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // InternalTemplateLang.g:5224:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // InternalTemplateLang.g:5224:5: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==77) ) {
                        alt87=1;
                    }
                    else if ( (LA87_0==78) ) {
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
                            // InternalTemplateLang.g:5225:6: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
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
                            // InternalTemplateLang.g:5236:6: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
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
                    // InternalTemplateLang.g:5250:3: ( (lv_null_4_0= 'null' ) )
                    {
                    // InternalTemplateLang.g:5250:3: ( (lv_null_4_0= 'null' ) )
                    // InternalTemplateLang.g:5251:4: (lv_null_4_0= 'null' )
                    {
                    // InternalTemplateLang.g:5251:4: (lv_null_4_0= 'null' )
                    // InternalTemplateLang.g:5252:5: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
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
                    // InternalTemplateLang.g:5265:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // InternalTemplateLang.g:5265:3: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // InternalTemplateLang.g:5266:4: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // InternalTemplateLang.g:5270:4: (lv_version_5_0= RULE_VERSION )
                    // InternalTemplateLang.g:5271:5: lv_version_5_0= RULE_VERSION
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
    // InternalTemplateLang.g:5291:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // InternalTemplateLang.g:5291:49: (iv_ruleNumValue= ruleNumValue EOF )
            // InternalTemplateLang.g:5292:2: iv_ruleNumValue= ruleNumValue EOF
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
    // InternalTemplateLang.g:5298:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:5304:2: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // InternalTemplateLang.g:5305:2: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // InternalTemplateLang.g:5305:2: ( (lv_val_0_0= RULE_NUMBER ) )
            // InternalTemplateLang.g:5306:3: (lv_val_0_0= RULE_NUMBER )
            {
            // InternalTemplateLang.g:5306:3: (lv_val_0_0= RULE_NUMBER )
            // InternalTemplateLang.g:5307:4: lv_val_0_0= RULE_NUMBER
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
    // InternalTemplateLang.g:5326:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // InternalTemplateLang.g:5326:50: (iv_ruleIdentifier= ruleIdentifier EOF )
            // InternalTemplateLang.g:5327:2: iv_ruleIdentifier= ruleIdentifier EOF
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
    // InternalTemplateLang.g:5333:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalTemplateLang.g:5339:2: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // InternalTemplateLang.g:5340:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // InternalTemplateLang.g:5340:2: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt89=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt89=1;
                }
                break;
            case RULE_VERSION:
                {
                alt89=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt89=3;
                }
                break;
            case 51:
                {
                alt89=4;
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
                    // InternalTemplateLang.g:5341:3: this_ID_0= RULE_ID
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
                    // InternalTemplateLang.g:5349:3: this_VERSION_1= RULE_VERSION
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
                    // InternalTemplateLang.g:5357:3: this_EXPONENT_2= RULE_EXPONENT
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
                    // InternalTemplateLang.g:5365:3: kw= 'version'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:5374:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalTemplateLang.g:5374:45: (iv_ruleType= ruleType EOF )
            // InternalTemplateLang.g:5375:2: iv_ruleType= ruleType EOF
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
    // InternalTemplateLang.g:5381:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // InternalTemplateLang.g:5387:2: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // InternalTemplateLang.g:5388:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // InternalTemplateLang.g:5388:2: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt91=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_VERSION:
            case RULE_EXPONENT:
            case 51:
                {
                alt91=1;
                }
                break;
            case 80:
                {
                alt91=2;
                }
                break;
            case 81:
                {
                alt91=3;
                }
                break;
            case 82:
                {
                alt91=4;
                }
                break;
            case 83:
                {
                alt91=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // InternalTemplateLang.g:5389:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // InternalTemplateLang.g:5389:3: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // InternalTemplateLang.g:5390:4: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // InternalTemplateLang.g:5390:4: (lv_name_0_0= ruleQualifiedPrefix )
                    // InternalTemplateLang.g:5391:5: lv_name_0_0= ruleQualifiedPrefix
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
                    // InternalTemplateLang.g:5409:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // InternalTemplateLang.g:5409:3: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // InternalTemplateLang.g:5410:4: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // InternalTemplateLang.g:5410:4: ( (lv_set_1_0= 'setOf' ) )
                    // InternalTemplateLang.g:5411:5: (lv_set_1_0= 'setOf' )
                    {
                    // InternalTemplateLang.g:5411:5: (lv_set_1_0= 'setOf' )
                    // InternalTemplateLang.g:5412:6: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,80,FOLLOW_9); if (state.failed) return current;
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

                    // InternalTemplateLang.g:5424:4: ( (lv_param_2_0= ruleTypeParameters ) )
                    // InternalTemplateLang.g:5425:5: (lv_param_2_0= ruleTypeParameters )
                    {
                    // InternalTemplateLang.g:5425:5: (lv_param_2_0= ruleTypeParameters )
                    // InternalTemplateLang.g:5426:6: lv_param_2_0= ruleTypeParameters
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
                    // InternalTemplateLang.g:5445:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // InternalTemplateLang.g:5445:3: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // InternalTemplateLang.g:5446:4: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // InternalTemplateLang.g:5446:4: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // InternalTemplateLang.g:5447:5: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // InternalTemplateLang.g:5447:5: (lv_seq_3_0= 'sequenceOf' )
                    // InternalTemplateLang.g:5448:6: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,81,FOLLOW_9); if (state.failed) return current;
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

                    // InternalTemplateLang.g:5460:4: ( (lv_param_4_0= ruleTypeParameters ) )
                    // InternalTemplateLang.g:5461:5: (lv_param_4_0= ruleTypeParameters )
                    {
                    // InternalTemplateLang.g:5461:5: (lv_param_4_0= ruleTypeParameters )
                    // InternalTemplateLang.g:5462:6: lv_param_4_0= ruleTypeParameters
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
                    // InternalTemplateLang.g:5481:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // InternalTemplateLang.g:5481:3: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // InternalTemplateLang.g:5482:4: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // InternalTemplateLang.g:5482:4: ( (lv_map_5_0= 'mapOf' ) )
                    // InternalTemplateLang.g:5483:5: (lv_map_5_0= 'mapOf' )
                    {
                    // InternalTemplateLang.g:5483:5: (lv_map_5_0= 'mapOf' )
                    // InternalTemplateLang.g:5484:6: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,82,FOLLOW_9); if (state.failed) return current;
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

                    // InternalTemplateLang.g:5496:4: ( (lv_param_6_0= ruleTypeParameters ) )
                    // InternalTemplateLang.g:5497:5: (lv_param_6_0= ruleTypeParameters )
                    {
                    // InternalTemplateLang.g:5497:5: (lv_param_6_0= ruleTypeParameters )
                    // InternalTemplateLang.g:5498:6: lv_param_6_0= ruleTypeParameters
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
                    // InternalTemplateLang.g:5517:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // InternalTemplateLang.g:5517:3: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // InternalTemplateLang.g:5518:4: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // InternalTemplateLang.g:5518:4: ( (lv_call_7_0= 'callOf' ) )
                    // InternalTemplateLang.g:5519:5: (lv_call_7_0= 'callOf' )
                    {
                    // InternalTemplateLang.g:5519:5: (lv_call_7_0= 'callOf' )
                    // InternalTemplateLang.g:5520:6: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,83,FOLLOW_66); if (state.failed) return current;
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

                    // InternalTemplateLang.g:5532:4: ( (lv_return_8_0= ruleType ) )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_ID||(LA90_0>=RULE_VERSION && LA90_0<=RULE_EXPONENT)||LA90_0==51||(LA90_0>=80 && LA90_0<=83)) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // InternalTemplateLang.g:5533:5: (lv_return_8_0= ruleType )
                            {
                            // InternalTemplateLang.g:5533:5: (lv_return_8_0= ruleType )
                            // InternalTemplateLang.g:5534:6: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0());
                              					
                            }
                            pushFollow(FOLLOW_9);
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

                    // InternalTemplateLang.g:5551:4: ( (lv_param_9_0= ruleTypeParameters ) )
                    // InternalTemplateLang.g:5552:5: (lv_param_9_0= ruleTypeParameters )
                    {
                    // InternalTemplateLang.g:5552:5: (lv_param_9_0= ruleTypeParameters )
                    // InternalTemplateLang.g:5553:6: lv_param_9_0= ruleTypeParameters
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
    // InternalTemplateLang.g:5575:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // InternalTemplateLang.g:5575:55: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // InternalTemplateLang.g:5576:2: iv_ruleTypeParameters= ruleTypeParameters EOF
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
    // InternalTemplateLang.g:5582:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:5588:2: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // InternalTemplateLang.g:5589:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // InternalTemplateLang.g:5589:2: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // InternalTemplateLang.g:5590:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalTemplateLang.g:5594:3: ( (lv_param_1_0= ruleType ) )
            // InternalTemplateLang.g:5595:4: (lv_param_1_0= ruleType )
            {
            // InternalTemplateLang.g:5595:4: (lv_param_1_0= ruleType )
            // InternalTemplateLang.g:5596:5: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_17);
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

            // InternalTemplateLang.g:5613:3: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==22) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalTemplateLang.g:5614:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalTemplateLang.g:5618:4: ( (lv_param_3_0= ruleType ) )
            	    // InternalTemplateLang.g:5619:5: (lv_param_3_0= ruleType )
            	    {
            	    // InternalTemplateLang.g:5619:5: (lv_param_3_0= ruleType )
            	    // InternalTemplateLang.g:5620:6: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
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
            	    break loop92;
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
    // InternalTemplateLang.g:5646:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // InternalTemplateLang.g:5646:61: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // InternalTemplateLang.g:5647:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
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
    // InternalTemplateLang.g:5653:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:5659:2: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // InternalTemplateLang.g:5660:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // InternalTemplateLang.g:5660:2: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // InternalTemplateLang.g:5661:3: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // InternalTemplateLang.g:5661:3: ()
            // InternalTemplateLang.g:5662:4: 
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

            otherlv_1=(Token)match(input,17,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalTemplateLang.g:5675:3: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=RULE_ID && LA94_0<=RULE_EXPONENT)||LA94_0==14||LA94_0==17||LA94_0==30||LA94_0==51||LA94_0==67||(LA94_0>=69 && LA94_0<=71)||(LA94_0>=77 && LA94_0<=79)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalTemplateLang.g:5676:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // InternalTemplateLang.g:5676:4: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // InternalTemplateLang.g:5677:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // InternalTemplateLang.g:5677:5: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // InternalTemplateLang.g:5678:6: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
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

                    // InternalTemplateLang.g:5695:4: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==22) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // InternalTemplateLang.g:5696:5: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,22,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalTemplateLang.g:5700:5: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // InternalTemplateLang.g:5701:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // InternalTemplateLang.g:5701:6: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // InternalTemplateLang.g:5702:7: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop93;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
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
    // InternalTemplateLang.g:5729:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // InternalTemplateLang.g:5729:71: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // InternalTemplateLang.g:5730:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
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
    // InternalTemplateLang.g:5736:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;



        	enterRule();

        try {
            // InternalTemplateLang.g:5742:2: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // InternalTemplateLang.g:5743:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // InternalTemplateLang.g:5743:2: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=RULE_ID && LA95_0<=RULE_EXPONENT)||LA95_0==14||LA95_0==30||LA95_0==51||LA95_0==67||(LA95_0>=69 && LA95_0<=71)||(LA95_0>=77 && LA95_0<=79)) ) {
                alt95=1;
            }
            else if ( (LA95_0==17) ) {
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
                    // InternalTemplateLang.g:5744:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // InternalTemplateLang.g:5744:3: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // InternalTemplateLang.g:5745:4: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // InternalTemplateLang.g:5745:4: (lv_logical_0_0= ruleLogicalExpression )
                    // InternalTemplateLang.g:5746:5: lv_logical_0_0= ruleLogicalExpression
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
                    // InternalTemplateLang.g:5764:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // InternalTemplateLang.g:5764:3: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // InternalTemplateLang.g:5765:4: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // InternalTemplateLang.g:5765:4: (lv_container_1_0= ruleContainerInitializer )
                    // InternalTemplateLang.g:5766:5: lv_container_1_0= ruleContainerInitializer
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

    // $ANTLR start synpred8_InternalTemplateLang
    public final void synpred8_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_version_13_0 = null;


        // InternalTemplateLang.g:260:4: ( (lv_version_13_0= ruleVersionStmt ) )
        // InternalTemplateLang.g:260:4: (lv_version_13_0= ruleVersionStmt )
        {
        // InternalTemplateLang.g:260:4: (lv_version_13_0= ruleVersionStmt )
        // InternalTemplateLang.g:261:5: lv_version_13_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_12_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_version_13_0=ruleVersionStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalTemplateLang

    // $ANTLR start synpred18_InternalTemplateLang
    public final void synpred18_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_annotations_0_0 = null;


        // InternalTemplateLang.g:749:4: ( (lv_annotations_0_0= ruleAnnotationDeclarations ) )
        // InternalTemplateLang.g:749:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
        {
        // InternalTemplateLang.g:749:4: (lv_annotations_0_0= ruleAnnotationDeclarations )
        // InternalTemplateLang.g:750:5: lv_annotations_0_0= ruleAnnotationDeclarations
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getVilDefAccess().getAnnotationsAnnotationDeclarationsParserRuleCall_0_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_annotations_0_0=ruleAnnotationDeclarations();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalTemplateLang

    // $ANTLR start synpred24_InternalTemplateLang
    public final void synpred24_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_var_0_0 = null;


        // InternalTemplateLang.g:950:3: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) )
        // InternalTemplateLang.g:950:3: ( (lv_var_0_0= ruleVariableDeclaration ) )
        {
        // InternalTemplateLang.g:950:3: ( (lv_var_0_0= ruleVariableDeclaration ) )
        // InternalTemplateLang.g:951:4: (lv_var_0_0= ruleVariableDeclaration )
        {
        // InternalTemplateLang.g:951:4: (lv_var_0_0= ruleVariableDeclaration )
        // InternalTemplateLang.g:952:5: lv_var_0_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getStmtAccess().getVarVariableDeclarationParserRuleCall_0_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_var_0_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred24_InternalTemplateLang

    // $ANTLR start synpred27_InternalTemplateLang
    public final void synpred27_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_multi_3_0 = null;


        // InternalTemplateLang.g:1010:3: ( ( (lv_multi_3_0= rulemultiselect ) ) )
        // InternalTemplateLang.g:1010:3: ( (lv_multi_3_0= rulemultiselect ) )
        {
        // InternalTemplateLang.g:1010:3: ( (lv_multi_3_0= rulemultiselect ) )
        // InternalTemplateLang.g:1011:4: (lv_multi_3_0= rulemultiselect )
        {
        // InternalTemplateLang.g:1011:4: (lv_multi_3_0= rulemultiselect )
        // InternalTemplateLang.g:1012:5: lv_multi_3_0= rulemultiselect
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getStmtAccess().getMultiMultiselectParserRuleCall_3_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_multi_3_0=rulemultiselect();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred27_InternalTemplateLang

    // $ANTLR start synpred30_InternalTemplateLang
    public final void synpred30_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_exprStmt_6_0 = null;


        // InternalTemplateLang.g:1070:3: ( ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) )
        // InternalTemplateLang.g:1070:3: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        {
        // InternalTemplateLang.g:1070:3: ( (lv_exprStmt_6_0= ruleExpressionStatement ) )
        // InternalTemplateLang.g:1071:4: (lv_exprStmt_6_0= ruleExpressionStatement )
        {
        // InternalTemplateLang.g:1071:4: (lv_exprStmt_6_0= ruleExpressionStatement )
        // InternalTemplateLang.g:1072:5: lv_exprStmt_6_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getStmtAccess().getExprStmtExpressionStatementParserRuleCall_6_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_exprStmt_6_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred30_InternalTemplateLang

    // $ANTLR start synpred31_InternalTemplateLang
    public final void synpred31_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_ctn_7_0 = null;


        // InternalTemplateLang.g:1090:3: ( ( (lv_ctn_7_0= ruleContent ) ) )
        // InternalTemplateLang.g:1090:3: ( (lv_ctn_7_0= ruleContent ) )
        {
        // InternalTemplateLang.g:1090:3: ( (lv_ctn_7_0= ruleContent ) )
        // InternalTemplateLang.g:1091:4: (lv_ctn_7_0= ruleContent )
        {
        // InternalTemplateLang.g:1091:4: (lv_ctn_7_0= ruleContent )
        // InternalTemplateLang.g:1092:5: lv_ctn_7_0= ruleContent
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getStmtAccess().getCtnContentParserRuleCall_7_0());
          				
        }
        pushFollow(FOLLOW_2);
        lv_ctn_7_0=ruleContent();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred31_InternalTemplateLang

    // $ANTLR start synpred32_InternalTemplateLang
    public final void synpred32_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_if_4_0 = null;


        // InternalTemplateLang.g:1180:4: ( ( (lv_if_4_0= ruleStmt ) ) )
        // InternalTemplateLang.g:1180:4: ( (lv_if_4_0= ruleStmt ) )
        {
        // InternalTemplateLang.g:1180:4: ( (lv_if_4_0= ruleStmt ) )
        // InternalTemplateLang.g:1181:5: (lv_if_4_0= ruleStmt )
        {
        // InternalTemplateLang.g:1181:5: (lv_if_4_0= ruleStmt )
        // InternalTemplateLang.g:1182:6: lv_if_4_0= ruleStmt
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getAlternativeAccess().getIfStmtParserRuleCall_4_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_if_4_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred32_InternalTemplateLang

    // $ANTLR start synpred34_InternalTemplateLang
    public final void synpred34_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_else_7_0 = null;


        // InternalTemplateLang.g:1229:5: ( ( (lv_else_7_0= ruleStmt ) ) )
        // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
        {
        // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
        // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
        {
        // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
        // InternalTemplateLang.g:1231:7: lv_else_7_0= ruleStmt
        {
        if ( state.backtracking==0 ) {

          							newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0_0());
          						
        }
        pushFollow(FOLLOW_2);
        lv_else_7_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred34_InternalTemplateLang

    // $ANTLR start synpred35_InternalTemplateLang
    public final void synpred35_InternalTemplateLang_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        EObject lv_else_7_0 = null;

        EObject lv_elseBlock_8_0 = null;


        // InternalTemplateLang.g:1221:4: ( ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) ) )
        // InternalTemplateLang.g:1221:4: ( ( 'else' )=>otherlv_6= 'else' ) ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )
        {
        // InternalTemplateLang.g:1221:4: ( ( 'else' )=>otherlv_6= 'else' )
        // InternalTemplateLang.g:1222:5: ( 'else' )=>otherlv_6= 'else'
        {
        otherlv_6=(Token)match(input,29,FOLLOW_27); if (state.failed) return ;

        }

        // InternalTemplateLang.g:1228:4: ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )
        int alt97=2;
        alt97 = dfa97.predict(input);
        switch (alt97) {
            case 1 :
                // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
                {
                // InternalTemplateLang.g:1229:5: ( (lv_else_7_0= ruleStmt ) )
                // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
                {
                // InternalTemplateLang.g:1230:6: (lv_else_7_0= ruleStmt )
                // InternalTemplateLang.g:1231:7: lv_else_7_0= ruleStmt
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getAlternativeAccess().getElseStmtParserRuleCall_5_1_0_0());
                  						
                }
                pushFollow(FOLLOW_2);
                lv_else_7_0=ruleStmt();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalTemplateLang.g:1249:5: ( (lv_elseBlock_8_0= ruleStmtBlock ) )
                {
                // InternalTemplateLang.g:1249:5: ( (lv_elseBlock_8_0= ruleStmtBlock ) )
                // InternalTemplateLang.g:1250:6: (lv_elseBlock_8_0= ruleStmtBlock )
                {
                // InternalTemplateLang.g:1250:6: (lv_elseBlock_8_0= ruleStmtBlock )
                // InternalTemplateLang.g:1251:7: lv_elseBlock_8_0= ruleStmtBlock
                {
                if ( state.backtracking==0 ) {

                  							newCompositeNode(grammarAccess.getAlternativeAccess().getElseBlockStmtBlockParserRuleCall_5_1_1_0());
                  						
                }
                pushFollow(FOLLOW_2);
                lv_elseBlock_8_0=ruleStmtBlock();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred35_InternalTemplateLang

    // $ANTLR start synpred44_InternalTemplateLang
    public final void synpred44_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_stmt_11_0 = null;


        // InternalTemplateLang.g:1709:4: ( ( (lv_stmt_11_0= ruleStmt ) ) )
        // InternalTemplateLang.g:1709:4: ( (lv_stmt_11_0= ruleStmt ) )
        {
        // InternalTemplateLang.g:1709:4: ( (lv_stmt_11_0= ruleStmt ) )
        // InternalTemplateLang.g:1710:5: (lv_stmt_11_0= ruleStmt )
        {
        // InternalTemplateLang.g:1710:5: (lv_stmt_11_0= ruleStmt )
        // InternalTemplateLang.g:1711:6: lv_stmt_11_0= ruleStmt
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getLoopAccess().getStmtStmtParserRuleCall_8_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_stmt_11_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred44_InternalTemplateLang

    // $ANTLR start synpred45_InternalTemplateLang
    public final void synpred45_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_stmt_4_0 = null;


        // InternalTemplateLang.g:1800:4: ( ( (lv_stmt_4_0= ruleStmt ) ) )
        // InternalTemplateLang.g:1800:4: ( (lv_stmt_4_0= ruleStmt ) )
        {
        // InternalTemplateLang.g:1800:4: ( (lv_stmt_4_0= ruleStmt ) )
        // InternalTemplateLang.g:1801:5: (lv_stmt_4_0= ruleStmt )
        {
        // InternalTemplateLang.g:1801:5: (lv_stmt_4_0= ruleStmt )
        // InternalTemplateLang.g:1802:6: lv_stmt_4_0= ruleStmt
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getWhileAccess().getStmtStmtParserRuleCall_4_0_0());
          					
        }
        pushFollow(FOLLOW_2);
        lv_stmt_4_0=ruleStmt();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred45_InternalTemplateLang

    // $ANTLR start synpred101_InternalTemplateLang
    public final void synpred101_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_decl_2_0 = null;


        // InternalTemplateLang.g:4831:4: ( (lv_decl_2_0= ruleDeclarator ) )
        // InternalTemplateLang.g:4831:4: (lv_decl_2_0= ruleDeclarator )
        {
        // InternalTemplateLang.g:4831:4: (lv_decl_2_0= ruleDeclarator )
        // InternalTemplateLang.g:4832:5: lv_decl_2_0= ruleDeclarator
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
    // $ANTLR end synpred101_InternalTemplateLang

    // $ANTLR start synpred109_InternalTemplateLang
    public final void synpred109_InternalTemplateLang_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // InternalTemplateLang.g:5202:3: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // InternalTemplateLang.g:5202:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // InternalTemplateLang.g:5202:3: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // InternalTemplateLang.g:5203:4: (lv_qValue_2_0= ruleQualifiedName )
        {
        // InternalTemplateLang.g:5203:4: (lv_qValue_2_0= ruleQualifiedName )
        // InternalTemplateLang.g:5204:5: lv_qValue_2_0= ruleQualifiedName
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
    // $ANTLR end synpred109_InternalTemplateLang

    // $ANTLR start synpred113_InternalTemplateLang
    public final void synpred113_InternalTemplateLang_fragment() throws RecognitionException {   
        // InternalTemplateLang.g:5266:4: ( ( RULE_VERSION ) )
        // InternalTemplateLang.g:5266:5: ( RULE_VERSION )
        {
        // InternalTemplateLang.g:5266:5: ( RULE_VERSION )
        // InternalTemplateLang.g:5267:5: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred113_InternalTemplateLang

    // Delegated rules

    public final boolean synpred109_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalTemplateLang_fragment(); // can never throw exception
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
    public final boolean synpred32_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalTemplateLang_fragment(); // can never throw exception
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
    public final boolean synpred8_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalTemplateLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalTemplateLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA97 dfa97 = new DFA97(this);
    static final String dfa_1s = "\35\uffff";
    static final String dfa_2s = "\1\4\1\uffff\4\0\15\uffff\1\0\11\uffff";
    static final String dfa_3s = "\1\123\1\uffff\4\0\15\uffff\1\0\11\uffff";
    static final String dfa_4s = "\1\uffff\1\1\10\uffff\1\2\1\3\1\4\1\5\1\6\1\7\13\uffff\1\11\1\10";
    static final String dfa_5s = "\2\uffff\1\0\1\1\1\2\1\3\15\uffff\1\4\11\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\1\17\1\23\1\3\1\4\5\uffff\1\17\2\uffff\1\17\12\uffff\1\12\1\uffff\1\17\1\uffff\1\13\2\uffff\1\15\1\16\1\33\1\14\5\uffff\1\1\6\uffff\1\5\17\uffff\1\17\1\uffff\3\17\5\uffff\3\17\4\1",
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
            "\1\uffff",
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
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "949:2: ( ( (lv_var_0_0= ruleVariableDeclaration ) ) | ( (lv_alt_1_0= ruleAlternative ) ) | ( (lv_switch_2_0= ruleSwitch ) ) | ( (lv_multi_3_0= rulemultiselect ) ) | ( (lv_loop_4_0= ruleLoop ) ) | ( (lv_while_5_0= ruleWhile ) ) | ( (lv_exprStmt_6_0= ruleExpressionStatement ) ) | ( (lv_ctn_7_0= ruleContent ) ) | ( (lv_flush_8_0= ruleFlush ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred27_InternalTemplateLang()) ) {s = 12;}

                        else if ( (synpred30_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred27_InternalTemplateLang()) ) {s = 12;}

                        else if ( (synpred30_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred27_InternalTemplateLang()) ) {s = 12;}

                        else if ( (synpred30_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred24_InternalTemplateLang()) ) {s = 1;}

                        else if ( (synpred27_InternalTemplateLang()) ) {s = 12;}

                        else if ( (synpred30_InternalTemplateLang()) ) {s = 15;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_19 = input.LA(1);

                         
                        int index21_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalTemplateLang()) ) {s = 15;}

                        else if ( (synpred31_InternalTemplateLang()) ) {s = 28;}

                         
                        input.seek(index21_19);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\1\4\31\uffff\1\0\2\uffff";
    static final String dfa_8s = "\1\123\31\uffff\1\0\2\uffff";
    static final String dfa_9s = "\1\uffff\1\1\32\uffff\1\2";
    static final String dfa_10s = "\32\uffff\1\0\2\uffff}>";
    static final String[] dfa_11s = {
            "\5\1\5\uffff\1\1\2\uffff\1\32\12\uffff\1\1\1\uffff\1\1\1\uffff\1\1\2\uffff\4\1\5\uffff\1\1\6\uffff\1\1\17\uffff\1\1\1\uffff\3\1\5\uffff\7\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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
    static final char[] dfa_7 = DFA.unpackEncodedStringToUnsignedChars(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[][] dfa_11 = unpackEncodedStringArray(dfa_11s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_10;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1179:3: ( ( (lv_if_4_0= ruleStmt ) ) | ( (lv_ifBlock_5_0= ruleStmtBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalTemplateLang()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index22_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_10;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1228:4: ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_26 = input.LA(1);

                         
                        int index23_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalTemplateLang()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index23_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_10;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1708:3: ( ( (lv_stmt_11_0= ruleStmt ) ) | ( (lv_block_12_0= ruleStmtBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_26 = input.LA(1);

                         
                        int index33_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_InternalTemplateLang()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index33_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_10;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1799:3: ( ( (lv_stmt_4_0= ruleStmt ) ) | ( (lv_block_5_0= ruleStmtBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_26 = input.LA(1);

                         
                        int index34_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred45_InternalTemplateLang()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index34_26);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_12s = "\14\uffff";
    static final String dfa_13s = "\1\4\4\16\1\uffff\1\4\1\uffff\4\16";
    static final String dfa_14s = "\1\117\4\114\1\uffff\1\63\1\uffff\4\114";
    static final String dfa_15s = "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String dfa_16s = "\14\uffff}>";
    static final String[] dfa_17s = {
            "\1\1\2\5\1\2\1\3\5\uffff\1\5\2\uffff\1\5\14\uffff\1\5\24\uffff\1\4\17\uffff\1\5\1\uffff\3\5\5\uffff\3\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\6\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\6\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\6\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\6\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "",
            "\1\10\2\uffff\1\11\1\12\52\uffff\1\13",
            "",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\5\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\5\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\5\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5",
            "\1\5\5\uffff\1\5\2\uffff\1\7\3\uffff\1\5\17\uffff\1\5\12\uffff\17\5\3\uffff\2\5\2\uffff\1\5"
    };

    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final char[] dfa_13 = DFA.unpackEncodedStringToUnsignedChars(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[][] dfa_17 = unpackEncodedStringArray(dfa_17s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_12;
            this.eof = dfa_12;
            this.min = dfa_13;
            this.max = dfa_14;
            this.accept = dfa_15;
            this.special = dfa_16;
            this.transition = dfa_17;
        }
        public String getDescription() {
            return "2991:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String dfa_18s = "\16\uffff";
    static final String dfa_19s = "\2\uffff\4\1\4\uffff\4\1";
    static final String dfa_20s = "\1\4\1\uffff\4\15\2\uffff\1\4\1\uffff\4\15";
    static final String dfa_21s = "\1\117\1\uffff\4\114\2\uffff\1\63\1\uffff\4\114";
    static final String dfa_22s = "\1\uffff\1\1\4\uffff\1\3\1\4\1\uffff\1\2\4\uffff";
    static final String dfa_23s = "\16\uffff}>";
    static final String[] dfa_24s = {
            "\1\2\2\1\1\3\1\4\5\uffff\1\1\44\uffff\1\5\22\uffff\1\6\1\7\5\uffff\3\1",
            "",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "",
            "",
            "\1\12\2\uffff\1\13\1\14\52\uffff\1\15",
            "",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10",
            "\1\1\1\11\1\1\1\uffff\6\1\1\uffff\1\1\2\uffff\1\1\6\uffff\1\1\10\uffff\1\1\5\uffff\1\1\4\uffff\17\1\3\uffff\3\1\1\uffff\1\10"
    };

    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[][] dfa_24 = unpackEncodedStringArray(dfa_24s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_18;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_23;
            this.transition = dfa_24;
        }
        public String getDescription() {
            return "4046:2: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_newEx_3_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String dfa_25s = "\26\uffff";
    static final String dfa_26s = "\1\4\4\0\21\uffff";
    static final String dfa_27s = "\1\123\4\0\21\uffff";
    static final String dfa_28s = "\5\uffff\1\1\3\uffff\1\2\14\uffff";
    static final String dfa_29s = "\1\uffff\1\0\1\1\1\2\1\3\21\uffff}>";
    static final String[] dfa_30s = {
            "\1\1\2\11\1\2\1\3\5\uffff\2\11\1\uffff\1\11\14\uffff\1\11\24\uffff\1\4\17\uffff\1\11\1\uffff\3\11\5\uffff\3\11\4\5",
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

    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[][] dfa_30 = unpackEncodedStringArray(dfa_30s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_25;
            this.eof = dfa_25;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_29;
            this.transition = dfa_30;
        }
        public String getDescription() {
            return "4830:3: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA81_2 = input.LA(1);

                         
                        int index81_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index81_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA81_3 = input.LA(1);

                         
                        int index81_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index81_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA81_4 = input.LA(1);

                         
                        int index81_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred101_InternalTemplateLang()) ) {s = 5;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index81_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_7;
            this.max = dfa_8;
            this.accept = dfa_9;
            this.special = dfa_10;
            this.transition = dfa_11;
        }
        public String getDescription() {
            return "1228:4: ( ( (lv_else_7_0= ruleStmt ) ) | ( (lv_elseBlock_8_0= ruleStmtBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_26 = input.LA(1);

                         
                        int index97_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalTemplateLang()) ) {s = 1;}

                        else if ( (true) ) {s = 28;}

                         
                        input.seek(index97_26);
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0032040001202000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0002040001202000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0002000001202000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0008000000000190L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0008000000008190L,0x00000000000F0000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0009700006040190L,0x00000000000F0800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0008000000000190L,0x00000000000F0000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00081079500641F0L,0x00000000000FE0E8L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00080000400241F0L,0x000000000000E0E8L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00081079500241F0L,0x00000000000FE0E8L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000C8080002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00080000400041F0L,0x000000000000E0E8L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000800000020000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0008100000040190L,0x00000000000F0000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0044000008000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0004000008000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000080000800000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0F80000000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x7000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x8000000000100002L,0x0000000000000003L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0040000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000300L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x000800004002C1F0L,0x000000000000E0E8L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x000800004002C1F0L,0x00000000000FE0E8L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0008000000004190L,0x00000000000F0000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x00080000400641F0L,0x000000000000E0E8L});

}