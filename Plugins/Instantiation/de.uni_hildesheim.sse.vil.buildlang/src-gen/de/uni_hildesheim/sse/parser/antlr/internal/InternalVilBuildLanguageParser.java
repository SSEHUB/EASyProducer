package de.uni_hildesheim.sse.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.uni_hildesheim.sse.services.VilBuildLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalVilBuildLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_VERSION", "RULE_NUMBER", "RULE_ID", "RULE_EXPONENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requireVTL'", "';'", "'vilScript'", "'('", "')'", "'{'", "'}'", "'extends'", "'load'", "'properties'", "'='", "':'", "','", "'protected'", "'.'", "'instantiate'", "'rule'", "'map'", "'if'", "'else'", "'join'", "'with'", "'exclude'", "'execute'", "'const'", "'typedef'", "'@advice'", "'version'", "'import'", "'and'", "'or'", "'xor'", "'=='", "'<>'", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'not'", "'!'", "'super'", "'new'", "'->'", "'['", "']'", "'|'", "'::'", "'true'", "'false'", "'null'", "'setOf'", "'sequenceOf'", "'mapOf'", "'callOf'"
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
    public static final int RULE_VERSION=5;
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
    public static final int RULE_NUMBER=6;
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
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__71=71;
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


        public InternalVilBuildLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVilBuildLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVilBuildLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g"; }



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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:73:1: entryRuleImplementationUnit returns [EObject current=null] : iv_ruleImplementationUnit= ruleImplementationUnit EOF ;
    public final EObject entryRuleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementationUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:74:2: (iv_ruleImplementationUnit= ruleImplementationUnit EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:75:2: iv_ruleImplementationUnit= ruleImplementationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImplementationUnitRule()); 
            }
            pushFollow(FOLLOW_ruleImplementationUnit_in_entryRuleImplementationUnit81);
            iv_ruleImplementationUnit=ruleImplementationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImplementationUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplementationUnit91); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:82:1: ruleImplementationUnit returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) ;
    public final EObject ruleImplementationUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_requires_2_0 = null;

        EObject lv_scripts_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:85:28: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:86:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_requires_2_0= ruleRequire ) )* ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:86:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:87:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:95:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==41) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:96:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:96:1: (lv_imports_1_0= ruleImport )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:97:3: lv_imports_1_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getImportsImportParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleImplementationUnit149);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:113:3: ( (lv_requires_2_0= ruleRequire ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:114:1: (lv_requires_2_0= ruleRequire )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:114:1: (lv_requires_2_0= ruleRequire )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:115:3: lv_requires_2_0= ruleRequire
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getRequiresRequireParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRequire_in_ruleImplementationUnit171);
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
            	              		"Require");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:131:3: ( (lv_scripts_3_0= ruleLanguageUnit ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15||LA3_0==39) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:132:1: (lv_scripts_3_0= ruleLanguageUnit )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:133:3: lv_scripts_3_0= ruleLanguageUnit
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImplementationUnitAccess().getScriptsLanguageUnitParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLanguageUnit_in_ruleImplementationUnit193);
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
            	              		"LanguageUnit");
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:157:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:158:2: (iv_ruleRequire= ruleRequire EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:159:2: iv_ruleRequire= ruleRequire EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequireRule()); 
            }
            pushFollow(FOLLOW_ruleRequire_in_entryRuleRequire230);
            iv_ruleRequire=ruleRequire();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequire; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequire240); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:166:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:169:28: ( (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:170:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:170:1: (otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:170:3: otherlv_0= 'requireVTL' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleRequire277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireVTLKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:174:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:175:1: (lv_name_1_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:175:1: (lv_name_1_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:176:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRequire294); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:192:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:193:1: (lv_versionSpec_2_0= ruleVersionSpec )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:193:1: (lv_versionSpec_2_0= ruleVersionSpec )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:194:3: lv_versionSpec_2_0= ruleVersionSpec
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRequireAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_ruleRequire320);
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
                      		"VersionSpec");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleRequire332); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:222:1: entryRuleLanguageUnit returns [EObject current=null] : iv_ruleLanguageUnit= ruleLanguageUnit EOF ;
    public final EObject entryRuleLanguageUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageUnit = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:223:2: (iv_ruleLanguageUnit= ruleLanguageUnit EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:224:2: iv_ruleLanguageUnit= ruleLanguageUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLanguageUnitRule()); 
            }
            pushFollow(FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit368);
            iv_ruleLanguageUnit=ruleLanguageUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLanguageUnit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLanguageUnit378); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:231:1: ruleLanguageUnit returns [EObject current=null] : ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:234:28: ( ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:235:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:235:1: ( ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:235:2: ( (lv_advices_0_0= ruleAdvice ) )* otherlv_1= 'vilScript' ( (lv_name_2_0= ruleIdentifier ) ) otherlv_3= '(' ( (lv_param_4_0= ruleParameterList ) )? otherlv_5= ')' ( (lv_parent_6_0= ruleScriptParentDecl ) )? otherlv_7= '{' ( (lv_version_8_0= ruleVersionStmt ) )? ( (lv_loadProperties_9_0= ruleLoadProperties ) )* ( (lv_contents_10_0= ruleScriptContents ) ) otherlv_11= '}' (otherlv_12= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:235:2: ( (lv_advices_0_0= ruleAdvice ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==39) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:236:1: (lv_advices_0_0= ruleAdvice )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:236:1: (lv_advices_0_0= ruleAdvice )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:237:3: lv_advices_0_0= ruleAdvice
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getAdvicesAdviceParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdvice_in_ruleLanguageUnit424);
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
            	    break loop4;
                }
            } while (true);

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleLanguageUnit437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLanguageUnitAccess().getVilScriptKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:257:1: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:258:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:258:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:259:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleLanguageUnit458);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleLanguageUnit470); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLanguageUnitAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:279:1: ( (lv_param_4_0= ruleParameterList ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_VERSION||(LA5_0>=RULE_ID && LA5_0<=RULE_EXPONENT)||LA5_0==40||(LA5_0>=68 && LA5_0<=71)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:280:1: (lv_param_4_0= ruleParameterList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:280:1: (lv_param_4_0= ruleParameterList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:281:3: lv_param_4_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getParamParameterListParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParameterList_in_ruleLanguageUnit491);
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
                              		"ParameterList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleLanguageUnit504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLanguageUnitAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:301:1: ( (lv_parent_6_0= ruleScriptParentDecl ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:302:1: (lv_parent_6_0= ruleScriptParentDecl )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:302:1: (lv_parent_6_0= ruleScriptParentDecl )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:303:3: lv_parent_6_0= ruleScriptParentDecl
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getParentScriptParentDeclParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleScriptParentDecl_in_ruleLanguageUnit525);
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
                              		"ScriptParentDecl");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleLanguageUnit538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getLanguageUnitAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:323:1: ( (lv_version_8_0= ruleVersionStmt ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==40) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:325:3: lv_version_8_0= ruleVersionStmt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionStmt_in_ruleLanguageUnit559);
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
                              		"VersionStmt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:341:3: ( (lv_loadProperties_9_0= ruleLoadProperties ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:342:1: (lv_loadProperties_9_0= ruleLoadProperties )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:342:1: (lv_loadProperties_9_0= ruleLoadProperties )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:343:3: lv_loadProperties_9_0= ruleLoadProperties
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getLoadPropertiesLoadPropertiesParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLoadProperties_in_ruleLanguageUnit581);
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
            	              		"LoadProperties");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:359:3: ( (lv_contents_10_0= ruleScriptContents ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:360:1: (lv_contents_10_0= ruleScriptContents )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:360:1: (lv_contents_10_0= ruleScriptContents )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:361:3: lv_contents_10_0= ruleScriptContents
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getContentsScriptContentsParserRuleCall_10_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleScriptContents_in_ruleLanguageUnit603);
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
                      		"ScriptContents");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_11=(Token)match(input,19,FOLLOW_19_in_ruleLanguageUnit615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getLanguageUnitAccess().getRightCurlyBracketKeyword_11());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:381:1: (otherlv_12= ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==14) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:381:3: otherlv_12= ';'
                    {
                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleLanguageUnit628); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:393:1: entryRuleScriptParentDecl returns [EObject current=null] : iv_ruleScriptParentDecl= ruleScriptParentDecl EOF ;
    public final EObject entryRuleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptParentDecl = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:394:2: (iv_ruleScriptParentDecl= ruleScriptParentDecl EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:395:2: iv_ruleScriptParentDecl= ruleScriptParentDecl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScriptParentDeclRule()); 
            }
            pushFollow(FOLLOW_ruleScriptParentDecl_in_entryRuleScriptParentDecl666);
            iv_ruleScriptParentDecl=ruleScriptParentDecl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScriptParentDecl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScriptParentDecl676); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:402:1: ruleScriptParentDecl returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleScriptParentDecl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:405:28: ( (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:406:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:406:1: (otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:406:3: otherlv_0= 'extends' ( (lv_name_1_0= ruleIdentifier ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleScriptParentDecl713); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getScriptParentDeclAccess().getExtendsKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:410:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:411:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:411:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:412:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScriptParentDeclAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleScriptParentDecl734);
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
    // $ANTLR end "ruleScriptParentDecl"


    // $ANTLR start "entryRuleLoadProperties"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:436:1: entryRuleLoadProperties returns [EObject current=null] : iv_ruleLoadProperties= ruleLoadProperties EOF ;
    public final EObject entryRuleLoadProperties() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoadProperties = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:437:2: (iv_ruleLoadProperties= ruleLoadProperties EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:438:2: iv_ruleLoadProperties= ruleLoadProperties EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoadPropertiesRule()); 
            }
            pushFollow(FOLLOW_ruleLoadProperties_in_entryRuleLoadProperties770);
            iv_ruleLoadProperties=ruleLoadProperties();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoadProperties; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoadProperties780); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:445:1: ruleLoadProperties returns [EObject current=null] : (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) ;
    public final EObject ruleLoadProperties() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:448:28: ( (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:449:1: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:449:1: (otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:449:3: otherlv_0= 'load' otherlv_1= 'properties' ( (lv_path_2_0= RULE_STRING ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleLoadProperties817); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLoadPropertiesAccess().getLoadKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleLoadProperties829); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLoadPropertiesAccess().getPropertiesKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:457:1: ( (lv_path_2_0= RULE_STRING ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:458:1: (lv_path_2_0= RULE_STRING )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:458:1: (lv_path_2_0= RULE_STRING )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:459:3: lv_path_2_0= RULE_STRING
            {
            lv_path_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLoadProperties846); if (state.failed) return current;
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
                      		"STRING");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleLoadProperties863); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:487:1: entryRuleScriptContents returns [EObject current=null] : iv_ruleScriptContents= ruleScriptContents EOF ;
    public final EObject entryRuleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScriptContents = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:488:2: (iv_ruleScriptContents= ruleScriptContents EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:489:2: iv_ruleScriptContents= ruleScriptContents EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScriptContentsRule()); 
            }
            pushFollow(FOLLOW_ruleScriptContents_in_entryRuleScriptContents899);
            iv_ruleScriptContents=ruleScriptContents();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScriptContents; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScriptContents909); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:496:1: ruleScriptContents returns [EObject current=null] : ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )* ) ;
    public final EObject ruleScriptContents() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_1_0 = null;

        EObject lv_elements_2_0 = null;

        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:499:28: ( ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:1: ( () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:2: () ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:500:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:501:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )*
            loop10:
            do {
                int alt10=4;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:511:3: lv_elements_1_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsVariableDeclarationParserRuleCall_1_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleScriptContents968);
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
            	              		"VariableDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleTypeDef ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:528:6: ( (lv_elements_2_0= ruleTypeDef ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleTypeDef )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:529:1: (lv_elements_2_0= ruleTypeDef )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:530:3: lv_elements_2_0= ruleTypeDef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsTypeDefParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDef_in_ruleScriptContents995);
            	    lv_elements_2_0=ruleTypeDef();

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
            	              		"TypeDef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleRuleDeclaration ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleRuleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleRuleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleRuleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:549:3: lv_elements_3_0= ruleRuleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRuleDeclaration_in_ruleScriptContents1022);
            	    lv_elements_3_0=ruleRuleDeclaration();

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
            	              		"RuleDeclaration");
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:573:1: entryRuleRuleDeclaration returns [EObject current=null] : iv_ruleRuleDeclaration= ruleRuleDeclaration EOF ;
    public final EObject entryRuleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:574:2: (iv_ruleRuleDeclaration= ruleRuleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:575:2: iv_ruleRuleDeclaration= ruleRuleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1060);
            iv_ruleRuleDeclaration=ruleRuleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDeclaration1070); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:582:1: ruleRuleDeclaration returns [EObject current=null] : ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) ;
    public final EObject ruleRuleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_type_1_0 = null;

        EObject lv_modifier_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;

        EObject lv_conditions_8_0 = null;

        EObject lv_block_9_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:585:28: ( ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:586:1: ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:586:1: ( () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:586:2: () ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )? ( (lv_conditions_8_0= ruleRuleConditions ) )? ( (lv_block_9_0= ruleRuleElementBlock ) ) (otherlv_10= ';' )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:586:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:587:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:2: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:3: ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:3: ( (lv_type_1_0= ruleType ) )?
                    int alt11=2;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==RULE_VERSION||(LA11_1>=RULE_ID && LA11_1<=RULE_EXPONENT)||LA11_1==26||LA11_1==40||LA11_1==64) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case RULE_VERSION:
                            {
                            int LA11_2 = input.LA(2);

                            if ( (LA11_2==RULE_VERSION||(LA11_2>=RULE_ID && LA11_2<=RULE_EXPONENT)||LA11_2==26||LA11_2==40||LA11_2==64) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case RULE_EXPONENT:
                            {
                            int LA11_3 = input.LA(2);

                            if ( (LA11_3==RULE_VERSION||(LA11_3>=RULE_ID && LA11_3<=RULE_EXPONENT)||LA11_3==26||LA11_3==40||LA11_3==64) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case 40:
                            {
                            int LA11_4 = input.LA(2);

                            if ( (LA11_4==RULE_VERSION||(LA11_4>=RULE_ID && LA11_4<=RULE_EXPONENT)||LA11_4==26||LA11_4==40||LA11_4==64) ) {
                                alt11=1;
                            }
                            }
                            break;
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                            {
                            alt11=1;
                            }
                            break;
                    }

                    switch (alt11) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:1: (lv_type_1_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:1: (lv_type_1_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:597:3: lv_type_1_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleRuleDeclaration1129);
                            lv_type_1_0=ruleType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRuleDeclarationRule());
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:3: ( (lv_modifier_2_0= ruleRuleModifier ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==26) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:1: (lv_modifier_2_0= ruleRuleModifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:1: (lv_modifier_2_0= ruleRuleModifier )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:615:3: lv_modifier_2_0= ruleRuleModifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1151);
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
                                      		"RuleModifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:631:3: ( (lv_name_3_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:632:1: (lv_name_3_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:632:1: (lv_name_3_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:633:3: lv_name_3_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1173);
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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleRuleDeclaration1185); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRuleDeclarationAccess().getLeftParenthesisKeyword_1_3());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:653:1: ( (lv_paramList_5_0= ruleParameterList ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_VERSION||(LA13_0>=RULE_ID && LA13_0<=RULE_EXPONENT)||LA13_0==40||(LA13_0>=68 && LA13_0<=71)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:654:1: (lv_paramList_5_0= ruleParameterList )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:654:1: (lv_paramList_5_0= ruleParameterList )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:655:3: lv_paramList_5_0= ruleParameterList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleParameterList_in_ruleRuleDeclaration1206);
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
                                      		"ParameterList");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleRuleDeclaration1219); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRuleDeclarationAccess().getRightParenthesisKeyword_1_5());
                          
                    }
                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleRuleDeclaration1231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getRuleDeclarationAccess().getEqualsSignKeyword_1_6());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:679:3: ( (lv_conditions_8_0= ruleRuleConditions ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_EXPONENT)||LA15_0==16||LA15_0==24||LA15_0==28||LA15_0==30||LA15_0==33||LA15_0==36||LA15_0==40||LA15_0==53||(LA15_0>=56 && LA15_0<=59)||(LA15_0>=65 && LA15_0<=67)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:680:1: (lv_conditions_8_0= ruleRuleConditions )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:680:1: (lv_conditions_8_0= ruleRuleConditions )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:681:3: lv_conditions_8_0= ruleRuleConditions
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getConditionsRuleConditionsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRuleConditions_in_ruleRuleDeclaration1254);
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
                              		"RuleConditions");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:697:3: ( (lv_block_9_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:698:1: (lv_block_9_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:698:1: (lv_block_9_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:699:3: lv_block_9_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getBlockRuleElementBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1276);
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
                      		"RuleElementBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:715:2: (otherlv_10= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==14) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:715:4: otherlv_10= ';'
                    {
                    otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleRuleDeclaration1289); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:727:1: entryRuleRuleConditions returns [EObject current=null] : iv_ruleRuleConditions= ruleRuleConditions EOF ;
    public final EObject entryRuleRuleConditions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleConditions = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:728:2: (iv_ruleRuleConditions= ruleRuleConditions EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:729:2: iv_ruleRuleConditions= ruleRuleConditions EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleConditionsRule()); 
            }
            pushFollow(FOLLOW_ruleRuleConditions_in_entryRuleRuleConditions1327);
            iv_ruleRuleConditions=ruleRuleConditions();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleConditions; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleConditions1337); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:736:1: ruleRuleConditions returns [EObject current=null] : ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) ;
    public final EObject ruleRuleConditions() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_postcondition_1_0 = null;

        EObject lv_preconditions_3_0 = null;

        EObject lv_preconditions_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:739:28: ( ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:740:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:740:1: ( () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:740:2: () ( (lv_postcondition_1_0= ruleLogicalExpression ) )? otherlv_2= ':' ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:740:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:741:2: 
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:749:2: ( (lv_postcondition_1_0= ruleLogicalExpression ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_STRING && LA17_0<=RULE_EXPONENT)||LA17_0==16||LA17_0==28||LA17_0==30||LA17_0==33||LA17_0==36||LA17_0==40||LA17_0==53||(LA17_0>=56 && LA17_0<=59)||(LA17_0>=65 && LA17_0<=67)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:750:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:750:1: (lv_postcondition_1_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:751:3: lv_postcondition_1_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPostconditionLogicalExpressionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1395);
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
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleRuleConditions1408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRuleConditionsAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:771:1: ( ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_EXPONENT)||LA19_0==16||LA19_0==28||LA19_0==30||LA19_0==33||LA19_0==36||LA19_0==40||LA19_0==53||(LA19_0>=56 && LA19_0<=59)||(LA19_0>=65 && LA19_0<=67)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:771:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) ) (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:771:2: ( (lv_preconditions_3_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:772:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:772:1: (lv_preconditions_3_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:773:3: lv_preconditions_3_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1430);
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
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:789:2: (otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==25) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:789:4: otherlv_4= ',' ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleRuleConditions1443); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getRuleConditionsAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:793:1: ( (lv_preconditions_5_0= ruleLogicalExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:794:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:794:1: (lv_preconditions_5_0= ruleLogicalExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:795:3: lv_preconditions_5_0= ruleLogicalExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRuleConditionsAccess().getPreconditionsLogicalExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1464);
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
                    	              		"LogicalExpression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:819:1: entryRuleRuleElementBlock returns [EObject current=null] : iv_ruleRuleElementBlock= ruleRuleElementBlock EOF ;
    public final EObject entryRuleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElementBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:820:2: (iv_ruleRuleElementBlock= ruleRuleElementBlock EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:821:2: iv_ruleRuleElementBlock= ruleRuleElementBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementBlockRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1504);
            iv_ruleRuleElementBlock=ruleRuleElementBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElementBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElementBlock1514); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:828:1: ruleRuleElementBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) ;
    public final EObject ruleRuleElementBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:831:28: ( ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:832:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:832:1: ( () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:832:2: () otherlv_1= '{' ( (lv_elements_2_0= ruleRuleElement ) )* otherlv_3= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:832:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:833:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRuleElementBlock1563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRuleElementBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:845:1: ( (lv_elements_2_0= ruleRuleElement ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_EXPONENT)||LA20_0==16||LA20_0==18||LA20_0==28||(LA20_0>=30 && LA20_0<=31)||LA20_0==33||(LA20_0>=36 && LA20_0<=37)||LA20_0==40||LA20_0==53||(LA20_0>=56 && LA20_0<=59)||(LA20_0>=65 && LA20_0<=71)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:846:1: (lv_elements_2_0= ruleRuleElement )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:846:1: (lv_elements_2_0= ruleRuleElement )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:847:3: lv_elements_2_0= ruleRuleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleElementBlockAccess().getElementsRuleElementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1584);
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
            	              		"RuleElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleRuleElementBlock1597); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:875:1: entryRuleRuleElement returns [EObject current=null] : iv_ruleRuleElement= ruleRuleElement EOF ;
    public final EObject entryRuleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleElement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:876:2: (iv_ruleRuleElement= ruleRuleElement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:877:2: iv_ruleRuleElement= ruleRuleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleElementRule()); 
            }
            pushFollow(FOLLOW_ruleRuleElement_in_entryRuleRuleElement1633);
            iv_ruleRuleElement=ruleRuleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleElement1643); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:884:1: ruleRuleElement returns [EObject current=null] : ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) ;
    public final EObject ruleRuleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_varDecl_0_0 = null;

        EObject lv_exprStmt_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:887:28: ( ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:888:2: ( (lv_varDecl_0_0= ruleVariableDeclaration ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:889:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:889:1: (lv_varDecl_0_0= ruleVariableDeclaration )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:890:3: lv_varDecl_0_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getVarDeclVariableDeclarationParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1689);
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
                              		"VariableDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:907:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:907:6: ( (lv_exprStmt_1_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:908:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:908:1: (lv_exprStmt_1_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:909:3: lv_exprStmt_1_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRuleElementAccess().getExprStmtExpressionStatementParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleRuleElement1716);
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
                              		"ExpressionStatement");
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


    // $ANTLR start "entryRuleRuleModifier"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:933:1: entryRuleRuleModifier returns [EObject current=null] : iv_ruleRuleModifier= ruleRuleModifier EOF ;
    public final EObject entryRuleRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleModifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:934:2: (iv_ruleRuleModifier= ruleRuleModifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:935:2: iv_ruleRuleModifier= ruleRuleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleModifierRule()); 
            }
            pushFollow(FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1752);
            iv_ruleRuleModifier=ruleRuleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleModifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleModifier1762); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:942:1: ruleRuleModifier returns [EObject current=null] : ( (lv_protected_0_0= 'protected' ) ) ;
    public final EObject ruleRuleModifier() throws RecognitionException {
        EObject current = null;

        Token lv_protected_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:945:28: ( ( (lv_protected_0_0= 'protected' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:946:1: ( (lv_protected_0_0= 'protected' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:946:1: ( (lv_protected_0_0= 'protected' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:947:1: (lv_protected_0_0= 'protected' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:947:1: (lv_protected_0_0= 'protected' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:948:3: lv_protected_0_0= 'protected'
            {
            lv_protected_0_0=(Token)match(input,26,FOLLOW_26_in_ruleRuleModifier1804); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:969:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:970:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:971:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement1852);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement1862); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:978:1: ruleExpressionStatement returns [EObject current=null] : ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:981:28: ( ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:1: ( ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' ) | ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_EXPONENT)||LA25_0==16||LA25_0==18||LA25_0==28||LA25_0==30||LA25_0==33||LA25_0==36||LA25_0==40||LA25_0==53||(LA25_0>=56 && LA25_0<=59)||(LA25_0>=65 && LA25_0<=67)) ) {
                alt25=1;
            }
            else if ( (LA25_0==31) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:2: ( ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )? ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ';'
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?
                    int alt23=2;
                    alt23 = dfa23.predict(input);
                    switch (alt23) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:4: ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '='
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:982:4: ( (lv_var_0_0= ruleIdentifier ) )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:983:1: (lv_var_0_0= ruleIdentifier )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:983:1: (lv_var_0_0= ruleIdentifier )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:984:3: lv_var_0_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getVarIdentifierParserRuleCall_0_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement1910);
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

                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1000:2: (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==27) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1000:4: otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) )
                                    {
                                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleExpressionStatement1923); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getFullStopKeyword_0_0_1_0());
                                          
                                    }
                                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1004:1: ( (lv_field_2_0= ruleIdentifier ) )
                                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1005:1: (lv_field_2_0= ruleIdentifier )
                                    {
                                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1005:1: (lv_field_2_0= ruleIdentifier )
                                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1006:3: lv_field_2_0= ruleIdentifier
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getFieldIdentifierParserRuleCall_0_0_1_1_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleIdentifier_in_ruleExpressionStatement1944);
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

                            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleExpressionStatement1958); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getExpressionStatementAccess().getEqualsSignKeyword_0_0_2());
                                  
                            }

                            }
                            break;

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1026:3: ( (lv_expr_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1027:1: (lv_expr_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1027:1: (lv_expr_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1028:3: lv_expr_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement1981);
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

                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement1993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1049:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1049:6: ( ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )? )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1049:7: ( (lv_alt_6_0= ruleAlternative ) ) (otherlv_7= ';' )?
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1049:7: ( (lv_alt_6_0= ruleAlternative ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1050:1: (lv_alt_6_0= ruleAlternative )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1050:1: (lv_alt_6_0= ruleAlternative )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1051:3: lv_alt_6_0= ruleAlternative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getAltAlternativeParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAlternative_in_ruleExpressionStatement2022);
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
                              		"Alternative");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1067:2: (otherlv_7= ';' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==14) ) {
                        int LA24_1 = input.LA(2);

                        if ( (synpred27_InternalVilBuildLanguage()) ) {
                            alt24=1;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1067:4: otherlv_7= ';'
                            {
                            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleExpressionStatement2035); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1079:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1080:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1081:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2074);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2084); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1088:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1091:28: ( ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1092:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1092:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )
            int alt26=8;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1092:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1092:2: ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1093:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1093:1: (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1094:3: lv_otherEx_0_0= ruleExpressionOrQualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOtherExExpressionOrQualifiedExecutionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression2130);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1111:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1111:6: ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1112:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1112:1: (lv_unqEx_1_0= ruleUnqualifiedExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1113:3: lv_unqEx_1_0= ruleUnqualifiedExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnqExUnqualifiedExecutionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression2157);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1130:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1130:6: ( (lv_superEx_2_0= ruleSuperExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1131:1: (lv_superEx_2_0= ruleSuperExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1131:1: (lv_superEx_2_0= ruleSuperExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1132:3: lv_superEx_2_0= ruleSuperExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSuperExSuperExecutionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2184);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1149:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1149:6: ( (lv_sysEx_3_0= ruleSystemExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1150:1: (lv_sysEx_3_0= ruleSystemExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1150:1: (lv_sysEx_3_0= ruleSystemExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1151:3: lv_sysEx_3_0= ruleSystemExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getSysExSystemExecutionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2211);
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
                              		"SystemExecution");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1168:6: ( (lv_map_4_0= ruleMap ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1168:6: ( (lv_map_4_0= ruleMap ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1169:1: (lv_map_4_0= ruleMap )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1169:1: (lv_map_4_0= ruleMap )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1170:3: lv_map_4_0= ruleMap
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMapMapParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMap_in_rulePrimaryExpression2238);
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
                              		"Map");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1187:6: ( (lv_join_5_0= ruleJoin ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1187:6: ( (lv_join_5_0= ruleJoin ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1188:1: (lv_join_5_0= ruleJoin )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1188:1: (lv_join_5_0= ruleJoin )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1189:3: lv_join_5_0= ruleJoin
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getJoinJoinParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJoin_in_rulePrimaryExpression2265);
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
                              		"Join");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1206:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1206:6: ( (lv_instantiate_6_0= ruleInstantiate ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1207:1: (lv_instantiate_6_0= ruleInstantiate )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1207:1: (lv_instantiate_6_0= ruleInstantiate )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1208:3: lv_instantiate_6_0= ruleInstantiate
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getInstantiateInstantiateParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInstantiate_in_rulePrimaryExpression2292);
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
                              		"Instantiate");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1225:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1225:6: ( (lv_newEx_7_0= ruleConstructorExecution ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1226:1: (lv_newEx_7_0= ruleConstructorExecution )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1226:1: (lv_newEx_7_0= ruleConstructorExecution )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1227:3: lv_newEx_7_0= ruleConstructorExecution
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNewExConstructorExecutionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2319);
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


    // $ANTLR start "entryRuleInstantiate"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1251:1: entryRuleInstantiate returns [EObject current=null] : iv_ruleInstantiate= ruleInstantiate EOF ;
    public final EObject entryRuleInstantiate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstantiate = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1252:2: (iv_ruleInstantiate= ruleInstantiate EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1253:2: iv_ruleInstantiate= ruleInstantiate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstantiateRule()); 
            }
            pushFollow(FOLLOW_ruleInstantiate_in_entryRuleInstantiate2355);
            iv_ruleInstantiate=ruleInstantiate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstantiate; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstantiate2365); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1260:1: ruleInstantiate returns [EObject current=null] : (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleInstantiate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_rule_3_0=null;
        Token lv_ruleName_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_project_1_0 = null;

        EObject lv_param_6_0 = null;

        EObject lv_versionSpec_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1263:28: ( (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1264:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1264:1: (otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1264:3: otherlv_0= 'instantiate' ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) ) otherlv_5= '(' ( (lv_param_6_0= ruleArgumentList ) )? otherlv_7= ')' ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleInstantiate2402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstantiateAccess().getInstantiateKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:1: ( ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? ) | ( (lv_ruleName_4_0= RULE_STRING ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_VERSION||(LA28_0>=RULE_ID && LA28_0<=RULE_EXPONENT)||LA28_0==40) ) {
                alt28=1;
            }
            else if ( (LA28_0==RULE_STRING) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:2: ( ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )? )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:3: ( (lv_project_1_0= ruleIdentifier ) ) (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1268:3: ( (lv_project_1_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_project_1_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1269:1: (lv_project_1_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1270:3: lv_project_1_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getProjectIdentifierParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleInstantiate2425);
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
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1286:2: (otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==29) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1286:4: otherlv_2= 'rule' ( (lv_rule_3_0= RULE_STRING ) )
                            {
                            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleInstantiate2438); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getInstantiateAccess().getRuleKeyword_1_0_1_0());
                                  
                            }
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1290:1: ( (lv_rule_3_0= RULE_STRING ) )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1291:1: (lv_rule_3_0= RULE_STRING )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1291:1: (lv_rule_3_0= RULE_STRING )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1292:3: lv_rule_3_0= RULE_STRING
                            {
                            lv_rule_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2455); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_rule_3_0, grammarAccess.getInstantiateAccess().getRuleSTRINGTerminalRuleCall_1_0_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getInstantiateRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"rule",
                                      		lv_rule_3_0, 
                                      		"STRING");
                              	    
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1309:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1309:6: ( (lv_ruleName_4_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1310:1: (lv_ruleName_4_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1310:1: (lv_ruleName_4_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1311:3: lv_ruleName_4_0= RULE_STRING
                    {
                    lv_ruleName_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstantiate2486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_ruleName_4_0, grammarAccess.getInstantiateAccess().getRuleNameSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInstantiateRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"ruleName",
                              		lv_ruleName_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleInstantiate2504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInstantiateAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1331:1: ( (lv_param_6_0= ruleArgumentList ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_STRING && LA29_0<=RULE_EXPONENT)||LA29_0==16||LA29_0==18||LA29_0==28||LA29_0==30||LA29_0==33||LA29_0==36||LA29_0==40||LA29_0==53||(LA29_0>=56 && LA29_0<=59)||(LA29_0>=65 && LA29_0<=67)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1332:1: (lv_param_6_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1332:1: (lv_param_6_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1333:3: lv_param_6_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleInstantiate2525);
                    lv_param_6_0=ruleArgumentList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstantiateRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_6_0, 
                              		"ArgumentList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleInstantiate2538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getInstantiateAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1353:1: ( (lv_versionSpec_8_0= ruleVersionSpec ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1354:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1354:1: (lv_versionSpec_8_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1355:3: lv_versionSpec_8_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInstantiateAccess().getVersionSpecVersionSpecParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleInstantiate2559);
                    lv_versionSpec_8_0=ruleVersionSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInstantiateRule());
                      	        }
                             		set(
                             			current, 
                             			"versionSpec",
                              		lv_versionSpec_8_0, 
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
    // $ANTLR end "ruleInstantiate"


    // $ANTLR start "entryRuleMapVariable"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1379:1: entryRuleMapVariable returns [EObject current=null] : iv_ruleMapVariable= ruleMapVariable EOF ;
    public final EObject entryRuleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1380:2: (iv_ruleMapVariable= ruleMapVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1381:2: iv_ruleMapVariable= ruleMapVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapVariableRule()); 
            }
            pushFollow(FOLLOW_ruleMapVariable_in_entryRuleMapVariable2596);
            iv_ruleMapVariable=ruleMapVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMapVariable2606); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapVariable"


    // $ANTLR start "ruleMapVariable"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1388:1: ruleMapVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleMapVariable() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_var_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1391:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1392:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1392:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1392:2: ( (lv_type_0_0= ruleType ) )? ( (lv_var_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1392:2: ( (lv_type_0_0= ruleType ) )?
            int alt31=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==RULE_VERSION||(LA31_1>=RULE_ID && LA31_1<=RULE_EXPONENT)||LA31_1==40||LA31_1==64) ) {
                        alt31=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==RULE_VERSION||(LA31_2>=RULE_ID && LA31_2<=RULE_EXPONENT)||LA31_2==40||LA31_2==64) ) {
                        alt31=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (LA31_3==RULE_VERSION||(LA31_3>=RULE_ID && LA31_3<=RULE_EXPONENT)||LA31_3==40||LA31_3==64) ) {
                        alt31=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA31_4 = input.LA(2);

                    if ( (LA31_4==RULE_VERSION||(LA31_4>=RULE_ID && LA31_4<=RULE_EXPONENT)||LA31_4==40||LA31_4==64) ) {
                        alt31=1;
                    }
                    }
                    break;
                case 68:
                case 69:
                case 70:
                case 71:
                    {
                    alt31=1;
                    }
                    break;
            }

            switch (alt31) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1393:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1393:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1394:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapVariableAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleMapVariable2652);
                    lv_type_0_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapVariableRule());
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1410:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1411:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1411:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1412:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleMapVariable2674);
            lv_var_1_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapVariableRule());
              	        }
                     		set(
                     			current, 
                     			"var",
                      		lv_var_1_0, 
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
    // $ANTLR end "ruleMapVariable"


    // $ANTLR start "entryRuleMap"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1436:1: entryRuleMap returns [EObject current=null] : iv_ruleMap= ruleMap EOF ;
    public final EObject entryRuleMap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMap = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1437:2: (iv_ruleMap= ruleMap EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1438:2: iv_ruleMap= ruleMap EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapRule()); 
            }
            pushFollow(FOLLOW_ruleMap_in_entryRuleMap2710);
            iv_ruleMap=ruleMap();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMap; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMap2720); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1445:1: ruleMap returns [EObject current=null] : (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1448:28: ( (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1449:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1449:1: (otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1449:3: otherlv_0= 'map' otherlv_1= '(' ( (lv_var_2_0= ruleMapVariable ) ) (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )* ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) ) ( (lv_expr_6_0= ruleExpression ) ) otherlv_7= ')' ( (lv_block_8_0= ruleRuleElementBlock ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleMap2757); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMapAccess().getMapKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleMap2769); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1457:1: ( (lv_var_2_0= ruleMapVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1458:1: (lv_var_2_0= ruleMapVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1458:1: (lv_var_2_0= ruleMapVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1459:3: lv_var_2_0= ruleMapVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2790);
            lv_var_2_0=ruleMapVariable();

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
                      		"MapVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1475:2: (otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==25) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1475:4: otherlv_3= ',' ( (lv_var_4_0= ruleMapVariable ) )
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleMap2803); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMapAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1479:1: ( (lv_var_4_0= ruleMapVariable ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1480:1: (lv_var_4_0= ruleMapVariable )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1480:1: (lv_var_4_0= ruleMapVariable )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1481:3: lv_var_4_0= ruleMapVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMapAccess().getVarMapVariableParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMapVariable_in_ruleMap2824);
            	    lv_var_4_0=ruleMapVariable();

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
            	              		"MapVariable");
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1497:4: ( ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1498:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1498:1: ( (lv_separator_5_1= '=' | lv_separator_5_2= ':' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1499:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1499:1: (lv_separator_5_1= '=' | lv_separator_5_2= ':' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==23) ) {
                alt33=1;
            }
            else if ( (LA33_0==24) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1500:3: lv_separator_5_1= '='
                    {
                    lv_separator_5_1=(Token)match(input,23,FOLLOW_23_in_ruleMap2846); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1512:8: lv_separator_5_2= ':'
                    {
                    lv_separator_5_2=(Token)match(input,24,FOLLOW_24_in_ruleMap2875); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1527:2: ( (lv_expr_6_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1528:1: (lv_expr_6_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1528:1: (lv_expr_6_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1529:3: lv_expr_6_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getExprExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMap2912);
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
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleMap2924); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMapAccess().getRightParenthesisKeyword_6());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1549:1: ( (lv_block_8_0= ruleRuleElementBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1550:1: (lv_block_8_0= ruleRuleElementBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1550:1: (lv_block_8_0= ruleRuleElementBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1551:3: lv_block_8_0= ruleRuleElementBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapAccess().getBlockRuleElementBlockParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleMap2945);
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
                      		"RuleElementBlock");
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


    // $ANTLR start "entryRuleAlternative"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1575:1: entryRuleAlternative returns [EObject current=null] : iv_ruleAlternative= ruleAlternative EOF ;
    public final EObject entryRuleAlternative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternative = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1576:2: (iv_ruleAlternative= ruleAlternative EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1577:2: iv_ruleAlternative= ruleAlternative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAlternativeRule()); 
            }
            pushFollow(FOLLOW_ruleAlternative_in_entryRuleAlternative2981);
            iv_ruleAlternative=ruleAlternative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlternative; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternative2991); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1584:1: ruleAlternative returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1587:28: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1588:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1588:1: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1588:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_if_4_0= ruleStatementOrBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleAlternative3028); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAlternativeAccess().getIfKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAlternative3040); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAlternativeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1596:1: ( (lv_expr_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1597:1: (lv_expr_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1597:1: (lv_expr_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1598:3: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getExprExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlternative3061);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAlternative3073); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAlternativeAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1618:1: ( (lv_if_4_0= ruleStatementOrBlock ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1619:1: (lv_if_4_0= ruleStatementOrBlock )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1619:1: (lv_if_4_0= ruleStatementOrBlock )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1620:3: lv_if_4_0= ruleStatementOrBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAlternativeAccess().getIfStatementOrBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStatementOrBlock_in_ruleAlternative3094);
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
                      		"StatementOrBlock");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:2: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred43_InternalVilBuildLanguage()) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:3: ( ( 'else' )=>otherlv_5= 'else' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:4: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleAlternative3115); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAlternativeAccess().getElseKeyword_5_0());
                          
                    }

                    }

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1641:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1642:1: (lv_else_6_0= ruleStatementOrBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1642:1: (lv_else_6_0= ruleStatementOrBlock )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1643:3: lv_else_6_0= ruleStatementOrBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleStatementOrBlock_in_ruleAlternative3137);
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
                              		"StatementOrBlock");
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1667:1: entryRuleStatementOrBlock returns [EObject current=null] : iv_ruleStatementOrBlock= ruleStatementOrBlock EOF ;
    public final EObject entryRuleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementOrBlock = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1668:2: (iv_ruleStatementOrBlock= ruleStatementOrBlock EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1669:2: iv_ruleStatementOrBlock= ruleStatementOrBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementOrBlockRule()); 
            }
            pushFollow(FOLLOW_ruleStatementOrBlock_in_entryRuleStatementOrBlock3175);
            iv_ruleStatementOrBlock=ruleStatementOrBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementOrBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatementOrBlock3185); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1676:1: ruleStatementOrBlock returns [EObject current=null] : ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) ;
    public final EObject ruleStatementOrBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_exStmt_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1679:28: ( ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1681:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1681:1: (lv_exStmt_0_0= ruleExpressionStatement )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1682:3: lv_exStmt_0_0= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleStatementOrBlock3231);
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
                              		"ExpressionStatement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1699:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1699:6: ( (lv_block_1_0= ruleRuleElementBlock ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1700:1: (lv_block_1_0= ruleRuleElementBlock )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1700:1: (lv_block_1_0= ruleRuleElementBlock )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1701:3: lv_block_1_0= ruleRuleElementBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getBlockRuleElementBlockParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRuleElementBlock_in_ruleStatementOrBlock3258);
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
                              		"RuleElementBlock");
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1725:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1726:2: (iv_ruleJoin= ruleJoin EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1727:2: iv_ruleJoin= ruleJoin EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinRule()); 
            }
            pushFollow(FOLLOW_ruleJoin_in_entryRuleJoin3294);
            iv_ruleJoin=ruleJoin();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoin; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoin3304); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1734:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1737:28: ( (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1738:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1738:1: (otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1738:3: otherlv_0= 'join' otherlv_1= '(' ( (lv_var1_2_0= ruleJoinVariable ) ) otherlv_3= ',' ( (lv_var2_4_0= ruleJoinVariable ) ) otherlv_5= ')' (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleJoin3341); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJoin3353); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1746:1: ( (lv_var1_2_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1747:1: (lv_var1_2_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1747:1: (lv_var1_2_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1748:3: lv_var1_2_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar1JoinVariableParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin3374);
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
                      		"JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleJoin3386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getCommaKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1768:1: ( (lv_var2_4_0= ruleJoinVariable ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1769:1: (lv_var2_4_0= ruleJoinVariable )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1769:1: (lv_var2_4_0= ruleJoinVariable )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1770:3: lv_var2_4_0= ruleJoinVariable
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinAccess().getVar2JoinVariableParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_ruleJoin3407);
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
                      		"JoinVariable");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJoin3419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getRightParenthesisKeyword_5());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1790:1: (otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==34) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1790:3: otherlv_6= 'with' otherlv_7= '(' ( (lv_condition_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleJoin3432); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getWithKeyword_6_0());
                          
                    }
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleJoin3444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_6_1());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1798:1: ( (lv_condition_8_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1799:1: (lv_condition_8_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1799:1: (lv_condition_8_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1800:3: lv_condition_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJoinAccess().getConditionExpressionParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleJoin3465);
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
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleJoin3477); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1828:1: entryRuleJoinVariable returns [EObject current=null] : iv_ruleJoinVariable= ruleJoinVariable EOF ;
    public final EObject entryRuleJoinVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinVariable = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1829:2: (iv_ruleJoinVariable= ruleJoinVariable EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1830:2: iv_ruleJoinVariable= ruleJoinVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJoinVariableRule()); 
            }
            pushFollow(FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3515);
            iv_ruleJoinVariable=ruleJoinVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJoinVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJoinVariable3525); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1837:1: ruleJoinVariable returns [EObject current=null] : ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) ;
    public final EObject ruleJoinVariable() throws RecognitionException {
        EObject current = null;

        Token lv_excl_0_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_var_1_0 = null;

        EObject lv_expr_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1840:28: ( ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:1: ( ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:2: ( (lv_excl_0_0= 'exclude' ) )? ( (lv_var_1_0= ruleIdentifier ) ) otherlv_2= ':' ( (lv_expr_3_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1841:2: ( (lv_excl_0_0= 'exclude' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==35) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1842:1: (lv_excl_0_0= 'exclude' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1842:1: (lv_excl_0_0= 'exclude' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1843:3: lv_excl_0_0= 'exclude'
                    {
                    lv_excl_0_0=(Token)match(input,35,FOLLOW_35_in_ruleJoinVariable3568); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1856:3: ( (lv_var_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1857:1: (lv_var_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1857:1: (lv_var_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1858:3: lv_var_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getVarIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleJoinVariable3603);
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
                      		"Identifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleJoinVariable3615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getJoinVariableAccess().getColonKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1878:1: ( (lv_expr_3_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1879:1: (lv_expr_3_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1879:1: (lv_expr_3_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1880:3: lv_expr_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJoinVariableAccess().getExprExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleJoinVariable3636);
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
    // $ANTLR end "ruleJoinVariable"


    // $ANTLR start "entryRuleSystemExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1904:1: entryRuleSystemExecution returns [EObject current=null] : iv_ruleSystemExecution= ruleSystemExecution EOF ;
    public final EObject entryRuleSystemExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1905:2: (iv_ruleSystemExecution= ruleSystemExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1906:2: iv_ruleSystemExecution= ruleSystemExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3672);
            iv_ruleSystemExecution=ruleSystemExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemExecution3682); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1913:1: ruleSystemExecution returns [EObject current=null] : (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) ;
    public final EObject ruleSystemExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_call_1_0 = null;

        EObject lv_calls_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1916:28: ( (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1917:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1917:1: (otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1917:3: otherlv_0= 'execute' ( (lv_call_1_0= ruleCall ) ) ( (lv_calls_2_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleSystemExecution3719); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemExecutionAccess().getExecuteKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1921:1: ( (lv_call_1_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1922:1: (lv_call_1_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1922:1: (lv_call_1_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1923:3: lv_call_1_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallCallParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSystemExecution3740);
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
                      		"Call");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1939:2: ( (lv_calls_2_0= ruleSubCall ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==27||(LA38_0>=60 && LA38_0<=61)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1940:1: (lv_calls_2_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1940:1: (lv_calls_2_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1941:3: lv_calls_2_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemExecutionAccess().getCallsSubCallParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSystemExecution3761);
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
            	              		"SubCall");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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
    // $ANTLR end "ruleSystemExecution"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1965:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1966:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1967:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3798);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration3808); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1974:1: ruleVariableDeclaration returns [EObject current=null] : ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1977:28: ( ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1978:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1978:1: ( ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1978:2: ( (lv_const_0_0= 'const' ) )? ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleIdentifier ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? otherlv_5= ';'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1978:2: ( (lv_const_0_0= 'const' ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==37) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1979:1: (lv_const_0_0= 'const' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1979:1: (lv_const_0_0= 'const' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1980:3: lv_const_0_0= 'const'
                    {
                    lv_const_0_0=(Token)match(input,37,FOLLOW_37_in_ruleVariableDeclaration3851); if (state.failed) return current;
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1993:3: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1994:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1994:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1995:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleVariableDeclaration3886);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2011:2: ( (lv_name_2_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2012:1: (lv_name_2_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2012:1: (lv_name_2_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2013:3: lv_name_2_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameIdentifierParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3907);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2029:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==23) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2029:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleVariableDeclaration3920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2033:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2034:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2034:1: (lv_expression_4_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2035:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableDeclaration3941);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVariableDeclaration3955); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2063:1: entryRuleTypeDef returns [EObject current=null] : iv_ruleTypeDef= ruleTypeDef EOF ;
    public final EObject entryRuleTypeDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDef = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2064:2: (iv_ruleTypeDef= ruleTypeDef EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2065:2: iv_ruleTypeDef= ruleTypeDef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDef_in_entryRuleTypeDef3991);
            iv_ruleTypeDef=ruleTypeDef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDef4001); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2072:1: ruleTypeDef returns [EObject current=null] : (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) ;
    public final EObject ruleTypeDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2075:28: ( (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2076:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2076:1: (otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2076:3: otherlv_0= 'typedef' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleTypeDef4038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeDefAccess().getTypedefKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2080:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2081:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2081:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2082:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleTypeDef4059);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2098:2: ( (lv_type_2_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:1: (lv_type_2_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2099:1: (lv_type_2_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2100:3: lv_type_2_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefAccess().getTypeTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeDef4080);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleTypeDef4092); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2128:1: entryRuleAdvice returns [EObject current=null] : iv_ruleAdvice= ruleAdvice EOF ;
    public final EObject entryRuleAdvice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdvice = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2129:2: (iv_ruleAdvice= ruleAdvice EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2130:2: iv_ruleAdvice= ruleAdvice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdviceRule()); 
            }
            pushFollow(FOLLOW_ruleAdvice_in_entryRuleAdvice4128);
            iv_ruleAdvice=ruleAdvice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdvice; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdvice4138); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2137:1: ruleAdvice returns [EObject current=null] : (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) ;
    public final EObject ruleAdvice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_2_0 = null;

        EObject lv_versionSpec_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2140:28: ( (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2141:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2141:1: (otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2141:3: otherlv_0= '@advice' otherlv_1= '(' ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= ')' ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleAdvice4175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdviceAccess().getAdviceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleAdvice4187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdviceAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2149:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2150:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2150:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2151:3: lv_name_2_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdviceAccess().getNameQualifiedNameParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleAdvice4208);
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

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleAdvice4220); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdviceAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2171:1: ( (lv_versionSpec_4_0= ruleVersionSpec ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==34) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2172:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2172:1: (lv_versionSpec_4_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2173:3: lv_versionSpec_4_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAdviceAccess().getVersionSpecVersionSpecParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleAdvice4241);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2197:1: entryRuleVersionSpec returns [EObject current=null] : iv_ruleVersionSpec= ruleVersionSpec EOF ;
    public final EObject entryRuleVersionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionSpec = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2198:2: (iv_ruleVersionSpec= ruleVersionSpec EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2199:2: iv_ruleVersionSpec= ruleVersionSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionSpecRule()); 
            }
            pushFollow(FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec4278);
            iv_ruleVersionSpec=ruleVersionSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionSpec4288); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2206:1: ruleVersionSpec returns [EObject current=null] : (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) ;
    public final EObject ruleVersionSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_restriction_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2209:28: ( (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2210:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2210:1: (otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2210:3: otherlv_0= 'with' ( (lv_restriction_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleVersionSpec4325); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionSpecAccess().getWithKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2214:1: ( (lv_restriction_1_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2215:1: (lv_restriction_1_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2215:1: (lv_restriction_1_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2216:3: lv_restriction_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionSpecAccess().getRestrictionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVersionSpec4346);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2240:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2241:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2242:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList4382);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList4392); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2249:1: ruleParameterList returns [EObject current=null] : ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2252:28: ( ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:1: ( ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:2: ( (lv_param_0_0= ruleParameter ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2253:2: ( (lv_param_0_0= ruleParameter ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2254:1: (lv_param_0_0= ruleParameter )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2254:1: (lv_param_0_0= ruleParameter )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2255:3: lv_param_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4438);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2271:2: (otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==25) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2271:4: otherlv_1= ',' ( (lv_param_2_0= ruleParameter ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleParameterList4451); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2275:1: ( (lv_param_2_0= ruleParameter ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2276:1: (lv_param_2_0= ruleParameter )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2276:1: (lv_param_2_0= ruleParameter )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2277:3: lv_param_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameterListAccess().getParamParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleParameter_in_ruleParameterList4472);
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
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameter"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2301:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2302:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2303:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4510);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4520); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2310:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2313:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2314:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2314:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2314:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= ruleIdentifier ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2314:2: ( (lv_type_0_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2315:1: (lv_type_0_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2315:1: (lv_type_0_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2316:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleParameter4566);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2332:2: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2333:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2333:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2334:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleParameter4587);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2358:1: entryRuleVersionStmt returns [EObject current=null] : iv_ruleVersionStmt= ruleVersionStmt EOF ;
    public final EObject entryRuleVersionStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionStmt = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2359:2: (iv_ruleVersionStmt= ruleVersionStmt EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2360:2: iv_ruleVersionStmt= ruleVersionStmt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionStmtRule()); 
            }
            pushFollow(FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4623);
            iv_ruleVersionStmt=ruleVersionStmt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionStmt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVersionStmt4633); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2367:1: ruleVersionStmt returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) ;
    public final EObject ruleVersionStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_version_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2370:28: ( (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2371:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2371:1: (otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2371:3: otherlv_0= 'version' ( (lv_version_1_0= RULE_VERSION ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleVersionStmt4670); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionStmtAccess().getVersionKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2375:1: ( (lv_version_1_0= RULE_VERSION ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2376:1: (lv_version_1_0= RULE_VERSION )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2376:1: (lv_version_1_0= RULE_VERSION )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2377:3: lv_version_1_0= RULE_VERSION
            {
            lv_version_1_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleVersionStmt4687); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleVersionStmt4704); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2405:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2406:2: (iv_ruleImport= ruleImport EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2407:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport4740);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport4750); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2414:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_versionSpec_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2417:28: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2418:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2418:1: (otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2418:3: otherlv_0= 'import' ( (lv_name_1_0= ruleIdentifier ) ) ( (lv_versionSpec_2_0= ruleVersionSpec ) )? otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleImport4787); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2422:1: ( (lv_name_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2423:1: (lv_name_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2423:1: (lv_name_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2424:3: lv_name_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getNameIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleImport4808);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2440:2: ( (lv_versionSpec_2_0= ruleVersionSpec ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==34) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2441:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2441:1: (lv_versionSpec_2_0= ruleVersionSpec )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2442:3: lv_versionSpec_2_0= ruleVersionSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImportAccess().getVersionSpecVersionSpecParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleVersionSpec_in_ruleImport4829);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleImport4842); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2470:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2471:2: (iv_ruleExpression= ruleExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2472:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4878);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4888); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2479:1: ruleExpression returns [EObject current=null] : ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expr_0_0 = null;

        EObject lv_init_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2482:28: ( ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:1: ( ( (lv_expr_0_0= ruleLogicalExpression ) ) | ( (lv_init_1_0= ruleContainerInitializer ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_EXPONENT)||LA44_0==16||LA44_0==28||LA44_0==30||LA44_0==33||LA44_0==36||LA44_0==40||LA44_0==53||(LA44_0>=56 && LA44_0<=59)||(LA44_0>=65 && LA44_0<=67)) ) {
                alt44=1;
            }
            else if ( (LA44_0==18) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2483:2: ( (lv_expr_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2484:1: (lv_expr_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2484:1: (lv_expr_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2485:3: lv_expr_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getExprLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleExpression4934);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2502:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2502:6: ( (lv_init_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2503:1: (lv_init_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2503:1: (lv_init_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2504:3: lv_init_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getInitContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleExpression4961);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2528:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2529:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2530:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4997);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression5007); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2537:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2540:28: ( ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2541:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2541:1: ( ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2541:2: ( (lv_left_0_0= ruleEqualityExpression ) ) ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2541:2: ( (lv_left_0_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2542:1: (lv_left_0_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2542:1: (lv_left_0_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2543:3: lv_left_0_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getLeftEqualityExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression5053);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2559:2: ( (lv_right_1_0= ruleLogicalExpressionPart ) )*
            loop45:
            do {
                int alt45=2;
                switch ( input.LA(1) ) {
                case 42:
                    {
                    int LA45_2 = input.LA(2);

                    if ( (synpred54_InternalVilBuildLanguage()) ) {
                        alt45=1;
                    }


                    }
                    break;
                case 43:
                    {
                    int LA45_3 = input.LA(2);

                    if ( (synpred54_InternalVilBuildLanguage()) ) {
                        alt45=1;
                    }


                    }
                    break;
                case 44:
                    {
                    int LA45_4 = input.LA(2);

                    if ( (synpred54_InternalVilBuildLanguage()) ) {
                        alt45=1;
                    }


                    }
                    break;

                }

                switch (alt45) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2560:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2560:1: (lv_right_1_0= ruleLogicalExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2561:3: lv_right_1_0= ruleLogicalExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression5074);
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
            	    break loop45;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2585:1: entryRuleLogicalExpressionPart returns [EObject current=null] : iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF ;
    public final EObject entryRuleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2586:2: (iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2587:2: iv_ruleLogicalExpressionPart= ruleLogicalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart5111);
            iv_ruleLogicalExpressionPart=ruleLogicalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpressionPart5121); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2594:1: ruleLogicalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) ;
    public final EObject ruleLogicalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2597:28: ( ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2598:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2598:1: ( ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2598:2: ( (lv_op_0_0= ruleLogicalOperator ) ) ( (lv_ex_1_0= ruleEqualityExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2598:2: ( (lv_op_0_0= ruleLogicalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2599:1: (lv_op_0_0= ruleLogicalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2599:1: (lv_op_0_0= ruleLogicalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2600:3: lv_op_0_0= ruleLogicalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getOpLogicalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart5167);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2616:2: ( (lv_ex_1_0= ruleEqualityExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2617:1: (lv_ex_1_0= ruleEqualityExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2617:1: (lv_ex_1_0= ruleEqualityExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2618:3: lv_ex_1_0= ruleEqualityExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionPartAccess().getExEqualityExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart5188);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2642:1: entryRuleLogicalOperator returns [String current=null] : iv_ruleLogicalOperator= ruleLogicalOperator EOF ;
    public final String entryRuleLogicalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2643:2: (iv_ruleLogicalOperator= ruleLogicalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2644:2: iv_ruleLogicalOperator= ruleLogicalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5225);
            iv_ruleLogicalOperator=ruleLogicalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOperator5236); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2651:1: ruleLogicalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2654:28: ( (kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2655:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2655:1: (kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt46=1;
                }
                break;
            case 43:
                {
                alt46=2;
                }
                break;
            case 44:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2656:2: kw= 'and'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleLogicalOperator5274); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2663:2: kw= 'or'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleLogicalOperator5293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getLogicalOperatorAccess().getOrKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2670:2: kw= 'xor'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleLogicalOperator5312); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2683:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2684:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2685:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5352);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression5362); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2692:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2695:28: ( ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2696:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2696:1: ( ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2696:2: ( (lv_left_0_0= ruleRelationalExpression ) ) ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2696:2: ( (lv_left_0_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2697:1: (lv_left_0_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2697:1: (lv_left_0_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2698:3: lv_left_0_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getLeftRelationalExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5408);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2714:2: ( (lv_right_1_0= ruleEqualityExpressionPart ) )?
            int alt47=2;
            switch ( input.LA(1) ) {
                case 45:
                    {
                    int LA47_1 = input.LA(2);

                    if ( (synpred57_InternalVilBuildLanguage()) ) {
                        alt47=1;
                    }
                    }
                    break;
                case 46:
                    {
                    int LA47_2 = input.LA(2);

                    if ( (synpred57_InternalVilBuildLanguage()) ) {
                        alt47=1;
                    }
                    }
                    break;
                case 47:
                    {
                    int LA47_3 = input.LA(2);

                    if ( (synpred57_InternalVilBuildLanguage()) ) {
                        alt47=1;
                    }
                    }
                    break;
            }

            switch (alt47) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2715:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2715:1: (lv_right_1_0= ruleEqualityExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2716:3: lv_right_1_0= ruleEqualityExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5429);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2740:1: entryRuleEqualityExpressionPart returns [EObject current=null] : iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF ;
    public final EObject entryRuleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2741:2: (iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2742:2: iv_ruleEqualityExpressionPart= ruleEqualityExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5466);
            iv_ruleEqualityExpressionPart=ruleEqualityExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpressionPart5476); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2749:1: ruleEqualityExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) ;
    public final EObject ruleEqualityExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2752:28: ( ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2753:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2753:1: ( ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2753:2: ( (lv_op_0_0= ruleEqualityOperator ) ) ( (lv_ex_1_0= ruleRelationalExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2753:2: ( (lv_op_0_0= ruleEqualityOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2754:1: (lv_op_0_0= ruleEqualityOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2754:1: (lv_op_0_0= ruleEqualityOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2755:3: lv_op_0_0= ruleEqualityOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getOpEqualityOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5522);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2771:2: ( (lv_ex_1_0= ruleRelationalExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2772:1: (lv_ex_1_0= ruleRelationalExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2772:1: (lv_ex_1_0= ruleRelationalExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2773:3: lv_ex_1_0= ruleRelationalExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEqualityExpressionPartAccess().getExRelationalExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5543);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2797:1: entryRuleEqualityOperator returns [String current=null] : iv_ruleEqualityOperator= ruleEqualityOperator EOF ;
    public final String entryRuleEqualityOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEqualityOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2798:2: (iv_ruleEqualityOperator= ruleEqualityOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2799:2: iv_ruleEqualityOperator= ruleEqualityOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5580);
            iv_ruleEqualityOperator=ruleEqualityOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityOperator5591); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2806:1: ruleEqualityOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '<>' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleEqualityOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2809:28: ( (kw= '==' | kw= '<>' | kw= '!=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2810:1: (kw= '==' | kw= '<>' | kw= '!=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2810:1: (kw= '==' | kw= '<>' | kw= '!=' )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt48=1;
                }
                break;
            case 46:
                {
                alt48=2;
                }
                break;
            case 47:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2811:2: kw= '=='
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleEqualityOperator5629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2818:2: kw= '<>'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleEqualityOperator5648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEqualityOperatorAccess().getLessThanSignGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2825:2: kw= '!='
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleEqualityOperator5667); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2838:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2839:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2840:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5707);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression5717); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2847:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2850:28: ( ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2851:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2851:1: ( ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2851:2: ( (lv_left_0_0= ruleAdditiveExpression ) ) ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2851:2: ( (lv_left_0_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2852:1: (lv_left_0_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2852:1: (lv_left_0_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2853:3: lv_left_0_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftAdditiveExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5763);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2869:2: ( (lv_right_1_0= ruleRelationalExpressionPart ) )?
            int alt49=2;
            switch ( input.LA(1) ) {
                case 48:
                    {
                    int LA49_1 = input.LA(2);

                    if ( (synpred60_InternalVilBuildLanguage()) ) {
                        alt49=1;
                    }
                    }
                    break;
                case 49:
                    {
                    int LA49_2 = input.LA(2);

                    if ( (synpred60_InternalVilBuildLanguage()) ) {
                        alt49=1;
                    }
                    }
                    break;
                case 50:
                    {
                    int LA49_3 = input.LA(2);

                    if ( (synpred60_InternalVilBuildLanguage()) ) {
                        alt49=1;
                    }
                    }
                    break;
                case 51:
                    {
                    int LA49_4 = input.LA(2);

                    if ( (synpred60_InternalVilBuildLanguage()) ) {
                        alt49=1;
                    }
                    }
                    break;
            }

            switch (alt49) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2870:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2870:1: (lv_right_1_0= ruleRelationalExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2871:3: lv_right_1_0= ruleRelationalExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5784);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2895:1: entryRuleRelationalExpressionPart returns [EObject current=null] : iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF ;
    public final EObject entryRuleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2896:2: (iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2897:2: iv_ruleRelationalExpressionPart= ruleRelationalExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5821);
            iv_ruleRelationalExpressionPart=ruleRelationalExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpressionPart5831); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2904:1: ruleRelationalExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) ;
    public final EObject ruleRelationalExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2907:28: ( ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:1: ( ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:2: ( (lv_op_0_0= ruleRelationalOperator ) ) ( (lv_ex_1_0= ruleAdditiveExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2908:2: ( (lv_op_0_0= ruleRelationalOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2909:1: (lv_op_0_0= ruleRelationalOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2909:1: (lv_op_0_0= ruleRelationalOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2910:3: lv_op_0_0= ruleRelationalOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getOpRelationalOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5877);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2926:2: ( (lv_ex_1_0= ruleAdditiveExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2927:1: (lv_ex_1_0= ruleAdditiveExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2927:1: (lv_ex_1_0= ruleAdditiveExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2928:3: lv_ex_1_0= ruleAdditiveExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionPartAccess().getExAdditiveExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5898);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2952:1: entryRuleRelationalOperator returns [String current=null] : iv_ruleRelationalOperator= ruleRelationalOperator EOF ;
    public final String entryRuleRelationalOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2953:2: (iv_ruleRelationalOperator= ruleRelationalOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2954:2: iv_ruleRelationalOperator= ruleRelationalOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5935);
            iv_ruleRelationalOperator=ruleRelationalOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOperator5946); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2961:1: ruleRelationalOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2964:28: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2965:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2965:1: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' )
            int alt50=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt50=1;
                }
                break;
            case 49:
                {
                alt50=2;
                }
                break;
            case 50:
                {
                alt50=3;
                }
                break;
            case 51:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2966:2: kw= '>'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleRelationalOperator5984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2973:2: kw= '<'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleRelationalOperator6003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2980:2: kw= '>='
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleRelationalOperator6022); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationalOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2987:2: kw= '<='
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleRelationalOperator6041); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3000:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3001:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3002:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6081);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression6091); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3009:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3012:28: ( ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3013:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3013:1: ( ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3013:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) ) ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3013:2: ( (lv_left_0_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3014:1: (lv_left_0_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3014:1: (lv_left_0_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3015:3: lv_left_0_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getLeftMultiplicativeExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6137);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3031:2: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==52) ) {
                    int LA51_2 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt51=1;
                    }


                }
                else if ( (LA51_0==53) ) {
                    int LA51_3 = input.LA(2);

                    if ( (synpred64_InternalVilBuildLanguage()) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3032:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3032:1: (lv_right_1_0= ruleAdditiveExpressionPart )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3033:3: lv_right_1_0= ruleAdditiveExpressionPart
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6158);
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3057:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3058:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3059:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6195);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6205); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3066:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ex_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3069:28: ( ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3070:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3070:1: ( ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3070:2: ( (lv_op_0_0= ruleAdditiveOperator ) ) ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3070:2: ( (lv_op_0_0= ruleAdditiveOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3071:1: (lv_op_0_0= ruleAdditiveOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3071:1: (lv_op_0_0= ruleAdditiveOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3072:3: lv_op_0_0= ruleAdditiveOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOpAdditiveOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6251);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3088:2: ( (lv_ex_1_0= ruleMultiplicativeExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3089:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3089:1: (lv_ex_1_0= ruleMultiplicativeExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3090:3: lv_ex_1_0= ruleMultiplicativeExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getExMultiplicativeExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6272);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3114:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3115:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3116:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6309);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6320); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3123:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3126:28: ( (kw= '+' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3127:1: (kw= '+' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3127:1: (kw= '+' | kw= '-' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==52) ) {
                alt52=1;
            }
            else if ( (LA52_0==53) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3128:2: kw= '+'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleAdditiveOperator6358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3135:2: kw= '-'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleAdditiveOperator6377); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3148:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3149:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3150:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6417);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6427); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3157:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3160:28: ( ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3161:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3161:1: ( ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )? )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3161:2: ( (lv_left_0_0= ruleUnaryExpression ) ) ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3161:2: ( (lv_left_0_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3162:1: (lv_left_0_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3162:1: (lv_left_0_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3163:3: lv_left_0_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getLeftUnaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6473);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3179:2: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==54) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred66_InternalVilBuildLanguage()) ) {
                    alt53=1;
                }
            }
            else if ( (LA53_0==55) ) {
                int LA53_2 = input.LA(2);

                if ( (synpred66_InternalVilBuildLanguage()) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3180:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3180:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3181:3: lv_right_1_0= ruleMultiplicativeExpressionPart
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6494);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3205:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3206:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3207:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6531);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpressionPart; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6541); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3214:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3217:28: ( ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3218:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3218:1: ( ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3218:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) ) ( (lv_expr_1_0= ruleUnaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3218:2: ( (lv_op_0_0= ruleMultiplicativeOperator ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3219:1: (lv_op_0_0= ruleMultiplicativeOperator )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3219:1: (lv_op_0_0= ruleMultiplicativeOperator )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3220:3: lv_op_0_0= ruleMultiplicativeOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOpMultiplicativeOperatorParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6587);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3236:2: ( (lv_expr_1_0= ruleUnaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3237:1: (lv_expr_1_0= ruleUnaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3237:1: (lv_expr_1_0= ruleUnaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3238:3: lv_expr_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getExprUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6608);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3262:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3263:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3264:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6645);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator6656); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3271:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3274:28: ( (kw= '*' | kw= '/' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3275:1: (kw= '*' | kw= '/' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3275:1: (kw= '*' | kw= '/' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==54) ) {
                alt54=1;
            }
            else if ( (LA54_0==55) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3276:2: kw= '*'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleMultiplicativeOperator6694); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3283:2: kw= '/'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleMultiplicativeOperator6713); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3296:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3297:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3298:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6753);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression6763); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3305:1: ruleUnaryExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3308:28: ( ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3309:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3309:1: ( ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3309:2: ( (lv_op_0_0= ruleUnaryOperator ) )? ( (lv_expr_1_0= rulePostfixExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3309:2: ( (lv_op_0_0= ruleUnaryOperator ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==53||(LA55_0>=56 && LA55_0<=57)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3310:1: (lv_op_0_0= ruleUnaryOperator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3310:1: (lv_op_0_0= ruleUnaryOperator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3311:3: lv_op_0_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOpUnaryOperatorParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6809);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3327:3: ( (lv_expr_1_0= rulePostfixExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3328:1: (lv_expr_1_0= rulePostfixExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3328:1: (lv_expr_1_0= rulePostfixExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3329:3: lv_expr_1_0= rulePostfixExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExprPostfixExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6831);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3353:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3354:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3355:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6868);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator6879); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3362:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '!' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3365:28: ( (kw= 'not' | kw= '!' | kw= '-' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3366:1: (kw= 'not' | kw= '!' | kw= '-' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3366:1: (kw= 'not' | kw= '!' | kw= '-' )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt56=1;
                }
                break;
            case 57:
                {
                alt56=2;
                }
                break;
            case 53:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3367:2: kw= 'not'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleUnaryOperator6917); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3374:2: kw= '!'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleUnaryOperator6936); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getExclamationMarkKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3381:2: kw= '-'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleUnaryOperator6955); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3394:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3395:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3396:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6995);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression7005); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3403:1: rulePostfixExpression returns [EObject current=null] : ( (lv_left_0_0= rulePrimaryExpression ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3406:28: ( ( (lv_left_0_0= rulePrimaryExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3407:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3407:1: ( (lv_left_0_0= rulePrimaryExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3408:1: (lv_left_0_0= rulePrimaryExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3408:1: (lv_left_0_0= rulePrimaryExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3409:3: lv_left_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getLeftPrimaryExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7050);
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


    // $ANTLR start "entryRuleExpressionOrQualifiedExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3433:1: entryRuleExpressionOrQualifiedExecution returns [EObject current=null] : iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF ;
    public final EObject entryRuleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionOrQualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3434:2: (iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3435:2: iv_ruleExpressionOrQualifiedExecution= ruleExpressionOrQualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution7085);
            iv_ruleExpressionOrQualifiedExecution=ruleExpressionOrQualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionOrQualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution7095); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3442:1: ruleExpressionOrQualifiedExecution returns [EObject current=null] : ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) ;
    public final EObject ruleExpressionOrQualifiedExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_val_0_0 = null;

        EObject lv_parenthesis_2_0 = null;

        EObject lv_calls_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3445:28: ( ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:1: ( ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) ) ( (lv_calls_4_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:2: ( ( (lv_val_0_0= ruleConstant ) ) | (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_STRING && LA57_0<=RULE_EXPONENT)||LA57_0==40||(LA57_0>=65 && LA57_0<=67)) ) {
                alt57=1;
            }
            else if ( (LA57_0==16) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:3: ( (lv_val_0_0= ruleConstant ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3446:3: ( (lv_val_0_0= ruleConstant ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3447:1: (lv_val_0_0= ruleConstant )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3447:1: (lv_val_0_0= ruleConstant )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3448:3: lv_val_0_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getValConstantParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7142);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3465:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3465:6: (otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3465:8: otherlv_1= '(' ( (lv_parenthesis_2_0= ruleExpression ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleExpressionOrQualifiedExecution7161); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExpressionOrQualifiedExecutionAccess().getLeftParenthesisKeyword_0_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3469:1: ( (lv_parenthesis_2_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3470:1: (lv_parenthesis_2_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3470:1: (lv_parenthesis_2_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3471:3: lv_parenthesis_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getParenthesisExpressionParserRuleCall_0_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7182);
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

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleExpressionOrQualifiedExecution7194); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getExpressionOrQualifiedExecutionAccess().getRightParenthesisKeyword_0_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3491:3: ( (lv_calls_4_0= ruleSubCall ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==27||(LA58_0>=60 && LA58_0<=61)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3492:1: (lv_calls_4_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3492:1: (lv_calls_4_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3493:3: lv_calls_4_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExpressionOrQualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7217);
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
            	    break loop58;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3517:1: entryRuleUnqualifiedExecution returns [EObject current=null] : iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF ;
    public final EObject entryRuleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3518:2: (iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3519:2: iv_ruleUnqualifiedExecution= ruleUnqualifiedExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnqualifiedExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7254);
            iv_ruleUnqualifiedExecution=ruleUnqualifiedExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnqualifiedExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedExecution7264); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3526:1: ruleUnqualifiedExecution returns [EObject current=null] : ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) ;
    public final EObject ruleUnqualifiedExecution() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;

        EObject lv_calls_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3529:28: ( ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3530:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3530:1: ( ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3530:2: ( (lv_call_0_0= ruleCall ) ) ( (lv_calls_1_0= ruleSubCall ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3530:2: ( (lv_call_0_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3531:1: (lv_call_0_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3531:1: (lv_call_0_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3532:3: lv_call_0_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallCallParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleUnqualifiedExecution7310);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3548:2: ( (lv_calls_1_0= ruleSubCall ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==27||(LA59_0>=60 && LA59_0<=61)) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3549:1: (lv_calls_1_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3549:1: (lv_calls_1_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3550:3: lv_calls_1_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnqualifiedExecutionAccess().getCallsSubCallParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7331);
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
    // $ANTLR end "ruleUnqualifiedExecution"


    // $ANTLR start "entryRuleSuperExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3574:1: entryRuleSuperExecution returns [EObject current=null] : iv_ruleSuperExecution= ruleSuperExecution EOF ;
    public final EObject entryRuleSuperExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3575:2: (iv_ruleSuperExecution= ruleSuperExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3576:2: iv_ruleSuperExecution= ruleSuperExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7368);
            iv_ruleSuperExecution=ruleSuperExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperExecution7378); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3583:1: ruleSuperExecution returns [EObject current=null] : (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) ;
    public final EObject ruleSuperExecution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_call_2_0 = null;

        EObject lv_calls_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3586:28: ( (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3587:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3587:1: (otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3587:3: otherlv_0= 'super' otherlv_1= '.' ( (lv_call_2_0= ruleCall ) ) ( (lv_calls_3_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleSuperExecution7415); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperExecutionAccess().getSuperKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleSuperExecution7427); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSuperExecutionAccess().getFullStopKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3595:1: ( (lv_call_2_0= ruleCall ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3596:1: (lv_call_2_0= ruleCall )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3596:1: (lv_call_2_0= ruleCall )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3597:3: lv_call_2_0= ruleCall
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallCallParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCall_in_ruleSuperExecution7448);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3613:2: ( (lv_calls_3_0= ruleSubCall ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==27||(LA60_0>=60 && LA60_0<=61)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3614:1: (lv_calls_3_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3614:1: (lv_calls_3_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3615:3: lv_calls_3_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSuperExecutionAccess().getCallsSubCallParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleSuperExecution7469);
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
    // $ANTLR end "ruleSuperExecution"


    // $ANTLR start "entryRuleConstructorExecution"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3639:1: entryRuleConstructorExecution returns [EObject current=null] : iv_ruleConstructorExecution= ruleConstructorExecution EOF ;
    public final EObject entryRuleConstructorExecution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorExecution = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3640:2: (iv_ruleConstructorExecution= ruleConstructorExecution EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3641:2: iv_ruleConstructorExecution= ruleConstructorExecution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructorExecutionRule()); 
            }
            pushFollow(FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7506);
            iv_ruleConstructorExecution=ruleConstructorExecution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructorExecution; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorExecution7516); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3648:1: ruleConstructorExecution returns [EObject current=null] : (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3651:28: ( (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3652:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3652:1: (otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3652:3: otherlv_0= 'new' ( (lv_type_1_0= ruleType ) ) otherlv_2= '(' ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ( (lv_calls_5_0= ruleSubCall ) )*
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleConstructorExecution7553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstructorExecutionAccess().getNewKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3656:1: ( (lv_type_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3657:1: (lv_type_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3657:1: (lv_type_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3658:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleConstructorExecution7574);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleConstructorExecution7586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructorExecutionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3678:1: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=RULE_STRING && LA61_0<=RULE_EXPONENT)||LA61_0==16||LA61_0==18||LA61_0==28||LA61_0==30||LA61_0==33||LA61_0==36||LA61_0==40||LA61_0==53||(LA61_0>=56 && LA61_0<=59)||(LA61_0>=65 && LA61_0<=67)) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3679:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3679:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3680:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleConstructorExecution7607);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleConstructorExecution7620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructorExecutionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3700:1: ( (lv_calls_5_0= ruleSubCall ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==27||(LA62_0>=60 && LA62_0<=61)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3701:1: (lv_calls_5_0= ruleSubCall )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3701:1: (lv_calls_5_0= ruleSubCall )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3702:3: lv_calls_5_0= ruleSubCall
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructorExecutionAccess().getCallsSubCallParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSubCall_in_ruleConstructorExecution7641);
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
    // $ANTLR end "ruleConstructorExecution"


    // $ANTLR start "entryRuleSubCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3726:1: entryRuleSubCall returns [EObject current=null] : iv_ruleSubCall= ruleSubCall EOF ;
    public final EObject entryRuleSubCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3727:2: (iv_ruleSubCall= ruleSubCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3728:2: iv_ruleSubCall= ruleSubCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubCallRule()); 
            }
            pushFollow(FOLLOW_ruleSubCall_in_entryRuleSubCall7678);
            iv_ruleSubCall=ruleSubCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubCall7688); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3735:1: ruleSubCall returns [EObject current=null] : ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3738:28: ( ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:1: ( ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) ) | (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==27||LA64_0==60) ) {
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:2: ( ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) ) ( (lv_call_1_0= ruleCall ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3739:3: ( ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3740:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3740:1: ( (lv_type_0_1= '.' | lv_type_0_2= '->' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3741:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3741:1: (lv_type_0_1= '.' | lv_type_0_2= '->' )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==27) ) {
                        alt63=1;
                    }
                    else if ( (LA63_0==60) ) {
                        alt63=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3742:3: lv_type_0_1= '.'
                            {
                            lv_type_0_1=(Token)match(input,27,FOLLOW_27_in_ruleSubCall7734); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3754:8: lv_type_0_2= '->'
                            {
                            lv_type_0_2=(Token)match(input,60,FOLLOW_60_in_ruleSubCall7763); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3769:2: ( (lv_call_1_0= ruleCall ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3770:1: (lv_call_1_0= ruleCall )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3770:1: (lv_call_1_0= ruleCall )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3771:3: lv_call_1_0= ruleCall
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getCallCallParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCall_in_ruleSubCall7800);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3788:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3788:6: (otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3788:8: otherlv_2= '[' ( (lv_arrayEx_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleSubCall7820); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSubCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3792:1: ( (lv_arrayEx_3_0= ruleExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3793:1: (lv_arrayEx_3_0= ruleExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3793:1: (lv_arrayEx_3_0= ruleExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3794:3: lv_arrayEx_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubCallAccess().getArrayExExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubCall7841);
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

                    otherlv_4=(Token)match(input,62,FOLLOW_62_in_ruleSubCall7853); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3822:1: entryRuleDeclarator returns [EObject current=null] : iv_ruleDeclarator= ruleDeclarator EOF ;
    public final EObject entryRuleDeclarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclarator = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3823:2: (iv_ruleDeclarator= ruleDeclarator EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3824:2: iv_ruleDeclarator= ruleDeclarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaratorRule()); 
            }
            pushFollow(FOLLOW_ruleDeclarator_in_entryRuleDeclarator7890);
            iv_ruleDeclarator=ruleDeclarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclarator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarator7900); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3831:1: ruleDeclarator returns [EObject current=null] : ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) ;
    public final EObject ruleDeclarator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_decl_0_0 = null;

        EObject lv_decl_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3834:28: ( ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:1: ( ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:2: ( (lv_decl_0_0= ruleDeclaration ) ) (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )* otherlv_3= '|'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3835:2: ( (lv_decl_0_0= ruleDeclaration ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3836:1: (lv_decl_0_0= ruleDeclaration )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3836:1: (lv_decl_0_0= ruleDeclaration )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3837:3: lv_decl_0_0= ruleDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7946);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3853:2: (otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==14) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3853:4: otherlv_1= ';' ( (lv_decl_2_0= ruleDeclaration ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleDeclarator7959); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getDeclaratorAccess().getSemicolonKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3857:1: ( (lv_decl_2_0= ruleDeclaration ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3858:1: (lv_decl_2_0= ruleDeclaration )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3858:1: (lv_decl_2_0= ruleDeclaration )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3859:3: lv_decl_2_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclaratorAccess().getDeclDeclarationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDeclaration_in_ruleDeclarator7980);
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
            	    break loop65;
                }
            } while (true);

            otherlv_3=(Token)match(input,63,FOLLOW_63_in_ruleDeclarator7994); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3887:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3888:2: (iv_ruleDeclaration= ruleDeclaration EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3889:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleDeclaration_in_entryRuleDeclaration8030);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclaration8040); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3896:1: ruleDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_id_1_0 = null;

        AntlrDatatypeRuleToken lv_id_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3899:28: ( ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3900:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3900:1: ( ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3900:2: ( (lv_type_0_0= ruleType ) )? ( (lv_id_1_0= ruleIdentifier ) ) (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3900:2: ( (lv_type_0_0= ruleType ) )?
            int alt66=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA66_1 = input.LA(2);

                    if ( (LA66_1==RULE_VERSION||(LA66_1>=RULE_ID && LA66_1<=RULE_EXPONENT)||LA66_1==40||LA66_1==64) ) {
                        alt66=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA66_2 = input.LA(2);

                    if ( (LA66_2==RULE_VERSION||(LA66_2>=RULE_ID && LA66_2<=RULE_EXPONENT)||LA66_2==40||LA66_2==64) ) {
                        alt66=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA66_3 = input.LA(2);

                    if ( (LA66_3==RULE_VERSION||(LA66_3>=RULE_ID && LA66_3<=RULE_EXPONENT)||LA66_3==40||LA66_3==64) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA66_4 = input.LA(2);

                    if ( (LA66_4==RULE_VERSION||(LA66_4>=RULE_ID && LA66_4<=RULE_EXPONENT)||LA66_4==40||LA66_4==64) ) {
                        alt66=1;
                    }
                    }
                    break;
                case 68:
                case 69:
                case 70:
                case 71:
                    {
                    alt66=1;
                    }
                    break;
            }

            switch (alt66) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3901:1: (lv_type_0_0= ruleType )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3901:1: (lv_type_0_0= ruleType )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3902:3: lv_type_0_0= ruleType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDeclarationAccess().getTypeTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleType_in_ruleDeclaration8086);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3918:3: ( (lv_id_1_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3919:1: (lv_id_1_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3919:1: (lv_id_1_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3920:3: lv_id_1_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration8108);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3936:2: (otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==25) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3936:4: otherlv_2= ',' ( (lv_id_3_0= ruleIdentifier ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleDeclaration8121); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getDeclarationAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3940:1: ( (lv_id_3_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3941:1: (lv_id_3_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3941:1: (lv_id_3_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3942:3: lv_id_3_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDeclarationAccess().getIdIdentifierParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleDeclaration8142);
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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleCall"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3966:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3967:2: (iv_ruleCall= ruleCall EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3968:2: iv_ruleCall= ruleCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCallRule()); 
            }
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall8180);
            iv_ruleCall=ruleCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall8190); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3975:1: ruleCall returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_name_0_0 = null;

        EObject lv_decl_2_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3978:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:2: ( (lv_name_0_0= ruleQualifiedPrefix ) ) otherlv_1= '(' ( (lv_decl_2_0= ruleDeclarator ) )? ( (lv_param_3_0= ruleArgumentList ) )? otherlv_4= ')'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3979:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3980:1: (lv_name_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3980:1: (lv_name_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3981:3: lv_name_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCallAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleCall8236);
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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleCall8248); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4001:1: ( (lv_decl_2_0= ruleDeclarator ) )?
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4002:1: (lv_decl_2_0= ruleDeclarator )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4002:1: (lv_decl_2_0= ruleDeclarator )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4003:3: lv_decl_2_0= ruleDeclarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getDeclDeclaratorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDeclarator_in_ruleCall8269);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4019:3: ( (lv_param_3_0= ruleArgumentList ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=RULE_STRING && LA69_0<=RULE_EXPONENT)||LA69_0==16||LA69_0==18||LA69_0==28||LA69_0==30||LA69_0==33||LA69_0==36||LA69_0==40||LA69_0==53||(LA69_0>=56 && LA69_0<=59)||(LA69_0>=65 && LA69_0<=67)) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4020:1: (lv_param_3_0= ruleArgumentList )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4020:1: (lv_param_3_0= ruleArgumentList )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4021:3: lv_param_3_0= ruleArgumentList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCallAccess().getParamArgumentListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgumentList_in_ruleCall8291);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleCall8304); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4049:1: entryRuleArgumentList returns [EObject current=null] : iv_ruleArgumentList= ruleArgumentList EOF ;
    public final EObject entryRuleArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentList = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4050:2: (iv_ruleArgumentList= ruleArgumentList EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4051:2: iv_ruleArgumentList= ruleArgumentList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentListRule()); 
            }
            pushFollow(FOLLOW_ruleArgumentList_in_entryRuleArgumentList8340);
            iv_ruleArgumentList=ruleArgumentList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgumentList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentList8350); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4058:1: ruleArgumentList returns [EObject current=null] : ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) ;
    public final EObject ruleArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_param_0_0 = null;

        EObject lv_param_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4061:28: ( ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4062:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4062:1: ( ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4062:2: ( (lv_param_0_0= ruleNamedArgument ) ) (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4062:2: ( (lv_param_0_0= ruleNamedArgument ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4063:1: (lv_param_0_0= ruleNamedArgument )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4063:1: (lv_param_0_0= ruleNamedArgument )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4064:3: lv_param_0_0= ruleNamedArgument
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8396);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4080:2: (otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==25) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4080:4: otherlv_1= ',' ( (lv_param_2_0= ruleNamedArgument ) )
            	    {
            	    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleArgumentList8409); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getArgumentListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4084:1: ( (lv_param_2_0= ruleNamedArgument ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4085:1: (lv_param_2_0= ruleNamedArgument )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4085:1: (lv_param_2_0= ruleNamedArgument )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4086:3: lv_param_2_0= ruleNamedArgument
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArgumentListAccess().getParamNamedArgumentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedArgument_in_ruleArgumentList8430);
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
    // $ANTLR end "ruleArgumentList"


    // $ANTLR start "entryRuleNamedArgument"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4110:1: entryRuleNamedArgument returns [EObject current=null] : iv_ruleNamedArgument= ruleNamedArgument EOF ;
    public final EObject entryRuleNamedArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedArgument = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4111:2: (iv_ruleNamedArgument= ruleNamedArgument EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4112:2: iv_ruleNamedArgument= ruleNamedArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8468);
            iv_ruleNamedArgument=ruleNamedArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedArgument8478); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4119:1: ruleNamedArgument returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ex_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4122:28: ( ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:1: ( ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )? ( (lv_ex_2_0= ruleExpression ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:2: ( ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '=' )?
            int alt71=2;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    int LA71_1 = input.LA(2);

                    if ( (LA71_1==23) ) {
                        alt71=1;
                    }
                    }
                    break;
                case RULE_VERSION:
                    {
                    int LA71_2 = input.LA(2);

                    if ( (LA71_2==23) ) {
                        alt71=1;
                    }
                    }
                    break;
                case RULE_EXPONENT:
                    {
                    int LA71_3 = input.LA(2);

                    if ( (LA71_3==23) ) {
                        alt71=1;
                    }
                    }
                    break;
                case 40:
                    {
                    int LA71_4 = input.LA(2);

                    if ( (LA71_4==23) ) {
                        alt71=1;
                    }
                    }
                    break;
            }

            switch (alt71) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:3: ( (lv_name_0_0= ruleIdentifier ) ) otherlv_1= '='
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4123:3: ( (lv_name_0_0= ruleIdentifier ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4124:1: (lv_name_0_0= ruleIdentifier )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4124:1: (lv_name_0_0= ruleIdentifier )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4125:3: lv_name_0_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getNameIdentifierParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdentifier_in_ruleNamedArgument8525);
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

                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNamedArgument8537); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNamedArgumentAccess().getEqualsSignKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4145:3: ( (lv_ex_2_0= ruleExpression ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4146:1: (lv_ex_2_0= ruleExpression )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4146:1: (lv_ex_2_0= ruleExpression )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4147:3: lv_ex_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedArgumentAccess().getExExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedArgument8560);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4171:1: entryRuleQualifiedPrefix returns [EObject current=null] : iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF ;
    public final EObject entryRuleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedPrefix = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4172:2: (iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4173:2: iv_ruleQualifiedPrefix= ruleQualifiedPrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedPrefixRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8596);
            iv_ruleQualifiedPrefix=ruleQualifiedPrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedPrefix; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedPrefix8606); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4180:1: ruleQualifiedPrefix returns [EObject current=null] : ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedPrefix() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        AntlrDatatypeRuleToken lv_qname_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4183:28: ( ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:1: ( ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:2: ( (lv_qname_0_0= ruleIdentifier ) ) ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4184:2: ( (lv_qname_0_0= ruleIdentifier ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:1: (lv_qname_0_0= ruleIdentifier )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4185:1: (lv_qname_0_0= ruleIdentifier )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4186:3: lv_qname_0_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8652);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4202:2: ( ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==64) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4202:3: ( (lv_qname_1_0= '::' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4202:3: ( (lv_qname_1_0= '::' ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4203:1: (lv_qname_1_0= '::' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4203:1: (lv_qname_1_0= '::' )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4204:3: lv_qname_1_0= '::'
            	    {
            	    lv_qname_1_0=(Token)match(input,64,FOLLOW_64_in_ruleQualifiedPrefix8671); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4217:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4218:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4218:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4219:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedPrefixAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8705);
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
    // $ANTLR end "ruleQualifiedPrefix"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4243:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4244:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4245:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8743);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName8753); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4252:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_qname_1_0=null;
        EObject lv_prefix_0_0 = null;

        AntlrDatatypeRuleToken lv_qname_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4255:28: ( ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4256:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4256:1: ( ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )* )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4256:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) ) ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4256:2: ( (lv_prefix_0_0= ruleQualifiedPrefix ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4257:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4257:1: (lv_prefix_0_0= ruleQualifiedPrefix )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4258:3: lv_prefix_0_0= ruleQualifiedPrefix
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getPrefixQualifiedPrefixParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8799);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4274:2: ( ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==27) ) {
                    switch ( input.LA(2) ) {
                    case RULE_ID:
                        {
                        int LA73_3 = input.LA(3);

                        if ( (LA73_3==EOF||(LA73_3>=14 && LA73_3<=15)||(LA73_3>=17 && LA73_3<=19)||(LA73_3>=24 && LA73_3<=25)||LA73_3==27||LA73_3==39||(LA73_3>=42 && LA73_3<=55)||(LA73_3>=60 && LA73_3<=62)) ) {
                            alt73=1;
                        }


                        }
                        break;
                    case RULE_VERSION:
                        {
                        int LA73_4 = input.LA(3);

                        if ( (LA73_4==EOF||(LA73_4>=14 && LA73_4<=15)||(LA73_4>=17 && LA73_4<=19)||(LA73_4>=24 && LA73_4<=25)||LA73_4==27||LA73_4==39||(LA73_4>=42 && LA73_4<=55)||(LA73_4>=60 && LA73_4<=62)) ) {
                            alt73=1;
                        }


                        }
                        break;
                    case RULE_EXPONENT:
                        {
                        int LA73_5 = input.LA(3);

                        if ( (LA73_5==EOF||(LA73_5>=14 && LA73_5<=15)||(LA73_5>=17 && LA73_5<=19)||(LA73_5>=24 && LA73_5<=25)||LA73_5==27||LA73_5==39||(LA73_5>=42 && LA73_5<=55)||(LA73_5>=60 && LA73_5<=62)) ) {
                            alt73=1;
                        }


                        }
                        break;
                    case 40:
                        {
                        int LA73_6 = input.LA(3);

                        if ( (LA73_6==EOF||(LA73_6>=14 && LA73_6<=15)||(LA73_6>=17 && LA73_6<=19)||(LA73_6>=24 && LA73_6<=25)||LA73_6==27||LA73_6==39||(LA73_6>=42 && LA73_6<=55)||(LA73_6>=60 && LA73_6<=62)) ) {
                            alt73=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt73) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4274:3: ( (lv_qname_1_0= '.' ) ) ( (lv_qname_2_0= ruleIdentifier ) )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4274:3: ( (lv_qname_1_0= '.' ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4275:1: (lv_qname_1_0= '.' )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4275:1: (lv_qname_1_0= '.' )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4276:3: lv_qname_1_0= '.'
            	    {
            	    lv_qname_1_0=(Token)match(input,27,FOLLOW_27_in_ruleQualifiedName8818); if (state.failed) return current;
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

            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4289:2: ( (lv_qname_2_0= ruleIdentifier ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4290:1: (lv_qname_2_0= ruleIdentifier )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4290:1: (lv_qname_2_0= ruleIdentifier )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4291:3: lv_qname_2_0= ruleIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameAccess().getQnameIdentifierParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIdentifier_in_ruleQualifiedName8852);
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleConstant"
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4315:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4316:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4317:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant8890);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant8900); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4324:1: ruleConstant returns [EObject current=null] : ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4327:28: ( ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:1: ( ( (lv_nValue_0_0= ruleNumValue ) ) | ( (lv_sValue_1_0= RULE_STRING ) ) | ( (lv_qValue_2_0= ruleQualifiedName ) ) | ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) ) | ( (lv_null_4_0= 'null' ) ) | ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) ) )
            int alt75=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt75=1;
                }
                break;
            case RULE_STRING:
                {
                alt75=2;
                }
                break;
            case RULE_ID:
            case RULE_EXPONENT:
            case 40:
                {
                alt75=3;
                }
                break;
            case RULE_VERSION:
                {
                int LA75_4 = input.LA(2);

                if ( (synpred90_InternalVilBuildLanguage()) ) {
                    alt75=3;
                }
                else if ( (synpred94_InternalVilBuildLanguage()) ) {
                    alt75=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 4, input);

                    throw nvae;
                }
                }
                break;
            case 65:
            case 66:
                {
                alt75=4;
                }
                break;
            case 67:
                {
                alt75=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4328:2: ( (lv_nValue_0_0= ruleNumValue ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4329:1: (lv_nValue_0_0= ruleNumValue )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4329:1: (lv_nValue_0_0= ruleNumValue )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4330:3: lv_nValue_0_0= ruleNumValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getNValueNumValueParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumValue_in_ruleConstant8946);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4347:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4347:6: ( (lv_sValue_1_0= RULE_STRING ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4348:1: (lv_sValue_1_0= RULE_STRING )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4348:1: (lv_sValue_1_0= RULE_STRING )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4349:3: lv_sValue_1_0= RULE_STRING
                    {
                    lv_sValue_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConstant8969); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4367:1: (lv_qValue_2_0= ruleQualifiedName )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4367:1: (lv_qValue_2_0= ruleQualifiedName )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4368:3: lv_qValue_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant9001);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4385:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4385:6: ( ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4386:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4386:1: ( (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4387:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4387:1: (lv_bValue_3_1= 'true' | lv_bValue_3_2= 'false' )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==65) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==66) ) {
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4388:3: lv_bValue_3_1= 'true'
                            {
                            lv_bValue_3_1=(Token)match(input,65,FOLLOW_65_in_ruleConstant9027); if (state.failed) return current;
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
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4400:8: lv_bValue_3_2= 'false'
                            {
                            lv_bValue_3_2=(Token)match(input,66,FOLLOW_66_in_ruleConstant9056); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4416:6: ( (lv_null_4_0= 'null' ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4416:6: ( (lv_null_4_0= 'null' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4417:1: (lv_null_4_0= 'null' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4417:1: (lv_null_4_0= 'null' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4418:3: lv_null_4_0= 'null'
                    {
                    lv_null_4_0=(Token)match(input,67,FOLLOW_67_in_ruleConstant9096); if (state.failed) return current;
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4432:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4432:6: ( ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4432:7: ( ( RULE_VERSION ) )=> (lv_version_5_0= RULE_VERSION )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4438:1: (lv_version_5_0= RULE_VERSION )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4439:3: lv_version_5_0= RULE_VERSION
                    {
                    lv_version_5_0=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleConstant9143); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4463:1: entryRuleNumValue returns [EObject current=null] : iv_ruleNumValue= ruleNumValue EOF ;
    public final EObject entryRuleNumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumValue = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4464:2: (iv_ruleNumValue= ruleNumValue EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4465:2: iv_ruleNumValue= ruleNumValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumValue_in_entryRuleNumValue9184);
            iv_ruleNumValue=ruleNumValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumValue9194); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4472:1: ruleNumValue returns [EObject current=null] : ( (lv_val_0_0= RULE_NUMBER ) ) ;
    public final EObject ruleNumValue() throws RecognitionException {
        EObject current = null;

        Token lv_val_0_0=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4475:28: ( ( (lv_val_0_0= RULE_NUMBER ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4476:1: ( (lv_val_0_0= RULE_NUMBER ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4476:1: ( (lv_val_0_0= RULE_NUMBER ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4477:1: (lv_val_0_0= RULE_NUMBER )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4477:1: (lv_val_0_0= RULE_NUMBER )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4478:3: lv_val_0_0= RULE_NUMBER
            {
            lv_val_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumValue9235); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4502:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4503:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4504:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier9276);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier9287); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4511:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_VERSION_1=null;
        Token this_EXPONENT_2=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4514:28: ( (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:1: (this_ID_0= RULE_ID | this_VERSION_1= RULE_VERSION | this_EXPONENT_2= RULE_EXPONENT | kw= 'version' )
            int alt76=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt76=1;
                }
                break;
            case RULE_VERSION:
                {
                alt76=2;
                }
                break;
            case RULE_EXPONENT:
                {
                alt76=3;
                }
                break;
            case 40:
                {
                alt76=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4515:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier9327); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4523:10: this_VERSION_1= RULE_VERSION
                    {
                    this_VERSION_1=(Token)match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_ruleIdentifier9353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_VERSION_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_VERSION_1, grammarAccess.getIdentifierAccess().getVERSIONTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4531:10: this_EXPONENT_2= RULE_EXPONENT
                    {
                    this_EXPONENT_2=(Token)match(input,RULE_EXPONENT,FOLLOW_RULE_EXPONENT_in_ruleIdentifier9379); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_EXPONENT_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXPONENT_2, grammarAccess.getIdentifierAccess().getEXPONENTTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4540:2: kw= 'version'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleIdentifier9403); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4553:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4554:2: (iv_ruleType= ruleType EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4555:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_ruleType_in_entryRuleType9443);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleType9453); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4562:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) ;
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
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4565:28: ( ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4566:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4566:1: ( ( (lv_name_0_0= ruleQualifiedPrefix ) ) | ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) ) | ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) ) | ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) ) | ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) ) )
            int alt78=5;
            switch ( input.LA(1) ) {
            case RULE_VERSION:
            case RULE_ID:
            case RULE_EXPONENT:
            case 40:
                {
                alt78=1;
                }
                break;
            case 68:
                {
                alt78=2;
                }
                break;
            case 69:
                {
                alt78=3;
                }
                break;
            case 70:
                {
                alt78=4;
                }
                break;
            case 71:
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4566:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4566:2: ( (lv_name_0_0= ruleQualifiedPrefix ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4567:1: (lv_name_0_0= ruleQualifiedPrefix )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4567:1: (lv_name_0_0= ruleQualifiedPrefix )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4568:3: lv_name_0_0= ruleQualifiedPrefix
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getNameQualifiedPrefixParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedPrefix_in_ruleType9499);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4585:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4585:6: ( ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4585:7: ( (lv_set_1_0= 'setOf' ) ) ( (lv_param_2_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4585:7: ( (lv_set_1_0= 'setOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4586:1: (lv_set_1_0= 'setOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4586:1: (lv_set_1_0= 'setOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4587:3: lv_set_1_0= 'setOf'
                    {
                    lv_set_1_0=(Token)match(input,68,FOLLOW_68_in_ruleType9524); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4600:2: ( (lv_param_2_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4601:1: (lv_param_2_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4601:1: (lv_param_2_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4602:3: lv_param_2_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9558);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4619:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4619:6: ( ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4619:7: ( (lv_seq_3_0= 'sequenceOf' ) ) ( (lv_param_4_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4619:7: ( (lv_seq_3_0= 'sequenceOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4620:1: (lv_seq_3_0= 'sequenceOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4620:1: (lv_seq_3_0= 'sequenceOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4621:3: lv_seq_3_0= 'sequenceOf'
                    {
                    lv_seq_3_0=(Token)match(input,69,FOLLOW_69_in_ruleType9584); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4634:2: ( (lv_param_4_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4635:1: (lv_param_4_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4635:1: (lv_param_4_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4636:3: lv_param_4_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9618);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4653:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4653:6: ( ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4653:7: ( (lv_map_5_0= 'mapOf' ) ) ( (lv_param_6_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4653:7: ( (lv_map_5_0= 'mapOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4654:1: (lv_map_5_0= 'mapOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4654:1: (lv_map_5_0= 'mapOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4655:3: lv_map_5_0= 'mapOf'
                    {
                    lv_map_5_0=(Token)match(input,70,FOLLOW_70_in_ruleType9644); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4668:2: ( (lv_param_6_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:1: (lv_param_6_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4669:1: (lv_param_6_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4670:3: lv_param_6_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9678);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:6: ( ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:7: ( (lv_call_7_0= 'callOf' ) ) ( (lv_return_8_0= ruleType ) )? ( (lv_param_9_0= ruleTypeParameters ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4687:7: ( (lv_call_7_0= 'callOf' ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4688:1: (lv_call_7_0= 'callOf' )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4688:1: (lv_call_7_0= 'callOf' )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4689:3: lv_call_7_0= 'callOf'
                    {
                    lv_call_7_0=(Token)match(input,71,FOLLOW_71_in_ruleType9704); if (state.failed) return current;
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4702:2: ( (lv_return_8_0= ruleType ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_VERSION||(LA77_0>=RULE_ID && LA77_0<=RULE_EXPONENT)||LA77_0==40||(LA77_0>=68 && LA77_0<=71)) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4703:1: (lv_return_8_0= ruleType )
                            {
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4703:1: (lv_return_8_0= ruleType )
                            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4704:3: lv_return_8_0= ruleType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeAccess().getReturnTypeParserRuleCall_4_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleType_in_ruleType9738);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4720:3: ( (lv_param_9_0= ruleTypeParameters ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4721:1: (lv_param_9_0= ruleTypeParameters )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4721:1: (lv_param_9_0= ruleTypeParameters )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4722:3: lv_param_9_0= ruleTypeParameters
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeAccess().getParamTypeParametersParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeParameters_in_ruleType9760);
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4746:1: entryRuleTypeParameters returns [EObject current=null] : iv_ruleTypeParameters= ruleTypeParameters EOF ;
    public final EObject entryRuleTypeParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameters = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4747:2: (iv_ruleTypeParameters= ruleTypeParameters EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4748:2: iv_ruleTypeParameters= ruleTypeParameters EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParametersRule()); 
            }
            pushFollow(FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9797);
            iv_ruleTypeParameters=ruleTypeParameters();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameters; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeParameters9807); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4755:1: ruleTypeParameters returns [EObject current=null] : (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleTypeParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_1_0 = null;

        EObject lv_param_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4758:28: ( (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4759:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4759:1: (otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4759:3: otherlv_0= '(' ( (lv_param_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTypeParameters9844); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTypeParametersAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4763:1: ( (lv_param_1_0= ruleType ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4764:1: (lv_param_1_0= ruleType )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4764:1: (lv_param_1_0= ruleType )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4765:3: lv_param_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9865);
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

            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4781:2: (otherlv_2= ',' ( (lv_param_3_0= ruleType ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==25) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4781:4: otherlv_2= ',' ( (lv_param_3_0= ruleType ) )
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleTypeParameters9878); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeParametersAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4785:1: ( (lv_param_3_0= ruleType ) )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4786:1: (lv_param_3_0= ruleType )
            	    {
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4786:1: (lv_param_3_0= ruleType )
            	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4787:3: lv_param_3_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeParametersAccess().getParamTypeParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleType_in_ruleTypeParameters9899);
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
            	    break loop79;
                }
            } while (true);

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleTypeParameters9913); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4815:1: entryRuleContainerInitializer returns [EObject current=null] : iv_ruleContainerInitializer= ruleContainerInitializer EOF ;
    public final EObject entryRuleContainerInitializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializer = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4816:2: (iv_ruleContainerInitializer= ruleContainerInitializer EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4817:2: iv_ruleContainerInitializer= ruleContainerInitializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9949);
            iv_ruleContainerInitializer=ruleContainerInitializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializer; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializer9959); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4824:1: ruleContainerInitializer returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleContainerInitializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4827:28: ( ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4828:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4828:1: ( () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}' )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4828:2: () otherlv_1= '{' ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )? otherlv_5= '}'
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4828:2: ()
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4829:2: 
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

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleContainerInitializer10008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContainerInitializerAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4841:1: ( ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=RULE_STRING && LA81_0<=RULE_EXPONENT)||LA81_0==16||LA81_0==18||LA81_0==28||LA81_0==30||LA81_0==33||LA81_0==36||LA81_0==40||LA81_0==53||(LA81_0>=56 && LA81_0<=59)||(LA81_0>=65 && LA81_0<=67)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4841:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4841:2: ( (lv_exprs_2_0= ruleContainerInitializerExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4842:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4842:1: (lv_exprs_2_0= ruleContainerInitializerExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4843:3: lv_exprs_2_0= ruleContainerInitializerExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10030);
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

                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4859:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==25) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4859:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleContainerInitializer10043); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getContainerInitializerAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4863:1: ( (lv_exprs_4_0= ruleContainerInitializerExpression ) )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4864:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    {
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4864:1: (lv_exprs_4_0= ruleContainerInitializerExpression )
                    	    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4865:3: lv_exprs_4_0= ruleContainerInitializerExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainerInitializerAccess().getExprsContainerInitializerExpressionParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10064);
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
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleContainerInitializer10080); if (state.failed) return current;
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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4893:1: entryRuleContainerInitializerExpression returns [EObject current=null] : iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF ;
    public final EObject entryRuleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainerInitializerExpression = null;


        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4894:2: (iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4895:2: iv_ruleContainerInitializerExpression= ruleContainerInitializerExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerInitializerExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10116);
            iv_ruleContainerInitializerExpression=ruleContainerInitializerExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainerInitializerExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainerInitializerExpression10126); if (state.failed) return current;

            }

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
    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4902:1: ruleContainerInitializerExpression returns [EObject current=null] : ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) ;
    public final EObject ruleContainerInitializerExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_logical_0_0 = null;

        EObject lv_container_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4905:28: ( ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) ) )
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4906:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            {
            // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4906:1: ( ( (lv_logical_0_0= ruleLogicalExpression ) ) | ( (lv_container_1_0= ruleContainerInitializer ) ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_EXPONENT)||LA82_0==16||LA82_0==28||LA82_0==30||LA82_0==33||LA82_0==36||LA82_0==40||LA82_0==53||(LA82_0>=56 && LA82_0<=59)||(LA82_0>=65 && LA82_0<=67)) ) {
                alt82=1;
            }
            else if ( (LA82_0==18) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4906:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4906:2: ( (lv_logical_0_0= ruleLogicalExpression ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4907:1: (lv_logical_0_0= ruleLogicalExpression )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4907:1: (lv_logical_0_0= ruleLogicalExpression )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4908:3: lv_logical_0_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getLogicalLogicalExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10172);
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
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4925:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4925:6: ( (lv_container_1_0= ruleContainerInitializer ) )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4926:1: (lv_container_1_0= ruleContainerInitializer )
                    {
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4926:1: (lv_container_1_0= ruleContainerInitializer )
                    // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4927:3: lv_container_1_0= ruleContainerInitializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainerInitializerExpressionAccess().getContainerContainerInitializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10199);
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

    // $ANTLR start synpred7_InternalVilBuildLanguage
    public final void synpred7_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_version_8_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:324:1: ( (lv_version_8_0= ruleVersionStmt ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:324:1: (lv_version_8_0= ruleVersionStmt )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:325:3: lv_version_8_0= ruleVersionStmt
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLanguageUnitAccess().getVersionVersionStmtParserRuleCall_8_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVersionStmt_in_synpred7_InternalVilBuildLanguage559);
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


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:3: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:509:3: ( (lv_elements_1_0= ruleVariableDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:510:1: (lv_elements_1_0= ruleVariableDeclaration )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:511:3: lv_elements_1_0= ruleVariableDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsVariableDeclarationParserRuleCall_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleVariableDeclaration_in_synpred10_InternalVilBuildLanguage968);
        lv_elements_1_0=ruleVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_InternalVilBuildLanguage

    // $ANTLR start synpred12_InternalVilBuildLanguage
    public final void synpred12_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_elements_3_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:547:6: ( ( (lv_elements_3_0= ruleRuleDeclaration ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleRuleDeclaration ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:547:6: ( (lv_elements_3_0= ruleRuleDeclaration ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleRuleDeclaration )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:548:1: (lv_elements_3_0= ruleRuleDeclaration )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:549:3: lv_elements_3_0= ruleRuleDeclaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getScriptContentsAccess().getElementsRuleDeclarationParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleRuleDeclaration_in_synpred12_InternalVilBuildLanguage1022);
        lv_elements_3_0=ruleRuleDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred12_InternalVilBuildLanguage

    // $ANTLR start synpred16_InternalVilBuildLanguage
    public final void synpred16_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_type_1_0 = null;

        EObject lv_modifier_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_paramList_5_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:3: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:3: ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '='
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:595:3: ( (lv_type_1_0= ruleType ) )?
        int alt83=2;
        switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==RULE_VERSION||(LA83_1>=RULE_ID && LA83_1<=RULE_EXPONENT)||LA83_1==26||LA83_1==40||LA83_1==64) ) {
                    alt83=1;
                }
                }
                break;
            case RULE_VERSION:
                {
                int LA83_2 = input.LA(2);

                if ( (LA83_2==RULE_VERSION||(LA83_2>=RULE_ID && LA83_2<=RULE_EXPONENT)||LA83_2==26||LA83_2==40||LA83_2==64) ) {
                    alt83=1;
                }
                }
                break;
            case RULE_EXPONENT:
                {
                int LA83_3 = input.LA(2);

                if ( (LA83_3==RULE_VERSION||(LA83_3>=RULE_ID && LA83_3<=RULE_EXPONENT)||LA83_3==26||LA83_3==40||LA83_3==64) ) {
                    alt83=1;
                }
                }
                break;
            case 40:
                {
                int LA83_4 = input.LA(2);

                if ( (LA83_4==RULE_VERSION||(LA83_4>=RULE_ID && LA83_4<=RULE_EXPONENT)||LA83_4==26||LA83_4==40||LA83_4==64) ) {
                    alt83=1;
                }
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
                {
                alt83=1;
                }
                break;
        }

        switch (alt83) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:1: (lv_type_1_0= ruleType )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:596:1: (lv_type_1_0= ruleType )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:597:3: lv_type_1_0= ruleType
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getTypeTypeParserRuleCall_1_0_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleType_in_synpred16_InternalVilBuildLanguage1129);
                lv_type_1_0=ruleType();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:613:3: ( (lv_modifier_2_0= ruleRuleModifier ) )?
        int alt84=2;
        int LA84_0 = input.LA(1);

        if ( (LA84_0==26) ) {
            alt84=1;
        }
        switch (alt84) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:1: (lv_modifier_2_0= ruleRuleModifier )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:614:1: (lv_modifier_2_0= ruleRuleModifier )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:615:3: lv_modifier_2_0= ruleRuleModifier
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getModifierRuleModifierParserRuleCall_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleRuleModifier_in_synpred16_InternalVilBuildLanguage1151);
                lv_modifier_2_0=ruleRuleModifier();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:631:3: ( (lv_name_3_0= ruleIdentifier ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:632:1: (lv_name_3_0= ruleIdentifier )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:632:1: (lv_name_3_0= ruleIdentifier )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:633:3: lv_name_3_0= ruleIdentifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getNameIdentifierParserRuleCall_1_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleIdentifier_in_synpred16_InternalVilBuildLanguage1173);
        lv_name_3_0=ruleIdentifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,16,FOLLOW_16_in_synpred16_InternalVilBuildLanguage1185); if (state.failed) return ;
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:653:1: ( (lv_paramList_5_0= ruleParameterList ) )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==RULE_VERSION||(LA85_0>=RULE_ID && LA85_0<=RULE_EXPONENT)||LA85_0==40||(LA85_0>=68 && LA85_0<=71)) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:654:1: (lv_paramList_5_0= ruleParameterList )
                {
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:654:1: (lv_paramList_5_0= ruleParameterList )
                // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:655:3: lv_paramList_5_0= ruleParameterList
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getRuleDeclarationAccess().getParamListParameterListParserRuleCall_1_4_0()); 
                  	    
                }
                pushFollow(FOLLOW_ruleParameterList_in_synpred16_InternalVilBuildLanguage1206);
                lv_paramList_5_0=ruleParameterList();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_6=(Token)match(input,17,FOLLOW_17_in_synpred16_InternalVilBuildLanguage1219); if (state.failed) return ;
        otherlv_7=(Token)match(input,23,FOLLOW_23_in_synpred16_InternalVilBuildLanguage1231); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalVilBuildLanguage

    // $ANTLR start synpred27_InternalVilBuildLanguage
    public final void synpred27_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1067:4: (otherlv_7= ';' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1067:4: otherlv_7= ';'
        {
        otherlv_7=(Token)match(input,14,FOLLOW_14_in_synpred27_InternalVilBuildLanguage2035); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalVilBuildLanguage

    // $ANTLR start synpred43_InternalVilBuildLanguage
    public final void synpred43_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_else_6_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:3: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatementOrBlock ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:3: ( ( 'else' )=>otherlv_5= 'else' )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1636:4: ( 'else' )=>otherlv_5= 'else'
        {
        otherlv_5=(Token)match(input,32,FOLLOW_32_in_synpred43_InternalVilBuildLanguage3115); if (state.failed) return ;

        }

        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1641:2: ( (lv_else_6_0= ruleStatementOrBlock ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1642:1: (lv_else_6_0= ruleStatementOrBlock )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1642:1: (lv_else_6_0= ruleStatementOrBlock )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1643:3: lv_else_6_0= ruleStatementOrBlock
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAlternativeAccess().getElseStatementOrBlockParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleStatementOrBlock_in_synpred43_InternalVilBuildLanguage3137);
        lv_else_6_0=ruleStatementOrBlock();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred43_InternalVilBuildLanguage

    // $ANTLR start synpred44_InternalVilBuildLanguage
    public final void synpred44_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_exStmt_0_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:2: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1680:2: ( (lv_exStmt_0_0= ruleExpressionStatement ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1681:1: (lv_exStmt_0_0= ruleExpressionStatement )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1681:1: (lv_exStmt_0_0= ruleExpressionStatement )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:1682:3: lv_exStmt_0_0= ruleExpressionStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementOrBlockAccess().getExStmtExpressionStatementParserRuleCall_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionStatement_in_synpred44_InternalVilBuildLanguage3231);
        lv_exStmt_0_0=ruleExpressionStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred44_InternalVilBuildLanguage

    // $ANTLR start synpred54_InternalVilBuildLanguage
    public final void synpred54_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2560:1: ( (lv_right_1_0= ruleLogicalExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2560:1: (lv_right_1_0= ruleLogicalExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2560:1: (lv_right_1_0= ruleLogicalExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2561:3: lv_right_1_0= ruleLogicalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getRightLogicalExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleLogicalExpressionPart_in_synpred54_InternalVilBuildLanguage5074);
        lv_right_1_0=ruleLogicalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred54_InternalVilBuildLanguage

    // $ANTLR start synpred57_InternalVilBuildLanguage
    public final void synpred57_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2715:1: ( (lv_right_1_0= ruleEqualityExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2715:1: (lv_right_1_0= ruleEqualityExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2715:1: (lv_right_1_0= ruleEqualityExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2716:3: lv_right_1_0= ruleEqualityExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleEqualityExpressionPart_in_synpred57_InternalVilBuildLanguage5429);
        lv_right_1_0=ruleEqualityExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred57_InternalVilBuildLanguage

    // $ANTLR start synpred60_InternalVilBuildLanguage
    public final void synpred60_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2870:1: ( (lv_right_1_0= ruleRelationalExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2870:1: (lv_right_1_0= ruleRelationalExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2870:1: (lv_right_1_0= ruleRelationalExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:2871:3: lv_right_1_0= ruleRelationalExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightRelationalExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleRelationalExpressionPart_in_synpred60_InternalVilBuildLanguage5784);
        lv_right_1_0=ruleRelationalExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred60_InternalVilBuildLanguage

    // $ANTLR start synpred64_InternalVilBuildLanguage
    public final void synpred64_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3032:1: ( (lv_right_1_0= ruleAdditiveExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3032:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3032:1: (lv_right_1_0= ruleAdditiveExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3033:3: lv_right_1_0= ruleAdditiveExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_synpred64_InternalVilBuildLanguage6158);
        lv_right_1_0=ruleAdditiveExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred64_InternalVilBuildLanguage

    // $ANTLR start synpred66_InternalVilBuildLanguage
    public final void synpred66_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_right_1_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3180:1: ( (lv_right_1_0= ruleMultiplicativeExpressionPart ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3180:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3180:1: (lv_right_1_0= ruleMultiplicativeExpressionPart )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:3181:3: lv_right_1_0= ruleMultiplicativeExpressionPart
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightMultiplicativeExpressionPartParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_synpred66_InternalVilBuildLanguage6494);
        lv_right_1_0=ruleMultiplicativeExpressionPart();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred66_InternalVilBuildLanguage

    // $ANTLR start synpred90_InternalVilBuildLanguage
    public final void synpred90_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        EObject lv_qValue_2_0 = null;


        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:6: ( ( (lv_qValue_2_0= ruleQualifiedName ) ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4366:6: ( (lv_qValue_2_0= ruleQualifiedName ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4367:1: (lv_qValue_2_0= ruleQualifiedName )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4367:1: (lv_qValue_2_0= ruleQualifiedName )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4368:3: lv_qValue_2_0= ruleQualifiedName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getConstantAccess().getQValueQualifiedNameParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleQualifiedName_in_synpred90_InternalVilBuildLanguage9001);
        lv_qValue_2_0=ruleQualifiedName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred90_InternalVilBuildLanguage

    // $ANTLR start synpred94_InternalVilBuildLanguage
    public final void synpred94_InternalVilBuildLanguage_fragment() throws RecognitionException {   
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4432:7: ( ( RULE_VERSION ) )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4433:1: ( RULE_VERSION )
        {
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4433:1: ( RULE_VERSION )
        // ../de.uni_hildesheim.sse.vil.buildlang/src-gen/de/uni_hildesheim/sse/parser/antlr/internal/InternalVilBuildLanguage.g:4434:1: RULE_VERSION
        {
        match(input,RULE_VERSION,FOLLOW_RULE_VERSION_in_synpred94_InternalVilBuildLanguage9129); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred94_InternalVilBuildLanguage

    // Delegated rules

    public final boolean synpred43_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred64_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    public final boolean synpred16_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalVilBuildLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalVilBuildLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalVilBuildLanguage_fragment(); // can never throw exception
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
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA68 dfa68 = new DFA68(this);
    static final String DFA10_eotS =
        "\37\uffff";
    static final String DFA10_eofS =
        "\1\1\36\uffff";
    static final String DFA10_minS =
        "\1\4\3\uffff\10\0\23\uffff";
    static final String DFA10_maxS =
        "\1\107\3\uffff\10\0\23\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\4\1\uffff\1\1\10\uffff\1\2\1\3\21\uffff";
    static final String DFA10_specialS =
        "\4\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\23\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\15\1\5\1\15\1\4\1\6\7\uffff\1\15\1\uffff\1\15\1\1\4\uffff"+
            "\1\15\1\uffff\1\15\1\uffff\1\15\1\uffff\1\15\2\uffff\1\15\2"+
            "\uffff\1\15\1\3\1\14\1\uffff\1\7\14\uffff\1\15\2\uffff\4\15"+
            "\5\uffff\3\15\1\10\1\11\1\12\1\13",
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
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 509:2: ( ( (lv_elements_1_0= ruleVariableDeclaration ) ) | ( (lv_elements_2_0= ruleTypeDef ) ) | ( (lv_elements_3_0= ruleRuleDeclaration ) ) )*";
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

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalVilBuildLanguage()) ) {s = 3;}

                        else if ( (synpred12_InternalVilBuildLanguage()) ) {s = 13;}

                         
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
    static final String DFA14_eotS =
        "\33\uffff";
    static final String DFA14_eofS =
        "\33\uffff";
    static final String DFA14_minS =
        "\1\4\4\0\26\uffff";
    static final String DFA14_maxS =
        "\1\107\4\0\26\uffff";
    static final String DFA14_acceptS =
        "\5\uffff\1\1\4\uffff\1\2\20\uffff";
    static final String DFA14_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\26\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\12\1\2\1\12\1\1\1\3\7\uffff\1\12\1\uffff\1\12\5\uffff\1"+
            "\12\1\uffff\1\5\1\uffff\1\12\1\uffff\1\12\2\uffff\1\12\2\uffff"+
            "\1\12\3\uffff\1\4\14\uffff\1\12\2\uffff\4\12\5\uffff\3\12\4"+
            "\5",
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

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "595:2: ( ( (lv_type_1_0= ruleType ) )? ( (lv_modifier_2_0= ruleRuleModifier ) )? ( (lv_name_3_0= ruleIdentifier ) ) otherlv_4= '(' ( (lv_paramList_5_0= ruleParameterList ) )? otherlv_6= ')' otherlv_7= '=' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_1 = input.LA(1);

                         
                        int index14_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_3 = input.LA(1);

                         
                        int index14_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_4 = input.LA(1);

                         
                        int index14_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_InternalVilBuildLanguage()) ) {s = 5;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index14_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\14\uffff";
    static final String DFA21_eofS =
        "\14\uffff";
    static final String DFA21_minS =
        "\1\4\1\uffff\4\5\1\uffff\5\5";
    static final String DFA21_maxS =
        "\1\107\1\uffff\4\100\1\uffff\1\50\4\100";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\4\uffff\1\2\5\uffff";
    static final String DFA21_specialS =
        "\14\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\6\1\3\1\6\1\2\1\4\7\uffff\1\6\1\uffff\1\6\11\uffff\1\6\1"+
            "\uffff\2\6\1\uffff\1\6\2\uffff\1\6\1\1\2\uffff\1\5\14\uffff"+
            "\1\6\2\uffff\4\6\5\uffff\3\6\4\1",
            "",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff"+
            "\1\6\14\uffff\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff"+
            "\1\6\14\uffff\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff"+
            "\1\6\14\uffff\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\6\uffff\1\6\3\uffff"+
            "\1\6\14\uffff\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "",
            "\1\11\1\uffff\1\10\1\12\37\uffff\1\13",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\14\uffff"+
            "\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\14\uffff"+
            "\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\14\uffff"+
            "\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\1\1\uffff\2\1\5\uffff\1\6\1\uffff\1\6\12\uffff\1\6\14\uffff"+
            "\1\1\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7"
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
            return "888:1: ( ( (lv_varDecl_0_0= ruleVariableDeclaration ) ) | ( (lv_exprStmt_1_0= ruleExpressionStatement ) ) )";
        }
    }
    static final String DFA23_eotS =
        "\14\uffff";
    static final String DFA23_eofS =
        "\14\uffff";
    static final String DFA23_minS =
        "\1\4\4\16\1\uffff\1\5\1\uffff\4\16";
    static final String DFA23_maxS =
        "\1\103\4\100\1\uffff\1\50\1\uffff\4\100";
    static final String DFA23_acceptS =
        "\5\uffff\1\2\1\uffff\1\1\4\uffff";
    static final String DFA23_specialS =
        "\14\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\5\1\2\1\5\1\1\1\3\7\uffff\1\5\1\uffff\1\5\11\uffff\1\5\1"+
            "\uffff\1\5\2\uffff\1\5\2\uffff\1\5\3\uffff\1\4\14\uffff\1\5"+
            "\2\uffff\4\5\5\uffff\3\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\6\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "",
            "\1\11\1\uffff\1\10\1\12\37\uffff\1\13",
            "",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5",
            "\1\5\1\uffff\1\5\6\uffff\1\7\3\uffff\1\5\16\uffff\16\5\4\uffff"+
            "\2\5\2\uffff\1\5"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "982:3: ( ( (lv_var_0_0= ruleIdentifier ) ) (otherlv_1= '.' ( (lv_field_2_0= ruleIdentifier ) ) )? otherlv_3= '=' )?";
        }
    }
    static final String DFA26_eotS =
        "\22\uffff";
    static final String DFA26_eofS =
        "\2\uffff\4\1\10\uffff\4\1";
    static final String DFA26_minS =
        "\1\4\1\uffff\4\16\6\uffff\1\5\1\uffff\4\16";
    static final String DFA26_maxS =
        "\1\103\1\uffff\4\100\6\uffff\1\50\1\uffff\4\100";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\4\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\2\4\uffff";
    static final String DFA26_specialS =
        "\22\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\1\3\1\1\1\2\1\4\7\uffff\1\1\13\uffff\1\12\1\uffff\1\10"+
            "\2\uffff\1\11\2\uffff\1\7\3\uffff\1\5\21\uffff\1\6\1\13\5\uffff"+
            "\3\1",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16\1\20\37\uffff\1\21",
            "",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14",
            "\2\1\1\15\3\1\4\uffff\2\1\1\uffff\1\1\13\uffff\1\1\2\uffff"+
            "\16\1\4\uffff\3\1\1\uffff\1\14"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1092:1: ( ( (lv_otherEx_0_0= ruleExpressionOrQualifiedExecution ) ) | ( (lv_unqEx_1_0= ruleUnqualifiedExecution ) ) | ( (lv_superEx_2_0= ruleSuperExecution ) ) | ( (lv_sysEx_3_0= ruleSystemExecution ) ) | ( (lv_map_4_0= ruleMap ) ) | ( (lv_join_5_0= ruleJoin ) ) | ( (lv_instantiate_6_0= ruleInstantiate ) ) | ( (lv_newEx_7_0= ruleConstructorExecution ) ) )";
        }
    }
    static final String DFA35_eotS =
        "\27\uffff";
    static final String DFA35_eofS =
        "\27\uffff";
    static final String DFA35_minS =
        "\1\4\23\uffff\1\0\2\uffff";
    static final String DFA35_maxS =
        "\1\103\23\uffff\1\0\2\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\1\24\uffff\1\2";
    static final String DFA35_specialS =
        "\24\uffff\1\0\2\uffff}>";
    static final String[] DFA35_transitionS = {
            "\5\1\7\uffff\1\1\1\uffff\1\24\11\uffff\1\1\1\uffff\2\1\1\uffff"+
            "\1\1\2\uffff\1\1\3\uffff\1\1\14\uffff\1\1\2\uffff\4\1\5\uffff"+
            "\3\1",
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
            return "1680:1: ( ( (lv_exStmt_0_0= ruleExpressionStatement ) ) | ( (lv_block_1_0= ruleRuleElementBlock ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_20 = input.LA(1);

                         
                        int index35_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_InternalVilBuildLanguage()) ) {s = 1;}

                        else if ( (true) ) {s = 22;}

                         
                        input.seek(index35_20);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\21\uffff";
    static final String DFA68_eofS =
        "\21\uffff";
    static final String DFA68_minS =
        "\1\4\4\5\2\uffff\1\5\1\4\4\5\4\16";
    static final String DFA68_maxS =
        "\1\107\4\100\2\uffff\1\50\1\103\10\100";
    static final String DFA68_acceptS =
        "\5\uffff\1\1\1\2\12\uffff";
    static final String DFA68_specialS =
        "\21\uffff}>";
    static final String[] DFA68_transitionS = {
            "\1\6\1\2\1\6\1\1\1\3\7\uffff\3\6\11\uffff\1\6\1\uffff\1\6\2"+
            "\uffff\1\6\2\uffff\1\6\3\uffff\1\4\14\uffff\1\6\2\uffff\4\6"+
            "\5\uffff\3\6\4\5",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\1\uffff\1\6\14\uffff\1\5\1\uffff\16\6\4\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\1\uffff\1\6\14\uffff\1\5\1\uffff\16\6\4\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\1\uffff\1\6\14\uffff\1\5\1\uffff\16\6\4\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "\1\5\1\uffff\2\5\5\uffff\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff"+
            "\1\10\1\uffff\1\6\14\uffff\1\5\1\uffff\16\6\4\uffff\2\6\1\uffff"+
            "\1\5\1\7",
            "",
            "",
            "\1\12\1\uffff\1\11\1\13\37\uffff\1\14",
            "\1\6\1\16\1\6\1\15\1\17\7\uffff\1\6\1\uffff\1\6\11\uffff\1"+
            "\6\1\uffff\1\6\2\uffff\1\6\2\uffff\1\6\3\uffff\1\20\14\uffff"+
            "\1\6\2\uffff\4\6\5\uffff\3\6",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\1\uffff\1\6\14\uffff"+
            "\1\5\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\1\uffff\1\6\14\uffff"+
            "\1\5\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\1\uffff\1\6\14\uffff"+
            "\1\5\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\5\7\uffff\2\6\7\uffff\1\6\1\uffff\1\6\14\uffff"+
            "\1\5\1\uffff\16\6\4\uffff\2\6\2\uffff\1\7",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\1\uffff\1\6\16\uffff"+
            "\16\6\4\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\1\uffff\1\6\16\uffff"+
            "\16\6\4\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\1\uffff\1\6\16\uffff"+
            "\16\6\4\uffff\2\6\1\uffff\1\5\1\6",
            "\1\5\1\uffff\2\6\5\uffff\1\6\1\uffff\1\10\1\uffff\1\6\16\uffff"+
            "\16\6\4\uffff\2\6\1\uffff\1\5\1\6"
    };

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "4001:1: ( (lv_decl_2_0= ruleDeclarator ) )?";
        }
    }
 

    public static final BitSet FOLLOW_ruleImplementationUnit_in_entryRuleImplementationUnit81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplementationUnit91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleImplementationUnit149 = new BitSet(new long[]{0x000002800000A002L});
    public static final BitSet FOLLOW_ruleRequire_in_ruleImplementationUnit171 = new BitSet(new long[]{0x000000800000A002L});
    public static final BitSet FOLLOW_ruleLanguageUnit_in_ruleImplementationUnit193 = new BitSet(new long[]{0x0000008000008002L});
    public static final BitSet FOLLOW_ruleRequire_in_entryRuleRequire230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequire240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRequire277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequire294 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleRequire320 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleRequire332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLanguageUnit_in_entryRuleLanguageUnit368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLanguageUnit378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_ruleLanguageUnit424 = new BitSet(new long[]{0x0000008000008000L});
    public static final BitSet FOLLOW_15_in_ruleLanguageUnit437 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleLanguageUnit458 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLanguageUnit470 = new BitSet(new long[]{0x00000100000201A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleLanguageUnit491 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLanguageUnit504 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_ruleLanguageUnit525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLanguageUnit538 = new BitSet(new long[]{0x0F200172552D01F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleVersionStmt_in_ruleLanguageUnit559 = new BitSet(new long[]{0x0F200172552D01F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleLoadProperties_in_ruleLanguageUnit581 = new BitSet(new long[]{0x0F200172552D01F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleScriptContents_in_ruleLanguageUnit603 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLanguageUnit615 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleLanguageUnit628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptParentDecl_in_entryRuleScriptParentDecl666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptParentDecl676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleScriptParentDecl713 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleScriptParentDecl734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoadProperties_in_entryRuleLoadProperties770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoadProperties780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleLoadProperties817 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLoadProperties829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLoadProperties846 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLoadProperties863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScriptContents_in_entryRuleScriptContents899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScriptContents909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleScriptContents968 = new BitSet(new long[]{0x0F200172550501F2L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleTypeDef_in_ruleScriptContents995 = new BitSet(new long[]{0x0F200172550501F2L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_ruleScriptContents1022 = new BitSet(new long[]{0x0F200172550501F2L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_entryRuleRuleDeclaration1060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDeclaration1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleRuleDeclaration1129 = new BitSet(new long[]{0x00000100040001A0L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_ruleRuleDeclaration1151 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleRuleDeclaration1173 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRuleDeclaration1185 = new BitSet(new long[]{0x00000100000201A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleRuleDeclaration1206 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleRuleDeclaration1219 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleRuleDeclaration1231 = new BitSet(new long[]{0x0F200172550501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleConditions_in_ruleRuleDeclaration1254 = new BitSet(new long[]{0x0F200172550501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleRuleDeclaration1276 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRuleDeclaration1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleConditions_in_entryRuleRuleConditions1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleConditions1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1395 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleRuleConditions1408 = new BitSet(new long[]{0x0F200112500101F2L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1430 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleRuleConditions1443 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleRuleConditions1464 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_entryRuleRuleElementBlock1504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElementBlock1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRuleElementBlock1563 = new BitSet(new long[]{0x0F200132D00D01F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleElement_in_ruleRuleElementBlock1584 = new BitSet(new long[]{0x0F200132D00D01F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_19_in_ruleRuleElementBlock1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElement_in_entryRuleRuleElement1633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleElement1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleRuleElement1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleRuleElement1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_entryRuleRuleModifier1752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleModifier1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRuleModifier1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement1852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement1910 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_27_in_ruleExpressionStatement1923 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleExpressionStatement1944 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExpressionStatement1958 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement1981 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_ruleExpressionStatement2022 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionStatement2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2074 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_rulePrimaryExpression2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_rulePrimaryExpression2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_rulePrimaryExpression2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_rulePrimaryExpression2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_rulePrimaryExpression2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_rulePrimaryExpression2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_rulePrimaryExpression2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_rulePrimaryExpression2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstantiate_in_entryRuleInstantiate2355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstantiate2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleInstantiate2402 = new BitSet(new long[]{0x00000100000001B0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleInstantiate2425 = new BitSet(new long[]{0x0000000020010000L});
    public static final BitSet FOLLOW_29_in_ruleInstantiate2438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2455 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstantiate2486 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInstantiate2504 = new BitSet(new long[]{0x0F200112500701F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleInstantiate2525 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleInstantiate2538 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleInstantiate2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMapVariable_in_entryRuleMapVariable2596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMapVariable2606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleMapVariable2652 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleMapVariable2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMap_in_entryRuleMap2710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMap2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleMap2757 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleMap2769 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2790 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_25_in_ruleMap2803 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleMapVariable_in_ruleMap2824 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_23_in_ruleMap2846 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_24_in_ruleMap2875 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMap2912 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMap2924 = new BitSet(new long[]{0x0F200172550501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleMap2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternative_in_entryRuleAlternative2981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternative2991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAlternative3028 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAlternative3040 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlternative3061 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAlternative3073 = new BitSet(new long[]{0x0F200172D50501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_ruleAlternative3094 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleAlternative3115 = new BitSet(new long[]{0x0F200172D50501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_ruleAlternative3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_entryRuleStatementOrBlock3175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatementOrBlock3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleStatementOrBlock3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleElementBlock_in_ruleStatementOrBlock3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoin_in_entryRuleJoin3294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoin3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleJoin3341 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin3353 = new BitSet(new long[]{0x00000108000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin3374 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleJoin3386 = new BitSet(new long[]{0x00000108000001A0L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_ruleJoin3407 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin3419 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleJoin3432 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleJoin3444 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoin3465 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleJoin3477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJoinVariable_in_entryRuleJoinVariable3515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJoinVariable3525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleJoinVariable3568 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleJoinVariable3603 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleJoinVariable3615 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleJoinVariable3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemExecution_in_entryRuleSystemExecution3672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemExecution3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSystemExecution3719 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSystemExecution3740 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSystemExecution3761 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration3798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleVariableDeclaration3851 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVariableDeclaration3886 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleVariableDeclaration3907 = new BitSet(new long[]{0x0000000000804000L});
    public static final BitSet FOLLOW_23_in_ruleVariableDeclaration3920 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableDeclaration3941 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVariableDeclaration3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDef_in_entryRuleTypeDef3991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDef4001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleTypeDef4038 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleTypeDef4059 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeDef4080 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTypeDef4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdvice_in_entryRuleAdvice4128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdvice4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAdvice4175 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleAdvice4187 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAdvice4208 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleAdvice4220 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleAdvice4241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_entryRuleVersionSpec4278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionSpec4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleVersionSpec4325 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVersionSpec4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList4382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4438 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleParameterList4451 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleParameterList4472 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleParameter4566 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleParameter4587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_entryRuleVersionStmt4623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVersionStmt4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleVersionStmt4670 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleVersionStmt4687 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleVersionStmt4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport4740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleImport4787 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleImport4808 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_ruleVersionSpec_in_ruleImport4829 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleImport4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleExpression4934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleExpression4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression4997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpression5053 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_ruleLogicalExpression5074 = new BitSet(new long[]{0x00001C0000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_entryRuleLogicalExpressionPart5111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpressionPart5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_ruleLogicalExpressionPart5167 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalExpressionPart5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOperator_in_entryRuleLogicalOperator5225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOperator5236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLogicalOperator5274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleLogicalOperator5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLogicalOperator5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression5352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression5362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression5408 = new BitSet(new long[]{0x0000E00000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_ruleEqualityExpression5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_entryRuleEqualityExpressionPart5466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpressionPart5476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpressionPart5522 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpressionPart5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_entryRuleEqualityOperator5580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityOperator5591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleEqualityOperator5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleEqualityOperator5648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleEqualityOperator5667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression5707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression5763 = new BitSet(new long[]{0x000F000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_ruleRelationalExpression5784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_entryRuleRelationalExpressionPart5821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpressionPart5831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpressionPart5877 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpressionPart5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_entryRuleRelationalOperator5935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOperator5946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelationalOperator5984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelationalOperator6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelationalOperator6022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalOperator6041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6137 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6158 = new BitSet(new long[]{0x0030000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6251 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleAdditiveOperator6358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleAdditiveOperator6377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression6473 = new BitSet(new long[]{0x00C0000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6587 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpressionPart6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator6645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator6656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleMultiplicativeOperator6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleMultiplicativeOperator6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression6753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression6809 = new BitSet(new long[]{0x0F200112500101F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression6831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator6868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator6879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleUnaryOperator6917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleUnaryOperator6936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleUnaryOperator6955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression6995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression7005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionOrQualifiedExecution_in_entryRuleExpressionOrQualifiedExecution7085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionOrQualifiedExecution7095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleExpressionOrQualifiedExecution7142 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionOrQualifiedExecution7161 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionOrQualifiedExecution7182 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleExpressionOrQualifiedExecution7194 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleExpressionOrQualifiedExecution7217 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedExecution_in_entryRuleUnqualifiedExecution7254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedExecution7264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleUnqualifiedExecution7310 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleUnqualifiedExecution7331 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSuperExecution_in_entryRuleSuperExecution7368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperExecution7378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSuperExecution7415 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSuperExecution7427 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuperExecution7448 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleSuperExecution7469 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleConstructorExecution_in_entryRuleConstructorExecution7506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorExecution7516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleConstructorExecution7553 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleConstructorExecution7574 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstructorExecution7586 = new BitSet(new long[]{0x0F200112500701F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleConstructorExecution7607 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConstructorExecution7620 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_ruleConstructorExecution7641 = new BitSet(new long[]{0x3000000008000002L});
    public static final BitSet FOLLOW_ruleSubCall_in_entryRuleSubCall7678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubCall7688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleSubCall7734 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_60_in_ruleSubCall7763 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSubCall7800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleSubCall7820 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubCall7841 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSubCall7853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarator_in_entryRuleDeclarator7890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarator7900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7946 = new BitSet(new long[]{0x8000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleDeclarator7959 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleDeclaration_in_ruleDeclarator7980 = new BitSet(new long[]{0x8000000000004000L});
    public static final BitSet FOLLOW_63_in_ruleDeclarator7994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclaration_in_entryRuleDeclaration8030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclaration8040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleDeclaration8086 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration8108 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleDeclaration8121 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleDeclaration8142 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall8180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleCall8236 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCall8248 = new BitSet(new long[]{0x0F200112500701F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleDeclarator_in_ruleCall8269 = new BitSet(new long[]{0x0F200112500701F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleArgumentList_in_ruleCall8291 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleCall8304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentList_in_entryRuleArgumentList8340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentList8350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8396 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleArgumentList8409 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleNamedArgument_in_ruleArgumentList8430 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleNamedArgument_in_entryRuleNamedArgument8468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedArgument8478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleNamedArgument8525 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedArgument8537 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedArgument8560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_entryRuleQualifiedPrefix8596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedPrefix8606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8652 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleQualifiedPrefix8671 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedPrefix8705 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleQualifiedName8799 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleQualifiedName8818 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleQualifiedName8852 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant8890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant8900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_ruleConstant8946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConstant8969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant9001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConstant9027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConstant9056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConstant9096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleConstant9143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumValue_in_entryRuleNumValue9184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumValue9194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumValue9235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier9276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier9287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier9327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_ruleIdentifier9353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EXPONENT_in_ruleIdentifier9379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleIdentifier9403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType9443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType9453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedPrefix_in_ruleType9499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleType9524 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleType9584 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleType9644 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleType9704 = new BitSet(new long[]{0x00000100000101A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleType9738 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_ruleType9760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeParameters_in_entryRuleTypeParameters9797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameters9807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeParameters9844 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9865 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_25_in_ruleTypeParameters9878 = new BitSet(new long[]{0x00000100000001A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeParameters9899 = new BitSet(new long[]{0x0000000002020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeParameters9913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_entryRuleContainerInitializer9949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializer9959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleContainerInitializer10008 = new BitSet(new long[]{0x0F200112500D01F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10030 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_25_in_ruleContainerInitializer10043 = new BitSet(new long[]{0x0F200112500501F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_ruleContainerInitializer10064 = new BitSet(new long[]{0x0000000002080000L});
    public static final BitSet FOLLOW_19_in_ruleContainerInitializer10080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializerExpression_in_entryRuleContainerInitializerExpression10116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainerInitializerExpression10126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleContainerInitializerExpression10172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainerInitializer_in_ruleContainerInitializerExpression10199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVersionStmt_in_synpred7_InternalVilBuildLanguage559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_synpred10_InternalVilBuildLanguage968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDeclaration_in_synpred12_InternalVilBuildLanguage1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_synpred16_InternalVilBuildLanguage1129 = new BitSet(new long[]{0x00000100040001A0L});
    public static final BitSet FOLLOW_ruleRuleModifier_in_synpred16_InternalVilBuildLanguage1151 = new BitSet(new long[]{0x00000100000001A0L});
    public static final BitSet FOLLOW_ruleIdentifier_in_synpred16_InternalVilBuildLanguage1173 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_synpred16_InternalVilBuildLanguage1185 = new BitSet(new long[]{0x00000100000201A0L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleParameterList_in_synpred16_InternalVilBuildLanguage1206 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred16_InternalVilBuildLanguage1219 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_synpred16_InternalVilBuildLanguage1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred27_InternalVilBuildLanguage2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred43_InternalVilBuildLanguage3115 = new BitSet(new long[]{0x0F200172D50501F0L,0x00000000000000FEL});
    public static final BitSet FOLLOW_ruleStatementOrBlock_in_synpred43_InternalVilBuildLanguage3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_synpred44_InternalVilBuildLanguage3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpressionPart_in_synpred54_InternalVilBuildLanguage5074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpressionPart_in_synpred57_InternalVilBuildLanguage5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpressionPart_in_synpred60_InternalVilBuildLanguage5784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_synpred64_InternalVilBuildLanguage6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_synpred66_InternalVilBuildLanguage6494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_synpred90_InternalVilBuildLanguage9001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VERSION_in_synpred94_InternalVilBuildLanguage9129 = new BitSet(new long[]{0x0000000000000002L});

}